package com.scenetec.upf.operation.model.domain.whitelist;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/01/28
 */
@ApiModel(description = "来款账户白名单")
@Data
public class WhiteListDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    
	
    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
	private String userCreate;
	
    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
	private Date gmtCreate;
	
    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
	private String userModified;
	
    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
	private Date gmtModified;
	
    /**
     * 客户名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "客户名称")
	private String merName;
	
    /**
     * 客户简称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "客户简称")
	private String merAbb;
	
    /**
     * 代付客户号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "代付客户号")
	private String industryCode;
	
    /**
     * 来款方户名
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "来款方户名")
	private String accountName;
    /**
     * 资金账户
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "资金账户")
	private String fundAccount;


	
}