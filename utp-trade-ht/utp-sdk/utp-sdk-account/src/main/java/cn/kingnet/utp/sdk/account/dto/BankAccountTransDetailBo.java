package cn.kingnet.utp.sdk.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 一般户|内部户共用
 * @Author WJH
 * @Date 2018年10月24日
 */
@Getter
@Setter
public class BankAccountTransDetailBo implements Serializable {

    /**
     * 卡号
     */
    private String cardNumber;

    /**
     * 客户账号
     */
    private String custAccountNo;

    /**
     * 客户名称||一般户 查明细返回
     */
    private String custAccountName;
    /**
     * 客户名称||内部户 查明细返回
     */
    private String accountName;

    /**
     * 交易账务日期，清算日期
     */
    private String txnDate;

    /**
     * 交易自然日期，交易日期
     */
    private String natureDate;

    /**
     * 明细序号
     */
    private Long detailSerialNumber;

    /**
     * 借贷标志 0-借方 1-贷方
     */
    private String drcrFlag;

    /**
     * 交易金额（单位分）
     */
    private Double txnAmount;

    /**
     * 账户余额（单位分）
     */
    private Double accountBalance;

    /**
     * 对方账号| 一般户专有
     */
    private String otherCustAccountNo;


    /**
     * 对方账号| 内部户专有
     */
    private String otherAccount;

    /**
     * 对方客户名称
     */
    private String otherCustName;

    /**
     * 0-正常 1-被冲账 2-冲账 ||一般户专有
     */
    private String reversedFlag;

    /**
     * 0-正常 1-被冲账 2-冲账 ||内部户专有
     */
    private String reverseFlag;

    /**
     * 备注信息
     */
    private String remarkDetail;


    /**
     * 交易时间HHmmss
     */
    private String txnTime;

    /**
     * 华通系统交易流水号
     */
    private String sysReferenceNo;

    /**
     * 华通原系统交易流水号
     */
    private String orgSysReferenceNo;

    /**
     * 对方行名
     */
    private String otherBankName;

    /**
     * 对方银行备注
     */
    private String otherRemark;

    /**
     * 操作状态 0-未入账 1-已入账
     */
    private String operStatus;
}
