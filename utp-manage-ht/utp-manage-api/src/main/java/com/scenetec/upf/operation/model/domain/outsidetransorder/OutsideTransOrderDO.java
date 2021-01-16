package com.scenetec.upf.operation.model.domain.outsidetransorder;

import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/06/04
 */
@ApiModel(description = "")
@Data
public class OutsideTransOrderDO {

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
     * 平台编码
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "平台编码")
	private String industryCode;
	
    /**
     * 批次号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "批次号")
	private String batchId;
	
    /**
     * 请求日期yyyyMMdd
     * mysqlType: bigint(8)
     */
    @ApiModelProperty(value = "请求日期yyyyMMdd")
	private String reqDate;
	
    /**
     * 请求时间HHmmss
     * mysqlType: int(6)
     */
    @ApiModelProperty(value = "请求时间HHmmss")
	private String reqTime;
	
    /**
     * 交易日期yyyyMMdd
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "交易日期yyyyMMdd")
	private String transDate;
	
    /**
     * 交易时间HHmmss
     * mysqlType: varchar(6)
     */
    @ApiModelProperty(value = "交易时间HHmmss")
	private String transTime;
	
    /**
     * 交易支付订单号
     * mysqlType: bigint(64)
     */
    @ApiModelProperty(value = "交易支付订单号")
	private String transOrderId;
	
    /**
     * 交易商户号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "交易商户号")
	private String merNo;
	
    /**
     * 支付方式|0支付宝 1微信 2银联  3无正向支付流水  9其他支付方式
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "支付方式|0支付宝 1微信 2银联  3无正向支付流水  9其他支付方式")
	private String payMode;
	
    /**
     * 交易金额单位分
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易金额单位分")
	private String transAmount;
	
    /**
     * 卖方名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "卖方名称")
	private String sellerName;
	
    /**
     * 买方名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "买方名称")
	private String buyerName;
	
    /**
     * 商品信息(描述)
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "商品信息(描述)")
	private String goodsInfo;
	
    /**
     * 备注信息
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "备注信息")
	private String remark;
	
    /**
     * 上送状态成功：SUCCESS | 失败：FAILURE
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "上送状态成功：SUCCESS | 失败：FAILURE")
	private String uploadStatus;
	
    /**
     * 上送状态描述
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "上送状态描述")
	private String uploadDesc;

    @ApiModelProperty(value = "0未关联分账 1已关联分账")
	private String splitStatus;

    @ApiModelProperty(value = "商户名称")
    private String merName;
    @ApiModelProperty(value = "商户手机号")
    private String merPhone;
    @ApiModelProperty(value = "支付机构编号")
    private String txnChannel;
    @ApiModelProperty(value = "交易渠道支付订单号")
    private String txnChannelTradeNo;
    @ApiModelProperty(value = "优惠金额")
    private String discountAmount;
    @ApiModelProperty(value = "付款方ID")
    private String buyerId;
    @ApiModelProperty(value = "付款方手机号")
    private String buyerPhone;
    @ApiModelProperty(value = "物流信息")
    private String logistics;

	
}