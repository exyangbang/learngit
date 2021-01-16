package cn.kingnet.utp.trade.common.support;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;

import java.io.Serializable;

/**
 * @author zhongli
 * @date 2018/10/9
 */

public class FetureContext<REQ extends SpBaseRequest, RESP extends SpBaseResponse> implements Serializable {
    private final String traceId;
    private final String spanId;
    private final String clientTradeId;
    private final String reqDate;
    private final String reqTime;
    private final REQ spReq;
    protected RESP spResp;

    public FetureContext(String traceId, String spanId, String clientTradeId, String reqDate, String reqTime, REQ spReq) {
        this.traceId = traceId;
        this.spanId = spanId;
        this.clientTradeId = clientTradeId;
        this.reqDate = reqDate;
        this.reqTime = reqTime;
        this.spReq = spReq;
    }

    public void setSpResp(RESP spResp) {
        this.spResp = spResp;
    }

    public String getTraceId() {
        return traceId;
    }

    public String getSpanId() {
        return spanId;
    }

    public String getClientTradeId() {
        return clientTradeId;
    }

    public String getReqDate() {
        return reqDate;
    }

    public String getReqTime() {
        return reqTime;
    }

    public REQ getSpReq() {
        return spReq;
    }

    public RESP getSpResp() {
        return spResp;
    }


    @SuppressWarnings("unchecked")
    public <T extends SpBaseRequest> T getData(Class<T> clazz) {
        if(clazz.isAssignableFrom(SpBaseRequest.class)){
            return (T) spReq;
        }
        return null;
    }


}
