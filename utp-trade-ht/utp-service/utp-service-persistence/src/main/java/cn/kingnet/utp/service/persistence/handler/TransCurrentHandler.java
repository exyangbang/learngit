package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.ITransCurrentHandler;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.TransCurrentCondition;
import cn.kingnet.utp.service.persistence.entity.TransOrderRelation;
import cn.kingnet.utp.service.persistence.entity.TransParamFail;
import cn.kingnet.utp.service.persistence.entity.vo.TransBatchRecordVo;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import cn.kingnet.utp.service.persistence.service.TransCurrentAndHistoryService;
import cn.kingnet.utp.trade.common.enums.BatchStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description : 当日交易流水数据处理实现
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 15:57
 */
@RestController
@RequestMapping("/spi/persistence/transCurrent")
public class TransCurrentHandler extends DefaultFeginExceptionHandler implements ITransCurrentHandler {

    @Resource
    private TransCurrentAndHistoryService transCurrentAndHistoryService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTransCurrent(@RequestBody(required = false) List<TransCurrent> transCurrentList) {
        if (!CollectionUtils.isEmpty(transCurrentList)) {
            transCurrentAndHistoryService.insertBatch(transCurrentList);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTransOrderRelation(@RequestBody(required = false) List<TransOrderRelation> transOrderRelationList) {
        if (!CollectionUtils.isEmpty(transOrderRelationList)) {
            MybatisDaoImpl.run().insertBatch(transOrderRelationList, 100);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateByIndustryCodeAndServerTransId(@RequestBody(required = false) TransCurrent transCurrent,
                                                     @RequestParam(value = "industryCode", required = false) String industryCode,
                                                     @RequestParam(value = "serverTransId", required = false) String serverTransId) {
        Assert.hasText(industryCode, "参数 industryCode 不能为空");
        Assert.hasText(serverTransId, "参数 serverTransId 不能为空");
        if (transCurrent != null) {
            PlusEntityWrapper<TransCurrent> condition = TransCurrentCondition.builder().andIndustryCodeEq(industryCode).andServerTransIdEq(serverTransId).build();
            MybatisDaoImpl.run().update(transCurrent, condition);
        }
    }

    @PostMapping("/updateCurrentOrHistoryById")
    @Override
    public void updateCurrentOrHistoryById(@RequestBody(required = false) TransCurrent transCurrent, @RequestParam(value = "historyStatus") boolean historyStatus) {
        transCurrentAndHistoryService.updateCurrentOrHistoryById(transCurrent, historyStatus);
    }

    @Override
    public List<TransCurrent> queryByIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                             @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                             @RequestParam(value = "serverTransId", required = false) String serverTransId
    ) {
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "平台代码不能为空");
        }
        if (StringUtil.isEmpty(clientTransId) && StringUtil.isEmpty(serverTransId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水与服务端流水不能同时为空");
        }

        TransCurrentCondition condition = TransCurrentCondition.builder().andIndustryCodeEq(industryCode);
        if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isEmpty(serverTransId)) {
            condition.andClientTransIdEq(clientTransId);
        } else if (StringUtils.isEmpty(clientTransId) && StringUtils.isNotEmpty(serverTransId)) {
            condition.andServerTransIdEq(serverTransId);
        } else {
            condition.andClientTransIdEq(clientTransId).andServerTransIdEq(serverTransId);
        }

        List<TransCurrent> list = MybatisDaoImpl.run().selectList(condition.build());
        return list;
    }

    @PostMapping("/getByIndustryAndClientTransIdOrServerTransId")
    @Override
    public TransCurrent getByIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                     @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                     @RequestParam(value = "serverTransId", required = false) String serverTransId) {
        return transCurrentAndHistoryService.getByIndustryAndClientTransIdOrServerTransId(industryCode, clientTransId, serverTransId);
    }

