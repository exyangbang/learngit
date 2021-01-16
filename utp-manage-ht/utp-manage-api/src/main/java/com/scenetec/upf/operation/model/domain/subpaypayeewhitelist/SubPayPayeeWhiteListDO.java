package com.scenetec.upf.operation.model.domain.subpaypayeewhitelist;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2020/05/07
 */
@ApiModel(description = "子账户单笔付款收款白名单")
public class SubPayPayeeWhiteListDO {

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
	private String userModified;
	
    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
	private Date gmtModified;
	
    /**
     * 收款账号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "收款账号")
	private String payeeAccount;
	
    /**
     * 收款户名
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "收款户名")
	private String payeeName;
	
    /**
     * 代付客户号
     * mysqlType: int(20)
     */
    @ApiModelProperty(value = "代付客户号")
	private Long industryId;

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
    /** 获取收款账号 */
	public String getPayeeAccount() {
		return this.payeeAccount;
	}

    /** 设置收款账号 */
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
    /** 获取收款户名 */
	public String getPayeeName() {
		return this.payeeName;
	}

    /** 设置收款户名 */
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
    /** 获取代付客户号 */
	public Long getIndustryId() {
		return this.industryId;
	}

    /** 设置代付客户号 */
	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}

    @Override
	public String toString() {
		return "SubPayPayeeWhiteListDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", payeeAccount = [" + payeeAccount +"]"
              + ", payeeName = [" + payeeName +"]"
              + ", industryId = [" + industryId +"]"
              ;
	}
	
}