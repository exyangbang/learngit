package cn.kingnet.utp.service.persistence.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BankAccountTransDetailVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改用户
     */
    private String userModified;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 平台编码
     */
    private String industryCode;

    /**
     * 卡号
     */
    private String cardNumber;

    /**
     * 客户账号
     */
    private String custAccountNo;

    /**
     * 客户名称
     */
    private String custAccountName;

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
    private Long txnAmount;

    /**
     * 账户余额（单位分）
     */
    private Long accountBalance;

    /**
     * 对方账号
     */
    private String otherCustAccountNo;

    /**
     * 对方客户名称
     */
    private String otherCustName;

    /**
     * 0-正常 1-被冲账 2-冲账
     */
    private String reversedFlag;

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

    /**
     * 摘要描述
     */
    private String summaryDescription;

    /**
     * 用户账户|虚拟账户
     */
    private String account;

    /**
     * 入金订单状态[0未处理 1退款处理中 2已冻结 3已解冻 4已退款]
     */
    private String orderStatus;

    /**
     * 明细来源标识：0默认内部同步 1订单入金通知
     */
    private String sourceFlag;

    /**
     * 手工入账状态（0-待审核 1-审核通过 2-审核驳回）
     */
    private String auditStatus;

    private String bizReferenceNo;

    /**
     * 来款清算行号（订单入金通知处理时赋值）
     */
    private String otherBankNo;

    /**
     * 客户充值订单id 订单入金通知时赋值=incomeFlow.rid
     */
    private String otherRid;
}