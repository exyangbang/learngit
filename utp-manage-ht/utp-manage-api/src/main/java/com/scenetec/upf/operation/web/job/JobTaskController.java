package com.scenetec.upf.operation.web.job;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.job.JobTaskDO;
import com.scenetec.upf.operation.service.job.JobTaskService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/10/22
 */
@Api(value="作业任务管理",tags={"作业任务管理"})
@RestController
public class JobTaskController {

    @Resource
    JobTaskService service;

    @RequestMapping(value = "/api/jobTask", method = RequestMethod.POST)
    public long create(@RequestBody JobTaskDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/jobTask/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/jobTask", method = RequestMethod.PUT)
    public void update(@RequestBody JobTaskDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/jobTask/{id}", method = RequestMethod.GET)
    public JobTaskDO get(@PathVariable Long id){
        return service.getById(id);
    }

    @RequestMapping(value = "/api/jobTask/pageList", method = RequestMethod.POST)
    public PageInfo<JobTaskDO> pageList(@RequestBody Query query) {
	    return service.pageList(query);
	}

    @RequestMapping(value = "/api/jobTask/list", method = RequestMethod.POST)
    public List<JobTaskDO> list(@RequestBody Map<String, Object> params) {
        return service.list(params);
    }

    @RequestMapping(value = "/api/jobTask/jobDict",method = RequestMethod.GET)
    public List<Map> jobDict(){
        return service.jobDict();
    }
}
