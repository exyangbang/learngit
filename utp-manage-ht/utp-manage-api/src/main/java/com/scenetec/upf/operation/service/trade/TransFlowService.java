package com.scenetec.upf.operation.service.trade;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.trade.TransFlowDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/12
 */
public interface TransFlowService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(TransFlowDO obj);

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
	void update(TransFlowDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	TransFlowDO getCurrentById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<TransFlowDO> listCurrent(Query query);
	PageInfo<TransFlowDO> listCurrentDownload(Query query);
	Map<String,Long>  countSum(Map<String, Object> parameters);
	Map<String,Long>  countSumHistory(Map<String, Object> parameters);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	TransFlowDO getHistoryById(Long id);
	TransFlowDO getHistorySelctOne(String ServerTransId);
	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<TransFlowDO> listHistory(Query query);
	PageInfo<TransFlowDO> listHistoryDownload(Query query);
}
