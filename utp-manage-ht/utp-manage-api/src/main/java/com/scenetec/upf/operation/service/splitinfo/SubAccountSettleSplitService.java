package com.scenetec.upf.operation.service.splitinfo;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.vo.SubAccountSettleSplitVO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Map;

/**
 * @author scenetec
 */
public interface SubAccountSettleSplitService {

    /**
     * 分页查询
     * @param query
     * @return
     */
    PageInfo<SubAccountSettleSplitVO> query(Query query);

    /**
     * 笔数/金额统计
     * @param parameters
     * @return
     */
    Map<String,Long> countTotal(Map<String, Object> parameters);
}
