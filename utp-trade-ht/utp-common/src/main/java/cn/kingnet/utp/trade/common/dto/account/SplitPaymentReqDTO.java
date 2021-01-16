package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  单笔实时分账
 * @Author WJH
 * @Date 2019/11/29
 */
@Setter
@Getter
@ToString
public class SplitPaymentReqDTO extends BaseRequestDTO {
    /**
     * 请求日期	varchar(8)	M		按自然日(yyyyMMdd)也作为清算日期
     */
    private String reqDate;
    /**
     * 请求时间	varchar(6)	M		HHmmss
     */
    private String reqTime;
    /**
     * 入账子账户	varchar(30)	M		开户获取
     */
    private String account;
    /**
     * 分账金额	varchar(15)	M		单位分
     */
    private String payAmt;
    /**
     * 备注说明	varchar(1024)	O
     */
    private String remark;
    /**
     * 支付订单号列表	varchar(1024)	M		多个订单号用”,”逗号隔开，取值为4.3.4接口中“支付订单号”且已上送成功。每个支付订单号至多被关联次数限制受后管配置
     */
    private String tradeOrderIds;

}
