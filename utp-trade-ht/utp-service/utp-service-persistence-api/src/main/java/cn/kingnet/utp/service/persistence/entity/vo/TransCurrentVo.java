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
public class TransCurrentVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 渠道标识
     */
    private String channelKey;

    /**
     * 渠道编号
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 商户编号\个人身份证号
     */
    private String merNo;

    /**
     * 客户请求流水号
     */
    private String clientTransId;

    /**
     * 客户请求时间(yyyyMMddHHmmss)
     */
    private String clientTransTime;

    /**
     * 服务端流水号
     */
    private String serverTransId;

    /**
     * 产品类型/编码
     */
    private String productCode;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 服务端批处理号
     */
    private String serverBatchNo;

    /**
     * 关联流水id
     */
    private String serverLinkId;

    /**
     * 交易金额(分)
     */
    private Long transAmount;

    /**
     * 实际发生金额(分)
     */
    private Long realAmount;

    /**
     * 交易状态，成功：TRADE_SUCCESS、失败：TRADE_FAILURE、处理中：PROCESSING
     */
    private String transStatus;

    /**
     * 交易日期(yyyyMMdd)
     */
    private String transDate;

    /**
     * 交易时间(HHmmss)
     */
    private String transTime;

    /**
     * 渠道返回时间
     */
    private String channelRespTime;

    /**
     * 渠道返回代码
     */
    private String channelRespCode;

    /**
     * 渠道返回流水号。单笔交易渠道交易流水号（暂中信无返回此值）；批量交易渠道交易批次号。
     */
    private String channelRespId;

    private String channelRespMsg;

    /**
     * 响应码
     */
    private String respCode;

    /**
     * 返回错误
     */
    private String respException;

    /**
     * 返回信息
     */
    private String respMessage;

    /**
     * 撤销状态0-未撤销 1-已撤销
     */
    private String revokeStatus;

    /**
     * 退货状态0-未退货 1-部分退货 2-已全部退货
     */
    private String refundStatus;

    /**
     * 退款金额
     */
    private Long refundAmount;

    /**
     * 对账状态 0未对账 1已对账
     */
    private String reconcileStatus;

    /**
     * 回调地址
     */
    private String transCallbackUrl;

    /**
     * 对账时间
     */
    private Date reconcileTime;

    /**
     * 对账日
     */
    private String reconcileDate;

    /**
     * 备注
     */
    private String description;

    /**
     * 批量交易时：该批次下的明细流水号
     */
    private String batchSubNo;

    /**
     * 货币类型
     */
    private String currency;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 更新用户
     */
    private String userModified;

    /**
     * 入网分配的用户名
     */
    private String userCode;

    /**
     * 企业入网时分配的企业账号
     */
    private String accNo;

    /**
     * 用户手续费
     */
    private Long merFee;

    /**
     * 渠道手续费
     */
    private Long channelFee;

    /**
     * 对公对私标志
     */
    private String pcFlag;

    /**
     * 客户类型
     */
    private String userType;

    /**
     * 收款人账号
     */
    private String payeeAcctNo;

    /**
     * 收款人名称
     */
    private String payeeName;

    /**
     * 付款人账号
     */
    private String payerAcctNo;

    /**
     * 付款人名称
     */
    private String payerName;

    /**
     * 平台编码/客户号
     */
    private String industryCode;

    /**
     * 清算分账Id
     */
    private Long splitInfoId;

    /**
     * 商户结算类型(1-实时,2-后结)
     */
    private String merSettleType;

    /**
     * 商户收费模式(1-内扣,2-外扣)
     */
    private String merChargeMode;

    /**
     * 渠道结算类型(1-实时,2-后结)
     */
    private String channelSettleType;

    /**
     * 渠道收费模式(1-内扣,2-外扣)
     */
    private String channelChargeMode;

    /**
     * 渠道清算日期
     */
    private String channelSettleDate;

    /**
     * 原渠道手续费
     */
    private Long orginChannelFee;

    /**
     * 付款虚拟账户
     */
    private String payerAccount;

    /**
     * 收款虚拟账户
     */
    private String payeeAccount;

    /**
     * 手续费虚拟账户
     */
    private String feeAccount;

    /**
     * 收益虚拟账户
     */
    private String incomeAccount;

    /**
     * 是否要求渠道对账 0否 1是
     */
    private String needChannelReconcile;

    /**
     * 展示付款帐号
     */
    private String showPayerAccountNo;

    /**
     * 展示付款帐号名称
     */
    private String showPayerAccountName;

    /**
     * 展示收款帐号
     */
    private String showPayeeAccountNo;

    /**
     * 展示收款帐号名称
     */
    private String showPayeeAccountName;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 电子回单生成标识0未生成 1已生成
     */
    private String elcMakeFlag;

    /**
     * 手续费支出账户名称
     */
    private String feeAccountName;

    /**
     * 手续费收益账户名称
     */
    private String incomeAccountName;

    /**
     * 付款人开户行行名
     */
    private String payerOpbkName;

    /**
     * 收款人开户行名
     */
    private String payeeOpbkName;

    /**
     * 摘要
     */
    private String summaryDescription;

    /**
     * 是否移入历史表（1是,0否）
     */
    private String historyStatus;

    /**
     * 状态查询次数
     */
    private Integer queryTime;

    /**
     * 请求ip
     */
    private String remoteIp;

    /**
     * 余额支付类型：0-用户-客户平台 1-用户-用户
     */
    private String paymentType;

    /**
     * 余额支付账期（对账日期=交易日+该账期）
     */
    private Integer paymentPeriod;

    /**
     * 余额支付结算状态 0未结算 1已结算
     */
    private String paymentSettleStatus;
}