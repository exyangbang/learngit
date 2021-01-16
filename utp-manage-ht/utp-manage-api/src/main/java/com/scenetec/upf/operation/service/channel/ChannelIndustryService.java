package com.scenetec.upf.operation.service.channel;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channel.ChannelIndustryDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/10/31
 */
public interface ChannelIndustryService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(ChannelIndustryDO obj);

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
	void update(ChannelIndustryDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	ChannelIndustryDO getById(Long id);

	/**
	 * 查询列表(分页)
	 * @param query
	 * @return
	 */
	PageInfo<ChannelIndustryDO> pageList(Query query);
	/**
	 * 查询列表(分页) 分组
	 * @param query
	 * @return
	 */
	PageInfo<ChannelIndustryDO> pageListGroup(Query query);

    /**
    * 查询列表(无分页)
    * @param query
    * @return
    */
    List<ChannelIndustryDO> list(Map<String, Object> params);

	/**
	 * 置顶操作
	 * @param arrayId
	 * @return
	 */
	Integer roofPlacement(List arrayId);
}
