package cn.kingnet.utp.trade.common.exception;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;

/**
 * @Description : 文件交互异常
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 10:38
 */
public class FileManageException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int status;
    private String message;
    private String exception;

    public FileManageException(HttpRespStatus httpRespStatus, String message, Throwable throwable) {
        super(throwable);
        this.status = httpRespStatus.value();
        this.message = message;
    }

    public FileManageException(HttpRespStatus httpRespStatus, String message) {
        this(httpRespStatus.value(), message);
    }

    public FileManageException(HttpRespStatus httpRespStatus) {
        this(httpRespStatus, httpRespStatus.getReasonPhrase());
    }

    public FileManageException(int status, String message) {
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

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FileManageException {" +
                "status=" + status +
                ", message='" + message +
                "',exception='" + exception +
                "'}";
    }
}
