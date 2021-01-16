package com.scenetec.upf.operation.service.applicationformanualentry;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.applicationformanualentry.ApplicationForManualEntryDO;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.vo.applicationformanualentry.ApplicationForManualEntryVO;
import com.scenetec.upf.operation.model.vo.whitelist.WhiteListVO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface ApplicationForManualEntryService {
    /**
     * 创建
     *
     * @param entryVO
     * @return
     */
    Long create(ApplicationForManualEntryVO entryVO);

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
    void update(ApplicationForManualEntryDO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    ApplicationForManualEntryDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<ApplicationForManualEntryDO> list(Query query);
}
