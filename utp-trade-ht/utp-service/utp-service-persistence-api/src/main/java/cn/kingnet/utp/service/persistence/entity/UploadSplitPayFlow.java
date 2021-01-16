package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.UploadSplitPayFlowVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_upload_split_pay_flow")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.UploadSplitPayFlowMapper")
public class UploadSplitPayFlow extends BaseEntity {
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
     * 清算日期 格式为yyyyMMdd
     */
    @TableField(value = "settle_date")
    private String settleDate;

    /**
     * 金额		M	单位:分   无小数点
     */
    @TableField(value = "amount")
    private Long amount;

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
     * 关联支付订单号列表 trans_order_ids
     */
    @TableField(value = "extend_1")
    private String extend1;

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
     * 批次Id
     */
    @TableField(value = "batch_id")
    private String batchId;

    /**
     * 发起提现交易日期yyyyMMdd
     */
    @TableField(value = "trans_date")
    private String transDate;

    /**
     * 服务端交易流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 客户端交易流水号
     */
    @TableField(value = "client_trans_id")
    private String clientTransId;

    /**
     * 交易状态|同交易表状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 提现结果查询次数
     */
    @TableField(value = "query_times")
    private Integer queryTimes;

    /**
     * 提现结果描述
     */
    @TableField(value = "trans_desc")
    private String transDesc;

    /**
     * 华通清算对账日
     */
    @TableField(value = "reconcile_date")
    private String reconcileDate;

    /**
     * 用户账户
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 结算方式0=代付结算 1=记账结算
     */
    @TableField(value = "settle_mode")
    private String settleMode;

    /**
     * 代付客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 上送状态成功：SUCCESS | 失败：FAILURE
     */
    @TableField(value = "upload_status")
    private String uploadStatus;

    /**
     * 上送状态描述
     */
    @TableField(value = "upload_desc")
    private String uploadDesc;

    public UploadSplitPayFlowVo buildVo() {
        return new UploadSplitPayFlowVo(id, userCreate, gmtCreate, userModified, gmtModified, settleDate, amount, period, splitDate, remark, extend1, extend2, extend3, batchId, transDate, serverTransId, clientTransId, transStatus, queryTimes, transDesc, reconcileDate, userAccount, settleMode, industryCode, uploadStatus, uploadDesc);
    }

    public static UploadSplitPayFlow of(UploadSplitPayFlowVo vo) {
        return new UploadSplitPayFlow(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getSettleDate(), vo.getAmount(), vo.getPeriod(), vo.getSplitDate(), vo.getRemark(), vo.getExtend1(), vo.getExtend2(), vo.getExtend3(), vo.getBatchId(), vo.getTransDate(), vo.getServerTransId(), vo.getClientTransId(), vo.getTransStatus(), vo.getQueryTimes(), vo.getTransDesc(), vo.getReconcileDate(), vo.getUserAccount(), vo.getSettleMode(), vo.getIndustryCode(), vo.getUploadStatus(), vo.getUploadDesc());
    }
}