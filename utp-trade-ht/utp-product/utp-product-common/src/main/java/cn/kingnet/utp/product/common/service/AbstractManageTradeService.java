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
import cn.kingnet.utp.trade.common.security.AuthInfo;
import cn.kingnet.utp.trade.common.security.AuthorizationUtil;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Optional;


/**
 * @Description : 交易服务抽象类
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 14:53
 */
@Slf4j
public abstract class AbstractManageTradeService<REQ extends BaseRequestDTO, RESP extends BaseResponseDTO> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final UtpConfigProperties utpConfigProperties;

    protected TradeService tradeService;
    protected ServerIdGenerate serverIdGenerate;

    @PostConstruct
    public void initService() {
        this.tradeService = this.getClass().getDeclaredAnnotation(TradeService.class);
        Assert.notNull(tradeService, this.getClass().getName().concat("未添加注解@TradeService"));
    }

    public AbstractManageTradeService(UtpConfigProperties utpConfigProperties, ServerIdGenerate serverIdGenerate) {
        super();
        this.utpConfigProperties = utpConfigProperties;
        this.serverIdGenerate = serverIdGenerate;
    }

    /**
     * 服务入口
     *
     * @return 返回响应信息
     */
    public RESP doService(final REQ requestDTO) {
        RESP responseDTO;
        //服务端平台流水(全局唯一数据)
        String serverTransId = this.generateServerTransId();
        long startTime = System.currentTimeMillis();
        if (logger.isInfoEnabled()) {
            logger.info("流水号:{} >> 开始 {}-{} [{}] 产品交易服务", serverTransId, tradeService.productCode(), tradeService.tradeType().getCode(), tradeService.tradeType().getDesc());
            logger.info("流水号:{} >> 客户端请求报文体：->{}", serverTransId, JSON.toJSONString(requestDTO));
        }

        //1.构造整个服务上下文参数
        TradeContext<REQ, RESP> tradeContext = this.buildTradeContext(serverTransId, requestDTO, tradeService);
        try {
            //3.验签客户端上送信息
            this.verifyAuthorization(tradeContext);
            //3.1 库表验证请求参数及
            this.verifyReqParam(tradeContext);
            if (logger.isDebugEnabled()) {
                logger.debug("{} >> 开始库表验证请求参数 验证通过!", serverTransId);
            }
            //4.初始化流水
            if (tradeService.createTransFlow()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("{} >> 开始初始化流水this.initTransFlow", serverTransId);
                }
                this.initTransFlow(tradeContext);
            }
            try {
                //5.请求渠道交易
                if (logger.isDebugEnabled()) {
                    logger.debug("{} >> 开始请求渠道交易this.reqChannel", serverTransId);
                }
                ChannelResponseDTO channelResponseDTO = this.reqChannel(tradeContext);
                if (logger.isDebugEnabled()) {
                    logger.debug("流水号:{} << 渠道返回信息channelResponseDTO：<<=={}", serverTransId, JSON.toJSONString(channelResponseDTO));
                }
                tradeContext.setChannelResponseDTO(channelResponseDTO);
                responseDTO = this.buildResponseDTO(tradeContext, null);
            } catch (Exception e) {
                responseDTO = this.buildResponseDTO(tradeContext, e);
                logger.error("流水号:{} << 交易异常:{}", serverTransId, e.getMessage(), e);
            } finally {
                //8.更新流水
                if (tradeService.createTransFlow()) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("{} >> 开始更新流水this.updateTransFlow", serverTransId);
                    }
                    this.updateTransFlow(tradeContext);
                }
            }
        } catch (Exception e) {
            responseDTO = this.buildResponseDTO(tradeContext, e);
            logger.error("流水号:{} << 交易异常:{}", serverTransId, e.getMessage(), e);
        }
        if (logger.isInfoEnabled()) {
            logger.info("流水号:{} << 响应客户端报文：<<== {}", serverTransId, JSON.toJSONString(responseDTO));
            logger.info("流水号:{} << 结束 耗时:{}ms {}-{} [{}] 产品交易服务", serverTransId, System.currentTimeMillis() - startTime, tradeService.productCode(), tradeService.tradeType().getCode(), tradeService.tradeType().getDesc());
        }
        return responseDTO;
    }


    /**
     * 获取服务端流水号
     *
     * @return
     */
    protected String generateServerTransId() {
        return serverIdGenerate.generateServerTransId();
    }

    protected String generateClientTransId() {
        return serverIdGenerate.generateClientTransId();
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
        } catch (TradeException e) {
            logger.error("流水号:{} >> 客户端请求错误 >>{}", tradeContext.getServerTransId(), e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("流水号:{} >> 客户端请求错误 >>{}", tradeContext.getServerTransId(), e.getMessage(), e);
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, e.getMessage());
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
    public RESP buildResponseDTO(TradeContext<REQ, RESP> tradeContext, Throwable e) {

        Optional<ChannelResponseDTO> channelResponseDTOOptional = Optional.ofNullable(tradeContext.getChannelResponseDTO());
        String spRespStr = channelResponseDTOOptional
                .map(reqChannel -> Optional.ofNullable(reqChannel.getSpRespMsg())
                        .map(sp -> JSON.toJSONString(sp))
                        .orElse("{}"))
                .orElse("{}");

        RESP clientResp = JSON.parseObject(spRespStr, (Class<RESP>) tradeContext.getTradeService().respClass());

        channelResponseDTOOptional.ifPresent(cResDTO -> {
            clientResp.setStatus(cResDTO.getStatus());
            clientResp.setException(cResDTO.getException());
            clientResp.setMessage(cResDTO.getMessage());
        });

        clientResp.setClientTradeId(tradeContext.getClientTradeId());
        clientResp.setServerTradeId(tradeContext.getServerTransId());

        if (e != null) {
            if (e instanceof TradeException) {
                TradeException te = (TradeException) e;
                clientResp.setStatus(String.valueOf(te.getStatus()));
                clientResp.setMessage(te.getMessage());
                clientResp.setException(te.getException());
            } else {
                clientResp.setStatus(String.valueOf(HttpRespStatus.SERVER_ERROR.value()));
                clientResp.setMessage(e.getMessage());
                clientResp.setException(e.getClass().getName());
            }
        }
        if (StringUtil.isNotBlank(clientResp.getException()) && clientResp.getException().length() > 100) {
            clientResp.setException(clientResp.getException().substring(0, 100));
        }

        if (StringUtil.isNotBlank(clientResp.getMessage()) && clientResp.getMessage().length() > 100) {
            clientResp.setMessage(clientResp.getMessage().substring(0, 100));
        }
        if (StringUtil.isBlank(clientResp.getMessage())) {
            if (StringUtil.isBlank(clientResp.getException())) {
                HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(clientResp.getStatus()));
                if (httpRespStatus.is2xxSuccessful()) {
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
        tradeContext.setResponseDTO(clientResp);
        return clientResp;
    }


    /**
     * 验签客户端上送信息
     *
     * @param tradeContext 交易上下文
     */
    public void verifyAuthorization(TradeContext<REQ, RESP> tradeContext) {

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
