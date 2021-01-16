package com.scenetec.upf.operation.service.financialaccountstatement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.financialaccountstatement.FinancialAccountStatementDO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.financialaccountstatement.FinancialAccountStatementMapper;
import com.scenetec.upf.operation.repository.fundaccount.FundAccountMapper;
import com.scenetec.upf.operation.repository.industry.IndustryMapper;
import com.scenetec.upf.operation.service.financialaccountstatement.FinancialAccountStatementService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.zeus.daogenerator.model.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class FinancialAccountStatementAServiceImpl implements FinancialAccountStatementService {

    @Autowired
    FinancialAccountStatementMapper statementMapper;
    @Autowired
    IndustryMapper industryMapper;
    @Autowired
    FundAccountMapper fundAccountMapper;
    @Autowired
    AccountMapper accountMapper;

    @Autowired
    UserService userService;

    @Override
    public FinancialAccountStatementDO getById(Long id) {

        return statementMapper.getById(id);
    }

    @Override
    public PageInfo<FinancialAccountStatementDO> list(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
//        PageHelper.orderBy("id desc");
        Map parMap = obj.getParameters();
        List<FinancialAccountStatementDO> page = statementMapper.listPage(parMap);
        return new PageInfo<>(page);
    }

    @Override
    public PageInfo<FinancialAccountStatementDO> listDownload(Query obj) {
//        PageHelper.orderBy("id desc");
        Map parMap = obj.getParameters();
        List<FinancialAccountStatementDO> page = statementMapper.listPage(parMap);
        return new PageInfo<>(page);
    }

    @Override
    public Map<String, Long> countSum(Map<String, Object> parameters) {
        return statementMapper.countTrans(parameters);
    }


}
