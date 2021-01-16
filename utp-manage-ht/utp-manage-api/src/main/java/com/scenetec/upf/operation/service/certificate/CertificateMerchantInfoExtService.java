package com.scenetec.upf.operation.service.certificate;

import java.util.List;

/**
 * @author yangyongchao
 * @date 2018/7/24
 */
public interface CertificateMerchantInfoExtService {

	/**
	 * 证书商户关联
	 * @param certificateId
	 * @param merchants
	 */
	public void certificateMerchantInfo(String certificateId, List<String> merchants);
}
