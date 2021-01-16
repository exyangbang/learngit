package com.scenetec.upf.operation.service.settle;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.settle.IndSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.MerSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.OrgSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.TransSumInfoDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/13
 */
public interface SettleSumInfoService {

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
	void update(OrgSettleSumInfoDO obj);

	OrgSettleSumInfoDO selectOne(OrgSettleSumInfoDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	OrgSettleSumInfoDO getById(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<OrgSettleSumInfoDO> orgList(Query query);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<MerSettleSumInfoDO> merList(Query query);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<IndSettleSumInfoDO> indList(Query query);

	PageInfo<TransSumInfoDO> sumList(Query query);
	/**
	 * 查询列表
	 * @param obj
	 * @return
	 */

	List<OrgSettleSumInfoDO> selectOrgList(OrgSettleSumInfoDO obj);

	/**
	 * 查询列表
	 * @param obj
	 * @return
	 */

	List<MerSettleSumInfoDO> selectMerList(MerSettleSumInfoDO obj);

	/**
	 * 查询列表
	 * @param obj
	 * @return
	 */

	List<IndSettleSumInfoDO> selectIndList(IndSettleSumInfoDO obj);

	List<TransSumInfoDO> selectSumList(Map<String, Object> parameters);

	Map<String,Long> countOrg(String orgCode, String reconcileDate);
	Map<String,Long> countMer(String merNo, String reconcileDate);
	Map<String,Long> countInd(String industryCode, String reconcileDate);

	Map<String,Long>  countSum(Map<String, Object> parameters);
}
