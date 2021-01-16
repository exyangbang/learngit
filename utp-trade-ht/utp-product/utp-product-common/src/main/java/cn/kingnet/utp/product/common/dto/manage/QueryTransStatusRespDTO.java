package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 定时任务交易结果查询
 * @Author WJH
 * @Date 2019/08/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryTransStatusRespDTO extends BaseInnerManageRespDTO {

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
