package com.scenetec.upf.operation.service.industry.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.OpenAccountModeEnum;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.account.AccountDetailDO;
import com.scenetec.upf.operation.model.domain.channel.ChannelIndustryDO;
import com.scenetec.upf.operation.model.domain.fundaccount.FundAccountDO;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.industry.status.IndustryTypeEnum;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.vo.AccountInfoVO;
import com.scenetec.upf.operation.model.vo.UploadIndustryMerchantImagesReqDTO;
import com.scenetec.upf.operation.model.vo.UploadIndustryMerchantImagesRespDTO;
import com.scenetec.upf.operation.model.vo.industry.IndustryDataVO;
import com.scenetec.upf.operation.model.vo.industry.IndustryVO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.channel.ChannelIndustryMapper;
import com.scenetec.upf.operation.repository.fundaccount.FundAccountMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.industryamtlimit.IndustryAmtLimitMapper;
import com.scenetec.upf.operation.repository.merchant.MerchantInfoMapper;
import com.scenetec.upf.operation.repository.whitelist.WhiteListMapper;
import com.scenetec.upf.operation.service.imageHanlder.ImageHanlderService;
import com.scenetec.upf.operation.service.industry.IndustryAccountInfoService;
import com.scenetec.upf.operation.service.industry.IndustryService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@Service
@Slf4j
public class IndustryServiceImpl implements IndustryService {
    Logger logger = LoggerFactory.getLogger(IndustryServiceImpl.class);
    @Resource
    IndustryMapper mapper;
    @Resource
    UserService userService;
    @Resource
    MerchantInfoMapper merMapper;
    @Resource
    AccountMapper accountMapper;
    @Resource
    FundAccountMapper fundAccountMapper;
    @Resource
    WhiteListMapper whiteListMapper;

    @Resource
    IndustryAmtLimitMapper industryAmtLimitMapper;

    @Resource
    IndustryAccountInfoService industryAccountInfoService;
    @Value("${virtualAccount.url}")
    private String url;
    @Resource
    ChannelIndustryMapper channelIndustryMapper;
    @Resource
    ImageHanlderService imageHanlderService;
    @Resource
    private Environment env;

    //创建虚拟账户

    /**
     * 虚拟账户的生成规则：4位资金账户编号+8位序号+2位随机码
     * 引用
     *
     * @param obj
     */
    void createVirtualAccount(IndustryDO obj) {
        AccountDO accountDO = new AccountDO();
        accountDO.setAccount(obj.getAccount());
        //accountDO.setAccount(obj.getCode());
        //channel_type和obj_type值相同
        String typeStr = obj.getIndustryType();
        accountDO.setObjType(typeStr);
        accountDO.setObjCode(obj.getCode());
        accountDO.setObjName(obj.getName());
        accountDO.setBalance(0L);
        accountDO.setAvailAmount(0L);
        accountDO.setFrozenAmount(0L);
        accountDO.setGmtCreate(new Date());
        accountDO.setGmtModified(new Date());
        accountDO.setUserCreate(userService.getUserContext().getUsername());
        accountDO.setUserModified(userService.getUserContext().getUsername());
        accountDO.setFundAccount(obj.getFundAccount());
        accountDO.setStatus("1");
        accountDO.setIndustryId(obj.getId());
        accountDO.setId(IdGenerate.getId());
        accountMapper.create(accountDO);
    }

    void enableAccount(IndustryDO obj) {
        AccountDO accountDO = new AccountDO();
        accountDO.setStatus("1");
        accountDO.setObjType(obj.getIndustryType());
        accountDO.setObjCode(obj.getCode());
        accountDO.setObjName(obj.getName());
        accountDO.setAccount(obj.getAccount());
        accountDO.setFundAccount(obj.getFundAccount());
        accountDO.setGmtModified(new Date());
        accountDO.setUserModified(userService.getUserContext().getUsername());
        accountDO.setIndustryId(obj.getId());
        accountMapper.updateByObjById(accountDO);
    }

