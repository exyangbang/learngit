package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.AccountSettleDetailVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_account_settle_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.AccountSettleDetailMapper")
public class AccountSettleDetail extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 清算日期 格式为yyyyMMdd
     */
    @TableField(value = "settle_date")
    private String settleDate;

    /**
     * 批次Id
     */
    @TableField(value = "batch_id")
    private String batchId;

    /**
     * 平台编码/客户号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 付款虚拟账户
     */
    @TableField(value = "payer_account")
    private String payerAccount;

    /**
     * 用户号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 用户虚拟账户
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 金额,单位:分 无小数点
     */
    @TableField(value = "amount")
    private Long amount;

    /**
     * 数字， 例如:1 表示账期为 T+1
     */
    @TableField(value = "period")
    private Integer period;

    /**
     * 账号
     */
    @TableField(value = "account_no")
    private String accountNo;

    /**
     * 展示付款账号
     */
    @TableField(value = "show_payer_acct_no")
    private String showPayerAcctNo;

    /**
     * 展示付款户名
     */
    @TableField(value = "show_payer_name")
    private String showPayerName;

    /**
     * 清算收款账号
     */
    @TableField(value = "payee_acct_no")
    private String payeeAcctNo;

    /**
     * 清算收款户名
     */
    @TableField(value = "payee_name")
    private String payeeName;

    /**
     * 清算行行号
     */
    @TableField(value = "payee_opbk")
    private String payeeOpbk;

    /**
     * 备注信息
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
     * 清算处理状态（0-未处理 1-已处理）
     */
    @TableField(value = "handle_status")
    private String handleStatus;

    /**
     * 是否计入提现（0-否 1-是）
     */
    @TableField(value = "provision_flag")
    private String provisionFlag;

    /**
     * 交易状态|同交易表状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 清算结果描述
     */
    @TableField(value = "trans_desc")
    private String transDesc;

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

    public AccountSettleDetailVo buildVo() {
        return new AccountSettleDetailVo(id, settleDate, batchId, industryCode, payerAccount, merNo, userAccount, amount, period, accountNo, showPayerAcctNo, showPayerName, payeeAcctNo, payeeName, payeeOpbk, remark, extend1, extend2, extend3, handleStatus, provisionFlag, transStatus, transDesc, channelKey, channelCode, channelName, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static AccountSettleDetail of(AccountSettleDetailVo vo) {
        return new AccountSettleDetail(vo.getId(), vo.getSettleDate(), vo.getBatchId(), vo.getIndustryCode(), vo.getPayerAccount(), vo.getMerNo(), vo.getUserAccount(), vo.getAmount(), vo.getPeriod(), vo.getAccountNo(), vo.getShowPayerAcctNo(), vo.getShowPayerName(), vo.getPayeeAcctNo(), vo.getPayeeName(), vo.getPayeeOpbk(), vo.getRemark(), vo.getExtend1(), vo.getExtend2(), vo.getExtend3(), vo.getHandleStatus(), vo.getProvisionFlag(), vo.getTransStatus(), vo.getTransDesc(), vo.getChannelKey(), vo.getChannelCode(), vo.getChannelName(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}