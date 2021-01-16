package cn.kingnet.utp.trade.common.exception;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;

/**
 * @Description 产品服务异常
 * @Author WJH
 * @Date 2018年09月08日
 */
public class ProductException extends TradeException {

    public ProductException(HttpRespStatus httpRespStatus, String message) {
        super(httpRespStatus, message);
    }

    public ProductException(HttpRespStatus httpRespStatus, String message,Throwable e) {
        super(httpRespStatus, message,e);
    }

    public ProductException(HttpRespStatus httpRespStatus) {
        super(httpRespStatus);
    }

    public ProductException(int status, String message) {
        super(status, message);
    }
}
