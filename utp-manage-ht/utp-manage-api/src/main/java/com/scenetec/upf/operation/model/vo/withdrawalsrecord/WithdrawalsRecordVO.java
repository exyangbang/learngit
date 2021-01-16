package com.scenetec.upf.operation.model.vo.withdrawalsrecord;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/03/14
 */
@ApiModel(description = "手续费收益提现申请记录表")
@Data
public class WithdrawalsRecordVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     *
     * 虚拟账户
     */
	@NotNull(message = "虚拟账户不能为空")
    @ApiModelProperty(value = "虚拟账户")
	private String account;

	@NotNull(message = "提现金额不能为空")
	@ApiModelProperty(value = "提现金额")
	private Long amount;

	@NotNull(message = "收款账户id不能为空")
	@ApiModelProperty(value = "收款账户id")
	private Long reciveId;

	/**
	 * 状态（0-待审核 1-审核通过 2-审核驳回）
	 * mysqlType:  varchar(2)
	 */
	@ApiModelProperty(value = "状态（0-待审核 1-审核通过 2-审核驳回）")
	private String auditStatus;
}