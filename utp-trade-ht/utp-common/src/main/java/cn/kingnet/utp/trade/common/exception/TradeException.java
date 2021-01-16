package cn.kingnet.utp.trade.common.exception;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;

/**
 * @Description : 交易异常
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 10:38
 */
public class TradeException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int status;
    private String message;
    private String exception;

    public TradeException(HttpRespStatus httpRespStatus,String message,Throwable throwable) {
        super(throwable);
        this.status = httpRespStatus.value();
        this.message = message;
    }

    public TradeException(HttpRespStatus httpRespStatus,String message) {
        this(httpRespStatus.value(),message);
    }

    public TradeException(HttpRespStatus httpRespStatus) {
        this(httpRespStatus,httpRespStatus.getReasonPhrase());
    }

    public TradeException(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TradeException {" +
                "status=" + status +
                ", message='" + message +
                "',exception='" + exception +
                "'}";
    }
}
