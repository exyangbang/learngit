package cn.kingnet.utp.product.common.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description : 服务响应信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/27 11:16
 */
public class BaseInnerManageRespDTO implements Serializable {

    /**
     * 状态码:httpRespCode一致 2xx 等
     */
    private String status;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 异常信息
     */
    private String exception;
    /**
     * 时间
     */
    private String timestamp;
    /**
     * 数据
     */
    private Object data;

    public BaseInnerManageRespDTO() {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public BaseInnerManageRespDTO(String status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public BaseInnerManageRespDTO(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
