package cn.kingnet.utp.scheduler.exception;

/**
 * @author zhongli
 * @date 2019-02-26 
 *
 */
public class DepositNoticeJobRemoteCallException extends RuntimeException {
    public DepositNoticeJobRemoteCallException(String message) {
        super(message);
    }

    public DepositNoticeJobRemoteCallException(Throwable cause) {
        super(cause);
    }
}
