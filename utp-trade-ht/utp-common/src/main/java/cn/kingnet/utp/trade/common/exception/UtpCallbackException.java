package cn.kingnet.utp.trade.common.exception;

/**
 * @author zhongli
 * @date 2019-02-26 
 *
 */
public class UtpCallbackException extends RuntimeException {
    public UtpCallbackException(String message) {
        super(message);
    }

    public UtpCallbackException(Throwable cause) {
        super(cause);
    }
}