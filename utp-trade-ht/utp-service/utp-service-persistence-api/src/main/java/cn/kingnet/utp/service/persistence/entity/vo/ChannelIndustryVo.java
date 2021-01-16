package cn.kingnet.utp.service.persistence.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChannelIndustryVo implements java.io.Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建用户
     */
    private String userCreate;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改用户
     */
    private String userModified;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 渠道代码
     */
    private String channelCode;

    /**
     * 支付产品编码
     */
    private String productNo;

    /**
     * 平台号
     */
    private String industryCode;

    /**
     * 平台手续费模板Id
     */
    private Long indFeeTemplateId;

    /**
     * 渠道手续费模板Id
     */
    private Long chnFeeTemplateId;

    /**
     * 置顶操作
     */
    private Long roofPlacement;

    /**
     * 渠道商户号
     */
    private String channelMerNo;

    /**
     * 渠道标识
     */
    private String channelKey;

    /**
     * 对公手续费模板Id
     */
    private Long publicFeeTemplateId;

    /**
     * 对私手续费模板Id
     */
    private Long privateFeeTemplateId;

    /**
     * 渠道商户名称
     */
    private String channelMerName;

    /**
     * 渠道商户简称
     */
    private String channelMerShortName;

    /**
     * 渠道商户类别
     */
    private String channelMerCategory;

    /**
     * 渠道资金来源
     */
    private String channelCapitalSource;
}
