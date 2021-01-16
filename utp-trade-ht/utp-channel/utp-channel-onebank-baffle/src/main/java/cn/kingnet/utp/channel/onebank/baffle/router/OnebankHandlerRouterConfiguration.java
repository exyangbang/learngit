package cn.kingnet.utp.channel.onebank.baffle.router;

import cn.kingnet.utp.channel.onebank.baffle.router.handler.OnebankChannelPaymentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author zhongli
 */
@Configuration
public class OnebankHandlerRouterConfiguration {

    @Bean
    RouterFunction<ServerResponse> routerFunction(OnebankChannelPaymentHandler unionChannelPaymentHandler) {
        return nest(path("/onebank/payment"),
                route(POST("/{subTradeType}").and(accept(MediaType.APPLICATION_JSON_UTF8)), unionChannelPaymentHandler::pay));
    }
}
