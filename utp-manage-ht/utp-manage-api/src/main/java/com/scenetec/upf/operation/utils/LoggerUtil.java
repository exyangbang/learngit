package com.scenetec.upf.operation.utils;

import org.slf4j.Logger;

/**
 * @author shendunyuan
 * 2018/07/17
 */
public class LoggerUtil {

	/**
	 * 日志统一处理类
	 * @param logger
	 * @param msg
	 * @param params
	 */
	public static void logger(Logger logger, String msg, Object... params) {
		if (logger != null) {
			if (logger.isDebugEnabled()) {
				logger.debug(msg, params);
			} else if (logger.isInfoEnabled()) {
				logger.info(msg, params);
			} else {
				logger.error(msg, params);
			}
		}
	}
}
