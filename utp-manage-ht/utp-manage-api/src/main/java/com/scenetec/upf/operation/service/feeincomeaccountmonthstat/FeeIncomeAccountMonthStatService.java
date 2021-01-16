package com.scenetec.upf.operation.service.feeincomeaccountmonthstat;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.fee.FeeTemplateDO;
import com.scenetec.upf.operation.model.domain.feeincomeaccountmonthstat.FeeIncomeAccountMonthStatDO;
import com.scenetec.upf.operation.model.vo.QueryFeeIncomeAccountCollectionRespDTO;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/04
 */
public interface FeeIncomeAccountMonthStatService {

	/**
	 * 更新
	 * @param obj
	 */
	void feeIncomeAccountMonthStat(List<String> list);


	void feeIncomeAccountMonthCollection(List<String> list);

	QueryFeeIncomeAccountCollectionRespDTO queryFeeIncomeAccountMonthCollection(Long id);

	/**
	 * 人工核查
	 * @param feeIncomeAccountMonthStatDO
	 */
	void feeManualVerification(FeeIncomeAccountMonthStatDO feeIncomeAccountMonthStatDO);
	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<FeeIncomeAccountMonthStatDO> list(Query query);

	Map<String,Long> countSumCollect(Map<String, Object> parameters);
}
