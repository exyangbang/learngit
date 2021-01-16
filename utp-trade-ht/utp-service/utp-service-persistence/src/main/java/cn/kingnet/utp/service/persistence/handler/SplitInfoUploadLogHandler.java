package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.ISplitInfoUploadLogHandler;
import cn.kingnet.utp.service.persistence.entity.JobTaskCondition;
import cn.kingnet.utp.service.persistence.entity.SplitInfoCondition;
import cn.kingnet.utp.service.persistence.entity.SplitInfoUploadLog;
import cn.kingnet.utp.service.persistence.entity.SplitInfoUploadLogCondition;
import cn.kingnet.utp.service.persistence.service.JobTaskService;
import cn.kingnet.utp.trade.common.enums.JobTaskId;
import cn.kingnet.utp.trade.common.enums.JobTaskStatus;
import cn.kingnet.utp.trade.common.enums.SplitStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 清算分账上送日志业务
 * @Author WJH
 * @Date 2018年10月30日
 */
@RestController
@RequestMapping("/spi/persistence/splitInfoUploadLog")
@Slf4j
public class SplitInfoUploadLogHandler extends DefaultFeginExceptionHandler implements ISplitInfoUploadLogHandler {

    @Resource
    private JobTaskService jobTaskService;

    /**
     * 持久化 清算分账文件
     *
     * @param splitInfoUploadLog
     */
    @PostMapping("/saveSplitInfoUploadLog")
    @Override
    public void saveSplitInfoUploadLog(@RequestBody(required = false) SplitInfoUploadLog splitInfoUploadLog) {
        MybatisDaoImpl.run().insert(splitInfoUploadLog);
    }


    /**
     * 更新 清算分账上送纪录状态
     *
     * @param splitInfoUploadLog
     */
    @PutMapping("/updateSplitInfoUploadLogStatus")
    @Override
    public void updateSplitInfoUploadLogStatus(@RequestBody(required = false) SplitInfoUploadLog splitInfoUploadLog) {
        TransStatus.resolve(splitInfoUploadLog.getTransStatus());
        if (splitInfoUploadLog != null && splitInfoUploadLog.getId() != null && splitInfoUploadLog.getId() > 0) {
            MybatisDaoImpl.run().updateById(splitInfoUploadLog);
        } else {
            String setSql = String.format("trans_status='%s',remark='%s',gmt_modified='%s'", splitInfoUploadLog.getTransStatus(),
                    StringUtil.trimToEmpty(splitInfoUploadLog.getRemark()), DateUtil.getCurrentDate(DateUtil.FORMAT_DATETIME));
            PlusEntityWrapper<SplitInfoUploadLog> condition = SplitInfoUploadLogCondition.builder().andProviderCodeEq(splitInfoUploadLog.getProviderCode())
                    .andSettleDateEq(splitInfoUploadLog.getSettleDate())
                    .andBatchIdEq(splitInfoUploadLog.getBatchId())
                    .build();
            MybatisDaoImpl.run().updateForSet(setSql, condition);
        }

    }


    /**
     * 异常回退
     * 1.清算分账上送纪录状态变更为失败
     * 2.删除关联的清算任务及关联的分账信息
     *
     * @param splitInfoUploadLog
     */
    @PostMapping("/rollbackSplitInfoUploadLog")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rollbackSplitInfoUploadLog(@RequestBody(required = false) SplitInfoUploadLog splitInfoUploadLog) {
        if (splitInfoUploadLog != null) {
            splitInfoUploadLog.setRemark(StringUtil.isEmpty(splitInfoUploadLog.getRemark())?"异常回退处理":splitInfoUploadLog.getRemark());
            splitInfoUploadLog.setTransStatus(TransStatus.TRADE_FAILURE.name());
            updateSplitInfoUploadLogStatus(splitInfoUploadLog);
            final String taskId = JobTaskId.SETTLESPLIT_TASKID.getTaskId(splitInfoUploadLog.getProviderCode(),splitInfoUploadLog.getSettleDate(),splitInfoUploadLog.getBatchId());
            MybatisDaoImpl.run().delete(JobTaskCondition.builder().andTaskIdEq(taskId).and().andJobtaskStateNe(JobTaskStatus.SUCCESS.name()).orJobtaskStateIsNull().build());
            MybatisDaoImpl.run().delete(SplitInfoCondition.builder().andProviderCodeEq(splitInfoUploadLog.getProviderCode())
                    .andSettleDateEq(splitInfoUploadLog.getSettleDate()).andBatchIdEq(splitInfoUploadLog.getBatchId())
                    .andStatusEq(SplitStatus.SPLIT_UNDO.getStatus()).build());
        }
    }


    /**
     * 清算分账信息：是否存在
     *
     * @param providerCode
     * @param settleDate
     * @param batchId
     * @param transStatus
     * @return
     */
    @GetMapping("/isExistSplitInfoUploadLog")
    @Override
    public boolean isExistSplitInfoUploadLog(
            @RequestParam(value = "providerCode", required = false) String providerCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchId", required = false) String batchId,
            @RequestParam(value = "transStatus", required = false) String transStatus
    ) {
        SplitInfoUploadLogCondition condition = SplitInfoUploadLogCondition.builder();
        condition.andProviderCodeEq(providerCode).andSettleDateEq(settleDate).andBatchIdEq(batchId);
        if (StringUtil.isNotEmpty(transStatus)) {
            TransStatus.resolve(transStatus);
            condition.andTransStatusEq(transStatus);
        }

        return MybatisDaoImpl.run().selectCount(condition.build()) > 0;


    }


    /**
     * @param providerCode 文件提供方
     * @param settleDate   清算日期
     * @param batchId      批次ID
     * @return
     */
    @GetMapping("querySplitInfoByBatchId")
    @Override
    public SplitInfoUploadLog querySplitInfoByBatchId(@RequestParam(value = "providerCode", required = false) String providerCode,
                                                      @RequestParam(value = "settleDate", required = false) String settleDate,
                                                      @RequestParam(value = "batchId", required = false) String batchId
    ) {
        return MybatisDaoImpl.run().selectOne(SplitInfoUploadLogCondition.builder()
                .andProviderCodeEq(providerCode).andSettleDateEq(settleDate).andBatchIdEq(batchId).build());
    }


    /**
     * 实时 创建清算分账文件处理任务
     *
     * @param providerCode
     * @param settleDate
     * @param batchId
     */
    @PostMapping("/createJobTask4SplitInfo")
    @Override
    public void createJobTask4SplitInfo(@RequestParam(value = "providerCode", required = false) String providerCode,
                                        @RequestParam(value = "settleDate", required = false) String settleDate,
                                        @RequestParam(value = "batchId", required = false) String batchId) {
        jobTaskService.createJobTask4SplitInfo(providerCode, settleDate, batchId);
    }


}
