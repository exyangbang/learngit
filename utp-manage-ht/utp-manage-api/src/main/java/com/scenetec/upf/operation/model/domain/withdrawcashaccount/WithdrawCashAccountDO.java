package com.scenetec.upf.operation.model.domain.withdrawcashaccount;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/03/14
 */
@ApiModel(description = "提现账户表")
@Data
public class WithdrawCashAccountDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    
	
    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    @JsonIgnore
	private String userCreate;
	
    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
	private Date gmtCreate;
	
    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    @JsonIgnore
	private String userModified;
	
    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
	private Date gmtModified;
	
    /**
     * 收款方账号
     * mysqlType: varchar(40)
     */
    @ApiModelProperty(value = "收款方账号")
	private String accountNo;
	
    /**
     * 收款方名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "收款方名称")
	private String accountName;
	
    /**
     * industry表id
     * mysqlType:  bigint(20)
     */
    @ApiModelProperty(value = "industry表id")
	private Long industryId;
	
    /**
     * 清算行号
     * mysqlType:  bigint(20)
     */
    @ApiModelProperty(value = "清算行号")
	private Long payeeOpbk;
	
    /**
     * 状态（0-不可用 1-可用）
     * mysqlType:  varchar(2)
     */
    @ApiModelProperty(value = "状态（0-不可用 1-可用）")
	private String status;
	
    /**
     * 资金账户
     * mysqlType:  varchar(32)
     */
    @ApiModelProperty(value = "资金账户")
	private String fundAccount;

	@ApiModelProperty(value = "开户行号")
	private String opBankCode;

	@ApiModelProperty(value = "开户名称")
	private String opBankName;


    @Override
	public String toString() {
		return "WithdrawCashAccountDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", accountNo = [" + accountNo +"]"
              + ", accountName = [" + accountName +"]"
              + ", industryId = [" + industryId +"]"
              + ", payeeOpbk = [" + payeeOpbk +"]"
              + ", status = [" + status +"]"
              + ", fundAccount = [" + fundAccount +"]"
              ;
	}
	
}