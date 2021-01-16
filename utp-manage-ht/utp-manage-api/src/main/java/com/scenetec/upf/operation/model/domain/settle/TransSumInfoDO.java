package com.scenetec.upf.operation.model.domain.settle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@ApiModel(description = "对账汇总表")
@Data
public class TransSumInfoDO {

    /**
     * 客户号
     * mysqlType: varchar(30)
     */
    @ApiModelProperty(value = "客户号")
	private String industryCode;

    /**
     * 客户名称
     * mysqlType: varchar(30)
     */
    @ApiModelProperty(value = "客户名称")
    private String industryName;

    /**
     * 渠道编号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道编号")
	private String channelCode;

    /**
     * 渠道名称
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName;

    /**
     * 产品编码/类型
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "产品编码/类型")
	private String productCode;

    /**
     * 交易总笔数
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "交易总笔数")
	private Long totalCount;

    /**
     * 交易总金额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "交易总金额")
	private Long totalAmount;

    /**
     * 渠道总手续费
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "渠道总手续费")
	private Long totalChannelFee;

    /**
     * 客户交易总手续费
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "客户交易总手续费")
    private Long totalIndustryFee;

	
}