package cn.kingnet.utp.scheduler.service.impl;

import cn.kingnet.utp.scheduler.data.bo.SettleSplitProcessT0TaskBO;
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
 * 处理 下游电商平台(EB) 平台清算分账文件
 * 处理逻辑：
 * 1.提取已落库的未清算分账的数据
 * 2.商户/个人信息不存在则先相应信息若库，同时开通相应的商户虚账户\个人虚账户
 * 3.清算分账打款入相应的虚账户业务处理
 * 4.针对分账账期为0的，则系统还得发起自动提现操作
 * <p>
 * @author Administrator
 */
@Service
@Slf4j
public class IndustrySettleSplitT0JobTask extends AbstractJobManagerService {

    @Resource
    private IndustrySettleSplitService industrySettleSplitService;

    public IndustrySettleSplitT0JobTask(SimpleJobTaskService simpleJobTaskService) {
        super(simpleJobTaskService);
        initRunJobTasks();
    }

    @Override
    protected int getSchedulerRunTaskPeriod() {
        return 30;
    }

    @Override
    protected int defaultMaxRetryTimes() {
        return 10;
    }

    @Override
    protected int maxTaskRunCount() {
        return 100;
    }

    @Override
    protected String getJobId() {
        return JobTaskId.SETTLESPLIT_PROCESS_JOBID_EB.getId();
    }

    @Override
    protected String getJobName() {
        return JobTaskId.SETTLESPLIT_PROCESS_JOBID_EB.getName();
    }

    @Override
    protected void assignJobTasksExecute() {
    }

    @Override
    protected boolean jobTaskExecute(JobTask jobTask) throws Exception {
        Map map = Splitter.on("--").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split(jobTask.getTaskArgs());
        SettleSplitProcessT0TaskBO options = new JSONObject(map).toJavaObject(SettleSplitProcessT0TaskBO.class);
        try {
            industrySettleSplitService.processSplitInfo4T0(options.getProviderCode(), options.getSettleDate(), options.getBatchId());
        } catch (Exception e) {
            log.error("代付客户号:{}-清算日期:{}-批次号:{}的清算分账任务处理异常", options.getProviderCode(), options.getSettleDate(), options.getBatchId(), e);
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, e.getMessage(), e);
        }
        return true;
    }

    @Override
    protected void callDependentJobTask(JobTask jobTask) {
        getSimpleJobTaskService().updateWaittingByDependent(JobTaskId.SETTLESPLIT_RETURN_JOBID_EB.getId(), jobTask.getTaskId());
    }



}
