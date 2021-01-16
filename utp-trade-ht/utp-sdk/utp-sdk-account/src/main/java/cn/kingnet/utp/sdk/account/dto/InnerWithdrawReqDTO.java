package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;

/**
 * @Description : 提现请求DTO
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/9 15:18
 */
public class InnerWithdrawReqDTO extends BaseRequestDTO {


    /**
     * 清算分账时系统自动发起提现时：必填
     *
     */
    private String splitInfoId;

    /**
     * 代付客户号
     */
    private String industryCode;

    /**
     * 必填
     * 用户账户
     */
    private String userAccount;


    /**
     * 必填
     * 请求日期
     */
    private String reqDate;

    /**
     * 必填
     * 请求时间
     */
    private String reqTime;

    /**
     * 必填
     * 交易金额
     */
    private String payAmt;

    /**
     * 后端回调地址
     */
    private String callbackUrl;

    /**
     * 必填
     * 备注说明
     */
    private String remark;

    /**
     * 手机号码
     */
    private String mobile;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
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

    public String getSplitInfoId() {
        return splitInfoId;
    }

    public void setSplitInfoId(String splitInfoId) {
        this.splitInfoId = splitInfoId;
    }
}
