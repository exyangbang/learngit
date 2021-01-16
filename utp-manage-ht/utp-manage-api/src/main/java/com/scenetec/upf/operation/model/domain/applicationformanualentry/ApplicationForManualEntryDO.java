package com.scenetec.upf.operation.model.domain.applicationformanualentry;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/03/18
 */
@ApiModel(description = "手工入账申请记录表")
@Data
public class ApplicationForManualEntryDO {

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
     * 客户账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "客户账号")
	private String custAccountNo;
	
    /**
     * 客户名称
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "客户名称")
	private String custAccountName;
	
    /**
     * 交易金额（单位分)
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "交易金额（单位分)")
	private Long txnAmount;
	
    /**
     * 账户余额（单位分）
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "账户余额（单位分）")
	private Long accountBalance;
	
    /**
     * 对方账号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "对方账号")
	private String otherCustAccountNo;
	
    /**
     * 对方客户名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "对方客户名称")
	private String otherCustName;
	
    /**
     * 入账虚拟账号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "入账虚拟账号")
	private String account;
	
    /**
     * 入账户名
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "入账户名")
	private String accountName;
	
    /**
     * 华通系统交易流水号
     * mysqlType: varchar(34)
     */
    @ApiModelProperty(value = "华通系统交易流水号")
	private String sysReferenceNo;
	
    /**
     * 平台专用银行账户交易明细表对应id
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "平台专用银行账户交易明细表对应id")
	private Long transId;
	
    /**
     * 状态（0-不可用 1-可用）
     * mysqlType:  varchar(2)
     */
    @ApiModelProperty(value = "状态（0-不可用 1-可用）")
	private String status;
	
    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     * mysqlType:  varchar(2)
     */
    @ApiModelProperty(value = "状态（0-待审核 1-审核通过 2-审核驳回）")
	private String auditStatus;
    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     * mysqlType:  varchar(2)
     */
    @ApiModelProperty(value = "状态（0-待审核 1-审核通过 2-审核驳回）")
	private String auditStatusPass;


    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
	public String toString() {
		return "ApplicationForManualEntryDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", custAccountNo = [" + custAccountNo +"]"
              + ", custAccountName = [" + custAccountName +"]"
              + ", txnAmount = [" + txnAmount +"]"
              + ", accountBalance = [" + accountBalance +"]"
              + ", otherCustAccountNo = [" + otherCustAccountNo +"]"
              + ", otherCustName = [" + otherCustName +"]"
              + ", account = [" + account +"]"
              + ", accountName = [" + accountName +"]"
              + ", sysReferenceNo = [" + sysReferenceNo +"]"
              + ", transId = [" + transId +"]"
              + ", status = [" + status +"]"
              + ", auditStatus = [" + auditStatus +"]"
              + ", auditStatusPass = [" + auditStatusPass +"]"
              + ", remark = [" + remark +"]"
              ;
	}

}