package com.scenetec.upf.operation.web.blacklist;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.blacklisapproval.BlacklistApprovalDO;
import com.scenetec.upf.operation.model.vo.BlacklistOperationRecordVO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.IndustryAmtLimitApprovalVO;
import com.scenetec.upf.operation.service.blacklist.BlacklistApprovalService;
import com.scenetec.upf.operation.service.blacklist.BlacklistService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "分账黑名单管理审批记录", tags = {"分账黑名单管理审批记录"})
@RestController
public class BlacklistOperationRecordController {
    @Resource
    BlacklistApprovalService service;

    @RequestMapping(value = "/api/blacklistApr", method = RequestMethod.POST)
    public long create(@Validated @RequestBody BlacklistOperationRecordVO obj) {
        return service.create(obj);
    }


    @RequestMapping(value = "/api/blacklistApr/list", method = RequestMethod.POST)
    public PageInfo<BlacklistApprovalDO> list(@RequestBody Query query) {
        return service.pageList(query);
    }

    /**
     * 审核
     *
     */
    @RequestMapping(value = "/api/blacklistAprOper", method = RequestMethod.PUT)
    public void blacklistAprOper(@RequestBody BlacklistOperationRecordVO obj) {
        service.update(obj);
    }
}
