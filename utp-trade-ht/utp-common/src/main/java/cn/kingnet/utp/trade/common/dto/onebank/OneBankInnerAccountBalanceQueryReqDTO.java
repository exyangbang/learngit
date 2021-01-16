package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;

import java.io.Serializable;

/**
 * @Description : 内部户：资金账户余额查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/15 14:46
 */
public class OneBankInnerAccountBalanceQueryReqDTO extends SpBaseRequest implements Serializable {

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
     * 账号	string	40
     * "输入为账号或待销账序号，返回值为一笔记录
     * 输入科目、机构、货币代号，返回值为多笔记录"
     */
    private String subAccount;

    /**
     * 首次查询标志
     * 1-首次 0-非首次，如果首次查询，返回记录总行数，非首次不返回
     */
    private String firstInquiryFlg;

    /**
     * 返回笔数
     */
    private String perReturnRows;

    /**
     * 起始笔数
     */
    private String startingRow;


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

    public String getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
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
}
