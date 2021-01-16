package com.scenetec.upf.operation.model.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 存量客户开的客户号默认为 1-其他渠道，后管针对 ECIF开户渠道 0自有渠道 1-其他渠道的相关记录都可以修改，
 * 1-其他渠道的修改完不同步至ECIF，0自有渠道修改完，对接ecif维护客户信息接口，同步至ECIF
 *
 * @Description 后管编辑用户|平台信息 涉及 银行客户号信息标识DTO
 * @Author WJH
 * @Date 2020/05/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BankClientAccountInfoDTO extends BaseInnerManageReqDTO {
    /**
     * 客户端请求Id
     */
    private String clientTransId;
    /**
     * 虚账户表主键ID
     */
    private String accountId;
    /**
     * 虚账号
     */
    private String account;
    /**
     * 账户类型（userType）：0个人 1企业
     * 取值：merchantInfo.userType 若为平台客户则取值都是1企业
     */
    private String userType;
    /**
     * 关联的银行客户号
     */
    private String bankClientNo;
    /**
     * yyyyMMdd
     **/
    private String reqDate;
    /**
     * HHmmss
     **/
    private String reqTime;


    @Override
    public String[] toSHA1() {
        return new String[]{
                "appid=".concat(appid),
                "secret=".concat(secret),
                "clientTransId=".concat(clientTransId),
                "reqDate=".concat(reqDate),
                "reqDate=".concat(reqDate),
                "reqTime=".concat(reqTime),
                "accountId=".concat(accountId),
                "account=".concat(account),
                "userType=".concat(userType),
                "bankClientNo=".concat(bankClientNo),
        };
    }

    /**
     * ecif个人账户
     */
    private PersonAccount personAccount;
    /**
     * ecif企业账户
     */
    private OrganizationAccount organizationAccount;

    @Data
    public static class PersonAccount implements Serializable {
        // 个人账户：居民类型、性别、国籍、职业、住所/工作地址、证件有效期、个人证件正面图片、个人证件反面图片
        // 佣金账户|待结算账户 跟userType区分
        /**
         * 居民类型：0非居民 1居民
         */
        private String cdResidentTp;

        /**
         * 性别	STRING(20)	O	开户必输 取值 sex
         */
        private String genderTpCd;

        /**
         * 国籍代码 STRING(20)	O	开户必输 取值 country
         */
        private String countryTpCd;

        /**
         * 职业	STRING(20)	O	开户必输 取值prosession
         */
        private String occupationTpCd;

        /**
         * 详细地址	STRING(200)	Y	开户必输 取值address
         */
        private String address;
        /**
         * 证件有效期yyyyMMdd
         */
        private String idIndate;
        /**
         * 证件类型 101 身份证，102 护照  103 军官证  企业类型必须为218=社会统一信用号
         */
        private String idType;
        /**
         *身份证号码
         */
        private String idCode;
    }

    @Data
    public static class OrganizationAccount implements Serializable {
        /**
         * 证件类型 101 身份证，102 护照  103 军官证  企业类型必须为218=社会统一信用号
         */
        private String idType;
        /**
         * 企业营业执照即社会统一信用号
         */
        private String busLicCode;
        /**
         * 企业名称
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
         * 企业经营性质：企业性质
         */
        private String ownershipTpCd;

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
         * 居民类型
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

    }


}



