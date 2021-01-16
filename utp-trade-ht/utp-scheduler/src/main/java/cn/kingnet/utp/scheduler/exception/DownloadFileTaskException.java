package cn.kingnet.utp.scheduler.exception;

/**
 * 下载清算分账文件异常
 * @author WJH
 * @date 2018/9/14
 */
public class DownloadFileTaskException extends RuntimeException {
    private int code;

    public DownloadFileTaskException(String message) {
        super(message);
    }

    public DownloadFileTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloadFileTaskException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DownloadFileTaskException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
