package com.scenetec.upf.operation.web.bankaccounttransdetail;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.bankaccounttransdetail.BankAccountTransDetailDO;
import com.scenetec.upf.operation.service.bankaccounttransdetail.BankAccountTransDetailService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "未入账资金流水查询", tags = {"未入账资金流水查询"})
@RestController
public class BankAccountTransDetailController {
    @Resource
    BankAccountTransDetailService service;
    @RequestMapping(value = "/api/bankAccountTransDetail/{id}", method = RequestMethod.GET)
    public BankAccountTransDetailDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/bankAccountTransDetail/pageList", method = RequestMethod.POST)
    public PageInfo<BankAccountTransDetailDO> pageList(@RequestBody Query query) {
        return service.pageList(query);
    }
}
