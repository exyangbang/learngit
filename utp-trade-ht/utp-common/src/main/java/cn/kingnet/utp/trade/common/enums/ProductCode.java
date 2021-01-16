package cn.kingnet.utp.trade.common.enums;

/**
 * 产品类型/产品编码|支付产品模块一致
 * Created on 2018/5/14
 *
 * @author by Benjamin.Huang
 */
public enum ProductCode {

    /**
     * 代收
     */
    COLLECTION,
    /**
     * 账户+代付
     */
    ACCOUNT,
    /**
     * 预付费卡
     */
    PRECARD;

    ProductCode() {
    }

}
