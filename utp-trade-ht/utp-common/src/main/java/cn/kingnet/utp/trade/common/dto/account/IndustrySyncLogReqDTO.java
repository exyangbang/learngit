package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description 华通银行账户明细同步日志
 * @Author WJH
 * @Date 2019年01月22日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IndustrySyncLogReqDTO extends BaseRequestDTO {

    /**
     * 代付客户号
     */
    private String industryCode;

    /**
     * 起始同步日期yyyyMMdd
     *
     */
    private String startDate;

}
