package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.AccountEntryDetailVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_account_entry_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.AccountEntryDetailMapper")
public class AccountEntryDetail extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 入账日期 格式为yyyyMMdd
     */
    @TableField(value = "entry_date")
    private String entryDate;

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
     * 账户类型 0-对私 1-对公
     */
    @TableField(value = "account_type")
    private String accountType;

    /**
     * 账号
     */
    @TableField(value = "account_no")
    private String accountNo;

    /**
     * 卡标记(0-不记名卡,1-记名卡)
     */
    @TableField(value = "card_flag")
    private String cardFlag;

    /**
     * 姓名
     */
    @TableField(value = "account_name")
    private String accountName;

    /**
     * 身份证号
     */
    @TableField(value = "cert_no")
    private String certNo;

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
     * 入账处理状态（0-未处理 1-已处理）
     */
    @TableField(value = "handle_status")
    private String handleStatus;

    /**
     * 交易状态|同交易表状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 入账结果描述
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

    public AccountEntryDetailVo buildVo() {
        return new AccountEntryDetailVo(id, entryDate, batchId, industryCode, payerAccount, merNo, userAccount, amount, period, accountType, accountNo, cardFlag, accountName, certNo, remark, extend1, extend2, extend3, handleStatus, transStatus, transDesc, channelKey, channelCode, channelName, userCreate, gmtCreate, userModified, gmtModified);
    }

    public static AccountEntryDetail of(AccountEntryDetailVo vo) {
        return new AccountEntryDetail(vo.getId(), vo.getEntryDate(), vo.getBatchId(), vo.getIndustryCode(), vo.getPayerAccount(), vo.getMerNo(), vo.getUserAccount(), vo.getAmount(), vo.getPeriod(), vo.getAccountType(), vo.getAccountNo(), vo.getCardFlag(), vo.getAccountName(), vo.getCertNo(), vo.getRemark(), vo.getExtend1(), vo.getExtend2(), vo.getExtend3(), vo.getHandleStatus(), vo.getTransStatus(), vo.getTransDesc(), vo.getChannelKey(), vo.getChannelCode(), vo.getChannelName(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified());
    }
}