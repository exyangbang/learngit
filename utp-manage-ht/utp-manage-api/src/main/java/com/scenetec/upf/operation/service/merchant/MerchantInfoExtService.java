package com.scenetec.upf.operation.service.merchant;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.merchant.MerchantInfoVo;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/07/25
 */
public interface MerchantInfoExtService {

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<MerchantInfoVo> queryListWithCertId(Query query);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(MerchantInfoDO obj);
}
