package com.scenetec.upf.operation.web.industry;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industry.IndustryAccountInfoDO;
import com.scenetec.upf.operation.service.industry.IndustryAccountInfoService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/11/06
 */
@Api(value="平台来款账户信息表",tags={"平台来款账户信息表"})
@RestController
public class IndustryAccountInfoController {

    @Resource
    IndustryAccountInfoService service;

    @RequestMapping(value = "/api/industryAccountInfo", method = RequestMethod.POST)
    public long create(@RequestBody IndustryAccountInfoDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/industryAccountInfo/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/industryAccountInfo", method = RequestMethod.PUT)
    public void update(@RequestBody IndustryAccountInfoDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/industryAccountInfo/{id}", method = RequestMethod.GET)
    public IndustryAccountInfoDO get(@PathVariable Long id){
        return service.getById(id);
    }

    @RequestMapping(value = "/api/industryAccountInfo/pageList", method = RequestMethod.POST)
    public PageInfo<IndustryAccountInfoDO> pageList(@RequestBody Query query) {
	    return service.pageList(query);
	}

    @RequestMapping(value = "/api/industryAccountInfo/list", method = RequestMethod.POST)
    public List<IndustryAccountInfoDO> list(@RequestBody Map<String, Object> params) {
        return service.list(params);
    }
}
