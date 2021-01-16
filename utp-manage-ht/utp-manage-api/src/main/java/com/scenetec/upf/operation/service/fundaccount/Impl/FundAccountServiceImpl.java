package com.scenetec.upf.operation.service.fundaccount.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AccountTypeEnum;
import com.scenetec.upf.operation.model.Enum.FundUserTypeEnum;
import com.scenetec.upf.operation.model.Enum.TrueOrFalseEnum;
import com.scenetec.upf.operation.model.domain.account.FundAcctInfoDO;
import com.scenetec.upf.operation.model.domain.fundaccount.FundAccountDO;
import com.scenetec.upf.operation.model.domain.fundaccount.status.FundAccountTypeEnum;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.vo.ValidAccountInfoReqDTO;
import com.scenetec.upf.operation.model.vo.fundaccount.FundAccountVO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.account.FundAcctInfoMapper;
import com.scenetec.upf.operation.repository.fundaccount.FundAccountMapper;
import com.scenetec.upf.operation.service.fundaccount.FundAccountService;
import com.scenetec.upf.operation.service.industry.IndustryService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.upf.operation.utils.OnliineTool.OnlineRequestTool;
import com.scenetec.upf.operation.utils.SHA1;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class FundAccountServiceImpl implements FundAccountService {
    @Resource
    FundAccountMapper mapper;
    @Resource
    IndustryService service;
    @Resource
    UserService userService;
    @Resource
    AccountMapper accountMapper;
    @Resource
    OnlineRequestTool onlineRequestTool;
    @Value("${innerManage.validAccountInfo.url}")
    private String url;
    @Resource
    private FundAcctInfoMapper fundAcctInfoMapper;

    /**
     * 资金账号不允许重复
     * account_num(资金账户编号) 4位数不重复的值
     *
     * @param obj
     * @return
     */
    @Override
    @Transactional
    public long create(FundAccountVO obj) {
        //判断类型
        if (!FundUserTypeEnum.contains(obj.getUseType())) {
            throw new SystemRuntimeException(ErrorCode.BSMSC006, "使用类型错误");
        }
        FundAccountDO newAccount = new FundAccountDO();
        BeanUtils.copyProperties(obj, newAccount);
        //通过联机查行内的资金账户是不是已经存在
        ValidAccountInfoReqDTO validAccountInfoReqDTO = new ValidAccountInfoReqDTO();
        validAccountInfoReqDTO.setFundAccName(obj.getBankAccountName());
        validAccountInfoReqDTO.setFundAccNo(obj.getBankAccountNo());
        validAccountInfoReqDTO.setFundAccType(obj.getAccountType());
        try {
            validAccountInfoReqDTO.setSign(SHA1.genWithAmple(validAccountInfoReqDTO.toSHA1()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {

            onlineRequestTool.postResquest(url, validAccountInfoReqDTO);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "资金账户信息验证失败！");
        }


        //判断资金账号是否存在
        FundAccountDO tempAccount = new FundAccountDO();
        tempAccount.setBankAccountNo(obj.getBankAccountNo());
        int resCount = mapper.count(tempAccount);
        if (resCount > 0) {
            throw new SystemRuntimeException(ErrorCode.BSACCOUNT001);
        }
        tempAccount = new FundAccountDO();
        resCount = mapper.selMaxValue(tempAccount) + 1;
        String accountNum = String.format("%4d", resCount).replace(" ", "0");//4位数
        if (AccountTypeEnum.contains(obj.getAccountType()) == false) {
            throw new SystemRuntimeException(ErrorCode.BSACCOUNT004);
        }
        newAccount.setAccountNum(accountNum);
        newAccount.setGmtCreate(new Date());
        newAccount.setUserCreate(userService.getUserContext().getUsername());
        newAccount.setGmtModified(new Date());
        newAccount.setUserModified(userService.getUserContext().getUsername());
        newAccount.setStatus(FundAccountTypeEnum.CHAN_AVAILABLE.getValue());
        newAccount.setSynchronizationTime(new Date());
        newAccount.setAccountType(obj.getAccountType());
        newAccount.setCurrentBalance(0L);
        newAccount.setId(IdGenerate.getId());
        Long res = mapper.create(newAccount);
        if (TrueOrFalseEnum.TRUE.getValue().equals(obj.getReportAmlFlag())) {
            FundAcctInfoDO newFundAcctInfoDO = new FundAcctInfoDO();
            newFundAcctInfoDO.setFundAcct(obj.getBankAccountNo());
            newFundAcctInfoDO.setFundAcctName(obj.getBankAccountName());
            fundAcctInfoMapper.create(newFundAcctInfoDO);
        }
        return res;
    }

    /**
     * 代付客户有关联了资金账户(bank_account_no-->fund_account)，
     * 该数据不允许删除；没有关联的，可以删除。
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        FundAccountDO fundAccountDO = mapper.getById(id);
        //判断是否与代付客户已经关联
        IndustryDO industryDO = new IndustryDO();
        industryDO.setFundAccount(fundAccountDO.getBankAccountNo());
        Integer tempIndustry = service.getOneIndustryCount(industryDO);
        if (tempIndustry > 0) {
            throw new SystemRuntimeException(ErrorCode.BSACCOUNT002);
        }
        //直接删除，去掉软删除
        int res = mapper.delete(id);
        FundAcctInfoDO newFundAcctInfoDO = new FundAcctInfoDO();
        newFundAcctInfoDO.setFundAcct(fundAccountDO.getBankAccountNo());
        FundAcctInfoDO fundAcctInfoDO = fundAcctInfoMapper.selectOne(newFundAcctInfoDO);
        if (Objects.nonNull(fundAcctInfoDO)) {
            fundAcctInfoMapper.delete(fundAcctInfoDO.getId());
        }
        return res;
    }

    /**
     * 资金账户不允许重复。
     *
     * @param obj
     */
    @Override
    public void update(FundAccountVO obj) {
        FundAccountDO newAccount = new FundAccountDO();
        BeanUtils.copyProperties(obj, newAccount);
        if (!AccountTypeEnum.contains(obj.getAccountType())) {
            throw new SystemRuntimeException(ErrorCode.BSACCOUNT004);
        }
        // 资金账户编号不能修改
        newAccount.setAccountNum(null);
        newAccount.setGmtModified(new Date());
        newAccount.setUserModified(userService.getUserContext().getUsername());
        // 资金账号不能修改
        newAccount.setBankAccountNo(null);
        mapper.update(newAccount);
        FundAcctInfoDO newFundAcctInfoDO = new FundAcctInfoDO();
        newFundAcctInfoDO.setFundAcct(obj.getBankAccountNo());
        FundAcctInfoDO fundAcctInfoDO = fundAcctInfoMapper.selectOne(newFundAcctInfoDO);
        if (TrueOrFalseEnum.TRUE.getValue().equals(obj.getReportAmlFlag())) {
            if (Objects.isNull(fundAcctInfoDO)) {
                newFundAcctInfoDO.setFundAcctName(obj.getBankAccountName());
                fundAcctInfoMapper.create(newFundAcctInfoDO);
            }
        } else {
            if (Objects.nonNull(fundAcctInfoDO)) {
                fundAcctInfoMapper.delete(fundAcctInfoDO.getId());
            }
        }
    }

    @Override
    public FundAccountDO getById(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return mapper.getById(id);
    }

    @Override
    public PageInfo<FundAccountDO> list(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        Map parMap = obj.getParameters();
        parMap.put("status", FundAccountTypeEnum.CHAN_AVAILABLE.getValue());
        List<FundAccountDO> page = mapper.listPage(parMap);
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<FundAccountDO> fundAccountScreen(Query obj) {
        List<FundAccountDO> page = new ArrayList<>();
        try {
            obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
            obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
            PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
            PageHelper.orderBy("gmt_modified desc");
            Map parMap = obj.getParameters();
            page = mapper.listPageScreen(parMap);
        } catch (Exception e) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, "获取资金账户列表错误！");
        }
        return new PageInfo<>(page);
    }

    /**
     * 通过t_fund_account的bank_account_no == t_industry的fund_account
     * 再从 org_code和industry_type 组合 ==
     * t_account的 obj_code和obj_type查找出对应的虚拟账户
     * (获取资金账户查询代付客户所绑定的资金账户，的虚拟账户详情)
     * `frozen_amount` bigint(20) DEFAULT '0' COMMENT '冻结金额（单位分）',
     * `avail_amount` bigint(20) DEFAULT '0' COMMENT '可用金额（单位分）',
     * `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
     */
    @Override
    public PageInfo<Map<String, Object>> listDatail(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        Map parMap = obj.getParameters();
        if (parMap.get("bankAccountNo") == null) {
            throw new SystemRuntimeException(ErrorCode.BSMUM005);
        }
        String idStr = parMap.get("bankAccountNo").toString();
        List<Map<String, Object>> page = mapper.selectCustList(idStr);
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        if (parameters.get("bankAccountNo") == null) {
            throw new SystemRuntimeException(ErrorCode.BSMUM005);
        }
        String idStr = parameters.get("bankAccountNo").toString();
        return mapper.totalCount(idStr);
    }


}
