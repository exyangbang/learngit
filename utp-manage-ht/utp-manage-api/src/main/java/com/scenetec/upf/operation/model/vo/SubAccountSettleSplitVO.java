package com.scenetec.upf.operation.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author scenetec
 */
@ApiModel(description = "子账户分账信息")
@Data
@ToString
public class SubAccountSettleSplitVO {

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "批次号")
    private String batchNo;

    @ApiModelProperty(value = "清算日期")
    private String settleDate;

    @ApiModelProperty(value = "客户号")
    private String industryCode;

    @ApiModelProperty(value = "客户名称")
    private String industryName;

    @ApiModelProperty(value = "客户端流水号")
    private String clientTransId;

    @ApiModelProperty(value = "转出用户账户")
    private String payerSubAccount;

    @ApiModelProperty(value = "转出用户户名")
    private String payerSubAccountName;

    @ApiModelProperty(value = "转入用户账户")
    private String payeeSubAccount;

    @ApiModelProperty(value = "转入用户户名")
    private String payeeSubAccountName;

    @ApiModelProperty(value = "金额")
    private String amount;

    @ApiModelProperty(value = "结算方式")
    private String settleMode;

    @ApiModelProperty(value = "账期")
    private String period;

    @ApiModelProperty(value = "入账状态")
    private String status;

    @ApiModelProperty(value = "交易状态")
    private String transStatus;

    @ApiModelProperty(value = "交易结果描述")
    private String transDesc;

    @ApiModelProperty(value = "备注说明")
    private String remark;

    @ApiModelProperty(value = "关联支付订单流水表中的trans_order_id 多个用逗号隔开")
    private String transOrderIds;
}
