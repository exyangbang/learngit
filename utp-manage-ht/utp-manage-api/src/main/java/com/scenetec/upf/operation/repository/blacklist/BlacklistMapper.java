package com.scenetec.upf.operation.repository.blacklist;

import com.scenetec.upf.operation.model.domain.blacklist.BlacklistDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/10/10
 */
@Repository
@Mapper
public interface BlacklistMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_blacklist (user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark,obj_type ,bus_lic_code,ent_name ) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{name},#{idCode},#{remark},#{objType},#{busLicCode},#{entName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(BlacklistDO obj);
    

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_blacklist where id = #{id}")
    int delete(Long userId);

    @Delete("delete from t_blacklist where id_code = #{idCode}")
    int deleteByIdCode(String idCode);

    @Delete("delete from t_blacklist where bus_lic_code = #{busLicCode}")
    int deleteByBusLicCode(String idCode);
    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_blacklist <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='name != null'> name = #{name}, </if> "
            +"<if test='idCode != null'> id_code = #{idCode}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='objType != null'> obj_type = #{objType}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(BlacklistDO obj);

    @Update(
            "<script>"
                    +"update t_blacklist <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='name != null'> name = #{name}, </if> "
                    +"<if test='remark != null'> remark = #{remark}, </if> "
                    +"<if test='objType != null'> obj_type = #{objType}, </if> "
                    +"<if test='entName != null'> ent_name = #{entName}, </if> "
                    +"</set> where id_code = #{idCode}"
                    +"</script>"
    )
    int updateByIdCode(BlacklistDO obj);

    @Update(
            "<script>"
                    +"update t_blacklist <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='name != null'> name = #{name}, </if> "
                    +"<if test='remark != null'> remark = #{remark}, </if> "
                    +"<if test='objType != null'> obj_type = #{objType}, </if> "
                    +"<if test='entName != null'> ent_name = #{entName}, </if> "
                    +"</set> where bus_lic_code = #{busLicCode}"
                    +"</script>"
    )
    int updateByBusLicCode(BlacklistDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark,obj_type,bus_lic_code,ent_name from t_blacklist where id = #{id}")
 	@Results(id="BlacklistResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "name", column = "name"),@Result(property = "idCode", column = "id_code"),@Result(property = "remark", column = "remark"),@Result(property = "busLicCode", column = "bus_lic_code") ,@Result(property = "entName", column = "ent_name") ,@Result(property = "objType", column = "obj_type")})
 	BlacklistDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark from t_blacklist where 1 = 1"
		        + "<if test='params.idCode != null'> and id_code = #{params.idCode}</if>"
        + "</script>"
    )
    @ResultMap("BlacklistResultMap")
    Page<BlacklistDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_blacklist <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='idCode != null'> id_code = #{idCode} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(BlacklistDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark from t_blacklist"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='idCode != null'> id_code = #{idCode} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("BlacklistResultMap")
    BlacklistDO selectOne(BlacklistDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark from t_blacklist"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='idCode != null'> id_code = #{idCode} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("BlacklistResultMap")
    List<BlacklistDO> selectList(BlacklistDO obj);

    @Select(
            "<script>"
                    +"SELECT "
                    +"lit.*,"
                    +" CASE "
                    +" WHEN lit.obj_type = 1 THEN "
                    +" ( "
                    +" SELECT "
                    +" audit_status "
                    +" FROM "
                    +" t_blacklist_approval ap "
                    +" WHERE "
                    +" ap.id_code = lit.id_code "
                    +" ORDER BY "
                    +"  gmt_create DESC "
                    +"  LIMIT 1 "
                    +"  )  "
                    +" WHEN lit.obj_type = 2 THEN "
                    +" ( "
                    +" SELECT "
                    +" audit_status "
                    +"  FROM "
                    +" t_blacklist_approval ap "
                    +" WHERE "
                    +" ap.bus_lic_code = lit.bus_lic_code "
                    +" ORDER BY "
                    +" gmt_create DESC "
                    +" LIMIT 1 "
                    +" )  "
                    +" end AS auditStatus "
                    +" FROM "
                    +" t_blacklist AS lit "
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='params.name != null'> lit.name like concat('%',#{params.name},'%') AND </if> "
                    +"<if test='params.entName != null'> lit.ent_name like concat('%',#{params.entName},'%') AND </if> "
                    +"<if test='params.idCode != null'> lit.id_code = #{params.idCode} AND </if> "
                    +"<if test='params.busLicCode != null'> lit.bus_lic_code = #{params.busLicCode} AND </if> "
                    +"<if test='params.objType != null'> lit.obj_type = #{params.objType} AND </if> "
                    + "<if test='params.transBeginDate != null'> gmt_create &gt;= #{params.transBeginDate} AND </if>"
                    + "<if test='params.transEndDate != null'> gmt_create &lt;= #{params.transEndDate} AND </if>"
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("BlacklistResultMap")
    List<BlacklistDO> listPage(@Param("params") Map<String, Object> params);

}

