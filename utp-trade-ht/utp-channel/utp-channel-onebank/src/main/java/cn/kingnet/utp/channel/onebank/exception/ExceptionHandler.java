package cn.kingnet.utp.channel.onebank.exception;

import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.exception.ChannelResponseException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * 统一异常处理
 *
 * @Auther: zhongli
 * @Date: 2018/7/20
 */
@Component
@Slf4j
@Order(Integer.MIN_VALUE)
public class ExceptionHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = "服务器未知错误。请求失败";
        if (ex instanceof ChannelResponseException) {
            httpStatus = HttpStatus.valueOf(((ChannelResponseException) ex).getStatus());
            message = ex.getMessage();
        } else if (ex.getCause() instanceof ChannelResponseException) {
            httpStatus = HttpStatus.valueOf(((ChannelResponseException) ex.getCause()).getStatus());
            message = ex.getCause().getMessage();
        }
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
        response.setStatusCode(httpStatus);
        message = JSON.toJSONString(ChannelResponseDTO.builder().status(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).message(message).exception(ex.getMessage()).build());
        DataBuffer db = response.bufferFactory().wrap(message.getBytes());
        return response.writeWith(Mono.just(db));
    }
}
