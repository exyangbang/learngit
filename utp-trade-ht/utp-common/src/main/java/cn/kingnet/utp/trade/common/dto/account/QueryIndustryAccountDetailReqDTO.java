package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description : 描述
 * @Author : WJH
 * @Create : 2019/03/06 10:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryIndustryAccountDetailReqDTO extends BaseRequestDTO {


    /**
     * 操作类型：详见AccountOperType枚举类
     */
    private String operateType;

    /**
     * 开始日期
     */
    private String startDate;
    /**
     * 截止日期
     */
    private String endDate;
    /**
     * 收款账户
     */
    private String peerAccNo;
}
