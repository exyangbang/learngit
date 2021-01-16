package com.scenetec.upf.operation.service.codedictionary;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.codedictionary.CodeDictionaryDO;
import com.scenetec.zeus.daogenerator.model.Query;

public interface CodeDictionaryService {
    /**
     * 创建
     * @param obj
     * @return
     */
    long create(CodeDictionaryDO obj);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 更新
     * @param obj
     */
    void update(CodeDictionaryDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
    CodeDictionaryDO getById(Long id);

    /**
     * 查询列表(分页)
     * @param query
     * @return
     */
    PageInfo<CodeDictionaryDO> pageList(Query query);
}
