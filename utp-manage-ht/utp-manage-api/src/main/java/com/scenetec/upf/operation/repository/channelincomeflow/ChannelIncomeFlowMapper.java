package com.scenetec.upf.operation.repository.channelincomeflow;

import com.scenetec.upf.operation.model.domain.channelincomeflow.ChannelIncomeFlowDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2020/03/16
 */
@Repository
@Mapper
public interface ChannelIncomeFlowMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_channel_income_flow (user_create,gmt_create,user_modified,gmt_modified,acc_no,acc_name,amt,core_no,rid,ex_acct_no,ex_acct_name,account_name,clear_bankno,bank_code,bank_name,tran_no,tran_date,auto_payee_acct_ao,auto_payee_acct_name,manual_payee_acct_no,manual_payee_acct_name,biz_flag,elc_make_flag,remark,handle_flag) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{accNo},#{accName},#{amt},#{coreNo},#{rid},#{exAcctNo},#{exAcctName},#{accountName},#{clearBankno},#{bankCode},#{bankName},#{tranNo},#{tranDate},#{autoPayeeAcctAo},#{autoPayeeAcctName},#{manualPayeeAcctNo},#{manualPayeeAcctName},#{bizFlag},#{elcMakeFlag},#{remark},#{handleFlag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(ChannelIncomeFlowDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_income_flow ("
        +" user_create, gmt_create, user_modified, gmt_modified, acc_no, acc_name, amt, core_no, rid, ex_acct_no, ex_acct_name, account_name, clear_bankno, bank_code, bank_name, tran_no, tran_date, auto_payee_acct_ao, auto_payee_acct_name, manual_payee_acct_no, manual_payee_acct_name, biz_flag, elc_make_flag, remark, handle_flag"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accNo}, #{item.accName}, #{item.amt}, #{item.coreNo}, #{item.rid}, #{item.exAcctNo}, #{item.exAcctName}, #{item.accountName}, #{item.clearBankno}, #{item.bankCode}, #{item.bankName}, #{item.tranNo}, #{item.tranDate}, #{item.autoPayeeAcctAo}, #{item.autoPayeeAcctName}, #{item.manualPayeeAcctNo}, #{item.manualPayeeAcctName}, #{item.bizFlag}, #{item.elcMakeFlag}, #{item.remark}, #{item.handleFlag})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<ChannelIncomeFlowDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_channel_income_flow ("
        +" user_create, gmt_create, user_modified, gmt_modified, acc_no, acc_name, amt, core_no, rid, ex_acct_no, ex_acct_name, account_name, clear_bankno, bank_code, bank_name, tran_no, tran_date, auto_payee_acct_ao, auto_payee_acct_name, manual_payee_acct_no, manual_payee_acct_name, biz_flag, elc_make_flag, remark, handle_flag"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.accNo}, #{item.accName}, #{item.amt}, #{item.coreNo}, #{item.rid}, #{item.exAcctNo}, #{item.exAcctName}, #{item.accountName}, #{item.clearBankno}, #{item.bankCode}, #{item.bankName}, #{item.tranNo}, #{item.tranDate}, #{item.autoPayeeAcctAo}, #{item.autoPayeeAcctName}, #{item.manualPayeeAcctNo}, #{item.manualPayeeAcctName}, #{item.bizFlag}, #{item.elcMakeFlag}, #{item.remark}, #{item.handleFlag})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"acc_no = VALUES(acc_no),"
            +"acc_name = VALUES(acc_name),"
            +"amt = VALUES(amt),"
            +"core_no = VALUES(core_no),"
            +"rid = VALUES(rid),"
            +"ex_acct_no = VALUES(ex_acct_no),"
            +"ex_acct_name = VALUES(ex_acct_name),"
            +"account_name = VALUES(account_name),"
            +"clear_bankno = VALUES(clear_bankno),"
            +"bank_code = VALUES(bank_code),"
            +"bank_name = VALUES(bank_name),"
            +"tran_no = VALUES(tran_no),"
            +"tran_date = VALUES(tran_date),"
            +"auto_payee_acct_ao = VALUES(auto_payee_acct_ao),"
            +"auto_payee_acct_name = VALUES(auto_payee_acct_name),"
            +"manual_payee_acct_no = VALUES(manual_payee_acct_no),"
            +"manual_payee_acct_name = VALUES(manual_payee_acct_name),"
            +"biz_flag = VALUES(biz_flag),"
            +"elc_make_flag = VALUES(elc_make_flag),"
            +"remark = VALUES(remark),"
            +"handle_flag = VALUES(handle_flag)"
        +"</script>"
    )
    int modifyList(List<ChannelIncomeFlowDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_channel_income_flow where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_channel_income_flow <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='accNo != null'> acc_no = #{accNo}, </if> "
            +"<if test='accName != null'> acc_name = #{accName}, </if> "
            +"<if test='amt != null'> amt = #{amt}, </if> "
            +"<if test='coreNo != null'> core_no = #{coreNo}, </if> "
            +"<if test='rid != null'> rid = #{rid}, </if> "
            +"<if test='exAcctNo != null'> ex_acct_no = #{exAcctNo}, </if> "
            +"<if test='exAcctName != null'> ex_acct_name = #{exAcctName}, </if> "
            +"<if test='accountName != null'> account_name = #{accountName}, </if> "
            +"<if test='clearBankno != null'> clear_bankno = #{clearBankno}, </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
            +"<if test='bankName != null'> bank_name = #{bankName}, </if> "
            +"<if test='tranNo != null'> tran_no = #{tranNo}, </if> "
            +"<if test='tranDate != null'> tran_date = #{tranDate}, </if> "
            +"<if test='autoPayeeAcctAo != null'> auto_payee_acct_ao = #{autoPayeeAcctAo}, </if> "
            +"<if test='autoPayeeAcctName != null'> auto_payee_acct_name = #{autoPayeeAcctName}, </if> "
            +"<if test='manualPayeeAcctNo != null'> manual_payee_acct_no = #{manualPayeeAcctNo}, </if> "
            +"<if test='manualPayeeAcctName != null'> manual_payee_acct_name = #{manualPayeeAcctName}, </if> "
            +"<if test='bizFlag != null'> biz_flag = #{bizFlag}, </if> "
            +"<if test='elcMakeFlag != null'> elc_make_flag = #{elcMakeFlag}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
            +"<if test='handleFlag != null'> handle_flag = #{handleFlag}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(ChannelIncomeFlowDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,acc_no,acc_name,amt,core_no,rid,ex_acct_no,ex_acct_name,account_name,clear_bankno,bank_code,bank_name,tran_no,tran_date,auto_payee_acct_ao,auto_payee_acct_name,manual_payee_acct_no,manual_payee_acct_name,biz_flag,elc_make_flag,remark,handle_flag from t_channel_income_flow where id = #{id}")
 	@Results(id="ChannelIncomeFlowResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "accNo", column = "acc_no"),@Result(property = "accName", column = "acc_name"),@Result(property = "amt", column = "amt"),@Result(property = "coreNo", column = "core_no"),@Result(property = "rid", column = "rid"),@Result(property = "exAcctNo", column = "ex_acct_no"),@Result(property = "exAcctName", column = "ex_acct_name"),@Result(property = "accountName", column = "account_name"),@Result(property = "clearBankno", column = "clear_bankno"),@Result(property = "bankCode", column = "bank_code"),@Result(property = "bankName", column = "bank_name"),@Result(property = "tranNo", column = "tran_no"),@Result(property = "tranDate", column = "tran_date"),@Result(property = "autoPayeeAcctAo", column = "auto_payee_acct_ao"),@Result(property = "autoPayeeAcctName", column = "auto_payee_acct_name"),@Result(property = "manualPayeeAcctNo", column = "manual_payee_acct_no"),@Result(property = "manualPayeeAcctName", column = "manual_payee_acct_name"),@Result(property = "bizFlag", column = "biz_flag"),@Result(property = "elcMakeFlag", column = "elc_make_flag"),@Result(property = "remark", column = "remark"),@Result(property = "handleFlag", column = "handle_flag")
            ,@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryName", column = "industry_name"),@Result(property = "accountType", column = "account_type")})
 	ChannelIncomeFlowDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,acc_no,acc_name,amt,core_no,rid,ex_acct_no,ex_acct_name,account_name,clear_bankno,bank_code,bank_name,tran_no,tran_date,auto_payee_acct_ao,auto_payee_acct_name,manual_payee_acct_no,manual_payee_acct_name,biz_flag,elc_make_flag,remark,handle_flag from t_channel_income_flow where 1 = 1"
        + "</script>"
    )
    @ResultMap("ChannelIncomeFlowResultMap")
    Page<ChannelIncomeFlowDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_channel_income_flow <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accNo != null'> acc_no = #{accNo} AND </if> "
            +"<if test='accName != null'> acc_name = #{accName} AND </if> "
            +"<if test='amt != null'> amt = #{amt} AND </if> "
            +"<if test='coreNo != null'> core_no = #{coreNo} AND </if> "
            +"<if test='rid != null'> rid = #{rid} AND </if> "
            +"<if test='exAcctNo != null'> ex_acct_no = #{exAcctNo} AND </if> "
            +"<if test='exAcctName != null'> ex_acct_name = #{exAcctName} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='clearBankno != null'> clear_bankno = #{clearBankno} AND </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
            +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
            +"<if test='tranNo != null'> tran_no = #{tranNo} AND </if> "
            +"<if test='tranDate != null'> tran_date = #{tranDate} AND </if> "
            +"<if test='autoPayeeAcctAo != null'> auto_payee_acct_ao = #{autoPayeeAcctAo} AND </if> "
            +"<if test='autoPayeeAcctName != null'> auto_payee_acct_name = #{autoPayeeAcctName} AND </if> "
            +"<if test='manualPayeeAcctNo != null'> manual_payee_acct_no = #{manualPayeeAcctNo} AND </if> "
            +"<if test='manualPayeeAcctName != null'> manual_payee_acct_name = #{manualPayeeAcctName} AND </if> "
            +"<if test='bizFlag != null'> biz_flag = #{bizFlag} AND </if> "
            +"<if test='elcMakeFlag != null'> elc_make_flag = #{elcMakeFlag} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='handleFlag != null'> handle_flag = #{handleFlag} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(ChannelIncomeFlowDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,acc_no,acc_name,amt,core_no,rid,ex_acct_no,ex_acct_name,account_name,clear_bankno,bank_code,bank_name,tran_no,tran_date,auto_payee_acct_ao,auto_payee_acct_name,manual_payee_acct_no,manual_payee_acct_name,biz_flag,elc_make_flag,remark,handle_flag from t_channel_income_flow"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accNo != null'> acc_no = #{accNo} AND </if> "
            +"<if test='accName != null'> acc_name = #{accName} AND </if> "
            +"<if test='amt != null'> amt = #{amt} AND </if> "
            +"<if test='coreNo != null'> core_no = #{coreNo} AND </if> "
            +"<if test='rid != null'> rid = #{rid} AND </if> "
            +"<if test='exAcctNo != null'> ex_acct_no = #{exAcctNo} AND </if> "
            +"<if test='exAcctName != null'> ex_acct_name = #{exAcctName} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='clearBankno != null'> clear_bankno = #{clearBankno} AND </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
            +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
            +"<if test='tranNo != null'> tran_no = #{tranNo} AND </if> "
            +"<if test='tranDate != null'> tran_date = #{tranDate} AND </if> "
            +"<if test='autoPayeeAcctAo != null'> auto_payee_acct_ao = #{autoPayeeAcctAo} AND </if> "
            +"<if test='autoPayeeAcctName != null'> auto_payee_acct_name = #{autoPayeeAcctName} AND </if> "
            +"<if test='manualPayeeAcctNo != null'> manual_payee_acct_no = #{manualPayeeAcctNo} AND </if> "
            +"<if test='manualPayeeAcctName != null'> manual_payee_acct_name = #{manualPayeeAcctName} AND </if> "
            +"<if test='bizFlag != null'> biz_flag = #{bizFlag} AND </if> "
            +"<if test='elcMakeFlag != null'> elc_make_flag = #{elcMakeFlag} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='handleFlag != null'> handle_flag = #{handleFlag} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelIncomeFlowResultMap")
    ChannelIncomeFlowDO selectOne(ChannelIncomeFlowDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,acc_no,acc_name,amt,core_no,rid,ex_acct_no,ex_acct_name,account_name,clear_bankno,bank_code,bank_name,tran_no,tran_date,auto_payee_acct_ao,auto_payee_acct_name,manual_payee_acct_no,manual_payee_acct_name,biz_flag,elc_make_flag,remark,handle_flag from t_channel_income_flow"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='accNo != null'> acc_no = #{accNo} AND </if> "
            +"<if test='accName != null'> acc_name = #{accName} AND </if> "
            +"<if test='amt != null'> amt = #{amt} AND </if> "
            +"<if test='coreNo != null'> core_no = #{coreNo} AND </if> "
            +"<if test='rid != null'> rid = #{rid} AND </if> "
            +"<if test='exAcctNo != null'> ex_acct_no = #{exAcctNo} AND </if> "
            +"<if test='exAcctName != null'> ex_acct_name = #{exAcctName} AND </if> "
            +"<if test='accountName != null'> account_name = #{accountName} AND </if> "
            +"<if test='clearBankno != null'> clear_bankno = #{clearBankno} AND </if> "
            +"<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
            +"<if test='bankName != null'> bank_name = #{bankName} AND </if> "
            +"<if test='tranNo != null'> tran_no = #{tranNo} AND </if> "
            +"<if test='tranDate != null'> tran_date = #{tranDate} AND </if> "
            +"<if test='autoPayeeAcctAo != null'> auto_payee_acct_ao = #{autoPayeeAcctAo} AND </if> "
            +"<if test='autoPayeeAcctName != null'> auto_payee_acct_name = #{autoPayeeAcctName} AND </if> "
            +"<if test='manualPayeeAcctNo != null'> manual_payee_acct_no = #{manualPayeeAcctNo} AND </if> "
            +"<if test='manualPayeeAcctName != null'> manual_payee_acct_name = #{manualPayeeAcctName} AND </if> "
            +"<if test='bizFlag != null'> biz_flag = #{bizFlag} AND </if> "
            +"<if test='elcMakeFlag != null'> elc_make_flag = #{elcMakeFlag} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
            +"<if test='handleFlag != null'> handle_flag = #{handleFlag} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("ChannelIncomeFlowResultMap")
    List<ChannelIncomeFlowDO> selectList(ChannelIncomeFlowDO obj);


    /**
     * 通过条件查询多条记录(不分页)
     * @param obj--
     *           t_channel_income_flow   --> core_no '核心主交易流水(订单号)',--》(入金流水)t_upload_subaccount_income_flow-->income_flow_id （'入金流水id'
     * @return
     *    下游报备的流水 ---》渠道入金通知流水表
     *
     */
    @Select(
            "<script>"
                    +"SELECT infl.* "//,ch.income_flow_id AS incomeFlowId
                    +"FROM t_channel_income_flow infl "
//                    +"left JOIN t_upload_subaccount_income_flow ch ON ch.income_flow_id = infl.rid  "
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='params.coreNo != null'> infl.core_no = #{params.coreNo} AND </if> "
                    +"<if test='params.industryCode != null'> infl.industry_code = #{params.industryCode} and </if> "
                    +"<if test='params.autoPayeeAcctAo != null'> infl.auto_payee_acct_ao = #{params.autoPayeeAcctAo} and </if> "
                    +"<if test='params.industryName != null'>  infl.industry_name like concat ('%',#{params.industryName},'%') and </if> "
                    +"<if test='params.autoPayeeAcctName != null'> infl.auto_payee_acct_name like concat ('%',#{params.autoPayeeAcctName},'%') AND </if> "
                    + "<if test='params.transBeginDate != null'>infl.tran_date &gt;= #{params.transBeginDate} AND </if>"
                    + "<if test='params.transEndDate != null'> infl.tran_date &lt;= #{params.transEndDate} AND</if>"
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("ChannelIncomeFlowResultMap")
    Page<ChannelIncomeFlowDO> pageList(@Param("params") Map<String, Object> params);

//    @Select(
//            "<script>"
//                    +"select t.* from ("
//                    +"SELECT infl.*,ch.income_flow_id AS incomeFlowId, "
//                    +"case "
//                    +"when ac.obj_type='2' then merinfo.industry_code "
//                    +"when ac.obj_type='3' then merinfo.industry_code "
//                    +"when ac.obj_type='7' then merinfo.industry_code "
//                    +"when ac.obj_type='8' then merinfo.industry_code "
//                    +"when ac.obj_type='9' then merinfo2.industry_code "
//                    +"else ind.code "
//                    +"end  as code, "
//                    +"case  "
//                    +"when ac.obj_type='2' then merinfo.industry_name "
//                    +"when ac.obj_type='3' then merinfo.industry_name "
//                    +"when ac.obj_type='7' then merinfo.industry_name "
//                    +"when ac.obj_type='8' then merinfo.industry_name "
//                    +"when ac.obj_type='9' then merinfo2.industry_name "
//                    +"else ind.name "
//                    +"end  as name "
//                    +"FROM t_channel_income_flow infl "
//                    +"left join t_account ac on ac.account =infl.acc_no "
//                    +"left JOIN t_industry ind ON ind.account = ac.account "
//                    +"left JOIN t_merchant_info merinfo ON merinfo.account = ac.account "
//                    +"left JOIN t_merchant_info merinfo2 ON merinfo2.settle_account = ac.account "
//                    +"left JOIN t_upload_subaccount_income_flow ch ON ch.income_flow_id = infl.rid  "
//                    +"WHERE 1 = 1  "
//                    +") as t "
//                    +"<where> <trim suffixOverrides='AND'>"
//                    +"<if test='params.coreNo != null'> t.core_no = #{params.coreNo} AND </if> "
//                    +"<if test='params.code != null'> t.code = #{params.code} AND </if> "
//                    +"<if test='params.autoPayeeAcctAo != null'> t.auto_payee_acct_ao = #{params.autoPayeeAcctAo} AND </if> "
//                    +"<if test='params.name != null'> t.name like concat ('%',#{params.name},'%') AND </if> "
//                    +"<if test='params.autoPayeeAcctName != null'> t.auto_payee_acct_name like concat ('%',#{params.autoPayeeAcctName},'%') AND </if> "
//                    + "<if test='params.transBeginDate != null'>t.tran_date &gt;= #{params.transBeginDate} AND </if>"
//                    + "<if test='params.transEndDate != null'> t.tran_date &lt;= #{params.transEndDate} AND</if>"
//                    +"</trim></where> "
//                    +"</script>"
//    )
//    @ResultMap("ChannelIncomeFlowResultMap")
//    Page<ChannelIncomeFlowDO> pageList(@Param("params") Map<String, Object> params);


}

