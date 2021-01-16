package cn.kingnet.utp.sdk.core;

import cn.kingnet.utp.sdk.core.auth.Authorization;
import cn.kingnet.utp.sdk.core.auth.impl.HtSignAuthorization;
import cn.kingnet.utp.sdk.core.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.*;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

@Slf4j
public abstract class UtpClient {
    protected final static Properties properties = new Properties();

    protected final AsyncHttpClient asyncHttpClient;
    protected final Authorization authorization;
    private final String host;

    final static String ACCEPT = "accept";
    final static String APPLICATION_JSON = "application/json";
    final static String ACCEPT_CHARSET = "accept-charset";
    final static String CONTENT_TYPE = "content-type";
    final static String AUTHORIZATION = "authorization";

    public UtpClient(final Authorization authorization, final String host) {
        super();
        this.authorization = authorization;
        this.asyncHttpClient = new DefaultAsyncHttpClient(createAsyncHttpClientConfig());
        this.host = host;
    }

    static {
        try {
            InputStream in = UtpClient.class.getResourceAsStream("/utp.properties");
            if (null == in) {
                in = UtpClient.class.getClassLoader().getResourceAsStream("/utp.properties");
            }
            properties.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static AsyncHttpClientConfig createAsyncHttpClientConfig() {
        final DefaultAsyncHttpClientConfig.Builder builder = new DefaultAsyncHttpClientConfig.Builder();
        builder.setUserAgent(
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36 FSCLOUD/0.0.1 (UMS)");
        builder.setConnectTimeout(5000);
        builder.setReadTimeout(60000);
        return builder.build();
    }

    public String getHost() {
        return host;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    @Slf4j
    public static class Builder<RESP> {
        private final String url;
        private final AsyncHttpClient asyncHttpClient;
        private final Authorization authorization;
        private final Class<RESP> responseClass;
        private Map<String, String> data = new HashMap();

        @SuppressWarnings("unchecked")
        protected Builder(final AsyncHttpClient asyncHttpClient,
                          final Authorization authorization,
                          final Class<RESP> responseClass,
                          final String host,
                          final String url) {
            super();
            this.asyncHttpClient = asyncHttpClient;
            this.authorization = authorization;
            this.url = String.format("%s%s", host, url);
            this.responseClass = responseClass;
        }

        @SuppressWarnings("unused")
        public Builder<RESP> set(String name, String value) {
            if (null == name || null == value) {
                throw new IllegalArgumentException("参数不能为空");
            }
            this.data.put(name, value);
            return this;
        }

        public Builder<RESP> setReqData(Object reqData) {
            if (reqData == null) {
                throw new IllegalArgumentException("参数不能为空");
            }
            Map<String, String> reqMap = JSON.parseObject(JSON.toJSONBytes(reqData), Map.class);
            this.data.putAll(reqMap);
            return this;
        }

        public Map<String, String> getReqData() {
            return this.data;
        }

        @SuppressWarnings("unused")
        private BoundRequestBuilder initRequestBuilder() {
            try {
                final BoundRequestBuilder requestBuilder = this.asyncHttpClient.preparePost(url);
                String headAuthorization = this.authorization.createAuthorization(data);
                String reqJsonBody = JSON.toJSONString(data);
                requestBuilder.addHeader(ACCEPT, APPLICATION_JSON);
                requestBuilder.addHeader(ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
                requestBuilder.addHeader(CONTENT_TYPE, APPLICATION_JSON);
                requestBuilder.addHeader(AUTHORIZATION, headAuthorization);
                requestBuilder.setBody(reqJsonBody);
                requestBuilder.setCharset(StandardCharsets.UTF_8);

                if (this.authorization instanceof HtSignAuthorization) {
                    log.info("请求客户号:{} >> 请求地址:{}", ((HtSignAuthorization) this.authorization).getIndustryCode(), this.url);
                } else {
                    log.info("请求地址:{}", this.url);
                }


                return requestBuilder;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @SuppressWarnings("unused")
        public CompletableFuture<RESP> execute() {
            try {
                final BoundRequestBuilder requestBuilder = this.initRequestBuilder();
                return requestBuilder.execute().toCompletableFuture().thenApplyAsync(this::parse);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * 文件下载
         *
         * @return
         */
        @SuppressWarnings("unused")
        public CompletableFuture<InputStream> executeDownload() {
            try {
                final BoundRequestBuilder requestBuilder = this.initRequestBuilder();
                return requestBuilder.execute().toCompletableFuture().thenApplyAsync(this::parseDownload);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        protected RESP parse(Response response) {
            String msg = null;
            if (response.getStatusCode() != 200) {
                msg = response.getResponseBody();
                if (null == msg) {
                    msg = response.getStatusText();
                }
                throw new HttpException(response.getStatusCode(), msg);
            }
            Map<String, String> respMap = JSON.parseObject(response.getResponseBody(), Map.class);
            String authorization = response.getHeader(AUTHORIZATION);
            if (!StringUtil.isEmpty(authorization)) {
                String[] authAy = authorization.split(":");
                String industryCode = authAy[1];
                String signed = authAy[2];
                String timestamp = authAy[3];
                if (!this.authorization.verifyAuthorization(signed, timestamp, respMap)) {
                    throw new HttpException(response.getStatusCode(), industryCode + " 返回报文验签失败:" + response.getResponseBody());
                }
            }

            return JSON.parseObject(response.getResponseBody(), this.responseClass);

        }

        protected InputStream parseDownload(Response response) {
            String msg;
            if (response.getStatusCode() != 200) {
                msg = response.getResponseBody();
                if (null == msg) {
                    msg = response.getStatusText();
                }
                throw new HttpException(response.getStatusCode(), msg);
            }
            String respData = null;
            try {
                return response.getResponseBodyAsStream();
            } catch (Exception e) {
                throw new HttpException(response.getStatusCode(), "返回报文解析异常: " + respData);
            }
        }
    }

}
