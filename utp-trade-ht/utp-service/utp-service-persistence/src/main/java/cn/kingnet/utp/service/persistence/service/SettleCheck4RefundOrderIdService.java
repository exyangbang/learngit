package cn.kingnet.utp.service.persistence.service;


import cn.kingnet.utp.service.persistence.entity.SettleCheckInfo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 订单退款的差错处理
 */
@Service
@Slf4j
public class SettleCheck4RefundOrderIdService extends SettleCheckBaseAbstractService {

    public SettleCheck4RefundOrderIdService(InnerAccountService innerAccountService) {
        super(innerAccountService);
    }

    /**
     * 付款者：解冻转账金额
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Unfreezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId()) &&
                innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.unfreezeBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), settleCheckInfo.getOrderId());
        } else {
            log.warn(" 对账/差错处理 >> 订单退款：交易状态[由处理中转失败] 暂无法资金调账操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在订单退款 资金解冻记录或不存在资金冻结记录.", settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId());
        }
    }

    /**
     * 付款者：转账金额回退=余额增加
     * 收款者：转账金额回退=余额扣减【无法操作】
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Plus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                ) {
            innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), settleCheckInfo.getOrderId());
        } else {
            log.warn(" 对账/差错处理 >> 订单退款：交易状态[由成功转失败] 暂无法资金调账操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在订单退款 资金退款记录或不存在资金出金记录.", settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId());
        }
    }

    /**
     * 付款者：转账金额从冻结金额中扣减
     * 收款者：转账金额入账 【无法操作】
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())
                && innerAccountService.isExistAccountDetail4Freezen(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), settleCheckInfo.getOrderId());
        } else {
            log.warn(" 对账/差错处理 >> 订单退款：交易状态[由处理中转成功] 暂无法资金调账操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在订单退款 资金出金记录或不存在资金冻结记录.", settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId());
        }

    }

    /**
     * 付款者：转账金额从余额扣减
     * 收款者：转账金额入账【无法操作】
     *
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {

        if (!innerAccountService.isExistAccountDetail4Minus(settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId())) {
            innerAccountService.minusAvailBalance(AccountOperSubType.TRANSFER, settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(), settleCheckInfo.getPayeeName(), settleCheckInfo.getOrderId());
        } else {
            log.warn(" 对账/差错处理 >> 订单退款：交易状态[由失败转成功] 暂无法资金调账操作：原因 >> 虚拟账号:{},发生金额:{} 服务端流水号:{} 已存在订单退款 资金出金记录.", settleCheckInfo.getPayerAccount(), settleCheckInfo.getRealAmount(), settleCheckInfo.getServerTransId());
        }
    }

}
