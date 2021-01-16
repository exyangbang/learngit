package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.BankAccountTransDetailVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_bank_account_trans_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.BankAccountTransDetailMapper")
public class BankAccountTransDetail extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 平台编码
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 卡号
     */
    @TableField(value = "card_number")
    private String cardNumber;

    /**
     * 客户账号
     */
    @TableField(value = "cust_account_no")
    private String custAccountNo;

    /**
     * 客户名称
     */
    @TableField(value = "cust_account_name")
    private String custAccountName;

    /**
     * 交易账务日期，清算日期
     */
    @TableField(value = "txn_date")
    private String txnDate;

    /**
     * 交易自然日期，交易日期
     */
    @TableField(value = "nature_date")
    private String natureDate;

    /**
     * 明细序号
     */
    @TableField(value = "detail_serial_number")
    private Long detailSerialNumber;

    /**
     * 借贷标志 0-借方 1-贷方
     */
    @TableField(value = "drcr_flag")
    private String drcrFlag;

    /**
     * 交易金额（单位分）
     */
    @TableField(value = "txn_amount")
    private Long txnAmount;

    /**
     * 账户余额（单位分）
     */
    @TableField(value = "account_balance")
    private Long accountBalance;

    /**
     * 对方账号
     */
    @TableField(value = "other_cust_account_no")
    private String otherCustAccountNo;

    /**
     * 对方客户名称
     */
    @TableField(value = "other_cust_name")
    private String otherCustName;

    /**
     * 0-正常 1-被冲账 2-冲账
     */
    @TableField(value = "reversed_flag")
    private String reversedFlag;

    /**
     * 备注信息
     */
    @TableField(value = "remark_detail")
    private String remarkDetail;

    /**
     * 交易时间HHmmss
     */
    @TableField(value = "txn_time")
    private String txnTime;

    /**
     * 华通系统交易流水号
     */
    @TableField(value = "sys_reference_no")
    private String sysReferenceNo;

    /**
     * 华通原系统交易流水号
     */
    @TableField(value = "org_sys_reference_no")
    private String orgSysReferenceNo;

    /**
     * 对方行名
     */
    @TableField(value = "other_bank_name")
    private String otherBankName;

    /**
     * 对方银行备注
     */
    @TableField(value = "other_remark")
    private String otherRemark;

    /**
     * 操作状态 0-未入账 1-已入账
     */
    @TableField(value = "oper_status")
    private String operStatus;

    /**
     * 摘要描述
     */
    @TableField(value = "summary_description")
    private String summaryDescription;

    /**
     * 用户账户|虚拟账户
     */
    @TableField(value = "account")
    private String account;

    /**
     * 入金订单状态[0未处理 1退款处理中 2已冻结 3已解冻 4已退款]
     */
    @TableField(value = "order_status")
    private String orderStatus;

    /**
     * 明细来源标识：0默认内部同步 1订单入金通知
     */
    @TableField(value = "source_flag")
    private String sourceFlag;

    /**
     * 手工入账状态（0-待审核 1-审核通过 2-审核驳回）
     */
    @TableField(value = "audit_status")
    private String auditStatus;

    @TableField(value = "biz_reference_no")
    private String bizReferenceNo;

    /**
     * 来款清算行号（订单入金通知处理时赋值）
     */
    @TableField(value = "other_bank_no")
    private String otherBankNo;

    /**
     * 客户充值订单id 订单入金通知时赋值=incomeFlow.rid
     */
    @TableField(value = "other_rid")
    private String otherRid;

    public BankAccountTransDetailVo buildVo() {
        return new BankAccountTransDetailVo(id, userCreate, gmtCreate, userModified, gmtModified, industryCode, cardNumber, custAccountNo, custAccountName, txnDate, natureDate, detailSerialNumber, drcrFlag, txnAmount, accountBalance, otherCustAccountNo, otherCustName, reversedFlag, remarkDetail, txnTime, sysReferenceNo, orgSysReferenceNo, otherBankName, otherRemark, operStatus, summaryDescription, account, orderStatus, sourceFlag, auditStatus, bizReferenceNo, otherBankNo, otherRid);
    }

    public static BankAccountTransDetail of(BankAccountTransDetailVo vo) {
        return new BankAccountTransDetail(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getIndustryCode(), vo.getCardNumber(), vo.getCustAccountNo(), vo.getCustAccountName(), vo.getTxnDate(), vo.getNatureDate(), vo.getDetailSerialNumber(), vo.getDrcrFlag(), vo.getTxnAmount(), vo.getAccountBalance(), vo.getOtherCustAccountNo(), vo.getOtherCustName(), vo.getReversedFlag(), vo.getRemarkDetail(), vo.getTxnTime(), vo.getSysReferenceNo(), vo.getOrgSysReferenceNo(), vo.getOtherBankName(), vo.getOtherRemark(), vo.getOperStatus(), vo.getSummaryDescription(), vo.getAccount(), vo.getOrderStatus(), vo.getSourceFlag(), vo.getAuditStatus(), vo.getBizReferenceNo(), vo.getOtherBankNo(), vo.getOtherRid());
    }
}