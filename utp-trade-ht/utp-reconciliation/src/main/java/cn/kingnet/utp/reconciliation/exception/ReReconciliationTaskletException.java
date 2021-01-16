package cn.kingnet.utp.reconciliation.exception;

/**
 * @author zhongli
 * @date 2018/9/17
 */
public class ReReconciliationTaskletException extends RuntimeException {
    private int code;

    public ReReconciliationTaskletException(String message) {
        super(message);
    }

    public ReReconciliationTaskletException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReReconciliationTaskletException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ReReconciliationTaskletException(String message, Throwable cause, int code) {
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
