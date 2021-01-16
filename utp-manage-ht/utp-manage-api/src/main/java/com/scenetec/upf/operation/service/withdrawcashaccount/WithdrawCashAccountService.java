package com.scenetec.upf.operation.service.withdrawcashaccount;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.domain.withdrawcashaccount.WithdrawCashAccountDO;
import com.scenetec.upf.operation.model.vo.whitelist.WhiteListVO;
import com.scenetec.upf.operation.model.vo.withdrawcashaccount.WithdrawCashAccountVO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface WithdrawCashAccountService {
    /**
     * 创建
     *
     * @param obj
     * @return
     */
    long create(WithdrawCashAccountVO obj);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新
     *
     * @param obj
     */
    void update(WithdrawCashAccountVO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    WithdrawCashAccountDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<WithdrawCashAccountDO> list(Query query);
}
