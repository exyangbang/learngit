package com.scenetec.upf.operation.service.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.SubaccountsAmtLimitApprovalVO;
import com.scenetec.zeus.daogenerator.model.Query;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface SubaccountsAmtLimitApprovalService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(SubaccountsAmtLimitApprovalVO obj);

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
	void update(SubaccountsAmtLimitApprovalVO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	SubaccountsAmtLimitApprovalDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<SubaccountsAmtLimitApprovalDO> list(Query query);

	void quotaExaApprovalAudit(SubaccountsAmtLimitApprovalVO obj);

	void updateToOnlineReuqest(SubaccountsAmtLimitApprovalVO obj);
	void updateToOnlineReuqest1(SubaccountsAmtLimitApprovalVO obj);
}
