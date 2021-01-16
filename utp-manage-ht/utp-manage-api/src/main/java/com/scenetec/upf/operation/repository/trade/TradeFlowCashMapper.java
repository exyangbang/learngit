package com.scenetec.upf.operation.repository.trade;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.trade.TradeFlowCashDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.Map;

/**
 * @author LIFA
 * @date 2018/07/25
 */
@Repository
@Mapper
public interface TradeFlowCashMapper {

    /**
     * 查询详细
     * @param id
     * @return
     */
    @Select("select id,client_flow_id,platform_mer_id,trade_date,trade_time,txn_type,txn_sub_type,batch_no,acq_ins_code,biz_type,order_id,mer_type,mer_code,mer_name,mer_abbr,sub_mer_id,sub_mer_name,sub_mer_abbr,txn_time,acc_type,acc_no,txn_amt,currency_code,req_reserved,pay_mode,bill_type,bill_no,interactive_mode,query_id,recheck_flag,trade_status,callback_number,callback_status,callback_time,remark from t_trade_flow_cash where id = #{id}")
    @Results(id="TradeFlowCashMapper", value = {@Result(property = "id", column = "id"),@Result(property = "clientFlowId", column = "client_flow_id"),@Result(property = "platformMerId", column = "platform_mer_id"),@Result(property = "tradeDate", column = "trade_date"),@Result(property = "tradeTime", column = "trade_time"),@Result(property = "txnType", column = "txn_type"),@Result(property = "txnSubType", column = "txn_sub_type"),@Result(property = "batchNo", column = "batch_no"),@Result(property = "acqInsCode", column = "acq_ins_code"),@Result(property = "bizType", column = "biz_type"),@Result(property = "orderId", column = "order_id"),@Result(property = "merType", column = "mer_type"),@Result(property = "merCode", column = "mer_code"),@Result(property = "merName", column = "mer_name"),@Result(property = "merAbbr", column = "mer_abbr"),@Result(property = "subMerId", column = "sub_mer_id"),@Result(property = "subMerName", column = "sub_mer_name"),@Result(property = "subMerAbbr", column = "sub_mer_abbr"),@Result(property = "txnTime", column = "txn_time"),@Result(property = "accType", column = "acc_type"),@Result(property = "accNo", column = "acc_no"),@Result(property = "txnAmt", column = "txn_amt"),@Result(property = "currencyCode", column = "currency_code"),@Result(property = "reqReserved", column = "req_reserved"),@Result(property = "payMode", column = "pay_mode"),@Result(property = "billType", column = "bill_type"),@Result(property = "billNo", column = "bill_no"),@Result(property = "interactiveMode", column = "interactive_mode"),@Result(property = "queryId", column = "query_id"),@Result(property = "recheckFlag", column = "recheck_flag"),@Result(property = "tradeStatus", column = "trade_status"),@Result(property = "callbackNumber", column = "callback_number"),@Result(property = "callbackStatus", column = "callback_status"),@Result(property = "callbackTime", column = "callback_time"),@Result(property = "remark", column = "remark"),@Result(property = "createTime", column = "create_time"),@Result(property = "updateTime", column = "update_time")})
    TradeFlowCashDO getById(@Param("id") Long id);


    /**
     * 查询列表
     * @param params
     * @return
     */
    @Select(
        "<script>"
                + "select a.id,a.client_flow_id,a.platform_mer_id,a.trade_date,a.trade_time,a.txn_type,a.txn_sub_type ," +
                "a.batch_no,b.full_name as \"acq_ins_code\" ,a.biz_type,order_id,a.mer_type,a.mer_code,a.mer_name,mer_abbr ,a.sub_mer_id,a.sub_mer_name," +
                "a.sub_mer_abbr,a.txn_time,a.acc_type,a.acc_no,a.txn_amt,a.currency_code,a.req_reserved ,a.pay_mode,a.bill_type,a.bill_no,a.interactive_mode,a.query_id," +
                "a.recheck_flag,a.trade_status,a.callback_number,a.callback_status,a.callback_time,a.remark,a.create_time,a.update_time from t_trade_flow_cash a left join t_organization b on a.acq_ins_code = b.org_code where 1 = 1"
                + "<if test='params.beginTradeDate != null and params.beginTradeDate !=\"\"'> and a.trade_date >= #{params.beginTradeDate}</if>"
                + "<if test='params.endTradeDate != null and params.endTradeDate !=\"\"'> and a.trade_date &lt;= #{params.endTradeDate}</if>"
                + "<if test='params.beginTradeTime != null and params.beginTradeTime !=\"\"'> and a.trade_time >= #{params.beginTradeTime}</if>"
                + "<if test='params.endTradeTime != null and params.beginTradeTime !=\"\"'> and a.trade_time &lt;= #{params.endTradeTime}</if>"
                + "<if test='params.tradeStatus != null and params.tradeStatus !=\"\"'> and a.trade_status = #{params.tradeStatus}</if>"
                + "<if test='params.merCode != null and params.merCode !=\"\"'> and a.mer_code = #{params.merCode}</if>"
                + "<if test='params.clientFlowId != null and params.clientFlowId !=\"\"'> and a.client_flow_id = #{params.clientFlowId}</if>"
                + "<if test='params.id != null and params.id !=\"\"'> and a.id = #{params.id}</if>"
                + "<if test='params.acqInsCode != null and params.acqInsCode !=\"\"'> and a.acq_ins_code = #{params.acqInsCode}</if>"
                + "<if test='params.bizType != null and params.beginTradeTime !=\"\"'> and a.biz_type = #{params.bizType}</if>"
                + "<if test='params.txnType != null and params.txnType !=\"\"'> and a.txn_type = #{params.txnType}</if>"
         + "</script>"
    )
    @ResultMap("TradeFlowCashMapper")
    Page<TradeFlowCashDO> list(@Param("params") Map<String, Object> params);
}

