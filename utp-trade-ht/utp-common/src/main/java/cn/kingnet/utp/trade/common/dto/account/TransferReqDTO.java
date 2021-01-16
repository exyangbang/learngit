package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description : 转账请求DTO
 * @Author : linjiazhen@scenetec.com
 * @Create : 2018/11/29 17:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TransferReqDTO extends BaseRequestDTO {
    /**请求日期*/
    private String reqDate;
    /**请求时间*/
    private String reqTime;
    /**转出账户*/
    private String payerAccNo;
    /**转出账户名称*/
    private String payerAccName;
    /**转入代付客户号*/
    private String payeeIndustryCode;
    /**转入账户*/
    private String payeeAccNo;
    /**转入账户名称*/
    private String payeeAccName;
    /**转入清算行号*/
    private String payeeBankCode;
    /**转账金额*/
    private String payAmt;
    /**回调地址*/
    private String callbackUrl;
    /**备注说明*/
    private String remark;

}
