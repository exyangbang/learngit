package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IndustryAmountLimitBO implements Serializable {
    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 日期 注：yyyyMMdd
     */
    private String date;

    /**
     * id主键累计交易金额;若计算当前剩余可以用额度= dailyLimitTotalAmount - accumulateAmount
     */
    private long accumulateAmount;

    /**
     * 每日交易总限额
     */
    private long dailyLimitTotalAmount;

    /**
     * 变动资金，-为减可用额度，+为增可用额度
     */
    private long transAmount;

    /**
     * 对公账户单笔限额
     */
    private long publicLimitEachAmount;
    /**
     * 对私账户单笔限额
     */
    private long privateLimitEachAmount;

    /**
     * 单位结算卡 单笔限额
     */
    private long billingCardLimitEachAmount;

    /**
     * 客户号下默认 对私子账户提现/代付单日限额（单位分）
     */
    private long commPrivateSubAccountDailyLimitTotalAmount;
    /**
     * 客户号下默认 对公子账户提现/代付单日限额（单位分）
     */
    private long commPublicSubAccountDailyLimitTotalAmount;

    /**
     * 相同提现金额最大次数
     */
    private String sameCashMaxAmt;

    /**
     * 一分钟内最大提现交易笔数
     */
    private String minuteMaxCashTranAmt;




    /**
     * 客户号余额支付单日限额（单位分）
     */
    private long industryBalancePayDailyLimitTotalAmount;
    /**
     * 对私子账户余额支付单日限额（单位分）
     */
    private long privateSubAccountBalancePayDailyLimitTotalAmount;
    /**
     * 对公子账户余额支付单日限额（单位分）
     */
    private long publicSubAccountBalancePayDailyLimitTotalAmount;

    /**
     * id主键累计余额支付累计交易成功金额;若计算当前剩余可用余额支付额度= industryBalancePayDailyLimitTotalAmount - industryBalancePayAccumulateAmount
     */
    private long industryBalancePayAccumulateAmount;

}
