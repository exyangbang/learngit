package com.scenetec.upf.operation.model.domain.system.status;

/**
 * @author linkaigui on 2018-07-12.
 * @ 创建日期：2018-07-12
 */
public enum DelFlagEnum {

    /**
     * 否-未删除
     *
     */
    NORMAL("0","否"),

    /**
     * 是-已删除
     *
     */
    DELETE("1","是");

    private String value;
    private String label;

    DelFlagEnum(String value, String label) {
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
