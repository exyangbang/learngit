package com.scenetec.upf.operation.model.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description : 服务响应信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/27 11:16
 */
public class ServerResponseDTO implements Serializable {

    /**
     * 状态码:httpRespCode一致 2xx 等
     */
    private String status;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 时间
     */
    private String timestamp;
    /**
     * 数据
     */
    private Object data;

    public ServerResponseDTO() {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public ServerResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public ServerResponseDTO(String status, String message, String timestamp, Object data) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
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
}
