package cn.kingnet.utp.trade.common.enums;

/**
 * @Description: 联网核查返回码
 * @Author sheqingquan@scenetec.com
 * @Create 2020/7/3 14:06
 */
public enum OneBankOnlineCheckCode {

    SUCCESS("90000", "成功"),
    M00("00", "公民身份号码与姓名一致，但不存在照片"),
    M01("01", "公民身份号码与姓名一致，且存在照片"),
    M02("02", "公民身份号码存在，但与姓名不匹配"),
    M03("03", "公民身份号码不存在"),
    M04("04", "公民身份号码不存在或姓名不匹配"),
    M11("-1", "输入证件号码为空"),
    M12("-2", "输入公民姓名为空"),
    M13("-3", "输入业务发生地为空"),
    M14("-4", "输入业务类型为空"),
    M15("-5", "输入身份证格式不符"),
    M19("-9", "其他错误"),
    ;

    /**
     * 响应码
     */
    private String respCode;
    /**
     * 描述
     */
    private String desc;

    OneBankOnlineCheckCode(String respCode, String desc) {
        this.respCode = respCode;
        this.desc = desc;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static OneBankOnlineCheckCode resolve(String code) {
        for (OneBankOnlineCheckCode onlineCheckCode : values()) {
            if (onlineCheckCode.getRespCode().equals(code)) {
                return onlineCheckCode;
            }
        }
        throw new RuntimeException(String.format("未知类型:%s", code));
    }
}