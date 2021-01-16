package cn.kingnet.utp.service.persistence.service;


import cn.kingnet.utp.service.persistence.entity.SettleCheckInfo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 提现交易的差错处理
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SettleCheck4WithdrawService extends SettleCheckBaseAbstractService {

    public SettleCheck4WithdrawService(InnerAccountService innerAccountService) {
        super(innerAccountService);
    }

    @Override
    protected void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            }
        }
    }

    @Override
    protected void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        &&innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "提现手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayeeAcctNo(), "提现手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
                }
            }
        }
    }

    @Override
    protected void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        ) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "提现手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayeeAcctNo(), "提现手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
                }
            }
        }
    }

    @Override
    protected void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "提现手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getPayeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "提现手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayeeAcctNo(), "提现手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
                }
            }
        }
    }


}
