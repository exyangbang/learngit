package cn.kingnet.product.account.support;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author WJH
 * @Date 2020/03/11
 */
@Slf4j
public class AbortRejectedLogHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        String message = "策略终止任务：Task[" + r.toString() + "] rejected from " + executor.toString();
        LambdaLogger.error(log, message);
        throw new TradeException(HttpRespStatus.FORBIDDEN, message);
    }
}
