package com.scenetec.upf.operation.model.domain.settle;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@ApiModel(description = "对账汇总表")
@Data
public class OrgSettleSumInfoDO {

    /**
     * 对账日期
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "对账日期")
	private String reconcileDate;

    /**
     * 机构编号
     * mysqlType: varchar(30)
     */
    @ApiModelProperty(value = "机构编号")
	private String orgCode;

    /**
     * 商户号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "商户号")
	private String merNo;

    /**
     * 交易日期
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易日期")
	private String transDate;

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
     * 总手续费
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "总手续费")
	private Long totalFee;

    @Override
	public String toString() {
		return "SettleSumInfoDO:"
              + ", settleDate = [" + reconcileDate +"]"
              + ", orgCode = [" + orgCode +"]"
              + ", merNo = [" + merNo +"]"
              + ", transDate = [" + transDate +"]"
              + ", productCode = [" + productCode +"]"
              + ", tradeType = [" + tradeType +"]"
              + ", totalCount = [" + totalCount +"]"
              + ", totalAmount = [" + totalAmount +"]"
              + ", totalFee = [" + totalFee +"]"
              ;
	}
	
}