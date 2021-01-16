package com.scenetec.upf.operation.security.auth.jwt.extractor;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
public interface TokenExtractor {
    /**
     * token
     * @param payload 参数
     * @return string
     * */
    String extract(String payload);
}
