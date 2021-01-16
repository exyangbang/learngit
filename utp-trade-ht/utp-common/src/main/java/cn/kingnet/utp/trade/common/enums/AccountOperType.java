package cn.kingnet.utp.trade.common.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月10日
 */
@Getter
public enum AccountOperType {

    PLUS_BLANCE("01", "入金"),
    FREEZEN_BLANCE("02", "冻结"),
    UNFREEZEN_BLANCE("03", "解冻"),
    MINUS_BLANCE("04", "出金"),

    PLUS_FREEZEN_BLANCE("05", "冻结金额入金"),
    PLUS_BLANCE_INNER("06", "内部调账入金"),
    MINUS_AVAIL_BLANCE("07", "可用余额出金"),
    ;

    AccountOperType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

   public static AccountOperType getEnum(String code){
       return Arrays.stream(AccountOperType.values()).filter(o->o.code.equals(code)).findFirst().orElse(null);
   }


}
