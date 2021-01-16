package com.scenetec.upf.operation.web.blacklist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.blacklist.BlacklistDO;
import com.scenetec.upf.operation.service.blacklist.BlacklistService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "分账黑名单管理", tags = {"分账黑名单管理"})
@RestController
public class  BlacklistController {
    @Resource
    BlacklistService service;

    @RequestMapping(value = "/api/blacklist/list", method = RequestMethod.POST)
    public PageInfo<BlacklistDO> list(@RequestBody Query query) {
        return service.getBlackList(query);
    }

}
