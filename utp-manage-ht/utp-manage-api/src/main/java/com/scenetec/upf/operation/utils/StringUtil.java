package com.scenetec.upf.operation.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author shendunyuan@scenetec.com
 * @date 2018/7/23
 */
public class StringUtil {

	public static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * byte数组转字符串
	 * @param src
	 * @return
	 */
	public static String byte2String(byte[] src) {
		return byte2String(src, DEFAULT_CHARSET);
	}

	/**
	 * byte数组转字符串
	 * @param src
	 * @param charset
	 * @return
	 */
	public static String byte2String(byte[] src, String charset) {
		String res = null;
		try {
			if (src == null) {
				res = "";
			} else {
				if (StringUtils.isBlank(charset)) {
					charset = DEFAULT_CHARSET;
				}

				res = new String(src, charset);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("byte数组转String异常");
		}
		return res;
	}

	/**
	 * 字符串转byte数组
	 * @param src
	 * @return
	 */
	public static byte[] string2Byte(String src) {
		return string2Byte(src, DEFAULT_CHARSET);
	}

	/**
	 * 字符串转byte数组
	 * @param src
	 * @param charset
	 * @return
	 */
	public static byte[] string2Byte(String src, String charset) {
		byte[] res = null;
		try {
			if (src == null) {
				src = "";
			}

			if (StringUtils.isBlank(charset)) {
				charset = DEFAULT_CHARSET;
			}

			res = src.getBytes(charset);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("字符串转byte数组异常");
		}
		return res;
	}

	/**
	 * 转换string
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		String res = "";
		if (obj != null) {
			res = String.valueOf(obj);
		}
		return res;
	}
}
