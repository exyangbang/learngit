package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;

import java.io.Serializable;

/**
 * @Description : 内部户：资金账户资金明细查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 14:46
 */
public class OneBankInnerAccountTransDetailQueryReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 交易流水号
     */
    private String clientTradeId;

    /**
     * 请求日期
     */
    private String reqDate;

    /**
     * 请求时间
     */
    private String reqTime;

    /**帐号*/
    private String acctNo;

    /**帐号类型*/
    private String acctType;

    /**
     * 账号	string	40	Y
     **/
    private String custAccountNo;
    /**
     * 账户机构	string	10
     **/
    private String accountBranchCode;
    /**
     * 起始日期	string	8
     **/
    private String startingDate;
    /**
     * 结束日期	string	8
     */
    private String terminationDate;
    /**
     * 借贷标志	string	1		"0-借方 1-贷方"
     */
    private String drcrFlag;
    /**
     * 返回行数	long	19	Y
     */
    private String perReturnRows;
    /**
     * 首次查询标志	string	1	Y	"1-首次 0-非首次"
     */
    private String firstInquiryFlg;
    /**
     * 起始行数	long	19	Y	翻页查询第一笔送
     */
    private String startingRow;
    /**
     * 起始日期为空时不允许输入
     * 起始时间 HHmmss
     */
    private String startingTime;
    /**
     * 终止日期为空时不允许输入
     * 终止时间 HHmmss
     */
    private String terminationTime;
    /**
     * 对方账号 对方账号|来款账号
     */
    private String rivalAcct;


    public String getClientTradeId() {
        return clientTradeId;
    }

    public void setClientTradeId(String clientTradeId) {
        this.clientTradeId = clientTradeId;
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

    public String getCustAccountNo() {
        return custAccountNo;
    }

    public void setCustAccountNo(String custAccountNo) {
        this.custAccountNo = custAccountNo;
    }

    public String getAccountBranchCode() {
        return accountBranchCode;
    }

    public void setAccountBranchCode(String accountBranchCode) {
        this.accountBranchCode = accountBranchCode;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getDrcrFlag() {
        return drcrFlag;
    }

    public void setDrcrFlag(String drcrFlag) {
        this.drcrFlag = drcrFlag;
    }

    public String getPerReturnRows() {
        return perReturnRows;
    }

    public void setPerReturnRows(String perReturnRows) {
        this.perReturnRows = perReturnRows;
    }

    public String getFirstInquiryFlg() {
        return firstInquiryFlg;
    }

    public void setFirstInquiryFlg(String firstInquiryFlg) {
        this.firstInquiryFlg = firstInquiryFlg;
    }

    public String getStartingRow() {
        return startingRow;
    }

    public void setStartingRow(String startingRow) {
        this.startingRow = startingRow;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getTerminationTime() {
        return terminationTime;
    }

    public void setTerminationTime(String terminationTime) {
        this.terminationTime = terminationTime;
    }

    public String getRivalAcct() {
        return rivalAcct;
    }

    public void setRivalAcct(String rivalAcct) {
        this.rivalAcct = rivalAcct;
    }
}
