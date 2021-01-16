package com.scenetec.upf.operation.repository.industry;

import com.scenetec.upf.operation.model.domain.industry.IndustryAccountInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/11/06
 */
@Repository
@Mapper
public interface IndustryAccountInfoMapper {


    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_industry_account_info (id,user_create,gmt_create,user_modified,gmt_modified,industry_code,account_no,account_name,bank_code,bank_name,industry_type) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{industryCode},#{accountNo},#{accountName},#{bankCode},#{bankName},#{industryType})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(IndustryAccountInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    +"insert into t_industry_account_info ("
                    +" user_create, gmt_create, user_modified, gmt_modified, industry_code, account_no, account_name, bank_code, bank_name, industry_type"
                    +") values "
                    +"<foreach collection='list' item='item' index='index' separator=','>"
                    +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.accountNo}, #{item.accountName}, #{item.bankCode}, #{item.bankName}, #{item.industryType})"
                    +"</foreach>"
                    +"</script>"
    )
    int insertList(List<IndustryAccountInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    +"insert into t_industry_account_info ("
                    +" user_create, gmt_create, user_modified, gmt_modified, industry_code, account_no, account_name, bank_code, bank_name, industry_type"
                    +") values "
                    +"<foreach collection='list' item='item' index='index' separator=','>"
                    +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.accountNo}, #{item.accountName}, #{item.bankCode}, #{item.bankName}, #{item.industryType})"
                    +"</foreach>"
                    +" ON DUPLICATE KEY UPDATE "
                    +"user_create = VALUES(user_create),"
                    +"gmt_create = VALUES(gmt_create),"
                    +"user_modified = VALUES(user_modified),"
                    +"gmt_modified = VALUES(gmt_modified),"
                    +"industry_code = VALUES(industry_code),"
                    +"account_no = VALUES(account_no),"
                    +"account_name = VALUES(account_name),"
                    +"bank_code = VALUES(bank_code),"
                    +"bank_name = VALUES(bank_name),"
                    +"industry_type = VALUES(industry_type)"
                    +"</script>"
    )
    int modifyList(List<IndustryAccountInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_industry_account_info where id = #{id}")
    int delete(Long userId);

    /**
     * 删除
     * @param code
     * @return
     */
    @Delete("delete from t_industry_account_info where industry_code = #{code} and industry_type = #{industryType}")
    int deleteByIndustryCode(String code,String industryType);
    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @Delete("update t_industry_account_info set status=0 where id = #{id}")
    int deleteLogic(Long id);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    +"update t_industry_account_info <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
                    +"<if test='accountNo != null'> account_no = #{accountNo}, </if> "
                    +"<if test='accountName != null'> account_name = #{accountName}, </if> "
                    +"<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
                    +"<if test='bankName != null'> bank_name = #{bankName}, </if> "
                    /* +"<if test='industryType != null'> industry_type = #{industryType}, </if> "*/
                    +"</set> where id = #{id}"
                    +"</script>"
    )
    int update(IndustryAccountInfoDO obj);


    /**
     * 查询详细
     * @param id
     * @return
     */
    @Select("select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,account_no,account_name,bank_code,bank_name,industry_type from t_industry_account_info where id = #{id}")
    @Results(id="IndustryFeeAccountInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "accountNo", column = "account_no"),@Result(property = "accountName", column = "account_name"),@Result(property = "bankCode", column = "bank_code"),@Result(property = "bankName", column = "bank_name"),@Result(property = "industryType", column = "industry_type")})
    IndustryAccountInfoDO getById(@Param("id") Long id);


    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,account_no,account_name,bank_code,bank_name,industry_type from t_industry_account_info where 1 = 1"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>" +
                    "<if test='params.industryType != null'> and industry_type = #{params.industryType}</if>"
                    + "</script>"
    )
    @ResultMap("IndustryFeeAccountInfoResultMap")
    Page<IndustryAccountInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,account_no,account_name,bank_code,bank_name,industry_type from t_industry_account_info where 1 = 1"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>" +
                    "<if test='params.industryType != null'> and industry_type = #{params.industryType}</if>"
                    + "</script>"
    )
    @ResultMap("IndustryFeeAccountInfoResultMap")
    Page<IndustryAccountInfoDO> pageList(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_industry_account_info <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    +"<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int count(IndustryAccountInfoDO obj);
    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_industry_account_info <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    +"<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    +"<if test='id != null and id>0'> id != #{id} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int countById(IndustryAccountInfoDO obj);
    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,account_no,account_name,bank_code,bank_name,industry_type from t_industry_account_info"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='id != null and id>0'> id = #{id} AND </if>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    +"<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("IndustryFeeAccountInfoResultMap")
    IndustryAccountInfoDO selectOne(IndustryAccountInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,account_no,account_name,bank_code,bank_name,industry_type from t_industry_account_info"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    +"<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("IndustryFeeAccountInfoResultMap")
    List<IndustryAccountInfoDO> selectList(IndustryAccountInfoDO obj);


    @Select("<script>"+
            "SELECT  count(ind.fund_account) FROM t_industry_account_info inac " +
            "LEFT JOIN t_industry ind ON ind.CODE = inac.industry_code WHERE inac.account_no = #{accountNo} " +
            "<if test='industryType != null'>and inac.industry_type = #{industryType} </if> " +
            "AND ind.fund_account = #{fundAccount}"
            +"</script>"
    )
    Integer  checkByAccountNo(@Param("fundAccount") String fundAccount,@Param("accountNo") String accountNo,@Param("industryType") String industryType);


//    @Select("SELECT\n" +
//            "count( cust_number ) \n" +
//            "FROM\n" +
//            "t_industry \n" +
//            "WHERE\n" +
//            "CODE = #{industryCode} \n" +
//            "AND cust_number IN ( SELECT cust_number FROM t_industry ti, t_industry_account_info ta WHERE ti.CODE = ta.industry_code AND ta.account_no = #{accountNo} )")
//    Integer checkByAccountNo(@Param("industryCode") String industryCode,@Param("accountNo") String accountNo);

/*    @Select("SELECT COUNT(*) FROM t_fee_account WHERE acc_no in" +
            "(SELECT acc_no FROM t_fee_account WHERE industry_code in\n" +
            "(SELECT industry_code FROM t_industry_account_info WHERE account_no = #{accountNo}))" +
            "AND industry_code = #{industryCode}")

    Integer checkByAccountNoCount(@Param("industryCode") String industryCode,@Param("accountNo") String accountNo);*/
}

