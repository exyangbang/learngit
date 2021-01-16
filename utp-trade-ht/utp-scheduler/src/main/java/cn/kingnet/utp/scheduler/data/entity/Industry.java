package cn.kingnet.utp.scheduler.data.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import cn.kingnet.utp.scheduler.data.entity.vo.IndustryVo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_industry")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.scheduler.data.mapper.IndustryMapper")
public class Industry extends BaseEntity {
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
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 简称
     */
    @TableField(value = "simple_name")
    private String simpleName;

    /**
     * 行业代码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 省代码
     */
    @TableField(value = "province_code")
    private String provinceCode;

    /**
     * 市代码
     */
    @TableField(value = "city_code")
    private String cityCode;

    /**
     * 县代码
     */
    @TableField(value = "county_code")
    private String countyCode;

    /**
     * 虚拟账户
     */
    @TableField(value = "account")
    private String account;

    /**
     * 来款账户名称
     */
    @TableField(value = "account_name")
    private String accountName;

    /**
     * 来款银行名称
     */
    @TableField(value = "bank_name")
    private String bankName;

    /**
     * 来款银行行号
     */
    @TableField(value = "bank_code")
    private String bankCode;

    /**
     * 状态（0-不可用 1-可用）
     */
    @TableField(value = "status")
    private String status;

    /**
     * 华通客户号
     */
    @TableField(value = "cust_number")
    private String custNumber;

    /**
     * 华通客户账号
     */
    @TableField(value = "cust_account_no")
    private String custAccountNo;

    /**
     * 华通客户账号名称
     */
    @TableField(value = "cust_account_name")
    private String custAccountName;

    /**
     * 入金通知 URL
     */
    @TableField(value = "inner_notice_url")
    private String innerNoticeUrl;

    /**
     * 选择手续费支出账户 id
     */
    @TableField(value = "fee_expenditure_account")
    private Long feeExpenditureAccount;

    /**
     * 手续费收益账户 id
     */
    @TableField(value = "processing_fee_income_account")
    private Long processingFeeIncomeAccount;

    /**
     * 机构编码
     */
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 机构名称
     */
    @TableField(value = "org_name")
    private String orgName;

    /**
     * 1:平台|行业账户,4-手续费收入账户 5-手续费支出账户 6-归集账户 10-小额打款支出账户
     */
    @TableField(value = "industry_type")
    private String industryType;

    /**
     * 1对外,0不对外 二级账户是否对外接款
     */
    @TableField(value = "whether_external")
    private String whetherExternal;

    /**
     * 资金账户
     */
    @TableField(value = "fund_account")
    private String fundAccount;

    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     */
    @TableField(value = "audit_status")
    private String auditStatus;

    /**
     * 归集账户id
     */
    @TableField(value = "collection_industry_id")
    private Long collectionIndustryId;

    /**
     * 企业名称
     */
    @TableField(value = "ent_name")
    private String entName;

    /**
     * 注册地址
     */
    @TableField(value = "reg_address")
    private String regAddress;

    /**
     * 营业执照号
     */
    @TableField(value = "bus_lic_code")
    private String busLicCode;

    /**
     * 个人/法人证件类型 101 身份证，102 护照  103 军官证
     */
    @TableField(value = "id_type")
    private String idType;

    /**
     * 个人/法人证件号
     */
    @TableField(value = "id_code")
    private String idCode;

    /**
     * 账号
     */
    @TableField(value = "account_no")
    private String accountNo;

    /**
     * 开通业务（“1分账业务”、“2代付业务”）
     */
    @TableField(value = "business_type")
    private String businessType;

    /**
     * 存储DN信息中统一社会信用代码
     */
    @TableField(value = "dn")
    private String dn;

    /**
     * 法人名称
     */
    @TableField(value = "legal_person")
    private String legalPerson;

    /**
     * 最大佣金比例 支持百分之0.001
     */
    @TableField(value = "max_brokerage_rate")
    private Long maxBrokerageRate;

    /**
     * 客户国籍
     */
    @TableField(value = "nationality")
    private String nationality;

    /**
     * 联系人电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 客户行业
     */
    @TableField(value = "customer_trade")
    private String customerTrade;

    /**
     * 控股股东或实际控制人证明文件类型
     */
    @TableField(value = "file_type")
    private String fileType;

    /**
     * 控股股东或实际控制人其他证明文件类型
     */
    @TableField(value = "other_file_type")
    private String otherFileType;

    /**
     * 控股股东或实际控制人证明文件号码
     */
    @TableField(value = "file_num")
    private String fileNum;

    /**
     * 余额支付账期，“T0”、“T1”，默认值“T1”
     */
    @TableField(value = "balance_pay_period")
    private String balancePayPeriod;

    /**
     * 是否开通双账户 1-是、2-否，默认值 否
     */
    @TableField(value = "is_opne_double_acc")
    private String isOpneDoubleAcc;

    /**
     * 是否开通余额支付功能 1-是、2-否，默认值 否
     */
    @TableField(value = "is_opne_balance_pay")
    private String isOpneBalancePay;

    /**
     * 鉴权方式 3-三要素认证、4-四要素认证，默认值 四要素认证
     */
    @TableField(value = "authentication_mode")
    private String authenticationMode;

    /**
     * 是否需要对公打款验证 0否 1是
     */
    @TableField(value = "need_public_auth_amt")
    private String needPublicAuthAmt;

    /**
     * 是否支持bind多张卡 0否 1是
     */
    @TableField(value = "able_bind_multi_card")
    private String ableBindMultiCard;

