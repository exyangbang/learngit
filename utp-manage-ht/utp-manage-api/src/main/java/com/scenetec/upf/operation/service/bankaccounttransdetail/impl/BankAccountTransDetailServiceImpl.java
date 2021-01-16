package com.scenetec.upf.operation.service.bankaccounttransdetail.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.bankaccounttransdetail.BankAccountTransDetailDO;
import com.scenetec.upf.operation.repository.bankaccounttransdetail.BankAccountTransDetailMapper;
import com.scenetec.upf.operation.service.bankaccounttransdetail.BankAccountTransDetailService;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BankAccountTransDetailServiceImpl implements BankAccountTransDetailService {
    @Autowired
    BankAccountTransDetailMapper bankAccountTransDetailMapper;

    @Override
    public BankAccountTransDetailDO getById(Long id) {
        if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return bankAccountTransDetailMapper.getById(id);
    }

    @Override
    public void update(BankAccountTransDetailDO obj) {
        bankAccountTransDetailMapper.update(obj);
    }

    /**
     * 未入账查询
     * `oper_status` 操作状态 0-未入账 1-已入账'
     *
     * @param obj
     * @return
     */
    @Override
    public PageInfo<BankAccountTransDetailDO> pageList(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        Map parMap = obj.getParameters();
        parMap.put("operStatus", 0);
        List<BankAccountTransDetailDO> page = bankAccountTransDetailMapper.listPage(parMap);
        return new PageInfo<>(page);
    }
}
