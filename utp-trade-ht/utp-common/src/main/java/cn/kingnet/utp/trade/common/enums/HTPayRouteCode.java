package cn.kingnet.utp.trade.common.enums;

/**
 * 华通接口路由编码
 *
 * @Description
 * @Author WJH
 * @Date 2019/03/22
 */
public enum HTPayRouteCode {

    CUC("银联全渠道"),
    CUP("银联电子"),
    SZC("深圳同城"),
    SIB("超级网银"),
    HVP("大额"),
    BEP("小额"),
    XMA("厦门民生"),
    TFP("腾付通"),
    YZF("翼支付"),;

    private String desc;

    HTPayRouteCode(String desc) {
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }
}
