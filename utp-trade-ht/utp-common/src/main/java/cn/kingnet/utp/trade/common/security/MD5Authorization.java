package cn.kingnet.utp.trade.common.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @Description : MD5签名验签
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/11 14:39
 */
public class MD5Authorization implements Authorization {

    private static final Logger logger = LoggerFactory.getLogger(MD5Authorization.class);

    private final String appId;

    private final String secret;

    public MD5Authorization(String appId, String secret) {
        super();
        this.appId = appId;
        this.secret = secret;
    }

    /**
     * 创建签名加密字符串
     *
     * @param sortString 参数排序拼接字符串
     * @return 签名字符串
     */
    public String createAuthorization(String sortString) {
        long time = System.currentTimeMillis();
        String signString = sortString + time + this.secret;
        logger.debug("待MD5签名串：{}", signString);
        return String.format(AUTH_RSA + ":%s:%s:%s", this.appId, DigestUtils.md5Hex(signString.getBytes(StandardCharsets.UTF_8)), time);
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
        String signString = sortString + timestamp + this.secret;
        String signResult = DigestUtils.md5Hex(signString.getBytes(StandardCharsets.UTF_8));
        return sign.equals(signResult);
    }

    @Override
    public boolean verifyDn(String sign, String dbDN) {
        return true;
    }
}
