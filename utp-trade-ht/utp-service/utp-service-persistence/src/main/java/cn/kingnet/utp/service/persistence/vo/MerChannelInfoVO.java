package cn.kingnet.utp.service.persistence.vo;

import cn.kingnet.utp.service.persistence.entity.CertificateInfo;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2018年09月07日
 */
@Data
public class MerChannelInfoVO {

    /**
     *  商户号
     */
    private String merNo;
    /**
     * 商户名称
     */
    private String merName;
    /**
     * 机构编号
     */
    private String orgCode;
    /**
     * 机构名称
     */
    private String orgName;

    //-----往下渠道表获取--------------------------------

    /**
     * 渠道标识:字典定义
     */
    private String channelKey;
    /**
     * 渠道编码
     */
    private String channelCode;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 产品编号
     */
    private String productNo;
    /**
     * 企业账户：上游渠道方分配
     */
    private String accNo;
    /**
     * 用户标识|用户登录id，上游渠道方分配
     */
    private String userCode;
}
