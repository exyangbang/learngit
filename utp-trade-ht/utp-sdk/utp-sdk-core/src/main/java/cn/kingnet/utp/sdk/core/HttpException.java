package cn.kingnet.utp.sdk.core;

public class HttpException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final int code;
    private final String message;

    public HttpException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
