package com.scenetec.upf.operation.model.domain.accIncomeFlow;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2020/02/12
 */
@ApiModel(description = "子账户入金流水报备")
public class accIncomeFlowDO {

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
     * 入金子账户
     * mysqlType: varchar(30)
     */
    @ApiModelProperty(value = "入金子账户")
	private String subAccount;
	
    /**
     * 入金批次Id
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "入金批次Id")
	private String batchNo;
	
    /**
     * 批次内序号
     * mysqlType: int(11)
     */
    @ApiModelProperty(value = "批次内序号")
	private int seqNo;
	
    /**
     * 入金流水id
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "入金流水id")
	private String incomeFlowId;
	
    /**
     * 入金金额单位分
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "入金金额单位分")
	private Long incomeAmount;
	
    /**
     * 上送支付流水ids
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "上送支付流水ids")
	private String payFlowIds;
	
    /**
     * 备注说明
     * mysqlType: varchar(1024)
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
    /** 获取入金子账户 */
	public String getSubAccount() {
		return this.subAccount;
	}

    /** 设置入金子账户 */
	public void setSubAccount(String subAccount) {
		this.subAccount = subAccount;
	}
    /** 获取入金批次Id */
	public String getBatchNo() {
		return this.batchNo;
	}

    /** 设置入金批次Id */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
    /** 获取批次内序号 */
	public int getSeqNo() {
		return this.seqNo;
	}

    /** 设置批次内序号 */
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
    /** 获取入金流水id */
	public String getIncomeFlowId() {
		return this.incomeFlowId;
	}

    /** 设置入金流水id */
	public void setIncomeFlowId(String incomeFlowId) {
		this.incomeFlowId = incomeFlowId;
	}
    /** 获取入金金额单位分 */
	public Long getIncomeAmount() {
		return this.incomeAmount;
	}

    /** 设置入金金额单位分 */
	public void setIncomeAmount(Long incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
    /** 获取上送支付流水ids */
	public String getPayFlowIds() {
		return this.payFlowIds;
	}

    /** 设置上送支付流水ids */
	public void setPayFlowIds(String payFlowIds) {
		this.payFlowIds = payFlowIds;
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
		return "accIncomeFlowDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", subAccount = [" + subAccount +"]"
              + ", batchNo = [" + batchNo +"]"
              + ", seqNo = [" + seqNo +"]"
              + ", incomeFlowId = [" + incomeFlowId +"]"
              + ", incomeAmount = [" + incomeAmount +"]"
              + ", payFlowIds = [" + payFlowIds +"]"
              + ", remark = [" + remark +"]"
              ;
	}
	
}