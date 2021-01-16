package cn.buyforyou.sign.crypto;

import java.security.MessageDigest;

/**
 * <p>          
 *       概述： sha 256 摘要
 * </p>   
 * @author           创建人：    ryl
 * @copyRight        所有权©：  北京银河摩尔信息技术有限公司  All right reserved.
 * @date             创建时间：2018年8月29日 上午11:06:49
 */
public class HTSHA256 {
	/**
	 * 对明文密码进行加密
	 * @param pwd
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public static String shaEncode(String pwd,String accountId) throws Exception {
		String str=String.format("%s{%s}", pwd,accountId);
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes("GBK"));
		StringBuffer strHexString = new StringBuffer();
		for (byte b : md.digest()) {
			strHexString.append(String.format("%02X", b));
		}
		return strHexString.toString();
	}
	
	public static void main(String[] args) {	
		// loginPwd{accountId}
		String t= "123qwe{admin}";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(t.getBytes("GBK"));
			for(byte b:md.digest())
				System.out.format("%02X",b);			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
