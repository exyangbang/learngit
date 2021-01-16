package com.scenetec.upf.operation.model.domain.channel;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@ApiModel(description = "渠道商户管理")
@Data
public class ChannelMerchantDO {

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
     * 渠道代码
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "渠道代码")
	private String channelCode;

    /**
     * 支付产品编码
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "支付产品编码")
	private String productNo;

    /**
     * 支付产品名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "支付产品名称")
    private String productName;

    /**
     * 商户号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "商户号")
	private String merNo;

    /**
     * 商户名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "商户名称")
    private String merName;

    /**
     * 商户手续费模板Id
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "商户手续费模板Id")
	private Long merFeeTemplateId;

    /**
     * 商户手续费模板Id
     */
    @ApiModelProperty(value = "商户手续费模板名称")
    private String merFeeTemplateName;

    /**
     * 渠道手续费模板Id
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "渠道手续费模板Id")
	private Long chnFeeTemplateId;

    @Override
	public String toString() {
		return "ChannelMerchantDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", channelCode = [" + channelCode +"]"
              + ", productNo = [" + productNo +"]"
              + ", merNo = [" + merNo +"]"
              + ", merFeeTemplateId = [" + merFeeTemplateId +"]"
              + ", chnFeeTemplateId = [" + chnFeeTemplateId +"]"
              ;
	}
	
}