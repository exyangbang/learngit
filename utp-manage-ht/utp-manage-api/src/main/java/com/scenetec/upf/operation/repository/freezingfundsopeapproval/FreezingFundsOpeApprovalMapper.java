package com.scenetec.upf.operation.repository.freezingfundsopeapproval;

import com.scenetec.upf.operation.model.domain.freezingfundsopeapproval.FreezingFundsOpeApprovalDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/10/11
 */
@Repository
@Mapper
public interface FreezingFundsOpeApprovalMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_freezing_funds_ope_approval (id,user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_name,code,ind_name,operation_type,frozen_amount,bus_lic_code,audit_remark,server_trans_id,clinet_trans_id,add_usr,audit_status,freeze_id,unfreeze_status) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{account},#{objType},#{objName},#{code},#{indName},#{operationType},#{frozenAmount},#{busLicCode},#{auditRemark},#{serverTransId},#{clinetTransId},#{addUsr},#{auditStatus},#{freezeId},#{unfreezeStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(FreezingFundsOpeApprovalDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_freezing_funds_ope_approval ("
        +" user_create, gmt_create, user_modified, gmt_modified, account, obj_type, obj_name, code, ind_name, operation_type, frozen_amount, bus_lic_code, audit_remark, server_trans_id, clinet_trans_id, add_usr, audit_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.objName}, #{item.code}, #{item.indName}, #{item.operationType}, #{item.frozenAmount}, #{item.busLicCode}, #{item.auditRemark}, #{item.serverTransId}, #{item.clinetTransId}, #{item.addUsr}, #{item.auditStatus})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<FreezingFundsOpeApprovalDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_freezing_funds_ope_approval ("
        +" user_create, gmt_create, user_modified, gmt_modified, account, obj_type, obj_name, code, ind_name, operation_type, frozen_amount, bus_lic_code, audit_remark, server_trans_id, clinet_trans_id, add_usr, audit_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.objName}, #{item.code}, #{item.indName}, #{item.operationType}, #{item.frozenAmount}, #{item.busLicCode}, #{item.auditRemark}, #{item.serverTransId}, #{item.clinetTransId}, #{item.addUsr}, #{item.auditStatus})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"account = VALUES(account),"
            +"obj_type = VALUES(obj_type),"
            +"obj_name = VALUES(obj_name),"
            +"code = VALUES(code),"
            +"ind_name = VALUES(ind_name),"
            +"operation_type = VALUES(operation_type),"
            +"frozen_amount = VALUES(frozen_amount),"
            +"bus_lic_code = VALUES(bus_lic_code),"
            +"audit_remark = VALUES(audit_remark),"
            +"server_trans_id = VALUES(server_trans_id),"
            +"clinet_trans_id = VALUES(clinet_trans_id),"
            +"add_usr = VALUES(add_usr),"
            +"audit_status = VALUES(audit_status)"
        +"</script>"
    )
    int modifyList(List<FreezingFundsOpeApprovalDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_freezing_funds_ope_approval where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_freezing_funds_ope_approval <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='account != null'> account = #{account}, </if> "
            +"<if test='objType != null'> obj_type = #{objType}, </if> "
            +"<if test='objName != null'> obj_name = #{objName}, </if> "
            +"<if test='code != null'> code = #{code}, </if> "
            +"<if test='indName != null'> ind_name = #{indName}, </if> "
            +"<if test='operationType != null'> operation_type = #{operationType}, </if> "
            +"<if test='frozenAmount != null'> frozen_amount = #{frozenAmount}, </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode}, </if> "
            +"<if test='auditRemark != null'> audit_remark = #{auditRemark}, </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "
            +"<if test='clinetTransId != null'> clinet_trans_id = #{clinetTransId}, </if> "
            +"<if test='addUsr != null'> add_usr = #{addUsr}, </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
            +"<if test='freezeId != null'>  freeze_id = #{freezeId}, </if> "
                +"<if test='unfreezeStatus != null'>  unfreeze_status = #{unfreezeStatus}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(FreezingFundsOpeApprovalDO obj);

    @Update(
            "<script>"
                    +"update t_freezing_funds_ope_approval <set> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='auditRemark != null'> audit_remark = #{auditRemark}, </if> "
                    +"<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "
                    +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
                    +"</set> where clinet_trans_id = #{clinetTransId} and account = #{account} and " +
                    "operation_type = #{operationType}"
                    +"</script>"
    )
    int updateByClientTransIdAndAccount(FreezingFundsOpeApprovalDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select * from t_freezing_funds_ope_approval where id = #{id}")
 	@Results(id="FreezingFundsOpeApprovalResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "account", column = "account"),@Result(property = "objType", column = "obj_type"),@Result(property = "objName", column = "obj_name"),@Result(property = "code", column = "code"),@Result(property = "indName", column = "ind_name"),@Result(property = "operationType", column = "operation_type"),@Result(property = "frozenAmount", column = "frozen_amount"),@Result(property = "busLicCode", column = "bus_lic_code"),@Result(property = "auditRemark", column = "audit_remark"),@Result(property = "serverTransId", column = "server_trans_id"),@Result(property = "clinetTransId", column = "clinet_trans_id"),@Result(property = "addUsr", column = "add_usr"),@Result(property = "auditStatus", column = "audit_status"),@Result(property = "freezeId", column = "freeze_id"),@Result(property = "unfreezeStatus", column = "unfreeze_status")})
 	FreezingFundsOpeApprovalDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_name,code,ind_name,operation_type,frozen_amount,bus_lic_code,audit_remark,server_trans_id,clinet_trans_id,add_usr,audit_status from t_freezing_funds_ope_approval where 1 = 1"
        + "</script>"
    )
    @ResultMap("FreezingFundsOpeApprovalResultMap")
    Page<FreezingFundsOpeApprovalDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_freezing_funds_ope_approval <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='objName != null'> obj_name = #{objName} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='indName != null'> ind_name = #{indName} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
            +"<if test='frozenAmount != null'> frozen_amount = #{frozenAmount} AND </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
            +"<if test='auditRemark != null'> audit_remark = #{auditRemark} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='clinetTransId != null'> clinet_trans_id = #{clinetTransId} AND </if> "
            +"<if test='addUsr != null'> add_usr = #{addUsr} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='freezeId != null'> freeze_id = #{freezeId} AND </if> "
            +"<if test='unfreezeStatus != null'> unfreeze_status = #{unfreezeStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(FreezingFundsOpeApprovalDO obj);

    @Select(
            "<script>"
                    +"select count(*) from t_freezing_funds_ope_approval <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='account != null'> account = #{account} AND </if> "
                    +"<if test='objType != null'> obj_type = #{objType} AND </if> "
                    +"<if test='objName != null'> obj_name = #{objName} AND </if> "
                    +"<if test='code != null'> code = #{code} AND </if> "
                    +"<if test='indName != null'> ind_name = #{indName} AND </if> "
                    +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
                    +"<if test='frozenAmount != null'> frozen_amount = #{frozenAmount} AND </if> "
                    +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
                    +"<if test='auditRemark != null'> audit_remark = #{auditRemark} AND </if> "
                    +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
                    +"<if test='clinetTransId != null'> clinet_trans_id = #{clinetTransId} AND </if> "
                    +"<if test='addUsr != null'> add_usr = #{addUsr} AND </if> "
                    +"<if test='unfreezeStatus != null'> unfreeze_status != #{unfreezeStatus} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int countUnfreezeStatus(FreezingFundsOpeApprovalDO obj);
    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_name,code,ind_name,operation_type,frozen_amount,bus_lic_code,audit_remark,server_trans_id,clinet_trans_id,add_usr,audit_status from t_freezing_funds_ope_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='objName != null'> obj_name = #{objName} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='indName != null'> ind_name = #{indName} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
            +"<if test='frozenAmount != null'> frozen_amount = #{frozenAmount} AND </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
            +"<if test='auditRemark != null'> audit_remark = #{auditRemark} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='clinetTransId != null'> clinet_trans_id = #{clinetTransId} AND </if> "
            +"<if test='addUsr != null'> add_usr = #{addUsr} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FreezingFundsOpeApprovalResultMap")
    FreezingFundsOpeApprovalDO selectOne(FreezingFundsOpeApprovalDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_name,code,ind_name,operation_type,frozen_amount,bus_lic_code,audit_remark,server_trans_id,clinet_trans_id,add_usr,audit_status from t_freezing_funds_ope_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='objName != null'> obj_name = #{objName} AND </if> "
            +"<if test='code != null'> code = #{code} AND </if> "
            +"<if test='indName != null'> ind_name = #{indName} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
            +"<if test='frozenAmount != null'> frozen_amount = #{frozenAmount} AND </if> "
            +"<if test='busLicCode != null'> bus_lic_code = #{busLicCode} AND </if> "
            +"<if test='auditRemark != null'> audit_remark = #{auditRemark} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='clinetTransId != null'> clinet_trans_id = #{clinetTransId} AND </if> "
            +"<if test='addUsr != null'> add_usr = #{addUsr} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FreezingFundsOpeApprovalResultMap")
    List<FreezingFundsOpeApprovalDO> selectList(FreezingFundsOpeApprovalDO obj);


    @Select(
            "<script>"
                    +"select * from t_freezing_funds_ope_approval"
                    +"<where> <trim suffixOverrides='AND'>"
                    + "<if test='params.transBeginDate != null'> gmt_create &gt;= #{params.transBeginDate} AND </if>"
                    + "<if test='params.transEndDate != null'> gmt_create &lt;= #{params.transEndDate} AND </if>"
                    +"<if test='params.account != null'> account = #{params.account} AND </if> "
                    +"<if test='params.objType != null'> obj_type = #{params.objType} AND </if> "
                    +"<if test='params.objName != null'> obj_name like concat('%', #{params.objName} ,'%') AND </if> "
                    +"<if test='params.code != null'> code = #{params.code} AND </if> "
                    +"<if test='params.indName != null'> ind_name like concat('%',#{params.indName},'%')  AND </if> "
                    +"<if test='params.operationType != null'> operation_type = #{params.operationType} AND </if> "
                    +"<if test='params.frozenAmount != null'> frozen_amount = #{params.frozenAmount} AND </if> "
                    +"<if test='params.busLicCode != null'> bus_lic_code = #{params.busLicCode} AND </if> "
                    +"<if test='params.serverTransId != null'> server_trans_id = #{params.serverTransId} AND </if> "
                    +"<if test='params.clinetTransId != null'> clinet_trans_id = #{params.clinetTransId} AND </if> "
                    +"<if test='params.addUsr != null'> add_usr = #{params.addUsr} AND </if> "
                    +"<if test='params.auditStatus != null'> audit_status = #{params.auditStatus} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("FreezingFundsOpeApprovalResultMap")
    List<FreezingFundsOpeApprovalDO> listPage(@Param("params") Map<String, Object> params);

    /**
     * 发起申请金额 求和
     * @param
     * @return
     */
    @Select("select ifnull(sum(frozen_amount),0) from t_freezing_funds_ope_approval where account = #{account} and audit_status ='0' and operation_type='0'")
    Long sumOfFrozenAmount(String account);
}

