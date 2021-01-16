package com.scenetec.upf.operation.model.vo.whitelist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author scenetec
 * @date 2019/01/28
 */
@ApiModel(description = "来款账户白名单")
@Data
public class WhiteListVO {

	@ApiModelProperty(value = "主键ID")
	private Long id;

	/**
	 * 客户名称
	 * mysqlType: varchar(200)
	 */
	@NotNull(message = "客户名称不能为空")
	@ApiModelProperty(value = "客户名称")
	@Size(min=1,max = 200,message = "客户名称最大长度不能超过200")
	private String merName;

	/**
	 * 客户简称
	 * mysqlType: varchar(200)
	 */

	@ApiModelProperty(value = "客户简称")
	@Size(min=1,max = 200,message = "客户简称最大长度不能超过200")
	private String merAbb;

	/**
	 * 代付客户号
	 * mysqlType: varchar(12)
	 */
	@ApiModelProperty(value = "代付客户号")
	@NotNull(message = "代付客户号不能为空")
	@Size(min=1,max = 12,message = "代付客户号最大长度不能超过12")
	private String industryCode;
	
    /**
     * 来款方户名
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "来款方户名")
	@NotNull(message = "来款方户名不能为空")
	@Size(min=1,max = 200,message = "来款方户名最大长度不能超过200")
	private String accountName;

	/**
	 * 资金账户
	 * mysqlType: varchar(200)
	 */
	@ApiModelProperty(value = "资金账户")
//	@NotNull(message = "资金账户不能为空")
//	@Size(min=1,max = 200,message = "来款方户名最大长度不能超过200")
	private String fundAccount;
	
}