package com.scenetec.upf.operation.web.system;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.system.CardBinInfoDO;
import com.scenetec.upf.operation.service.system.CardBinInfoService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/11/08
 */
@Api(value="卡bin管理",tags={"卡bin管理"})
@RestController
public class CardBinInfoController {

    @Resource
    CardBinInfoService service;

    @RequestMapping(value = "/api/cardBinInfo", method = RequestMethod.POST)
    public long create(@RequestBody CardBinInfoDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/cardBinInfo/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/cardBinInfo", method = RequestMethod.PUT)
    public void update(@RequestBody CardBinInfoDO obj){
        service.update(obj);
    }
	
    @RequestMapping(value = "/api/cardBinInfo/{id}", method = RequestMethod.GET)
    public CardBinInfoDO get(@PathVariable Long id){
        return service.getById(id);
    }

    @RequestMapping(value = "/api/cardBinInfo/pageList", method = RequestMethod.POST)
    public PageInfo<CardBinInfoDO> pageList(@RequestBody Query query) {
	    return service.pageList(query);
	}

    @RequestMapping(value = "/api/cardBinInfo/list", method = RequestMethod.POST)
    public List<CardBinInfoDO> list(@RequestBody Map<String, Object> params) {
        return service.list(params);
    }

    @RequestMapping(value = "/api/cardBinInfo/runsql", method = RequestMethod.POST)
    public void runSql(@RequestParam("file") MultipartFile file){

        service.runSql(file);
    }

}
