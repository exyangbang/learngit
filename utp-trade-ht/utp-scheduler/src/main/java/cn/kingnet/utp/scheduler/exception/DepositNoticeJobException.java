package cn.kingnet.utp.scheduler.exception;

/**
 * @author zhongli
 * @date 2019-02-26 
 *
 */
public class DepositNoticeJobException extends RuntimeException {
    public DepositNoticeJobException(String message) {
        super(message);
    }

    public DepositNoticeJobException(Throwable cause) {
        super(cause);
    }
}
