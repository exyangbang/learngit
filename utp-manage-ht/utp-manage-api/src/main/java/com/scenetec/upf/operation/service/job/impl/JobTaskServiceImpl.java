package com.scenetec.upf.operation.service.job.impl;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.job.JobTaskDO;

import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scenetec.upf.operation.repository.job.JobTaskMapper;
import com.scenetec.upf.operation.service.job.JobTaskService;
import com.scenetec.zeus.daogenerator.model.Query;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/10/22
 */
@Service
public class JobTaskServiceImpl implements JobTaskService{

    @Resource
    JobTaskMapper mapper;

    @Resource
    UserService userService;

    @Override
    public long create(JobTaskDO obj) {
        obj.setGmtCreate(new Date());
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        obj.setId(IdGenerate.getId());
        mapper.create(obj);
        return obj.getId();
	}

    @Override
    public int delete(Long id) {
	    return mapper.delete(id);
	}

    @Override
	public void update(JobTaskDO obj) {
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
	    mapper.update(obj);
	}
	
    @Override
    public JobTaskDO getById(Long id) {
         return mapper.getById(id);
    }

    @Override
    public PageInfo<JobTaskDO> pageList(Query query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());        
	    Page<JobTaskDO> page = mapper.pageList(query.getParameters());
	    return new PageInfo<>(page);
	}

    @Override
    public List<JobTaskDO> list(Map<String, Object> params) {
        return mapper.list(params);
    }

    @Override
    public List<Map> jobDict() {
        List<Map> jobs= mapper.jobDict();
        return jobs;
    }


}
