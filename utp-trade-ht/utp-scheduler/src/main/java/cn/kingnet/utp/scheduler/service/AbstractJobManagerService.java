package cn.kingnet.utp.scheduler.service;

import cn.kingnet.utp.scheduler.data.entity.JobTask;
import cn.kingnet.utp.scheduler.enums.JobTaskStatus;
import cn.kingnet.utp.scheduler.job.SimpleJobTaskService;
import cn.kingnet.utp.scheduler.utils.StringUtils;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于t_job_task表的 调度任务抽象类
 * 子类可重写核心线程数、调度间隔时间、最大任务数等来调整
 */
public abstract class AbstractJobManagerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AtomicBoolean schedulerAssignTaskRunning = new AtomicBoolean();
    private final AtomicBoolean schedulerTaskRunning = new AtomicBoolean();
    private final AtomicInteger executorTaskRunCount = new AtomicInteger(0);
    private final SimpleJobTaskService simpleJobTaskService;
    private final ExecutorService executorTaskRunService;
    private final ScheduledExecutorService scheduledExecutorService;


    protected SimpleJobTaskService getSimpleJobTaskService() {
        return simpleJobTaskService;
    }

    public AbstractJobManagerService(SimpleJobTaskService simpleJobTaskService) {
        this.simpleJobTaskService = simpleJobTaskService;
        scheduledExecutorService = new ScheduledThreadPoolExecutor(2,new ThreadFactoryBuilder().setNameFormat("scheduler-"+nameFormat()).build());
        executorTaskRunService = new ThreadPoolExecutor(corePoolSize(),80,0,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(100),new ThreadFactoryBuilder().setNameFormat(nameFormat()).build());
    }

    /**
     * 设置线程池大小
     */
    protected int corePoolSize() {
        return 4;
    }

    /**
     * 设置任务组线程名称
     */
    protected String nameFormat() {
        return String.format("%s-pool-%s", getJobId(), "%02d");
    }


    /**
     * 设置任务组jobId
     */
    protected abstract String getJobId();

    /**
     * 设置任务组作业名称
     */
    protected abstract String getJobName();

    /**
     * 是否支持执行重跑
     *
     * @return boolean
     */
    protected boolean isRerun() {
        return true;
    }

    /**
     * 默认失败最大重试次数
     * @return
     */
    protected int defaultMaxRetryTimes() {
        return 20;
    }

    /**
     * 获取作业时间：默认执行日期前一天：yyyyMMdd
     */
    protected String getJobDate() {
        return getCertainDate(-1);
    }

    /**
     * 定时调度 生成task任务 是否正在执行
     */
    protected AtomicBoolean getSchedulerAssignTaskRunning() {
        return schedulerAssignTaskRunning;
    }
    /**
     * 定时调度 执行task任务 是否正在执行
     */
    protected AtomicBoolean getSchedulerTaskRunning() {
        return schedulerTaskRunning;
    }
    /**
     *  当前正在执行任务数量
     */
    protected AtomicInteger getExecutorTaskRunCount() {
        return executorTaskRunCount;
    }

    /**
     * 默认最大并发任务数
     * @return
     */
    protected int maxTaskRunCount() {
        return 80;
    }

    protected int getSchedulerAssignTaskPeriod() {
        return 60;
    }

    protected int getSchedulerRunTaskPeriod() {
        return 60;
    }

    /**
     * 下次重跑时间 yyyyMMddHHmmss
     */
    protected String getNextReRunTime() {
        return getMinuteDate(30);
    }

    protected void initScheduled() {
        this.initAssignJobTasks();
        this.initRunJobTasks();
    }

    protected ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    protected ExecutorService getExecutorTaskRunService() {
        return executorTaskRunService;
    }

    /**
     * 定时调度 创建运行任务
     */
    protected void initAssignJobTasks() {
        getScheduledExecutorService().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (getSchedulerAssignTaskRunning().compareAndSet(false, true)) {
                    try {
                        assignJobTasksExecute();
                    } catch (Exception e) {
                        logger.error("初始化任务运行失败" + e.getMessage(), e);
                    } finally {
                        getSchedulerAssignTaskRunning().compareAndSet(true, false);
                    }
                }
            }
        }, 30, getSchedulerAssignTaskPeriod(), TimeUnit.SECONDS);
    }

    /**
     * 创建具体运行任务
     */
    protected abstract void assignJobTasksExecute();

    /**
     * 定时调度：运行任务
     */
    protected void initRunJobTasks() {
        getScheduledExecutorService().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (getSchedulerTaskRunning().compareAndSet(false, true)) {
                    try {
                        if (isRerun()) {
                            rerunJobTasksRun();
                        }
                        runJobTask();
                    } catch (Exception e) {
                        logger.error("任务运行失败", e);
                    } finally {
                        getSchedulerTaskRunning().compareAndSet(true, false);
                    }
                }
            }
        }, 45, getSchedulerRunTaskPeriod(), TimeUnit.SECONDS);
    }

    /**
     * 运行具体任务
     */
    protected void runJobTask() {
        List<JobTask> jobTasks = this.simpleJobTaskService.findJobTaskByWaiting(this.getJobId(),maxTaskRunCount());
        logger.info("开始执行{}任务 任务数:{}", this.getJobName(), jobTasks.size());
        for (JobTask jobTask : jobTasks) {
            logger.info("jobId {}, taskId {}", jobTask.getJobId(), jobTask.getTaskId());
            if (getExecutorTaskRunCount().get() >= maxTaskRunCount()) {
                break;
            }
            // 判断前一天的任务是否完成
            try {
                if (checkYesterdayJobTaskUnSuccess(jobTask)) {
                    continue;
                }
            } catch (Exception e) {
                logger.error("任务运行失败", e);
                String exceptionMessage = new String(StringUtils.getData(e));
                exceptionMessage = exceptionMessage == null ? "" : StringUtil.truncate(exceptionMessage, 500).replaceAll("'", "");
                simpleJobTaskService.updateFailed(jobTask.getJobId(), jobTask.getTaskId(), exceptionMessage, getNextReRunTime());
                continue;
            }
            getExecutorTaskRunCount().incrementAndGet();
            getExecutorTaskRunService().execute(new Runnable() {
                @Override
                public void run() {
                    AtomicBoolean success = new AtomicBoolean(true);
                    try {
                        // 1.更新作业为运行中
                        simpleJobTaskService.updateRunning(jobTask.getJobId(), jobTask.getTaskId());
                        boolean executeSuccess = jobTaskExecute(jobTask);
                        if (!executeSuccess) {
                            success.compareAndSet(true, false);
                            simpleJobTaskService.updateFailed(jobTask.getJobId(), jobTask.getTaskId(), "任务运行失败", getNextReRunTime());
                        }
                    } catch (Exception e) {
                        logger.error("任务运行失败", e);
                        success.compareAndSet(true, false);
                        String exceptionMessage = new String(StringUtils.getData(e));
                        exceptionMessage = exceptionMessage == null ? "" : StringUtil.truncate(exceptionMessage, 500).replaceAll("'", "");
                        simpleJobTaskService.updateFailed(jobTask.getJobId(), jobTask.getTaskId(), exceptionMessage, getNextReRunTime());
                    } finally {
                        getExecutorTaskRunCount().decrementAndGet();
                        if (success.get()) {
                            // 更新作业为成功
                            simpleJobTaskService.updateSuccess(jobTask.getJobId(), jobTask.getTaskId());
                            // 回调函数
                            callDependentJobTask(jobTask);
                        }
                    }
                }
            });
        }
    }

    /**
     * 创建任务
     *
     * @param taskId
     * @param traskArgs
     * @return void
     */
    protected void createJobTask(String taskId, String traskArgs, JobTaskStatus jobTaskStatus) {
        JobTask.JobTaskBuilder jobTask = JobTask.builder();
        jobTask.jobDate(getJobDate())
                .jobId(getJobId())
                .jobtaskState(jobTaskStatus.name())
                .taskId(taskId)
                .jobPriority(1)
                .gmtCreate(new Date())
                .gmtModified(new Date())
                .jobName(this.getJobName())
                .retryTimes(0)
                .id(IdGenerate.getId())
                .taskArgs(traskArgs);
        simpleJobTaskService.saveJobTask(jobTask.build());

    }


    /**
     * 更新失败作业重跑
     */
    protected void rerunJobTasksRun() {
        simpleJobTaskService.updateRerun(this.getJobId(), defaultMaxRetryTimes());
    }

    /**
     * 运行具体任务
     *
     * @return void
     */
    protected abstract boolean jobTaskExecute(JobTask jobTask) throws Exception;

    /**
     * 判断昨天的任务是否成功
     *
     * @param jobTask
     * @return boolean
     */
    protected boolean checkYesterdayJobTaskUnSuccess(JobTask jobTask) throws Exception {
        return false;
    }

    /**
     * 运行回调函数
     *
     * @return void
     */
    protected void callDependentJobTask(JobTask jobTask) {
    }

    @PreDestroy
    public void destroy() {
        getScheduledExecutorService().shutdown();
    }

    /**
     * 得到与当前日期相差指定天数的日期字符串.
     *
     * @param days 前后的天数，正值为后， 负值为前
     * @return
     */
    protected String getCertainDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        return StringUtils.formatDate(calendar.getTime());
    }

    protected String getMinuteDate(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return StringUtils.formatTime(calendar.getTime());
    }


}
