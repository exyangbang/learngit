package com.scenetec.upf.operation.web.industryamtlimit;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.Enum.InduAmtLimitOperationTypeEnum;
import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitApprovalDO;
import com.scenetec.upf.operation.model.vo.industryamtlimit.IndustryAmtLimitApprovalVO;
import com.scenetec.upf.operation.service.industryamtlimit.IndustryAmtLimitApprovalService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "客户风控参数管理审批", tags = {"客户风控参数管理审批"})
@RestController
public class IndustryAmtLimitApprovalController {

    @Resource
    IndustryAmtLimitApprovalService service;

    @RequestMapping(value = "/api/industryAmLimitApproval", method = RequestMethod.POST)
    public long create(@RequestBody IndustryAmtLimitApprovalVO obj) {

        return service.create(obj);
    }

    @RequestMapping(value = "/api/industryAmLimitApproval/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/industryAmLimitApproval", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody IndustryAmtLimitApprovalVO obj) {
        service.update(obj);
    }

    @RequestMapping(value = "/api/industryAmLimitApproval/{id}", method = RequestMethod.GET)
    public IndustryAmtLimitApprovalDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/industryAmLimitApproval/list", method = RequestMethod.POST)
    public PageInfo<IndustryAmtLimitApprovalDO> list(@RequestBody Query query) {
        return service.list(query);
    }

    /**
     * 审核
     *
     */
    @RequestMapping(value = "/api/industryAmLimitApprovalAudit", method = RequestMethod.PUT)
    public void quotaExaApprovalAudit(@Validated @RequestBody IndustryAmtLimitApprovalVO obj) {
        service.quotaExaApprovalAudit(obj);
        IndustryAmtLimitApprovalDO tempInd = service.getById(obj.getId());
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
    @RequestMapping(value = "/api/industryAmtLimitApprovalReq", method = RequestMethod.POST)
    public void subAccountLimitAmountOnlineReq(@RequestBody IndustryAmtLimitApprovalVO obj) {
        service.updateToOnlineReuqest(obj);
    }

}
