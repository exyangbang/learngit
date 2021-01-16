package cn.kingnet.utp.trade.common.dto;

import java.io.Serializable;

/**
 * Created on 2018/5/17
 *
 * @author by linkaigui
 */
public class BaseRequestDTO implements Serializable {

    /**
     * 客户端流水号
     */
    private String clientTradeId;

    public String getClientTradeId() {
        return clientTradeId;
    }

    public void setClientTradeId(String clientTradeId) {
        this.clientTradeId = clientTradeId;
    }
}
