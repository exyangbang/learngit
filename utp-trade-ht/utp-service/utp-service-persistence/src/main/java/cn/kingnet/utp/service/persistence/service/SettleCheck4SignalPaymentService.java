package cn.kingnet.utp.service.persistence.service;


import cn.kingnet.utp.service.persistence.entity.SettleCheckInfo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 单笔实时代付的差错处理|订单退款
 */
@Service
@Slf4j
public class SettleCheck4SignalPaymentService extends SettleCheckBaseAbstractService {

    public SettleCheck4SignalPaymentService(InnerAccountService innerAccountService) {
        super(innerAccountService);
    }

    /**
     * 付款者：解冻实时代付金额
     * 实际手续费付款者：解冻实时代付手续费
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                ) {
            innerAccountService.unfreezeBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "实时代付余额解冻:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        ) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            }
        }
    }

    /**
     * 付款者：实时代付金额回退=余额增加
     * 实际手续费付款者：实时代付手续费回退=余额增加
     * 收款者：实时代付金额回退=余额扣减【无法操作】
     * 手续费收益账户：实时代付手续费回退=余额扣减
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "实时代付余额退款:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        ) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        ) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayerAccount(), "实时代付手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "实时代付手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }

    }

    /**
     * 付款者：实时代付金额从冻结金额中扣减
     * 实际手续费付款者：实时代付手续费回退从冻结金额中扣减
     * 收款者：实时代付金额入账 【无法操作】
     * 手续费收益账户：实时代付手续费入账
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                ) {
            innerAccountService.minusBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "实时代付冻结余额扣减:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        ) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayerAccount(), "实时代付手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        ) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "实时代付手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }

    }

    /**
     * 付款者：实时代付金额从余额扣减
     * 实际手续费付款者：实时代付手续费从余额扣减
     * 收款者：实时代付金额入账【无法操作】
     * 手续费收益账户：实时代付手续费入账
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusAvailBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "实时代付余额扣减:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayerAccount(), "实时代付手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "实时代付手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "实时代付手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }

    }

}
