package cn.kingnet.utp.sdk.core.dto;

import java.io.Serializable;


public class ServerResponse<RESP> implements Serializable {

    private Throwable throwable;
    private RESP respData;

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public RESP getRespData() {
        return respData;
    }

    public void setRespData(RESP respData) {
        this.respData = respData;
    }
}
