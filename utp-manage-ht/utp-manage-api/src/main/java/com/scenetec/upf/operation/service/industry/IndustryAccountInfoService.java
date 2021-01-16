package com.scenetec.upf.operation.service.industry;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industry.IndustryAccountInfoDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/11/06
 */
public interface IndustryAccountInfoService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(IndustryAccountInfoDO obj);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 删除
	 * @param code
	 * @return
	 */
	int deleteByIndustryCode(String code,String industryType);

	/**
	 * 更新
	 * @param obj
	 */
	void update(IndustryAccountInfoDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	IndustryAccountInfoDO getById(Long id);

	/**
	 * 查询列表(分页)
	 * @param query
	 * @return
	 */
	PageInfo<IndustryAccountInfoDO> pageList(Query query);

    /**
    * 查询列表(无分页)
    * @param query
    * @return
    */
    List<IndustryAccountInfoDO> list(Map<String, Object> params);
}
