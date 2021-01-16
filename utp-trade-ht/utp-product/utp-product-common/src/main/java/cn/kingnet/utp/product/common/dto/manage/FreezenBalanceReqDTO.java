package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 后管冻结/解冻资金请求
 * @Author WJH
 * @Date 2019/08/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FreezenBalanceReqDTO extends BaseInnerManageReqDTO {
    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 请求客户号端流水号
     */
    private String clientTransId;
    /**
     * 平台|用户账户等虚拟账户
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
    /**
     * 审核备注
     */
    private String auditRemark;
    /**
     * 状态（0-待审核 1-审核通过 2-审核驳回）
     */
    private String auditStatus;


    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "clientTransId=".concat(clientTransId),
                "userAccount=".concat(userAccount),
                "frozenAmount=".concat(String.valueOf(frozenAmount)),
                "operationType=".concat(operationType),
                "auditStatus=".concat(auditStatus)
        };
    }
}
