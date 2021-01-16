package cn.kingnet.utp.trade.common.dto.account;

import java.io.Serializable;

/**
 * @Description : 订单退款回调请求客户端信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 13:38
 */
public class RefundOrderIdCallbackClientReqDTO implements Serializable {

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

    /**订单号*/
    private String orderId;

    /**用户账户*/
    private String userAccount;

    /**交易日期*/
    private String transDate;

    /**交易金额*/
    private String payAmt;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }

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
