package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.FundAccType;

import java.io.Serializable;

/**
 * @Description : 一般户：资金账户余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 14:46
 */
public class OneBankAccountBalanceQueryReqDTO extends SpBaseRequest implements Serializable {

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

    /**
     * 客户号处理方式
     * 1-查询客户号下所有信息
     * 输入客户号，或者卡号，或者客户账号
     * 0-查询卡/客户账号下信息，按组合查询（默认）组合条件包括：
     * 个人：
     * 卡号+账户序号
     * 卡号+货币代码+账户钞汇标志
     * 卡号+产品编号
     * 对公：
     * 客户账号+账户序号
     * 客户账号+货币代码+账户钞汇标志
     * 客户账号+产品编号
     */
    private String custAcctRangeFlg;

    /**客户账号*/
    private String custAccountNo;

    /**
     * 首次查询标志
     * 1-首次 0-非首次，如果首次查询，返回记录总行数，非首次不返回
     */
    private String firstInquiryFlg;

    /**返回笔数*/
    private String perReturnRows;

    /**起始笔数*/
    private String startingRow;

    /**
     *  资金账户类型
     * @return
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

    public String getCustAcctRangeFlg() {
        return custAcctRangeFlg;
    }

    public void setCustAcctRangeFlg(String custAcctRangeFlg) {
        this.custAcctRangeFlg = custAcctRangeFlg;
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

    public FundAccType getFundAccType() {
        return fundAccType;
    }

    public void setFundAccType(FundAccType fundAccType) {
        this.fundAccType = fundAccType;
    }
}
