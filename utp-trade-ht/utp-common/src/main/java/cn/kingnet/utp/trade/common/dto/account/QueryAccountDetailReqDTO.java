package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description 账户资金明细查询请求
 * @Author WJH
 * @Date 2018年11月23日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryAccountDetailReqDTO extends BaseRequestDTO {

    /**
     * 必填
     * 用户账户
     */
    private String userAccount;

    /**
     * 操作类型：详见AccountOperType枚举类
     */
    private String operateType;

    /**
     * 必填
     * 开始日期
     */
    private String startDate;

    /**
     * 必填
     * 终止日期
     */
    private String endDate;

    private String peerAccNo;

}
