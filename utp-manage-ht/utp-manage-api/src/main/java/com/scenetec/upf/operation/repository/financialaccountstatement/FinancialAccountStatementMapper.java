package com.scenetec.upf.operation.repository.financialaccountstatement;

import com.scenetec.upf.operation.model.domain.financialaccountstatement.FinancialAccountStatementDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/02/14
 */
@Repository
@Mapper
public interface FinancialAccountStatementMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_financial_account_statement (id,user_create,gmt_create,user_modified,gmt_modified,account_no,mer_name,industry_code,industry_name,in_total_amount,out_total_amount,current_account_balance,trans_date) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{accountNo},#{merName},#{industryCode},#{industryName},#{inTotalAmount},#{outTotalAmount},#{currentAccountBalance},#{transDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(FinancialAccountStatementDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_financial_account_statement ("
        +" user_create, gmt_create, user_modified, gmt_modified, account_no, mer_name, industry_code, industry_name, in_total_amount, out_total_amount, current_account_balance, trans_date"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accountNo}, #{item.merName}, #{item.industryCode}, #{item.industryName}, #{item.inTotalAmount}, #{item.outTotalAmount}, #{item.currentAccountBalance}, #{item.transDate})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<FinancialAccountStatementDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_financial_account_statement ("
        +" user_create, gmt_create, user_modified, gmt_modified, account_no, mer_name, industry_code, industry_name, in_total_amount, out_total_amount, current_account_balance, trans_date"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accountNo}, #{item.merName}, #{item.industryCode}, #{item.industryName}, #{item.inTotalAmount}, #{item.outTotalAmount}, #{item.currentAccountBalance}, #{item.transDate})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"account_no = VALUES(account_no),"
            +"mer_name = VALUES(mer_name),"
            +"industry_code = VALUES(industry_code),"
            +"industry_name = VALUES(industry_name),"
            +"in_total_amount = VALUES(in_total_amount),"
            +"out_total_amount = VALUES(out_total_amount),"
            +"current_account_balance = VALUES(current_account_balance),"
            +"trans_date = VALUES(trans_date)"
        +"</script>"
    )
    int modifyList(List<FinancialAccountStatementDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_financial_account_statement where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_financial_account_statement <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo}, </if> "
            +"<if test='merName != null'> mer_name = #{merName}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='industryName != null'> industry_name = #{industryName}, </if> "
            +"<if test='inTotalAmount != null'> in_total_amount = #{inTotalAmount}, </if> "
            +"<if test='outTotalAmount != null'> out_total_amount = #{outTotalAmount}, </if> "
            +"<if test='currentAccountBalance != null'> current_account_balance = #{currentAccountBalance}, </if> "
            +"<if test='transDate != null'> trans_date = #{transDate}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(FinancialAccountStatementDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,account_no,mer_name,industry_code,industry_name,in_total_amount,out_total_amount,current_account_balance,trans_date from t_financial_account_statement where id = #{id}")
 	@Results(id="FinancialAccountStatementResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "accountNo", column = "account_no"),@Result(property = "merName", column = "mer_name"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryName", column = "industry_name"),@Result(property = "inTotalAmount", column = "in_total_amount"),@Result(property = "outTotalAmount", column = "out_total_amount"),@Result(property = "currentAccountBalance", column = "current_account_balance"),@Result(property = "transDate", column = "trans_date")})
 	FinancialAccountStatementDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,account_no,mer_name,industry_code,industry_name,in_total_amount,out_total_amount,current_account_balance,trans_date from t_financial_account_statement where 1 = 1"
        + "</script>"
    )
    @ResultMap("FinancialAccountStatementResultMap")
    Page<FinancialAccountStatementDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_financial_account_statement <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='merName != null'> mer_name = #{merName} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
            +"<if test='inTotalAmount != null'> in_total_amount = #{inTotalAmount} AND </if> "
            +"<if test='outTotalAmount != null'> out_total_amount = #{outTotalAmount} AND </if> "
            +"<if test='currentAccountBalance != null'> current_account_balance = #{currentAccountBalance} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(FinancialAccountStatementDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account_no,mer_name,industry_code,industry_name,in_total_amount,out_total_amount,current_account_balance,trans_date from t_financial_account_statement"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='merName != null'> mer_name = #{merName} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
            +"<if test='inTotalAmount != null'> in_total_amount = #{inTotalAmount} AND </if> "
            +"<if test='outTotalAmount != null'> out_total_amount = #{outTotalAmount} AND </if> "
            +"<if test='currentAccountBalance != null'> current_account_balance = #{currentAccountBalance} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FinancialAccountStatementResultMap")
    FinancialAccountStatementDO selectOne(FinancialAccountStatementDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account_no,mer_name,industry_code,industry_name,in_total_amount,out_total_amount,current_account_balance,trans_date from t_financial_account_statement"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='merName != null'> mer_name = #{merName} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
            +"<if test='inTotalAmount != null'> in_total_amount = #{inTotalAmount} AND </if> "
            +"<if test='outTotalAmount != null'> out_total_amount = #{outTotalAmount} AND </if> "
            +"<if test='currentAccountBalance != null'> current_account_balance = #{currentAccountBalance} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FinancialAccountStatementResultMap")
    List<FinancialAccountStatementDO> selectList(FinancialAccountStatementDO obj);
    /**
     * 通过条件查询多条记录(不分页)
     * @param
     * @return
     */
    @Select(
            "<script>"
                    +"select id, user_create,gmt_create,user_modified,gmt_modified,account_no,mer_name,industry_code,industry_name,in_total_amount,out_total_amount,current_account_balance,trans_date from t_financial_account_statement where 1=1"

                    + "<if test='params.transBeginDate != null'> and trans_date &gt;= #{params.transBeginDate} </if>"
                    + "<if test='params.transEndDate != null'>and trans_date &lt;= #{params.transEndDate}</if>"

                    +"<if test='params.accountNo != null'>and account_no = #{params.accountNo} </if> "
                    +"<if test='params.merName != null'>and mer_name like concat('%',#{params.merName},'%') </if> "
                    +"<if test='params.industryCode != null'>and industry_code = #{params.industryCode} </if> "
                    +"<if test='params.industryName != null'>and industry_name like concat('%',#{params.industryName},'%')</if> "
                    +"<if test='params.inTotalAmount != null'>and in_total_amount = #{params.inTotalAmount} </if> "
                    +"<if test='params.outTotalAmount != null'>and out_total_amount = #{params.outTotalAmount}</if> "
                    +"<if test='params.currentAccountBalance != null'>and current_account_balance = #{params.currentAccountBalance} </if> "
                    +"order by id desc"
                    +"</script>"
    )
    @ResultMap("FinancialAccountStatementResultMap")
    List<FinancialAccountStatementDO> listPage(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"
                    +"select count(1) totalCount,IFNULL(sum(in_total_amount) ,0) inTotalAmount,IFNULL(sum(out_total_amount),0) outTotalAmount,IFNULL(sum(current_account_balance),0) currentAccountBalance from t_financial_account_statement where 1=1"

                    + "<if test='params.transBeginDate != null'> and trans_date &gt;= #{params.transBeginDate} </if>"
                    + "<if test='params.transEndDate != null'>and trans_date &lt;= #{params.transEndDate}</if>"

                    +"<if test='params.accountNo != null'>and account_no = #{params.accountNo} </if> "
                    +"<if test='params.merName != null'>and mer_name like concat('%',#{params.merName},'%') </if> "
                    +"<if test='params.industryCode != null'>and industry_code = #{params.industryCode} </if> "
                    +"<if test='params.industryName != null'>and industry_name like concat('%',#{params.industryName},'%')</if> "
                    +"<if test='params.inTotalAmount != null'>and in_total_amount = #{params.inTotalAmount} </if> "
                    +"<if test='params.outTotalAmount != null'>and out_total_amount = #{params.outTotalAmount}</if> "
                    +"<if test='params.currentAccountBalance != null'>and current_account_balance = #{params.currentAccountBalance} </if> "

                    +"</script>"
    )
    Map<String,Long> countTrans(@Param("params") Map<String, Object> params);
}

