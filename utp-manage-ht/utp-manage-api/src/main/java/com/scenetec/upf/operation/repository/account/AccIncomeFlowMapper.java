package com.scenetec.upf.operation.repository.account;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.account.AccIncomeFlowDO;
import com.scenetec.upf.operation.model.domain.outsidetransorder.OutsideTransOrderDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2020/02/12
 */
@Repository
@Mapper
public interface AccIncomeFlowMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_upload_subaccount_income_flow (user_create,gmt_create,user_modified,gmt_modified,sub_account,batch_no,seq_no,income_flow_id,income_amount,pay_flow_ids,remark) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{subAccount},#{batchNo},#{seqNo},#{incomeFlowId},#{incomeAmount},#{payFlowIds},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(AccIncomeFlowDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_upload_subaccount_income_flow ("
        +" user_create, gmt_create, user_modified, gmt_modified, sub_account, batch_no, seq_no, income_flow_id, income_amount, pay_flow_ids, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.subAccount}, #{item.batchNo}, #{item.seqNo}, #{item.incomeFlowId}, #{item.incomeAmount}, #{item.payFlowIds}, #{item.remark})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<AccIncomeFlowDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_upload_subaccount_income_flow ("
        +" user_create, gmt_create, user_modified, gmt_modified, sub_account, batch_no, seq_no, income_flow_id, income_amount, pay_flow_ids, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.subAccount}, #{item.batchNo}, #{item.seqNo}, #{item.incomeFlowId}, #{item.incomeAmount}, #{item.payFlowIds}, #{item.remark})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"sub_account = VALUES(sub_account),"
            +"batch_no = VALUES(batch_no),"
            +"seq_no = VALUES(seq_no),"
            +"income_flow_id = VALUES(income_flow_id),"
            +"income_amount = VALUES(income_amount),"
            +"pay_flow_ids = VALUES(pay_flow_ids),"
            +"remark = VALUES(remark)"
        +"</script>"
    )
    int modifyList(List<AccIncomeFlowDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_upload_subaccount_income_flow where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_upload_subaccount_income_flow <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='subAccount != null'> sub_account = #{subAccount}, </if> "
            +"<if test='batchNo != null'> batch_no = #{batchNo}, </if> "
            +"<if test='seqNo != null'> seq_no = #{seqNo}, </if> "
            +"<if test='incomeFlowId != null'> income_flow_id = #{incomeFlowId}, </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount}, </if> "
            +"<if test='payFlowIds != null'> pay_flow_ids = #{payFlowIds}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(AccIncomeFlowDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,sub_account,batch_no,seq_no,income_flow_id,income_amount,pay_flow_ids,remark from t_upload_subaccount_income_flow where id = #{id}")
 	@Results(id="AccIncomeFlowResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "subAccount", column = "sub_account"),@Result(property = "batchNo", column = "batch_no"),@Result(property = "seqNo", column = "seq_no"),@Result(property = "incomeFlowId", column = "income_flow_id"),@Result(property = "incomeAmount", column = "income_amount"),@Result(property = "payFlowIds", column = "pay_flow_ids")
            ,@Result(property = "remark", column = "remark"),@Result(property = "accNo", column = "acc_no"),@Result(property = "accName", column = "acc_name"),@Result(property = "autoPayeeAcctAo", column = "auto_payee_acct_ao"),@Result(property = "autoPayeeAcctName", column = "auto_payee_acct_name"),@Result(property = "exAcctNo", column = "ex_acct_no"),@Result(property = "exAcctName", column = "ex_acct_name"),@Result(property = "amt", column = "amt"),@Result(property = "tranDate", column = "tran_date"),@Result(property = "industryCode", column = "industry_code")})
 	AccIncomeFlowDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,sub_account,batch_no,seq_no,income_flow_id,income_amount,pay_flow_ids,remark from t_upload_subaccount_income_flow where 1 = 1"
        + "</script>"
    )
    @ResultMap("AccIncomeFlowResultMap")
    Page<AccIncomeFlowDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_upload_subaccount_income_flow <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='subAccount != null'> sub_account = #{subAccount} AND </if> "
            +"<if test='batchNo != null'> batch_no = #{batchNo} AND </if> "
            +"<if test='seqNo != null'> seq_no = #{seqNo} AND </if> "
            +"<if test='incomeFlowId != null'> income_flow_id = #{incomeFlowId} AND </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount} AND </if> "
            +"<if test='payFlowIds != null'> pay_flow_ids = #{payFlowIds} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(AccIncomeFlowDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id,sub_account,batch_no,seq_no,income_flow_id,income_amount,pay_flow_ids,remark from t_upload_subaccount_income_flow"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='subAccount != null'> sub_account = #{subAccount} AND </if> "
            +"<if test='batchNo != null'> batch_no = #{batchNo} AND </if> "
            +"<if test='seqNo != null'> seq_no = #{seqNo} AND </if> "
            +"<if test='incomeFlowId != null'> income_flow_id = #{incomeFlowId} AND </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount} AND </if> "
            +"<if test='payFlowIds != null'> pay_flow_ids = #{payFlowIds} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("AccIncomeFlowResultMap")
    AccIncomeFlowDO selectOne(AccIncomeFlowDO obj);


    @Select(
            "<script>"
                    +"select id,income_flow_id from t_upload_subaccount_income_flow"
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='incomeFlowId != null'> income_flow_id = #{incomeFlowId} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("AccIncomeFlowResultMap")
    AccIncomeFlowDO selectOneByIncomeFlowId(AccIncomeFlowDO obj);
    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,sub_account,batch_no,seq_no,income_flow_id,income_amount,pay_flow_ids,remark from t_upload_subaccount_income_flow"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='subAccount != null'> sub_account = #{subAccount} AND </if> "
            +"<if test='batchNo != null'> batch_no = #{batchNo} AND </if> "
            +"<if test='seqNo != null'> seq_no = #{seqNo} AND </if> "
            +"<if test='incomeFlowId != null'> income_flow_id = #{incomeFlowId} AND </if> "
            +"<if test='incomeAmount != null'> income_amount = #{incomeAmount} AND </if> "
            +"<if test='payFlowIds != null'> pay_flow_ids = #{payFlowIds} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("AccIncomeFlowResultMap")
    List<AccIncomeFlowDO> selectList(AccIncomeFlowDO obj);



//
//    @Select(
//            "<script>"
//                    +"SELECT count(*) totalCount,sum(trans_amount) transAmount,IFNULL(sum(mer_fee),0) merFeeTotal,IFNULL(sum(channel_fee),0) channelFeeTotal from t_upload_subaccount_income_flow infl left join t_channel_income_flow ch on " +
//                    "ch.core_no =infl.income_flow_id  "
//                    +"<where> <trim suffixOverrides='AND'>"
//                    +"<if test='params.incomeFlowId != null'> infl.income_flow_id = #{params.incomeFlowId} AND </if> "
//                    +"<if test='params.accNo != null'> ch.acc_no = #{params.accNo} AND </if> "
//                    +"<if test='params.autoPayeeAcctAo != null'> ch.auto_payee_acct_ao = #{params.autoPayeeAcctAo} AND </if> "
//                    +"<if test='params.accName != null'> ch.acc_name like concat ('%',#{params.accName},'%') AND </if> "
//                    +"<if test='params.autoPayeeAcctName != null'> ch.auto_payee_acct_name like concat ('%',#{params.autoPayeeAcctName},'%') AND </if> "
//                    + "<if test='params.transBeginDate != null'>ch.tran_date &gt;= #{params.transBeginDate} AND </if>"
//                    + "<if test='params.transEndDate != null'> ch.tran_date &lt;= #{params.transEndDate} AND</if>"
//                    +"</trim></where> "
//                    +"</script>"
//    )
//
//    Map<String,Long>  totalCount(@Param("params") Map<String, Object> params);

}

