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
public class IndustryVo implements java.io.Serializable {
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
    private String code;

    /**
     * 省代码
     */
    private String provinceCode;

    /**
     * 市代码
     */
    private String cityCode;

    /**
     * 县代码
     */
    private String countyCode;

    /**
     * 虚拟账户
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
     * 状态（0-不可用 1-可用）
     */
    private String status;

    /**
     * 华通客户号
     */
    private String custNumber;

    /**
     * 华通客户账号
     */
    private String custAccountNo;

    /**
     * 华通客户账号名称
     */
    private String custAccountName;

    /**
     * 入金通知 URL
     */
    private String innerNoticeUrl;

    /**
     * 选择手续费支出账户 id
     */
    private Long feeExpenditureAccount;

    /**
     * 手续费收益账户 id
     */
    private Long processingFeeIncomeAccount;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 1:平台|行业账户,4-手续费收入账户 5-手续费支出账户 6-归集账户 10-小额打款支出账户
     */
    private String industryType;

    /**
     * 1对外,0不对外 二级账户是否对外接款
     */
    private String whetherExternal;

    /**
     * 资金账户
     */
    private String fundAccount;

    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     */
    private String auditStatus;

    /**
     * 归集账户id
     */
    private Long collectionIndustryId;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 注册地址
     */
    private String regAddress;

    /**
     * 营业执照号
     */
    private String busLicCode;

    /**
     * 个人/法人证件类型 101 身份证，102 护照  103 军官证
     */
    private String idType;

    /**
     * 个人/法人证件号
     */
    private String idCode;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 开通业务（“1分账业务”、“2代付业务”）
     */
    private String businessType;

    /**
     * 存储DN信息中统一社会信用代码
     */
    private String dn;

    /**
     * 法人名称
     */
    private String legalPerson;

    /**
     * 最大佣金比例 支持百分之0.001
     */
    private Long maxBrokerageRate;

    /**
     * 客户国籍
     */
    private String nationality;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 客户行业
     */
    private String customerTrade;

    /**
     * 控股股东或实际控制人证明文件类型
     */
    private String fileType;

    /**
     * 控股股东或实际控制人其他证明文件类型
     */
    private String otherFileType;

    /**
     * 控股股东或实际控制人证明文件号码
     */
    private String fileNum;

    /**
     * 余额支付账期，“T0”、“T1”，默认值“T1”
     */
    private String balancePayPeriod;

    /**
     * 是否开通双账户 1-是、2-否，默认值 否
     */
    private String isOpneDoubleAcc;

    /**
     * 是否开通余额支付功能 1-是、2-否，默认值 否
     */
    private String isOpneBalancePay;

    /**
     * 鉴权方式 3-三要素认证、4-四要素认证，默认值 四要素认证
     */
    private String authenticationMode;

    /**
     * 是否需要对公打款验证 0否 1是
     */
    private String needPublicAuthAmt;

    /**
     * 是否支持bind多张卡 0否 1是
     */
    private String ableBindMultiCard;

    /**
     * 小额打款支出账户 id
     */
    private Long authPaymentAccountId;

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
     * 二级账户最大开立数量 默认值2
     */
    private Integer subAccountOpenMax;

    /**
     * 生成对账文件模式 0=T+1日普通对账方式 1=D+1日特殊对账方式
     */
    private Integer reconciliationMode;

    /**
     * 是否允许下载子账户日终余额对账单 标志 0=否 1=是
     */
    private Integer ableDownloadDailyBalance;

    /**
     * 开户模式 0-鉴权绑卡时上传图片资料(旧) 1-开户时上传图片资料(新)
     */
    private Integer openAccountMode;

    /**
     * 0=“根据来款账户上账”、1=“无限制的来款上账”
     */
    private Integer industryIncomeType;

    /**
     * 是否支持自定义显示付款账号及户名 0否 1是
     */
    private Integer openShowCustomFlag;

    /**
     * 营业执照图片
     */
    private String busLicPic;

    /**
     * 法人证件正面图片
     */
    private String personPic;

    /**
     * 法人证件反面图片
     */
    private String personReversePic;

    /**
     * 开户许可证（Base64字符串 <200k）
     */
    private String licensePic;
}