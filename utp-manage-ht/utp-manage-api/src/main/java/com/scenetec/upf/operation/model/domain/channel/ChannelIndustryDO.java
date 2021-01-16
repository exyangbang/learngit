package com.scenetec.upf.operation.model.domain.channel;

import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/10/31
 */
@ApiModel(description = "渠道平台管理")
@Data
public class ChannelIndustryDO {

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

    @ApiModelProperty(value = "渠道名称")
    private String channelName;
    /**
     * 支付产品编码
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "支付产品编码")
	private String productNo;

    @ApiModelProperty(value = "支付产品名称")
    private String productName;
    /**
     * 平台号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "平台号")
	private String industryCode;

    @ApiModelProperty(value = "平台名称")
    private String industryName;

    /**
     * 平台手续费模板Id
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "平台手续费模板Id")
	private Long indFeeTemplateId;

    @ApiModelProperty(value = "平台手续费模板名称")
    private String indFeeTemplateName;

    /**
     * 渠道手续费模板Id
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "渠道手续费模板Id")
	private Long chnFeeTemplateId;


    /**
     * 置顶操作
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "置顶操作")
    private Long roofPlacement;


    /**
     * 渠道标识
     *
     */
    @ApiModelProperty(value = "渠道标识")
    private String channelKey;

    @ApiModelProperty(value = "渠道商户号")
    private String channelMerNo;

    @ApiModelProperty(value = "对公模板id")
    private Long publicFeeTemplateId;

    @ApiModelProperty(value = "对私模板id")
    private Long privateFeeTemplateId;


    @ApiModelProperty(value = "对公模板名称")
    private String publicFeeTemplateName;

    @ApiModelProperty(value = "对私模板名称")
    private String privateFeeTemplateName;

    @ApiModelProperty(value = "商户名称")
    private String channelMerName;

    @ApiModelProperty(value = "商户类别")
    private String channelMerategory;

    @ApiModelProperty(value = "商户简称")
    private String channelMerShortName;

    @ApiModelProperty(value = "资金来源")
    private String channelCapitalSource;

    @ApiModelProperty(value = "银联渠道名称备注")
    private String channelMerNameDec;
}