package cn.kingnet.utp.trade.common.exception;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * @Description : 异常拦截处理
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/13 16:23
 */
public class DefaultFeginExceptionHandler {

    /**
     * 拦截各个服务的具体异常
     */
    @ExceptionHandler(TradeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object apiService(TradeException e) {
        Map<String,Object> responseMap = Maps.newHashMap();
        responseMap.put("status",e.getStatus());
        responseMap.put("message",e.getMessage());
        responseMap.put("exception",e.getException());
        responseMap.put("exceptionClassName","TradeException");
        return responseMap;
    }
}
