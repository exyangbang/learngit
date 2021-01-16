package com.scenetec.upf.operation.web.withdrawcashaccount;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.withdrawcashaccount.WithdrawCashAccountDO;
import com.scenetec.upf.operation.model.vo.withdrawcashaccount.WithdrawCashAccountVO;
import com.scenetec.upf.operation.service.withdrawcashaccount.WithdrawCashAccountService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Api(value = "提现账户表", tags = {"提现账户表"})
@RestController
public class WithdrawCashAccountController {
    @Resource
    WithdrawCashAccountService service;

    @RequestMapping(value = "/api/withdrawCashAccount", method = RequestMethod.POST)
    public long create(@Validated @RequestBody WithdrawCashAccountVO obj) {

        return service.create(obj);
    }

    @RequestMapping(value = "/api/withdrawCashAccount/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * 修改提现账户
     * @param obj
     */
    @RequestMapping(value = "/api/withdrawCashAccount", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody WithdrawCashAccountVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/withdrawCashAccount/{id}", method = RequestMethod.GET)
    public WithdrawCashAccountDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/withdrawCashAccount/list", method = RequestMethod.POST)
    public PageInfo<WithdrawCashAccountDO> list(@RequestBody Query query) {
        return service.list(query);
    }


}
