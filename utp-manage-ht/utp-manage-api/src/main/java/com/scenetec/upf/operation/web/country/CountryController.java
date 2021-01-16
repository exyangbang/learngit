package com.scenetec.upf.operation.web.country;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.country.CountryDO;
import com.scenetec.upf.operation.service.country.CountryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(value = "国家代码", tags = {"国家代码"})
@RestController
public class CountryController {
    @Resource
    public CountryService service;

    @RequestMapping(value = "/api/industry/countryList", method = RequestMethod.POST)
    public Page<CountryDO> list() {
        return service.getCountList();
    }
}
