package cn.kingnet.utp.trade.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description : 基础配置信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/1 17:09
 */
@Data
public class BasicConfigInfo implements Serializable {

    /**
     * 产品编号
     */
    private String productNo;

    /**
     * 产品代码
     */
    private String productCode;

    /**》》》》》》》》》》》》》》》》》》行业信息 Industry》》》》》》》》》》》》》》》》》》》》》》*/
    /**
     * Industry表ID
     */
    private Long industryId;
    /**
     * 行业代码
     */
    private String industryCode;

    /**
     * 行业名称
     */
    private String industryName;

    /**
     * 行业简称
     */
    private String simpleName;

    /**
     * 代付客户企业名称
     */
    private String entName;

    /**
     * 帐号对应industry表的accountNo字段
     */
    private String industryAccountNo;

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
     * 资金账户类型：1内部户 2一般户
     */
    private String fundAccType;

    /**
     * 行业标识
     **/
    private String industryType;

    /**
     * 行业归属资金账户
     **/
    private String fundAccount;

    /**
     * 行业开通的虚拟账号
     **/
    private String industryAccount;

    /**
     * 行业开通业务（“1分账业务”、“2代付业务”）
     */
    private String businessType;

    /**
     * 入金通知
     **/
    private String innerNoticeUrl;

    /**
     * 手续费支出账户ID
     **/
    private Long feeExpenditureId;

    /**
     * 手续费支出虚拟账户
     */
    private String feeAccount;

    /**
     * 手续费支出虚拟账户名称
     */
    private String feeAccountName;

    /**
     * 手续费收益账户ID
     **/
    private Long feeIncomeId;

    /**
     * 手续费收益虚拟账户
     */
    private String feeIncomeAccount;
    /**
     * 手续费收益虚拟名称
     */
    private String feeIncomeAccountName;

    /**
     * 小额打款支出账户 id
     */
    private Long authPaymentAccountId;

    /**
     * 小额打款支出虚拟账户
     */
    private String authPaymentAccount;
    /**
     * 小额打款支出虚拟名称
     */
    private String authPaymentAccountName;

    /**
     * 客户号收取最高佣金比例 页面设值0.001%，库表存值0.001% * 1000 * 100
     */
    private Long maxBrokerageRate;
    /**
     * 客户号开通的佣金账户||分账业务才有需要开通
     */
    private String industryBrokerageAccount;

    /**
     * 所属收单机构代码
     */
    private String orgCode;

    /**
     * 所属收单机构名称
     */
    private String orgName;

    /**
     * 是否开通余额支付功能 1-是、2-否，默认值 否
     */
    private String isOpenBalancePay;
    /**
     * 余额支付账期，“T0”、“T1”，默认值“T1”
     */
    private String balancePayPeriod;

    /**
     * 是否开通双账户 1-是、2-否，默认值 否
     */
    private String isOpenDoubleAcc;

    /**
     * 是否需要对公打款验证 0否 1是
     */
    private String needPublicAuthAmt;

    /**
     * 是否支持bind多张卡 0否 1是
     */
    private String ableBindMultiCard;

    /**
     * 是否开通子账户单笔付款功能 1-是、0-否
     */
    private String openSubSinglePay;

    /**
     * 是否校验收款人开通虚户标志 1-是、0-否
     */
    private String verifyPayeeAccountSign;

    /**
     * 是否校验收款人白名单标志 1-是、0-否
     */
    private String verifyPayeeWhiteListSign;

    /**
     * 付款子账户类型 2.企业账户、3.个人账户、8.个体工商户账户
     */
    private String payerSubType;

    /**
     * 二级账户入金类型1：仅同名账户二级账户入金 2：无账户限制二级账户入金 3：仅白名单账户二级账户入金
     */
    private Integer subIncomeType;

    /**
     * 是否支持支付流水初始化 0否 1是
     */
    private Integer ableTransOrderInit;

    /**
     * 二级账户最大开立数量 默认值1
     */
    private Integer subAccountOpenMax;

    /**
     * 开户模式 0-鉴权绑卡时上传图片资料(旧) 1-开户时上传图片资料(新)
     */
    private Integer openAccountMode;

    public int getBalancePayPeriod4Int() {
        return "T0".equalsIgnoreCase(this.balancePayPeriod) ? 0 : 1;
    }

    /**
     * 生成对账文件模式 0=T+1日普通对账方式 1=D+1日特殊对账方式 默认0
     */
    private Integer reconciliationMode;
    /**
     * 是否允许下载子账户日终余额对账单 标志 0=否 1=是 默认0
     */
    private Integer ableDownloadDailyBalance;

    /**
     * 0=根据来款账户上账、1=无限制的来款上账
     */
    private Integer industryIncomeType;

    /**》》》》》》》》》》》》》》》》》》商户信息及用户账户信息表 MerchantInfo》》》》》》》》》》》》》》》》》》》》》》*/

    /**
     * 用户开户时客户端上送唯一标识：用户标识
     */
    private String merNo;

    /**
     * 用户开户时客户端上送：用户名称
     */
    private String merName;

    /**
     * 用户开户时客户端上送：用户简称
     */
    private String nameAbbreviation;

    /**
     * 用户开户时创建的 用户账户即虚拟账号
     **/
    private String userAccount;

    /**
     * 用户虚拟账户对应的资金账户
     */
    private String userFundAccount;

    /**
     * 用户账户特置手续费模板
     **/
    private Long userFeeTemplateId;

    /**
     * 用户类型 0-个人 1-企业
     */
    private String userType;

    /**
     * 用户状态 参考AccountStatus
     */
    private String userAccountStatus;

    /**
     * 账户状态（0-冻结 1-正常 2-销户） 参考 VirtualAccountStatus
     */
    private String accountStatus;

    /**
     * 用户审核状态0=待审核 1=已认证 2=审核驳回 9=待认证
     */
    private Integer userAuthStatus;

    /**
     * 用户账户归属的代付客户号
     */
    private String userIndustryCode;
    /**
     * 用户账户性质：merchantInfo.Nature 若merchantInfo.settleAccount==null?nature:'9'
     */
    private String userAccountNature;

    /**
     * 是否支持自定义显示付款账号及户名 0否 1是
     */
    private Integer openShowCustomFlag;
}
