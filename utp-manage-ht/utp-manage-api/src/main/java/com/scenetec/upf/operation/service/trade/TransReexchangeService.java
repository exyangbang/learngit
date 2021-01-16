package com.scenetec.upf.operation.service.trade;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.trade.TransReexchangeDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @Description : 退汇流水信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 17:57
 */
public interface TransReexchangeService {

    /**
     *
     * @param transReexchangeDO
     * @return
     */
    int create(TransReexchangeDO transReexchangeDO);

    /**
     * 查询列表(分页)
     * @param query
     * @return
     */
    PageInfo<TransReexchangeDO> pageReexchange(Query query);
    PageInfo<TransReexchangeDO> pageReexchangeDownload(Query query);

    Map<String,Long> countSum(Map<String, Object> parameters);

    /**
     * 查询列表(不分页)
     * @param transReexchangeDO
     * @return
     */
    List<TransReexchangeDO> list(TransReexchangeDO transReexchangeDO);
}
