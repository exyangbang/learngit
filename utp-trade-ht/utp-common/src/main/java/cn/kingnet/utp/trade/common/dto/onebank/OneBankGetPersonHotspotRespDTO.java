package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.onebank.ecif.AppHeader;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.HsClient;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : GetPersonHotspot	查询个人客户热点信息	2013010001	01
 * @Author : WJH
 */
@Setter
@Getter
@NoArgsConstructor
public class OneBankGetPersonHotspotRespDTO extends SpBaseResponse implements Serializable {

    private AppHeader appHeader;
    private AppBody appBody;


    @Getter
    @Setter
    public static class AppBody implements Serializable {
        private HsClient hsClient;

    }
}
