package cn.kingnet.utp.service.persistence.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2020/12/25
 */
@ConfigurationProperties(prefix = "cn.kingnet.utp")
@Setter
@Getter
public class PersistenceProperties {


    private Cipher cipher;
    /**
     * 融合支付中特殊平台客户的流水缓存配置 industryCode:cacheTime(单位小时)
     */
    private Map<String, Long> mixTransMap;

    @Getter
    @Setter
    public static class Cipher {
        private String privateKey;
        private String publicKey;
    }


}
