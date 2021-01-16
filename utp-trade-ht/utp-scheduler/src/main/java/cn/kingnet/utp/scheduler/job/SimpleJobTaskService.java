package cn.kingnet.utp.scheduler.job;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.JobTask;
import cn.kingnet.utp.scheduler.data.entity.JobTaskCondition;
import cn.kingnet.utp.scheduler.enums.JobTaskStatus;
import cn.kingnet.utp.scheduler.utils.StringUtils;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SimpleJobTaskService {


    /**
     * 判断是否存在非成功的任务[ 空数据或者成功状态 视为成功任务]
     */
    public boolean existsJobTaskNoSuccess(String jobId, String taskId) {
        JobTask jobTask = MybatisDaoImpl.run().selectOne(JobTaskCondition.builder().andJobIdEq(jobId).andTaskIdEq(taskId).build());
        if (jobTask == null || JobTaskStatus.SUCCESS.name().equals(jobTask.getJobtaskState())) {
            return false;
        }
        return true;
    }

    /**
     * 获取等待运行的任务
     *
     * @param jobId
     * @return List<JobTask>
     */
    public List<JobTask> findJobTaskByWaiting(String jobId,int limit) {
        if(limit<=0){limit = 100;}
        return MybatisDaoImpl.run().selectList(JobTaskCondition.builder().andJobIdEq(jobId).andJobtaskStateEq(JobTaskStatus.WAITING.name()).build().last(" limit "+limit));
    }

    /**
     * 更新失败任务为等待状态
     *
     * @param jobId
     * @param retryTimes 尝试次数
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateRerun(String jobId, int retryTimes) {
        String updateSql = String.format("jobtask_state = '%s',catch_exception = null ", JobTaskStatus.WAITING.name());
        MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder().andJobtaskStateIn(JobTaskStatus.KILLED.name(), JobTaskStatus.FAILED.name())
                .andJobIdEq(jobId).andRetryTimesLe(retryTimes).andNextRerunTimeLe(StringUtils.formatTime(new Date())).build());
    }

    /**
     * 初始化任务
     *
     * @param jobTask
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveJobTask(JobTask jobTask) {
        int count = MybatisDaoImpl.run().selectCount(JobTaskCondition.builder().andTaskIdEq(jobTask.getTaskId()).andJobIdEq(jobTask.getJobId()).build());
        if (count > 0) {
            return;
        }
        MybatisDaoImpl.run().insert(jobTask);
    }

    /**
     * 更新任务为运行中
     *
     * @param jobId
     * @param taskId
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateRunning(String jobId, String taskId) {
        String updateSql = String.format("jobtask_state = '%s',last_run_starttime = '%s',retry_times = retry_times+1,catch_exception = null ",
                JobTaskStatus.RUNNING.name(), StringUtils.formatTime(new Date()));
        MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder().andJobtaskStateEq(JobTaskStatus.WAITING.name())
                .andJobIdEq(jobId).andTaskIdEq(taskId).andNextRerunTimeLe(StringUtils.formatTime(new Date())).build());
    }

    /**
     * 更新任务为成功
     *
     * @param jobId
     * @param taskId
     * @return void
     * @author XiaoBin.Zeng
     * @createAt 2017年11月07日
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateSuccess(String jobId, String taskId) {
        String updateSql = String.format("jobtask_state = '%s',last_run_endtime = '%s',catch_exception = null ", JobTaskStatus.SUCCESS.name(), StringUtils.formatTime(new Date()));
        MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder().andJobIdEq(jobId).andTaskIdEq(taskId).build());
    }

    /**
     * 更新任务为失败
     *
     * @param jobId
     * @param taskId
     * @param catchException
     * @param nextRerunTime
     * @return void
     * @author XiaoBin.Zeng
     * @createAt 2017年11月06日
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateFailed(String jobId, String taskId, String catchException, String nextRerunTime) {
        catchException = StringUtil.truncate(catchException, 200);
        String updateSql = String.format("jobtask_state = '%s',last_run_endtime = '%s',next_rerun_time = '%s',catch_exception = '%s'",
                JobTaskStatus.FAILED.name(), StringUtils.formatTime(new Date()), nextRerunTime, catchException == null ? "" : catchException.replaceAll("'", ""));
        MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder().andJobIdEq(jobId).andTaskIdEq(taskId).build());
    }

    /**
     * 更新任务状态为等待状态(回调依赖任务)
     *
     * @param jobId
     * @param taskId
     * @return void
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateWaittingByDependent(String jobId, String taskId) {
        String updateSql = String.format("jobtask_state = '%s',catch_exception = null ", JobTaskStatus.WAITING.name());
        MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder().andJobIdEq(jobId).andTaskIdEq(taskId).and().andJobtaskStateNe(JobTaskStatus.RUNNING.name()).orJobtaskStateIsNull().build()
        );
    }

    /**
     * 更新任务备注
     *
     * @param jobId
     * @param taskId
     * @param description
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateDescription(String jobId, String taskId, String description) {
        String updateSql = String.format("description = '%s'", description);
        MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder()
                .andJobIdEq(jobId).andTaskIdEq(taskId).build()
        );
    }


}
