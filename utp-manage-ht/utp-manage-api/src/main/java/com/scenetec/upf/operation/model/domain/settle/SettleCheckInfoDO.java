package com.scenetec.upf.operation.model.domain.settle;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@ApiModel(description = "差错流水")
@Data
public class SettleCheckInfoDO {

    @JsonSerialize(using= ToStringSerializer.class)
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
     * 渠道编号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道编号")
    private String channelCode;

    /**
     * 渠道名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName;


    /**
     * 商户号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "用户号")
	private String merNo;

    /**
     * 产品编码
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "产品编码")
	private String productCode;

    /**
     * 交易类型
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易类型")
	private String tradeType;

    /**
     * 客户端流水号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "客户端流水号")
	private String clientTransId;

    /**
     * 服务端流水号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "服务端流水号")
	private String serverTransId;

    /**
     * 交易金额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "交易金额")
	private Long transAmount;

    /**
     * 交易状态
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "交易状态")
	private String transStatus;

    /**
     * 交易日期也是对账日期
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "交易日期")
    private String transDate;

    /**
     * 客户端交易发起时间
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "客户端交易发起时间")
	private String clientTransTime;

    /**
     * 渠道返回时间
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道返回时间")
	private String channelRespTime;

    /**
     * 渠道返回代码
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "渠道返回代码")
	private String channelRespCode;

    /**
     * 渠道返回信息
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "渠道返回信息")
	private String channelRespMsg;

    /**
     * 差错类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "差错类型")
	private String errorType;

    /**
     * 差错备注
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "差错备注")
	private String errorDesc;

    /**
     * 处理状态
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "处理状态")
	private String status;

    /**
     * 处理说明备注
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "处理说明备注")
	private String remark;

    @ApiModelProperty(value = "代付客户号")
    private String industryCode;

    @ApiModelProperty(value = "代付客户名称")
    private String industryName;

    @ApiModelProperty(value = "收款人账号")
    private String payeeAcctNo;

    @ApiModelProperty(value = "收款人名称")
    private String payeeName;

    @ApiModelProperty(value = "人工处理审核状态（0-待审核 1-审核通过 2-审核驳回)")
    private String auditStatus;
    @ApiModelProperty(value = "付款虚拟账户")
    private String payerAccount;
    @ApiModelProperty(value = "展示收款帐号")
    private String showPayeeAccountNo;
    @ApiModelProperty(value = "展示收款帐号名称")
    private String showPayeeAccountName;

    @ApiModelProperty(value = "清算日期")
    private String channelSettleDate;
    @ApiModelProperty(value = "交易时间时分秒")
    private String transTime;
    @ApiModelProperty(value = "交易时间时分秒")
    private String reconcileTime;
    @ApiModelProperty(value = "id数组")
    private List tempIdList;

    @Override
	public String toString() {
		return "SettleCheckInfoDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", merNo = [" + merNo +"]"
              + ", productCode = [" + productCode +"]"
              + ", tradeType = [" + tradeType +"]"
              + ", clientTransId = [" + clientTransId +"]"
              + ", serverTransId = [" + serverTransId +"]"
              + ", transAmount = [" + transAmount +"]"
              + ", transStatus = [" + transStatus +"]"
              + ", clientTransTime = [" + clientTransTime +"]"
              + ", channelRespTime = [" + channelRespTime +"]"
              + ", channelRespCode = [" + channelRespCode +"]"
              + ", channelRespMsg = [" + channelRespMsg +"]"
              + ", errorType = [" + errorType +"]"
              + ", errorDesc = [" + errorDesc +"]"
              + ", status = [" + status +"]"
              + ", remark = [" + remark +"]"
              + ", auditStatus = [" + auditStatus +"]"
              + ", payerAccount = [" + payerAccount +"]"
              + ", channelSettleDate = [" + channelSettleDate +"]"
              + ", transTime = [" + transTime +"]"
              ;
	}
	
}