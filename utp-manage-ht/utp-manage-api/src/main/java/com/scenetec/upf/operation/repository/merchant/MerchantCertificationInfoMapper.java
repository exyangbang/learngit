package com.scenetec.upf.operation.repository.merchant;

import com.scenetec.upf.operation.model.domain.merchant.MerchantCertificationInfoDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.github.pagehelper.Page;
import java.util.Map;
import java.util.List;

/**
 * @author scenetec
 * @date 2018/07/27
 */
@Repository
@Mapper
public interface MerchantCertificationInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_merchant_certification_info (user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_type,legal_id_type,cert_code,cert_name,cert_expiration_date_start,cert_expiration_date_end) values (#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{merNo},#{certType},#{legalIdType},#{certCode},#{certName},#{certExpirationDateStart},#{certExpirationDateEnd})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(MerchantCertificationInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_certification_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, cert_type, legal_id_type, cert_code, cert_name, cert_expiration_date_start, cert_expiration_date_end"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.certType}, #{item.legalIdType}, #{item.certCode}, #{item.certName}, #{item.certExpirationDateStart}, #{item.certExpirationDateEnd})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<MerchantCertificationInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_merchant_certification_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, mer_no, cert_type, legal_id_type, cert_code, cert_name, cert_expiration_date_start, cert_expiration_date_end"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.merNo}, #{item.certType}, #{item.legalIdType}, #{item.certCode}, #{item.certName}, #{item.certExpirationDateStart}, #{item.certExpirationDateEnd})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"mer_no = VALUES(mer_no),"
            +"cert_type = VALUES(cert_type),"
            +"legal_id_type = VALUES(legal_id_type),"
            +"cert_code = VALUES(cert_code),"
            +"cert_name = VALUES(cert_name),"
            +"cert_expiration_date_start = VALUES(cert_expiration_date_start),"
            +"cert_expiration_date_end = VALUES(cert_expiration_date_end)"
        +"</script>"
    )
    int modifyList(List<MerchantCertificationInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_merchant_certification_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_merchant_certification_info <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
            +"<if test='certType != null'> cert_type = #{certType}, </if> "
            +"<if test='legalIdType != null'> legal_id_type = #{legalIdType}, </if> "
            +"<if test='certCode != null'> cert_code = #{certCode}, </if> "
            +"<if test='certName != null'> cert_name = #{certName}, </if> "
            +"<if test='certExpirationDateStart != null'> cert_expiration_date_start = #{certExpirationDateStart}, </if> "
            +"<if test='certExpirationDateEnd != null'> cert_expiration_date_end = #{certExpirationDateEnd}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(MerchantCertificationInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_type,legal_id_type,cert_code,cert_name,cert_expiration_date_start,cert_expiration_date_end from t_merchant_certification_info where id = #{id}")
 	@Results(id="MerchantCertificationInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "merNo", column = "mer_no"),@Result(property = "certType", column = "cert_type"),@Result(property = "legalIdType", column = "legal_id_type"),@Result(property = "certCode", column = "cert_code"),@Result(property = "certName", column = "cert_name"),@Result(property = "certExpirationDateStart", column = "cert_expiration_date_start"),@Result(property = "certExpirationDateEnd", column = "cert_expiration_date_end")})
 	MerchantCertificationInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_type,legal_id_type,cert_code,cert_name,cert_expiration_date_start,cert_expiration_date_end from t_merchant_certification_info where 1 = 1"
		        + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
		        + "<if test='params.certType != null'> and cert_type = #{params.certType}</if>"
		        + "<if test='params.legalIdType != null'> and legal_id_type = #{params.legalIdType}</if>"
        + "</script>"
    )
    @ResultMap("MerchantCertificationInfoResultMap")
    Page<MerchantCertificationInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_merchant_certification_info <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='certType != null'> cert_type = #{certType} AND </if> "
            +"<if test='legalIdType != null'> legal_id_type = #{legalIdType} AND </if> "
            +"<if test='certCode != null'> cert_code = #{certCode} AND </if> "
            +"<if test='certName != null'> cert_name = #{certName} AND </if> "
            +"<if test='certExpirationDateStart != null'> cert_expiration_date_start = #{certExpirationDateStart} AND </if> "
            +"<if test='certExpirationDateEnd != null'> cert_expiration_date_end = #{certExpirationDateEnd} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(MerchantCertificationInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_type,legal_id_type,cert_code,cert_name,cert_expiration_date_start,cert_expiration_date_end from t_merchant_certification_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='certType != null'> cert_type = #{certType} AND </if> "
            +"<if test='legalIdType != null'> legal_id_type = #{legalIdType} AND </if> "
            +"<if test='certCode != null'> cert_code = #{certCode} AND </if> "
            +"<if test='certName != null'> cert_name = #{certName} AND </if> "
            +"<if test='certExpirationDateStart != null'> cert_expiration_date_start = #{certExpirationDateStart} AND </if> "
            +"<if test='certExpirationDateEnd != null'> cert_expiration_date_end = #{certExpirationDateEnd} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerchantCertificationInfoResultMap")
    MerchantCertificationInfoDO selectOne(MerchantCertificationInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,mer_no,cert_type,legal_id_type,cert_code,cert_name,cert_expiration_date_start,cert_expiration_date_end from t_merchant_certification_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
            +"<if test='certType != null'> cert_type = #{certType} AND </if> "
            +"<if test='legalIdType != null'> legal_id_type = #{legalIdType} AND </if> "
            +"<if test='certCode != null'> cert_code = #{certCode} AND </if> "
            +"<if test='certName != null'> cert_name = #{certName} AND </if> "
            +"<if test='certExpirationDateStart != null'> cert_expiration_date_start = #{certExpirationDateStart} AND </if> "
            +"<if test='certExpirationDateEnd != null'> cert_expiration_date_end = #{certExpirationDateEnd} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("MerchantCertificationInfoResultMap")
    List<MerchantCertificationInfoDO> selectList(MerchantCertificationInfoDO obj);

}

