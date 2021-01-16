package com.scenetec.upf.operation.web.channel;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channel.ChannelMerchantDO;
import com.scenetec.upf.operation.service.channel.ChannelMerchantService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;

/**
 * @author scenetec
 * @date 2018/09/04
 */
@Api(value="渠道商户管理",tags={"渠道商户管理"})
@RestController
public class ChannelMerchantController {

    @Resource
    ChannelMerchantService service;

    @RequestMapping(value = "/api/channelMerchant", method = RequestMethod.POST)
    public long create(@RequestBody ChannelMerchantDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/channelMerchant/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/channelMerchant", method = RequestMethod.PUT)
    public void update(@RequestBody ChannelMerchantDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/channelMerchant/{id}", method = RequestMethod.GET)
    public ChannelMerchantDO get(@PathVariable Long id){
        return service.getById(id);
    }

    @RequestMapping(value = "/api/channelMerchant/list", method = RequestMethod.POST)
    public PageInfo<ChannelMerchantDO> list(@RequestBody Query query) {
	    return service.list(query);
	}
}
