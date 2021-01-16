package cn.kingnet.utp.reconciliation.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class ExceptionResolver {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public InternalResponse handler(Exception e) {
        log.error(e.getMessage(), e);
        return new InternalResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}