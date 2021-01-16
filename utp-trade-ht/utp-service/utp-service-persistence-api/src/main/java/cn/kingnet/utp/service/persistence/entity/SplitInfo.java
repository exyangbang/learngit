package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.SplitInfoVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_split_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.SplitInfoMapper")
public class SplitInfo extends BaseEntity {
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
     * 商户号
     */
    @TableField(value = "mer_no")
    private String merNo;

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
     * 账户类型		M	0-对私 1-对公
     */
    @TableField(value = "account_type")
    private String accountType;

    /**
     * 收款人账号		M
     */
    @TableField(value = "account_no")
    private String accountNo;

    /**
     * 收款人名称	M
     */
    @TableField(value = "account_name")
    private String accountName;

    /**
     * 收款人清算行行号		M	
     */
    @TableField(value = "bank_code")
    private String bankCode;

    /**
     * 备注说明
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 扩展字段1
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
     * 虚账户分账入账状态（0-未入账 1-已入账）
     */
    @TableField(value = "status")
    private String status;

    /**
     * 文件提供商
     */
    @TableField(value = "provider_code")
    private String providerCode;

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
     * 分账主体0-个人 1商户
     */
    @TableField(value = "subject")
    private String subject;

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

    public SplitInfoVo buildVo() {
        return new SplitInfoVo(id, userCreate, gmtCreate, userModified, gmtModified, settleDate, merNo, amount, period, splitDate, accountType, accountNo, accountName, bankCode, remark, extend1, extend2, extend3, status, providerCode, batchId, transDate, serverTransId, clientTransId, transStatus, queryTimes, transDesc, subject, reconcileDate, userAccount, settleMode, industryCode);
    }

    public static SplitInfo of(SplitInfoVo vo) {
        return new SplitInfo(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getSettleDate(), vo.getMerNo(), vo.getAmount(), vo.getPeriod(), vo.getSplitDate(), vo.getAccountType(), vo.getAccountNo(), vo.getAccountName(), vo.getBankCode(), vo.getRemark(), vo.getExtend1(), vo.getExtend2(), vo.getExtend3(), vo.getStatus(), vo.getProviderCode(), vo.getBatchId(), vo.getTransDate(), vo.getServerTransId(), vo.getClientTransId(), vo.getTransStatus(), vo.getQueryTimes(), vo.getTransDesc(), vo.getSubject(), vo.getReconcileDate(), vo.getUserAccount(), vo.getSettleMode(), vo.getIndustryCode());
    }
}