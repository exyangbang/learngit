package com.scenetec.upf.operation.repository.trade;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.trade.TransReexchangeDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description : 退汇流水信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 15:22
 */
@Repository
@Mapper
public interface TransReexchangeMapper {

    /**
     * 根据id查询退汇流水信息
     * @param id 主键
     * @return 退汇流水信息
     * */
    @Results(id = "transReexchangeResultMap", value = {
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
            @Result(column = "reconcile_status", property = "reconcileStatus"),
            @Result(column = "reconcile_time", property = "reconcileTime"),
            @Result(column = "reconcile_date", property = "reconcileDate"),
            @Result(column = "payee_acct_no", property = "payeeAcctNo"),
            @Result(column = "payee_name", property = "payeeName"),
            @Result(column = "payer_acct_no", property = "payerAcctNo"),
            @Result(column = "payer_name", property = "payerName"),
            @Result(column = "industry_code", property = "industryCode"),
            @Result(column = "channel_settle_date", property = "channelSettleDate"),
            @Result(column = "solve_status", property = "solveStatus"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified"),
            @Result(column = "user_create", property = "userCreate"),
            @Result(column = "user_modified", property = "userModified"),
            @Result(column = "industry_name", property = "industryName")
    })
    @Select("select id, channel_key, channel_code, channel_name, mer_no, client_trans_id, client_trans_time, server_trans_id, product_code, trade_type, org_code, org_name, server_batch_no, server_link_id, trans_amount, real_amount, trans_status, trans_date, trans_time, reconcile_status, reconcile_time, reconcile_date, payee_acct_no, payee_name, payer_acct_no, payer_name, industry_code, channel_settle_date, solve_status, gmt_create, gmt_modified, user_create, user_modified,(select name from t_industry where code=industry_code) industry_name from t_trans_reexchange where id=#{id}")
    TransReexchangeDO findOne(@Param("id") long id);

    /**
     * 保存退汇流水信息
     * @param transReexchangeDO 退汇流水信息对象
     * @return 保存结果
     * */
    @Insert("INSERT INTO t_trans_reexchange (id, channel_key, channel_code, channel_name, mer_no, client_trans_id, client_trans_time, server_trans_id, product_code, trade_type, org_code, org_name" +
            ", server_batch_no, server_link_id, trans_amount, real_amount, trans_status, trans_date, trans_time, reconcile_status, reconcile_time, reconcile_date, payee_acct_no" +
            ", payee_name, payer_acct_no, payer_name, industry_code, channel_settle_date, solve_status, gmt_create, gmt_modified, user_create, user_modified) VALUES " +
            "(#{id}, #{channelKey}, #{channelCode}, #{channelName}, #{merNo}, #{clientTransId}, #{clientTransTime}, #{serverTransId}, #{productCode}, #{tradeType}, #{orgCode}, #{orgName}" +
            ", #{serverBatchNo}, #{serverLinkId}, #{transAmount}, #{realAmount}, #{transStatus}, #{transDate}, #{transTime}, #{reconcileStatus}, #{reconcileTime}, #{reconcileDate}, #{payeeAcctNo}" +
            ", #{payeeName}, #{payerAcctNo}, #{payerName}, #{industryCode}, #{channelSettleDate}, #{solveStatus}, #{gmtCreate}, #{gmtModified}, #{userCreate}, #{userModified})")
    int insert(TransReexchangeDO transReexchangeDO);

    /**
     * 查询总数
     * @param serverTransId
     * @return
     */
    @Select("SELECT COUNT(1) FROM t_trans_reexchange WHERE server_trans_id=#{serverTransId}")
    int countByServerTransId(@Param("serverTransId") String serverTransId);

    @Select("select id, channel_key, channel_code, channel_name, mer_no, client_trans_id, client_trans_time, server_trans_id, product_code, trade_type, org_code, org_name, server_batch_no, server_link_id, trans_amount, real_amount, trans_status, trans_date, trans_time, reconcile_status, reconcile_time, reconcile_date, payee_acct_no, payee_name, payer_acct_no, payer_name, industry_code, channel_settle_date, solve_status, gmt_create, gmt_modified, user_create, user_modified,(select name from t_industry where code=industry_code) industry_name from t_trans_reexchange where server_trans_id=#{serverTransId}")
    @ResultMap("transReexchangeResultMap")
    TransReexchangeDO findOneByServerTransId(@Param("serverTransId") String serverTransId);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) totalCount,sum(trans_amount) transAmount from t_trans_reexchange where 1 = 1"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.transDate != null'> and trans_date = #{params.transDate}</if>"
                    + "<if test='params.reconcileDate != null'> and reconcile_date = #{params.reconcileDate}</if>"
                    + "<if test='params.payeeAcctNo != null'> and payee_acct_no = #{params.payeeAcctNo}</if>"
                    + "order by gmt_create desc"
                    + "</script>"
    )
    Map<String,Long> totalCountReexchange(@Param("params") Map<String, Object> params);

    /**
     * 统计
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, channel_key, channel_code, channel_name, mer_no, client_trans_id, client_trans_time, server_trans_id, product_code, trade_type, org_code, org_name, server_batch_no, server_link_id, trans_amount, real_amount, trans_status, trans_date, trans_time, reconcile_status, reconcile_time, reconcile_date, payee_acct_no, payee_name, payer_acct_no, payer_name, industry_code, channel_settle_date, solve_status, gmt_create, gmt_modified, user_create, user_modified,(select name from t_industry where code=industry_code) industry_name from t_trans_reexchange where 1 = 1"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.transDate != null'> and trans_date = #{params.transDate}</if>"
                    + "<if test='params.reconcileDate != null'> and reconcile_date = #{params.reconcileDate}</if>"
                    + "<if test='params.payeeAcctNo != null'> and payee_acct_no = #{params.payeeAcctNo}</if>"
                    + "order by gmt_create desc"
                    + "</script>"
    )
    @ResultMap("transReexchangeResultMap")
    Page<TransReexchangeDO> pageReexchange(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(不分页)
     * @param transReexchangeDO
     * @return
     */
    @Select(
            "<script>"
                    + "select id, channel_key, channel_code, channel_name, mer_no, client_trans_id, client_trans_time, server_trans_id, product_code, trade_type, org_code, org_name, server_batch_no, server_link_id, trans_amount, real_amount, trans_status, trans_date, trans_time, reconcile_status, reconcile_time, reconcile_date, payee_acct_no, payee_name, payer_acct_no, payer_name, industry_code, channel_settle_date, solve_status, gmt_create, gmt_modified, user_create, user_modified,(select name from t_industry where code=industry_code) industry_name from t_trans_reexchange where 1 = 1"
                    + "<if test='industryCode != null'> and industry_code = #{industryCode}</if>"
                    + "<if test='transDate != null'> and trans_date = #{transDate}</if>"
                    + "<if test='reconcileDate != null'> and reconcile_date = #{reconcileDate}</if>"
                    + "<if test='payeeAcctNo != null'> and payee_acct_no = #{payeeAcctNo}</if>"
                    + "order by gmt_create desc"
                    + "</script>"
    )
    @ResultMap("transReexchangeResultMap")
    List<TransReexchangeDO> list(TransReexchangeDO transReexchangeDO);
}
