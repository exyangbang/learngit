package com.scenetec.upf.operation.service.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitDO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface IndustryAmtLimitService {

	/**
	 * 查询列表
//	 * @param query
	 * @return
	 */
	PageInfo<IndustryAmtLimitDO> list(Query query);

}
