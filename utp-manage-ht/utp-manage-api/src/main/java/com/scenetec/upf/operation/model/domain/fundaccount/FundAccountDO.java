package com.scenetec.upf.operation.model.domain.fundaccount;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author scenetec
 * @date 2019/02/21
 */
@ApiModel(description = "资金账户表")
@Data
public class FundAccountDO {

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
     * 资金账户编号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "资金账户编号")
	private String accountNum;
	
    /**
     * 清算行行号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "清算行行号")
	private String bankCode;
	
    /**
     * 状态（0-不可用 1-可用）
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "状态（0-不可用 1-可用）")
	private String status;
	
    /**
     * 华通客户账号|内部户账号'
     * mysqlType: varchar(40)
     */
    @ApiModelProperty(value = "华通客户账号|内部户账号'")
	private String bankAccountNo;
	
    /**
     * 华通客户账号名称|内部户名称
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "华通客户账号名称|内部户名称")
	private String bankAccountName;
	
    /**
     * 最新同步时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "最新同步时间")
	private Date synchronizationTime;

	/**
	 * 1:内部户，2:一般户
	 * mysqlType: varchar(2)
	 */
	@ApiModelProperty(value = "1:内部户，2:一般户")
    private String accountType;
	
    /**
     * 当前余额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "当前余额")
	private Long currentBalance;

	@ApiModelProperty(value = "使用类型(0-普通用途 1-归集用途)")
	private String useType;


    @ApiModelProperty(value = "是否与其他系统共享实体账户0=否 1=是")
    private String shareFlag;

    @ApiModelProperty(value = "是否上报反洗钱(AML=Anti-money laundering)0=否;1=是")
    private String reportAmlFlag;
	
}