package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.onebank.ecif.AppHeader;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.Xperson;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description : 建立个人客户信息
 * @Author : WJH
 */
@Setter
@Getter
@NoArgsConstructor
public class OneBankAddPersonRespDTO extends SpBaseResponse implements Serializable {

    private AppHeader appHeader;
    private AppBody appBody;


    @Getter
    @Setter
    public static class AppBody implements Serializable {
        private Xperson xperson;
    }
}
