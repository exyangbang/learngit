package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 单笔交易流水查询
 * @Author WJH
 * @Date 2019/08/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
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