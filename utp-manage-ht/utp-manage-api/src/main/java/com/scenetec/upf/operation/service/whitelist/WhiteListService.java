package com.scenetec.upf.operation.service.whitelist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.vo.whitelist.WhiteListVO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface WhiteListService {
    /**
     * 创建
     *
     * @param obj
     * @return
     */
    long create(WhiteListVO obj);

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
    void update(WhiteListVO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    WhiteListDO getById(Long id);

    /**
     * 查询列表
     *
     * @param
     * @return
     */
    PageInfo<WhiteListDO> list(Query query);
}
