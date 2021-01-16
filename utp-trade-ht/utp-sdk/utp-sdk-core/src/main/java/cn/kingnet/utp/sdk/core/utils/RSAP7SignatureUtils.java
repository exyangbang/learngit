/* Copyright ©北京银河摩尔信息技术有限公司 right reserved.*/

package cn.kingnet.utp.sdk.core.utils;

import cfca.sadk.algorithm.common.Mechanism;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.CertUtil;
import cfca.sadk.util.KeyUtil;
import cfca.sadk.util.Signature;
import cfca.sadk.x509.certificate.X509Cert;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

/**
 * <p>
 *       概述： 华通银行软文签名工具-cfca
 * </p>
 * @author           创建人：    ryl
 * @copyRight        所有权©：  北京银河摩尔信息技术有限公司  All right reserved.
 * @date             创建时间：2018年8月29日 下午2:36:53
 */
public class RSAP7SignatureUtils {
	/**
	 * <p>
	 *      概述： 签名
	 * </p>
	 * @author             创建人：      ryl
	 * @date               创建时间：   2018年8月29日 下午2:48:37
	 * @param signCertData 签名证书
	 * @param password 证书密码
	 * @param data 签名数据
	 * @throws Exception
	 * @return             返回：          String   签文
	 */
	public static String sign(String signCertData,String password,String data)throws Exception {
		//步骤1 加密库初始化
		String deviceName = JCrypto.JSOFT_LIB;
		JCrypto.getInstance().initialize(deviceName, null);
		Session session = JCrypto.getInstance().openSession(deviceName);

		//步骤2 读取pfx文件构建证书对象
		File pfxFile = new File(signCertData);
		byte[] pfxByte = FileUtils.readFileToByteArray(pfxFile);
		X509Cert signCert = CertUtil.getCertFromPFX(pfxByte, password);

		//步骤3 获得私钥对象
		PrivateKey privateKey = KeyUtil.getPrivateKeyFromPFX(pfxByte, password);

		//步骤4 P7消息签名
		Signature signKit = new Signature();
		byte[] sourceData = data.getBytes(StandardCharsets.UTF_8);
		String signAlg = Mechanism.SHA1;
		byte[] signedData = signKit.p7SignMessageDetach(signAlg, sourceData, privateKey, signCert, session);
		return new String(signedData);
	}
	/**
	 * <p>
	 *      概述： 核签
	 * </p>
	 * @author             创建人：      ryl
	 * @date               创建时间：   2018年8月29日 下午2:49:32
	 * @param base64P7SignedData 签文
	 * @param data 核签数据
	 * @throws Exception
	 * @return             返回：boolean false:失败 true:成功
	 */
	public static boolean verify(String base64P7SignedData,String data)throws Exception {
        //步骤1 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);

        byte[] p7SignedData = base64P7SignedData.getBytes();

        //步骤2 验签
        Signature signKit = new Signature();
        byte[] sourceData = data.getBytes(StandardCharsets.UTF_8);
        boolean result = signKit.p7VerifyMessageDetach(sourceData, p7SignedData, session);
        return result;
	}
}
