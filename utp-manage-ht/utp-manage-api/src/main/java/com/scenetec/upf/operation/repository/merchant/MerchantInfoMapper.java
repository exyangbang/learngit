package com.scenetec.upf.operation.repository.merchant;

import com.scenetec.upf.operation.model.domain.industry.IndustryDO;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;

import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/08/01
 */
@Repository
@Mapper
public interface MerchantInfoMapper {

    /**
     * 创建
     *
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_info (id,user_create,gmt_create,user_modified,gmt_modified,mer_no,mer_name,name_abbreviation,administrative_code,org_code,org_name,industry_code,industry_name,province_code,city_code,county_code,reg_address,business_address,legal_name,status,website_name,pay_merchant_no,template_id) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{merNo},#{merName},#{nameAbbreviation},#{administrativeCode},#{orgCode},#{orgName},#{industryCode},#{industryName},#{provinceCode},#{cityCode},#{countyCode},#{regAddress},#{businessAddress},#{legalName},#{status},#{websiteName},#{payMerchantNo},#{templateId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(MerchantInfoDO obj);

    /**
     * 创建
     *
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_account_info (id,user_create,gmt_create,user_modified,gmt_modified,mer_no,account_type,account_no,account_name,bank_code,bank_name) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{merNo},#{accountType},#{accountNo},#{accountName},#{bankCode},#{bankName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long createAccount(MerchantInfoDO obj);

    /**
     * 批量插入
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_merchant_info ("
                    + " user_create, gmt_create, user_modified, gmt_modified, mer_no, mer_name, name_abbreviation, administrative_code, org_code, org_name, industry_code, industry_name, province_code, city_code, county_code, reg_address, business_address, legal_name, status, website_name, pay_merchant_no, template_id"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.merName}, #{item.nameAbbreviation}, #{item.administrativeCode}, #{item.orgCode}, #{item.orgName}, #{item.industryCode}, #{item.industryName}, #{item.provinceCode}, #{item.cityCode}, #{item.countyCode}, #{item.regAddress}, #{item.businessAddress}, #{item.legalName}, #{item.status}, #{item.websiteName}, #{item.payMerchantNo}, #{item.templateId})"
                    + "</foreach>"
                    + "</script>"
    )
    int insertList(List<MerchantInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     *
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    + "insert into t_merchant_info ("
                    + " user_create, gmt_create, user_modified, gmt_modified, mer_no, mer_name, name_abbreviation, administrative_code, org_code, org_name, industry_code, industry_name,province_code, city_code, county_code, reg_address, business_address, legal_name, status, website_name, pay_merchant_no, template_id"
                    + ") values "
                    + "<foreach collection='list' item='item' index='index' separator=','>"
                    + "( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.merName}, #{item.nameAbbreviation}, #{item.administrativeCode}, #{item.orgCode}, #{item.orgName}, #{item.industryCode}, #{item.industryName},#{item.provinceCode}, #{item.cityCode}, #{item.countyCode}, #{item.regAddress}, #{item.businessAddress}, #{item.legalName}, #{item.status}, #{item.websiteName}, #{item.payMerchantNo}, #{item.templateId})"
                    + "</foreach>"
                    + " ON DUPLICATE KEY UPDATE "
                    + "user_create = VALUES(user_create),"
                    + "gmt_create = VALUES(gmt_create),"
                    + "user_modified = VALUES(user_modified),"
                    + "gmt_modified = VALUES(gmt_modified),"
                    + "mer_no = VALUES(mer_no),"
                    + "mer_name = VALUES(mer_name),"
                    + "name_abbreviation = VALUES(name_abbreviation),"
                    + "administrative_code = VALUES(administrative_code),"
                    + "org_code = VALUES(org_code),"
                    + "org_name = VALUES(org_name),"
                    + "province_code = VALUES(province_code),"
                    + "city_code = VALUES(city_code),"
                    + "county_code = VALUES(county_code),"
                    + "reg_address = VALUES(reg_address),"
                    + "business_address = VALUES(business_address),"
                    + "legal_name = VALUES(legal_name),"
                    + "status = VALUES(status),"
                    + "website_name = VALUES(website_name),"
                    + "pay_merchant_no = VALUES(pay_merchant_no),"
                    + "template_id = VALUES(template_id)"
                    + "</script>"
    )
    int modifyList(List<MerchantInfoDO> obj);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @Delete("delete from t_merchant_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     *
     * @param obj
     * @return
     */
    @Update(
            "<script>"
                    + "update t_merchant_info <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo}, </if> "
                    + "<if test='merName != null'> mer_name = #{merName}, </if> "
                    + "<if test='nameAbbreviation != null'> name_abbreviation = #{nameAbbreviation}, </if> "
                    + "<if test='administrativeCode != null'> administrative_code = #{administrativeCode}, </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode}, </if> "
                    + "<if test='orgName != null'> org_name = #{orgName}, </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
                    + "<if test='industryName != null'> industry_name = #{industryName}, </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode}, </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode}, </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode}, </if> "
                    + "<if test='regAddress != null'> reg_address = #{regAddress}, </if> "
                    + "<if test='businessAddress != null'> business_address = #{businessAddress}, </if> "
                    + "<if test='legalName != null'> legal_name = #{legalName}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "<if test='websiteName != null'> website_name = #{websiteName}, </if> "
                    + "<if test='payMerchantNo != null'> pay_merchant_no = #{payMerchantNo}, </if> "
                    + "<if test='templateId != null'> template_id = #{templateId}, </if> "
                    + "<if test='busLicPic != null'> bus_lic_pic = #{busLicPic}, </if> "
                    + "<if test='licensePic != null'> license_pic = #{licensePic}, </if> "
                    + "<if test='personPic != null'> person_pic = #{personPic}, </if> "
                    + "<if test='personReversePic != null'> person_reverse_pic = #{personReversePic}, </if> "
                    + "<if test='authStatus != null'> auth_status = #{authStatus}, </if> "
                    + "</set> where id = #{id}"
                    + "</script>"
    )
    int update(MerchantInfoDO obj);

