package com.scenetec.upf.operation.repository.channelrespcode;

import com.scenetec.upf.operation.model.domain.channelrespcode.ChannelRespcodeDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/06/18
 */
@Repository
@Mapper
public interface ChannelRespcodeMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_channel_respcode (user_create,gmt_create,user_modified,gmt_modified,trans_status,channel_respcode,channel_respdesc,status,remark) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{transStatus},#{channelRespcode},#{channelRespdesc},#{status},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(ChannelRespcodeDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_respcode ("
        +" user_create, gmt_create, user_modified, gmt_modified, trans_status, channel_respcode, channel_respdesc, status, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.transStatus}, #{item.channelRespcode}, #{item.channelRespdesc}, #{item.status}, #{item.remark})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<ChannelRespcodeDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_respcode ("
        +" user_create, gmt_create, user_modified, gmt_modified, trans_status, channel_respcode, channel_respdesc, status, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.transStatus}, #{item.channelRespcode}, #{item.channelRespdesc}, #{item.status}, #{item.remark})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"trans_status = VALUES(trans_status),"
            +"channel_respcode = VALUES(channel_respcode),"
            +"channel_respdesc = VALUES(channel_respdesc),"
            +"status = VALUES(status),"
            +"remark = VALUES(remark)"
        +"</script>"
    )
    int modifyList(List<ChannelRespcodeDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_channel_respcode where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_channel_respcode <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus}, </if> "
            +"<if test='channelRespcode != null'> channel_respcode = #{channelRespcode}, </if> "
            +"<if test='channelRespdesc != null'> channel_respdesc = #{channelRespdesc}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(ChannelRespcodeDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,trans_status,channel_respcode,channel_respdesc,status,remark from t_channel_respcode where id = #{id}")
 	@Results(id="ChannelRespcodeResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "transStatus", column = "trans_status"),@Result(property = "channelRespcode", column = "channel_respcode"),@Result(property = "channelRespdesc", column = "channel_respdesc"),@Result(property = "status", column = "status"),@Result(property = "remark", column = "remark")})
 	ChannelRespcodeDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,trans_status,channel_respcode,channel_respdesc,status,remark from t_channel_respcode where 1 = 1"
		        + "<if test='params.channelRespcode != null'> and channel_respcode = #{params.channelRespcode}</if>"
        + "</script>"
    )
    @ResultMap("ChannelRespcodeResultMap")
    Page<ChannelRespcodeDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_channel_respcode <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='channelRespcode != null'> channel_respcode = #{channelRespcode} AND </if> "
            +"<if test='channelRespdesc != null'> channel_respdesc = #{channelRespdesc} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='id != null'> id != #{id} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(ChannelRespcodeDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,trans_status,channel_respcode,channel_respdesc,status,remark from t_channel_respcode"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='channelRespcode != null'> channel_respcode = #{channelRespcode} AND </if> "
            +"<if test='channelRespdesc != null'> channel_respdesc = #{channelRespdesc} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelRespcodeResultMap")
    ChannelRespcodeDO selectOne(ChannelRespcodeDO obj);


    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,trans_status,channel_respcode,channel_respdesc,status,remark from t_channel_respcode"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='channelRespcode != null'> channel_respcode = #{channelRespcode} AND </if> "
            +"<if test='channelRespdesc != null'> channel_respdesc = #{channelRespdesc} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelRespcodeResultMap")
    List<ChannelRespcodeDO> selectList(ChannelRespcodeDO obj);

}

