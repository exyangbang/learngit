package com.scenetec.upf.operation.model.domain.industry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/11/06
 */
@ApiModel(description = "平台来款账户信息表")
@Data
public class IndustryAccountInfoDO {

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
     * 平台号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "平台号")
	private String industryCode;

    /**
     * 来款账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "来款账号")
	private String accountNo;

    /**
     * 来款账户名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "来款账户名称")
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
     * 1:渠道商户(行业),4-手续费收入账户 5-手续费支出账户
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "1:渠道商户(行业),4-手续费收入账户 5-手续费支出账户")
    private String industryType;

    @Override
	public String toString() {
		return "IndustryAccountInfoDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", industryCode = [" + industryCode +"]"
              + ", accountNo = [" + accountNo +"]"
              + ", accountName = [" + accountName +"]"
              + ", bankCode = [" + bankCode +"]"
              + ", bankName = [" + bankName +"]"
                + ", industryType = [" + industryType +"]"
              ;
	}
	
}