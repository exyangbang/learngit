package cn.kingnet.utp.channel.onebank.baffle.configuration;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongli
 */
@ConfigurationProperties(prefix = "cn.kingnet.utp.channel.onebank")
@Setter
@Getter
public class OnebankChannelProperties {

    private int threadPoolNum = 4;

    private int maxThreadPoolNum = 4;

    private String dmbConfigPath;

    private long timeout = 6000;

    private String channelId;

    private String txnTellerId;

    private String txnBranchCode;

    private String prcscd;

    private Map<String,Transfer> transferMap= new HashMap<>();

    /**
     * 转账接口配置
     */
    @Setter
    @Getter
    public static class Transfer {
        private String productcode;
        private String serviceId;
        private String sceneId;
        private String callBackServiceId;
        private String callBackSceneId;
        private String prcscd;
    }

    public Transfer getTransfer(final String key) {
        if(transferMap.containsKey(key)){
            return transferMap.get(key);
        }else {
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"未找到接口配置:"+key);
        }
    }
}
