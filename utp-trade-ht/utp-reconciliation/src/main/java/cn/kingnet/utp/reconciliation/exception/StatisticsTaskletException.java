package cn.kingnet.utp.reconciliation.exception;

/**
 * @author zhongli
 * @date 2018/9/17
 */
public class StatisticsTaskletException extends RuntimeException {
    private int code;

    public StatisticsTaskletException(String message) {
        super(message);
    }

    public StatisticsTaskletException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatisticsTaskletException(String message, int code) {
        super(message);
        this.code = code;
    }

    public StatisticsTaskletException(String message, Throwable cause, int code) {
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
