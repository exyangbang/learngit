package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 后管归集账户提现结果查询
 * @Author WJH
 * @Date 2019/07/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryCollectionAccountWithdrawReqDTO extends BaseInnerManageReqDTO {

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
     * 原请求提现客户端流水号
     */
    private String origClientTradeId;


    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "reqDate=".concat(reqDate),
                "reqTime=".concat(reqTime),
                "clientTransId=".concat(clientTransId),
                "industryCode=".concat(industryCode)
        };
    }
}