    /**
     * 小额打款支出账户 id
     */
    @TableField(value = "auth_payment_account_id")
    private Long authPaymentAccountId;

    /**
     * 是否开通子账户单笔付款功能 1-是、0-否
     */
    @TableField(value = "open_sub_single_pay")
    private String openSubSinglePay;

    /**
     * 是否校验收款人开通虚户标志 1-是、0-否
     */
    @TableField(value = "verify_payee_account_sign")
    private String verifyPayeeAccountSign;

    /**
     * 是否校验收款人白名单标志 1-是、0-否
     */
    @TableField(value = "verify_payee_white_list_sign")
    private String verifyPayeeWhiteListSign;

    /**
     * 付款子账户类型 2.企业账户、3.个人账户、8.个体工商户账户
     */
    @TableField(value = "payer_sub_type")
    private String payerSubType;

    /**
     * 二级账户入金类型1：仅同名账户二级账户入金 2：无账户限制二级账户入金 3：仅白名单账户二级账户入金
     */
    @TableField(value = "sub_income_type")
    private Integer subIncomeType;

    /**
     * 是否支持支付流水初始化 0否 1是
     */
    @TableField(value = "able_trans_order_init")
    private Integer ableTransOrderInit;

    /**
     * 二级账户最大开立数量 默认值2
     */
    @TableField(value = "sub_account_open_max")
    private Integer subAccountOpenMax;

    /**
     * 生成对账文件模式 0=T+1日普通对账方式 1=D+1日特殊对账方式
     */
    @TableField(value = "reconciliation_mode")
    private Integer reconciliationMode;

    /**
     * 是否允许下载子账户日终余额对账单 标志 0=否 1=是
     */
    @TableField(value = "able_download_daily_balance")
    private Integer ableDownloadDailyBalance;

    /**
     * 营业执照图片
     */
    @TableField(value = "bus_lic_pic")
    private String busLicPic;

    /**
     * 法人证件正面图片
     */
    @TableField(value = "person_pic")
    private String personPic;

    /**
     * 法人证件反面图片
     */
    @TableField(value = "person_reverse_pic")
    private String personReversePic;

    /**
     * 开户许可证（Base64字符串 <200k）
     */
    @TableField(value = "license_pic")
    private String licensePic;

    public IndustryVo buildVo() {
        return new IndustryVo(id, userCreate, gmtCreate, userModified, gmtModified, name, simpleName, code, provinceCode, cityCode, countyCode, account, accountName, bankName, bankCode, status, custNumber, custAccountNo, custAccountName, innerNoticeUrl, feeExpenditureAccount, processingFeeIncomeAccount, orgCode, orgName, industryType, whetherExternal, fundAccount, auditStatus, collectionIndustryId, entName, regAddress, busLicCode, idType, idCode, accountNo, businessType, dn, legalPerson, maxBrokerageRate, nationality, phone, customerTrade, fileType, otherFileType, fileNum, balancePayPeriod, isOpneDoubleAcc, isOpneBalancePay, authenticationMode, needPublicAuthAmt, ableBindMultiCard, authPaymentAccountId, openSubSinglePay, verifyPayeeAccountSign, verifyPayeeWhiteListSign, payerSubType, subIncomeType, ableTransOrderInit, subAccountOpenMax, reconciliationMode, ableDownloadDailyBalance, busLicPic, personPic, personReversePic, licensePic);
    }

    public static Industry of(IndustryVo vo) {
        return new Industry(vo.getId(), vo.getUserCreate(), vo.getGmtCreate(), vo.getUserModified(), vo.getGmtModified(), vo.getName(), vo.getSimpleName(), vo.getCode(), vo.getProvinceCode(), vo.getCityCode(), vo.getCountyCode(), vo.getAccount(), vo.getAccountName(), vo.getBankName(), vo.getBankCode(), vo.getStatus(), vo.getCustNumber(), vo.getCustAccountNo(), vo.getCustAccountName(), vo.getInnerNoticeUrl(), vo.getFeeExpenditureAccount(), vo.getProcessingFeeIncomeAccount(), vo.getOrgCode(), vo.getOrgName(), vo.getIndustryType(), vo.getWhetherExternal(), vo.getFundAccount(), vo.getAuditStatus(), vo.getCollectionIndustryId(), vo.getEntName(), vo.getRegAddress(), vo.getBusLicCode(), vo.getIdType(), vo.getIdCode(), vo.getAccountNo(), vo.getBusinessType(), vo.getDn(), vo.getLegalPerson(), vo.getMaxBrokerageRate(), vo.getNationality(), vo.getPhone(), vo.getCustomerTrade(), vo.getFileType(), vo.getOtherFileType(), vo.getFileNum(), vo.getBalancePayPeriod(), vo.getIsOpneDoubleAcc(), vo.getIsOpneBalancePay(), vo.getAuthenticationMode(), vo.getNeedPublicAuthAmt(), vo.getAbleBindMultiCard(), vo.getAuthPaymentAccountId(), vo.getOpenSubSinglePay(), vo.getVerifyPayeeAccountSign(), vo.getVerifyPayeeWhiteListSign(), vo.getPayerSubType(), vo.getSubIncomeType(), vo.getAbleTransOrderInit(), vo.getSubAccountOpenMax(), vo.getReconciliationMode(), vo.getAbleDownloadDailyBalance(), vo.getBusLicPic(), vo.getPersonPic(), vo.getPersonReversePic(), vo.getLicensePic());
    }
}
