package com.scenetec.upf.operation.service.certificate.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scenetec.upf.operation.exception.ErrorCode;
import com.scenetec.upf.operation.exception.SystemRuntimeException;
import com.scenetec.upf.operation.model.domain.certificate.CertificateInfoDO;
import com.scenetec.upf.operation.model.domain.certificate.CertificateMerchantInfoDO;
import com.scenetec.upf.operation.model.vo.certificate.CertificateInfoVO;
import com.scenetec.upf.operation.model.vo.certificate.CertificateVO;
import com.scenetec.upf.operation.model.vo.certificate.SecretInfoVo;
import com.scenetec.upf.operation.repository.certificate.CertificateInfoExtMapper;
import com.scenetec.upf.operation.repository.certificate.CertificateInfoMapper;
import com.scenetec.upf.operation.repository.certificate.CertificateMerchantInfoMapper;
import com.scenetec.upf.operation.service.certificate.CertificateInfoExtService;
import com.scenetec.upf.operation.service.system.UserService;
import com.scenetec.upf.operation.utils.*;
import com.scenetec.zeus.daogenerator.model.Query;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.security.krb5.internal.crypto.Des;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.security.cert.X509Certificate;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.util.*;

/**
 * @author shendunyuan@scenetec.com
 */
@Service
@Slf4j
public class CertificateInfoExtServiceImpl implements CertificateInfoExtService {

	private static final String KEYSTORE_INSTANCE = "PKCS12";

	private static final String ALGORITHM = "RSA";

	private static final int MAX_ENCRYPT_BLOCK = 245;

	private static final int MAX_DENCRYPT_BLOCK = 256;

	private static final String DEFAULT_CHARSET = "UTF-8";

	@Resource
	CertificateInfoExtMapper mapper;
	@Resource
	CertificateMerchantInfoMapper cmMapper;
	@Resource
	CertificateInfoMapper certMapper;
	@Resource
	UserService userService;

	@Value("${certificate.key.public.filepath}")
	String publicKeyFile;
	@Value("${certificate.key.private.filepath}")
	String privateKeyFile;

	@Value("${certificate.3des.key}")
	String key;
	/**
	 * 查询详细
	 *
	 * @param id 主键编号
	 * @return 证书对象
	 */
	@Override
	public CertificateInfoVO getByIdWithOutCertFile(Long id) {
		return mapper.getByIdWithOutCertFile(id);
	}

	/**
	 * 查询列表
	 *
	 * @param query 查询条件
	 * @return 证书列表
	 */
	@Override
	public PageInfo<CertificateInfoVO> queryListWithOutCertFile(Query query) {
		PageHelper.startPage(query.getPageNo(), query.getPageSize());
		Map<String, Object> parameters = query.getParameters();
		parameters.put("status", "1");
		Page<CertificateInfoVO> page = mapper.selectListWithOutCertFile(query.getParameters());
		return new PageInfo<>(page);
	}

	/**
	 * 根据商户号查询公私钥列表
	 *
	 * @param merNo 商户号
	 * @return 秘钥列表
	 */
	@Override
	public List<SecretInfoVo> querySecretListByMerNo(String merNo) {
		// 创建返回对象
		List<SecretInfoVo> voList = new ArrayList<>();
		try {
			// 查询商户关联的证书编号
			CertificateMerchantInfoDO merchantInfoDO = new CertificateMerchantInfoDO();
			merchantInfoDO.setMerNo(merNo);
			List<CertificateMerchantInfoDO> merchantInfoDOList = cmMapper.selectList(merchantInfoDO);
			if (merchantInfoDOList == null || merchantInfoDOList.size() <= 0) {
				return voList;
			}
			for (CertificateMerchantInfoDO infoDO : merchantInfoDOList) {
				// 查询证书信息
				CertificateInfoDO certDo = certMapper.getById(Long.valueOf(infoDO.getCertId()));
				// 组装返回参数
				voList.add(getSecretInfo(certDo));
			}
		}catch (Exception e) {
			throw new SystemRuntimeException(ErrorCode.BSMCE016);
		}
		// 返回结果
		return voList;
	}

