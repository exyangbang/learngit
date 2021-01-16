package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 后管归集账户提现响应dto
 * @Author WJH
 * @Date 2019/07/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CollectionAccountWithdrawRespDTO extends BaseInnerManageRespDTO {

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
     * 提现虚拟账号
     */
    private String account;
    /**
     * 提现金额
     */
    private Long transAmount;
    /**
     * 交易状态：见枚举类
     */
    private String transStatus;
    /**
     * 交易描述
     */
    private String transDesc;


}
