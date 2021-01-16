package com.scenetec.upf.operation.web.fundaccount;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.fundaccount.FundAccountDO;
import com.scenetec.upf.operation.model.vo.fundaccount.FundAccountVO;
import com.scenetec.upf.operation.service.fundaccount.FundAccountService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(value = "资金账户管理", tags = {"资金账户管理"})
@RestController
public class FundAccountController {

    @Resource
    FundAccountService service;


    @RequestMapping(value = "/api/fundAccount", method = RequestMethod.POST)
    public long create(@Validated @RequestBody FundAccountVO obj) {
        return service.create(obj);
    }

    @RequestMapping(value = "/api/fundAccount/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/fundAccount", method = RequestMethod.PUT)
    public void update(@RequestBody FundAccountVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/fundAccount/{id}", method = RequestMethod.GET)
    public FundAccountDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/fundAccount/list", method = RequestMethod.POST)
    public PageInfo<FundAccountDO> list(@RequestBody Query query) {
        return service.list(query);
    }

    /**
     * 添加手续费账户 --》如果账户类型选择归集账户--》选择资金账户的时候，要判断，如果已经被配置过的不能再配置
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/fundAccountScreen/list", method = RequestMethod.POST)
    public PageInfo<FundAccountDO> fundAccountScreen(@RequestBody Query query) {
        return service.fundAccountScreen(query);
    }
    /**
     * 代付客户明细
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/fundAccount/listDeatil", method = RequestMethod.POST)
    public Map<String, Object> listDeatil(@RequestBody Query query) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", service.listDatail(query));
        map.put("total", service.countSum(query.getParameters()));
        return map;
    }

}
