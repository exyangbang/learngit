package cn.kingnet.utp.service.persistence.entity;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.base.sql.MapperInterface;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_job_task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@MapperInterface("cn.kingnet.utp.service.persistence.mapper.JobTaskMapper")
public class JobTask extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 创建用户
     */
    @TableField(value = "user_create")
    private String userCreate;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改用户
     */
    @TableField(value = "user_modified")
    private String userModified;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 异常
     */
    @TableField(value = "catch_exception")
    private String catchException;

    /**
     * 备注
     */
    @TableField(value = "description")
    private String description;

    /**
     * 作业日期yyyyMMdd
     */
    @TableField(value = "job_date")
    private String jobDate;

    /**
     * 作业id
     */
    @TableField(value = "job_id")
    private String jobId;

    /**
     * 作业名称
     */
    @TableField(value = "job_name")
    private String jobName;

    /**
     * 作业优先级
     */
    @TableField(value = "job_priority")
    private Integer jobPriority;

    /**
     * 作务状态
     */
    @TableField(value = "jobtask_state")
    private String jobtaskState;

    /**
     * 最后运行结束时间
     */
    @TableField(value = "last_run_endtime")
    private String lastRunEndtime;

    /**
     * 最后运行开始时间
     */
    @TableField(value = "last_run_starttime")
    private String lastRunStarttime;

    /**
     * 失败下次重试时间
     */
    @TableField(value = "next_rerun_time")
    private String nextRerunTime;

    /**
     * 重试运行次数
     */
    @TableField(value = "retry_times")
    private Integer retryTimes;

    /**
     * 作业参数
     */
    @TableField(value = "task_args")
    private String taskArgs;

    /**
     * 任务id
     */
    @TableField(value = "task_id")
    private String taskId;
}