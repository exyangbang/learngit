package cn.kingnet.utp.service.persistence.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description : 行业渠道信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/1 9:44
 */
@Data
public class IndustryChannelInfoVO implements Serializable {

    /**》》》》》》》》》》》》》》》》》》行业信息 Industry》》》》》》》》》》》》》》》》》》》》》》*/
    /**
     * 名称
     */
    private String name;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 行业代码
     */
    private String industryCode;

    /**
     * 来款账户
     */
    private String account;

    /**
     * 来款账户名称
     */
    private String accountName;

    /**
     * 来款银行名称
     */
    private String bankName;

    /**
     * 来款银行行号
     */
    private String bankCode;

    /**
     * 客户号
     */
    private String custNumber;

    /**
     * 客户账号
     */
    private String custAccountNo;

    /**
     * 客户账号名称
     */
    private String custAccountName;

    /**
     * 入金通知
     **/
    private String innerNoticeUrl;
    /**
     * 手续费支出账户Id
     **/
    private String feeExpenditureAccount;
    /**
     * 手续费收益账户Id
     **/
    private String processingFeeIncomeAccount;
    /**
     * 行业标识
     **/
    private String industryType;
    /**
     * 行业归属资金账户
     **/
    private String fundAccount;


    /**》》》》》》》》》》》》》》》》》》渠道信息 ChannelInfo》》》》》》》》》》》》》》》》》》》》》》*/

    /**
     * 渠道标识:字典定义
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
     * 企业账户：上游渠道方分配
     */
    private String accNo;

    /**
     * 用户标识|用户登录id，上游渠道方分配
     */
    private String userCode;
}
