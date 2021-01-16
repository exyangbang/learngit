package cn.kingnet.utp.trade.common.security;

import cn.buyforyou.sign.util.HTSignUtils;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/2 15:37
 */
@Slf4j
public class HTSIGNAuthorization implements Authorization {

    private final String appId;
    /**
     * 华通数字签名核签证书名称
     */
    private final String verifyCertName;
    /**
     * 华通数字签名加签证书名称
     */
    private final String signCertName;

    private final String htSignFlag;

    public HTSIGNAuthorization(String appId, String verifyCertName, String signCertName) {
        this.appId = appId;
        this.verifyCertName = verifyCertName;
        this.signCertName = signCertName;
        this.htSignFlag = "1";
    }

    /**
     * @param appId          默认置为空，必须通过byAppId签名验签方法
     * @param verifyCertName 验签证书名称|根证书
     * @param signCertName   签名证书名称
     * @param htSignFlag     是否进行签名验签标识：0=不需要，其他都要
     */
    public HTSIGNAuthorization(String appId, String verifyCertName, String signCertName, String htSignFlag) {
        this.appId = appId;
        this.verifyCertName = verifyCertName;
        this.signCertName = signCertName;
        this.htSignFlag = htSignFlag;
    }


    @Override
    public String createAuthorization(String sortString) {
        long time = System.currentTimeMillis();
        String signString = sortString + time;
        log.debug("行内加签参数：签名证书:{} >> 签名字符串:{}", signCertName, signString);
        String sign = HTSignUtils.u012(signCertName, signString);
        log.debug("行内加签返回结果：" + new String(sign));
        return String.format(AUTH_RSA + ":%s:%s:%s", this.appId, sign, time);
    }

    @Override
    public boolean verifyAuthorization(String sign, String timestamp, String sortString) {
        String signString = sortString + timestamp;
        log.debug("行内核签入参：" + signString);
        boolean flag = HTSignUtils.u013(verifyCertName, signString, sign.getBytes());
        log.debug("行内核签结果：" + flag);
        return flag;
    }

    /**
     * 回调时加签
     *
     * @param appId
     * @param sortString
     * @return
     */
    public String createAuthorizationByAppId(String appId, String sortString) {
        long time = System.currentTimeMillis();
        if (!"0".equals(this.htSignFlag)) {
            String signString = sortString + time;
            log.debug("行内加签参数：签名证书:{} >> 签名字符串:{}", signCertName, signString);
            String sign = HTSignUtils.u012(signCertName, signString);
            log.debug("行内加签返回结果：" + new String(sign));
            return String.format(AUTH_RSA + ":%s:%s:%s", appId, sign, time);
        } else {
            return String.format(AUTH_RSA + ":%s:%s:%s", appId, "-", time);
        }
    }

    /**
     * 回调时验签
     *
     * @param sign
     * @param timestamp
     * @param sortString
     * @return
     */
    public boolean verifyAuthorizationByAppId(String sign, String timestamp, String sortString) {
        if (!"0".equals(this.htSignFlag)) {
            String signString = sortString + timestamp;
            boolean flag = HTSignUtils.u013(verifyCertName, signString, sign.getBytes());
            log.info("行内核签结果：" + flag);
            return flag;
        } else {
            return true;
        }
    }

    @Override
    public boolean verifyDn(String sign, String dbDN) {
        try {
            String curDN = HTSignUtils.getDNFromP7SignData(sign);
            log.info(" <<=== 数据库配置dbDN:{} ,通过P7SignData签名信息从加密机获取DN值: {}", dbDN, curDN);
            if (StringUtil.isBlank(curDN)) {
                throw new RuntimeException("通过P7SignData签名信息从加密机获取DN值为空");
            }
            return curDN.contains(dbDN);
        } catch (Exception e) {
            throw new RuntimeException(String.format("通过P7SignData签名信息从加密机获取DN异常:%s", e.getMessage()));
        }
    }
}
