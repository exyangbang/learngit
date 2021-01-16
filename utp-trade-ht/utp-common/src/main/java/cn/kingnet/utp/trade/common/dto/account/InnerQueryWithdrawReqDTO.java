package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;

/**
 * @Description : 内部系统调用
 */
public class InnerQueryWithdrawReqDTO extends BaseRequestDTO {


    /**
     * 清算分账时系统自动发起提现时：必填
     */
    private String splitInfoId;


    /**
     * 必填
     * 代付客户号
     */
    private String industryCode;

    /**
     * 必填
     * 用户账户
     */
    private String userAccount;

    /**
     * 业务发出日期
     */
    private String reqDate;

    /**
     * 源客户端流水号
     */
    private String origClientTradeId;

    /**
     * 源服务端端流水号
     */
    private String origServerTradeId;


    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getOrigClientTradeId() {
        return origClientTradeId;
    }

    public void setOrigClientTradeId(String origClientTradeId) {
        this.origClientTradeId = origClientTradeId;
    }

    public String getOrigServerTradeId() {
        return origServerTradeId;
    }

    public void setOrigServerTradeId(String origServerTradeId) {
        this.origServerTradeId = origServerTradeId;
    }

    public String getSplitInfoId() {
        return splitInfoId;
    }

    public void setSplitInfoId(String splitInfoId) {
        this.splitInfoId = splitInfoId;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
