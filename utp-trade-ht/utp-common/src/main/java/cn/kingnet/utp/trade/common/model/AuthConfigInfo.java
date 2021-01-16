package cn.kingnet.utp.trade.common.model;

import lombok.Data;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @Description : 证书配置信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/31 15:16
 */
@Data
public class AuthConfigInfo implements Serializable {

    /**
     * 签名类型：PASSWORD、RSA签名、MD5签名
     */
    private String signType;

    /**
     * 签名类型为PASSWORD\MD5 时的密码或者密钥值
     */
    private String password;

    /**
     * 商户给转接平台的公钥（用于验签商户给转接平台的信息）
     */
    private String mer4UtpPublickey;

    private PublicKey mer4UtpPubKey;

    /**
     * 转接平台对供应链或商户签名的私钥（用于转接平台送交供应链或其他上游商户信息的签名）
     */
    private String utpSignPrivatekey;

    private PrivateKey utpSignPriKey;

    /**
     * 平台公钥
     */
    private PublicKey platformPubKey;

    /**
     * 平台私钥
     */
    private PrivateKey platformPriKey;

    /**
     * 华通数字签名核签证书名称
     */
    private String verifyCertName;
    /**
     * 华通数字签名加签证书名称
     */
    private String signCertName;

    /**
     * 最后更新时间
     */
    private Date lastTime;
    /**
     * 签名信息中提取的DN 统一社会信用代码
     */
    private String dn4CreditCode;
    /**
     * lastTime距当前时间是否超时min分钟
     *
     * @param min 分钟数
     * @return
     */
    public boolean isTimeout(int min) {
        if (lastTime == null) return true;
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).isAfter(lastTime.toInstant().plusSeconds(min * 60));
    }
}
