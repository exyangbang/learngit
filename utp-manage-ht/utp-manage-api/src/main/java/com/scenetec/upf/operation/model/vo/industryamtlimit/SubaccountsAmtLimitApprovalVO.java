package com.scenetec.upf.operation.model.vo.industryamtlimit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/07/29
 */
@ApiModel(description = "子账户交易限额审批记录表")
@Data
public class SubaccountsAmtLimitApprovalVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    @JsonIgnore
	private String userCreate;

    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
	private Date gmtCreate;

    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    @JsonIgnore
	private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
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
     * 归属对象名称
     * mysqlType:  varchar(200)
     */
    @ApiModelProperty(value = "归属对象名称")
	private String subObjName;

    /**
     * 虚拟账户账号
     * mysqlType:  varchar(32)
     */
    @ApiModelProperty(value = "虚拟账户账号")
	private String subAccount;

    /**
     * 子账户单笔限额（单位分）
     * mysqlType: bigint(20))
     */
    @ApiModelProperty(value = "子账户单笔限额（单位分）")
    @DecimalMin("1")
	private Long subaccountsIndividualAmt;

    /**
     * 子账户单日限额（单位分）
     * mysqlType: bigint(20))
     */
    @ApiModelProperty(value = "子账户单日限额（单位分）")
    @DecimalMin("1")
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

    @ApiModelProperty(value = "审批列表的id")
    private Long approvalId;
}