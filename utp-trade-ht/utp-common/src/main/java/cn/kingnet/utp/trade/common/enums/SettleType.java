package cn.kingnet.utp.trade.common.enums;

import java.util.stream.Stream;

/**
 * @Description : 结算类型
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/21 15:28
 */
public enum SettleType {

    REAL_TIME("1","实时"),
    AFTER_NODE("2","后结");

    private String type;

    private String desc;

    SettleType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SettleType resolve(String type){
        return Stream.of(values()).filter(o->o.getType().equals(type)).findFirst().orElse(null);
    }

}
