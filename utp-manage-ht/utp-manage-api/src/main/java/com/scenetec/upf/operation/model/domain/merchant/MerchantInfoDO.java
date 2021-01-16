package com.scenetec.upf.operation.model.domain.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import com.scenetec.upf.operation.model.domain.country.CountryDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/08/01
 */
@ApiModel(description = "商户基本信息表")
@Data
public class MerchantInfoDO {

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
    private Date gmtCreate;

    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;

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

//    @ApiModelProperty(value = "居民类型")
//    private String residentType;

//    @ApiModelProperty(value = "银行卡列表")
//    private List<MerchantAccountInfoDO> merList;
//
//    @ApiModelProperty(value = "国籍列表")
//    private List<CountryDO> countryList;
//
//    @ApiModelProperty(value = "职业列表")
//    private List<CodeDictionaryDO> codeDictionaryList;

    @ApiModelProperty(value = "归属对象类型")
    private String objType;

    @ApiModelProperty(value = "银行客户号")
    private String bankClientNo;

}