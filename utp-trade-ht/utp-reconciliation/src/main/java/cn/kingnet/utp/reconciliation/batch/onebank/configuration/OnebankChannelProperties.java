package cn.kingnet.utp.reconciliation.batch.onebank.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description : 中信渠道属性配置
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/5 18:16
 */
@Configuration
@ConfigurationProperties(prefix = OnebankChannelProperties.ONEBANK_CHANNEL_PREFIX)
@Setter
@Getter
public class OnebankChannelProperties {

    public static final String ONEBANK_CHANNEL_PREFIX = "cn.kingnet.utp.channel.onebank.ftp";

    private String host;
    private int port;
    private int httpsPort;
    private String sysId;
    private String userName;
    private String password;
}
