package com.scenetec.upf.operation.model.domain.merchant;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/07/27
 */
@ApiModel(description = "商户证件信息表")
public class MerchantCertificationInfoDO {

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
     * 证件类型
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "证件类型")
	private String certType;
	
    /**
     * 法人代表证件类型
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "法人代表证件类型")
	private String legalIdType;
	
    /**
     * 证件号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "证件号")
	private String certCode;
	
    /**
     * 证件名称
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "证件名称")
	private String certName;
	
    /**
     * 证件有效起始日期
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "证件有效起始日期")
	private String certExpirationDateStart;
	
    /**
     * 证件有效截止日期
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "证件有效截止日期")
	private String certExpirationDateEnd;

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
    /** 获取证件类型 */
	public String getCertType() {
		return this.certType;
	}

    /** 设置证件类型 */
	public void setCertType(String certType) {
		this.certType = certType;
	}
    /** 获取法人代表证件类型 */
	public String getLegalIdType() {
		return this.legalIdType;
	}

    /** 设置法人代表证件类型 */
	public void setLegalIdType(String legalIdType) {
		this.legalIdType = legalIdType;
	}
    /** 获取证件号 */
	public String getCertCode() {
		return this.certCode;
	}

    /** 设置证件号 */
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
    /** 获取证件名称 */
	public String getCertName() {
		return this.certName;
	}

    /** 设置证件名称 */
	public void setCertName(String certName) {
		this.certName = certName;
	}
    /** 获取证件有效起始日期 */
	public String getCertExpirationDateStart() {
		return this.certExpirationDateStart;
	}

    /** 设置证件有效起始日期 */
	public void setCertExpirationDateStart(String certExpirationDateStart) {
		this.certExpirationDateStart = certExpirationDateStart;
	}
    /** 获取证件有效截止日期 */
	public String getCertExpirationDateEnd() {
		return this.certExpirationDateEnd;
	}

    /** 设置证件有效截止日期 */
	public void setCertExpirationDateEnd(String certExpirationDateEnd) {
		this.certExpirationDateEnd = certExpirationDateEnd;
	}

    @Override
	public String toString() {
		return "MerchantCertificationInfoDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", merNo = [" + merNo +"]"
              + ", certType = [" + certType +"]"
              + ", legalIdType = [" + legalIdType +"]"
              + ", certCode = [" + certCode +"]"
              + ", certName = [" + certName +"]"
              + ", certExpirationDateStart = [" + certExpirationDateStart +"]"
              + ", certExpirationDateEnd = [" + certExpirationDateEnd +"]"
              ;
	}
	
}