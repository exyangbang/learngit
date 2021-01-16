package cn.kingnet.product.account.support;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.trade.common.utils.SSLSocketClient;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhongli
 * @Date: 2018/7/24
 */
@Slf4j
public class UtpRestTemplate {
    final RestTemplate restTemplate;

    public UtpRestTemplate(ProductAccountProperties productAccountProperties) {
        this.restTemplate = customize(productAccountProperties);
    }

    protected RestTemplate customize(ProductAccountProperties productAccountProperties) {
        return new RestTemplate(clientHttpRequestFactory(productAccountProperties));
    }

    private ClientHttpRequestFactory clientHttpRequestFactory(ProductAccountProperties productAccountProperties) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(productAccountProperties.getHttpMaxIdleConnections(), productAccountProperties.getHttpKeepAliveDuration(), TimeUnit.MILLISECONDS));
        if(StringUtil.isNotEmpty(productAccountProperties.getProxyIp()) && productAccountProperties.getProxyPort()>0){
            clientBuilder.proxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress(productAccountProperties.getProxyIp(),productAccountProperties.getProxyPort())));
            log.warn("==> OkHttpClient 已启用代理服务[ip:{},port:{}]转发请求",productAccountProperties.getProxyIp(),productAccountProperties.getProxyPort());
            clientBuilder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                    .hostnameVerifier(SSLSocketClient.getHostnameVerifier());
        }
        OkHttpClient client = clientBuilder.build();
        final OkHttp3ClientHttpRequestFactory rf = new OkHttp3ClientHttpRequestFactory(client);
        rf.setWriteTimeout(productAccountProperties.getHttpWriteTimeout());
        rf.setConnectTimeout(productAccountProperties.getHttpConnectTimeout());
        rf.setReadTimeout(productAccountProperties.getHttpReadTimeout());
        return rf;
    }

    public RestTemplate get() {
        return restTemplate;
    }


}
