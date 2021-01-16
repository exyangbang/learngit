package com.scenetec.upf.operation.model.Enum;

import java.util.stream.Stream;

/**
 * @Description : 产品代码和编号映射
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/12 17:52
 */
public enum ProductNoEnum {

    COLLECTION(ProductCodeEn.COLLECTION.name(), "1000"), //代收
    ACCOUNT(ProductCodeEn.ACCOUNT.name(), "1001"), //代付
    PRECARD(ProductCodeEn.PRECARD.name(), "1002"); //预付费卡

    private String code;

    private String no;

    ProductNoEnum(String code, String no) {
        this.code = code;
        this.no = no;
    }

    public static String getNoByCode(String code){
        return Stream.of(values()).filter(item -> item.getCode().equals(code)).map(ProductNoEnum::getNo).findFirst().orElse("");
    }

    public static String getCodeByNo(String no){
        return Stream.of(values()).filter(item -> item.getNo().equals(no)).map(ProductNoEnum::getCode).findFirst().orElse("");
    }

    public String getCode() {
        return code;
    }

    public String getNo() {
        return no;
    }
}
