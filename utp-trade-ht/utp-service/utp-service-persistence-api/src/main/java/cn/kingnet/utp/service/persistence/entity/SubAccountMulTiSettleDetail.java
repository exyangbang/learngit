package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.SubAccountMulTiSettleDetailVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_upload_subaccount_multi_settle_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.SubAccountMulTiSettleDetailMapper")
public class SubAccountMulTiSettleDetail extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 发起交易客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 请求日期yyyyMMdd
     */
    @TableField(value = "req_date")
    private String reqDate;

    /**
     * 请求时间HHmmss
     */
    @TableField(value = "req_time")
    private String reqTime;

    /**
     * 分账出金子账户文件外
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 1结算 2退款 3撤销
     */
    @TableField(value = "type")
    private String type;

    /**
     * 批次Id
     */
    @TableField(value = "batch_no")
    private String batchNo;

    /**
     * 批次内序号
     */
    @TableField(value = "seq_no")
    private Integer seqNo;

    /**
     * 清算日期 格式为yyyyMMdd
     */
    @TableField(value = "settle_date")
    private String settleDate;

    /**
     * 客户端交易流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 结算转出子账户
     */
    @TableField(value = "payer_sub_account")
    private String payerSubAccount;

    /**
     * 结算转入子账户
     */
    @TableField(value = "payee_sub_account")
    private String payeeSubAccount;

    /**
     * 金额		M	单位:分   无小数点
     */
    @TableField(value = "amount")
    private Long amount;

    /**
     * 结算方式0=代付结算 1=记账结算
     */
    @TableField(value = "settle_mode")
    private String settleMode;

    /**
     * M	数字， 例如： 1 表示账期为 T+1
     */
    @TableField(value = "period")
    private Integer period;

    /**
     * 入账日期 格式yyyyMMdd(清算日期+实际账期天数)
     */
    @TableField(value = "split_date")
    private String splitDate;

    /**
     * 备注说明
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 扩展字段2
     */
    @TableField(value = "extend_2")
    private String extend2;

    /**
     * 扩展字段3
     */
    @TableField(value = "extend_3")
    private String extend3;

    /**
     * 虚账户分账入账状态（0-未入账 1-已入账）
     */
    @TableField(value = "status")
    private String status;

    /**
     * 交易日期yyyyMMdd
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 交易时间HHmmss
     */
    @TableField(value = "trans_time")
    private String transTime;

    /**
     * 服务端交易流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 交易状态|同交易表状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 结算结果查询次数
     */
    @TableField(value = "query_times")
    private Integer queryTimes;

    /**
     * 结算结果描述
     */
    @TableField(value = "trans_desc")
    private String transDesc;

    /**
     * 结算主体0-个人 1商户
     */
    @TableField(value = "subject")
    private String subject;

    /**
     * 清算对账日
     */
    @TableField(value = "reconcile_date")
    private String reconcileDate;

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
     * 关联支付订单流水表中的trans_order_id 多个用逗号隔开
     */
    @TableField(value = "trans_order_ids")
    private String transOrderIds;

    public SubAccountMulTiSettleDetailVo buildVo() {
        return new SubAccountMulTiSettleDetailVo(id, industryCode, reqDate, reqTime, userAccount, type, batchNo, seqNo, settleDate, clientTransId, payerSubAccount, payeeSubAccount, amount, settleMode, period, splitDate, remark, extend2, extend3, status, transDate, transTime, serverTransId, transStatus, queryTimes, transDesc, subject, reconcileDate, userCreate, gmtCreate, userModified, gmtModified, transOrderIds);
    }

    public static SubAccountMulTiSettleDetail of(SubAccountMulTiSettleDetailVo vo) {
        return new SubAccountMulTiSettleDetail(vo.getId(), vo.getIndustryCode(), vo.getReqDate(), vo.getReqTime(), vo.getUserAccount(), vo.getType(), vo.getBatchNo(), vo.getSeqNo(), vo.getSettleDate(), vo.getClientTransId(), vo.getPayerSubAccount(), vo.getPayeeSubAccount(), vo.getAmount(), vo.getSettleMode(), vo.getPeriod(), vo.getSplitDate(), vo.getRemark(), vo.getExtend2(), vo.getExtend3(), vo.getStatus(), vo.getTransDate(), vo.getTransTime(), vo.getServerTransId(), vo.getTransStatus(), vo.getQueryTimes(), vo.getTransDesc(), vo.getSubject(), vo.getReconcileDate(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getTransOrderIds());
    }
}
