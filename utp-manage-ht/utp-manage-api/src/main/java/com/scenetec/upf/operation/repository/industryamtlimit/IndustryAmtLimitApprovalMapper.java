package com.scenetec.upf.operation.repository.industryamtlimit;

import com.scenetec.upf.operation.model.domain.industryamtlimit.IndustryAmtLimitApprovalDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/07/29
 */
@Repository
@Mapper
public interface IndustryAmtLimitApprovalMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_industry_amt_limit_approval (id,user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,industry_name,public_individual_amt,private_individual_amt,unit_individual_amt,industry_date_amt,subaccounts_date_amt,remark,audit_status,operation_type,same_order_max_spe_amt,same_cash_max_amt,minute_max_cash_tran_amt,public_subaccounts_date_amt,industry_balance_date_amt,private_subaccounts_balance_date_amt,public_subaccounts_balance_date_amt) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{industryCode},#{industryId},#{industryName},#{publicIndividualAmt},#{privateIndividualAmt},#{unitIndividualAmt},#{industryDateAmt},#{subaccountsDateAmt},#{remark},#{auditStatus},#{operationType},#{sameOrderMaxSpeAmt},#{sameCashMaxAmt},#{minuteMaxCashTranAmt},#{publicSubaccountsDateAmt},#{industryBalanceDateAmt},#{privateSubaccountsBalanceDateAmt},#{publicSubaccountsBalanceDateAmt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(IndustryAmtLimitApprovalDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_industry_amt_limit_approval ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, industry_id, industry_name, public_individual_amt, private_individual_amt, unit_individual_amt, industry_date_amt, subaccounts_date_amt, remark, audit_status, operation_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.industryId}, #{item.industryName}, #{item.publicIndividualAmt}, #{item.privateIndividualAmt}, #{item.unitIndividualAmt}, #{item.industryDateAmt}, #{item.subaccountsDateAmt}, #{item.remark}, #{item.auditStatus}, #{item.operationType})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<IndustryAmtLimitApprovalDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_industry_amt_limit_approval ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, industry_id, industry_name, public_individual_amt, private_individual_amt, unit_individual_amt, industry_date_amt, subaccounts_date_amt, remark, audit_status, operation_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.industryId}, #{item.industryName}, #{item.publicIndividualAmt}, #{item.privateIndividualAmt}, #{item.unitIndividualAmt}, #{item.industryDateAmt}, #{item.subaccountsDateAmt}, #{item.remark}, #{item.auditStatus}, #{item.operationType})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"industry_code = VALUES(industry_code),"
            +"industry_id = VALUES(industry_id),"
            +"industry_name = VALUES(industry_name),"
            +"public_individual_amt = VALUES(public_individual_amt),"
            +"private_individual_amt = VALUES(private_individual_amt),"
            +"unit_individual_amt = VALUES(unit_individual_amt),"
            +"industry_date_amt = VALUES(industry_date_amt),"
            +"subaccounts_date_amt = VALUES(subaccounts_date_amt),"
            +"remark = VALUES(remark),"
            +"audit_status = VALUES(audit_status),"
            +"operation_type = VALUES(operation_type)"
        +"</script>"
    )
    int modifyList(List<IndustryAmtLimitApprovalDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_industry_amt_limit_approval where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_industry_amt_limit_approval <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='industryId != null'> industry_id = #{industryId}, </if> "
            +"<if test='industryName != null'> industry_name = #{industryName}, </if> "
            +"<if test='publicIndividualAmt != null'> public_individual_amt = #{publicIndividualAmt}, </if> "
            +"<if test='privateIndividualAmt != null'> private_individual_amt = #{privateIndividualAmt}, </if> "
            +"<if test='unitIndividualAmt != null'> unit_individual_amt = #{unitIndividualAmt}, </if> "
            +"<if test='industryDateAmt != null'> industry_date_amt = #{industryDateAmt}, </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
            +"<if test='operationType != null'> operation_type = #{operationType}, </if> "
            +"<if test='sameOrderMaxSpeAmt != null'> same_order_max_spe_amt = #{sameOrderMaxSpeAmt}, </if> "
            +"<if test='sameCashMaxAmt != null'> same_cash_max_amt = #{sameCashMaxAmt}, </if> "
            +"<if test='minuteMaxCashTranAmt != null'> minute_max_cash_tran_amt = #{minuteMaxCashTranAmt}, </if> "

        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(IndustryAmtLimitApprovalDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select * from t_industry_amt_limit_approval where  id = #{id}")
 	@Results(id="IndustryAmtLimitApprovalResultMap",
            value = {@Result(property = "id", column = "id"),
                    @Result(property = "userCreate", column = "user_create"),
                    @Result(property = "gmtCreate", column = "gmt_create"),
                    @Result(property = "userModified", column = "user_modified"),
                    @Result(property = "gmtModified", column = "gmt_modified"),
                    @Result(property = "industryCode", column = "industry_code"),
                    @Result(property = "industryId", column = "industry_id"),
                    @Result(property = "industryName", column = "industry_name"),
                    @Result(property = "publicIndividualAmt", column = "public_individual_amt"),
                    @Result(property = "privateIndividualAmt", column = "private_individual_amt"),
                    @Result(property = "unitIndividualAmt", column = "unit_individual_amt"),
                    @Result(property = "industryDateAmt", column = "industry_date_amt"),
                    @Result(property = "subaccountsDateAmt", column = "subaccounts_date_amt"),
                    @Result(property = "remark", column = "remark"),
                    @Result(property = "auditStatus", column = "audit_status"),
                    @Result(property = "operationType", column = "operation_type"),
                    @Result(property = "sameOrderMaxSpeAmt", column = "same_order_max_spe_amt"),
                    @Result(property = "sameCashMaxAmt", column = "same_cash_max_amt"),
                    @Result(property = "minuteMaxCashTranAmt", column = "minute_max_cash_tran_amt"),
                    @Result(property = "publicSubaccountsDateAmt", column = "public_subaccounts_date_amt"),
                    @Result(property = "industryBalanceDateAmt", column = "industry_balance_date_amt"),
                    @Result(property = "privateSubaccountsBalanceDateAmt", column = "private_subaccounts_balance_date_amt"),
                    @Result(property = "publicSubaccountsBalanceDateAmt", column = "public_subaccounts_balance_date_amt")
 	})
 	IndustryAmtLimitApprovalDO getById(@Param("id") Long id);


    @Select("select id from t_industry_amt_limit_approval where industry_code = #{industryCode}")
    IndustryAmtLimitApprovalDO getByCode(@Param("industryCode") String industryCode);
    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,industry_name,public_individual_amt,private_individual_amt,unit_individual_amt,industry_date_amt,subaccounts_date_amt,remark,audit_status,operation_type from t_industry_amt_limit_approval where 1 = 1"
        + "</script>"
    )
    @ResultMap("IndustryAmtLimitApprovalResultMap")
    Page<IndustryAmtLimitApprovalDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_industry_amt_limit_approval <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
            +"<if test='publicIndividualAmt != null'> public_individual_amt = #{publicIndividualAmt} AND </if> "
            +"<if test='privateIndividualAmt != null'> private_individual_amt = #{privateIndividualAmt} AND </if> "
            +"<if test='unitIndividualAmt != null'> unit_individual_amt = #{unitIndividualAmt} AND </if> "
            +"<if test='industryDateAmt != null'> industry_date_amt = #{industryDateAmt} AND </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(IndustryAmtLimitApprovalDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,industry_name,public_individual_amt,private_individual_amt,unit_individual_amt,industry_date_amt,subaccounts_date_amt,remark,audit_status,operation_type from t_industry_amt_limit_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
            +"<if test='publicIndividualAmt != null'> public_individual_amt = #{publicIndividualAmt} AND </if> "
            +"<if test='privateIndividualAmt != null'> private_individual_amt = #{privateIndividualAmt} AND </if> "
            +"<if test='unitIndividualAmt != null'> unit_individual_amt = #{unitIndividualAmt} AND </if> "
            +"<if test='industryDateAmt != null'> industry_date_amt = #{industryDateAmt} AND </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("IndustryAmtLimitApprovalResultMap")
    IndustryAmtLimitApprovalDO selectOne(IndustryAmtLimitApprovalDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,industry_name,public_individual_amt,private_individual_amt,unit_individual_amt,industry_date_amt,subaccounts_date_amt,remark,audit_status,operation_type from t_industry_amt_limit_approval"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
            +"<if test='publicIndividualAmt != null'> public_individual_amt = #{publicIndividualAmt} AND </if> "
            +"<if test='privateIndividualAmt != null'> private_individual_amt = #{privateIndividualAmt} AND </if> "
            +"<if test='unitIndividualAmt != null'> unit_individual_amt = #{unitIndividualAmt} AND </if> "
            +"<if test='industryDateAmt != null'> industry_date_amt = #{industryDateAmt} AND </if> "
            +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
            +"<if test='operationType != null'> operation_type = #{operationType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("IndustryAmtLimitApprovalResultMap")
    List<IndustryAmtLimitApprovalDO> selectList(IndustryAmtLimitApprovalDO obj);
    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select * from  t_industry_amt_limit_approval  where 1 = 1"
                    + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.subObjName != null'> and sub_obj_name like concat('%',#{params.subObjName},'%')</if>"
                    +"<if test='params.industryCode != null'>and industry_code = #{params.industryCode}  </if> "
                    + "<if test='params.subAccount != null'> and sub_account = #{params.subAccount}</if>"
                    + "<if test='params.operationType != null'> and operation_type = #{params.operationType}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.industryName != null'> and industry_name like concat('%',#{params.industryName},'%')</if>"
                    + "<if test='params.transBeginDate != null'> and gmt_create &gt;= #{params.transBeginDate}</if>"
                    + "<if test='params.transEndDate != null'> and gmt_create &lt;= #{params.transEndDate}</if>"
                    +"order by gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryAmtLimitApprovalResultMap")
    Page<IndustryAmtLimitApprovalDO> pageList(@Param("params") Map<String, Object> params);



    @Select(
            "<script>"
                    + "select * from t_industry_amt_limit_approval  where 1 = 1"
                    +"<if test='params.industryName != null'>and industry_name = concat('%',#{params.industryName},'%')  </if> "
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.operationType != null'> and operation_type = #{params.operationType}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.transBeginDate != null'> and gmt_create &gt;= #{params.transBeginDate}</if>"
                    + "<if test='params.transEndDate != null'> and gmt_create &lt;= #{params.transEndDate}</if>"
                    +"order by gmt_modified desc limit 1"
                    + "</script>"
    )
    @ResultMap("IndustryAmtLimitApprovalResultMap")
    IndustryAmtLimitApprovalDO selectByindLimit(@Param("params") Map<String, Object> params);



}

