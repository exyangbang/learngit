package com.scenetec.upf.operation.repository.trade;

import com.scenetec.upf.operation.model.domain.trade.TransHistoryDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Description : 历史交易流水
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 15:21
 */
@Repository
@Mapper
public interface TransHistoryMapper {

    /**
     * 根据服务端流水号查询历史交易流水
     * @param serverTransId 服务端流水号
     * @return 历史交易流水信息
     * */
    @Results(id = "transHistoryResultMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "channel_key", property = "channelKey"),
            @Result(column = "channel_code", property = "channelCode"),
            @Result(column = "channel_name", property = "channelName"),
            @Result(column = "mer_no", property = "merNo"),
            @Result(column = "client_trans_id", property = "clientTransId"),
            @Result(column = "client_trans_time", property = "clientTransTime"),
            @Result(column = "server_trans_id", property = "serverTransId"),
            @Result(column = "product_code", property = "productCode"),
            @Result(column = "trade_type", property = "tradeType"),
            @Result(column = "org_code", property = "orgCode"),
            @Result(column = "org_name", property = "orgName"),
            @Result(column = "server_batch_no", property = "serverBatchNo"),
            @Result(column = "server_link_id", property = "serverLinkId"),
            @Result(column = "trans_amount", property = "transAmount"),
            @Result(column = "real_amount", property = "realAmount"),
            @Result(column = "trans_status", property = "transStatus"),
            @Result(column = "trans_date", property = "transDate"),
            @Result(column = "trans_time", property = "transTime"),
            @Result(column = "channel_resp_time", property = "channelRespTime"),
            @Result(column = "channel_resp_code", property = "channelRespCode"),
            @Result(column = "channel_resp_id", property = "channelRespId"),
            @Result(column = "channel_resp_msg", property = "channelRespMsg"),
            @Result(column = "resp_code", property = "respCode"),
            @Result(column = "resp_exception", property = "respException"),
            @Result(column = "resp_message", property = "respMessage"),
            @Result(column = "revoke_status", property = "revokeStatus"),
            @Result(column = "refund_status", property = "refundStatus"),
            @Result(column = "reconcile_status", property = "reconcileStatus"),
            @Result(column = "trans_callback_url", property = "transCallbackUrl"),
            @Result(column = "reconcile_time", property = "reconcileTime"),
            @Result(column = "reconcile_date", property = "reconcileDate"),
            @Result(column = "description", property = "description"),
            @Result(column = "batch_sub_no", property = "batchSubNo"),
            @Result(column = "currency", property = "currency"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified"),
            @Result(column = "user_create", property = "userCreate"),
            @Result(column = "user_modified", property = "userModified"),
            @Result(column = "user_code", property = "userCode"),
            @Result(column = "acc_no", property = "accNo"),
            @Result(column = "mer_fee", property = "merFee"),
            @Result(column = "channel_fee", property = "channelFee"),
            @Result(column = "pc_flag", property = "pcFlag"),
            @Result(column = "user_type", property = "userType"),
            @Result(column = "payee_acct_no", property = "payeeAcctNo"),
            @Result(column = "payee_name", property = "payeeName"),
            @Result(column = "payer_acct_no", property = "payerAcctNo"),
            @Result(column = "payer_name", property = "payerName"),
            @Result(column = "industry_code", property = "industryCode"),
            @Result(column = "split_info_id", property = "splitInfoId"),
            @Result(column = "mer_settle_type", property = "merSettleType"),
            @Result(column = "mer_charge_mode", property = "merChargeMode"),
            @Result(column = "channel_settle_type", property = "channelSettleType"),
            @Result(column = "channel_charge_mode", property = "channelChargeMode"),
            @Result(column = "channel_settle_date", property = "channelSettleDate"),
            @Result(column = "need_channel_reconcile", property = "needChannelReconcile"),
            @Result(column = "show_payee_account_no", property = "showPayeeAccountNo"),
            @Result(column = "show_payee_account_name", property = "showPayeeAccountName")
    })
    @Select("select id,show_payee_account_no,show_payee_account_name, channel_key, channel_code, channel_name, mer_no, client_trans_id, client_trans_time, server_trans_id, product_code, trade_type, org_code, org_name, server_batch_no, server_link_id, trans_amount, real_amount, trans_status, trans_date, trans_time, channel_resp_time, channel_resp_code, channel_resp_id, channel_resp_msg, resp_code, resp_exception, resp_message, revoke_status, refund_status, reconcile_status, trans_callback_url, reconcile_time, reconcile_date, description, batch_sub_no, currency, gmt_create, gmt_modified, user_create, user_modified, user_code, acc_no, mer_fee, channel_fee, pc_flag, user_type, payee_acct_no, payee_name, payer_acct_no, payer_name, industry_code, split_info_id, mer_settle_type, mer_charge_mode, channel_settle_type, channel_charge_mode, channel_settle_date, need_channel_reconcile from t_trans_history where server_trans_id=#{serverTransId}")
    TransHistoryDO findOneByServerTransId(@Param("serverTransId") String serverTransId);

    @Update("update t_trans_history set trans_status=#{transStatus}, gmt_modified=#{gmtModified},user_modified=#{userModified} where id=#{id} AND trans_status = 'TRADE_SUCCESS'")
    int updateTransStatus(TransHistoryDO transHistoryDO);
}
