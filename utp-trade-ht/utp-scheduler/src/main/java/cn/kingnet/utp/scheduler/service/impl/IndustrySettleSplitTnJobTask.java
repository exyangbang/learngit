package cn.kingnet.utp.scheduler.service.impl;

import cn.kingnet.utp.scheduler.data.bo.SettleSplitProcessTNTaskBO;
import cn.kingnet.utp.scheduler.data.entity.JobTask;
import cn.kingnet.utp.scheduler.enums.JobTaskStatus;
import cn.kingnet.utp.scheduler.job.SimpleJobTaskService;
import cn.kingnet.utp.scheduler.service.AbstractJobManagerService;
import cn.kingnet.utp.scheduler.service.IndustrySettleSplitService;
import cn.kingnet.utp.scheduler.utils.StringUtils;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.JobTaskId;
import cn.kingnet.utp.trade.common.exception.SchedulerException;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

/**
 * 处理 T+n 清算分账数据
 * 处理逻辑：
 * 1.提取T+n 已落库的未清算分账的数据
 * 2.商户/个人信息不存在则先相应信息若库，同时开通相应的商户虚账户\个人虚账户
 * 3.清算分账打款入相应的虚账户业务处理
 */
@Service
@Slf4j
public class IndustrySettleSplitTnJobTask extends AbstractJobManagerService {
    @Resource
    private IndustrySettleSplitService industrySettleSplitService;

    public IndustrySettleSplitTnJobTask(SimpleJobTaskService simpleJobTaskService) {
        super(simpleJobTaskService);
        initScheduled();
    }

    @Override
    protected int getSchedulerRunTaskPeriod() {
        return 40;
    }
    @Override
    protected int defaultMaxRetryTimes() {
        return 10;
    }

    @Override
    protected int maxTaskRunCount() {
        return 30;
    }

    @Override
    protected String getJobId() {
        return JobTaskId.SETTLESPLIT_PROCESS_JOBID_TN.getId();
    }

    @Override
    protected String getJobName() {
        return JobTaskId.SETTLESPLIT_PROCESS_JOBID_TN.getName();
    }

    private String getTaskId(String splitDate) {
        return String.format("%s-%s-TN", JobTaskId.SETTLESPLIT_TASKID.getId(), splitDate);
    }

    @Override
    protected void assignJobTasksExecute() {
        // T+n结算，再T+n那天0凌晨执行
        String splitDate = getCertainDate(0);
        final String taskId = getTaskId(splitDate);
        final String settleSplitProcessTNArgs = new StringBuffer().append("   --splitDate=" + splitDate).append("\n").toString();
        //FIXME 待优化 按客户号+日期 创建Tn处理任务
        createJobTask(splitDate, getJobId(), taskId, getJobName(), settleSplitProcessTNArgs, JobTaskStatus.WAITING);

    }

    @Override
    protected boolean jobTaskExecute(JobTask jobTask) throws Exception {

        Map map = Splitter.on("--").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split(jobTask.getTaskArgs());
        SettleSplitProcessTNTaskBO options = new JSONObject(map).toJavaObject(SettleSplitProcessTNTaskBO.class);
        try {
            industrySettleSplitService.processSplitInfo4TN(options.getSplitDate());
        } catch (Exception e) {
            log.error("清分记录Tn日期[{}]的分账任务处理异常", options.getSplitDate(), e);
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, e.getMessage(), e);
        }
        return true;

    }

    @Override
    protected void callDependentJobTask(JobTask jobTask) {

    }

    @Override
    protected boolean checkYesterdayJobTaskUnSuccess(JobTask jobTask) throws Exception {
        String jobDateStr = jobTask.getJobDate();
        String yesterdayJobDate = StringUtils.minusDate(jobDateStr, DateTimeFormatter.BASIC_ISO_DATE, 1);
        String yesterdayTaskId = getTaskId(yesterdayJobDate);
        return getSimpleJobTaskService().existsJobTaskNoSuccess(jobTask.getJobId(), yesterdayTaskId);
    }

    protected void createJobTask(String splitDate, String jobId, String taskId, String jobName, String traskArgs, JobTaskStatus jobTaskStatus) {
        JobTask.JobTaskBuilder jobTask = JobTask.builder();
        jobTask.jobDate(splitDate)
                .jobId(jobId)
                .jobtaskState(jobTaskStatus.name())
                .taskId(taskId)
                .jobPriority(1)
                .gmtCreate(new Date())
                .gmtModified(new Date())
                .jobName(jobName)
                .retryTimes(0)
                .id(IdGenerate.getId())
                .taskArgs(traskArgs);
        ;
        getSimpleJobTaskService().saveJobTask(jobTask.build());
    }
}
