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
public class TransReexchangeVo implements java.io.Serializable {
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
     * 交易状态
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
     * 对账状态 0未对账 1已对账
     */
    private String reconcileStatus;

    /**
     * 对账时间
     */
    private Date reconcileTime;

    /**
     * 对账日
     */
    private String reconcileDate;

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
     * 渠道清算日期
     */
    private String channelSettleDate;

    /**
     * 处理状态 0未处理 1已处理
     */
    private String solveStatus;

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
}