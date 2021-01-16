package cn.kingnet.product.account.service.inner;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.impl.WithdrawService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ISplitInfoHandler;
import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.InnerWithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.WithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.WithdrawRespDTO;
import cn.kingnet.utp.trade.common.enums.InnerCallBackUrl;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.model.ResponseModel;
import cn.kingnet.utp.trade.common.security.AuthInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;


/**
 * 内部提现服务
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.INNER_WITHDRAW,
        reqClass = WithdrawReqDTO.class,
        respClass = WithdrawRespDTO.class,
        createTransFlow = true,
        chargeFlag = true,
        successTransStatus = TransStatus.PROCESSING
)
@Service
public class InnerWithdrawService extends WithdrawService {

    @Resource
    private ISplitInfoHandler iSplitInfoHandler;


    public InnerWithdrawService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler iBasicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, iBasicConfigHandler, productAccountProperties);
    }

    public ResponseModel doService(InnerWithdrawReqDTO reqDTO) {
        reqDTO.setCallbackUrl(InnerCallBackUrl.WITHDRAW_CALLBACK.getUrl());
        Map<String, Object> parameters = BeanMap.create(reqDTO);
        return doService(null, parameters);
    }


    @Override
    public ResponseModel doService(String authStr, Map<String, Object> parameters) {
        ResponseModel responseModel;
        ////服务端平台流水(全局唯一数据)
        String serverTransId = this.generateServerTransId();
        if (logger.isDebugEnabled()) {
            logger.debug("流水号:{} >> 进入{}-{} 产品交易服务", serverTransId, tradeService.productCode(), tradeService.tradeType());
            logger.debug("流水号:{} >> 商户请求报文头：->{}", serverTransId, authStr);
            logger.debug("流水号:{} >> 商户请求报文：->{}", serverTransId, parameters);
        }
        //1.构造整个服务上下文参数
        WithdrawReqDTO requestDTO = JSON.parseObject(JSON.toJSONString(parameters), WithdrawReqDTO.class);
        TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext = this.buildTradeContext(serverTransId, requestDTO, tradeService);
        tradeContext.setAttribute(SPLITINFO_ID_KEY, Long.valueOf((String) parameters.get("splitInfoId")));
        try {
            //mock AuthInfo
            tradeContext.setAuthInfo(buildAuthInfo((String)parameters.get("industryCode")));

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
                ChannelResponseDTO channelResponseDTO = super.reqChannel(tradeContext);
                if (logger.isDebugEnabled()) {
                    logger.debug("流水号:{} << 渠道返回信息channelResponseDTO：<<== {}", serverTransId, JSON.toJSONString(channelResponseDTO));
                }
                tradeContext.setChannelResponseDTO(channelResponseDTO);
                //6.组装响应信息
                WithdrawRespDTO respClientDTO = this.buildRespClientDTO(tradeContext, null);
                //7.响应DTO特殊处理
                afterBuildRespHandle(respClientDTO, tradeContext, null);
                tradeContext.setResponseDTO(respClientDTO);
            } catch (Exception e) {
                //6.组装响应信息
                WithdrawRespDTO respClientDTO = this.buildRespClientDTO(tradeContext, e);
                //7.响应DTO特殊处理
                afterBuildRespHandle(respClientDTO, tradeContext, e);
                tradeContext.setResponseDTO(respClientDTO);
                logger.error("流水号:{} >> 交易异常:{}", serverTransId, e.getMessage(), e);
            } finally {
                //8.更新流水
                if (tradeService.createTransFlow()) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("{} >> 开始更新流水this.updateTransFlow", serverTransId);
                    }
                    this.updateTransFlow(tradeContext);
                }
            }
            //9.重签返回给客户端
            responseModel = this.buildToClientResponseModel(tradeContext, false);
        } catch (Exception e) {
            //6.组装响应信息
            WithdrawRespDTO respClientDTO = this.buildRespClientDTO(tradeContext, e);
            //7.响应DTO特殊处理
            afterBuildRespHandle(respClientDTO, tradeContext, e);
            tradeContext.setResponseDTO(respClientDTO);
            //9.重签返回给客户端
            responseModel = this.buildToClientResponseModel(tradeContext, false);
            logger.error("流水号:{} >> 交易异常:{}", serverTransId, e.getMessage(), e);
            updateSplitInfoExcep(tradeContext);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("流水号:{} >> 平台返回报文：->{}", serverTransId, JSON.toJSONString(responseModel));
            logger.debug("流水号:{} >> 结束{}-{} 产品交易服务", serverTransId, tradeService.productCode(), tradeService.tradeType());
        }
        return responseModel;

    }

    private AuthInfo buildAuthInfo(String industryCode) {
        AuthInfo authInfo = new AuthInfo();
        authInfo.setAuthNo(industryCode);
        return authInfo;
    }


    @Override
    public void initTransFlow(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext) {
        try {
            super.initTransFlow(tradeContext);
        } catch (Exception e) {
            logger.error("splitInfoId={} 流水号:{} >> 初始化清算分账提现异常:{}", tradeContext.getAttribute(SPLITINFO_ID_KEY), tradeContext.getServerTransId(), e.getMessage(), e);
            throw e;
        } finally {
            // 更新清算分账提现流水相关状态
            SplitInfo splitInfo = SplitInfo.builder()
                    .transDate(tradeContext.getTransDate())
                    .clientTransId(tradeContext.getClientTradeId())
                    .serverTransId(tradeContext.getServerTransId())
                    .transStatus(TransStatus.PROCESSING.name())
                    .gmtModified(new Date())
                    .queryTimes(0)
                    .transDesc("处理中")
                    .id(tradeContext.getAttribute(SPLITINFO_ID_KEY))
                    .build();
            try {
                iSplitInfoHandler.updateTransStatusById(splitInfo);
            } catch (Exception e) {
                logger.error("splitInfoId={} 流水号:{} >> 更新清算分账状态[处理中]异常:{}", tradeContext.getAttribute(SPLITINFO_ID_KEY),
                        tradeContext.getServerTransId(), e.getMessage(), e);
            }
        }
    }

    private void updateSplitInfoExcep(TradeContext<WithdrawReqDTO, WithdrawRespDTO> tradeContext) {
        // 更新清算分账提现流水相关状态
        SplitInfo splitInfo = SplitInfo.builder()
                .transDate(tradeContext.getTransDate())
                .clientTransId(tradeContext.getClientTradeId())
                .serverTransId(tradeContext.getServerTransId())
                .transStatus(TransStatus.TRADE_FAILURE.name())
                .gmtModified(new Date())
                .queryTimes(0)
                .transDesc(String.format("交易失败：[%s-%s]", tradeContext.getResponseDTO().getStatus(),
                        tradeContext.getResponseDTO().getMessage()))
                .id(tradeContext.getAttribute(SPLITINFO_ID_KEY))
                .build();
        try {
            iSplitInfoHandler.updateTransStatusById(splitInfo);
        } catch (Exception e) {
            logger.error("splitInfoId={} 流水号:{} >> 更新清算分账状态[交易失败]异常:{}", tradeContext.getAttribute(SPLITINFO_ID_KEY),
                    tradeContext.getServerTransId(), e.getMessage(), e);
        }
    }

}
