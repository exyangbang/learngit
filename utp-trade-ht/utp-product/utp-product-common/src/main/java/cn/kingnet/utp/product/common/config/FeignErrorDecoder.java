package cn.kingnet.utp.product.common.config;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/13 15:04
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String resposeBody;
        try {
            if (response == null || response.body() == null) {
                if (response != null && response.status() == 404) {
                    return new TradeException(HttpRespStatus.NOT_FOUND, "远程服务不存在");
                } else {
                    return new TradeException(HttpRespStatus.SERVER_ERROR, "服务器异常");
                }
            }
            resposeBody = Util.toString(response.body().asReader());
            log.error("Feign调用异常 异常信息 ==> {}", resposeBody);
        } catch (IOException e) {
            return new TradeException(HttpRespStatus.SERVER_ERROR, "流读取异常");
        }

        Integer status = null;
        String message = "";
        if (StringUtil.isNotBlank(resposeBody) && resposeBody.contains("TradeException")) {
            JSONObject jsonObject = JSON.parseObject(resposeBody);
            String exceptionClassName = jsonObject.getString("exceptionClassName");
            status = jsonObject.getInteger("status");
            message = jsonObject.getString("message");
            String exception = jsonObject.getString("exception");
            if ("TradeException".equals(exceptionClassName)) {
                if (StringUtil.isBlank(message)) {
                    message = exception;
                }
                TradeException tradeException = new TradeException(status, message);
                tradeException.setException(exception);
                return tradeException;
            }
        } else {
            try {
                JSONObject obj = JSON.parseObject(resposeBody);
                if (obj.containsKey("message")) {
                    message = obj.getString("message");
                }
            } catch (Throwable e) {
                message = resposeBody;
            }

        }

        if (StringUtil.isBlank(message)) {
            message = "Feign调用异常";
        }
        if (status == null) {
            status = HttpRespStatus.SERVER_ERROR.value();
        }
        return new TradeException(status, message);
    }
}
