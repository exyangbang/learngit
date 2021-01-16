package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.utp.service.persistence.entity.SettleCheckInfo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description : 子账户单笔付款交易的差错处理
 * @Author : linkaigui
 * @Create : 2020/5/26 10:46
 */
@Service
@Slf4j
public class SettleCheck4AccPaymentService extends SettleCheckBaseAbstractService{

    public SettleCheck4AccPaymentService(InnerAccountService innerAccountService) {
        super(innerAccountService);
    }

    @Override
    protected void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            }
        }
    }

    @Override
    protected void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        &&innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "子账户单笔付款手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayeeAcctNo(), "子账户单笔付款手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
                }
            }
        }
    }

    @Override
    protected void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                ) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "子账户单笔付款手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayeeAcctNo(), "子账户单笔付款手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
                }
            }
        }
    }

    @Override
    protected void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),settleCheckInfo.getPayeeName(),null);
        }

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())
                        && innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "子账户单笔付款手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(),settleCheckInfo.getMerFee().longValue()==settleCheckInfo.getRealAmount())
                        && innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getPayerAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "子账户单笔付款手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId())) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getPayeeAcctNo(), "子账户单笔付款手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
                }
            }
        }
    }
}
