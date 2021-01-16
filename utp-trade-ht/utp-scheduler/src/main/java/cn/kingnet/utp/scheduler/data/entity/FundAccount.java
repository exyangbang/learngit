package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.scheduler.data.entity.vo.FundAccountVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_fund_account")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.FundAccountMapper")
public class FundAccount extends BaseEntity {
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
     * 资金账户编号
     */
    @TableField(value = "account_num")
    private String accountNum;

    /**
     * 清算行行号
     */
    @TableField(value = "bank_code")
    private String bankCode;

    /**
     * 状态（0-不可用 1-可用）
     */
    @TableField(value = "status")
    private String status;

    /**
     * 华通客户账号|内部户账号
     */
    @TableField(value = "bank_account_no")
    private String bankAccountNo;

    /**
     * 华通客户账号名称|内部户名称
     */
    @TableField(value = "bank_account_name")
    private String bankAccountName;

    /**
     * 最新同步时间
     */
    @TableField(value = "synchronization_time")
    private Date synchronizationTime;

    /**
     * 当前余额
     */
    @TableField(value = "current_balance")
    private Long currentBalance;

    /**
     * 1:内部户，2:一般户
     */
    @TableField(value = "account_type")
    private String accountType;

    /**
     * 使用类型(0-普通用途 1-归集用途)
     */
    @TableField(value = "use_type")
    private String useType;

    /**
     * 是否与其他系统共享实体账户0=否 1=是
     */
    @TableField(value = "share_flag")
    private String shareFlag;

    public FundAccountVo buildVo() {
        return new FundAccountVo(id, userCreate, gmtCreate, userModified, gmtModified, accountNum, bankCode, status, bankAccountNo, bankAccountName, synchronizationTime, currentBalance, accountType, useType, shareFlag);
    }

    public static FundAccount of(FundAccountVo vo) {
        return new FundAccount(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getAccountNum(), vo.getBankCode(), vo.getStatus(), vo.getBankAccountNo(), vo.getBankAccountName(), vo.getSynchronizationTime(), vo.getCurrentBalance(), vo.getAccountType(), vo.getUseType(), vo.getShareFlag());
    }
}