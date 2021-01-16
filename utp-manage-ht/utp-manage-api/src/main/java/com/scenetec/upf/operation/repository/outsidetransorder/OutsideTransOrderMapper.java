package com.scenetec.upf.operation.repository.outsidetransorder;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.outsidetransorder.OutsideTransOrderDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2019/06/04
 */
@Repository
@Mapper
public interface OutsideTransOrderMapper {

    /**
     * 创建
     *
     * @param obj
     * @return
     */
    @Insert("insert into t_outside_trans_order (user_create,gmt_create,user_modified,gmt_modified,industry_code,batch_id,req_date,req_time,trans_date,trans_time,trans_order_id,mer_no,pay_mode,trans_amount,seller_name,buyer_name,goods_info,remark,upload_status,upload_desc) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{industryCode},#{batchId},#{reqDate},#{reqTime},#{transDate},#{transTime},#{transOrderId},#{merNo},#{payMode},#{transAmount},#{sellerName},#{buyerName},#{goodsInfo},#{remark},#{uploadStatus},#{uploadDesc})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(OutsideTransOrderDO obj);

    /**
     * 批量插入
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_outside_trans_order ("
                    + " user_create, gmt_create, user_modified, gmt_modified, industry_code, batch_id, req_date, req_time, trans_date, trans_time, trans_order_id, mer_no, pay_mode, trans_amount, seller_name, buyer_name, goods_info, remark, upload_status, upload_desc"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.batchId}, #{item.reqDate}, #{item.reqTime}, #{item.transDate}, #{item.transTime}, #{item.transOrderId}, #{item.merNo}, #{item.payMode}, #{item.transAmount}, #{item.sellerName}, #{item.buyerName}, #{item.goodsInfo}, #{item.remark}, #{item.uploadStatus}, #{item.uploadDesc})"
                    + "</foreach>"
                    + "</script>"
    )
    int insertList(List<OutsideTransOrderDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_outside_trans_order ("
                    + " user_create, gmt_create, user_modified, gmt_modified, industry_code, batch_id, req_date, req_time, trans_date, trans_time, trans_order_id, mer_no, pay_mode, trans_amount, seller_name, buyer_name, goods_info, remark, upload_status, upload_desc"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.batchId}, #{item.reqDate}, #{item.reqTime}, #{item.transDate}, #{item.transTime}, #{item.transOrderId}, #{item.merNo}, #{item.payMode}, #{item.transAmount}, #{item.sellerName}, #{item.buyerName}, #{item.goodsInfo}, #{item.remark}, #{item.uploadStatus}, #{item.uploadDesc})"
                    + "</foreach>"
                    + " ON DUPLICATE KEY UPDATE "
                    + "user_create = VALUES(user_create),"
                    + "gmt_create = VALUES(gmt_create),"
                    + "user_modified = VALUES(user_modified),"
                    + "gmt_modified = VALUES(gmt_modified),"
                    + "industry_code = VALUES(industry_code),"
                    + "batch_id = VALUES(batch_id),"
                    + "req_date = VALUES(req_date),"
                    + "req_time = VALUES(req_time),"
                    + "trans_date = VALUES(trans_date),"
                    + "trans_time = VALUES(trans_time),"
                    + "trans_order_id = VALUES(trans_order_id),"
                    + "mer_no = VALUES(mer_no),"
                    + "pay_mode = VALUES(pay_mode),"
                    + "trans_amount = VALUES(trans_amount),"
                    + "seller_name = VALUES(seller_name),"
                    + "buyer_name = VALUES(buyer_name),"
                    + "goods_info = VALUES(goods_info),"
                    + "remark = VALUES(remark),"
                    + "upload_status = VALUES(upload_status),"
                    + "upload_desc = VALUES(upload_desc)"
                    + "</script>"
    )
    int modifyList(List<OutsideTransOrderDO> obj);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @Delete("delete from t_outside_trans_order where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_outside_trans_order <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId}, </if> "
                    + "<if test='reqDate != null'> req_date = #{reqDate}, </if> "
                    + "<if test='reqTime != null'> req_time = #{reqTime}, </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate}, </if> "
                    + "<if test='transTime != null'> trans_time = #{transTime}, </if> "
                    + "<if test='transOrderId != null'> trans_order_id = #{transOrderId}, </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo}, </if> "
                    + "<if test='payMode != null'> pay_mode = #{payMode}, </if> "
                    + "<if test='transAmount != null'> trans_amount = #{transAmount}, </if> "
                    + "<if test='sellerName != null'> seller_name = #{sellerName}, </if> "
                    + "<if test='buyerName != null'> buyer_name = #{buyerName}, </if> "
                    + "<if test='goodsInfo != null'> goods_info = #{goodsInfo}, </if> "
                    + "<if test='remark != null'> remark = #{remark}, </if> "
                    + "<if test='uploadStatus != null'> upload_status = #{uploadStatus}, </if> "
                    + "<if test='uploadDesc != null'> upload_desc = #{uploadDesc}, </if> "
                    + "</set> where id = #{id}"
                    + "</script>"
    )
    int update(OutsideTransOrderDO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    @Select("select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,batch_id,req_date,req_time,trans_date,trans_time,trans_order_id,mer_no,pay_mode,trans_amount,seller_name,buyer_name,goods_info,remark,upload_status,upload_desc from t_outside_trans_order where id = #{id}")
    @Results(id = "OutsideTransOrderResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"), @Result(property = "gmtCreate", column = "gmt_create"), @Result(property = "userModified", column = "user_modified"), @Result(property = "gmtModified", column = "gmt_modified"), @Result(property = "industryCode", column = "industry_code"), @Result(property = "batchId", column = "batch_id"), @Result(property = "reqDate", column = "req_date"), @Result(property = "reqTime", column = "req_time"), @Result(property = "transDate", column = "trans_date"), @Result(property = "transTime", column = "trans_time"), @Result(property = "transOrderId", column = "trans_order_id"), @Result(property = "merNo", column = "mer_no"), @Result(property = "payMode", column = "pay_mode"), @Result(property = "transAmount", column = "trans_amount"), @Result(property = "sellerName", column = "seller_name"), @Result(property = "buyerName", column = "buyer_name"), @Result(property = "goodsInfo", column = "goods_info"), @Result(property = "remark", column = "remark"), @Result(property = "uploadStatus", column = "upload_status"), @Result(property = "uploadDesc", column = "upload_desc"), @Result(property = "splitStatus", column = "split_status"), @Result(property = "merName", column = "mer_name"), @Result(property = "merPhone", column = "mer_phone"), @Result(property = "txnChannel", column = "txn_channel")
            , @Result(property = "txnChannelTradeNo", column = "txn_channel_trade_no"), @Result(property = "discountAmount", column = "discount_amount"), @Result(property = "buyerId", column = "buyer_id"), @Result(property = "buyerPhone", column = "buyer_phone"), @Result(property = "logistics", column = "logistics")})
    OutsideTransOrderDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     *S
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id,batch_id,trans_date,trans_time,trans_order_id,industry_code,mer_no,trans_amount,seller_name,buyer_name,goods_info,pay_mode,split_status,mer_name,mer_phone,txn_channel,txn_channel_trade_no,discount_amount,buyer_id,buyer_phone,logistics,"
                    +"case when pay_mode=3 " +
                    "then 'PDF下载' " +
                    "else remark " +
                    "end remark "+
                    " from t_outside_trans_order where 1 = 1"
                    + "<if test='params.beginTransDate != null'> and trans_date &gt;= #{params.beginTransDate}</if>"
                    + "<if test='params.endTransDate!= null'> and trans_date &lt;= #{params.endTransDate}</if>"
                    + "<if test='params.beginTransTime != null'> and trans_time &gt;= #{params.beginTransTime}</if>"
                    + "<if test='params.endTransTime != null'> and trans_time &lt;= #{params.endTransTime}</if>"
                    + "<if test='params.transOrderId != null'> and trans_order_id = #{params.transOrderId}</if>"
                    + "<if test='params.flowTransOrderId != null'> and trans_order_id in " +
                    "  <foreach collection='params.flowTransOrderId' item='item' index='index' open='(' separator=',' close=')'> #{item}</foreach> </if>"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "<if test='params.uploadStatus != null'> and upload_status = #{params.uploadStatus}</if>"
                    + "<if test='params.batchId != null'> and batch_id = #{params.batchId}</if>"
                    + "<if test='params.splitStatus != null'> and split_status = #{params.splitStatus}</if>"
                    + "</script>"
    )
    @ResultMap("OutsideTransOrderResultMap")
    Page<OutsideTransOrderDO> list(@Param("params") Map<String, Object> params);

    /**
     * 统计
     *
     * @param params
     * @return
     */

    @Select(
            "<script>"
                    + "select count(1) totalCount,IFNULL(sum(trans_amount),0) inTotalAmount from t_outside_trans_order where 1 = 1"
                    + "<if test='params.beginTransDate != null'> and trans_date &gt;= #{params.beginTransDate}</if>"
                    + "<if test='params.endTransDate!= null'> and trans_date &lt;= #{params.endTransDate}</if>"
                    + "<if test='params.beginTransTime != null'> and trans_time &gt;= #{params.beginTransTime}</if>"
                    + "<if test='params.endTransTime != null'> and trans_time &lt;= #{params.endTransTime}</if>"
                    + "<if test='params.transOrderId != null'> and trans_order_id = #{params.transOrderId}</if>"
                    + "<if test='params.flowTransOrderId != null'> and trans_order_id in " +
                    "  <foreach collection='params.flowTransOrderId' item='item' index='index' open='(' separator=',' close=')'> #{item}</foreach> </if>"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "<if test='params.uploadStatus != null'> and upload_status = #{params.uploadStatus}</if>"
                    + "<if test='params.batchId != null'> and batch_id = #{params.batchId}</if>"
                    + "<if test='params.splitStatus != null'> and split_status = #{params.splitStatus}</if>"

                    + "</script>"
    )
    Map<String, Object> countSum(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) from t_outside_trans_order <where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId} AND </if> "
                    + "<if test='reqDate != null'> req_date = #{reqDate} AND </if> "
                    + "<if test='reqTime != null'> req_time = #{reqTime} AND </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate} AND </if> "
                    + "<if test='transTime != null'> trans_time = #{transTime} AND </if> "
                    + "<if test='transOrderId != null'> trans_order_id = #{transOrderId} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='payMode != null'> pay_mode = #{payMode} AND </if> "
                    + "<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
                    + "<if test='sellerName != null'> seller_name = #{sellerName} AND </if> "
                    + "<if test='buyerName != null'> buyer_name = #{buyerName} AND </if> "
                    + "<if test='goodsInfo != null'> goods_info = #{goodsInfo} AND </if> "
                    + "<if test='remark != null'> remark = #{remark} AND </if> "
                    + "<if test='uploadStatus != null'> upload_status = #{uploadStatus} AND </if> "
                    + "<if test='uploadDesc != null'> upload_desc = #{uploadDesc} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    int count(OutsideTransOrderDO obj);

