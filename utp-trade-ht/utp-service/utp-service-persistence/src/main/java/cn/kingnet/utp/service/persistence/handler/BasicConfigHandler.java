package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.mapper.CertificateInfoMapper;
import cn.kingnet.utp.service.persistence.service.AccountService;
import cn.kingnet.utp.service.persistence.service.IndustryService;
import cn.kingnet.utp.service.persistence.service.MerchantInfoService;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.AuthConfigInfo;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.DesUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description : 基础信息，通用服务
 * @Author : linkaigui
 * @Create : 2019/2/22 15:26
 */
@RestController
@RequestMapping("/spi/persistence/basicConfig")
@Slf4j
public class BasicConfigHandler extends DefaultFeginExceptionHandler implements IBasicConfigHandler {

    /**
     * 该DES秘钥 必须与后管保持一致：约定不再变更。
     */
    @Value("${cn.kingnet.utp.manage.des-key:abcdefghijklmnopqrstuvwx}")
    private String KEY;

    @Resource
    private AccountService accountService;
    @Resource
    private IndustryService industryService;
    @Resource
    private MerchantInfoService merchantInfoService;
    @Resource
    private RedisTemplate<String, BasicConfigInfo> redisTemplate;

    /**
     * 获取平台关联证书信息，主要公私钥
     *
     * @param industryCode 平台客户号
     * @return
     */
    @Override
    public AuthConfigInfo getAuthConfigInfoByIndustry(@RequestParam(value = "industryCode") String industryCode) {
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "企业编号(平台编号)不能为空");
        }
        try {
            Map<String, Object> parameterMap = new HashMap<>(4);
            parameterMap.put("industryCode", industryCode);
            List<CertificateInfo> certList = MybatisDaoImpl.of(CertificateInfoMapper.class).selectListBySql("getIndustryCertList", parameterMap);
            return makeAuthConfigInfo(certList);
        } catch (Exception e) {
            log.error("获取关联证书异常：", e);
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "查无关联证书[失效或者未生效]，请联系管理员核实。");
        }
    }

    /**
     * 获取平台关联的基础配置信息
     * 参数非空校验都下放业务各自处理
     *
     * @param industryCode 平台代码
     * @param userAccount  用户账号
     * @param productCode  产品类型
     * @return
     */
    @Override
    public BasicConfigInfo getBasicConfigInfoByIndustry(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "userAccount", required = false) String userAccount, @RequestParam(value = "productCode", required = false) String productCode) {
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台客户号不能为空");
        }
        BasicConfigInfo basicConfigInfo = null;
        BoundValueOperations<String, BasicConfigInfo> userAccountBVO = null;
        BoundValueOperations<String, BasicConfigInfo> industryBVO = null;
        if (StringUtil.isNotBlank(userAccount)) {
            String userAccountBasicConfigKey = RedisKey.fmtKey(RedisKey.BASIC_INDUSTRY_CONFIG, industryCode, userAccount);
            userAccountBVO = redisTemplate.boundValueOps(userAccountBasicConfigKey);
            if (userAccountBVO != null && (basicConfigInfo = userAccountBVO.get()) != null) {
                return basicConfigInfo;
            }
        } else {
            String basicConfigKey = RedisKey.fmtKey(RedisKey.BASIC_INDUSTRY_CONFIG, industryCode);
            industryBVO = redisTemplate.boundValueOps(basicConfigKey);
            if (industryBVO != null && (basicConfigInfo = industryBVO.get()) != null) {
                return basicConfigInfo;
            }
        }
        try {
            //1.获取平台客户信息
            IndustryCondition industryCondition = IndustryCondition.builder().andCodeEq(industryCode).andStatusEq(TrueOrFalseStatus.TRUE.value());
            Industry industry = industryService.selectOne(industryCondition.build());
            if (industry == null || !VirtualAccountType.INDUSTRY.getType().equals(industry.getIndustryType())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "查无此平台客户信息,请联系管理员");
            }
            if (!AuditStatus.APPROVED.getStatus().equals(industry.getAuditStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台客户未审核通过,请联系管理员");
            }
            if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台客户状态不可用,请联系管理员");
            }
            if (StringUtil.isBlank(industry.getFundAccount())) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "资金账号未配置,请联系管理员");
            }
            basicConfigInfo = new BasicConfigInfo();
            basicConfigInfo.setIndustryId(industry.getId());
            basicConfigInfo.setIndustryCode(industry.getCode());
            basicConfigInfo.setIndustryName(industry.getName());
            basicConfigInfo.setSimpleName(industry.getSimpleName());
            basicConfigInfo.setIndustryType(industry.getIndustryType());
            basicConfigInfo.setFundAccount(industry.getFundAccount());
            basicConfigInfo.setIndustryAccount(industry.getAccount());
            basicConfigInfo.setInnerNoticeUrl(industry.getInnerNoticeUrl());
            basicConfigInfo.setOrgCode(industry.getOrgCode());
            basicConfigInfo.setOrgName(industry.getOrgName());
            basicConfigInfo.setBusinessType(industry.getBusinessType());
            basicConfigInfo.setIsOpenBalancePay(industry.getIsOpneBalancePay());
            basicConfigInfo.setBalancePayPeriod(industry.getBalancePayPeriod());
            basicConfigInfo.setIsOpenDoubleAcc(industry.getIsOpneDoubleAcc());
            basicConfigInfo.setNeedPublicAuthAmt(industry.getNeedPublicAuthAmt());
            basicConfigInfo.setAbleBindMultiCard(industry.getAbleBindMultiCard());
            basicConfigInfo.setEntName(industry.getEntName());
            basicConfigInfo.setIndustryAccountNo(industry.getAccountNo());
            basicConfigInfo.setOpenSubSinglePay(industry.getOpenSubSinglePay());
            basicConfigInfo.setVerifyPayeeAccountSign(industry.getVerifyPayeeAccountSign());
            basicConfigInfo.setVerifyPayeeWhiteListSign(industry.getVerifyPayeeWhiteListSign());
            basicConfigInfo.setPayerSubType(industry.getPayerSubType());
            basicConfigInfo.setAbleTransOrderInit(industry.getAbleTransOrderInit());
            basicConfigInfo.setSubIncomeType(industry.getSubIncomeType());
            basicConfigInfo.setSubAccountOpenMax(industry.getSubAccountOpenMax());
            basicConfigInfo.setReconciliationMode(industry.getReconciliationMode());
            basicConfigInfo.setAbleDownloadDailyBalance(industry.getAbleDownloadDailyBalance());
            basicConfigInfo.setOpenAccountMode(industry.getOpenAccountMode());
            basicConfigInfo.setOpenShowCustomFlag(industry.getOpenShowCustomFlag());

            if (IndustryBusinessType.SPLIT.getType().equals(industry.getBusinessType())) {
                if (industry.getMaxBrokerageRate() == null || industry.getMaxBrokerageRate() < 0) {
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, "分账业务客户号必须设置收取最高佣金比例");
                }
                basicConfigInfo.setMaxBrokerageRate(industry.getMaxBrokerageRate());
                // 分账业务才有可能需要开通 佣金账户
                Account brokerageAccount = accountService.getBrokerageAccount(industryCode);
                if (brokerageAccount != null && StringUtil.isNotEmpty(brokerageAccount.getAccount())) {
                    basicConfigInfo.setIndustryBrokerageAccount(brokerageAccount.getAccount());
                }
            }


            //2.手续费支出账户
            basicConfigInfo.setFeeExpenditureId(industry.getFeeExpenditureAccount());
            if (industry.getFeeExpenditureAccount() != null && industry.getFeeExpenditureAccount().compareTo(industry.getId()) == 0) {
                basicConfigInfo.setFeeAccount(industry.getAccount());
                basicConfigInfo.setFeeAccountName(industry.getName());
            } else if (industry.getFeeExpenditureAccount() != null) {
                Industry feeIndustry = industryService.selectOne(IndustryCondition.builder().andIdEq(industry.getFeeExpenditureAccount()).build());
                if (feeIndustry != null) {
                    basicConfigInfo.setFeeAccount(feeIndustry.getAccount());
                    basicConfigInfo.setFeeAccountName(feeIndustry.getName());
                }
            }

            //3.手续费收益账户
            basicConfigInfo.setFeeIncomeId(industry.getProcessingFeeIncomeAccount());
            if (industry.getProcessingFeeIncomeAccount() != null && industry.getProcessingFeeIncomeAccount().compareTo(industry.getId()) == 0) {
                basicConfigInfo.setFeeIncomeAccount(industry.getAccount());
                basicConfigInfo.setFeeIncomeAccountName(industry.getName());
            } else if (industry.getProcessingFeeIncomeAccount() != null) {
                Industry feeIncomeIndustry = industryService.selectOne(IndustryCondition.builder().andIdEq(industry.getProcessingFeeIncomeAccount()).build());
                if (feeIncomeIndustry != null) {
                    basicConfigInfo.setFeeIncomeAccount(feeIncomeIndustry.getAccount());
                    basicConfigInfo.setFeeIncomeAccountName(feeIncomeIndustry.getName());
                }
            }

            //3.小额打款支出账户
            basicConfigInfo.setAuthPaymentAccountId(industry.getAuthPaymentAccountId());
            if (industry.getAuthPaymentAccountId() != null && industry.getAuthPaymentAccountId().compareTo(industry.getId()) == 0) {
                basicConfigInfo.setAuthPaymentAccount(industry.getAccount());
                basicConfigInfo.setAuthPaymentAccountName(industry.getName());
            } else if (industry.getAuthPaymentAccountId() != null) {
                Industry authPaymentIndustry = industryService.selectOne(IndustryCondition.builder().andIdEq(industry.getAuthPaymentAccountId()).build());
                if (authPaymentIndustry != null) {
                    basicConfigInfo.setAuthPaymentAccount(authPaymentIndustry.getAccount());
                    basicConfigInfo.setAuthPaymentAccountName(authPaymentIndustry.getName());
                }
            }

            //4.设置产品编号
            if (StringUtil.isNotBlank(productCode)) {
                String productNo = ProductNo.getNoByCode(productCode);
                if (StringUtil.isBlank(productNo)) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "产品类型错误!");
                }
                basicConfigInfo.setProductNo(productNo);
                basicConfigInfo.setProductCode(productCode);
            }

            //5.获取资金帐号信息
            FundAccount fundAccount = MybatisDaoImpl.run().selectOne(FundAccountCondition.builder().andBankAccountNoEq(industry.getFundAccount()).andStatusEq(TrueOrFalseStatus.TRUE.value()).build());
            if (fundAccount == null) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "资金账号未配置!");
            }
            basicConfigInfo.setCustNumber(fundAccount.getBankAccountNo());
            basicConfigInfo.setCustAccountNo(fundAccount.getBankAccountNo());
            basicConfigInfo.setCustAccountName(fundAccount.getBankAccountName());
            //存量数据为内部户故默认为1
            basicConfigInfo.setFundAccType(StringUtil.isEmpty(fundAccount.getAccountType()) ? FundAccType.INNER_ACC.getType() : fundAccount.getAccountType());

            //6.获取商户信息/个人信息 userType 0=个人 1=商户
            if (StringUtil.isNotBlank(userAccount)) {
                MerchantInfo merchantInfo = merchantInfoService.selectOne4AllNature(userAccount);
                if (merchantInfo == null || StringUtil.isEmpty(merchantInfo.getStatus())) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("账户%s不存在!", userAccount));
                }
                if (AccountStatus.NO_OPEN.getCode().intValue() == Integer.parseInt(merchantInfo.getStatus())) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("账户%s未开户!", userAccount));
                }
                if (AccountStatus.CANCEL.getCode().intValue() == Integer.parseInt(merchantInfo.getStatus())) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("账户%s已销户!", userAccount));
                }

                basicConfigInfo.setMerNo(merchantInfo.getMerNo());
                basicConfigInfo.setMerName(merchantInfo.getMerName());
                basicConfigInfo.setNameAbbreviation(merchantInfo.getNameAbbreviation());
                basicConfigInfo.setUserAccount(userAccount);
                basicConfigInfo.setUserType(merchantInfo.getUserType());
                basicConfigInfo.setUserAccountStatus(merchantInfo.getStatus());
                basicConfigInfo.setUserIndustryCode(merchantInfo.getIndustryCode());
                basicConfigInfo.setUserAuthStatus(merchantInfo.getAuthStatus());

                Account userAccountDB = MybatisDaoImpl.run().selectOne(AccountCondition.builder().andAccountEq(userAccount).build());
                if (userAccountDB == null || StringUtil.isEmpty(userAccountDB.getStatus())) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("用户账户%s不存在!", userAccount));
                }
                if (VirtualAccountStatus.CANCEL.getType().equals(userAccountDB.getStatus())) {
                    throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("用户账户%s已销户!", userAccount));
                }
                basicConfigInfo.setUserAccountNature(userAccountDB.getObjType());
                basicConfigInfo.setUserFeeTemplateId(userAccountDB.getFeeTemplateId());
                basicConfigInfo.setUserFundAccount(userAccountDB.getFundAccount());
            }

            //查询平台账户状态是否被冻结
            if (StringUtil.isNotBlank(industry.getAccount())) {
                PlusEntityWrapper<Account> warp = AccountCondition.builder().andAccountEq(industry.getAccount()).build();
                Account account = MybatisDaoImpl.run().selectOne(warp);
                if (null != account) {
                    basicConfigInfo.setAccountStatus(account.getStatus());
                }
            }
            // 平台缓存超时时间4至5min随机
            if (industryBVO != null) {
                industryBVO.set(basicConfigInfo, new Random().nextInt(60) + 240, TimeUnit.SECONDS);
            }
            //平台+用户 缓存1-2min随机超时
            if (StringUtil.isNotBlank(userAccount) && userAccountBVO != null) {
                userAccountBVO.set(basicConfigInfo, new Random().nextInt(60) + 60, TimeUnit.SECONDS);
            }
            return basicConfigInfo;
        } catch (Exception e) {
            delIndustryAndAccountInRedis(industryCode, userAccount);
            log.error("无法获取平台客户基本信息!", e);
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "无法获取平台客户基本信息:" + e.getMessage());
        }
    }

    private void delIndustryAndAccountInRedis(String industryCode, String userAccount) {
        try {
            if (StringUtil.isNotBlank(userAccount)) {
                String userAccountBasicConfigKey = RedisKey.fmtKey(RedisKey.BASIC_INDUSTRY_CONFIG, industryCode, userAccount);
                redisTemplate.delete(userAccountBasicConfigKey);
            }
            if (StringUtil.isNotBlank(industryCode)) {
                String industryCodeBasicConfigKey = RedisKey.fmtKey(RedisKey.BASIC_INDUSTRY_CONFIG, industryCode);
                redisTemplate.delete(industryCodeBasicConfigKey);
            }
        } catch (Exception e) {
            log.error("删除basicConfigInfo缓存异常:{}", e.getMessage(), e);
        }
    }

    private AuthConfigInfo makeAuthConfigInfo(List<CertificateInfo> certList) {
        if (certList != null && certList.size() > 0) {
            AuthConfigInfo tempInfo = new AuthConfigInfo();
            certList.stream()
                    //生效时间早于当前时间
                    .filter(o -> DateUtil.getDateFromString(o.getEffectiveDate(), "yyyy-MM-dd").before(new Date()))
                    //失效时间晚于当前时间
                    .filter(o -> DateUtil.getDateFromString(o.getExpirationDate(), "yyyy-MM-dd").after(new Date()))
                    //根据证书类型分组
                    .collect(Collectors.groupingBy(CertificateInfo::getCertificateType)).forEach((type, list) -> {
                if (CommonConstants.ORG_CERT_TYPE.equals(type)) {
                    CertificateInfo certificateInfo = list.stream().findFirst().get();
                    tempInfo.setMer4UtpPublickey(DesUtil.decryptThreeDESECB(certificateInfo.getPublicKey(), KEY));
                } else if (CommonConstants.CHANNEL_CERT_TYPE.equals(type)) {
                    CertificateInfo certificateInfo = list.stream().findFirst().get();
                    tempInfo.setUtpSignPrivatekey(DesUtil.decryptThreeDESECB(certificateInfo.getPrivateKey(), KEY));
                }
            });
            //FIXME 暂默认都为RSA，待后管提供参数配置
            tempInfo.setSignType(CommonConstants.AUTHORIZATION_TYPE_RSA);
            tempInfo.setLastTime(new Date());
            return tempInfo;
        }
        return null;
    }

    @PostMapping("/getIndustryByIndustryCode")
    @Override
    public Industry getIndustryByIndustryCode(@RequestParam(value = "industryCode", required = false) String industryCode) {
        //1.获取平台客户信息
        Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(industryCode).build());
        if (industry == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "查无此平台客户信息,请联系管理员");
        }
        if (!AuditStatus.APPROVED.getStatus().equals(industry.getAuditStatus())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台客户未审核通过,请联系管理员");
        }
        if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台客户状态不可用,请联系管理员");
        }
        if (StringUtil.isBlank(industry.getFundAccount())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "资金账号未配置,请联系管理员");
        }
        return industry;
    }


}
