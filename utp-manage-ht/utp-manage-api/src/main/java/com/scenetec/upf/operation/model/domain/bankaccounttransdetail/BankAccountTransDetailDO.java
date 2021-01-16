package com.scenetec.upf.operation.model.domain.bankaccounttransdetail;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2019/02/27
 */
@ApiModel(description = "未入账资金流水查询")
public class BankAccountTransDetailDO {

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
     * 平台编码
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "平台编码")
	private String industryCode;
	
    /**
     * 卡号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "卡号")
	private String cardNumber;
	
    /**
     * 客户账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "客户账号")
	private String custAccountNo;
	
    /**
     * 客户名称
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "客户名称")
	private String custAccountName;
	
    /**
     * 交易账务日期，清算日期
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "交易账务日期，清算日期")
	private Long txnDate;
	
    /**
     * 交易自然日期，交易日期
     * mysqlType: varchar(8)
     */
    @ApiModelProperty(value = "交易自然日期，交易日期")
	private String natureDate;
	
    /**
     * 明细序号
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "明细序号")
	private Long detailSerialNumber;
	
    /**
     * 借贷标志 0-借方 1-贷方
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "借贷标志 0-借方 1-贷方")
	private String drcrFlag;
	
    /**
     * 交易金额（单位分)
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "交易金额（单位分)")
	private Long txnAmount;
	
    /**
     * 账户余额（单位分)
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "账户余额（单位分)")
	private Long accountBalance;
	
    /**
     * 对方账号
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "对方账号")
	private String otherCustAccountNo;
	
    /**
     * 对方客户名称
     * mysqlType: varchar(50)
     */
    @ApiModelProperty(value = "对方客户名称")
	private String otherCustName;
	
    /**
     * 0-正常 1-被冲账 2-冲账
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "0-正常 1-被冲账 2-冲账")
	private String reversedFlag;
	
    /**
     * 备注信息
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "备注信息")
	private String remarkDetail;
	
    /**
     * 交易时间HHmmss
     * mysqlType: varchar(6)
     */
    @ApiModelProperty(value = "交易时间HHmmss")
	private String txnTime;
	
    /**
     * 华通系统交易流水号
     * mysqlType: varchar(34)
     */
    @ApiModelProperty(value = "华通系统交易流水号")
	private String sysReferenceNo;
	
    /**
     * 华通原系统交易流水号
     * mysqlType: varchar(34)
     */
    @ApiModelProperty(value = "华通原系统交易流水号")
	private String orgSysReferenceNo;
	
    /**
     * 对方行名
     * mysqlType: varchar(80)
     */
    @ApiModelProperty(value = "对方行名")
	private String otherBankName;
	
    /**
     * 对方银行备注
     * mysqlType: varchar(80)
     */
    @ApiModelProperty(value = "对方银行备注")
	private String otherRemark;
	
    /**
     * 操作状态 0-未入账 1-已入账
     * mysqlType: varchar(2)
     */
    @ApiModelProperty(value = "操作状态 0-未入账 1-已入账")
	private String operStatus;



	/**
	 * 手工入账状态（0-待审核 1-审核通过 2-审核驳回）
	 * mysqlType: varchar(2)
	 */
	@ApiModelProperty(value = "手工入账状态（0-待审核 1-审核通过 2-审核驳回）")
	private String auditStatus;

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

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
    /** 获取平台编码 */
	public String getIndustryCode() {
		return this.industryCode;
	}

    /** 设置平台编码 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
    /** 获取卡号 */
	public String getCardNumber() {
		return this.cardNumber;
	}

    /** 设置卡号 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
    /** 获取客户账号 */
	public String getCustAccountNo() {
		return this.custAccountNo;
	}

    /** 设置客户账号 */
	public void setCustAccountNo(String custAccountNo) {
		this.custAccountNo = custAccountNo;
	}
    /** 获取客户名称 */
	public String getCustAccountName() {
		return this.custAccountName;
	}

    /** 设置客户名称 */
	public void setCustAccountName(String custAccountName) {
		this.custAccountName = custAccountName;
	}
    /** 获取交易账务日期，清算日期 */
	public Long getTxnDate() {
		return this.txnDate;
	}

    /** 设置交易账务日期，清算日期 */
	public void setTxnDate(Long txnDate) {
		this.txnDate = txnDate;
	}
    /** 获取交易自然日期，交易日期 */
	public String getNatureDate() {
		return this.natureDate;
	}

    /** 设置交易自然日期，交易日期 */
	public void setNatureDate(String natureDate) {
		this.natureDate = natureDate;
	}
    /** 获取明细序号 */
	public Long getDetailSerialNumber() {
		return this.detailSerialNumber;
	}

    /** 设置明细序号 */
	public void setDetailSerialNumber(Long detailSerialNumber) {
		this.detailSerialNumber = detailSerialNumber;
	}
    /** 获取借贷标志 0-借方 1-贷方 */
	public String getDrcrFlag() {
		return this.drcrFlag;
	}

    /** 设置借贷标志 0-借方 1-贷方 */
	public void setDrcrFlag(String drcrFlag) {
		this.drcrFlag = drcrFlag;
	}
    /** 获取交易金额（单位分) */
	public Long getTxnAmount() {
		return this.txnAmount;
	}

    /** 设置交易金额（单位分) */
	public void setTxnAmount(Long txnAmount) {
		this.txnAmount = txnAmount;
	}
    /** 获取账户余额（单位分) */
	public Long getAccountBalance() {
		return this.accountBalance;
	}

    /** 设置账户余额（单位分) */
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
    /** 获取对方账号 */
	public String getOtherCustAccountNo() {
		return this.otherCustAccountNo;
	}

    /** 设置对方账号 */
	public void setOtherCustAccountNo(String otherCustAccountNo) {
		this.otherCustAccountNo = otherCustAccountNo;
	}
    /** 获取对方客户名称 */
	public String getOtherCustName() {
		return this.otherCustName;
	}

    /** 设置对方客户名称 */
	public void setOtherCustName(String otherCustName) {
		this.otherCustName = otherCustName;
	}
    /** 获取0-正常 1-被冲账 2-冲账 */
	public String getReversedFlag() {
		return this.reversedFlag;
	}

    /** 设置0-正常 1-被冲账 2-冲账 */
	public void setReversedFlag(String reversedFlag) {
		this.reversedFlag = reversedFlag;
	}
    /** 获取备注信息 */
	public String getRemarkDetail() {
		return this.remarkDetail;
	}

    /** 设置备注信息 */
	public void setRemarkDetail(String remarkDetail) {
		this.remarkDetail = remarkDetail;
	}
    /** 获取交易时间HHmmss */
	public String getTxnTime() {
		return this.txnTime;
	}

    /** 设置交易时间HHmmss */
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
    /** 获取华通系统交易流水号 */
	public String getSysReferenceNo() {
		return this.sysReferenceNo;
	}

    /** 设置华通系统交易流水号 */
	public void setSysReferenceNo(String sysReferenceNo) {
		this.sysReferenceNo = sysReferenceNo;
	}
    /** 获取华通原系统交易流水号 */
	public String getOrgSysReferenceNo() {
		return this.orgSysReferenceNo;
	}

    /** 设置华通原系统交易流水号 */
	public void setOrgSysReferenceNo(String orgSysReferenceNo) {
		this.orgSysReferenceNo = orgSysReferenceNo;
	}
    /** 获取对方行名 */
	public String getOtherBankName() {
		return this.otherBankName;
	}

    /** 设置对方行名 */
	public void setOtherBankName(String otherBankName) {
		this.otherBankName = otherBankName;
	}
    /** 获取对方银行备注 */
	public String getOtherRemark() {
		return this.otherRemark;
	}

    /** 设置对方银行备注 */
	public void setOtherRemark(String otherRemark) {
		this.otherRemark = otherRemark;
	}
    /** 获取操作状态 0-未入账 1-已入账 */
	public String getOperStatus() {
		return this.operStatus;
	}

    /** 设置操作状态 0-未入账 1-已入账 */
	public void setOperStatus(String operStatus) {
		this.operStatus = operStatus;
	}

    @Override
	public String toString() {
		return "BankAccountTransDetailDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", industryCode = [" + industryCode +"]"
              + ", cardNumber = [" + cardNumber +"]"
              + ", custAccountNo = [" + custAccountNo +"]"
              + ", custAccountName = [" + custAccountName +"]"
              + ", txnDate = [" + txnDate +"]"
              + ", natureDate = [" + natureDate +"]"
              + ", detailSerialNumber = [" + detailSerialNumber +"]"
              + ", drcrFlag = [" + drcrFlag +"]"
              + ", txnAmount = [" + txnAmount +"]"
              + ", accountBalance = [" + accountBalance +"]"
              + ", otherCustAccountNo = [" + otherCustAccountNo +"]"
              + ", otherCustName = [" + otherCustName +"]"
              + ", reversedFlag = [" + reversedFlag +"]"
              + ", remarkDetail = [" + remarkDetail +"]"
              + ", txnTime = [" + txnTime +"]"
              + ", sysReferenceNo = [" + sysReferenceNo +"]"
              + ", orgSysReferenceNo = [" + orgSysReferenceNo +"]"
              + ", otherBankName = [" + otherBankName +"]"
              + ", otherRemark = [" + otherRemark +"]"
              + ", operStatus = [" + operStatus +"]"
              + ", auditStatus = [" + auditStatus +"]"
              ;
	}
	
}