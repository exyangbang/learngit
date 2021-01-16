package com.scenetec.upf.operation.service.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitDO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface SubaccountsAmtLimitService {

	/**
	 * 查询列表
//	 * @param query
	 * @return
	 */
	PageInfo<SubaccountsAmtLimitDO> list(Query query);

}
