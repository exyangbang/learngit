package com.scenetec.upf.operation.repository.certificate;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.certificate.CertificateInfoDO;
import com.scenetec.upf.operation.model.vo.certificate.CertificateInfoVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Map;

/**
 * @Author: shendunyuan@scenetec.com
 * @date: 2018/7/23
 */
@Repository
@Mapper
public interface CertificateInfoExtMapper {

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_path,status,remark from t_certificate_info where id = #{id}")
	@Results(id="CertificateVoResMap", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "certificateNo", column = "certificate_no"),@Result(property = "certificateSeq", column = "certificate_seq"),@Result(property = "certificateName", column = "certificate_name"),@Result(property = "channelKey", column = "channel_key"),@Result(property = "productCode", column = "product_code"),@Result(property = "orgCode", column = "org_code"),@Result(property = "orgName", column = "org_name"),@Result(property = "certificateType", column = "certificate_type"),@Result(property = "privateKey", column = "private_key"),@Result(property = "privateKeyPassword", column = "private_key_password"),@Result(property = "privateStorePassword", column = "private_store_password"),@Result(property = "publicKey", column = "public_key"),@Result(property = "effectiveDate", column = "effective_date"),@Result(property = "expirationDate", column = "expiration_date"),@Result(property = "certificateFile", column = "certificate_file"),@Result(property = "certificatePath", column = "certificate_path"),@Result(property = "status", column = "status"),@Result(property = "remark", column = "remark")})
	CertificateInfoVO getByIdWithOutCertFile(@Param("id") Long id);

	/**
	 * 查询列表(分页)
	 * @param params
	 * @return
	 */
	@Select(
			"<script>"
					+ "select distinct a.id, a.user_create,a.gmt_create,a.user_modified,a.gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_path,status,remark from t_certificate_info a left join t_certificate_industry_info b on a.id=b.cert_id where 1 = 1"
					+ "<if test='params.certificateSeq != null'> and a.certificate_seq = #{params.certificateSeq}</if>"
					+ "<if test='params.orgCode != null'> and a.org_code = #{params.orgCode}</if>"
					+ "<if test='params.orgName != null'> and a.org_name like concat('%',#{params.orgName},'%')</if>"
					+ "<if test='params.certificateName != null'> and a.certificate_name like concat('%',#{params.certificateName},'%')</if>"
					+ "<if test='params.certificateType != null'> and a.certificate_type = #{params.certificateType}</if>"
					+ "<if test='params.relationFlag != null'> and a.relation_flag = #{params.relationFlag}</if>"
					+ "<if test='params.industryCode != null'> and b.industry_code = #{params.industryCode}</if>"
					+ "<if test='params.status != null'> and a.status = #{params.status}</if>"
					+ " order by a.id desc"
					+ "</script>"
	)
	@ResultMap("CertificateVoResMap")
	Page<CertificateInfoVO> selectListWithOutCertFile(@Param("params") Map<String, Object> params);

	/**
	 * 更新证书状态
	 * @param id
	 * @param status
	 * @param userModified
	 * @param gmtModified
	 * @return
	 */
	@Update("update t_certificate_info set status = #{status}, user_modified = #{userModified}, gmt_modified = #{gmtModified} where id = #{id}")
	int updateStatus(@Param("id") Long id, @Param("status") String status, @Param("userModified") String userModified, @Param("gmtModified") Date gmtModified);

	/**
	 * 根据名称和状态查询证书
	 * @param certificateName
	 * @param status
	 * @return
	 */
	@Select("select id, user_create,gmt_create,user_modified,gmt_modified,certificate_no,certificate_seq,certificate_name,channel_key,product_code,org_code,org_name,certificate_type,private_key,private_key_password,private_store_password,public_key,effective_date,expiration_date,certificate_path,status,remark from t_certificate_info where certificate_name = #{certificateName} and status = #{status}")
	@Results(id="CertificateInfoMapper", value = {@Result(property = "id", column = "id"), @Result(property = "userCreate", column = "user_create"),@Result(property = "gmtCreate", column = "gmt_create"),@Result(property = "userModified", column = "user_modified"),@Result(property = "gmtModified", column = "gmt_modified"),@Result(property = "certificateNo", column = "certificate_no"),@Result(property = "certificateSeq", column = "certificate_seq"),@Result(property = "certificateName", column = "certificate_name"),@Result(property = "channelKey", column = "channel_key"),@Result(property = "productCode", column = "product_code"),@Result(property = "orgCode", column = "org_code"),@Result(property = "orgName", column = "org_name"),@Result(property = "certificateType", column = "certificate_type"),@Result(property = "privateKey", column = "private_key"),@Result(property = "privateKeyPassword", column = "private_key_password"),@Result(property = "privateStorePassword", column = "private_store_password"),@Result(property = "publicKey", column = "public_key"),@Result(property = "effectiveDate", column = "effective_date"),@Result(property = "expirationDate", column = "expiration_date"),@Result(property = "certificateFile", column = "certificate_file"),@Result(property = "certificatePath", column = "certificate_path"),@Result(property = "status", column = "status"),@Result(property = "remark", column = "remark")})
	CertificateInfoDO selectCertByNameAndStatus(@Param("certificateName") String certificateName, @Param("status") String status);

}

