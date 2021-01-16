package com.scenetec.upf.operation.model.vo.industry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@ApiModel(description = "行业管理")
@Data
public class IndustryDataVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


    @Size(min = 1, max = 200, message = " 企业名称最大长度不能超过200")
    @ApiModelProperty(value = "企业名称")
    @NotNull(message = "企业名称不能为空")
    private String entName;

    @Size(min = 1, max = 40, message = "企业账号最大长度不能超过40")
    @ApiModelProperty(value = "企业账号")
    @NotNull(message = "企业账号不能为空")
    private String accountNo;

    private String account;

    private String code;
    /**
     * 营业执照号
     * mysqlType:
     */
//    @Size(min=1,max = 200,message = "营业执照号最大长度不能超过200")
//    @NotNull(message = "营业执照号不能为空")
    @ApiModelProperty(value = "营业执照号")
    private String busLicCode;

    /**
     * 注册地址
     * mysqlType: varchar(300)
     */
//    @Size(min=1,max = 200,message = "注册地址最大长度不能超过200")
//    @NotNull(message = "注册地址不能为空")
    @ApiModelProperty(value = "注册地址")
    private String regAddress;


    /**
     * 法人证件类型
     * mysqlType: varchar(32)
     */
    @Size(min = 1, max = 3, message = "法人证件类型最大长度不能超过3")
    @ApiModelProperty(value = "法人证件类型")
    @NotNull(message = "法人证件类型不能为空")
    private String idType;
    /**
     * 个人/法人证件号
     * mysqlType: varchar(32)
     */
    @Size(min = 1, max = 40, message = "个人/法人证件号最大长度不能超过40")
    @ApiModelProperty(value = "个人/法人证件号")
    @NotNull(message = "个人/法人证件号不能为空")
    private String idCode;


    /**
     * 营业执照图片（点击可以查看图片）
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "营业执照图片（点击可以查看图片）")
//    @NotNull(message = "营业执照图片不能为空")
    private String busLicPic;

    /**
     * 法人证件图片正面（点击可以查看图片）
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "法人证件图片正面（点击可以查看图片）")
//    @NotNull(message = "法人证件图片正面不能为空")
    private String personPic;

    /**
     * 法人证件图片反面（点击可以查看图片
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "法人证件图片反面（点击可以查看图片")
//    @NotNull(message = "法人证件图片反面不能为空")
    private String personReversePic;

    @ApiModelProperty(value = "开户许可证")
    private String licensePic;


    @ApiModelProperty(value = "法人名称")
    @Size(min = 1, max = 40, message = "法人名称最大长度不能超过100")
    @NotNull(message = "法人名称不能为空")
    private String legalPerson;

    @Size(min = 1, max = 100, message = "客户国籍最大长度不能超过100")
    private String nationality;
    @Size(min = 1, max = 20, message = "联系人电话最大长度不能超过20")
    private String phone;
    @Size(min = 1, max = 40, message = "客户行业最大长度不能超过40")
    private String customerTrade;
    //    @Size(min=1,max = 128,message = "控股股东或实际控制人证明文件类型最大长度不能超过128")
    private String fileType;
    //    @Size(min=1,max = 128,message = "控股股东或实际控制人其他证明文件类型最大长度不能超过128")
    private String otherFileType;
    //    @Size(min=1,max = 128,message = "控股股东或实际控制人证明文件号码最大长度不能超过128")
    private String fileNum;
}