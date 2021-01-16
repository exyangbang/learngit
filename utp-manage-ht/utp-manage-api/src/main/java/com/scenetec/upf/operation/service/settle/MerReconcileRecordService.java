package com.scenetec.upf.operation.service.settle;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.settle.MerReconcileRecordDO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/19
 */
public interface MerReconcileRecordService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(MerReconcileRecordDO obj);

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
	void update(MerReconcileRecordDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	MerReconcileRecordDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<MerReconcileRecordDO> list(Query query);

	Integer reconcileStatus();
}
