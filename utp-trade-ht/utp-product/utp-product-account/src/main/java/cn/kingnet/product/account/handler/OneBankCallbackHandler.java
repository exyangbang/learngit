package cn.kingnet.product.account.handler;

import cn.kingnet.product.api.account.IOneBankCallbackHandler;
import cn.kingnet.utp.service.persistence.api.IAccountOrderLogHandler;
import cn.kingnet.utp.service.persistence.api.IProcessTransHandler;
import cn.kingnet.utp.service.persistence.api.IRedisCacheHandler;
import cn.kingnet.utp.service.persistence.api.ITransCurrentHandler;
import cn.kingnet.utp.service.persistence.entity.AccountOrderLog;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.trade.common.dto.account.AccPaymentCallbackClientReqDTO;
import cn.kingnet.utp.trade.common.dto.account.RefundOrderIdCallbackClientReqDTO;
import cn.kingnet.utp.trade.common.dto.account.TransferCallbackClientReqDTO;
import cn.kingnet.utp.trade.common.dto.account.WithdrawCallbackClientReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferCallbackReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferCallbackRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 华通回调内部调用
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 10:55
 */
@RestController
@RequestMapping("/innerAccount/callback")
@Slf4j
public class OneBankCallbackHandler extends DefaultFeginExceptionHandler implements IOneBankCallbackHandler {

    private final ITransCurrentHandler transCurrentHandler;
    private final IProcessTransHandler processTransHandler;
    private final IAccountOrderLogHandler accountOrderLogHandler;
    private final IRedisCacheHandler redisCacheHandler;

    public OneBankCallbackHandler(ITransCurrentHandler transCurrentHandler, IProcessTransHandler processTransHandler, IRedisCacheHandler redisCacheHandler, IAccountOrderLogHandler accountOrderLogHandler) {
        this.transCurrentHandler = transCurrentHandler;
        this.processTransHandler = processTransHandler;
        this.redisCacheHandler = redisCacheHandler;
        this.accountOrderLogHandler = accountOrderLogHandler;
    }

