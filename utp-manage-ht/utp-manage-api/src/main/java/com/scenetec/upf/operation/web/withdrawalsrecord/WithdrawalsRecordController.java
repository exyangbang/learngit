package com.scenetec.upf.operation.web.withdrawalsrecord;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.withdrawalsrecord.WithdrawalsRecordDO;
import com.scenetec.upf.operation.model.vo.QueryCollectionAccountWithdrawRespDTO;
import com.scenetec.upf.operation.model.vo.withdrawalsrecord.WithdrawalsRecordExVO;
import com.scenetec.upf.operation.model.vo.withdrawalsrecord.WithdrawalsRecordVO;
import com.scenetec.upf.operation.service.withdrawalsrecord.WithdrawalsRecordService;
import com.scenetec.upf.operation.utils.OnliineTool.OnlineRequestTool;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "归集账户提现申请记录表", tags = {"归集账户收益提现申请记录表"})
@RestController
public class WithdrawalsRecordController {
    @Resource
    WithdrawalsRecordService service;

    @Resource
    OnlineRequestTool onlineRequestTool;

    @Value("${withdraw.cas.accountRefrsh.url}")
    private String accountRefrshURl;


    @RequestMapping(value = "/api/withdrawalsRecord", method = RequestMethod.POST)
    public long create(@Validated @RequestBody WithdrawalsRecordVO obj) {

        return service.create(obj);
    }


    @RequestMapping(value = "/api/withdrawalsRecord/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * 提现审核
     * @param obj
     */
    @RequestMapping(value = "/api/withdrawalsRecord", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody WithdrawalsRecordExVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/withdrawalsRecord/{id}", method = RequestMethod.GET)
    public WithdrawalsRecordDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/withdrawalsRecord/list", method = RequestMethod.POST)
    public PageInfo<WithdrawalsRecordDO> list(@RequestBody Query query) {
        return service.list(query);
    }

    /**
     * 刷新提现状态
     * @param obj
     */
    @RequestMapping(value = "/api/withdrawalsRecordRefresh", method = RequestMethod.POST)
    public QueryCollectionAccountWithdrawRespDTO withdrawalsRecordRefresh(@RequestBody WithdrawalsRecordExVO obj) {
        QueryCollectionAccountWithdrawRespDTO queryCollectionAccountWithdrawRespDTO =  service.queryCollectAccountWithdrawUrl(obj);
        return queryCollectionAccountWithdrawRespDTO;
    }

}
