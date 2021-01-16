package cn.kingnet.utp.trade.common.utils;

import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ChannelException;
import org.springframework.cglib.beans.BeanMap;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description 构造ChannelResponseDTO
 * @Author WJH
 * @Date 2018年09月08日
 */
public class ChannelResponseUtil {

    @SuppressWarnings("unchecked")
    public static <T> ChannelResponseDTO success(T data, String channelRespId, String channelRespCode) {
        ChannelResponseDTO result = new ChannelResponseDTO();
        result.setStatus(HttpRespStatus.OK.valueStr());
        result.setMessage(HttpRespStatus.OK.getReasonPhrase());
        result.setChannelRespId(channelRespId);
        result.setSpRespMsg(toMap(data));
        result.setChannelRespCode(channelRespCode);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> ChannelResponseDTO build(T data, String channelRespId, String channelRespCode, HttpRespStatus status, String... msg) {
        ChannelResponseDTO result = new ChannelResponseDTO();
        result.setStatus(status.valueStr());
        result.setMessage(msg != null ? Arrays.toString(msg) : status.getReasonPhrase());
        result.setChannelRespId(channelRespId);
        result.setSpRespMsg(toMap(data));
        result.setChannelRespCode(channelRespCode);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> ChannelResponseDTO fail(T data, HttpRespStatus status, String msg) {
        ChannelResponseDTO result = new ChannelResponseDTO();
        result.setStatus(status.valueStr());
        result.setMessage(msg != null ? msg : status.getReasonPhrase());
        result.setSpRespMsg(toMap(data));
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> ChannelResponseDTO exception(T data, String channelRespId, String channelRespCode, ChannelException ce) {
        ChannelResponseDTO result = new ChannelResponseDTO();
        result.setStatus(String.valueOf(ce.getStatus()));
        result.setMessage(ce.getMessage());
        result.setChannelRespId(channelRespId);
        result.setSpRespMsg(toMap(data));
        result.setChannelRespCode(channelRespCode);
        return result;
    }

    public static <T> ChannelResponseDTO exception(T data, HttpRespStatus status, String msg, String exceptionMsg) {
        ChannelResponseDTO result = new ChannelResponseDTO();
        result.setStatus(status == null ? HttpRespStatus.SERVER_ERROR.valueStr() : status.valueStr());
        result.setSpRespMsg(toMap(data));
        result.setMessage(msg);
        result.setException(exceptionMsg);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(Object data) {
        Map<String, Object> reMap = null;
        if (data != null) {
            if (data instanceof Map) {
                reMap = (Map) data;
            } else {
                reMap = BeanMap.create(data);
            }
        }
        return reMap;
    }
}
