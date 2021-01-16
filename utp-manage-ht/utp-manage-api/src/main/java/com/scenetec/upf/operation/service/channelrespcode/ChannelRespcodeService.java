package com.scenetec.upf.operation.service.channelrespcode;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channelrespcode.ChannelRespcodeDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

public interface ChannelRespcodeService {
    /**
     * 创建
     * @param obj
     * @return
     */
    long create(ChannelRespcodeDO obj);

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
    void update(ChannelRespcodeDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
    ChannelRespcodeDO getById(Long id);

    /**
     * 查询列表(分页)
     * @param query
     * @return
     */
    PageInfo<ChannelRespcodeDO> pageList(Query query);

}
