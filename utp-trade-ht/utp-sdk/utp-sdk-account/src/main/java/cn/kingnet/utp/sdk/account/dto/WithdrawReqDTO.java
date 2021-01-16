package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;

/**
 * @Description : 提现请求DTO
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/9 15:18
 */
public class WithdrawReqDTO extends BaseRequestDTO {

    /**用户账号*/
    private String userAccount;

    /**请求日期*/
    private String reqDate;

    /**请求时间*/
    private String reqTime;

    /**交易金额*/
    private String payAmt;

    /**显示付款账号*/
    private String showPayerAcctNo;

    /**显示付款户名*/
    private String showPayerName;

    /**后端回调地址*/
    private String callbackUrl;

    /**备注说明*/
    private String remark;

    /**手机号码*/
    private String mobile;
    /**
     * 指定的提现账号; 支持绑定多张卡的客户该字段必填；不支持绑定多张卡的客户该字段不需要填
     */
    private String acctNo;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }

    public String getShowPayerAcctNo() {
        return showPayerAcctNo;
    }

    public void setShowPayerAcctNo(String showPayerAcctNo) {
        this.showPayerAcctNo = showPayerAcctNo;
    }

    public String getShowPayerName() {
        return showPayerName;
    }

    public void setShowPayerName(String showPayerName) {
        this.showPayerName = showPayerName;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }
}
