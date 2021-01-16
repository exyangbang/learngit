package com.scenetec.upf.operation.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
public class ErrorResponse {
    /**
     *HTTP Response Status Code
     */
    private final HttpStatus status;

    /** General Error message
     * */
    private final String message;

    /**
    *Error code
     */
    private final String errorCode;

    private final Date timestamp;

    protected ErrorResponse(final String message, final String errorCode, HttpStatus status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.timestamp = new Date();
    }

    public static ErrorResponse of(final String message, final String errorCode, HttpStatus status) {
        return new ErrorResponse(message, errorCode, status);
    }

    public Integer getStatus() {
        return status.value();
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
