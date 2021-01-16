package com.scenetec.upf.operation.repository.blacklisapproval;

import com.scenetec.upf.operation.model.domain.blacklisapproval.BlacklistApprovalDO;
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
public interface BlacklistApprovalMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_blacklist_approval (id,user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark,audit_status,operation_type,obj_type,bus_lic_code,ent_name) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{name},#{idCode},#{remark},#{auditStatus},#{operationType},#{objType},#{busLicCode},#{entName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(BlacklistApprovalDO obj);



    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_blacklist_approval where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_blacklist_approval <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='name != null'> name = #{name}, </if> "
            +"<if test='idCode != null'> id_code = #{idCode}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
            +"<if test='objType != null'> obj_type = #{objType}, </if> "
            +"<if test='operationType != null'> operation_type = #{operationType}, </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode}, </if> "
            +"<if test='entName != null'> ent_name = #{entName}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(BlacklistApprovalDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark,audit_status,operation_type,obj_type,bus_lic_code,ent_name  from t_blacklist_approval where id = #{id}")
 	@Results(id="BlacklistApprovalResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "name", column = "name"),@Result(property = "idCode", column = "id_code"),@Result(property = "remark", column = "remark"),@Result(property = "auditStatus", column = "audit_status"),@Result(property = "operationType", column = "operation_type"),@Result(property = "objType", column = "obj_type"),@Result(property = "busLicCode", column = "bus_lic_code") ,@Result(property = "entName", column = "ent_name")})
 	BlacklistApprovalDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark,audit_status,operation_type from t_blacklist_approval where 1 = 1"
        + "</script>"
    )
    @ResultMap("BlacklistApprovalResultMap")
    Page<BlacklistApprovalDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_blacklist_approval <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='idCode != null'> id_code = #{idCode} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
                +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(BlacklistApprovalDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark,audit_status,operation_type from t_blacklist_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='idCode != null'> id_code = #{idCode} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("BlacklistApprovalResultMap")
    BlacklistApprovalDO selectOne(BlacklistApprovalDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,name,id_code,remark,audit_status,operation_type from t_blacklist_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='idCode != null'> id_code = #{idCode} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("BlacklistApprovalResultMap")
    List<BlacklistApprovalDO> selectList(BlacklistApprovalDO obj);


    @Select(
            "<script>"
                    +"select * from t_blacklist_approval"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='params.name != null'> name like concat('%',#{params.name},'%') AND </if> "
                    +"<if test='params.idCode != null'> id_code = #{params.idCode} AND </if> "
                    +"<if test='params.auditStatus != null'> audit_status = #{params.auditStatus} AND </if> "
                    +"<if test='params.operationType != null'> operation_type = #{params.operationType} AND </if> "
                    +"<if test='params.busLicCode != null'> bus_lic_code = #{params.busLicCode} AND  </if> "
                    +"<if test='params.entName != null'> ent_name = #{params.entName} AND  </if> "
                    +"<if test='params.objType != null'> obj_type = #{params.objType} AND  </if> "
                    + "<if test='params.transBeginDate != null'> gmt_create &gt;= #{params.transBeginDate} AND </if>"
                    + "<if test='params.transEndDate != null'> gmt_create &lt;= #{params.transEndDate} AND </if>"
                    +"</trim></where> "
                    +"order by gmt_create desc"
                    +"</script>"
    )
    @ResultMap("BlacklistApprovalResultMap")
    List<BlacklistApprovalDO> pageList(@Param("params") Map<String, Object> params);

}

