package com.scenetec.upf.operation.model.domain.job;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author scenetec
 * @date 2018/10/22
 */
@ApiModel(description = "作业任务管理")
@Data
public class JobTaskDO {

    @JsonSerialize(using= ToStringSerializer.class)
    @ApiModelProperty(value = "主键ID")
    private Long id;
    

    /**
     * 创建用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "创建用户")
    @JsonIgnore
	private String userCreate;

    /**
     * 创建时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
	private Date gmtCreate;

    /**
     * 修改用户
     * mysqlType: varchar(250)
     */
    @ApiModelProperty(value = "修改用户")
    @JsonIgnore
	private String userModified;

    /**
     * 修改时间
     * mysqlType: datetime
     */
    @ApiModelProperty(value = "修改时间")
    @JsonIgnore
	private Date gmtModified;

    /**
     * 作业ID
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "作业ID")
	private String jobId;

    /**
     * 任务名称
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "任务名称")
	private String jobName;

    /**
     * 任务日期
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "任务日期")
	private String jobDate;

    /**
     * 任务优先级
     * mysqlType: int(11)
     */
    @ApiModelProperty(value = "任务优先级")
	private Integer jobPriority;

    /**
     * 作业任务状态
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "作业任务状态")
	private String jobtaskState;

    /**
     * 上次运行开始时间
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "上次运行开始时间")
	private String lastRunStarttime;

    /**
     * 上次运行结束时间
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "上次运行结束时间")
	private String lastRunEndtime;

    /**
     * 下次运行时间
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "下次运行时间")
	private String nextRerunTime;

    /**
     * 重试次数
     * mysqlType: int(10)
     */
    @ApiModelProperty(value = "重试次数")
	private Integer retryTimes;

    /**
     * 任务参数
     * mysqlType: varchar(1024)
     */
    @ApiModelProperty(value = "任务参数")
	private String taskArgs;

    /**
     * 任务Id
     * mysqlType: varchar(200)
     */
    @ApiModelProperty(value = "任务Id")
	private String taskId;

    /**
     * 异常信息
     * mysqlType: varchar(2048)
     */
    @ApiModelProperty(value = "异常信息")
	private String catchException;

    /**
     * 描述
     * mysqlType: varchar(100)
     */
    @ApiModelProperty(value = "描述")
	private String description;

    @Override
	public String toString() {
		return "JobTaskDO:"
              + "id = ["+ id + "]"
              + ", userCreate = [" + userCreate +"]"
              + ", gmtCreate = [" + gmtCreate +"]"
              + ", userModified = [" + userModified +"]"
              + ", gmtModified = [" + gmtModified +"]"
              + ", jobId = [" + jobId +"]"
              + ", jobName = [" + jobName +"]"
              + ", jobDate = [" + jobDate +"]"
              + ", jobPriority = [" + jobPriority +"]"
              + ", jobtaskState = [" + jobtaskState +"]"
              + ", lastRunStarttime = [" + lastRunStarttime +"]"
              + ", lastRunEndtime = [" + lastRunEndtime +"]"
              + ", nextRerunTime = [" + nextRerunTime +"]"
              + ", retryTimes = [" + retryTimes +"]"
              + ", taskArgs = [" + taskArgs +"]"
              + ", taskId = [" + taskId +"]"
              + ", catchException = [" + catchException +"]"
              + ", description = [" + description +"]"
              ;
	}
	
}