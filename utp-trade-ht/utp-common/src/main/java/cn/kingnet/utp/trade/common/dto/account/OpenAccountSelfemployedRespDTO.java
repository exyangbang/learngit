package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description : 个体工商户开户
 * @Author : linkaigui
 * @Create : 2020/2/11 16:56
 */
@Setter
@Getter
public class OpenAccountSelfemployedRespDTO extends BaseResponseDTO {
    /**
     * 虚拟账户
     */
    private String userAccount;
}
