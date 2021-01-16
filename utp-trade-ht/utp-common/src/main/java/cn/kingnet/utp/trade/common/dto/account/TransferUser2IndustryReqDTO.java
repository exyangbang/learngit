package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/06
 */
public class TransferUser2IndustryReqDTO extends BaseRequestDTO {
    /**
     * 请求日期	varchar(8)	M		按自然日(yyyyMMDD)
     */
    private String reqDate;
    /**
     * 请求时间	varchar(6)	M		HHmmss
     */
    private String reqTime;
    /**
     * 转出用户账号	varchar(19)	M
     */
    private String payerUserAccount;

    /**
     * 转账金额	varchar(15)	M		单位分
     */
    private String payAmt;
    /**
     * 备注说明	varchar(200)	O
     */
    private String remark;

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

    public String getPayerUserAccount() {
        return payerUserAccount;
    }

    public void setPayerUserAccount(String payerUserAccount) {
        this.payerUserAccount = payerUserAccount;
    }

    public String getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
