package com.scenetec.upf.operation.web.specialindustrysyncconfig;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.specialindustrysyncconfig.SpecialIndustrySyncConfigDO;
import com.scenetec.upf.operation.service.specialindustrysyncconfig.SpecialIndustrySyncConfigSevice;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "特殊客户同步名单配置", tags = {"特殊客户同步名单配置"})
@RestController
public class SpecialindustrySyncConfigConcroller {
    @Resource
    SpecialIndustrySyncConfigSevice service;

    @RequestMapping(value = "/api/specialIndustrySyncConfig/list", method = RequestMethod.POST)
    public PageInfo<SpecialIndustrySyncConfigDO> list(@RequestBody Query query) {
        return service.list(query);
    }

    @RequestMapping(value = "/api/specialIndustrySyncConfig/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/specialIndustrySyncConfig", method = RequestMethod.POST)
    public long create(@RequestBody List<IndustryDO> obj) {
        return service.create(obj);
    }
}
