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
 * @Description : 退汇流水信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 15:12
 */
@ApiModel(description = "退汇流水信息")
@Data
public class TransReexchangeDO implements Serializable {

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
    private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;
    @ApiModelProperty(value = "修改时间")
    private String  gmtModifiedStr;
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
     * 对账状态 0未对账 1已对账
     */
    @ApiModelProperty(value = "对账状态")
    private String reconcileStatus;

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
     * 代付客户名称
     */
    @ApiModelProperty(value = "代付客户名称")
    private String industryName;

    /**
     * 渠道清算日期
     */
    @ApiModelProperty(value = "渠道清算日期")
    private String channelSettleDate;

    /**
     * 处理状态 0未处理 1已处理
     */
    @ApiModelProperty(value = "处理状态")
    private String solveStatus;
}
