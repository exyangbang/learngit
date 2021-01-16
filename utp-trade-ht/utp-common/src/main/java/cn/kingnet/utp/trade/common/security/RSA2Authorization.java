package cn.kingnet.utp.trade.common.security;

import cn.kingnet.utp.trade.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @Description : RSA2签名验签
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/11 14:44
 */
public class RSA2Authorization implements Authorization {

    private static final Logger logger = LoggerFactory.getLogger(RSA2Authorization.class);

    private static final String KEY_ALGORITHM_RSA = "RSA";
    private static final String SIGN_ALGORITHM_SHA256RSA = "SHA256withRSA";

    private final String appId;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    RSA2Authorization(String appId, String privateKey, String publicKey) {
        super();
        this.appId = appId;
        try {
            if (StringUtil.isNotBlank(privateKey)) {
                this.privateKey = genPriKey(privateKey);
            }
            if (StringUtil.isNotBlank(publicKey)) {
                this.publicKey = genPubKey(publicKey);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public RSA2Authorization(String appId, PrivateKey privateKey, PublicKey publicKey) {
        super();
        this.appId = appId;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    /**
     * 获取私钥
     *
     * @param priKeyStr 私钥串
     * @return RSAPrivateKey
     */
      static RSAPrivateKey genPriKey(final String priKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        final byte[] priKeyBytes = Base64.getDecoder().decode(priKeyStr);
        final PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(priKeyBytes);
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    /**
     * 获取公钥
     *
     * @param pubKeyStr 公钥串
     * @return RSAPublicKey
     */
    static RSAPublicKey genPubKey(final String pubKeyStr)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        final byte[] pubKeyBytes = Base64.getDecoder().decode(pubKeyStr);
        final X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    /**
     * 创建签名加密字符串
     *
     * @param sortString 参数排序拼接字符串
     * @return 签名字符串
     */
    public String createAuthorization(String sortString) {
        long time = System.currentTimeMillis();
        String signString = sortString + time;
        String sign = this.sign(signString);
        return String.format(AUTH_RSA + ":%s:%s:%s", this.appId, sign, time);
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
        String signString = sortString + timestamp;
        return this.verify(signString, sign);
    }

    private String sign(final String data) {
        try {
            final Signature st = Signature.getInstance(SIGN_ALGORITHM_SHA256RSA);
            st.initSign(this.privateKey);
            st.update(data.getBytes(StandardCharsets.UTF_8));
            byte[] srcBytes = st.sign();
            return Base64.getEncoder().encodeToString(srcBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verify(final String data, final String sign) {
        try {
            final Signature st = Signature.getInstance(SIGN_ALGORITHM_SHA256RSA);
            st.initVerify(this.publicKey);
            st.update(data.getBytes(StandardCharsets.UTF_8));
            byte[] signatureBytes = Base64.getDecoder().decode(sign);
            return st.verify(signatureBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean verifyDn(String sign, String dbDN) {
        return true;
    }
}
