package com.scenetec.upf.operation.repository.feeincomeaccountmonthstat;

import com.scenetec.upf.operation.model.domain.feeincomeaccountmonthstat.FeeIncomeAccountMonthStatDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/08/22
 */
@Repository
@Mapper
public interface FeeIncomeAccountMonthStatMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_fee_income_account_month_stat (user_create,gmt_create,user_modified,gmt_modified,stat_month,account,name,collection_status,income_amount,outcome_amount,remark,trans_status,trans_desc,server_trans_id) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{statMonth},#{account},#{name},#{collectionStatus},#{incomeAmount},#{outcomeAmount},#{remark},#{transStatus},#{transDesc},#{serverTransId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(FeeIncomeAccountMonthStatDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_fee_income_account_month_stat ("
        +" user_create, gmt_create, user_modified, gmt_modified, stat_month, account, name, collection_status, income_amount, outcome_amount, remark, trans_status, trans_desc, server_trans_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.statMonth}, #{item.account}, #{item.name}, #{item.collectionStatus}, #{item.incomeAmount}, #{item.outcomeAmount}, #{item.remark}, #{item.transStatus}, #{item.transDesc}, #{item.serverTransId})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<FeeIncomeAccountMonthStatDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_fee_income_account_month_stat ("
        +" user_create, gmt_create, user_modified, gmt_modified, stat_month, account, name, collection_status, income_amount, outcome_amount, remark, trans_status, trans_desc, server_trans_id"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.statMonth}, #{item.account}, #{item.name}, #{item.collectionStatus}, #{item.incomeAmount}, #{item.outcomeAmount}, #{item.remark}, #{item.transStatus}, #{item.transDesc}, #{item.serverTransId})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"stat_month = VALUES(stat_month),"
            +"account = VALUES(account),"
            +"name = VALUES(name),"
            +"collection_status = VALUES(collection_status),"
            +"income_amount = VALUES(income_amount),"
            +"outcome_amount = VALUES(outcome_amount),"
            +"remark = VALUES(remark),"
            +"trans_status = VALUES(trans_status),"
            +"trans_desc = VALUES(trans_desc),"
            +"server_trans_id = VALUES(server_trans_id)"
        +"</script>"
    )
    int modifyList(List<FeeIncomeAccountMonthStatDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_fee_income_account_month_stat where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_fee_income_account_month_stat <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='statMonth != null'> stat_month = #{statMonth}, </if> "
            +"<if test='account != null'> account = #{account}, </if> "
            +"<if test='name != null'> name = #{name}, </if> "
            +"<if test='collectionStatus != null'> collection_status = #{collectionStatus}, </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount}, </if> "
            +"<if test='outcomeAmount != null'> outcome_amount = #{outcomeAmount}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus}, </if> "
            +"<if test='transDesc != null'> trans_desc = #{transDesc}, </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(FeeIncomeAccountMonthStatDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,stat_month,account,name,collection_status,income_amount,outcome_amount,remark,trans_status,trans_desc,server_trans_id from t_fee_income_account_month_stat where id = #{id}")
 	@Results(id="FeeIncomeAccountMonthStatResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "statMonth", column = "stat_month"),@Result(property = "account", column = "account"),@Result(property = "name", column = "name"),@Result(property = "collectionStatus", column = "collection_status"),@Result(property = "incomeAmount", column = "income_amount"),@Result(property = "outcomeAmount", column = "outcome_amount"),@Result(property = "remark", column = "remark"),@Result(property = "transStatus", column = "trans_status"),@Result(property = "transDesc", column = "trans_desc"),@Result(property = "serverTransId", column = "server_trans_id")})
 	FeeIncomeAccountMonthStatDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,stat_month,account,name,collection_status,income_amount,outcome_amount,remark,trans_status,trans_desc,server_trans_id from t_fee_income_account_month_stat where 1 = 1"
        + "</script>"
    )
    @ResultMap("FeeIncomeAccountMonthStatResultMap")
    Page<FeeIncomeAccountMonthStatDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_fee_income_account_month_stat <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='statMonth != null'> stat_month = #{statMonth} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='collectionStatus != null'> collection_status = #{collectionStatus} AND </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount} AND </if> "
            +"<if test='outcomeAmount != null'> outcome_amount = #{outcomeAmount} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='transDesc != null'> trans_desc = #{transDesc} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(FeeIncomeAccountMonthStatDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,stat_month,account,name,collection_status,income_amount,outcome_amount,remark,trans_status,trans_desc,server_trans_id from t_fee_income_account_month_stat"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='statMonth != null'> stat_month = #{statMonth} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='collectionStatus != null'> collection_status = #{collectionStatus} AND </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount} AND </if> "
            +"<if test='outcomeAmount != null'> outcome_amount = #{outcomeAmount} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='transDesc != null'> trans_desc = #{transDesc} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FeeIncomeAccountMonthStatResultMap")
    FeeIncomeAccountMonthStatDO selectOne(FeeIncomeAccountMonthStatDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,stat_month,account,name,collection_status,income_amount,outcome_amount,remark,trans_status,trans_desc,server_trans_id from t_fee_income_account_month_stat"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='statMonth != null'> stat_month = #{statMonth} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='name != null'> name = #{name} AND </if> "
            +"<if test='collectionStatus != null'> collection_status = #{collectionStatus} AND </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount} AND </if> "
            +"<if test='outcomeAmount != null'> outcome_amount = #{outcomeAmount} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='transStatus != null'> trans_status = #{transStatus} AND </if> "
            +"<if test='transDesc != null'> trans_desc = #{transDesc} AND </if> "
            +"<if test='serverTransId != null'> server_trans_id = #{serverTransId} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("FeeIncomeAccountMonthStatResultMap")
    List<FeeIncomeAccountMonthStatDO> selectList(FeeIncomeAccountMonthStatDO obj);


    @Select(
            "<script>"
                    +"SELECT DISTINCT "
                    +"at.*,IFNULL(at.income_amount,0) - IFNULL(at.outcome_amount,0) as totalAmount, "
                    +"c.name as collName, "
                    +"c.account as collAccount "
                    +"FROM "
                    +"t_fee_income_account_month_stat at "
                    +"INNER join t_industry a on a.account = at.account "
                    +"INNER JOIN t_industry b ON b.processing_fee_income_account = a.id "
                    +"INNER JOIN t_industry c ON b.collection_industry_id = c.id "
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='params.begStatMonth != null'> at.stat_month &gt;=  #{params.begStatMonth} AND </if> "
                    +"<if test='params.endStatMonth != null'> at.stat_month &lt;=  #{params.endStatMonth} AND </if> "
                    +"<if test='params.account != null'> at.account = #{params.account} AND </if> "
                    +"<if test='params.name != null'> at.name like CONCAT('%',#{params.name},'%') AND </if> "
                    +"<if test='params.collectionStatus != null'> at.collection_status = #{params.collectionStatus} AND </if> "
                    +"<if test='params.incomeAmount != null'> at.income_amount = #{params.incomeAmount} AND </if> "
                    +"<if test='params.outcomeAmount != null'> at.outcome_amount = #{params.outcomeAmount} AND </if> "
                    +"<if test='params.transStatus != null'> at.trans_status = #{params.transStatus} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("FeeIncomeAccountMonthStatResultMap")
    Page<FeeIncomeAccountMonthStatDO> pageList(@Param("params")Map<String,Object> params);

//第一行：归集总笔数  归集总金额
    @Select(
            "<script>"
                    +"select count(1) as totalCount,IFNULL(sum(at.income_amount),0) as incomeAmount,IFNULL(sum(at.outcome_amount),0) as outcomeAmount from t_fee_income_account_month_stat at "
                    +"INNER join t_industry a on a.account = at.account "
            +"INNER JOIN t_industry b ON b.processing_fee_income_account = a.id "
            +"INNER JOIN t_industry c ON b.collection_industry_id = c.id "
            +"<where> <trim suffixOverrides='AND'>"
            +"<if test='params.begStatMonth != null'> at.stat_month &gt;=  #{params.begStatMonth} AND </if> "
            +"<if test='params.endStatMonth != null'> at.stat_month &lt;=  #{params.endStatMonth} AND </if> "
            +"<if test='params.account != null'> at.account = #{params.account} AND </if> "
            +"<if test='params.name != null'> at.name like CONCAT('%',#{params.name},'%') AND </if> "
            +"<if test='params.collectionStatus != null'> at.collection_status = #{params.collectionStatus} AND </if> "
            +"<if test='params.incomeAmount != null'> at.income_amount = #{params.incomeAmount} AND </if> "
            +"<if test='params.outcomeAmount != null'> at.outcome_amount = #{params.outcomeAmount} AND </if> "
            +"<if test='params.transStatus != null'> at.trans_status = #{params.transStatus} AND </if> "
            +"</trim></where> "
                    +"</script>"
    )
    Map<String,Long> countSumCollect(@Param("params")Map<String,Object> params);

}

