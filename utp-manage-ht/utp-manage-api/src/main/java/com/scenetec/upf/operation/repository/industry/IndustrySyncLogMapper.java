package com.scenetec.upf.operation.repository.industry;

import com.scenetec.upf.operation.model.domain.industry.IndustrySyncLogDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/01/22
 */
@Repository
@Mapper
public interface IndustrySyncLogMapper {

    /**
     * 更新
     * @param
     * @return
     */
//    @Update("update t_industry_sync_log set last_date = #{lastDate},user_modified = #{userModified},gmt_modified = #{gmtModified} where industry_code = #{industryCode}")
//    int updateByIndustryCode(@Param("lastDate") String lastDate, @Param("userModified") String userModified, @Param("gmtModified") Date gmtModified, @Param("industryCode") String industryCode);
    @Update("update t_industry_sync_log set last_date = #{lastDate},user_modified = #{userModified},gmt_modified = #{gmtModified} where  industry_code = #{industryCode}" )
    @ResultMap("IndustrySyncLogResultMap")
    int updateByIndustryCode(IndustrySyncLogDO obj);

    @Update("update t_industry_sync_log set last_date = #{lastDate},last_time = #{lastTime},user_modified = #{userModified},gmt_modified = #{gmtModified} where  fund_account_no = #{fundAccountNo}" )
    @ResultMap("IndustrySyncLogResultMap")
    int updateByfundAccount(IndustrySyncLogDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select user_create,gmt_create,user_modified,gmt_modified,industry_code,last_date,remark from t_industry_sync_log where id = #{id}")
 	@Results(id="IndustrySyncLogResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "lastDate", column = "last_date"),@Result(property = "remark", column = "remark")})
 	IndustrySyncLogDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select user_create,gmt_create,user_modified,gmt_modified,industry_code,last_date,remark from t_industry_sync_log where 1 = 1"
		        + "<if test='params.industryCode != null'> and industryCode = #{params.industryCode}</if>"
        + "</script>"
    )
    @ResultMap("IndustrySyncLogResultMap")
    Page<IndustrySyncLogDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_industry_sync_log <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='lastDate != null'> last_date = #{lastDate} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(IndustrySyncLogDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,last_date,remark from t_industry_sync_log"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='lastDate != null'> last_date = #{lastDate} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("IndustrySyncLogResultMap")
    IndustrySyncLogDO selectOne(IndustrySyncLogDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select user_create,gmt_create,user_modified,gmt_modified,industry_code,last_date,remark from t_industry_sync_log"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='lastDate != null'> last_date = #{lastDate} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("IndustrySyncLogResultMap")
    List<IndustrySyncLogDO> selectList(IndustrySyncLogDO obj);

}

