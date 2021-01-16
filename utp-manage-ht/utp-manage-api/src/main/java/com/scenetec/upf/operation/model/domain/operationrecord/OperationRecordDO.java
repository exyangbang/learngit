package com.scenetec.upf.operation.model.domain.operationrecord;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/06/03
 */
@ApiModel(description = "审批操作记录")
@Data
public class OperationRecordDO {

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
     * 虚拟账户
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "虚拟账户")
	private String account;
	
    /**
     * 账户类型（1-行业 2-商户 3-个人）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "账户类型（1-行业 2-商户 3-个人）")
	private String objType;
	
    /**
     * 证件号
     * mysqlType:  varchar(20)
     */
    @ApiModelProperty(value = "证件号")
	private String busLicCode;
	
    /**
     * 账户名称
     * mysqlType:  varchar(200)
     */
    @ApiModelProperty(value = "账户名称")
	private String objName;
	
    /**
     * 代付客户号
     * mysqlType:  varchar(20)
     */
    @ApiModelProperty(value = "代付客户号")
	private String code;
	
    /**
     * 代付客名称
     * mysqlType:  varchar(200)
     */
    @ApiModelProperty(value = "代付客名称")
	private String indName;
	
    /**
     * 资金账号
     * mysqlType:  varchar(32)
     */
    @ApiModelProperty(value = "资金账号")
	private String bankAccountNo;
	
    /**
     * 资金账号名称
     * mysqlType:  varchar(200)
     */
    @ApiModelProperty(value = "资金账号名称")
	private String bankAccountName;
	
    /**
     * 审核备注
     * mysqlType:  varchar(500)
     */
    @ApiModelProperty(value = "审核备注")
	private String remarks;
	
    /**
     * 状态（0-冻结 1-正常）
     * mysqlType:  varchar(10)
     */
    @ApiModelProperty(value = "状态（0-冻结 1-正常）")
	private String status;
	
    /**
     * 状态（0-审批驳回 1-审批通过 2-冻结审核 3-解冻待审核）
     * mysqlType:  varchar(32)
     */
    @ApiModelProperty(value = "状态（0-审批驳回 1-审批通过 2-冻结审核 3-解冻待审核）")
	private String operationType;

	@ApiModelProperty(value = "创建日期")
	private String sndDate;

    @ApiModelProperty(value = "申请备注信息")
    private String applyRemark;

    private String idValidity;
}