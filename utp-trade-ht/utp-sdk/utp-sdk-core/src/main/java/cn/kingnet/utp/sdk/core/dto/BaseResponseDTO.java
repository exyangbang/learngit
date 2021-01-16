package cn.kingnet.utp.sdk.core.dto;

import java.io.Serializable;

/**
 * Created on 2018/5/17
 *
 * @author by linkaigui
 */
public class BaseResponseDTO implements Serializable {

    /**
     * 客户端流水号
     */
    private String clientTradeId;
    /**
     * 服务端流水号
     */
    private String serverTradeId;
    /**
     * 状态码
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

    public String getClientTradeId() {
        return clientTradeId;
    }

    public void setClientTradeId(String clientTradeId) {
        this.clientTradeId = clientTradeId;
    }

    public String getServerTradeId() {
        return serverTradeId;
    }

    public void setServerTradeId(String serverTradeId) {
        this.serverTradeId = serverTradeId;
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

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
