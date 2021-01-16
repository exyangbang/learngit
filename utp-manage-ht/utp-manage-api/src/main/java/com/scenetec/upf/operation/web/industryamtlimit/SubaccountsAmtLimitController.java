package com.scenetec.upf.operation.web.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitDO;
import com.scenetec.upf.operation.service.industryamtlimit.SubaccountsAmtLimitService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "子账户交易限额管理", tags = {"子账户交易限额管理"})
@RestController
public class SubaccountsAmtLimitController {

    @Resource
    SubaccountsAmtLimitService service;

    @RequestMapping(value = "/api/subaccountsAmtLimit/list", method = RequestMethod.POST)
    public PageInfo<SubaccountsAmtLimitDO> list(@RequestBody Query query) {
        return service.list(query);
    }


}
