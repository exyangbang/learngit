package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;

import java.io.Serializable;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 14:07
 */
public class OneBankTransQueryRespDTO extends SpBaseResponse implements Serializable {

    /**源客户端流水号*/
    private String origClientTradeId;

    /**源服务端端流水号*/
    private String origServerTradeId;

    /**交易状态*/
    private String transStatus;

    public String getOrigClientTradeId() {
        return origClientTradeId;
    }

    public void setOrigClientTradeId(String origClientTradeId) {
        this.origClientTradeId = origClientTradeId;
    }

    public String getOrigServerTradeId() {
        return origServerTradeId;
    }

    public void setOrigServerTradeId(String origServerTradeId) {
        this.origServerTradeId = origServerTradeId;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }
}
