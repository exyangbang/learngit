package com.scenetec.upf.operation.model.vo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 后管冻结/解冻资金响应
 * @Author WJH
 * @Date 2019/08/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FreezenBalanceRespDTO extends BaseInnerManageRespDTO {

    /**
     * 请求客户号端流水号
     */
    private String clientTransId;
    /**
     * 响应服务端流水号
     */
    private String serverTransId;
    /**
     * 客户号
     */
    private String userAccount;

    /**
     * 交易金额 15
     */
    private Long frozenAmount;
    /**
     * 操作类型：0冻结 1解冻
     */
    private String operationType;

}
