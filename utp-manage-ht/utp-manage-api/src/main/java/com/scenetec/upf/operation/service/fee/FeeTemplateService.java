package com.scenetec.upf.operation.service.fee;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.fee.FeeTemplateDO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface FeeTemplateService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(FeeTemplateDO obj);

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
	void update(FeeTemplateDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	FeeTemplateDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<FeeTemplateDO> list(Query query);
}
