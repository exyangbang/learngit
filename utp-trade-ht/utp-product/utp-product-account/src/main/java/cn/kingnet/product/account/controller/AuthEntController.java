package cn.kingnet.product.account.controller;

import cn.kingnet.product.account.service.inner.manage.AuthEntAuditService;
import cn.kingnet.utp.product.common.dto.AuthEntAccountDto;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.UtpCallbackException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @Description 内部调用
 */
@RestController
@RequestMapping("innerAccount/auth")
@Slf4j
public class AuthEntController extends DefaultFeginExceptionHandler {

    private final AuthEntAuditService authEntAuditService;

    public AuthEntController(AuthEntAuditService authEntAuditService) {
        this.authEntAuditService = authEntAuditService;
    }

    @PostMapping("ent")
    public DeferredResult<Object> authEnt(@RequestBody AuthEntAccountDto authEntAccountDto) {
        LambdaLogger.debug(log, l -> l.debug("开户认证审核请求报文：{}", JSON.toJSONString(authEntAccountDto)));
        DeferredResult<Object> dr = new DeferredResult<Object>();
        CompletableFuture.supplyAsync(() -> authEntAuditService.audit(authEntAccountDto))
                .whenCompleteAsync((r, e) -> {
                    Map<String, String> respMap = Maps.newHashMap();
                    if (e == null && r == HttpRespStatus.OK) {
                        respMap.put("status", HttpRespStatus.OK.valueStr());
                        respMap.put("message", "操作成功");
                    } else if (e instanceof UtpCallbackException) {
                        respMap.put("status", HttpRespStatus.OK.valueStr());
                        respMap.put("message", e.getMessage());
                    } else {
                        respMap.put("status", HttpRespStatus.BAD_REQUEST.valueStr());
                        respMap.put("message", e == null ? "服务器异常" : e.getMessage());
                        respMap.put("exception", e == null ? null : e.getLocalizedMessage());
                    }
                    LambdaLogger.debug(log, l -> l.debug("开户认证审核响应报文：{}", JSON.toJSONString(respMap)));
                    dr.setResult(respMap);
                });
        return dr;
    }
}
