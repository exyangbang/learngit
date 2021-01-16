package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_trans_param_fail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.TransParamFailMapper")
public class TransParamFail extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

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
     * 商户编号\个人身份证号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 客户请求流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 客户请求时间(yyyyMMddHHmmss)
     */
    @TableField(value = "client_trans_time")
    private String clientTransTime;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

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
     * 交易金额(分)
     */
    @TableField(value = "trans_amount")
    private Long transAmount;

    /**
     * 实际发生金额(分)
     */
    @TableField(value = "real_amount")
    private Long realAmount;

    /**
     * 交易状态，成功：TRADE_SUCCESS、失败：TRADE_FAILURE、处理中：PROCESSING
     */
    @TableField(value = "trans_status")
    private String transStatus;

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
     * 渠道返回时间
     */
    @TableField(value = "channel_resp_time")
    private String channelRespTime;

    /**
     * 渠道返回代码
     */
    @TableField(value = "channel_resp_code")
    private String channelRespCode;

    /**
     * 渠道返回流水号。单笔交易渠道交易流水号（暂中信无返回此值）；批量交易渠道交易批次号。
     */
    @TableField(value = "channel_resp_id")
    private String channelRespId;

    @TableField(value = "channel_resp_msg")
    private String channelRespMsg;

    /**
     * 响应码
     */
    @TableField(value = "resp_code")
    private String respCode;

    /**
     * 返回错误
     */
    @TableField(value = "resp_exception")
    private String respException;

    /**
     * 返回信息
     */
    @TableField(value = "resp_message")
    private String respMessage;

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
     * 退款金额
     */
    @TableField(value = "refund_amount")
    private Long refundAmount;

    /**
     * 对账状态 0未对账 1已对账
     */
    @TableField(value = "reconcile_status")
    private String reconcileStatus;

    /**
     * 回调地址
     */
    @TableField(value = "trans_callback_url")
    private String transCallbackUrl;

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
     * 备注
     */
    @TableField(value = "description")
    private String description;

    /**
     * 批量交易时：该批次下的明细流水号
     */
    @TableField(value = "batch_sub_no")
    private String batchSubNo;

    /**
     * 货币类型
     */
    @TableField(value = "currency")
    private String currency;

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
     * 入网分配的用户名
     */
    @TableField(value = "user_code")
    private String userCode;

    /**
     * 企业入网时分配的企业账号
     */
    @TableField(value = "acc_no")
    private String accNo;

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
     * 平台编码/客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 清算分账Id
     */
    @TableField(value = "split_info_id")
    private Long splitInfoId;

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
     * 订单号
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
     * 摘要
     */
    @TableField(value = "summary_description")
    private String summaryDescription;

    /**
     * 是否移入历史表（1是,0否）
     */
    @TableField(value = "history_status")
    private String historyStatus;

    /**
     * 状态查询次数
     */
    @TableField(value = "query_time")
    private Integer queryTime;

    /**
     * 请求ip
     */
    @TableField(value = "remote_ip")
    private String remoteIp;

    /**
     * 余额支付类型：0-用户-客户平台 1-用户-用户
     */
    @TableField(value = "payment_type")
    private String paymentType;

    /**
     * 余额支付账期（对账日期=交易日+该账期）
     */
    @TableField(value = "payment_period")
    private Integer paymentPeriod;

    /**
     * 余额支付结算状态 0未结算 1已结算
     */
    @TableField(value = "payment_settle_status")
    private String paymentSettleStatus;

    public TransParamFailVo buildVo() {
        return new TransParamFailVo(id, channelKey, channelCode, channelName, merNo, clientTransId, clientTransTime, serverTransId, productCode, tradeType, orgCode, orgName, serverBatchNo, serverLinkId, transAmount, realAmount, transStatus, transDate, transTime, channelRespTime, channelRespCode, channelRespId, channelRespMsg, respCode, respException, respMessage, revokeStatus, refundStatus, refundAmount, reconcileStatus, transCallbackUrl, reconcileTime, reconcileDate, description, batchSubNo, currency, gmtCreate, gmtModified, userCreate, userModified, userCode, accNo, merFee, channelFee, pcFlag, userType, payeeAcctNo, payeeName, payerAcctNo, payerName, industryCode, splitInfoId, merSettleType, merChargeMode, channelSettleType, channelChargeMode, channelSettleDate, orginChannelFee, payerAccount, payeeAccount, feeAccount, incomeAccount, needChannelReconcile, showPayerAccountNo, showPayerAccountName, showPayeeAccountNo, showPayeeAccountName, orderId, elcMakeFlag, feeAccountName, incomeAccountName, payerOpbkName, payeeOpbkName, summaryDescription, historyStatus, queryTime, remoteIp, paymentType, paymentPeriod, paymentSettleStatus);
    }

    public static TransParamFail of(TransParamFailVo vo) {
        return new TransParamFail(vo.getId(), vo.getChannelKey(), vo.getChannelCode(), vo.getChannelName(), vo.getMerNo(), vo.getClientTransId(), vo.getClientTransTime(), vo.getServerTransId(), vo.getProductCode(), vo.getTradeType(), vo.getOrgCode(), vo.getOrgName(), vo.getServerBatchNo(), vo.getServerLinkId(), vo.getTransAmount(), vo.getRealAmount(), vo.getTransStatus(), vo.getTransDate(), vo.getTransTime(), vo.getChannelRespTime(), vo.getChannelRespCode(), vo.getChannelRespId(), vo.getChannelRespMsg(), vo.getRespCode(), vo.getRespException(), vo.getRespMessage(), vo.getRevokeStatus(), vo.getRefundStatus(), vo.getRefundAmount(), vo.getReconcileStatus(), vo.getTransCallbackUrl(), vo.getReconcileTime(), vo.getReconcileDate(), vo.getDescription(), vo.getBatchSubNo(), vo.getCurrency(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getUserCode(), vo.getAccNo(), vo.getMerFee(), vo.getChannelFee(), vo.getPcFlag(), vo.getUserType(), vo.getPayeeAcctNo(), vo.getPayeeName(), vo.getPayerAcctNo(), vo.getPayerName(), vo.getIndustryCode(), vo.getSplitInfoId(), vo.getMerSettleType(), vo.getMerChargeMode(), vo.getChannelSettleType(), vo.getChannelChargeMode(), vo.getChannelSettleDate(), vo.getOrginChannelFee(), vo.getPayerAccount(), vo.getPayeeAccount(), vo.getFeeAccount(), vo.getIncomeAccount(), vo.getNeedChannelReconcile(), vo.getShowPayerAccountNo(), vo.getShowPayerAccountName(), vo.getShowPayeeAccountNo(), vo.getShowPayeeAccountName(), vo.getOrderId(), vo.getElcMakeFlag(), vo.getFeeAccountName(), vo.getIncomeAccountName(), vo.getPayerOpbkName(), vo.getPayeeOpbkName(), vo.getSummaryDescription(), vo.getHistoryStatus(), vo.getQueryTime(), vo.getRemoteIp(), vo.getPaymentType(), vo.getPaymentPeriod(), vo.getPaymentSettleStatus());
    }
}