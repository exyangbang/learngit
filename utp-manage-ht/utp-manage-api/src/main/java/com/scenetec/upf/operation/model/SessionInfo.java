package com.scenetec.upf.operation.model;

import org.springframework.http.HttpHeaders;

/**
 * 会话信息类
 * Created on 2018/7/17
 *
 * @author by Benjamin.Huang
 */
public class SessionInfo {

    public static final String HEADER_PARAM_AUTHORIZATION = "X-Authorization";
    public static final String HEADER_PARAM_REQUESTED_WITH = "X-Requested-With";
    public static final String HEADER_PARAM_CONTENT_TYPE = "Content-Type";
    public static final String REQUEST_PARAM_SESSION_INFO = "session_info";

    private String loginName;

    private String authorization;

    private String contentType;

    private String requestedWith;

    private String clientIp;

    private String requestPath;

    private String requestMethod;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getRequestedWith() {
        return requestedWith;
    }

    public void setRequestedWith(String requestedWith) {
        this.requestedWith = requestedWith;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public HttpHeaders getHttpHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_PARAM_AUTHORIZATION, this.getAuthorization());
        headers.add(HEADER_PARAM_CONTENT_TYPE, this.getContentType());
        headers.add(HEADER_PARAM_REQUESTED_WITH, this.getRequestedWith());
        return headers;
    }
}
