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
public class AccountDetailVo implements java.io.Serializable {
    private Long id;

    /**
     * 虚拟账户（关联账户表）
     */
    private String account;

    /**
     * 操作类型 01 入金 02 冻结 03 解冻 04 出金 
     */
    private String operateType;

    /**
     * 子操作类型：1打款 2代付 3转账 4手续费 5退款 6退汇
     */
    private String operateSubType;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 操作前余额
     */
    private Long beforeBalance;

    /**
     * 操作后余额
     */
    private Long afterBalance;

    /**
     * 记录时间
     */
    private Date recordTime;

    /**
     * 账户明细序号
     */
    private Long seqNo;

    /**
     * 操作变动备注说明
     */
    private String remark;

    /**
     * 对方账户
     */
    private String peerAccNo;

    /**
     * 服务端交易流水号
     */
    private String serverTransId;

    /**
     * 对方账户名称
     */
    private String outsideOrderId;

    /**
     * 对方账户名称
     */
    private String peerAccName;
}