    void disableAccount(String objCode, String ObjType, Long objId) {
        AccountDO accountDO = new AccountDO();
        accountDO.setStatus("0");
        accountDO.setObjType(ObjType);
        accountDO.setObjCode(objCode);
        accountDO.setIndustryId(objId);
        accountMapper.updateByObj(accountDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long create(IndustryVO objVO) {
        IndustryDO obj = new IndustryDO();
        BeanUtils.copyProperties(objVO, obj);
        obj.setGmtCreate(new Date());
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        obj.setStatus("1");
        //channel_type和obj_type值相同
        String typeStr = obj.getIndustryType();
        if (!IndustryTypeEnum.contains(typeStr)) {
            throw new SystemRuntimeException(ErrorCode.BSMIM005);
        }
        //客户名称不能重复
        IndustryDO industryDO = new IndustryDO();
        industryDO.setName(obj.getName());
        if (mapper.count(industryDO) != 0) {
            if (objVO.getIndustryType().equals("1")) {
                throw new SystemRuntimeException(ErrorCode.BSMIM002);
            }
            throw new SystemRuntimeException(ErrorCode.BSMIM009);

        }
        //行业代码不能重复
        IndustryDO tempindustryDO = new IndustryDO();
        tempindustryDO.setCode(obj.getCode());
        if (mapper.count(tempindustryDO) > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMIM001);
        }
        // 无限制的来款上账时，需要校验一个资金账户下仅一个客户号
        if ("1".equals(Objects.toString(obj.getIndustryIncomeType(), "0"))) {
            IndustryDO fundIndustryDO = new IndustryDO();
            fundIndustryDO.setFundAccount(objVO.getFundAccount());
            fundIndustryDO.setIndustryType(IndustryTypeEnum.CHAN_BUSINESS.getValue());
            if (mapper.count(fundIndustryDO) > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM011);
            }
        } else {
            IndustryDO fundIndustryDO = new IndustryDO();
            fundIndustryDO.setFundAccount(objVO.getFundAccount());
            fundIndustryDO.setIndustryIncomeType(1);
            if (mapper.count(fundIndustryDO) > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM012);
            }
        }
        industryDO.setName(null);
        industryDO.setStatus(null);
        industryDO.setCode(obj.getCode());
        IndustryDO platform = mapper.selectOne(industryDO);
        //虚拟账户的生成规则：4位资金账户编号+8位序号+2位随机码。目前是通过联机那边获取，把4位数的资金账户编号传到连接，获取虚拟账号号码
        //http://ip:9806/spi/persistence/account/createAccountNo 参数 accountNum，为账户资金编号(4位)
        String accountNum = call(obj.getAccount());
        obj.setAccount(accountNum);
        if (platform == null) {
            //目前只有平台的账户需要审核其余类型的不需要审核，默认审核通过
            if (obj.getIndustryType().equals(IndustryTypeEnum.CHAN_BUSINESS.getValue())) {
                obj.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
            } else {
                obj.setAuditStatus(AuditStatusEnum.AUDIT_PASS.getValue());
            }
            obj.setId(IdGenerate.getId());
            Long resId = mapper.create(obj);
            //如果支出账户选择自己的时候获取id并保存fee_expenditure_account的ID指向本身
            if (obj.getIndustryType().equals(IndustryTypeEnum.CHAN_BUSINESS.getValue()) &&
                    obj.getFeeExpenditureAccount().equals(-1L)) {
                IndustryDO tempIndustry = mapper.getById(obj.getId());
                tempIndustry.setFeeExpenditureAccount(tempIndustry.getId());
                mapper.update(tempIndustry);
            }
            if (obj.getIndustryType().equals(IndustryTypeEnum.CHAN_BUSINESS.getValue())) {
                //代付客户审核通过再创建虚拟账户
            } else {
                //创建虚拟账户
                createVirtualAccount(obj);
            }

        } else if (platform.getStatus().equals("0")) {
            obj.setId(platform.getId());
            mapper.update(obj);
            enableAccount(obj);
        } else {
            throw new SystemRuntimeException(ErrorCode.BSMIM001);
        }

