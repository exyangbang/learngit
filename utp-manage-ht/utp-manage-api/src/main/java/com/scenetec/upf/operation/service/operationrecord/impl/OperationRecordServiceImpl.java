package com.scenetec.upf.operation.service.operationrecord.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.OperationTypeEnum;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.operationrecord.OperationRecordDO;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import com.scenetec.upf.operation.model.vo.operationrecord.OperationRecordBatchVO;
import com.scenetec.upf.operation.model.vo.operationrecord.OperationRecordVO;
import com.scenetec.upf.operation.repository.account.AccountMapper;
import com.scenetec.upf.operation.repository.operationrecord.OperationRecordMapper;
import com.scenetec.upf.operation.service.operationrecord.OperationRecordService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.DateUtilities;
import com.scenetec.upf.operation.utils.IdGenerate;
import com.scenetec.zeus.daogenerator.model.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OperationRecordServiceImpl implements OperationRecordService {

    @Resource
    OperationRecordMapper recordMapper;

    @Resource
    UserService userService;

    @Resource
    AccountMapper accountMapper;


    @Override
    public long create(OperationRecordDO obj) {
        if (obj.getStatus().equals("2")){
            throw new SystemRuntimeException(ErrorCode.BSMSC006,"该账户已被销户");
        }
        if (!OperationTypeEnum.contains(obj.getOperationType())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (obj.getOperationType().equals(OperationTypeEnum.FREEZE_PENDING_REVIEW.getCode())) {//冻结操作
            obj.setStatus("0");
        }
        if (obj.getOperationType().equals(OperationTypeEnum.THAWING_PENDING_REVIEW.getCode())) {//解冻操作
            obj.setStatus("1");
        }
        obj.setGmtCreate(new Date());
        Date getDate = Calendar.getInstance().getTime();
        String dateStr = new SimpleDateFormat("yyyyMMdd").format(getDate);
        obj.setSndDate(dateStr);
        obj.setUserCreate(userService.getUserContext().getUsername());
        obj.setId(IdGenerate.getId());
        return recordMapper.create(obj);
    }

    @Override
    public int delete(Long id) {
        return recordMapper.delete(id);
    }

    @Override
    @Transactional
    public void update(OperationRecordDO obj) {
        obj.setGmtModified(new Date());
        obj.setUserModified(userService.getUserContext().getUsername());
        if (obj.getId() == null || obj.getId() < 0) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (!OperationTypeEnum.contains(obj.getOperationType())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        OperationRecordDO temObj = recordMapper.getById(obj.getId());
        //如果虚拟账户被销户的不能操作
        AccountDO tempAc = new AccountDO();
        tempAc.setAccount(temObj.getAccount());
        tempAc = accountMapper.selectOne(tempAc);
        if (tempAc.getStatus().equals("2")){
            throw new SystemRuntimeException(ErrorCode.BSMSC006,"该账户已被销户");
        }

        //冻结审核通过
        if (obj.getOperationType().equals(OperationTypeEnum.FREEZE_APPROVAL.getCode())) {
            AccountDO accountDO = new AccountDO();
            accountDO.setAccount(temObj.getAccount());
            accountDO.setGmtModified(new Date());
            accountDO.setStatus("0");
            accountDO.setUserModified(userService.getUserContext().getUsername());
            accountMapper.updateByAccount(accountDO);
        }
        //解冻审核通过
        if (obj.getOperationType().equals(OperationTypeEnum.THAWING_APPROVAL.getCode())) {
            AccountDO accountDO = new AccountDO();
            accountDO.setAccount(temObj.getAccount());
            accountDO.setGmtModified(new Date());
            accountDO.setStatus("1");
            accountDO.setUserModified(userService.getUserContext().getUsername());
            accountMapper.updateByAccount(accountDO);
        }
        recordMapper.update(obj);
    }

    @Override
    public OperationRecordDO getById(Long id) {
        return recordMapper.getById(id);
    }

    @Override
    public PageInfo<OperationRecordVO> list(Query query) {
        query.setPageNo(query.getPageNo() == 0 ? 1 : query.getPageNo());
        query.setPageSize(query.getPageSize() == 0 ? 10 : query.getPageSize());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        PageHelper.orderBy("gmt_create desc");
        Page<OperationRecordDO> page = recordMapper.listPage(query.getParameters());
        List<OperationRecordVO> list = page.getResult().stream().map(operationRecordDO -> {
            OperationRecordVO operationRecordVO = new OperationRecordVO();
            BeanUtils.copyProperties(operationRecordDO, operationRecordVO);
            return operationRecordVO;
        }).collect(Collectors.toList());
        Page<OperationRecordVO> resultPage = new Page();
        resultPage.setPageNum(query.getPageNo());
        resultPage.setPageSize(query.getPageSize());
        resultPage.setTotal(page.getTotal());
        resultPage.getResult().addAll(list);
        return resultPage.toPageInfo();
    }

    @Override
    public int batchAudit(OperationRecordBatchVO operationRecordBatchVO) {
        AtomicInteger failAtomic = new AtomicInteger(0);
        for (Long id: operationRecordBatchVO.getIds()) {
            try {
                if (id == null || id < 0) {
                    throw new SystemRuntimeException(ErrorCode.BSMCM001);
                }
                OperationRecordDO operationRecordDO = recordMapper.getById(id);
                if (Objects.isNull(operationRecordDO)) {
                    SystemRuntimeException e = new SystemRuntimeException(ErrorCode.BSMCM001);
                    e.setMessage(String.format("id[%s]不存在", id));
                    throw e;
                }

                //如果虚拟账户被销户的不能操作
                AccountDO account = new AccountDO();
                account.setAccount(operationRecordDO.getAccount());
                account = accountMapper.selectOne(account);
                if (account.getStatus().equals("2")) {
                    SystemRuntimeException e = new SystemRuntimeException(ErrorCode.BSMSC006,"该账户已被销户");
                    e.setMessage(String.format("id[%s]该账户已被销户", id));
                    throw e;
                }
                String operationType = operationRecordBatchVO.getOperationType();
                // 判断当前记录操作类型
                if (OperationTypeEnum.FREEZE_PENDING_REVIEW.getCode().equals(operationRecordDO.getOperationType())) {
                    if ("1".equals(operationType)) {
                        operationType = OperationTypeEnum.FREEZE_APPROVAL.getCode();
                    } else {
                        operationType = OperationTypeEnum.FREEZE_APPROVAL_REJECTED.getCode();
                    }
                } else if (OperationTypeEnum.THAWING_PENDING_REVIEW.getCode().equals(operationRecordDO.getOperationType())) {
                    if ("1".equals(operationType)) {
                        operationType = OperationTypeEnum.THAWING_APPROVAL.getCode();
                    } else {
                        operationType = OperationTypeEnum.THAWING_AUDIT_REJECTED.getCode();
                    }
                } else {
                    SystemRuntimeException e = new SystemRuntimeException(ErrorCode.BSMCM001);
                    e.setMessage(String.format("id[%s]不支持的操作类型", id));
                    throw e;
                }
                //冻结审核通过
                if (operationType.equals(OperationTypeEnum.FREEZE_APPROVAL.getCode())) {
                    AccountDO accountDO = new AccountDO();
                    accountDO.setAccount(operationRecordDO.getAccount());
                    accountDO.setGmtModified(new Date());
                    accountDO.setStatus("0");
                    accountDO.setUserModified(userService.getUserContext().getUsername());
                    accountMapper.updateByAccount(accountDO);
                }
                //解冻审核通过
                if (operationType.equals(OperationTypeEnum.THAWING_APPROVAL.getCode())) {
                    AccountDO accountDO = new AccountDO();
                    accountDO.setAccount(operationRecordDO.getAccount());
                    accountDO.setGmtModified(new Date());
                    accountDO.setStatus("1");
                    accountDO.setUserModified(userService.getUserContext().getUsername());
                    accountMapper.updateByAccount(accountDO);
                }
                OperationRecordDO operationRecord = new OperationRecordDO();
                operationRecord.setId(id);
                operationRecord.setOperationType(operationType);
                operationRecord.setRemarks(operationRecordBatchVO.getRemarks());
                operationRecord.setGmtModified(new Date());
                operationRecord.setUserModified(userService.getUserContext().getUsername());
                recordMapper.update(operationRecord);
            } catch (SystemRuntimeException e) {
                log.error("批量处理异常", e);
                failAtomic.incrementAndGet();
            }
        }
        return failAtomic.get();
    }
}
