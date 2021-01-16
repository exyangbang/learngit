package com.scenetec.upf.operation.model.domain.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author scenetec
 * @date 2018/09/12
 */
@ApiModel(description = "历史交易流水")
@Data
public class TransFlowDO {

    @JsonSerialize(using = ToStringSerializer.class)
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
     * 渠道返回代码
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道返回代码")
    private String channelRespCode;

    /**
     * 渠道返回流水号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道返回流水号")
    private String channelRespId;

    /**
     * 渠道返回信息
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "渠道返回信息")
    private String channelRespMsg;

    /**
     * 渠道返回时间
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道返回时间")
    private String channelRespTime;

    /**
     * 客户请求流水号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "客户请求流水号")
    private String clientTransId;

    /**
     * 客户请求时间(yyyyMMddHHmmss)
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "客户请求时间(yyyyMMddHHmmss)")
    private String clientTransTime;

    /**
     * 货币类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "货币类型")
    private String currency;

    /**
     * 机构编码
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "机构编码")
    private String orgCode;

    /**
     * 备注
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "备注")
    private String description;

    /**
     * 返回错误
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "返回错误")
    private String respException;

    /**
     * 响应信息
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "响应信息")
    private String respMessage;

    /**
     * 服务端批处理号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "服务端批处理号")
    private String serverBatchNo;

    /**
     * 关联流水id
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "关联流水id")
    private String serverLinkId;

    /**
     * 关联流水id
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "关联流水id")
    private String serverTransId;

    /**
     * 对账日期
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "对账日期")
    private String reconcileDate;

    /**
     * 产品编码
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "产品编码")
    private String productCode;

    /**
     * 交易类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "交易类型")
    private String tradeType;

    /**
     * 交易金额(分)
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "交易金额(分)")
    private Long transAmount;

    /**
     * 回调地址
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "回调地址")
    private String transCallbackUrl;

    /**
     * 交易日期(yyyyMMdd)
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "交易日期(yyyyMMdd)")
    private String transDate;

    /**
     * 交易状态
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "交易状态")
    private String transStatus;

    /**
     * 交易时间(HHmmss)
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "交易时间(HHmmss)")
    private String transTime;

    /**
     * 商户编号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "用户号")
    private String merNo;

    /**
     * 商户名称
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "用户名称")
    private String merName;

    /**
     * 响应码
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "响应码")
    private String respCode;

    /**
     * 对账状态
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "对账状态")
    private String reconcileStatus;

    /**
     * 入网分配的用户名
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "入网分配的用户名")
    private String userCode;

    /**
     * 批量交易时：该批次下的明细流水号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "批量交易时：该批次下的明细流水号")
    private String batchSubNo;

    /**
     * 企业入网时分配的企业编码
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "企业入网时分配的企业编码")
    private String accNo;

    @ApiModelProperty(value = "代付客户号")
    private String industryCode;

    @ApiModelProperty(value = "代付客户名称")
    private String industryName;

    @ApiModelProperty(value = "收款人账号")
    private String payeeAcctNo;

    @ApiModelProperty(value = "收款人名称")
    private String payeeName;

    @ApiModelProperty(value = "清算日期")
    private String channelSettleDate;

    @ApiModelProperty(value = "付款虚拟账户")
    private String payerAccount;

    @ApiModelProperty(value = "展示收款帐号")
    private String showPayeeAccountNo;

    @ApiModelProperty(value = "展示收款帐号名称")
    private String showPayeeAccountName;

    @ApiModelProperty(value = "客户手续费")
    private String merFee;

    @ApiModelProperty(value = "渠道手续费")
    private String channelFee;

    @ApiModelProperty(value = "收款虚拟账户")
    private String payeeAccount;

    @ApiModelProperty(value = "请求ip")
    private String remoteIp;
    @ApiModelProperty(value = "余额支付类型")
    private String paymentType;
    @ApiModelProperty(value = "余额支付账期")
    private String paymentPeriod;
    @ApiModelProperty(value = "余额支付结算状态")
    private String paymentSettleStatus;

    @ApiModelProperty(value = "交易平台订单号")
    private String orderId;

    @ApiModelProperty(value = "商品信息")
    private String summaryDescription;

}
