package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 代付客户号对应的华通专有账户明细
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
     * 过滤标识：1按照来款账户配置顾虑，其他都不过滤
     */
    private String filteFlag;

}
