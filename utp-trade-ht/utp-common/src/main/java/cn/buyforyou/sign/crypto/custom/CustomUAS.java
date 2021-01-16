package cn.buyforyou.sign.crypto.custom;

import cn.buyforyou.sign.crypto.api.UnionUAS;
import cn.buyforyou.sign.crypto.api.UnionUAS.Recv;

public final class CustomUAS {
	/**
	* UnionAppUpdateCert	更新证书(二代支付)
	* @param appName(ASCII)	证书应用名称,命名需遵循规则appID.bankID.ver, appID为应用标识，bankID为机构标识, ver为版本号
	* @param cert(ASCII)	公钥证书(base64格式)
	* @return
	* 			返回 int, =0 成功,其他失败
	*/
	public int UnionAppUpdateCert(String appName, String cert) {
		if (appName == null || cert == null)
			return -1;
		String[] ms = appName.split("\\.");
		if (ms.length != 3)
			return -2;
		String pix = "01010000";
		String bankID = ms[1];
		String certVersion = String.format("%02d",Integer.parseInt(ms[2]));
		Recv recv = new UnionUAS().servUA15(pix, bankID, certVersion, cert);
		return recv.getResponseCode();
	}
	
	/**
	* UnionAppRevocationCert	撤销证书(二代支付)
	* @param appName(ASCII)	证书应用名称,命名需遵循规则appID.bankID.ver, appID为应用标识，bankID为机构标识, ver为版本号
	* @return 返回 int, =0 成功,其他失败
	*/
	public int UnionAppRevocationCert(String appName) {
		if (appName == null)
			return -1;
		String[] ms = appName.split("\\.");
		if (ms.length != 3)
			return -2;
		String pix = "01010000";
		String bankID = ms[1];
		String certVersion = String.format("%02d",Integer.parseInt(ms[2]));
		Recv recv = new UnionUAS().servUA16(pix, bankID, certVersion, "2");
		return recv.getResponseCode();
	}
	
	/**
	* UnionAppRawSign	普通签名(裸签)(二代支付)
	* @param msg(B) 待签名原文
	* @param iAlgorithm 摘要算法,0后台自行判断，1 表示SHA1, 2 表示SM3,RSA证书只能选择SHA1；SM2证书只能选择SM3算法
	* @param appName(ASCII)	证书应用名称,命名需遵循规则appID.bankID.ver, appID为应用标识，bankID为机构标识, ver为版本号
	* @return 返回 String, 非null 成功,null失败
	*/
	public String UnionAppRawSign(byte[] msg,int iAlgorithm,String appName) {
		if (appName == null)
			return null;
		String[] ms = appName.split("\\.");
		if (ms.length != 3)
			return null;
		String pix = "01010000";
		String bankID = ms[1];
		String certVersion = String.format("%02d",Integer.parseInt(ms[2]));
		String algFlag = null;
		if (iAlgorithm == 0)
			algFlag = "2";
		else
			algFlag = String.format("%d", iAlgorithm-1);
		Recv recv = new UnionUAS().servUA12(pix, bankID, certVersion, msg, algFlag);
		if (recv.getResponseCode() != 0)
			return null;
		return new String(recv.getSign());
	}
	
	/**
	* UnionAppRawVerify	此接口用于普通业务的数据验签(二代支付)
	* @param msg(B) 待签名原文
	* @param signedData 待验证的签名,base64编码
	* @param appName(ASCII)	证书应用名称,命名需遵循规则appID.bankID.ver, appID为应用标识，bankID为机构标识, ver为版本号
	* @param iAlgorithm 摘要算法,会根据签名长度判断是sm2或rsa
	* @return 返回 int, =0 成功,其他失败
	*/
	public int UnionAppRawVerify(byte[] msg,String signedData,String appName,int iAlgorithm) {
		if (appName == null)
			return -1;
		String[] ms = appName.split("\\.");
		if (ms.length != 3)
			return -2;
		String pix = "01010000";
		String bankID = ms[1];
		String certVersion = String.format("%02d",Integer.parseInt(ms[2]));
		Recv recv = new UnionUAS().servUA13(pix, bankID, certVersion, msg, signedData, "0");
		return recv.getResponseCode();
	}
	
	/**
	* UnionAppDetachedSign	对数据进行pkcs7 detached方式签名，返回签名结果(二代支付)
	* @param msg(B) 待签名原文,二进制数据
	* @param appName(ASCII)	证书应用名称,命名需遵循规则appID.bankID.ver, appID为应用标识，bankID为机构标识, ver为版本号
	* @param iAlgorithm 摘要算法,会根据签名长度判断是sm2或rsa
	* @return
	* 			返回 int, =0 成功,其他失败
	*/
	public String UnionAppDetachedSign(byte[] msg,String appName,int iAlgorithm) {
		if (appName == null)
			return null;
		String[] ms = appName.split("\\.");
		if (ms.length != 3)
			return null;
		String pix = "01010000";
		String bankID = ms[1];
		String certVersion = String.format("%02d",Integer.parseInt(ms[2]));
		String algFlag = null;
		if (iAlgorithm == 0)
			algFlag = "2";
		else
			algFlag = String.format("%d", iAlgorithm-1);
		Recv recv = new UnionUAS().servUA10(pix, bankID, certVersion, msg, algFlag);
		if (recv.getResponseCode() != 0)
			return null;
		return new String(recv.getSign());
	}
	
	/**
	* UnionAppDetachedVerify	对数据进行pkcs7 detached方式签名，返回签名结果(二代支付)
	* @param msg(B) 待签名原文,二进制数据
	* @param appName(ASCII)	证书应用名称,命名需遵循规则appID.bankID.ver, appID为应用标识，bankID为机构标识, ver为版本号
	* @param iAlgorithm 摘要算法,会根据签名长度判断是sm2或rsa
	* @return
	* 			返回UnionCertInfo对象, UnionCertInfo 公钥证书属性类，包括如下属性
                  private String subject;		//证书主题
	              private String ser_number;	//证书序号
	              private String issuer_subject;	//证书颁发者
	              private String start_time;	//证书生效日期yyyyMMdd
	              private String end_time;	//证书失效日期yyyyMMdd
	              private String alg_id;     //证书算法标识 "RSA"或"SM2"
	              private String pk;         证书公钥(RSA公钥格式为DER Hex格式,SM2公钥 为”04||xHex||yHex”)
	              private String base64Cert;  //证书数据(base64

	*/
	public UnionCertInfo UnionAppDetachedVerify(byte[] msg,String signedMsg) {
		Recv recv = new UnionUAS().servUA11("3","", "", "",  msg, signedMsg);
		if (recv.getResponseCode() != 0)
			return null;
		UnionCertInfo info = new UnionCertInfo();
		info.setBase64Cert(recv.getCertBuf());
		info.setSer_number(recv.getCertSN());
		info.setSubject(recv.getCertDN());
		info.setStart_time(recv.getCertEffdate());
		info.setEnd_time(recv.getCertInvdate());
		return info;
	}
}