package cn.kingnet.utp.scheduler.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2020/12/29
 */
@ConfigurationProperties(prefix = "cn.kingnet.utp")
@Component
@Getter
@Setter
public class UtpProperties {
    /**
     * 融合支付中特殊平台客户的流水缓存配置 industryCode:cacheTime(单位天)
     */
    private Map<String, Long> mixTransMap;

}
