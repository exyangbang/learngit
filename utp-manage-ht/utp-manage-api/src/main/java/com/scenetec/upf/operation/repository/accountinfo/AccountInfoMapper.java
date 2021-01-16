package com.scenetec.upf.operation.repository.accountinfo;

import com.scenetec.upf.operation.model.domain.accountinfo.AccountInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2020/05/18
 */
@Repository
@Mapper
public interface AccountInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_account_info (user_create,gmt_create,user_modified,gmt_modified,account,obj_type,business_scope,register_fund,business_indate,legal_indate,control_name,control_cerfile_type,control_cerfile_no,control_indate,charge_name,charge_cerfile_type,charge_cerfile_no,charge_indate,auth_bus_name,auth_bus_type,auth_bus_no,auth_bus_indate,customer_manager,customer_manager_phone,enterprise_type,enterprise_sale,enterprise_eco_nature,listing_type,resident_type,user_type) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{account},#{objType},#{businessScope},#{registerFund},#{businessIndate},#{legalIndate},#{controlName},#{controlCerfileType},#{controlCerfileNo},#{controlIndate},#{chargeName},#{chargeCerfileType},#{chargeCerfileNo},#{chargeIndate},#{authBusName},#{authBusType},#{authBusNo},#{authBusIndate},#{customerManager},#{customerManagerPhone},#{enterpriseType},#{enterpriseSale},#{enterpriseEcoNature},#{listingType},#{residentType},#{userType})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(AccountInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_account_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, account, obj_type, business_scope, register_fund, business_indate, legal_indate, control_name, control_cerfile_type, control_cerfile_no, control_indate, charge_name, charge_cerfile_type, charge_cerfile_no, charge_indate, auth_bus_name, auth_bus_type, auth_bus_no, auth_bus_indate, customer_manager, customer_manager_phone, enterprise_type, enterprise_sale, enterprise_eco_nature, listing_type, resident_type, user_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.businessScope}, #{item.registerFund}, #{item.businessIndate}, #{item.legalIndate}, #{item.controlName}, #{item.controlCerfileType}, #{item.controlCerfileNo}, #{item.controlIndate}, #{item.chargeName}, #{item.chargeCerfileType}, #{item.chargeCerfileNo}, #{item.chargeIndate}, #{item.authBusName}, #{item.authBusType}, #{item.authBusNo}, #{item.authBusIndate}, #{item.customerManager}, #{item.customerManagerPhone}, #{item.enterpriseType}, #{item.enterpriseSale}, #{item.enterpriseEcoNature}, #{item.listingType}, #{item.residentType}, #{item.userType})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<AccountInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_account_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, account, obj_type, business_scope, register_fund, business_indate, legal_indate, control_name, control_cerfile_type, control_cerfile_no, control_indate, charge_name, charge_cerfile_type, charge_cerfile_no, charge_indate, auth_bus_name, auth_bus_type, auth_bus_no, auth_bus_indate, customer_manager, customer_manager_phone, enterprise_type, enterprise_sale, enterprise_eco_nature, listing_type, resident_type, user_type"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.account}, #{item.objType}, #{item.businessScope}, #{item.registerFund}, #{item.businessIndate}, #{item.legalIndate}, #{item.controlName}, #{item.controlCerfileType}, #{item.controlCerfileNo}, #{item.controlIndate}, #{item.chargeName}, #{item.chargeCerfileType}, #{item.chargeCerfileNo}, #{item.chargeIndate}, #{item.authBusName}, #{item.authBusType}, #{item.authBusNo}, #{item.authBusIndate}, #{item.customerManager}, #{item.customerManagerPhone}, #{item.enterpriseType}, #{item.enterpriseSale}, #{item.enterpriseEcoNature}, #{item.listingType}, #{item.residentType}, #{item.userType})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"account = VALUES(account),"
            +"obj_type = VALUES(obj_type),"
            +"business_scope = VALUES(business_scope),"
            +"register_fund = VALUES(register_fund),"
            +"business_indate = VALUES(business_indate),"
            +"legal_indate = VALUES(legal_indate),"
            +"control_name = VALUES(control_name),"
            +"control_cerfile_type = VALUES(control_cerfile_type),"
            +"control_cerfile_no = VALUES(control_cerfile_no),"
            +"control_indate = VALUES(control_indate),"
            +"charge_name = VALUES(charge_name),"
            +"charge_cerfile_type = VALUES(charge_cerfile_type),"
            +"charge_cerfile_no = VALUES(charge_cerfile_no),"
            +"charge_indate = VALUES(charge_indate),"
            +"auth_bus_name = VALUES(auth_bus_name),"
            +"auth_bus_type = VALUES(auth_bus_type),"
            +"auth_bus_no = VALUES(auth_bus_no),"
            +"auth_bus_indate = VALUES(auth_bus_indate),"
            +"customer_manager = VALUES(customer_manager),"
            +"customer_manager_phone = VALUES(customer_manager_phone),"
            +"enterprise_type = VALUES(enterprise_type),"
            +"enterprise_sale = VALUES(enterprise_sale),"
            +"enterprise_eco_nature = VALUES(enterprise_eco_nature),"
            +"listing_type = VALUES(listing_type),"
            +"resident_type = VALUES(resident_type),"
            +"user_type = VALUES(user_type)"
        +"</script>"
    )
    int modifyList(List<AccountInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_account_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_account_info <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='account != null'> account = #{account}, </if> "
            +"<if test='objType != null'> obj_type = #{objType}, </if> "
            +"<if test='businessScope != null'> business_scope = #{businessScope}, </if> "
            +"<if test='registerFund != null'> register_fund = #{registerFund}, </if> "
            +"<if test='businessIndate != null'> business_indate = #{businessIndate}, </if> "
            +"<if test='legalIndate != null'> legal_indate = #{legalIndate}, </if> "
            +"<if test='controlName != null'> control_name = #{controlName}, </if> "
            +"<if test='controlCerfileType != null'> control_cerfile_type = #{controlCerfileType}, </if> "
            +"<if test='controlCerfileNo != null'> control_cerfile_no = #{controlCerfileNo}, </if> "
            +"<if test='controlIndate != null'> control_indate = #{controlIndate}, </if> "
            +"<if test='chargeName != null'> charge_name = #{chargeName}, </if> "
            +"<if test='chargeCerfileType != null'> charge_cerfile_type = #{chargeCerfileType}, </if> "
            +"<if test='chargeCerfileNo != null'> charge_cerfile_no = #{chargeCerfileNo}, </if> "
            +"<if test='chargeIndate != null'> charge_indate = #{chargeIndate}, </if> "
            +"<if test='authBusName != null'> auth_bus_name = #{authBusName}, </if> "
            +"<if test='authBusType != null'> auth_bus_type = #{authBusType}, </if> "
            +"<if test='authBusNo != null'> auth_bus_no = #{authBusNo}, </if> "
            +"<if test='authBusIndate != null'> auth_bus_indate = #{authBusIndate}, </if> "
            +"<if test='customerManager != null'> customer_manager = #{customerManager}, </if> "
            +"<if test='customerManagerPhone != null'> customer_manager_phone = #{customerManagerPhone}, </if> "
            +"<if test='enterpriseType != null'> enterprise_type = #{enterpriseType}, </if> "
            +"<if test='enterpriseSale != null'> enterprise_sale = #{enterpriseSale}, </if> "
            +"<if test='enterpriseEcoNature != null'> enterprise_eco_nature = #{enterpriseEcoNature}, </if> "
            +"<if test='listingType != null'> listing_type = #{listingType}, </if> "
            +"<if test='residentType != null'> resident_type = #{residentType}, </if> "
            +"<if test='userType != null'> user_type = #{userType}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(AccountInfoDO obj);

    @Update(
            "<script>"
                    +"update t_account_info <set> "
                    +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
                    +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
                    +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
                    +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
                    +"<if test='account != null'> account = #{account}, </if> "
                    +"<if test='objType != null'> obj_type = #{objType}, </if> "
                    +"<if test='businessScope != null'> business_scope = #{businessScope}, </if> "
                    +"<if test='registerFund != null'> register_fund = #{registerFund}, </if> "
                    +"<if test='businessIndate != null'> business_indate = #{businessIndate}, </if> "
                    +"<if test='legalIndate != null'> legal_indate = #{legalIndate}, </if> "
                    +"<if test='controlName != null'> control_name = #{controlName}, </if> "
                    +"<if test='controlCerfileType != null'> control_cerfile_type = #{controlCerfileType}, </if> "
                    +"<if test='controlCerfileNo != null'> control_cerfile_no = #{controlCerfileNo}, </if> "
                    +"<if test='controlIndate != null'> control_indate = #{controlIndate}, </if> "
                    +"<if test='chargeName != null'> charge_name = #{chargeName}, </if> "
                    +"<if test='chargeCerfileType != null'> charge_cerfile_type = #{chargeCerfileType}, </if> "
                    +"<if test='chargeCerfileNo != null'> charge_cerfile_no = #{chargeCerfileNo}, </if> "
                    +"<if test='chargeIndate != null'> charge_indate = #{chargeIndate}, </if> "
                    +"<if test='authBusName != null'> auth_bus_name = #{authBusName}, </if> "
                    +"<if test='authBusType != null'> auth_bus_type = #{authBusType}, </if> "
                    +"<if test='authBusNo != null'> auth_bus_no = #{authBusNo}, </if> "
                    +"<if test='authBusIndate != null'> auth_bus_indate = #{authBusIndate}, </if> "
                    +"<if test='customerManager != null'> customer_manager = #{customerManager}, </if> "
                    +"<if test='customerManagerPhone != null'> customer_manager_phone = #{customerManagerPhone}, </if> "
                    +"<if test='enterpriseType != null'> enterprise_type = #{enterpriseType}, </if> "
                    +"<if test='enterpriseSale != null'> enterprise_sale = #{enterpriseSale}, </if> "
                    +"<if test='enterpriseEcoNature != null'> enterprise_eco_nature = #{enterpriseEcoNature}, </if> "
                    +"<if test='listingType != null'> listing_type = #{listingType}, </if> "
                    +"<if test='residentType != null'> resident_type = #{residentType}, </if> "
                    +"<if test='userType != null'> user_type = #{userType}, </if> "
                    +"</set> where account = #{account}"
                    +"</script>"
    )
    int updateByAccount(AccountInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,business_scope,register_fund,business_indate,legal_indate,control_name,control_cerfile_type,control_cerfile_no,control_indate,charge_name,charge_cerfile_type,charge_cerfile_no,charge_indate,auth_bus_name,auth_bus_type,auth_bus_no,auth_bus_indate,customer_manager,customer_manager_phone,enterprise_type,enterprise_sale,enterprise_eco_nature,listing_type,resident_type,user_type from t_account_info where id = #{id}")
 	@Results(id="AccountInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "account", column = "account"),@Result(property = "objType", column = "obj_type"),@Result(property = "businessScope", column = "business_scope"),@Result(property = "registerFund", column = "register_fund"),@Result(property = "businessIndate", column = "business_indate"),@Result(property = "legalIndate", column = "legal_indate"),@Result(property = "controlName", column = "control_name"),@Result(property = "controlCerfileType", column = "control_cerfile_type"),@Result(property = "controlCerfileNo", column = "control_cerfile_no"),@Result(property = "controlIndate", column = "control_indate"),@Result(property = "chargeName", column = "charge_name"),@Result(property = "chargeCerfileType", column = "charge_cerfile_type"),@Result(property = "chargeCerfileNo", column = "charge_cerfile_no"),@Result(property = "chargeIndate", column = "charge_indate"),@Result(property = "authBusName", column = "auth_bus_name"),@Result(property = "authBusType", column = "auth_bus_type"),@Result(property = "authBusNo", column = "auth_bus_no"),@Result(property = "authBusIndate", column = "auth_bus_indate"),@Result(property = "customerManager", column = "customer_manager"),@Result(property = "customerManagerPhone", column = "customer_manager_phone"),@Result(property = "enterpriseType", column = "enterprise_type"),@Result(property = "enterpriseSale", column = "enterprise_sale"),@Result(property = "enterpriseEcoNature", column = "enterprise_eco_nature"),@Result(property = "listingType", column = "listing_type"),@Result(property = "residentType", column = "resident_type"),@Result(property = "userType", column = "user_type")})
 	AccountInfoDO getById(@Param("id") Long id);


    @Select("select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,business_scope,register_fund,business_indate,legal_indate,control_name,control_cerfile_type,control_cerfile_no,control_indate,charge_name,charge_cerfile_type,charge_cerfile_no,charge_indate,auth_bus_name,auth_bus_type,auth_bus_no,auth_bus_indate,customer_manager,customer_manager_phone,enterprise_type,enterprise_sale,enterprise_eco_nature,listing_type,resident_type,user_type from t_account_info where account = #{account}")
    @ResultMap("AccountInfoResultMap")
    AccountInfoDO getByAccount(@Param("account") String account);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,business_scope,register_fund,business_indate,legal_indate,control_name,control_cerfile_type,control_cerfile_no,control_indate,charge_name,charge_cerfile_type,charge_cerfile_no,charge_indate,auth_bus_name,auth_bus_type,auth_bus_no,auth_bus_indate,customer_manager,customer_manager_phone,enterprise_type,enterprise_sale,enterprise_eco_nature,listing_type,resident_type,user_type from t_account_info where 1 = 1"
		        + "<if test='params.account != null'> and account like concat('%',#{params.account},'%')</if>"
        + "</script>"
    )
    @ResultMap("AccountInfoResultMap")
    Page<AccountInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_account_info <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='businessScope != null'> business_scope = #{businessScope} AND </if> "
            +"<if test='registerFund != null'> register_fund = #{registerFund} AND </if> "
            +"<if test='businessIndate != null'> business_indate = #{businessIndate} AND </if> "
            +"<if test='legalIndate != null'> legal_indate = #{legalIndate} AND </if> "
            +"<if test='controlName != null'> control_name = #{controlName} AND </if> "
            +"<if test='controlCerfileType != null'> control_cerfile_type = #{controlCerfileType} AND </if> "
            +"<if test='controlCerfileNo != null'> control_cerfile_no = #{controlCerfileNo} AND </if> "
            +"<if test='controlIndate != null'> control_indate = #{controlIndate} AND </if> "
            +"<if test='chargeName != null'> charge_name = #{chargeName} AND </if> "
            +"<if test='chargeCerfileType != null'> charge_cerfile_type = #{chargeCerfileType} AND </if> "
            +"<if test='chargeCerfileNo != null'> charge_cerfile_no = #{chargeCerfileNo} AND </if> "
            +"<if test='chargeIndate != null'> charge_indate = #{chargeIndate} AND </if> "
            +"<if test='authBusName != null'> auth_bus_name = #{authBusName} AND </if> "
            +"<if test='authBusType != null'> auth_bus_type = #{authBusType} AND </if> "
            +"<if test='authBusNo != null'> auth_bus_no = #{authBusNo} AND </if> "
            +"<if test='authBusIndate != null'> auth_bus_indate = #{authBusIndate} AND </if> "
            +"<if test='customerManager != null'> customer_manager = #{customerManager} AND </if> "
            +"<if test='customerManagerPhone != null'> customer_manager_phone = #{customerManagerPhone} AND </if> "
            +"<if test='enterpriseType != null'> enterprise_type = #{enterpriseType} AND </if> "
            +"<if test='enterpriseSale != null'> enterprise_sale = #{enterpriseSale} AND </if> "
            +"<if test='enterpriseEcoNature != null'> enterprise_eco_nature = #{enterpriseEcoNature} AND </if> "
            +"<if test='listingType != null'> listing_type = #{listingType} AND </if> "
            +"<if test='residentType != null'> resident_type = #{residentType} AND </if> "
            +"<if test='userType != null'> user_type = #{userType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(AccountInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,business_scope,register_fund,business_indate,legal_indate,control_name,control_cerfile_type,control_cerfile_no,control_indate,charge_name,charge_cerfile_type,charge_cerfile_no,charge_indate,auth_bus_name,auth_bus_type,auth_bus_no,auth_bus_indate,customer_manager,customer_manager_phone,enterprise_type,enterprise_sale,enterprise_eco_nature,listing_type,resident_type,user_type from t_account_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='businessScope != null'> business_scope = #{businessScope} AND </if> "
            +"<if test='registerFund != null'> register_fund = #{registerFund} AND </if> "
            +"<if test='businessIndate != null'> business_indate = #{businessIndate} AND </if> "
            +"<if test='legalIndate != null'> legal_indate = #{legalIndate} AND </if> "
            +"<if test='controlName != null'> control_name = #{controlName} AND </if> "
            +"<if test='controlCerfileType != null'> control_cerfile_type = #{controlCerfileType} AND </if> "
            +"<if test='controlCerfileNo != null'> control_cerfile_no = #{controlCerfileNo} AND </if> "
            +"<if test='controlIndate != null'> control_indate = #{controlIndate} AND </if> "
            +"<if test='chargeName != null'> charge_name = #{chargeName} AND </if> "
            +"<if test='chargeCerfileType != null'> charge_cerfile_type = #{chargeCerfileType} AND </if> "
            +"<if test='chargeCerfileNo != null'> charge_cerfile_no = #{chargeCerfileNo} AND </if> "
            +"<if test='chargeIndate != null'> charge_indate = #{chargeIndate} AND </if> "
            +"<if test='authBusName != null'> auth_bus_name = #{authBusName} AND </if> "
            +"<if test='authBusType != null'> auth_bus_type = #{authBusType} AND </if> "
            +"<if test='authBusNo != null'> auth_bus_no = #{authBusNo} AND </if> "
            +"<if test='authBusIndate != null'> auth_bus_indate = #{authBusIndate} AND </if> "
            +"<if test='customerManager != null'> customer_manager = #{customerManager} AND </if> "
            +"<if test='customerManagerPhone != null'> customer_manager_phone = #{customerManagerPhone} AND </if> "
            +"<if test='enterpriseType != null'> enterprise_type = #{enterpriseType} AND </if> "
            +"<if test='enterpriseSale != null'> enterprise_sale = #{enterpriseSale} AND </if> "
            +"<if test='enterpriseEcoNature != null'> enterprise_eco_nature = #{enterpriseEcoNature} AND </if> "
            +"<if test='listingType != null'> listing_type = #{listingType} AND </if> "
            +"<if test='residentType != null'> resident_type = #{residentType} AND </if> "
            +"<if test='userType != null'> user_type = #{userType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("AccountInfoResultMap")
    AccountInfoDO selectOne(AccountInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,account,obj_type,business_scope,register_fund,business_indate,legal_indate,control_name,control_cerfile_type,control_cerfile_no,control_indate,charge_name,charge_cerfile_type,charge_cerfile_no,charge_indate,auth_bus_name,auth_bus_type,auth_bus_no,auth_bus_indate,customer_manager,customer_manager_phone,enterprise_type,enterprise_sale,enterprise_eco_nature,listing_type,resident_type,user_type from t_account_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='account != null'> account = #{account} AND </if> "
            +"<if test='objType != null'> obj_type = #{objType} AND </if> "
            +"<if test='businessScope != null'> business_scope = #{businessScope} AND </if> "
            +"<if test='registerFund != null'> register_fund = #{registerFund} AND </if> "
            +"<if test='businessIndate != null'> business_indate = #{businessIndate} AND </if> "
            +"<if test='legalIndate != null'> legal_indate = #{legalIndate} AND </if> "
            +"<if test='controlName != null'> control_name = #{controlName} AND </if> "
            +"<if test='controlCerfileType != null'> control_cerfile_type = #{controlCerfileType} AND </if> "
            +"<if test='controlCerfileNo != null'> control_cerfile_no = #{controlCerfileNo} AND </if> "
            +"<if test='controlIndate != null'> control_indate = #{controlIndate} AND </if> "
            +"<if test='chargeName != null'> charge_name = #{chargeName} AND </if> "
            +"<if test='chargeCerfileType != null'> charge_cerfile_type = #{chargeCerfileType} AND </if> "
            +"<if test='chargeCerfileNo != null'> charge_cerfile_no = #{chargeCerfileNo} AND </if> "
            +"<if test='chargeIndate != null'> charge_indate = #{chargeIndate} AND </if> "
            +"<if test='authBusName != null'> auth_bus_name = #{authBusName} AND </if> "
            +"<if test='authBusType != null'> auth_bus_type = #{authBusType} AND </if> "
            +"<if test='authBusNo != null'> auth_bus_no = #{authBusNo} AND </if> "
            +"<if test='authBusIndate != null'> auth_bus_indate = #{authBusIndate} AND </if> "
            +"<if test='customerManager != null'> customer_manager = #{customerManager} AND </if> "
            +"<if test='customerManagerPhone != null'> customer_manager_phone = #{customerManagerPhone} AND </if> "
            +"<if test='enterpriseType != null'> enterprise_type = #{enterpriseType} AND </if> "
            +"<if test='enterpriseSale != null'> enterprise_sale = #{enterpriseSale} AND </if> "
            +"<if test='enterpriseEcoNature != null'> enterprise_eco_nature = #{enterpriseEcoNature} AND </if> "
            +"<if test='listingType != null'> listing_type = #{listingType} AND </if> "
            +"<if test='residentType != null'> resident_type = #{residentType} AND </if> "
            +"<if test='userType != null'> user_type = #{userType} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("AccountInfoResultMap")
    List<AccountInfoDO> selectList(AccountInfoDO obj);

}

