package cn.kingnet.utp.service.persistence.service;


import cn.kingnet.utp.trade.common.enums.ReconciliationErrorType;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class ReconciliationErrorTypeService {

    @Resource
    private SettleCheck4WithdrawService settleCheck4WithdrawService;
    @Resource
    private SettleCheck4TransferService settleCheck4TransferService;
    @Resource
    private SettleCheck4PreCardService settleCheck4PreCardService;
    @Resource
    SettleCheck4SignalPaymentService settleCheck4SignalPaymentService;
    @Resource
    SettleCheck4RefundOrderIdService settleCheck4RefundOrderIdService;
    @Resource
    SettleCheck4RandomAmtPaymentAuthService settleCheck4RandomAmtPaymentAuthService;
    @Resource
    SettleCheck4AccPaymentService settleCheck4AccPaymentService;

    /**
     * 差错处理及处理状态更新
     *
     * @param id                  差错表Id
     * @param errorType           差错类型
     * @param transStatus         交易类型
     * @param transStatus         校正后交易状态
     * @param remark              备注说明
     * @param serverTransId       服务端交易流水号
     * @param needUpdateTransflow 是否更新交易流水表
     * @return
     */
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void adjustAccount4SettleCheck(long id, ReconciliationErrorType errorType,
                                          TradeType tradeType, TransStatus transStatus, String remark, String serverTransId, boolean needUpdateTransflow) {

        if (tradeType == TradeType.WITHDRAW) {
            settleCheck4WithdrawService.adjustAccount4SettleCheck(id, errorType, tradeType, transStatus, remark, serverTransId, needUpdateTransflow);
        } else if (tradeType == TradeType.TRANSFER || tradeType == TradeType.TRANSFER_USER2INDUSTRY || tradeType == TradeType.TRANSFER_USER2USER) {
            settleCheck4TransferService.adjustAccount4SettleCheck(id, errorType, tradeType, transStatus, remark, serverTransId, needUpdateTransflow);
        } else if (tradeType == TradeType.UPLOAD_ACCOUNT_SETTLE) {
            settleCheck4PreCardService.adjustAccount4SettleCheck(id, errorType, tradeType, transStatus, remark, serverTransId, needUpdateTransflow);
        } else if (tradeType == TradeType.SGL_PAYMENT) {
            settleCheck4SignalPaymentService.adjustAccount4SettleCheck(id, errorType, tradeType, transStatus, remark, serverTransId, needUpdateTransflow);
        } else if (tradeType == TradeType.REFUND_ORDERID) {
            settleCheck4RefundOrderIdService.adjustAccount4SettleCheck(id, errorType, tradeType, transStatus, remark, serverTransId, needUpdateTransflow);
        } else if (tradeType == TradeType.RANDOM_AMT_PAYMENT_AUTH) {
            settleCheck4RandomAmtPaymentAuthService.adjustAccount4SettleCheck(id, errorType, tradeType, transStatus, remark, serverTransId, needUpdateTransflow);
        } else if (tradeType == TradeType.ACC_PAYMENT) {
            settleCheck4AccPaymentService.adjustAccount4SettleCheck(id, errorType, tradeType, transStatus, remark, serverTransId, needUpdateTransflow);
        } else {
            LambdaLogger.error(log, "差错记录id{}-服务端流水号：{} >> 交易类型为：{}[{}]，暂未实现差错处理流程", id, serverTransId, tradeType.getCode(), tradeType.getDesc());
        }
    }

}
