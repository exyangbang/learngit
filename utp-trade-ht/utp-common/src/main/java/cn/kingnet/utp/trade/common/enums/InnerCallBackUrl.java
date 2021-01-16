package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月01日
 */
public enum InnerCallBackUrl {


    WITHDRAW_CALLBACK("http://127.0.0.1:8080/innerCallback/withdraw", "内部系统提现回调URL"),
    FEE_COLLECTION_TRANSFER_CALLBACK("http://127.0.0.1:8080/innerCallback/feeCollectionTransfer", "归集划转回调URL"),
    COLLECT_ACCOUNT_WITHDRAW("http://127.0.0.1:8080/innerCallback/collectAccountWithdraw", "归集账户提现回调URL"),
    ;


    private String url;
    private String desc;

    InnerCallBackUrl(String url, String desc) {
        this.url = url;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }

    public static InnerCallBackUrl getInnerCallBackUrl(String url) {
        return Stream.of(values()).filter(item -> item.getUrl().equals(url)).findFirst().orElse(null);
    }
}
