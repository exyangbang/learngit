package cn.kingnet.utp.trade.common.dto.account;

import java.io.Serializable;

/**
 * @Description : 提现回调请求客户端信息
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 13:38
 */
public class WithdrawCallbackClientReqDTO implements Serializable {

    /**
     * 客户编码
     */
    private String userNo;

    /**
     * 用户虚拟账户
     */
    private String userAccount;

    /**
     * 请求日期
     */
    private String reqDate;

    /**
     * 源客户端流水号
     */
    private String origClientTradeId;

    /**
     * 源服务端端流水号
     */
    private String origServerTradeId;

    /**
     * 交易状态
     */
    private String transStatus;

    /**
     * 状态描述
     */
    private String statusDesc;

    /**
     * 对账日期
     */
    private String reconcileDate;
    /**
     * 手续费结算类型:1实时 2后结
     */
    private String feeType;
    /**
     * 手续费收费模式：1内扣 2外扣
     */
    private String feeModel;
    /**
     * 手续费金额单位分
     */
    private String feeAmount;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeModel() {
        return feeModel;
    }

    public void setFeeModel(String feeModel) {
        this.feeModel = feeModel;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }
}
