package com.scenetec.upf.operation.repository.industry;

import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;

import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/09/29
 */
@Repository
@Mapper
public interface IndustryMapper {

    /**
     * 创建
     *
     * @param obj
     * @return
     */

    @Insert("insert into t_industry (id,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,bank_code,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,fund_account,whether_external,audit_status,collection_industry_id,business_type,dn,max_brokerage_rate,balance_pay_period,is_opne_double_acc,is_opne_balance_pay,authentication_mode,need_public_auth_amt,able_bind_multi_card,auth_payment_account_id,open_sub_single_pay,verify_payee_account_sign,verify_payee_white_list_sign,payer_sub_type,sub_income_type,able_trans_order_init,sub_account_open_max,reconciliation_mode,able_download_daily_balance,open_account_mode,industry_income_type,open_show_custom_flag) " +
            "values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{name},#{simpleName},#{code},#{provinceCode},#{cityCode},#{countyCode},#{account},#{accountName},#{bankName},#{bankCode},#{status},#{custNumber},#{custAccountNo},#{custAccountName},#{innerNoticeUrl},#{feeExpenditureAccount},#{processingFeeIncomeAccount},#{orgCode},#{orgName},#{industryType},#{fundAccount},#{whetherExternal},#{auditStatus},#{collectionIndustryId},#{businessType},#{dn},#{maxBrokerageRate},#{balancePayPeriod},#{isOpneDoubleAcc},#{isOpneBalancePay},#{authenticationMode},#{needPublicAuthAmt},#{ableBindMultiCard},#{authPaymentAccountId},#{openSubSinglePay},#{verifyPayeeAccountSign},#{verifyPayeeWhiteListSign},#{payerSubType},#{subIncomeType},#{ableTransOrderInit},#{subAccountOpenMax},#{reconciliationMode},#{ableDownloadDailyBalance},#{openAccountMode},#{industryIncomeType},#{openShowCustomFlag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(IndustryDO obj);


    /**
     * 批量插入
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_industry ("
                    + " user_create, gmt_create, user_modified, gmt_modified, name, simple_name, code, province_code, city_code, county_code, account, account_name, bank_name, bank_code, status" + ",cust_number,cust_account_no,cust_account_name,inner_notice_url,org_code,org_name,fee_expenditure_account,industry_type,fund_account,whether_external,processing_fee_income_account,audit_status,collection_industry_id"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.name}, #{item.simpleName}, #{item.code}, #{item.provinceCode}, #{item.cityCode}, #{item.countyCode}, #{item.account}, #{item.accountName}, #{item.bankName}, #{item.bankCode}, #{item.status},#{item.custNumber},#{item.custAccountNo},#{item.custAccountName},#{item.innerNoticeUrl},#{item.orgCode},#{item.orgName},#{item.feeExpenditureAccount},#{item.industryType},#{item.fundAccount},#{item.whetherExternal},#{item.processingFeeIncomeAccount},#{item.auditStatus},#{item.collectionIndustryId})"
                    + "</foreach>"
                    + "</script>"
    )
    int insertList(List<IndustryDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_industry ("
                    + " user_create, gmt_create, user_modified, gmt_modified, name, simple_name, code, province_code, city_code, county_code, account, account_name, bank_name, bank_code,inner_notice_url,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,fund_account,whether_external, status,audit_status"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.name}, #{item.simpleName}, #{item.code}, #{item.provinceCode}, #{item.cityCode}, #{item.countyCode}, #{item.account}, #{item.accountName}, #{item.bankName}, #{item.bankCode},#{item.innerNoticeUrl},#{item.feeExpenditureAccount},#{item.processingFeeIncomeAccount},#{item.orgCode},#{item.orgName},#{item.industryType},#{item.fundAccount},#{item.whetherExternal}, #{item.status}, #{item.auditStatus})"
                    + "</foreach>"
                    + " ON DUPLICATE KEY UPDATE "
                    + "user_create = VALUES(user_create),"
                    + "gmt_create = VALUES(gmt_create),"
                    + "user_modified = VALUES(user_modified),"
                    + "gmt_modified = VALUES(gmt_modified),"
                    + "name = VALUES(name),"
                    + "simple_name = VALUES(simple_name),"
                    + "code = VALUES(code),"
                    + "province_code = VALUES(province_code),"
                    + "city_code = VALUES(city_code),"
                    + "county_code = VALUES(county_code),"
                    + "account = VALUES(account),"
                    + "account_name = VALUES(account_name),"
                    + "bank_name = VALUES(bank_name),"
                    + "bank_code = VALUES(bank_code),"
                    + "inner_notice_url = VALUES(inner_notice_url),"
                    + "fee_expenditure_account = VALUES(fee_expenditure_account),"
                    + "processing_fee_income_account = VALUES(processing_fee_income_account),"
                    + "status = VALUES(status),"
                    + "org_code = VALUES(org_code),"
                    + "industry_type = VALUES(industry_type),"
                    + "fund_account = VALUES(fund_account),"
                    + "whether_external = VALUES(whether_external),"
                    + "status = VALUES(status),"
                    + "audit_status = VALUES(audit_status),"
                    + "</script>"
    )
    int modifyList(List<IndustryDO> obj);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Delete("delete from t_industry where id = #{id}")
    int delete(Long id);

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    @Delete("update t_industry set status=0 where id = #{id}")
    int deleteLogic(Long id);

    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_industry <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='name != null'> name = #{name}, </if> "
                    + "<if test='simpleName != null'> simple_name = #{simpleName}, </if> "
                    + "<if test='code != null'> code = #{code}, </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode}, </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode}, </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode}, </if> "
                    + "<if test='account != null'> account = #{account}, </if> "
                    + "<if test='accountName != null'> account_name = #{accountName}, </if> "
                    + "<if test='bankName != null'> bank_name = #{bankName}, </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "<if test='custNumber != null'> cust_number = #{custNumber}, </if> "
                    + "<if test='custAccountNo != null'> cust_account_no = #{custAccountNo}, </if> "
                    + "<if test='custAccountName != null'> cust_account_name = #{custAccountName}, </if> "
                    + "<if test='innerNoticeUrl != null'> inner_notice_url = #{innerNoticeUrl}, </if> "
                    + "<if test='feeExpenditureAccount != null'> fee_expenditure_account = #{feeExpenditureAccount}, </if> "
                    + "<if test='processingFeeIncomeAccount != null'> processing_fee_income_account = #{processingFeeIncomeAccount}, </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode}, </if> "
                    + "<if test='orgName != null'> org_name = #{orgName}, </if> "
                    + "<if test='industryType != null'> industry_type = #{industryType}, </if> "
                    + "<if test='fundAccount != null'> fund_account = #{fundAccount}, </if> "
                    + "<if test='whetherExternal != null'> whether_external = #{whetherExternal}, </if> "
                    + "<if test='collectionIndustryId != null'> collection_industry_id = #{collectionIndustryId}, </if> "
                    + "<if test='entName != null'> ent_name = #{entName}, </if> "
                    + "<if test='regAddress != null'> reg_address = #{regAddress}, </if> "
                    + "<if test='personPic != null'> person_pic = #{personPic}, </if> "
                    + "<if test='busLicCode != null'> bus_lic_code = #{busLicCode}, </if> "
                    + "<if test='idType != null'> id_type = #{idType}, </if> "
                    + "<if test='idCode != null'> id_code = #{idCode}, </if> "
                    + "<if test='busLicPic != null'> bus_lic_pic = #{busLicPic}, </if> "
                    + "<if test='personReversePic != null'> person_reverse_pic = #{personReversePic}, </if> "
                    + "<if test='licensePic != null'> license_pic = #{licensePic}, </if> "
                    + "<if test='accountNo != null'> account_no = #{accountNo}, </if> "
                    + "<if test='businessType != null'> business_type = #{businessType}, </if> "
                    + "<if test='dn != null'> dn = #{dn}, </if> "
                    + "<if test='maxBrokerageRate != null'> max_brokerage_rate = #{maxBrokerageRate}, </if> "
                    + "<if test='legalPerson != null'> legal_person = #{legalPerson}, </if> "
                    + "<if test='nationality != null'> nationality = #{nationality}, </if> "
                    + "<if test='phone != null'> phone = #{phone}, </if> "
                    + "<if test='customerTrade != null'> customer_trade = #{customerTrade}, </if> "
                    + "<if test='fileType != null'> file_type = #{fileType}, </if> "
                    + "<if test='otherFileType != null'> other_file_type = #{otherFileType}, </if> "
                    + "<if test='fileNum != null'> file_num = #{fileNum}, </if> "
                    + "<if test='balancePayPeriod != null'> balance_pay_period = #{balancePayPeriod}, </if> "
                    + "<if test='isOpneDoubleAcc != null'> is_opne_double_acc = #{isOpneDoubleAcc}, </if> "
                    + "<if test='isOpneBalancePay != null'> is_opne_balance_pay = #{isOpneBalancePay}, </if> "
                    + "<if test='authenticationMode != null'> authentication_mode = #{authenticationMode}, </if> "
                    + "<if test='needPublicAuthAmt != null'> need_public_auth_amt = #{needPublicAuthAmt}, </if> "
                    + "<if test='ableBindMultiCard != null'> able_bind_multi_card = #{ableBindMultiCard}, </if> "
                    + "<if test='authPaymentAccountId != null'> auth_payment_account_id = #{authPaymentAccountId}, </if> "
                    + "<if test='openSubSinglePay != null'> open_sub_single_pay = #{openSubSinglePay}, </if> "
                    + "<if test='verifyPayeeAccountSign != null'> verify_payee_account_sign = #{verifyPayeeAccountSign}, </if> "
                    + "<if test='verifyPayeeWhiteListSign != null'> verify_payee_white_list_sign = #{verifyPayeeWhiteListSign}, </if> "
                    + "<if test='payerSubType != null'> payer_sub_type = #{payerSubType}, </if> "
                    + "<if test='subAccountOpenMax != null'> sub_account_open_max = #{subAccountOpenMax}, </if> "
                    + "<if test='subIncomeType != null'> sub_income_type = #{subIncomeType}, </if> "
                    + "<if test='ableTransOrderInit != null'> able_trans_order_init = #{ableTransOrderInit}, </if> "
                    + "<if test='reconciliationMode != null'> reconciliation_mode = #{reconciliationMode}, </if> "
                    + "<if test='ableDownloadDailyBalance != null'> able_download_daily_balance = #{ableDownloadDailyBalance}, </if> "
                    + "<if test='openAccountMode != null'> open_account_mode = #{openAccountMode}, </if> "
                    + "<if test='industryIncomeType != null'> industry_income_type = #{industryIncomeType}, </if> "
                    + "<if test='openShowCustomFlag != null'> open_show_custom_flag = #{openShowCustomFlag}, </if> "
                    + "</set> where id = #{id}"
                    + "</script>"
    )
    int update(IndustryDO obj);


    @Update(
            "<script>"
                    + "update t_industry <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='name != null'> name = #{name}, </if> "
                    + "<if test='simpleName != null'> simple_name = #{simpleName}, </if> "
                    + "<if test='code != null'> code = #{code}, </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode}, </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode}, </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode}, </if> "
                    + "<if test='accountName != null'> account_name = #{accountName}, </if> "
                    + "<if test='bankName != null'> bank_name = #{bankName}, </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "<if test='custNumber != null'> cust_number = #{custNumber}, </if> "
                    + "<if test='custAccountNo != null'> cust_account_no = #{custAccountNo}, </if> "
                    + "<if test='custAccountName != null'> cust_account_name = #{custAccountName}, </if> "
                    + "<if test='innerNoticeUrl != null'> inner_notice_url = #{innerNoticeUrl}, </if> "
                    + "<if test='feeExpenditureAccount != null'> fee_expenditure_account = #{feeExpenditureAccount}, </if> "
                    + "<if test='processingFeeIncomeAccount != null'> processing_fee_income_account = #{processingFeeIncomeAccount}, </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode}, </if> "
                    + "<if test='orgName != null'> org_name = #{orgName}, </if> "
                    + "<if test='industryType != null'> industry_type = #{industryType}, </if> "
                    + "<if test='fundAccount != null'> fund_account = #{fundAccount}, </if> "
                    + "<if test='whetherExternal != null'> whether_external = #{whetherExternal}, </if> "
                    + "<if test='collectionIndustryId != null'> collection_industry_id = #{collectionIndustryId}, </if> "
                    + "<if test='entName != null'> ent_name = #{entName}, </if> "
                    + "<if test='regAddress != null'> reg_address = #{regAddress}, </if> "
                    + "<if test='personPic != null'> person_pic = #{personPic}, </if> "
                    + "<if test='busLicCode != null'> bus_lic_code = #{busLicCode}, </if> "
                    + "<if test='idType != null'> id_type = #{idType}, </if> "
                    + "<if test='idCode != null'> id_code = #{idCode}, </if> "
                    + "<if test='busLicPic != null'> bus_lic_pic = #{busLicPic}, </if> "
                    + "<if test='personReversePic != null'> person_reverse_pic = #{personReversePic}, </if> "
                    + "<if test='licensePic != null'> license_pic = #{licensePic}, </if> "
                    + "<if test='accountNo != null'> account_no = #{accountNo}, </if> "
                    + "<if test='businessType != null'> business_type = #{businessType}, </if> "
                    + "<if test='dn != null'> dn = #{dn}, </if> "
                    + "<if test='maxBrokerageRate != null'> max_brokerage_rate = #{maxBrokerageRate}, </if> "
                    + "<if test='legalPerson != null'> legal_person = #{legalPerson}, </if> "
                    + "<if test='nationality != null'> nationality = #{nationality}, </if> "
                    + "<if test='phone != null'> phone = #{phone}, </if> "
                    + "<if test='customerTrade != null'> customer_trade = #{customerTrade}, </if> "
                    + "<if test='fileType != null'> file_type = #{fileType}, </if> "
                    + "<if test='otherFileType != null'> other_file_type = #{otherFileType}, </if> "
                    + "<if test='fileNum != null'> file_num = #{fileNum}, </if> "
                    + "<if test='balancePayPeriod != null'> balance_pay_period = #{balancePayPeriod}, </if> "
                    + "<if test='isOpneDoubleAcc != null'> is_opne_double_acc = #{isOpneDoubleAcc}, </if> "
                    + "<if test='isOpneBalancePay != null'> is_opne_balance_pay = #{isOpneBalancePay}, </if> "
                    + "<if test='authenticationMode != null'> authentication_mode = #{authenticationMode}, </if> "
                    + "<if test='needPublicAuthAmt != null'> need_public_auth_amt = #{needPublicAuthAmt}, </if> "
                    + "<if test='ableBindMultiCard != null'> able_bind_multi_card = #{ableBindMultiCard}, </if> "
                    + "<if test='authPaymentAccountId != null'> auth_payment_account_id = #{authPaymentAccountId}, </if> "
                    + "<if test='openSubSinglePay != null'> open_sub_single_pay = #{openSubSinglePay}, </if> "
                    + "<if test='verifyPayeeAccountSign != null'> verify_payee_account_sign = #{verifyPayeeAccountSign}, </if> "
                    + "<if test='verifyPayeeWhiteListSign != null'> verify_payee_white_list_sign = #{verifyPayeeWhiteListSign}, </if> "
                    + "<if test='payerSubType != null'> payer_sub_type = #{payerSubType}, </if> "
                    + "</set> where account = #{account}"
                    + "</script>"
    )
    int updateForAccount(IndustryDO obj);


    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_industry <set> "
                    + "<if test='auditStatus != null'> audit_status = #{auditStatus}, </if> "
                    + "</set> where id = #{id}"
                    + "</script>"
    )
    int updateAuditStatus(IndustryDO obj);

    @Select("select id,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,bank_code,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,fund_account,whether_external,audit_status,collection_industry_id,business_type,dn,max_brokerage_rate,balance_pay_period,is_opne_double_acc,is_opne_balance_pay,authentication_mode,need_public_auth_amt,able_bind_multi_card,auth_payment_account_id,open_sub_single_pay,verify_payee_account_sign,verify_payee_white_list_sign,payer_sub_type,sub_income_type,able_trans_order_init,sub_account_open_max,sub_account_open_max,reconciliation_mode,able_download_daily_balance,open_account_mode,industry_income_type,open_show_custom_flag from t_industry where id = #{id}")
    @ResultMap("IndustryResultMap")
    IndustryDO getByIdExImage(@Param("id") Long id);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    @Select("select * from t_industry where id = #{id}")
    @Results(id = "IndustryResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userCreate", column = "user_create")
            , @Result(property = "gmtCreate", column = "gmt_create")
            , @Result(property = "userModified", column = "user_modified")
            , @Result(property = "gmtModified", column = "gmt_modified")
            , @Result(property = "name", column = "name")
            , @Result(property = "simpleName", column = "simple_name")
            , @Result(property = "code", column = "code")
            , @Result(property = "provinceCode", column = "province_code")
            , @Result(property = "cityCode", column = "city_code")
            , @Result(property = "countyCode", column = "county_code")
            , @Result(property = "account", column = "account")
            , @Result(property = "accountName", column = "account_name")
            , @Result(property = "bankName", column = "bank_name")
            , @Result(property = "bankCode", column = "bank_code")
            , @Result(property = "status", column = "status")
            , @Result(property = "custNumber", column = "cust_number")
            , @Result(property = "custAccountNo", column = "cust_account_no")
            , @Result(property = "custAccountName", column = "cust_account_name")
            , @Result(property = "innerNoticeUrl", column = "inner_notice_url")
            , @Result(property = "feeExpenditureAccount", column = "fee_expenditure_account")
            , @Result(property = "processingFeeIncomeAccount", column = "processing_fee_income_account")
            , @Result(property = "certId", column = "cert_id")
            , @Result(property = "orgCode", column = "org_code")
            , @Result(property = "orgName", column = "org_name")
            , @Result(property = "industryType", column = "industry_type")
            , @Result(property = "fundAccount", column = "fund_account")
            , @Result(property = "whetherExternal", column = "whether_external")
            , @Result(property = "auditStatus", column = "audit_status")
            , @Result(property = "collectionIndustryId", column = "collection_industry_id")
            , @Result(property = "entName", column = "ent_name")
            , @Result(property = "busLicCode", column = "bus_lic_code")
            , @Result(property = "idType", column = "id_type")
            , @Result(property = "idCode", column = "id_code")
            , @Result(property = "busLicPic", column = "bus_lic_pic")
            , @Result(property = "personPic", column = "person_pic")
            , @Result(property = "personReversePic", column = "person_reverse_pic")
            , @Result(property = "licensePic", column = "license_pic")
            , @Result(property = "accountNo", column = "account_no")
            , @Result(property = "regAddress", column = "reg_address")
            , @Result(property = "businessType", column = "business_type")
            , @Result(property = "dn", column = "dn")
            , @Result(property = "maxBrokerageRate", column = "max_brokerage_rate")
            , @Result(property = "legalPerson", column = "legal_person")
            , @Result(property = "nationality", column = "nationality")
            , @Result(property = "phone", column = "phone")
            , @Result(property = "customerTrade", column = "customer_trade")
            , @Result(property = "fileType", column = "file_type")
            , @Result(property = "otherFileType", column = "other_file_type")
            , @Result(property = "fileNum", column = "file_num")
            , @Result(property = "balancePayPeriod", column = "balance_pay_period")
            , @Result(property = "isOpneDoubleAcc", column = "is_opne_double_acc")
            , @Result(property = "isOpneBalancePay", column = "is_opne_balance_pay")
            , @Result(property = "authenticationMode", column = "authentication_mode")
            , @Result(property = "needPublicAuthAmt", column = "need_public_auth_amt")
            , @Result(property = "ableBindMultiCard", column = "able_bind_multi_card")
            , @Result(property = "authPaymentAccountId", column = "auth_payment_account_id")
            , @Result(property = "openSubSinglePay", column = "open_sub_single_pay")
            , @Result(property = "verifyPayeeAccountSign", column = "verify_payee_account_sign")
            , @Result(property = "verifyPayeeWhiteListSign", column = "verify_payee_white_list_sign")
            , @Result(property = "payerSubType", column = "payer_sub_type")
            , @Result(property = "subIncomeType", column = "sub_income_type")
            , @Result(property = "ableTransOrderInit", column = "able_trans_order_init")
            , @Result(property = "subAccountOpenMax", column = "sub_account_open_max")
            , @Result(property = "reconciliationMode", column = "reconciliation_mode")
            , @Result(property = "ableDownloadDailyBalance", column = "able_download_daily_balance")
            , @Result(property = "openAccountMode", column = "open_account_mode")
            , @Result(property = "industryIncomeType", column = "industry_income_type")
            , @Result(property = "openShowCustomFlag", column = "open_show_custom_flag")
    }
    )
    IndustryDO getById(@Param("id") Long id);

    @Select("select id,${pciType} from t_industry where account = #{account}")
    @ResultMap("IndustryResultMap")
    IndustryDO getByIdForImage(@Param("account") String account,@Param("pciType") String pciType);

    @Select("select name from t_industry where code = #{code}")
    @ResultMap("IndustryResultMap")
    IndustryDO getByCode(@Param("code") String code);
    /**
     * 查询列表(分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id,dn from t_industry where 1 = 1"
                    + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.code != null'> and code = #{params.code}</if>"
                    + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
                    + "<if test='params.industryType != null'> and industry_type = #{params.industryType}</if>"
                    + "<if test='params.fundAccount != null'> and fund_account = #{params.fundAccount}</if>"
                    + "<if test='params.collectionFundAccount != null'> and fund_account != #{params.collectionFundAccount}</if>"
                    + "<if test='params.whetherExternal != null'> and whether_external = #{params.whetherExternal}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.status != null'> and status = #{params.status}</if>"
                    + "<if test='params.collectionIndustryId != null'> and collection_industry_id = #{params.collectionIndustryId}</if>"
                    + "<if test='params.processingFeeIncomeAccount != null'> and processing_fee_income_account = #{params.processingFeeIncomeAccount}</if>"

                    + "order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    Page<IndustryDO> pageList(@Param("params") Map<String, Object> params);


    @Select(
            "<script>"
                    + "select a.id,a.user_create,a.gmt_create,a.user_modified,a.gmt_modified,a.name,a.simple_name,a.code,a.province_code,a.city_code,a.county_code,a.account,a.account_name,a.bank_name,a.status,a.cust_number,a.cust_account_no,a.cust_account_name,a.inner_notice_url,a.fee_expenditure_account,a.fee_expenditure_account,a.processing_fee_income_account,a.org_code,a.org_name,a.industry_type,a.whether_external,a.fund_account,a.audit_status,a.collection_industry_id,a.dn from t_industry a where 1 = 1"
                    + "<if test='params.name != null'> and a.name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.code != null'> and a.code = #{params.code}</if>"
                    + "<if test='params.orgCode != null'> and a.org_code = #{params.orgCode}</if>"
                    + "<if test='params.industryType != null'> and a.industry_type = #{params.industryType}</if>"
                    + "<if test='params.fundAccount != null'> and a.fund_account = #{params.fundAccount}</if>"
                    + "<if test='params.collectionFundAccount != null'> and a.fund_account != #{params.collectionFundAccount}</if>"
                    + "<if test='params.whetherExternal != null'> and a.whether_external = #{params.whetherExternal}</if>"
                    + "<if test='params.auditStatus != null'> and a.audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.status != null'> and a.status = #{params.status}</if>"
                    + "<if test='params.collectionIndustryId != null'> and a.collection_industry_id = #{params.collectionIndustryId}</if>"
                    + "<if test='params.processingFeeIncomeAccount != null'> and a.processing_fee_income_account = #{params.processingFeeIncomeAccount}</if>"
                    + "<if test='params.industryType == 5 and params.id == null'> and not EXISTS ( SELECT fee_expenditure_account from t_industry b where b.fee_expenditure_account =a.id )  </if>"
                    + "<if test='params.industryType == 5 and params.id != null'> and not EXISTS ( SELECT b.fee_expenditure_account,b.id from t_industry b where b.fee_expenditure_account =a.id and b.id != #{params.id} ) </if>"
                    + "<if test='params.industryType ==10 and params.id == null'> and not EXISTS ( SELECT fee_expenditure_account from t_industry b where b.auth_payment_account_id =a.id ) </if>"
                    + "<if test='params.industryType ==10 and params.id != null'> and not EXISTS ( SELECT b.auth_payment_account_id,b.id  from t_industry b where b.auth_payment_account_id =a.id and b.id != #{params.id}) </if>"

                    + "order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    Page<IndustryDO> pageListFeeAndAuthAccount(@Param("params") Map<String, Object> params);


    /**
     * 查询列表(分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select ind.id,ind.user_create,ind.gmt_create,ind.user_modified,ind.gmt_modified,ind.name,ind.simple_name,ind.code,ind.province_code,ind.city_code,ind.county_code,ind.account,ind.account_name,ind.bank_name,ind.status,ind.cust_number,ind.cust_account_no,ind.cust_account_name,ind.inner_notice_url,ind.fee_expenditure_account,ind.fee_expenditure_account,ind.processing_fee_income_account,ind.org_code,ind.org_name,ind.industry_type,ind.whether_external,ind.fund_account,ind.audit_status,ind.collection_industry_id,ind.dn from t_industry ind " +
                    " left join t_special_industry_sync_config sy on ind.code = sy.industry_code where  sy.industry_code is null"
                    + "<if test='params.name != null'> and ind.name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.code != null'> and ind.code = #{params.code}</if>"
                    + "<if test='params.orgCode != null'> and ind.org_code = #{params.orgCode}</if>"
                    + "<if test='params.industryType != null'> and ind.industry_type = #{params.industryType}</if>"
                    + "<if test='params.fundAccount != null'> and ind.fund_account = #{params.fundAccount}</if>"
                    + "<if test='params.whetherExternal != null'> and ind.whether_external = #{params.whetherExternal}</if>"
                    + "<if test='params.auditStatus != null'> and ind.audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.status != null'> and ind.status = #{params.status}</if>"
                    + "<if test='params.collectionIndustryId != null'> and ind.collection_industry_id = #{params.collectionIndustryId}</if>"
                    + "<if test='params.processingFeeIncomeAccount != null'> and ind.processing_fee_income_account = #{params.processingFeeIncomeAccount}</if>"

                    + "order by ind.gmt_modified desc ,ind.gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    Page<IndustryDO> pageListExclude(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"
                    + "select id,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id,dn, open_sub_single_pay,verify_payee_account_sign,verify_payee_white_list_sign,payer_sub_type from t_industry where 1 = 1"
                    + "<if test='processingFeeIncomeAccount != null'> and processing_fee_income_account = #{processingFeeIncomeAccount}</if>"

                    + "order by gmt_modified desc ,gmt_create desc limit 1"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    IndustryDO selectOneBylimit(IndustryDO obj);


    @Select(
            "<script>"
                    + "select id,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id,dn from t_industry where 1 = 1"
                    + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.code != null'> and code = #{params.code}</if>"
                    + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
                    + "<if test='params.industryType != null'> and industry_type = #{params.industryType}</if>"
                    + "<if test='params.fundAccount != null'> and fund_account = #{params.fundAccount}</if>"
                    + "<if test='params.whetherExternal != null'> and whether_external = #{params.whetherExternal}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.status != null'> and status = #{params.status}</if>"
                    + "<if test='params.collectionIndustryId != null'> and collection_industry_id = #{params.collectionIndustryId}</if>"
                    + "<if test='params.id != null'> and id = #{params.id}</if>"

                    + "order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    Page<IndustryDO> pageCollectionList(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页) 正序。
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id from t_industry where 1 = 1"
                    + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.code != null'> and code = #{params.code}</if>"
                    + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
                    + "<if test='params.industryType != null'> and industry_type = #{params.industryType}</if>"
                    + "<if test='params.fundAccount != null'> and fund_account = #{params.fundAccount}</if>"
                    + "<if test='params.whetherExternal != null'> and whether_external = #{params.whetherExternal}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.status != null'> and status = #{params.status}</if>"
                    + "<if test='params.collectionIndustryId != null'> and ,collection_industry_id = #{params.collectionIndustryId}</if>"

                    + "order by gmt_modified asc ,gmt_create asc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    Page<IndustryDO> pageListAsc(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(分页) 费用账户查询
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id from t_industry where 1 = 1" + " and status = '1'"
                    + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.code != null'> and code = #{params.code}</if>"
                    + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
                    + "<if test='params.industryType != null'> and (industry_type = #{params.industryType}</if>"
                    + "<if test='params.industryTypePay != null'> or industry_type = #{params.industryTypePay}</if>"
                    + "<if test='params.authIndustryType != null'> or industry_type = #{params.authIndustryType}</if>"
                    + "<if test='params.industryTypeImputation != null'> or industry_type = #{params.industryTypeImputation})</if>"
                    + "<if test='params.fundAccount != null'> and fund_account = #{params.fundAccount}</if>"
                    + "<if test='params.whetherExternal != null'> and whether_external = #{params.whetherExternal}</if>"
                    + "<if test='params.auditStatus != null'> and audit_status = #{params.auditStatus}</if>"
                    + "<if test='params.collectionIndustryId != null'> and collection_industry_id = #{params.collectionIndustryId}</if>"
                    + "order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    Page<IndustryDO> pageListFeeAccount(@Param("params") Map<String, Object> params);

    /**
     * 查询列表(不分页)
     *
     * @param params
     * @return
     */
    @Select(
            "<script>"
                    + "select id,business_type,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id from t_industry where 1 = 1" + " and status = '1'"
                    + "<if test='params.name != null'> and name like concat('%',#{params.name},'%')</if>"
                    + "<if test='params.code != null'> and code = #{params.code}</if>"
                    + "<if test='params.industryType != null'> and industry_type = #{params.industryType}</if>"
                    + "<if test='params.fundAccount != null'> and fund_account = #{params.fundAccount}</if>"
                    + "<if test='params.whetherExternal != null'> and whether_external = #{params.whetherExternal}</if>"
                    + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
                    + "<if test='params.collectionIndustryId != null'> and collection_industry_id = #{params.collectionIndustryId}</if>"
                    + "<if test='params.businessType != null'> and business_type = #{params.businessType}</if>"
                    + "order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    List<IndustryDO> list(@Param("params") Map<String, Object> params);


    @Select(
            "<script>"
    +"select id,business_type,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id from t_industry where industry_type='1' and code not in (select industry_code from t_industry_amt_limit) order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    List<IndustryDO> industryUnTransactionLimitList(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) from t_industry <where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='name != null'> name = #{name} AND </if> "
                    + "<if test='simpleName != null'> simple_name = #{simpleName} AND </if> "
                    + "<if test='code != null'> code = #{code} AND </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    + "<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> " +
                    "<if test='innerNoticeUrl != null'> inner_notice_url = #{innerNoticeUrl} AND </if> "
                    + "<if test='feeExpenditureAccount != null'> fee_expenditure_account = #{feeExpenditureAccount} AND </if> "
                    + "<if test='processingFeeIncomeAccount != null'> processing_fee_income_account = #{processingFeeIncomeAccount} AND </if> "
                    + "<if test='collectionIndustryId != null'> collection_industry_id = #{collectionIndustryId} AND </if> "
                    + "<if test='id != null'> id != #{id} AND </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    + "<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    + "<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
                    + "<if test='whetherExternal != null'> whether_external = #{whetherExternal} AND </if> "
                    + "<if test='authPaymentAccountId != null'> auth_payment_account_id = #{authPaymentAccountId} AND </if> "
                    + "<if test='industryIncomeType != null'> industry_income_type = #{industryIncomeType} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    int count(IndustryDO obj);

    /**
     * 通过条件查询单条记录
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select * from t_industry"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> id = #{id} AND </if>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='name != null'> name = #{name} AND </if> "
                    + "<if test='simpleName != null'> simple_name = #{simpleName} AND </if> "
                    + "<if test='code != null'> code = #{code} AND </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    + "<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='innerNoticeUrl != null'> inner_notice_url = #{innerNoticeUrl} AND </if> "
                    + "<if test='feeExpenditureAccount != null'> fee_expenditure_account = #{feeExpenditureAccount} AND </if> "
                    + "<if test='processingFeeIncomeAccount != null'> processing_fee_income_account = #{processingFeeIncomeAccount} AND </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    + "<if test='orgName != null'> org_name = #{orgName} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    + "<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
                    + "<if test='whetherExternal != null'> whether_external = #{whetherExternal} AND </if> "
                    + "<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
                    + "<if test='collectionIndustryId != null'> collection_industry_id = #{collectionIndustryId} AND </if> "

                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    IndustryDO selectOne(IndustryDO obj);

    /**
     * 通过条件查询单条记录
     *企业注册地址  营业执照号 法人姓名 法人证件类型 法人证件号 国籍
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id,name,simple_name,code,account,account_name,bank_name,bank_code,cust_number,cust_account_no," +
                    "cust_account_name,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,fund_account," +
                    "whether_external,audit_status,collection_industry_id,business_type,dn,max_brokerage_rate,balance_pay_period,is_opne_double_acc," +
                    "is_opne_balance_pay,authentication_mode,need_public_auth_amt,able_bind_multi_card,auth_payment_account_id," +
                    "reg_address,bus_lic_code,legal_person,id_type,id_code,nationality,ent_name,phone,customer_trade,"+
                    "open_sub_single_pay,verify_payee_account_sign,verify_payee_white_list_sign,payer_sub_type from t_industry"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> id = #{id} AND </if>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='name != null'> name = #{name} AND </if> "
                    + "<if test='simpleName != null'> simple_name = #{simpleName} AND </if> "
                    + "<if test='code != null'> code = #{code} AND </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    + "<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='innerNoticeUrl != null'> inner_notice_url = #{innerNoticeUrl} AND </if> "
                    + "<if test='feeExpenditureAccount != null'> fee_expenditure_account = #{feeExpenditureAccount} AND </if> "
                    + "<if test='processingFeeIncomeAccount != null'> processing_fee_income_account = #{processingFeeIncomeAccount} AND </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    + "<if test='orgName != null'> org_name = #{orgName} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    + "<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
                    + "<if test='whetherExternal != null'> whether_external = #{whetherExternal} AND </if> "
                    + "<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
                    + "<if test='collectionIndustryId != null'> collection_industry_id = #{collectionIndustryId} AND </if> "

                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    IndustryDO selectOneExcludeImage(IndustryDO obj);

    @Select(
            "<script>"
                    + "select fund_account from t_industry"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='code != null'> code = #{code} AND </if>"
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    IndustryDO selectFundAccount(IndustryDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id,user_create,gmt_create,user_modified,gmt_modified,name,simple_name,code,province_code,city_code,county_code,account,account_name,bank_name,status,cust_number,cust_account_no,cust_account_name,inner_notice_url,fee_expenditure_account,fee_expenditure_account,processing_fee_income_account,org_code,org_name,industry_type,whether_external,fund_account,audit_status,collection_industry_id from t_industry"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='name != null'> name = #{name} AND </if> "
                    + "<if test='simpleName != null'> simple_name = #{simpleName} AND </if> "
                    + "<if test='code != null'> code = #{code} AND </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "<if test='accountName != null'> account_name = #{accountName} AND </if> "
                    + "<if test='bankName != null'> bank_name = #{bankName} AND </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode} AND </if> "
                    + "<if test='innerNoticeUrl != null'> inner_notice_url = #{innerNoticeUrl} AND </if> "
                    + "<if test='feeExpenditureAccount != null'> fee_expenditure_account = #{feeExpenditureAccount} AND </if> "
                    + "<if test='processingFeeIncomeAccount != null'> processing_fee_income_account = #{processingFeeIncomeAccount} AND </if> "
                    + "<if test='orgCode != null'> org_code != #{orgCode} AND </if> "
                    + "<if test='orgName != null'> org_name != #{orgName} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='industryType != null'> industry_type = #{industryType} AND </if> "
                    + "<if test='fundAccount != null'> fund_account = #{fundAccount} AND </if> "
                    + "<if test='whetherExternal != null'> whether_external = #{whetherExternal} AND </if> "
                    + "<if test='auditStatus != null'> audit_status = #{auditStatus} AND </if> "
                    + "<if test='collectionIndustryId != null'> collection_industry_id = #{collectionIndustryId} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("IndustryResultMap")
    List<IndustryDO> selectList(IndustryDO obj);

    @Select("<script>SELECT ti.id,ti.industry_type,ti.CODE code,ti.NAME name,tci.cert_id cert_id FROM t_industry ti LEFT JOIN (\n" +
            "SELECT tc.industry_code,tc.cert_id FROM t_certificate_industry_info tc,t_certificate_info ci WHERE tc.cert_id=ci.id AND ci.id=#{params.certificateId} AND ci.`status`='1' " +
            "AND ci.certificate_type=#{params.certificateType}) tci ON ti.`code`=tci.industry_code where ti.STATUS='1'" +
            "<if test='params.name != null'> AND  ti.name = #{params.name} </if>" +
            "<if test='params.industryType != null'> AND  ti.industry_type = #{params.industryType} </if>" +
            "<if test='params.code != null'> AND  ti.code = #{params.code} </if> </script>")
    @ResultMap("IndustryResultMap")
    Page<IndustryDO> selectListWithCert(@Param("params") Map<String, Object> params);


    @Select("SELECT\n" +
            "count( account_no ) \n" +
            "FROM\n" +
            "t_industry_account_info \n" +
            "WHERE\n" +
            "industry_code = #{industryCode} \n" +
            "AND account_no IN ( SELECT account_no FROM t_industry ti, t_industry_account_info ta WHERE ti.CODE = ta.industry_code AND ti.cust_number = #{custNumber} )")
    Integer checkByCustNumber(@Param("industryCode") String industryCode, @Param("custNumber") String custNumber);



    /**
     * 对象是否存在和费用账户关联
     *
     * @param
     * @return
     */
    @Select("select count(*) from t_industry where( fee_expenditure_account = #{feeExpenditureAccount} OR processing_fee_income_account = #{feeExpenditureAccount}) and status=#{status}")
    int feeAccountCount(@Param("feeExpenditureAccount") Long feeExpenditureAccount, @Param("status") Integer status);
}

