package com.scenetec.upf.operation.repository.industryamtlimit;

import com.scenetec.upf.operation.model.domain.industryamtlimit.SubaccountsAmtLimitDO;
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
public interface SubaccountsAmtLimitMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_subaccounts_amt_limit (id,user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{industryCode},#{industryId},#{subObjName},#{subAccount},#{subaccountsIndividualAmt},#{subaccountsDateAmt},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(SubaccountsAmtLimitDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_subaccounts_amt_limit ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, industry_id, sub_obj_name, sub_account, subaccounts_individual_amt, subaccounts_date_amt, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.industryId}, #{item.subObjName}, #{item.subAccount}, #{item.subaccountsIndividualAmt}, #{item.subaccountsDateAmt}, #{item.remark})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<SubaccountsAmtLimitDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_subaccounts_amt_limit ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, industry_id, sub_obj_name, sub_account, subaccounts_individual_amt, subaccounts_date_amt, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.industryId}, #{item.subObjName}, #{item.subAccount}, #{item.subaccountsIndividualAmt}, #{item.subaccountsDateAmt}, #{item.remark})"
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
            +"remark = VALUES(remark)"
        +"</script>"
    )
    int modifyList(List<SubaccountsAmtLimitDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_subaccounts_amt_limit where id = #{id}")
    int delete(Long userId);

    @Delete("delete from t_subaccounts_amt_limit where sub_account = #{subAccount} and industry_code = #{industryCode}")
    int deleteBysubAccount(String subAccount,String industryCode);
    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_subaccounts_amt_limit <set> "
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
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(SubaccountsAmtLimitDO obj);

    @Update(
            "<script>"
                    +"update t_subaccounts_amt_limit <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
//                    +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
//                    +"<if test='industryId != null'> industry_id = #{industryId}, </if> "
                    +"<if test='subObjName != null'> sub_obj_name = #{subObjName}, </if> "
                    +"<if test='subaccountsIndividualAmt != null'> subaccounts_individual_amt = #{subaccountsIndividualAmt}, </if> "
                    +"<if test='subaccountsDateAmt != null'> subaccounts_date_amt = #{subaccountsDateAmt}, </if> "
                    +"<if test='remark != null'> remark = #{remark}, </if> "
                    +"</set> where sub_account = #{subAccount}"
                    +"</script>"
    )
    int updateBysubAccount(SubaccountsAmtLimitDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark from t_subaccounts_amt_limit where id = #{id}")
 	@Results(id="SubaccountsAmtLimitResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryId", column = "industry_id"),@Result(property = "subObjName", column = "sub_obj_name"),@Result(property = "subAccount", column = "sub_account"),@Result(property = "subaccountsIndividualAmt", column = "subaccounts_individual_amt"),@Result(property = "subaccountsDateAmt", column = "subaccounts_date_amt"),@Result(property = "remark", column = "remark")})
 	SubaccountsAmtLimitDO getById(@Param("id") Long id);


    @Select("select id from t_subaccounts_amt_limit where sub_account = #{subAccount} and industry_code = #{industryCode}")
    SubaccountsAmtLimitDO getByIdSubAccount(@Param("subAccount") String subAccount,@Param("industryCode") String industryCode);
    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark from t_subaccounts_amt_limit where 1 = 1"
        + "</script>"
    )
    @ResultMap("SubaccountsAmtLimitResultMap")
    Page<SubaccountsAmtLimitDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_subaccounts_amt_limit <where> <trim suffixOverrides='AND'>"
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
        +"</trim></where> "
        +"</script>"
    )
    int count(SubaccountsAmtLimitDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark from t_subaccounts_amt_limit"
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
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SubaccountsAmtLimitResultMap")
    SubaccountsAmtLimitDO selectOne(SubaccountsAmtLimitDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,industry_id,sub_obj_name,sub_account,subaccounts_individual_amt,subaccounts_date_amt,remark from t_subaccounts_amt_limit"
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
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SubaccountsAmtLimitResultMap")
    List<SubaccountsAmtLimitDO> selectList(SubaccountsAmtLimitDO obj);



    /**
     * 查询条件：客户名称(输入框，模糊查询)、 客户号(输入框，全匹配查询)、子账户名称(输入框，模糊查询)、子账户账号(输入框，全匹配查询)
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select sb.*,(select audit_status from t_subaccounts_amt_limit_approval ap where ap.industry_code=sb.industry_code and ap.sub_account=sb.sub_account order by  gmt_modified desc limit 1) as auditStatus,(select id from t_subaccounts_amt_limit_approval ap where ap.industry_code=sb.industry_code and ap.sub_account=sb.sub_account order by  gmt_modified desc limit 1) as approvalId,ind.name as name from t_subaccounts_amt_limit sb left join t_industry ind on ind.id=sb.industry_id  where 1 = 1"
                    + "<if test='params.name != null'> and ind.name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.subObjName != null'> and sb.sub_obj_name like concat('%',#{params.subObjName},'%')</if>"
                    +"<if test='params.industryCode != null'>and sb.industry_code = #{params.industryCode}  </if> "
                    + "<if test='params.subAccount != null'> and sb.sub_account = #{params.subAccount}</if>"
                    +"order by gmt_modified desc"
                    + "</script>"
    )
    @ResultMap("SubaccountsAmtLimitResultMap")
    Page<SubaccountsAmtLimitDO> pageList(@Param("params") Map<String, Object> params);

}

