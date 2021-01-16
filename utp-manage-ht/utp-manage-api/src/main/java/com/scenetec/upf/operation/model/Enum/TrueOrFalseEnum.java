package com.scenetec.upf.operation.model.Enum;

import lombok.Getter;

/**
 * @Description :
 * @Author : <a href="zengxiaobin@scenetec.com">Xiaobin.Zeng</a>
 * @Create : 2020/08/07 20:15
 */
@Getter
public enum TrueOrFalseEnum {
    FALSE("0"),
    TRUE("1");
    private String value;

    TrueOrFalseEnum(String value) {
        this.value = value;
    }
}
