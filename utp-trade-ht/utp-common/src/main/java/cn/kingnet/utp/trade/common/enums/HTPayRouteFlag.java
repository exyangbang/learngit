package cn.kingnet.utp.trade.common.enums;

/**
 * 华通接口路由类型
 * 路由类型【固定长度：1】 1指定；2支付平台路由
 *
 * @Description
 * @Author WJH
 * @Date 2019/03/22
 */
public enum HTPayRouteFlag {

    UTP_DESIGNATED("1", "UTP平台指定"),
    HT_ROUTE("2", "华通支付平台路由"),;
    private String flag;
    private String desc;

    HTPayRouteFlag(String flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag() {
        return flag;
    }

    public String getDesc() {
        return desc;
    }
}
