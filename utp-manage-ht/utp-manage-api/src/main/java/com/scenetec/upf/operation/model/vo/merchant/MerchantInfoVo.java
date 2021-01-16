package com.scenetec.upf.operation.model.vo.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author scenetec
 * @date 2018/07/25
 */
@ApiModel(description = "商户基本信息表")
public class MerchantInfoVo {

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
     * 商户号
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "商户号")
	private String merNo;
	
    /**
     * 商户名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "商户名称")
	private String merName;
	
    /**
     * 商户简称
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "商户简称")
	private String nameAbbreviation;
	
    /**
     * 行政区划代码
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "行政区划代码")
	private String administrativeCode;

	/**
	 * 所属收单机构代码
	 * mysqlType: varchar(64)
	 */
	@ApiModelProperty(value = "所属收单机构代码")
	private String orgCode;

	/**
	 * 所属收单机构名称
	 * mysqlType: varchar(200)
	 */
	@ApiModelProperty(value = "所属收单机构名称")
	private String orgName;
	
    /**
     * 所属省
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "所属省")
	private String provinceCode;
	
    /**
     * 所属市
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "所属市")
	private String cityCode;
	
    /**
     * 所属县
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "所属县")
	private String countyCode;
	
    /**
     * 注册地址
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "注册地址")
	private String regAddress;
	
    /**
     * 营业地址
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "营业地址")
	private String businessAddress;
	
    /**
     * 法人代表姓名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "法人代表姓名")
	private String legalName;
	
    /**
     * 商户状态
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "商户状态")
	private String status;
	
    /**
     * 商户网站名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "商户网站名称")
	private String websiteName;
	
    /**
     * 支出商户号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "支出商户号")
	private String payMerchantNo;
	
    /**
     * 模板ID
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "模板ID")
	private String templateId;

	/**
	 * 证书编号
	 */
	@ApiModelProperty(value = "证书编号")
    private String certId;

	/** 获取主键ID */
	public Long getId() {
        return id;
    }

    /** 设置主键ID */
    public void setId(Long id) {
        this.id = id;
    }

    /** 获取创建用户 */
	public String getUserCreate() {
		return this.userCreate;
	}

    /** 设置创建用户 */
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
    /** 获取创建时间 */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

    /** 设置创建时间 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
    /** 获取修改用户 */
	public String getUserModified() {
		return this.userModified;
	}

    /** 设置修改用户 */
	public void setUserModified(String userModified) {
		this.userModified = userModified;
	}
    /** 获取修改时间 */
	public Date getGmtModified() {
		return this.gmtModified;
	}

    /** 设置修改时间 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
    /** 获取商户号 */
	public String getMerNo() {
		return this.merNo;
	}

    /** 设置商户号 */
	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}
    /** 获取商户名称 */
	public String getMerName() {
		return this.merName;
	}

    /** 设置商户名称 */
	public void setMerName(String merName) {
		this.merName = merName;
	}
    /** 获取商户简称 */
	public String getNameAbbreviation() {
		return this.nameAbbreviation;
	}

    /** 设置商户简称 */
	public void setNameAbbreviation(String nameAbbreviation) {
		this.nameAbbreviation = nameAbbreviation;
	}
    /** 获取行政区划代码 */
	public String getAdministrativeCode() {
		return this.administrativeCode;
	}

    /** 设置行政区划代码 */
	public void setAdministrativeCode(String administrativeCode) {
		this.administrativeCode = administrativeCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/** 获取所属省 */
	public String getProvinceCode() {
		return this.provinceCode;
	}

    /** 设置所属省 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
    /** 获取所属市 */
	public String getCityCode() {
		return this.cityCode;
	}

    /** 设置所属市 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
    /** 获取所属县 */
	public String getCountyCode() {
		return this.countyCode;
	}

    /** 设置所属县 */
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
    /** 获取注册地址 */
	public String getRegAddress() {
		return this.regAddress;
	}

    /** 设置注册地址 */
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
    /** 获取营业地址 */
	public String getBusinessAddress() {
		return this.businessAddress;
	}

    /** 设置营业地址 */
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
    /** 获取法人代表姓名 */
	public String getLegalName() {
		return this.legalName;
	}

    /** 设置法人代表姓名 */
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
    /** 获取商户状态 */
	public String getStatus() {
		return this.status;
	}

    /** 设置商户状态 */
	public void setStatus(String status) {
		this.status = status;
	}
    /** 获取商户网站名称 */
	public String getWebsiteName() {
		return this.websiteName;
	}

    /** 设置商户网站名称 */
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
    /** 获取支出商户号 */
	public String getPayMerchantNo() {
		return this.payMerchantNo;
	}

    /** 设置支出商户号 */
	public void setPayMerchantNo(String payMerchantNo) {
		this.payMerchantNo = payMerchantNo;
	}
    /** 获取模板ID */
	public String getTemplateId() {
		return this.templateId;
	}

    /** 设置模板ID */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}
}