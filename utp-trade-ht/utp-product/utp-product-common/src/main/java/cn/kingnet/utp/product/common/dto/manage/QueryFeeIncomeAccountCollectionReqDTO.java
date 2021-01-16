package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description 后管收益账户归集划转结果查询
 * @Author WJH
 * @Date 2019/07/24
 */
@Getter
@Setter
public class QueryFeeIncomeAccountCollectionReqDTO extends BaseInnerManageReqDTO {

    private String reqDate;
    private String reqTime;
    /**
     * 请求客户号端流水号
     */
    private String clientTransId;
    /**
     * 收益虚拟账户
     */
    private String account;
    /**
     * 原请求提现服务端流水号
     */
    private String origServerTradeId;


    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "reqDate=".concat(reqDate),
                "reqTime=".concat(reqTime),
                "origServerTradeId=".concat(origServerTradeId),
                "account=".concat(account)
        };
    }
}
