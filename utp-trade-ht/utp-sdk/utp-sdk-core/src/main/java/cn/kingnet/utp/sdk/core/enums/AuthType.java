package cn.kingnet.utp.sdk.core.enums;

/**
 * @Description
 * @Author WJH
 * @Date 2018年09月14日
 */
public enum AuthType {
    MD5("MD5", "md5验证"),
    PASSWORD("PASSWORD", "密码验证"),
    RSA("RSA", "RSA验证"),
    HTSIGN("UTP01", "华通验证");

    AuthType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
