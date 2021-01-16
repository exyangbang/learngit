package com.scenetec.upf.operation.model.domain.merchant;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/07/27
 */
@ApiModel(description = "商户证件照片信息表")
public class MerchantCertificationPicInfoDO {

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
     * 证件号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "证件号")
	private String certCode;
	
    /**
     * 证件照片
     * mysqlType: blob
     */
    @ApiModelProperty(value = "证件照片")
	private byte[] certPic;
	
    /**
     * 证件照片路径
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "证件照片路径")
	private String certPicPath;

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
    /** 获取证件号 */
	public String getCertCode() {
		return this.certCode;
	}

    /** 设置证件号 */
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
    /** 获取证件照片 */
	public byte[] getCertPic() {
		return this.certPic;
	}

    /** 设置证件照片 */
	public void setCertPic(byte[] certPic) {
		this.certPic = certPic;
	}
    /** 获取证件照片路径 */
	public String getCertPicPath() {
		return this.certPicPath;
	}

    /** 设置证件照片路径 */
	public void setCertPicPath(String certPicPath) {
		this.certPicPath = certPicPath;
	}

    @Override
	public String toString() {
		return "MerchantCertificationPicInfoDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", merNo = [" + merNo +"]"
              + ", certCode = [" + certCode +"]"
              + ", certPic = [" + certPic +"]"
              + ", certPicPath = [" + certPicPath +"]"
              ;
	}
	
}