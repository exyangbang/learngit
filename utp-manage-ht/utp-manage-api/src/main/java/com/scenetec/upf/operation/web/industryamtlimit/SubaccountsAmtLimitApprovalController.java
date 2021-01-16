package com.scenetec.upf.operation.web.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.InduAmtLimitOperationTypeEnum;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.IndustryAmtLimitApprovalVO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.SubaccountsAmtLimitApprovalVO;
import com.scenetec.upf.operation.service.industryamtlimit.SubaccountsAmtLimitApprovalService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "子账户交易限额管理审批", tags = {"子账户交易限额管理审批"})
@RestController
public class SubaccountsAmtLimitApprovalController {

    @Resource
    SubaccountsAmtLimitApprovalService service;

    @RequestMapping(value = "/api/subaccountsmtALimitApproval", method = RequestMethod.POST)
    public long create(@Validated @RequestBody SubaccountsAmtLimitApprovalVO obj) {

        return service.create(obj);
    }

    @RequestMapping(value = "/api/subaccountsmtALimitApproval/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/subaccountsmtALimitApproval", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody SubaccountsAmtLimitApprovalVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/subaccountsmtALimitApproval/{id}", method = RequestMethod.GET)
    public SubaccountsAmtLimitApprovalDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/subaccountsmtALimitApproval/list", method = RequestMethod.POST)
    public PageInfo<SubaccountsAmtLimitApprovalDO> list(@RequestBody Query query) {
        return service.list(query);
    }

    /**
     * 审核
     *
     */
    @RequestMapping(value = "/api/subaccountsmtALimitApprovalAudit", method = RequestMethod.PUT)
    public void quotaExaApprovalAudit(@Validated @RequestBody SubaccountsAmtLimitApprovalVO obj) {
        service.quotaExaApprovalAudit(obj);
        SubaccountsAmtLimitApprovalDO tempInd = service.getById(obj.getId());
        ////通过审核，并且不是删除的情况再通知联机，删除情况另外处理
        if (AuditStatusEnum.AUDIT_PASS.getValue().equals(obj.getAuditStatus())&&
        !InduAmtLimitOperationTypeEnum.FREEZE_APPROVAL.getCode().equals(tempInd.getOperationType())) {
            service.updateToOnlineReuqest1(obj);
        }

    }


    /**
     * 告知联机刷新额度
     * @param query
     * @return
     */
    @RequestMapping(value = "/api/subAccountLimitAmountOnlineReq", method = RequestMethod.POST)
    public void subAccountLimitAmountOnlineReq(@RequestBody SubaccountsAmtLimitApprovalVO obj) {
        service.updateToOnlineReuqest(obj);
    }
}
