package com.scenetec.upf.operation.repository.job;

import com.scenetec.upf.operation.model.domain.job.JobTaskDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/10/22
 */
@Repository
@Mapper
public interface JobTaskMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_job_task (id,user_create,gmt_create,user_modified,gmt_modified,job_id,job_name,job_date,job_priority,jobtask_state,last_run_starttime,last_run_endtime,next_rerun_time,retry_times,task_args,task_id,catch_exception,description) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{jobId},#{jobName},#{jobDate},#{jobPriority},#{jobtaskState},#{lastRunStarttime},#{lastRunEndtime},#{nextRerunTime},#{retryTimes},#{taskArgs},#{taskId},#{catchException},#{description})")
 	long create(JobTaskDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_job_task ("
        +" user_create, gmt_create, user_modified, gmt_modified, job_id, job_name, job_date, job_priority, jobtask_state, last_run_starttime, last_run_endtime, next_rerun_time, retry_times, task_args, task_id, catch_exception, description"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.jobId}, #{item.jobName}, #{item.jobDate}, #{item.jobPriority}, #{item.jobtaskState}, #{item.lastRunStarttime}, #{item.lastRunEndtime}, #{item.nextRerunTime}, #{item.retryTimes}, #{item.taskArgs}, #{item.taskId}, #{item.catchException}, #{item.description})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<JobTaskDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_job_task ("
        +" user_create, gmt_create, user_modified, gmt_modified, job_id, job_name, job_date, job_priority, jobtask_state, last_run_starttime, last_run_endtime, next_rerun_time, retry_times, task_args, task_id, catch_exception, description"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.jobId}, #{item.jobName}, #{item.jobDate}, #{item.jobPriority}, #{item.jobtaskState}, #{item.lastRunStarttime}, #{item.lastRunEndtime}, #{item.nextRerunTime}, #{item.retryTimes}, #{item.taskArgs}, #{item.taskId}, #{item.catchException}, #{item.description})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"job_id = VALUES(job_id),"
            +"job_name = VALUES(job_name),"
            +"job_date = VALUES(job_date),"
            +"job_priority = VALUES(job_priority),"
            +"jobtask_state = VALUES(jobtask_state),"
            +"last_run_starttime = VALUES(last_run_starttime),"
            +"last_run_endtime = VALUES(last_run_endtime),"
            +"next_rerun_time = VALUES(next_rerun_time),"
            +"retry_times = VALUES(retry_times),"
            +"task_args = VALUES(task_args),"
            +"task_id = VALUES(task_id),"
            +"catch_exception = VALUES(catch_exception),"
            +"description = VALUES(description)"
        +"</script>"
    )
    int modifyList(List<JobTaskDO> obj);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from t_job_task where id = #{id}")
    int delete(Long id);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @Delete("update t_job_task set status=0 where id = #{id}")
    int deleteLogic(Long id);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_job_task <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='jobId != null'> job_id = #{jobId}, </if> "
            +"<if test='jobName != null'> job_name = #{jobName}, </if> "
            +"<if test='jobDate != null'> job_date = #{jobDate}, </if> "
            +"<if test='jobPriority != null'> job_priority = #{jobPriority}, </if> "
            +"<if test='jobtaskState != null'> jobtask_state = #{jobtaskState}, </if> "
            +"<if test='lastRunStarttime != null'> last_run_starttime = #{lastRunStarttime}, </if> "
            +"<if test='lastRunEndtime != null'> last_run_endtime = #{lastRunEndtime}, </if> "
            +"<if test='nextRerunTime != null'> next_rerun_time = #{nextRerunTime}, </if> "
            +"<if test='retryTimes != null'> retry_times = #{retryTimes}, </if> "
            +"<if test='taskArgs != null'> task_args = #{taskArgs}, </if> "
            +"<if test='taskId != null'> task_id = #{taskId}, </if> "
            +"<if test='catchException != null'> catch_exception = #{catchException}, </if> "
            +"<if test='description != null'> description = #{description}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(JobTaskDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,job_id,job_name,job_date,job_priority,jobtask_state,last_run_starttime,last_run_endtime,next_rerun_time,retry_times,task_args,task_id,catch_exception,description from t_job_task where id = #{id}")
 	@Results(id="JobTaskResultMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "userCreate", column = "user_create" )
        ,        @Result(property = "gmtCreate", column = "gmt_create" )
        ,        @Result(property = "userModified", column = "user_modified" )
        ,        @Result(property = "gmtModified", column = "gmt_modified" )
        ,        @Result(property = "jobId", column = "job_id" )
        ,        @Result(property = "jobName", column = "job_name" )
        ,        @Result(property = "jobDate", column = "job_date" )
        ,        @Result(property = "jobPriority", column = "job_priority" )
        ,        @Result(property = "jobtaskState", column = "jobtask_state" )
        ,        @Result(property = "lastRunStarttime", column = "last_run_starttime" )
        ,        @Result(property = "lastRunEndtime", column = "last_run_endtime" )
        ,        @Result(property = "nextRerunTime", column = "next_rerun_time" )
        ,        @Result(property = "retryTimes", column = "retry_times" )
        ,        @Result(property = "taskArgs", column = "task_args" )
        ,        @Result(property = "taskId", column = "task_id" )
        ,        @Result(property = "catchException", column = "catch_exception" )
        ,        @Result(property = "description", column = "description" )
        }
    )
 	JobTaskDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,job_id,job_name,job_date,job_priority,jobtask_state,last_run_starttime,last_run_endtime,next_rerun_time,retry_times,task_args,task_id,catch_exception,description from t_job_task where 1 = 1"
                + "<if test='params.jobtaskState != null'> and jobtask_state = #{params.jobtaskState}</if>"
                + "<if test='params.taskId != null'> and task_id like concat('%',#{params.taskId},'%')</if>"
		        + "<if test='params.jobId != null'> and job_id like concat('%',#{params.jobId},'%')</if>"
		        + "<if test='params.jobName != null'> and job_name like concat('%',#{params.jobName},'%')</if>"
                + "<if test='params.jobDate != null'> and job_date = #{params.jobDate}</if>"
                + "<if test='params.lastRunStarttime != null'> and last_run_starttime &gt;= #{params.lastRunStarttime}</if>"
                + "<if test='params.lastRunEndtime != null'> and last_run_starttime &lt;= #{params.lastRunEndtime}</if>"
                 +"order by job_date desc"
        + "</script>"
    )
    @ResultMap("JobTaskResultMap")
    Page<JobTaskDO> pageList(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(不分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
            + "select id, user_create,gmt_create,user_modified,gmt_modified,job_id,job_name,job_date,job_priority,jobtask_state,last_run_starttime,last_run_endtime,next_rerun_time,retry_times,task_args,task_id,catch_exception,description from t_job_task where 1 = 1"
                + "<if test='params.jobtaskState != null'> and jobtask_state = #{params.jobtaskState}</if>"
                + "<if test='params.taskId != null'> and task_id like concat('%',#{params.taskId},'%')</if>"
                + "<if test='params.jobId != null'> and job_id like concat('%',#{params.jobId},'%')</if>"
                + "<if test='params.jobName != null'> and job_name like concat('%',#{params.jobName},'%')</if>"
                + "<if test='params.jobDate != null'> and job_date = #{params.jobDate}</if>"
                + "<if test='params.lastRunStarttime != null'> and last_run_starttime &gt;= #{params.lastRunStarttime}</if>"
                + "<if test='params.lastRunEndtime != null'> and last_run_starttime &lt;= #{params.lastRunEndtime}</if>"
        + "</script>"
    )
    @ResultMap("JobTaskResultMap")
    List<JobTaskDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_job_task <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='jobId != null'> job_id = #{jobId} AND </if> "
            +"<if test='jobName != null'> job_name = #{jobName} AND </if> "
            +"<if test='jobDate != null'> job_date = #{jobDate} AND </if> "
            +"<if test='jobPriority != null'> job_priority = #{jobPriority} AND </if> "
            +"<if test='jobtaskState != null'> jobtask_state = #{jobtaskState} AND </if> "
            +"<if test='lastRunStarttime != null'> last_run_starttime = #{lastRunStarttime} AND </if> "
            +"<if test='lastRunEndtime != null'> last_run_endtime = #{lastRunEndtime} AND </if> "
            +"<if test='nextRerunTime != null'> next_rerun_time = #{nextRerunTime} AND </if> "
            +"<if test='retryTimes != null'> retry_times = #{retryTimes} AND </if> "
            +"<if test='taskArgs != null'> task_args = #{taskArgs} AND </if> "
            +"<if test='taskId != null'> task_id = #{taskId} AND </if> "
            +"<if test='catchException != null'> catch_exception = #{catchException} AND </if> "
            +"<if test='description != null'> description = #{description} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(JobTaskDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,job_id,job_name,job_date,job_priority,jobtask_state,last_run_starttime,last_run_endtime,next_rerun_time,retry_times,task_args,task_id,catch_exception,description from t_job_task"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='jobId != null'> job_id = #{jobId} AND </if> "
            +"<if test='jobName != null'> job_name = #{jobName} AND </if> "
            +"<if test='jobDate != null'> job_date = #{jobDate} AND </if> "
            +"<if test='jobPriority != null'> job_priority = #{jobPriority} AND </if> "
            +"<if test='jobtaskState != null'> jobtask_state = #{jobtaskState} AND </if> "
            +"<if test='lastRunStarttime != null'> last_run_starttime = #{lastRunStarttime} AND </if> "
            +"<if test='lastRunEndtime != null'> last_run_endtime = #{lastRunEndtime} AND </if> "
            +"<if test='nextRerunTime != null'> next_rerun_time = #{nextRerunTime} AND </if> "
            +"<if test='retryTimes != null'> retry_times = #{retryTimes} AND </if> "
            +"<if test='taskArgs != null'> task_args = #{taskArgs} AND </if> "
            +"<if test='taskId != null'> task_id = #{taskId} AND </if> "
            +"<if test='catchException != null'> catch_exception = #{catchException} AND </if> "
            +"<if test='description != null'> description = #{description} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("JobTaskResultMap")
    JobTaskDO selectOne(JobTaskDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,job_id,job_name,job_date,job_priority,jobtask_state,last_run_starttime,last_run_endtime,next_rerun_time,retry_times,task_args,task_id,catch_exception,description from t_job_task"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='jobId != null'> job_id = #{jobId} AND </if> "
            +"<if test='jobName != null'> job_name = #{jobName} AND </if> "
            +"<if test='jobDate != null'> job_date = #{jobDate} AND </if> "
            +"<if test='jobPriority != null'> job_priority = #{jobPriority} AND </if> "
            +"<if test='jobtaskState != null'> jobtask_state = #{jobtaskState} AND </if> "
            +"<if test='lastRunStarttime != null'> last_run_starttime = #{lastRunStarttime} AND </if> "
            +"<if test='lastRunEndtime != null'> last_run_endtime = #{lastRunEndtime} AND </if> "
            +"<if test='nextRerunTime != null'> next_rerun_time = #{nextRerunTime} AND </if> "
            +"<if test='retryTimes != null'> retry_times = #{retryTimes} AND </if> "
            +"<if test='taskArgs != null'> task_args = #{taskArgs} AND </if> "
            +"<if test='taskId != null'> task_id = #{taskId} AND </if> "
            +"<if test='catchException != null'> catch_exception = #{catchException} AND </if> "
            +"<if test='description != null'> description = #{description} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("JobTaskResultMap")
    List<JobTaskDO> selectList(JobTaskDO obj);


    @Select("select job_id jobId,job_name jobName from t_job_task group by job_id,job_name")
    @ResultType(Map.class)
    List<Map> jobDict();
}

