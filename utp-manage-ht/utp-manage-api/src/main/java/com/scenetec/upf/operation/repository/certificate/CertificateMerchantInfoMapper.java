package com.scenetec.upf.operation.repository.certificate;

import com.scenetec.upf.operation.model.domain.certificate.CertificateMerchantInfoDO;
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
public interface CertificateMerchantInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_certificate_merchant_info (cert_id,mer_no) values (#{certId},#{merNo})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(CertificateMerchantInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_certificate_merchant_info ("
        +" id,cert_id, mer_no"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"(#{item.id},#{item.certId}, #{item.merNo})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<CertificateMerchantInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_certificate_merchant_info ("
        +" cert_id, mer_no"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"(#{item.certId}, #{item.merNo})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"cert_id = VALUES(cert_id),"
            +"mer_no = VALUES(mer_no)"
        +"</script>"
    )
    int modifyList(List<CertificateMerchantInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_certificate_merchant_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_certificate_merchant_info <set> "
            +"<if test='certId != null'> cert_id = #{certId}, </if> "
            +"<if test='merNo != null'> mer_no = #{merNo}, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(CertificateMerchantInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id,cert_id,mer_no from t_certificate_merchant_info where id = #{id}")
 	@Results(id="CertificateMerchantInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "certId", column = "cert_id"),@Result(property = "merNo", column = "mer_no")})
 	CertificateMerchantInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id,cert_id,mer_no from t_certificate_merchant_info where 1 = 1"
		        + "<if test='params.certId != null'> and cert_id = #{params.certId}</if>"
		        + "<if test='params.merNo != null'> and mer_no = #{params.merNo}</if>"
        + "</script>"
    )
    @ResultMap("CertificateMerchantInfoResultMap")
    Page<CertificateMerchantInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_certificate_merchant_info <where> <trim suffixOverrides='AND'>"
            +"<if test='certId != null'> cert_id = #{certId} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(CertificateMerchantInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id,cert_id,mer_no from t_certificate_merchant_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='certId != null'> cert_id = #{certId} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CertificateMerchantInfoResultMap")
    CertificateMerchantInfoDO selectOne(CertificateMerchantInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id,cert_id,mer_no from t_certificate_merchant_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='certId != null'> cert_id = #{certId} AND </if> "
            +"<if test='merNo != null'> mer_no = #{merNo} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CertificateMerchantInfoResultMap")
    List<CertificateMerchantInfoDO> selectList(CertificateMerchantInfoDO obj);

}

