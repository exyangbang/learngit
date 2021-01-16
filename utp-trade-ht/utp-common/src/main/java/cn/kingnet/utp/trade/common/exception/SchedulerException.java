package cn.kingnet.utp.trade.common.exception;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;

/**
 * @Description 调度服务异常
 * @Author WJH
 * @Date 2018年09月08日
 */
public class SchedulerException extends TradeException {

    public SchedulerException(HttpRespStatus httpRespStatus, String message) {
        super(httpRespStatus, message);
    }

    public SchedulerException(HttpRespStatus httpRespStatus, String message,Throwable throwable) {
        super(httpRespStatus, message,throwable);
    }

    public SchedulerException(HttpRespStatus httpRespStatus) {
        super(httpRespStatus);
    }

    public SchedulerException(int status, String message) {
        super(status, message);
    }
}
