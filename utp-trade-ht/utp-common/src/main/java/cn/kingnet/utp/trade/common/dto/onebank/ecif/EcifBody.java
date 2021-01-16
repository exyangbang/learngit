package cn.kingnet.utp.trade.common.dto.onebank.ecif;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

/**
 * EcifBody 请求|响应body报文结构
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EcifBody implements Serializable {

    private AppHeader appHeader;
    private Map<String, Object> appBody;

}
