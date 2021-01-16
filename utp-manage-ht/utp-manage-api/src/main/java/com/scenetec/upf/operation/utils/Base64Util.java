package com.scenetec.upf.operation.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Base64;

/**
 * @author shendunyuan@scenetec.com
 * @date 2018/7/23
 */
public class Base64Util {

	public static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * base64加密
	 * @param src
	 * @return
	 */
	public static byte[] encode(String src) {
		return encode(src, DEFAULT_CHARSET);
	}

	/**
	 * base64加密
	 * @param src
	 * @param charset
	 * @return
	 */
	public static byte[] encode(String src, String charset) {
		byte[] res = null;
		try {
			if (StringUtils.isBlank(charset)) {
				charset = DEFAULT_CHARSET;
			}

			byte[] b = src.getBytes(charset);

			res = encode(b);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("base64加密异常");
		}
		return res;
	}

	/**
	 * base64加密
	 * @param src
	 * @return
	 */
	public static byte[] encode(byte[] src) {
		return Base64.getEncoder().encode(src);
	}

	/**
	 * base64解密
	 * @param src
	 * @return
	 */
	public static byte[] decode(String src) {
		return decode(src, DEFAULT_CHARSET);
	}

	/**
	 * base64解密
	 * @param src
	 * @param charset
	 * @return
	 */
	public static byte[] decode(String src, String charset) {
		byte[] res = null;
		try {
			if (StringUtils.isBlank(charset)) {
				charset = DEFAULT_CHARSET;
			}

			byte[] b = src.getBytes(charset);

			res = decode(b);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("base64解密异常");
		}
		return res;
	}

	/**
	 * base64解密
	 * @param src
	 * @return
	 */
	public static byte[] decode(byte[] src) {
		return Base64.getDecoder().decode(src);
	}
}
