package com.scenetec.upf.operation.web.channel;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.channel.ChannelIndustryDO;
import com.scenetec.upf.operation.service.channel.ChannelIndustryService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/10/31
 */
@Api(value="渠道平台管理",tags={"渠道平台管理"})
@RestController
public class ChannelIndustryController {

    @Resource
    ChannelIndustryService service;

    @RequestMapping(value = "/api/channelIndustry", method = RequestMethod.POST)
    public long create(@RequestBody ChannelIndustryDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/channelIndustry/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/channelIndustry", method = RequestMethod.PUT)
    public void update(@RequestBody ChannelIndustryDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/channelIndustry/{id}", method = RequestMethod.GET)
    public ChannelIndustryDO get(@PathVariable Long id){
        return service.getById(id);
    }

    @RequestMapping(value = "/api/channelIndustry/pageList", method = RequestMethod.POST)
    public PageInfo<ChannelIndustryDO> pageList(@RequestBody Query query) {
	    return service.pageList(query);
	}
    @RequestMapping(value = "/api/channelIndustry/pageListGroup", method = RequestMethod.POST)
    public PageInfo<ChannelIndustryDO> pageListGroup(@RequestBody Query query) {
        return service.pageListGroup(query);
    }
    @RequestMapping(value = "/api/channelIndustry/list", method = RequestMethod.POST)
    public List<ChannelIndustryDO> list(@RequestBody Map<String, Object> params) {
        return service.list(params);
    }

    @RequestMapping(value = "/api/channelIndustry/roofPlacement", method = RequestMethod.PUT)
    public int roofPlacement(@RequestBody Map<String, Object> params) {
        List list = (List)params.get("arrayId");
        return service.roofPlacement(list);
    }
}