	/**
	 * 上传公钥
	 *
	 * @param file 证书文件
	 * @param obj 证书对象
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void uploadMerPublicKey(MultipartFile file, CertificateVO obj) {
		InputStream is = null;
		try {
			// 校验证书名称
			checkCertName(obj.getCertificateName(), null);
			// 组装参数
			CertificateInfoDO cert = genCertificateInfoDO(obj);
			// 获取文件长度
			if (file.getSize() <= 0) {
				throw new SystemRuntimeException(ErrorCode.BSMCE001);
			}
			// 读取文件流
			is = file.getInputStream();
			// 获取公钥
			getPubKey(is, cert);
			// 设置证件来源
			if (StringUtils.isBlank(cert.getCertificateType())) {
				cert.setCertificateType("1");
			}
			cert.setStatus("1");
			cert.setCertificateNo(getUUID32());
			// 设置创建用户
			genUserInfo(cert, true);
			// 获取文件二进制文件
			getCertFile(file, cert);
			// 保存基础信息
			cert.setId(IdGenerate.getId());
			certMapper.create(cert);
		} catch (SystemRuntimeException sex) {
			throw sex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE012, "机构");
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 上传私钥
	 *
	 * @param file 证书文件
	 * @param obj 证书对象
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void uploadUpPrivateKey(MultipartFile file, CertificateVO obj) {
		InputStream is = null;
		try {
			// 校验证书名称
			checkCertName(obj.getCertificateName(), null);
			// 组装参数
			CertificateInfoDO cert = genCertificateInfoDO(obj);
			// 获取文件流
			is = file.getInputStream();
			// 获取秘钥
			getPriKey(is, cert);
			// 设置证件来源
			if (StringUtils.isBlank(cert.getCertificateType())) {
				cert.setCertificateType("2");
			}
			cert.setStatus("1");
			cert.setCertificateNo(getUUID32());
			// 创建用户
			genUserInfo(cert, true);
			// 获取文件二进制文件
			getCertFile(file, cert);
			// 保存基础信息
			cert.setId(IdGenerate.getId());
			certMapper.create(cert);
		} catch(SystemRuntimeException sex) {
			throw sex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE012, "渠道");
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void deleteCertificate(Long id) {
		// 校验是否关联商户
		CertificateMerchantInfoDO cmdo = new CertificateMerchantInfoDO();
		cmdo.setCertId(StringUtil.toString(id));
		List<CertificateMerchantInfoDO> cmList = cmMapper.selectList(cmdo);
		if (cmList != null && cmList.size() > 0) {
			throw new SystemRuntimeException(ErrorCode.BSMCE007);
		}
		// 逻辑删除，状态置为作废
		String status = "0";
		String userModified = userService.getUserContext().getUsername();
		mapper.updateStatus(id,status, userModified, new Date());
	}

	/**
	 * 编辑公钥
	 *
	 * @param file 证书文件
	 * @param obj 证书对象
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void updateMerPublicKey(MultipartFile file, CertificateVO obj) {
		InputStream is = null;
		try {
			// 组装参数
			CertificateInfoDO cert = genCertificateInfoDO(obj);
			// 校验证书名称
			checkCertName(obj.getCertificateName(), obj.getId());
			// 读取文件流
			if (file != null) {
				is = file.getInputStream();
				// 获取文件二进制文件
				getCertFile(file, cert);
			} else {
				is = new ByteArrayInputStream(getCertFile(obj.getId()));
			}
			// 读取文件内容
			getPubKey(is, cert);
			// 设置证件来源
			if (StringUtils.isBlank(cert.getCertificateType())) {
				cert.setCertificateType("1");
			}
			// 创建用户
			genUserInfo(cert, false);
			// 保存基础信息
			certMapper.update(cert);
		} catch(SystemRuntimeException sex) {
			throw sex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE012, "机构");
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 编辑私钥
	 *
	 * @param file 私钥文件
	 * @param obj 证书对象
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void updateUpPrivateKey(MultipartFile file, CertificateVO obj) {
		InputStream is = null;
		try {
			// 组装参数
			CertificateInfoDO cert = genCertificateInfoDO(obj);
			// 校验证书名称
			checkCertName(obj.getCertificateName(), obj.getId());
			// 读取文件流
			if (file != null) {
				is = file.getInputStream();
				// 获取文件二进制文件
				getCertFile(file, cert);
			} else {
				is = new ByteArrayInputStream(getCertFile(obj.getId()));
			}
			// 获取秘钥
			getPriKey(is, cert);
			// 设置证件来源
			if (StringUtils.isBlank(cert.getCertificateType())) {
				cert.setCertificateType("2");
			}
			// 创建用户
			genUserInfo(cert, false);
			// 保存基础信息
			certMapper.update(cert);
		} catch(SystemRuntimeException sex) {
			throw sex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE012, "渠道");
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 修改
	 * @param obj 证书对象
	 */
	private void genUserInfo(CertificateInfoDO obj, boolean flag) {
		String userName = userService.getUserContext().getUsername();
		Date date = new Date();
		if (flag) {
			obj.setUserCreate(userName);
			obj.setGmtCreate(date);
		}
		obj.setUserModified(userName);
		obj.setGmtModified(date);
	}

