package com.scenetec.upf.operation.service.fundaccount;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.fundaccount.FundAccountDO;


import com.scenetec.upf.operation.model.vo.fundaccount.FundAccountVO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Map;

public interface FundAccountService {
    /**
     * 创建
     * @param obj
     * @return
     */
    long create(FundAccountVO obj);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新
     * @param obj
     */
    void update(FundAccountVO obj);
    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    FundAccountDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<FundAccountDO> list(Query query);

    PageInfo<FundAccountDO> fundAccountScreen(Query obj);

    PageInfo<Map<String,Object>> listDatail(Query query);

    Map<String,Long> countSum(Map<String, Object> parameters);
}
