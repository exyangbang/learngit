package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 定时任务交易结果查询
 * @Author WJH
 * @Date 2019/08/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryTransStatusReqDTO extends BaseInnerManageReqDTO {
    /**
     * 请求客户号端流水号
     */
    private String clientTradeId;
    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 原请求服务端流水号
     */
    private String origServerTradeId;


    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "clientTradeId=".concat(clientTradeId),
                "origServerTradeId=".concat(origServerTradeId),
                "industryCode=".concat(industryCode)
        };
    }
}
