package cn.kingnet.product.account.controller;

import brave.Span;
import brave.Tracer;
import cn.kingnet.product.account.support.AbortRejectedLogHandler;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.service.AbstractTradeService;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("v2/account")
@Slf4j
public class AccountController {

    private final Map<String, AbstractTradeService> tradeServiceMap = new HashMap<>();
    private final ExecutorService accountWorkTaskExec;
    private final static String[] INNER_SERVS = new String[]{
            TradeType.INNER_WITHDRAW.getCode().toLowerCase(),
            TradeType.INNER_QUERY_WITHDRAW.getCode().toLowerCase(),
            TradeType.COLLECT_ACCOUNT_WITHDRAW.getCode().toLowerCase(),
            TradeType.AUTH_ENT.getCode().toLowerCase(),
            TradeType.BIND_ENT.getCode().toLowerCase()
    };
    private Tracer tracer;

    private boolean isInnerService(String tradeType) {
        return Arrays.asList(INNER_SERVS).contains(tradeType.toLowerCase());
    }

    public AccountController(@SuppressWarnings("rawtypes") final Collection<AbstractTradeService> abstractTradeServices, Tracer tracer) {
        super();
        this.tracer = tracer;
        abstractTradeServices.forEach(item -> {
            TradeService ts = AnnotationUtils.findAnnotation(item.getClass(), TradeService.class);
            if (ProductCode.ACCOUNT.equals(ts.productCode()) && !isInnerService(ts.tradeType().getCode().toLowerCase()) && !ts.isManageService()) {
                tradeServiceMap.put(ts.tradeType().getCode().toLowerCase(), item);
            }
        });
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("accountWorkTask-%s").build();
        accountWorkTaskExec = new ThreadPoolExecutor(32, 480, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(320), threadFactory, new AbortRejectedLogHandler());
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
            dr.setResult(buildRespException(HttpRespStatus.NOT_FOUND.valueStr(), "不支持的交易类型", ""));
            return dr;
        }
        String remoteIp = getRemoteIpAddress(req);
        Span span = tracer.currentSpan();
        CompletableFuture
                .supplyAsync(() -> {
                    //异步代码保留原有的spanId和traceId需要在异步调用前 Span span = tracer.currentSpan();异步方法设置 tracer.withSpanInScope(span)
                    try (Tracer.SpanInScope cleared = tracer.withSpanInScope(span)) {
                        return this.tradeServiceMap.get(tradeType.toLowerCase()).setRemoteIp(remoteIp).doService(authStr, parameters);
                    } catch (Exception e) {
                        throw e;
                    }
                }, accountWorkTaskExec)
                .whenCompleteAsync((responseModel, t) -> {
                    if (t != null) {
                        TradeException te = null;
                        if (t instanceof TradeException) {
                            te = (TradeException) t;
                        } else if (null != t.getCause() && t.getCause() instanceof TradeException) {
                            te = (TradeException) t.getCause();
                        } else if (t instanceof SocketTimeoutException) {
                            te = new TradeException(HttpRespStatus.GATEWAY_TIMEOUT, "请求超时!", t);
                        } else {
                            te = new TradeException(HttpRespStatus.SERVER_ERROR, "服务器异常!", t);
                        }
                        log.error("产品：{},交易类型：{},服务错误：{}", ProductCode.ACCOUNT, tradeType, t.getMessage(), t);
                        Map<String, String> respMap = buildRespException(String.valueOf(te.getStatus()), te.getMessage(), "");
                        dr.setResult(respMap);
                    }
                    if (StringUtil.isNotBlank(responseModel.getAuthorization())) {
                        resp.setHeader(HttpHeaders.AUTHORIZATION, responseModel.getAuthorization());
                    }
                    dr.setResult(responseModel.getResponseBody());
                }, accountWorkTaskExec);
        return dr;
    }

    private Map<String, String> buildRespException(String status, String message, String exceptionMsg) {
        Map<String, String> respMap = Maps.newHashMap();
        respMap.put("status", status);
        respMap.put("message", message);
        respMap.put("exception", exceptionMsg);
        respMap.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return respMap;
    }

    /**
     * 获取远程IP
     *
     * @param request
     * @return IP Address
     */
    public static String getRemoteIpAddress(HttpServletRequest request) {
        String ip = null;
        try {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            if (StringUtil.isNotBlank(ip)) {
                ip = ip.split(",")[0];
            }
        } catch (Exception e) {
            log.error("获取客户端远程Ip异常：{}", e.getMessage());
        }
        return ip;
    }

}
