package com.scenetec.upf.operation.web.merchant;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.service.merchant.MerchantInfoService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Api(value = "个体工商户鉴权审表", tags = {"个体工商户鉴权审表"})
@RestController
public class PersonalInfoAuthController {
    @Resource
    MerchantInfoService service;
    @RequestMapping(value = "/api/personalInfoAuth/list", method = RequestMethod.POST)
    public PageInfo<MerchantInfoDO> list(@RequestBody Query query) {
        Map<String, Object> tem = query.getParameters();
        tem.put("nature", "8");
        return service.list(query);
    }

    @RequestMapping(value = "/api/personalInfoAuth/{id}", method = RequestMethod.GET)
    public MerchantInfoDO get(@PathVariable Long id) {
        return service.getById(id);
    }


}
