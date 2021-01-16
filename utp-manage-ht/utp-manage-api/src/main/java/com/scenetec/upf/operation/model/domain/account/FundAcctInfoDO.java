package com.scenetec.upf.operation.model.domain.account;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author scenetec
 * @date 2020/08/07
 */
@ApiModel(description = "反洗钱控制名单")
@Setter
@Getter
public class FundAcctInfoDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 客户号
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "客户号")
	private String industryCode;
	
    /**
     * 内部户账号
     * mysqlType: varchar(48)
     */
    @ApiModelProperty(value = "内部户账号")
	private String fundAcct;
	
    /**
     * 内部户账号名称
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "内部户账号名称")
	private String fundAcctName;

    @Override
	public String toString() {
		return "FundAcctInfoDO:"
              + "id = ["+ id + "]"
              + ", industryCode = [" + industryCode +"]"
              + ", fundAcct = [" + fundAcct +"]"
              + ", fundAcctName = [" + fundAcctName +"]"
              ;
	}
	
}