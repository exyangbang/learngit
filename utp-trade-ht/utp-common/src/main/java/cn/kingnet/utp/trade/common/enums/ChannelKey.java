package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 渠道标识
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/23 15:26
 */
public enum ChannelKey {

    HT_CKEY("0001", "人行大小额"),
    HT_CUC("0002", "银联代付(实时划账)"),
    HT_SIB("0003", "超级网银"),
    HT_POST_CUC("0004", "银联代付(事后划账)");

    private String key;
    private String name;

    ChannelKey(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static ChannelKey resolve(String key) {
        return Stream.of(values()).filter(k -> k.equals(key)).findFirst().orElseThrow(() -> new RuntimeException("入参渠道编号" + key + "错误"));
    }
}
