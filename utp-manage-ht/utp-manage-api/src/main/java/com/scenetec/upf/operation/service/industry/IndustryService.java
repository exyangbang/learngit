package com.scenetec.upf.operation.service.industry;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.vo.industry.IndustryDataVO;
import com.scenetec.upf.operation.model.vo.industry.IndustryVO;
import com.scenetec.zeus.daogenerator.model.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/29
 */
public interface IndustryService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(IndustryVO obj);

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
	void update(IndustryVO obj);

	/**
	 * 更新审核状态
	 * @param obj
	 */
	void updateAuditStatus(IndustryVO obj);
	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	IndustryDO getById(Long id,String exImage);
	IndustryDO getByAccount(String account);
	/**
	 * 获取对象
	 * @param obj
	 * @return
	 */
	IndustryDO getOneIndustry(IndustryDO obj);
	Integer getOneIndustryCount(IndustryDO obj);

	/**
	 * 查询列表(分页)
	 * @param query
	 * @return
	 */
	PageInfo<IndustryDO> pageList(Query query);
	PageInfo<IndustryDO> pageListFeeAndAuthAccount(Query query);

	PageInfo<IndustryDO> pageCollectionList(Query query);

	PageInfo<IndustryDO> pageListExclude(Query query);
	/**
	 * 费用账户
	 * @param query
	 * @return
	 */
	PageInfo<IndustryDO> pageListFeeAccount(Query query);

	/**
	 * 显示分账业务的信息列表
	 * @param query
	 * @return
	 */
	PageInfo<IndustryDO> industryListOnlyAccountSplittingBusiness(Query query);

	/**
	 * 隐藏被选过的交易限额账号
	 * @param query
	 * @return
	 */
	PageInfo<IndustryDO> industryUnTransactionLimitList(Query query);

	/**
    * 查询列表(无分页)
    * @param query
    * @return
    */
    List<IndustryDO> list(Query query);

	PageInfo<IndustryDO> selectListWithCert(Query query);

	void createIndustryAccountInfo(IndustryDataVO industryDO);

    boolean isExistFundAccount(String fundAccount);
}
