package com.scenetec.upf.operation.model.domain.merchant;

import com.scenetec.upf.operation.model.vo.BaseInnerManageRespDTO;
import lombok.Data;

/**
 * @Description 单笔交易流水查询
 * @Author WJH
 * @Date 2019/08/30
 */
@Data
public class QuerySingleTransStatusRespDTO extends BaseInnerManageRespDTO {

    /**
     * 交易类型
     */
    private String tradeType;
    /**
     * 交易金额
     */
    private Long transAmount;
    /**
     * 交易状态
     */
    private String transStatus;
}