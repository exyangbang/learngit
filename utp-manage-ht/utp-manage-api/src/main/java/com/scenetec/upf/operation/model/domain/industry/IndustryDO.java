package com.scenetec.upf.operation.model.domain.industry;

import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Size;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@ApiModel(description = "行业管理")
@Data
public class IndustryDO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    @JsonIgnore
    private String userCreate;

    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
    private Date gmtCreate;

    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    @JsonIgnore
    private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
    private Date gmtModified;

    /**
     * 名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 简称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "简称")
    private String simpleName;

    /**
     * 行业代码
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "行业代码")
    private String code;

    /**
     * 省代码
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "省代码")
    private String provinceCode;

    /**
     * 市代码
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "市代码")
    private String cityCode;

    /**
     * 县代码
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "县代码")
    private String countyCode;

    /**
     * 来款账户
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "来款账户")
    private String account;

    /**
     * 来款账户名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "来款账户名称")
    private String accountName;

    /**
     * 来款银行名称
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "来款银行名称")
    private String bankName;

    /**
     * 来款银行行号
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "来款银行行号")
    private String bankCode;

    /**
     * 状态
     * mysqlType: varchar(10)
     */
    @ApiModelProperty(value = "状态")
    private String status;

    /**
     * 客户号
     * mysqlType: varchar(12)
     */
    @ApiModelProperty(value = "客户号")
    private String custNumber;

    /**
     * 客户账户
     * mysqlType: varchar(40)
     */
    @ApiModelProperty(value = "客户账户")
    private String custAccountNo;

    /**
     * 客户账户
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "客户账号名称")
    private String custAccountName;

    @ApiModelProperty(value = "证书id")
    private String certId;

    @ApiModelProperty(value = "入金通知 URL")
    private String innerNoticeUrl;

    @ApiModelProperty(value = "选择手续费支出账户")
    private Long feeExpenditureAccount;

    @ApiModelProperty(value = "手续费收益账户")
    private Long processingFeeIncomeAccount;

    @ApiModelProperty(value = "选择手续费支出账户名称")
    private String feeExpenditureAccountName;

    @ApiModelProperty(value = "手续费收益账户名称")
    private String processingFeeIncomeAccountName;
    /**
     * 机构号
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "机构号")
    private String orgCode;

    /**
     * 机构名称
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    /**
     * 1:渠道商户(行业),4-手续费收入账户 5-手续费支出账户
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "1:渠道商户(行业),4-手续费收入账户 5-手续费支出账户")
    private String industryType;
    /**
     * 二级账户是否对外接款（必填，下拉框，“是”、“否”）
     * mysqlType: bigint(20)
     */
    @ApiModelProperty(value = "1对外,0不对外")
    private String whetherExternal;

    /**
     * 资金账户
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "资金账户")
    private String fundAccount;

    /**
     * 手续费支出账户选择是否是自己 -1是自己，1是其他
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "选择是否是自己")
    private Long accountSelf;

    /**
     * 资金账号 提供给前端是使用
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "华通客户账号|内部户账号")
    private String bankAccountNo;

    /**
     * 户名 提供给前端是使用
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "华通客户账号名称|内部户名称")
    private String bankAccountName;

    @ApiModelProperty(value = "状态（0-待审核 1-审核通过 2-审核驳回）")
    private String auditStatus;

    @ApiModelProperty(value = "归集账户id")
    private Long collectionIndustryId;

    @ApiModelProperty(value = "归集账户名称")
    private String collectionAccountName;

    @ApiModelProperty(value = "企业名称")
    private String entName;


    /**
     * 注册地址
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "注册地址")
    private String regAddress;

    /**
     * 营业执照号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "营业执照号")
    private String busLicCode;

    /**
     * 法人证件类型
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "法人证件类型")
    private String idType;
    /**
     * 个人/法人证件号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "个人/法人证件号")
    private String idCode;


    /**
     * 营业执照图片（点击可以查看图片）
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "营业执照图片（点击可以查看图片）")
    private String busLicPic;

    /**
     * 法人证件图片正面（点击可以查看图片）
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "法人证件图片正面（点击可以查看图片）")
    private String personPic;

    /**
     * 法人证件图片反面（点击可以查看图片
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "法人证件图片反面（点击可以查看图片")
    private String personReversePic;

    @ApiModelProperty(value = "开户许可证")
    private String licensePic;

    @ApiModelProperty(value = "企业账号")
    private String accountNo;

    @ApiModelProperty(value = "开通业务（“1分账业务”、“2代付业务”）")
    private String businessType;

    @ApiModelProperty(value = "存储DN信息中统一社会信用代码")
    private String dn;

    @ApiModelProperty(value = "平台最大佣金比例")
    private Long maxBrokerageRate;
    @ApiModelProperty(value = "法人名称")
    private String legalPerson;

    @ApiModelProperty(value ="客户国籍")
    private String nationality;
    @ApiModelProperty(value ="联系人电话")
    private String phone;
    @ApiModelProperty(value = "客户行业")
    private String customerTrade;
    @ApiModelProperty(value = "控股股东或实际控制人证明文件类型")
    private String fileType;
    @ApiModelProperty(value ="控股股东或实际控制人其他证明文件类型")
    private String otherFileType;
    @ApiModelProperty(value = "控股股东或实际控制人证明文件号码")
    private String fileNum;

    @ApiModelProperty(value = "余额支付账期")
    private String balancePayPeriod;

    @ApiModelProperty(value = "是否开通双账户")
    private String isOpneDoubleAcc;

    @ApiModelProperty(value = "是否开通余额支付功能")
    private String isOpneBalancePay;

    @ApiModelProperty(value = "鉴权方式")
    private String authenticationMode;


    @ApiModelProperty(value = "是否对公打款验证")
    private String needPublicAuthAmt;

    @ApiModelProperty(value = "是否支持绑定多张同名卡")
    private String ableBindMultiCard;

    @ApiModelProperty(value = "小额打款支出账户")
    private Long authPaymentAccountId;

    @ApiModelProperty(value = "是否开通子账户单笔付款功能")
    private String openSubSinglePay;

    @ApiModelProperty(value = "是否校验收款人开通虚户标志")
    private String verifyPayeeAccountSign;

    @ApiModelProperty(value = "是否校验收款人白名单标志")
    private String verifyPayeeWhiteListSign;

    @ApiModelProperty(value = "付款子账户类型")
    private String payerSubType;

    @ApiModelProperty(value = "二级账户入金类型1：仅同名账户二级账户入金 2：无账户限制二级账户入金 3：仅白名单账户二级账户入金")
    private Integer subIncomeType;

    @ApiModelProperty(value = "是否支持支付流水初始化 0否 1是")
    private Integer ableTransOrderInit;

    @ApiModelProperty(value = "二级账户最大开立数量 默认值0")
    private Integer subAccountOpenMax;

    @ApiModelProperty(value = "生成对账文件模式 0=T+1日普通对账方式 1=D+1日特殊对账方式")
    private Integer reconciliationMode;

    @ApiModelProperty(value = "是否允许下载子账户日终余额对账单 标志 0=否 1=是")
    private Integer ableDownloadDailyBalance;

    @ApiModelProperty(value = "开户模式 0-鉴权绑卡时上传图片资料(旧) 1-开户时上传图片资料(新)")
    private Integer openAccountMode;

    @ApiModelProperty(value = "0=根据来款账户上账 1=无限制的来款上账")
    private Integer industryIncomeType;

    @ApiModelProperty(value = "是否支持自定义显示付款账号及户名 0否 1是")
    private Integer openShowCustomFlag;
}