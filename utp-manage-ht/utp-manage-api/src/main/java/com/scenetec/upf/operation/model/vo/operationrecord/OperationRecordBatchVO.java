package com.scenetec.upf.operation.model.vo.operationrecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ApiModel(description = "批量审批")
@Data
@ToString
public class OperationRecordBatchVO {

    @ApiModelProperty(value = "审核记录ID")
    private List<Long> ids;

    @ApiModelProperty(value = "状态（2-审批驳回 1-审批通过）")
    private String operationType;

    @ApiModelProperty(value = "审核备注")
    private String remarks;
}
