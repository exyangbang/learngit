package com.scenetec.upf.operation.service.certificate;

import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.model.domain.certificate.CertificateInfoDO;
import com.scenetec.upf.operation.model.vo.certificate.CertificateInfoVO;
import com.scenetec.upf.operation.model.vo.certificate.CertificateVO;
import com.scenetec.upf.operation.model.vo.certificate.SecretInfoVo;
import com.scenetec.zeus.daogenerator.model.Query;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author scenetec
 * @date 2018/07/22
 */
public interface CertificateInfoExtService {

	/**
	 * 查询详细
	 * @param id
	 * @return
	 */
	CertificateInfoVO getByIdWithOutCertFile(Long id);

	/**
	 * 查询列表
	 * @param query
	 * @return
	 */
	PageInfo<CertificateInfoVO> queryListWithOutCertFile(Query query);

	/**
	 * 根据商户号查询公私钥列表
	 * @param merNo
	 * @return
	 */
	List<SecretInfoVo> querySecretListByMerNo(String merNo);

	/**
	 * 上传公钥
	 * @param file
	 * @param obj
	 */
	void uploadMerPublicKey(MultipartFile file, CertificateVO obj);

	/**
	 * 上传私钥
	 * @param file
	 * @param obj
	 */
	void uploadUpPrivateKey(MultipartFile file, CertificateVO obj);

	/**
	 * 删除证书
	 * @param id
	 */
	void deleteCertificate(Long id);

	/**
	 * 编辑公钥
	 * @param file
	 * @param obj
	 */
	void updateMerPublicKey(MultipartFile file, CertificateVO obj);

	/**
	 * 编辑私钥
	 * @param file
	 * @param obj
	 */
	void updateUpPrivateKey(MultipartFile file, CertificateVO obj);
}
