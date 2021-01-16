package cn.kingnet.utp.channel.onebank.configuration;

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
    /**
     * 华通分配的dfa：与dmb.xml中dfa一致
     */
    private String dfa;
    /**
     * 请求目标dfa值：资金账户未内部户取值
     */
    private String targetDfa;
    /**
     * 请求目标dfa：资金账户为一般户性质取值
     */
    private String targetDfaGeneral;

    private Map<String, Transfer> transferMap = new HashMap<>();

    /**
     * 转账接口配置
     */
    @Setter
    @Getter
    public static class Transfer {
        /**
         * 原产品编码:适用大小额渠道及实时划转的银联渠道
         */
        private String productcode;
        /**
         * 新产品编码:适用大小额渠道及日终划转的银联渠道
         */
        private String newProductcode;
        private String serviceId;
        private String sceneId;
        private String callBackServiceId;
        private String callBackSceneId;
        /**
         * 交易处理码
         */
        private String prcscd;
        private String version;
    }

    public Transfer getTransfer(final String key) {
        if (transferMap.containsKey(key)) {
            return transferMap.get(key);
        } else {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "未找到接口配置:" + key);
        }
    }
}
