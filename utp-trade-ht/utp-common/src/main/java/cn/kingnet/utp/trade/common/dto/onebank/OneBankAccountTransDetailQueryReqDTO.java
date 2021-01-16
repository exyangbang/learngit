package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.FundAccType;

import java.io.Serializable;

/**
 * @Description : 一般户：资金账户资金明细查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 14:46
 */
public class OneBankAccountTransDetailQueryReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 交易流水号
     */
    private String clientTradeId;

    /**请求日期*/
    private String reqDate;

    /**请求时间*/
    private String reqTime;

    /**帐号*/
    private String acctNo;

    /**帐号类型*/
    private String acctType;

    /**客户帐号*/
    private String custAccountNo;

    /**
     * 首次查询标志
     * 1-首次 0-非首次
     * 默认是0-非首次
     */
    private String firstInquiryFlg;

    /**返回行数*/
    private String perReturnRows;

    /**起始行数*/
    private String startingRow;
    /**
     * 查询明细：起始日期 yyyyMMdd
     */
    private String startingDate;
    /**
     * 查询明细：终止日期 yyyyMMdd
     */
    private String endDate;
    /**
     * 0 - 按时间顺序顺序查询
     * 1 - 按时间顺序倒序查询
     * 默认 0
     */
    private String inquiryOrder = "0";

    /**
     * 借贷标识
     * "0-借方 1-贷方
     * 不送则全部"
     */
    private String drcrFlag;

    /**
     * 资金账户类型
     */
    private FundAccType fundAccType;

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

    public String getCustAccountNo() {
        return custAccountNo;
    }

    public void setCustAccountNo(String custAccountNo) {
        this.custAccountNo = custAccountNo;
    }

    public String getFirstInquiryFlg() {
        return firstInquiryFlg;
    }

    public void setFirstInquiryFlg(String firstInquiryFlg) {
        this.firstInquiryFlg = firstInquiryFlg;
    }

    public String getPerReturnRows() {
        return perReturnRows;
    }

    public void setPerReturnRows(String perReturnRows) {
        this.perReturnRows = perReturnRows;
    }

    public String getStartingRow() {
        return startingRow;
    }

    public void setStartingRow(String startingRow) {
        this.startingRow = startingRow;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInquiryOrder() {
        return inquiryOrder;
    }

    public void setInquiryOrder(String inquiryOrder) {
        this.inquiryOrder = inquiryOrder;
    }

    public String getDrcrFlag() {
        return drcrFlag;
    }

    public void setDrcrFlag(String drcrFlag) {
        this.drcrFlag = drcrFlag;
    }

    public FundAccType getFundAccType() {
        return fundAccType;
    }

    public void setFundAccType(FundAccType fundAccType) {
        this.fundAccType = fundAccType;
    }
}
