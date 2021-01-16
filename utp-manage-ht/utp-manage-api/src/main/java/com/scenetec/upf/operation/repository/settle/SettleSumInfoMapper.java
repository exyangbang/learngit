package com.scenetec.upf.operation.repository.settle;

import com.scenetec.upf.operation.model.domain.settle.IndSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.MerSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.OrgSettleSumInfoDO;
import com.scenetec.upf.operation.model.domain.settle.TransSumInfoDO;
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
public interface SettleSumInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_day_sum (user_create,gmt_create,user_modified,gmt_modified,settle_date,org_code,mer_no,trans_date,product_code,trade_type,total_count,total_amount,total_fee) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{settleDate},#{orgCode},#{merNo},#{transDate},#{productCode},#{tradeType},#{totalCount},#{totalAmount},#{totalFee})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(OrgSettleSumInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_day_sum ("
        +" user_create, gmt_create, user_modified, gmt_modified, settle_date, org_code, mer_no, trans_date, product_code, trade_type, total_count, total_amount, total_fee"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.settleDate}, #{item.orgCode}, #{item.merNo}, #{item.transDate}, #{item.productCode}, #{item.tradeType}, #{item.totalCount}, #{item.totalAmount}, #{item.totalFee})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<OrgSettleSumInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_day_sum ("
        +" user_create, gmt_create, user_modified, gmt_modified, settle_date, org_code, mer_no, trans_date, product_code, trade_type, total_count, total_amount, total_fee"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.settleDate}, #{item.orgCode}, #{item.merNo}, #{item.transDate}, #{item.productCode}, #{item.tradeType}, #{item.totalCount}, #{item.totalAmount}, #{item.totalFee})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"settle_date = VALUES(settle_date),"
            +"org_code = VALUES(org_code),"
            +"mer_no = VALUES(mer_no),"
            +"trans_date = VALUES(trans_date),"
            +"product_code = VALUES(product_code),"
            +"trade_type = VALUES(trade_type),"
            +"total_count = VALUES(total_count),"
            +"total_amount = VALUES(total_amount),"
            +"total_fee = VALUES(total_fee)"
        +"</script>"
    )
    int modifyList(List<OrgSettleSumInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_merchant_day_sum where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_merchant_day_sum <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='settleDate != null'> settle_date = #{settleDate}, </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='transDate != null'> trans_date = #{transDate}, </if> "
            +"<if test='productCode != null'> product_code = #{productCode}, </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType}, </if> "
            +"<if test='totalCount != null'> total_count = #{totalCount}, </if> "
            +"<if test='totalAmount != null'> total_amount = #{totalAmount}, </if> "
            +"<if test='totalFee != null'> total_fee = #{totalFee}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(OrgSettleSumInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,settle_date,org_code,mer_no,trans_date,product_code,trade_type,total_count,total_amount,total_fee from t_merchant_day_sum where id = #{id}")
    @ResultMap("SettleSumInfoResultMap")
    OrgSettleSumInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select reconcile_date,org_code,mer_no,trans_date,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code,(select value from t_common_dictionary where type='tradeType' and `key`=trade_type) trade_type,total_count,total_amount,ifnull(total_fee,0) total_fee from t_merchant_day_sum where 1 = 1"
		        + "<if test='params.reconcileDate != null'> and trans_date = #{params.reconcileDate}</if>"
		        + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
        + "</script>"
    )
    @Results(id="SettleSumInfoResultMap", value = {@Result(property = "reconcileDate", column = "reconcile_date"),@Result(property = "orgCode", column = "org_code"),@Result(property = "merNo", column = "mer_no"),@Result(property = "transDate", column = "trans_date"),@Result(property = "productCode", column = "product_code"),@Result(property = "tradeType", column = "trade_type"),@Result(property = "totalCount", column = "total_count"),@Result(property = "totalAmount", column = "total_amount"),@Result(property = "totalFee", column = "total_fee")})
    Page<OrgSettleSumInfoDO> orgList(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select reconcile_date,client_trans_id,server_trans_id,mer_no,trans_date,trans_time,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code,(select value from t_common_dictionary where type='tradeType' and `key`=trade_type) trade_type,trans_amount,0 trans_fee from t_trans_history where 1 = 1"
                    + "<if test='params.reconcileDate != null'> and reconcile_date = #{params.reconcileDate}</if>"
                    + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
                    + "and trans_status='TRADE_SUCCESS'"
                    + "</script>"
    )
    @Results(id="merSettleSumInfoResultMap", value = {@Result(property = "reconcileDate", column = "reconcile_date"),@Result(property = "clientTransId", column = "client_trans_id"),@Result(property = "serverTransId", column = "server_trans_id"),@Result(property = "merNo", column = "mer_no"),@Result(property = "transDate", column = "trans_date"),@Result(property = "transTime", column = "trans_time"),@Result(property = "productCode", column = "product_code"),@Result(property = "tradeType", column = "trade_type"),@Result(property = "transAmount", column = "trans_amount"),@Result(property = "transFee", column = "trans_fee")})
    Page<MerSettleSumInfoDO> merList(@Param("params") Map<String, Object> params);



    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select reconcile_date,client_trans_id,server_trans_id,insert(payee_acct_no, 7, 7, '****') payee_acct_no,payee_name,trans_date,trans_time,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code, trade_type,trans_amount,mer_fee from t_trans_history where 1 = 1"
                    + "<if test='params.reconcileDate != null'> and reconcile_date = #{params.reconcileDate}</if>"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "and trans_status='TRADE_SUCCESS'"
                    + "</script>"
    )
    @Results(id="indSettleSumInfoResultMap", value = {@Result(property = "reconcileDate", column = "reconcile_date"),@Result(property = "clientTransId", column = "client_trans_id"),@Result(property = "serverTransId", column = "server_trans_id"),@Result(property = "payeeAcctNo", column = "payee_acct_no"),@Result(property = "payeeName", column = "payee_name"),@Result(property = "transDate", column = "trans_date"),@Result(property = "transTime", column = "trans_time"),@Result(property = "productCode", column = "product_code"),@Result(property = "tradeType", column = "trade_type"),@Result(property = "transAmount", column = "trans_amount"),@Result(property = "merFee", column = "mer_fee")})
    Page<IndSettleSumInfoDO> indList(@Param("params") Map<String, Object> params);

