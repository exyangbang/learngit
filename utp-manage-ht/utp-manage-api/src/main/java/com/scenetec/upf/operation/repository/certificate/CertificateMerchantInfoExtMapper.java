package com.scenetec.upf.operation.repository.certificate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author scenetec
 * @date 2018/07/23
 */
@Repository
@Mapper
public interface CertificateMerchantInfoExtMapper {

    /**
     * 删除证书所关联商户
     * @param certificateId
     * @return
     */
    @Delete("delete from t_certificate_merchant_info where cert_id = #{certificateId}")
    int deleteRefOfCertId(String certificateId);


}

