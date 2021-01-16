package cn.kingnet.utp.trade.common.dto.sp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/11/01
 */
@Getter
@Setter
public class SpBaseResponse implements Serializable {
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

}
