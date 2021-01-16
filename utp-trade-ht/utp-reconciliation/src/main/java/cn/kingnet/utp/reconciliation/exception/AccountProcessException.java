package cn.kingnet.utp.reconciliation.exception;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/23 19:34
 */
public class AccountProcessException extends RuntimeException {

    private int code;

    public AccountProcessException(String message) {
        super(message);
    }

    public AccountProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountProcessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public AccountProcessException(String message, Throwable cause, int code) {
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
