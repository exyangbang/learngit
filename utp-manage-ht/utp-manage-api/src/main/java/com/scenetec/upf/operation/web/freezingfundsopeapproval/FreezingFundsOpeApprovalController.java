package com.scenetec.upf.operation.web.freezingfundsopeapproval;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.blacklisapproval.BlacklistApprovalDO;
import com.scenetec.upf.operation.model.domain.freezingfundsopeapproval.FreezingFundsOpeApprovalDO;
import com.scenetec.upf.operation.model.vo.BlacklistOperationRecordVO;
import com.scenetec.upf.operation.service.blacklist.BlacklistApprovalService;
import com.scenetec.upf.operation.service.freezingfundsopeapproval.FreezingFundsOpeApprovalService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@Api(value = "冻结资金审批记录", tags = {"冻结资金审批记录"})
@RestController
public class FreezingFundsOpeApprovalController {
    @Resource
    private FreezingFundsOpeApprovalService service;

    @RequestMapping(value = "/api/freezingFundsOpeRecord", method = RequestMethod.POST)
    public long create(@RequestBody FreezingFundsOpeApprovalDO obj) {
        return service.create(obj);
    }


    @RequestMapping(value = "/api/freezingFundsOpeRecord/list", method = RequestMethod.POST)
    public PageInfo<FreezingFundsOpeApprovalDO> list(@RequestBody Query query) {
        return service.pageList(query);
    }

    /**
     * 审核
     */
    @RequestMapping(value = "/api/freezingFundsOpeRecordOper", method = RequestMethod.PUT)
    public void blacklistAprOper(@RequestBody FreezingFundsOpeApprovalDO obj) {
        service.update(obj);
    }
}
