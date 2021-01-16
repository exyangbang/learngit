package com.scenetec.upf.operation.model.domain.certificate.status;


/**
 * 证书类型枚举
 * Created on 2018/7/16
 *
 * @author by Benjamin.Huang
 */
public enum CertificateTypeEnum {

    /**
     * 公钥
     */
    PUBLIC_KEY("1", "公钥"),

    /**
     * 私钥
     */
    PRIVATE_KEY("2", "私钥");

    private String value;
    private String label;

    CertificateTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
