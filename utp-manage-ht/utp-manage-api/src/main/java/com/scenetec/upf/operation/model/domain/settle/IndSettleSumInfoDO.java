package com.scenetec.upf.operation.model.domain.settle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@ApiModel(description = "客户对账汇总表")
@Data
public class IndSettleSumInfoDO {

    /**
     * 对账日期
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "对账日期")
	private String reconcileDate;

    /**
     * 客户端流水号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "客户端流水号")
    private String clientTransId;

    /**
     * 代付客户号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "代付客户号")
    private String industryCode;

    /**
     * 服务端流水号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "服务端流水号")
    private String serverTransId;

    /**
     * 机构编号
     * mysqlType: varchar(30)
     */
    @ApiModelProperty(value = "收款人姓名")
	private String payeeName;

    /**
     * 商户号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "收款人账号")
	private String payeeAcctNo;

    /**
     * 交易日期
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易日期")
	private String transDate;

    /**
     * 交易时间
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易时间")
    private String transTime;

    /**
     * 产品编码/类型
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "产品编码/类型")
	private String productCode;

    /**
     * 交易类型
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易类型")
	private String tradeType;


    /**
     * 交易总金额
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "交易金额")
	private Long transAmount;

    /**
     * 手续费
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "手续费")
	private Long merFee;

    @Override
	public String toString() {
		return "SettleSumInfoDO:"
              + ", settleDate = [" + reconcileDate +"]"
              + ", transDate = [" + transDate +"]"
              + ", productCode = [" + productCode +"]"
              + ", tradeType = [" + tradeType +"]"
              + ", totalAmount = [" + transAmount +"]"
              ;
	}
	
}