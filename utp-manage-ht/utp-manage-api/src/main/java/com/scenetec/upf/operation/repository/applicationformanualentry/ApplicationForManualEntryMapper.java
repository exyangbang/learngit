package com.scenetec.upf.operation.repository.applicationformanualentry;

import com.scenetec.upf.operation.model.domain.applicationformanualentry.ApplicationForManualEntryDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/03/18
 */
@Repository
@Mapper
public interface ApplicationForManualEntryMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_application_for_manual_entry (id,user_create,gmt_create,user_modified,gmt_modified,cust_account_no,cust_account_name,txn_amount,account_balance,other_cust_account_no,other_cust_name,account,account_name,sys_reference_no,trans_id,status,audit_status,remark) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{custAccountNo},#{custAccountName},#{txnAmount},#{accountBalance},#{otherCustAccountNo},#{otherCustName},#{account},#{accountName},#{sysReferenceNo},#{transId},#{status},#{auditStatus},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(ApplicationForManualEntryDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_application_for_manual_entry ("
        +" user_create, gmt_create, user_modified, gmt_modified, cust_account_no, cust_account_name, txn_amount, account_balance, other_cust_account_no, other_cust_name, account, account_name, sys_reference_no, trans_id, status, audit_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.custAccountNo}, #{item.custAccountName}, #{item.txnAmount}, #{item.accountBalance}, #{item.otherCustAccountNo}, #{item.otherCustName}, #{item.account}, #{item.accountName}, #{item.sysReferenceNo}, #{item.transId}, #{item.status}, #{item.auditStatus})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<ApplicationForManualEntryDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_application_for_manual_entry ("
        +" user_create, gmt_create, user_modified, gmt_modified, cust_account_no, cust_account_name, txn_amount, account_balance, other_cust_account_no, other_cust_name, account, account_name, sys_reference_no, trans_id, status, audit_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.custAccountNo}, #{item.custAccountName}, #{item.txnAmount}, #{item.accountBalance}, #{item.otherCustAccountNo}, #{item.otherCustName}, #{item.account}, #{item.accountName}, #{item.sysReferenceNo}, #{item.transId}, #{item.status}, #{item.auditStatus})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"cust_account_no = VALUES(cust_account_no),"
            +"cust_account_name = VALUES(cust_account_name),"
            +"txn_amount = VALUES(txn_amount),"
            +"account_balance = VALUES(account_balance),"
            +"other_cust_account_no = VALUES(other_cust_account_no),"
            +"other_cust_name = VALUES(other_cust_name),"
            +"account = VALUES(account),"
            +"account_name = VALUES(account_name),"
            +"sys_reference_no = VALUES(sys_reference_no),"
            +"trans_id = VALUES(trans_id),"
            +"status = VALUES(status),"
            +"audit_status = VALUES(audit_status)"
        +"</script>"
    )
    int modifyList(List<ApplicationForManualEntryDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_application_for_manual_entry where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_application_for_manual_entry <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo}, </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName}, </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount}, </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance}, </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo}, </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName}, </if> "
            +"<if test='account != null'> account = #{account}, </if> "
            +"<if test='accountName != null'> account_name = #{accountName}, </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo}, </if> "
            +"<if test='transId != null'> trans_id = #{transId}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(ApplicationForManualEntryDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,cust_account_no,cust_account_name,txn_amount,account_balance,other_cust_account_no,other_cust_name,account,account_name,sys_reference_no,trans_id,status,audit_status,remark from t_application_for_manual_entry where id = #{id}")
 	@Results(id="ApplicationForManualEntryResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "custAccountNo", column = "cust_account_no"),@Result(property = "custAccountName", column = "cust_account_name"),@Result(property = "txnAmount", column = "txn_amount"),@Result(property = "accountBalance", column = "account_balance"),@Result(property = "otherCustAccountNo", column = "other_cust_account_no"),@Result(property = "otherCustName", column = "other_cust_name"),@Result(property = "account", column = "account"),@Result(property = "accountName", column = "account_name"),@Result(property = "sysReferenceNo", column = "sys_reference_no"),@Result(property = "transId", column = "trans_id"),@Result(property = "status", column = "status"),@Result(property = "auditStatus", column = "audit_status"),@Result(property = "remark", column = "remark")})
 	ApplicationForManualEntryDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,cust_account_no,cust_account_name,txn_amount,account_balance,other_cust_account_no,other_cust_name,account,account_name,sys_reference_no,trans_id,status,audit_status from t_application_for_manual_entry where 1 = 1"
        + "</script>"
    )
    @ResultMap("ApplicationForManualEntryResultMap")
    Page<ApplicationForManualEntryDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_application_for_manual_entry <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo} AND </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName} AND </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount} AND </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance} AND </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo} AND </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo} AND </if> "
            +"<if test='transId != null'> trans_id = #{transId} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(ApplicationForManualEntryDO obj);

    /**
     * 查询总数 查询 通过和待审核状态的数据
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_application_for_manual_entry <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo} AND </if> "
                    +"<if test='custAccountName != null'> cust_account_name = #{custAccountName} AND </if> "
                    +"<if test='txnAmount != null'> txn_amount = #{txnAmount} AND </if> "
                    +"<if test='accountBalance != null'> account_balance = #{accountBalance} AND </if> "
                    +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo} AND </if> "
                    +"<if test='otherCustName != null'> other_cust_name = #{otherCustName} AND </if> "
                    +"<if test='account != null'> account = #{account} AND </if> "
                    +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo} AND </if> "
                    +"<if test='transId != null'> trans_id = #{transId} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    +"<if test='auditStatusPass != null'> audit_status = #{auditStatusPass} OR </if> "
                    +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
                    +"<if test='transId != null'> trans_id = #{transId} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int countCustom(ApplicationForManualEntryDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,cust_account_no,cust_account_name,txn_amount,account_balance,other_cust_account_no,other_cust_name,account,account_name,sys_reference_no,trans_id,status,audit_status from t_application_for_manual_entry"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo} AND </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName} AND </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount} AND </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance} AND </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo} AND </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo} AND </if> "
            +"<if test='transId != null'> trans_id = #{transId} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ApplicationForManualEntryResultMap")
    ApplicationForManualEntryDO selectOne(ApplicationForManualEntryDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,cust_account_no,cust_account_name,txn_amount,account_balance,other_cust_account_no,other_cust_name,account,account_name,sys_reference_no,trans_id,status,audit_status from t_application_for_manual_entry"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo} AND </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName} AND </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount} AND </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance} AND </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo} AND </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo} AND </if> "
            +"<if test='transId != null'> trans_id = #{transId} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ApplicationForManualEntryResultMap")
    List<ApplicationForManualEntryDO> selectList(ApplicationForManualEntryDO obj);

    /**
     * 查询列表(分页) listpage
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select * from t_application_for_manual_entry  where 1 = 1"
                    + "<if test='params.transBeginDate != null'> and tm.gmt_modified &gt;= #{params.transBeginDate} </if>"
                    + "<if test='params.transEndDate != null'>and tm.gmt_modified &lt;= #{params.transEndDate}</if>"
                    + "<if test='params.custAccountNo != null'> and cust_account_no = #{params.custAccountNo}</if>"
                    +"<if test='params.custAccountName != null'>and cust_account_name like concat('%',#{params.custAccountName},'%')</if> "
                    +"<if test='params.otherCustAccountNo != null'>and other_cust_account_no = #{params.otherCustAccountNo} </if> "
                    +"<if test='params.otherCustName != null'>and other_cust_name like concat('%',#{params.otherCustName},'%') </if> "
                    +"<if test='params.account != null'>and account = #{params.account} </if> "
                    +"<if test='params.accountName != null'>and account_name like concat('%',#{params.accountName},'%') </if> "
                    +"<if test='params.auditStatus != null'>and audit_status = #{params.auditStatus} </if> "
                    +"<if test='params.status != null'>and status = #{params.status} </if> "
                    +"<if test='params.sysReferenceNo != null'>and sys_reference_no = #{params.sysReferenceNo} </if> "
                    + "</script>"
    )
    @ResultMap("ApplicationForManualEntryResultMap")
    Page<ApplicationForManualEntryDO> listPage(@Param("params") Map<String, Object> params);

    /**
     * 更新 逻辑删除
     * @param
     * @return
     */
    @Update(
            "<script> update t_application_for_manual_entry set status = 0 where id = #{id} </script>"
    )
    int updateByStatus(Long userId);

}

