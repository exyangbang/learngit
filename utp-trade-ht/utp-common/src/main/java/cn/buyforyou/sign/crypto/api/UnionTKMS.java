package cn.buyforyou.sign.crypto.api;

import com.union.utils.UnionAPI;

import java.util.HashMap;
import java.util.Map;

public class UnionTKMS {
	
	

	/**
	* T002	初始化终端主密钥
	* @param termType	终端类型
	* @param termID	终端号
	* @param protectKey	保护密钥
	* @param isDeleteESSCKeyFlag	重置平台密钥标识
	* @return
	* 			返回 {@link Recv} 对象
	* 			获取响应信息：
	* <blockquote>
	* 			{@link Recv#getResponseCode()}	:	响应码<br>
	* 			{@link Recv#getResponseRemark()}	:	响应描述<br>
	* 			{@link Recv#getKeyName()}	:	密钥名称<br>
	* 			{@link Recv#getKeyValue()}	:	密钥密文<br>
	* 			{@link Recv#getCheckValue()}	:	校验值<br>
	* </blockquote>
	*/
	public Recv servT002(String termType, String termID, String protectKey, String isDeleteESSCKeyFlag) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			* userInfo、sysID、appID可供用户自定
			* userInfo: 不指定则由API自动生成；
			* sysID、appID: 不指定则采用配置文件中的设定
			*/
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if((ret=api.start("T002", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("termID", termID)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("protectKey", protectKey)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("isDeleteESSCKeyFlag", isDeleteESSCKeyFlag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if(ret!=0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyName(api.getByte("keyName"));
			recv.setKeyValue(api.getByte("keyValue"));
			recv.setCheckValue(api.getByte("checkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	
	
	/**
	* T001	下载终端公钥
	* @param termType	终端类型
	* @param termID	终端号
	* @param authCode	认证码
	* @param symmetricKeyList	对称密钥列表
	* @param pkMLenth	公钥模长
	* @param pkExponent	公钥指数
	* @param format1	源PIN格式
	* @param format2	目的PIN格式
	* @param checkFlag	检验标识
	* @param checkData	PIN校验数据
	* @param decimalFlag	十进制转换标识
	* @param decimalTable	十进制转换表
	* @return
	* 			返回 {@link Recv} 对象
	* 			获取响应信息：
	* <blockquote>
	* 			{@link Recv#getResponseCode()}	:	响应码<br>
	* 			{@link Recv#getResponseRemark()}	:	响应描述<br>
	* 			{@link Recv#getPk()}	:	公钥<br>
	* </blockquote>
	*/
	public Recv servT001(String termType, String termID, String authCode,
			String symmetricKeyList, String pkMLenth, String pkExponent) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			* userInfo、sysID、appID可供用户自定
			* userInfo: 不指定则由API自动生成；
			* sysID、appID: 不指定则采用配置文件中的设定
			*/
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if((ret=api.start("T001", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("termID", termID)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("authCode", authCode)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("symmetricKeyList", symmetricKeyList)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("pkMLenth", pkMLenth)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("pkExponent", pkExponent)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if(ret!=0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPk(api.getString("pk") == null ? " " : api.getString("pk"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	
	
	/**
	 * T003 更新终端密钥
	 * @param termType 终端类型
	 * @param termID 终端号
	 * @param keyType 密钥类型
	 * @return ZMKName 主密钥名称
	 * @return keyName 密钥名称
	 * @return keyValue 密钥密文
	 * @return keyValue2 密钥密文2
	 * @return checkValue 校验值
	 */
	public Recv servT003(String termType, String termID ,String keyType) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if((ret=api.start("T003", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if((ret=api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if((ret = api.setString("termID", termID)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			
			ret = api.send();		//返回响应码
			recv.setResponseCode(ret);
			if(ret!=0) {		//如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			
			recv.setZMKName(api.getString("ZMKName"));
			recv.setKeyName(api.getString("keyName"));
			recv.setKeyValue(api.getString("keyValue"));
			recv.setKeyValue2(api.getString("keyValue2"));
			recv.setCheckValue(api.getString("checkValue"));
			api.end();	//结束释放UnionAPI类中静态成员变量
			
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}
	

	/**
	* T007	注册终端
	* @param termType	终端类型
	* @param deviceId	终端编号
	* @param factoryId	厂商编号
	* @param organization	机构编号
	* @param pkMLenth	公钥模长
	* @param pkExponent	公钥指数
	* @return
	* 			返回 {@link Recv} 对象
	* 			获取响应信息：
	* <blockquote>
	* 			{@link Recv#getResponseCode()}	:	响应码<br>
	* 			{@link Recv#getResponseRemark()}	:	响应描述<br>
	* </blockquote>
	*/
	public Recv servT007(String termType, String deviceId, String factoryId, String organization, String pkMLenth, String pkExponent) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			* userInfo、sysID、appID可供用户自定
			* userInfo: 不指定则由API自动生成；
			* sysID、appID: 不指定则采用配置文件中的设定
			*/
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if((ret=api.start("T007", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("deviceId", deviceId)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("factoryId", factoryId)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("organization", organization)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("pkMLenth", pkMLenth)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("pkExponent", pkExponent)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if(ret!=0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	
	/**
	* T008	获取认证码（注册终端）
	* @param termType	终端类型
	* @param deviceId	终端编号
	* @param factoryId	厂商编号
	* @param organization	机构编号
	* @param pkMLenth	公钥模长
	* @param authCodeLen	认证码长度
	* @param authCodeType	认证码复杂度
	* @param pkExponent	公钥指数
	* @return
	* 			返回 {@link Recv} 对象
	* 			获取响应信息：
	* <blockquote>
	* 			{@link Recv#getResponseCode()}	:	响应码<br>
	* 			{@link Recv#getResponseRemark()}	:	响应描述<br>
	* 			{@link Recv#getAuthCode()}	:	认证码<br>
	* </blockquote>
	*/
	public Recv servT008(String termType, String deviceId, String factoryId,
			String organization, String pkMLenth, String authCodeLen,
			String authCodeType, String pkExponent) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			* userInfo、sysID、appID可供用户自定
			* userInfo: 不指定则由API自动生成；
			* sysID、appID: 不指定则采用配置文件中的设定
			*/
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if((ret=api.start("T008", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("deviceId", deviceId)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("factoryId", factoryId)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("organization", organization)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("pkMLenth", pkMLenth)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("authCodeLen", authCodeLen)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("authCodeType", authCodeType)) != 0)
				recv.setResponseCode(ret);
			if((ret =api.setString("pkExponent", pkExponent)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if(ret!=0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setAuthCode(api.getByte("authCode"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	
	
	//该类用于接收报文响应域，由客户跟进接口说明文档自行定义
	public static class Recv{
		private final Map<String, String> strings = new HashMap<String, String>();
		private final Map<String, byte[]> bytes = new HashMap<String, byte[]>();
		private final Map<String, Integer> integers = new HashMap<String, Integer>();
		

		public byte[] getAuthCode() {
			return bytes.get("authCode");
		}

		public void setAuthCode(byte[] authCode) {
			bytes.put("authCode", authCode);
		}
		
		
		public String getPk() {
			return strings.get("pk");
		}

		public void setPk(String pk) {
			strings.put("pk", pk);
		}
		
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
		public String getZMKName() {
			return strings.get("ZMKName");
		}

		public void setZMKName(String ZMKName) {
			strings.put("ZMKName", ZMKName);
		}
		public String getKeyName() {
			return strings.get("keyName");
		}

		public void setKeyName(String keyName) {
			strings.put("keyName", keyName);
		}
		public String getKeyValue() {
			return strings.get("keyValue");
		}

		public void setKeyValue(String keyValue) {
			strings.put("keyValue", keyValue);
		}
		public String getKeyValue2() {
			return strings.get("keyValue2");
		}

		public void setKeyValue2(String keyValue2) {
			strings.put("keyValue2", keyValue2);
		}
		public String getCheckValue() {
			return strings.get("checkValue");
		}

		public void setCheckValue(String checkValue) {
			strings.put("checkValue", checkValue);
		}
		
		public byte[] getKeyNameOne() {
			return bytes.get("keyName");
		}

		public void setKeyName(byte[] keyName) {
			bytes.put("keyName", keyName);
		}
		public byte[] getKeyValueOne() {
			return bytes.get("keyValue");
		}

		public void setKeyValue(byte[] keyValue) {
			bytes.put("keyValue", keyValue);
		}
		public byte[] getCheckValueOne() {
			return bytes.get("checkValue");
		}

		public void setCheckValue(byte[] checkValue) {
			bytes.put("checkValue", checkValue);
		}

		
		public static Recv failed(Exception e) {
			final Recv recv = new Recv();
			recv.setResponseCode(-1);
			recv.setResponseRemark(e.getMessage());
			return recv;
		}
	}
}

