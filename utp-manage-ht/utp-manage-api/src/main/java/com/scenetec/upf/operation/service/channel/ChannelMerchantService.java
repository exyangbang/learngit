package com.scenetec.upf.operation.service.channel;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channel.ChannelMerchantDO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface ChannelMerchantService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(ChannelMerchantDO obj);

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
	void update(ChannelMerchantDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	ChannelMerchantDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<ChannelMerchantDO> list(Query query);
}
