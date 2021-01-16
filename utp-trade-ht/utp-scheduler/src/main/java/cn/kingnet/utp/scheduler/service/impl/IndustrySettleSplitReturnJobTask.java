package cn.kingnet.utp.scheduler.service.impl;

import cn.kingnet.utp.scheduler.data.bo.SettleSplitReturnTaskBO;
import cn.kingnet.utp.scheduler.data.entity.JobTask;
import cn.kingnet.utp.scheduler.job.SimpleJobTaskService;
import cn.kingnet.utp.scheduler.service.AbstractJobManagerService;
import cn.kingnet.utp.scheduler.service.IndustrySettleSplitService;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.JobTaskId;
import cn.kingnet.utp.trade.common.exception.SchedulerException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 华通 处理EB创建清算分账回盘文件
 */
@Service
@Slf4j
public class IndustrySettleSplitReturnJobTask extends AbstractJobManagerService {
    @Resource
    private IndustrySettleSplitService industrySettleSplitService;

    public IndustrySettleSplitReturnJobTask(SimpleJobTaskService simpleJobTaskService) {
        super(simpleJobTaskService);
        initRunJobTasks();
    }

    @Override
    protected String getJobId() {
        return JobTaskId.SETTLESPLIT_RETURN_JOBID_EB.getId();
    }

    @Override
    protected String getJobName() {
        return JobTaskId.SETTLESPLIT_RETURN_JOBID_EB.getName();
    }

    @Override
    protected int getSchedulerRunTaskPeriod() {
        return 50;
    }

    @Override
    protected int defaultMaxRetryTimes() {
        return 20;
    }

    @Override
    protected int maxTaskRunCount() {
        return 50;
    }


    @Override
    protected void assignJobTasksExecute() {
    }

    @Override
    protected boolean jobTaskExecute(JobTask jobTask) throws Exception {
        Map map = Splitter.on("--").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split(jobTask.getTaskArgs());
        SettleSplitReturnTaskBO options = new JSONObject(map).toJavaObject(SettleSplitReturnTaskBO.class);
        try {
            industrySettleSplitService.returnSplitInfoResult(options.getProviderCode(), options.getSettleDate(), options.getBatchId());
        } catch (Exception e) {
            log.error("客户号:{}-清算日期:{}-批次号:{}的清算分账结果回盘回调通知异常", options.getProviderCode(), options.getSettleDate(), options.getBatchId(), e);
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
        return true;
    }


}
