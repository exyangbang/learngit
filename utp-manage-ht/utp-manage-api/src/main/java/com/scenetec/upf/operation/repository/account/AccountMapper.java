package com.scenetec.upf.operation.repository.account;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.account.AccountDO;
import com.scenetec.upf.operation.model.domain.account.AccountDetailDO;
import com.scenetec.upf.operation.model.domain.electronicreceipt.AaccountElectronicReceiptDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@Repository
@Mapper
public interface AccountMapper {

    /**
     * 创建
     *
     * @param obj
     * @return
     */
    @Insert("insert into t_account (id,user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_code,obj_name,balance,frozen_amount,avail_amount,status,fee_template_id,fund_account,industry_id) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{account},#{objType},#{objCode},#{objName},#{balance},#{frozenAmount},#{availAmount},#{status},#{feeTemplateId},#{fundAccount},#{industryId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(AccountDO obj);

    /**
     * 批量插入
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_account ("
                    + " user_create, gmt_create, user_modified, gmt_modified, account, obj_type, obj_code, obj_name, balance, frozen_amount, avail_amount,fee_template_id, status"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.objCode}, #{item.objName}, #{item.balance}, #{item.frozenAmount}, #{item.availAmount}, #{item.feeTemplateId}, #{item.status})"
                    + "</foreach>"
                    + "</script>"
    )
    int insertList(List<AccountDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_account ("
                    + " user_create, gmt_create, user_modified, gmt_modified, account, obj_type, obj_code, obj_name, balance, frozen_amount, avail_amount,fee_template_id,industry_id, status"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.objCode}, #{item.objName}, #{item.balance}, #{item.frozenAmount}, #{item.availAmount},#{item.feeTemplateId},#{item.industryId}, #{item.status})"
                    + "</foreach>"
                    + " ON DUPLICATE KEY UPDATE "
                    + "user_create = VALUES(user_create),"
                    + "gmt_create = VALUES(gmt_create),"
                    + "user_modified = VALUES(user_modified),"
                    + "gmt_modified = VALUES(gmt_modified),"
                    + "account = VALUES(account),"
                    + "obj_type = VALUES(obj_type),"
                    + "obj_code = VALUES(obj_code),"
                    + "obj_name = VALUES(obj_name),"
                    + "balance = VALUES(balance),"
                    + "frozen_amount = VALUES(frozen_amount),"
                    + "avail_amount = VALUES(avail_amount),"
                    + "fee_template_id = VALUES(fee_template_id),"
                    + "status = VALUES(status)"
                    + "</script>"
    )
    int modifyList(List<AccountDO> obj);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Delete("delete from t_account where id = #{id}")
    int delete(Long id);

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    @Delete("update t_account set status=0 where id = #{id}")
    int deleteLogic(Long id);

    /**
     * 逻辑删除
     *
     * @param account
     * @return
     */
    @Delete("update t_account set status=0 where obj_code = #{objCode} and obj_type= #{objType}")
    int deleteLogicByObjCode(@Param("objCode") String objCode, @Param("objType") String objType);

    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_account <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='account != null'> account = #{account}, </if> "
                    + "<if test='objType != null'> obj_type = #{objType}, </if> "
                    + "<if test='objCode != null'> obj_code = #{objCode}, </if> "
                    + "<if test='objName != null'> obj_name = #{objName}, </if> "
                    + "<if test='balance != null'> balance = #{balance}, </if> "
                    + "<if test='frozenAmount != null'> frozen_amount = #{frozenAmount}, </if> "
                    + "<if test='availAmount != null'> avail_amount = #{availAmount}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "<if test='feeTemplateId != null'> fee_template_id = #{feeTemplateId}, </if> "
                    + "<if test='feeTemplateIdRelieve != null'> fee_template_id = null, </if> "
                    + "<if test='bankClientStatus != null'> bank_client_status = #{bankClientStatus}, </if> "
                    + "<if test='bankClientNo != null'> bank_client_no = #{bankClientNo}, </if> "
                    + "</set> where id = #{id}"
                    + "</script>"
    )
    int update(AccountDO obj);

    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_account <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='account != null'> account = #{account}, </if> "
                    + "<if test='objType != null'> obj_type = #{objType}, </if> "
                    + "<if test='objCode != null'> obj_code = #{objCode}, </if> "
                    + "<if test='objName != null'> obj_name = #{objName}, </if> "
                    + "<if test='balance != null'> balance = #{balance}, </if> "
                    + "<if test='frozenAmount != null'> frozen_amount = #{frozenAmount}, </if> "
                    + "<if test='availAmount != null'> avail_amount = #{availAmount}, </if> "
                    + "<if test='feeTemplateId != null'> fee_template_id = #{feeTemplateId}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "</set> where obj_code = #{objCode} and obj_type = #{objType}  "
                    + "</script>"
    )
    int updateByObj(AccountDO obj);

    @Update(
            "<script>"
                    + "update t_account <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='account != null'> account = #{account}, </if> "
                    + "<if test='objType != null'> obj_type = #{objType}, </if> "
                    + "<if test='objCode != null'> obj_code = #{objCode}, </if> "
                    + "<if test='objName != null'> obj_name = #{objName}, </if> "
                    + "<if test='balance != null'> balance = #{balance}, </if> "
                    + "<if test='frozenAmount != null'> frozen_amount = #{frozenAmount}, </if> "
                    + "<if test='availAmount != null'> avail_amount = #{availAmount}, </if> "
                    + "<if test='feeTemplateId != null'> fee_template_id = #{feeTemplateId}, </if> "
                    + "<if test='fundAccount != null'> fund_account = #{fundAccount}, </if> "

                    + "<if test='status != null'> status = #{status}, </if> "
                    + "</set> where industry_id = #{industryId} "
                    + "</script>"
    )
    int updateByObjById(AccountDO obj);

    @Update(
            "<script>"
                    + "update t_account <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "</set> where account = #{account}"
                    + "</script>"
    )
    int updateByAccount(AccountDO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    @Select("select * from t_account ac where id = #{id}")
    @Results(id = "AccountResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userCreate", column = "user_create")
            , @Result(property = "gmtCreate", column = "gmt_create")
            , @Result(property = "userModified", column = "user_modified")
            , @Result(property = "gmtModified", column = "gmt_modified")
            , @Result(property = "account", column = "account")
            , @Result(property = "objType", column = "obj_type")
            , @Result(property = "objCode", column = "obj_code")
            , @Result(property = "objName", column = "obj_name")
            , @Result(property = "balance", column = "balance")
            , @Result(property = "frozenAmount", column = "frozen_amount")
            , @Result(property = "availAmount", column = "avail_amount")
            , @Result(property = "status", column = "status")
            , @Result(property = "feeTemplateId", column = "fee_template_id")
            , @Result(property = "industryId", column = "industry_id")
            , @Result(property = "account_no", column = "accountNo")
            , @Result(property = "bankClientNo", column = "bank_client_no")
            , @Result(property = "bankClientStatus", column = "bank_client_status")
            , @Result(property = "bankClientChnFlag", column = "bank_client_chn_flag")
            , @Result(property = "fundAccount", column = "fund_account")
            , @Result(property = "operationType", column = "operation_type")

    }
    )
    AccountDO getById(@Param("id") Long id);


    @Select("select ac.*,merinfo.user_type as userType from t_account ac LEFT JOIN t_merchant_info merinfo ON merinfo.account = ac.account  where ac.id = #{id}")
    @ResultMap("AccountResultMap")
    AccountDO getByIdToMerAcc(@Param("id") Long id);
    /**
     * 查询列表(分页)
     *
     * @return
     */

    @Select(
            "<script>"
                    + "select sb.* from("
                    + "SELECT "
                    + "ac.id, "
                    + "ac.status, "
                    + "ac.user_create, "
                    + "ac.gmt_create, "
                    + "ac.user_modified, "
                    + "ac.gmt_modified, "
                    + "ac.account, "
                    + "ac.obj_type, "
                    + "ac.obj_code, "
                    + "ac.balance, "
                    + "ac.frozen_amount, "
                    + "ac.avail_amount, "
                    + "ac.fee_template_id,"
                    + "ac.bank_client_status,"
                    + "ac.bank_client_chn_flag,"
                    + "ac.bank_client_no,"
                    + "merinfo.user_type as userType, "
                    + "ac.fund_account, "
                    + "fund.bank_account_no AS bankAccountNo, "
                    + "fund.bank_account_name AS bankAccountName, "
                    +"operation.operation_type as operation_type,"
//                    + "(select operation_type from t_operation_record operation where operation.account = ac.account order by gmt_create desc limit 1) as operationType, "
                    + "case  "
                    + " when ac.obj_type='3' then merinfo.industry_code "
                    + " when ac.obj_type='2' then merinfo.industry_code  "
                    + " when ac.obj_type='7' then merinfo.industry_code  "
                    + " when ac.obj_type='8' then merinfo.industry_code  "
                    + " when ac.obj_type='9' then merinfo2.industry_code  "
                    + "  else ac.obj_code "
                    + "   end  as code,  "
                    + "case  "
                    + "  when ac.obj_type='3' then merinfo.industry_name  "
                    + " when ac.obj_type='2' then merinfo.industry_name  "
                    + " when ac.obj_type='7' then merinfo.industry_name  "
                    + " when ac.obj_type='8' then merinfo.industry_name  "
                    + " when ac.obj_type='9' then merinfo2.industry_name  "
                    + " else ac.obj_name  "
                    + " end  as indName,   "
                    + " case  "
                    + " when ac.obj_type='2' then merinfo.ent_name  "
                    + " else ac.obj_name   "
                    + " end  as obj_name,  "
                    + " case  "
                    + "  when ac.obj_type='2' then merinfo.bus_lic_code  "
                    + "  when (ac.obj_type='9' and merinfo2.user_type='0')  then merinfo2.id_code  "
                    + "  when (ac.obj_type='9' and merinfo2.user_type='1')  then merinfo2.bus_lic_code  "
                    + "  when ac.obj_type='1' then ind.id_code  "
                    + " else merinfo.id_code  "
                    + "  end  as busLicCode,  "
                    + " case  "
                    + "  when ac.obj_type='2' then merinfo.auth_status  "
                    + " else '-1' "
                    + " end merAuthStatus, "
                    + " case when ac.obj_type = '2' then accinfo.business_indate "
                    + "  when ac.obj_type = '1' then accinfo.legal_indate "
                    + "  when (ac.obj_type = '9' and merinfo2.user_type = '0') then merinfo2.id_indate "
                    + "  when (ac.obj_type = '9' and merinfo2.user_type = '1') then accinfo.business_indate "
                    + " else merinfo.id_indate end as idValidity, "
                    + " case when ac.obj_type = '3' then merinfo.status "
                    + "  when ac.obj_type = '8' then merinfo.status "
                    + " else '-1' end as merStatus "
                    + "FROM t_account ac "
                    + "LEFT JOIN t_fund_account fund ON fund.bank_account_no = ac.fund_account "
                    + "LEFT JOIN t_merchant_info merinfo ON merinfo.account = ac.account "
                    + "LEFT JOIN t_merchant_info merinfo2 ON merinfo2.settle_account = ac.account  "
                    + "LEFT JOIN t_industry ind ON ind.account = ac.account  "
                    + "LEFT JOIN t_account_info accinfo on ac.account = accinfo.account "
                    +"  LEFT JOIN ( SELECT b.* FROM t_operation_record b INNER JOIN (SELECT MAX(gmt_create) gmt_create,operation.account FROM t_operation_record operation GROUP BY account) c on b.gmt_create = c.gmt_create and b.account = c.account) operation ON operation.account = ac.account "
                    +" where 1=1 "
                    + "<if test='params.account != null'> and ac.account = #{params.account}</if>"
                    + "<if test='params.objType != null'> and ac.obj_type = #{params.objType}</if>"
                    + "<if test='params.beginTransDatetime != null'> and ac.gmt_create &gt;= #{params.beginTransDatetime} </if>"
                    + "<if test='params.endTransDatetime != null'>and ac.gmt_create &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.bankAccountNo != null'> and fund.bank_account_no = #{params.bankAccountNo}</if>"
                    + "<if test='params.bankClientNo != null'> and ac.bank_client_no = #{params.bankClientNo}</if>"
                    + "<if test='params.bankClientStatus != null'> and ac.bank_client_status = #{params.bankClientStatus}</if>"
                    + "<if test='params.status != null'> and  ac.status = #{params.status}</if>"
                    + ") as sb  where 1=1 "
                    + "<if test='params.objCode != null'> and sb.obj_code = #{params.objCode}</if>"
                    + "<if test='params.objName != null'> and sb.obj_name like concat('%',#{params.objName},'%')</if>"
                    + "<if test='params.busLicCode != null'> and sb.busLicCode = #{params.busLicCode}</if>"
                    + "<if test='params.code != null'> and sb.code = #{params.code}</if>"
                    + "<if test='params.accountNo != null'> and  sb.accountNo = #{params.accountNo}</if>"
                    + "<if test='params.expireDays != null and params.expireDays == 1'> and DATEDIFF(sb.idValidity, NOW()) &lt; #{params.expireDays}</if>"
                    + "<if test='params.expireDays != null and params.expireDays gt 1'> and DATEDIFF(sb.idValidity, NOW()) between 1 and #{params.expireDays} </if>"
                    + "order by gmt_create desc"
                    + "</script>"

    )
    @ResultMap("AccountResultMap")
    Page<AccountDO> pageList(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"
                    + "select  count(1),"
                    + " IFNULL(sum(sb.balance), 0) totalBalance,"
                    + "IFNULL(sum(sb.frozen_amount), 0) totalFrozenAmount,"
                    + "IFNULL(sum(sb.avail_amount), 0) totalAvailAmount from("
                    + "SELECT "
                    + "ac.id, "
                    + "ac.bank_client_no, "
                    + "ac.status, "
                    + "ac.user_create, "
                    + "ac.gmt_create, "
                    + "ac.user_modified, "
                    + "ac.gmt_modified, "
                    + "ac.account, "
                    + "ac.obj_type, "
                    + "ac.obj_code, "
                    + "ac.balance, "
                    + "ac.frozen_amount, "
                    + "ac.avail_amount, "
                    + "ac.fee_template_id,"
                    + "ac.bank_client_status,"
                    + "ac.bank_client_chn_flag,"
                    + "merinfo.user_type as userType, "
                    + "ac.fund_account, "
                    + "fund.bank_account_no AS bankAccountNo, "
                    + "fund.bank_account_name AS bankAccountName, "
                    +"operation.operation_type as operation_type, "
//                    + "(select operation_type from t_operation_record operation where operation.account = ac.account order by gmt_create desc limit 1) as operationType, "
                    + "case  "
                    + " when ac.obj_type='3' then merinfo.industry_code "
                    + " when ac.obj_type='2' then merinfo.industry_code  "
                    + " when ac.obj_type='7' then merinfo.industry_code  "
                    + " when ac.obj_type='8' then merinfo.industry_code  "
                    + " when ac.obj_type='9' then merinfo2.industry_code  "
                    + "  else ac.obj_code "
                    + "   end  as code,  "
                    + "case  "
                    + "  when ac.obj_type='3' then merinfo.industry_name  "
                    + " when ac.obj_type='2' then merinfo.industry_name  "
                    + " when ac.obj_type='7' then merinfo.industry_name  "
                    + " when ac.obj_type='8' then merinfo.industry_name  "
                    + " when ac.obj_type='9' then merinfo2.industry_name  "
                    + " else ac.obj_name  "
                    + " end  as indName,   "
                    + " case  "
                    + " when ac.obj_type='2' then merinfo.ent_name  "
                    + " else ac.obj_name   "
                    + " end  as obj_name,  "
                    + " case  "
                    + "  when ac.obj_type='2' then merinfo.bus_lic_code  "
                    + "  when ac.obj_type='1' then ind.id_code  "
                    + " else merinfo.id_code  "
                    + "  end  as busLicCode,  "
                    + " case when accinfo.obj_type = '2' then accinfo.business_indate "
                    + " when (accinfo.obj_type = '9' and accinfo.user_type = '1') then accinfo.business_indate "
                    + " else accinfo.legal_indate end as idValidity "
                    + "FROM t_account ac "
                    + "LEFT JOIN t_fund_account fund ON fund.bank_account_no = ac.fund_account "
                    + "LEFT JOIN t_merchant_info merinfo ON merinfo.account = ac.account "
                    + "LEFT JOIN t_merchant_account_info meracc ON meracc.account = ac.account "
                    + "LEFT JOIN t_industry ind ON ind.account = ac.account  "
                    + "LEFT JOIN t_merchant_info merinfo2 ON merinfo2.settle_account = ac.account  "
                    + "LEFT JOIN t_account_info accinfo on ac.account = accinfo.account "
                    +"  LEFT JOIN ( SELECT MAX( gmt_create ) operation_type, operation.account FROM t_operation_record operation GROUP BY account ) operation ON operation.account = ac.account "
                    +" where 1=1 "
                    + "<if test='params.account != null'> and ac.account like concat('%',#{params.account},'%')</if>"
                    + "<if test='params.objType != null'> and ac.obj_type = #{params.objType}</if>"
                    + "<if test='params.beginTransDatetime != null'> and ac.gmt_create &gt;= #{params.beginTransDatetime} </if>"
                    + "<if test='params.endTransDatetime != null'>and ac.gmt_create &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.bankAccountNo != null'> and fund.bank_account_no = #{params.bankAccountNo}</if>"
                    + "<if test='params.bankClientNo != null'> and ac.bank_client_no = #{params.bankClientNo}</if>"
                    + "<if test='params.bankClientStatus != null'> and ac.bank_client_status = #{params.bankClientStatus}</if>"
                    + "<if test='params.status != null'> and  ac.status = #{params.status}</if>"
                    + ") as sb  where 1=1 "
                    + "<if test='params.objCode != null'> and sb.obj_code = #{params.objCode}</if>"
                    + "<if test='params.objName != null'> and sb.obj_name like concat('%',#{params.objName},'%')</if>"
                    + "<if test='params.busLicCode != null'> and sb.busLicCode = #{params.busLicCode}</if>"
                    + "<if test='params.code != null'> and sb.code = #{params.code}</if>"
                    + "<if test='params.accountNo != null'> and  sb.accountNo = #{params.accountNo}</if>"
                    + "<if test='params.expireDays != null and params.expireDays == 1'> and DATEDIFF(sb.idValidity, NOW()) &lt; #{params.expireDays}</if>"
                    + "<if test='params.expireDays != null and params.expireDays gt 1'> and DATEDIFF(sb.idValidity, NOW()) between 1 and #{params.expireDays} </if>"
                    + "</script>"
    )
    Map<String, Long> countTrans(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页) 排除收益账户
     *
     * @return
     */
    @Select(
            "<script>"
                    + "select sb.* from("
                    + "SELECT "
                    + "ac.id, "
                    + "ac.bank_client_no, "
                    + "ac.status, "
                    + "ac.user_create, "
                    + "ac.gmt_create, "
                    + "ac.user_modified, "
                    + "ac.gmt_modified, "
                    + "ac.account, "
                    + "ac.obj_type, "
                    + "ac.obj_code, "
                    + "ac.balance, "
                    + "ac.frozen_amount, "
                    + "ac.avail_amount, "
                    + "ac.fee_template_id,"
                    + "ac.bank_client_status,"
                    + "ac.bank_client_chn_flag,"
                    + "merinfo.user_type as userType, "
                    + "ac.fund_account, "
                    + "fund.bank_account_no AS bankAccountNo, "
                    + "fund.bank_account_name AS bankAccountName, "
                    + "operation.operation_type as operation_type,"
//                    + "(select operation_type from t_operation_record operation where operation.account = ac.account order by gmt_create desc limit 1) as operationType, "
                    + "case  "
                    + " when ac.obj_type='3' then merinfo.industry_code "
                    + " when ac.obj_type='2' then merinfo.industry_code  "
                    + " when ac.obj_type='7' then merinfo.industry_code  "
                    + " when ac.obj_type='8' then merinfo.industry_code  "
                    + " when ac.obj_type='9' then merinfo2.industry_code  "
                    + "  else ac.obj_code "
                    + "   end  as code,  "
                    + "case  "
                    + "  when ac.obj_type='3' then merinfo.industry_name  "
                    + " when ac.obj_type='2' then merinfo.industry_name  "
                    + " when ac.obj_type='7' then merinfo.industry_name  "
                    + " when ac.obj_type='8' then merinfo.industry_name  "
                    + " when ac.obj_type='9' then merinfo2.industry_name  "
                    + " else ac.obj_name  "
                    + " end  as indName,   "
                    + " case  "
                    + " when ac.obj_type='2' then merinfo.ent_name  "
                    + " else ac.obj_name   "
                    + " end  as obj_name,  "
                    + " case  "
                    + "  when ac.obj_type='2' then merinfo.bus_lic_code  "
                    + "  when ac.obj_type='1' then ind.id_code  "
                    + " else merinfo.id_code  "
                    + "  end  as busLicCode  "
                    + "FROM t_account ac "
                    + "LEFT JOIN t_fund_account fund ON fund.bank_account_no = ac.fund_account "
                    + "LEFT JOIN t_merchant_info merinfo ON merinfo.account = ac.account "
                    + "LEFT JOIN t_merchant_info merinfo2 ON merinfo2.settle_account = ac.account  "
                    + "LEFT JOIN t_merchant_account_info meracc ON meracc.account = ac.account "
                    + "LEFT JOIN t_industry ind ON ind.account = ac.account  "
                    +"  LEFT JOIN ( SELECT MAX( gmt_create ) operation_type, operation.account FROM t_operation_record operation GROUP BY account ) operation ON operation.account = ac.account "
                    +" where 1=1 "
                    + "<if test='params.account != null'> and ac.account like concat('%',#{params.account},'%')</if>"
                    + "<if test='params.objType != null'> and ac.obj_type = #{params.objType}</if>"
                    + "<if test='params.beginTransDatetime != null'> and ac.gmt_create &gt;= #{params.beginTransDatetime} </if>"
                    + "<if test='params.endTransDatetime != null'>and ac.gmt_create &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.bankAccountNo != null'> and fund.bank_account_no = #{params.bankAccountNo}</if>"
                    + "<if test='params.bankClientNo != null'> and ac.bank_client_no = #{params.bankClientNo}</if>"
                    + "<if test='params.bankClientStatus != null'> and ac.bank_client_status = #{params.bankClientStatus}</if>"
                    + ") as sb  where 1=1 "
                    + "<if test='params.objCode != null'> and sb.obj_code = #{params.objCode}</if>"
                    + "<if test='params.objName != null'> and sb.obj_name like concat('%',#{params.objName},'%')</if>"
                    + "<if test='params.busLicCode != null'> and sb.busLicCode = #{params.busLicCode}</if>"
                    + "<if test='params.code != null'> and sb.code = #{params.code}</if>"
                    + "<if test='params.accountNo != null'> and  sb.accountNo = #{params.accountNo}</if>"
                    + "order by gmt_create desc"
                    + "</script>"
    )
    @ResultMap("AccountResultMap")
    Page<AccountDO> pageListUnincome(@Param("params") Map<String, Object> params);
    /**
     * 查询列表(分页)
     *
     * @return
     */
