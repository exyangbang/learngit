package cn.kingnet.utp.scheduler.exception;

/**
 * @author zhongli
 * @date 2019-02-26 
 *
 */
public class CallbackNoticeJobException extends RuntimeException {
    public CallbackNoticeJobException(String message) {
        super(message);
    }

    public CallbackNoticeJobException(Throwable cause) {
        super(cause);
    }
}
