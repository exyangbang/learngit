package cn.kingnet.utp.trade.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * @author zhongli
 */
@Slf4j
public class ChannelResponseException extends BaseResponseException {
    private static final long serialVersionUID = 1L;

    public ChannelResponseException(Throwable e) {
        super(e);
    }

    public ChannelResponseException(int status, String exception, String message) {
        super(status, exception, message);
    }

    public ChannelResponseException(int status, String message) {
        super(status, message);
    }

    public ChannelResponseException(HttpStatus status, String exception, String message) {
        super(status, exception, message);
    }

    public ChannelResponseException(HttpStatus status) {
        super(status);
    }

    public ChannelResponseException(HttpStatus status, String message) {
        super(status, message);
    }
}