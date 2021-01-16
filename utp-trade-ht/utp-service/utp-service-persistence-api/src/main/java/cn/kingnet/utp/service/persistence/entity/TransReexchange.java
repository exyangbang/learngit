package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.TransReexchangeVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_trans_reexchange")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.TransReexchangeMapper")
public class TransReexchange extends BaseEntity {
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
     * 交易状态
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
     * 对账状态 0未对账 1已对账
     */
    @TableField(value = "reconcile_status")
    private String reconcileStatus;

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
     * 渠道清算日期
     */
    @TableField(value = "channel_settle_date")
    private String channelSettleDate;

    /**
     * 处理状态 0未处理 1已处理
     */
    @TableField(value = "solve_status")
    private String solveStatus;

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

    public TransReexchangeVo buildVo() {
        return new TransReexchangeVo(id, channelKey, channelCode, channelName, merNo, clientTransId, clientTransTime, serverTransId, productCode, tradeType, orgCode, orgName, serverBatchNo, serverLinkId, transAmount, realAmount, transStatus, transDate, transTime, reconcileStatus, reconcileTime, reconcileDate, payeeAcctNo, payeeName, payerAcctNo, payerName, industryCode, channelSettleDate, solveStatus, gmtCreate, gmtModified, userCreate, userModified);
    }

    public static TransReexchange of(TransReexchangeVo vo) {
        return new TransReexchange(vo.getId(), vo.getChannelKey(), vo.getChannelCode(), vo.getChannelName(), vo.getMerNo(), vo.getClientTransId(), vo.getClientTransTime(), vo.getServerTransId(), vo.getProductCode(), vo.getTradeType(), vo.getOrgCode(), vo.getOrgName(), vo.getServerBatchNo(), vo.getServerLinkId(), vo.getTransAmount(), vo.getRealAmount(), vo.getTransStatus(), vo.getTransDate(), vo.getTransTime(), vo.getReconcileStatus(), vo.getReconcileTime(), vo.getReconcileDate(), vo.getPayeeAcctNo(), vo.getPayeeName(), vo.getPayerAcctNo(), vo.getPayerName(), vo.getIndustryCode(), vo.getChannelSettleDate(), vo.getSolveStatus(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified());
    }
}