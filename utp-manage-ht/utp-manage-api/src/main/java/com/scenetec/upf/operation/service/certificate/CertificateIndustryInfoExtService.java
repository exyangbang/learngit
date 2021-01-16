package com.scenetec.upf.operation.service.certificate;

import java.util.List;

/**
 * @author yangyongchao
 * @date 2018/7/24
 */
public interface CertificateIndustryInfoExtService {

	/**
	 * 证书商户关联
	 * @param certificateId
	 * @param industrys
	 */
	public void certificateIndustryInfo(String certificateId, List<String> industrys);

	public long countRefOfCertId(Long certificateId);
}
