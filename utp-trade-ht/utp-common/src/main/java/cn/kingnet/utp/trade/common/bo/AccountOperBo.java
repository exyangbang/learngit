package cn.kingnet.utp.trade.common.bo;

import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountOperBo implements Serializable {


    /**
     * 代付客户号| 不为空
     */
    @NotNull
    private String industryCode;

    /**
     * 账户子操作类型| 不为空
     */
    @NotNull
    private AccountOperSubType accountOperSubType;
    /**
     * 虚拟账号| 不为空
     */
    @NotNull
    private String userAccount;
    /**
     * 发生金额| 不为空
     */
    @NotNull
    private Long amount;
    /**
     * 对方账号
     */
    private String peerAccNo;
    /**
     * 对方账户名称
     */
    private String peerAccName;
    /**
     * 备注说明
     */
    private String remark;
    /**
     * 服务端流水号
     */
    private String serverTransId;
    /**
     * 外部系统订单号
     */
    private String outsideOrderId;



}
