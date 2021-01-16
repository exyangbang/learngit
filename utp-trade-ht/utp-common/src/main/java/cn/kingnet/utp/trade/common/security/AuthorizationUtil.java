package cn.kingnet.utp.trade.common.security;

import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.StringUtil;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created on 2018/5/28
 *
 * @author by linkaigui
 */
public class AuthorizationUtil {

    private static final String KEY_ALGORITHM_RSA = "RSA";

    /**
     * 获取授权信息拆分数组
     *
     * @param authString 客户端授权信息 headers里Authorization字段UTP01:merNo:sign的base64编码:timestamp
     * @return 授权拆分数组
     */
    public static AuthInfo getAuthInfo(String authString) {
        AuthInfo authInfo = new AuthInfo(authString);
        if (!Authorization.AUTH_RSA.equals(authInfo.getStartStr()))
            throw new TradeException(HttpRespStatus.UNAUTHORIZED, "Authorization：签名验签算法参数有误.");
        return authInfo;
    }

    public static Authorization build4RSA(String merNo, String pubKey, String priKey) {
        return Authorization.Builder.buildAuthorization(merNo, CommonConstants.AUTHORIZATION_TYPE_RSA, pubKey, priKey);
    }

    /**
     * 获取私钥
     *
     * @param priKeyStr 私钥串
     * @return RSAPrivateKey
     */
    public static RSAPrivateKey genPriKey(final String priKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (StringUtil.isEmpty(priKeyStr)) {
            return null;
        }
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
    public static RSAPublicKey genPubKey(final String pubKeyStr)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (StringUtil.isEmpty(pubKeyStr)) {
            return null;
        }
        final byte[] pubKeyBytes = Base64.getDecoder().decode(pubKeyStr);
        final X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
        final KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }
}
