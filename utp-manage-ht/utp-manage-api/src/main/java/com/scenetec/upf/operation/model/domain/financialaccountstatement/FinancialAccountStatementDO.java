package com.scenetec.upf.operation.model.domain.financialaccountstatement;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2019/02/14
 */
@ApiModel(description = "资金账户统计报表")
public class FinancialAccountStatementDO {

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
     * 资金账号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "资金账号")
	private String accountNo;
	
    /**
     * 客户名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "客户名称")
	private String merName;
	
    /**
     * 代付客户号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "代付客户号")
	private String industryCode;
	
    /**
     * 代付客户名
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "代付客户名")
	private String industryName;
	
    /**
     * 入金总金额（单位分）
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "入金总金额（单位分）")
	private Long inTotalAmount;
	
    /**
     * 出金总金额（单位分）
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "出金总金额（单位分）")
	private Long outTotalAmount;
	
    /**
     * 当日账户余额（单位分）
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "当日账户余额（单位分）")
	private Long currentAccountBalance;
	
    /**
     * 交易日期 格式为yyyyMMdd
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "交易日期 格式为yyyyMMdd")
	private String transDate;

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
    /** 获取资金账号 */
	public String getAccountNo() {
		return this.accountNo;
	}

    /** 设置资金账号 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
    /** 获取客户名称 */
	public String getMerName() {
		return this.merName;
	}

    /** 设置客户名称 */
	public void setMerName(String merName) {
		this.merName = merName;
	}
    /** 获取代付客户号 */
	public String getIndustryCode() {
		return this.industryCode;
	}

    /** 设置代付客户号 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
    /** 获取代付客户名 */
	public String getIndustryName() {
		return this.industryName;
	}

    /** 设置代付客户名 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
    /** 获取入金总金额（单位分） */
	public Long getInTotalAmount() {
		return this.inTotalAmount;
	}

    /** 设置入金总金额（单位分） */
	public void setInTotalAmount(Long inTotalAmount) {
		this.inTotalAmount = inTotalAmount;
	}
    /** 获取出金总金额（单位分） */
	public Long getOutTotalAmount() {
		return this.outTotalAmount;
	}

    /** 设置出金总金额（单位分） */
	public void setOutTotalAmount(Long outTotalAmount) {
		this.outTotalAmount = outTotalAmount;
	}
    /** 获取当日账户余额（单位分） */
	public Long getCurrentAccountBalance() {
		return this.currentAccountBalance;
	}

    /** 设置当日账户余额（单位分） */
	public void setCurrentAccountBalance(Long currentAccountBalance) {
		this.currentAccountBalance = currentAccountBalance;
	}
    /** 获取交易日期 格式为yyyyMMdd */
	public String getTransDate() {
		return this.transDate;
	}

    /** 设置交易日期 格式为yyyyMMdd */
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

    @Override
	public String toString() {
		return "FinancialAccountStatementDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", accountNo = [" + accountNo +"]"
              + ", merName = [" + merName +"]"
              + ", industryCode = [" + industryCode +"]"
              + ", industryName = [" + industryName +"]"
              + ", inTotalAmount = [" + inTotalAmount +"]"
              + ", outTotalAmount = [" + outTotalAmount +"]"
              + ", currentAccountBalance = [" + currentAccountBalance +"]"
              + ", transDate = [" + transDate +"]"
              ;
	}
	
}