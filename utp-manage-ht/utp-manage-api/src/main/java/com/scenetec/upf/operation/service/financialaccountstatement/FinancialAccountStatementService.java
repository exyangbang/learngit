package com.scenetec.upf.operation.service.financialaccountstatement;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.financialaccountstatement.FinancialAccountStatementDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Map;

public interface FinancialAccountStatementService {
    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    FinancialAccountStatementDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<FinancialAccountStatementDO> list(Query query);

    PageInfo<FinancialAccountStatementDO> listDownload(Query query);

    Map<String,Long> countSum(Map<String, Object> parameters);
}
