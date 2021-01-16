package com.scenetec.upf.operation.model.domain.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description : 历史交易流水
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 15:02
 */
@ApiModel(description = "历史交易流水")
@Data
public class TransHistoryDO implements Serializable {

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
     * 渠道标识
     */
    @ApiModelProperty(value = "渠道标识")
    private String channelKey;

    /**
     * 渠道编号
     */
    @ApiModelProperty(value = "渠道编号")
    private String channelCode;

    /**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName;

    /**
     * 商户编号/个人身份证号
     */
    @ApiModelProperty(value = "商户编号/个人身份证号")
    private String merNo;

    /**
     * 客户请求流水号
     */
    @ApiModelProperty(value = "客户请求流水号")
    private String clientTransId;

    /**
     * 客户请求时间(yyyyMMddHHmmss)
     */
    @ApiModelProperty(value = "客户请求时间")
    private String clientTransTime;

    /**
     * 服务端流水号
     */
    @ApiModelProperty(value = "服务端流水号")
    private String serverTransId;

    /**
     * 产品类型/编码
     */
    @ApiModelProperty(value = "产品类型/编码")
    private String productCode;

    /**
     * 交易类型
     */
    @ApiModelProperty(value = "交易类型")
    private String tradeType;

    /**
     * 机构编码
     */
    @ApiModelProperty(value = "机构编码")
    private String orgCode;

    /**
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;

    /**
     * 服务端批处理号
     */
    @ApiModelProperty(value = "服务端批处理号")
    private String serverBatchNo;

    /**
     * 关联流水id
     */
    @ApiModelProperty(value = "关联流水id")
    private String serverLinkId;

    /**
     * 交易金额(分)
     */
    @ApiModelProperty(value = "交易金额(分)")
    private Long transAmount;

    /**
     * 实际发生金额(分)
     */
    @ApiModelProperty(value = "实际发生金额(分)")
    private Long realAmount;

    /**
     * 交易状态
     */
    @ApiModelProperty(value = "交易状态")
    private String transStatus;

    /**
     * 交易日期(yyyyMMdd)
     */
    @ApiModelProperty(value = "交易日期(yyyyMMdd)")
    private String transDate;

    /**
     * 交易时间(HHmmss)
     */
    @ApiModelProperty(value = "交易时间(HHmmss)")
    private String transTime;

    /**
     * 渠道返回时间
     */
    @ApiModelProperty(value = "渠道返回时间")
    private String channelRespTime;

    /**
     * 渠道返回代码
     */
    @ApiModelProperty(value = "渠道返回代码")
    private String channelRespCode;

    /**
     * 渠道返回流水号。单笔交易渠道交易流水号（暂中信无返回此值）；批量交易渠道交易批次号。
     */
    @ApiModelProperty(value = "渠道返回流水号")
    private String channelRespId;

    /**
     * 渠道返回信息
     */
    @ApiModelProperty(value = "渠道返回信息")
    private String channelRespMsg;

    /**
     * 响应码
     */
    @ApiModelProperty(value = "响应码")
    private String respCode;

    /**
     * 返回错误
     */
    @ApiModelProperty(value = "返回错误")
    private String respException;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息")
    private String respMessage;

    /**
     * 撤销状态0-未撤销 1-已撤销
     */
    @ApiModelProperty(value = "撤销状态")
    private String revokeStatus;

    /**
     * 退货状态0-未退货 1-部分退货 2-已全部退货
     */
    @ApiModelProperty(value = "退货状态")
    private String refundStatus;

    /**
     * 对账状态 0未对账 1已对账
     */
    @ApiModelProperty(value = "对账状态")
    private String reconcileStatus;

    /**
     * 回调地址
     */
    @ApiModelProperty(value = "回调地址")
    private String transCallbackUrl;

    /**
     * 对账时间
     */
    @ApiModelProperty(value = "对账时间")
    private Date reconcileTime;

    /**
     * 对账日
     */
    @ApiModelProperty(value = "对账日")
    private String reconcileDate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String description;

    /**
     * 批量交易时：该批次下的明细流水号
     */
    @ApiModelProperty(value = "批次下的明细流水号")
    private String batchSubNo;

    /**
     * 货币类型
     */
    @ApiModelProperty(value = "货币类型")
    private String currency;

    /**
     * 入网分配的用户名
     */
    @ApiModelProperty(value = "入网分配的用户名")
    private String userCode;

    /**
     * 企业入网时分配的企业账号
     */
    @ApiModelProperty(value = "企业入网时分配的企业账号")
    private String accNo;

    /**
     * 商户手续费
     */
    @ApiModelProperty(value = "商户手续费")
    private Long merFee;

    /**
     * 渠道手续费
     */
    @ApiModelProperty(value = "渠道手续费")
    private Long channelFee;

    /**
     * 对公对私标志
     */
    @ApiModelProperty(value = "对公对私标志")
    private String pcFlag;

    /**
     * 客户类型
     */
    @ApiModelProperty(value = "客户类型")
    private String userType;

    /**
     * 收款人账号
     */
    @ApiModelProperty(value = "收款人账号")
    private String payeeAcctNo;

    /**
     * 收款人名称
     */
    @ApiModelProperty(value = "收款人名称")
    private String payeeName;

    /**
     * 付款人账号
     */
    @ApiModelProperty(value = "付款人账号")
    private String payerAcctNo;

    /**
     * 付款人名称
     */
    @ApiModelProperty(value = "付款人名称")
    private String payerName;

    /**
     * 平台编码/客户号
     */
    @ApiModelProperty(value = "代付客户号")
    private String industryCode;

    /**
     * 清算分账Id
     */
    @ApiModelProperty(value = "清算分账Id")
    private Long splitInfoId;

    /**
     * 商户结算类型(1-实时,2-后结)
     */
    @ApiModelProperty(value = "商户结算类型")
    private String merSettleType;

    /**
     * 商户收费模式(1-内扣,2-外扣)
     */
    @ApiModelProperty(value = "商户收费模式")
    private String merChargeMode;

    /**
     * 渠道结算类型(1-实时,2-后结)
     */
    @ApiModelProperty(value = "渠道结算类型")
    private String channelSettleType;

    /**
     * 渠道收费模式(1-内扣,2-外扣)
     */
    @ApiModelProperty(value = "渠道收费模式")
    private String channelChargeMode;

    /**
     * 渠道清算日期
     */
    @ApiModelProperty(value = "渠道清算日期")
    private String channelSettleDate;

    /**
     * 是否要求渠道对账
     */
    @ApiModelProperty(value = "是否要求渠道对账")
    private String needChannelReconcile;

    @ApiModelProperty(value = "展示收款帐号")
    private String showPayeeAccountNo;

    @ApiModelProperty(value = "展示收款帐号名")
    private String showPayeeAccountName;
}
