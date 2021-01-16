package com.scenetec.upf.operation.service.withdrawalsrecord;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.withdrawalsrecord.WithdrawalsRecordDO;
import com.scenetec.upf.operation.model.domain.withdrawcashaccount.WithdrawCashAccountDO;
import com.scenetec.upf.operation.model.vo.CollectionAccountWithdrawRespDTO;
import com.scenetec.upf.operation.model.vo.QueryCollectionAccountWithdrawRespDTO;
import com.scenetec.upf.operation.model.vo.withdrawalsrecord.WithdrawalsRecordExVO;
import com.scenetec.upf.operation.model.vo.withdrawalsrecord.WithdrawalsRecordVO;
import com.scenetec.upf.operation.model.vo.withdrawcashaccount.WithdrawCashAccountVO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface WithdrawalsRecordService {
    /**
     * 创建
     *
     * @param obj
     * @return
     */
    long create(WithdrawalsRecordVO objVo);

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
    void update(WithdrawalsRecordExVO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    WithdrawalsRecordDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<WithdrawalsRecordDO> list(Query query);

    /**
     * 刷新
     * @param objVo
     */
    QueryCollectionAccountWithdrawRespDTO queryCollectAccountWithdrawUrl(WithdrawalsRecordExVO objVo);

}
