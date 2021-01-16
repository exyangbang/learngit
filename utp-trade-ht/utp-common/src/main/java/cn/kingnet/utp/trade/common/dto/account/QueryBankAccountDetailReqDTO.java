package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description : 代付客户号对应的华通专有账户明细
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryBankAccountDetailReqDTO extends BaseRequestDTO {


    /**
     * 起始日期：yyyyMMdd
     */
    private String startDate;
    /**
     * 终止日志：HHmmss
     */
    private String endDate;

    /**
     * 查询标识：0 本地记录 1实时查询华通记录
     */
    private String filteFlag;

}
