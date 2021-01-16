package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 后管归集账户提现申请
 * @Author WJH
 * @Date 2019/07/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CollectionAccountWithdrawReqDTO extends BaseInnerManageReqDTO {

    /**
     * 归集账户提现表主键id || 关联表验证如下三个字段是否一致
     */
    private String id;
    private String reqDate;
    private String reqTime;
    /**
     * 请求客户号端流水号
     */
    private String clientTransId;
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


    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "id=".concat(id),
                "reqDate=".concat(reqDate),
                "reqTime=".concat(reqTime),
                "clientTransId=".concat(clientTransId),
                "industryCode=".concat(industryCode),
                "account=".concat(account),
                "transAmount=".concat(String.valueOf(transAmount))
        };
    }
}
