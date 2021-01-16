package cn.kingnet.utp.sdk.precard.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;

/**
 * @Description : 预付费卡清算文件上送
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 13:28
 */
public class UploadAccountSettleReqDTO extends BaseRequestDTO {

    /**
     * 请求日期：yyyyMMdd
     */
    private String reqDate;
    /**
     * 请求时间：HHmmss
     */
    private String reqTime;

    /**
     * 清算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * 批次号
     */
    private String batchNo;

    /**收款人账号*/
    private String payeeAcctNo;

    /**收款人名称*/
    private String payeeName;

    /**收款人清算行行号*/
    private String payeeOpbk;

    /**显示付款账号*/
    private String showPayerAcctNo;

    /**显示付款户名*/
    private String showPayerName;

    /**
     * 结果回调地址
     */
    private String callbackUrl;

    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;

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

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getPayeeAcctNo() {
        return payeeAcctNo;
    }

    public void setPayeeAcctNo(String payeeAcctNo) {
        this.payeeAcctNo = payeeAcctNo;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
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

    public String getPayeeOpbk() {
        return payeeOpbk;
    }

    public void setPayeeOpbk(String payeeOpbk) {
        this.payeeOpbk = payeeOpbk;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
