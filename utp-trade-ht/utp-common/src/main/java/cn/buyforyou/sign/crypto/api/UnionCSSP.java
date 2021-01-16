package cn.buyforyou.sign.crypto.api;

import com.union.error.UnionError;
import com.union.utils.Base64;
import com.union.utils.Hex;
import com.union.utils.UnionAPI;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UnionCSSP {

	/**
	 * E100 测试密码机状态
	 * 
	 * @param mode
	 *            模式
	 * @param hsmIP
	 *            密码机IP
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getFaildList()} : 探测失败密码机IP列表<br>
	 *         </blockquote>
	 */
	public Recv servE100(String mode, String hsmIP) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E100", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hsmIP", hsmIP)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setFaildList(api.getString("faildList"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E101 执行密码机指令
	 * 
	 * @param hsmCmdReq
	 *            请求指令
	 * @param ascFlag
	 *            编码标识
	 * @param lenOfMsgHead
	 *            消息头长度
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getHsmCmdRes()} : 响应指令<br>
	 *         </blockquote>
	 */
	public Recv servE101(String hsmCmdReq, String ascFlag, String lenOfMsgHead) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E101", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hsmCmdReq", hsmCmdReq)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("ascFlag", ascFlag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setHsmCmdRes(api.getString("hsmCmdRes"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E142 转加密PIN
	 * 
	 * @param pinBlock
	 *            PIN密文
	 * @param zmkKeyName
	 *            源密钥保护密钥
	 * @param keyName1
	 *            源密钥名称
	 * @param keyName2
	 *            目的密钥名称
	 * @param accNo1
	 *            源账号
	 * @param accNo2
	 *            目的账号
	 * @param format1
	 *            源PIN格式
	 * @param format2
	 *            目的PIN格式
	 * @param checkFlag
	 *            检验标识
	 * @param checkData
	 *            PIN校验数据
	 * @param decimalFlag
	 *            十进制转换标识
	 * @param decimalTable
	 *            十进制转换表
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinBlock()} : PIN密文<br>
	 *         {@link Recv#getPinOffset()} : PIN Offset<br>
	 *         {@link Recv#getCheckData()} : PIN校验数据<br>
	 *         {@link Recv#getDecimalTable()} : 十进制转换表<br>
	 *         </blockquote>
	 */
	public Recv servE142(String pinBlock, byte[] zmkKeyName, byte[] keyName1, byte[] keyName2, byte[] accNo1,
			byte[] accNo2, int format1, int format2, int checkFlag, byte[] checkData, int decimalFlag,
			String decimalTable) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E142", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("zmkKeyName", zmkKeyName, zmkKeyName.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("keyName1", keyName1, keyName1.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("keyName2", keyName2, keyName2.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("accNo1", accNo1, accNo1.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("accNo2", accNo2, accNo2.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("format1", format1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("format2", format2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("checkFlag", checkFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("checkData", checkData, checkData.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("decimalFlag", decimalFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("decimalTable", decimalTable)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinBlock(api.getString("pinBlock"));
			recv.setPinOffset(api.getString("pinOffset") == null ? "" : api.getString("checkValue"));
			recv.setCheckData(api.getByte("checkData") == null ? "" : api.getString("checkValue"));
			recv.setDecimalTable(api.getString("decimalTable"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E112 导入对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param keyValue
	 *            密钥密文
	 * @param checkValue
	 *            密钥校验值
	 * @param protectFlag
	 *            保护方式
	 * @param protectKey
	 *            保护密钥
	 * @param activeDate
	 *            生效日期
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCheckValue()} : 密钥校验值<br>
	 *         </blockquote>
	 */
	public Recv servE112(String keyName, String keyValue, String checkValue, String protectFlag, String protectKey,
			String activeDate) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E112", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkValue", checkValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectFlag", protectFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectKey", protectKey)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if ("".equals(checkValue)) {
				recv.setCheckValue(api.getString("checkValue") == null ? "" : api.getString("checkValue"));
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E111 更新对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式
	 * @param exportFlag
	 *            输出标识
	 * @param exportLmkKey
	 *            输出标识
	 * @param protectKey
	 *            保护密钥
	 * @param activeDate
	 *            生效日期
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyValue()} : 密钥密文<br>
	 *         {@link Recv#getCheckValue()} : 密钥校验值<br>
	 *         {@link Recv#getKeyValue2()} : 密钥密文<br>
	 *         </blockquote>
	 */
	public Recv servE111(String keyName, String mode, String exportFlag, String exportLmkKey, String protectKey,
			String activeDate) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E111", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportLmkKey", exportLmkKey)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectKey", protectKey)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyValue(api.getString("keyValue"));
			recv.setCheckValue(api.getString("checkValue"));
			if ("1".equals(exportLmkKey)) {
				recv.setKeyValue2(api.getString("keyValue2") == null ? "" : api.getString("keyValue2"));
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E110 生成对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param keyGroup
	 *            密钥组
	 * @param algorithmID
	 *            算法标识
	 * @param keyType
	 *            密钥类型
	 * @param keyLen
	 *            密钥长度
	 * @param updateKeyFlag
	 *            更新密钥标识
	 * @param oldVersionKeyIsUsed
	 *            允许使用旧密钥
	 * @param inputFlag
	 *            允许导入标识
	 * @param outputFlag
	 *            允许导出标识
	 * @param effectiveDays
	 *            有效天数
	 * @param enabled
	 *            启用标识
	 * @param activeDate
	 *            生效日期
	 * @param keyApplyPlatform
	 *            密钥申请平台
	 * @param keyDistributePlatform
	 *            密钥分发平台
	 * @param mode
	 *            模式
	 * @param exportFlag
	 *            输出标识
	 * @param exportLmkKey
	 *            输出标识
	 * @param protectKey
	 *            保护密钥
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyValue()} : 密钥密文<br>
	 *         {@link Recv#getCheckValue()} : 密钥校验值<br>
	 *         {@link Recv#getKeyValue2()} : 密钥密文<br>
	 *         </blockquote>
	 */
	public Recv servE110(String keyName, String keyGroup, String algorithmID, String keyType, String keyLen,
			String updateKeyFlag, String oldVersionKeyIsUsed, String inputFlag, String outputFlag, String effectiveDays,
			String enabled, String activeDate, String keyApplyPlatform, String keyDistributePlatform, String mode,
			String exportFlag, String exportLmkKey, String protectKey) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E110", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyGroup", keyGroup)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyLen", keyLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("updateKeyFlag", updateKeyFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oldVersionKeyIsUsed", oldVersionKeyIsUsed)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inputFlag", inputFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outputFlag", outputFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("effectiveDays", effectiveDays)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("enabled", enabled)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyApplyPlatform", keyApplyPlatform)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyDistributePlatform", keyDistributePlatform)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportLmkKey", exportLmkKey)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectKey", protectKey)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if ("1".equals(mode) && "1".equals(outputFlag) || "1".equals(exportFlag) || "2".equals(exportFlag)
					|| "3".equals(exportFlag)) {
				recv.setKeyValue(api.getString("keyValue"));
				recv.setCheckValue(api.getString("checkValue"));
			}
			if ("1".equals(exportLmkKey)) {
				recv.setKeyValue2(api.getString("keyValue2") == null ? "" : api.getString("keyValue2"));
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E113 导出对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param protectFlag
	 *            保护方式
	 * @param exportLmkKey
	 *            输出标识
	 * @param protectKey
	 *            保护密钥
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyValue()} : 密钥密文<br>
	 *         {@link Recv#getCheckValue()} : 密钥校验值<br>
	 *         {@link Recv#getKeyValue2()} : 密钥密文<br>
	 *         </blockquote>
	 */
	public Recv servE113(String keyName, String protectFlag, String exportLmkKey, String protectKey) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E113", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectFlag", protectFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportLmkKey", exportLmkKey)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectKey", protectKey)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyValue(api.getString("keyValue"));
			recv.setCheckValue(api.getString("checkValue"));
			// if("1".equals(exportLmkKey)) {
			recv.setKeyValue2(api.getString("keyValue2"));
			// }
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E114 申请对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE114(String keyName, String mode) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E114", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E115 分发对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE115(String keyName, String mode) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E115", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E116 销毁对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE116(String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E116", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E117 获取对称密钥信息
	 * 
	 * @param keyName
	 *            密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyGroup ()} : 密钥组<br>
	 *         {@link Recv#getAlgorithmID()} : 算法标识<br>
	 *         {@link Recv#getKeyType()} : 密钥类型<br>
	 *         {@link Recv#getKeyLen()} : 密钥长度<br>
	 *         {@link Recv#getOldVersionKeyIsUsed()} : 允许使用旧密钥<br>
	 *         {@link Recv#getInputFlag()} : 允许导入标识<br>
	 *         {@link Recv#getOutputFlag()} : 允许导出标识<br>
	 *         {@link Recv#getEffectiveDays()} : 有效天数<br>
	 *         {@link Recv#getActiveDate()} : 生效日期<br>
	 *         {@link Recv#getStatus()} : 状态<br>
	 *         {@link Recv#getCreatorType()} : 创建者类型<br>
	 *         {@link Recv#getCreator()} : 创建者<br>
	 *         {@link Recv#getCreateTime()} : 创建时间<br>
	 *         {@link Recv#getKeyUpdateTime()} : 密钥更新时间<br>
	 *         {@link Recv#getKeyApplyPlatform()} : 密钥申请平台<br>
	 *         {@link Recv#getKeyDistributePlatform()} : 密钥分发平台<br>
	 *         {@link Recv#getUsingUnit()} : 使用单位<br>
	 *         {@link Recv#getRemark()} : 备注<br>
	 *         </blockquote>
	 */
	public Recv servE117(String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E117", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyGroup(api.getString("keyGroup"));
			recv.setAlgorithmID(api.getString("algorithmID"));
			recv.setKeyType(api.getString("keyType"));
			recv.setKeyLen(api.getInteger("keyLen"));
			recv.setOldVersionKeyIsUsed(api.getString("oldVersionKeyIsUsed"));
			recv.setInputFlag(api.getString("inputFlag"));
			recv.setOutputFlag(api.getString("outputFlag"));
			recv.setEffectiveDays(api.getString("effectiveDays"));
			recv.setActiveDate(api.getString("activeDate"));
			recv.setStatus(api.getString("status"));
			recv.setCreatorType(api.getString("creatorType"));
			recv.setCreator(api.getString("creator"));
			recv.setCreateTime(api.getString("createTime"));
			recv.setKeyUpdateTime(api.getString("keyUpdateTime"));
			recv.setKeyApplyPlatform(api.getString("keyApplyPlatform"));
			recv.setKeyDistributePlatform(api.getString("keyDistributePlatform"));
			recv.setUsingUnit(api.getString("usingUnit"));
			recv.setRemark(api.getString("remark"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E118 打印对称密钥
	 * 
	 * @param mode
	 *            打印模式
	 * @param keyName
	 *            密钥名称
	 * @param algorithmID
	 *            算法标识
	 * @param keyLen
	 *            密钥长度
	 * @param keyType
	 *            密钥类型
	 * @param hsmIP
	 *            密码机IP
	 * @param numOfComponent
	 *            分量数量
	 * @param formatName
	 *            打印格式名称
	 * @param appendPrintNum
	 *            附加打印数量
	 * @param appendPrintParam1
	 *            附加打印参数值
	 * @param appendPrintParam2
	 *            附加打印参数值
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE118(String mode, String keyName, String algorithmID, int keyLen, String keyType, String hsmIP,
			int numOfComponent, String formatName, String appendPrintNum, String appendPrintParam1,
			String appendPrintParam2) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E118", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("keyLen", keyLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hsmIP", hsmIP)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("numOfComponent", numOfComponent)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("formatName", formatName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("appendPrintNum", appendPrintNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("appendPrintParam1", appendPrintParam1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("appendPrintParam2", appendPrintParam2)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E119 启用、挂起对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE119(String keyName, String mode) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E119", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E11A 密钥回退
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param flag
	 *            Flag标识
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE11A(String keyName, int flag) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E11A", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("flag", flag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E11B 约定传输密钥
	 * 
	 * @param branchNo
	 *            分行号
	 * @param rsaPKValue
	 *            rsa公钥值
	 * @param sm2PKValue
	 *            sm2公钥值
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getDesKeyByPK()} : rsa加密的密钥值<br>
	 *         {@link Recv#getDesCheckValue()} : rsa加密的校验值<br>
	 *         </blockquote>
	 */
	public Recv servE11B(String branchNo, String rsaPKValue, String sm2PKValue) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E11B", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("branchNo", branchNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("rsaPKValue", rsaPKValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sm2PKValue", sm2PKValue)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setDesKeyByPK(api.getString("desKeyByPK"));
			recv.setSm4KeyByPK(api.getString("sm4KeyByPK"));
			recv.setSm4CheckValue(api.getString("sm4CheckValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E120 生成非对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param keyGroup
	 *            密钥组
	 * @param algorithmID
	 *            算法标识
	 * @param keyType
	 *            密钥类型
	 * @param pkExponent
	 *            公钥指数
	 * @param keyLen
	 *            密钥长度
	 * @param updateKeyFlag
	 *            更新密钥标识
	 * @param vkStoreLocation
	 *            私钥存储位置
	 * @param hsmGroupID
	 *            密码机组名
	 * @param vkIndex
	 *            私钥索引
	 * @param oldVersionKeyIsUsed
	 *            允许使用旧密钥
	 * @param mode
	 *            模式
	 * @param inputFlag
	 *            私钥允许导入标识
	 * @param outputFlag
	 *            私钥允许导出标识
	 * @param exportFlag
	 *            私钥输出标识
	 * @param effectiveDays
	 *            有效天数
	 * @param enabled
	 *            启用标识
	 * @param activeDate
	 *            生效日期
	 * @param keyApplyPlatform
	 *            密钥申请平台
	 * @param keyDistributePlatform
	 *            密钥分发平台
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPkValue()} : 公钥值<br>
	 *         {@link Recv#getVkValue()} : 私钥值<br>
	 *         </blockquote>
	 */
	public Recv servE120(String keyName, String keyGroup, String algorithmID, String keyType, String pkExponent,
			int keyLen, String updateKeyFlag, String vkStoreLocation, String hsmGroupID, String vkIndex,
			String oldVersionKeyIsUsed, String mode, String inputFlag, String outputFlag, String exportFlag,
			String effectiveDays, String enabled, String activeDate, String keyApplyPlatform,
			String keyDistributePlatform) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E120", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyGroup", keyGroup)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkExponent", pkExponent)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("keyLen", keyLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("updateKeyFlag", updateKeyFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkStoreLocation", vkStoreLocation)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hsmGroupID", hsmGroupID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkIndex", vkIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oldVersionKeyIsUsed", oldVersionKeyIsUsed)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inputFlag", inputFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outputFlag", outputFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("effectiveDays", effectiveDays)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("enabled", enabled)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyApplyPlatform", keyApplyPlatform)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyDistributePlatform", keyDistributePlatform)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPkValue(api.getString("pkValue"));
			recv.setVkValue(api.getString("vkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E121 更新非对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式
	 * @param exportFlag
	 *            私钥输出标识
	 * @param activeDate
	 *            生效日期
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPkValue()} : 公钥值<br>
	 *         {@link Recv#getVkValue()} : 私钥值<br>
	 *         </blockquote>
	 */
	public Recv servE121(String keyName, String mode, String exportFlag, String activeDate) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E121", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPkValue(api.getString("pkValue"));
			recv.setVkValue(api.getString("vkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E122 导入公钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param format
	 *            公钥编码格式
	 * @param pkValue
	 *            公钥
	 * @param activeDate
	 *            生效日期
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE122(String keyName, String format, String pkValue, String activeDate) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E122", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkValue", pkValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E123 导出公钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPkValue()} : 公钥<br>
	 *         </blockquote>
	 */
	public Recv servE123(String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E123", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPkValue(api.getString("pkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E124 申请非对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE124(String keyName, String mode) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E124", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E125 分发非对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE125(String keyName, String mode) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E125", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E126 销毁非对称密钥
	 * 
	 * @param keyName
	 *            密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE126(String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E126", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E127 获取非对称密钥信息
	 * 
	 * @param keyName
	 *            密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyGroup()} : 密钥组<br>
	 *         {@link Recv#getAlgorithmID()} : 算法标识<br>
	 *         {@link Recv#getKeyType()} : 密钥类型<br>
	 *         {@link Recv#getPkExponent()} : 公钥指数<br>
	 *         {@link Recv#getKeyLen()} : 密钥长度<br>
	 *         {@link Recv#getVkStoreLocation()} : 私钥存储位置<br>
	 *         {@link Recv#getVkIndex()} : 私钥索引<br>
	 *         {@link Recv#getOldVersionKeyIsUsed()} : 允许使用旧密钥<br>
	 *         {@link Recv#getInputFlag()} : 私钥允许导入标识<br>
	 *         {@link Recv#getOutputFlag()} : 私钥允许导出标识<br>
	 *         {@link Recv#getKeyUpdateTime()} : 密钥更新时间<br>
	 *         {@link Recv#getEffectiveDays()} : 有效天数<br>
	 *         {@link Recv#getStatus()} : 状态<br>
	 *         {@link Recv#getActiveDate()} : 生效日期<br>
	 *         {@link Recv#getKeyApplyPlatform()} : 密钥申请平台<br>
	 *         {@link Recv#getKeyDistributePlatform()} : 密钥分发平台<br>
	 *         {@link Recv#getCreatorType()} : 创建者类型<br>
	 *         {@link Recv#getCreator()} : 创建者<br>
	 *         {@link Recv#getCreateTime()} : 创建时间<br>
	 *         {@link Recv#getOrganizationName()} : 组织<br>
	 *         {@link Recv#getRemark()} : 备注<br>
	 *         </blockquote>
	 */
	public Recv servE127(String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E127", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyGroup(api.getString("keyGroup"));
			recv.setAlgorithmID(api.getString("algorithmID"));
			recv.setKeyType(api.getString("keyType"));
			recv.setPkExponent(api.getString("pkExponent"));
			recv.setKeyLen(api.getInteger("keyLen"));
			recv.setVkStoreLocation(api.getString("vkStoreLocation"));
			recv.setVkIndex(api.getString("vkIndex"));
			recv.setOldVersionKeyIsUsed(api.getString("oldVersionKeyIsUsed"));
			recv.setInputFlag(api.getString("inputFlag"));
			recv.setOutputFlag(api.getString("outputFlag"));
			recv.setKeyUpdateTime(api.getString("keyUpdateTime"));
			recv.setEffectiveDays(api.getString("effectiveDays"));
			recv.setStatus(api.getString("status"));
			recv.setActiveDate(api.getString("activeDate"));
			recv.setKeyApplyPlatform(api.getString("keyApplyPlatform"));
			recv.setKeyDistributePlatform(api.getString("keyDistributePlatform"));
			recv.setCreatorType(api.getString("creatorType"));
			recv.setCreator(api.getString("creator"));
			recv.setCreateTime(api.getString("createTime"));
			recv.setOrganizationName(api.getString("organizationName"));
			recv.setRemark(api.getString("remark"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E130 获取非对称密钥信息
	 * 
	 * @param pinLen
	 *            PIN长度
	 * @param accNo
	 *            账号
	 * @param mode
	 *            模式
	 * @param pinOffset
	 *            PINOffset
	 * @param keyName
	 *            密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinBlock()} : PIN密文<br>
	 *         </blockquote>
	 */
	public Recv servE130(int pinLen, String accNo, String mode, String pinOffset, String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E130", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("pinLen", pinLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinOffset", pinOffset)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinBlock(api.getString("pinBlock"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E131 生成PVV
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param protectFlag
	 *            PIN保护方式
	 * @param pinBlock
	 *            PIN密文
	 * @param keyNameOfZPK
	 *            ZPK密钥名称
	 * @param accNo
	 *            账号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPVV()} : PVV<br>
	 *         </blockquote>
	 */
	public Recv servE131(String keyName, String protectFlag, String pinBlock, String keyNameOfZPK, String accNo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E131", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectFlag", protectFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyNameOfZPK", keyNameOfZPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPVV(api.getString("PVV"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E132 生成PIN Offset
	 * 
	 * @param userInfo
	 *            用户自定义信息(可选)
	 * @param keyName
	 *            PVK密钥名称
	 * @param pinBlock
	 *            PIN密文
	 * @param minPinLen
	 *            最小的PIN长度
	 * @param protectFlag
	 *            PIN保护方式
	 * @param keyNameOfZPK
	 *            ZPK密钥名称
	 * @param accNo
	 *            账号
	 * @param checkFlag
	 *            检验标识
	 * @param checkData1
	 *            PIN校验数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码
	 *         {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getPinOffset()}}
	 *         ：pinOffset {@link Recv#getCheckData2()}} ：PIN校验数据 </blockquote>
	 */
	public Recv servE132(String keyName, String pinBlock, int minPinLen, int protectFlag, String keyNameOfZPK,
			String accNo, int checkFlag, String checkData1) {

		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E132", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("minPinLen", minPinLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("protectFlag", protectFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyNameOfZPK", keyNameOfZPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("checkFlag", checkFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkData", checkData1)) != 0)
				recv.setResponseCode(ret);
			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setPinOffset(api.getString("pinOffset"));
			recv.setCheckData(api.getString("checkData"));
			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E133 生成CVV
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param flag
	 *            CVN标志
	 * @param expirationDate
	 *            有效期
	 * @param serviceCode
	 *            服务代码
	 * @param accNo
	 *            账号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCVV()} : CVV<br>
	 *         </blockquote>
	 */
	public Recv servE133(String keyName, int flag, String expirationDate, String serviceCode, String accNo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E133", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("flag", flag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("expirationDate", expirationDate)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serviceCode", serviceCode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCVV(api.getString("CVV"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E140 加密PIN
	 * 
	 * @param plainPin
	 *            明文PIN
	 * @param isDigit
	 *            是否是数字PIN
	 * @param accNo
	 *            账号
	 * @param mode
	 *            模式
	 * @param format
	 *            格式
	 * @param keyName
	 *            ZPK密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinBlock()} : PIN密文<br>
	 *         </blockquote>
	 */
	public Recv servE140(String plainPin, String isDigit, String accNo, String mode, String format, String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E140", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("plainPin", plainPin)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("isDigit", isDigit)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinBlock(api.getString("pinBlock"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E141 解密PIN
	 * 
	 * @param pinBlock
	 *            PIN密文
	 * @param accNo
	 *            账号
	 * @param mode
	 *            模式
	 * @param keyName
	 *            ZPK密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPlainPin()} : PIN明文<br>
	 *         {@link Recv#getReferenceNumber()} : 参考数<br>
	 *         </blockquote>
	 */
	public Recv servE141(String pinBlock, String accNo, String mode, String format, String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E141", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPlainPin(api.getString("plainPin", ""));
			if ("09".equals(format)) {

			} else {
				recv.setReferenceNumber(api.getString("referenceNumber", ""));
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E142 转加密PIN
	 * 
	 * @param pinBlock
	 *            PIN密文
	 * @param zmkKeyName
	 *            源密钥保护密钥
	 * @param keyName1
	 *            源密钥名称
	 * @param keyName2
	 *            目的密钥名称
	 * @param accNo1
	 *            源账号
	 * @param accNo2
	 *            目的账号
	 * @param format1
	 *            源PIN格式
	 * @param format2
	 *            目的PIN格式
	 * @param checkFlag
	 *            检验标识
	 * @param checkData
	 *            PIN校验数据
	 * @param decimalFlag
	 *            十进制转换标识
	 * @param decimalTable
	 *            十进制转换表
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinBlock()} : PIN密文<br>
	 *         {@link Recv#getPinOffset()} : PIN Offset<br>
	 *         {@link Recv#getCheckData()} : PIN校验数据<br>
	 *         {@link Recv#getDecimalTable()} : 十进制转换表<br>
	 *         </blockquote>
	 */
	public Recv servE142(String pinBlock, String zmkKeyName, String keyName1, String keyName2, String accNo1,
			String accNo2, String format1, String format2, String checkFlag, String checkData, String decimalFlag,
			String decimalTable) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E142", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zmkKeyName", zmkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName1", keyName1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName2", keyName2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo1", accNo1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo2", accNo2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format1", format1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format2", format2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkFlag", checkFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkData", checkData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("decimalFlag", decimalFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("decimalTable", decimalTable)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinBlock(api.getString("pinBlock"));
			recv.setPinOffset(api.getString("pinOffset"));
			recv.setCheckData(api.getString("checkData"));
			recv.setDecimalTable(api.getString("decimalTable"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E143 验证PIN
	 * 
	 * @param pinBlock
	 *            PIN密文
	 * @param format
	 *            PIN格式
	 * @param keyName
	 *            密钥名称
	 * @param accNo
	 *            账号
	 * @param mode
	 *            模式
	 * @param keyNameOfPVK
	 *            PVK名称
	 * @param pinOffset
	 *            PIN Offset
	 * @param checkFlag
	 *            检验标识
	 * @param checkData
	 *            PIN校验数据
	 * @param PVV
	 *            PVV
	 * @param pinBlockByLMK
	 *            LMK加密的PIN密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE143(String pinBlock, String format, String keyName, String accNo, String mode, String keyNameOfPVK,
			String pinOffset, String checkFlag, String checkData, String PVV, String pinBlockByLMK) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E143", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyNameOfPVK", keyNameOfPVK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinOffset", pinOffset)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkFlag", checkFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkData", checkData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("PVV", PVV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlockByLMK", pinBlockByLMK)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E144 转加密PIN Offset
	 * 
	 * @param pinLen
	 *            PIN长度
	 * @param pinOffset
	 *            PIN Offset
	 * @param keyName1
	 *            源PVK密钥名称
	 * @param keyName2
	 *            目的PVK密钥名称
	 * @param accNo1
	 *            源账号
	 * @param accNo2
	 *            目的账号
	 * @param checkFlag1
	 *            检验标识
	 * @param checkData1
	 *            PIN校验数据
	 * @param checkFlag2
	 *            检验标识
	 * @param checkData2
	 *            PIN校验数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinOffset()} : pinOffset<br>
	 *         {@link Recv#getCheckData()} : PIN校验数据<br>
	 *         </blockquote>
	 */
	public Recv servE144(int pinLen, String pinOffset, String keyName1, String keyName2, String accNo1, String accNo2,
			String checkFlag1, String checkData1, String checkFlag2, String checkData2) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E144", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("pinLen", pinLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinOffset", pinOffset)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName1", keyName1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName2", keyName2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo1", accNo1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo2", accNo2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkFlag1", checkFlag1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkData1", checkData1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkFlag2", checkFlag2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkData2", checkData2)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinOffset(api.getString("pinOffset"));
			recv.setCheckData(api.getString("checkData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E145 验证CVV
	 * 
	 * @param CVV
	 *            CVV
	 * @param expirationDate
	 *            有效期
	 * @param serviceCode
	 *            服务代码
	 * @param accNo
	 *            账号
	 * @param keyName
	 *            CVK密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinOffset()} : pinOffset<br>
	 *         {@link Recv#getCheckData()} : PIN校验数据<br>
	 *         </blockquote>
	 */
	public Recv servE145(String CVV, String expirationDate, String serviceCode, String accNo, String keyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E145", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("CVV", CVV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("expirationDate", expirationDate)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serviceCode", serviceCode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinOffset(api.getString("pinOffset"));
			recv.setCheckData(api.getString("checkData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E146 将ZPK（DES和SM4）加密的pin转成SM2公钥加密
	 * 
	 * @param keyName
	 *            CVK密钥名称
	 * @param format
	 *            PIN格式
	 * @param accNo
	 *            账号
	 * @param pinBlock
	 *            ZPK加密的PIN
	 * @param SM2KeyName
	 *            公钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinByPK()} : 公钥加密的PIN密文<br>
	 *         </blockquote>
	 */
	public Recv servE146(String keyName, String format, String accNo, String pinBlock, String SM2KeyName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E146", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("SM2KeyName", SM2KeyName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinByPK(api.getString("pinByPK"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E148 SM4和DES pinBlock转成MD5和SM3，公钥加密的渠道密码转换成SM3/MD5
	 * 
	 * @param mode
	 *            模式
	 * @param keyName
	 *            密钥名称
	 * @param pinBlock
	 *            ZPK加密的PIN
	 * @param accNo
	 *            账号
	 * @param algorithmID
	 *            算法标识
	 * @param dataFillMode
	 *            数据补位方式
	 * @param saltedOffset
	 *            加盐偏移
	 * @param saltedData
	 *            加盐数据
	 * @param dataFillHead
	 *            前填充数据
	 * @param dataFillTail
	 *            后填充数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getHash()} : hash<br>
	 *         </blockquote>
	 */
	public Recv servE148(String mode, String keyName, String pinBlock, String accNo, String algorithmID,
			String dataFillMode, String saltedOffset, String saltedData, String dataFillHead, String dataFillTail) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E148", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillMode", dataFillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("saltedOffset", saltedOffset)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("saltedData", saltedData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillHead", dataFillHead)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillTail", dataFillTail)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setHash(api.getString("hash"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E149 弱密码检查(只支持交易密码)
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param format
	 *            pin块格式
	 * @param accNo
	 *            账号
	 * @param phoneNumber
	 *            手机号码
	 * @param identityCard
	 *            身份证号
	 * @param verifyData1
	 *            验证数据1
	 * @param verifyData2
	 *            验证数据2
	 * @param pinBlock
	 *            pin密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getResultFlag()} : 检查结果标识<br>
	 *         </blockquote>
	 */
	public Recv servE149(String keyName, String format, String accNo, String phoneNumber, String identityCard,
			String verifyData1, String verifyData2, String pinBlock) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E149", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("phoneNumber", phoneNumber)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("identityCard", identityCard)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("verifyData1", verifyData1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("verifyData2", verifyData2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setResultFlag(api.getString("resultFlag"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E14A ZPK加密的pin与zek加密的pin互转
	 * 
	 * @param zpkKeyName
	 *            ZPK密钥名称
	 * @param zekKeyName
	 *            ZEK密钥名称
	 * @param flag
	 *            模式
	 * @param encrypMode
	 *            密钥加密模式
	 * @param fillMode
	 *            加密数据填充格式
	 * @param pinBlock
	 *            PIN密文
	 * @param accNo
	 *            账号
	 * @param format
	 *            格式
	 * @param iv
	 *            初始向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE14A(String zpkKeyName, String zekKeyName, String flag, String encrypMode, String fillMode,
			String pinBlock, String accNo, String format, String iv) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E14A", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zpkKeyName", zpkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zekKeyName", zekKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("flag", flag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encrypMode", encrypMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E150 生成MAC
	 * 
	 * @param keyVersion
	 *            密钥版本
	 * @param mode
	 *            模式
	 * @param keyName
	 *            密钥名称
	 * @param keyValue
	 *            密钥密文
	 * @param algorithmID
	 *            算法标识
	 * @param fillMode
	 *            自动填充方式
	 * @param dataType
	 *            数据类型
	 * @param data
	 *            数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMac()} : MAC<br>
	 *         </blockquote>
	 */
	public Recv servE150(String keyVersion, String mode, String keyName, String keyValue, String algorithmID,
			String fillMode, String dataType, byte[] data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E150", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyVersion", keyVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMac(api.getString("mac"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E151 验证MAC
	 * 
	 * @param keyVersion
	 *            密钥版本
	 * @param mode
	 *            模式
	 * @param keyName
	 *            密钥名称
	 * @param keyValue
	 *            密钥密文
	 * @param algorithmID
	 *            算法标识
	 * @param fillMode
	 *            自动填充方式
	 * @param dataType
	 *            数据类型
	 * @param data
	 *            数据
	 * @param mac
	 *            MAC
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE151(String keyVersion, String mode, String keyName, String keyValue, String algorithmID,
			String fillMode, String dataType, byte[] data, String mac) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E151", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyVersion", keyVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mac", mac)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E152 验证并生成MAC
	 * 
	 * @param mode
	 *            模式
	 * @param keyName1
	 *            密钥名称1,用于验证mac
	 * @param keyValue1
	 *            密钥密文1
	 * @param keyName2
	 *            密钥名称2,用于生成mac
	 * @param keyValue2
	 *            密钥密文2
	 * @param algorithmID
	 *            算法标识
	 * @param fillMode
	 *            自动填充方式
	 * @param dataType
	 *            数据类型
	 * @param data
	 *            数据
	 * @param mac
	 *            待验证MAC
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMac()} : 新生成MAC<br>
	 *         </blockquote>
	 */
	public Recv servE152(String mode, String keyName1, String keyValue1, String keyName2, String keyValue2,
			String algorithmID, String fillMode, String dataType, String data, String mac) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E152", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName1", keyName1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue1", keyValue1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName2", keyName2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue2", keyValue2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mac", mac)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMac(api.getString("mac"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E160 加密数据
	 * 
	 * @param mode
	 *            模式
	 * @param keyName
	 *            密钥名称
	 * @param keyValue
	 *            密钥密文
	 * @param algorithmID
	 *            算法标识
	 * @param data
	 *            数据
	 * @param iv
	 *            初始向量
	 * @param format
	 *            密文数据格式
	 * @param dataType
	 *            数据类型
	 * @param separator
	 *            分隔符
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 密文数据<br>
	 *         </blockquote>
	 */
	public Recv servE160(String mode, String keyName, String keyValue, String algorithmID, byte[] data, String iv,
			String format, String dataType, String separator) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E160", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("separator", separator)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E161 解密数据
	 * 
	 * @param mode
	 *            模式
	 * @param keyName
	 *            密钥名称
	 * @param keyValue
	 *            密钥密文
	 * @param algorithmID
	 *            算法标识
	 * @param exportFlag
	 *            输出标识
	 * @param data
	 *            数据
	 * @param iv
	 *            初始向量
	 * @param format
	 *            密文数据格式
	 * @param separator
	 *            分隔符
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 密文数据<br>
	 *         </blockquote>
	 */
	public Recv servE161(String mode, String keyName, String keyValue, String algorithmID, String exportFlag,
			byte[] data, String iv, String format, String separator) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E161", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("separator", separator)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E162 RC4加解密数据
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param dataLen
	 *            数据长度
	 * @param data
	 *            待加密数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 加密数据<br>
	 *         </blockquote>
	 */
	public Recv servE162(String keyName, int dataLen, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E162", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataLen", dataLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E163 从ZEK加密转成另一把ZEK加密
	 * 
	 * @param zekKeyName1
	 *            ZEK1密钥名称
	 * @param cipherData
	 *            密文数据
	 * @param algorithmID
	 *            算法标志
	 * @param IV
	 *            初始向量
	 * @param dst_IV
	 *            目的初始向量
	 * @param format
	 *            密文数据格式
	 * @param zekKeyName2
	 *            ZEK2密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCipherData()} : 目的zek密钥加密的数据<br>
	 *         </blockquote>
	 */
	public Recv servE163(String zekKeyName1, String cipherData, String algorithmID, String IV, String dst_IV,
			String format, String zekKeyName2) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E163", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zekKeyName1", zekKeyName1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cipherData", cipherData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("IV", IV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dst_IV", dst_IV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zekKeyName2", zekKeyName2)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCipherData(api.getByte("cipherData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E164 将一把密钥加密的数据转换为另一把密钥加密（Y1 WF指令）
	 * 
	 * @param srcKeyName
	 *            源密钥名称
	 * @param srcMode
	 *            源加密算法
	 * @param dstKeyName
	 *            目的密钥名称
	 * @param dstMode
	 *            目的加密算法
	 * @param srcData
	 *            源数据
	 * @param iv_cbc
	 *            源算法初始向量
	 * @param iv_cbcDst
	 *            目的算法初始向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getDstData()} : 目的数据<br>
	 *         </blockquote>
	 */
	public Recv servE164(String srcKeyName, String srcMode, String dstKeyName, String dstMode, String srcData,
			String iv_cbc, String iv_cbcDst) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E164", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcKeyName", srcKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcMode", srcMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dstKeyName", dstKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dstMode", dstMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcData", srcData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv_cbc", iv_cbc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv_cbcDst", iv_cbcDst)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setDstData(api.getByte("dstData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E165 数字信封数据加密
	 * 
	 * @param keyName
	 *            非对称密钥名称
	 * @param algorithmID
	 *            数据加密算法标识
	 * @param iv
	 *            初始向量
	 * @param fillMode
	 *            数据填充方式
	 * @param dataType
	 *            数据类型
	 * @param data
	 *            待加密数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getEncryptData()} : 密文数据/ LMK加密的对称密钥+密钥校验值<br>
	 *         {@link Recv#getKeyByPK()} : 公钥加密的ZEk密钥<br>
	 *         </blockquote>
	 */
	public Recv servE165(String keyName, String algorithmID, String iv, String fillMode, String dataType, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E165", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setEncryptData(api.getString("encryptData"));
			recv.setKeyByPK(api.getString("keyByPK"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E166 数字信封数据解密
	 * 
	 * @param keyName
	 *            非对称密钥名称
	 * @param keyByPK
	 *            公钥加密的ZEk密钥
	 * @param algorithmID
	 *            数据加密算法标识
	 * @param iv
	 *            初始向量
	 * @param fillMode
	 *            数据填充方式
	 * @param dataType
	 *            数据类型
	 * @param exportFlag
	 *            输出标识
	 * @param encryptData
	 *            密文数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 明文数据<br>
	 *         </blockquote>
	 */
	public Recv servE166(String keyName, String keyByPK, String algorithmID, String iv, String fillMode,
			String dataType, String exportFlag, String encryptData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E166", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyByPK", keyByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encryptData", encryptData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E170 私钥签名
	 * 
	 * @param format
	 *            签名输出格式
	 * @param mode
	 *            输入模式
	 * @param keyName
	 *            密钥名称
	 * @param vkValue
	 *            私钥值
	 * @param dataFillMode
	 *            数据补位方式
	 * @param hashID
	 *            HASH算法标识
	 * @param userID
	 *            用户标识
	 * @param data
	 *            签名数据
	 * @param dataType
	 *            签名数据类型
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 签名<br>
	 *         </blockquote>
	 */
	public Recv servE170(String format, String mode, String keyName, String vkValue, String dataFillMode, String hashID,
			String userID, String data, String dataType) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E170", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkValue", vkValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillMode", dataFillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hashID", hashID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E171 公钥验签
	 * 
	 * @param mode
	 *            输入模式
	 * @param keyName
	 *            密钥名称
	 * @param pkValue
	 *            公钥
	 * @param algorithmID
	 *            算法标识
	 * @param pkExponent
	 *            公钥指数
	 * @param dataFillMode
	 *            数据补位方式
	 * @param hashID
	 *            HASH算法标识
	 * @param userID
	 *            用户标识
	 * @param data
	 *            签名数据
	 * @param dataType
	 *            签名数据类型
	 * @param sign
	 *            签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE171(String mode, String keyName, String pkValue, String algorithmID, String pkExponent,
			String dataFillMode, String hashID, String userID, String data, String dataType, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E171", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkValue", pkValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkExponent", pkExponent)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillMode", dataFillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hashID", hashID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E172 公钥加密
	 * 
	 * @param mode
	 *            输入模式
	 * @param keyName
	 *            密钥名称
	 * @param pkValue
	 *            公钥
	 * @param algorithmID
	 *            算法标识
	 * @param pkExponent
	 *            公钥指数
	 * @param dataFillMode
	 *            数据补位方式
	 * @param plainData
	 *            明文数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCipherData()} : 密文数据<br>
	 *         </blockquote>
	 */
	public Recv servE172(String mode, String keyName, String pkValue, String algorithmID, String pkExponent,
			String dataFillMode, String plainData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E172", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkValue", pkValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkExponent", pkExponent)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillMode", dataFillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("plainData", plainData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCipherData(api.getByte("cipherData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E173 私钥解密
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param cipherDataLen
	 *            密文数据长度
	 * @param algorithmID
	 *            算法标识
	 * @param vkIndex
	 *            私钥索引
	 * @param dataFillMode
	 *            公钥加密时采用的填充方式
	 * @param cipherData
	 *            密文数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPlainData()} : 明文数据<br>
	 *         </blockquote>
	 */
	public Recv servE173(String keyName, String cipherDataLen, String algorithmID, String vkIndex, String dataFillMode,
			String cipherData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E173", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cipherDataLen", cipherDataLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkIndex", vkIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillMode", dataFillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cipherData", cipherData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPlainData(api.getByte("plainData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E174 公钥加密的字符密码转ZPK/ZEK加密或摘要输出，支持密码复杂度检查
	 * 
	 * @param mode
	 *            输入模式
	 * @param pkName
	 *            非对称密钥名称
	 * @param keyName
	 *            对称密钥名称
	 * @param paddingFlag
	 *            填充方式
	 * @param complexity
	 *            字符密码复杂度
	 * @param minPinLen
	 *            最小PIN长度
	 * @param pinByPK
	 *            公钥加密的PIN密文
	 * @param hashFlag
	 *            公钥加密的PIN密文
	 * @param userID
	 *            用户标识
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinBlock()} : 对称密钥加密的密钥密文<br>
	 *         {@link Recv#getHash()} : Hash结果<br>
	 *         </blockquote>
	 */
	public Recv servE174(String mode, String pkName, String keyName, String paddingFlag, String complexity,
			String minPinLen, String pinByPK, String hashFlag, String userID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E174", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkName", pkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("paddingFlag", paddingFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("complexity", complexity)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("minPinLen", minPinLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hashFlag", hashFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinBlock(api.getString("pinBlock"));
			recv.setHash(api.getString("hash"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E175 将ZPK/ZEK加密的字符密码转换为摘要输出
	 * 
	 * @param keyName
	 *            对称密钥名称
	 * @param pinBlock
	 *            PIN密文
	 * @param hashFlag
	 *            摘要标识
	 * @param userID
	 *            用户ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getHash()} : Hash结果<br>
	 *         </blockquote>
	 */
	public Recv servE175(String keyName, String pinBlock, String hashFlag, String userID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E175", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hashFlag", hashFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setHash(api.getString("hash"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E180 计算数据摘要
	 * 
	 * @param data
	 *            摘要数据
	 * @param dataType
	 *            数据类型
	 * @param hashID
	 *            Hash算法标识
	 * @param mode 
	 *            SM3摘要模式
	 * @param pk 
	 *            公钥名称或密钥值
	 * @param userID
	 *            用户ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getDigest()} : 摘要<br>
	 *         </blockquote>
	 */
	public Recv servE180(String data, String dataType, String hashID, String mode, String pk, String userID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E180", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hashID", hashID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pk", pk)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setDigest(api.getString("digest"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E201 数字PIN转换(PK->ZPK)
	 * 
	 * @param pkName
	 *            公钥名称
	 * @param zpkKeyName
	 *            ZPK密钥名称
	 * @param accNo
	 *            账号
	 * @param pinByPK
	 *            公钥加密的PIN
	 * @param format 
	 *            PIN格式
	 * @param specialAlg 
	 *            专用算法标示
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinByZPK()} : ZPK加密的PIN<br>
	 *         </blockquote>
	 */
	public Recv servE201(String pkName, String zpkKeyName, String accNo, String pinByPK, String format,
			String specialAlg) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E201", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkKeyName", pkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zpkKeyName", zpkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("specialAlg", specialAlg)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinByZPK(api.getString("pinByZPK"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E202 字符PIN转换(PK->ZPK)
	 * 
	 * @param pkKeyName
	 *            公钥名称
	 * @param zpkKeyName
	 *            ZPK密钥名称
	 * @param specAlg
	 *            特殊算法标识
	 * @param accNo
	 *            账号
	 * @param pinByPK
	 *            公钥加密的PIN
	 * @param format
	 *            PIN格式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinByZPK()} : ZPK加密的PIN<br>
	 *         </blockquote>
	 */
	public Recv servE202(String pkKeyName, String zpkKeyName, String specAlg, String accNo, String pinByPK,
			String format) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E202", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkKeyName", pkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zpkKeyName", zpkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("specAlg", specAlg)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinByZPK(api.getString("pinByZPK"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E203 字符PIN转换(ZPK->ZPK)
	 * 
	 * @param pinBlock
	 *            PIN密文
	 * @param format1
	 *            源PIN格式
	 * @param format2
	 *            目的PIN格式
	 * @param accNo1
	 *            源账号
	 * @param accNo2
	 *            目的账号
	 * @param keyName1
	 *            源密钥名称
	 * @param keyName2
	 *            目的密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinBlock()} : PIN密文<br>
	 *         </blockquote>
	 */
	public Recv servE203(String pinBlock, String format1, String format2, String accNo1, String accNo2, String keyName1,
			String keyName2) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E203", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format1", format1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format2", format2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo1", accNo1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo2", accNo2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName1", keyName1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName2", keyName2)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinBlock(api.getString("pinBlock"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E204 带ID码返回(PK->ZPK)
	 * 
	 * @param pkKeyName
	 *            公钥名称
	 * @param zpkKeyName
	 *            ZPK密钥名称
	 * @param accNo
	 *            目的PIN格式
	 * @param pinByPK
	 *            公钥加密的PIN
	 * @param fillMode
	 *            用公钥加密PIN时所采用的PIN填充方式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinLen()} : 密码长度<br>
	 *         {@link Recv#getPinByZPK()} : ZPK加密的PIN<br>
	 *         {@link Recv#getPinByZPK2()} : <br>
	 *         {@link Recv#getIdLen()} : ID码长度<br>
	 *         {@link Recv#getUniqueID()} : ID码明文<br>
	 *         </blockquote>
	 */
	public Recv servE204(String pkKeyName, String zpkKeyName, String accNo, String pinByPK, String fillMode) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E204", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkKeyName", pkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zpkKeyName", zpkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinLen(api.getString("pinLen"));
			recv.setPinByZPK(api.getString("pinByZPK"));
			recv.setPinByZPK2(api.getString("pinByZPK2"));
			recv.setIdLen(api.getString("idLen"));
			recv.setUniqueID(api.getString("uniqueID"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E205 将PIN由X9.8转为特殊算法加密(zpk->zpk)
	 * 
	 * @param pinBlock
	 *            PIN密文
	 * @param accNo1
	 *            源账号
	 * @param accNo2
	 *            目的账号
	 * @param format1
	 *            原数据格式
	 * @param format2
	 *            目的数据格式
	 * @param keyName1
	 *            源密钥名称
	 * @param keyName2
	 *            目的密钥名称
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinBlock()} : PIN密文<br>
	 *         </blockquote>
	 */
	public Recv servE205(String pinBlock, String accNo1, String accNo2, String format1, String format2, String keyName1,
			String keyName2) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E205", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo1", accNo1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo2", accNo2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format1", format1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format2", format2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName1", keyName1)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName2", keyName2)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinBlock(api.getString("pinBlock"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E206 数字PIN转换，带ID码返回（pk->zpk）
	 * 
	 * @param pkKeyName
	 *            公钥名称
	 * @param vkIndex
	 *            私钥索引
	 * @param algorithmID
	 *            算法标识
	 * @param fillMode
	 *            填充模式
	 * @param zpkKeyName
	 *            ZPK密钥名称
	 * @param accNo
	 *            账号
	 * @param pinByPK
	 *            公钥加密的PIN
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinLen ()} : PIN长度<br>
	 *         {@link Recv#getPinByZPK()} : ZPK加密的PIN<br>
	 *         {@link Recv#getIdLen()} : ID码长度<br>
	 *         {@link Recv#getId()} : ID码明文<br>
	 *         </blockquote>
	 */
	public Recv servE206(String pkKeyName, String vkIndex, String algorithmID, String fillMode, String zpkKeyName,
			String accNo, String pinByPK) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E206", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkKeyName", pkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkIndex", vkIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zpkKeyName", zpkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinLen(api.getString("pinLen"));
			recv.setPinByZPK(api.getString("pinByZPK"));
			recv.setIdLen(api.getString("idLen"));
			recv.setId(api.getString("id"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E207 SM2公钥加密的PIN用SM2私钥解密后由SM4算法ZPK加密
	 * 
	 * @param mode
	 *            模式
	 * @param keyName
	 *            密钥名称
	 * @param vkIndex
	 *            私钥索引
	 * @param vkValue
	 *            私钥值
	 * @param dataFillMode
	 *            公钥加密填充模式
	 * @param pinFormat
	 *            Pin块格式
	 * @param pinByPK
	 *            公钥加密的pin
	 * @param zpkName
	 *            ZPK密钥名称
	 * @param accNo
	 *            账号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinByZPK ()} : zpk加密的pin<br>
	 *         {@link Recv#getPinLen()} : 密码长度<br>
	 *         {@link Recv#getUniqueID()} : ID码明文<br>
	 *         </blockquote>
	 */
	public Recv servE207(String mode, String keyName, String vkIndex, String vkValue, String dataFillMode,
			String pinFormat, String pinByPK, String zpkName, String accNo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E207", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkIndex", vkIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkValue", vkValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillMode", dataFillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinFormat", pinFormat)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zpkName", zpkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinByZPK(api.getString("pinByZPK"));
			if (mode == "3" || mode == "4") {
				recv.setPinLen(api.getString("pinLen"));
				recv.setUniqueID(api.getString("uniqueID"));
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E208 将私钥解密后的登录口令转换为网银的EDK加密
	 * 
	 * @param mode
	 *            外部送密钥标识
	 * @param fillMode
	 *            用公钥加密时所采用的填充方式
	 * @param rsaName
	 *            私钥钥名称
	 * @param edkName
	 *            加密edk密钥名称国密算法是，为MKAC类型
	 * @param pinByPK
	 *            公开密钥加密的PIN国密算法是，为被公钥加密的数据
	 * @param vkValue
	 *            外部送入的私钥
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinOffset ()} : PIN块国密算法是，为转加密后的数据<br>
	 *         </blockquote>
	 */
	public Recv servE208(String mode, String fillMode, String rsaName, String edkName, String pinByPK, String vkValue) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E208", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("rsaName", rsaName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("edkName", edkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkValue", vkValue)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinOffset(api.getString("pinOffset"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E209 E209公钥加密转DES加密（柳州银行6A指令）
	 * 
	 * @param pkKeyName
	 *            公钥名称
	 * @param fillMode
	 *            用公钥加密时所采用的填充方式
	 * @param pinByPK
	 *            公钥加密的PIN
	 * @param specialAlg
	 *            专用算法标示
	 * @param zekKeyName
	 *            zek密钥名称
	 * @param encrypMode
	 *            算法标示
	 * @param iv
	 *            初始向量
	 * @param format
	 *            数据填充方式(补位方式)
	 * @param dataPrefixLen
	 *            填充数据前缀长度
	 * @param dataPrefix
	 *            填充数据前缀
	 * @param dataSuffixLen
	 *            填充数据后缀长度
	 * @param dataSuffix
	 *            填充数据后缀
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinByZEK()} : Zek加密的pin密文<br>
	 *         {@link Recv#getComplexityOfPin()} : Pin密码复杂度<br>
	 *         </blockquote>
	 */
	public Recv servE209(String pkKeyName, String fillMode, String pinByPK, String specialAlg, String zekKeyName,
			String encrypMode, String IV, String format, String dataPrefixLen, String dataPrefix, String dataSuffixLen,
			String dataSuffix) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E209", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkKeyName", pkKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("specialAlg", specialAlg)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zekKeyName", zekKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encrypMode", encrypMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", IV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataPrefixLen", dataPrefixLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataPrefix", dataPrefix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataSuffixLen", dataSuffixLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataSuffix", dataSuffix)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if (specialAlg == "P") {
				recv.setPinByZEK(api.getString("pinByZEK", ""));
			}
			if (specialAlg == "Q") {
				recv.setComplexityOfPin(api.getString("complexityOfPin", ""));
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E210 SM2公钥加密的pin或渠道密码转换成zpk（DES和SM4）加密
	 * 
	 * @param keyName
	 *            SM2密钥名称
	 * @param pinByPK
	 *            公钥加密的密文
	 * @param zpkName
	 *            Zpk密钥名称
	 * @param mode
	 *            模式
	 * @param format
	 *            PIN格式
	 * @param accNo
	 *            账号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinByZPK ()} : ZPK加密的PIN/渠道密码<br>
	 *         </blockquote>
	 */
	public Recv servE210(String keyName, String pinByPK, String zpkName, String mode, String format, String accNo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E210", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinByPK", pinByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zpkName", zpkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinByZPK(api.getString("pinByZPK"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E211 互联网金融签名验签（完成验签需要发送两次报文，支持国际国密）
	 * 
	 * @param sendFlag
	 *            发送次数标识
	 * @param pkcs7Str
	 *            PKCS7签名
	 * @param data
	 *            签名数据
	 * @param pkValue
	 *            公钥
	 * @param sign
	 *            签名
	 * @param algorithmID
	 *            算法标识
	 * @param hashID
	 *            哈希标识
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPkValue ()} : 公钥<br>
	 *         {@link Recv#getSign()} : 签名<br>
	 *         {@link Recv#getHashID()} : 哈希标识<br>
	 *         {@link Recv#getAlgorithmID()} : 算法标识<br>
	 *         {@link Recv#getIssuserDN()} : 颁发者信息<br>
	 *         {@link Recv#getUserDN()} : 证书信息<br>
	 *         {@link Recv#getSerialNumber()} : 序列号<br>
	 *         {@link Recv#getRevokedFlag()} : 吊销标识<br>
	 *         </blockquote>
	 */
	public Recv servE211(String sendFlag, String pkcs7Str, String data, String pkValue, String sign, String algorithmID,
			String hashID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E211", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sendFlag", sendFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkcs7Str", pkcs7Str)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkValue", pkValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("hashID", hashID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPkValue(api.getString("pkValue"));
			recv.setSign(api.getString("sign"));
			recv.setHashID(api.getString("hashID"));
			recv.setAlgorithmID(api.getString("algorithmID"));
			recv.setIssuserDN(api.getString("issuserDN"));
			recv.setUserDN(api.getString("userDN"));
			recv.setSerialNumber(api.getString("serialNumber"));
			recv.setRevokedFlag(api.getString("revokedFlag"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E212 3.2.3 将SM2公钥加密的SM4密钥转化为LMK加密，解密SM4加密的数据
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param cipherData
	 *            公钥加密密钥的密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData ()} : 数据明文<br>
	 *         </blockquote>
	 */
	public Recv servE212(String keyName, String cipherData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E212", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cipherData", cipherData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E301 校验ARQC(525)
	 * 
	 * @param keyName
	 *            mk-ac密钥名称
	 * @param version
	 *            密钥的版本号
	 * @param pan
	 *            卡号或（卡号+卡序列号）
	 * @param atc
	 *            离散过程因子
	 * @param arqcData
	 *            计算ARQC使用的数据
	 * @param arqc
	 *            待验证的TC/ARQC/ACC
	 * @param iccType
	 *            Ic卡类型
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE301(String keyName, String version, String pan, String atc, String arqcData, String arqc,
			String iccType) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E301", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("version", version)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pan", pan)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("atc", atc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("arqcData", arqcData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("arqc", arqc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iccType", iccType)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E302 生成ARPC(526/529)
	 * 
	 * @param keyName
	 *            mk-ac密钥名称
	 * @param version
	 *            密钥的版本号
	 * @param pan
	 *            卡号或（卡号+卡序列号）
	 * @param atc
	 *            离散过程因子
	 * @param verifyArqc
	 *            是验证ARQC标识
	 * @param arqcData
	 *            计算ARQC使用的数据
	 * @param arqc
	 *            待验证的TC/ARQC/ACC
	 * @param iccType
	 *            Ic卡类型
	 * @param arc
	 *            授权响应码
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getArpc()} : ARPCs<br>
	 *         </blockquote>
	 */
	public Recv servE302(String keyName, String version, String pan, String atc, String verifyArqc, String arqcData,
			String arqc, String iccType, String arc) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E302", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("version", version)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pan", pan)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("atc", atc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("verifyArqc", verifyArqc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("arqcData", arqcData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("arqc", arqc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iccType", iccType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("arc", arc)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setArpc(api.getString("arpc"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E303 3.3.3 加密数据(527)
	 * 
	 * @param keyName
	 *            mk-ac密钥名称
	 * @param version
	 *            密钥的版本号
	 * @param pan
	 *            卡号或（卡号+卡序列号）
	 * @param atc
	 *            离散过程因子
	 * @param mode
	 *            加密模式
	 * @param iv
	 *            初始向量
	 * @param plainData
	 *            明文数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCiperData ()} : 密文数据<br>
	 *         </blockquote>
	 */
	public Recv servE303(String keyName, String version, String pan, String atc, String mode, String iv,
			String plainData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E303", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("version", version)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pan", pan)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("atc", atc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("plainData", plainData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCiperData(api.getByte("ciperData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E304 脚本数据计算MAC(528)
	 * 
	 * @param keyName
	 *            mk-ac密钥名称
	 * @param version
	 *            密钥的版本号
	 * @param pan
	 *            卡号或（卡号+卡序列号）
	 * @param atc
	 *            离散过程因子
	 * @param plainData
	 *            明文数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMac()} : MAC<br>
	 *         </blockquote>
	 */
	public Recv servE304(String keyName, String version, String pan, String atc, String plainData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E304", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("version", version)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pan", pan)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("atc", atc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("plainData", plainData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMac(api.getString("mac"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E401 生成本行报文
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param algFlag
	 *            签名算法
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 数字签名<br>
	 *         </blockquote>
	 */
	public Recv servE401(String pix, String bankID, String certVersion, String data, String algFlag) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E401", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algFlag", algFlag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E402 解析他行绑定报文
	 * 
	 * @param pix
	 *            应用ID
	 * @param mode
	 *            模式
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCertDN()} : 证书拥有者信息<br>
	 *         {@link Recv#getCertSN()} : 证书序列号<br>
	 *         {@link Recv#getCertEffdate()} : 证书起始时间<br>
	 *         {@link Recv#getCertInvdate()} : 证书结束时间<br>
	 *         {@link Recv#getCertBuf()} : 公钥证书<br>
	 *         </blockquote>
	 */
	public Recv servE402(String pix, String mode, String bankID, String certVersion, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E402", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCertDN(api.getString("certDN"));
			recv.setCertSN(api.getString("certSN"));
			recv.setCertEffdate(api.getString("certEffdate"));
			recv.setCertInvdate(api.getString("certInvdate"));
			recv.setCertBuf(api.getString("certBuf"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E403 数字签名加签
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param algFlag
	 *            签名算法
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 数字签名<br>
	 *         </blockquote>
	 */
	public Recv servE403(String pix, String bankID, String certVersion, String data, String algFlag) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E403", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algFlag", algFlag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E404 数字签名核签
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param sign
	 *            密钥离散次数(导入)
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE404(String pix, String bankID, String certVersion, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E404", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E405 解析他行绑定报文(不验证签名数据)
	 * 
	 * @param pix
	 *            应用ID
	 * @param mode
	 *            模式
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param sign
	 *            密钥离散次数(导入)
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE405(String pix, String mode, String bankID, String certVersion, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E405", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E40A 获取证书算法类型及公钥
	 * 
	 * @param algFlag
	 *            签名算法
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getHashID()} : Hash标识<br>
	 *         {@link Recv#getPkValue()} : 公钥值<br>
	 *         </blockquote>
	 */
	public Recv servE40A(String algFlag, String pix, String bankID, String certVersion) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E40A", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algFlag", algFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setHashID(api.getString("hashID"));
			recv.setPkValue(api.getString("pkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E406 证书导入（他行证书导入本行并保存到本行数据库）
	 * 
	 * @param BankID
	 *            参与行机构号
	 * @param Pkcs7Str
	 *            PKCS7签名(base64格式)
	 * @param Version
	 *            证书版本号
	 * @param SignatureData
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPk()} : 公钥<br>
	 *         {@link Recv#getCertActiveData()} : 证书生效日期<br>
	 *         {@link Recv#getCertEndData()} : 证书失效日期<br>
	 *         {@link Recv#getCertID()} : 证书序列号<br>
	 *         {@link Recv#getCertFileName()} : 证书名称<br>
	 *         </blockquote>
	 */
	public Recv servE406(String BankID, String Pkcs7Str, String Version, String SignatureData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E406", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("BankID", BankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("Pkcs7Str", Pkcs7Str)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("Version", Version)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("SignatureData", SignatureData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPk(api.getString("pk"));
			recv.setCertActiveData(api.getString("certActiveData"));
			recv.setCertEndData(api.getString("certEndData"));
			recv.setCertID(api.getString("certID"));
			recv.setCertFileName(api.getString("certFileName"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E407 证书导出（导出本行证书给他行使用）
	 * 
	 * @param VkIndex
	 *            私钥索引号
	 * @param UserID
	 *            用户ID号
	 * @param signatureData
	 *            原始签名数据
	 * @param BankID
	 *            参与行机构号
	 * @param Version
	 *            证书版本号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPkcs7Str()} : PKCS7签名(base64格式)<br>
	 *         </blockquote>
	 */
	public Recv servE407(String VkIndex, String UserID, String signatureData, String BankID, String Version) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E407", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("VkIndex", VkIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("UserID", UserID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("signatureData", signatureData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("BankID", BankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("Version", Version)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPkcs7Str(api.getString("pkcs7Str"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E408 E408 证书签名(使用本行证书进行数据签名)
	 * 
	 * @param VkIndex
	 *            私钥索引号
	 * @param UserID
	 *            用户ID号
	 * @param signatureData
	 *            原始签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getBase64Signature()} : 数字签名<br>
	 *         </blockquote>
	 */
	public Recv servE408(String VkIndex, String UserID, String signatureData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E408", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("VkIndex", VkIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("UserID", UserID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("signatureData", signatureData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setBase64Signature(api.getString("base64Signature"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E409 证书验签(使用他行证书进行数据验签)
	 * 
	 * @param BankID
	 *            参与行机构号
	 * @param Version
	 *            证书版本号
	 * @param UserID
	 *            用户ID号
	 * @param signatureData
	 *            原始签名数据
	 * @param Base64Sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getVerify_result()} : 验签结果<br>
	 *         </blockquote>
	 */
	public Recv servE409(String BankID, String Version, String UserID, String signatureData, String Base64Sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E409", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("BankID", BankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("Version", Version)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("UserID", UserID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("signatureData", signatureData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("Base64Sign", Base64Sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setVerify_result(api.getString("Verify_result"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E411 生成本行报文
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param algFlag
	 *            签名算法
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 数字签名<br>
	 *         </blockquote>
	 */
	public Recv servE411(String pix, String bankID, String certVersion, String data, String algFlag) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E411", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algFlag", algFlag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E412 解析他行绑定报文
	 * 
	 * @param pix
	 *            应用ID
	 * @param mode
	 *            模式
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCertDN()} : 证书拥有者信息<br>
	 *         {@link Recv#getCertSN()} : 证书序列号<br>
	 *         {@link Recv#getCertEffdate()} : 证书起始时间<br>
	 *         {@link Recv#getCertInvdate()} : 证书结束时间<br>
	 *         {@link Recv#getCertBuf()} : 公钥证书<br>
	 *         </blockquote>
	 */
	public Recv servE412(String pix, String mode, String bankID, String certVersion, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E412", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCertDN(api.getString("certDN"));
			recv.setCertSN(api.getString("certSN"));
			recv.setCertEffdate(api.getString("certEffdate"));
			recv.setCertInvdate(api.getString("certInvdate"));
			recv.setCertBuf(api.getString("certBuf"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E413 数字签名加签
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param algFlag
	 *            签名算法
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 数字签名<br>
	 *         </blockquote>
	 */
	public Recv servE413(String pix, String bankID, String certVersion, String data, String algFlag) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E413", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algFlag", algFlag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E414 数字签名核签
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE414(String pix, String bankID, String certVersion, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E414", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E416 加密文件
	 * 
	 * @param pkName
	 *            公钥名称
	 * @param vkName
	 *            私钥名称
	 * @param fileName
	 *            文件名
	 * @param version
	 *            加密数据版本号
	 * @param bankID
	 *            机构编号
	 * @param serverInfo
	 *            服务器信息
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE416(String pkName, String vkName, String fileName, String version, String bankID,
			String serverInfo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E416", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkName", pkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkName", vkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fileName", fileName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("version", version)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serverInfo", serverInfo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E417 解密文件
	 * 
	 * @param pkName
	 *            公钥名称
	 * @param vkName
	 *            私钥名称
	 * @param fileName
	 *            文件名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE417(String pkName, String vkName, String fileName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E417", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkName", pkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("vkName", vkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fileName", fileName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E501 签名
	 * 
	 * @param certID
	 *            应用ID
	 * @param data
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : PKCS7数字签名<br>
	 *         </blockquote>
	 */
	public Recv servE501(String certID, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E501", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certID", certID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E502 验签
	 * 
	 * @param certID
	 *            应用ID
	 * @param sign
	 *            PKCS7数字签名
	 * @param data
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE502(String certID, String sign, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E502", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certID", certID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E503 制作数字信封
	 * 
	 * @param certID
	 *            应用ID
	 * @param data
	 *            加密数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPkcs7Env()} : PKCS7加密数据信封<br>
	 *         </blockquote>
	 */
	public Recv servE503(String certID, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E503", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certID", certID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPkcs7Env(api.getString("pkcs7Env"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E504 解包数字信封
	 * 
	 * @param certID
	 *            应用ID
	 * @param pkcs7Env
	 *            PKCS7加密数据信封
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 明文数据<br>
	 *         </blockquote>
	 */
	public Recv servE504(String certID, String pkcs7Env) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E504", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certID", certID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkcs7Env", pkcs7Env)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E601 计算安全报文
	 * 
	 * @param mode
	 *            加密模式
	 * @param scheme
	 *            方案标志
	 * @param rootKeyName
	 *            根密钥名称
	 * @param rootDiscreteNum
	 *            根密钥离散次数
	 * @param rootDiscreteData
	 *            根密钥离散数据q
	 * @param pkType
	 *            保护密钥类型
	 * @param protectKeyName
	 *            保护密钥名称
	 * @param pkDiscreteNum
	 *            保护密钥离散次数
	 * @param pkDiscreteData
	 *            保护密钥离散数据
	 * @param sessionFlag
	 *            过程密钥标志
	 * @param sessionFactor
	 *            过程因子
	 * @param iv_cbc
	 *            IV-CBC
	 * @param encFillData
	 *            加密填充数据
	 * @param encFillOffset
	 *            加密填充偏移
	 * @param iv_mac
	 *            IV-MAC
	 * @param macFillData
	 *            MAC填充数据
	 * @param macFillOffset
	 *            MAC填充偏移
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMac()} : MAC<br>
	 *         {@link Recv#getData()} : 密钥密文<br>
	 *         </blockquote>
	 */
	public Recv servE601(String mode, String scheme, String rootKeyName, String rootDiscreteNum,
			String rootDiscreteData, String pkType, String protectKeyName, String pkDiscreteNum, String pkDiscreteData,
			String sessionFlag, String sessionFactor, String iv_cbc, String encFillData, String encFillOffset,
			String iv_mac, String macFillData, String macFillOffset) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E601", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("scheme", scheme)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("rootKeyName", rootKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("rootDiscreteNum", rootDiscreteNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("rootDiscreteData", rootDiscreteData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkType", pkType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectKeyName", protectKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkDiscreteNum", pkDiscreteNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkDiscreteData", pkDiscreteData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sessionFlag", sessionFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sessionFactor", sessionFactor)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv_cbc", iv_cbc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encFillData", encFillData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encFillOffset", encFillOffset)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv_mac", iv_mac)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("macFillData", macFillData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("macFillOffset", macFillOffset)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMac(api.getString("mac"));
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E602 使用离散密钥加解密数据或计算MAC
	 * 
	 * @param keyIndex
	 *            密钥索引
	 * @param keyName
	 *            密钥名称
	 * @param keyDiscreteData
	 *            密钥离散数据
	 * @param keyDiscreteNum
	 *            密钥离散次数
	 * @param algorithmID
	 *            过程密钥算法标志
	 * @param GC_Data
	 *            过程密钥离散数据
	 * @param encryptFlag
	 *            加密标志
	 * @param encryptAlgorithmID
	 *            加密算法选择
	 * @param macFlag
	 *            MAC 标志
	 * @param macAlgorithmID
	 *            MAC 算法选择
	 * @param data
	 *            报文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMac()} : MAC<br>
	 *         {@link Recv#getData()} : 报文密文/明文<br>
	 *         </blockquote>
	 */
	public Recv servE602(String keyIndex, String keyName, String keyDiscreteData, String keyDiscreteNum,
			String algorithmID, String GC_Data, String encryptFlag, String encryptAlgorithmID, String macFlag,
			String macAlgorithmID, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E602", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyIndex", keyIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyDiscreteData", keyDiscreteData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyDiscreteNum", keyDiscreteNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("GC_Data", GC_Data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encryptFlag", encryptFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encryptAlgorithmID", encryptAlgorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("macFlag", macFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("macAlgorithmID", macAlgorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMac(api.getString("mac"));
			recv.setData(api.getByte("data"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E603 使用离散密钥转加密PIN
	 * 
	 * @param inScheme
	 *            导入方案
	 * @param inGC_Data
	 *            过程数据（导入）
	 * @param inKeyFlag
	 *            导入密钥标志
	 * @param inKeyIndex
	 *            加密机内部导入密钥
	 * @param inKeyName
	 *            导入密钥名称
	 * @param inDiscreteNum
	 *            密钥离散次数(导入)
	 * @param inDiscreteData
	 *            密钥离散数据(导入)
	 * @param outScheme
	 *            导出方案
	 * @param outGC_Data
	 *            过程数据（导出）
	 * @param outKeyFlag
	 *            导出密钥标志
	 * @param outKeyIndex
	 *            加密机内部导出密钥
	 * @param outKeyName
	 *            导出密钥名称
	 * @param outDiscreteNum
	 *            密钥离散次数(导出)
	 * @param outDiscreteData
	 *            密钥离散数据（导出）
	 * @param oriAccNo
	 *            原账号
	 * @param desAccNo
	 *            目的账号
	 * @param oriPIN
	 *            源PIN块格式
	 * @param desPIN
	 *            目的PIN块格式
	 * @param accNo
	 *            目的全帐号
	 * @param oriPINBlock
	 *            源PINBLOCK
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getDesPINBlock()} : 目标PIN<br>
	 *         </blockquote>
	 */
	public Recv servE603(String inScheme, String inGC_Data, String inKeyFlag, String inKeyIndex, String inKeyName,
			String inDiscreteNum, String inDiscreteData, String outScheme, String outGC_Data, String outKeyFlag,
			String outKeyIndex, String outKeyName, String outDiscreteNum, String outDiscreteData, String oriAccNo,
			String desAccNo, String oriPIN, String desPIN, String accNo, String oriPINBlock) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E603", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inScheme", inScheme)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inGC_Data", inGC_Data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inKeyFlag", inKeyFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inKeyIndex", inKeyIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inKeyName", inKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inDiscreteNum", inDiscreteNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("inDiscreteData", inDiscreteData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outScheme", outScheme)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outGC_Data", outGC_Data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outKeyFlag", outKeyFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outKeyIndex", outKeyIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outKeyName", outKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outDiscreteNum", outDiscreteNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("outDiscreteData", outDiscreteData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oriAccNo", oriAccNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("desAccNo", desAccNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oriPIN", oriPIN)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("desPIN", desPIN)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oriPINBlock", oriPINBlock)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setDesPINBlock(api.getString("desPINBlock"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E701 下载终端公钥（对应T001）
	 * 
	 * @param termType
	 *            终端类型
	 * @param termID
	 *            终端号
	 * @param authCode
	 *            认证码
	 * @param keyPlatformID
	 *            TKMS系统ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPk()} : 公钥<br>
	 *         </blockquote>
	 */
	public Recv servE701(String termType, String termID, String authCode, String keyPlatformID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E701 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termID", termID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("authCode", authCode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyPlatformID", keyPlatformID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPk(api.getString("pk"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E702 初始化终端主密钥（对应T002）
	 * 
	 * @param termType
	 *            终端类型
	 * @param termID
	 *            终端号
	 * @param protectKey
	 *            保护密钥
	 * @param keyPlatformID
	 *            TKMS系统ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyName()} : 密钥名称<br>
	 *         {@link Recv#getKeyValue()} : 密钥密文<br>
	 *         {@link Recv#getCheckValue()} : 校验值<br>
	 *         </blockquote>
	 */
	public Recv servE702(String termType, String termID, String protectKey, String keyPlatformID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E702 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termID", termID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("protectKey", protectKey)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyPlatformID", keyPlatformID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyName(api.getString("keyName"));
			recv.setKeyValue(api.getString("keyValue"));
			recv.setCheckValue(api.getString("checkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E703 更新终端密钥（T003）
	 * 
	 * @param termType
	 *            终端类型
	 * @param termID
	 *            终端号
	 * @param keyType
	 *            密钥类型
	 * @param keyPlatformID
	 *            TKMS系统ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyName()} : 密钥名称<br>
	 *         {@link Recv#getKeyValue()} : 密钥密文<br>
	 *         {@link Recv#getCheckValue()} : 校验值<br>
	 *         </blockquote>
	 */
	public Recv servE703(String termType, String termID, String keyType, String keyPlatformID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E703 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termID", termID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyPlatformID", keyPlatformID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyName(api.getString("keyName"));
			recv.setKeyValue(api.getString("keyValue"));
			recv.setCheckValue(api.getString("checkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E704 终端在线转发报文（对应T020）
	 * 
	 * @param mode
	 *            转换模式
	 * @param oriTermType
	 *            原终端类型
	 * @param newTermType
	 *            目的终端类型
	 * @param oriTermID
	 *            原终端编号
	 * @param newTermID
	 *            目的终端编号
	 * @param factoryId
	 *            厂商编号
	 * @param organization
	 *            机构编号
	 * @param keyPlatformID
	 *            TKMS系统ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyName()} : 密钥名称<br>
	 *         {@link Recv#getKeyValue()} : 密钥密文<br>
	 *         {@link Recv#getCheckValue()} : 校验值<br>
	 *         </blockquote>
	 */
	public Recv servE704(String mode, String oriTermType, String newTermType, String oriTermID, String newTermID,
			String factoryId, String organization, String keyPlatformID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E704 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oriTermType", oriTermType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("newTermType", newTermType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oriTermID", oriTermID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("newTermID", newTermID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("factoryId", factoryId)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("organization", organization)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyPlatformID", keyPlatformID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyName(api.getString("keyName"));
			recv.setKeyValue(api.getString("keyValue"));
			recv.setCheckValue(api.getString("checkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E705 获取授权码（对应T005）
	 * 
	 * @param termType
	 *            终端类型
	 * @param termID
	 *            终端号
	 * @param authCodeLen
	 *            认证码长度
	 * @param authCodeType
	 *            证码复杂度
	 * @param keyPlatformID
	 *            TKMS系统ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getAuthCode()} : 远程密钥值<br>
	 *         </blockquote>
	 */
	public Recv servE705(String termType, String termID, String authCodeLen, String authCodeType,
			String keyPlatformID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E705 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termID", termID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("authCodeLen", authCodeLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("authCodeType", authCodeType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyPlatformID", keyPlatformID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setAuthCode(api.getString("authCode"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E707 增加终端（对应T007）
	 * 
	 * @param termType
	 *            终端类型
	 * @param factoryId
	 *            厂商编号
	 * @param deviceId
	 *            终端编号
	 * @param organization
	 *            机构编号
	 * @param keyPlatformID
	 *            TKMS系统ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servE707(String termType, String factoryId, String deviceId, String organization,
			String keyPlatformID) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E707", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("termType", termType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("factoryId", factoryId)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("deviceId", deviceId)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("organization", organization)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyPlatformID", keyPlatformID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * E801 根据离散数据生成MAC/TAC
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param keyIndex
	 *            密钥索引
	 * @param algorithmID
	 *            算法标识
	 * @param mode
	 *            模式
	 * @param discreteNum
	 *            离散次数
	 * @param discreteData
	 *            离散数据
	 * @param sessionData
	 *            过程数据
	 * @param data
	 *            数据
	 * @param IV
	 *            初始向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMac()} : Mac<br>
	 *         {@link Recv#getIcv()} : Icv<br>
	 *         </blockquote>
	 */
	public Recv servE801(String keyName, String keyIndex, String algorithmID, String mode, String discreteNum,
			String discreteData, String sessionData, String data, String IV) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E801", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyIndex", keyIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("discreteNum", discreteNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("discreteData", discreteData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sessionData", sessionData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("IV", IV)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMac(api.getString("mac"));
			recv.setIcv(api.getString("Icv"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E802 产生运通卡安全码
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式标识
	 * @param accNo
	 *            账号
	 * @param serviceCode
	 *            服务码
	 * @param activeDate
	 *            有效期
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMode()} : 模式标识<br>
	 *         {@link Recv#getSafeCodeFive()} : 5位卡安全码<br>
	 *         {@link Recv#getSafeCodeFour()} : 4位卡安全码<br>
	 *         {@link Recv#getSafeCodeThree()} : 3位卡安全码<br>
	 *         </blockquote>
	 */
	public Recv servE802(String keyName, String mode, String accNo, String serviceCode, String activeDate) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E802 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serviceCode", serviceCode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMode(api.getString("mode"));
			recv.setSafeCodeFive(api.getString("safeCodeFive"));
			recv.setSafeCodeFour(api.getString("safeCodeFour"));
			recv.setSafeCodeThree(api.getString("safeCodeThree"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E803 校验运通卡安全码
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param mode
	 *            模式标识
	 * @param accNo
	 *            账号
	 * @param serviceCode
	 *            服务码
	 * @param activeDate
	 *            有效期
	 * @param safeCodeFive
	 *            5位卡安全码
	 * @param safeCodeFour
	 *            4位卡安全码
	 * @param safeCodeThree
	 *            3位卡安全码
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMode()} : 模式标识<br>
	 *         {@link Recv#getCheckResult()} : 安全码校验结果<br>
	 *         </blockquote>
	 */
	public Recv servE803(String keyName, String mode, String accNo, String serviceCode, String activeDate,
			String safeCodeFive, String safeCodeFour, String safeCodeThree) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E803 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serviceCode", serviceCode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("activeDate", activeDate)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("safeCodeFive", safeCodeFive)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("safeCodeFour", safeCodeFour)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("safeCodeThree", safeCodeThree)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMode(api.getString("mode"));
			recv.setCheckResult(api.getString("checkResult"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E804 验证离散数据生成MAC/TAC
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param keyIndex
	 *            密钥索引
	 * @param algorithmID
	 *            算法标识
	 * @param mode
	 *            模式
	 * @param discreteNum
	 *            离散次数
	 * @param discreteData
	 *            离散数据
	 * @param sessionData
	 *            过程数据
	 * @param data
	 *            数据
	 * @param iv
	 *            初始向量
	 * @param mac
	 *            mac
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getMac()} : Mac<br>
	 *         </blockquote>
	 */
	public Recv servE804(String keyName, String keyIndex, String algorithmID, String mode, String discreteNum,
			String discreteData, String sessionData, String data, String iv, String mac) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E804 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyIndex", keyIndex)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("discreteNum", discreteNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("discreteData", discreteData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sessionData", sessionData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mac", mac)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setMac(api.getString("mac"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * E805 验证离散数据生成MAC/TAC
	 * 
	 * @param mode
	 *            模式
	 * @param keyName
	 *            主密钥名称
	 * @param pan
	 *            卡号或（卡号+卡序列号）
	 * @param trackData
	 * @param un
	 *            终端授权码
	 * @param atc
	 *            离散过程因子
	 * @param CVC3
	 *            CVC3
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCVC3()} : CVC3<br>
	 *         </blockquote>
	 */
	public Recv servE805(String mode, String keyName, String pan, String trackData, String un, String atc,
			String CVC3) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("E805 ", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pan", pan)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("trackData", trackData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("un", un)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("atc", atc)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("CVC3", CVC3)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCVC3(api.getString("CVC3"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA01 将密钥转加密为密码机主密钥加密
	 * 
	 * @param keyName
	 *            源密钥名称
	 * @param type
	 *            待加密的密钥类型
	 * @param mode
	 *            模式
	 * @param CipherText
	 *            kek加密的密钥密文
	 * @param IV
	 *            初始向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyCipherTextByLmk()} : LMK加密的密钥密文<br>
	 *         </blockquote>
	 */
	public Recv servEA01(String keyName, String type, String mode, String CipherText, String IV) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA01", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("type", type)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("CipherText", CipherText)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("IV", IV)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyCipherTextByLmk(api.getByte("keyCipherTextByLmk"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA02 申请KMC
	 * 
	 * @param flag
	 *            生成密钥标识
	 * @param keyName
	 *            密钥名称
	 * @param keyValue
	 *            密钥值
	 * @param masterkeyType
	 *            主密钥模板
	 * @param ChkeyType
	 *            子密钥模板
	 * @param algorithmID
	 *            算法标志
	 * @param data
	 *            离散数据
	 * @param GCdata
	 *            过程数据
	 * @param IV
	 *            初始化向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyValue()} : 离散后的密钥值<br>
	 *         </blockquote>
	 */
	public Recv servEA02(String flag, String keyName, String keyValue, String masterkeyType, String ChkeyType,
			String algorithmID, String data, String GCdata, String IV) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA02", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("flag", flag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("masterkeyType", masterkeyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("ChkeyType", ChkeyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("GCdata", GCdata)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("IV", IV)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyValue(api.getString("KeyValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA03 加密一个密钥
	 * 
	 * @param keyA
	 *            keyA的密钥密文
	 * @param typeA
	 *            keyA的密钥类型
	 * @param lenA
	 *            KeyA的长度
	 * @param mode
	 *            加密算法
	 * @param keyB
	 *            keyB的密钥密文
	 * @param typeB
	 *            keyB的密钥类型
	 * @param lenB
	 *            KeyB的长度
	 * @param IV
	 *            加密算法使用的初始向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyLen()} : 密钥长度<br>
	 *         {@link Recv#getDstkey()} : 加密后密钥密文<br>
	 *         </blockquote>
	 */
	public Recv servEA03(String keyA, String typeA, int lenA, String mode, String keyB, String typeB, int lenB,
			String IV) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA03", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyA", keyA)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("typeA", typeA)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("lenA", lenA)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyB", keyB)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("typeB", typeB)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("lenB", lenB)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("IV", IV)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyLen(api.getInteger("keyLen"));
			recv.setDstkey(api.getString("dstkey"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA04 将数据由KEK加密，转加密为B密钥加密
	 * 
	 * @param kekName
	 *            源密钥名称
	 * @param srcEncMode
	 *            源加密算法模式
	 * @param srcIV
	 *            初始向量
	 * @param keyBCipherTextByLmk
	 *            keyB的密钥密文
	 * @param keyBType
	 *            keyB的密钥类型
	 * @param dstEncMode
	 *            目的加密算法
	 * @param dstIV
	 *            目的加密算法使用的初始向量
	 * @param dataCipherTextBykek
	 *            kek加密的数据密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getDataCipherTextBykeyB()} : keyB加密的数据密文<br>
	 *         </blockquote>
	 */
	public Recv servEA04(String kekName, String srcEncMode, String srcIV, String keyBCipherTextByLmk, String keyBType,
			String dstEncMode, String dstIV, String dataCipherTextBykek) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA04", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("kekName", kekName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcEncMode", srcEncMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcIV", srcIV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyBCipherTextByLmk", keyBCipherTextByLmk)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyBType", keyBType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dstEncMode", dstEncMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dstIV", dstIV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataCipherTextBykek", dataCipherTextBykek)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setDataCipherTextBykeyB(api.getString("dataCipherTextBykeyB"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA05 对称密钥加密数据
	 * 
	 * @param keyName
	 *            加解密数据密钥的密钥名称
	 * @param keyCipherTextByLmk
	 *            key的密钥密文
	 * @param keyType
	 *            key的密钥类型
	 * @param Flag
	 *            加、解密标识
	 * @param Mode
	 *            数据加解密算法
	 * @param IV
	 *            初始向量
	 * @param srcData
	 *            待加解密的数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getDstData()} : 加解密后的数据<br>
	 *         </blockquote>
	 */
	public Recv servEA05(String keyName, String keyCipherTextByLmk, String keyType, String Flag, String Mode, String IV,
			String srcData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA05", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyCipherTextByLmk", keyCipherTextByLmk)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("Flag", Flag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("Mode", Mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("IV", IV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcData", srcData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setDstData(api.getByte("dstData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA06 将数据有KEK加密转为B密钥加密
	 * 
	 * @param keyName
	 *            源密钥名称
	 * @param DisperseTimes
	 *            源密钥离散次数
	 * @param DisperseData
	 *            源密钥离散数据
	 * @param keyName2
	 *            目的密钥名称
	 * @param DisperseTimes2
	 *            目的密钥离散次数
	 * @param DisperseData2
	 *            目的密钥离散数据
	 * @param ciperData
	 *            源密钥加密数据密文
	 * @param srcEncMode
	 *            源密钥加密算法
	 * @param srcIV
	 *            源加密算法初始向量
	 * @param dstEncMode
	 *            目的密钥加密算法
	 * @param dstIV
	 *            目的加密算法初始向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getDstCipher()} : 目的密钥加密的数据密文<br>
	 *         </blockquote>
	 */
	public Recv servEA06(String keyName, String DisperseTimes, String DisperseData, String keyName2,
			String DisperseTimes2, String DisperseData2, String ciperData, String srcEncMode, String srcIV,
			String dstEncMode, String dstIV) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA06", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("DisperseTimes", DisperseTimes)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("DisperseData", DisperseData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName2", keyName2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("DisperseTimes2", DisperseTimes2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("DisperseData2", DisperseData2)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("ciperData", ciperData)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcEncMode", srcEncMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("srcIV", srcIV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dstEncMode", dstEncMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dstIV", dstIV)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setDstCipher(api.getByte("dstCipher"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA10查询数字证书算法和公钥值
	 * 
	 * @param serialNum
	 *            证书序列号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码 <br>
	 *         {@link Recv#getResponseRemark()}} ：响应描述 <br>
	 *         {@link Recv#getAlgFlag()}} ：算法标识 <br>
	 *         {@link Recv#getPkValue()}} ：公钥值 </blockquote>
	 */
	public Recv servEA10(String serialNum) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA10", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serialNum", serialNum)) != 0)
				recv.setResponseCode(ret);
			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setAlgFlag(api.getInteger("algFlag"));
			recv.setPkValue(api.getString("pkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA11数字签名加签
	 * 
	 * @param serialNum
	 *            证书序列号
	 * @param data
	 *            待签名数据
	 * @param dataType
	 *            data数据类型
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码<br>
	 *         {@link Recv#getResponseRemark()}} ：响应描述<br>
	 *         {@link Recv#getSign()}} ：签名结果 </blockquote>
	 */
	public Recv servEA11(String serialNum, byte[] data, int dataType) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA11", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serialNum", serialNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataType", dataType)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA12数字签名核签
	 * 
	 * @param serialNum
	 *            证书序列号
	 * @param data
	 *            待签名数据
	 * @param dataType
	 *            data数据类型
	 * @param sign
	 *            签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码<br>
	 *         {@link Recv#getResponseRemark()}} ：响应描述 </blockquote>
	 */
	public Recv servEA12(String serialNum, byte[] data, int dataType, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA12", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serialNum", serialNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
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
	 * EA13公钥加密对称密钥
	 * 
	 * @param mode
	 *            密钥模式
	 * @param keyValue
	 *            密钥值
	 * @param keyType
	 *            密钥算法类型
	 * @param serialNum
	 *            证书序列号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码
	 *         {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getKeyByPK()} }
	 *         ：公钥加密的密钥密文<br>
	 *         {@link Recv#getKeyValue()}} ：密钥值 </blockquote>
	 */
	public Recv servEA13(int mode, String keyValue, String keyType, String serialNum) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA13", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serialNum", serialNum)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setKeyByPK(api.getString("keyByPK"));
			recv.setKeyValue(api.getString("keyValue"));
			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA14公钥加密的对称密钥转lmk加密
	 * 
	 * @param serialNum
	 *            证书序列号
	 * @param keyByPK
	 *            公钥加密的密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码
	 *         {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getKeyValue()}}
	 *         ：密钥密文<br>
	 *         {@link Recv#getKeyType()}} ：密钥类型 </blockquote>
	 */
	public Recv servEA14(String serialNum, String keyByPK) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA14", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serialNum", serialNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyByPK", keyByPK)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setKeyValue(api.getString("keyValue"));
			recv.setKeyType(api.getString("keyType"));
			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA15 数据加密
	 * 
	 * @param keyValue
	 *            密钥值
	 * @param keyType
	 *            密钥类型
	 * @param paddingFlag
	 *            填充标识
	 * @param data
	 *            待加密的数据
	 * @param dataType
	 *            data数据类型
	 * @param algorithmID
	 *            算法标识
	 * @param iv
	 *            iv向量
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码<br>
	 *         {@link Recv#getResponseRemark()}} ：响应描述<br>
	 *         {@link Recv#getData()}} ：数据密文 </blockquote>
	 */
	public Recv servEA15(String keyValue, String keyType, int paddingFlag, byte[] data, int dataType, int algorithmID,
			String iv) {

		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA15", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("paddingFlag", paddingFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setData(api.getByte("data"));
			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA16 数据解密
	 * 
	 * @param keyValue
	 *            密钥值
	 * @param keyType
	 *            密钥类型
	 * @param paddingFlag
	 *            填充标识
	 * @param data
	 *            密文数据
	 * @param exportFlag
	 *            输出明文数据标识
	 * @param algorithmID
	 *            算法标识
	 * @param iv
	 *            iv向量
	 * @return 返回 {@link Recv} 对象 获取响应信息：<br>
	 *         <blockquote> {@link Recv#getResponseCode()}} ：响应码<br>
	 *         {@link Recv#getResponseRemark()}} ：响应描述<br>
	 *         {@link Recv#getData()}} ：明文数据 </blockquote>
	 */
	public Recv servEA16(String keyValue, String keyType, int paddingFlag, String data, int exportFlag, int algorithmID,
			String iv) {

		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA16", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("paddingFlag", paddingFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setData(api.getByte("data"));
			api.end(); // 结束释放UnionAPI类中静态成员变量
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA17 网联接入数字信封加密
	 * 
	 * @param serialNum
	 *            证书序列号
	 * @param mode
	 *            密钥模式
	 * @param keyType
	 *            密钥类型
	 * @param keyValue
	 *            密钥密文
	 * @param data
	 *            明文数据
	 * @param dataLen
	 *            数据长度
	 * @param dataType
	 *            明文data数据类型
	 * @param separator
	 *            分隔符
	 * @param paddingFlag
	 *            填充标识
	 * @param exportFlag
	 *            输出密文数据标识
	 * @param keyByPKFormat
	 *            输出公钥加密的密钥密文编码格式
	 * @param algorithmID
	 *            算法标识
	 * @param iv
	 *            iv向量
	 * @return 返回 {@link Recv} 对象 获取响应信息：<br>
	 *         <blockquote> {@link Recv#getResponseCode()}} ：响应码
	 *         {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getKeyByPK()} }
	 *         ：公钥加密的密钥密文<br>
	 *         {@link Recv#getKeyValue()}} ：密钥密文<br>
	 *         {@link Recv#getData()}} ：密文数据 </blockquote>
	 */
	public Recv servEA17(String serialNum, int mode, String keyType, String keyValue, byte[] data, int dataLen,
			int dataType, byte[] separator, int paddingFlag, int exportFlag, int keyByPKFormat, int algorithmID,
			String iv) {

		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA17", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serialNum", serialNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyValue", keyValue)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataLen", dataLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("separator", separator, separator.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("paddingFlag", paddingFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("keyByPKFormat", keyByPKFormat)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setKeyByPK(api.getString("keyByPK"));
			recv.setKeyValue(api.getString("keyValue"));
			recv.setData(api.getByte("data"));
			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA18 网联接入数字信封解密
	 * 
	 * @param serialNum
	 *            证书序列号
	 * @param keyByPK
	 *            公钥加密的密钥密文
	 * @param keyByPKFormat
	 *            公钥加密的密钥密文数据编码格式
	 * @param data
	 *            密文数据
	 * @param dataLen
	 *            数据长度
	 * @param dataType
	 *            密文data数据类型
	 * @param separator
	 *            分隔符
	 * @param paddingFlag
	 *            填充标识
	 * @param exportFlag
	 *            输出明文数据标识
	 * @param algorithmID
	 *            算法标识
	 * @param iv
	 *            iv向量
	 * @return 返回 {@link Recv} 对象 获取响应信息：<br>
	 *         <blockquote> {@link Recv#getResponseCode()}} ：响应码<br>
	 *         {@link Recv#getResponseRemark()}} ：响应描述<br>
	 *         {@link Recv#getKeyValue()}} ：密钥密文<br>
	 *         {@link Recv#getKeyType()}} ：密钥类型<br>
	 *         {@link Recv#getData()}} ：明文数据 </blockquote>
	 */
	public Recv servEA18(String serialNum, String keyByPK, int keyByPKFormat, byte[] data, int dataLen, int dataType,
			byte[] separator, int paddingFlag, int exportFlag, int algorithmID, String iv) {

		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA18", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("serialNum", serialNum)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyByPK", keyByPK)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("keyByPKFormat", keyByPKFormat)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("data", data, data.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataLen", dataLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setByte("separator", separator, separator.length)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("paddingFlag", paddingFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("iv", iv)) != 0)
				recv.setResponseCode(ret);

			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setKeyValue(api.getString("keyValue"));
			recv.setKeyType(api.getString("keyType"));
			recv.setData(api.getByte("data"));
			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA20 apk正版验证
	 * 
	 * @param keyName
	 *            非对称密钥名称
	 * @param mode
	 *            模式
	 * @param seedKeyName
	 *            密钥名称
	 * @param zmkName
	 *            加密保护种子的密钥
	 * @param cycle
	 *            口令变化周期
	 * @param otpLen
	 *            口令长度
	 * @param wnd
	 *            窗口期
	 * @param apkSign
	 *            apk程序签名
	 * @param sign
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getResult ()} : 签名结果<br>
	 *         </blockquote>
	 */
	public Recv servEA20(String keyName, String mode, String seedKeyName, String zmkName, String cycle, String otpLen,
			String wnd, String apkSign, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA20", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("seedKeyName", seedKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zmkName", zmkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cycle", cycle)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("otpLen", otpLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("wnd", wnd)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("apkSign", apkSign)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			recv.setResult(api.getString("result"));
			if (ret != 0) {
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
	 * EA21 生成种子
	 * 
	 * @param seedKeyName
	 *            密钥名称
	 * @param zmkName
	 *            加密保护种子的密钥
	 * @param seed_len
	 *            种子长度
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSeedByZmk()} : Zmk加密的种子<br>
	 *         </blockquote>
	 */
	public Recv servEA21(String seedKeyName, String zmkName, int seed_len) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA21", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("seedKeyName", seedKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zmkName", zmkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setInteger("seed_len", seed_len)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSeedByZmk(api.getString("seedByZmk"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA22 验证动态口令
	 * 
	 * @param zmkName
	 *            zmk密钥名称
	 * @param seedKeyName
	 *            密钥名称
	 * @param otp
	 *            动态口令
	 * @param autoCode
	 *            挑战码
	 * @param otpLen
	 *            口令长度
	 * @param cycle
	 *            口令变化周期
	 * @param wnd
	 *            窗口期
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getResult()} : 签名结果<br>
	 *         </blockquote>
	 */
	public Recv servEA22(String zmkName, String seedKeyName, String otp, String autoCode, String otpLen, String cycle,
			String wnd) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA22", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zmkName", zmkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("seedKeyName", seedKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("otp", otp)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("autoCode", autoCode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("otpLen", otpLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cycle", cycle)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("wnd", wnd)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			recv.setResult(api.getString("result"));
			if (ret != 0) {
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
	 * EA23 生产手机验证码
	 * 
	 * @param zmkName
	 *            zmk密钥名称
	 * @param seedKeyName
	 *            密钥名称
	 * @param autoCode
	 *            挑战码
	 * @param otpLen
	 *            口令长度
	 * @param cycle
	 *            口令变化周期
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getOtp()} : 手机短信验证码<br>
	 *         </blockquote>
	 */
	public Recv servEA23(String zmkName, String seedKeyName, String autoCode, String otpLen, String cycle) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA23", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("zmkName", zmkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("seedKeyName", seedKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("autoCode", autoCode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("otpLen", otpLen)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cycle", cycle)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setOtp(api.getString("otp"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA24 PK加密的对称密钥转换为LMK加密
	 * 
	 * @param keyName
	 *            对称密钥名称
	 * @param pkName
	 *            非对称密钥名称
	 * @param keyByPk
	 *            pk加密的对称密钥
	 * @param checkValue
	 *            密钥校验值
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getKeyByLmk()} : Lmk加密下的密钥名称<br>
	 *         </blockquote>
	 */
	public Recv servEA24(String keyName, String pkName, String keyByPk, String checkValue) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA24", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkName", pkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyByPk", keyByPk)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("checkValue", checkValue)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setKeyByLmk(api.getString("keyByLmk"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * 文件加解密,算法ECB,填充方式PKCS5
	 * 
	 * @param plainFile
	 *            明文文件名
	 * @param cipherFile
	 *            密文文件名
	 * @param keyValue
	 *            密钥值
	 * @param keyType
	 *            密钥类型
	 * @param mode
	 *            模式，0加密，1解密
	 */
	private Recv unionEncryptAndDecryptFile(String plainFile, String cipherFile, String keyValue, String keyType,
			int mode) {

		// 读取文件到buffer中
		FileInputStream in = null;
		FileOutputStream out = null;
		Recv recv = new Recv();

		try {
			if (mode == 1) {
				in = new FileInputStream(cipherFile);
				out = new FileOutputStream(plainFile);
			} else {
				in = new FileInputStream(plainFile);
				out = new FileOutputStream(cipherFile);
			}
			int peerLen = 512;
			byte[] inBuffer = new byte[peerLen];
			int totalLen = 0;
			totalLen = in.available();
			int num = 0;
			int curlen = 2048;
			int paddingFlag = 0;
			if (totalLen % peerLen != 0)
				num = totalLen / peerLen + 1;
			else
				num = totalLen / peerLen;
			for (int i = 0; i < num; i++) {
				if (i == num - 1) {
					paddingFlag = 1;
					if (totalLen % peerLen != 0)
						curlen = totalLen % peerLen;
				}
				final byte[] buffer = curlen < peerLen ? new byte[curlen] : inBuffer;
				in.read(buffer);
				// String data = UnionStr.bcdhex_to_aschex(buffer);
				String data = Hex.encode(buffer);
				if (mode == 1)
					recv = servEA16(keyValue, keyType, paddingFlag, data, 1, 0, null);
				else
					recv = servEA15(keyValue, keyType, paddingFlag, data.getBytes(), 1, 0, null);
				if (recv.getResponseCode() != 0)
					return recv;
				String odata = new String(recv.getData());
				// final byte[] outBuffer = UnionStr.aschex_to_bcdhex(odata);
				final byte[] outBuffer = Hex.decode(odata);
				out.write(outBuffer);
			}
		} catch (Exception e) {
			return Recv.failed(e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return recv;
	}

	/**
	 * 文件解密,算法ECB,填充方式PKCS5
	 * 
	 * @param plainFile
	 *            明文文件名
	 * @param cipherFile
	 *            密文文件名
	 * @param keyValue
	 *            密钥值
	 * @param keyType
	 *            密钥类型
	 */
	public Recv unionDecryptFile(String plainFile, String cipherFile, String keyValue, String keyType) {
		return unionEncryptAndDecryptFile(plainFile, cipherFile, keyValue, keyType, 1);
	}

	/**
	 * 文件加密,算法ECB,填充方式PKCS5 plainFile 明文文件名 cipherFile 密文文件名 keyValue 密钥值 keyType
	 * 密钥类型
	 */
	public Recv unionEncryptFile(String plainFile, String cipherFile, String keyValue, String keyType) {
		return unionEncryptAndDecryptFile(plainFile, cipherFile, keyValue, keyType, 0);
	}

	/**
	 * 文件解密,算法ECB,填充方式PKCS5 plainFile 明文文件名，如"D:/files/aa.txt" cipherFile
	 * 密文文件名，如"D:/files/aa.enc" serialNum 加密证书序列号 keyByPK 公钥加密的密钥密文，HEX数据
	 * keyByPKFormat 公钥加密的密钥密文类型，1：hex数据，3：base64编码数据
	 */
	public Recv unionDecryptFileWithKeyByPK(String plainFile, String cipherFile, String serialNum, String keyByPK,
			int keyByPKFormat) {
		Recv recv = new Recv();
		String keyByPKHex = null;
		if (keyByPKFormat != 1 && keyByPKFormat != 3) {
			recv.setResponseCode(Integer.parseInt(UnionError.ERRCODEAPIPARAMETER.getCode()));
			recv.setResponseRemark(UnionError.ERRCODEAPIPARAMETER.getMessage());
			return recv;
		}
		if (keyByPKFormat == 3) {
			try {
				final byte[] bcdK = Base64.getDecoder().decode(keyByPK);
				// keyByPKHex = UnionStr.bcdhex_to_aschex(bcdK);
				keyByPKHex = Hex.encode(bcdK);
			} catch (Exception e) {
				return Recv.failed(e);
			}
		} else
			keyByPKHex = keyByPK;
		recv = servEA14(serialNum, keyByPKHex);
		if (recv.getResponseCode() != 0)
			return recv;
		String keyValue = recv.getKeyValue();
		String keyType = recv.getKeyType();

		recv = unionEncryptAndDecryptFile(plainFile, cipherFile, keyValue, keyType, 1);
		return recv;
	}

	/**
	 * EA30 数字签名
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param userID
	 *            用户标识
	 * @param data
	 *            签名数据，Base64编码
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码
	 *         {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getSign()}}
	 *         ：签名结果，Base64的签名结果 </blockquote>
	 */
	public Recv servEA30(String keyName, String userID, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA30", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setSign(api.getString("sign"));
			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA31 数字验签
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param userID
	 *            用户标识
	 * @param data
	 *            签名数据，Base64编码
	 * @param sign
	 *            签名结果，Base64的签名结果
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码
	 *         {@link Recv#getResponseRemark()}} ：响应描述 </blockquote>
	 */
	public Recv servEA31(String keyName, String userID, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA31", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA32 敏感信息加密
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param sensInfo
	 *            敏感信息，Base64编码
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()}} ：响应码
	 *         {@link Recv#getResponseRemark()}} ：响应描述 {@link Recv#getEncKey()}}
	 *         ：公钥加密的保护密钥，银联加密密钥，公钥加密的保护密钥,BASE64格式 {@link Recv#getEncInfo()}}
	 *         ：保护密钥加密的敏感信息，BASE64格式 </blockquote>
	 */
	public Recv servEA32(String keyName, String sensInfo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA32", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sensInfo", sensInfo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send(); // 返回响应码
			recv.setResponseCode(ret);
			if (ret != 0) { // 如果发送失败，则可以调用#getResponseRemark()获取错误描述
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}

			recv.setEncKey(api.getString("encKey"));
			recv.setEncInfo(api.getString("encInfo"));

			api.end(); // 结束释放UnionAPI类中静态成员变量

			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA33 敏感信息解密
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param encKey
	 *            公钥加密的保护密钥
	 * @param encInfo
	 *            保护密钥加密的敏感信息
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSensInfo()} : 敏感信息明文<br>
	 *         </blockquote>
	 */
	public Recv servEA33(String keyName, String encKey, String encInfo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA33", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encKey", encKey)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("encInfo", encInfo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSensInfo(api.getString("sensInfo"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA51 生成本行报文
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 数字签名<br>
	 *         </blockquote>
	 */
	public Recv servEA51(String pix, String bankID, String certVersion, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA51", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA52 解析他行绑定报文
	 * 
	 * @param pix
	 *            应用ID
	 * @param mode
	 *            模式
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCertDN()} : 证书拥有者信息<br>
	 *         {@link Recv#getCertSN()} : 证书序列号<br>
	 *         {@link Recv#getCertEffdate()} : 证书起始时间<br>
	 *         {@link Recv#getCertInvdate()} : 证书结束时间<br>
	 *         {@link Recv#getCertBuf()} : 公钥证书<br>
	 *         </blockquote>
	 */
	public Recv servEA52(String pix, String mode, String bankID, String certVersion, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA52", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCertDN(api.getString("certDN"));
			recv.setCertSN(api.getString("certSN"));
			recv.setCertEffdate(api.getString("certEffdate"));
			recv.setCertInvdate(api.getString("certInvdate"));
			recv.setCertBuf(api.getString("certBuf"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA53 数字签名加签
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 数字签名<br>
	 *         </blockquote>
	 */
	public Recv servEA53(String pix, String bankID, String certVersion, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA53", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA54 数字签名核签
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servEA54(String pix, String bankID, String certVersion, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA54", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * EA55 解析他行绑定报文(不验证签名数据)
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param data
	 *            签名数据
	 * @param sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servEA55(String pix, String bankID, String certVersion, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA55", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * EA56 获取证书算法类型及公钥
	 * 
	 * @param pix
	 *            应用ID
	 * @param bankID
	 *            参与行机构号
	 * @param certVersion
	 *            证书版本号
	 * @param sign
	 *            数字签名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servEA56(String pix, String bankID, String certVersion, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA56", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pix", pix)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("bankID", bankID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("certVersion", certVersion)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * EA60 zpk加密pin转公钥加密
	 * 
	 * @param algorithmID
	 *            算法标识
	 * @param keyName
	 *            ZPK或TPK密钥名称
	 * @param pinBlock
	 *            ZPK或TPK加密的PIN
	 * @param accNo
	 *            账号
	 * @param asyKeyName
	 *            非对称密钥名称
	 * @param mode
	 *            加密模式
	 * @param dataFillMode
	 *            加密填充方式（RSA）
	 * @param IV
	 *            初始值
	 * @param format
	 *            PIN格式
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPinByPK()} : 公钥加密的PIN密文<br>
	 *         </blockquote>
	 */
	public Recv servEA60(String algorithmID, String keyName, String pinBlock, String accNo, String asyKeyName,
			String mode, String dataFillMode, String IV, String format) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA60", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("algorithmID", algorithmID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("asyKeyName", asyKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("mode", mode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataFillMode", dataFillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("IV", IV)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("format", format)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPinByPK(api.getString("pinByPK"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA61 数字签名
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param data
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getSign()} : 签名结果<br>
	 *         </blockquote>
	 */
	public Recv servEA61(String keyName, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA61", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setSign(api.getString("sign"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA62 数字验签
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param data
	 *            签名数据
	 * @param sign
	 *            签名结果
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servEA62(String keyName, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA62", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * EA63 敏感信息加密
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param plainData
	 *            敏感信息
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getCipherData()} : 敏感信息密文<br>
	 *         </blockquote>
	 */
	public Recv servEA63(String keyName, String plainData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA63", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("plainData", plainData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setCipherData(api.getByte("cipherData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA64 敏感信息解密
	 * 
	 * @param keyName
	 *            密钥名称
	 * @param cipherData
	 *            敏感信息密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPlainData()} : 敏感信息明文<br>
	 *         </blockquote>
	 */
	public Recv servEA64(String keyName, String cipherData) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA64", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cipherData", cipherData)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setPlainData(api.getByte("plainData"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EG50 RSA公钥加密转专用算法加密(紫金农商定制)
	 * 
	 * @param keyName
	 *            公钥名称
	 * @param dataType
	 *            公钥加密的密文数据类型,1：HEX数据,3：base64编码数据
	 * @param data
	 *            公钥加密的密文,当dataType为1时，数据为扩展HEX数据,当dataType为3时，数据为base64编码数据
	 * @param fillMode
	 *            公钥加密填充方式,0：填充0x00,1：PKCS填充
	 * @param accNo
	 *            帐号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 专用算法加密的密文<br>
	 *         </blockquote>
	 */
	public Recv servEG50(String keyName, String dataType, String data, String fillMode, String accNo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EG50", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getString("data", "").getBytes());
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EG51 SM4加密转专用算法加密(紫金农商定制)
	 * 
	 * @param keyName
	 *            公钥名称
	 * @param pinBlock
	 *            ZPK加密的PIN密文
	 * @param accNo
	 *            帐号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 专用算法加密的密文<br>
	 *         </blockquote>
	 */
	public Recv servEG51(String keyName, String pinBlock, String accNo) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EG51", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pinBlock", pinBlock)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getString("data", "").getBytes());
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EG52 RSA公钥加密转平安算法加密(紫金农商定制)
	 * 
	 * @param pkName
	 *            公钥名称
	 * @param keyName
	 *            ZAK密钥名称
	 * @param accNo
	 *            帐号
	 * @param dataType
	 *            公钥加密的密文数据类型,1：HEX数据,3：base64编码数据
	 * @param data
	 *            公钥加密的密文
	 * @param fillMode
	 *            公钥加密填充方式,0：填充0x00,1：PKCS填充
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} : 专用算法加密的密文,ZAK计算得到的MAC<br>
	 *         </blockquote>
	 */
	public Recv servEG52(String pkName, String keyName, String accNo, String dataType, String data, String fillMode) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EG52", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("pkName", pkName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("accNo", accNo)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getString("data", "").getBytes());
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EG53 RSA算法私钥解密(紫金农商定制)
	 * 
	 * @param keyName
	 *            公钥名称
	 * @param dataType
	 *            公钥加密的密文数据类型
	 * @param data
	 *            公钥加密的数据密文
	 * @param fillMode
	 *            填充方式
	 * @param exportFlag
	 *            密文输出标识
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getData()} :
	 *         明文,当exportFlag为0时，为解密后的数据原文ascii字符,当exportFlag为1时，为解密后数据原文扩展后的HEX数据,当exportFlag为3时，为解密后数据原文base64编码数据<br>
	 *         </blockquote>
	 */
	public Recv servEG53(String keyName, String dataType, String data, String fillMode, String exportFlag) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EG53", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("dataType", dataType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fillMode", fillMode)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("exportFlag", exportFlag)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setData(api.getString("data", "").getBytes());
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA90 公钥加密的密钥转lmk加密
	 * 
	 * @param asyKeyName
	 *            非对称密钥名称
	 * @param application
	 *            节点ID
	 * @param keyByPk
	 *            公钥加密的密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getkeyValue()} : keyValue<br>
	 *         {@link Recv#getcheckValue()}: checkValue<br>
	 *         {@link Recv#getkeyType()} : keyType<br>
	 *         {@link Recv#getkeyName()} : keyName<br>
	 *         </blockquote>
	 **/

	public Recv servEA90(String asyKeyName, String application, String nodeID, String keyByPk) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA90", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("asyKeyName", asyKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("application", application)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("nodeID", nodeID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyByPk", keyByPk)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setkeyValue(api.getString("keyValue"));
			recv.setcheckValue(api.getString("checkValue"));
			recv.setkeyType(api.getString("keyType"));
			recv.setkeyName(api.getString("keyName"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA91 导入证书
	 * 
	 * @param fileName
	 *            证书文件名
	 * @param cert
	 *            证书内容
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 **/

	public Recv servEA91(String fileName, String cert) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA91", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fileName", fileName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("cert", cert)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
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
	 * EA92 导出证书
	 * 
	 * @param fileName
	 *            证书文件名
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getcert()} : cert<br>
	 *         {@link Recv#getversion()} : version<br>
	 *         </blockquote>
	 **/

	public Recv servEA92(String fileName) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA92", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("fileName", fileName)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setcert(api.getString("cert"));
			recv.setversion(api.getString("version"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA93 公钥加密对称密钥
	 * 
	 * @param asyKeyName
	 *            非对称密钥名称
	 * @param keyName
	 *            对称密钥名称
	 * @param keyType
	 *            密钥类型
	 * @param keyLen
	 *            密钥长度
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getkeyValue()} : keyValue<br>
	 *         {@link Recv#getcheckValue()} : checkValue<br>
	 *         {@link Recv#getkeyByPk()} : keyByPk<br>
	 *         </blockquote>
	 **/

	public Recv servEA93(String asyKeyName, String keyName, String keyType, String keyLen) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA93", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("asyKeyName", asyKeyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyType", keyType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyLen", keyLen)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setkeyValue(api.getString("keyValue"));
			recv.setcheckValue(api.getString("checkValue"));
			recv.setkeyByPk(api.getString("keyByPk"));
			// recv.setmac(api.getString("checkValue"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA94 签名
	 * 
	 * @param asyKeyName
	 *            非对称密钥名称
	 * @param data
	 *            签名数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getsign()} : sign<br>
	 *         {@link Recv#getversion()} : version<br>
	 *         </blockquote>
	 **/

	public Recv servEA94(String keyName, String data) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA94", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setsign(api.getString("sign"));
			recv.setversion(api.getString("version"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * EA95 验签
	 * 
	 * @param keyName
	 *            非对称密钥名称
	 * @param data
	 *            签名数据
	 * @param sign
	 *            签名结果
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 **/

	public Recv servEA95(String keyName, String data, String sign) {
		try {
			int ret = 0;
			Recv recv = new Recv();
			UnionAPI api = new UnionAPI();
			/*
			 * userInfo、sysID、appID可供用户自定 userInfo: 不指定则由API自动生成； sysID、appID:
			 * 不指定则采用配置文件中的设定
			 */
			String userInfo = "";
			String sysID = "";
			String appID = "";
			if ((ret = api.start("EA95", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("keyName", keyName)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("data", data)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("sign", sign)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	// 该类用于接收报文响应域，由客户跟进接口说明文档自行定义
	public static class Recv {
		private final Map<String, String> strings = new HashMap<String, String>();
		private final Map<String, byte[]> bytes = new HashMap<String, byte[]>();
		private final Map<String, Integer> integers = new HashMap<String, Integer>();

		// add by liuql 20180604
		public String setsign(String sign) {
			return strings.put("sign",sign);
		}

		public String getsign() {
			return strings.get("sign");
		}

		public String setkeyByPk(String keyByPk) {
			return strings.put("keyByPk",keyByPk);
		}

		public String getkeyByPk() {
			return strings.get("keyByPk");
		}

		public String setcert(String cert) {
			return strings.put("cert",cert);
		}

		public String getcert() {
			return strings.get("cert");
		}

		public String setversion(String version) {
			return strings.put("version",version);
		}

		public String getversion() {
			return strings.get("version");
		}

		public String getkeyName() {
			return strings.get("keyName");
		}

		public void setkeyName(String keyName) {
			strings.put("keyName", keyName);
		}

		public String getkeyType() {
			return strings.get("keyType");
		}

		public void setkeyType(String keyType) {
			strings.put("keyType", keyType);
		}

		public String getcheckValue() {
			return strings.get("checkValue");
		}

		public void setcheckValue(String checkValue) {
			strings.put("checkValue", checkValue);
		}

		public String getkeyValue() {
			return strings.get("keyValue");
		}

		public void setkeyValue(String keyValue) {
			strings.put("keyValue", keyValue);
		}

		//
		public String getCVV() {
			return strings.get("CVV");
		}

		public void setCVV(String CVV) {
			strings.put("CVV", CVV);
		}

		public byte[] getData() {
			return bytes.get("data");
		}

		public void setData(byte[] data) {
			bytes.put("data", data);
		}

		public void setHsmCmdRes(byte[] hsmCmdRes) {
			bytes.put("hsmCmdRes", hsmCmdRes);
		}

		public Integer getResponseCode() {
			return integers.get("responseCode");
		}

		public void setResponseCode(Integer responseCode) {
			integers.put("responseCode", responseCode);
		}

		public Integer getAlgFlag() {
			return integers.get("algFlag");
		}

		public void setAlgFlag(Integer algFlag) {
			integers.put("algFlag", algFlag);
		}

		public Integer getKeyLen() {
			return integers.get("keyLen");
		}

		public void setKeyLen(Integer keyLen) {
			integers.put("keyLen", keyLen);
		}

		public String getResponseRemark() {
			return strings.get("responseRemark");
		}

		public void setResponseRemark(String responseRemark) {
			strings.put("responseRemark", responseRemark);
		}

		public String getPinOffset() {
			return strings.get("pinOffset");
		}

		public void setPinOffset(String pinOffset) {
			strings.put("pinOffset", pinOffset);
		}

		public String getCheckData2() {
			return strings.get("checkData2");
		}

		public void setCheckData2(String checkData2) {
			strings.put("checkData2", checkData2);
		}

		public String getSign() {
			return strings.get("sign");
		}

		public void setSign(String sign) {
			strings.put("sign", sign);
		}

		public String getEncKey() {
			return strings.get("encKey");
		}

		public void setEncKey(String encKey) {
			strings.put("encKey", encKey);
		}

		public String getEncInfo() {
			return strings.get("encInfo");
		}

		public void setEncInfo(String encInfo) {
			strings.put("encInfo", encInfo);
		}

		public String getPkValue() {
			return strings.get("pkValue");
		}

		public void setPkValue(String pkValue) {
			strings.put("pkValue", pkValue);
		}

		public String getKeyByPK() {
			return strings.get("keyByPK");
		}

		public void setKeyByPK(String keyByPK) {
			strings.put("keyByPK", keyByPK);
		}

		public String getKeyValue() {
			return strings.get("keyValue");
		}

		public void setKeyValue(String keyValue) {
			strings.put("keyValue", keyValue);
		}

		public String getKeyType() {
			return strings.get("keyType");
		}

		public void setKeyType(String keyType) {
			strings.put("keyType", keyType);
		}

		public String getSensInfo() {
			return strings.get("sensInfo");
		}

		public void setSensInfo(String sensInfo) {
			strings.put("sensInfo", sensInfo);
		}

		public String getFaildList() {
			return strings.get("faildList");
		}

		public void setFaildList(String faildList) {
			strings.put("faildList", faildList);
		}

		public String getCheckValue() {
			return strings.get("checkValue");
		}

		public void setCheckValue(String checkValue) {
			strings.put("checkValue", checkValue);
		}

		public String getKeyValue2() {
			return strings.get("keyValue2");
		}

		public void setKeyValue2(String keyValue2) {
			strings.put("keyValue2", keyValue2);
		}

		public String getKeyGroup() {
			return strings.get("keyGroup");
		}

		public void setKeyGroup(String keyGroup) {
			strings.put("keyGroup", keyGroup);
		}

		public String getAlgorithmID() {
			return strings.get("algorithmID");
		}

		public void setAlgorithmID(String algorithmID) {
			strings.put("algorithmID", algorithmID);
		}

		public String getOldVersionKeyIsUsed() {
			return strings.get("oldVersionKeyIsUsed");
		}

		public void setOldVersionKeyIsUsed(String oldVersionKeyIsUsed) {
			strings.put("oldVersionKeyIsUsed", oldVersionKeyIsUsed);
		}

		public String getInputFlag() {
			return strings.get("inputFlag");
		}

		public void setInputFlag(String inputFlag) {
			strings.put("inputFlag", inputFlag);
		}

		public String getOutputFlag() {
			return strings.get("outputFlag");
		}

		public void setOutputFlag(String outputFlag) {
			strings.put("outputFlag", outputFlag);
		}

		public String getEffectiveDays() {
			return strings.get("effectiveDays");
		}

		public void setEffectiveDays(String effectiveDays) {
			strings.put("effectiveDays", effectiveDays);
		}

		public String getActiveDate() {
			return strings.get("activeDate");
		}

		public void setActiveDate(String activeDate) {
			strings.put("activeDate", activeDate);
		}

		public String getStatus() {
			return strings.get("status");
		}

		public void setStatus(String status) {
			strings.put("status", status);
		}

		public String getCreatorType() {
			return strings.get("creatorType");
		}

		public void setCreatorType(String creatorType) {
			strings.put("creatorType", creatorType);
		}

		public String getCreator() {
			return strings.get("creator");
		}

		public void setCreator(String creator) {
			strings.put("creator", creator);
		}

		public String getCreateTime() {
			return strings.get("createTime");
		}

		public void setCreateTime(String createTime) {
			strings.put("createTime", createTime);
		}

		public String getKeyUpdateTime() {
			return strings.get("keyUpdateTime");
		}

		public void setKeyUpdateTime(String keyUpdateTime) {
			strings.put("keyUpdateTime", keyUpdateTime);
		}

		public String getKeyApplyPlatform() {
			return strings.get("keyApplyPlatform");
		}

		public void setKeyApplyPlatform(String keyApplyPlatform) {
			strings.put("keyApplyPlatform", keyApplyPlatform);
		}

		public String getKeyDistributePlatform() {
			return strings.get("keyDistributePlatform");
		}

		public void setKeyDistributePlatform(String keyDistributePlatform) {
			strings.put("keyDistributePlatform", keyDistributePlatform);
		}

		public String getUsingUnit() {
			return strings.get("usingUnit");
		}

		public void setUsingUnit(String usingUnit) {
			strings.put("usingUnit", usingUnit);
		}

		public String getRemark() {
			return strings.get("remark");
		}

		public void setRemark(String remark) {
			strings.put("remark", remark);
		}

		public String getDesKeyByPK() {
			return strings.get("desKeyByPK");
		}

		public void setDesKeyByPK(String desKeyByPK) {
			strings.put("desKeyByPK", desKeyByPK);
		}

		public String getDesCheckValue() {
			return strings.get("desCheckValue");
		}

		public void setDesCheckValue(String desCheckValue) {
			strings.put("desCheckValue", desCheckValue);
		}

		public String getSm4KeyByPK() {
			return strings.get("sm4KeyByPK");
		}

		public void setSm4KeyByPK(String sm4KeyByPK) {
			strings.put("sm4KeyByPK", sm4KeyByPK);
		}

		public String getSm4CheckValue() {
			return strings.get("sm4CheckValue");
		}

		public void setSm4CheckValue(String sm4CheckValue) {
			strings.put("sm4CheckValue", sm4CheckValue);
		}

		public String getVkValue() {
			return strings.get("vkValue");
		}

		public void setVkValue(String vkValue) {
			strings.put("vkValue", vkValue);
		}

		public String getPkExponent() {
			return strings.get("pkExponent");
		}

		public void setPkExponent(String pkExponent) {
			strings.put("pkExponent", pkExponent);
		}

		public String getVkStoreLocation() {
			return strings.get("vkStoreLocation");
		}

		public void setVkStoreLocation(String vkStoreLocation) {
			strings.put("vkStoreLocation", vkStoreLocation);
		}

		public String getVkIndex() {
			return strings.get("vkIndex");
		}

		public void setVkIndex(String vkIndex) {
			strings.put("vkIndex", vkIndex);
		}

		public String getOrganizationName() {
			return strings.get("organizationName");
		}

		public void setOrganizationName(String organizationName) {
			strings.put("organizationName", organizationName);
		}

		public String getPinBlock() {
			return strings.get("pinBlock");
		}

		public void setPinBlock(String pinBlock) {
			strings.put("pinBlock", pinBlock);
		}

		public String getPVV() {
			return strings.get("PVV");
		}

		public void setPVV(String PVV) {
			strings.put("PVV", PVV);
		}

		public String getPlainPin() {
			return strings.get("plainPin");
		}

		public void setPlainPin(String plainPin) {
			strings.put("plainPin", plainPin);
		}

		public String getReferenceNumber() {
			return strings.get("referenceNumber");
		}

		public void setReferenceNumber(String referenceNumber) {
			strings.put("referenceNumber", referenceNumber);
		}

		public String getCheckData() {
			return strings.get("checkData");
		}

		public void setCheckData(String checkData) {
			strings.put("checkData", checkData);
		}

		public byte[] getCheckData3() {
			return bytes.get("checkData");
		}

		public void setCheckData(byte[] checkData) {
			bytes.put("checkData", checkData);
		}

		public String getDecimalTable() {
			return strings.get("decimalTable");
		}

		public void setDecimalTable(String decimalTable) {
			strings.put("decimalTable", decimalTable);
		}

		public String getMac() {
			return strings.get("mac");
		}

		public void setMac(String mac) {
			strings.put("mac", mac);
		}

		public String getHsmCmdRes() {
			return strings.get("hsmCmdRes");
		}

		public void setHsmCmdRes(String hsmCmdRes) {
			strings.put("hsmCmdRes", hsmCmdRes);
		}

		public String getPinByPK() {
			return strings.get("pinByPK");
		}

		public void setPinByPK(String pinByPK) {
			strings.put("pinByPK", pinByPK);
		}

		public String getHash() {
			return strings.get("hash");
		}

		public void setHash(String hash) {
			strings.put("hash", hash);
		}

		public String getResultFlag() {
			return strings.get("resultFlag");
		}

		public void setResultFlag(String resultFlag) {
			strings.put("resultFlag", resultFlag);
		}

		public String getDesPinBlock() {
			return strings.get("desPinBlock");
		}

		public void setDesPinBlock(String desPinBlock) {
			strings.put("desPinBlock", desPinBlock);
		}

		public byte[] getCipherData() {
			return bytes.get("cipherData");
		}

		public void setCipherData(byte[] cipherData) {
			bytes.put("cipherData", cipherData);
		}

		public byte[] getDstData() {
			return bytes.get("dstData");
		}

		public void setDstData(byte[] dstData) {
			bytes.put("dstData", dstData);
		}

		public String getEncryptData() {
			return strings.get("encryptData");
		}

		public void setEncryptData(String encryptData) {
			strings.put("encryptData", encryptData);
		}

		public byte[] getPlainData() {
			return bytes.get("plainData");
		}

		public void setPlainData(byte[] plainData) {
			bytes.put("plainData", plainData);
		}

		public String getDigest() {
			return strings.get("digest");
		}

		public void setDigest(String digest) {
			strings.put("digest", digest);
		}

		public String getPinLen() {
			return strings.get("pinLen");
		}

		public void setPinLen(String pinLen) {
			strings.put("pinLen", pinLen);
		}

		public String getPinByZPK() {
			return strings.get("pinByZPK");
		}

		public void setPinByZPK(String pinByZPK) {
			strings.put("pinByZPK", pinByZPK);
		}

		public String getPinByZPK2() {
			return strings.get("pinByZPK2");
		}

		public void setPinByZPK2(String pinByZPK2) {
			strings.put("pinByZPK2", pinByZPK2);
		}

		public String getIdLen() {
			return strings.get("idLen");
		}

		public void setIdLen(String idLen) {
			strings.put("idLen", idLen);
		}

		public String getUniqueID() {
			return strings.get("uniqueID");
		}

		public void setUniqueID(String uniqueID) {
			strings.put("uniqueID", uniqueID);
		}

		public String getId() {
			return strings.get("id");
		}

		public void setId(String id) {
			strings.put("id", id);
		}

		public String getComplexityOfPin() {
			return strings.get("complexityOfPin ");
		}

		public void setComplexityOfPin(String complexityOfPin) {
			strings.put("complexityOfPin ", complexityOfPin);
		}

		public String getPinByZEK() {
			return strings.get("pinByZEK");
		}

		public void setPinByZEK(String pinByZEK) {
			strings.put("pinByZEK", pinByZEK);
		}

		public String getHashID() {
			return strings.get("hashID");
		}

		public void setHashID(String hashID) {
			strings.put("hashID", hashID);
		}

		public String getIssuserDN() {
			return strings.get("issuserDN");
		}

		public void setIssuserDN(String issuserDN) {
			strings.put("issuserDN", issuserDN);
		}

		public String getUserDN() {
			return strings.get("userDN");
		}

		public void setUserDN(String userDN) {
			strings.put("userDN", userDN);
		}

		public String getSerialNumber() {
			return strings.get("serialNumber");
		}

		public void setSerialNumber(String serialNumber) {
			strings.put("serialNumber", serialNumber);
		}

		public String getRevokedFlag() {
			return strings.get("revokedFlag");
		}

		public void setRevokedFlag(String revokedFlag) {
			strings.put("revokedFlag", revokedFlag);
		}

		public String getArpc() {
			return strings.get("arpc");
		}

		public void setArpc(String arpc) {
			strings.put("arpc", arpc);
		}

		public byte[] getCiperData() {
			return bytes.get("ciperData ");
		}

		public void setCiperData(byte[] ciperData) {
			bytes.put("ciperData ", ciperData);
		}

		public String getCertDN() {
			return strings.get("certDN");
		}

		public void setCertDN(String certDN) {
			strings.put("certDN", certDN);
		}

		public String getCertSN() {
			return strings.get("certSN");
		}

		public void setCertSN(String certSN) {
			strings.put("certSN", certSN);
		}

		public String getCertEffdate() {
			return strings.get("certEffdate");
		}

		public void setCertEffdate(String certEffdate) {
			strings.put("certEffdate", certEffdate);
		}

		public String getCertInvdate() {
			return strings.get("certInvdate");
		}

		public void setCertInvdate(String certInvdate) {
			strings.put("certInvdate", certInvdate);
		}

		public String getCertBuf() {
			return strings.get("certBuf");
		}

		public void setCertBuf(String certBuf) {
			strings.put("certBuf", certBuf);
		}

		public String getPk() {
			return strings.get("pk");
		}

		public void setPk(String pk) {
			strings.put("pk", pk);
		}

		public String getCertActiveData() {
			return strings.get("certActiveData");
		}

		public void setCertActiveData(String certActiveData) {
			strings.put("certActiveData", certActiveData);
		}

		public String getCertEndData() {
			return strings.get("certEndData");
		}

		public void setCertEndData(String certEndData) {
			strings.put("certEndData", certEndData);
		}

		public String getCertID() {
			return strings.get("certID");
		}

		public void setCertID(String certID) {
			strings.put("certID", certID);
		}

		public String getPkcs7Str() {
			return strings.get("pkcs7Str");
		}

		public void setPkcs7Str(String pkcs7Str) {
			strings.put("pkcs7Str", pkcs7Str);
		}

		public String getCertFileName() {
			return strings.get("certFileName");
		}

		public void setCertFileName(String certFileName) {
			strings.put("certFileName", certFileName);
		}

		public String getBase64Signature() {
			return strings.get("base64Signature");
		}

		public void setBase64Signature(String base64Signature) {
			strings.put("base64Signature", base64Signature);
		}

		public String getVerify_result() {
			return strings.get("Verify_result");
		}

		public void setVerify_result(String Verify_result) {
			strings.put("Verify_result", Verify_result);
		}

		public String getPkcs7Env() {
			return strings.get("pkcs7Env");
		}

		public void setPkcs7Env(String pkcs7Env) {
			strings.put("pkcs7Env", pkcs7Env);
		}

		public String getDesPINBlock() {
			return strings.get("desPINBlock");
		}

		public void setDesPINBlock(String desPINBlock) {
			strings.put("desPINBlock", desPINBlock);
		}

		public String getKeyName() {
			return strings.get("keyName");
		}

		public void setKeyName(String keyName) {
			strings.put("keyName", keyName);
		}

		public String getAuthCode() {
			return strings.get("authCode");
		}

		public void setAuthCode(String authCode) {
			strings.put("authCode", authCode);
		}

		public String getMode() {
			return strings.get("mode");
		}

		public void setMode(String mode) {
			strings.put("mode", mode);
		}

		public String getIcv() {
			return strings.get("Icv");
		}

		public void setIcv(String Icv) {
			strings.put("Icv", Icv);
		}

		public String getSafeCodeFive() {
			return strings.get("safeCodeFive");
		}

		public void setSafeCodeFive(String safeCodeFive) {
			strings.put("safeCodeFive", safeCodeFive);
		}

		public String getCheckResult() {
			return strings.get("checkResult");
		}

		public void setCheckResult(String checkResult) {
			strings.put("checkResult", checkResult);
		}

		public String getSafeCodeFour() {
			return strings.get("safeCodeFour");
		}

		public void setSafeCodeFour(String safeCodeFour) {
			strings.put("safeCodeFour", safeCodeFour);
		}

		public String getSafeCodeThree() {
			return strings.get("safeCodeThree");
		}

		public void setSafeCodeThree(String safeCodeThree) {
			strings.put("safeCodeThree", safeCodeThree);
		}

		public String getCVC3() {
			return strings.get("CVC3");
		}

		public void setCVC3(String CVC3) {
			strings.put("CVC3", CVC3);
		}

		public String getDataCipherTextBykeyB() {
			return strings.get("dataCipherTextBykeyB");
		}

		public void setDataCipherTextBykeyB(String dataCipherTextBykeyB) {
			strings.put("dataCipherTextBykeyB", dataCipherTextBykeyB);
		}

		public String getDstkey() {
			return strings.get("dstkey");
		}

		public void setDstkey(String dstkey) {
			strings.put("dstkey", dstkey);
		}

		public byte[] getDstCipher() {
			return bytes.get("dstCipher");
		}

		public void setDstCipher(byte[] dstCipher) {
			bytes.put("dstCipher", dstCipher);
		}

		public void setKeyCipherTextByLmk(byte[] keyCipherTextByLmk) {
			bytes.put("keyCipherTextByLmk", keyCipherTextByLmk);
		}

		public String getResult() {
			return strings.get("result");
		}

		public void setResult(String result) {
			strings.put("result", result);
		}

		public String getSeedByZmk() {
			return strings.get("seedByZmk");
		}

		public void setSeedByZmk(String seedByZmk) {
			strings.put("seedByZmk", seedByZmk);
		}

		public String getOtp() {
			return strings.get("otp");
		}

		public void setOtp(String otp) {
			strings.put("otp", otp);
		}

		public String getKeyByLmk() {
			return strings.get("keyByLmk");
		}

		public void setKeyByLmk(String keyByLmk) {
			strings.put("keyByLmk", keyByLmk);
		}

		public static Recv failed(Exception e) {
			final Recv recv = new Recv();
			recv.setResponseCode(-1);
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			final PrintStream printStream = new PrintStream(outputStream);
			e.printStackTrace(printStream);
			recv.setResponseRemark(new String(outputStream.toByteArray()));
			return recv;
		}
	}
}
