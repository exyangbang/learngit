package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description 上送分账-支付流水结果查询 请求
 * @Author WJH
 * @Date 2018年10月29日
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuerySplitPayFlowResultReqDTO extends BaseRequestDTO {

    /**
     * 批次号
     */
    private String batchNo;


}
