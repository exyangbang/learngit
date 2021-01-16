package com.scenetec.upf.operation.model.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@ApiModel(description = "账户管理")
@Data
public class AccountDetailDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    private String objNo;

    private String objName;

    private String accountType;

    /**
     * 账号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "账号")
	private String account;

    /**
     * 操作类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "操作类型")
	private String operateType;

    /**
     * 归属对象编号
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "金额")
	private Long amount;

    /**
     * 归属对象名称
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "操作前余额")
	private Long beforeBalance;

    /**
     * 账户余额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "操作后余额")
	private Long afterBalance;

    /**
     * 记录时间
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "记录时间")
	private Date recordTime;

    /**
     * 序号
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "序号")
    private Long seqNo;
    /**
     * 对方账号
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "对方账号")
    private String peerAccNo;
    /**
     * 对方名称
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "对方名称")
    private String peerAccName;

    /**
     * 证件号
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "证件号")
    private Long busLicCode;

    /**
     * 子操作类型：1打款 2代付 3转账 4手续费 5退款 6退汇
     * mysqlType: String(20)
     */
    @ApiModelProperty(value = "子操作类型")
    private String operateSubType;
    /**
     * 实名
     * mysqlType: String(20)
     */
    @ApiModelProperty(value = "实名")
    private String realName;
    /**
     * 企业名称
     * mysqlType: String(20)
     */
    @ApiModelProperty(value = "企业名称")
    private String entName;
    /**
     * 用户类型|0-个人 1-商户
     * mysqlType: String(20)
     */
    @ApiModelProperty(value = "用户类型|0-个人 1-商户")
    private String userType;

}