package cn.kingnet.utp.reconciliation.exception;

/**
 * @author zhongli
 * @date 2018/9/17
 */
public class ReconciliationProcessorException extends RuntimeException {
    private int code;

    public ReconciliationProcessorException(String message) {
        super(message);
    }

    public ReconciliationProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReconciliationProcessorException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ReconciliationProcessorException(String message, Throwable cause, int code) {
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
