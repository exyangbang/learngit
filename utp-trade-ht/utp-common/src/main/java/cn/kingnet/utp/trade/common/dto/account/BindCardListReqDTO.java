package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
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
public class BindCardListReqDTO extends BaseRequestDTO {


    /**
     * 虚拟账户
     */
    private String userAccount;
    /**
     * 账号
     */
    private String acctNo;

}
