package cn.kingnet.utp.reconciliation.exception;

/**
 * @author zhongli
 * @date 2018/9/17
 */
public class UpdateRecordTaskletException extends RuntimeException {
    private int code;

    public UpdateRecordTaskletException(String message) {
        super(message);
    }

    public UpdateRecordTaskletException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateRecordTaskletException(String message, int code) {
        super(message);
        this.code = code;
    }

    public UpdateRecordTaskletException(String message, Throwable cause, int code) {
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