    @Update(
            "<script>"
                    + "update t_merchant_info <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo}, </if> "
                    + "<if test='merName != null'> mer_name = #{merName}, </if> "
                    + "<if test='nameAbbreviation != null'> name_abbreviation = #{nameAbbreviation}, </if> "
                    + "<if test='administrativeCode != null'> administrative_code = #{administrativeCode}, </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode}, </if> "
                    + "<if test='orgName != null'> org_name = #{orgName}, </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode}, </if> "
                    + "<if test='industryName != null'> industry_name = #{industryName}, </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode}, </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode}, </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode}, </if> "
                    + "<if test='regAddress != null'> reg_address = #{regAddress}, </if> "
                    + "<if test='businessAddress != null'> business_address = #{businessAddress}, </if> "
                    + "<if test='legalName != null'> legal_name = #{legalName}, </if> "
                    + "<if test='status != null'> status = #{status}, </if> "
                    + "<if test='websiteName != null'> website_name = #{websiteName}, </if> "
                    + "<if test='payMerchantNo != null'> pay_merchant_no = #{payMerchantNo}, </if> "
                    + "<if test='templateId != null'> template_id = #{templateId}, </if> "
                    + "<if test='busLicPic != null'> bus_lic_pic = #{busLicPic}, </if> "
                    + "<if test='licensePic != null'> license_pic = #{licensePic}, </if> "
                    + "<if test='personPic != null'> person_pic = #{personPic}, </if> "
                    + "<if test='personReversePic != null'> person_reverse_pic = #{personReversePic}, </if> "
                    + "<if test='authStatus != null'> auth_status = #{authStatus}, </if> "
                    + "<if test='idIndate != null'> id_indate = #{idIndate}, </if> "
                    + "<if test='country != null'> country = #{country}, </if> "
                    + "<if test='prosession != null'> prosession = #{prosession}, </if> "
                    + "<if test='idCode != null'> id_code = #{idCode}, </if> "
                    + "<if test='idType != null'> id_type = #{idType}, </if> "
                    + "<if test='sex != null'> sex = #{sex}, </if> "
                    + "<if test='entName != null'> ent_name = #{entName}, </if> "
                    + "</set> where account = #{account}"
                    + "</script>"
    )
    int updateForAccount(MerchantInfoDO obj);

    @Update(
            "<script>"
                    + "update t_merchant_account_info <set> "
                    + "<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    + "<if test='accountType != null'> account_type = #{accountType}, </if> "
                    + "<if test='accountNo != null'> account_no = #{accountNo}, </if> "
                    + "<if test='accountName != null'> account_name = #{accountName}, </if> "
                    + "<if test='bankCode != null'> bank_code = #{bankCode}, </if> "
                    + "<if test='bankName != null'> bank_name = #{bankName}, </if> "
                    + "</set> where mer_no = #{merNo}"
                    + "</script>"
    )
    int updateAccount(MerchantInfoDO obj);

