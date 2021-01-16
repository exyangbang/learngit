package com.scenetec.upf.operation.model.domain.merchant;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/07/27
 */
@ApiModel(description = "商户联系人信息表")
public class MerchantContactInfoDO {

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
     * 商户联系人
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "商户联系人")
	private String contactName;
	
    /**
     * 商户联系人电话
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "商户联系人电话")
	private String contactPhone;
	
    /**
     * 商户联系人邮箱
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "商户联系人邮箱")
	private String contactEmail;

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
    /** 获取商户联系人 */
	public String getContactName() {
		return this.contactName;
	}

    /** 设置商户联系人 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
    /** 获取商户联系人电话 */
	public String getContactPhone() {
		return this.contactPhone;
	}

    /** 设置商户联系人电话 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
    /** 获取商户联系人邮箱 */
	public String getContactEmail() {
		return this.contactEmail;
	}

    /** 设置商户联系人邮箱 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

    @Override
	public String toString() {
		return "MerchantContactInfoDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", merNo = [" + merNo +"]"
              + ", contactName = [" + contactName +"]"
              + ", contactPhone = [" + contactPhone +"]"
              + ", contactEmail = [" + contactEmail +"]"
              ;
	}
	
}