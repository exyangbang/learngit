package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.JobTask;
import cn.kingnet.utp.service.persistence.entity.JobTaskCondition;
import cn.kingnet.utp.trade.common.enums.JobTaskId;
import cn.kingnet.utp.trade.common.enums.JobTaskStatus;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月12日
 */
@Service
@Slf4j
public class JobTaskService {


    /**
     * 实时 创建清算分账文件处理任务
     *
     * @param industryCode
     * @param settleDate
     * @param batchId
     */
    @Transactional(rollbackFor = Exception.class)
    public void createJobTask4SplitInfo(String industryCode, String settleDate, String batchId) {
        if (StringUtil.isEmpty(industryCode) || StringUtil.isEmpty(settleDate) || StringUtil.isEmpty(batchId)) {
            return;
        }
        final String taskId = JobTaskId.SETTLESPLIT_TASKID.getTaskId(industryCode,settleDate,batchId);
        final String taskArgs = new StringBuffer()
                .append("   --providerCode=" + industryCode).append("\n")
                .append("   --settleDate=" + settleDate).append("\n")
                .append("   --batchId=" + batchId).append("\n").toString();

        //1.电商平台创建清算分账数据处理任务 ||入虚账及明细，更新商户账户表信息
        createJobTask(taskId, JobTaskId.SETTLESPLIT_PROCESS_JOBID_EB, JobTaskStatus.WAITING, taskArgs);
        //2.创建清算分账回盘文件任务 || 查询数据处理结果并生成回盘文件及推送
        createJobTask(taskId, JobTaskId.SETTLESPLIT_RETURN_JOBID_EB, JobTaskStatus.PREP, taskArgs);
    }

    public String getTaskId4AcctReceipt(String account) {
        return String.format("%s-%s", JobTaskId.ACCOUNT_ELE_RECEIPT_PDF_TASKID.getId(), account);
    }

    /**
     * 创建生成开户电子回单处理任务
     * @param account 虚拟账户
     * @param nature 账户性质
     */
    @Transactional(rollbackFor = Exception.class)
    public void createJobTask4AcctReceipt(String account, String nature){
        if (StringUtil.isEmpty(account)) {
            return;
        }
        final String taskId = getTaskId4AcctReceipt(account);
        final String taskArgs = new StringBuffer()
                .append("   --account=" + account).append("\n")
                .append(StringUtil.isNotBlank(nature) ? "   --nature=" + nature : "").append("\n").toString();
        //1.创建生成开户电子回单处理任务
        createJobTask(taskId, JobTaskId.ACCOUNT_ELE_RECEIPT_PDF_PROCESS_JOBID, JobTaskStatus.WAITING, taskArgs);
    }

    /**
     * 创建任务
     *
     * @param taskId
     * @param jobTaskId
     * @param jobTaskStatus
     * @param taskArgs
     */
    @Transactional(rollbackFor = Exception.class)
    public void createJobTask(String taskId, JobTaskId jobTaskId, JobTaskStatus jobTaskStatus, String taskArgs) {
        JobTask jobTask = JobTask.builder().jobDate(DateUtil.getCurrentDate())
                .jobId(jobTaskId.getId())
                .jobtaskState(jobTaskStatus.name())
                .taskId(taskId)
                .jobPriority(1)
                .gmtCreate(new Date())
                .gmtModified(new Date())
                .jobName(jobTaskId.getName())
                .retryTimes(0)
                .id(IdGenerate.getId())
                .taskArgs(taskArgs).build();
        int count = MybatisDaoImpl.run().selectCount(JobTaskCondition.builder()
                .andTaskIdEq(jobTask.getTaskId()).andJobIdEq(jobTask.getJobId()).build());
        if (count > 0) {
            return;
        }
        MybatisDaoImpl.run().insert(jobTask);
    }

}
