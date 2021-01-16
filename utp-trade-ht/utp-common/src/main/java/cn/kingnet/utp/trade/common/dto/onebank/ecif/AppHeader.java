package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.*;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2019/10/30
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppHeader implements Serializable {
    private QueryHeader queryHeader;
}
