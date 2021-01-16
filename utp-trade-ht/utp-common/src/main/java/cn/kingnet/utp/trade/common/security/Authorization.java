package cn.kingnet.utp.trade.common.security;

import cn.kingnet.utp.trade.common.model.AuthConfigInfo;
import cn.kingnet.utp.trade.common.utils.CommonConstants;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @Description : 签名验签
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/11 14:40
 */
public interface Authorization {

    /**
     * headers里Authorization字段UTP01:merNo:sign的base64编码:timestamp
     * 标识签名验签采用RSA算法
     */
    String AUTH_RSA = "UTP01";

    /**
     *  创建签名加密字符串
     * @param sortString 参数排序拼接字符串
     * @return 签名字符串
     */
    String createAuthorization(String sortString);

    /**
     *  验签解密
     * @param sign 签名字符串
     * @param timestamp 时间戳
     * @param sortString 参数排序拼接字符串
     * @return
     */
    boolean verifyAuthorization(String sign, String timestamp, String sortString);

    /**
     *  校验上送签名证书DN与后管配置DN
     * @param sign 客户端上送签名信息
     * @param dbDN 后管配置dn信息
     * @return
     */
    boolean verifyDn(String sign,String dbDN);

    class Builder {

        /**
         * 获取验签工具
         *
         * @param signType      验签类型
         * @param verifyContent   验证要素
         * @param signContent 加密要素
         * @return Authorization 签名验签工具
         */
        public static Authorization buildAuthorization(String appId, String signType, String verifyContent,String signContent) {
            Authorization authorization = null;
            switch (signType) {
                case CommonConstants.AUTHORIZATION_TYPE_PASSWORD:
                    authorization = new PasswordAuthorization(appId, verifyContent);
                    break;
                case CommonConstants.AUTHORIZATION_TYPE_MD5:
                    authorization = new MD5Authorization(appId, verifyContent);
                    break;
                case CommonConstants.AUTHORIZATION_TYPE_RSA:
                    authorization = new RSA2Authorization(appId, signContent,verifyContent);
                    break;
                default:
                    break;
            }
            return authorization;
        }

        public static Authorization buildAuthorization(String appId, String signType, String pasContent, PrivateKey privateKey, PublicKey publicKey) {
            Authorization authorization = null;
            switch (signType) {
                case CommonConstants.AUTHORIZATION_TYPE_PASSWORD:
                    authorization = new PasswordAuthorization(appId, pasContent);
                    break;
                case CommonConstants.AUTHORIZATION_TYPE_MD5:
                    authorization = new MD5Authorization(appId, pasContent);
                    break;
                case CommonConstants.AUTHORIZATION_TYPE_RSA:
                    authorization = new RSA2Authorization(appId, privateKey,publicKey);
                    break;
                default:
                    break;
            }
            return authorization;
        }

        public static Authorization buildAuthorization(String appId, AuthConfigInfo authConfigInfo) {
            Authorization authorization = null;
            switch (authConfigInfo.getSignType()) {
                case CommonConstants.AUTHORIZATION_TYPE_PASSWORD:
                    authorization = new PasswordAuthorization(appId, authConfigInfo.getPassword());
                    break;
                case CommonConstants.AUTHORIZATION_TYPE_MD5:
                    authorization = new MD5Authorization(appId, authConfigInfo.getPassword());
                    break;
                case CommonConstants.AUTHORIZATION_TYPE_RSA:
                    authorization = new RSA2Authorization(appId, authConfigInfo.getPlatformPriKey(),authConfigInfo.getMer4UtpPubKey());
                    break;
                case CommonConstants.AUTHORIZATION_TYPE_HTSIGN:
                    authorization = new HTSIGNAuthorization(appId, authConfigInfo.getVerifyCertName(),authConfigInfo.getSignCertName());
                    break;
                default:
                    break;
            }
            return authorization;
        }
    }


}