package com.scenetec.upf.operation.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 后管归集账户提现结果响应dto
 * @Author WJH
 * @Date 2019/07/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryCollectionAccountWithdrawRespDTO extends BaseInnerManageRespDTO {

    /**
     * 请求客户号端流水号
     */
    private String clientTransId;
    /**
     * 请求服务端流水号
     */
    private String serverTransId;
    /**
     * 提现客户号
     */
    private String industryCode;

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
