package cn.kingnet.product.precard.controller;

import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.service.AbstractTradeService;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("v2/precard")
@Slf4j
public class PreCardController {

    private final Map<String, AbstractTradeService> tradeServiceMap = new HashMap<>();

    public PreCardController(@SuppressWarnings("rawtypes") final Collection<AbstractTradeService> abstractTradeServices) {
        super();
        abstractTradeServices.forEach(item -> {
            TradeService ts = AnnotationUtils.findAnnotation(item.getClass(), TradeService.class);
            if (ProductCode.PRECARD.equals(ts.productCode())) {
                tradeServiceMap.put(ts.tradeType().getCode().toLowerCase(), item);
            }
        });
    }

    @PostMapping(value = "/{tradeType}", consumes = {"application/x-www-form-urlencoded"})
    public @ResponseBody
    DeferredResult<Object> service(@PathVariable("tradeType") final String tradeType, @RequestHeader(HttpHeaders.AUTHORIZATION) final String authStr, final HttpServletRequest req, final HttpServletResponse resp) {
        Map<String, Object> parameters = WebUtils.getParametersStartingWith(req, "");
        return this.doService(tradeType, authStr, req, resp, parameters);
    }

    @PostMapping(value = "/{tradeType}", consumes = {"application/json", "application/xml"})
    public @ResponseBody
    DeferredResult<Object> service(@PathVariable("tradeType") final String tradeType, @RequestHeader(HttpHeaders.AUTHORIZATION) final String authStr, @RequestBody final Map<String, Object> map, final HttpServletRequest req, final HttpServletResponse resp) {
        return this.doService(tradeType, authStr, req, resp, map);
    }

    @SuppressWarnings("unchecked")
    protected DeferredResult<Object> doService(String tradeType, final String authStr, final HttpServletRequest req, final HttpServletResponse resp, final Map<String, Object> parameters) {
        DeferredResult<Object> dr = new DeferredResult<Object>();
        if (!this.tradeServiceMap.containsKey(tradeType.toLowerCase())) {
            throw new TradeException(HttpStatus.NOT_FOUND.value(), "不支持的交易类型");
        }
        CompletableFuture
                .supplyAsync(() -> this.tradeServiceMap.get(tradeType.toLowerCase()).doService(authStr, parameters))
                .whenCompleteAsync((responseModel, t) -> {
                    if (t != null) {
                        TradeException te = null;
                        if (t instanceof TradeException) {
                            te = (TradeException) t;
                        } else if (null != t.getCause() && t.getCause() instanceof TradeException) {
                            te = (TradeException) t.getCause();
                        } else if (t instanceof SocketTimeoutException) {
                            te = new TradeException(HttpRespStatus.GATEWAY_TIMEOUT, "请求超时", t);
                        } else {
                            te = new TradeException(HttpRespStatus.SERVER_ERROR, "服务器异常!",t);
                        }
                        log.error("产品：{},交易类型：{},服务错误：{}",ProductCode.PRECARD,tradeType,t.getMessage(),t);
                        Map<String, String> respMap = Maps.newHashMap();
                        respMap.put("status", String.valueOf(te.getStatus()));
                        respMap.put("message", te.getMessage());
                        respMap.put("exception", "");
                        respMap.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                        dr.setResult(respMap);
                    }
                    if (StringUtil.isNotBlank(responseModel.getAuthorization()))
                        resp.setHeader(HttpHeaders.AUTHORIZATION, responseModel.getAuthorization());
                    dr.setResult(responseModel.getResponseBody());
                });
        return dr;
    }
}
