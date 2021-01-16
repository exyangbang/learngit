package com.scenetec.upf.operation.model.domain.account;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2020/02/12
 */
@ApiModel(description = "子账户入金流水报备")
@Data
public class AccIncomeFlowDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


//    /**
//     * 创建用户
//     * mysqlType: varchar(250)
//     */
//    @ApiModelProperty(value = "创建用户")
//    @JsonIgnore
//	private String userCreate;
//
//    /**
//     * 创建时间
//     * mysqlType: datetime
//     */
//    @ApiModelProperty(value = "创建时间")
//    @JsonIgnore
//	private Date gmtCreate;
//
//    /**
//     * 修改用户
//     * mysqlType: varchar(250)
//     */
//    @ApiModelProperty(value = "修改用户")
//    @JsonIgnore
//	private String userModified;
//
//    /**
//     * 修改时间
//     * mysqlType: datetime
//     */
//    @ApiModelProperty(value = "修改时间")
//    @JsonIgnore
//	private Date gmtModified;

	/**
	 * 入金流水号
	 * mysqlType: varchar(30)
	 */
	@ApiModelProperty(value = "入金流水号")
	private String incomeFlowId;


	/**
	 * 代付客户名称
	 *
	 */
	@ApiModelProperty(value = "代付客户名称")
	private String name;


	/**
	 * 代付客户号
	 *
	 */
	@ApiModelProperty(value = "代付客户号")
	private String industryCode;

	/**
	 * 收款人账号
	 * mysqlType: varchar(1024)
	 */
	@ApiModelProperty(value = "收款人账号")
	private String autoPayeeAcctAo;

	/**
	 * 收款人名称
	 * mysqlType: varchar(1024)
	 */
	@ApiModelProperty(value = "收款人名称")
	private String autoPayeeAcctName;
	/**
	 * 付款人账号
	 * mysqlType: varchar(1024)
	 */
	@ApiModelProperty(value = "付款人账号")
	private String exAcctNo;

	/**
	 * 付款人名称
	 * mysqlType: varchar(1024)
	 */
	@ApiModelProperty(value = "付款人名称")
	private String exAcctName;


	@ApiModelProperty(value = "虚拟账户账号")
	private String accNo;
	/**
	 * 交易金额
	 * mysqlType: varchar(1024)
	 */
	@ApiModelProperty(value = "交易金额")
	private String amt;

	/**
	 * 交易日期
	 * mysqlType: varchar(1024)
	 */
	@ApiModelProperty(value = "交易日期")
	private String tranDate;
	/**
	 * 备注说明
	 * mysqlType: varchar(1024)
	 */
	@ApiModelProperty(value = "备注说明")
	private String remark;



}