package cn.kingnet.utp.scheduler.data.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FeeIncomeAccountMonthCollectionVo implements java.io.Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 统计月份yyyyMM
     */
    private String statMonth;

    /**
     * 手续费收益账户月统计表主键id
     */
    private Long feeStatId;

    /**
     * 交易流水表（当前或者历史）主键id
     */
    private Long transId;
}