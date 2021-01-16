package com.scenetec.upf.operation.service.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.IndustryAmtLimitApprovalVO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.SubaccountsAmtLimitApprovalVO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface IndustryAmtLimitApprovalService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(IndustryAmtLimitApprovalVO obj);

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
	void update(IndustryAmtLimitApprovalVO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	IndustryAmtLimitApprovalDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<IndustryAmtLimitApprovalDO> list(Query query);

	void quotaExaApprovalAudit(IndustryAmtLimitApprovalVO obj);

	void updateToOnlineReuqest1(IndustryAmtLimitApprovalVO obj);
	void updateToOnlineReuqest(IndustryAmtLimitApprovalVO obj);
}
