package cn.kingnet.utp.trade.common.response;

import java.io.Serializable;

/**
 * @author zhongli
 */
public abstract class BaseResponse implements Serializable {

    //应答码
    public String respCode;

    //应答信息
    public String respMsg;

    public BaseResponse() {
    }

    public BaseResponse(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
