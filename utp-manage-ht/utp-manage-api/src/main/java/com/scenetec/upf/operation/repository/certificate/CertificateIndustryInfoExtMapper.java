package com.scenetec.upf.operation.repository.certificate;

import com.scenetec.upf.operation.model.domain.certificate.CertificateIndustryInfoDO;
import com.scenetec.upf.operation.model.domain.certificate.CertificateMerchantInfoDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author scenetec
 * @date 2018/07/23
 */
@Repository
@Mapper
public interface CertificateIndustryInfoExtMapper {

    /**
     * 删除证书所关联商户
     * @param certificateId
     * @return
     */
    @Delete("delete from t_certificate_industry_info where cert_id = #{certificateId}")
    int deleteRefOfCertId(String certificateId);

    /**
     * 批量插入
     * @param obj
     * @return
     */
    @Insert(
            "<script>"
                    +"insert into t_certificate_industry_info ("
                    +" cert_id, industry_code"
                    +") values "
                    +"<foreach collection='list' item='item' index='index' separator=','>"
                    +"(#{item.certId}, #{item.industryCode})"
                    +"</foreach>"
                    +"</script>"
    )
    int insertList(List<CertificateIndustryInfoDO> obj);

    /**
     * 所关联商户数量
     * @param certificateId
     * @return
     */
    @Select("select count(1) from t_certificate_industry_info where cert_id = #{certificateId}")
    long countRefOfCertId(Long certificateId);
}

