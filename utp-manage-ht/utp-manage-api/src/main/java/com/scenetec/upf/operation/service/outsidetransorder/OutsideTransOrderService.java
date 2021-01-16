package com.scenetec.upf.operation.service.outsidetransorder;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.outsidetransorder.OutsideTransOrderDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Map;

public interface OutsideTransOrderService {

    /**
     * 查询列表
     *
     * @param query
     * @return
     */
    PageInfo<OutsideTransOrderDO> list(Query query);

    PageInfo<OutsideTransOrderDO> listDownload(Query query);

    Map<String, Object> countSum(Map<String, Object> parameters);

    OutsideTransOrderDO showPDF(Long id);
}
