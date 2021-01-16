package cn.kingnet.utp.service.persistence;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class ExceptionResolver {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Object handler(Exception e) throws Exception {
        log.error(e.getMessage(), e);
        if (e instanceof IllegalArgumentException) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, e.getMessage());
        } else if (e instanceof TradeException) {
            TradeException e1 = (TradeException) e;
            Map<String, Object> responseMap = Maps.newHashMap();
            responseMap.put("status", e1.getStatus());
            responseMap.put("message", e.getMessage());
            responseMap.put("exception", e1.getException());
            responseMap.put("exceptionClassName", "TradeException");
            return responseMap;
        } else {
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, e.getMessage());
        }
    }
}