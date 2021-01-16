package com.scenetec.upf.operation.model.domain.electronicreceipt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author scenetec
 * @date 2019/03/19
 */
@ApiModel(description = "开户电子回单")
@Data
public class AaccountElectronicReceiptDO {

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
     * 电子回单号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "电子回单号")
	private String receiptNo;
	
    /**
     * 校验值
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "校验值")
	private String md5Hex;

    /**
     * pdf文件内容
     * mysqlType: mediumblob
     */
    @ApiModelProperty(value = "pdf文件内容")
	private byte[] fileContent;
	
    /**
     * 交易流水ID
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "虚拟账户")
	private String account;
	
}