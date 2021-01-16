package com.scenetec.upf.operation.service.product;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channelincomeflow.ChannelIncomeFlowDO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface FlowingIntoGoldService {

    /**
     * 查询列表
     * @param query
     * @return
     */
    PageInfo<ChannelIncomeFlowDO> list(Query query);
}
