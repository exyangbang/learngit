package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IndustryAmtLimitVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 代付客户号
     */
    private String industryCode;

    /**
     * 代付客户id
     */
    private Long industryId;

    /**
     * 名称
     */
    private String industryName;

    /**
     * 对公单笔提现/代付限额（单位分）
     */
    private Long publicIndividualAmt;

    /**
     * 对私单笔提现/代付限额（单位分）
     */
    private Long privateIndividualAmt;

    /**
     * 单位结算卡单笔提现/代付限额（单位分）
     */
    private Long unitIndividualAmt;

    /**
     * 客户号单日提现/代付限额（单位分）
     */
    private Long industryDateAmt;

    /**
     * 对私子账户提现/代付单日限额（单位分）
     */
    private Long subaccountsDateAmt;

    /**
     * 备注
     */
    private String remark;

    /**
     * 相同订单最大分账数量
     */
    private String sameOrderMaxSpeAmt;

    /**
     * 相同提现金额最大次数
     */
    private String sameCashMaxAmt;

    /**
     * 一分钟内最大提现交易笔数
     */
    private String minuteMaxCashTranAmt;

    /**
     * 对公子账户提现/代付单日限额（单位分）
     */
    private Long publicSubaccountsDateAmt;

    /**
     * 客户号余额支付单日限额（单位分）
     */
    private Long industryBalanceDateAmt;

    /**
     * 对私子账户余额支付单日限额（单位分）
     */
    private Long privateSubaccountsBalanceDateAmt;

    /**
     * 对公子账户余额支付单日限额（单位分）
     */
    private Long publicSubaccountsBalanceDateAmt;
}