//    @Select(
//            "<script>"
//                    + "select sb.* from("
//                    + "select ac.id, ac.user_create,ac.gmt_create,ac.user_modified,ac.gmt_modified,ac.account,ac.obj_type,ac.obj_code,ac.balance,ac.frozen_amount,ac.avail_amount,ac.status,ac.fee_template_id, "
//                    + "ac.fund_account, mer.account_no as accountNo, "
//                    + "fund.bank_account_no as bankAccountNo,fund.bank_account_name as bankAccountName, "
//                    + "  case "
//                    + "    when ac.obj_type='3' then teind.code "
//                    + "when ac.obj_type='2' then teind.code "
//                    + "    else ind. CODE "
//                    + "    end  as code, "
//                    + "  case "
//                    + "    when ac.obj_type='3' then teind.name "
//                    + "when ac.obj_type='2' then teind.name "
//                    + "    else ind.NAME "
//                    + "    end  as indName,  "
//                    + "case "
//                    + "    when ac.obj_type='2' then merinfo.ent_name "
//                    + "    else ac.obj_name "
//                    + "    end  as obj_name, "
//                    + "case "
//                    + "    when ac.obj_type='2' then merinfo.bus_lic_code "
//                    + "    else merinfo.id_code "
//                    + "    end  as busLicCode "
//                    + " from t_account ac "
//                    + "LEFT JOIN t_merchant_account_info mer ON mer.account = ac.account "
//                    + "LEFT JOIN t_merchant_info merinfo ON merinfo.account = ac.account "
//                    + "LEFT JOIN t_industry ind ON ac.account = ind.account "
//                    + "left JOIN t_fund_account fund ON ac.fund_account = fund.bank_account_no "
//                    + "LEFT JOIN t_industry teind ON teind.code = merinfo.industry_code "
//                    + "where 1=1) as sb where 1=1 "
//                    + "<if test='params.account != null'> and sb.account like concat('%',#{params.account},'%')</if>"
//                    + "<if test='params.objType != null'> and sb.obj_type = #{params.objType}</if>"
//                    + "<if test='params.objCode != null'> and sb.obj_code = #{params.objCode}</if>"
//                    + "<if test='params.objName != null'> and sb.obj_name like concat('%',#{params.objName},'%')</if>"
//                    + "<if test='params.busLicCode != null'> and sb.busLicCode = #{params.busLicCode}</if>"
//                    + "<if test='params.code != null'> and sb.code = #{params.code}</if>"
//                    + "<if test='params.accountNo != null'> and  sb.accountNo = #{params.accountNo}</if>"
//                    + "<if test='params.bankAccountNo != null'> and sb.bankAccountNo = #{params.bankAccountNo}</if>"
//                    + "order by gmt_create desc"
//                    + "</script>"
//    )
//    @ResultMap("AccountResultMap")
//    Page<AccountDO> pageList(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页)  虚拟账户重新获取
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select ac.*,ac.fund_account from t_account ac "
                    + "where 1=1 "
                    + "<if test='params.account != null'> and ac.account like concat('%',#{params.account},'%')</if>"
                    + "<if test='params.objType != null'> and ac.obj_type = #{params.objType}</if>"
                    + "<if test='params.objCode != null'> and ac.obj_code = #{params.objCode}</if>"
                    + "<if test='params.objName != null'> and ac.obj_name like concat('%',#{params.objName},'%')</if>"
                    + "<if test='params.accountNo != null'> and  mer.account_no = #{params.accountNo}</if>"
                    + "order by gmt_create desc"
                    + "</script>"
    )
    @ResultMap("AccountResultMap")
    Page<AccountDO> pageListAccount(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select ac.id,ac.account,ac.operate_type,ac.operate_sub_type,ac.amount,ac.before_balance,ac.after_balance,ac.record_time,ac.seq_no,ac.peer_acc_no,ac.peer_acc_name ,"
                    + "mer.ent_name as entName,mer.real_name as realName,mer.user_type as userType  from t_account_detail ac LEFT JOIN t_merchant_info mer on (mer.account = ac.account) where 1 = 1"

                    + "<if test='params.account != null'> and ac.account = #{params.account}</if>"
                    + "<if test='params.operateType != null'> and ac.operate_type = #{params.operateType}</if>"
                    + "<if test='params.beginDatetime != null'> and ac.record_time &gt;= #{params.beginDatetime}</if>"
                    + "<if test='params.endDatetime != null'> and ac.record_time &lt;= #{params.endDatetime}</if>"
                    + "order by ac.record_time desc , ac.seq_no desc"
                    + "</script>"
    )
    @Results(id = "AccountResultDetailMap", value = {
            @Result(property = "id", column = "id")
            , @Result(property = "account", column = "account")
            , @Result(property = "operateType", column = "operate_type")
            , @Result(property = "operateSubType", column = "operate_sub_type")
            , @Result(property = "amount", column = "amount")
            , @Result(property = "beforeBalance", column = "before_balance")
            , @Result(property = "afterBalance", column = "after_balance")
            , @Result(property = "recordTime", column = "record_time")
            , @Result(property = "seqNo", column = "seq_no")
            , @Result(property = "peerAccName", column = "peer_acc_name")
            , @Result(property = "peerAccNo", column = "peer_acc_no")
            , @Result(property = "bankClientNo", column = "bank_client_no")


    }
    )
    Page<AccountDetailDO> pageListDetail(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(不分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_code,obj_name,balance,frozen_amount,avail_amount,status,fee_template_id from t_account where 1 = 1"
                    + "<if test='params.account != null'> and account like concat('%',#{params.account},'%')</if>"
                    + "<if test='params.objType != null'> and obj_type = #{params.objType}</if>"
                    + "<if test='params.objCode != null'> and obj_code = #{params.objCode}</if>"
                    + "<if test='params.objName != null'> and obj_name like concat('%',#{params.objName},'%')</if>"
                    + "</script>"
    )
    @ResultMap("AccountResultMap")
    List<AccountDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) from t_account <where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "<if test='objType != null'> obj_type = #{objType} AND </if> "
                    + "<if test='objCode != null'> obj_code = #{objCode} AND </if> "
                    + "<if test='objName != null'> obj_name = #{objName} AND </if> "
                    + "<if test='balance != null'> balance = #{balance} AND </if> "
                    + "<if test='frozenAmount != null'> frozen_amount = #{frozenAmount} AND </if> "
                    + "<if test='availAmount != null'> avail_amount = #{availAmount} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='feeTemplateId != null'> fee_template_id = #{feeTemplateId} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    int count(AccountDO obj);

    /**
     * 通过条件查询单条记录
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id,bank_client_no, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_code,obj_name,balance,frozen_amount,avail_amount,status,fee_template_id,bank_client_chn_flag from t_account"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> id = #{id} AND </if>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "<if test='objType != null'> obj_type = #{objType} AND </if> "
                    + "<if test='objCode != null'> obj_code = #{objCode} AND </if> "
                    + "<if test='objName != null'> obj_name = #{objName} AND </if> "
                    + "<if test='balance != null'> balance = #{balance} AND </if> "
                    + "<if test='frozenAmount != null'> frozen_amount = #{frozenAmount} AND </if> "
                    + "<if test='availAmount != null'> avail_amount = #{availAmount} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='feeTemplateId != null'> fee_template_id = #{feeTemplateId} AND </if> "
                    + "<if test='industryId != null'> industry_id = #{industryId} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("AccountResultMap")
    AccountDO selectOne(AccountDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,obj_code,obj_name,balance,frozen_amount,avail_amount,status,fee_template_id from t_account"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "<if test='objType != null'> obj_type = #{objType} AND </if> "
                    + "<if test='objCode != null'> obj_code = #{objCode} AND </if> "
                    + "<if test='objName != null'> obj_name = #{objName} AND </if> "
                    + "<if test='balance != null'> balance = #{balance} AND </if> "
                    + "<if test='frozenAmount != null'> frozen_amount = #{frozenAmount} AND </if> "
                    + "<if test='availAmount != null'> avail_amount = #{availAmount} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='feeTemplateId != null'> fee_template_id = #{feeTemplateId} AND </if> "

                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("AccountResultMap")
    List<AccountDO> selectList(AccountDO obj);


    /**
     * 查询总数
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "SELECT IFNULL(sum(amount),0) from t_account a INNER join t_account_detail b on a.account = b.account"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='transBeginDate != null'> and b.record_time &gt;= #{transBeginDate} </if>"
                    + "<if test='transEndDate != null'>and b.record_time &lt;= #{transEndDate}</if>"

                    + "<if test='status != null'>and a.status = #{status} </if> "
                    + "<if test='account != null'>and  b.account = #{account} </if> "
                    + "<if test='operateType != null'>and b.operate_type = #{operateType} </if> "

                    + "</trim></where> "
                    + "</script>"
    )
    Long countSum(AccountDO obj);


    @Select(
            "<script>"
                    + "select account,id,file_content as fileContent from t_account_electronic_receipt"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='account != null'>and  account = #{account} </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    AaccountElectronicReceiptDO getAccounElectronic(@Param("account") String account);





    @Select(
            "<script>"
                    + "select id,account,obj_type,obj_code,obj_name,fund_account from t_account "
                    +"<where>" +
                    " id in"
                    + " <foreach item='item' index='index' collection='list' open='(' separator=',' close=')'>"
                    + "(#{item})"
                    + "</foreach>"
                    +"</where>"
                    + "</script>"
    )
    @ResultMap("AccountResultMap")
    List<AccountDO> selectListForIn(List<Long> list);

}

