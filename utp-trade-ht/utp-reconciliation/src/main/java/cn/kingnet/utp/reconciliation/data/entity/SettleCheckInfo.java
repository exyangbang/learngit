package cn.kingnet.utp.reconciliation.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_settle_check_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.reconciliation.data.mapper.SettleCheckInfoMapper")
public class SettleCheckInfo extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 差错类型
     */
    @TableField(value = "error_type")
    private String errorType;

    /**
     * 差错备注
     */
    @TableField(value = "error_desc")
    private String errorDesc;

    /**
     * 处理标志
     */
    @TableField(value = "status")
    private String status;

    /**
     * 处理说明备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 虚账处理标识
     */
    @TableField(value = "account_handle_flag")
    private String accountHandleFlag;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 客户请求流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 对账时间
     */
    @TableField(value = "reconcile_time")
    private Date reconcileTime;

    /**
     * 对账日
     */
    @TableField(value = "reconcile_date")
    private String reconcileDate;

    /**
     * 修改前交易状态
     */
    @TableField(value = "before_trans_status")
    private String beforeTransStatus;

    /**
     * 交易状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 交易金额(分)
     */
    @TableField(value = "trans_amount")
    private Long transAmount;

    /**
     * 用户手续费
     */
    @TableField(value = "mer_fee")
    private Long merFee;

    /**
     * 渠道手续费
     */
    @TableField(value = "channel_fee")
    private Long channelFee;

    /**
     * 实际发生金额
     */
    @TableField(value = "real_amount")
    private Long realAmount;

    /**
     * 商户编号\个人身份证号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 平台编码/客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 产品类型/编码
     */
    @TableField(value = "product_code")
    private String productCode;

    /**
     * 交易类型
     */
    @TableField(value = "trade_type")
    private String tradeType;

    /**
     * 交易日期(yyyyMMdd)
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 交易时间(HHmmss)
     */
    @TableField(value = "trans_time")
    private String transTime;

    /**
     * 渠道标识
     */
    @TableField(value = "channel_key")
    private String channelKey;

    /**
     * 渠道编号
     */
    @TableField(value = "channel_code")
    private String channelCode;

    /**
     * 渠道名称
     */
    @TableField(value = "channel_name")
    private String channelName;

    /**
     * 渠道返回代码
     */
    @TableField(value = "channel_resp_code")
    private String channelRespCode;

    /**
     * 渠道返回流水号，批量交易渠道交易批次号。
     */
    @TableField(value = "channel_resp_id")
    private String channelRespId;

    @TableField(value = "channel_resp_msg")
    private String channelRespMsg;

    /**
     * 渠道返回时间
     */
    @TableField(value = "channel_resp_time")
    private String channelRespTime;

    /**
     * 客户请求时间(yyyyMMddHHmmss)
     */
    @TableField(value = "client_trans_time")
    private String clientTransTime;

    /**
     * 机构编码
     */
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 机构名称
     */
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 服务端批处理号
     */
    @TableField(value = "server_batch_no")
    private String serverBatchNo;

    /**
     * 关联流水id
     */
    @TableField(value = "server_link_id")
    private String serverLinkId;

    /**
     * 响应码
     */
    @TableField(value = "resp_code")
    private String respCode;

    /**
     * 撤销状态0-未撤销 1-已撤销
     */
    @TableField(value = "revoke_status")
    private String revokeStatus;

    /**
     * 退货状态0-未退货 1-部分退货 2-已全部退货
     */
    @TableField(value = "refund_status")
    private String refundStatus;

    /**
     * 入网分配的用户名
     */
    @TableField(value = "user_code")
    private String userCode;

    /**
     * 批量交易时：该批次下的明细流水号
     */
    @TableField(value = "batch_sub_no")
    private String batchSubNo;

    /**
     * 对公对私标志
     */
    @TableField(value = "pc_flag")
    private String pcFlag;

    /**
     * 客户类型
     */
    @TableField(value = "user_type")
    private String userType;

    /**
     * 收款人账号
     */
    @TableField(value = "payee_acct_no")
    private String payeeAcctNo;

    /**
     * 收款人名称
     */
    @TableField(value = "payee_name")
    private String payeeName;

    /**
     * 付款人账号
     */
    @TableField(value = "payer_acct_no")
    private String payerAcctNo;

    /**
     * 付款人名称
     */
    @TableField(value = "payer_name")
    private String payerName;

    /**
     * 企业入网时分配的企业账号
     */
    @TableField(value = "acc_no")
    private String accNo;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 商户结算类型(1-实时,2-后结)
     */
    @TableField(value = "mer_settle_type")
    private String merSettleType;

    /**
     * 商户收费模式(1-内扣,2-外扣)
     */
    @TableField(value = "mer_charge_mode")
    private String merChargeMode;

    /**
     * 渠道结算类型(1-实时,2-后结)
     */
    @TableField(value = "channel_settle_type")
    private String channelSettleType;

    /**
     * 渠道收费模式(1-内扣,2-外扣)
     */
    @TableField(value = "channel_charge_mode")
    private String channelChargeMode;

    /**
     * 渠道清算日期
     */
    @TableField(value = "channel_settle_date")
    private String channelSettleDate;

    /**
     * 原渠道手续费
     */
    @TableField(value = "orgin_channel_fee")
    private Long orginChannelFee;

    /**
     * 付款虚拟账户
     */
    @TableField(value = "payer_account")
    private String payerAccount;

    /**
     * 收款虚拟账户
     */
    @TableField(value = "payee_account")
    private String payeeAccount;

    /**
     * 手续费虚拟账户
     */
    @TableField(value = "fee_account")
    private String feeAccount;

    /**
     * 收益虚拟账户
     */
    @TableField(value = "income_account")
    private String incomeAccount;

    /**
     * 是否要求渠道对账 0否 1是
     */
    @TableField(value = "need_channel_reconcile")
    private String needChannelReconcile;

    /**
     * 展示付款帐号
     */
    @TableField(value = "show_payer_account_no")
    private String showPayerAccountNo;

    /**
     * 展示付款帐号名称
     */
    @TableField(value = "show_payer_account_name")
    private String showPayerAccountName;

    /**
     * 展示收款帐号
     */
    @TableField(value = "show_payee_account_no")
    private String showPayeeAccountNo;

    /**
     * 展示收款帐号名称
     */
    @TableField(value = "show_payee_account_name")
    private String showPayeeAccountName;

    /**
     * 订单号|暂指华通通知银行流水号
     */
    @TableField(value = "order_id")
    private String orderId;

    /**
     * 电子回单生成标识0未生成 1已生成
     */
    @TableField(value = "elc_make_flag")
    private String elcMakeFlag;

    /**
     * 手续费支出账户名称
     */
    @TableField(value = "fee_account_name")
    private String feeAccountName;

    /**
     * 手续费收益账户名称
     */
    @TableField(value = "income_account_name")
    private String incomeAccountName;

    /**
     * 付款人开户行行名
     */
    @TableField(value = "payer_opbk_name")
    private String payerOpbkName;

    /**
     * 收款人开户行名
     */
    @TableField(value = "payee_opbk_name")
    private String payeeOpbkName;

    /**
     * 备注
     */
    @TableField(value = "summary_description")
    private String summaryDescription;

    /**
     * 人工处理审核状态（0-待审核 1-审核通过 2-审核驳回）
     */
    @TableField(value = "audit_status")
    private String auditStatus;
}