package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.FeeTemplateVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_fee_template")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.FeeTemplateMapper")
public class FeeTemplate extends BaseEntity {
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
     * 模板名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 结算类型
     */
    @TableField(value = "settle_type")
    private String settleType;

    /**
     * 收费模式
     */
    @TableField(value = "charge_mode")
    private String chargeMode;

    /**
     * 计算方式
     */
    @TableField(value = "calculate_mode")
    private String calculateMode;

    /**
     * 手续费
     */
    @TableField(value = "fee")
    private Long fee;

    /**
     * 最小手续费
     */
    @TableField(value = "min_fee")
    private Long minFee;

    /**
     * 最大手续费
     */
    @TableField(value = "max_fee")
    private Long maxFee;

    /**
     * 区间内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    private String remark;

    public FeeTemplateVo buildVo() {
        return new FeeTemplateVo(id, userCreate, gmtCreate, userModified, gmtModified, name, settleType, chargeMode, calculateMode, fee, minFee, maxFee, content, remark);
    }

    public static FeeTemplate of(FeeTemplateVo vo) {
        return new FeeTemplate(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getName(), vo.getSettleType(), vo.getChargeMode(), vo.getCalculateMode(), vo.getFee(), vo.getMinFee(), vo.getMaxFee(), vo.getContent(), vo.getRemark());
    }
}