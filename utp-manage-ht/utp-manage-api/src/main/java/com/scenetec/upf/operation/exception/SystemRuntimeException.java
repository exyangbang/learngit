package com.scenetec.upf.operation.exception;

/**
 * @author luoxianjun
 */
public class SystemRuntimeException extends RuntimeException{
    /**
     * 错误码
     */
    private ErrorCode code;
    /**
     * 嵌套异常
     */
    private Exception exception;
    /**
     * 错误信息参数
     */
    private String[] args;

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SystemRuntimeException(){
    }

    public SystemRuntimeException(ErrorCode code, String... args){
        this.code = code;
        this.args = args;
    }

    public SystemRuntimeException(ErrorCode code, Exception exception, String... args){
        this.code = code;
        this.args = args;
        this.exception = exception;
    }

    public SystemRuntimeException(ErrorCode code, Exception exception){
        this.code = code;
        this.exception = exception;
    }

    public String[] getArgs() {
        return args;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public ErrorCode getCode() {
        return code;
    }

    public Exception getException() {
        return exception;
    }
}