    /**
     * 通过条件查询单条记录
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,batch_id,req_date,req_time,trans_date,trans_time,trans_order_id,mer_no,pay_mode,trans_amount,seller_name,buyer_name,goods_info,remark,upload_status,upload_desc from t_outside_trans_order"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> id = #{id} AND </if>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId} AND </if> "
                    + "<if test='reqDate != null'> req_date = #{reqDate} AND </if> "
                    + "<if test='reqTime != null'> req_time = #{reqTime} AND </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate} AND </if> "
                    + "<if test='transTime != null'> trans_time = #{transTime} AND </if> "
                    + "<if test='transOrderId != null'> trans_order_id = #{transOrderId} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='payMode != null'> pay_mode = #{payMode} AND </if> "
                    + "<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
                    + "<if test='sellerName != null'> seller_name = #{sellerName} AND </if> "
                    + "<if test='buyerName != null'> buyer_name = #{buyerName} AND </if> "
                    + "<if test='goodsInfo != null'> goods_info = #{goodsInfo} AND </if> "
                    + "<if test='remark != null'> remark = #{remark} AND </if> "
                    + "<if test='uploadStatus != null'> upload_status = #{uploadStatus} AND </if> "
                    + "<if test='uploadDesc != null'> upload_desc = #{uploadDesc} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("OutsideTransOrderResultMap")
    OutsideTransOrderDO selectOne(OutsideTransOrderDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,batch_id,req_date,req_time,trans_date,trans_time,trans_order_id,mer_no,pay_mode,trans_amount,seller_name,buyer_name,goods_info,remark,upload_status,upload_desc from t_outside_trans_order"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "<if test='batchId != null'> batch_id = #{batchId} AND </if> "
                    + "<if test='reqDate != null'> req_date = #{reqDate} AND </if> "
                    + "<if test='reqTime != null'> req_time = #{reqTime} AND </if> "
                    + "<if test='transDate != null'> trans_date = #{transDate} AND </if> "
                    + "<if test='transTime != null'> trans_time = #{transTime} AND </if> "
                    + "<if test='transOrderId != null'> trans_order_id = #{transOrderId} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='payMode != null'> pay_mode = #{payMode} AND </if> "
                    + "<if test='transAmount != null'> trans_amount = #{transAmount} AND </if> "
                    + "<if test='sellerName != null'> seller_name = #{sellerName} AND </if> "
                    + "<if test='buyerName != null'> buyer_name = #{buyerName} AND </if> "
                    + "<if test='goodsInfo != null'> goods_info = #{goodsInfo} AND </if> "
                    + "<if test='remark != null'> remark = #{remark} AND </if> "
                    + "<if test='uploadStatus != null'> upload_status = #{uploadStatus} AND </if> "
                    + "<if test='uploadDesc != null'> upload_desc = #{uploadDesc} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("OutsideTransOrderResultMap")
    List<OutsideTransOrderDO> selectList(OutsideTransOrderDO obj);

}

