package com.scenetec.upf.operation.web.operationrecord;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.Enum.OperationTypeEnum;
import com.scenetec.upf.operation.model.domain.operationrecord.OperationRecordDO;
import com.scenetec.upf.operation.model.vo.operationrecord.OperationRecordBatchApplyVO;
import com.scenetec.upf.operation.model.vo.operationrecord.OperationRecordBatchVO;
import com.scenetec.upf.operation.model.vo.operationrecord.OperationRecordVO;
import com.scenetec.upf.operation.service.operationrecord.OperationRecordService;
import com.scenetec.zeus.daogenerator.model.Query;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Api(value = "审批记录", tags = {"审批记录"})
@RestController
@Slf4j
public class OperationRecordController {
    @Resource
    OperationRecordService service;


    @RequestMapping(value = "/api/operationRecord", method = RequestMethod.POST)
    public long create(@RequestBody OperationRecordDO obj) {
        return service.create(obj);
    }

    /**
     * 批量申请
     */
    @RequestMapping(value = "/api/operationRecord/batch", method = RequestMethod.POST)
    public void batch(@RequestBody OperationRecordBatchApplyVO operationRecordBatchApplyVO) {
        if (!OperationTypeEnum.contains(operationRecordBatchApplyVO.getOperationType())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (StringUtils.isBlank(operationRecordBatchApplyVO.getApplyRemark())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        AtomicInteger failAtomic = new AtomicInteger(0);
        List<OperationRecordVO> list = operationRecordBatchApplyVO.getOperationRecords();
        if (CollectionUtils.isEmpty(list)) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        for (OperationRecordVO operationRecordVO : list) {
            try {
                OperationRecordDO operationRecordDO = new OperationRecordDO();
                BeanUtils.copyProperties(operationRecordVO, operationRecordDO);
                operationRecordDO.setApplyRemark(operationRecordBatchApplyVO.getApplyRemark());
                operationRecordDO.setOperationType(operationRecordBatchApplyVO.getOperationType());
                service.create(operationRecordDO);
            } catch (SystemRuntimeException e) {
                failAtomic.incrementAndGet();
                log.error("批量申请异常", e);
            }
        }
        if (failAtomic.get() > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, String.format("共%s笔，失败%s笔，成功%s笔", list.size(), failAtomic.get(), list.size() - failAtomic.get()));
        }
    }

    @RequestMapping(value = "/api/operationRecord/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/api/operationRecord", method = RequestMethod.PUT)
    public void update(@RequestBody OperationRecordDO obj) {

    }

    @RequestMapping(value = "/api/operationRecord/{id}", method = RequestMethod.GET)
    public OperationRecordDO get(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/api/operationRecord/pageList", method = RequestMethod.POST)
    public PageInfo<OperationRecordVO> pageList(@RequestBody Query query) {
        return service.list(query);
    }

    /**
     * 审批
     * @param
     * @return
     */
    @RequestMapping(value = "/api/operationRecordOper/operation", method = RequestMethod.PUT)
    public void operationRecordOper(@RequestBody OperationRecordDO obj) {
        service.update(obj);
    }

    /**
     * 批量审批
     * @param operationRecordBatchVO
     */
    @RequestMapping(value = "/api/operationRecordOper/batchAudit", method = RequestMethod.PUT)
    public void batchAudit(@RequestBody OperationRecordBatchVO operationRecordBatchVO) {
        if (CollectionUtils.isEmpty(operationRecordBatchVO.getIds())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (!OperationTypeEnum.contains(operationRecordBatchVO.getOperationType())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        if (StringUtils.isBlank(operationRecordBatchVO.getRemarks())) {
            throw new SystemRuntimeException(ErrorCode.BSMCM001);
        }
        int fail = service.batchAudit(operationRecordBatchVO);
        if (fail > 0) {
            throw new SystemRuntimeException(ErrorCode.BSMPS001, String.format("共%s笔，失败%s笔，成功%s笔", operationRecordBatchVO.getIds().size(), fail, operationRecordBatchVO.getIds().size() - fail));
        }
    }
}
