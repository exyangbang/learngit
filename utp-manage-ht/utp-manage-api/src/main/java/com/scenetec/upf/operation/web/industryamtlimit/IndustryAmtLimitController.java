package com.scenetec.upf.operation.web.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitDO;
import com.scenetec.upf.operation.service.industryamtlimit.IndustryAmtLimitService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "客户风控参数管理", tags = {"客户风控参数管理"})
@RestController
public class IndustryAmtLimitController {

    @Resource
    IndustryAmtLimitService service;

    @RequestMapping(value = "/api/industryAmLimit/list", method = RequestMethod.POST)
    public PageInfo<IndustryAmtLimitDO> list(@RequestBody Query query) {
        return service.list(query);
    }


}
