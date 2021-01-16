package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;

/**
 * @Description : 提现结果查询请求DTO
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 11:32
 */
public class QueryWithdrawReqDTO extends BaseRequestDTO {

    /**客户账户*/
    private String userAccount;
    /**业务发出日期*/
    private String reqDate;

    /**源客户端流水号*/
    private String origClientTradeId;

    /**源服务端端流水号*/
    private String origServerTradeId;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

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
}
