package com.scenetec.upf.operation.service.trade;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.vo.SubAccountPaymentFlowVO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Map;

public interface SubAccountPaymentService {

    /**
     * 分页查询
     * @param query
     * @return
     */
    PageInfo<SubAccountPaymentFlowVO> query(Query query);

    /**
     * 笔数/金额统计
     * @param parameters
     * @return
     */
    Map<String,Long> countTotal(Map<String, Object> parameters);
}
