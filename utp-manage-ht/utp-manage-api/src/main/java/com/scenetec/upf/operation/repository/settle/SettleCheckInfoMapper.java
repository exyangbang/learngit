package com.scenetec.upf.operation.repository.settle;

import com.scenetec.upf.operation.model.domain.settle.SettleCheckInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/09/13
 */
@Repository
@Mapper
public interface SettleCheckInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_settle_check_info (id,user_create,gmt_create,user_modified,gmt_modified,org_code,mer_no,product_code,trade_type,client_trans_id,server_trans_id,trans_amount,trans_status,client_trans_time,channel_resp_time,channel_resp_code,channel_resp_msg,error_type,error_desc,status,remark) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{orgCode},#{merNo},#{productCode},#{tradeType},#{clientTransId},#{serverTransId},#{transAmount},#{transStatus},#{clientTransTime},#{channelRespTime},#{channelRespCode},#{channelRespMsg},#{errorType},#{errorDesc},#{status},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(SettleCheckInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_settle_check_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, org_code, mer_no, product_code, trade_type, client_trans_id, server_trans_id, trans_amount, trans_status, client_trans_time, channel_resp_time, channel_resp_code, channel_resp_msg, error_type, error_desc, status, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.orgCode}, #{item.merNo}, #{item.productCode}, #{item.tradeType}, #{item.clientTransId}, #{item.serverTransId}, #{item.transAmount}, #{item.transStatus}, #{item.clientTransTime}, #{item.channelRespTime}, #{item.channelRespCode}, #{item.channelRespMsg}, #{item.errorType}, #{item.errorDesc}, #{item.status}, #{item.remark})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<SettleCheckInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_settle_check_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, org_code, mer_no, product_code, trade_type, client_trans_id, server_trans_id, trans_amount, trans_status, client_trans_time, channel_resp_time, channel_resp_code, channel_resp_msg, error_type, error_desc, status, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.orgCode}, #{item.merNo}, #{item.productCode}, #{item.tradeType}, #{item.clientTransId}, #{item.serverTransId}, #{item.transAmount}, #{item.transStatus}, #{item.clientTransTime}, #{item.channelRespTime}, #{item.channelRespCode}, #{item.channelRespMsg}, #{item.errorType}, #{item.errorDesc}, #{item.status}, #{item.remark})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"org_code = VALUES(org_code),"
            +"mer_no = VALUES(mer_no),"
            +"product_code = VALUES(product_code),"
            +"trade_type = VALUES(trade_type),"
            +"client_trans_id = VALUES(client_trans_id),"
            +"server_trans_id = VALUES(server_trans_id),"
            +"trans_amount = VALUES(trans_amount),"
            +"trans_status = VALUES(trans_status),"
            +"client_trans_time = VALUES(client_trans_time),"
            +"channel_resp_time = VALUES(channel_resp_time),"
            +"channel_resp_code = VALUES(channel_resp_code),"
            +"channel_resp_msg = VALUES(channel_resp_msg),"
            +"error_type = VALUES(error_type),"
            +"error_desc = VALUES(error_desc),"
            +"status = VALUES(status),"
            +"remark = VALUES(remark)"
        +"</script>"
    )
    int modifyList(List<SettleCheckInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_settle_check_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_settle_check_info <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
//            +"<if test='orgCode != null'> org_code = #{orgCode}, </if> "
//            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
//            +"<if test='productCode != null'> product_code = #{productCode}, </if> "
//            +"<if test='tradeType != null'> trade_type = #{tradeType}, </if> "
//            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId}, </if> "
//            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "
//            +"<if test='transAmount != null'> trans_amount = #{transAmount}, </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus}, </if> "
//            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime}, </if> "
//            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime}, </if> "
//            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode}, </if> "
//            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg}, </if> "
//            +"<if test='errorType != null'> error_type = #{errorType}, </if> "
//            +"<if test='errorDesc != null'> error_desc = #{errorDesc}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(SettleCheckInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,(select name from t_industry where code=ci.industry_code) industry_name,mer_no,product_code,trade_type,client_trans_id,server_trans_id,trans_amount,trans_status,trans_date,client_trans_time,channel_resp_time,channel_resp_code,channel_resp_msg,error_type,error_desc,status,remark,payee_acct_no from t_settle_check_info ci where id = #{id}")
 	@Results(id="SettleCheckInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryName", column = "industry_name"),@Result(property = "channelCode", column = "channel_code"),@Result(property = "channelName", column = "channel_name"),@Result(property = "merNo", column = "mer_no"),@Result(property = "merName", column = "mer_name"),@Result(property = "productCode", column = "product_code"),@Result(property = "tradeType", column = "trade_type"),@Result(property = "clientTransId", column = "client_trans_id"),@Result(property = "serverTransId", column = "server_trans_id"),@Result(property = "transAmount", column = "trans_amount"),@Result(property = "transStatus", column = "trans_status"),@Result(property = "transDate", column = "trans_date"),@Result(property = "clientTransTime", column = "client_trans_time"),@Result(property = "channelRespTime", column = "channel_resp_time"),@Result(property = "channelRespCode", column = "channel_resp_code"),@Result(property = "channelRespMsg", column = "channel_resp_msg"),@Result(property = "errorType", column = "error_type"),@Result(property = "errorDesc", column = "error_desc"),@Result(property = "status", column = "status"),@Result(property = "remark", column = "remark"),@Result(property = "payeeAcctNo", column = "payee_acct_no"),@Result(property = "payeeName", column = "payee_name")})
 	SettleCheckInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return insert(payee_acct_no, 7, 7, '****')
     */
 	@Select(
        "<script>"
 			+ "select id,reconcile_time as reconcileTime,trans_time as transTime,channel_settle_date as channelSettleDate,show_payee_account_no as showPayeeAccountNo,show_payee_account_name as showPayeeAccountName, user_create,gmt_create,user_modified,gmt_modified,industry_code,(select name from t_industry where code=ci.industry_code) industry_name,mer_no,product_code,trade_type,client_trans_id,server_trans_id,trans_amount,trans_status,trans_date,client_trans_time,channel_resp_time,channel_resp_code,channel_resp_msg,error_type,error_desc,status,remark, payee_acct_no,payee_name,channel_code,channel_name,audit_status as auditStatus" +
                " , CASE "
                +" WHEN trade_type='WITHDRAW' THEN "
                +" payee_account "
                +" ELSE "
                +"  payer_account"
                +" END payerAccount"
                +" from t_settle_check_info ci where 1 = 1"
                + "<if test='params.beginTransDatetime != null'> and concat(trans_date,trans_time) &gt;= #{params.beginTransDatetime}</if>"
                + "<if test='params.endTransDatetime != null'> and concat(trans_date,trans_time) &lt;= #{params.endTransDatetime}</if>"
                + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
		        + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
		        + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
		        + "<if test='params.serverTransId != null'> and server_trans_id = #{params.serverTransId}</if>"
		        + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                + "<if test='params.tradeType != null'> and trade_type = #{params.tradeType}</if>"
                + "<if test='params.transDate != null'> and trans_date = #{params.transDate}</if>"
		        + "<if test='params.errorType != null'> and <if test='params.fErrorType != null'> ( </if> error_type = #{params.errorType}</if>"
		        + "<if test='params.fErrorType != null'> or error_type = #{params.fErrorType})</if>"
		        + "<if test='params.status != null'> and status = #{params.status}</if>"
		        + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType != null ' > and payer_account = #{params.payerAccount}</if>"
                + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType == null '> and payer_account = #{params.payerAccount} or (payee_account = #{params.payerAccount} and trade_type = 'WITHDRAW')</if>"
                + "<if test='params.payerAccount != null and params.tradeType == \"WITHDRAW\".toString() '> and payee_account = #{params.payerAccount}</if>"
                +"order by trans_date desc ,trans_time desc"
        + "</script>"
    )
    @ResultMap("SettleCheckInfoResultMap")
    Page<SettleCheckInfoDO> list(@Param("params") Map<String, Object> params);


    /**
     * 统计
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select count(1) totalCount,IFNULL(sum(trans_amount),0) inTotalAmount from t_settle_check_info where 1 = 1"
                    + "<if test='params.beginTransDatetime != null'> and client_trans_time &gt;= #{params.beginTransDatetime}</if>"
                    + "<if test='params.endTransDatetime != null'> and client_trans_time &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.serverTransId != null'> and server_trans_id = #{params.serverTransId}</if>"
                    + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                    + "<if test='params.tradeType != null'> and trade_type = #{params.tradeType}</if>"
                    + "<if test='params.transDate != null'> and trans_date = #{params.transDate}</if>"
                    + "<if test='params.errorType != null'> and <if test='params.fErrorType != null'> ( </if> error_type = #{params.errorType}</if>"
                    + "<if test='params.fErrorType != null'> or error_type = #{params.fErrorType})</if>"
                    + "<if test='params.status != null'> and status = #{params.status}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType != null ' > and payer_account = #{params.payerAccount}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType == null '> and payer_account = #{params.payerAccount} or (payee_account = #{params.payerAccount} and trade_type = 'WITHDRAW')</if>"
                    + "<if test='params.payerAccount != null and params.tradeType == \"WITHDRAW\".toString() '> and payee_account = #{params.payerAccount}</if>"
                    + "</script>"
    )
    Map<String, Long> countSum(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_settle_check_info <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime} AND </if> "
            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime} AND </if> "
            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode} AND </if> "
            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg} AND </if> "
            +"<if test='errorType != null'> error_type = #{errorType} AND </if> "
            +"<if test='errorDesc != null'> error_desc = #{errorDesc} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(SettleCheckInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,org_code,mer_no,product_code,trade_type,client_trans_id,server_trans_id,trans_amount,trans_status,client_trans_time,channel_resp_time,channel_resp_code,channel_resp_msg,error_type,error_desc,status,remark from t_settle_check_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime} AND </if> "
            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime} AND </if> "
            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode} AND </if> "
            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg} AND </if> "
            +"<if test='errorType != null'> error_type = #{errorType} AND </if> "
            +"<if test='errorDesc != null'> error_desc = #{errorDesc} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SettleCheckInfoResultMap")
    SettleCheckInfoDO selectOne(SettleCheckInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,org_code,mer_no,product_code,trade_type,client_trans_id,server_trans_id,trans_amount,trans_status,client_trans_time,channel_resp_time,channel_resp_code,channel_resp_msg,error_type,error_desc,status,remark from t_settle_check_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime} AND </if> "
            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime} AND </if> "
            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode} AND </if> "
            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg} AND </if> "
            +"<if test='errorType != null'> error_type = #{errorType} AND </if> "
            +"<if test='errorDesc != null'> error_desc = #{errorDesc} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SettleCheckInfoResultMap")
    List<SettleCheckInfoDO> selectList(SettleCheckInfoDO obj);

}

