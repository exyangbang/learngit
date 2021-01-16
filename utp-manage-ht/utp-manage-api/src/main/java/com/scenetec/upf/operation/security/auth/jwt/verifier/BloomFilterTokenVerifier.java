package com.scenetec.upf.operation.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
