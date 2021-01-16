package com.scenetec.upf.operation.repository.fundaccount;

import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.fundaccount.FundAccountDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;

import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/02/21
 */
@Repository
@Mapper
public interface FundAccountMapper {

    /**
     * 创建
     *
     * @param obj
     * @return
     */
    @Insert("insert into t_fund_account (id,user_create,gmt_create,user_modified,gmt_modified,account_num,bank_code,status,bank_account_no,bank_account_name,synchronization_time,current_balance,account_type,use_type,share_flag,report_aml_flag) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{accountNum},#{bankCode},#{status},#{bankAccountNo},#{bankAccountName},#{synchronizationTime},#{currentBalance},#{accountType},#{useType},#{shareFlag},#{reportAmlFlag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(FundAccountDO obj);

    /**
     * 批量插入
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_fund_account ("
                    + " user_create, gmt_create, user_modified, gmt_modified, account_num, bank_code, status, bank_account_no, bank_account_name, synchronization_time,account_type, current_balance"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accountNum}, #{item.bankCode}, #{item.status}, #{item.bankAccountNo}, #{item.bankAccountName}, #{item.synchronizationTime}, #{item.accountType}, #{item.currentBalance})"
                    + "</foreach>"
                    + "</script>"
    )
    int insertList(List<FundAccountDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_fund_account ("
                    + " user_create, gmt_create, user_modified, gmt_modified, account_num, bank_code, status, bank_account_no, bank_account_name, synchronization_time,account_type, current_balance"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accountNum}, #{item.bankCode}, #{item.status}, #{item.bankAccountNo}, #{item.bankAccountName}, #{item.synchronizationTime}, #{item.accountType}, #{item.currentBalance})"
                    + "</foreach>"
                    + " ON DUPLICATE KEY UPDATE "
                    + "user_create = VALUES(user_create),"
                    + "gmt_create = VALUES(gmt_create),"
                    + "user_modified = VALUES(user_modified),"
                    + "gmt_modified = VALUES(gmt_modified),"
                    + "account_num = VALUES(account_num),"
                    + "bank_code = VALUES(bank_code),"
                    + "status = VALUES(status),"
                    + "bank_account_no = VALUES(bank_account_no),"
                    + "bank_account_name = VALUES(bank_account_name),"
                    + "synchronization_time = VALUES(synchronization_time),"
                    + "current_balance = VALUES(current_balance)"
                    + "</script>"
    )
    int modifyList(List<FundAccountDO> obj);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @Delete("delete from t_fund_account where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_fund_account <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='accountNum != null'> account_num = #{accountNum}, </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo}, </if> "
                    + "<if test='bankAccountName != null'> bank_account_name = #{bankAccountName}, </if> "
                    + "<if test='synchronizationTime != null'> synchronization_time = #{synchronizationTime}, </if> "
                    + "<if test='currentBalance != null'> current_balance = #{currentBalance}, </if> "
                    + "<if test='accountType != null'> account_type = #{accountType}, </if> "
                    + "<if test='useType != null'> use_type = #{useType}, </if> "
                    + "<if test='shareFlag != null'> share_flag = #{shareFlag}, </if> "
                    + "<if test='reportAmlFlag != null'> report_aml_flag = #{reportAmlFlag}, </if> "
                    + "</set> where id = #{id}"
                    + "</script>"
    )
    int update(FundAccountDO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    @Select("select * from t_fund_account where id = #{id} and status=1")
    @Results(id = "FundAccountResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"), @Result(property = "gmtCreate", column = "gmt_create"), @Result(property = "userModified", column = "user_modified"), @Result(property = "gmtModified", column = "gmt_modified"), @Result(property = "accountNum", column = "account_num"), @Result(property = "bankCode", column = "bank_code"), @Result(property = "status", column = "status"), @Result(property = "bankAccountNo", column = "bank_account_no"), @Result(property = "bankAccountName", column = "bank_account_name"), @Result(property = "synchronizationTime", column = "synchronization_time"), @Result(property = "currentBalance", column = "current_balance"), @Result(property = "accountType", column = "account_type"), @Result(property = "useType", column = "use_type"), @Result(property = "shareFlag", column = "share_flag"), @Result(property = "reportAmlFlag", column = "report_aml_flag")})
    FundAccountDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,account_num,bank_code,status,bank_account_no,bank_account_name,synchronization_time,current_balance,account_type from t_fund_account where 1 = 1"
                    + "<if test='params.accountNum != null'> and account_num = #{params.accountNum}</if>"
                    + "<if test='params.bankAccountNo != null'> and bank_account_no = #{params.bankAccountNo}</if>"
                    + "</script>"
    )
    @ResultMap("FundAccountResultMap")
    Page<FundAccountDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id,use_type, user_create,gmt_create,user_modified,gmt_modified,account_num,bank_code,status,bank_account_no,bank_account_name,synchronization_time,current_balance,account_type,share_flag,report_aml_flag from t_fund_account where 1 = 1"
                    + "<if test='params.bankAccountNo != null'> and bank_account_no = #{params.bankAccountNo}</if>"
                    + "<if test='params.status != null'> and status = #{params.status}</if>"
                    + "<if test='params.bankAccountName != null'> and bank_account_name like concat('%',#{params.bankAccountName},'%')</if>"
                    + "<if test='params.useType != null'> and use_type = #{params.useType}</if>"
                    + "<if test='params.reportAmlFlag != null'> and report_aml_flag = #{params.reportAmlFlag}</if>"
                    + "<if test='params.shareFlag != null'> and share_flag = #{params.shareFlag}</if>"
                    + "</script>"
    )
    @ResultMap("FundAccountResultMap")
    Page<FundAccountDO> listPage(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"
                    + "SELECT "
                    + "* "
                    + "FROM "
                    + "t_fund_account "
                    + "WHERE "
                    + "1 = 1 and status = 1 "
                    + "and use_type='1' and bank_account_no not in(select fund_account from t_industry WHERE industry_type='6' ) "
                    + "</script>"
    )
    @ResultMap("FundAccountResultMap")
    Page<FundAccountDO> listPageScreen(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) from t_fund_account <where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='accountNum != null'> account_num = #{accountNum} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo} AND </if> "
                    + "<if test='bankAccountName != null'> bank_account_name = #{bankAccountName} AND </if> "
                    + "<if test='synchronizationTime != null'> synchronization_time = #{synchronizationTime} AND </if> "
                    + "<if test='currentBalance != null'> current_balance = #{currentBalance} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    int count(FundAccountDO obj);

    /**
     * 查询总数 id 中不包含自己
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) from t_fund_account <where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='accountNum != null'> account_num = #{accountNum} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo} AND </if> "
                    + "<if test='bankAccountName != null'> bank_account_name = #{bankAccountName} AND </if> "
                    + "<if test='id != null'> id != #{id} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    int countExclusive(FundAccountDO obj);

    /**
     * 通过条件查询单条记录
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,account_num,bank_code,status,bank_account_no,bank_account_name,synchronization_time,current_balance,account_type from t_fund_account"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> id = #{id} AND </if>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='accountNum != null'> account_num = #{accountNum} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo} AND </if> "
                    + "<if test='bankAccountName != null'> bank_account_name = #{bankAccountName} AND </if> "
                    + "<if test='synchronizationTime != null'> synchronization_time = #{synchronizationTime} AND </if> "
                    + "<if test='currentBalance != null'> current_balance = #{currentBalance} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("FundAccountResultMap")
    FundAccountDO selectOne(FundAccountDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,account_num,bank_code,status,bank_account_no,bank_account_name,synchronization_time,current_balance,account_type from t_fund_account"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='accountNum != null'> account_num = #{accountNum} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='bankAccountNo != null'> bank_account_no = #{bankAccountNo} AND </if> "
                    + "<if test='bankAccountName != null'> bank_account_name = #{bankAccountName} AND </if> "
                    + "<if test='synchronizationTime != null'> synchronization_time = #{synchronizationTime} AND </if> "
                    + "<if test='currentBalance != null'> current_balance = #{currentBalance} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("FundAccountResultMap")
    List<FundAccountDO> selectList(FundAccountDO obj);

    /**
     * 代付客户明细 ,idu.account_type
     * 通过t_fund_account的bank_account_no == t_industry的fund_account
     * 再从 org_code和industry_type 组合 ==
     * t_account的 obj_code和obj_type查找出对应的虚拟账户
     */
    @Select("SELECT idu.id,idu.gmt_modified,idu.code as code, IFNULL(ac.frozen_amount,0) as frozenAmount,IFNULL(ac.avail_amount,0) as availAmount,IFNULL(ac.balance, 0) AS balance,ac.gmt_create as gmtCreate,idu.name as name from t_industry  idu left join t_account ac on (ac.account = idu.account) where idu.fund_account=#{bankAccountNo} and idu.status = 1")
    List<Map<String, Object>> selectCustList(@Param("bankAccountNo") String bankAccountNo);
// @Select("SELECT idu.id,idu.code as code,ac.frozen_amount as frozenAmount,ac.avail_amount as availAmount,ac.gmt_create as gmtCreate,idu.name as name FROM t_account ac, (SELECT * FROM t_industry WHERE fund_account = (SELECT bank_account_no FROM t_fund_account WHERE id = #{id} and status=1)) idu  WHERE idu.org_code=ac.obj_code AND idu.industry_type=ac.obj_type and idu.status=1 and ac.status=1")
//    List<Map<String,Object>> selectCustList(@Param("id") Long id);

    /**
     * 客户数量，总余额，总冻结余额
     *
     * @param
     * @return
     */
    @Select(
            "SELECT count(*) totalCount,sum(frozen_amount) totalFrozenAmount,SUM(avail_amount) totalAvailAmount from t_industry  idu left join t_account ac on (ac.account = idu.account) where idu.fund_account=#{bankAccountNo} and idu.status = 1"
    )
    Map<String, Long> totalCount(@Param("bankAccountNo") String bankAccountNo);


    @Select(
            "\n" + "select IFNULL(MAX(account_num),0)  as account_num FROM t_fund_account"
    )
    int selMaxValue(FundAccountDO obj);

}

