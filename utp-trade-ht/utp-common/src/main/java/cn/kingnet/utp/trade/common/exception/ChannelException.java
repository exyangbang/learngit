package cn.kingnet.utp.trade.common.exception;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;

/**
 * @Description 渠道异常
 * @Author WJH
 * @Date 2018年09月08日
 */
public class ChannelException extends TradeException {

    public ChannelException(HttpRespStatus httpRespStatus, String message,Throwable throwable) {
        super(httpRespStatus, message,throwable);
    }
    public ChannelException(HttpRespStatus httpRespStatus, String message) {
        super(httpRespStatus, message);
    }

    public ChannelException(HttpRespStatus httpRespStatus) {
        super(httpRespStatus);
    }

    public ChannelException(int status, String message) {
        super(status, message);
    }
}
