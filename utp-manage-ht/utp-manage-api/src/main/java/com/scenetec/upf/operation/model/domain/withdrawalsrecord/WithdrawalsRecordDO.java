package com.scenetec.upf.operation.model.domain.withdrawalsrecord;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/03/14
 */
@ApiModel(description = "手续费收益提现申请记录表")
@Data
public class WithdrawalsRecordDO {

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
     * 提现客户端流水号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "提现客户端流水号")
	private String clientTransId;

    /**
     * 收款方账号
     * mysqlType: varchar(40)
     */
    @ApiModelProperty(value = "收款方账号")
	private String reciveAccountNo;
	
    /**
     * 资金账户户名
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "资金账户户名")
	private String reciveAccountName;
	
    /**
     * 收款方名称
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "收款方名称")
	private String account;
	
    /**
     * 提现金额（单位分）
     * mysqlType:  bigint(20)
     */
    @ApiModelProperty(value = "提现金额（单位分）")
	private Long amount;
	
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

    @ApiModelProperty(value = "提现请求日期yyyyMMdd")
    private String reqDate;
    @ApiModelProperty(value = "提现请求时间HHmmss")
    private String reqTime;
    @ApiModelProperty(value = "收款方开户行号")
    private String reciveOpBankCode;
    @ApiModelProperty(value = "收款方开户行名称")
    private String reciveOpBankName;
    @ApiModelProperty(value = "收款方清算行号")
    private String reciveClBankCode;
    /**
     * 归集账户客户号
     * mysqlType: varchar(40)
     */
    @ApiModelProperty(value = "归集账户客户号")
    private String industryCode;

    /**
     * 归集账户客户名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "归集账户名称")
    private String industryName;
    /**
     * 资金账号
     * mysqlType: varchar(40)
     */
    @ApiModelProperty(value = "资金账号")
    private String fundAccountNo;

    /**
     * 资金账户户名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "资金账户户名")
    private String fundAccountName;

//    @ApiModelProperty(value = "归集账户代付客户号")
//    private String industryCode;


    @ApiModelProperty(value = "交易状态")
    private String transStatus;

    @ApiModelProperty(value = "服务端流水号")
    private String serverTransId;

    @ApiModelProperty(value = "交易状态描述")
    private String transDesc;
}