package com.scenetec.upf.operation.model.vo.operationrecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ApiModel(description = "批量申请")
@Data
@ToString
public class OperationRecordBatchApplyVO {

    @ApiModelProperty(value = "状态（2-冻结申请 3-解冻申请）")
    private String operationType;

    @ApiModelProperty(value = "申请备注")
    private String applyRemark;

    @ApiModelProperty(value = "明细")
    private List<OperationRecordVO> operationRecords;
}
