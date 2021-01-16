package com.scenetec.upf.operation.service.splitinfo;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.splitinfo.SplitInfoDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Map;

public interface SplitInfoService {

    /**
     * 查询列表
     * @param query
     * @return
     */
    PageInfo<SplitInfoDO> list(Query query);

    PageInfo<SplitInfoDO> listDownload(Query query);
    Map<String,Long> countSum(Map<String, Object> parameters);

    SplitInfoDO getById(Long id);
}
