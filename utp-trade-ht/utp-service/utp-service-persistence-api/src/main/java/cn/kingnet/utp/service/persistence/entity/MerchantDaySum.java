package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.MerchantDaySumVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_merchant_day_sum")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.MerchantDaySumMapper")
public class MerchantDaySum extends BaseEntity {
    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 对账日期
     */
    @TableField(value = "reconcile_date")
    private String reconcileDate;

    /**
     * 机构编号
     */
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 商户号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 交易日期
     */
    @TableField(value = "trans_date")
    private String transDate;

    @TableField(value = "product_code")
    private String productCode;

    /**
     * 交易类型
     */
    @TableField(value = "trade_type")
    private String tradeType;

    /**
     * 交易总笔数
     */
    @TableField(value = "total_count")
    private Long totalCount;

    /**
     * 交易总金额(分)
     */
    @TableField(value = "total_amount")
    private Long totalAmount;

    /**
     * 总手续费（分）
     */
    @TableField(value = "total_fee")
    private Long totalFee;

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

    public MerchantDaySumVo buildVo() {
        return new MerchantDaySumVo(id, reconcileDate, orgCode, merNo, transDate, productCode, tradeType, totalCount, totalAmount, totalFee, gmtCreate, gmtModified, userCreate, userModified);
    }

    public static MerchantDaySum of(MerchantDaySumVo vo) {
        return new MerchantDaySum(vo.getId(), vo.getReconcileDate(), vo.getOrgCode(), vo.getMerNo(), vo.getTransDate(), vo.getProductCode(), vo.getTradeType(), vo.getTotalCount(), vo.getTotalAmount(), vo.getTotalFee(), vo.getGmtCreate(), vo.getGmtModified(), vo.getUserCreate(), vo.getUserModified());
    }
}