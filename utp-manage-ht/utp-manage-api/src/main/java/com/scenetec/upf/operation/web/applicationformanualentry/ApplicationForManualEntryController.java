package com.scenetec.upf.operation.web.applicationformanualentry;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.applicationformanualentry.ApplicationForManualEntryDO;
import com.scenetec.upf.operation.model.vo.applicationformanualentry.ApplicationForManualEntryVO;
import com.scenetec.upf.operation.service.applicationformanualentry.ApplicationForManualEntryService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "手工入账申请", tags = {"手工入账申请"})
@RestController
public class ApplicationForManualEntryController {
    @Resource
    ApplicationForManualEntryService service;

    @RequestMapping(value = "/api/applicationForManualEntry", method = RequestMethod.POST)
    public long create(@RequestBody ApplicationForManualEntryVO obj) {

        return service.create(obj);
    }

    @RequestMapping(value = "/api/applicationForManualEntry/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * 手工入账审核
     *
     * @param obj
     */
    @RequestMapping(value = "/api/applicationForManualEntry", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody ApplicationForManualEntryDO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/applicationForManualEntry/{id}", method = RequestMethod.GET)
    public ApplicationForManualEntryDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/applicationForManualEntry/list", method = RequestMethod.POST)
    public PageInfo<ApplicationForManualEntryDO> list(@RequestBody Query query) {
        return service.list(query);
    }
}
