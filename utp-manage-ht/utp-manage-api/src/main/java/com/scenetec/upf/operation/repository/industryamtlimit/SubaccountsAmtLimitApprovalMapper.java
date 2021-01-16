package com.scenetec.upf.operation.repository.industryamtlimit;

import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitApprovalDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/07/31
 */
@Repository
@Mapper
public interface SubaccountsAmtLimitApprovalMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_subaccounts_amt_limit_approval (user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark,audit_status,operation_type) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{industryCode},#{industryId},#{subObjName},#{subAccount},#{subaccountsIndividualAmt},#{subaccountsDateAmt},#{remark},#{auditStatus},#{operationType})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(SubaccountsAmtLimitApprovalDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_subaccounts_amt_limit_approval ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, industry_id, sub_obj_name, sub_account, subaccounts_individual_amt, subaccounts_date_amt, remark, audit_status, operation_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.industryId}, #{item.subObjName}, #{item.subAccount}, #{item.subaccountsIndividualAmt}, #{item.subaccountsDateAmt}, #{item.remark}, #{item.auditStatus}, #{item.operationType})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<SubaccountsAmtLimitApprovalDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_subaccounts_amt_limit_approval ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, industry_id, sub_obj_name, sub_account, subaccounts_individual_amt, subaccounts_date_amt, remark, audit_status, operation_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.industryId}, #{item.subObjName}, #{item.subAccount}, #{item.subaccountsIndividualAmt}, #{item.subaccountsDateAmt}, #{item.remark}, #{item.auditStatus}, #{item.operationType})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"industry_code = VALUES(industry_code),"
            +"industry_id = VALUES(industry_id),"
            +"sub_obj_name = VALUES(sub_obj_name),"
            +"sub_account = VALUES(sub_account),"
            +"subaccounts_individual_amt = VALUES(subaccounts_individual_amt),"
            +"subaccounts_date_amt = VALUES(subaccounts_date_amt),"
            +"remark = VALUES(remark),"
            +"audit_status = VALUES(audit_status),"
            +"operation_type = VALUES(operation_type)"
        +"</script>"
    )
    int modifyList(List<SubaccountsAmtLimitApprovalDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_subaccounts_amt_limit_approval where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_subaccounts_amt_limit_approval <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='industryId != null'> industry_id = #{industryId}, </if> "
            +"<if test='subObjName != null'> sub_obj_name = #{subObjName}, </if> "
            +"<if test='subAccount != null'> sub_account = #{subAccount}, </if> "
            +"<if test='subaccountsIndividualAmt != null'> subaccounts_individual_amt = #{subaccountsIndividualAmt}, </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
            +"<if test='operationType != null'> operation_type = #{operationType}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(SubaccountsAmtLimitApprovalDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark,audit_status,operation_type from t_subaccounts_amt_limit_approval where id = #{id}")
 	@Results(id="SubaccountsAmtLimitApprovalResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryId", column = "industry_id"),@Result(property = "subObjName", column = "sub_obj_name"),@Result(property = "subAccount", column = "sub_account"),@Result(property = "subaccountsIndividualAmt", column = "subaccounts_individual_amt"),@Result(property = "subaccountsDateAmt", column = "subaccounts_date_amt"),@Result(property = "remark", column = "remark"),@Result(property = "auditStatus", column = "audit_status"),@Result(property = "operationType", column = "operation_type")})
 	SubaccountsAmtLimitApprovalDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark,audit_status,operation_type from t_subaccounts_amt_limit_approval where 1 = 1"
        + "</script>"
    )
    @ResultMap("SubaccountsAmtLimitApprovalResultMap")
    Page<SubaccountsAmtLimitApprovalDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_subaccounts_amt_limit_approval <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='subObjName != null'> sub_obj_name = #{subObjName} AND </if> "
            +"<if test='subAccount != null'> sub_account = #{subAccount} AND </if> "
            +"<if test='subaccountsIndividualAmt != null'> subaccounts_individual_amt = #{subaccountsIndividualAmt} AND </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(SubaccountsAmtLimitApprovalDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark,audit_status,operation_type from t_subaccounts_amt_limit_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='subObjName != null'> sub_obj_name = #{subObjName} AND </if> "
            +"<if test='subAccount != null'> sub_account = #{subAccount} AND </if> "
            +"<if test='subaccountsIndividualAmt != null'> subaccounts_individual_amt = #{subaccountsIndividualAmt} AND </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SubaccountsAmtLimitApprovalResultMap")
    SubaccountsAmtLimitApprovalDO selectOne(SubaccountsAmtLimitApprovalDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark,audit_status,operation_type from t_subaccounts_amt_limit_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='subObjName != null'> sub_obj_name = #{subObjName} AND </if> "
            +"<if test='subAccount != null'> sub_account = #{subAccount} AND </if> "
            +"<if test='subaccountsIndividualAmt != null'> subaccounts_individual_amt = #{subaccountsIndividualAmt} AND </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SubaccountsAmtLimitApprovalResultMap")
    List<SubaccountsAmtLimitApprovalDO> selectList(SubaccountsAmtLimitApprovalDO obj);


    @Select(
            "<script>"
                    + "select * from t_subaccounts_amt_limit_approval  where 1 = 1"
                    +"<if test='params.industryName != null'>and industry_name = concat('%',#{params.industryName},'%')  </if> "
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.operationType != null'> and operation_type = #{params.operationType}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.subAccount != null'> and sub_account = #{params.subAccount}</if>"
                    + "<if test='params.transBeginDate != null'> and gmt_create &gt;= #{params.transBeginDate}</if>"
                    + "<if test='params.transEndDate != null'> and gmt_create &lt;= #{params.transEndDate}</if>"
                    +"order by gmt_modified desc limit 1"
                    + "</script>"
    )
    @ResultMap("SubaccountsAmtLimitApprovalResultMap")
    SubaccountsAmtLimitApprovalDO selectByindLimit(@Param("params") Map<String, Object> params);


    /**
     * 客户名称(输入框，模糊查询)、 客户号(输入框，全匹配查询)、子账户名称(输入框，模糊查询)、子账户账号(输入框，全匹配查询)、
     * 操作类型（下拉框，内容：“新增”、“修改”、“删除”）
     * 审核状态（全匹配查询）、申请开始时间、申请结束时间
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select ap.*,ind.name from  t_subaccounts_amt_limit_approval ap left join t_industry ind on ind.id=ap.industry_id   where 1 = 1"
                    + "<if test='params.name != null'> and ind.name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.subObjName != null'> and ap.sub_obj_name like concat('%',#{params.subObjName},'%')</if>"
                    +"<if test='params.industryCode != null'>and ap.industry_code = #{params.industryCode}  </if> "
                    + "<if test='params.subAccount != null'> and ap.sub_account = #{params.subAccount}</if>"
                    + "<if test='params.operationType != null'> and ap.operation_type = #{params.operationType}</if>"
                    + "<if test='params.auditStatus != null'> and ap.audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.transBeginDate != null'> and ap.gmt_create &gt;= #{params.transBeginDate}</if>"
                    + "<if test='params.transEndDate != null'> and ap.gmt_create &lt;= #{params.transEndDate}</if>"
                    +"order by gmt_create desc"
                    + "</script>"
    )
    @ResultMap("SubaccountsAmtLimitApprovalResultMap")
    Page<SubaccountsAmtLimitApprovalDO> pageList(@Param("params") Map<String, Object> params);

}

