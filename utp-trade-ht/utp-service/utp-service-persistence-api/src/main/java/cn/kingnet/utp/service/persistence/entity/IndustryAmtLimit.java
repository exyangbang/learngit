package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.IndustryAmtLimitVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_industry_amt_limit")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.IndustryAmtLimitMapper")
public class IndustryAmtLimit extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 代付客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 代付客户id
     */
    @TableField(value = "industry_id")
    private Long industryId;

    /**
     * 名称
     */
    @TableField(value = "industry_name")
    private String industryName;

    /**
     * 对公单笔提现/代付限额（单位分）
     */
    @TableField(value = "public_individual_amt")
    private Long publicIndividualAmt;

    /**
     * 对私单笔提现/代付限额（单位分）
     */
    @TableField(value = "private_individual_amt")
    private Long privateIndividualAmt;

    /**
     * 单位结算卡单笔提现/代付限额（单位分）
     */
    @TableField(value = "unit_individual_amt")
    private Long unitIndividualAmt;

    /**
     * 客户号单日提现/代付限额（单位分）
     */
    @TableField(value = "industry_date_amt")
    private Long industryDateAmt;

    /**
     * 对私子账户提现/代付单日限额（单位分）
     */
    @TableField(value = "subaccounts_date_amt")
    private Long subaccountsDateAmt;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 相同订单最大分账数量
     */
    @TableField(value = "same_order_max_spe_amt")
    private String sameOrderMaxSpeAmt;

    /**
     * 相同提现金额最大次数
     */
    @TableField(value = "same_cash_max_amt")
    private String sameCashMaxAmt;

    /**
     * 一分钟内最大提现交易笔数
     */
    @TableField(value = "minute_max_cash_tran_amt")
    private String minuteMaxCashTranAmt;

    /**
     * 对公子账户提现/代付单日限额（单位分）
     */
    @TableField(value = "public_subaccounts_date_amt")
    private Long publicSubaccountsDateAmt;

    /**
     * 客户号余额支付单日限额（单位分）
     */
    @TableField(value = "industry_balance_date_amt")
    private Long industryBalanceDateAmt;

    /**
     * 对私子账户余额支付单日限额（单位分）
     */
    @TableField(value = "private_subaccounts_balance_date_amt")
    private Long privateSubaccountsBalanceDateAmt;

    /**
     * 对公子账户余额支付单日限额（单位分）
     */
    @TableField(value = "public_subaccounts_balance_date_amt")
    private Long publicSubaccountsBalanceDateAmt;

    public IndustryAmtLimitVo buildVo() {
        return new IndustryAmtLimitVo(id, gmtCreate, gmtModified, userCreate, userModified, industryCode, industryId, industryName, publicIndividualAmt, privateIndividualAmt, unitIndividualAmt, industryDateAmt, subaccountsDateAmt, remark, sameOrderMaxSpeAmt, sameCashMaxAmt, minuteMaxCashTranAmt, publicSubaccountsDateAmt, industryBalanceDateAmt, privateSubaccountsBalanceDateAmt, publicSubaccountsBalanceDateAmt);
    }

    public static IndustryAmtLimit of(IndustryAmtLimitVo vo) {
        return new IndustryAmtLimit(vo.getId(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getIndustryCode(), vo.getIndustryId(), vo.getIndustryName(), vo.getPublicIndividualAmt(), vo.getPrivateIndividualAmt(), vo.getUnitIndividualAmt(), vo.getIndustryDateAmt(), vo.getSubaccountsDateAmt(), vo.getRemark(), vo.getSameOrderMaxSpeAmt(), vo.getSameCashMaxAmt(), vo.getMinuteMaxCashTranAmt(), vo.getPublicSubaccountsDateAmt(), vo.getIndustryBalanceDateAmt(), vo.getPrivateSubaccountsBalanceDateAmt(), vo.getPublicSubaccountsBalanceDateAmt());
    }
}
