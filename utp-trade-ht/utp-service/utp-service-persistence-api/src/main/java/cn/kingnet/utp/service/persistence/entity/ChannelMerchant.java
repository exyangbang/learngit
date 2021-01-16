package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.ChannelMerchantVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_channel_merchant")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.ChannelMerchantMapper")
public class ChannelMerchant extends BaseEntity {
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
     * 渠道代码
     */
    @TableField(value = "channel_code")
    private String channelCode;

    /**
     * 支付产品编码
     */
    @TableField(value = "product_no")
    private String productNo;

    /**
     * 商户号
     */
    @TableField(value = "mer_no")
    private String merNo;

    /**
     * 商户手续费模板Id
     */
    @TableField(value = "mer_fee_template_id")
    private Long merFeeTemplateId;

    /**
     * 渠道手续费模板Id
     */
    @TableField(value = "chn_fee_template_id")
    private Long chnFeeTemplateId;

    public ChannelMerchantVo buildVo() {
        return new ChannelMerchantVo(id, userCreate, gmtCreate, userModified, gmtModified, channelCode, productNo, merNo, merFeeTemplateId, chnFeeTemplateId);
    }

    public static ChannelMerchant of(ChannelMerchantVo vo) {
        return new ChannelMerchant(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getChannelCode(), vo.getProductNo(), vo.getMerNo(), vo.getMerFeeTemplateId(), vo.getChnFeeTemplateId());
    }
}