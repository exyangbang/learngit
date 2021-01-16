package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : 更新企业客户信息
 * @Author : WJH
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class OneBankUpdateOrgReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 银行客户号
     */
    private String clientId;

    /**
     * 证件类型 101 身份证，102 护照  103 军官证  企业类型必须为218=社会统一信用号
     */
    private String idType;
    /**
     * 企业营业执照即社会统一信用号
     */
    private String busLicCode;
    /**
     * 客户名称	STRING(200)	O 企业名称	开户必输
     */
    private String entName;

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
     * 营业执照证件有效期yyyyMMdd
     */
    private String idIndate;
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
     * 国籍代码 STRING(20)	O	开户必输 取值 country
     */
    private String countryTpCd;

    /**
     * 行业类型	STRING(20)	O 取值prosession
     */
    private String industryTpCd;

    /**
     * 居民类型  居民类型 0非居民 1居民
     */
    private String residentTpCd;

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
     * 法人证件有效期
     */
    private String legalIdindate;


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
     * 负责人名称
     */
    private String principalName;
    /**
     * 负责人证件类型
     */
    private String principalIdType;
    /**
     * 负责人证件号码
     */
    private String principalIdCode;
    /**
     * 负责人证件有效期
     */
    private String principalIdindate;


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
    /**
     * 法人手机号码：merchantInfo.mobile
     */
    private String legalMobile;


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


}
