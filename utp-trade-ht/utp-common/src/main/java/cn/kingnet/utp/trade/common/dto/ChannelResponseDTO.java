package cn.kingnet.utp.trade.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @Description : 渠道响应DTO
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/7 10:28
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
public class ChannelResponseDTO implements Serializable {

    /**
     * 服务端流水号
     */
    private String serverTransId;
    /**
     * 渠道平台流水号
     */
    private String channelRespId;
    /**
     * 渠道返回代码
     */
    private String channelRespCode;
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
    /**
     * 渠道返回的信息
     */
    private Map<String, Object> spRespMsg;
    public ChannelResponseDTO() {
        super();
        setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }


    public ChannelResponseDTO(String status, String message, String exception,
                              String channelRespId, Map<String, Object> spRespMsg) {
        setStatus(status);
        setMessage(message);
        setException(exception);
        setChannelRespId(channelRespId);
        setSpRespMsg(spRespMsg);
        setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public ChannelResponseDTO(String serverTransId) {
        super();
        this.serverTransId = serverTransId;
        setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
