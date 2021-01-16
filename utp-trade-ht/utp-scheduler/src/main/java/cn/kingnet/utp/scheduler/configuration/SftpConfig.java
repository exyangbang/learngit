package cn.kingnet.utp.scheduler.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

/**
 * @Description
 * @Author WJH
 * @Date 2020/08/13
 */

@ConfigurationProperties(prefix = "cn.kingnet.utp.sftp")
@Getter
@Setter
public class SftpConfig {
    private String userName;
    private String password;
    private String privateKey;
    private String host;
    private int port;

    @PostConstruct
    public void init() {
        Assert.hasText(userName, () -> "cn.kingnet.utp.ssh.user-name 未配置");
        if (password == null && privateKey == null) {
            throw new RuntimeException("cn.kingnet.utp.ssh.password|privateKey 必须配置一项");
        }
        Assert.hasText(host, () -> "cn.kingnet.utp.ssh.host 未配置");
        Assert.isTrue(port > 0, () -> "cn.kingnet.utp.ssh.host 未配置");
    }
}
