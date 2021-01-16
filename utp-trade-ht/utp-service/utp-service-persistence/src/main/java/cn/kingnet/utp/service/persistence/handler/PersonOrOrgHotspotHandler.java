package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IPersonOrOrgHotspotHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.BankClientAccountBO;
import cn.kingnet.utp.service.persistence.entity.bo.PersonOrgInfoBo;
import cn.kingnet.utp.service.persistence.mapper.AccountMapper;
import cn.kingnet.utp.service.persistence.service.IndustryService;
import cn.kingnet.utp.service.persistence.service.MerchantInfoService;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Description : 个人/企业的客户热点信息关联服务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/11/05 10:00
 */
@RestController
@RequestMapping("/spi/persistence/personOrOrgHotspotHandler")
@Slf4j
public class PersonOrOrgHotspotHandler extends DefaultFeginExceptionHandler implements IPersonOrOrgHotspotHandler {

    @Resource
    private IndustryService industryService;
    @Resource
    private MerchantInfoService merchantInfoService;

    /**
     * 1 2 7（平台 企业 佣金户 视为ecif的企业类型）
     * account.status=1 and (
     * (objType=1 and industry.status=1) or (objType in(2,7) and merchantInfo.status in(2,3) and merchantInfo.authStatus=1)
     * ） 且如下13要素必选项
     * 要素不全的(企业名称、营业执照号码、手机号码、注册地址、注册资本、经营范围、法人姓名、法人证件类型、法人身份证号码、法人身份证有效期、客户经理、企业类型、企业规模、企业经济性质、居民类型、国籍、行业、营业执照有效期、营业执照图片法人身份证正反面三图)、
     * 冻结、销户、未审核的无论自动还是手工均不能上报ecif
     * <p>
     * 3 8（个人 个体工商 视为个人）
     * account.status=1 and objType in(3,8) and merchantInfo.status in(2,3)
     * 且如下必选项（个人9要素） 证件类型 证件号码 证件有效期 姓名 手机号码 国籍 性别 职业 详细地址
     */
    @Override
    public PersonOrgInfoBo getPersonOrOrgInfo(@RequestParam(value = "id") String id,
                                              @RequestParam(value = "account") String account,
                                              @RequestParam(value = "type") String type,
                                              @RequestParam(value = "code") String code,
                                              @RequestParam(value = "name") String name,
                                              @RequestParam(value = "fundAccount") String fundAccount) {


        Account acc = MybatisDaoImpl.run().selectOne(AccountCondition.builder().andIdEq(id).build());
        if (acc == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚拟账户不存在");
        }
        VirtualAccountStatus virtualAccountStatus = VirtualAccountStatus.resolve(acc.getStatus());
        if (virtualAccountStatus == null || virtualAccountStatus != VirtualAccountStatus.NORMAL) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("虚账户状态为[%s],暂无需上报", virtualAccountStatus == null ? null : virtualAccountStatus.getName()));
        }

        //校验账户信息
        if (!acc.getAccount().equals(account)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚拟账户号不匹配");
        }
        if (!acc.getObjType().equals(type)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "归属对象类型不匹配");
        }
        if (!acc.getObjCode().equals(code)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "归属对象编号不匹配");
        }
        if (!acc.getFundAccount().equals(fundAccount)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "资金账户不匹配");
        }
        if (!StringUtil.isEmpty(acc.getBankClientNo()) || acc.getBankClientStatus() > 0) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "银行客户号已关联");
        }

        PersonOrgInfoBo personOrgInfoBo = null;
        VirtualAccountType vAccountType = VirtualAccountType.resolve(acc.getObjType());

        //证件类型：个人取merchantInfo.IdType  企业|商户 默认IdType.218 社会统一信用代码
        switch (vAccountType) {
            case INDUSTRY: {
                //平台账户，默认为企业
                personOrgInfoBo = industryInfoBuild(account);
            }
            break;
            case MERCHANT: {
                //企业商户
                personOrgInfoBo = orgInfoBuild(account,null);
            }
            break;
            case PERSON:
            case SELFEMPLOYED: {
                //个人 || 个体工商
                personOrgInfoBo = personInfoBuild(account, null);
            }
            break;
            case BROKERAGE: {
                // 拥金账户，需要判断个人或者企业
                MerchantInfo merchantInfo = getMerchantInfo(acc.getAccount());
                if (UserType.ONE.getType().equals(merchantInfo.getUserType())) {
                    //个人
                    personOrgInfoBo = personInfoBuild(account, merchantInfo);
                } else if (UserType.MER.getType().equals(merchantInfo.getUserType())) {
                    //企业
                    personOrgInfoBo = orgInfoBuild(account, merchantInfo);
                }
                break;
            }
            default: {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("暂不支持的虚拟账户类型[%s]", acc.getObjType()));
            }
        }
        return personOrgInfoBo;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBankClientNo(@RequestParam(value = "account") String account,
                                 @RequestParam(value = "bankClientNo") String bankClientNo,
                                 @RequestParam(value = "isSelfChannel") boolean isSelfChannel
    ) {
        int bankClientChnFlag = isSelfChannel ? 0 : 1;
        Account updateEntity = Account.builder().bankClientNo(bankClientNo).bankClientStatus(BankClientStatus.OPENED_REPORTED.getStatus())
                .bankClientChnFlag(bankClientChnFlag).gmtModified(new Date()).build();
        //同时更新待结算账户的 银行客户号
        MerchantInfo merchantInfo = merchantInfoService.selectOne(MerchantInfoCondition.builder().and().andAccountEq(account).orSettleAccountEq(account).build());
        //若为普通账户则 需要同步更新待结算账户不为空的记录
        if (merchantInfo != null) {
            if (StringUtil.isNotBlank(merchantInfo.getAccount())) {
                MybatisDaoImpl.run().update(updateEntity, AccountCondition.builder().andAccountEq(merchantInfo.getAccount()).build());
            }
            if (StringUtil.isNotBlank(merchantInfo.getSettleAccount())) {
                MybatisDaoImpl.run().update(updateEntity, AccountCondition.builder().andAccountEq(merchantInfo.getSettleAccount()).build());
            }
        } else {
            //平台客户
            MybatisDaoImpl.run().update(updateEntity, AccountCondition.builder().andAccountEq(account).build());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBankClientStatus(String account, String bankClientNo, int bankClientStatus) {
        BankClientStatus.resolve(bankClientStatus);
        Account updateEntity = Account.builder().bankClientStatus(bankClientStatus).gmtModified(new Date()).build();
        //同时更新待结算账户的 银行客户号
        MerchantInfo merchantInfo = merchantInfoService.selectOne(MerchantInfoCondition.builder().and().andAccountEq(account).orSettleAccountEq(account).build());
        if (merchantInfo != null) {
            if (StringUtil.isNotBlank(merchantInfo.getAccount())) {
                MybatisDaoImpl.run().update(updateEntity, AccountCondition.builder().andAccountEq(merchantInfo.getAccount()).andBankClientNoEq(bankClientNo).build());
            }
            if (StringUtil.isNotBlank(merchantInfo.getSettleAccount())) {
                MybatisDaoImpl.run().update(updateEntity, AccountCondition.builder().andAccountEq(merchantInfo.getSettleAccount()).andBankClientNoEq(bankClientNo).build());
            }
        } else {
            MybatisDaoImpl.run().update(updateEntity, AccountCondition.builder().andAccountEq(account).andBankClientNoEq(bankClientNo).build());
        }
    }

    @Override
    public List<BankClientAccountBO> selectBankClientAccount(@RequestBody PersonOrgInfoBo personOrgInfoBo) {
        Assert.hasText(personOrgInfoBo.getType(), "参数personOrgInfoBo.type不能为空");
        Assert.isTrue(Pattern.matches("0|1", personOrgInfoBo.getType()), "参数personOrgInfoBo.type 只能0|1");
        Assert.hasText(personOrgInfoBo.getCode(), "参数personOrgInfoBo.code不能为空");
        Map<String, String> params = new HashMap<>(4);
        params.put("type", personOrgInfoBo.getType());
        params.put("code", personOrgInfoBo.getCode());
        List<BankClientAccountBO> list = MybatisDaoImpl.of(AccountMapper.class).selectListBySql("selectBankClientAccount", params);
        return list;
    }


    /**
     * 构建个人客户信息： 9要素必填
     * 证件类型 证件号码 证件有效期 姓名 手机号码 国籍 性别 职业 详细地址
     */
    private PersonOrgInfoBo personInfoBuild(String account, MerchantInfo merInfo) {
        MerchantInfo merchantInfo = merInfo != null ? merInfo : getMerchantInfo(account);

        Assert.notNull(merchantInfo, "查无此账户基础信息不能为空");
        AccountStatus accountStatus = AccountStatus.getEnum(merchantInfo.getStatus());
        Assert.notNull(accountStatus, () -> String.format("账户基础信息状态[%s]不合法", merchantInfo.getStatus()));
        //20201028调整 个人 个体必须已开户已绑卡才能上送
        Assert.isTrue(accountStatus == AccountStatus.OPEN_BIND, () ->
                String.format("账户基础信息状态[%s]，非正常", accountStatus.getValue()));

        Assert.hasText(merchantInfo.getIdType(), () -> "证件类型不能为空");
        Assert.hasText(merchantInfo.getIdCode(), () -> "证件号不能为空");
        Assert.hasText(merchantInfo.getIdIndate(), () -> "证件有效期不能为空");
        Assert.hasText(merchantInfo.getRealName(), () -> "真实姓名不能为空");
        Assert.hasText(merchantInfo.getTelephone(), () -> "联系人电话不能为空");
        Assert.hasText(merchantInfo.getCountry(), () -> "国籍地区编码不能为空");
        Assert.hasText(merchantInfo.getSex(), () -> "性别不能为空");
        Assert.hasText(merchantInfo.getProsession(), () -> "职业不能为空");
        Assert.hasText(merchantInfo.getBusinessAddress(), () -> "住所/工作地址不能为空");
        String birthDate = null;
        if(IdType.SFZ.getCode().equals(merchantInfo.getIdType())){
            birthDate = ValidateUtils.getBirthDate(merchantInfo.getIdCode());
        }

        return PersonOrgInfoBo.builder()
                .type(UserType.ONE.getType())
                .idType(merchantInfo.getIdType())
                .code(merchantInfo.getIdCode())
                .idIndate(fmt2EcifDate(merchantInfo.getIdIndate()))
                .birthDt(birthDate)
                .realName(merchantInfo.getRealName())
                .telephone(merchantInfo.getTelephone())
                .countryTpCd(merchantInfo.getCountry())
                .genderTpCd(merchantInfo.getSex())
                .occupationTpCd(merchantInfo.getProsession())
                .address(merchantInfo.getBusinessAddress())
                //默认居民类型
                .residentType("1")
                .build();
    }

    /**
     * 构建企业客户信息
     *
     * @param account 企业商户信息
     */
    private PersonOrgInfoBo orgInfoBuild(String account, MerchantInfo merInfo) {

        MerchantInfo merchantInfo = merInfo != null ? merInfo : getMerchantInfo(account);

        Assert.notNull(merchantInfo, "查无此账户基础信息不能为空");
        AccountStatus accountStatus = AccountStatus.getEnum(merchantInfo.getStatus());
        Assert.notNull(accountStatus, () -> String.format("账户基础信息状态[%s]不合法", merchantInfo.getStatus()));
        Assert.isTrue(accountStatus == AccountStatus.OPEN_BIND || accountStatus == AccountStatus.OPEN_UNBIND, () ->
                String.format("账户基础信息状态[%s]，非正常", accountStatus.getValue()));
        Assert.isTrue(MerAuthStatus.NORMAL.getCode().intValue() == merchantInfo.getAuthStatus().intValue(), () -> "账户基础信息审核状态非[审核通过]");

        AccountInfo accountInfo = getECIFAccountInfo(merchantInfo.getAccount());
        Assert.notNull(accountInfo,"该账户关联AccountInfo不能为空");

        Assert.hasText(merchantInfo.getEntName(), "企业名称不能为空");
        Assert.hasText(merchantInfo.getBusLicCode(), "营业执照号不能为空");
        Assert.hasText(merchantInfo.getTelephone(), "法人联系电话不能为空");
        Assert.hasText(merchantInfo.getRegAddress(), "注册地址不能为空");
        Assert.hasText(accountInfo.getRegisterFund(), "企业注册资金不能为空");
        Assert.hasText(accountInfo.getBusinessScope(), "经营范围不能为空");
        Assert.hasText(merchantInfo.getLegalName(), "法人姓名不能为空");
        Assert.hasText(merchantInfo.getIdType(), "法人证件类型不能为空");
        Assert.hasText(merchantInfo.getIdCode(), "法人身份证号码不能为空");
        Assert.hasText(accountInfo.getLegalIndate(), "法人身份证有效期不能为空");
        Assert.hasText(accountInfo.getCustomerManager(), "客户经理不能为空");
        Assert.hasText(accountInfo.getEnterpriseType(), "企业类型不能为空");
        Assert.hasText(accountInfo.getEnterpriseSale(), "企业规模不能为空");
        Assert.hasText(accountInfo.getEnterpriseEcoNature(), "企业经济性质不能为空");
        Assert.hasText(accountInfo.getResidentType(), "居民类型不能为空");
        Assert.hasText(merchantInfo.getCountry(), "国籍不能为空");
        Assert.hasText(merchantInfo.getProsession(), "行业不能为空");
        Assert.hasText(accountInfo.getBusinessIndate(), "营业执照有效期不能为空");
        Assert.hasText(merchantInfo.getBusLicPic(), "营业执照图片不能为空");
        Assert.hasText(merchantInfo.getPersonPic(), "法人证件正面图片不能为空");
        Assert.hasText(merchantInfo.getPersonReversePic(), "法人证件反面图片不能为空");
        Assert.hasText(accountInfo.getContactAddress(), "联系地址不能为空");
        Assert.hasText(accountInfo.getBusinessStartDate(), "营业执照生效日期不能为空");
        Assert.hasText(accountInfo.getLegalStartDate(), "法人证件生效日期不能为空");


//        要素不全的(企业名称、营业执照号码、手机号码、注册地址、注册资本、经营范围、法人姓名、法人证件类型、法人身份证号码、法人身份证有效期、
//        客户经理、企业类型、企业规模、企业经济性质、居民类型、国籍、行业、营业执照有效期、营业执照图片法人身份证正反面三图)、冻结、销户、未审核的无论自动还是手工均不能上报ecif。
        //居民类型默认为居民
        String residentType = StringUtil.isEmpty(accountInfo.getResidentType())?"1":accountInfo.getResidentType();

        return PersonOrgInfoBo.builder()
                .type(UserType.MER.getType())
                .idType(IdType.ID218.getCode())
                .realName(merchantInfo.getEntName())
                .code(merchantInfo.getBusLicCode())
                .telephone(merchantInfo.getTelephone())
                .idIndate(fmt2EcifDate(accountInfo.getBusinessIndate()))
                .address(merchantInfo.getRegAddress())
                .registerAmt(accountInfo.getRegisterFund())
                .businessScope(accountInfo.getBusinessScope())
                .countryTpCd(merchantInfo.getCountry())
                .industryTpCd(merchantInfo.getProsession())
                .legalIdType(merchantInfo.getIdType())
                .legalIdCode(merchantInfo.getIdCode())
                .legalName(merchantInfo.getLegalName())
                .legalIdindate(fmt2EcifDate(accountInfo.getLegalIndate()))
                .customerManager(accountInfo.getCustomerManager())
                .orgTpCd(accountInfo.getEnterpriseType())
                .spdbScaleTpCd(accountInfo.getEnterpriseSale())
                .economicTpCd(accountInfo.getEnterpriseEcoNature())
                .residentType(residentType)
                .listedTpCd(accountInfo.getListingType())

                .contactAddress(accountInfo.getContactAddress())
                .businessStartdate(accountInfo.getBusinessStartDate())
                .legalStartdate(accountInfo.getLegalStartDate())
                .actualMasterIdStartDate(accountInfo.getControlStartDate())
                .authProxyIdStartDate(accountInfo.getAuthBusStartDate())
                .ownerOneName(accountInfo.getOwneroneName())
                .ownerOneCerfileType(accountInfo.getOwneroneCerfileType())
                .ownerOneCerfileNo(accountInfo.getOwneroneCerfileNo())
                .ownerOneStartdate(accountInfo.getOwneroneStartDate())
                .ownerOneIndate(accountInfo.getOwneroneInDate())
                .ownerTwoName(accountInfo.getOwnertwoName())
                .ownerTwoCerfileType(accountInfo.getOwnertwoCerfileType())
                .ownerTwoCerfileNo(accountInfo.getOwnertwoCerfileNo())
                .ownerTwoStartdate(accountInfo.getOwnertwoStartDate())
                .ownerTwoIndate(accountInfo.getOwnertwoInDate())
                .ownerThreeName(accountInfo.getOwnerthreeName())
                .ownerThreeCerfileType(accountInfo.getOwnerthreeCerfileType())
                .ownerThreeCerfileNo(accountInfo.getOwnerthreeCerfileNo())
                .ownerThreeStartdate(accountInfo.getOwnerthreeStartDate())
                .ownerThreeIndate(accountInfo.getOwnerthreeInDate())
                .ownerFourName(accountInfo.getOwnerfourName())
                .ownerFourCerfileType(accountInfo.getOwnerfourCerfileType())
                .ownerFourCerfileNo(accountInfo.getOwnerfourCerfileNo())
                .ownerFourStartdate(accountInfo.getOwnerfourStartDate())
                .ownerFourIndate(accountInfo.getOwnerfourInDate())
                .contactProvince(accountInfo.getContactProvince())
                .contactCity(accountInfo.getContactCity())
                .contactArea(accountInfo.getContactArea())
                .regProvince(accountInfo.getRegProvince())
                .regCity(accountInfo.getRegCity())
                .regArea(accountInfo.getRegArea())
                .build();

    }

    /**
     * 简单转换 yyyy-MM-dd 转 yyyyMMdd
     *
     * @param localDateStr
     * @return
     */
    private String fmt2EcifDate(String localDateStr) {
        return localDateStr == null ? null : localDateStr.replaceAll("-", "");
    }

    /**
     * 构建平台客户信息
     *
     * @param account 平台虚账户
     */
    private PersonOrgInfoBo industryInfoBuild(String account) {
        Industry industry = industryService.selectOne(IndustryCondition.builder().andAccountEq(account).build(),false);
        Assert.notNull(industry,"查无此平台客户信息");
        Assert.isTrue(TrueOrFalseStatus.TRUE.value().equals(industry.getStatus()),"平台客户状态非正常");

        AccountInfo accountInfo = getECIFAccountInfo(industry.getAccount());
        Assert.notNull(accountInfo,"该账户关联AccountInfo不能为空");

        Assert.hasText(industry.getEntName(), "企业名称不能为空");
        Assert.hasText(industry.getBusLicCode(), "营业执照号不能为空");
        Assert.hasText(industry.getPhone(), "法人联系电话不能为空");
        Assert.hasText(industry.getRegAddress(), "注册地址不能为空");
        Assert.hasText(accountInfo.getRegisterFund(), "企业注册资金不能为空");
        Assert.hasText(accountInfo.getBusinessScope(), "经营范围不能为空");
        Assert.hasText(industry.getLegalPerson(), "法人姓名不能为空");
        Assert.hasText(industry.getIdType(), "法人证件类型不能为空");
        Assert.hasText(industry.getIdCode(), "法人身份证号码不能为空");
        Assert.hasText(accountInfo.getLegalIndate(), "法人身份证有效期不能为空");
        Assert.hasText(accountInfo.getCustomerManager(), "客户经理不能为空");
        Assert.hasText(accountInfo.getEnterpriseType(), "企业类型不能为空");
        Assert.hasText(accountInfo.getEnterpriseSale(), "企业规模不能为空");
        Assert.hasText(accountInfo.getEnterpriseEcoNature(), "企业经济性质不能为空");
        Assert.hasText(accountInfo.getResidentType(), "居民类型不能为空");
        Assert.hasText(industry.getNationality(), "国籍不能为空");
        Assert.hasText(industry.getCustomerTrade(), "行业不能为空");
        Assert.hasText(accountInfo.getBusinessIndate(), "营业执照有效期不能为空");
        Assert.hasText(industry.getBusLicPic(), "营业执照图片不能为空");
        Assert.hasText(industry.getPersonPic(), "法人证件正面图片不能为空");
        Assert.hasText(industry.getPersonReversePic(), "法人证件反面图片不能为空");

//        要素不全的(企业名称、营业执照号码、手机号码、注册地址、注册资本、经营范围、法人姓名、法人证件类型、法人身份证号码、法人身份证有效期、
                //        客户经理、企业类型、企业规模、企业经济性质、居民类型、国籍、行业、营业执照有效期、营业执照图片法人身份证正反面三图)、冻结、销户、未审核的无论自动还是手工均不能上报ecif。
                //居民类型默认为居民
        String residentType = StringUtil.isEmpty(accountInfo.getResidentType())?"1":accountInfo.getResidentType();

        return PersonOrgInfoBo.builder()
                .type(UserType.MER.getType())
                .idType(IdType.ID218.getCode())
                .realName(industry.getEntName())
                .code(industry.getBusLicCode())
                .idIndate(fmt2EcifDate(accountInfo.getBusinessIndate()))
                .telephone(industry.getPhone())
                .address(industry.getRegAddress())
                .registerAmt(accountInfo.getRegisterFund())
                .businessScope(accountInfo.getBusinessScope())
                .countryTpCd(industry.getNationality())
                .industryTpCd(industry.getCustomerTrade())
                .legalIdType(industry.getIdType())
                .legalIdCode(industry.getIdCode())
                .legalName(industry.getLegalPerson())
                .legalIdindate(fmt2EcifDate(accountInfo.getLegalIndate()))
                .customerManager(accountInfo.getCustomerManager())
                .orgTpCd(accountInfo.getEnterpriseType())
                .spdbScaleTpCd(accountInfo.getEnterpriseSale())
                .economicTpCd(accountInfo.getEnterpriseEcoNature())
                .residentType(residentType)
                .listedTpCd(accountInfo.getListingType())
                .build();

    }

    /**
     * 获取 ECIF 账户补充信息
     */
    private AccountInfo getECIFAccountInfo(String userAccount) {
        return MybatisDaoImpl.run().selectOne(AccountInfo.builder().account(userAccount).build());
    }

    /**
     * 查询商户信息
     *
     * @param account 虚账号
     */
    private MerchantInfo getMerchantInfo(String account) {
        return merchantInfoService.selectOne(MerchantInfoCondition.builder().andAccountEq(account).build(),false);
    }
}
