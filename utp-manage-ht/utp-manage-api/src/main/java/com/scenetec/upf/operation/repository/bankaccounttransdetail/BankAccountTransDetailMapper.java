package com.scenetec.upf.operation.repository.bankaccounttransdetail;

import com.scenetec.upf.operation.model.domain.bankaccounttransdetail.BankAccountTransDetailDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2019/02/27
 */
@Repository
@Mapper
public interface BankAccountTransDetailMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_bank_account_trans_detail (user_create,gmt_create,user_modified,gmt_modified,industry_code,card_number,cust_account_no,cust_account_name,txn_date,nature_date,detail_serial_number,drcr_flag,txn_amount,account_balance,other_cust_account_no,other_cust_name,reversed_flag,remark_detail,txn_time,sys_reference_no,org_sys_reference_no,other_bank_name,other_remark,oper_status) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{industryCode},#{cardNumber},#{custAccountNo},#{custAccountName},#{txnDate},#{natureDate},#{detailSerialNumber},#{drcrFlag},#{txnAmount},#{accountBalance},#{otherCustAccountNo},#{otherCustName},#{reversedFlag},#{remarkDetail},#{txnTime},#{sysReferenceNo},#{orgSysReferenceNo},#{otherBankName},#{otherRemark},#{operStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(BankAccountTransDetailDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_bank_account_trans_detail ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, card_number, cust_account_no, cust_account_name, txn_date, nature_date, detail_serial_number, drcr_flag, txn_amount, account_balance, other_cust_account_no, other_cust_name, reversed_flag, remark_detail, txn_time, sys_reference_no, org_sys_reference_no, other_bank_name, other_remark, oper_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.cardNumber}, #{item.custAccountNo}, #{item.custAccountName}, #{item.txnDate}, #{item.natureDate}, #{item.detailSerialNumber}, #{item.drcrFlag}, #{item.txnAmount}, #{item.accountBalance}, #{item.otherCustAccountNo}, #{item.otherCustName}, #{item.reversedFlag}, #{item.remarkDetail}, #{item.txnTime}, #{item.sysReferenceNo}, #{item.orgSysReferenceNo}, #{item.otherBankName}, #{item.otherRemark}, #{item.operStatus})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<BankAccountTransDetailDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_bank_account_trans_detail ("
        +" user_create, gmt_create, user_modified, gmt_modified, industry_code, card_number, cust_account_no, cust_account_name, txn_date, nature_date, detail_serial_number, drcr_flag, txn_amount, account_balance, other_cust_account_no, other_cust_name, reversed_flag, remark_detail, txn_time, sys_reference_no, org_sys_reference_no, other_bank_name, other_remark, oper_status"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.industryCode}, #{item.cardNumber}, #{item.custAccountNo}, #{item.custAccountName}, #{item.txnDate}, #{item.natureDate}, #{item.detailSerialNumber}, #{item.drcrFlag}, #{item.txnAmount}, #{item.accountBalance}, #{item.otherCustAccountNo}, #{item.otherCustName}, #{item.reversedFlag}, #{item.remarkDetail}, #{item.txnTime}, #{item.sysReferenceNo}, #{item.orgSysReferenceNo}, #{item.otherBankName}, #{item.otherRemark}, #{item.operStatus})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"industry_code = VALUES(industry_code),"
            +"card_number = VALUES(card_number),"
            +"cust_account_no = VALUES(cust_account_no),"
            +"cust_account_name = VALUES(cust_account_name),"
            +"txn_date = VALUES(txn_date),"
            +"nature_date = VALUES(nature_date),"
            +"detail_serial_number = VALUES(detail_serial_number),"
            +"drcr_flag = VALUES(drcr_flag),"
            +"txn_amount = VALUES(txn_amount),"
            +"account_balance = VALUES(account_balance),"
            +"other_cust_account_no = VALUES(other_cust_account_no),"
            +"other_cust_name = VALUES(other_cust_name),"
            +"reversed_flag = VALUES(reversed_flag),"
            +"remark_detail = VALUES(remark_detail),"
            +"txn_time = VALUES(txn_time),"
            +"sys_reference_no = VALUES(sys_reference_no),"
            +"org_sys_reference_no = VALUES(org_sys_reference_no),"
            +"other_bank_name = VALUES(other_bank_name),"
            +"other_remark = VALUES(other_remark),"
            +"oper_status = VALUES(oper_status)"
        +"</script>"
    )
    int modifyList(List<BankAccountTransDetailDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_bank_account_trans_detail where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_bank_account_trans_detail <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
            +"<if test='cardNumber != null'> card_number = #{cardNumber}, </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo}, </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName}, </if> "
            +"<if test='txnDate != null'> txn_date = #{txnDate}, </if> "
            +"<if test='natureDate != null'> nature_date = #{natureDate}, </if> "
            +"<if test='detailSerialNumber != null'> detail_serial_number = #{detailSerialNumber}, </if> "
            +"<if test='drcrFlag != null'> drcr_flag = #{drcrFlag}, </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount}, </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance}, </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo}, </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName}, </if> "
            +"<if test='reversedFlag != null'> reversed_flag = #{reversedFlag}, </if> "
            +"<if test='remarkDetail != null'> remark_detail = #{remarkDetail}, </if> "
            +"<if test='txnTime != null'> txn_time = #{txnTime}, </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo}, </if> "
            +"<if test='orgSysReferenceNo != null'> org_sys_reference_no = #{orgSysReferenceNo}, </if> "
            +"<if test='otherBankName != null'> other_bank_name = #{otherBankName}, </if> "
            +"<if test='otherRemark != null'> other_remark = #{otherRemark}, </if> "
            +"<if test='operStatus != null'> oper_status = #{operStatus}, </if> "
            +"<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(BankAccountTransDetailDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,card_number,cust_account_no,cust_account_name,txn_date,nature_date,detail_serial_number,drcr_flag,txn_amount,account_balance,other_cust_account_no,other_cust_name,reversed_flag,remark_detail,txn_time,sys_reference_no,org_sys_reference_no,other_bank_name,other_remark,oper_status from t_bank_account_trans_detail where id = #{id}")
 	@Results(id="BankAccountTransDetailResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "industryCode", column = "industry_code"),@Result(property = "cardNumber", column = "card_number"),@Result(property = "custAccountNo", column = "cust_account_no"),@Result(property = "custAccountName", column = "cust_account_name"),@Result(property = "txnDate", column = "txn_date"),@Result(property = "natureDate", column = "nature_date"),@Result(property = "detailSerialNumber", column = "detail_serial_number"),@Result(property = "drcrFlag", column = "drcr_flag"),@Result(property = "txnAmount", column = "txn_amount"),@Result(property = "accountBalance", column = "account_balance"),@Result(property = "otherCustAccountNo", column = "other_cust_account_no"),@Result(property = "otherCustName", column = "other_cust_name"),@Result(property = "reversedFlag", column = "reversed_flag"),@Result(property = "remarkDetail", column = "remark_detail"),@Result(property = "txnTime", column = "txn_time"),@Result(property = "sysReferenceNo", column = "sys_reference_no"),@Result(property = "orgSysReferenceNo", column = "org_sys_reference_no"),@Result(property = "otherBankName", column = "other_bank_name"),@Result(property = "otherRemark", column = "other_remark"),@Result(property = "operStatus", column = "oper_status")})
 	BankAccountTransDetailDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,card_number,cust_account_no,cust_account_name,txn_date,nature_date,detail_serial_number,drcr_flag,txn_amount,account_balance,other_cust_account_no,other_cust_name,reversed_flag,remark_detail,txn_time,sys_reference_no,org_sys_reference_no,other_bank_name,other_remark,oper_status from t_bank_account_trans_detail where 1 = 1"
		        + "<if test='params.industryCode != null'> and industry_code = #{params.industryCode}</if>"
		        + "<if test='params.detailSerialNumber != null'> and detail_serial_number = #{params.detailSerialNumber}</if>"
		        + "<if test='params.custAccountNo != null'> and cust_account_no = #{params.custAccountNo}</if>"
		        + "<if test='params.txnDate != null'> and txn_date = #{params.txnDate}</if>"
        + "</script>"
    )
    @ResultMap("BankAccountTransDetailResultMap")
    Page<BankAccountTransDetailDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,card_number,cust_account_no,cust_account_name,txn_date,nature_date,detail_serial_number,drcr_flag,txn_amount,account_balance,other_cust_account_no,other_cust_name,reversed_flag,remark_detail,txn_time,sys_reference_no,org_sys_reference_no,other_bank_name,other_remark,oper_status,audit_status as auditStatus  from t_bank_account_trans_detail where 1 = 1"
                    + "<if test='params.transBeginDate != null'> and txn_date &gt;= #{params.transBeginDate} </if>"
                    + "<if test='params.transEndDate != null'>and txn_date &lt;= #{params.transEndDate}</if>"
                    + "<if test='params.custAccountNo != null'> and cust_account_no = #{params.custAccountNo}</if>"
                    + "<if test='params.custAccountName != null'> and cust_account_name like concat('%',#{params.custAccountName},'%')</if>"
                    + "<if test='params.otherCustAccountNo != null'> and other_cust_account_no = #{params.otherCustAccountNo}</if>"
                    + "<if test='params.otherCustName != null'>and other_cust_name like concat('%',#{params.otherCustName},'%') </if>"
                    + "<if test='params.operStatus != null'>and oper_status = #{params.operStatus}</if>"
                    +
                    "</script>"
    )
    @ResultMap("BankAccountTransDetailResultMap")
    Page<BankAccountTransDetailDO> listPage(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_bank_account_trans_detail <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='cardNumber != null'> card_number = #{cardNumber} AND </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo} AND </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName} AND </if> "
            +"<if test='txnDate != null'> txn_date = #{txnDate} AND </if> "
            +"<if test='natureDate != null'> nature_date = #{natureDate} AND </if> "
            +"<if test='detailSerialNumber != null'> detail_serial_number = #{detailSerialNumber} AND </if> "
            +"<if test='drcrFlag != null'> drcr_flag = #{drcrFlag} AND </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount} AND </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance} AND </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo} AND </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName} AND </if> "
            +"<if test='reversedFlag != null'> reversed_flag = #{reversedFlag} AND </if> "
            +"<if test='remarkDetail != null'> remark_detail = #{remarkDetail} AND </if> "
            +"<if test='txnTime != null'> txn_time = #{txnTime} AND </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo} AND </if> "
            +"<if test='orgSysReferenceNo != null'> org_sys_reference_no = #{orgSysReferenceNo} AND </if> "
            +"<if test='otherBankName != null'> other_bank_name = #{otherBankName} AND </if> "
            +"<if test='otherRemark != null'> other_remark = #{otherRemark} AND </if> "
            +"<if test='operStatus != null'> oper_status = #{operStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(BankAccountTransDetailDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,card_number,cust_account_no,cust_account_name,txn_date,nature_date,detail_serial_number,drcr_flag,txn_amount,account_balance,other_cust_account_no,other_cust_name,reversed_flag,remark_detail,txn_time,sys_reference_no,org_sys_reference_no,other_bank_name,other_remark,oper_status from t_bank_account_trans_detail"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='cardNumber != null'> card_number = #{cardNumber} AND </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo} AND </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName} AND </if> "
            +"<if test='txnDate != null'> txn_date = #{txnDate} AND </if> "
            +"<if test='natureDate != null'> nature_date = #{natureDate} AND </if> "
            +"<if test='detailSerialNumber != null'> detail_serial_number = #{detailSerialNumber} AND </if> "
            +"<if test='drcrFlag != null'> drcr_flag = #{drcrFlag} AND </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount} AND </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance} AND </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo} AND </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName} AND </if> "
            +"<if test='reversedFlag != null'> reversed_flag = #{reversedFlag} AND </if> "
            +"<if test='remarkDetail != null'> remark_detail = #{remarkDetail} AND </if> "
            +"<if test='txnTime != null'> txn_time = #{txnTime} AND </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo} AND </if> "
            +"<if test='orgSysReferenceNo != null'> org_sys_reference_no = #{orgSysReferenceNo} AND </if> "
            +"<if test='otherBankName != null'> other_bank_name = #{otherBankName} AND </if> "
            +"<if test='otherRemark != null'> other_remark = #{otherRemark} AND </if> "
            +"<if test='operStatus != null'> oper_status = #{operStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("BankAccountTransDetailResultMap")
    BankAccountTransDetailDO selectOne(BankAccountTransDetailDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,industry_code,card_number,cust_account_no,cust_account_name,txn_date,nature_date,detail_serial_number,drcr_flag,txn_amount,account_balance,other_cust_account_no,other_cust_name,reversed_flag,remark_detail,txn_time,sys_reference_no,org_sys_reference_no,other_bank_name,other_remark,oper_status from t_bank_account_trans_detail"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
            +"<if test='cardNumber != null'> card_number = #{cardNumber} AND </if> "
            +"<if test='custAccountNo != null'> cust_account_no = #{custAccountNo} AND </if> "
            +"<if test='custAccountName != null'> cust_account_name = #{custAccountName} AND </if> "
            +"<if test='txnDate != null'> txn_date = #{txnDate} AND </if> "
            +"<if test='natureDate != null'> nature_date = #{natureDate} AND </if> "
            +"<if test='detailSerialNumber != null'> detail_serial_number = #{detailSerialNumber} AND </if> "
            +"<if test='drcrFlag != null'> drcr_flag = #{drcrFlag} AND </if> "
            +"<if test='txnAmount != null'> txn_amount = #{txnAmount} AND </if> "
            +"<if test='accountBalance != null'> account_balance = #{accountBalance} AND </if> "
            +"<if test='otherCustAccountNo != null'> other_cust_account_no = #{otherCustAccountNo} AND </if> "
            +"<if test='otherCustName != null'> other_cust_name = #{otherCustName} AND </if> "
            +"<if test='reversedFlag != null'> reversed_flag = #{reversedFlag} AND </if> "
            +"<if test='remarkDetail != null'> remark_detail = #{remarkDetail} AND </if> "
            +"<if test='txnTime != null'> txn_time = #{txnTime} AND </if> "
            +"<if test='sysReferenceNo != null'> sys_reference_no = #{sysReferenceNo} AND </if> "
            +"<if test='orgSysReferenceNo != null'> org_sys_reference_no = #{orgSysReferenceNo} AND </if> "
            +"<if test='otherBankName != null'> other_bank_name = #{otherBankName} AND </if> "
            +"<if test='otherRemark != null'> other_remark = #{otherRemark} AND </if> "
            +"<if test='operStatus != null'> oper_status = #{operStatus} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("BankAccountTransDetailResultMap")
    List<BankAccountTransDetailDO> selectList(BankAccountTransDetailDO obj);

}

