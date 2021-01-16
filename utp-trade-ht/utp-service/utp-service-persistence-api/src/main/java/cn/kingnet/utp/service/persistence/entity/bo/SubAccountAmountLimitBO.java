package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.trade.common.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubAccountAmountLimitBO implements Serializable {
    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 客户号的子账户
     */
    private String subAccount;
    /**
     * 日期 注：yyyyMMdd
     */
    private String date;
    /**
     * 收款方账户类型
     */
    private AccountType accountType;
    /**
     * 客户号公共设值生效
     */
    private boolean industryCommEffect;
    /**
     * 【提现&子账户单笔代付】id主键累计交易金额;若计算当前剩余可以用额度= dailyLimitTotalAmount - accumulateAmount
     */
    private long accumulateAmount ;

    /**
     * 【提现&子账户单笔代付】每日交易总限额【1.平台客户设置(对公|对私子账户单日限额) 2.子账户限额设置】
     */
    private long dailyLimitTotalAmount ;

    /**
     * 变动资金，-为减可用额度，+为增可用额度
     */
    private long transAmount ;

    /**
     * 单笔限额
     */
    private long limitEachAmount ;

    //===========往下=余额支付交易生效==========================================

    /**
     * 【余额支付&余额支付退款】id主键累计余额支付交易金额;若计算当前剩余可以用额度= balancePayDailyLimitTotalAmount - balancePayAccumulateAmount
     */
    private long balancePayAccumulateAmount ;

    /**
     * 【余额支付&余额支付退款】每日交易总限额【1.平台客户设置(子账户余额支付 对公|对私子账户单日限额)】
     */
    private long balancePayDailyLimitTotalAmount ;

}
