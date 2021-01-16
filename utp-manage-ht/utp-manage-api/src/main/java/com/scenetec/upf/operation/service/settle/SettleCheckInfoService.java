package com.scenetec.upf.operation.service.settle;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.settle.SettleCheckInfoDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/13
 */
public interface SettleCheckInfoService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(SettleCheckInfoDO obj);

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
	void update(SettleCheckInfoDO obj);
	/**
	 * 更新
	 * @param obj
	 */
	void updateAuditStatus(SettleCheckInfoDO obj);
	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	SettleCheckInfoDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<SettleCheckInfoDO> list(Query query);

	PageInfo<SettleCheckInfoDO> listDownload(Query query);
	Map<String,Long> countSum(Map<String, Object> parameters);

}
