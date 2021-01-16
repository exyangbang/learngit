package com.scenetec.upf.operation.web.whitelist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.vo.whitelist.WhiteListVO;
import com.scenetec.upf.operation.service.whitelist.WhiteListService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "来款账户白名单", tags = {"来款账户白名单"})
@RestController
public class WhiteListController {
    @Resource
    WhiteListService service;

    @RequestMapping(value = "/api/whiteList", method = RequestMethod.POST)
    public long create(@Validated @RequestBody WhiteListVO obj) {

        return service.create(obj);
    }

    @RequestMapping(value = "/api/whiteList/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/whiteList", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody WhiteListVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/whiteList/{id}", method = RequestMethod.GET)
    public WhiteListDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/whiteList/list", method = RequestMethod.POST)
    public PageInfo<WhiteListDO> list(@RequestBody Query query) {
        return service.list(query);
    }
}
