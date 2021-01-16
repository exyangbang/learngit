package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.*;

import java.io.Serializable;

/**
 * @Description : 渠道配置信息
 * @Author : linkaigui
 * @Create : 2019/2/25 17:43
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChannelInfoBO implements Serializable {

    /**
     * 渠道信息主键Id
     */
    private String channelInfoId;
    /**
     * 渠道标识
     */
    private String channelKey;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 状态
     */
    private String status;

    /**
     * 企业账户
     */
    private String accNo;

    /**
     * 渠道限制总额度
     */
    private Long channelLimitAmount;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 平台手续费模板Id
     */
    private Long indFeeTemplateId;

    /**
     * 渠道手续费模板Id
     */
    private Long chnFeeTemplateId;

    /**
     * 对公手续费模板Id
     */
    private Long publicFeeTemplateId;

    /**
     * 对私手续费模板Id
     */
    private Long privateFeeTemplateId;

    /**
     * 置顶操作
     */
    private Long roofPlacement;
    /**
     * 银联渠道时:渠道商户号必填
     */
    private String channelMerNo;
    /**
     * 银联渠道时：渠道商户名称
     */
    private String channelMerName;
    /**
     * 银联渠道时：渠道商户简称
     */
    private String channelMerShortName;
    /**
     * 银联渠道时：渠道商户类别
     */
    private String channelMerCategory;
    /**
     * 银联渠道时：渠道资金来源
     */
    private String channelCapitalSource;



}
