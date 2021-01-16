package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 产品代码和编号映射
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/12 17:52
 */
public enum ProductNo {

    COLLECTION(ProductCode.COLLECTION.name(), "1000"), //代收
    ACCOUNT(ProductCode.ACCOUNT.name(), "1001"), //代付
    PRECARD(ProductCode.PRECARD.name(), "1002"); //预付费卡

    private String code;

    private String no;

    ProductNo(String code, String no) {
        this.code = code;
        this.no = no;
    }

    public static String getNoByCode(String code){
        return Stream.of(values()).filter(item -> item.getCode().equals(code)).map(ProductNo::getNo).findFirst().orElse("");
    }

    public static String getCodeByNo(String no){
        return Stream.of(values()).filter(item -> item.getNo().equals(no)).map(ProductNo::getCode).findFirst().orElse("");
    }

    public String getCode() {
        return code;
    }

    public String getNo() {
        return no;
    }
}
