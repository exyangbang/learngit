package com.scenetec.upf.operation.service.job;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.job.JobTaskDO;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/10/22
 */
public interface JobTaskService {

	/**
	 * 创建
	 * @param obj
	 * @return
	 */
	long create(JobTaskDO obj);

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
	void update(JobTaskDO obj);

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	JobTaskDO getById(Long id);

	/**
	 * 查询列表(分页)
	 * @param query
	 * @return
	 */
	PageInfo<JobTaskDO> pageList(Query query);

    /**
    * 查询列表(无分页)
    * @param query
    * @return
    */
    List<JobTaskDO> list(Map<String, Object> params);

	/**
	 * 获取jobId和jobName
	 * @return
	 */
	List<Map> jobDict();
}
