package cn.kingnet.utp.scheduler.service.impl;

import cn.kingnet.utp.scheduler.data.bo.AccountEleReceiptTaskBO;
import cn.kingnet.utp.scheduler.data.entity.JobTask;
import cn.kingnet.utp.scheduler.job.SimpleJobTaskService;
import cn.kingnet.utp.scheduler.service.AbstractJobManagerService;
import cn.kingnet.utp.scheduler.service.AccountEleReceiptService;
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
 * @Description : 开户电子回单PDF
 * @Author : linkaigui
 * @Create : 2020/3/16 15:11
 */
@Service
@Slf4j
public class AccountEleReceiptJobTask extends AbstractJobManagerService {

    @Resource
    private AccountEleReceiptService accountEleReceiptService;

    public AccountEleReceiptJobTask(SimpleJobTaskService simpleJobTaskService) {
        super(simpleJobTaskService);
        initRunJobTasks();
    }

    @Override
    protected int corePoolSize() {
        return 1;
    }

    @Override
    protected String getJobId() {
        return JobTaskId.ACCOUNT_ELE_RECEIPT_PDF_PROCESS_JOBID.getId();
    }

    @Override
    protected String getJobName() {
        return JobTaskId.ACCOUNT_ELE_RECEIPT_PDF_PROCESS_JOBID.getName();
    }

    @Override
    protected void assignJobTasksExecute() {
    }

    @Override
    protected boolean jobTaskExecute(JobTask jobTask) throws Exception {
        Map map = Splitter.on("--").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split(jobTask.getTaskArgs());
        AccountEleReceiptTaskBO options = new JSONObject(map).toJavaObject(AccountEleReceiptTaskBO.class);
        try {
            accountEleReceiptService.eleReceipt(options);
        } catch (Exception e) {
            log.error("开户电子回单PDF:账户:{}处理异常", options.getAccount(), e);
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, e.getMessage(), e);
        }
        return true;
    }
}
