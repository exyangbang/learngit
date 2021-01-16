package com.scenetec.upf.operation.repository.withdrawalsrecord;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.withdrawalsrecord.WithdrawalsRecordDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2019/03/14
 */
@Repository
@Mapper
public interface WithdrawalsRecordMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_collect_account_withdraw  (id,user_create,gmt_create,user_modified,gmt_modified,client_trans_id,recive_account_no,recive_account_name,account,amount,status,audit_status,req_date,req_time,recive_op_bank_code,recive_op_bank_name,recive_cl_bank_code,industry_code,industry_name,fund_account_no,fund_account_name,trans_status) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{clientTransId},#{reciveAccountNo},#{reciveAccountName},#{account},#{amount},#{status},#{auditStatus},#{reqDate},#{reqTime},#{reciveOpBankCode},#{reciveOpBankName},#{reciveClBankCode},#{industryCode},#{industryName},#{fundAccountNo},#{fundAccountName},#{transStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(WithdrawalsRecordDO obj);
    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_collect_account_withdraw  where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    +"update t_collect_account_withdraw  <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='clientTransId != null'> client_trans_id = #{clientTransId}, </if> "
                    +"<if test='reciveAccountNo != null'> recive_account_no = #{reciveAccountNo}, </if> "
                    +"<if test='reciveAccountName != null'> recive_account_name = #{reciveAccountName}, </if> "
                    +"<if test='account != null'> account = #{account}, </if> "
                    +"<if test='amount != null'> amount = #{amount}, </if> "
                    +"<if test='status != null'> status = #{status}, </if> "
                    +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
                    +"<if test='reqDate != null'> req_date = #{reqDate}, </if> "
                    +"<if test='reqTime != null'> req_time = #{reqTime}, </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
                    +"<if test='industryName != null'> industry_name = #{industryName}, </if> "
                    +"<if test='fundAccountNo != null'> fund_account_no = #{fundAccountNo}, </if> "
                    +"<if test='fundAccountName != null'> fund_account_name = #{fundAccountName}, </if> "
                    +"<if test='transStatus != null'> trans_status = #{transStatus}, </if> "
                    +"<if test='transDesc != null'> trans_desc = #{transDesc}, </if> "
                    +"<if test='serverTransId != null'> server_trans_id = #{serverTransId}, </if> "

                    +"</set> where id = #{id}"
                    +"</script>"
    )
    int update(WithdrawalsRecordDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
    @Select("select * from t_collect_account_withdraw  where id = #{id}")
    @Results(id="WithdrawalsRecordResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "clientTransId", column = "client_trans_id"),@Result(property = "reciveAccountNo", column = "recive_account_no"),@Result(property = "reciveAccountName", column = "recive_account_name"),@Result(property = "account", column = "account"),@Result(property = "amount", column = "amount"),@Result(property = "status", column = "status"),@Result(property = "auditStatus", column = "audit_status"),@Result(property = "reqDate", column = "req_date"),@Result(property = "reqTime", column = "req_time"),@Result(property = "reciveOpBankCode", column = "recive_op_bank_code"),@Result(property = "reciveOpBankName", column = "recive_op_bank_name"),@Result(property = "reciveClBankCode", column = "recive_op_bank_name"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "industryName", column = "industry_name"),@Result(property = "fundAccountNo", column = "fund_account_no"),@Result(property = "fundAccountName", column = "fund_account_name"),@Result(property = "transStatus", column = "trans_status"),@Result(property = "transDesc", column = "trans_desc")})
    WithdrawalsRecordDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select * from t_collect_account_withdraw  where 1 = 1"
                    + "<if test='params.clientTransId != null'> and client_trans_id = #{params.clientTransId}</if>"
                    + "</script>"
    )
    @ResultMap("WithdrawalsRecordResultMap")
    Page<WithdrawalsRecordDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select count(*) from t_collect_account_withdraw  <where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
                    +"<if test='reciveAccountNo != null'> recive_account_no = #{reciveAccountNo} AND </if> "
                    +"<if test='reciveAccountName != null'> recive_account_name = #{reciveAccountName} AND </if> "
                    +"<if test='account != null'> account = #{account} AND </if> "
                    +"<if test='amount != null'> amount = #{amount} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    int count(WithdrawalsRecordDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select * from t_collect_account_withdraw "
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='id != null and id>0'> id = #{id} AND </if>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
                    +"<if test='reciveOpBankCode != null'> recive_op_bank_code = #{reciveOpBankCode} AND </if> "
                    +"<if test='reciveOpBankName != null'> recive_op_bank_name = #{reciveOpBankName} AND </if> "
                    +"<if test='reciveClBankCode != null'> recive_cl_bank_code = #{reciveClBankCode} AND </if> "
                    +"<if test='reciveAccountNo != null'> recive_account_no = #{reciveAccountNo} AND </if> "
                    +"<if test='reciveAccountName != null'> recive_account_name = #{reciveAccountName} AND </if> "
                    +"<if test='account != null'> account = #{account} AND </if> "
                    +"<if test='amount != null'> amount = #{amount} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
                    +"<if test='fundAccountNo != null'> fund_account_no = #{fundAccountNo} AND </if> "
                    +"<if test='fundAccountName != null'> fund_account_name = #{fundAccountName} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("WithdrawalsRecordResultMap")
    WithdrawalsRecordDO selectOne(WithdrawalsRecordDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    +"select * from t_collect_account_withdraw "
                    +"<where> <trim suffixOverrides='AND'>"
                    +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    +"<if test='clientTransId != null'> client_trans_id = #{clientTransId} AND </if> "
                    +"<if test='reciveOpBankCode != null'> recive_op_bank_code = #{reciveOpBankCode} AND </if> "
                    +"<if test='reciveOpBankName != null'> recive_op_bank_name = #{reciveOpBankName} AND </if> "
                    +"<if test='reciveClBankCode != null'> recive_cl_bank_code = #{reciveClBankCode} AND </if> "
                    +"<if test='reciveAccountNo != null'> recive_account_no = #{reciveAccountNo} AND </if> "
                    +"<if test='reciveAccountName != null'> recive_account_name = #{reciveAccountName} AND </if> "
                    +"<if test='account != null'> account = #{account} AND </if> "
                    +"<if test='amount != null'> amount = #{amount} AND </if> "
                    +"<if test='status != null'> status = #{status} AND </if> "
                    +"<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
                    +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    +"<if test='industryName != null'> industry_name = #{industryName} AND </if> "
                    +"<if test='fundAccountNo != null'> fund_account_no = #{fundAccountNo} AND </if> "
                    +"<if test='fundAccountName != null'> fund_account_name = #{fundAccountName} AND </if> "
                    +"</trim></where> "
                    +"</script>"
    )
    @ResultMap("WithdrawalsRecordResultMap")
    List<WithdrawalsRecordDO> selectList(WithdrawalsRecordDO obj);


    /**
     * 逻辑删除
     * @param
     * @return
     */
    @Update(
            "<script>"
                    +"update t_collect_account_withdraw set status = 0  where id = #{id}"
                    +"</script>"
    )
    int deletebyId(Long userId);


    /**
     * 查询列表(分页) listpage
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    +"select * from t_collect_account_withdraw where 1=1 "

                    + "<if test='params.transBeginDate != null'> and gmt_create &gt;= #{params.transBeginDate} </if>"
                    + "<if test='params.transEndDate != null'>and gmt_create &lt;= #{params.transEndDate}</if>"
                    +"<if test='params.userCreate != null'>and user_create = #{params.userCreate}  </if> "
                    +"<if test='params.userModified != null'>and user_modified = #{params.userModified} </if> "
                    +"<if test='params.gmtModified != null'>and gmt_modified = #{params.gmtModified} </if> "
                    +"<if test='params.clientTransId != null'>and client_trans_id = #{params.clientTransId} </if> "
                    +"<if test='params.reciveOpBankCode != null'> and recive_op_bank_code = #{params.reciveOpBankCode} </if> "
                    +"<if test='params.reciveOpBankName != null'>  and recive_op_bank_name like concat('%',#{params.reciveOpBankName},'%') </if> "
                    +"<if test='params.reciveClBankCode != null'>  and recive_cl_bank_code = #{params.reciveClBankCode} </if> "
                    +"<if test='params.reciveAccountNo != null'>and recive_account_no = #{params.reciveAccountNo}  </if> "
                    +"<if test='params.reciveAccountName != null'>and recive_account_name = #{rparams.eciveAccountName}  </if> "
                    +"<if test='params.account != null'>and account = #{params.account}  </if> "
                    +"<if test='params.amount != null'>and amount = #{params.amount}  </if> "
                    +"<if test='params.status != null'>and status = #{params.status}  </if> "
                    +"<if test='params.auditStatus != null'>and audit_status = #{params.auditStatus}  </if> "
                    +"<if test='params.industryCode != null'> and  industry_code = #{params.industryCode} </if> "
                    +"<if test='params.industryName != null'> and industry_name like concat('%', #{params.industryName},'%') </if> "
                    +"<if test='params.fundAccountNo != null'> and fund_account_no = #{params.fundAccountNo} </if> "
                    +"<if test='params.fundAccountName != null'> and fund_account_name = #{params.fundAccountName} </if> "
                    +"</script>"
    )
    @ResultMap("WithdrawalsRecordResultMap")
    Page<WithdrawalsRecordDO> listPage(@Param("params") Map<String, Object> params);



}

