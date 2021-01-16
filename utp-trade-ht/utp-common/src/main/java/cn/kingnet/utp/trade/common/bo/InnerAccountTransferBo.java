package cn.kingnet.utp.trade.common.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author WJH
 * @Date 2019/04/02
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InnerAccountTransferBo {

    /**
     * 付款者账户是否已冻结过
     */
    private boolean freezeFlag;
    /**
     * 代付客户号
     */
    private String industryCode;
    /**
     * 付款者虚拟账号
     */
    private String payerAccount;
    /**
     * 收款者虚拟账号
     */
    private String payeeAccount;
    /**
     * 发生金额
     */
    private Long amount;
    /**
     * 备注说明
     */
    private String remark;
    /**
     * 服务端端流水号
     */
    private String serverTransId;
    /**
     * 外部订单号
     */
    private String outsideOrderId;
    /**
     * 付款者虚拟账号名称
     */
    private String payerAccountName;
    /**
     * 收款者虚拟账号名称
     */
    private String payeeAccountName;

    /**
     * 账期 ：（余额支付|退款时） 账期为0 实时支付 账期为1 则为事后结算
     */
    private Integer period;

    /**
     *  交易流水id
     */
    private long transId;
    /**
     * transId记录是否已移入历史表
     */
    private boolean historyStatus;
    /**
     * 余额支付结算状态：已结算退款逻辑（付款者可用余额增加，收款可用余额退款） 未结算退款逻辑(付款者可用余额增加，收款者冻结余额退款)
     */
    private boolean paymentSettleStatus;

}
