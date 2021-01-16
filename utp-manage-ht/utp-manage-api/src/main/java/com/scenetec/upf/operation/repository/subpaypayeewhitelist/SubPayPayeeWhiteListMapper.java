package com.scenetec.upf.operation.repository.subpaypayeewhitelist;

import com.scenetec.upf.operation.model.domain.subpaypayeewhitelist.SubPayPayeeWhiteListDO;
import com.scenetec.upf.operation.model.domain.whitelist.WhiteListDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2020/05/07
 */
@Repository
@Mapper
public interface SubPayPayeeWhiteListMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_sub_pay_payee_white_list (id,user_create,gmt_create,user_modified,gmt_modified,payee_account,payee_name,industry_id) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{payeeAccount},#{payeeName},#{industryId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(SubPayPayeeWhiteListDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_sub_pay_payee_white_list ("
        +" user_create, gmt_create, user_modified, gmt_modified, payee_account, payee_name, industry_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.payeeAccount}, #{item.payeeName}, #{item.industryId})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<SubPayPayeeWhiteListDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_sub_pay_payee_white_list ("
        +" user_create, gmt_create, user_modified, gmt_modified, payee_account, payee_name, industry_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.payeeAccount}, #{item.payeeName}, #{item.industryId})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"payee_account = VALUES(payee_account),"
            +"payee_name = VALUES(payee_name),"
            +"industry_id = VALUES(industry_id)"
        +"</script>"
    )
    int modifyList(List<SubPayPayeeWhiteListDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_sub_pay_payee_white_list where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_sub_pay_payee_white_list <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='payeeAccount != null'> payee_account = #{payeeAccount}, </if> "
            +"<if test='payeeName != null'> payee_name = #{payeeName}, </if> "
            +"<if test='industryId != null'> industry_id = #{industryId}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(SubPayPayeeWhiteListDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,payee_account,payee_name,industry_id from t_sub_pay_payee_white_list where id = #{id}")
 	@Results(id="SubPayPayeeWhiteListResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "payeeAccount", column = "payee_account"),@Result(property = "payeeName", column = "payee_name"),@Result(property = "industryId", column = "industry_id")})
 	SubPayPayeeWhiteListDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,payee_account,payee_name,industry_id from t_sub_pay_payee_white_list where 1 = 1"
        + "</script>"
    )
    @ResultMap("SubPayPayeeWhiteListResultMap")
    Page<SubPayPayeeWhiteListDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_sub_pay_payee_white_list <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='payeeAccount != null'> payee_account = #{payeeAccount} AND </if> "
            +"<if test='payeeName != null'> payee_name = #{payeeName} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(SubPayPayeeWhiteListDO obj);

    @Select(
            "<script>"
                    +"select count(*) from t_sub_pay_payee_white_list <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='payeeAccount != null'> payee_account = #{payeeAccount} AND </if> "
                    +"<if test='payeeName != null'> payee_name = #{payeeName} AND </if> "
                    +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
                    +"<if test='id != null'> id not in(#{id}) AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int countExSelf(SubPayPayeeWhiteListDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,payee_account,payee_name,industry_id from t_sub_pay_payee_white_list"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='payeeAccount != null'> payee_account = #{payeeAccount} AND </if> "
            +"<if test='payeeName != null'> payee_name = #{payeeName} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SubPayPayeeWhiteListResultMap")
    SubPayPayeeWhiteListDO selectOne(SubPayPayeeWhiteListDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,payee_account,payee_name,industry_id from t_sub_pay_payee_white_list"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='payeeAccount != null'> payee_account = #{payeeAccount} AND </if> "
            +"<if test='payeeName != null'> payee_name = #{payeeName} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SubPayPayeeWhiteListResultMap")
    List<SubPayPayeeWhiteListDO> selectList(SubPayPayeeWhiteListDO obj);

    /**
     * 查询列表(分页)  条件查询
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    +"select * from t_sub_pay_payee_white_list "
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='params.payeeAccount != null'> payee_account like concat('%', #{params.payeeAccount} ,'%') AND </if> "
                    +"<if test='params.payeeName != null'> payee_name like concat('%', #{params.payeeName},'%') AND </if> "
                    +"<if test='params.industryId != null'> industry_id = #{params.industryId} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("SubPayPayeeWhiteListResultMap")
    Page<SubPayPayeeWhiteListDO> listPage(@Param("params") Map<String, Object> params);

    @Update("${sql}")
    void runSql(@Param("sql") String sql);

}