    /**
     * 批量保存流水及批次信息
     *
     * @param transBatchRecordVo
     */
    @PostMapping("saveTransCurrentAndBatchInfo")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveTransCurrentAndBatchInfo(TransBatchRecordVo transBatchRecordVo) {
        if (Objects.isNull(transBatchRecordVo.getBatchRecord()) || CollectionUtils.isEmpty(transBatchRecordVo.getCurrentList())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "请求批量信息有误");
        }
        transCurrentAndHistoryService.insertBatch(transBatchRecordVo.getCurrentList());
        MybatisDaoImpl.run().insert(transBatchRecordVo.getBatchRecord());

    }

    /**
     * 批量更新流水及批次信息
     *
     * @param transBatchRecordVo
     */
    @PutMapping("updateTransCurrentAndBatchInfo")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTransCurrentAndBatchInfo(TransBatchRecordVo transBatchRecordVo) {
        if (Objects.isNull(transBatchRecordVo.getBatchRecord()) || CollectionUtils.isEmpty(transBatchRecordVo.getCurrentList())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "请求批量信息有误");
        }
        MybatisDaoImpl.run().updateById(transBatchRecordVo.getBatchRecord());
        MybatisDaoImpl.run().updateBatchById(transBatchRecordVo.getCurrentList());

        //虚拟账户批次入账操作记录完成时，虚拟账户相关金额操作
        if (BatchStatus.COMPLETED.getCode().equals(transBatchRecordVo.getBatchRecord().getBatchStatus())) {
            //TODO
        }

    }

    @Override
    public TransCurrent queryByServerTrandsId(String serverTransId) {
        Assert.hasText(serverTransId, "参数 serverTransId 为空");
        return MybatisDaoImpl.run().selectOne(TransCurrentCondition.builder().andServerTransIdEq(serverTransId).build());
    }

    /**
     * 行业代码 + 客户端流水号 或者 行业代码 + 批次号 是否存在
     *
     * @param industryCode
     * @param clientTransId
     * @param batchId
     * @return
     */
    @Override
    public boolean isExistByIndustryCodeAndClientTransIdOrBatchId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                  @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                  @RequestParam(value = "batchId", required = false) String batchId) {
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "行业代码不能为空");
        }
        if (StringUtil.isEmpty(clientTransId) && StringUtil.isEmpty(batchId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户端流水与批次号不能同时为空");
        }
        TransCurrentCondition condition = TransCurrentCondition.builder().andIndustryCodeEq(industryCode);
        if (StringUtils.isNotEmpty(clientTransId) && StringUtils.isEmpty(batchId)) {
            condition.andClientTransIdEq(clientTransId);
        } else if (StringUtils.isEmpty(clientTransId) && StringUtils.isNotEmpty(batchId)) {
            condition.andServerBatchNoEq(batchId);
        } else {
            condition.and().andClientTransIdEq(clientTransId).orServerBatchNoEq(batchId);
        }

        int count = MybatisDaoImpl.run().selectCount(condition.build());

        return count > 0 ? true : false;
    }

    @GetMapping("/existIndustryAndClientTransIdOrServerTransId")
    @Override
    public boolean existIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                @RequestParam(value = "serverTransId", required = false) String serverTransId) {
        return transCurrentAndHistoryService.existIndustryCodeAndClientTransIdOrServerTransId(industryCode, clientTransId, serverTransId);
    }

    @Override
    @GetMapping("/existIndustryAndSuccessOrderId")
    public boolean existIndustryAndSuccessOrderId(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "orderId", required = false) String orderId) {
        Assert.hasText(industryCode, () -> "industryCode 参数不能为空");
        Assert.hasText(orderId, () -> "orderId 参数不能为空");
        return transCurrentAndHistoryService.existIndustryAndSuccessOrderId(industryCode, orderId);
    }

    @Override
    @PostMapping("/setSplitPaymentRedfund")
    public boolean setSplitPaymentRedfund(@RequestParam(value = "origClientTradeId", required = false) String origClientTradeId) {
        Assert.hasText(origClientTradeId, () -> "origClientTradeId 参数不能为空");
        return transCurrentAndHistoryService.setSplitPaymentRedfund(origClientTradeId);
    }

    @Override
    @PostMapping("/deleteSplitPaymentRedfund")
    public boolean deleteSplitPaymentRedfund(@RequestParam(value = "origClientTradeId", required = false) String origClientTradeId) {
        Assert.hasText(origClientTradeId, () -> "origClientTradeId 参数不能为空");
        return transCurrentAndHistoryService.deleteSplitPaymentRedfund(origClientTradeId);
    }

    @Override
    @PostMapping("/saveTransParamFail")
    public void saveTransParamFail(@RequestBody(required = false) TransParamFailVo transParamFailVo) {
        transCurrentAndHistoryService.saveTransParamFail(TransParamFail.of(transParamFailVo));
    }




}
