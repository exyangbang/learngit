package cn.kingnet.utp.trade.common.security;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Description : Password签名验签
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/11 14:40
 */
public class PasswordAuthorization implements Authorization {

    private final String appId;
    private final String password;

    public PasswordAuthorization(String appId, String password) {
        super();
        this.appId = appId;
        this.password = password;
    }

    /**
     * 创建签名加密字符串
     *
     * @param sortString 参数排序拼接字符串
     * @return 签名字符串
     */
    public String createAuthorization(String sortString) {
        return String.format(AUTH_RSA + ":%s:%s:%s", this.appId, DigestUtils.md5Hex(this.password.getBytes(StandardCharsets.UTF_8)), System.currentTimeMillis());
    }

    /**
     * 验签解密
     *
     * @param sign       签名字符串
     * @param timestamp  时间戳
     * @param sortString 参数排序拼接字符串
     * @return
     */
    public boolean verifyAuthorization(String sign, String timestamp, String sortString) {
        return DigestUtils.md5Hex(this.password.getBytes(StandardCharsets.UTF_8)).equals(sign);
    }

    @Override
    public boolean verifyDn(String sign, String dbDN) {
        return true;
    }
}
