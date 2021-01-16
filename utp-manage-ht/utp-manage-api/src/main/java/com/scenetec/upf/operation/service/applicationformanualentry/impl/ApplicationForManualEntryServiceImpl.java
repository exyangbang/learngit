package com.scenetec.upf.operation.service.applicationformanualentry.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.AuditStatusEnum;
import com.scenetec.upf.operation.model.domain.applicationformanualentry.ApplicationForManualEntryDO;
import com.scenetec.upf.operation.model.domain.bankaccounttransdetail.BankAccountTransDetailDO;
import com.scenetec.upf.operation.model.domain.withdrawalsrecord.status.WithdrawalsRecordStatusEnum;
import com.scenetec.upf.operation.model.vo.applicationformanualentry.ApplicationForManualEntryVO;
import com.scenetec.upf.operation.repository.applicationformanualentry.ApplicationForManualEntryMapper;
import com.scenetec.upf.operation.service.applicationformanualentry.ApplicationForManualEntryService;
import com.scenetec.upf.operation.service.bankaccounttransdetail.BankAccountTransDetailService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationForManualEntryServiceImpl implements ApplicationForManualEntryService {
    @Resource
    ApplicationForManualEntryMapper manualEntryMapper;
    @Resource
    UserService userService;
    @Resource
    BankAccountTransDetailService service;
    @Value("${application.for.anual.entry.url}")
    String applicationForManualEntryURL;

    @Override
    @Transactional
    public Long create(ApplicationForManualEntryVO entryVO) {
        BankAccountTransDetailDO bankAccountTransDetailDO = service.getById(entryVO.getTransId());
        if (bankAccountTransDetailDO == null) {
            throw new SystemRuntimeException(ErrorCode.CASH003);
        }
        ApplicationForManualEntryDO obj = new ApplicationForManualEntryDO();
        obj.setTransId(entryVO.getTransId());
        //'手工入账状态（0-待审核 1-审核通过 2-审核驳回）' 待审核或审核通过的不能再发起
        obj.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        obj.setAuditStatusPass(AuditStatusEnum.AUDIT_PASS.getValue());
        if (manualEntryMapper.countCustom(obj) > 0) {
            throw new SystemRuntimeException(ErrorCode.SGIMTR002);
        }
        obj.setTransId(entryVO.getTransId());
        obj.setCustAccountNo(bankAccountTransDetailDO.getCustAccountNo());
        obj.setCustAccountName(bankAccountTransDetailDO.getCustAccountName());
        obj.setTxnAmount(bankAccountTransDetailDO.getTxnAmount());
        obj.setAccountBalance(bankAccountTransDetailDO.getAccountBalance());
        obj.setOtherCustAccountNo(bankAccountTransDetailDO.getOtherCustAccountNo());
        obj.setOtherCustName(bankAccountTransDetailDO.getOtherCustName());
        obj.setSysReferenceNo(bankAccountTransDetailDO.getSysReferenceNo());
        obj.setAccount(entryVO.getAccount());
        obj.setAccountName(entryVO.getAccountName());
        obj.setGmtCreate(new Date());
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        obj.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());//状态（0-待审核 1-审核通过 2-审核驳回）
        obj.setStatus(WithdrawalsRecordStatusEnum.CHAN_AVAILABLE.getValue());//状态（0-不可用 1-可用）
        obj.setId(IdGenerate.getId());
        long res = manualEntryMapper.create(obj);
        //修改未入账流水表的审核状态
        bankAccountTransDetailDO.setAuditStatus(AuditStatusEnum.AUDIT_UNTREATED.getValue());
        bankAccountTransDetailDO.setId(obj.getTransId());
        service.update(bankAccountTransDetailDO);
        return res;
    }

    @Override
    public int delete(Long id) {
          if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return manualEntryMapper.updateByStatus(id);
    }

    /**
     * audit_status '状态（0-待审核 1-审核通过 2-审核驳回）'
     * 审批
     * 手工入账点击“审核通过后”，处理流程
     * 1. 更改手工入账申请记录状态为“审核通过”
     * 2. 未入账资金流水表 该笔交易流水变更为已入账。
     * 3. 虚拟账户表  入账的虚拟账户增加对应的余额
     * 4. 虚拟账户资金明细表   记录一笔资金明细流水    账户操作类型 记 01-入金    子类型记 7-手工入账
     * 以上4个步骤需在同一个事务中处理，不成功就回滚。
     * 5. 成功后调用信息通知接口，通知接入方。 代付客户虚拟账户入金的走 01 平台账户入金通知 ，  个人/企业虚拟账户入金的走03 二级账户入金通知
     *
     * @param obj
     */
    @Override
    @Transactional
    public void update(ApplicationForManualEntryDO obj) {
        if (obj == null || obj.getId() < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (obj.getAuditStatus() == null || !AuditStatusEnum.contains(obj.getAuditStatus())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        ApplicationForManualEntryDO tempObj = new ApplicationForManualEntryDO();
        tempObj.setId(obj.getId());
        tempObj.setAuditStatus(obj.getAuditStatus());
        tempObj.setGmtModified(new Date());
        tempObj.setUserModified(userService.getUserContext().getUsername());
        tempObj.setRemark(obj.getRemark());
        ApplicationForManualEntryDO manualEntryDO = manualEntryMapper.getById(obj.getId());
        if (manualEntryDO.getAuditStatus().equals(AuditStatusEnum.AUDIT_PASS.getValue())) {
            throw new SystemRuntimeException(ErrorCode.SGIMTR002);//已经通过不能重复发起
        }
        if (manualEntryDO.getAuditStatus().equals(AuditStatusEnum.AUDIT_REJECT.getValue())) {
            throw new SystemRuntimeException(ErrorCode.SGIMTR002);//已经驳回不能重复发起
        }
        if (obj.getAuditStatus().equals(AuditStatusEnum.AUDIT_PASS.getValue())) {//审核通过
            Map response;
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.postForObject(applicationForManualEntryURL, manualEntryDO, Map.class);
            if (response == null) {
                throw new SystemRuntimeException(ErrorCode.BSMPS001, "调用入账服务错误！");
            }
            if (!response.get("status").equals("200")) {
                if (response.get("message") == null) {
                    throw new SystemRuntimeException(ErrorCode.BSMPS001, "调用入账服务错误！");
                }
                throw new SystemRuntimeException(ErrorCode.BSMPS001, response.get("message").toString());
            }
        } else {//驳回
            ApplicationForManualEntryDO applicationForManualEntryDO = manualEntryMapper.getById(obj.getId());
            BankAccountTransDetailDO bankAccountTransDetailDO = service.getById(applicationForManualEntryDO.getTransId());
            String auds = AuditStatusEnum.AUDIT_REJECT.getValue();
            bankAccountTransDetailDO.setAuditStatus(auds);
            bankAccountTransDetailDO.setId(applicationForManualEntryDO.getTransId());
            service.update(bankAccountTransDetailDO);
        }
        manualEntryMapper.update(tempObj);
    }

    @Override
    public ApplicationForManualEntryDO getById(Long id) {
          if (id < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        return manualEntryMapper.getById(id);
    }

    @Override
    public PageInfo<ApplicationForManualEntryDO> list(Query obj) {
        obj.setPageNo(obj.getPageNo() == 0 ? 1 : obj.getPageNo());
        obj.setPageSize(obj.getPageSize() == 0 ? 10 : obj.getPageSize());
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());
        PageHelper.orderBy("gmt_modified desc");
        List<ApplicationForManualEntryDO> page = manualEntryMapper.listPage(obj.getParameters());
        return new PageInfo<>(page);
    }
}