    @Override
    public OneBankTransferCallbackRespDTO transferCallback(@RequestBody(required = false) OneBankTransferCallbackReqDTO oneBankTransferCallbackReqDTO) {
        String respCode = oneBankTransferCallbackReqDTO.getRespCode();
        String respMsg = oneBankTransferCallbackReqDTO.getRespMsg();
        String payTranStatus = oneBankTransferCallbackReqDTO.getPayTranStatus();
        String channelSettleDate = oneBankTransferCallbackReqDTO.getSettleDate();
        TransStatus transStatus;
        if ("PR00".equals(payTranStatus)) {
            transStatus = TransStatus.PROCESSING;
        } else if ("PR02".equals(payTranStatus)) {
            transStatus = TransStatus.TRADE_FAILURE;
        } else if ("PR03".equals(payTranStatus)) {
            transStatus = TransStatus.TRADE_SUCCESS;
        } else {
            log.info("回调信息 原交易id={}  响应码:{} 响应码描述:{} 支付状态：{}-->处理中暂时不处理，需通过主动查询获取结果 ", oneBankTransferCallbackReqDTO.getOldTransId(),
                    respCode, respMsg, payTranStatus);
            throw new TradeException(HttpRespStatus.BAD_GATEWAY, String.format("原交易id: %s,支付状态:%s,回调响应码 %s[%s]. 处理中暂时不处理",
                    oneBankTransferCallbackReqDTO.getOldTransId(), payTranStatus, respCode, respMsg));
        }
        log.info("回调信息 原交易id={}  响应码:{} 响应码描述:{} 支付状态：{} ", oneBankTransferCallbackReqDTO.getOldTransId(), respCode, respMsg, payTranStatus);
        TransCurrent transCurrent = transCurrentHandler.queryByServerTrandsId(oneBankTransferCallbackReqDTO.getOldTransId());
        if (transCurrent == null) {
            throw new TradeException(HttpRespStatus.NOT_ACCEPTABLE, "渠道回调获取交易记录失败：serverTradeId=".concat(oneBankTransferCallbackReqDTO.getOldTransId()));
        }

        if (!transStatus.name().equals(transCurrent.getTransStatus()) && !(TransStatus.TRADE_SUCCESS.name().equals(transCurrent.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(transCurrent.getTransStatus()))) {
            transCurrent = processTransHandler.onebankCallbackUpdate(transCurrent.getId(), respCode, respMsg, transStatus.name(), channelSettleDate);
        } else {
            log.error("交易表主键ID:{} 服务端流水号:{} >> 当前交易状态:{}，库表交易状态为明确状态[{}]或与回调状态[{}]一致，暂无法进行更新操作(更新状态，冻结金额处理)",
                    transCurrent.getId(), transCurrent.getServerTransId(), transCurrent.getTransStatus(), transCurrent.getTransStatus(), transStatus.name());
        }

        //回调通知下游结果
        if (transCurrent != null) {
            callBack2Client(transCurrent, transStatus, respMsg, channelSettleDate);
        }

        return OneBankTransferCallbackRespDTO.builder().respCode(OneBankRespCode.PCC00000.name()).respMsg("业务处理成功").build();
    }

    @Async
    public void callBack2Client(TransCurrent transCurrent, TransStatus transStatus, String respMsg, String channelSettleDate) {
        Object callBackContent = null;
        if (TradeType.WITHDRAW.getCode().equals(transCurrent.getTradeType())) {
            if (StringUtil.isNotBlank(transCurrent.getTransCallbackUrl()) && InnerCallBackUrl.getInnerCallBackUrl(transCurrent.getTransCallbackUrl()) == null) {
                WithdrawCallbackClientReqDTO withdrawCallbackClientReqDTO = new WithdrawCallbackClientReqDTO();
                withdrawCallbackClientReqDTO.setReqDate(transCurrent.getTransDate());
                withdrawCallbackClientReqDTO.setUserNo(transCurrent.getMerNo());
                withdrawCallbackClientReqDTO.setUserAccount(transCurrent.getPayeeAccount());
                withdrawCallbackClientReqDTO.setOrigClientTradeId(transCurrent.getClientTransId());
                withdrawCallbackClientReqDTO.setOrigServerTradeId(transCurrent.getServerTransId());
                withdrawCallbackClientReqDTO.setTransStatus(transStatus.name());
                withdrawCallbackClientReqDTO.setStatusDesc(respMsg);
                withdrawCallbackClientReqDTO.setReconcileDate(channelSettleDate);
                withdrawCallbackClientReqDTO.setFeeType(transCurrent.getMerSettleType());
                withdrawCallbackClientReqDTO.setFeeModel(transCurrent.getMerChargeMode());
                withdrawCallbackClientReqDTO.setFeeAmount(transCurrent.getMerFee()==null?"0":String.valueOf(transCurrent.getMerFee()));
                callBackContent = withdrawCallbackClientReqDTO;
            }
        } else if (TradeType.TRANSFER.getCode().equals(transCurrent.getTradeType()) || TradeType.SGL_PAYMENT.getCode().equals(transCurrent.getTradeType())) {
            if (StringUtil.isNotBlank(transCurrent.getTransCallbackUrl()) && InnerCallBackUrl.getInnerCallBackUrl(transCurrent.getTransCallbackUrl()) == null) {
                TransferCallbackClientReqDTO transferCallbackClientReqDTO = new TransferCallbackClientReqDTO();
                transferCallbackClientReqDTO.setOrigClientTradeId(transCurrent.getClientTransId());
                transferCallbackClientReqDTO.setOrigServerTradeId(transCurrent.getServerTransId());
                transferCallbackClientReqDTO.setTransStatus(transStatus.name());
                transferCallbackClientReqDTO.setStatusDesc(respMsg);
                transferCallbackClientReqDTO.setReconcileDate(channelSettleDate);
                transferCallbackClientReqDTO.setFeeType(transCurrent.getMerSettleType());
                transferCallbackClientReqDTO.setFeeModel(transCurrent.getMerChargeMode());
                transferCallbackClientReqDTO.setFeeAmount(transCurrent.getMerFee()==null?"0":String.valueOf(transCurrent.getMerFee()));
                callBackContent = transferCallbackClientReqDTO;
            }
        } else if (TradeType.REFUND_ORDERID.getCode().equals(transCurrent.getTradeType())) {
            if (StringUtil.isNotBlank(transCurrent.getTransCallbackUrl()) && InnerCallBackUrl.getInnerCallBackUrl(transCurrent.getTransCallbackUrl()) == null) {
                AccountOrderLog accountOrderLog = accountOrderLogHandler.getAccountOrderLog(transCurrent.getServerTransId());
                RefundOrderIdCallbackClientReqDTO callbackClientReqDTO = new RefundOrderIdCallbackClientReqDTO();
                callbackClientReqDTO.setOrigClientTradeId(transCurrent.getClientTransId());
                callbackClientReqDTO.setOrigServerTradeId(transCurrent.getServerTransId());
                callbackClientReqDTO.setTransStatus(transStatus.name());
                callbackClientReqDTO.setStatusDesc(respMsg);
                callbackClientReqDTO.setReconcileDate(channelSettleDate);
                callbackClientReqDTO.setOrderId(accountOrderLog.getOrderId());
                callbackClientReqDTO.setPayAmt(accountOrderLog.getAmt().toString());
                callbackClientReqDTO.setUserAccount(accountOrderLog.getAccount());
                callbackClientReqDTO.setTransDate(transCurrent.getTransDate());
                callBackContent = callbackClientReqDTO;
            }
        }else if (TradeType.ACC_PAYMENT.getCode().equals(transCurrent.getTradeType())) {
            if (StringUtil.isNotBlank(transCurrent.getTransCallbackUrl()) && InnerCallBackUrl.getInnerCallBackUrl(transCurrent.getTransCallbackUrl()) == null) {
                AccPaymentCallbackClientReqDTO accPaymentCallbackClientReqDTO = new AccPaymentCallbackClientReqDTO();
                accPaymentCallbackClientReqDTO.setReqDate(transCurrent.getTransDate());
                accPaymentCallbackClientReqDTO.setUserAccount(transCurrent.getPayerAccount());
                accPaymentCallbackClientReqDTO.setOrigClientTradeId(transCurrent.getClientTransId());
                accPaymentCallbackClientReqDTO.setOrigServerTradeId(transCurrent.getServerTransId());
                accPaymentCallbackClientReqDTO.setTransStatus(transStatus.name());
                accPaymentCallbackClientReqDTO.setStatusDesc(respMsg);
                accPaymentCallbackClientReqDTO.setReconcileDate(channelSettleDate);
                accPaymentCallbackClientReqDTO.setFeeType(transCurrent.getMerSettleType());
                accPaymentCallbackClientReqDTO.setFeeModel(transCurrent.getMerChargeMode());
                accPaymentCallbackClientReqDTO.setFeeAmount(transCurrent.getMerFee()==null?"0":String.valueOf(transCurrent.getMerFee()));
                callBackContent = accPaymentCallbackClientReqDTO;
            }
        }
        if (callBackContent != null) {
            try {
                redisCacheHandler.saveNoticeCallbackMessage(transCurrent.getTransCallbackUrl(), transCurrent.getIndustryCode(), transCurrent.getServerTransId(), BeanMap.create(callBackContent));
            } catch (Exception e) {
                throw new TradeException(HttpRespStatus.BAD_GATEWAY, String.format("渠道回调触发redis存储回调下游消息异常：%s", e.getMessage(), e));
            }
        }
    }

}
