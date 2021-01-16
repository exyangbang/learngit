package com.scenetec.upf.operation.web.product;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.product.PayProductDO;
import com.scenetec.upf.operation.service.product.PayProductService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Api(value="支付产品表",tags={"支付产品表"})
@RestController
public class PayProductController {

    @Resource
    PayProductService service;

    @RequestMapping(value = "/api/payProduct", method = RequestMethod.POST)
    public long create(@RequestBody PayProductDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/payProduct/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/payProduct", method = RequestMethod.PUT)
    public void update(@RequestBody PayProductDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/payProduct/{id}", method = RequestMethod.GET)
    public PayProductDO get(@PathVariable Long id){
        return service.getById(id);
    }

    @RequestMapping(value = "/api/payProduct/list", method = RequestMethod.POST)
    public PageInfo<PayProductDO> list(@RequestBody Query query) {
	    return service.list(query);
	}
}
