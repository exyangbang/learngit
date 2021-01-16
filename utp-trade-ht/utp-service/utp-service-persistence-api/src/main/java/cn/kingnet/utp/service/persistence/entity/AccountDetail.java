package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.AccountDetailVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_account_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.AccountDetailMapper")
public class AccountDetail extends BaseEntity {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 虚拟账户（关联账户表）
     */
    @TableField(value = "account")
    private String account;

    /**
     * 操作类型 01 入金 02 冻结 03 解冻 04 出金 
     */
    @TableField(value = "operate_type")
    private String operateType;

    /**
     * 子操作类型：1打款 2代付 3转账 4手续费 5退款 6退汇
     */
    @TableField(value = "operate_sub_type")
    private String operateSubType;

    /**
     * 金额
     */
    @TableField(value = "amount")
    private Long amount;

    /**
     * 操作前余额
     */
    @TableField(value = "before_balance")
    private Long beforeBalance;

    /**
     * 操作后余额
     */
    @TableField(value = "after_balance")
    private Long afterBalance;

    /**
     * 记录时间
     */
    @TableField(value = "record_time")
    private Date recordTime;

    /**
     * 账户明细序号
     */
    @TableField(value = "seq_no")
    private Long seqNo;

    /**
     * 操作变动备注说明
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 对方账户
     */
    @TableField(value = "peer_acc_no")
    private String peerAccNo;

    /**
     * 服务端交易流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    /**
     * 对方账户名称
     */
    @TableField(value = "outside_order_id")
    private String outsideOrderId;

    /**
     * 对方账户名称
     */
    @TableField(value = "peer_acc_name")
    private String peerAccName;

    public AccountDetailVo buildVo() {
        return new AccountDetailVo(id, account, operateType, operateSubType, amount, beforeBalance, afterBalance, recordTime, seqNo, remark, peerAccNo, serverTransId, outsideOrderId, peerAccName);
    }

    public static AccountDetail of(AccountDetailVo vo) {
        return new AccountDetail(vo.getId(), vo.getAccount(), vo.getOperateType(), vo.getOperateSubType(), vo.getAmount(), vo.getBeforeBalance(), vo.getAfterBalance(), vo.getRecordTime(), vo.getSeqNo(), vo.getRemark(), vo.getPeerAccNo(), vo.getServerTransId(), vo.getOutsideOrderId(), vo.getPeerAccName());
    }
}