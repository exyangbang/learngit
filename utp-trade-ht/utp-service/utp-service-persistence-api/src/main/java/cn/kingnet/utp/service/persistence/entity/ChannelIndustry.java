package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.service.persistence.entity.vo.ChannelIndustryVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_channel_industry")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.ChannelIndustryMapper")
public class ChannelIndustry extends BaseEntity {
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
     * 平台号
     */
    @TableField(value = "industry_code")
    private String industryCode;

    /**
     * 平台手续费模板Id
     */
    @TableField(value = "ind_fee_template_id")
    private Long indFeeTemplateId;

    /**
     * 渠道手续费模板Id
     */
    @TableField(value = "chn_fee_template_id")
    private Long chnFeeTemplateId;

    /**
     * 置顶操作
     */
    @TableField(value = "roof_placement")
    private Long roofPlacement;

    /**
     * 渠道商户号
     */
    @TableField(value = "channel_mer_no")
    private String channelMerNo;

    /**
     * 渠道标识
     */
    @TableField(value = "channel_key")
    private String channelKey;

    /**
     * 对公手续费模板Id
     */
    @TableField(value = "public_fee_template_id")
    private Long publicFeeTemplateId;

    /**
     * 对私手续费模板Id
     */
    @TableField(value = "private_fee_template_id")
    private Long privateFeeTemplateId;

    /**
     * 渠道商户名称
     */
    @TableField(value = "channel_mer_name")
    private String channelMerName;

    /**
     * 渠道商户简称
     */
    @TableField(value = "channel_mer_short_name")
    private String channelMerShortName;

    /**
     * 渠道商户类别
     */
    @TableField(value = "channel_mer_category")
    private String channelMerCategory;

    /**
     * 渠道资金来源
     */
    @TableField(value = "channel_capital_source")
    private String channelCapitalSource;

    public ChannelIndustryVo buildVo() {
        return new ChannelIndustryVo(id, userCreate, gmtCreate, userModified, gmtModified, channelCode, productNo, industryCode, indFeeTemplateId, chnFeeTemplateId, roofPlacement, channelMerNo, channelKey, publicFeeTemplateId, privateFeeTemplateId, channelMerName, channelMerShortName, channelMerCategory, channelCapitalSource);
    }

    public static ChannelIndustry of(ChannelIndustryVo vo) {
        return new ChannelIndustry(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getChannelCode(), vo.getProductNo(), vo.getIndustryCode(), vo.getIndFeeTemplateId(), vo.getChnFeeTemplateId(), vo.getRoofPlacement(), vo.getChannelMerNo(), vo.getChannelKey(), vo.getPublicFeeTemplateId(), vo.getPrivateFeeTemplateId(), vo.getChannelMerName(), vo.getChannelMerShortName(), vo.getChannelMerCategory(), vo.getChannelCapitalSource());
    }
}