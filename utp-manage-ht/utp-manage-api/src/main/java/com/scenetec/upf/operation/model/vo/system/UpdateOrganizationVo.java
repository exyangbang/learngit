package com.scenetec.upf.operation.model.vo.system;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author sunquanhu
 * @ 创建日期：2018年7月26日
 */
@ApiModel("机构信息")
@Data
public class UpdateOrganizationVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**上级机构ID*/
    @ApiModelProperty(value = "机构编码")
    @NotNull(message = "机构编码不能为空")
    private Long id;

    @ApiModelProperty(value = "机构父节点")
    private Long parentId;

    /**机构全称*/
    @ApiModelProperty(value = "机构名称")
    @NotNull(message = "机构名称不能为空")
    @Size(max = 200,message = "机构名称最大长度不能超过200")
    private String fullName;

    /**机构简称*/
    @ApiModelProperty(value = "机构简称")
    @Size(max = 200,message = "机构简称最大长度不能超过200位")
    private String simpleName;

    /**机构代码*/
    @ApiModelProperty(value = "机构代码")
    @NotNull(message = "机构代码不能为空")
    @Size(max = 12,message = "机构代码最大长度不能超过12位")
    private String orgCode;

    /**联系人姓名*/
    @ApiModelProperty(value = "业务联系人姓名")
    @NotNull(message = "业务联系人姓名不能为空")
    @Size(max = 20,message = "业务联系人姓名最大长度不能超过20位")
    private String contactName;

    /**联系人电话*/
    @ApiModelProperty(value = "业务联系人电话")
    @NotNull(message = "业务联系人电话不能为空")
    @Size(max = 20,message = "业务联系人电话不能超过20位")
    private String contactTel;

    /**联系人邮箱*/
    @ApiModelProperty(value = "业务联系人邮箱")
    @NotNull(message = "业务联系人邮箱不能为空")
    @Size(max = 50,message = "业务联系人邮箱最大长度不能超过50位")
    private String contactEmail;

    /**联系人地址*/
    @ApiModelProperty(value = "业务联系人地址")
    @Size(max = 200,message = "业务联系人地址最大长度不能超过200位")
    private String contactAddr;

    /**注册资本（元）*/
    @ApiModelProperty(value = "注册资本（元）")
    @Size(max = 15,message = "注册资本最大长度不能超过15位")
    private String registeredCapital;

    /**法人姓名*/
    @ApiModelProperty(value = "法人姓名")
    @NotNull(message = "法人姓名不能为空")
    @Size(max = 20,message = "法人姓名最大长度不能超过20位")
    private String legalName;

    /**法人身份证号*/
    @ApiModelProperty(value = "法人身份证号")
    @NotNull(message = "法人身份证号不能为空")
    @Size(max = 18,message = "法人身份证号最大长度不能超过18位")
    private String legalIdcard;

    /**身份证生效开始日期*/
    @ApiModelProperty(value = "身份证起始日期")
    @NotNull(message = "身份证起始日期不能为空")
    private String idcardStartDate;

    /**身份证生效截止日期*/
    @ApiModelProperty(value = "身份证截止日期")
    @NotNull(message = "身份证截止日期不能为空")
    private String idcardEndDate;

    /**营业执照号码*/
    @ApiModelProperty(value = "营业执照号码")
    @NotNull(message = "营业执照号码不能为空")
    @Size(max = 18,message = "营业执照号码最大长度不能超过18位")
    private String businessLicense;

    /**营业执照生效开始日期*/
    @ApiModelProperty(value = "营业执照起始日期")
    @NotNull(message = "营业执照起始日期不能为空")
    private String setupStartDate;

    /**营业执照生效截止日期*/
    @ApiModelProperty(value = "营业执照结束日期")
    @NotNull(message = "营业执照结束日期不能为空")
    private String setupEndDate;

    /**注册地址*/
    @ApiModelProperty(value = "注册地址")
    @NotNull(message = "注册地址不能为空")
    @Size(max = 200,message = "注册地址最大长度不能超过200")
    private String address;

    /**所属省份代码*/
    @ApiModelProperty(value = "所属省份")
    @NotNull(message = "所属省份不能为空")
    private String provinceCode;

    /**所属城市代码*/
    @ApiModelProperty(value = "所属城市")
    @NotNull(message = "所属城市不能为空")
    private String cityCode;

    /**所属县区代码*/
    @ApiModelProperty(value = "所属县区")
    @NotNull(message = "所属县区不能为空")
    private String countyCode;

    /**法人身份证照片*/
    @ApiModelProperty(value = "法人身份证照片")
    @NotNull(message = "法人身份证照片不能为空")
    private String legalIdcardPic;

    /**营业执照照片*/
    @ApiModelProperty(value = "营业执照照片")
    @NotNull(message = "营业执照照片不能为空")
    private String businessLicensePic;

    /**组织机构代码证照片*/
    @ApiModelProperty(value = "组织机构代码证照片")
    private String orgCodeCertPic;

    /**税务登记证照片*/
    @ApiModelProperty(value = "税务登记证照片")
    private String taxRegCertPic;

    /**开户许可证照片*/
    @ApiModelProperty(value = "开户许可证照片")
    private String accountOpenLicensePic;
    /**技术联系人姓名*/
    @ApiModelProperty(value = "技术联系人姓名")
    @Size(max = 20,message = "技术联系人姓名最大长度不能超过20位")
    private String technologyContactName;
    /**技术联系人电话*/
    @ApiModelProperty(value = "技术联系人电话")
    @Size(max = 20,message = "技术联系人电话不能超过20位")
    private String technologyContactTel;
    /**技术联系人邮箱*/
    @ApiModelProperty(value = "技术联系人邮箱")
    @Size(max = 20,message = "技术联系人电话不能超过20位")
    private String technologyContactEmail;
    /**技术联系人地址*/
    @ApiModelProperty(value = "技术联系人地址")
    @Size(max = 200,message = "技术联系人地址最大长度不能超过200位")
    private String technologyContactAddr;
}
