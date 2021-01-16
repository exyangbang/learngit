package com.scenetec.upf.operation.repository.certificate;

import com.scenetec.upf.operation.model.domain.certificate.CertificateInfoDO;
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
public interface CertificateInfoMapper {

    /**
     * 创建
     * @param obj
     * @return
     */
    @Insert("insert into t_certificate_info (id,user_create,gmt_create,user_modified,gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_file,certificate_path,status,remark) values (#{id},#{userCreate},#{gmtCreate},#{userModified},#{gmtModified},#{certificateNo},#{certificateSeq},#{certificateName},#{channelKey},#{productCode},#{orgCode},#{orgName},#{certificateType},#{privateKey},#{privateKeyPassword},#{privateStorePassword},#{publicKey},#{effectiveDate},#{expirationDate},#{certificateFile},#{certificatePath},#{status},#{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
 	long create(CertificateInfoDO obj);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_certificate_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, certificate_no, certificate_seq, certificate_name, channel_key,product_code, org_code, org_name, certificate_type, private_key, private_key_password, private_store_password, public_key, effective_date, expiration_date, certificate_file, certificate_path, status, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.certificateNo}, #{item.certificateSeq}, #{item.certificateName}, #{channelKey},#{productCode}, #{item.orgCode}, #{item.orgName}, #{item.certificateType}, #{item.privateKey}, #{item.privateKeyPassword}, #{item.privateStorePassword}, #{item.publicKey}, #{item.effectiveDate}, #{item.expirationDate}, #{item.certificateFile}, #{item.certificatePath}, #{item.status}, #{item.remark})"
        +"</foreach>"
        +"</script>"
    )
    int insertList(List<CertificateInfoDO> obj);

    /**
     * 批量插入（modify:无则插入有则更新）
     * @param obj
     * @return
     */
    @Insert(
        "<script>"
        +"insert into t_certificate_info ("
        +" user_create, gmt_create, user_modified, gmt_modified, certificate_no, certificate_seq, certificate_name, channel_key,product_code, org_code, org_name, certificate_type, private_key, private_key_password, private_store_password, public_key, effective_date, expiration_date, certificate_file, certificate_path, status, remark"
        +") values "
        +"<foreach collection='list' item='item' index='index' separator=','>"
        +"( #{item.userCreate}, #{item.gmtCreate}, #{item.userModified}, #{item.gmtModified}, #{item.certificateNo}, #{item.certificateSeq}, #{item.certificateName}, #{channelKey},#{productCode}, #{item.orgCode}, #{item.orgName}, #{item.certificateType}, #{item.privateKey}, #{item.privateKeyPassword}, #{item.privateStorePassword}, #{item.publicKey}, #{item.effectiveDate}, #{item.expirationDate}, #{item.certificateFile}, #{item.certificatePath}, #{item.status}, #{item.remark})"
        +"</foreach>"
        +" ON DUPLICATE KEY UPDATE "
            +"user_create = VALUES(user_create),"
            +"gmt_create = VALUES(gmt_create),"
            +"user_modified = VALUES(user_modified),"
            +"gmt_modified = VALUES(gmt_modified),"
            +"certificate_no = VALUES(certificate_no),"
            +"certificate_seq = VALUES(certificate_seq),"
            +"certificate_name = VALUES(certificate_name),"
            +"channel_key = VALUES(channel_key),"
            +"product_code = VALUES(product_code),"
            +"org_code = VALUES(org_code),"
            +"org_name = VALUES(org_name),"
            +"certificate_type = VALUES(certificate_type),"
            +"private_key = VALUES(private_key),"
            +"private_key_password = VALUES(private_key_password),"
            +"private_store_password = VALUES(private_store_password),"
            +"public_key = VALUES(public_key),"
            +"effective_date = VALUES(effective_date),"
            +"expiration_date = VALUES(expiration_date),"
            +"certificate_file = VALUES(certificate_file),"
            +"certificate_path = VALUES(certificate_path),"
            +"status = VALUES(status),"
            +"remark = VALUES(remark)"
        +"</script>"
    )
    int modifyList(List<CertificateInfoDO> obj);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_certificate_info where id = #{id}")
    int delete(Long userId);

    /**
     * 更新
     * @param obj
     * @return
     */
    @Update(
        "<script>"
        +"update t_certificate_info <set> "
            +"<if test='userCreate != null'> user_create = #{userCreate}, </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate}, </if> "
            +"<if test='userModified != null'> user_modified = #{userModified}, </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified}, </if> "
            +"<if test='certificateNo != null'> certificate_no = #{certificateNo}, </if> "
            +"<if test='certificateSeq != null'> certificate_seq = #{certificateSeq}, </if> "
            +"<if test='certificateName != null'> certificate_name = #{certificateName}, </if> "
            +"<if test='channelKey != null'> channel_key = #{channelKey}, </if> "
                +"<if test='productCode != null'> product_code = #{productCode}, </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode}, </if> "
            +"<if test='orgName != null'> org_name = #{orgName}, </if> "
            +"<if test='certificateType != null'> certificate_type = #{certificateType}, </if> "
            +"<if test='privateKey != null'> private_key = #{privateKey}, </if> "
            +"<if test='privateKeyPassword != null'> private_key_password = #{privateKeyPassword}, </if> "
            +"<if test='privateStorePassword != null'> private_store_password = #{privateStorePassword}, </if> "
            +"<if test='publicKey != null'> public_key = #{publicKey}, </if> "
            +"<if test='effectiveDate != null'> effective_date = #{effectiveDate}, </if> "
            +"<if test='expirationDate != null'> expiration_date = #{expirationDate}, </if> "
            +"<if test='certificateFile != null'> certificate_file = #{certificateFile}, </if> "
            +"<if test='certificatePath != null'> certificate_path = #{certificatePath}, </if> "
            +"<if test='status != null'> status = #{status}, </if> "
            +"<if test='remark != null'> remark = #{remark}, </if> "
                +"<if test='remark == null'> remark = null, </if> "
        +"</set> where id = #{id}"
        +"</script>"
           )
    int update(CertificateInfoDO obj);

    /**
     * 查询详细
     * @param id
     * @return
     */
 	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_file,certificate_path,status,remark from t_certificate_info where id = #{id}")
 	@Results(id="CertificateInfoResultMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "certificateNo", column = "certificate_no"),@Result(property = "certificateSeq", column = "certificate_seq"),@Result(property = "certificateName", column = "certificate_name"),@Result(property = "channelKey", column = "channel_key"),@Result(property = "productCode", column = "product_code"),@Result(property = "orgCode", column = "org_code"),@Result(property = "orgName", column = "org_name"),@Result(property = "certificateType", column = "certificate_type"),@Result(property = "privateKey", column = "private_key"),@Result(property = "privateKeyPassword", column = "private_key_password"),@Result(property = "privateStorePassword", column = "private_store_password"),@Result(property = "publicKey", column = "public_key"),@Result(property = "effectiveDate", column = "effective_date"),@Result(property = "expirationDate", column = "expiration_date"),@Result(property = "certificateFile", column = "certificate_file"),@Result(property = "certificatePath", column = "certificate_path"),@Result(property = "status", column = "status"),@Result(property = "remark", column = "remark")})
 	CertificateInfoDO getById(@Param("id") Long id);

    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select id, user_create,gmt_create,user_modified,gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_file,certificate_path,status,remark from t_certificate_info where 1 = 1"
		        + "<if test='params.certificateSeq != null'> and certificate_seq = #{params.certificateSeq}</if>"
		        + "<if test='params.orgCode != null'> and org_code = #{params.orgCode}</if>"
		        + "<if test='params.orgName != null'> and org_name like concat('%',#{params.orgName},'%')</if>"
		        + "<if test='params.certificateName != null'> and certificate_name like concat('%',#{params.certificateName},'%')</if>"
		        + "<if test='params.certificateType != null'> and certificate_type = #{params.certificateType}</if>"
		        + "<if test='params.status != null'> and status = #{params.status}</if>"
        + "</script>"
    )
    @ResultMap("CertificateInfoResultMap")
    Page<CertificateInfoDO> list(@Param("params") Map<String, Object> params);

    /**
     * 查询总数
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select count(*) from t_certificate_info <where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='certificateNo != null'> certificate_no = #{certificateNo} AND </if> "
            +"<if test='certificateSeq != null'> certificate_seq = #{certificateSeq} AND </if> "
            +"<if test='certificateName != null'> certificate_name = #{certificateName} AND </if> "
                +"<if test='channelKey != null'> channel_key = #{channelKey} AND </if> "
                +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='orgName != null'> org_name = #{orgName} AND </if> "
            +"<if test='certificateType != null'> certificate_type = #{certificateType} AND </if> "
            +"<if test='privateKey != null'> private_key = #{privateKey} AND </if> "
            +"<if test='privateKeyPassword != null'> private_key_password = #{privateKeyPassword} AND </if> "
            +"<if test='privateStorePassword != null'> private_store_password = #{privateStorePassword} AND </if> "
            +"<if test='publicKey != null'> public_key = #{publicKey} AND </if> "
            +"<if test='effectiveDate != null'> effective_date = #{effectiveDate} AND </if> "
            +"<if test='expirationDate != null'> expiration_date = #{expirationDate} AND </if> "
            +"<if test='certificateFile != null'> certificate_file = #{certificateFile} AND </if> "
            +"<if test='certificatePath != null'> certificate_path = #{certificatePath} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    int count(CertificateInfoDO obj);

    /**
     * 通过条件查询单条记录
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_file,certificate_path,status,remark from t_certificate_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='id != null and id>0'> id = #{id} AND </if>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='certificateNo != null'> certificate_no = #{certificateNo} AND </if> "
            +"<if test='certificateSeq != null'> certificate_seq = #{certificateSeq} AND </if> "
            +"<if test='certificateName != null'> certificate_name = #{certificateName} AND </if> "
                +"<if test='channelKey != null'> channel_key = #{channelKey} AND </if> "
                +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='orgName != null'> org_name = #{orgName} AND </if> "
            +"<if test='certificateType != null'> certificate_type = #{certificateType} AND </if> "
            +"<if test='privateKey != null'> private_key = #{privateKey} AND </if> "
            +"<if test='privateKeyPassword != null'> private_key_password = #{privateKeyPassword} AND </if> "
            +"<if test='privateStorePassword != null'> private_store_password = #{privateStorePassword} AND </if> "
            +"<if test='publicKey != null'> public_key = #{publicKey} AND </if> "
            +"<if test='effectiveDate != null'> effective_date = #{effectiveDate} AND </if> "
            +"<if test='expirationDate != null'> expiration_date = #{expirationDate} AND </if> "
            +"<if test='certificateFile != null'> certificate_file = #{certificateFile} AND </if> "
            +"<if test='certificatePath != null'> certificate_path = #{certificatePath} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CertificateInfoResultMap")
    CertificateInfoDO selectOne(CertificateInfoDO obj);

    /**
     * 通过条件查询多条记录(不分页)
     * @param obj
     * @return
     */
    @Select(
        "<script>"
        +"select id, user_create,gmt_create,user_modified,gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_file,certificate_path,status,remark from t_certificate_info"
        +"<where> <trim suffixOverrides='AND'>"
            +"<if test='userCreate != null'> user_create = #{userCreate} AND </if> "
            +"<if test='gmtCreate != null'> gmt_create = #{gmtCreate} AND </if> "
            +"<if test='userModified != null'> user_modified = #{userModified} AND </if> "
            +"<if test='gmtModified != null'> gmt_modified = #{gmtModified} AND </if> "
            +"<if test='certificateNo != null'> certificate_no = #{certificateNo} AND </if> "
            +"<if test='certificateSeq != null'> certificate_seq = #{certificateSeq} AND </if> "
            +"<if test='certificateName != null'> certificate_name = #{certificateName} AND </if> "
                +"<if test='channelKey != null'> channel_key = #{channelKey} AND </if> "
                +"<if test='productCode != null'> product_code = #{productCode} AND </if> "
            +"<if test='orgCode != null'> org_code = #{orgCode} AND </if> "
            +"<if test='orgName != null'> org_name = #{orgName} AND </if> "
            +"<if test='certificateType != null'> certificate_type = #{certificateType} AND </if> "
            +"<if test='privateKey != null'> private_key = #{privateKey} AND </if> "
            +"<if test='privateKeyPassword != null'> private_key_password = #{privateKeyPassword} AND </if> "
            +"<if test='privateStorePassword != null'> private_store_password = #{privateStorePassword} AND </if> "
            +"<if test='publicKey != null'> public_key = #{publicKey} AND </if> "
            +"<if test='effectiveDate != null'> effective_date = #{effectiveDate} AND </if> "
            +"<if test='expirationDate != null'> expiration_date = #{expirationDate} AND </if> "
            +"<if test='certificateFile != null'> certificate_file = #{certificateFile} AND </if> "
            +"<if test='certificatePath != null'> certificate_path = #{certificatePath} AND </if> "
            +"<if test='status != null'> status = #{status} AND </if> "
            +"<if test='remark != null'> remark = #{remark} AND </if> "
        +"</trim></where> "
        +"</script>"
    )
    @ResultMap("CertificateInfoResultMap")
    List<CertificateInfoDO> selectList(CertificateInfoDO obj);

}

