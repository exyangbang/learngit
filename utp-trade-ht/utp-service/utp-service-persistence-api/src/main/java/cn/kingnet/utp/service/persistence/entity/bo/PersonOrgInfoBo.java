package cn.kingnet.utp.service.persistence.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author WJH
 * @Date 2019/07/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonOrgInfoBo {

	/**
	 * 交易流水号 M
	 */
	private String clientTradeId;
	/**
	 * 请求日期 M
	 */
	private String reqDate;
	/**
	 * 请求时间 M
	 */
	private String reqTime;
	/**
	 * 0个人 1企业 M  userType
	 */
	private String type;
	/**
	 * 1个人证件号   2企业营业执照号 M
	 */
	private String code;
	/**
	 * 证件有效期yyyyMMdd 个人设置merchantInfo.id_indate 企业设置：accountInfo.business_indate营业执照有效期
	 */
	private String idIndate;
	/**
	 * 客户名称	STRING(200)	O
	 * 姓名	开户必输 个人姓名：企业则企业名称
	 */
	private String realName;
	/**
	 * 联系信息	STRING(85)	Y
	 * 开户必输 移动电话 M
	 */
	private String telephone;
	/**
	 * type=1
	 * 出生日期	DATE	O	yyyyMMdd（开户必输） 暂无
	 */
	private String birthDt;
	/**
	 * 国籍代码 STRING(20)	O	开户必输 取值 country
	 */
	private String countryTpCd;
	/**
	 * type=1
	 * M男 F女  在渠道层会被转换成 1：男 2：女 0 ：未知
	 * 性别	STRING(20)	O	开户必输 取值 sex
	 */
	private String genderTpCd;
	/**
	 * type=1
	 * 职业	STRING(20)	O	开户必输 取值prosession
	 */
	private String occupationTpCd;
	/**
	 * 详细地址	STRING(200)	Y	开户必输 取值address
	 */
	private String address;
	/**
	 * type=2
	 * 行业类型	STRING(20)	O 取值prosession
	 */
	private String industryTpCd;
	/**
	 * type=2
	 * 经营范围	STRING(1000)	Y
	 */
	private String businessScope;
	/**
	 * type=2
	 * 注册资金 单位元 CNY
	 */
	private String registerAmt;
	/**
	 * 证件类型：取值IdType枚举类 个人身份证 企业统一社会信用代码
	 */
	private String idType;
	/**
	 * 居民类型 居民类型 0非居民 1居民
	 */
	private String residentType;

	//====企业时选填========
	/**
	 * 上市类型
	 */
	private String listedTpCd;
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
	 * 联系地址
	 */
	private String contactAddress;
	/**
	 * 营业执照生效日期 yyyyMMdd
	 */
	private String businessStartdate;
	/**
	 * 法人证件生效日期 yyyyMMdd
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