        return obj.getId();
    }

    /**
     * 删除手续费账户的逻辑是，如果添加代付客户管理添加时，有选中的账号不能删除。
     * 删除商户账号的逻辑维持原来的不变
     * 如果代付客户关联了用户，不能删除
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public int delete(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        IndustryDO industryDO = mapper.getById(id);
        //已经被配置的小额打款支出账户不能删除
        if (IndustryTypeEnum.SMALL_AMOUNT_PAYMENT_ACCOUNT.getValue().equals(industryDO.getIndustryType())) {
            IndustryDO ind = new IndustryDO();
            ind.setAuthPaymentAccountId(id);
            Integer collInt = mapper.count(ind);
            if (collInt > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "该小额打款支出账户已经被配置不能删除");
            }
        }
        //已经被配置的归集账户不能删除
        if (IndustryTypeEnum.CHAN_IMPUTATION_FEEACCOUNT.getValue().equals(industryDO.getIndustryType())) {
            IndustryDO ind = new IndustryDO();
            ind.setCollectionIndustryId(id);
            Integer collInt = mapper.count(ind);
            if (collInt > 0) {
                throw new SystemRuntimeException(ErrorCode.BSMSC006, "该归集账户已经被配置不能删除");
            }
        }
        //代付客户号有配置额度的，不能删除
        IndustryAmtLimitDO industryAmtLimitDO = new IndustryAmtLimitDO();
        industryAmtLimitDO.setIndustryCode(industryDO.getCode());
        Integer countLimit = industryAmtLimitMapper.count(industryAmtLimitDO);
        if (countLimit > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "该客户号有配置限额不允许删除!");
        }

        //商户账号
        if (IndustryTypeEnum.CHAN_BUSINESS.getValue().equals(industryDO.getIndustryType())
                || IndustryTypeEnum.CHAN_IMPUTATION_FEEACCOUNT.getValue().equals(industryDO.getIndustryType())) {
            ChannelIndustryDO channelIndustryDO = new ChannelIndustryDO();
            channelIndustryDO.setIndustryCode(industryDO.getCode());
            if (channelIndustryMapper.count(channelIndustryDO) > 0) {//关联
                throw new SystemRuntimeException(ErrorCode.BSMIM003);
            }
            MerchantInfoDO merchantInfoDO = new MerchantInfoDO();
            merchantInfoDO.setIndustryCode(industryDO.getCode());
            if (merMapper.count(merchantInfoDO) != 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM003);
            }
            //无同步资金，无交易 可以删除（虚拟账户详情列表无记录可删除）
            AccountDO oneAccount = new AccountDO();
            oneAccount.setIndustryId(industryDO.getId());
            oneAccount = accountMapper.selectOne(oneAccount);
            if (oneAccount != null) {
                Map map = new HashMap();
                map.put("account", oneAccount.getAccount());
                Page<AccountDetailDO> page = accountMapper.pageListDetail(map);
                if (page.size() > 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMIM003);
                }
                accountMapper.delete(oneAccount.getId());
            }

            industryAccountInfoService.deleteByIndustryCode(industryDO.getCode(), industryDO.getIndustryType());
            return mapper.delete(id);
        }
        //手续费账户 被关联后无法删除
        if (industryDO.getIndustryType().equals(IndustryTypeEnum.CHAN_INCOME_FEEACCOUNT.getValue())
                || industryDO.getIndustryType().equals(IndustryTypeEnum.CHAN_PAY_FEEACCOUNT.getValue())
                || IndustryTypeEnum.SMALL_AMOUNT_PAYMENT_ACCOUNT.getValue().equals(industryDO.getIndustryType())) {
            IndustryDO tempIndustryDO = new IndustryDO();
            tempIndustryDO.setFeeExpenditureAccount(id);
            if (mapper.count(tempIndustryDO) != 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM008);
            }
            tempIndustryDO = new IndustryDO();
            tempIndustryDO.setProcessingFeeIncomeAccount(id);
            if (mapper.count(tempIndustryDO) != 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM008);
            }
            AccountDO oneAccount = new AccountDO();
            oneAccount.setIndustryId(industryDO.getId());
            oneAccount = accountMapper.selectOne(oneAccount);
            if (oneAccount != null) {
                accountMapper.delete(oneAccount.getId());
            }
            industryAccountInfoService.deleteByIndustryCode(industryDO.getCode(), industryDO.getIndustryType());
            return mapper.delete(id);
        }

        return 1;

    }

    @Override
    @Transactional
    public void update(IndustryVO objVO) {
        try {
            IndustryDO obj = new IndustryDO();
            BeanUtils.copyProperties(objVO, obj);
            //channel_type和obj_type值相同
            String typeStr = obj.getIndustryType();
            if (!IndustryTypeEnum.contains(typeStr)) {
                throw new SystemRuntimeException(ErrorCode.BSMIM005);
            }
            //代付客户号不能重复
            obj.setGmtModified(new Date());
            obj.setUserModified(userService.getUserContext().getUsername());
            IndustryDO industryDO = new IndustryDO();
            industryDO.setId(obj.getId());
            industryDO.setCode(obj.getCode());
            if (mapper.count(industryDO) != 0) {
                throw new SystemRuntimeException(ErrorCode.BSMIM001);
            }
            //客户名称不能重复
            industryDO.setCode(null);
            industryDO.setName(obj.getName());
            if (mapper.count(industryDO) != 0) {
                if (objVO.getIndustryType() == "1") {
                    throw new SystemRuntimeException(ErrorCode.BSMIM002);
                }
                throw new SystemRuntimeException(ErrorCode.BSMIM009);
            }
            IndustryDO industry = mapper.getById(obj.getId());
            if (!industry.getCustNumber().equals(obj.getCustNumber())) {
                if (mapper.checkByCustNumber(obj.getCode(), obj.getCustNumber()) != 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMIM004);
                }
            }
            obj.setAccount(industry.getAccount());
            //已经审核通过的资金账号不能修改
            if (industry.getAuditStatus().equals(AuditStatusEnum.AUDIT_PASS.getValue()) &&
                    !obj.getFundAccount().equals(industry.getFundAccount())) {
                throw new SystemRuntimeException(ErrorCode.BSMIM010);
            }
            if (AuditStatusEnum.AUDIT_PASS.getValue().equals(industry.getAuditStatus())
                    && OpenAccountModeEnum.OPEN.getCode().equals(industry.getOpenAccountMode())
                    && !industry.getOpenAccountMode().equals(objVO.getOpenAccountMode())) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, "审核已经通过，开户模式开户时上传图片资料(新)不允许修改");
            }
            mapper.update(obj);
            //如果支出账户选择自己的时候获取id并保存fee_expenditure_account的ID指向本身
            if (obj.getIndustryType().equals(IndustryTypeEnum.CHAN_BUSINESS.getValue()) &&
                    obj.getFeeExpenditureAccount().equals(-1L)) {
                IndustryDO tempIndustry = mapper.getById(obj.getId());
                tempIndustry.setFeeExpenditureAccount(tempIndustry.getId());
                mapper.update(tempIndustry);
            }
            //修改虚拟账户
            enableAccount(obj);
            //修改白名单
            WhiteListDO whiteListDO = new WhiteListDO();
            whiteListDO.setIndustryCode(obj.getCode());
            whiteListDO.setMerName(obj.getName());
            whiteListMapper.updateByIndustryCode(whiteListDO);
        } catch (SystemRuntimeException e) {
            throw e;
        } catch (Exception e) {
            log.error("客户更新异常", e);
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "更新失败，请检查输入");
        }

    }

    /**
     * 更新审核状态  审核通过创建虚拟账户
     *
     * @param obj
     */
    @Override
    @Transactional
    public void updateAuditStatus(IndustryVO obj) {
        if (obj.getAuditStatus() == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (!AuditStatusEnum.contains(obj.getAuditStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        //如果没有添加添加资料无法审批
        IndustryDO tempIndDo = mapper.getById(obj.getId());
        if (StringUtils.isEmpty(tempIndDo.getIdCode()) ||
                StringUtils.isEmpty(tempIndDo.getBusLicPic())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "无法审批,请先添加资料!");
        }

        IndustryDO industryDO = new IndustryDO();
        industryDO.setAuditStatus(obj.getAuditStatus());
        industryDO.setId(obj.getId());
        mapper.updateAuditStatus(industryDO);
        if (obj.getAuditStatus().equals(AuditStatusEnum.AUDIT_PASS.getValue())) {
            industryDO = mapper.getById(obj.getId());
            //创建虚拟账户
            createVirtualAccount(industryDO);
        }
    }

    @Override
    public IndustryDO getById(Long id, String exImage) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        IndustryDO industryDO;
        if (org.apache.commons.lang3.StringUtils.isNoneBlank(exImage) && exImage.equals("exImage")) {
            industryDO = mapper.getByIdExImage(id);//不需要获取图片影响响应速度
        } else {
            industryDO = mapper.getById(id);
            if (industryDO != null) {
                Map map = new HashMap();
                map.put("account", industryDO.getAccount());
                map.put("objType", industryDO.getIndustryType());
                try {
                    MerchantInfoDO merchantInfoDO = imageHanlderService.getImage(map);
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(merchantInfoDO.getPersonPic())) {
                        industryDO.setPersonPic(merchantInfoDO.getPersonPic());
                    } else {
                        industryDO.setPersonPic(null);
                    }
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(merchantInfoDO.getPersonReversePic())) {
                        industryDO.setPersonReversePic(merchantInfoDO.getPersonReversePic());
                    } else {
                        industryDO.setPersonReversePic(null);
                    }
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(merchantInfoDO.getLicensePic())) {
                        industryDO.setLicensePic(merchantInfoDO.getLicensePic());
                    } else {
                        industryDO.setLicensePic(null);
                    }
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(merchantInfoDO.getBusLicPic())) {
                        industryDO.setBusLicPic(merchantInfoDO.getBusLicPic());
                    } else {
                        industryDO.setBusLicPic(null);
                    }
                } catch (Exception e) {
                    if (e instanceof SystemRuntimeException) {
                        SystemRuntimeException systemRuntimeException = (SystemRuntimeException)e;
                        String msg = env.getProperty(systemRuntimeException.getCode().name());
                        msg = MessageFormatter.arrayFormat(msg, systemRuntimeException.getArgs()).getMessage();
                        systemRuntimeException.setMessage(msg);
                    }
                    logger.error("获取图片异常", e);
                }

            }
        }
        FundAccountDO fundAccountDO = new FundAccountDO();
        fundAccountDO.setBankAccountNo(industryDO.getFundAccount());
        fundAccountDO = fundAccountMapper.selectOne(fundAccountDO);
        if (fundAccountDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMIM006);
        }
        industryDO.setBankAccountNo(fundAccountDO.getBankAccountNo());
        industryDO.setBankAccountName(fundAccountDO.getBankAccountName());
        //industry_type 1:平台|行业账户,4-手续费收入账户 5-手续费支出账户'
        if (industryDO.getIndustryType().equals("1")) {//如果是代付客户才需要此操作
            IndustryDO industryDOIn = mapper.getById(industryDO.getProcessingFeeIncomeAccount());
            industryDO.setProcessingFeeIncomeAccountName(industryDOIn.getName());
            if (industryDO.getFeeExpenditureAccount().equals(-1L)) {
                industryDO.setFeeExpenditureAccountName(industryDO.getName());
            } else {
                IndustryDO industryDOout = mapper.getById(industryDO.getFeeExpenditureAccount());
                industryDO.setFeeExpenditureAccountName(industryDOout.getName());
            }
            //归集账户
            IndustryDO collectIndustryDO = mapper.getById(industryDO.getCollectionIndustryId());
            if (collectIndustryDO != null) {
                industryDO.setCollectionAccountName(collectIndustryDO.getName());
            }
            //如果之前选的自己，返回-1给前端
            if (id.equals(industryDO.getFeeExpenditureAccount())) {
                industryDO.setFeeExpenditureAccount(-1L);
            }
        }
        return industryDO;
    }

    @Override
    public IndustryDO getByAccount(String account) {
        if (account == null) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        IndustryDO tempDO = new IndustryDO();
        tempDO.setAccount(account);
        IndustryDO industryDO = mapper.selectOne(tempDO);
        if (industryDO == null) {
            throw new SystemRuntimeException(ErrorCode.BSMUM007);
        }
        FundAccountDO fundAccountDO = new FundAccountDO();
        fundAccountDO.setBankAccountNo(industryDO.getFundAccount());
        fundAccountDO = fundAccountMapper.selectOne(fundAccountDO);
        industryDO.setBankAccountNo(fundAccountDO.getBankAccountNo());
        industryDO.setBankAccountName(fundAccountDO.getBankAccountName());
        return industryDO;
    }

    @Override
    public IndustryDO getOneIndustry(IndustryDO obj) {
        return mapper.selectOne(obj);
    }

    @Override
    public Integer getOneIndustryCount(IndustryDO obj) {
        return mapper.count(obj);
    }

    @Override
    public PageInfo<IndustryDO> pageList(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map tempMap = query.getParameters();

        if (tempMap.get("customers") != null && tempMap.get("customers").equals("1")) {
            //代付客户管理，显示待审核的新增代付客户其余地方不显示  customers =1
            tempMap.put("status", "1");
        } else {
            tempMap.put("status", "1");
            tempMap.put("auditStatus", "1");
        }
        Page<IndustryDO> page = mapper.pageList(tempMap);
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<IndustryDO> pageListFeeAndAuthAccount(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map tempMap = query.getParameters();

        if (tempMap.get("customers") != null && tempMap.get("customers").equals("1")) {
            //代付客户管理，显示待审核的新增代付客户其余地方不显示  customers =1
            tempMap.put("status", "1");
        } else {
            tempMap.put("status", "1");
            tempMap.put("auditStatus", "1");
        }
        Page<IndustryDO> page = mapper.pageListFeeAndAuthAccount(tempMap);
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<IndustryDO> pageListExclude(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map tempMap = query.getParameters();
        tempMap.put("status", "1");
        tempMap.put("auditStatus", "1");
        Page<IndustryDO> page = mapper.pageListExclude(tempMap);
        return new PageInfo<>(page);
    }


    /**
     * 后管代付客户号那边新增一条校验规则：
     * 1.手续费收益账户 和 归集账户必须对应。
     * 也就是不同的代付客户号如果 选的是同一个手续费收益账户   那边归集账户也必须选同一个
     * 2.归集账户的对应的资金账户必须和客户号配置的不一样
     *
     * @param query
     * @return
     */
    @Override
    public PageInfo<IndustryDO> pageCollectionList(Query query) {
        Map tempMap = query.getParameters();
        String auditStatus = AuditStatusEnum.AUDIT_PASS.getValue();
        String industryType = IndustryTypeEnum.CHAN_IMPUTATION_FEEACCOUNT.getValue();
        tempMap.put("status", "1");
        tempMap.put("auditStatus", auditStatus);
        tempMap.put("industryType", industryType);
        if (tempMap.containsKey("processingFeeIncomeAccount")) {
            IndustryDO industryDO = new IndustryDO();
            industryDO.setProcessingFeeIncomeAccount(Long.valueOf(tempMap.get("processingFeeIncomeAccount").toString()));
            IndustryDO resDo = mapper.selectOneBylimit(industryDO);
            if (resDo != null && resDo.getCollectionIndustryId() != null && resDo.getCollectionIndustryId() > 0) {
                Map proMap = new HashMap();
                proMap.put("id", resDo.getCollectionIndustryId());
                tempMap.remove("processingFeeIncomeAccount");
                Page<IndustryDO> page = mapper.pageCollectionList(proMap);
                if (page.size() == 0) {
                    page = mapper.pageList(tempMap);
                }
                return new PageInfo<>(page);
            }
        }
        tempMap.remove("processingFeeIncomeAccount");
        Page<IndustryDO> page = mapper.pageList(tempMap);
        return new PageInfo<>(page);
    }

    /**
     * 费用账户列表查询
     *
     * @param query
     * @return
     */
    @Override
    public PageInfo<IndustryDO> pageListFeeAccount(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map map = query.getParameters();
        Page<IndustryDO> page = null;
        if (map.containsKey("containsKey") || map.get("industryType") == null) {
            map.put("industryTypePay", IndustryTypeEnum.CHAN_PAY_FEEACCOUNT.getValue());
            map.put("industryType", IndustryTypeEnum.CHAN_INCOME_FEEACCOUNT.getValue());
            map.put("industryTypeImputation", IndustryTypeEnum.CHAN_IMPUTATION_FEEACCOUNT.getValue());//归集账户
            map.put("authIndustryType", IndustryTypeEnum.SMALL_AMOUNT_PAYMENT_ACCOUNT.getValue());//小额打款支出账户
            page = mapper.pageListFeeAccount(map);
        } else {
            page = mapper.pageList(query.getParameters());
        }
//        if (!IndustryTypeEnum.contains(map.get("industryType").toString())) {
//            throw new SystemRuntimeException(ErrorCode.BSMIM005);
//        }
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<IndustryDO> industryListOnlyAccountSplittingBusiness(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Map map = query.getParameters();
        map.put("businessType", "1");//只能选择分账业务
        map.put("industryType", IndustryTypeEnum.CHAN_BUSINESS.getValue());
        List<IndustryDO> list = mapper.list(query.getParameters());
        return new PageInfo<>(list);
    }

    /**
     * 隐藏被选过的交易限额账号
     *
     * @param query
     * @return
     */
    @Override
    public PageInfo<IndustryDO> industryUnTransactionLimitList(Query query) {
        Map map = query.getParameters();
        List<IndustryDO> list = mapper.industryUnTransactionLimitList(query.getParameters());
        return new PageInfo<>(list);
    }

    @Override
    public List<IndustryDO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<IndustryDO> list = mapper.list(query.getParameters());
        return list;
    }

    @Override
    public PageInfo<IndustryDO> selectListWithCert(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<IndustryDO> page = mapper.selectListWithCert(query.getParameters());
        return new PageInfo<>(page);
    }

    /**
     * 完善账户信息
     *
     * @param industryDO
     * @return
     */
    @Override
    public void createIndustryAccountInfo(IndustryDataVO industryDO) {
        AccountInfoVO accountInfoVO = new AccountInfoVO();
        accountInfoVO.setAccount(industryDO.getAccountNo());
        accountInfoVO.setIndustryCode(industryDO.getCode());
        accountInfoVO.setBusLicPic(industryDO.getBusLicPic());
        accountInfoVO.setLicensePic(industryDO.getLicensePic());
        accountInfoVO.setPersonPic(industryDO.getPersonPic());
        accountInfoVO.setPersonReversePic(industryDO.getPersonReversePic());
        UploadIndustryMerchantImagesRespDTO respDTO = imageHanlderService.uploadImageReque(accountInfoVO);

        IndustryDO mer = new IndustryDO();
        mer.setEntName(industryDO.getEntName());//企业账户名称
        mer.setAccountNo(industryDO.getAccountNo());//企业账号
        mer.setRegAddress(industryDO.getRegAddress());//企业注册地址
        mer.setBusLicCode(industryDO.getBusLicCode());//营业执照号
        mer.setIdType(industryDO.getIdType());//法人证件类型
        mer.setIdCode(industryDO.getIdCode());//法人证件号
        mer.setBusLicPic(respDTO.getBusLicPicPath());//营业执照图片
        mer.setPersonPic(respDTO.getPersonPicPath());//法人证件正面图片
        mer.setPersonReversePic(respDTO.getPersonReversePicPath());//法人证件反面图片
        mer.setLicensePic(respDTO.getLicensePicPath());//开户许可证
        mer.setId(industryDO.getId());
        mer.setLegalPerson(industryDO.getLegalPerson());
        mer.setNationality(industryDO.getNationality());//客户国籍
        mer.setPhone(industryDO.getPhone());//联系人电话
        mer.setCustomerTrade(industryDO.getCustomerTrade());//客户行业
        mapper.update(mer);
    }

    @Override
    public boolean isExistFundAccount(String fundAccount) {
        IndustryDO fundIndustryDO = new IndustryDO();
        fundIndustryDO.setFundAccount(fundAccount);
        fundIndustryDO.setIndustryType(IndustryTypeEnum.CHAN_BUSINESS.getValue());
        if (mapper.count(fundIndustryDO) > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMIM011);
        }
        return true;
    }

    /**
     * 调用查询服务
     *
     * @return 返回结果
     */
    private String call(String par) {
        String response;
        try {
            // 执行查询
            RestTemplate restTemplate = new RestTemplate();
            // response = restTemplate.postForObject(url, query, String.class);
            String parStr = "?accountNum=" + par;
            response = restTemplate.getForObject(url + parStr, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SystemRuntimeException(ErrorCode.BSACCOUNT003, ex.getMessage());
        }
        return response;
    }
}
