drop table if exists t_job_task;
create table t_job_task (
	id  bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID'
        ,user_create varchar(250)  COMMENT '创建用户'
        ,gmt_create datetime  COMMENT '创建时间'
        ,user_modified varchar(250)  COMMENT '修改用户'
        ,gmt_modified datetime  COMMENT '修改时间'
        ,job_id varchar(100)  COMMENT '作业ID'
        ,job_name varchar(100)  COMMENT '任务名称'
        ,job_date varchar(100)  COMMENT '任务日期'
        ,job_priority int(11)  COMMENT '任务优先级'
        ,jobtask_state varchar(100)  COMMENT '作业任务状态'
        ,last_run_starttime varchar(100)  COMMENT '上次运行开始时间'
        ,last_run_endtime varchar(100)  COMMENT '上次运行结束时间'
        ,next_rerun_time varchar(100)  COMMENT '下次运行时间'
        ,retry_times int(10)  COMMENT '重试次数'
        ,task_args varchar(1024)  COMMENT '任务参数'
        ,task_id varchar(200)  COMMENT '任务Id'
        ,catch_exception varchar(2048)  COMMENT '异常信息'
        ,description varchar(100)  COMMENT '描述'
) COMMENT '作业任务管理';

create  index t_job_task_index_1 on t_job_task(job_id);
create  index t_job_task_index_2 on t_job_task(job_name);
create  index t_job_task_index_3 on t_job_task(job_date);
