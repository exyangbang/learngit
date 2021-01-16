package com.scenetec.upf.operation.web.merchant;


import javax.annotation.Resource;

import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoAuthDo;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.service.merchant.MerchantInfoService;
import com.scenetec.zeus.daogenerator.model.Query;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author scenetec
 * @date 2018/07/25
 */
@Api(value = "商户基本信息表", tags = {"商户基本信息表"})
@RestController
public class MerchantInfoController {

    @Resource
    MerchantInfoService service;

    @ApiIgnore
    @RequestMapping(value = "/api/merchantInfo", method = RequestMethod.POST)
    public long create(@RequestBody MerchantInfoDO obj) {
        return service.create(obj);
    }

    @ApiIgnore
    @RequestMapping(value = "/api/merchantInfo/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/merchantInfo", method = RequestMethod.PUT)
    public void update(@RequestBody MerchantInfoDO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/merchantInfo/{id}", method = RequestMethod.GET)
    public MerchantInfoDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/merchantInfo/list", method = RequestMethod.POST)
    public PageInfo<MerchantInfoDO> list(@RequestBody Query query) {
        Map<String, Object> tem = query.getParameters();
        tem.put("userType", "1");
        query.setParameters(tem);
        return service.list(query);
    }

    /**
     * 获取子账户，如果被选过的的子账户需要屏蔽
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/merchantInfo/listUnUserType", method = RequestMethod.POST)
    public PageInfo<MerchantInfoDO> listUnUserType(@RequestBody Query query) {
        return service.listExclusionOfSelection(query);
    }

    /**
     * 企业认证审核
     *
     * @param obj
     */
    @RequestMapping(value = "/api/merchantInfoAuth", method = RequestMethod.PUT)
    public void merchantInfoAuth(@RequestBody MerchantInfoAuthDo obj) {
        service.updateAuth(obj);
    }
}
