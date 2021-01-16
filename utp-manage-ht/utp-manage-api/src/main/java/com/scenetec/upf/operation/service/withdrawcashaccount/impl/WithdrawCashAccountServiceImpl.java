package com.scenetec.upf.operation.service.withdrawcashaccount.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.domain.withdrawcashaccount.WithdrawCashAccountDO;
import com.scenetec.upf.operation.model.vo.withdrawcashaccount.WithdrawCashAccountVO;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.repository.withdrawcashaccount.WithdrawCashAccountMapper;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.service.withdrawcashaccount.WithdrawCashAccountService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WithdrawCashAccountServiceImpl implements WithdrawCashAccountService {
    @Resource
    UserService userService;
    @Resource
    WithdrawCashAccountMapper withdrawCashAccountMapper;
    @Resource
    IndustryMapper industryMapper;

    @Override
    public long create(WithdrawCashAccountVO obj) {
        WithdrawCashAccountDO cashAccountDO = new WithdrawCashAccountDO();
        cashAccountDO.setAccountNo(obj.getAccountNo());
        Integer res = withdrawCashAccountMapper.count(cashAccountDO);
        if (res > 0) {
            throw new SystemRuntimeException(ErrorCode.CASH001);
        }
        cashAccountDO = new WithdrawCashAccountDO();
        BeanUtils.copyProperties(obj, cashAccountDO);
        cashAccountDO.setGmtCreate(new Date());
        cashAccountDO.setUserCreate(userService.getUserContext().getUsername());
        cashAccountDO.setGmtModified(new Date());
        cashAccountDO.setUserModified(userService.getUserContext().getUsername());
        cashAccountDO.setStatus("1");
        cashAccountDO.setId(IdGenerate.getId());
        return withdrawCashAccountMapper.create(cashAccountDO);
    }

    @Override
    public int delete(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return withdrawCashAccountMapper.delete(id);
    }

    /**
     * 修改提现账户
     *
     * @param obj
     */
    @Override
    public void update(WithdrawCashAccountVO obj) {
        WithdrawCashAccountDO cashAccountDO = new WithdrawCashAccountDO();
        cashAccountDO.setId(obj.getId());
        cashAccountDO.setAccountNo(obj.getAccountNo());
        Integer res = withdrawCashAccountMapper.countExclusive(cashAccountDO);
        if (res > 0) {
            throw new SystemRuntimeException(ErrorCode.CASH001);
        }
        cashAccountDO = new WithdrawCashAccountDO();
        BeanUtils.copyProperties(obj, cashAccountDO);
        cashAccountDO.setGmtModified(new Date());
        cashAccountDO.setUserModified(userService.getUserContext().getUsername());
        cashAccountDO.setStatus(null);
        withdrawCashAccountMapper.update(cashAccountDO);
    }


    @Override
    public WithdrawCashAccountDO getById(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return withdrawCashAccountMapper.getById(id);
    }

    @Override
    public PageInfo<WithdrawCashAccountDO> list(Query obj) {
//        PageHelper.orderBy("gmt_modified asc");
        Map par = obj.getParameters();
        if (par.containsKey("account")) {
            IndustryDO tempIndu = new IndustryDO();
            tempIndu.setAccount(par.get("account").toString());
            tempIndu = industryMapper.selectOne(tempIndu);
            if (tempIndu != null) {
                par.put("industryId", tempIndu.getId());
            } else {
                List<WithdrawCashAccountDO> page = new ArrayList<>();
                return new PageInfo<>(page);
            }
        }
        par.put("status", "1");
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        List<WithdrawCashAccountDO> page = withdrawCashAccountMapper.listPage(par);
        return new PageInfo<>(page);
    }
}
