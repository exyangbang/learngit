package cn.kingnet.utp.trade.common.model;


import org.apache.http.Header;

import java.io.Serializable;

/**
 * 服务层响应包装模型
 * Created on 2018/5/16
 *
 * @author by Benjamin.Huang
 */
public class ResponseModel implements Serializable {

    /**
     * 授权信息
     */
    private String authorization;

    /**
     * 响应信息
     */
    private Object responseBody;

    /**
     * 响应头内容类型
     */
    private Header respContentType;

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }

    public Header getRespContentType() {
        return respContentType;
    }

    public void setRespContentType(Header respContentType) {
        this.respContentType = respContentType;
    }
}
