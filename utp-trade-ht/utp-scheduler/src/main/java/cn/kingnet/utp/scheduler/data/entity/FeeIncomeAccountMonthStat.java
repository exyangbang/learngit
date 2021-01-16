package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.scheduler.data.entity.vo.FeeIncomeAccountMonthStatVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_fee_income_account_month_stat")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.FeeIncomeAccountMonthStatMapper")
public class FeeIncomeAccountMonthStat extends BaseEntity {
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
     * 手续费收益账户号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 手续费收益账户名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 归集划款状态 0未划转 1已划转
     */
    @TableField(value = "collection_status")
    private String collectionStatus;

    /**
     * 入金金额（单位分）
     */
    @TableField(value = "income_amount")
    private Long incomeAmount;

    /**
     * 出金金额（单位分）
     */
    @TableField(value = "outcome_amount")
    private Long outcomeAmount;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 更新用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 备注说明
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 交易状态
     */
    @TableField(value = "trans_status")
    private String transStatus;

    /**
     * 交易状态描述
     */
    @TableField(value = "trans_desc")
    private String transDesc;

    /**
     * 服务端流水号
     */
    @TableField(value = "server_trans_id")
    private String serverTransId;

    public FeeIncomeAccountMonthStatVo buildVo() {
        return new FeeIncomeAccountMonthStatVo(id, statMonth, account, name, collectionStatus, incomeAmount, outcomeAmount, gmtCreate, gmtModified, userCreate, userModified, remark, transStatus, transDesc, serverTransId);
    }

    public static FeeIncomeAccountMonthStat of(FeeIncomeAccountMonthStatVo vo) {
        return new FeeIncomeAccountMonthStat(vo.getId(), vo.getStatMonth(), vo.getAccount(), vo.getName(), vo.getCollectionStatus(), vo.getIncomeAmount(), vo.getOutcomeAmount(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified(), vo.getRemark(), vo.getTransStatus(), vo.getTransDesc(), vo.getServerTransId());
    }
}