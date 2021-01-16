package cn.kingnet.product.account.support;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.security.HTSIGNAuthorization;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;

import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2019/01/16
 */
@Slf4j
public class UtpCallbackTemplate {

    private final UtpRestTemplate utpRestTemplate;
    public final HTSIGNAuthorization htsignAuthorization;

    public UtpCallbackTemplate(UtpRestTemplate utpRestTemplate, HTSIGNAuthorization htsignAuthorization) {
        this.utpRestTemplate = utpRestTemplate;
        this.htsignAuthorization = htsignAuthorization;
    }

    /**
     * @param appId        代付客户号
     * @param url          请求地址
     * @param method       请求方法
     * @param reqeustBody  请求对象
     * @param responseType 响应对象
     * @param uriVariables
     * @param <T>
     * @return
     * @throws RestClientException
     */
    public <T> ResponseEntity<T> exchange(String industryCode, String url, HttpMethod method, Object reqeustBody, Class<T> responseType, Object... uriVariables) throws RestClientException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            Map<String, Object> responseMap;
            if (reqeustBody instanceof Map) {
                responseMap = (Map) reqeustBody;
            } else {
                responseMap = BeanMap.create(reqeustBody);
            }
            //字段值为map转jsonString排序
            if (reqeustBody != null) {
                responseMap.entrySet().stream().forEach(entry -> {
                    Object value = entry.getValue();
                    if (value != null && (value instanceof Map || value.getClass().isArray())) {
                        entry.setValue(JSON.toJSONString(entry.getValue()));
                    }
                });
            }
            LambdaLogger.debug(log, "代付客户号:{}  代签未排序数据 :{}", industryCode, JSON.toJSONString(responseMap));
            String sortString = StringUtil.getSortString(responseMap);
            LambdaLogger.debug(log, "代付客户号:{}  代签已排序数据 :{}", industryCode, sortString);

            String authorization = null;
            try {
                authorization = htsignAuthorization.createAuthorizationByAppId(industryCode, sortString);
            } catch (Exception e) {
                throw new RestClientException(String.format("回调加签异常:%s", e.getMessage()), e);
            }
            headers.add("Authorization", authorization);
            LambdaLogger.info(log, "代付客户号:{} << 回调通知地址:{} 回调内容：{}", industryCode, url, JSON.toJSONString(reqeustBody));
            LambdaLogger.debug(log, "代付客户号:{} << authorization:{}", industryCode, authorization);

            HttpEntity requestEntity = new HttpEntity(reqeustBody, headers);

            return utpRestTemplate.get().exchange(url, method, requestEntity, responseType, uriVariables);
        } catch (Exception e) {
            throw new TradeException(HttpRespStatus.NOT_ACCEPTABLE, String.format("回调通知下游[%s:url=%s] 异常信息：[%s]", industryCode, url, e.getMessage()), e);
        }

    }

}
