package cn.kingnet.utp.sdk.core.auth;

import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2019/09/26
 */
public interface Authorization {
    /**
     * 签名
     *
     * @param request
     * @return
     */
    String createAuthorization(Map<String, String> request);

    /**
     * 验签
     *
     * @param signed
     * @param timestamp
     * @param responseMap
     * @return
     */
    boolean verifyAuthorization(String signed, String timestamp, Map<String, String> responseMap);

}
