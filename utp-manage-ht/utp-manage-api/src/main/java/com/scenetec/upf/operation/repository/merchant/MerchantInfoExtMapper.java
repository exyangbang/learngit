package com.scenetec.upf.operation.repository.merchant;

import com.github.pagehelper.Page;
import com.scenetec.upf.operation.model.domain.merchant.MerchantInfoDO;
import com.scenetec.upf.operation.model.vo.merchant.MerchantInfoVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author scenetec
 * @date 2018/07/25
 */
@Repository
@Mapper
public interface MerchantInfoExtMapper {


    /**
     * 查询列表(分页)
     * @param params
     * @return
     */
 	@Select(
        "<script>"
 			+ "select mer.id, mer.user_create,mer.gmt_create,mer.user_modified,mer.gmt_modified,mer.mer_no,mer_name,"
		        + "name_abbreviation,administrative_code,org_code,org_name,province_code,city_code,county_code,reg_address,"
		        + "business_address,legal_name,status,website_name,pay_merchant_no,template_id,cert.cert_id "
		        + "from t_merchant_info mer "
		        + "left join (select c.mer_no,c.cert_id "
	            + "from t_certificate_info b "
	            + "left join t_certificate_merchant_info c on b.id = c.cert_id "
	            + "and b.org_code = #{params.orgCode} "
	            + "and b.id = #{params.certificateId} "
	            + "and b.status = '1' "
	            + "<if test='params.certificateType != null'> and b.certificate_type = #{params.certificateType}</if>) cert on mer.mer_no = cert.mer_no "
		        + "where 1 = 1"
		        + "<if test='params.merNo != null'> and mer.mer_no like concat('%',#{params.merNo},'%')</if>"
		        + "<if test='params.merName != null'> and mer.mer_name like concat('%',#{params.merName},'%')</if>"
		        + "<if test='params.legalName != null'> and mer.legal_name like concat('%',#{params.legalName},'%')</if>"
		        + "<if test='params.status != null'> and mer.status = #{params.status}</if>"
		        + "<if test='params.orgCode != null'> and mer.org_code = #{params.orgCode}</if>"
        + "</script>"
    )
	@Results(id="MerchantInfoExtResultMap",
			value = {@Result(property = "id", column = "id"),
					@Result(property = "userCreate", column = "user_create"),
					@Result(property = "gmtCreate", column = "gmt_create"),
					@Result(property = "userModified", column = "user_modified"),
					@Result(property = "gmtModified", column = "gmt_modified"),
					@Result(property = "merNo", column = "mer_no"),
					@Result(property = "merName", column = "mer_name"),
					@Result(property = "nameAbbreviation", column = "name_abbreviation"),
					@Result(property = "administrativeCode", column = "administrative_code"),
					@Result(property = "orgCode", column = "org_code"),
					@Result(property = "orgName", column = "org_name"),
					@Result(property = "provinceCode", column = "province_code"),
					@Result(property = "cityCode", column = "city_code"),
					@Result(property = "countyCode", column = "county_code"),
					@Result(property = "regAddress", column = "reg_address"),
					@Result(property = "businessAddress", column = "business_address"),
					@Result(property = "legalName", column = "legal_name"),
					@Result(property = "status", column = "status"),
					@Result(property = "websiteName", column = "website_name"),
					@Result(property = "payMerchantNo", column = "pay_merchant_no"),
					@Result(property = "templateId", column = "template_id"),
					@Result(property = "certId", column = "cert_id")})
    Page<MerchantInfoVo> queryListWithCertId(@Param("params") Map<String, Object> params);
}

