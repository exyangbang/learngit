package cn.kingnet.utp.reconciliation.exception;

/**
 * @author zhongli
 * @date 2018/9/14
 */
public class DownloadFileTaskValidateException extends RuntimeException {
    private int code;

    public DownloadFileTaskValidateException(String message) {
        super(message);
    }

    public DownloadFileTaskValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadFileTaskValidateException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DownloadFileTaskValidateException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
