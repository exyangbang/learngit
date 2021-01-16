package cn.kingnet.utp.scheduler.exception;

/**
 *  平台账户同步异常
 * @author WJH
 * @date 2018/9/14
 */
public class SyncIndustryAccountException extends RuntimeException {
    private int code;

    public SyncIndustryAccountException(String message) {
        super(message);
    }

    public SyncIndustryAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public SyncIndustryAccountException(String message, int code) {
        super(message);
        this.code = code;
    }

    public SyncIndustryAccountException(String message, Throwable cause, int code) {
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
