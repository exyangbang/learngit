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
public class ChannelInfoVo implements java.io.Serializable {
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
     * 支付产品编码
     */
    private String productNo;

    /**
     * 渠道额度
     */
    private Long amount;

    /**
     * 接入类型
     */
    private String joinType;

    /**
     * 请求前台地址
     */
    private String frontUrl;

    /**
     * 请求后台地址
     */
    private String backUrl;

    /**
     * trid参数
     */
    private String trid;

    /**
     * trtp参数
     */
    private String trtp;

    /**
     * 机构号
     */
    private String orgCode;

    /**
     * 渠道手续费模板Id
     */
    private Long chnFeeTemplateId;

    /**
     * 状态
     */
    private String status;

    /**
     * 企业账户
     */
    private String accNo;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 渠道额度
     */
    private Long channelQuota;

    /**
     * 渠道商户号
     */
    private String channelMerNo;

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