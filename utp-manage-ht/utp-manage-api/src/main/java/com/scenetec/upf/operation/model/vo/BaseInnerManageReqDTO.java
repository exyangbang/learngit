package com.scenetec.upf.operation.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 内部后管基本信息DTO
 */
@Setter
@Getter
public abstract class BaseInnerManageReqDTO implements Serializable {
    protected static final String appid = "utp-manager-ht";
    protected static final String secret = "mh7d3scgRHvk0AO6";

    /**
     * 签名
     */
    private String sign;


    public abstract String[] toSHA1();

}
