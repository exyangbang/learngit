package com.scenetec.upf.operation.service.product;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.product.PayProductDO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface PayProductService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(PayProductDO obj);

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
	void update(PayProductDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	PayProductDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<PayProductDO> list(Query query);
}
