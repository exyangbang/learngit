package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description 后管收益账户归集划转结果查询
 * @Author WJH
 * @Date 2019/07/24
 */
@Setter
@Getter
public class QueryFeeIncomeAccountCollectionRespDTO extends BaseInnerManageRespDTO {

    /**
     * 请求客户号端流水号
     */
    private String clientTransId;
    /**
     * 请求服务端流水号
     */
    private String serverTransId;
    /**
     * 收益账户
     */
    private String account;

    /**
     * 交易状态：见枚举类
     */
    private String transStatus;
    /**
     * 交易描述
     */
    private String transDesc;

    /**
     * 原提现客户端流水号
     */
    private String origClientTradeId;

    /**
     * 原提现服务端流水号
     */
    private String origServerTradeId;
    /**
     * 对账日期
     */
    private String reconcileDate;


}
