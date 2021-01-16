package cn.kingnet.product.account.service.inner;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.impl.QueryWithdrawService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ISplitInfoHandler;
import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.InnerQueryWithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryWithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryWithdrawRespDTO;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.model.ResponseModel;
import cn.kingnet.utp.trade.common.security.AuthInfo;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description : 提现结果查询接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 11:31
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.INNER_QUERY_WITHDRAW,
        reqClass = QueryWithdrawReqDTO.class,
        respClass = QueryWithdrawRespDTO.class
)
@Service
public class InnerQueryWithdrawService extends QueryWithdrawService {

    @Resource
    private ISplitInfoHandler iSplitInfoHandler;


    public InnerQueryWithdrawService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler iBasicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, iBasicConfigHandler, productAccountProperties);
    }

    public ResponseModel doService(InnerQueryWithdrawReqDTO reqDTO) {
        ResponseModel responseModel = null;
        try {
            QueryWithdrawReqDTO req = new QueryWithdrawReqDTO();
            BeanUtils.copyProperties(reqDTO, req);
            Map<String, Object> parameters = BeanMap.create(req);

            responseModel = doService(null, parameters);
            if (responseModel != null && responseModel.getResponseBody() != null) {
                QueryWithdrawRespDTO respDTO = (QueryWithdrawRespDTO) responseModel.getResponseBody();
                SplitInfo splitInfo = iSplitInfoHandler.getSplitInfoById(reqDTO.getSplitInfoId());
                if (!(TransStatus.TRADE_SUCCESS.name().equals(splitInfo.getTransStatus()) ||
                        TransStatus.TRADE_FAILURE.name().equals(splitInfo.getTransStatus()))) {
                    // 更新清算分账提现流水相关状态
                    if(StringUtil.isNotEmpty(respDTO.getTransStatus())){
                        iSplitInfoHandler.updateTransStatusAndTimesById(reqDTO.getSplitInfoId(), respDTO.getTransStatus(), respDTO.getStatusDesc(),respDTO.getReconcileDate());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("分账流水号:{} 原提现服务端流水号:{}>> 查询提现结果响应报文：{} ", reqDTO.getSplitInfoId(), reqDTO.getOrigServerTradeId(),
                    responseModel != null ? JSON.toJSONString(responseModel.getResponseBody()) : "", e);
        }
        return responseModel;
    }


    @Override
    public ResponseModel doService(String authStr, Map<String, Object> parameters) {
        ResponseModel responseModel;
        String serverTransId = this.generateServerTransId();
        if (logger.isDebugEnabled()) {
            logger.debug("流水号:{} >> 进入{}-{} 产品交易服务", serverTransId, tradeService.productCode(), tradeService.tradeType());
            logger.debug("流水号:{} >> 商户请求报文头：->{}", serverTransId, authStr);
            logger.debug("流水号:{} >> 商户请求报文：->{}", serverTransId, parameters);
        }
        //1.构造整个服务上下文参数
        QueryWithdrawReqDTO requestDTO = JSON.parseObject(JSON.toJSONString(parameters), QueryWithdrawReqDTO.class);
        TradeContext<QueryWithdrawReqDTO, QueryWithdrawRespDTO> tradeContext = this.buildTradeContext(serverTransId, requestDTO, tradeService);
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
                ChannelResponseDTO channelResponseDTO = this.reqChannel(tradeContext);
                if (logger.isDebugEnabled()) {
                    logger.debug("流水号:{} << 渠道返回信息channelResponseDTO：<<== {}", serverTransId, JSON.toJSONString(channelResponseDTO));
                }
                tradeContext.setChannelResponseDTO(channelResponseDTO);
                //6.组装响应信息
                QueryWithdrawRespDTO respClientDTO = this.buildRespClientDTO(tradeContext, null);
                //7.响应DTO特殊处理
                afterBuildRespHandle(respClientDTO, tradeContext, null);
                tradeContext.setResponseDTO(respClientDTO);
            } catch (Exception e) {
                //6.组装响应信息
                QueryWithdrawRespDTO respClientDTO = this.buildRespClientDTO(tradeContext, e);
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
            QueryWithdrawRespDTO respClientDTO = this.buildRespClientDTO(tradeContext, e);
            //7.响应DTO特殊处理
            afterBuildRespHandle(respClientDTO, tradeContext, e);
            tradeContext.setResponseDTO(respClientDTO);
            //9.重签返回给客户端
            responseModel = this.buildToClientResponseModel(tradeContext, false);
            logger.error("流水号:{} >> 交易异常:{}", serverTransId, e.getMessage(), e);
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

}
