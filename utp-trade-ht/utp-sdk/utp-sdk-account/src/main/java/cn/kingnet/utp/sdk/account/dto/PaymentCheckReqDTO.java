package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;
import lombok.*;

/**
 * @Description
 * @Author caixh
 * @Date 2020/3/23.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCheckReqDTO extends BaseRequestDTO {


    /**
     * 虚拟账户
     */
    private String userAccount;
    /**
     * 账号
     */
    private String acctNo;
    /**
     * 鉴权金额
     */
    private String authAmt;

}
