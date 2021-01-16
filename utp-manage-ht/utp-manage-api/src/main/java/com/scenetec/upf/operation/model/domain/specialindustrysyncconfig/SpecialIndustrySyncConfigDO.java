package com.scenetec.upf.operation.model.domain.specialindustrysyncconfig;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2020/03/10
 */
@ApiModel(description = "特殊客户同步名单配置")
public class SpecialIndustrySyncConfigDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;
    
	
    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
	private String userCreate;
	
    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
	private Date gmtCreate;
	
    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
	private String userModified;
	
    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
	private Date gmtModified;
	
    /**
     * 客户名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "客户名称")
	private String industryCode;
	
    /**
     * 客户名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "客户名称")
	private String name;
	
    /**
     * 备注
     * mysqlType: varchar(1000)
     */
    @ApiModelProperty(value = "备注")
	private String remark;

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
    /** 获取客户名称 */
	public String getIndustryCode() {
		return this.industryCode;
	}

    /** 设置客户名称 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
    /** 获取客户名称 */
	public String getName() {
		return this.name;
	}

    /** 设置客户名称 */
	public void setName(String name) {
		this.name = name;
	}
    /** 获取备注 */
	public String getRemark() {
		return this.remark;
	}

    /** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    @Override
	public String toString() {
		return "SpecialIndustrySyncConfigDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", industryCode = [" + industryCode +"]"
              + ", name = [" + name +"]"
              + ", remark = [" + remark +"]"
              ;
	}
	
}