	/**
	 * 校验证书名称
	 * @param certName 证书名称
	 */
	private void checkCertName(String certName, Long id) {
		// 有效状态的证书，不能重名
		CertificateInfoDO selectDo = mapper.selectCertByNameAndStatus(certName, "1");
		if(selectDo != null){
			if (!selectDo.getId().equals(id)) {
				throw new SystemRuntimeException(ErrorCode.BSMCE006);
			}
		}
	}

	/**
	 * 获取uuid编号
	 * @return 返回uuid
	 */
	private String getUUID32() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}

	/**
	 * 获取秘钥
	 * @param is 文件流
	 * @param obj 证书对象
	 */
	private void getPriKey(InputStream is, CertificateInfoDO obj) {
		try {
			// 加载秘钥库
			KeyStore ks = getKeyStore(is, obj.getPrivateStorePassword());
			// 获取私钥
			PrivateKey prikey = getPrivateKey(ks, obj.getPrivateKeyPassword());
			obj.setPrivateKey(DesUtil.encryptThreeDESECB(getKeyString(prikey),key));
			// 获取公钥
			Certificate cert = ks.getCertificate(getKeyAlias(ks));
			PublicKey pubkey = cert.getPublicKey();
			obj.setPublicKey(DesUtil.encryptThreeDESECB(getKeyString(pubkey),key));
			// 获取证书其他信息
			X509Certificate x509Cert = X509Certificate.getInstance(cert.getEncoded());
			getCertInfo(x509Cert, obj);
		} catch(SystemRuntimeException sex) {
			sex.printStackTrace();
			throw sex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE012, "渠道");
		}
	}

	/**
	 * 获取私钥
	 * @param ks 秘钥库
	 * @param keyPassword 秘钥密码
	 * @return 私钥
	 */
	private PrivateKey getPrivateKey(KeyStore ks, String keyPassword) {
		PrivateKey prikey;
		try {
			if (StringUtils.isBlank(keyPassword)) {
				throw new SystemRuntimeException(ErrorCode.BSMCE008);
			}
			// 获取私钥
			prikey = (PrivateKey) ks.getKey(getKeyAlias(ks), keyPassword.toCharArray());
		} catch (Exception ex) {
			throw new SystemRuntimeException(ErrorCode.BSMCE010);
		}
		return prikey;
	}

	/**
	 * 获取私钥别名
	 * @param ks 私钥库
	 * @return 私钥别名
	 */
	private String getKeyAlias(KeyStore ks) {
		String keyAlias = null;
		try {
			Enumeration enumeration = ks.aliases();

			if (enumeration.hasMoreElements()) {
				keyAlias = (String)enumeration.nextElement();
			}
		} catch (Exception ex) {
			throw new SystemRuntimeException(ErrorCode.BSMCE011);
		}
		return keyAlias;
	}

	/**
	 * 获取私钥库keystore
	 * @param is 文件流
	 * @param storeKey store密码
	 * @return 返回秘钥库
	 */
	private KeyStore getKeyStore(InputStream is, String storeKey) {
		KeyStore ks;
		try {
			// 获取文件流
			if (StringUtils.isBlank(storeKey)) {
				throw new SystemRuntimeException(ErrorCode.BSMCE009);
			}
			// 获取store密码
			char[] keyStorePwd = storeKey.toCharArray();
			// 读取秘钥
			ks = KeyStore.getInstance(KEYSTORE_INSTANCE);
			// 加载证书
			ks.load(is, keyStorePwd);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE002);
		}
		return ks;
	}

	/**
	 * 读取证书日期，序列号信息
	 * @param x509Cert x509证书
	 * @param obj 证书对象
	 */
	private void getCertInfo(X509Certificate x509Cert, CertificateInfoDO obj) {
		try {
			Date notBefore = x509Cert.getNotBefore();
			Date notAfter = x509Cert.getNotAfter();
			String certSeq = StringUtil.toString(x509Cert.getSerialNumber());

			obj.setCertificateSeq(certSeq);
			obj.setEffectiveDate(DateUtilities.formatDate(notBefore, "yyyy-MM-dd"));
			obj.setExpirationDate(DateUtilities.formatDate(notAfter, "yyyy-MM-dd"));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE003);
		}
	}

	/**
	 * 秘钥base64
	 * @param key 秘钥
	 * @return base64加密
	 */
	private String getKeyString(Key key) {
		if (key == null) {
			return null;
		}
		byte[] keyBytes = key.getEncoded();
		return StringUtil.byte2String(Base64Util.encode(keyBytes));
	}

	/**
	 * 读取文件内容
	 * @param is 文件流
	 */
	private void getPubKey(InputStream is, CertificateInfoDO obj) {
		try {
			// 读取证书
			X509Certificate x509Cert = X509Certificate.getInstance(is);
			PublicKey pubkey = x509Cert.getPublicKey();
			obj.setPublicKey(DesUtil.encryptThreeDESECB(getKeyString(pubkey),key));
			// 读取证书其他信息
			getCertInfo(x509Cert, obj);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE012, "机构");
		}
	}

	/**
	 * 获取文件二进制文件
	 * @param file 证书文件
	 * @param obj 证书对象
	 */
	private void getCertFile(MultipartFile file, CertificateInfoDO obj) {
		InputStream is = null;
		try {
			// 获取文件流
			is = file.getInputStream();
			// 获取二进制文件数组
			byte[] certificateFile = FileCopyUtils.copyToByteArray(is);
			//
			obj.setCertificateFile(certificateFile);
		} catch (Exception ex) {
			ex.printStackTrace();
			LoggerUtil.logger(log, ex.getMessage());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 组装私钥信息
	 * @param certDo 证书对象
	 * @return 秘钥对象
	 */
	private SecretInfoVo getSecretInfo(CertificateInfoDO certDo) throws Exception {
		SecretInfoVo vo = new SecretInfoVo();
		if (certDo != null) {
			vo.setCertificateSeq(certDo.getCertificateSeq());
			vo.setCertificateName(certDo.getCertificateName());
			vo.setCertificateType(certDo.getCertificateType());
			vo.setChannelKey(certDo.getChannelKey());
			vo.setProductCode(certDo.getProductCode());
			vo.setOrgCode(certDo.getOrgCode());
			vo.setPrivateKey(DesUtil.decryptThreeDESECB(certDo.getPrivateKey(),key));
			vo.setPrivateKeyPassword(certDo.getPrivateKeyPassword());
			vo.setPrivateStorePassword(certDo.getPrivateStorePassword());
			vo.setPublicKey(DesUtil.decryptThreeDESECB(certDo.getPublicKey(),key));
			vo.setEffectiveDate(certDo.getEffectiveDate());
			vo.setExpirationDate(certDo.getExpirationDate());
		}
		return vo;
	}

	/**
	 * 拷贝对象
	 * @param obj 源对象
	 * @return 证书对象
	 */
	private CertificateInfoDO genCertificateInfoDO(CertificateVO obj) {
		CertificateInfoDO cert = new CertificateInfoDO();
		BeanUtils.copyProperties(obj, cert);
		return cert;
	}

	/**
	 * 读取二进制文件
	 * @param id 主键
	 * @return 返回文件字节数组
	 */
	private byte[] getCertFile(Long id) {
		CertificateInfoDO certDo = certMapper.getById(id);
		if (certDo == null) {
			throw new SystemRuntimeException(ErrorCode.BSMCE013);
		}
		return certDo.getCertificateFile();
	}

	/**
	 * rsa公钥加密
	 * @param source 源字符串
	 * @return 加密字符串
	 */
	private String encrypt(String source) {
		String result = null;
		try {
			if (StringUtils.isNotBlank(source)) {
				Key publicKey = getKey(publicKeyFile);

				Cipher cipher = Cipher.getInstance(ALGORITHM);
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);

				byte[] resultByte = cipher(cipher, source.getBytes(DEFAULT_CHARSET), MAX_ENCRYPT_BLOCK);

				result = StringUtil.byte2String(Base64Util.encode(resultByte));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * 私钥解密
	 * @param source 源字符串
	 * @return 解密字符串
	 */
	private String decrypt(String source) {
		String target = null;
		try {
			if (StringUtils.isNotBlank(source)) {
				Key privateKey = getKey(privateKeyFile);

				Cipher cipher = Cipher.getInstance(ALGORITHM);
				cipher.init(Cipher.DECRYPT_MODE, privateKey);

				byte[] sourceByte = Base64Util.decode(source);

				byte[] targetByte = cipher(cipher, sourceByte, MAX_DENCRYPT_BLOCK);

				target = StringUtil.byte2String(targetByte);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return target;
	}

	/**
	 * 获取秘钥
	 * @param fileName 文件名
	 * @return 返回公私钥
	 */
	private Key getKey(String fileName) {
		Key key;
		InputStream is = null;
		ObjectInputStream ois = null;
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				throw new SystemRuntimeException(ErrorCode.BSMCE014);
			}
			if (file.isDirectory()) {
				throw new SystemRuntimeException(ErrorCode.BSMCE015);
			}
			// 读取文件
			is = new FileInputStream(file);
			ois = new ObjectInputStream(is);
			// 读取key
			key = (Key) ois.readObject();
		} catch (SystemRuntimeException srex) {
			throw srex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SystemRuntimeException(ErrorCode.BSMCE015);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return key;
	}

	private static byte[] cipher(Cipher cipher, byte[] data, int maxBlock) {
		byte[] cipherByte = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();

			int sourceLen = data.length;
			int offset = 0;
			byte[] cache;
			int i = 0;

			while (sourceLen - offset > 0) {
				if (sourceLen - offset > maxBlock) {
					cache = cipher.doFinal(data, offset, maxBlock);
				} else {
					cache = cipher.doFinal(data, offset, sourceLen - offset);
				}
				baos.write(cache, 0, cache.length);
				i++;
				offset = i*maxBlock;
			}

			cipherByte = baos.toByteArray();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return cipherByte;
	}
}