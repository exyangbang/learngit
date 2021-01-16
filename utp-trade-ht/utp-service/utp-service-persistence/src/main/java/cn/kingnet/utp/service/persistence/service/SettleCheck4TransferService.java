package cn.kingnet.utp.service.persistence.service;


import cn.kingnet.utp.service.persistence.entity.SettleCheckInfo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 转账交易的差错处理
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SettleCheck4TransferService extends SettleCheckBaseAbstractService {

    public SettleCheck4TransferService(InnerAccountService innerAccountService) {
        super(innerAccountService);
    }


    /**
     * 付款者：解冻转账金额
     * 实际手续费付款者：解冻转账手续费
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.unfreezeBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAccount(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            }
        }

    }

    /**
     * 付款者：转账金额回退=余额增加
     * 实际手续费付款者：转账手续费回退=余额增加
     * 收款者：转账金额回退=余额扣减
     * 手续费收益账户：转账手续费回退=余额扣减
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAccount(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayerAccount(), "转账退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayerAccount(), "转账手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "转账手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }
    }

    /**
     * 付款者：转账金额从冻结金额中扣减
     * 实际手续费付款者：转账手续费回退从冻结金额中扣减
     * 收款者：转账金额入账
     * 手续费收益账户：转账手续费入账
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAccount(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.plusBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayerAccount(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayerAccount(), "转账手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "转账手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }


    }

    /**
     * 付款者：转账金额从余额扣减
     * 实际手续费付款者：转账手续费从余额扣减
     * 收款者：转账金额入账
     * 手续费收益账户：转账手续费入账
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusAvailBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAccount(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.plusBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayerAccount(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
        }
        if (!isMerFeeZero(settleCheckInfo)) {
            if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayerAccount(), "转账手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "转账手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "转账手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }

    }


}
