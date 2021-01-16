package com.scenetec.upf.operation.repository.splitinfo;

import com.scenetec.upf.operation.model.domain.splitinfo.SplitInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;

import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/06/03
 */
@Repository
@Mapper
public interface SplitInfoMapper {

    /**
     * 创建
     *
     * @param obj
     * @return
     */
    @Insert("insert into t_split_info (user_create,gmt_create,user_modified,gmt_modified,settle_date,mer_no,amount,period,split_date,account_type,account_no,account_name,bank_code,remark,extend_1,extend_2,extend_3,status,provider_code,batch_id,trans_date,server_trans_id,client_trans_id,trans_status,query_times,trans_desc,subject,reconcile_date,user_account,settle_mode,industry_code) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{settleDate},#{merNo},#{amount},#{period},#{splitDate},#{accountType},#{accountNo},#{accountName},#{bankCode},#{remark},#{channelRespCode},#{extend_1},#{extend_2},#{extend_3},#{status},#{providerCode},#{batchId},#{transDate},#{serverTransId},#{clientTransId},#{transStatus},#{queryTimes},#{transDesc},#{subject},#{reconcileDate},#{userAccount},#{settleMode},#{industryCode})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(SplitInfoDO obj);

    /**
     * 批量插入
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_split_info ("
                    + " user_create, gmt_create, user_modified, gmt_modified, settle_date, mer_no, amount, period, split_date, account_type, account_no, account_name, bank_code, remark, extend_1, extend_2, extend_3, status, provider_code, batch_id, trans_date, server_trans_id, client_trans_id, trans_status, query_times, trans_desc, subject, reconcile_date, user_account, settle_mode, industry_code"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.settleDate}, #{item.merNo}, #{item.amount}, #{item.period}, #{item.splitDate}, #{item.accountType}, #{item.accountNo}, #{item.accountName}, #{item.bankCode}, #{item.remark}, #{item.channelRespCode}, #{item.extend_1}, #{item.extend_2}, #{item.extend_3}, #{item.status}, #{item.providerCode}, #{item.batchId}, #{item.transDate}, #{item.serverTransId}, #{item.clientTransId}, #{item.transStatus}, #{item.queryTimes}, #{item.transDesc}, #{item.subject}, #{item.reconcileDate}, #{item.userAccount}, #{item.settleMode}, #{item.industryCode})"
                    + "</foreach>"
                    + "</script>"
    )
    int insertList(List<SplitInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_split_info ("
                    + " user_create, gmt_create, user_modified, gmt_modified, settle_date, mer_no, amount, period, split_date, account_type, account_no, account_name, bank_code, remark, extend_1, extend_2, extend_3, status, provider_code, batch_id, trans_date, server_trans_id, client_trans_id, trans_status, query_times, trans_desc, subject, reconcile_date, user_account, settle_mode, industry_code"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.settleDate}, #{item.merNo}, #{item.amount}, #{item.period}, #{item.splitDate}, #{item.accountType}, #{item.accountNo}, #{item.accountName}, #{item.bankCode}, #{item.remark}, #{item.channelRespCode}, #{item.extend_1}, #{item.extend_2}, #{item.extend_3}, #{item.status}, #{item.providerCode}, #{item.batchId}, #{item.transDate}, #{item.serverTransId}, #{item.clientTransId}, #{item.transStatus}, #{item.queryTimes}, #{item.transDesc}, #{item.subject}, #{item.reconcileDate}, #{item.userAccount}, #{item.settleMode}, #{item.industryCode})"
                    + "</foreach>"
                    + " ON DUPLICATE KEY UPDATE "
                    + "user_create = VALUES(user_create),"
                    + "gmt_create = VALUES(gmt_create),"
                    + "user_modified = VALUES(user_modified),"
                    + "gmt_modified = VALUES(gmt_modified),"
                    + "settle_date = VALUES(settle_date),"
                    + "mer_no = VALUES(mer_no),"
                    + "amount = VALUES(amount),"
                    + "period = VALUES(period),"
                    + "split_date = VALUES(split_date),"
                    + "account_type = VALUES(account_type),"
                    + "account_no = VALUES(account_no),"
                    + "account_name = VALUES(account_name),"
                    + "bank_code = VALUES(bank_code),"
                    + "remark = VALUES(remark),"
                    + "extend_1 = VALUES(extend_1),"
                    + "extend_2 = VALUES(extend_2),"
                    + "extend_3 = VALUES(extend_3),"
                    + "status = VALUES(status),"
                    + "provider_code = VALUES(provider_code),"
                    + "batch_id = VALUES(batch_id),"
                    + "trans_date = VALUES(trans_date),"
                    + "server_trans_id = VALUES(server_trans_id),"
                    + "client_trans_id = VALUES(client_trans_id),"
                    + "trans_status = VALUES(trans_status),"
                    + "query_times = VALUES(query_times),"
                    + "trans_desc = VALUES(trans_desc),"
                    + "subject = VALUES(subject),"
                    + "reconcile_date = VALUES(reconcile_date),"
                    + "user_account = VALUES(user_account),"
                    + "settle_mode = VALUES(settle_mode),"
                    + "industry_code = VALUES(industry_code)"
                    + "</script>"
    )
    int modifyList(List<SplitInfoDO> obj);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @Delete("delete from t_split_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_split_info <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='settleDate != null'> settle_date = #{settleDate}, </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo}, </if> "
                    + "<if test='amount != null'> amount = #{amount}, </if> "
                    + "<if test='period != null'> period = #{period}, </if> "
                    + "<if test='splitDate != null'> split_date = #{splitDate}, </if> "
                    + "<if test='accountType != null'> account_type = #{accountType}, </if> "
                    + "<if test='accountNo != null'> account_no = #{accountNo}, </if> "
                    + "<if test='accountName != null'> account_name = #{accountName}, </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
                    + "<if test='remark != null'> remark = #{remark}, </if> "
                    + "<if test='extend_1 != null'> extend_1 = #{extend_1}, </if> "
                    + "<if test='extend_2 != null'> extend_2 = #{extend_2}, </if> "
                    + "<if test='extend_3 != null'> extend_3 = #{extend_3}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "<if test='providerCode != null'> provider_code = #{providerCode}, </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId}, </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate}, </if> "
                    + "<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "
                    + "<if test='clientTransId != null'> client_trans_id = #{clientTransId}, </if> "
                    + "<if test='transStatus != null'> trans_status = #{transStatus}, </if> "
                    + "<if test='queryTimes != null'> query_times = #{queryTimes}, </if> "
                    + "<if test='transDesc != null'> trans_desc = #{transDesc}, </if> "
                    + "<if test='subject != null'> subject = #{subject}, </if> "
                    + "<if test='reconcileDate != null'> reconcile_date = #{reconcileDate}, </if> "
                    + "<if test='userAccount != null'> user_account = #{userAccount}, </if> "
                    + "<if test='settleMode != null'> settle_mode = #{settleMode}, </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
                    + "</set> where id = #{id}"
                    + "</script>"
    )
    int update(SplitInfoDO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    @Select("select id, user_create,gmt_create,user_modified,gmt_modified,settle_date,mer_no,amount,period,split_date,account_type,account_no,account_name,bank_code,remark,extend_1,extend_2,extend_3,status,provider_code,batch_id,trans_date,server_trans_id,client_trans_id,trans_status,query_times,trans_desc,subject,reconcile_date,user_account,settle_mode,industry_code from t_split_info where id = #{id}")
    @Results(id = "SplitInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"), @Result(property = "gmtCreate", column = "gmt_create"), @Result(property = "userModified", column = "user_modified"), @Result(property = "gmtModified", column = "gmt_modified"), @Result(property = "settleDate", column = "settle_date"), @Result(property = "merNo", column = "mer_no"), @Result(property = "amount", column = "amount"), @Result(property = "period", column = "period"), @Result(property = "splitDate", column = "split_date"), @Result(property = "accountType", column = "account_type"), @Result(property = "accountNo", column = "account_no"), @Result(property = "accountName", column = "account_name"), @Result(property = "bankCode", column = "bank_code"), @Result(property = "remark", column = "remark"), @Result(property = "extend_1", column = "extend_1"), @Result(property = "extend_2", column = "extend_2"), @Result(property = "extend_3", column = "extend_3"), @Result(property = "status", column = "status"), @Result(property = "providerCode", column = "provider_code"), @Result(property = "batchId", column = "batch_id"), @Result(property = "transDate", column = "trans_date"), @Result(property = "serverTransId", column = "server_trans_id"), @Result(property = "clientTransId", column = "client_trans_id"), @Result(property = "transStatus", column = "trans_status"), @Result(property = "queryTimes", column = "query_times"), @Result(property = "transDesc", column = "trans_desc"), @Result(property = "subject", column = "subject"), @Result(property = "reconcileDate", column = "reconcile_date"), @Result(property = "userAccount", column = "user_account"), @Result(property = "settleMode", column = "settle_mode"), @Result(property = "industryCode", column = "industry_code")})
    SplitInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select sp.* ,"
                    + " case  "
                    + " when ac.obj_type='2' then merinfo.real_name  "
                    + " else ac.obj_name   "
                    + " end  as objName, "
                    + " ac.obj_name as industryName "
                    +" from t_split_info as sp "
                    +"left join t_account ac on ac.obj_code=sp.industry_code "
                    + "LEFT JOIN t_merchant_info merinfo ON merinfo.account = ac.account "
                    +" where 1 = 1 "
                    + "<if test='params.beginTransDatetime != null'> and sp.trans_date &gt;= #{params.beginTransDatetime}</if>"
                    + "<if test='params.endTransDatetime != null'> and sp.trans_date &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.merNo != null'> and sp.mer_no = #{params.merNo}</if>"
                    + "<if test='params.clientTransId != null'> and sp.client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.industryCode != null'> and sp.industry_code = #{params.industryCode}</if>"
                    + "<if test='params.batchId != null'> and sp.batch_id = #{params.batchId}</if>"
                    + "<if test='params.userAccount != null'> and sp.user_account = #{params.userAccount}</if>"
                    + "<if test='params.status != null'> and sp.status = #{params.status}</if>"
                    + "<if test='params.transStatus != null'> and sp.trans_status = #{params.transStatus}</if>"
                    + "</script>"
    )
    @ResultMap("SplitInfoResultMap")
    Page<SplitInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 统计
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select count(1) totalCount,IFNULL(sum(amount),0) inTotalAmount from t_split_info where 1 = 1"
                    + "<if test='params.beginTransDatetime != null'> and trans_date &gt;= #{params.beginTransDatetime}</if>"
                    + "<if test='params.endTransDatetime != null'> and trans_date &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.batchId != null'> and batch_id = #{params.batchId}</if>"
                    + "<if test='params.userAccount != null'> and user_account = #{params.userAccount}</if>"
                    + "<if test='params.status != null'> and status = #{params.status}</if>"
                    + "<if test='params.transStatus != null'> and trans_status = #{params.transStatus}</if>"
                    + "</script>"
    )
    Map<String, Long> countSum(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) from t_split_info <where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='settleDate != null'> settle_date = #{settleDate} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='amount != null'> amount = #{amount} AND </if> "
                    + "<if test='period != null'> period = #{period} AND </if> "
                    + "<if test='splitDate != null'> split_date = #{splitDate} AND </if> "
                    + "<if test='accountType != null'> account_type = #{accountType} AND </if> "
                    + "<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    + "<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='remark != null'> remark = #{remark} AND </if> "
                    + "<if test='extend_1 != null'> extend_1 = #{extend_1} AND </if> "
                    + "<if test='extend_2 != null'> extend_2 = #{extend_2} AND </if> "
                    + "<if test='extend_3 != null'> extend_3 = #{extend_3} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='providerCode != null'> provider_code = #{providerCode} AND </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId} AND </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate} AND </if> "
                    + "<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
                    + "<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
                    + "<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
                    + "<if test='queryTimes != null'> query_times = #{queryTimes} AND </if> "
                    + "<if test='transDesc != null'> trans_desc = #{transDesc} AND </if> "
                    + "<if test='subject != null'> subject = #{subject} AND </if> "
                    + "<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
                    + "<if test='userAccount != null'> user_account = #{userAccount} AND </if> "
                    + "<if test='settleMode != null'> settle_mode = #{settleMode} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    int count(SplitInfoDO obj);

    /**
     * 通过条件查询单条记录
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,settle_date,mer_no,amount,period,split_date,account_type,account_no,account_name,bank_code,remark,extend_1,extend_2,extend_3,status,provider_code,batch_id,trans_date,server_trans_id,client_trans_id,trans_status,query_times,trans_desc,subject,reconcile_date,user_account,settle_mode,industry_code from t_split_info"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> id = #{id} AND </if>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='settleDate != null'> settle_date = #{settleDate} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='amount != null'> amount = #{amount} AND </if> "
                    + "<if test='period != null'> period = #{period} AND </if> "
                    + "<if test='splitDate != null'> split_date = #{splitDate} AND </if> "
                    + "<if test='accountType != null'> account_type = #{accountType} AND </if> "
                    + "<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    + "<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='remark != null'> remark = #{remark} AND </if> "
                    + "<if test='extend_1 != null'> extend_1 = #{extend_1} AND </if> "
                    + "<if test='extend_2 != null'> extend_2 = #{extend_2} AND </if> "
                    + "<if test='extend_3 != null'> extend_3 = #{extend_3} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='providerCode != null'> provider_code = #{providerCode} AND </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId} AND </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate} AND </if> "
                    + "<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
                    + "<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
                    + "<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
                    + "<if test='queryTimes != null'> query_times = #{queryTimes} AND </if> "
                    + "<if test='transDesc != null'> trans_desc = #{transDesc} AND </if> "
                    + "<if test='subject != null'> subject = #{subject} AND </if> "
                    + "<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
                    + "<if test='userAccount != null'> user_account = #{userAccount} AND </if> "
                    + "<if test='settleMode != null'> settle_mode = #{settleMode} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("SplitInfoResultMap")
    SplitInfoDO selectOne(SplitInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,settle_date,mer_no,amount,period,split_date,account_type,account_no,account_name,bank_code,remark,extend_1,extend_2,extend_3,status,provider_code,batch_id,trans_date,server_trans_id,client_trans_id,trans_status,query_times,trans_desc,subject,reconcile_date,user_account,settle_mode,industry_code from t_split_info"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='settleDate != null'> settle_date = #{settleDate} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='amount != null'> amount = #{amount} AND </if> "
                    + "<if test='period != null'> period = #{period} AND </if> "
                    + "<if test='splitDate != null'> split_date = #{splitDate} AND </if> "
                    + "<if test='accountType != null'> account_type = #{accountType} AND </if> "
                    + "<if test='accountNo != null'> account_no = #{accountNo} AND </if> "
                    + "<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='remark != null'> remark = #{remark} AND </if> "
                    + "<if test='extend_1 != null'> extend_1 = #{extend_1} AND </if> "
                    + "<if test='extend_2 != null'> extend_2 = #{extend_2} AND </if> "
                    + "<if test='extend_3 != null'> extend_3 = #{extend_3} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='providerCode != null'> provider_code = #{providerCode} AND </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId} AND </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate} AND </if> "
                    + "<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
                    + "<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
                    + "<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
                    + "<if test='queryTimes != null'> query_times = #{queryTimes} AND </if> "
                    + "<if test='transDesc != null'> trans_desc = #{transDesc} AND </if> "
                    + "<if test='subject != null'> subject = #{subject} AND </if> "
                    + "<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
                    + "<if test='userAccount != null'> user_account = #{userAccount} AND </if> "
                    + "<if test='settleMode != null'> settle_mode = #{settleMode} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("SplitInfoResultMap")
    List<SplitInfoDO> selectList(SplitInfoDO obj);

}

