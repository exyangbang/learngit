package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.scheduler.data.entity.vo.FeeIncomeAccountMonthCollectionVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_fee_income_account_month_collection")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.FeeIncomeAccountMonthCollectionMapper")
public class FeeIncomeAccountMonthCollection extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 统计月份yyyyMM
     */
    @TableField(value = "stat_month")
    private String statMonth;

    /**
     * 手续费收益账户月统计表主键id
     */
    @TableField(value = "fee_stat_id")
    private Long feeStatId;

    /**
     * 交易流水表（当前或者历史）主键id
     */
    @TableField(value = "trans_id")
    private Long transId;

    public FeeIncomeAccountMonthCollectionVo buildVo() {
        return new FeeIncomeAccountMonthCollectionVo(id, statMonth, feeStatId, transId);
    }

    public static FeeIncomeAccountMonthCollection of(FeeIncomeAccountMonthCollectionVo vo) {
        return new FeeIncomeAccountMonthCollection(vo.getId(), vo.getStatMonth(), vo.getFeeStatId(), vo.getTransId());
    }
}