package com.scenetec.upf.operation.repository.specialindustrysyncconfig;


import com.scenetec.upf.operation.model.domain.specialindustrysyncconfig.SpecialIndustrySyncConfigDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2020/03/10
 */
@Repository
@Mapper
public interface SpecialIndustrySyncConfigMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_special_industry_sync_config (user_create,gmt_create,user_modified,gmt_modified,industry_code,name,remark) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{industryCode},#{name},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(SpecialIndustrySyncConfigDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_special_industry_sync_config ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, name, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.name}, #{item.remark})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<SpecialIndustrySyncConfigDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_special_industry_sync_config ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, name, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.name}, #{item.remark})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"industry_code = VALUES(industry_code),"
            +"name = VALUES(name),"
            +"remark = VALUES(remark)"
        +"</script>"
    )
    int modifyList(List<SpecialIndustrySyncConfigDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_special_industry_sync_config where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_special_industry_sync_config <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='name != null'> name = #{name}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(SpecialIndustrySyncConfigDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,name,remark from t_special_industry_sync_config where id = #{id}")
 	@Results(id="SpecialIndustrySyncConfigResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "name", column = "name"),@Result(property = "remark", column = "remark")})
 	SpecialIndustrySyncConfigDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,name,remark from t_special_industry_sync_config where 1 = 1"
        + "</script>"
    )
    @ResultMap("SpecialIndustrySyncConfigResultMap")
    Page<SpecialIndustrySyncConfigDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_special_industry_sync_config <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(SpecialIndustrySyncConfigDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,name,remark from t_special_industry_sync_config"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SpecialIndustrySyncConfigResultMap")
    SpecialIndustrySyncConfigDO selectOne(SpecialIndustrySyncConfigDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,name,remark from t_special_industry_sync_config"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='name != null'> name like concat('%',#{name},'%') AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SpecialIndustrySyncConfigResultMap")
    List<SpecialIndustrySyncConfigDO> selectList(SpecialIndustrySyncConfigDO obj);

}

