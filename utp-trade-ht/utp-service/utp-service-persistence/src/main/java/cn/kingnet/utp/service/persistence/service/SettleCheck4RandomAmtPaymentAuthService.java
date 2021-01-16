package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.utp.service.persistence.entity.SettleCheckInfo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description : 随机金额打款认证交易的差错处理
 * @Author : linkaigui
 * @Create : 2020/4/13 16:33
 */
@Service
@Slf4j
public class SettleCheck4RandomAmtPaymentAuthService extends SettleCheckBaseAbstractService{

    public SettleCheck4RandomAmtPaymentAuthService(InnerAccountService innerAccountService) {
        super(innerAccountService);
    }

    /**
     * 付款者：解冻随机金额
     * 无手续费
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
        ) {
            innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "随机金额打款余额解冻:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
    }

    /**
     * 付款者：随机金额回退=余额增加
     * 无手续费
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "随机金额打款退款:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
    }

    /**
     * 付款者：随机金额从冻结金额中扣减
     * 无手续费
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
        ) {
            innerAccountService.minusBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "随机金额打款冻结金额扣减:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
    }

    /**
     * 付款者：实时代付金额从余额扣减
     * 无手续费
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {
        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), "随机金额打款余额扣减:".concat(remark), settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), null);
        }
    }
}
