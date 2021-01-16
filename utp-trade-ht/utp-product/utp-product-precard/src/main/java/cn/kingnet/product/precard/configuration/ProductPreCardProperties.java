package cn.kingnet.product.precard.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhongli
 */
@ConfigurationProperties(prefix = "cn.kingnet.utp.product.account")
@Setter
@Getter
public class ProductPreCardProperties {
    /**
     * httpclient最大空闲连接数
     */
    private int httpMaxIdleConnections = 5;
    /**
     * httpclient保持连接时长 单位毫秒
     */
    private long httpKeepAliveDuration = 300000;
    /**
     * httpclient写入超时 单位毫秒
     */
    private int httpWriteTimeout = 30000;
    /**
     * httpclient请求超时 单位毫秒
     */
    private int httpConnectTimeout = 30000;
    /**
     * httpclient读取超时 单位毫秒
     */
    private int httpReadTimeout = 30000;

    private String systemId;

    private String dfa;

    private String proxyIp;
    private int proxyPort;

    /**
     * 行内硬加签验签的api配置文件路径
     */
    private String unionApiConfigFile;

    /*对公账号信息*/
    private PayerAccountInfo publicAccount;

    @Getter
    @Setter
    public static class PayerAccountInfo{
        private String payerOpbk;
        private String acctType;
        private String sysHeaderAcctType;
    }

}
