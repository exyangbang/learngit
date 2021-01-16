package com.scenetec.upf.operation.security.auth.jwt.verifier;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
public interface TokenVerifier {
    /**
     * 校验token
     * @param jti token
     * @return 结果 true or false
     * */
    boolean verify(String jti);
}
