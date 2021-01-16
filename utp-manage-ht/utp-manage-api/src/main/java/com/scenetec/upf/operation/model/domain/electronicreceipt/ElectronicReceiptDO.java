package com.scenetec.upf.operation.model.domain.electronicreceipt;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author scenetec
 * @date 2019/03/19
 */
@ApiModel(description = "电子回单")
@Data
public class ElectronicReceiptDO {

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
	private String orderNo;
	
    /**
     * 校验值
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "校验值")
	private String md5Hex;
	
    /**
     * json参数字符串
     * mysqlType: varchar(2000)
     */
    @ApiModelProperty(value = "json参数字符串")
	private String params;
	
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
    @ApiModelProperty(value = "交易流水ID")
	private String serverTransId;
	
    /**
     * 交易类型
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易类型")
	private String tradeType;
	
    /**
     * 客户请求流水号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "客户请求流水号")
	private String clientTransId;
	
    /**
     * 平台号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "平台号")
	private String industryCode;

	@ApiModelProperty(value = "路径")
	private String FilePath;

	
}