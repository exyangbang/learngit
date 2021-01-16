package com.scenetec.upf.operation.model.domain.system;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scenetec.upf.operation.model.domain.system.status.DelFlagEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linkaigui on 2018-07-13.
 * @ 创建日期：2018-07-13
 */
@Data
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键*/
    private Long id;

    /**上级机构ID*/
    private Long parentId;

    /**机构全称*/
    private String fullName;

    /**机构简称*/
    private String simpleName;

    /**机构代码*/
    private String orgCode;

    /**联系人姓名*/
    private String contactName;

    /**联系人电话*/
    private String contactTel;

    /**联系人邮箱*/
    private String contactEmail;

    /**联系人地址*/
    private String contactAddr;

    /**注册资本（元）*/
    private String registeredCapital;

    /**法人姓名*/
    private String legalName;

    /**法人身份证号*/
    private String legalIdcard;

    /**身份证生效开始日期*/
    private String idcardStartDate;

    /**身份证生效截止日期*/
    private String idcardEndDate;

    /**营业执照号码*/
    private String businessLicense;

    /**营业执照生效开始日期*/
    private String setupStartDate;

    /**营业执照生效截止日期*/
    private String setupEndDate;

    /**注册地址*/
    private String address;

    /**所属省份代码*/
    private String provinceCode;

    /**所属城市代码*/
    private String cityCode;

    /**所属县区代码*/
    private String countyCode;

    /**法人身份证照片*/
    private String legalIdcardPic;

    /**营业执照照片*/
    private String businessLicensePic;

    /**组织机构代码证照片*/
    private String orgCodeCertPic;

    /**税务登记证照片*/
    private String taxRegCertPic;

    /**开户许可证照片*/
    private String accountOpenLicensePic;

    /**删除标记*/
    private String delFlag = DelFlagEnum.NORMAL.getValue();

    /**技术联系人姓名*/
    private String technologyContactName;
    /**技术联系人电话*/
    private String technologyContactTel;
    /**技术联系人邮箱*/
    private String technologyContactEmail;
    /**技术联系人地址*/
    private String technologyContactAddr;

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
}
