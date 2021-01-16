package com.scenetec.upf.operation.model.domain.codedictionary;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2019/10/30
 */
@ApiModel(description = "业务编码字典")
public class CodeDictionaryDO {

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
     * 字典类型 0001:支付机构 0003:行业 0003:职业
     * mysqlType: varchar(255)
     */
    @ApiModelProperty(value = "字典类型 0001:支付机构 0002:行业 0003:职业")
	private String type;
	
    /**
     * key值
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "key值")
	private String code;
	
    /**
     * 信息名称
     * mysqlType: varchar(1000)
     */
    @ApiModelProperty(value = "信息名称")
	private String value;
	
    /**
     * 备注信息
     * mysqlType: varchar(1000)
     */
    @ApiModelProperty(value = "备注信息")
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
    /** 获取字典类型 0001:支付机构 0003:行业 0003:职业 */
	public String getType() {
		return this.type;
	}

    /** 设置字典类型 0001:支付机构 0003:行业 0003:职业 */
	public void setType(String type) {
		this.type = type;
	}
    /** 获取key值 */
	public String getCode() {
		return this.code;
	}

    /** 设置key值 */
	public void setCode(String code) {
		this.code = code;
	}
    /** 获取信息名称 */
	public String getValue() {
		return this.value;
	}

    /** 设置信息名称 */
	public void setValue(String value) {
		this.value = value;
	}
    /** 获取备注信息 */
	public String getRemark() {
		return this.remark;
	}

    /** 设置备注信息 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    @Override
	public String toString() {
		return "CodeDictionaryDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", type = [" + type +"]"
              + ", code = [" + code +"]"
              + ", value = [" + value +"]"
              + ", remark = [" + remark +"]"
              ;
	}
	
}