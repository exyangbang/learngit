package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;

/**
 * @Description : 提现结果查询请求DTO
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 11:32
 */
public class QueryWithdrawReqDTO extends BaseRequestDTO {

    /**业务发出日期*/
    private String reqDate;

    /**源客户端流水号*/
    private String origClientTradeId;

    /**源服务端端流水号*/
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
}
