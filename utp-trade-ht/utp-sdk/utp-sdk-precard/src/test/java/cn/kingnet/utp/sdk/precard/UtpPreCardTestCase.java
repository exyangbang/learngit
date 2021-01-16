package cn.kingnet.utp.sdk.precard;

import cn.kingnet.utp.sdk.core.auth.Authorization;
import cn.kingnet.utp.sdk.core.auth.impl.HtSignAuthorization;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import junit.framework.TestCase;

import java.security.KeyStore;
import java.security.cert.Certificate;

public abstract class UtpPreCardTestCase extends TestCase {

    protected final String host = "http://127.0.0.1:9810";
//    protected final String host = "http://192.168.211.236:9810";

    protected final String KEYSTORE_PASSWORD = "123456";
    protected final String PRIVATEKEY_PASSWORD = "123456";
    /**
     * 商户号
     **/
    protected final String merNo = "3"; //0594456 0594457 666666
    protected final String server_cer_path = "/certs/utp.cer";
    protected final String client_pfx_path = "/certs/fsp_client.pfx";

    protected final String CERT_PASSWORD = "111111";
    protected final String cert_pfx_path = "JFJT.pfx";

    /**
     *  客户号/平台号 银行专用账户  关联来款账户
     *  666666        平安          小米
     *  0594456       小米          华华1、对公2101
     *  0594457       小米          平安
     *
     个人0   对私账户  6270761100000081968 华华1 323391060018
     商户1   对公账户  6232656718000015138 平安 323391060018  0594457
     商户1   对公账户  6232656718000015146 小米 323391060018  0594456  0594456
     商户1   对公账户   6232656718000021623  对公2101 323391060018
     */

    /**
     * md5认证时秘钥
     **/
    protected final String md5_key = "";
    /**
     * 密码认证时密码
     **/
    protected final String password_pw = "";
    protected Certificate serverCertificate;
    protected KeyStore clientKeyStore;

    protected Authorization createAuthorization(AuthType authType) {
        if (AuthType.HTSIGN == authType) {
            String filePath = UtpPreCardTestCase.class.getClassLoader().getResource(cert_pfx_path).getPath();
            return new HtSignAuthorization(merNo, filePath, CERT_PASSWORD);
        }
        throw new RuntimeException("不支持的认证方式");
    }

}