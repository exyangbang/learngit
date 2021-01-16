package com.scenetec.upf.operation.repository.trade;

import com.scenetec.upf.operation.model.domain.trade.TransFlowDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/09/12
 */
@Repository
@Mapper
public interface TransFlowMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_trans_current (id,user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,org_code,description,org_name,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{channelCode},#{channelName},#{channelRespCode},#{channelRespId},#{channelRespMsg},#{channelRespTime},#{clientTransId},#{clientTransTime},#{currency},#{orgCode},#{description},#{orgName},#{respException},#{respMessage},#{serverBatchNo},#{serverLinkId},#{serverTransId},#{reconcileDate},#{productCode},#{tradeType},#{transAmount},#{transCallbackUrl},#{transDate},#{transStatus},#{transTime},#{merNo},#{respCode},#{revokeStatus},#{refundStatus},#{reconcileStatus},#{userCode},#{batchSubNo},#{accNo})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(TransFlowDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_trans_current ("
        +" user_create, gmt_create, user_modified, gmt_modified, channel_code, channel_name, channel_resp_code, channel_resp_id, channel_resp_msg, channel_resp_time, client_trans_id, client_trans_time, currency, org_code, description, org_name, resp_exception, resp_message, server_batch_no, server_link_id, server_trans_id, reconcile_date, product_code, trade_type, trans_amount, trans_callback_url, trans_date, trans_status, trans_time, mer_no, resp_code, revoke_status, refund_status, reconcile_status, user_code, batch_sub_no, acc_no"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelCode}, #{item.channelName}, #{item.channelRespCode}, #{item.channelRespId}, #{item.channelRespMsg}, #{item.channelRespTime}, #{item.clientTransId}, #{item.clientTransTime}, #{item.currency}, #{item.orgCode}, #{item.description}, #{item.orgName}, #{item.respException}, #{item.respMessage}, #{item.serverBatchNo}, #{item.serverLinkId}, #{item.serverTransId}, #{item.reconcileDate}, #{item.productCode}, #{item.tradeType}, #{item.transAmount}, #{item.transCallbackUrl}, #{item.transDate}, #{item.transStatus}, #{item.transTime}, #{item.merNo}, #{item.respCode}, #{item.revokeStatus}, #{item.refundStatus}, #{item.reconcileStatus}, #{item.userCode}, #{item.batchSubNo}, #{item.accNo})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<TransFlowDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_trans_current ("
        +" user_create, gmt_create, user_modified, gmt_modified, channel_code, channel_name, channel_resp_code, channel_resp_id, channel_resp_msg, channel_resp_time, client_trans_id, client_trans_time, currency, org_code, description, org_name, resp_exception, resp_message, server_batch_no, server_link_id, server_trans_id, reconcile_date, product_code, trade_type, trans_amount, trans_callback_url, trans_date, trans_status, trans_time, mer_no, resp_code, revoke_status, refund_status, reconcile_status, user_code, batch_sub_no, acc_no"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.channelCode}, #{item.channelName}, #{item.channelRespCode}, #{item.channelRespId}, #{item.channelRespMsg}, #{item.channelRespTime}, #{item.clientTransId}, #{item.clientTransTime}, #{item.currency}, #{item.orgCode}, #{item.description}, #{item.orgName}, #{item.respException}, #{item.respMessage}, #{item.serverBatchNo}, #{item.serverLinkId}, #{item.serverTransId}, #{item.reconcileDate}, #{item.productCode}, #{item.tradeType}, #{item.transAmount}, #{item.transCallbackUrl}, #{item.transDate}, #{item.transStatus}, #{item.transTime}, #{item.merNo}, #{item.respCode}, #{item.revokeStatus}, #{item.refundStatus}, #{item.reconcileStatus}, #{item.userCode}, #{item.batchSubNo}, #{item.accNo})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"channel_code = VALUES(channel_code),"
            +"channel_name = VALUES(channel_name),"
            +"channel_resp_code = VALUES(channel_resp_code),"
            +"channel_resp_id = VALUES(channel_resp_id),"
            +"channel_resp_msg = VALUES(channel_resp_msg),"
            +"channel_resp_time = VALUES(channel_resp_time),"
            +"client_trans_id = VALUES(client_trans_id),"
            +"client_trans_time = VALUES(client_trans_time),"
            +"currency = VALUES(currency),"
            +"org_code = VALUES(org_code),"
            +"description = VALUES(description),"
            +"org_name = VALUES(org_name),"
            +"resp_exception = VALUES(resp_exception),"
            +"resp_message = VALUES(resp_message),"
            +"server_batch_no = VALUES(server_batch_no),"
            +"server_link_id = VALUES(server_link_id),"
            +"server_trans_id = VALUES(server_trans_id),"
            +"reconcile_date = VALUES(reconcile_date),"
            +"product_code = VALUES(product_code),"
            +"trade_type = VALUES(trade_type),"
            +"trans_amount = VALUES(trans_amount),"
            +"trans_callback_url = VALUES(trans_callback_url),"
            +"trans_date = VALUES(trans_date),"
            +"trans_status = VALUES(trans_status),"
            +"trans_time = VALUES(trans_time),"
            +"mer_no = VALUES(mer_no),"
            +"resp_code = VALUES(resp_code),"
            +"revoke_status = VALUES(revoke_status),"
            +"refund_status = VALUES(refund_status),"
            +"reconcile_status = VALUES(reconcile_status),"
            +"user_code = VALUES(user_code),"
            +"batch_sub_no = VALUES(batch_sub_no),"
            +"acc_no = VALUES(acc_no)"
        +"</script>"
    )
    int modifyList(List<TransFlowDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_trans_current where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_trans_current <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode}, </if> "
            +"<if test='channelName != null'> channel_name = #{channelName}, </if> "
            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode}, </if> "
            +"<if test='channelRespId != null'> channel_resp_id = #{channelRespId}, </if> "
            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg}, </if> "
            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime}, </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId}, </if> "
            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime}, </if> "
            +"<if test='currency != null'> currency = #{currency}, </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode}, </if> "
            +"<if test='description != null'> description = #{description}, </if> "
            +"<if test='orgName != null'> org_name = #{orgName}, </if> "
            +"<if test='respException != null'> resp_exception = #{respException}, </if> "
            +"<if test='respMessage != null'> resp_message = #{respMessage}, </if> "
            +"<if test='serverBatchNo != null'> server_batch_no = #{serverBatchNo}, </if> "
            +"<if test='serverLinkId != null'> server_link_id = #{serverLinkId}, </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate}, </if> "
            +"<if test='productCode != null'> product_code = #{productCode}, </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType}, </if> "
            +"<if test='transAmount != null'> trans_amount = #{transAmount}, </if> "
            +"<if test='transCallbackUrl != null'> trans_callback_url = #{transCallbackUrl}, </if> "
            +"<if test='transDate != null'> trans_date = #{transDate}, </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus}, </if> "
            +"<if test='transTime != null'> trans_time = #{transTime}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='respCode != null'> resp_code = #{respCode}, </if> "
            +"<if test='revokeStatus != null'> revoke_status = #{revokeStatus}, </if> "
            +"<if test='refundStatus != null'> refund_status = #{refundStatus}, </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus}, </if> "
            +"<if test='userCode != null'> user_code = #{userCode}, </if> "
            +"<if test='batchSubNo != null'> batch_sub_no = #{batchSubNo}, </if> "
            +"<if test='accNo != null'> acc_no = #{accNo}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(TransFlowDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,description,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no,industry_code,(select name from t_industry where code=industry_code) industry_name,payee_acct_no,payee_name,remote_ip,payment_type,payment_period,payment_settle_status,order_id,summary_description from t_trans_current where id = #{id}")
 	@Results(id="TransFlowResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "channelCode", column = "channel_code"),@Result(property = "channelName", column = "channel_name"),@Result(property = "channelRespCode", column = "channel_resp_code"),@Result(property = "channelRespId", column = "channel_resp_id"),@Result(property = "channelRespMsg", column = "channel_resp_msg"),@Result(property = "channelRespTime", column = "channel_resp_time"),@Result(property = "clientTransId", column = "client_trans_id"),@Result(property = "clientTransTime", column = "client_trans_time"),@Result(property = "currency", column = "currency"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryName", column = "industry_name"),@Result(property = "description", column = "description"),@Result(property = "payeeAcctNo", column = "payee_acct_no"),@Result(property = "payeeName", column = "payee_name"),@Result(property = "respException", column = "resp_exception"),@Result(property = "respMessage", column = "resp_message"),@Result(property = "serverBatchNo", column = "server_batch_no"),@Result(property = "serverLinkId", column = "server_link_id"),@Result(property = "serverTransId", column = "server_trans_id"),@Result(property = "reconcileDate", column = "reconcile_date"),@Result(property = "productCode", column = "product_code"),@Result(property = "tradeType", column = "trade_type"),@Result(property = "transAmount", column = "trans_amount"),@Result(property = "transCallbackUrl", column = "trans_callback_url"),@Result(property = "transDate", column = "trans_date"),@Result(property = "transStatus", column = "trans_status"),@Result(property = "transTime", column = "trans_time"),@Result(property = "merNo", column = "mer_no"),@Result(property = "respCode", column = "resp_code"),@Result(property = "reconcileStatus", column = "reconcile_status"),@Result(property = "userCode", column = "user_code"),@Result(property = "batchSubNo", column = "batch_sub_no")
            ,@Result(property = "accNo", column = "acc_no"),@Result(property = "payeeAccount", column = "payee_account"),@Result(property = "remoteIp", column = "remote_ip"),@Result(property = "paymentType", column = "payment_type"),@Result(property = "paymentPeriod", column = "payment_period"),@Result(property = "paymentSettleStatus", column = "payment_settle_status"),@Result(property = "orderId", column = "order_id"),@Result(property = "summaryDescription", column = "summary_description")})
 	TransFlowDO getCurrentById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return insert(payee_acct_no, 7, 7, '****')
     */
 	@Select(
        "<script>"
 			+ "select id,remote_ip,payment_type,payment_period,payment_settle_status,order_id,summary_description,channel_settle_date as channelSettleDate,show_payee_account_no as showPayeeAccountNo,show_payee_account_name as showPayeeAccountName,user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,description,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no,industry_code,(select name from t_industry where code=industry_code) industry_name,payee_acct_no,payee_name,payer_name,payer_acct_no,ci.mer_fee as merFee,ci.channel_fee as channelFee "
                +" , CASE "
                +" WHEN trade_type='WITHDRAW' THEN "
                +" payee_account "
                +" ELSE "
                +"  payer_account"
                +" END payerAccount"
                +" from t_trans_current ci where 1 = 1"
                + "<if test='params.beginTransDatetime != null'> and concat(trans_date,trans_time) &gt;= #{params.beginTransDatetime}</if>"
                + "<if test='params.endTransDatetime != null'> and concat(trans_date,trans_time) &lt;= #{params.endTransDatetime}</if>"
		        + "<if test='params.transStatus != null'> and trans_status = #{params.transStatus}</if>"
		        + "<if test='params.reconcileStatus != null'> and reconcile_status = #{params.reconcileStatus}</if>"
		        + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
		        + "<if test='params.serverTransId != null'> and server_trans_id = #{params.serverTransId}</if>"
                + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
		        + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
		        + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
		        + "<if test='params.tradeType != null'> and trade_type = #{params.tradeType}</if>"
		        + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType != null ' > and payer_account = #{params.payerAccount}</if>"
		        + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType == null '> and payer_account = #{params.payerAccount} or (payee_account = #{params.payerAccount} and trade_type = 'WITHDRAW')</if>"
		        + "<if test='params.payerAccount != null and params.tradeType == \"WITHDRAW\".toString() '> and payee_account = #{params.payerAccount}</if>"
                + "order by gmt_modified desc"
        + "</script>"
    )
    @ResultMap("TransFlowResultMap")
    Page<TransFlowDO> listCurrent(@Param("params") Map<String, Object> params);





    /**
     * 显示汇总值，汇总交易总笔数、交易总金额
     * @param
     * @return
     */
    @Select(
            "<script>" +
                    "SELECT count(*) totalCount,IFNULL(sum(trans_amount),0) transAmount ,IFNULL(sum(mer_fee),0) merFeeTotal,IFNULL(sum(channel_fee),0) channelFeeTotal from t_trans_current ci where 1 = 1"
                    + "<if test='params.beginTransDatetime != null'> and concat(trans_date,trans_time) &gt;= #{params.beginTransDatetime}</if>"
                    + "<if test='params.endTransDatetime != null'> and concat(trans_date,trans_time) &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.transStatus != null'> and trans_status = #{params.transStatus}</if>"
                    + "<if test='params.reconcileStatus != null'> and reconcile_status = #{params.reconcileStatus}</if>"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.serverTransId != null'> and server_trans_id = #{params.serverTransId}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
                    + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                    + "<if test='params.tradeType != null'> and trade_type = #{params.tradeType}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType != null ' > and payer_account = #{params.payerAccount}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType == null '> and payer_account = #{params.payerAccount} or (payee_account = #{params.payerAccount} and trade_type = 'WITHDRAW')</if>"
                    + "<if test='params.payerAccount != null and params.tradeType == \"WITHDRAW\".toString() '> and payee_account = #{params.payerAccount}</if>"+
                    "</script>"
    )
    Map<String,Long> totalCount(@Param("params") Map<String, Object> params);


    /**
     * 查询详细
     * @param id
     * @return
     */
    @Select("select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,description,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no,industry_code,(select name from t_industry where code=industry_code) industry_name,payee_acct_no,payee_name,channel_settle_date from t_trans_history where id = #{id}")
    @ResultMap("TransFlowResultMap")
    TransFlowDO getHistoryById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return insert(payee_acct_no, 7, 7, '****')
     */
    @Select(
            "<script>"
                    + "select id,remote_ip,payment_type,payment_period,payment_settle_status,order_id,summary_description,show_payee_account_no as showPayeeAccountNo,show_payee_account_name as showPayeeAccountName,channel_settle_date as channelSettleDate, user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,description,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no,industry_code,(select name from t_industry where code=industry_code) industry_name, payee_acct_no,payee_name,ci.mer_fee as merFee,ci.channel_fee as channelFee " +
                    " , CASE "
                    +" WHEN trade_type='WITHDRAW' THEN "
                    +" payee_account "
                    +" ELSE "
                    +"  payer_account"
                    +" END payerAccount"
                    +" from t_trans_history ci where 1 = 1"
                    + "<if test='params.beginTransDatetime != null'> and concat(trans_date,trans_time) &gt;= #{params.beginTransDatetime}</if>"
                    + "<if test='params.endTransDatetime != null'> and concat(trans_date,trans_time) &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.transStatus != null'> and trans_status = #{params.transStatus}</if>"
                    + "<if test='params.reconcileStatus != null'> and reconcile_status = #{params.reconcileStatus}</if>"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.serverTransId != null'> and server_trans_id = #{params.serverTransId}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                    + "<if test='params.tradeType != null'> and trade_type = #{params.tradeType}</if>"
                    + "<if test='params.channelSettleDate != null'> and channel_settle_date = #{params.channelSettleDate}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType != null ' > and payer_account = #{params.payerAccount}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType == null '> and payer_account = #{params.payerAccount} or (payee_account = #{params.payerAccount} and trade_type = 'WITHDRAW')</if>"
                    + "<if test='params.payerAccount != null and params.tradeType == \"WITHDRAW\".toString() '> and payee_account = #{params.payerAccount}</if>"
                    + "order by trans_date desc,trans_time desc"
                    + "</script>"
    )
    @ResultMap("TransFlowResultMap")
    Page<TransFlowDO> listHistory(@Param("params") Map<String, Object> params);


    /**
     * 显示汇总值，汇总交易总笔数、交易总金额
     * @param
     * @return
     */
    @Select(
            "<script>" +
                    "SELECT count(*) totalCount,sum(trans_amount) transAmount,IFNULL(sum(mer_fee),0) merFeeTotal,IFNULL(sum(channel_fee),0) channelFeeTotal from t_trans_history ci where 1 = 1"
                    + "<if test='params.beginTransDatetime != null'> and concat(trans_date,trans_time) &gt;= #{params.beginTransDatetime}</if>"
                    + "<if test='params.endTransDatetime != null'> and concat(trans_date,trans_time) &lt;= #{params.endTransDatetime}</if>"
                    + "<if test='params.transStatus != null'> and trans_status = #{params.transStatus}</if>"
                    + "<if test='params.reconcileStatus != null'> and reconcile_status = #{params.reconcileStatus}</if>"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.serverTransId != null'> and server_trans_id = #{params.serverTransId}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                    + "<if test='params.tradeType != null'> and trade_type = #{params.tradeType}</if>"
                    + "<if test='params.channelSettleDate != null'> and channel_settle_date = #{params.channelSettleDate}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType != null ' > and payer_account = #{params.payerAccount}</if>"
                    + "<if test='params.payerAccount != null and params.tradeType != \"WITHDRAW\".toString() and params.tradeType == null '> and payer_account = #{params.payerAccount} or (payee_account = #{params.payerAccount} and trade_type = 'WITHDRAW')</if>"
                    + "<if test='params.payerAccount != null and params.tradeType == \"WITHDRAW\".toString() '> and payee_account = #{params.payerAccount}</if>"+
                    "</script>"
    )
    Map<String,Long> totalCountHistory(@Param("params") Map<String, Object> params);
    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_trans_current <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='channelName != null'> channel_name = #{channelName} AND </if> "
            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode} AND </if> "
            +"<if test='channelRespId != null'> channel_resp_id = #{channelRespId} AND </if> "
            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg} AND </if> "
            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime} AND </if> "
            +"<if test='currency != null'> currency = #{currency} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='description != null'> description = #{description} AND </if> "
            +"<if test='orgName != null'> org_name = #{orgName} AND </if> "
            +"<if test='respException != null'> resp_exception = #{respException} AND </if> "
            +"<if test='respMessage != null'> resp_message = #{respMessage} AND </if> "
            +"<if test='serverBatchNo != null'> server_batch_no = #{serverBatchNo} AND </if> "
            +"<if test='serverLinkId != null'> server_link_id = #{serverLinkId} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
            +"<if test='transCallbackUrl != null'> trans_callback_url = #{transCallbackUrl} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='transTime != null'> trans_time = #{transTime} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='respCode != null'> resp_code = #{respCode} AND </if> "
            +"<if test='revokeStatus != null'> revoke_status = #{revokeStatus} AND </if> "
            +"<if test='refundStatus != null'> refund_status = #{refundStatus} AND </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus} AND </if> "
            +"<if test='userCode != null'> user_code = #{userCode} AND </if> "
            +"<if test='batchSubNo != null'> batch_sub_no = #{batchSubNo} AND </if> "
            +"<if test='accNo != null'> acc_no = #{accNo} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(TransFlowDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,org_code,description,org_name,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no from t_trans_current"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='channelName != null'> channel_name = #{channelName} AND </if> "
            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode} AND </if> "
            +"<if test='channelRespId != null'> channel_resp_id = #{channelRespId} AND </if> "
            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg} AND </if> "
            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime} AND </if> "
            +"<if test='currency != null'> currency = #{currency} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='description != null'> description = #{description} AND </if> "
            +"<if test='orgName != null'> org_name = #{orgName} AND </if> "
            +"<if test='respException != null'> resp_exception = #{respException} AND </if> "
            +"<if test='respMessage != null'> resp_message = #{respMessage} AND </if> "
            +"<if test='serverBatchNo != null'> server_batch_no = #{serverBatchNo} AND </if> "
            +"<if test='serverLinkId != null'> server_link_id = #{serverLinkId} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
            +"<if test='transCallbackUrl != null'> trans_callback_url = #{transCallbackUrl} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='transTime != null'> trans_time = #{transTime} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='respCode != null'> resp_code = #{respCode} AND </if> "
            +"<if test='revokeStatus != null'> revoke_status = #{revokeStatus} AND </if> "
            +"<if test='refundStatus != null'> refund_status = #{refundStatus} AND </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus} AND </if> "
            +"<if test='userCode != null'> user_code = #{userCode} AND </if> "
            +"<if test='batchSubNo != null'> batch_sub_no = #{batchSubNo} AND </if> "
            +"<if test='accNo != null'> acc_no = #{accNo} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("TransFlowResultMap")
    TransFlowDO selectOne(TransFlowDO obj);
    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */

    @Select("select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,description,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no,industry_code,(select name from t_industry where code=industry_code) industry_name,payee_acct_no,payee_name,channel_settle_date from t_trans_history where server_trans_id = #{ServerTransId}")
    @ResultMap("TransFlowResultMap")
    TransFlowDO selectOneHistory(@Param("ServerTransId") String ServerTransId);
    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,channel_code,channel_name,channel_resp_code,channel_resp_id,channel_resp_msg,channel_resp_time,client_trans_id,client_trans_time,currency,org_code,description,org_name,resp_exception,resp_message,server_batch_no,server_link_id,server_trans_id,reconcile_date,product_code,trade_type,trans_amount,trans_callback_url,trans_date,trans_status,trans_time,mer_no,resp_code,revoke_status,refund_status,reconcile_status,user_code,batch_sub_no,acc_no from t_trans_current"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='channelCode != null'> channel_code = #{channelCode} AND </if> "
            +"<if test='channelName != null'> channel_name = #{channelName} AND </if> "
            +"<if test='channelRespCode != null'> channel_resp_code = #{channelRespCode} AND </if> "
            +"<if test='channelRespId != null'> channel_resp_id = #{channelRespId} AND </if> "
            +"<if test='channelRespMsg != null'> channel_resp_msg = #{channelRespMsg} AND </if> "
            +"<if test='channelRespTime != null'> channel_resp_time = #{channelRespTime} AND </if> "
            +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
            +"<if test='clientTransTime != null'> client_trans_time = #{clientTransTime} AND </if> "
            +"<if test='currency != null'> currency = #{currency} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='description != null'> description = #{description} AND </if> "
            +"<if test='orgName != null'> org_name = #{orgName} AND </if> "
            +"<if test='respException != null'> resp_exception = #{respException} AND </if> "
            +"<if test='respMessage != null'> resp_message = #{respMessage} AND </if> "
            +"<if test='serverBatchNo != null'> server_batch_no = #{serverBatchNo} AND </if> "
            +"<if test='serverLinkId != null'> server_link_id = #{serverLinkId} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
            +"<if test='reconcileDate != null'> reconcile_date = #{reconcileDate} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
            +"<if test='transCallbackUrl != null'> trans_callback_url = #{transCallbackUrl} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='transTime != null'> trans_time = #{transTime} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='respCode != null'> resp_code = #{respCode} AND </if> "
            +"<if test='revokeStatus != null'> revoke_status = #{revokeStatus} AND </if> "
            +"<if test='refundStatus != null'> refund_status = #{refundStatus} AND </if> "
            +"<if test='reconcileStatus != null'> reconcile_status = #{reconcileStatus} AND </if> "
            +"<if test='userCode != null'> user_code = #{userCode} AND </if> "
            +"<if test='batchSubNo != null'> batch_sub_no = #{batchSubNo} AND </if> "
            +"<if test='accNo != null'> acc_no = #{accNo} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("TransFlowResultMap")
    List<TransFlowDO> selectList(TransFlowDO obj);

}

