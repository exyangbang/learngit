package cn.kingnet.utp.product.common.service;

import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.AuthConfigInfo;
import cn.kingnet.utp.trade.common.model.ResponseModel;
import cn.kingnet.utp.trade.common.security.AuthInfo;
import cn.kingnet.utp.trade.common.security.Authorization;
import cn.kingnet.utp.trade.common.security.AuthorizationUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;


/**
 * @Description : 交易服务抽象类
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 14:53
 */
public abstract class AbstractTradeService<REQ extends BaseRequestDTO, RESP extends BaseResponseDTO> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final IAuthConfigInfoService authConfigInfoService;

    protected final UtpConfigProperties utpConfigProperties;

    protected TradeService tradeService;

    protected static ThreadLocal<Authorization> authorizationThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<String> remoteIpThreadLocal = new ThreadLocal<>();

    @PostConstruct
    public void initService() {
        this.tradeService = this.getClass().getDeclaredAnnotation(TradeService.class);
        Assert.notNull(tradeService, this.getClass().getName().concat("未添加注解@TradeService"));
    }

    public AbstractTradeService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties) {
        super();
        this.authConfigInfoService = authConfigInfoService;
        this.utpConfigProperties = utpConfigProperties;
    }

    public AbstractTradeService setRemoteIp(String remoteIp) {
        remoteIpThreadLocal.set(remoteIp);
        return this;
    }

    /**
     * 服务入口
     *
     * @param authStr    授权字符串
     * @param parameters 请求参数
     * @return 返回响应信息
     */
    public ResponseModel doService(final String authStr, final Map<String, Object> parameters) {
        ResponseModel responseModel = null;
        //服务端平台流水(全局唯一数据)
        String serverTransId = this.generateServerTransId();
        String remoteIp = remoteIpThreadLocal.get();
        long startTime = System.currentTimeMillis();
        String reqJSONString = JSON.toJSONString(parameters);
        LambdaLogger.info(logger, "流水号:{} >> 开始 {}-{} [{}] 产品交易服务 请求源IP: {}", serverTransId, tradeService.productCode(), tradeService.tradeType().getCode(), tradeService.tradeType().getDesc(), remoteIp);
        LambdaLogger.debug(logger, "流水号:{} >> 客户端请求报文头：->{}", serverTransId, authStr);
        LambdaLogger.info(logger, "流水号:{} >> 客户端请求报文头前200字符：->{}", serverTransId, StringUtil.truncate(authStr, 200));
        LambdaLogger.info(logger, "流水号:{} >> 客户端请求报文体：->{}", serverTransId, reqJSONString);

        //1.构造整个服务上下文参数
        REQ requestDTO = JSON.parseObject(reqJSONString, (Class<REQ>) tradeService.reqClass());
        TradeContext<REQ, RESP> tradeContext = this.buildTradeContext(serverTransId, requestDTO, tradeService);
        tradeContext.setRemoteIp(remoteIp);
        try {
            //2.解析Authoriztion授权信息
            this.parseAuthoriztion(authStr, tradeContext);
            //3.获取证书配置信息
            if (!"0".equals(utpConfigProperties.getHtSignFlag())) {
                AuthConfigInfo authConfigInfo = this.gainAuthConfigInfo(tradeContext);
                LambdaLogger.debug(logger, "流水号:{} >> 证书配置信息：->{}", serverTransId, JSON.toJSONString(authConfigInfo));
                tradeContext.setAuthConfigInfo(authConfigInfo);
                //3.验签客户端上送信息
                this.verifyAuthorization(tradeContext, parameters);
            }
            //3.1 库表验证请求参数及
            try {
                this.verifyReqParam(tradeContext);
                LambdaLogger.debug(logger, "{} >> 开始库表验证请求参数 验证通过!", serverTransId);
            } catch (Exception e) {
                if (tradeService.createTransFlow()) {
                    try {
                        this.insertTransParamFail(tradeContext, e);
                    } catch (Exception ex) {
                        LambdaLogger.error(logger, "{} >> 保存交易流水参数校验失败记录this.insertTransParamFail异常：{}", serverTransId, e.getMessage(), e);
                    }
                }
                throw e;
            }
            //4.初始化流水
            if (tradeService.createTransFlow()) {
                LambdaLogger.debug(logger, "{} >> 开始初始化流水this.initTransFlow", serverTransId);
                this.initTransFlow(tradeContext);
            }
            try {
                //5.请求渠道交易
                LambdaLogger.debug(logger, "{} >> 开始请求渠道交易this.reqChannel", serverTransId);
                ChannelResponseDTO channelResponseDTO = this.reqChannel(tradeContext);
                LambdaLogger.debug(logger, "流水号:{} << 渠道返回信息channelResponseDTO：<<=={}", serverTransId, JSON.toJSONString(channelResponseDTO));
                tradeContext.setChannelResponseDTO(channelResponseDTO);
                //6.组装响应信息
                RESP respClientDTO = this.buildRespClientDTO(tradeContext, null);
                //7.响应DTO特殊处理
                afterBuildRespHandle(respClientDTO, tradeContext, null);
                tradeContext.setResponseDTO(respClientDTO);
            } catch (Exception e) {
                //6.组装响应信息
                RESP respClientDTO = this.buildRespClientDTO(tradeContext, e);
                //7.响应DTO特殊处理
                afterBuildRespHandle(respClientDTO, tradeContext, e);
                tradeContext.setResponseDTO(respClientDTO);
                logger.error("流水号:{} << 交易异常:{}", serverTransId, e.getMessage(), e);
            } finally {
                //8.更新流水
                if (tradeService.createTransFlow()) {
                    LambdaLogger.debug(logger, "{} >> 开始更新流水this.updateTransFlow", serverTransId);
                    this.updateTransFlow(tradeContext);
                }
            }
            //9.重签返回给客户端
            responseModel = this.buildToClientResponseModel(tradeContext, true);
        } catch (Exception e) {
            //6.组装响应信息
            RESP respClientDTO = this.buildRespClientDTO(tradeContext, e);
            //7.响应DTO特殊处理
            afterBuildRespHandle(respClientDTO, tradeContext, e);
            tradeContext.setResponseDTO(respClientDTO);
            //9.重签返回给客户端
            responseModel = this.buildToClientResponseModel(tradeContext, true);
            LambdaLogger.error(logger, "流水号:{} << 交易异常:{}", serverTransId, e.getMessage(), e);
        } finally {
            cleanThreadLocal();
            LambdaLogger.info(logger, "流水号:{} << 响应客户端报文：<<== {}", serverTransId, JSON.toJSONString(responseModel != null ? responseModel.getResponseBody() : null));
            LambdaLogger.info(logger, "流水号:{} << 结束 耗时:{}ms {}-{} [{}] 产品交易服务", serverTransId, System.currentTimeMillis() - startTime, tradeService.productCode(), tradeService.tradeType().getCode(), tradeService.tradeType().getDesc());
        }

        return responseModel;
    }

    /**
     * 子类实现
     */
    @Async
    public void insertTransParamFail(TradeContext<REQ, RESP> tradeContext, Exception e) {

    }

    private void cleanThreadLocal() {
        try {
            authorizationThreadLocal.remove();
            remoteIpThreadLocal.remove();
        } catch (Exception e) {
        }
    }

    /**
     * 获取服务端流水号
     *
     * @return
     */
    protected String generateServerTransId() {
        return IdGenerate.getIdStr();
    }

    /**
     * 验证请求参数
     *
     * @param tradeContext 交易上下文
     */
    protected void verifyReqParam(TradeContext<REQ, RESP> tradeContext) {
        REQ reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.notNull(reqDTO, "请求参数有误");
        ValidateUtils.abcValid(reqDTO.getClientTradeId(), true, "客户端流水号");
        ValidateUtils.maxLength(reqDTO.getClientTradeId(), 32, true, "客户端流水号");
    }

    /**
     * 构造交易服务上下文
     *
     * @param serverTransId 服务端流水ID
     * @param requestDTO    请求的DTO
     * @return 交易上下文
     */
    public TradeContext<REQ, RESP> buildTradeContext(String serverTransId, REQ requestDTO, TradeService tradeService) {
        TradeContext<REQ, RESP> tradeContext = new TradeContext(serverTransId, requestDTO.getClientTradeId(), DateUtil.getCurrentDate(), DateUtil.getCurrentTime(), requestDTO);
        tradeContext.setTradeService(tradeService);
        return tradeContext;
    }

    /**
     * 解析授权信息
     *
     * @param authStr      报文头部请求信息
     * @param tradeContext 交易上下文
     * @return 交易上下文
     */
    public TradeContext<REQ, RESP> parseAuthoriztion(String authStr, TradeContext<REQ, RESP> tradeContext) {
        try {
            //2.获取请求头验权信息 headers里Authorization字段UTP01:authNo:sign的base64编码:timestamp
            AuthInfo authInfo = AuthorizationUtil.getAuthInfo(authStr);
            tradeContext.setAuthInfo(authInfo);
            tradeContext.setIndustryCode(authInfo.getAuthNo());
        } catch (TradeException e) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, String.format("请求头参数错误:%s", e.getMessage()));
        }
        return tradeContext;
    }

    /**
     * 组装响应客户端报文信息
     *
     * @param tradeContext 交易上下文
     * @param e            异常
     * @return 响应报文信息
     */
    public RESP buildRespClientDTO(TradeContext<REQ, RESP> tradeContext, Throwable e) {

        Optional<ChannelResponseDTO> channelResponseDTOOptional = Optional.ofNullable(tradeContext.getChannelResponseDTO());
        String spRespStr = channelResponseDTOOptional
                .map(reqChannel -> Optional.ofNullable(reqChannel.getSpRespMsg())
                        .map(sp -> JSON.toJSONString(sp))
                        .orElse("{}"))
                .orElse("{}");

        RESP clientResp = JSON.parseObject(spRespStr, (Class<RESP>) tradeContext.getTradeService().respClass());
        //通用响应对象状态、消息、异常消息赋值
        channelResponseDTOOptional.ifPresent(cResDTO -> {
            clientResp.setStatus(cResDTO.getStatus());
            clientResp.setException(cResDTO.getException());
            clientResp.setMessage(cResDTO.getMessage());
        });

        clientResp.setClientTradeId(tradeContext.getClientTradeId());
        clientResp.setServerTradeId(tradeContext.getServerTransId());

        //若异常则优先覆盖
        if (e != null) {
            if (e instanceof TradeException) {
                TradeException te = (TradeException) e;
                clientResp.setStatus(String.valueOf(te.getStatus()));
                clientResp.setMessage(te.getMessage());
                clientResp.setException(te.getException());
            } else {
                clientResp.setStatus(String.valueOf(HttpRespStatus.SERVER_ERROR.value()));
                clientResp.setMessage(HttpRespStatus.SERVER_ERROR.getReasonPhrase());
                clientResp.setException(e.getMessage());
            }
        }
        if (StringUtil.isNotBlank(clientResp.getException())) {
            clientResp.setException(StringUtil.truncate(clientResp.getException(), 150));
        }

        if (StringUtil.isNotBlank(clientResp.getMessage())) {
            clientResp.setMessage(StringUtil.truncate(clientResp.getMessage(), 150));
        }
        if (StringUtil.isBlank(clientResp.getMessage())) {
            if (StringUtil.isBlank(clientResp.getException())) {
                HttpRespStatus httpRespStatus = HttpRespStatus.resolve(clientResp.getStatus());
                if (httpRespStatus != null && httpRespStatus.is2xxSuccessful()) {
                    clientResp.setMessage("交易成功");
                }
            } else {
                clientResp.setMessage(clientResp.getException());
            }
        }

        if (StringUtil.isBlank(clientResp.getException())) {
            clientResp.setException(null);
        }
        clientResp.setTimestamp(DateUtil.getCurrentDate(DateUtil.FORMAT_TIMESTAMP));

        if (StringUtil.isBlank(clientResp.getClientTradeId()) && tradeContext.getRequestDTO() != null) {
            clientResp.setClientTradeId(tradeContext.getRequestDTO().getClientTradeId());
        }
        return clientResp;
    }

    /**
     * 响应DTO特殊处理
     *
     * @param respDTO      响应DTO
     * @param tradeContext 交易上下文
     * @param e            异常
     */
    public void afterBuildRespHandle(RESP respDTO, TradeContext<REQ, RESP> tradeContext, Throwable e) {
    }

    /**
     * 验签客户端上送信息
     *
     * @param tradeContext 交易上下文
     */
    public void verifyAuthorization(TradeContext<REQ, RESP> tradeContext, final Map<String, Object> parameters) {
        if (tradeContext.getAuthConfigInfo() == null) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "未授权客户号!");
        }
        Authorization verifyClient2SctrpAuth = this.getAuthorization(tradeContext);
        AuthInfo authInfo = tradeContext.getAuthInfo();
        Map requestMap = parameters;
        if (CollectionUtils.isEmpty(parameters)) {
            requestMap = BeanMap.create(tradeContext.getRequestDTO());
        }
        String sortString = StringUtil.getSortString(requestMap);
        Boolean verifyClient = verifyClient2SctrpAuth.verifyAuthorization(authInfo.getSign(), authInfo.getTimestamp(), sortString);
        if (!verifyClient) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "未授权:验签失败!");
        }
        if (StringUtil.isBlank(tradeContext.getAuthConfigInfo().getDn4CreditCode())) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "未授权:非法请求:代付客户未配置DN[唯一字符]");
        }
        Boolean verifyDN4CreditCode = verifyClient2SctrpAuth.verifyDn(authInfo.getSign(), tradeContext.getAuthConfigInfo().getDn4CreditCode());
        if (!verifyDN4CreditCode) {
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "未授权:非法请求:签名证书DN中不包含有代付客户配置DN[唯一字符]");
        }
    }

    /**
     * 重签组装返回客户端信息
     *
     * @param tradeContext 交易上下文
     * @return 响应信息
     */
    public ResponseModel buildToClientResponseModel(TradeContext<REQ, RESP> tradeContext, Boolean isSign) {
        ResponseModel responseModel = new ResponseModel();
        if (isSign && !"0".equals(utpConfigProperties.getHtSignFlag())) {
            AuthConfigInfo authConfigInfo = tradeContext.getAuthConfigInfo();
            if (authConfigInfo != null) {
                Authorization signSctrp2ClientAuth = this.getAuthorization(tradeContext);
                Map responseMap = BeanMap.create(tradeContext.getResponseDTO());
                String sortString = StringUtil.getSortString(responseMap);
                String signSctrp2Client = signSctrp2ClientAuth.createAuthorization(sortString);
                responseModel.setAuthorization(signSctrp2Client);
            } else {
                LambdaLogger.warn(logger, "流水号：{} >> 代付客户[{}]获取证书配置信息失败.暂无法返回客户端报文进行加签 ", tradeContext.getServerTransId(), tradeContext.getAuthInfo() != null ? tradeContext.getAuthInfo().getAuthNo() : null);
            }
        }
        Object responseBody = this.setResponseClientBody(tradeContext);
        responseModel.setResponseBody(responseBody);
        return responseModel;
    }

    protected Authorization getAuthorization(TradeContext<REQ, RESP> tradeContext) {
        Authorization authorization = authorizationThreadLocal.get();
        if (authorization == null) {
            AuthConfigInfo authConfigInfo = tradeContext.getAuthConfigInfo();
            authorization = Authorization.Builder.buildAuthorization(tradeContext.getAuthInfo().getAuthNo(), authConfigInfo);
            authorizationThreadLocal.set(authorization);
        }
        return Optional.ofNullable(authorization).orElseThrow(() -> new TradeException(HttpRespStatus.UNAUTHORIZED, "未授权:签名配置错误!"));
    }

    /**
     * 设置响应BODY内容
     *
     * @param tradeContext 交易信息
     * @return 响应BODY内容
     */
    public Object setResponseClientBody(TradeContext<REQ, RESP> tradeContext) {
        return tradeContext.getResponseDTO();
    }

    /**
     * 获取证书配置信息
     *
     * @param tradeContext 交易上下文
     * @return 返回证书配置信息
     */
    public AuthConfigInfo gainAuthConfigInfo(TradeContext<REQ, RESP> tradeContext) {
        AuthConfigInfo authConfigInfo = authConfigInfoService.gainAuthConfigInfo(tradeContext);
        if (authConfigInfo == null) {
            throw new RuntimeException(String.format("代付客户[%s]获取证书配置信息失败.authConfigInfo is null ", tradeContext.getAuthInfo().getAuthNo()));
        }
        return authConfigInfo;
    }

    /**
     * 根据响应信息获取交易状态
     *
     * @param tradeContext 交易所有信息
     * @return 交易状态
     */
    public String getTransStatus(TradeContext<REQ, RESP> tradeContext) {
        TransStatus status = TransStatus.PROCESSING;
        RESP sctrpResp = tradeContext.getResponseDTO();
        if (sctrpResp != null) {
            if (StringUtil.isNotBlank(sctrpResp.getStatus())) {
                HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(sctrpResp.getStatus()));
                if (httpRespStatus.is2xxSuccessful()) {
                    status = tradeContext.getTradeService().successTransStatus();
                } else if (httpRespStatus.is4xxClientError()) {
                    status = TransStatus.TRADE_FAILURE;
                } else if (httpRespStatus.is5xxServerError()) {
                    status = TransStatus.TRADE_ERROR;
                }
            } else {
                status = TransStatus.PROCESSING;
            }
        } else {
            status = TransStatus.TRADE_FAILURE;
        }
        return status.toString();
    }

    /**
     * 请求渠道
     *
     * @param tradeContext 交易上下文
     * @return 渠道响应DTO
     */
    public abstract ChannelResponseDTO reqChannel(TradeContext<REQ, RESP> tradeContext);

    /**
     * 初始化流水
     *
     * @param tradeContext 交易上下文
     */
    public abstract void initTransFlow(TradeContext<REQ, RESP> tradeContext);

    /**
     * 更新流水
     *
     * @param tradeContext 交易上下文
     */
    public abstract void updateTransFlow(TradeContext<REQ, RESP> tradeContext);
}
