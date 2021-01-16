package com.scenetec.upf.operation.repository.operationrecord;

import com.scenetec.upf.operation.model.domain.operationrecord.OperationRecordDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/05/31
 */
@Repository
@Mapper
public interface OperationRecordMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_operation_record (id,user_create,gmt_create,user_modified,gmt_modified,account,obj_type,bus_lic_code,obj_name,code,ind_name,bank_account_no,bank_account_name,remarks,status,operation_type,snd_date,apply_remark) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{account},#{objType},#{busLicCode},#{objName},#{code},#{indName},#{bankAccountNo},#{bankAccountName},#{remarks},#{status},#{operationType},#{sndDate},#{applyRemark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(OperationRecordDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_operation_record ("
        +" user_create, gmt_create, user_modified, gmt_modified, account, obj_type, bus_lic_code, obj_name, code, ind_name, bank_account_no, bank_account_name, remarks, status, operation_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.busLicCode}, #{item.objName}, #{item.code}, #{item.indName}, #{item.bankAccountNo}, #{item.bankAccountName}, #{item.remarks}, #{item.status}, #{item.operationType})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<OperationRecordDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_operation_record ("
        +" user_create, gmt_create, user_modified, gmt_modified, account, obj_type, bus_lic_code, obj_name, code, ind_name, bank_account_no, bank_account_name, remarks, status, operation_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.busLicCode}, #{item.objName}, #{item.code}, #{item.indName}, #{item.bankAccountNo}, #{item.bankAccountName}, #{item.remarks}, #{item.status}, #{item.operationType})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"account = VALUES(account),"
            +"obj_type = VALUES(obj_type),"
            +"bus_lic_code = VALUES(bus_lic_code),"
            +"obj_name = VALUES(obj_name),"
            +"code = VALUES(code),"
            +"ind_name = VALUES(ind_name),"
            +"bank_account_no = VALUES(bank_account_no),"
            +"bank_account_name = VALUES(bank_account_name),"
            +"remarks = VALUES(remarks),"
            +"status = VALUES(status),"
            +"operation_type = VALUES(operation_type)"
        +"</script>"
    )
    int modifyList(List<OperationRecordDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_operation_record where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_operation_record <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='account != null'> account = #{account}, </if> "
            +"<if test='objType != null'> obj_type = #{objType}, </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode}, </if> "
            +"<if test='objName != null'> obj_name = #{objName}, </if> "
            +"<if test='code != null'> code = #{code}, </if> "
            +"<if test='indName != null'> ind_name = #{indName}, </if> "
            +"<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo}, </if> "
            +"<if test='bankAccountName != null'> bank_account_name = #{bankAccountName}, </if> "
            +"<if test='remarks != null'> remarks = #{remarks}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
            +"<if test='operationType != null'> operation_type = #{operationType}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(OperationRecordDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,bus_lic_code,obj_name,code,ind_name,bank_account_no,bank_account_name,remarks,status,operation_type from t_operation_record where id = #{id}")
 	@Results(id="OperationRecordResultMap", value = {
 	        @Result(property = "id", column = "id"),
            @Result(property = "userCreate", column = "user_create"),
            @Result(property = "gmtCreate", column = "gmt_create"),
            @Result(property = "userModified", column = "user_modified"),
            @Result(property = "gmtModified", column = "gmt_modified"),
            @Result(property = "account", column = "account"),
            @Result(property = "objType", column = "obj_type"),
            @Result(property = "busLicCode", column = "bus_lic_code"),
            @Result(property = "objName", column = "obj_name"),
            @Result(property = "code", column = "code"),
            @Result(property = "indName", column = "ind_name"),
            @Result(property = "bankAccountNo", column = "bank_account_no"),
            @Result(property = "bankAccountName", column = "bank_account_name"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "status", column = "status"),
            @Result(property = "operationType", column = "operation_type"),
            @Result(property = "sndDate", column = "snd_date"),
            @Result(property = "applyRemark", column = "apply_remark")
 	})
 	OperationRecordDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,bus_lic_code,obj_name,code,ind_name,bank_account_no,bank_account_name,remarks,status,operation_type from t_operation_record where 1 = 1"
        + "</script>"
    )
    @ResultMap("OperationRecordResultMap")
    Page<OperationRecordDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_operation_record <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
            +"<if test='objName != null'> obj_name = #{objName} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='indName != null'> ind_name = #{indName} AND </if> "
            +"<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo} AND </if> "
            +"<if test='bankAccountName != null'> bank_account_name = #{bankAccountName} AND </if> "
            +"<if test='remarks != null'> remarks = #{remarks} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(OperationRecordDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,bus_lic_code,obj_name,code,ind_name,bank_account_no,bank_account_name,remarks,status,operation_type from t_operation_record"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
            +"<if test='objName != null'> obj_name = #{objName} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='indName != null'> ind_name = #{indName} AND </if> "
            +"<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo} AND </if> "
            +"<if test='bankAccountName != null'> bank_account_name = #{bankAccountName} AND </if> "
            +"<if test='remarks != null'> remarks = #{remarks} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("OperationRecordResultMap")
    OperationRecordDO selectOne(OperationRecordDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,bus_lic_code,obj_name,code,ind_name,bank_account_no,bank_account_name,remarks,status,operation_type from t_operation_record"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
            +"<if test='objName != null'> obj_name = #{objName} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='indName != null'> ind_name = #{indName} AND </if> "
            +"<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo} AND </if> "
            +"<if test='bankAccountName != null'> bank_account_name = #{bankAccountName} AND </if> "
            +"<if test='remarks != null'> remarks = #{remarks} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("OperationRecordResultMap")
    List<OperationRecordDO> selectList(OperationRecordDO obj);

    @Select(
            "<script>"
                    + "select o.*, "
                    + "case when ai.obj_type = '2' then ai.business_indate "
                    + "when (ai.obj_type = '9' and ai.user_type = '1') then ai.business_indate "
                    + " else ai.legal_indate end as idValidity "
                    + "from t_operation_record o LEFT JOIN t_account_info ai on o.account = ai.account "
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='params.userCreate != null'> o.user_create = #{params.userCreate} AND </if> "
                    + "<if test='params.transBeginDate != null'> o.snd_date &gt;= #{params.transBeginDate} and </if>"
                    + "<if test='params.transEndDate != null'> o.snd_date &lt;= #{params.transEndDate} and</if>"
                    + "<if test='params.userModified != null'> o.user_modified = #{params.userModified} AND </if> "
                    + "<if test='params.gmtModified != null'> o.gmt_modified = #{params.gmtModified} AND </if> "
                    + "<if test='params.objName != null'> o.obj_name like concat('%',#{params.objName},'%') AND </if> "
                    + "<if test='params.status != null'> o.status = #{params.status} AND </if>  "
                    +"<if test='params.operationType != null'> o.operation_type = #{params.operationType} AND </if>"
                    +"<if test='params.account != null'> o.account = #{params.account} AND </if>"
                    +"<if test='params.busLicCode != null'> o.bus_lic_code = #{params.busLicCode} AND </if>"
                    +"<if test='params.objType != null'> o.obj_type = #{params.objType} AND </if>"
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("OperationRecordResultMap")
    Page<OperationRecordDO> listPage(@Param("params") Map<String, Object> params);

}

