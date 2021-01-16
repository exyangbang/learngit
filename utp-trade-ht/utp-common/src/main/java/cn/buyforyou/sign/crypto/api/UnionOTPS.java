package cn.buyforyou.sign.crypto.api;

import com.union.utils.Checker;
import com.union.utils.Hex;
import com.union.utils.SM3;
import com.union.utils.UnionAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnionOTPS {

	/**
	 * D401 注册账号
	 * 
	 * @param userID
	 *            账号ID
	 * @param loginModeFlag
	 *            账号登录标识
	 * @param tokenType
	 *            令牌类型
	 * @param tokenID
	 *            令牌序号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPlainPassword()} : 密码明文<br>
	 *         </blockquote>
	 */
	public Recv servD401(String userID, String loginModeFlag, String tokenType, String tokenID) {
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
			if ((ret = api.start("D401", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("loginModeFlag", loginModeFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("tokenType", tokenType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("tokenID", tokenID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if (api.getString("plainPassword") != null)
				recv.setPlainPassword(api.getString("plainPassword"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D402 修改账号密码
	 * 
	 * @param userID
	 *            账号ID
	 * @param oldPassword
	 *            旧密码密文
	 * @param newPassword
	 *            新密码密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servD402(String userID, String oldPassword, String newPassword) {
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
			if ((ret = api.start("D402", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("oldPassword", oldPassword)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("newPassword", newPassword)) != 0)
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
	 * D403 重置密码
	 * 
	 * @param userID
	 *            账号ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getUserPassword()} : 密码明文<br>
	 *         </blockquote>
	 */
	public Recv servD403(String userID) {
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
			if ((ret = api.start("D403", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setUserPassword(api.getString("userPassword"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D404 账号禁用、解锁/解禁、删除、锁定
	 * 
	 * @param userID
	 *            账号ID
	 * @param operationID
	 *            账号操作
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servD404(String userID, String operationID) {
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
			if ((ret = api.start("D404", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("operationID", operationID)) != 0)
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
	 * D405 下载公钥明文
	 * 
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPkValue()} : 公钥明文<br>
	 *         </blockquote>
	 */
	public Recv servD405() {
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
			if ((ret = api.start("D405", userInfo, sysID, appID)) != 0)
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
	 * D406 账号登录服务
	 * 
	 * @param userID
	 *            账号ID
	 * @param userPassword
	 *            密码密文
	 * @param otp
	 *            待验证动态口令
	 * @param payload
	 *            账号自定义token载荷数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getToken()} : 账号的token<br>
	 *         {@link Recv#getRemainingTimes()} : 账号输入密码剩余次数<br>
	 *         {@link Recv#getRemainingDays()} : 账号更新密码剩余天数<br>
	 *         </blockquote>
	 */
	public Recv servD406(String userID, String userPassword, String otp, String payload) {
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
			if ((ret = api.start("D406", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userPassword", userPassword)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("otp", otp)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("payload", payload)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if (api.getString("token") != null)
				recv.setToken(api.getString("token"));
			if (api.getString("remainingTimes") != null)
				recv.setRemainingTimes(api.getString("remainingTimes"));
			if (api.getString("remainingDays") != null)
				recv.setRemainingDays(api.getString("remainingDays"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D406 账号登录服务
	 * 
	 * @param userID
	 *            账号ID
	 * @param passwordWithOTP
	 *            静态密码+动态口令字符串
	 * @param payload
	 *            账号自定义token载荷数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getToken()} : 账号的token<br>
	 *         {@link Recv#getRemainingTimes()} : 账号输入密码剩余次数<br>
	 *         {@link Recv#getRemainingDays()} : 账号更新密码剩余天数<br>
	 *         </blockquote>
	 */
	public Recv servD406(String userID, String passwordWithOTP, String payload) {
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
			if ((ret = api.start("D406", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);

			Checker.checkArgument(passwordWithOTP != null
			        && passwordWithOTP.length() >= 6, "illegal password+otp argument: %s", passwordWithOTP);
			final int otpSize = 6;
			final int index = passwordWithOTP.length() - otpSize;
			final String userPassword = digestPassword(userID, passwordWithOTP.substring(0, index));
			if ((ret = api.setString("userPassword", userPassword)) != 0)
				recv.setResponseCode(ret);
			final String otp = passwordWithOTP.substring(index);
			if ((ret = api.setString("otp", otp)) != 0)
				recv.setResponseCode(ret);

			if ((ret = api.setString("payload", payload)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if (api.getString("token") != null)
				recv.setToken(api.getString("token"));
			if (api.getString("remainingTimes") != null)
				recv.setRemainingTimes(api.getString("remainingTimes"));
			if (api.getString("remainingDays") != null)
				recv.setRemainingDays(api.getString("remainingDays"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	String digestPassword(String userID, String password) {
		Checker.checkArgument(password.length() <= 20, "the size of password must less than 20.");
		final byte[] data = new byte[40];
		Arrays.fill(data, (byte) 0x00);
		final byte[] bPassword = password.getBytes();
		System.arraycopy(bPassword, 0, data, 20, bPassword.length);
		final byte[] bUserID = userID.getBytes();
		final int offset = (bUserID.length > 20 ? bUserID.length -20 : 0);
		for (int i = 0; i < bPassword.length || i + offset < bUserID.length; i++) {
			if (i >= bPassword.length) {
				data[i] = bUserID[i + offset];
				continue;
			}
			if (i + offset >= bUserID.length) {
				data[i] = bPassword[i];
				continue;
			}
			data[i] = (byte) (bPassword[i] ^ bUserID[i + offset]);
		}
		final SM3 sm3 = new SM3();
		return Hex.encode(sm3.Digest(Hex.encode(data).getBytes()));
	}

	/**
	 * D407 验证账号Token服务
	 * 
	 * @param userID
	 *            账号ID
	 * @param token
	 *            账号的token
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servD407(String userID, String token) {
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
			if ((ret = api.start("D407", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("token", token)) != 0)
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
	 * D408 删除Token
	 * 
	 * @param userID
	 *            账号ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servD408(String userID) {
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
			if ((ret = api.start("D408", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
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
	 * D409 修改账号登录方式
	 * 
	 * @param userID
	 *            账号ID
	 * @param loginModeFlag
	 *            账号登录标识
	 * @param isDeleteTokenID
	 *            删除令牌序号标识
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getPlainPassword()} : 密码明文<br>
	 *         </blockquote>
	 */
	public Recv servD409(String userID, String loginModeFlag, String isDeleteTokenID) {
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
			if ((ret = api.start("D409", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("loginModeFlag", loginModeFlag)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("isDeleteTokenID", isDeleteTokenID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if (api.getString("plainPassword") != null)
				recv.setPlainPassword(api.getString("plainPassword"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D40A 绑定账号令牌
	 * 
	 * @param userID
	 *            账号ID
	 * @param tokenType
	 *            令牌类型
	 * @param tokenID
	 *            令牌序号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getActiveCode()} : 令牌激活码<br>
	 *         </blockquote>
	 */
	public Recv servD40A(String userID, String tokenType, String tokenID) {
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
			if ((ret = api.start("D40A", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("tokenType", tokenType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("tokenID", tokenID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if (api.getString("activeCode") != null)
				recv.setActiveCode(api.getString("activeCode"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D40B 查询账号信息
	 * 
	 * @param userID
	 *            账号ID
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getLoginModeFlag()} : 账号登录标识<br>
	 *         {@link Recv#getTokenType()} : 令牌类型<br>
	 *         {@link Recv#getTokenID()} : 令牌序号<br>
	 *         {@link Recv#getTokenStatus()} : 令牌状态<br>
	 *         </blockquote>
	 */
	public Recv servD40B(String userID) {
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
			if ((ret = api.start("D40B", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			if (api.getString("loginModeFlag") != null)
				recv.setLoginModeFlag(api.getString("loginModeFlag"));
			if (api.getString("tokenType") != null)
				recv.setTokenType(api.getString("tokenType"));
			if (api.getString("tokenID") != null)
				recv.setTokenID(api.getString("tokenID"));
			if (api.getString("tokenStatus") != null)
				recv.setTokenStatus(api.getString("tokenStatus"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D40C 账号追加Token载荷数据服务 （原账号token有效）
	 * 
	 * @param userID
	 *            账号ID
	 * @param token
	 *            账号的token
	 * @param payload
	 *            账号自定义token载荷数据
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getNewToken()} : 账号新的token<br>
	 *         </blockquote>
	 */
	public Recv servD40C(String userID, String token, String payload) {
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
			if ((ret = api.start("D40C", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("token", token)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("payload", payload)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setNewToken(api.getString("newToken"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D40D 更新账号Token服务 （原账号token无效）
	 * 
	 * @param userID
	 *            账号ID
	 * @param token
	 *            账号的token
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getNewToken()} : 账号新的token<br>
	 *         </blockquote>
	 */
	public Recv servD40D(String userID, String token) {
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
			if ((ret = api.start("D40D", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("token", token)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setNewToken(api.getString("newToken"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D40E 验证软件令牌口令
	 * 
	 * @param tokenID
	 *            令牌序号
	 * @param otp
	 *            动态口令
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getRemainTimes()} : 口令剩余验证次数<br>
	 *         </blockquote>
	 */
	public Recv servD40E(String tokenID, String otp) {
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
			if ((ret = api.start("D40E", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("tokenID", tokenID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("otp", otp)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setRemainTimes(api.getString("remainTimes"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D40F 验证账号静态密码
	 * 
	 * @param userID
	 *            账号ID
	 * @param userPassword
	 *            账号密码密文
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servD40F(String userID, String userPassword) {
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
			if ((ret = api.start("D40F", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userPassword", userPassword)) != 0)
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
	 * D410 查询所有账号ID
	 * 
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         {@link Recv#getAllUserID()} : 账号ID<br>
	 *         </blockquote>
	 */
	public Recv servD410() {
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
			if ((ret = api.start("D410", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			ret = api.send();
			recv.setResponseCode(ret);
			if (ret != 0) {
				recv.setResponseRemark(api.getResponseRemark());
				return recv;
			}
			recv.setAllUserID(api.getString("allUserID"));
			api.end();
			return recv;
		} catch (Exception e) {
			return Recv.failed(e);
		}
	}

	/**
	 * D411 绑定账号令牌 （账号管理员专用，不生成激活码）
	 * 
	 * @param userID
	 *            账号ID
	 * @param tokenType
	 *            令牌类型
	 * @param tokenID
	 *            令牌序号
	 * @return 返回 {@link Recv} 对象 获取响应信息： <blockquote>
	 *         {@link Recv#getResponseCode()} : 响应码<br>
	 *         {@link Recv#getResponseRemark()} : 响应描述<br>
	 *         </blockquote>
	 */
	public Recv servD411(String userID, String tokenType, String tokenID) {
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
			if ((ret = api.start("D411", userInfo, sysID, appID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("userID", userID)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("tokenType", tokenType)) != 0)
				recv.setResponseCode(ret);
			if ((ret = api.setString("tokenID", tokenID)) != 0)
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
		@SuppressWarnings("unused")
		private final Map<String, byte[]> bytes = new HashMap<String, byte[]>();
		private final Map<String, Integer> integers = new HashMap<String, Integer>();

		public String getAllUserID() {
			return strings.get("allUserID");
		}

		public void setAllUserID(String allUserID) {
			strings.put("allUserID", allUserID);
		}

		public String getRemainTimes() {
			return strings.get("remainTimes");
		}

		public void setRemainTimes(String remainTimes) {
			strings.put("remainTimes", remainTimes);
		}

		public String getNewToken() {
			return strings.get("newToken");
		}

		public void setNewToken(String newToken) {
			strings.put("newToken", newToken);
		}

		public String getLoginModeFlag() {
			return strings.get("loginModeFlag");
		}

		public void setLoginModeFlag(String loginModeFlag) {
			strings.put("loginModeFlag", loginModeFlag);
		}

		public String getTokenType() {
			return strings.get("tokenType");
		}

		public void setTokenType(String tokenType) {
			strings.put("tokenType", tokenType);
		}

		public String getTokenID() {
			return strings.get("tokenID");
		}

		public void setTokenID(String tokenID) {
			strings.put("tokenID", tokenID);
		}

		public String getTokenStatus() {
			return strings.get("tokenStatus");
		}

		public void setTokenStatus(String tokenStatus) {
			strings.put("tokenStatus", tokenStatus);
		}

		public String getActiveCode() {
			return strings.get("activeCode");
		}

		public void setActiveCode(String activeCode) {
			strings.put("activeCode", activeCode);
		}

		public String getToken() {
			return strings.get("token");
		}

		public void setToken(String token) {
			strings.put("token", token);
		}

		public String getRemainingTimes() {
			return strings.get("remainingTimes");
		}

		public void setRemainingTimes(String remainingTimes) {
			strings.put("remainingTimes", remainingTimes);
		}

		public String getRemainingDays() {
			return strings.get("remainingDays");
		}

		public void setRemainingDays(String remainingDays) {
			strings.put("remainingDays", remainingDays);
		}

		public String getPkValue() {
			return strings.get("pkValue");
		}

		public void setPkValue(String pkValue) {
			strings.put("pkValue", pkValue);
		}

		public String getUserPassword() {
			return strings.get("userPassword");
		}

		public void setUserPassword(String userPassword) {
			strings.put("userPassword", userPassword);
		}

		public String getPlainPassword() {
			return strings.get("plainPassword");
		}

		public void setPlainPassword(String plainPassword) {
			strings.put("plainPassword", plainPassword);
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

		public static Recv failed(Exception e) {
			final Recv recv = new Recv();
			recv.setResponseCode(-1);
			recv.setResponseRemark(e.getMessage());
			return recv;
		}
	}
}
