package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description : 批量账户入账请求dto
 * @Author : WJH
 * @Create : 2018-10-09
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class BatchRecordedReqDTO extends BaseRequestDTO {

    /**客户类型*/
    private String userType;
    /**客户编码*/
    private String userNo;

    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 总记录数
     */
    private String count;
    /**
     * 总金额
     */
    private String sumAmount;
    /**
     * 请求日期：yyyyMMdd
     */
    private String reqDate;
    /**
     * 请求时间：HHmmss
     */
    private String reqTime;
    /**
     * 账户入账集合
     * [
     * {"seqNo":"1","merNo":"9001","amount":"10"},
     * {"seqNo":"2","merNo":"9002","amount":"100"}
     * ]
     */
    private String items;


}
