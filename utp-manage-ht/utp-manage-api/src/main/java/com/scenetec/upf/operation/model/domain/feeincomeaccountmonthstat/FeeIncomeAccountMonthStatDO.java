package com.scenetec.upf.operation.model.domain.feeincomeaccountmonthstat;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/08/22
 */
@ApiModel(description = "手续费收益账户月统计表")
@Data
public class FeeIncomeAccountMonthStatDO {

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
     * 统计月份yyyyMM
     * mysqlType: varchar(6)
     */
    @ApiModelProperty(value = "统计月份yyyyMM")
	private String statMonth;
	
    /**
     * 手续费收益账户号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "手续费收益账户号")
	private String account;
	
    /**
     * 手续费收益账户名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "手续费收益账户名称")
	private String name;
	
    /**
     * '归集划款状态 0未划转 1已划转
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "'归集划款状态 0未划转 1已划转")
	private String collectionStatus;
	
    /**
     * 入金金额（单位分）
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "入金金额（单位分）")
	private Long incomeAmount;
	
    /**
     * 出金金额（单位分）
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "出金金额（单位分）")
	private Long outcomeAmount;
	
    /**
     * 备注说明
     * mysqlType: varchar(512)
     */
    @ApiModelProperty(value = "备注说明")
	private String remark;
	
    /**
     * 交易状态
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "交易状态")
	private String transStatus;
	
    /**
     * 交易状态描述
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "交易状态描述")
	private String transDesc;

	@ApiModelProperty(value = "服务端流水号")
	private String serverTransId;

	@ApiModelProperty(value = "归集账户名称")
	private String collName;

	@ApiModelProperty(value = "归集账号")
	private String collAccount;

	@ApiModelProperty(value = "归集金额")
	private Long totalAmount;
	
}