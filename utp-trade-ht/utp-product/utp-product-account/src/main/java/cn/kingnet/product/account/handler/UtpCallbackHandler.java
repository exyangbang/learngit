package cn.kingnet.product.account.handler;

import cn.kingnet.product.account.support.UtpCallbackTemplate;
import cn.kingnet.product.api.account.IUtpCallbackHandler;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description : UTP回调外部系统
 */
@RestController
@RequestMapping("/innerAccount/utpCallback")
@Slf4j
public class UtpCallbackHandler implements IUtpCallbackHandler {

    private final UtpCallbackTemplate utpCallbackTemplate;

    public UtpCallbackHandler(UtpCallbackTemplate utpCallbackTemplate) {
        this.utpCallbackTemplate = utpCallbackTemplate;
    }

    @Override
    @PostMapping("/callbackNotice")
    public boolean callbackNotice(@RequestParam("industryCode") String industryCode, @RequestParam("callbackUrl") String callbackUrl, @RequestBody(required = false) Map<String, Object> content) {
        try {
            ResponseEntity responseEntity = utpCallbackTemplate.exchange(industryCode, callbackUrl, HttpMethod.POST, content, Object.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                //代码和文档不一致 需兼容返回 success 或 {"status":"200"} 校验响应处理成功标志 后续规范统一处理
                String respBody = JSON.toJSONString(responseEntity.getBody());
                if ("success".equalsIgnoreCase(respBody) || respBody.contains("200")) {
                    return true;
                } else {
                    LambdaLogger.error(log, log -> log.error("回调通知应答[{}:{}] 响应内容[{}]不规范", industryCode, callbackUrl, respBody));
                }
            } else {
                LambdaLogger.error(log, log -> log.error("回调通知应答[{}:{}] 响应状态码[{}]非成功", industryCode, callbackUrl, responseEntity.getStatusCode().value()));
            }
        } catch (Exception e) {
            log.error("回调通知异常：{}", e.getMessage(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST,e.getMessage());
        }
        return false;
    }
}
