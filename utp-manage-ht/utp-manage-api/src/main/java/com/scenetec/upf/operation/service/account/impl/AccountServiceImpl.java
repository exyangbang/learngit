package com.scenetec.upf.operation.service.account.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.BankClientStatusEnum;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.account.AccountDetailDO;
import com.scenetec.upf.operation.model.domain.account.status.AccountEnum;
import com.scenetec.upf.operation.model.domain.accountinfo.AccountInfoDO;
import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import com.scenetec.upf.operation.model.domain.country.CountryDO;
import com.scenetec.upf.operation.model.domain.electronicreceipt.AaccountElectronicReceiptDO;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantAccountInfoDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.*;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.accountinfo.AccountInfoMapper;
import com.scenetec.upf.operation.repository.codedictionary.CodeDictionaryMapper;
import com.scenetec.upf.operation.repository.country.CountryMapper;
import com.scenetec.upf.operation.repository.fundaccount.FundAccountMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.merchant.MerchantAccountInfoMapper;
import com.scenetec.upf.operation.repository.merchant.MerchantInfoMapper;
import com.scenetec.upf.operation.service.account.AccountService;
import com.scenetec.upf.operation.service.imageHanlder.ImageHanlderService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.OnliineTool.OnlineRequestTool;
import com.scenetec.upf.operation.utils.SHA1;
import com.scenetec.zeus.daogenerator.model.Query;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper mapper;
    @Resource
    FundAccountMapper fundAccountMapper;
    @Resource
    MerchantAccountInfoMapper merchantAccountInfoMapper;
    @Resource
    MerchantInfoMapper merchantInfoMapper;
    @Resource
    IndustryMapper industryMapper;
    @Resource
    CountryMapper countryMapper;
    @Value("${account.innerManage.addPersonOrOrgInfo.url}")
    private String orgInfoUrl;
    @Resource
    private OnlineRequestTool onlineRequestTool;
    @Resource
    private CodeDictionaryMapper codeDictionaryMapper;
    @Resource
    UserService userService;
    @Resource
    AccountInfoMapper accountInfoMapper;

    @Value("${account.flow.updatePersonOrOrgHotspot.url}")
    private String updatePersonOrOrgHotspot;

    @Resource
    private ImageHanlderService imageHanlderService;

    @Override
    public long create(AccountDO obj) {
        obj.setGmtCreate(new Date());
        obj.setUserCreate("");
        obj.setGmtModified(new Date());
        obj.setUserModified("");
        obj.setId(IdGenerate.getId());
        mapper.create(obj);
        return obj.getId();
    }

    @Override
    public int delete(Long id) {
        return mapper.deleteLogic(id);
    }

    /**
     * 添加费用类型
     * 只有商户（企业）和个人才能配置手续费模板
     *
     * @param obj
     */
    @Override
    public void updateFeeTemplate(AccountDO obj) {
        if (obj.getFeeTemplateId() == null || obj.getId() == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        AccountDO accountDO = new AccountDO();
        accountDO.setId(obj.getId());
        accountDO.setFeeTemplateId(obj.getFeeTemplateId());
        accountDO.setGmtModified(new Date());
        AccountDO tempaccountDO = mapper.getById(obj.getId());
        if (tempaccountDO.getObjType().equals(AccountEnum.ACCOUNT_BUSINESS.getValue()) ||
                tempaccountDO.getObjType().equals(AccountEnum.ACCOUNT_PERSONAL.getValue()) ||
                tempaccountDO.getObjType().equals(AccountEnum.ACCOUNT_COMMISSION_ACCOUNT.getValue()) ||
                tempaccountDO.getObjType().equals(AccountEnum.PERSONAL_INFO_AUTH.getValue())) {
            if (obj.getFeeTemplateIdRelieve() != null && obj.getFeeTemplateIdRelieve() == -1L) {//删除手续费配置
                obj.setFeeTemplateId(null);
            }
            mapper.update(obj);
        } else {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "该用户不能配置手续费模板");
        }
    }

    @Override
    public MerchantInfoDO getImage(Map obj) {
        return imageHanlderService.getImage(obj);
    }


    /**
     * 更新信息
     *
     * @param accountInfoVO
     */
    @Override
    @Transactional
    public void updateMerchInfo(AccountInfoVO accountInfoVO) {
        if (AccountEnum.ACCOUNT_PERSONAL.getValue().equals(accountInfoVO.getObjType())
                || (AccountEnum.ACCOUNT_COMMISSION_ACCOUNT.getValue().equals(accountInfoVO.getObjType()) && "0".equals(accountInfoVO.getUserType()))
                || (AccountEnum.SETTLEMENT_ACCOUNT.getValue().equals(accountInfoVO.getObjType()) && "0".equals(accountInfoVO.getUserType()))
                || AccountEnum.PERSONAL_INFO_AUTH.getValue().equals(accountInfoVO.getObjType())) {//个人
            MerchantInfoDO resMer = new MerchantInfoDO();
            resMer.setAccount(accountInfoVO.getAccount());
            resMer.setIdIndate(accountInfoVO.getIdIndate());
            resMer.setSex(accountInfoVO.getSex());
            resMer.setCountry(accountInfoVO.getCountry());
            resMer.setProsession(accountInfoVO.getProsession());
            resMer.setBusinessAddress(accountInfoVO.getBusinessAddress());
            UploadIndustryMerchantImagesRespDTO imurlDO = imageHanlderService.uploadImageReque(accountInfoVO);
            resMer.setPersonPic(imurlDO.getPersonPicPath());
            resMer.setPersonReversePic(imurlDO.getPersonReversePicPath());
            resMer.setBusLicPic(imurlDO.getBusLicPicPath());
            resMer.setGmtModified(new Date());
            resMer.setUserModified(userService.getUserContext().getUsername());
            merchantInfoMapper.updateForAccount(resMer);

            AccountInfoDO ac = new AccountInfoDO();
            ac.setAccount(accountInfoVO.getAccount());
            Integer resInt = accountInfoMapper.count(ac);
            if (resInt == 1) {//update
                ac.setObjType(accountInfoVO.getObjType());
                ac.setResidentType(accountInfoVO.getResidentType());
                ac.setUserType(accountInfoVO.getUserType());
                ac.setUserModified(userService.getUserContext().getUsername());
                ac.setGmtModified(new Date());
                accountInfoMapper.updateByAccount(ac);
            } else { //create
                ac.setId(IdGenerate.getId());
                ac.setObjType(accountInfoVO.getObjType());
                ac.setResidentType(accountInfoVO.getResidentType());
                ac.setUserType(accountInfoVO.getUserType());
                ac.setUserCreate(userService.getUserContext().getUsername());
                ac.setGmtCreate(new Date());
                ac.setUserModified(userService.getUserContext().getUsername());
                ac.setGmtModified(new Date());
                accountInfoMapper.create(ac);
            }

        } else if (AccountEnum.ACCOUNT_INDUSTRY.getValue().equals(accountInfoVO.getObjType()) ||
                AccountEnum.ACCOUNT_BUSINESS.getValue().equals(accountInfoVO.getObjType())
                || (AccountEnum.ACCOUNT_COMMISSION_ACCOUNT.getValue().equals(accountInfoVO.getObjType()) && "1".equals(accountInfoVO.getUserType()))
                || (AccountEnum.SETTLEMENT_ACCOUNT.getValue().equals(accountInfoVO.getObjType()) && "1".equals(accountInfoVO.getUserType()))
        ) {//平台或企业
            AccountInfoDO ac = new AccountInfoDO();
            ac.setAccount(accountInfoVO.getAccount());
            Integer resInt = accountInfoMapper.count(ac);
            if (resInt == 1) {//update
                BeanUtils.copyProperties(accountInfoVO, ac);
                ac.setUserModified(userService.getUserContext().getUsername());
                ac.setGmtModified(new Date());
                accountInfoMapper.updateByAccount(ac);
            } else { //create
                ac.setId(IdGenerate.getId());
                BeanUtils.copyProperties(accountInfoVO, ac);
                ac.setUserCreate(userService.getUserContext().getUsername());
                ac.setGmtCreate(new Date());
                ac.setUserModified(userService.getUserContext().getUsername());
                ac.setGmtModified(new Date());
                accountInfoMapper.create(ac);
            }
            if (AccountEnum.ACCOUNT_INDUSTRY.getValue().equals(accountInfoVO.getObjType())) {//平台
                IndustryDO industryDO = new IndustryDO();
                industryDO.setAccount(accountInfoVO.getAccount());
                UploadIndustryMerchantImagesRespDTO imurlDO = imageHanlderService.uploadImageReque(accountInfoVO);
                industryDO.setPersonPic(imurlDO.getPersonPicPath());
                industryDO.setPersonReversePic(imurlDO.getPersonReversePicPath());
                industryDO.setBusLicPic(imurlDO.getBusLicPicPath());
                industryDO.setLicensePic(imurlDO.getLicensePicPath());
                industryDO.setLegalPerson(accountInfoVO.getLegalName());
                industryDO.setRegAddress(accountInfoVO.getRegAddress());
                industryDO.setGmtModified(new Date());
                industryDO.setUserModified(userService.getUserContext().getUsername());
                industryDO.setCustomerTrade(accountInfoVO.getProsession());//行业
                industryDO.setNationality(accountInfoVO.getCountry());//国籍
                industryDO.setPhone(accountInfoVO.getTelephone());
                industryDO.setEntName(accountInfoVO.getEntName());
                industryMapper.updateForAccount(industryDO);
            }
            if (AccountEnum.ACCOUNT_BUSINESS.getValue().equals(accountInfoVO.getObjType())
                    || (AccountEnum.ACCOUNT_COMMISSION_ACCOUNT.getValue().equals(accountInfoVO.getObjType()) && "1".equals(accountInfoVO.getUserType()))
                    || (AccountEnum.SETTLEMENT_ACCOUNT.getValue().equals(accountInfoVO.getObjType()) && "1".equals(accountInfoVO.getUserType()))
            ) {//企业
                MerchantInfoDO resMer = new MerchantInfoDO();
                resMer.setAccount(accountInfoVO.getAccount());
                UploadIndustryMerchantImagesRespDTO imurlDO = imageHanlderService.uploadImageReque(accountInfoVO);
                resMer.setPersonPic(imurlDO.getPersonPicPath());
                resMer.setPersonReversePic(imurlDO.getPersonReversePicPath());
                resMer.setBusLicPic(imurlDO.getBusLicPicPath());
                resMer.setLicensePic(imurlDO.getLicensePicPath());
                resMer.setIdType(accountInfoVO.getIdType());
                resMer.setIdCode(accountInfoVO.getIdCode());
                resMer.setProsession(accountInfoVO.getProsession());
                resMer.setCountry(accountInfoVO.getCountry());
                resMer.setGmtModified(new Date());
                resMer.setLegalName(accountInfoVO.getLegalName());
                resMer.setUserModified(userService.getUserContext().getUsername());
                resMer.setRegAddress(accountInfoVO.getRegAddress());
                if (AccountEnum.ACCOUNT_BUSINESS.getValue().equals(accountInfoVO.getObjType())) {
                    resMer.setEntName(accountInfoVO.getEntName());
                }
                merchantInfoMapper.updateForAccount(resMer);
            }
        }
        AccountDO accountDO = new AccountDO();
        accountDO.setAccount(accountInfoVO.getAccount());
        AccountDO ac = mapper.selectOne(accountDO);
        if (ac != null && StringUtils.isNoneBlank(ac.getBankClientNo())) {
            //修改为更新未上报
            updateClinetStatus(ac, BankClientStatusEnum.BANK_CLIENT_UPDATE_REPORT.getValue(), accountInfoVO.getAccount());
        }
        if (ac != null && StringUtils.isBlank(ac.getBankClientNo())) {
            //开户未上报
            updateClinetStatus(ac, BankClientStatusEnum.BANK_CLIENT_OPEN_UN_REPORT.getValue(), accountInfoVO.getAccount());
        }
        if (ac != null && "1".equals(ac.getBankClientChnFlag())) {
            // 其他渠道的,更新未上报
            updateClinetStatus(ac, BankClientStatusEnum.BANK_CLIENT_UPDATE_UN_REPORT.getValue(), accountInfoVO.getAccount());
        }
        // 上传到ecif
        accountInfoTransToECIF(accountInfoVO, ac);
    }

    /**
     * 上传到ecif
     *
     * @param accountInfoVO
     */
    private void accountInfoTransToECIF(AccountInfoVO accountInfoVO, AccountDO ac) {

        if (ac != null && ("0").equals(ac.getBankClientChnFlag())
                && StringUtils.isNoneBlank(ac.getBankClientNo())) {//自有渠道 bankclintno 为空不用报给联机
            if (ac.getObjType().equals("1")) {//如果是平台的userType默认是1
                accountInfoVO.setUserType("1");
            }
            String reqDate = DateUtilities.formatDate(new Date(), "yyyyMMdd");
            String reqTime = DateUtilities.formatDate(new Date(), "HHmmss");
            BankClientAccountInfoDTO clDO = new BankClientAccountInfoDTO();
            clDO.setClientTransId(IdGenerate.getIdStr());
            clDO.setAccountId(ac.getId().toString());
            clDO.setAccount(ac.getAccount());
            clDO.setUserType(accountInfoVO.getUserType());
            clDO.setBankClientNo(ac.getBankClientNo());
            clDO.setReqDate(reqDate);
            clDO.setReqTime(reqTime);
            BankClientAccountInfoDTO.PersonAccount ps = new BankClientAccountInfoDTO.PersonAccount();
            ps.setCdResidentTp(accountInfoVO.getResidentType());//居民类型：0非居民 1居民
            ps.setGenderTpCd(accountInfoVO.getSex());//性别
            ps.setCountryTpCd(accountInfoVO.getCountry());//国籍
            ps.setOccupationTpCd(accountInfoVO.getProsession());//职业
            ps.setAddress(accountInfoVO.getBusinessAddress());//地址
            ps.setIdIndate(fmtIndate(accountInfoVO.getIdIndate()));//证件有效期
            ps.setIdType(accountInfoVO.getIdType());//证件类型 101 身份证，102 护照  103 军官证  企业类型必须为218=社会统一信用号
            ps.setIdCode(accountInfoVO.getIdCode());//身份证号码
            clDO.setPersonAccount(ps);
            BankClientAccountInfoDTO.OrganizationAccount ogAc = new BankClientAccountInfoDTO.OrganizationAccount();
            ogAc.setIdType("218");//证件类型 101 身份证，102 护照  103 军官证  企业类型必须为218=社会统一信用号
            ogAc.setBusLicCode(accountInfoVO.getBusLicCode());//企业营业执照即社会统一信用号
            ogAc.setAddress(accountInfoVO.getRegAddress());//详细地址
            ogAc.setBusinessScope(accountInfoVO.getBusinessScope());//经营范围
            ogAc.setRegisterAmt(accountInfoVO.getRegisterFund());//注册资金 单位元 CNY
            ogAc.setIdIndate(fmtIndate(accountInfoVO.getBusinessIndate()));//营业执照证件有效期yyyyMMdd
            ogAc.setCustomerManager(accountInfoVO.getCustomerManager());//所属客户经理
            ogAc.setOrgTpCd(accountInfoVO.getEnterpriseType());//企业类型
            ogAc.setOwnershipTpCd(accountInfoVO.getEnterpriseEcoNature());//企业经营性质：企业性质
            ogAc.setSpdbScaleTpCd(accountInfoVO.getEnterpriseSale()); //企业规模
            ogAc.setListedTpCd(accountInfoVO.getListingType());//上市类型
            ogAc.setIndustryTpCd(accountInfoVO.getProsession());//行业类型
            ogAc.setResidentTpCd(accountInfoVO.getResidentType());//居民类型：0非居民 1居民
            ogAc.setLegalName(accountInfoVO.getLegalName());//法人名称
            ogAc.setLegalIdType(accountInfoVO.getIdType());//法人证件类型
            ogAc.setLegalIdCode(accountInfoVO.getIdCode());//法人证件号码
            ogAc.setLegalIdindate(fmtIndate(accountInfoVO.getLegalIndate()));//法人证件有效期
            ogAc.setActualMasterName(accountInfoVO.getControlName());//实际控制者名称
            ogAc.setActualMasterIdType(accountInfoVO.getControlCerfileType());//实际控制者证件类型
            ogAc.setActualMasterIdCode(accountInfoVO.getControlCerfileNo());//实际控制者证件号码
            ogAc.setActualMasterIdindate(fmtIndate(accountInfoVO.getControlIndate()));//实际控制者证件有效期
            ogAc.setPrincipalName(accountInfoVO.getChargeName());//负责人姓名
            ogAc.setPrincipalIdType(accountInfoVO.getChargeCerfileType());//负责人姓名证件类型
            ogAc.setPrincipalIdCode(accountInfoVO.getChargeCerfileNo());//负责人姓名证件号码
            ogAc.setPrincipalIdindate(fmtIndate(accountInfoVO.getChargeIndate()));//负责人姓名证件有效期
            ogAc.setAuthProxyName(accountInfoVO.getAuthBusName());//授权代理人名称
            ogAc.setAuthProxyIdType(accountInfoVO.getAuthBusType());//授权代理人证件类型
            ogAc.setAuthProxyIdCode(accountInfoVO.getAuthBusNo());//授权代理人证件号码
            ogAc.setAuthProxyIdindate(fmtIndate(accountInfoVO.getAuthBusIndate()));//授权代理人证件有效期
            ogAc.setEntName(accountInfoVO.getEntName());// 企业名称
            if (StringUtils.isBlank(clDO.getBankClientNo())) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, "关联的银行客户号不存在");
            }
            clDO.setOrganizationAccount(ogAc);
            if (AccountEnum.ACCOUNT_BUSINESS.getValue().equals(ac.getObjType())) {
                checkMerchantRequiredParam(ac.getAccount());
            }
            try {
                clDO.setSign(SHA1.genWithAmple(clDO.toSHA1()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            RestTemplate restTemplate = new RestTemplate();
            BaseInnerManageRespDTO resultMap = restTemplate.postForObject(updatePersonOrOrgHotspot, clDO, BaseInnerManageRespDTO.class);
            if ("200".equals(resultMap.getStatus())) {
                //更新已上报
                updateClinetStatus(ac, BankClientStatusEnum.BANK_CLIENT_UPDATE_REPORT.getValue(), accountInfoVO.getAccount());
            }
            if (!"200".equals(resultMap.getStatus())) {
                //更新未上报
//                updateClinetStatus(ac, BankClientStatusEnum.BANK_CLIENT_UPDATE_UN_REPORT.getValue(), accountInfoVO.getAccount());
                if (resultMap.getMessage() != null) {
                    throw new SystemRuntimeException(ErrorCode.BSMPS001, (String) resultMap.getMessage());
                }
                throw new SystemRuntimeException(ErrorCode.BSMPS001, "ECIF同步失败");
            }
        }
    }

    /**
     * 页面输入值yyyy-MM-dd 转 yyyyMMdd
     * @param date
     * @return
     */
    private String fmtIndate(String date){
        return date==null?null:date.trim().replaceAll("-","");
    }


    /**
     * 上报后更新 account 如果有分身信息也需要更改
     */
    private void updateClinetStatus(AccountDO acid, String bankClientStatus, String account) {
        AccountDO tesp = new AccountDO();
        tesp.setId(acid.getId());
        tesp.setBankClientStatus(bankClientStatus);
        mapper.update(tesp);

        MerchantInfoDO merchantInfoDO = new MerchantInfoDO();
        merchantInfoDO.setAccount(account);
        MerchantInfoDO mertemp = merchantInfoMapper.selectOnebyAccount(merchantInfoDO);
        if (mertemp != null) {
            tesp.setId(mertemp.getId());
            tesp.setBankClientNo(acid.getBankClientNo());
            tesp.setBankClientStatus(bankClientStatus);
            mapper.update(tesp);
        }
    }

    @Override
    public void update(AccountDO obj) {
        obj.setGmtModified(new Date());
        obj.setUserModified("");
        mapper.update(obj);
    }

    @Override
    public AccountDO getById(Long id) {
        return mapper.getById(id);
    }

    @Override
    public PageInfo<AccountDO> pageList(Query query) {
        Instant start = Instant.now();
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map map = query.getParameters();
        //银行客户号关联标志
        if (map.containsKey("bankClientStatus")) {
            Integer bankClientNoSta = Integer.valueOf(map.get("bankClientStatus").toString());
            if (bankClientNoSta == 5) {//查看全部
                map.put("bankClientStatus", null);
            }
        }
        Page<AccountDO> page = mapper.pageList(query.getParameters());
        Instant end = Instant.now();
        System.out.println("==1===" + Duration.between(start, end) + "===1=");
        return new PageInfo<>(page);
    }

    /**
     * 排除收益账户
     *
     * @param query
     * @return
     */
    @Override
    public PageInfo<AccountDO> pageListExclusive(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map tempMap = query.getParameters();
        if (tempMap.get("objType") == null || StringUtils.isBlank(tempMap.get("objType").toString())) {
            tempMap.put("objTypePar", "4");
        }
        Page<AccountDO> page = mapper.pageListUnincome(tempMap);
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        return mapper.countTrans(parameters);
    }

    @Override
    public PageInfo<AccountDetailDO> pageListDetail(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<AccountDetailDO> page = mapper.pageListDetail(query.getParameters());
        AccountDO accountDO = new AccountDO();
        page.getResult().forEach(item -> {
            accountDO.setAccount(item.getAccount());
            AccountDO temp = mapper.selectOne(accountDO);
            item.setObjNo(temp.getObjCode());
            item.setObjName(temp.getObjName());
            item.setAccountType(temp.getObjType());

        });
        return new PageInfo<>(page);
    }

    @Override
    public List<AccountDO> list(Map<String, Object> params) {
        return mapper.list(params);
    }

    @Override
    public AccountInfoVO accountDetail(Long id) {

        Instant start = Instant.now();
        AccountDO accountDO = mapper.getById(id);
        if (accountDO != null) {
            //个人,企业,佣金账户(),个体工商户,待结算账户
            if (AccountEnum.ACCOUNT_PERSONAL.getValue().equals(accountDO.getObjType()) ||
                    AccountEnum.ACCOUNT_BUSINESS.getValue().equals(accountDO.getObjType()) ||
                    AccountEnum.ACCOUNT_COMMISSION_ACCOUNT.getValue().equals(accountDO.getObjType()) ||
                    AccountEnum.PERSONAL_INFO_AUTH.getValue().equals(accountDO.getObjType()) ||
                    AccountEnum.SETTLEMENT_ACCOUNT.getValue().equals(accountDO.getObjType())) {

                MerchantInfoDO mer = new MerchantInfoDO();
                mer.setAccount(accountDO.getAccount());
                AccountInfoVO accountInfoVO = new AccountInfoVO();
                if (AccountEnum.SETTLEMENT_ACCOUNT.getValue().equals(accountDO.getObjType())) {
                    mer = new MerchantInfoDO();
                    mer.setSettleAccount(accountDO.getAccount());
                }
                mer = merchantInfoMapper.selectOneTomerchantAccountInfo(mer);
                if (mer != null) {
                    BeanUtils.copyProperties(mer, accountInfoVO);
                }
                if (AccountEnum.SETTLEMENT_ACCOUNT.getValue().equals(accountDO.getObjType())) {
                    //是否是个体工商户。待结算账户如果是个体工商户显示的和个人的不同，需要做区分
                   AccountDO acco = new AccountDO();
                   acco.setAccount(mer.getAccount());
                   acco = mapper.selectOne(acco);
                   if (acco != null &&
                           AccountEnum.PERSONAL_INFO_AUTH.getValue().equals(acco.getObjType())){
                       accountInfoVO.setPersonBus("1");
                   }
                }
                AccountInfoDO accountInfoDO = accountInfoMapper.getByAccount(mer.getAccount());
                if (accountInfoDO != null) {
                    BeanUtils.copyProperties(accountInfoDO, accountInfoVO);
                }
                //国籍列表
                List<CountryDO> clist = countryMapper.listBeThreeBitLetters(new HashMap<>());
                clist.forEach(c -> {
                    c.setChName(c.getChName() + "(" + c.getThreeBitLetters() + ")");
                });
                accountInfoVO.setCountryList(clist);
                //职业
                Map par = new HashMap();
                if (mer != null && ("0").equals(mer.getUserType())) {//个人
                    par.put("type", "0003");
                }
                if (mer != null && ("1").equals(mer.getUserType())) {//企业
                    par.put("codeBus", "^[A-Z]$");
                }
                List<CodeDictionaryDO> codeList = codeDictionaryMapper.listBeCodeAndValue(par);
                codeList.forEach(c -> {
                    c.setValue(c.getValue() + "(" + c.getCode() + ")");
                });
                accountInfoVO.setCodeDictionaryList(codeList);
                accountInfoVO.setObjType(accountDO.getObjType());

                Instant end = Instant.now();
                System.out.println("====耗时：" + Duration.between(start, end));
                return accountInfoVO;
            }
            //平台
            if (AccountEnum.ACCOUNT_INDUSTRY.getValue().equals(accountDO.getObjType())) {
                AccountInfoVO accVO = new AccountInfoVO();
                IndustryDO industryDO = new IndustryDO();
                industryDO.setAccount(accountDO.getAccount());
                industryDO = industryMapper.selectOneExcludeImage(industryDO);
                AccountInfoDO accountInfoDO = accountInfoMapper.getByAccount(industryDO.getAccount());
                if (accountInfoDO != null) {
                    BeanUtils.copyProperties(accountInfoDO, accVO);
                }
                accVO.setEntName(industryDO.getEntName());//企业账户名称
                accVO.setAccountNo(industryDO.getAccountNo());//企业账号
                accVO.setRegAddress(industryDO.getRegAddress());//企业注册地址
                accVO.setBusLicCode(industryDO.getBusLicCode());//营业执照号
                accVO.setIdType(industryDO.getIdType());//法人证件类型
                accVO.setIdCode(industryDO.getIdCode());//法人证件号
                accVO.setAccount(industryDO.getAccount());//虚拟账户
                accVO.setLegalName(industryDO.getLegalPerson());//法人姓名
                accVO.setCountry(industryDO.getNationality());//客户国籍
                accVO.setProsession(industryDO.getCustomerTrade());//职业
                accVO.setTelephone(industryDO.getPhone());
                accVO.setIndustryCode(industryDO.getCode());
                //国籍列表
                List<CountryDO> clist = countryMapper.listBeThreeBitLetters(new HashMap<>());
                clist.forEach(c -> {
                    c.setChName(c.getChName() + "(" + c.getThreeBitLetters() + ")");
                });
                //职业
                Map par = new HashMap();
                par.put("codeBus", "^[A-Z]$");
                List<CodeDictionaryDO> codeList = codeDictionaryMapper.listBeCodeAndValue(par);
                codeList.forEach(c -> {
                    c.setValue(c.getValue() + "(" + c.getCode() + ")");
                });
                accVO.setCodeDictionaryList(codeList);
                accVO.setCountryList(clist);
                accVO.setPhone(industryDO.getPhone());
                accVO.setUserType(accountDO.getObjType());
                return accVO;
            }
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return null;
    }

    /**
     * 上报银行系统
     *
     * @param obj
     */
    @Override
    public void reportBank(AccountReqVO obj) {
        if (obj.getIdList().size() > 0) {
            List<AccountDO> li = mapper.selectListForIn(obj.getIdList());
            AtomicInteger num = new AtomicInteger();
            for (AccountDO eid : li) {
                // 企业账户必填校验
                if (AccountEnum.ACCOUNT_BUSINESS.getValue().equals(eid.getObjType())) {
                    try {
                        checkMerchantRequiredParam(eid.getAccount());
                    } catch (SystemRuntimeException e) {
                        num.getAndIncrement();
                        if (li.size() == 1) {
                            throw e;
                        }
                        log.error("上报银行异常", e);
                        continue;
                    }
                }
                AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
                accountInfoDTO.setId(eid.getId().toString());
                accountInfoDTO.setAccount(eid.getAccount());
                accountInfoDTO.setType(eid.getObjType());
                accountInfoDTO.setCode(eid.getObjCode());
                accountInfoDTO.setName(eid.getObjName());
                accountInfoDTO.setFundAccount(eid.getFundAccount());
                try {
                    accountInfoDTO.setSign(SHA1.genWithAmple(accountInfoDTO.toSHA1()));
                } catch (NoSuchAlgorithmException e) {
                    log.error("联机请求签名异常", e);
                }
                try {
                    onlineRequestTool.reportBankReuqet(orgInfoUrl, accountInfoDTO);
                } catch (SystemRuntimeException e) {
                    num.getAndIncrement();
                    String regexp = "message='(.*)',";
                    Pattern pattern = Pattern.compile(regexp);
                    Matcher matcher = pattern.matcher(e.getArgs()[0]);
                    if (matcher.find()) {
                        String str = matcher.group(1);
                        log.error("上报银行错误=====" + str);
                        if (li.size() == 1) {
                            throw new SystemRuntimeException(ErrorCode.BSMPS001, str);
                        }
                    }
                    log.error("上报银行异常", e);
                }
            }
            if (num.get() > 0) {
                int successInt = li.size() - num.get();
                throw new SystemRuntimeException(ErrorCode.BSMPS001, "共上报：" + li.size() + "条。成功：" + successInt + "条。失败：" + num.get() + "条");
            }

        }

    }

    private void checkMerchantRequiredParam(String account) {
        MerchantInfoDO merchantInfo = new MerchantInfoDO();
        merchantInfo.setAccount(account);
        MerchantInfoDO merchantInfoDO = merchantInfoMapper.selectOne(merchantInfo);
        AccountInfoDO accountInfoDO = accountInfoMapper.getByAccount(merchantInfoDO.getAccount());
        if (Objects.isNull(merchantInfoDO)) {
            throwRequiredException(String.format("[%s]企业信息不存在", account));
        }
        if (Objects.isNull(accountInfoDO)) {
            throwRequiredException(String.format("[%s]企业账户信息不存在", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getEntName())) {
            throwRequiredException(String.format("[%s]企业名称不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getBusLicCode())) {
            throwRequiredException(String.format("[%s]营业执照号码不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getTelephone())) {
            throwRequiredException(String.format("[%s]手机号码不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getRegAddress())) {
            throwRequiredException(String.format("[%s]注册地址不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getRegisterFund())) {
            throwRequiredException(String.format("[%s]注册资本不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getBusinessScope())) {
            throwRequiredException(String.format("[%s]经营范围不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getLegalName())) {
            throwRequiredException(String.format("[%s]法人姓名不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getIdType())) {
            throwRequiredException(String.format("[%s]法人证件类型不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getIdCode())) {
            throwRequiredException(String.format("[%s]法人身份证号码不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getLegalIndate())) {
            throwRequiredException(String.format("[%s]法人身份证有效期不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getCustomerManager())) {
            throwRequiredException(String.format("[%s]客户经理不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getEnterpriseType())) {
            throwRequiredException(String.format("[%s]企业类型不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getEnterpriseSale())) {
            throwRequiredException(String.format("[%s]企业规模不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getEnterpriseEcoNature())) {
            throwRequiredException(String.format("[%s]企业经济性质不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getResidentType())) {
            throwRequiredException(String.format("[%s]居民类型不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getCountry())) {
            throwRequiredException(String.format("[%s]国籍不能为空", account));
        }
        if (StringUtils.isBlank(merchantInfoDO.getProsession())) {
            throwRequiredException(String.format("[%s]行业不能为空", account));
        }
        if (StringUtils.isBlank(accountInfoDO.getBusinessIndate())) {
            throwRequiredException(String.format("[%s]营业执照有效期不能为空", account));
        }
        MerchantInfoDO busLicPic = merchantInfoMapper.getByIdForImage(account, "bus_lic_pic");
        if (StringUtils.isBlank(busLicPic.getBusLicPic())) {
            throwRequiredException(String.format("[%s]营业执照图片不能为空", account));
        }
        MerchantInfoDO personPic = merchantInfoMapper.getByIdForImage(account, "person_pic");
        if (StringUtils.isBlank(personPic.getPersonPic())) {
            throwRequiredException(String.format("[%s]法人身份证正面不能为空", account));
        }
        MerchantInfoDO personReversePic = merchantInfoMapper.getByIdForImage(account, "person_reverse_pic");
        if (StringUtils.isBlank(personReversePic.getPersonReversePic())) {
            throwRequiredException(String.format("[%s]法人身份证反面不能为空", account));
        }
    }

    private void throwRequiredException(String message) {
        SystemRuntimeException exception = new SystemRuntimeException(ErrorCode.BSMPS001, message);
        exception.setMessage(message);
        throw exception;
    }

    @Override
    public AaccountElectronicReceiptDO getAccounElectronic(String account) {
        if (account == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        AaccountElectronicReceiptDO res = mapper.getAccounElectronic(account);
        if (res == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return res;
    }

    /**
     * @param account
     * @return
     */
    private List<MerchantAccountInfoDO> getBankList(String account) {
        if (StringUtils.isNoneBlank(account)) {
            MerchantAccountInfoDO temDo = new MerchantAccountInfoDO();
            temDo.setAccount(account);
            List<MerchantAccountInfoDO> merlist = merchantAccountInfoMapper.selectList(temDo);
            return merlist;
        }
        return null;
    }

}
