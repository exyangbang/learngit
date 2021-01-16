package com.scenetec.upf.operation.service.bankaccounttransdetail;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.bankaccounttransdetail.BankAccountTransDetailDO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface BankAccountTransDetailService {
    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    BankAccountTransDetailDO getById(Long id);

    /**
     * 更新
     *
     * @param obj
     */
    void update(BankAccountTransDetailDO obj);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<BankAccountTransDetailDO> pageList(Query query);
}
