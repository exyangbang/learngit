package com.scenetec.upf.operation.service.merchant;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author shendunyuan@scenetec.com
 * 2018/7/11 下午5:07
 */
public interface MerchantImportService {
	/**
	 * 导入商户列表
	 * @param file
	 * @return
	 */
	String upload(MultipartFile file, Resource resource);
}
