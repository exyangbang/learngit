package com.scenetec.upf.operation.web.settle;


import javax.annotation.Resource;

import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.utils.OnliineTool.OnlineRequestTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.settle.MerReconcileRecordDO;
import com.scenetec.upf.operation.service.settle.MerReconcileRecordService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/19
 */
@Api(value="对账接口",tags={"对账接口"})
@RestController
public class MerReconcileRecordController {
    private Logger logger = LoggerFactory.getLogger(MerReconcileRecordController.class);
    @Resource
    MerReconcileRecordService service;

    @Value("${reconcile.restart.url}")
    private String url;

 /*   @RequestMapping(value = "/api/merReconcileRecord", method = RequestMethod.POST)
    public long create(@RequestBody MerReconcileRecordDO obj){
        return service.create(obj);
    }

    @RequestMapping(value = "/api/merReconcileRecord/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id){
	    return service.delete(id);
	}

    @RequestMapping(value = "/api/merReconcileRecord", method = RequestMethod.PUT)
    public void update(@RequestBody MerReconcileRecordDO obj){
        service.update(obj);
    }

    @RequestMapping(value = "/api/merReconcileRecord/{id}", method = RequestMethod.GET)
    public MerReconcileRecordDO get(@PathVariable Long id){
        return service.getById(id);
    }*/
    @RequestMapping(value = "/api/reconcileRecord/restart", method = RequestMethod.POST)
    public String restart(@RequestBody Map map){
        MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
        request.add("merNo", map.get("merNo"));
        request.add("channelKey",map.get("channelKey"));
        request.add("date", map.get("reconcileDate"));
        RestTemplate restTemplate = new RestTemplate();
        String response="";
        try {
            response=restTemplate.postForObject(url, request,String.class);
        }catch (Exception e){
            logger.error(url+"===="+e);
            throw new SystemRuntimeException(ErrorCode.BSMST002);
        }
        return response;
    }

    @RequestMapping(value = "/api/reconcileRecord/list", method = RequestMethod.POST)
    public PageInfo<MerReconcileRecordDO> list(@RequestBody Query query) {
	    return service.list(query);
	}

    /**
     *
     * @return
     */
	@RequestMapping(value = "/api/reconcileRecord/reconcileStatus", method = RequestMethod.POST)
    public Integer reconcileStatus() {
        return service.reconcileStatus();
    }

}
