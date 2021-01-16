package com.scenetec.upf.operation.model.domain.industryamtlimit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author scenetec
 * @date 2019/07/29
 */
@ApiModel(description = "客户交易限额记录表")
@Data
public class IndustryAmtLimitApprovalDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    private String userCreate;

    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

    /**
     * 代付客户号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "代付客户号")
    private String industryCode;

    /**
     * 代付客户id）
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "代付客户id）")
    private Long industryId;

    /**
     * 名称
     * mysqlType:  varchar(200)
     */
    @ApiModelProperty(value = "名称")
    private String industryName;

    /**
     * 对公单笔限额（单位分）
     * mysqlType:  bigint(20)
     */
    @ApiModelProperty(value = "对公单笔提现/代付限额（单位分）")
    private Long publicIndividualAmt;

    /**
     * 对私单笔限额（单位分）
     * mysqlType: bigint(20))
     */
    @ApiModelProperty(value = "对私单笔提现/代付限额（单位分）")
    private Long privateIndividualAmt;

    /**
     * 单位结算卡单笔限额（单位分）
     * mysqlType: bigint(20))
     */
    @ApiModelProperty(value = "单位结算卡单笔提现/代付限额（单位分）")
    private Long unitIndividualAmt;

    /**
     * 客户号单日限额（单位分）
     * mysqlType: bigint(20))
     */
    @ApiModelProperty(value = "客户号单日提现/代付限额（单位分）")
    private Long industryDateAmt;

    /**
     * 子账户单日限额（单位分）
     * mysqlType: bigint(20))
     */
    @ApiModelProperty(value = "对私子账户提现/代付单日限额（单位分）")
    private Long subaccountsDateAmt;

    /**
     * 备注
     * mysqlType:  varchar(255)
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     * mysqlType:  varchar(2)
     */
    @ApiModelProperty(value = "状态（0-待审核 1-审核通过 2-审核驳回）")
    private String auditStatus;

    /**
     * 操作类型（0-删除 1-修改 2-添加）
     * mysqlType:  varchar(2)
     */
    @ApiModelProperty(value = "操作类型（0-删除 1-修改 2-添加）")
    private String operationType;

    @ApiModelProperty(value = "相同订单最大分账数量")
    private String sameOrderMaxSpeAmt;

    @ApiModelProperty(value = "相同提现金额最大次数")
    private String sameCashMaxAmt;

    @ApiModelProperty(value = "一分钟内最大提现交易笔数")
    private String minuteMaxCashTranAmt;

    @ApiModelProperty(value = "对公子账户提现/代付单日限额（单位分）")
    private Long publicSubaccountsDateAmt;

    @ApiModelProperty(value = "客户号余额支付单日限额（单位分）")
    private Long industryBalanceDateAmt;

    @ApiModelProperty(value = "对私子账户余额支付单日限额（单位分）")
    private Long privateSubaccountsBalanceDateAmt;

    @ApiModelProperty(value = "对公子账户余额支付单日限额（单位分）")
    private Long publicSubaccountsBalanceDateAmt;
}