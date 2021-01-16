package com.scenetec.upf.operation.service.specialindustrysyncconfig;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.specialindustrysyncconfig.SpecialIndustrySyncConfigDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;

public interface SpecialIndustrySyncConfigSevice {

    /**
     * 创建
     * @param obj
     * @return
     */
    long create(List<IndustryDO> list);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);


    /**
     * 查询列表
     * @param query
     * @return
     */
    PageInfo<SpecialIndustrySyncConfigDO> list(Query query);
}
