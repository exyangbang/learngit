package cn.kingnet.utp.sdk.account.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;
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