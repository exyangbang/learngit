package cn.kingnet.utp.product.common.dto.manage;

import cn.kingnet.utp.product.common.dto.BaseInnerManageReqDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sheqingquan@scenetec.com
 * @description: 单笔交易流水查询
 * @create 2020/2/18 9:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuerySingleTransStatusReqDTO extends BaseInnerManageReqDTO {

    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 交易日期
     * yyyyMMdd
     */
    private String transDate;
    /**
     * 客户号端流水号
     */
    private String clientTransId;

    @Override
    public String[] toSHA1() {
        return new String[]{"appid=".concat(appid), "secret=".concat(secret),
                "industryCode=".concat(industryCode),
                "transDate=".concat(transDate),
                "clientTransId=".concat(clientTransId)
        };
    }
}