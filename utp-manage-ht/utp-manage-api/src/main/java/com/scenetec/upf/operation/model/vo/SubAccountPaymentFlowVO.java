package com.scenetec.upf.operation.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel(description = "子账户单笔付款信息")
@Data
@ToString
public class SubAccountPaymentFlowVO {

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "交易时间")
    private String tradeDate;

    @ApiModelProperty(value = "清算日期")
    private String settleDate;

    @ApiModelProperty(value = "客户号")
    private String industryCode;

    @ApiModelProperty(value = "客户名称")
    private String industryName;

    @ApiModelProperty(value = "客户端流水号")
    private String clientTransId;

    @ApiModelProperty(value = "服务端流水号")
    private String serverTransId;

    @ApiModelProperty(value = "付款用户账户")
    private String payerSubAccount;

    @ApiModelProperty(value = "付款用户户名")
    private String payerSubAccountName;

    @ApiModelProperty(value = "收款用户账户")
    private String payeeSubAccount;

    @ApiModelProperty(value = "收款用户户名")
    private String payeeSubAccountName;

    @ApiModelProperty(value = "金额")
    private String amount;

    @ApiModelProperty(value = "交易状态")
    private String transStatus;

    @ApiModelProperty(value = "交易结果描述")
    private String transDesc;

    @ApiModelProperty(value = "备注说明")
    private String remark;

    @ApiModelProperty(value = "关联支付订单流水表中的trans_order_id 多个用逗号隔开")
    private String transOrderIds;
}
