package com.scenetec.upf.operation.model.vo.withdrawalsrecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author scenetec
 * @date 2019/03/14
 */
@ApiModel(description = "手续费收益提现申请记录表")
@Data
public class WithdrawalsRecordExVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

	/**
	 * 状态（0-待审核 1-审核通过 2-审核驳回）
	 * mysqlType:  varchar(2)
	 */
	@ApiModelProperty(value = "状态（0-待审核 1-审核通过 2-审核驳回）")
	private String auditStatus;
}