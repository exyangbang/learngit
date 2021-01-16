package com.scenetec.upf.operation.web.fee;


import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.fee.FeeTemplateDO;
import com.scenetec.upf.operation.service.fee.FeeTemplateService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Api(value="手续费模板管理",tags={"手续费模板管理"})
@RestController
public class FeeTemplateController {

    @Resource
    FeeTemplateService service;

    @RequestMapping(value = "/api/feeTemplate", method = RequestMethod.POST)
    public long create(@RequestBody FeeTemplateDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/feeTemplate/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/feeTemplate", method = RequestMethod.PUT)
    public void update(@RequestBody FeeTemplateDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/feeTemplate/{id}", method = RequestMethod.GET)
    public FeeTemplateDO get(@PathVariable Long id){
        return service.getById(id);
    }

    @RequestMapping(value = "/api/feeTemplate/list", method = RequestMethod.POST)
    public PageInfo<FeeTemplateDO> list(@RequestBody Query query) {
	    return service.list(query);
	}
}
