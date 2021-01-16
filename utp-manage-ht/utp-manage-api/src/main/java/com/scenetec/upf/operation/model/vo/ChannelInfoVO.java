package com.scenetec.upf.operation.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author scenetec
 * @date 2018/09/05
 */
@ApiModel(description = "渠道信息表")
@Data
public class ChannelInfoVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 渠道标识
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "渠道标识")
    private String channelKey;

    /**
     * 渠道名称
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName;

    /**
     * 渠道编码
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "渠道编码")
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
     * 支付产品名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "渠道额度")
    private String amount;

    /**
     * 接入类型
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "接入类型")
    private String joinType;

    /**
     * 请求前台地址
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "请求前台地址")
    private String frontUrl;

    /**
     * 请求后台地址
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "请求后台地址")
    private String backUrl;

    /**
     * trid参数
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "trid参数")
    private String trid;

    /**
     * trtp参数
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "trtp参数")
    private String trtp;

    /**
     * 机构号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "机构号")
    private String orgCode;

    /**
     * 机构名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;

    /**
     * 渠道手续费模板Id
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "渠道手续费模板Id")
    private Long chnFeeTemplateId;


    @ApiModelProperty(value = "渠道手续费模板名称")
    private String chnFeeTemplateName;

    /**
     * 状态
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "状态")
    private String status;

    /**
     * 状态
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "企业账户")
    private String accNo;

    /**
     * 状态
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "用户编码")
    private String userCode;


    @ApiModelProperty(value = "商户号")
    private String channelMerNo;


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