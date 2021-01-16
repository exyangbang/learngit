package com.scenetec.upf.operation.model.vo.applicationformanualentry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/03/15
 */
@ApiModel(description = "手工入账申请记录表")
@Data
public class ApplicationForManualEntryVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


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
	@NotNull(message = "入账虚拟账号id不能为空")
	private String account;
	
    /**
     * 入账户名
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "入账户名")
	@NotNull(message = "入账户名不能为空")
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
	@NotNull(message = "平台专用银行账户交易明细表对应id不能为空")
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

	
}