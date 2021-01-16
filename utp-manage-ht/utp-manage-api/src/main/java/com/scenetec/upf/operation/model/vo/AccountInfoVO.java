package com.scenetec.upf.operation.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import com.scenetec.upf.operation.model.domain.country.CountryDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantAccountInfoDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/08/01
 */
@ApiModel(description = "基本信息表")
@Data
public class AccountInfoVO {

    @ApiModelProperty(value = "主键ID")
    private Long id;


    /**
     * 商户号
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "商户号")
    private String merNo;

    /**
     * 商户名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "商户名称")
    private String merName;

    /**
     * 商户简称
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "商户简称")
    private String nameAbbreviation;

    /**
     * 行政区划代码
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "行政区划代码")
    private String administrativeCode;

    /**
     * 所属收单机构代码
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "所属收单机构代码")
    private String orgCode;

    /**
     * 所属收单机构名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "所属收单机构名称")
    private String orgName;

    /**
     * 所属行业代码
     * mysqlType: varchar(64)
     */
    @ApiModelProperty(value = "所属行业代码")
    private String industryCode;

    /**
     * 所属行业名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "所属行业名称")
    private String industryName;

    /**
     * 商户账户类型
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "商户账户类型")
    private String accountType;

    /**
     * 账户
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "账户")
    private String accountNo;

    /**
     * 账户名称
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "账户名称")
    private String accountName;

    /**
     * 开户行行号
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "开户行行号")
    private String bankCode;

    /**
     * 开户行名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "开户行行号")
    private String bankName;
    /**
     * 所属省
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "所属省")
    private String provinceCode;

    /**
     * 所属市
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "所属市")
    private String cityCode;

    /**
     * 所属县
     * mysqlType: varchar(20)
     */
    @ApiModelProperty(value = "所属县")
    private String countyCode;

    /**
     * 注册地址
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "注册地址")
    private String regAddress;

    /**
     * 营业地址
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "营业地址")
    private String businessAddress;

    /**
     * 法人代表姓名
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "法人代表姓名")
    private String legalName;

    /**
     * 商户状态
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "商户状态")
    private String status;

    /**
     * 商户网站名称
     * mysqlType: varchar(300)
     */
    @ApiModelProperty(value = "商户网站名称")
    private String websiteName;

    /**
     * 支出商户号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "支出商户号")
    private String payMerchantNo;

    /**
     * 模板ID
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "模板ID")
    private String templateId;
    /**
     * 审核状态
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "审核状态0=待审核 1=已认证 2=审核驳回 9=待认证")
    private String authStatus;
    /**
     * 虚拟账号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "虚拟账号")
    private String account;
    /**
     * 企业名称
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "企业名称")
    private String entName;
    /**
     * 营业执照号
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "营业执照号")
    private String busLicCode;
    /**
     * 法人姓名
     * mysqlType: varchar(32)
     */
    @ApiModelProperty(value = "法人姓名")
    private String realName;
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


    @ApiModelProperty(value = "审核状态0=待审核 1=已认证 2=审核驳回 9=待认证")
    private Integer authtatus;

    @ApiModelProperty(value = "认证回调地址")
    private String authCallBack;

    @ApiModelProperty(value = "审核备注")
    private String authRemark;

    @ApiModelProperty(value = "性别（M男 F女）")
    private String sex;

    @ApiModelProperty(value = "国籍")
    private String country;

    @ApiModelProperty(value = "职业")
    private String prosession;
    private String prosessionName;

    @ApiModelProperty(value = "证件有效期（yyyy-MM-dd）")
    private String idIndate;

    @ApiModelProperty(value = "开户许可证")
    private String licensePic;

    @ApiModelProperty(value = "清算行号")
    private String receiveBankCode;

    @ApiModelProperty(value = "用户类型|0-个人 1-商户")
    private String userType;

    @ApiModelProperty(value = "手机号码")
    private String telephone;

    @ApiModelProperty(value = "待结算虚拟账户")
    private String settleAccount;

    @ApiModelProperty(value = "居民类型")
    private String residentType;

    @ApiModelProperty(value = "银行卡列表")
    private List<MerchantAccountInfoDO> merList;

    @ApiModelProperty(value = "国籍列表")
    private List<CountryDO> countryList;

    @ApiModelProperty(value = "职业列表")
    private List<CodeDictionaryDO> codeDictionaryList;

    @ApiModelProperty(value = "归属对象类型")
    private String objType;

    private String phone;
    /**
     * 经营范围
     */
    private String businessScope;
    /**
     * 企业注册资金
     */
    private String registerFund;
    /**
     * 法人姓名
     */
    private String legalPerson;
    /**
     * 法人证件有效期
     */
    private String legalIndate;
    /**
     * 控股股东或者实际控制人姓名
     */
    private String controlName;
    /**
     * 控股股东或者实际控制人证件类型
     */

    private String controlCerfileType;
    /**
     * 控股股东或者实际控制人证件号
     */
    private String controlCerfileNo;
    /**
     * 控股股东或者实际控制人证件有效期
     */
    private String controlIndate;
    /**
     * 负责人姓名
     */
    private String chargeName;
    /**
     * 负责人证件类型
     */
    private String chargeCerfileType;
    /**
     * 负责人证件号
     */
    private String chargeCerfileNo;
    /**
     * 负责人证件有效期（yyyy
     */
    private String chargeIndate;
    /**
     * 授权办理业务人员姓名
     */
    private String authBusName;
    /**
     * 授权办理业务人员证件类型
     */
    private String authBusType;
    /**
     * 授权办理业务人员证件号
     */
    private String authBusNo;
    /**
     * 授权办理业务人员证件有效期
     */
    private String authBusIndate;
    /**
     * 客户经理
     */
    private String customerManager;
    /**
     * 客户经理联系方式（固话或者手机号码）
     */
    private String customerManagerPhone;
    /**
     * 企业类型
     */
    private String enterpriseType;
    /**
     * 企业规模
     */
    private String enterpriseSale;

    /**
     * 上市类型
     */
    private String listingType;
    /**
     * 企业经济性质
     */
    private String enterpriseEcoNature;
    /**
     * 营业执照有效期
     */
    private String businessIndate;
    /**
     * 是否是个体工商户。待结算账户如果是个体工商户显示的和个人的不同，需要做区分
     */
    private String personBus;
}