package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description : 建立企业客户信息:如下必填
 * 企业名称、营业执照号码、手机号码、注册地址、注册资本、经营范围、法人姓名、法人证件类型、法人身份证号码、
 * 法人身份证有效期、客户经理、企业类型、企业规模、企业经济性质、居民类型、国籍、行业、营业执照有效期
 * @Author : WJH
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankAddOrgReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 交易流水号
     */
    @NotNull
    private String clientTradeId;

    /**
     * 请求日期
     */
    @NotNull
    private String reqDate;

    /**
     * 请求时间
     */
    @NotNull
    private String reqTime;

    /**
     * 证件类型 101 身份证，102 护照  103 军官证  企业类型必须为218=社会统一信用号
     */
    @NotNull
    private String idType;
    /**
     * 企业营业执照即社会统一信用号
     */
    @NotNull
    private String busLicCode;
    /**
     * 证件有效期yyyyMMdd
     */
    private String idIndate;
    /**
     * 客户名称	STRING(200)	O 企业名称	开户必输
     */
    private String ent_name;

    /**
     * 联系信息	STRING(85)	Y	开户必输 移动电话
     */
    private String telephone;
    /**
     * 国籍代码 STRING(20)	O	开户必输 取值 country
     */
    private String countryTpCd;

    /**
     * 行业类型	STRING(20)	O 取值prosession
     */
    private String industryTpCd;

    /**
     * 详细地址	STRING(200)	Y	开户必输 取值address
     */
    private String address;
    /**
     * 经营范围	STRING(1000)	Y
     */
    private String businessScope;
    /**
     * 注册资金 单位元 CNY
     */
    private String registerAmt;

    /**
     * 法人名称
     */
    private String legalName;
    /**
     * 法人证件类型
     */
    private String legalIdType;
    /**
     * 法人证件号码
     */
    private String legalIdCode;
    /**
     * 法人证件有效期 yyyyMMdd
     */
    private String legalIdindate;

    /**
     * 法人手机号码：merchantInfo.mobile
     */
    private String legalMobile;

    /**
     * 所属客户经理
     */
    private String customerManager;
    /**
     * 企业类型
     */
    private String orgTpCd;

    /**
     * 行内：企业规模
     */
    private String spdbScaleTpCd;

    /**
     * 企业经营性质：即经济类型 [原后管OwnershipTpCd存储的值是EconomicTpCd,后管后期需要修正]
     */
    private String economicTpCd;

    /**
     * 上市类型
     */
    private String listedTpCd;

    /**
     * 居民类型 0非居民 1居民
     */
    private String residentTpCd;

    /**
     * 企业联系地址
     */
    private String contactAddress;
    /**
     * 营业执照生效日期
     */
    private String businessStartdate;
    /**
     * 法人证件生效日期
     */
    private String legalStartdate;
    /**
     * 实际控制人证件生效日期
     */
    private String actualMasterIdStartDate;
    /**
     * 授权代理人证件生效日期
     */
    private String authProxyIdStartDate;
    /**
     * 受益所有人1姓名
     */
    private String ownerOneName;
    /**
     * 受益所有人1证件类型
     */
    private String ownerOneCerfileType;
    /**
     * 受益所有人1证件号
     */
    private String ownerOneCerfileNo;
    /**
     * 受益所有人1证件生效日期
     */
    private String ownerOneStartdate;
    /**
     * 受益所有人1证件失效日期
     */
    private String ownerOneIndate;
    /**
     * 受益所有人2姓名
     */
    private String ownerTwoName;
    /**
     * 受益所有人2证件类型
     */
    private String ownerTwoCerfileType;
    /**
     * 受益所有人2证件号
     */
    private String ownerTwoCerfileNo;
    /**
     * 受益所有人2证件生效日期
     */
    private String ownerTwoStartdate;
    /**
     * 受益所有人2证件失效日期
     */
    private String ownerTwoIndate;
    /**
     * 受益所有人3姓名
     */
    private String ownerThreeName;
    /**
     * 受益所有人3证件类型
     */
    private String ownerThreeCerfileType;
    /**
     * 受益所有人3证件号
     */
    private String ownerThreeCerfileNo;
    /**
     * 受益所有人3证件生效日期
     */
    private String ownerThreeStartdate;
    /**
     * 受益所有人3证件失效日期
     */
    private String ownerThreeIndate;
    /**
     * 受益所有人4姓名
     */
    private String ownerFourName;
    /**
     * 受益所有人4证件类型
     */
    private String ownerFourCerfileType;
    /**
     * 受益所有人4证件号
     */
    private String ownerFourCerfileNo;
    /**
     * 受益所有人4证件生效日期
     */
    private String ownerFourStartdate;
    /**
     * 受益所有人4证件失效日期
     */
    private String ownerFourIndate;
    /**
     * 注册地址省份
     */
    private String regProvince;

    /**
     * 注册地址市
     */
    private String regCity;

    /**
     * 注册地址区
     */
    private String regArea;

    /**
     * 联系地址省份
     */
    private String contactProvince;

    /**
     * 联系地址市
     */
    private String contactCity;

    /**
     * 联系地址区
     */
    private String contactArea;


    /**
     * 实际控制者名称
     */
    private String actualMasterName;
    /**
     * 实际控制者证件类型
     */
    private String actualMasterIdType;
    /**
     * 实际控制者证件号码
     */
    private String actualMasterIdCode;
    /**
     * 实际控制者证件有效期
     */
    private String actualMasterIdindate;



    /**
     * 授权代理人名称
     */
    private String authProxyName;
    /**
     * 授权代理人证件类型
     */
    private String authProxyIdType;
    /**
     * 授权代理人证件号码
     */
    private String authProxyIdCode;
    /**
     * 授权代理人证件有效期
     */
    private String authProxyIdindate;

}
