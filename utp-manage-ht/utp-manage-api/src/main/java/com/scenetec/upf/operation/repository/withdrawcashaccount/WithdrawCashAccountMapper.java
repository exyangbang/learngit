package com.scenetec.upf.operation.repository.withdrawcashaccount;

import com.scenetec.upf.operation.model.domain.withdrawcashaccount.WithdrawCashAccountDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/03/14
 */
@Repository
@Mapper
public interface WithdrawCashAccountMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_withdraw_cash_account  (id,user_create,gmt_create,user_modified,gmt_modified,account_no,account_name,industry_id,payee_opbk,status,fund_account,op_bank_code,op_bank_name) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{accountNo},#{accountName},#{industryId},#{payeeOpbk},#{status},#{fundAccount},#{opBankCode},#{opBankName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(WithdrawCashAccountDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_withdraw_cash_account  ("
        +" user_create, gmt_create, user_modified, gmt_modified, account_no, account_name, industry_id, payee_opbk, status, fund_account"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accountNo}, #{item.accountName}, #{item.industryId}, #{item.payeeOpbk}, #{item.status}, #{item.fundAccount})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<WithdrawCashAccountDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_withdraw_cash_account  ("
        +" user_create, gmt_create, user_modified, gmt_modified, account_no, account_name, industry_id, payee_opbk, status, fund_account"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accountNo}, #{item.accountName}, #{item.industryId}, #{item.payeeOpbk}, #{item.status}, #{item.fundAccount})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"account_no = VALUES(account_no),"
            +"account_name = VALUES(account_name),"
            +"industry_id = VALUES(industry_id),"
            +"payee_opbk = VALUES(payee_opbk),"
            +"status = VALUES(status),"
            +"fund_account = VALUES(fund_account)"
        +"</script>"
    )
    int modifyList(List<WithdrawCashAccountDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_withdraw_cash_account  where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_withdraw_cash_account  <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo}, </if> "
            +"<if test='accountName != null'> account_name = #{accountName}, </if> "
            +"<if test='industryId != null'> industry_id = #{industryId}, </if> "
            +"<if test='payeeOpbk != null'> payee_opbk = #{payeeOpbk}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
            +"<if test='fundAccount != null'> fund_account = #{fundAccount}, </if> "
            +"<if test='opBankCode != null'> op_bank_code = #{opBankCode}, </if> "
            +"<if test='opBankName != null'> op_bank_name = #{opBankName}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(WithdrawCashAccountDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,account_no,account_name,industry_id,payee_opbk,status,fund_account,op_bank_code,op_bank_name from t_withdraw_cash_account  where id = #{id}")
 	@Results(id="WithdrawCashAccountResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "accountNo", column = "account_no"),@Result(property = "accountName", column = "account_name"),@Result(property = "industryId", column = "industry_id"),@Result(property = "payeeOpbk", column = "payee_opbk"),@Result(property = "status", column = "status"),@Result(property = "fundAccount", column = "fund_account"),@Result(property = "opBankCode", column = "op_bank_code"),@Result(property = "opBankName", column = "op_bank_name")})
 	WithdrawCashAccountDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,account_no,account_name,industry_id,payee_opbk,status,fund_account from t_withdraw_cash_account  where 1 = 1"
		        + "<if test='params.accountNo != null'> and account_no = #{params.accountNo}</if>"
        + "</script>"
    )
    @ResultMap("WithdrawCashAccountResultMap")
    Page<WithdrawCashAccountDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_withdraw_cash_account  <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='payeeOpbk != null'> payee_opbk = #{payeeOpbk} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(WithdrawCashAccountDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select * from t_withdraw_cash_account "
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='payeeOpbk != null'> payee_opbk = #{payeeOpbk} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("WithdrawCashAccountResultMap")
    WithdrawCashAccountDO selectOne(WithdrawCashAccountDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select * from t_withdraw_cash_account "
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
            +"<if test='payeeOpbk != null'> payee_opbk = #{payeeOpbk} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("WithdrawCashAccountResultMap")
    List<WithdrawCashAccountDO> selectList(WithdrawCashAccountDO obj);


    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_withdraw_cash_account  <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    +"<if test='industryId != null'> industry_id = #{industryId} AND </if> "
                    +"<if test='payeeOpbk != null'> payee_opbk = #{payeeOpbk} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    +"<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
                    +"<if test='id != null'> id != #{id} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int countExclusive(WithdrawCashAccountDO obj);

    /**
     * 查询列表(分页) listpage
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select * from t_withdraw_cash_account  where 1 = 1"
                    + "<if test='params.accountNo != null'> and account_no = #{params.accountNo}</if>"
                    +"<if test='params.userCreate != null'>and user_create = #{params.userCreate} </if> "
                    +"<if test='params.gmtCreate != null'>and gmt_create = #{params.gmtCreate} </if> "
                    +"<if test='params.userModified != null'>and user_modified = #{params.userModified} </if> "
                    +"<if test='params.gmtModified != null'>and gmt_modified = #{params.gmtModified} </if> "
                    +"<if test='params.accountName != null'>and account_name = #{params.accountName} </if> "
                    +"<if test='params.industryId != null'>and industry_id = #{params.industryId} </if> "
                    +"<if test='params.payeeOpbk != null'>and payee_opbk = #{params.payeeOpbk} </if> "
                    +"<if test='params.status != null'>and status = #{params.status} </if> "
                    +"<if test='params.fundAccount != null'>and fund_account = #{fundAccount} </if> "
                        +"order by gmt_modified desc"
                    + "</script>"
    )
    @ResultMap("WithdrawCashAccountResultMap")
    Page<WithdrawCashAccountDO> listPage(@Param("params") Map<String, Object> params);


    /**
     * 逻辑删除
     * @param
     * @return
     */
    @Update(
            "<script>"
                    +"update t_withdraw_cash_account set status = 0 where id = #{id}"
                    +"</script>"
    )
    int delteId(Long userId);
}

