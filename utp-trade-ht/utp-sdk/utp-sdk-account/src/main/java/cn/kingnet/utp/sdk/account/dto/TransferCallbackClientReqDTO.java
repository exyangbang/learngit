package cn.kingnet.utp.sdk.account.dto;

import java.io.Serializable;

/**
 * @Description : 提现回调请求客户端信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 13:38
 */
public class TransferCallbackClientReqDTO implements Serializable {

    /**源客户端流水号*/
    private String origClientTradeId;

    /**源服务端端流水号*/
    private String origServerTradeId;

    /**交易状态*/
    private String transStatus;

    /**状态描述*/
    private String statusDesc;

    /**对账日期*/
    private String reconcileDate;

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

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getReconcileDate() {
        return reconcileDate;
    }

    public void setReconcileDate(String reconcileDate) {
        this.reconcileDate = reconcileDate;
    }
}
