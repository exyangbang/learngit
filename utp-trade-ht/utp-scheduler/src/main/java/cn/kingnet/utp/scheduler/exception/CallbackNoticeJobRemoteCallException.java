package cn.kingnet.utp.scheduler.exception;

/**
 * @author zhongli
 * @date 2019-02-26 
 *
 */
public class CallbackNoticeJobRemoteCallException extends RuntimeException {
    public CallbackNoticeJobRemoteCallException(String message) {
        super(message);
    }

    public CallbackNoticeJobRemoteCallException(Throwable cause) {
        super(cause);
    }
}
