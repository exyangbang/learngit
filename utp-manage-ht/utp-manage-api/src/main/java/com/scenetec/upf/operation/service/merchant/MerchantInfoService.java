package com.scenetec.upf.operation.service.merchant;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoAuthDo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/07/25
 */
public interface MerchantInfoService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(MerchantInfoDO obj);

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
	void update(MerchantInfoDO obj);

	/**
	 *
	 * @param obj
	 */
	void updateAuth(MerchantInfoAuthDo obj);
	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	MerchantInfoDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<MerchantInfoDO> list(Query query);
	/**
	 * 获取子账户，如果被选过的的子账户需要屏蔽
	 * @param query
	 * @return
	 */
	PageInfo<MerchantInfoDO> listExclusionOfSelection(Query query);
}
