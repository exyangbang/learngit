package cn.kingnet.utp.channel.onebank.router.handler;

import cn.kingnet.utp.channel.onebank.service.IOnebankPayService;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.exception.ChannelResponseException;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author zhongli
 * @date 2018/10/9
 */
@Slf4j
@Component
public class OnebankChannelPaymentHandler {
    public Mono<ServerResponse> pay(ServerRequest request) {
        String subType = request.pathVariable("subTradeType");
        IOnebankPayService service = getWorkService(subType);
        return ok().body(Mono.fromFuture(service.doSyncWork(request)), Object.class);
    }

    private IOnebankPayService getWorkService(String subType) {
        try {
            UnionPaySubTypeEnum.valueOf(StringUtil.camelToUnderline(subType).toUpperCase());
        } catch (Exception e) {
            log.error("# 异常：{}", e.getMessage(), e);
            throw new ChannelResponseException(HttpStatus.BAD_GATEWAY, "无效的请求类型：".concat(subType));
        }

        Object bean = BeanApplicationContext.getBean(subType);
        if (bean instanceof IOnebankPayService) {
            return (IOnebankPayService) bean;
        }
        throw new ChannelResponseException(HttpStatus.BAD_GATEWAY, "平台未找到此类型渠道服务：".concat(subType));
    }
}