    /**
     * 查询详细
     *
     * @param id
     * @return
     */
    @Select("SELECT tm.telephone, tm.id,tm.legal_name ,tm.bus_lic_pic,tm.person_pic,tm.person_reverse_pic,tm.account,tm.ent_name,tm.bus_lic_code,tm.real_name,tm.id_type,tm.id_code,tm.auth_status,tm.user_create,tm.gmt_create,tm.user_modified,tm.gmt_modified,tm.mer_no,tm.mer_name,tm.name_abbreviation,tm.administrative_code,tm.org_code,tm.org_name,tm.industry_code,tm.industry_name,tm.reg_address,tm.license_pic,tm.country,tm.prosession FROM t_merchant_info tm WHERE tm.id= #{id}")
    @Results(id = "MerchantInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "busLicPic", column = "bus_lic_pic"), @Result(property = "personPic", column = "person_pic"), @Result(property = "personReversePic", column = "person_reverse_pic"), @Result(property = "authStatus", column = "auth_status"), @Result(property = "idType", column = "id_type"), @Result(property = "idCode", column = "id_code"), @Result(property = "account", column = "account"),
            @Result(property = "busLicCode", column = "bus_lic_code"), @Result(property = "realName", column = "real_name"), @Result(property = "entName", column = "ent_name"), @Result(property = "userCreate", column = "user_create"), @Result(property = "gmtCreate", column = "gmt_create"), @Result(property = "userModified", column = "user_modified"), @Result(property = "gmtModified", column = "gmt_modified"), @Result(property = "merNo", column = "mer_no"), @Result(property = "merName", column = "mer_name"),
            @Result(property = "nameAbbreviation", column = "name_abbreviation"), @Result(property = "administrativeCode", column = "administrative_code"), @Result(property = "orgCode", column = "org_code"), @Result(property = "orgName", column = "org_name"), @Result(property = "industryCode", column = "industry_code"), @Result(property = "industryName", column = "industry_name"), @Result(property = "accountType", column = "account_type"), @Result(property = "accountNo", column = "account_no"), @Result(property = "accountName", column = "account_name"),
            @Result(property = "bankCode", column = "bank_code"), @Result(property = "status", column = "status"), @Result(property = "legalName", column = "legal_name"), @Result(property = "userType", column = "user_type")
            , @Result(property = "bankName", column = "bank_name"), @Result(property = "entName", column = "ent_name"), @Result(property = "authStatus", column = "auth_status"), @Result(property = "authCallBack", column = "auth_call_back"), @Result(property = "authRemark", column = "auth_remark"), @Result(property = "sex", column = "sex"), @Result(property = "country", column = "country"), @Result(property = "prosession", column = "prosession"), @Result(property = "idIndate", column = "id_indate"), @Result(property = "licensePic", column = "license_pic"), @Result(property = "regAddress", column = "reg_address"), @Result(property = "businessAddress", column = "business_address")
            ,@Result(property = "settleAccount", column = "settle_account")
            ,@Result(property = "telephone", column = "telephone")})
    MerchantInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)like concat('%',#{params.feeAccountName},'%')
     *
     * @param params auth_status
     * @return
     */
    @Select(
            "<script>"
                    + "SELECT tm.id,tm.status,tm.account,tm.ent_name,tm.bus_lic_code,tm.real_name,tm.id_type,tm.id_code,tm.auth_status,tm.user_create,tm.gmt_create,tm.user_modified,tm.gmt_modified,tm.mer_no,tm.mer_name,tm.name_abbreviation,tm.administrative_code,tm.org_code,tm.org_name,tm.industry_code,tm.industry_name,tm.legal_name,tm.auth_remark FROM t_merchant_info tm WHERE 1 = 1 "
                    + "<if test='params.transBeginDate != null'> and tm.gmt_modified &gt;= #{params.transBeginDate} </if>"
                    + "<if test='params.transEndDate != null'>and tm.gmt_modified &lt;= #{params.transEndDate}</if>"
                    + "<if test='params.merNo != null'> and tm.mer_no like concat('%',#{params.merNo},'%')</if>"
                    + "<if test='params.merName != null'> and tm.mer_name like concat('%',#{params.merName},'%')</if>"
                    + "<if test='params.entName != null'> and tm.ent_name like concat('%',#{params.entName},'%')</if>"
                    + "<if test='params.status != null'> and tm.status != #{params.status}</if>"
                    + "<if test='params.authStatus != null'> and tm.auth_status = #{params.authStatus}</if>"
                    + "<if test='params.orgCode != null'> and tm.org_code = #{params.orgCode}</if>"
                    + "<if test='params.industryCode != null'> and tm.industry_code = #{params.industryCode}</if>"
                    + "<if test='params.account != null'> and tm.account = #{params.account}</if>"
                    + "<if test='params.userType != null'> and tm.user_type = #{params.userType}</if>"
                    + "<if test='params.industryName != null'>  and tm.industry_name like concat('%',#{params.industryName},'%')</if>"
                    + "<if test='params.realName != null'>  and tm.real_name like concat('%',#{params.realName},'%')</if>"
                    + "<if test='params.nature != null'> and tm.nature = #{params.nature}</if>"
                    + "</script>"
    )
    @ResultMap("MerchantInfoResultMap")
    Page<MerchantInfoDO> list(@Param("params") Map<String, Object> params);

    @Select(
            "<script>"
                    + "select id, account,ent_name,bus_lic_code,real_name,id_type,id_code,auth_status,user_create,gmt_create,user_modified,gmt_modified,mer_no,mer_name,name_abbreviation,administrative_code,org_code,org_name,province_code,city_code,county_code,reg_address,business_address,legal_name,status,website_name,pay_merchant_no,template_id  from t_merchant_info where 1=1"
                    + "<if test='params.status != null'>and status != #{params.status} </if>"
                    + "<if test='params.industryCode != null'>and industry_code = #{params.industryCode} </if> "
                    + " and account not in (select  sub_account from t_subaccounts_amt_limit) order by gmt_modified desc ,gmt_create desc"
                    + "</script>"
    )
    @ResultMap("MerchantInfoResultMap")
    Page<MerchantInfoDO> listExclusionOfSelection(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select count(*) from t_merchant_info <where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='merName != null'> mer_name = #{merName} AND </if> "
                    + "<if test='nameAbbreviation != null'> name_abbreviation = #{nameAbbreviation} AND </if> "
                    + "<if test='administrativeCode != null'> administrative_code = #{administrativeCode} AND </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "<if test='orgName != null'> org_name = #{orgName} AND </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode} AND </if> "
                    + "<if test='regAddress != null'> reg_address = #{regAddress} AND </if> "
                    + "<if test='businessAddress != null'> business_address = #{businessAddress} AND </if> "
                    + "<if test='legalName != null'> legal_name = #{legalName} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='websiteName != null'> website_name = #{websiteName} AND </if> "
                    + "<if test='payMerchantNo != null'> pay_merchant_no = #{payMerchantNo} AND </if> "
                    + "<if test='templateId != null'> template_id = #{templateId} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    int count(MerchantInfoDO obj);

    /**
     * 通过条件查询单条记录
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, account,ent_name,bus_lic_code,real_name,id_type,id_code,auth_status,user_create,gmt_create,user_modified,gmt_modified,mer_no,mer_name,name_abbreviation,administrative_code,org_code,org_name,province_code,city_code,county_code,reg_address,business_address,legal_name,status,website_name,pay_merchant_no,template_id,settle_account,telephone,country,prosession from t_merchant_info"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> id = #{id} AND </if>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='merName != null'> mer_name = #{merName} AND </if> "
                    + "<if test='nameAbbreviation != null'> name_abbreviation = #{nameAbbreviation} AND </if> "
                    + "<if test='administrativeCode != null'> administrative_code = #{administrativeCode} AND </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    + "<if test='orgName != null'> org_name = #{orgName} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode} AND </if> "
                    + "<if test='regAddress != null'> reg_address = #{regAddress} AND </if> "
                    + "<if test='businessAddress != null'> business_address = #{businessAddress} AND </if> "
                    + "<if test='legalName != null'> legal_name = #{legalName} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='websiteName != null'> website_name = #{websiteName} AND </if> "
                    + "<if test='payMerchantNo != null'> pay_merchant_no = #{payMerchantNo} AND </if> "
                    + "<if test='templateId != null'> template_id = #{templateId} AND </if> "
                    + "<if test='account != null'> account = #{account} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("MerchantInfoResultMap")
    MerchantInfoDO selectOne(MerchantInfoDO obj);



    @Select(
            "<script>"
                    + "select fo.settle_account,ac.id from t_merchant_info fo inner join t_account ac on ac.account=fo.settle_account"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='account != null'> fo.account = #{account} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("MerchantInfoResultMap")
    MerchantInfoDO selectOnebyAccount(MerchantInfoDO obj);


    @Select(
            "<script>"
                    + "select id, account,ent_name,bus_lic_code,real_name,id_type,id_code,auth_status,user_create,gmt_create,user_modified,gmt_modified,mer_no,mer_name,name_abbreviation,administrative_code,org_code,org_name,province_code,city_code,county_code,reg_address,business_address,legal_name,status,website_name,pay_merchant_no,template_id" +
                    ",id_indate,sex,country,prosession,telephone,user_type  from t_merchant_info  merInfo "
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='id != null and id>0'> merInfo.id = #{id} AND </if>"
                    + "<if test='userCreate != null'> merInfo.user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> merInfo.gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> merInfo.user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> merInfo.gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='merNo != null'> merInfo.mer_no = #{merNo} AND </if> "
                    + "<if test='merName != null'> merInfo.mer_name = #{merName} AND </if> "
                    + "<if test='nameAbbreviation != null'> merInfo.name_abbreviation = #{nameAbbreviation} AND </if> "
                    + "<if test='administrativeCode != null'> merInfo.administrative_code = #{administrativeCode} AND </if> "
                    + "<if test='orgCode != null'> merInfo.org_code = #{orgCode} AND </if> "
                    + "<if test='orgName != null'> merInfo.org_name = #{orgName} AND </if> "
                    + "<if test='industryCode != null'> merInfo.industry_code = #{industryCode} AND </if> "
                    + "<if test='provinceCode != null'> merInfo.province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> merInfo.city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> merInfo.county_code = #{countyCode} AND </if> "
                    + "<if test='regAddress != null'> merInfo.reg_address = #{regAddress} AND </if> "
                    + "<if test='businessAddress != null'> merInfo.business_address = #{businessAddress} AND </if> "
                    + "<if test='legalName != null'> merInfo.legal_name = #{legalName} AND </if> "
                    + "<if test='status != null'> merInfo.status = #{status} AND </if> "
                    + "<if test='websiteName != null'> merInfo.website_name = #{websiteName} AND </if> "
                    + "<if test='payMerchantNo != null'> merInfo.pay_merchant_no = #{payMerchantNo} AND </if> "
                    + "<if test='templateId != null'> merInfo.template_id = #{templateId} AND </if> "
                    + "<if test='account != null'> merInfo.account = #{account} AND </if> "
                    + "<if test='settleAccount != null'> merInfo.settle_account = #{settleAccount} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("MerchantInfoResultMap")
    MerchantInfoDO selectOneTomerchantAccountInfo(MerchantInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     *
     * @param obj
     * @return
     */
    @Select(
            "<script>"
                    + "select id, account,ent_name,bus_lic_code,real_name,id_type,id_code,auth_status,user_create,gmt_create,user_modified,gmt_modified,mer_no,mer_name,name_abbreviation,administrative_code,org_code,org_name,province_code,city_code,county_code,reg_address,business_address,legal_name,status,website_name,pay_merchant_no,template_id from t_merchant_info"
                    + "<where> <trim suffixOverrides='AND'>"
                    + "<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
                    + "<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
                    + "<if test='userModified != null'> user_modified = #{userModified} AND </if> "
                    + "<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
                    + "<if test='merNo != null'> mer_no = #{merNo} AND </if> "
                    + "<if test='merName != null'> mer_name = #{merName} AND </if> "
                    + "<if test='nameAbbreviation != null'> name_abbreviation = #{nameAbbreviation} AND </if> "
                    + "<if test='administrativeCode != null'> administrative_code = #{administrativeCode} AND </if> "
                    + "<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
                    + "<if test='orgName != null'> org_name = #{orgName} AND </if> "
                    + "<if test='industryCode != null'> industry_code = #{industryCode} AND </if> "
                    + "<if test='provinceCode != null'> province_code = #{provinceCode} AND </if> "
                    + "<if test='cityCode != null'> city_code = #{cityCode} AND </if> "
                    + "<if test='countyCode != null'> county_code = #{countyCode} AND </if> "
                    + "<if test='regAddress != null'> reg_address = #{regAddress} AND </if> "
                    + "<if test='businessAddress != null'> business_address = #{businessAddress} AND </if> "
                    + "<if test='legalName != null'> legal_name = #{legalName} AND </if> "
                    + "<if test='status != null'> status = #{status} AND </if> "
                    + "<if test='websiteName != null'> website_name = #{websiteName} AND </if> "
                    + "<if test='payMerchantNo != null'> pay_merchant_no = #{payMerchantNo} AND </if> "
                    + "<if test='templateId != null'> template_id = #{templateId} AND </if> "
                    + "</trim></where> "
                    + "</script>"
    )
    @ResultMap("MerchantInfoResultMap")
    List<MerchantInfoDO> selectList(MerchantInfoDO obj);

    @Select("select id,${pciType} from t_merchant_info where account = #{account}")
    @ResultMap("MerchantInfoResultMap")
    MerchantInfoDO getByIdForImage(@Param("account") String account,@Param("pciType") String pciType);

}

