package cn.kingnet.utp.scheduler.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhongli
 */
@ConfigurationProperties(prefix = "cn.kingnet.utp.product.account")
@Setter
@Getter
public class ProductAccountProperties {

    private String systemId;

    private String dfa;

    /**对公账号信息*/
    private PayerAccountInfo publicAccount;
    @Getter
    @Setter
    public static class PayerAccountInfo{
        private String payerOpbk;
        private String acctType;
        private String sysHeaderAcctType;
    }

    private String proxyIp;
    private int proxyPort;

}
