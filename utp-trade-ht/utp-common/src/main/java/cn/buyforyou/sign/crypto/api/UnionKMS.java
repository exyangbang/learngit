package cn.buyforyou.sign.crypto.api;

import com.union.utils.UnionAPI;

import java.util.HashMap;
import java.util.Map;

public class UnionKMS {
	
	/*
	 * K999 申请一张IC卡的安全数据
	 */
	public Recv servK999(
			String icStandard, String protectKeyName,String protectKeyVersion,String cardBin,int lengthOfRSA, String EF04, 
			String EF06, String EF08, String EF10, String recordNo, String iccPAN, int iccAppNum,String signData01, 
			String ICCExpires01, String dataVerificationCode01, String signData02,String ICCExpires02, String dataVerificationCode02,
			String signData03,String ICCExpires03,String dataVerificationCode03,String appExtension
		){
		
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if((ret=api.start("K999", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if((ret=api.setString("icStandard", icStandard)) != 0)
				recv.setResponseCode(ret);
			if((ret = api.setString("protectKeyName", protectKeyName)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("protectKeyVersion", protectKeyVersion)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("cardBin", cardBin)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setInteger("lengthOfRSA", lengthOfRSA)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("EF04", EF04)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("EF06", EF06)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("EF08", EF08)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("EF10", EF10)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("recordNo", recordNo)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("iccPAN", iccPAN)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setInteger("iccAppNum", iccAppNum)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("signData01", signData01)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("ICCExpires01", ICCExpires01)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("dataVerificationCode01", dataVerificationCode01)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("signData02", signData02)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("ICCExpires02", ICCExpires02)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("dataVerificationCode02", dataVerificationCode02)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("signData03", signData03)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("ICCExpires03", ICCExpires03)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("dataVerificationCode03", dataVerificationCode03)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("appExtension", appExtension)) != 0)
				recv.setResponseCode(ret);
			
			ret = api.send();		//返回响应码
			recv.setResponseCode(ret);
			if(ret!=0) {		//如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			
			recv.setSecurityFileData(api.getString("securityFileData"));
			api.end();	//结束释放UnionAPI类中静态成员变量
			
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}
	
	//该类用于接收报文响应域，由客户根据接口说明文档自行定义
	public static class Recv{
		private final Map<String, String> strings = new HashMap<String, String>();
		@SuppressWarnings("unused")
		private final Map<String, byte[]> bytes = new HashMap<String, byte[]>();
		private final Map<String, Integer> integers = new HashMap<String, Integer>();
	
		public Integer getResponseCode() {
			return integers.get("responseCode");
		}

		public void setResponseCode(Integer responseCode) {
			integers.put("responseCode", responseCode);
		}
		
		public String getResponseRemark() {
			return strings.get("responseRemark");
		}

		public void setResponseRemark(String responseRemark) {
			strings.put("responseRemark", responseRemark);
		}
		public String getSecurityFileData() {
			return strings.get("securityFileData");
		}

		public void setSecurityFileData(String securityFileData) {
			strings.put("securityFileData", securityFileData);
		}
		
		public static Recv failed(Exception e) {
			final Recv recv = new Recv();
			recv.setResponseCode(-1);
			recv.setResponseRemark(e.getMessage());
			return recv;
		}
	}
}
