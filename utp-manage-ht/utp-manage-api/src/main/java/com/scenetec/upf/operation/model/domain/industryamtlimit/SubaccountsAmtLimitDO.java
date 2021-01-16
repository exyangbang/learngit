package com.scenetec.upf.operation.model.domain.industryamtlimit;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/07/31
 */
@ApiModel(description = "子账户交易限额审批记录表")
@Data
public class SubaccountsAmtLimitDO {

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
	private Long subaccountsIndividualAmt;
	
    /**
     * 子账户单日限额（单位分）
     * mysqlType: bigint(20))
     */
    @ApiModelProperty(value = "子账户单日限额（单位分）")
	private Long subaccountsDateAmt;
	
    /**
     * 备注
     * mysqlType:  varchar(255)
     */
    @ApiModelProperty(value = "备注")
	private String remark;


	@ApiModelProperty(value = "审批状态")
	private String auditStatus;

	@ApiModelProperty(value = "客户名称")
	private String name;

    @ApiModelProperty(value = "审批列表的id")
    private Long approvalId;
}