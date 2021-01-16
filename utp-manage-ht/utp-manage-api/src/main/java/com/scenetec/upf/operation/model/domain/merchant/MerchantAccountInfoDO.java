package com.scenetec.upf.operation.model.domain.merchant;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2018/07/27
 */
@ApiModel(description = "商户账户信息表")
@Data
public class MerchantAccountInfoDO {

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
	private Date gmtModified;
	
    /**
     * 商户号
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "商户号")
	private String merNo;
	
    /**
     * 账户类型
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "账户类型")
	private String accountType;
	
    /**
     * 账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "账号")
	private String accountNo;
	
    /**
     * 账户名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "账户名称")
	private String accountName;
	
    /**
     * 开户行行号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "开户行行号")
	private String bankCode;
	
    /**
     * 开户行行名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "开户行行名称")
	private String bankName;
	
    /**
     * 接收行号/结算结构代码
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "接收行号/结算结构代码")
	private String receiveBankCode;

	@ApiModelProperty(value = "虚拟账户")
	private String account;

	@ApiModelProperty(value = "虚拟账户")
	private String bindStatus;
}