//    @Select(
//            "<script>"
//                    + "select reconcile_date,client_trans_id,server_trans_id,insert(payee_acct_no, 7, 7, '****') payee_acct_no,payee_name,trans_date,trans_time,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code,(select value from t_common_dictionary where type='tradeType' and `key`=trade_type) trade_type,trans_amount,mer_fee from t_trans_history where 1 = 1"
//                    + "<if test='params.reconcileDate != null'> and reconcile_date = #{params.reconcileDate}</if>"
//                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
//                    + "and trans_status='TRADE_SUCCESS'"
//                    + "</script>"
//    )
//    @Results(id="indSettleSumInfoResultMap", value = {@Result(property = "reconcileDate", column = "reconcile_date"),@Result(property = "clientTransId", column = "client_trans_id"),@Result(property = "serverTransId", column = "server_trans_id"),@Result(property = "payeeAcctNo", column = "payee_acct_no"),@Result(property = "payeeName", column = "payee_name"),@Result(property = "transDate", column = "trans_date"),@Result(property = "transTime", column = "trans_time"),@Result(property = "productCode", column = "product_code"),@Result(property = "tradeType", column = "trade_type"),@Result(property = "transAmount", column = "trans_amount"),@Result(property = "merFee", column = "mer_fee")})
//    Page<IndSettleSumInfoDO> indList(@Param("params") Map<String, Object> params);



    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select industry_code,(select name from t_industry where code=industry_code) industry_name,channel_code,channel_name,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code,count(1) total_count,sum(trans_Amount) total_amount,sum(mer_fee) total_industry_fee,sum(channel_fee) total_channel_fee from t_trans_history where "+" trans_status='TRADE_SUCCESS'"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.channelCode != null'> and channel_code = #{params.channelCode}</if>"
                    + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                    + "<if test='params.transBeginDate != null'> and trans_date &gt;= #{params.transBeginDate}</if>"
                    + "<if test='params.transEndDate != null'> and trans_date &lt;= #{params.transEndDate}</if>"
                    +"GROUP BY industry_code,channel_code,product_code"
                    + "</script>"
    )
    @Results(id="transSumInfoResultMap", value = {@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryName", column = "industry_name"),@Result(property = "channelCode", column = "channel_code"),@Result(property = "channelName", column = "channel_name"),@Result(property = "productCode", column = "product_code"),@Result(property = "totalCount", column = "total_count"),@Result(property = "totalAmount", column = "total_amount"),@Result(property = "totalChannelFee", column = "total_channel_fee"),@Result(property = "totalIndustryFee", column = "total_industry_fee")})
    Page<TransSumInfoDO> sumList(@Param("params") Map<String, Object> params);


    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_merchant_day_sum <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='settleDate != null'> settle_date = #{settleDate} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='totalCount != null'> total_count = #{totalCount} AND </if> "
            +"<if test='totalAmount != null'> total_amount = #{totalAmount} AND </if> "
            +"<if test='totalFee != null'> total_fee = #{totalFee} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(OrgSettleSumInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,settle_date,org_code,mer_no,trans_date,product_code,trade_type,total_count,total_amount,total_fee from t_merchant_day_sum"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='settleDate != null'> settle_date = #{settleDate} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='transDate != null'> trans_date = #{transDate} AND </if> "
            +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='tradeType != null'> trade_type = #{tradeType} AND </if> "
            +"<if test='totalCount != null'> total_count = #{totalCount} AND </if> "
            +"<if test='totalAmount != null'> total_amount = #{totalAmount} AND </if> "
            +"<if test='totalFee != null'> total_fee = #{totalFee} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SettleSumInfoResultMap")
    OrgSettleSumInfoDO selectOne(OrgSettleSumInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select reconcile_date,org_code,mer_no,trans_date,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code,(select value from t_common_dictionary where type='tradeType' and `key`=trade_type) trade_type,total_count,total_amount,ifnull(total_fee,0) total_fee from t_merchant_day_sum"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='reconcileDate != null'> trans_date = #{reconcileDate} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("SettleSumInfoResultMap")
    List<OrgSettleSumInfoDO> selectOrgList(OrgSettleSumInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select reconcile_date,client_trans_id,server_trans_id,mer_no,trans_date,trans_time,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code,(select value from t_common_dictionary where type='tradeType' and `key`=trade_type) trade_type,trans_amount,0 trans_fee from t_trans_history where 1 = 1"
                    + "<if test='reconcileDate != null'> and reconcile_date = #{reconcileDate}</if>"
                    + "<if test='merNo != null'> and mer_no = #{merNo}</if>"
            +           "and trans_status='TRADE_SUCCESS'"
                    + "</script>"
    )
    @ResultMap("merSettleSumInfoResultMap")
    List<MerSettleSumInfoDO> selectMerList(MerSettleSumInfoDO obj);


    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select reconcile_date,client_trans_id,server_trans_id,payee_acct_no,payee_name,trans_date,trans_time,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code, trade_type,trans_amount,mer_fee from t_trans_history where 1 = 1"
                    + "<if test='reconcileDate != null'> and reconcile_date = #{reconcileDate}</if>"
                    + "<if test='industryCode != null'> and industry_code = #{industryCode}</if>"
                    + "and trans_status='TRADE_SUCCESS'"
                    + "</script>"
    )
    @ResultMap("indSettleSumInfoResultMap")
    List<IndSettleSumInfoDO> selectIndList(IndSettleSumInfoDO obj);



    /**
     * 查询列表(不分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select industry_code,(select name from t_industry where code=industry_code) industry_name,channel_code,channel_name,(select value from t_common_dictionary where type='productType' and `key`=product_code) product_code,count(1) total_count,sum(trans_Amount) total_amount,sum(mer_fee) total_industry_fee,sum(channel_fee) total_channel_fee from t_trans_history where "+" trans_status='TRADE_SUCCESS'"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.channelCode != null'> and channel_code = #{params.channelCode}</if>"
                    + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                    + "<if test='params.transBeginDate != null'> and trans_date &gt;= #{params.transBeginDate}</if>"
                    + "<if test='params.transEndDate != null'> and trans_date &lt;= #{params.transEndDate}</if>"
                    +"GROUP BY industry_code,channel_code,product_code"
                    + "</script>"
    )
    @ResultMap("transSumInfoResultMap")
    List<TransSumInfoDO> selectSumList(@Param("params") Map<String, Object> params);


    @Select("select org_code,ifnull(sum(total_count),0) totalCount,ifnull(sum(total_amount),0) totalAmount,ifnull(sum(total_fee),0) totalFee from t_merchant_day_sum where org_code=#{orgCode} and reconcile_date=#{reconcileDate} group by org_code")
    Map<String,Long> countOrg(@Param("orgCode") String orgCode, @Param("reconcileDate") String reconcileDate);

    @Select("select mer_no,ifnull(sum(total_count),0) totalCount,ifnull(sum(total_amount),0) totalAmount,ifnull(sum(total_fee),0) totalFee  from t_merchant_day_sum where mer_no=#{merNo} and reconcile_date=#{reconcileDate} group by mer_no")
    Map<String,Long> countMer(@Param("merNo") String merNo, @Param("reconcileDate") String reconcileDate);

    @Select("select industry_code,ifnull(count(1),0) totalCount,ifnull(sum(trans_amount),0) totalAmount,ifnull(sum(mer_fee),0) totalFee  from t_trans_history where trans_status='TRADE_SUCCESS' and industry_code=#{industryCode} and reconcile_date=#{reconcileDate} group by industry_code")
    Map<String,Long> countInd(@Param("industryCode") String industryCode, @Param("reconcileDate") String reconcileDate);


    @Select(
            "<script>"
                    + "select count(1) totalCount,sum(trans_Amount) totalAmount,sum(mer_fee) totalIndustryFee,sum(channel_fee) totalChannelFee from t_trans_history where "+" trans_status='TRADE_SUCCESS'"
                    + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
                    + "<if test='params.channelCode != null'> and channel_code = #{params.channelCode}</if>"
                    + "<if test='params.productCode != null'> and product_code = #{params.productCode}</if>"
                    + "<if test='params.transBeginDate != null'> and trans_date &gt;= #{params.transBeginDate}</if>"
                    + "<if test='params.transEndDate != null'> and trans_date &lt;= #{params.transEndDate}</if>"
                    + "</script>"
    )
    Map<String,Long> countTrans(@Param("params") Map<String, Object> params);
}

