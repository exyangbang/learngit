package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.FundAccType;

import java.io.Serializable;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 14:03
 */
public class OneBankTransQueryReqDTO  extends SpBaseRequest implements Serializable {

    /**
     * 客户端流水号
     */
    private String clientTradeId;

    /**
     * yyyyMMdd
     * 交易日期
     */
    private String tradeDate;
    /**
     * HHmmss
     * 交易时间
     */
    private String tradeTime;

    /**帐号*/
    private String acctNo;

    /**帐号类型*/
    private String acctType;

    /**
     * 交易类型
     *  01:代付，02:代收，04：转账
     */
    private String payTransType;

    /**业务发出日期*/
    private String reqDate;

    /**源服务端端流水号*/
    private String origServerTradeId;

    private FundAccType fundAccType;

    public String getClientTradeId() {
        return clientTradeId;
    }

    public void setClientTradeId(String clientTradeId) {
        this.clientTradeId = clientTradeId;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
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

    public String getOrigServerTradeId() {
        return origServerTradeId;
    }

    public void setOrigServerTradeId(String origServerTradeId) {
        this.origServerTradeId = origServerTradeId;
    }

    public String getPayTransType() {
        return payTransType;
    }

    public void setPayTransType(String payTransType) {
        this.payTransType = payTransType;
    }

    public FundAccType getFundAccType() {
        return fundAccType;
    }

    public void setFundAccType(FundAccType fundAccType) {
        this.fundAccType = fundAccType;
    }
}
