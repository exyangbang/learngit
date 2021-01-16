package cn.kingnet.utp.trade.common.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author zhongli
 */
@Slf4j
@Setter
@Getter
@ToString
public abstract class BaseResponseException extends RuntimeException{
    private final int status;
    private final String exception;
    private final String message;
    private final LocalDateTime timestamp;

    public BaseResponseException(Throwable e) {
        super(e);
        this.exception = e.getClass().getName();
        this.status = 500;
        this.message = e.getMessage();
        this.timestamp = LocalDateTime.now();
    }

    public BaseResponseException(Throwable e,String exception) {
        super(e);
        this.exception = exception;
        this.status = 500;
        this.message = e.getMessage();
        this.timestamp = LocalDateTime.now();
    }

    public BaseResponseException(int status, String exception, String message) {
        this.status = status;
        this.exception = exception;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public BaseResponseException(int status, String message) {
        super(String.format("%s:%s", status, message));
        this.status = status;
        this.message = message;
        this.exception = this.getClass().getName();
        this.timestamp = LocalDateTime.now();
    }

    public BaseResponseException(HttpStatus status, String exception, String message) {
        this(status.value(), exception, message);
    }

    public BaseResponseException(HttpStatus status) {
        this(status.value(), status.getReasonPhrase());
    }

    public BaseResponseException(HttpStatus status, String message) {
        this(status.value(), message);
    }
}
