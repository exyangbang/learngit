package cn.kingnet.utp.trade.common.exception;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;

/**
 * @Description 持久化异常
 * @Author WJH
 * @Date 2018年09月08日
 */
public class PersistenceException extends TradeException {

    public PersistenceException(HttpRespStatus httpRespStatus, String message) {
        super(httpRespStatus, message);
    }
    public PersistenceException(HttpRespStatus httpRespStatus, String message,Throwable throwable) {
        super(httpRespStatus, message,throwable);
    }

    public PersistenceException(HttpRespStatus httpRespStatus) {
        super(httpRespStatus);
    }

    public PersistenceException(int status, String message) {
        super(status, message);
    }
}
