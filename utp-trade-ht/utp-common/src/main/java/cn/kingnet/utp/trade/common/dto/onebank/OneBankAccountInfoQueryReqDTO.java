package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.DFA;

import java.io.Serializable;

/**
 * @Description : 一般户 信息查询
 * @Author : WJH
 * @Create : 2019/07/24 14:46
 */
public class OneBankAccountInfoQueryReqDTO extends SpBaseRequest implements Serializable {

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


    /**
     * 帐号
     */
    private String acctNo;

    /**
     * 帐号类型
     */
    private String acctType;


    /**
     * 客户账号
     */
    private String custAccountNo;

    /**
     * 0-否 1-验密
     */
    private String checkPasswordFlg = "0";

    /**
     * "A-正常
     * C-销户"
     */
    private String status = "A";
    /**
     * 首次查询标志
     * 1-首次 0-非首次，如果首次查询，返回记录总行数，非首次不返回
     */
    private String firstInquiryFlg = "1";

    /**
     * 返回笔数
     */
    private String perReturnRows = "100";

    /**
     * 起始笔数
     */
    private String startingRow = "0";

    private DFA dfa;

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

    public String getCheckPasswordFlg() {
        return checkPasswordFlg;
    }

    public void setCheckPasswordFlg(String checkPasswordFlg) {
        this.checkPasswordFlg = checkPasswordFlg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public DFA getDfa() {
        return dfa;
    }

    public void setDfa(DFA dfa) {
        this.dfa = dfa;
    }
}
