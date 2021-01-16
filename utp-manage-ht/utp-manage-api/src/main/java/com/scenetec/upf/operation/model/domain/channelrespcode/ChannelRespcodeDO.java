package com.scenetec.upf.operation.model.domain.channelrespcode;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2019/06/18
 */
@ApiModel(description = "错误码管理")
public class ChannelRespcodeDO {

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
     * TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中")
	private String transStatus;
	
    /**
     * 渠道响应码
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "渠道响应码")
	private String channelRespcode;
	
    /**
     * 渠道响应码描述
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "渠道响应码描述")
	private String channelRespdesc;
	
    /**
     * 启用状态 0:不启用 1：启用'
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "启用状态 0:不启用 1：启用'")
	private String status;
	
    /**
     * 备注说明
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "备注说明")
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
    /** 获取TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中 */
	public String getTransStatus() {
		return this.transStatus;
	}

    /** 设置TRADE_SUCCESS:交易成功 TRADE_FAILURE:交易失败 PROCESSING：交易处理中 */
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
    /** 获取渠道响应码 */
	public String getChannelRespcode() {
		return this.channelRespcode;
	}

    /** 设置渠道响应码 */
	public void setChannelRespcode(String channelRespcode) {
		this.channelRespcode = channelRespcode;
	}
    /** 获取渠道响应码描述 */
	public String getChannelRespdesc() {
		return this.channelRespdesc;
	}

    /** 设置渠道响应码描述 */
	public void setChannelRespdesc(String channelRespdesc) {
		this.channelRespdesc = channelRespdesc;
	}
    /** 获取启用状态 0:不启用 1：启用' */
	public String getStatus() {
		return this.status;
	}

    /** 设置启用状态 0:不启用 1：启用' */
	public void setStatus(String status) {
		this.status = status;
	}
    /** 获取备注说明 */
	public String getRemark() {
		return this.remark;
	}

    /** 设置备注说明 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    @Override
	public String toString() {
		return "ChannelRespcodeDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", transStatus = [" + transStatus +"]"
              + ", channelRespcode = [" + channelRespcode +"]"
              + ", channelRespdesc = [" + channelRespdesc +"]"
              + ", status = [" + status +"]"
              + ", remark = [" + remark +"]"
              ;
	}
	
}