package cn.kingnet.utp.trade.common.dto.sp;

/**
 * @Description
 * @Author WJH
 * @Date 2019/11/01
 */
public enum RespCode {

    SUCCESS("00", "成功"),
    ERROR("99", "错误"),
    EXCEPTION("98", "异常"),

    ;
    /**
     * 四位：前两位代表系统 后两位代表具体信息
     */
    private String respCode;
    private String respDesc;

    RespCode(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }
}
