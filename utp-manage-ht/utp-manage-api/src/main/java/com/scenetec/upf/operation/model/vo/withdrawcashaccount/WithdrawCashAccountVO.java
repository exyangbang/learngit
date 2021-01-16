package com.scenetec.upf.operation.model.vo.withdrawcashaccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/03/13
 */
@ApiModel(description = "提现账户表")
@Data
public class WithdrawCashAccountVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
	
    /**
     * 收款方账号
     * mysqlType: varchar(40)
     */
	@NotNull(message = "收款方账号不能为空")
	@Size(min=1,max = 40,message = "收款方账号最大长度不能超过40")
    @ApiModelProperty(value = "收款方账号")
	private String accountNo;
	
    /**
     * 收款方名称
     * mysqlType: varchar(200)
     */
	@NotNull(message = "收款方名称不能为空")
	@Size(min=1,max = 200,message = "收款方名称最大长度不能超过200")
    @ApiModelProperty(value = "收款方名称")
	private String accountName;
	
    /**
     * industry表id
     * mysqlType:  bigint(20)
     */
    @ApiModelProperty(value = "industry表id")
	@NotNull(message = "industryid不能为空")
	private Long industryId;
	
    /**
     * 清算行号
     * mysqlType:  bigint(20)
     */
    @ApiModelProperty(value = "清算行号")
    @NotNull(message = "清算行号不能为空")
	private Long payeeOpbk;

    @ApiModelProperty(value = "资金账户")
    @NotNull(message = "资金账户不能为空")
    private String fundAccount;

    @ApiModelProperty(value = "开户行号")
    @NotNull(message = "开户行号不能为空")
    private String opBankCode;

    @ApiModelProperty(value = "开户名称")
    @NotNull(message = "开户名称不能为空")
    private String opBankName;
	
}