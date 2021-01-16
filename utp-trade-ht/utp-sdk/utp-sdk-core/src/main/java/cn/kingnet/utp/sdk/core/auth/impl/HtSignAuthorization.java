package cn.kingnet.utp.sdk.core.auth.impl;

import cn.kingnet.utp.sdk.core.auth.Authorization;
import cn.kingnet.utp.sdk.core.enums.AuthType;
import cn.kingnet.utp.sdk.core.utils.RSAP7SignatureUtils;
import cn.kingnet.utp.sdk.core.utils.StringUtil;

import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2019/09/26
 */
public class HtSignAuthorization implements Authorization {

    private final String industryCode;
    private final String signCertPath;
    private final String password;

    public HtSignAuthorization(String industryCode, String signCertPath, String password) {
        this.industryCode = industryCode;
        this.signCertPath = signCertPath;
        this.password = password;
    }

    public String getIndustryCode(){return this.industryCode;}

    @Override
    public String createAuthorization(Map<String, String> request) {
        String sortString = StringUtil.createSortString(request);
        long time = System.currentTimeMillis();
        String signString = sortString + time;
        String sign;
        try {
            sign = RSAP7SignatureUtils.sign(signCertPath, password, signString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return String.format("%s:%s:%s:%s", AuthType.HTSIGN.getCode(),industryCode, sign, time);
    }

    @Override
    public boolean verifyAuthorization(String signed, String timestamp, Map<String, String> response) {
        try {
            String sortString = StringUtil.createSortString(response);
            String signString = sortString + timestamp;
            return RSAP7SignatureUtils.verify(signed, signString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
