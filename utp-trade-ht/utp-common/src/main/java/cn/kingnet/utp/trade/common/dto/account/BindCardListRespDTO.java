package cn.kingnet.utp.trade.common.dto.account;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import lombok.*;

import java.util.List;

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
public class BindCardListRespDTO extends BaseResponseDTO {

    /**
     * 虚拟账户
     */
    private String userAccount;
    /**
     * 绑卡信息Json字符串
     */
    private String cardList;
}