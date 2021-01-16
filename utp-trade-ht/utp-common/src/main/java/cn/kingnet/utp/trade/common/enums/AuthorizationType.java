package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : 签名方式
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/29 10:17
 */
public enum AuthorizationType {
    /**密码*/
    PASSWORD,
    /**MD5*/
    MD5,
    /**RSA*/
    RSA,
    /**华通签名*/
    HTSIGN;

    AuthorizationType() {
    }
}
