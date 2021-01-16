package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.FundAccType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhongli
 * @date 2018/10/15
 */
@Setter
@Getter
public class OneBankTransferReq extends SpBaseRequest{
    /**
     * 交易流水号
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
    /**
     * 账号
     */
    private String acctNo;
    /**
     * 账号类型 2是卡号，3是账号
     */
    private String acctType = "3";

    /**
     * 资金账户类型：内部户[target-dfa]|一般户[target-dfa-general]
     */
    private FundAccType fundAccType;
    /**
     * 簿记枚举渠道编号：详见 ChannelKey 若渠道未银联代付(事后划账) 则取 新产品编码
     */
    private String channelKey;

    private OneBankTransferReqContent content;
}
