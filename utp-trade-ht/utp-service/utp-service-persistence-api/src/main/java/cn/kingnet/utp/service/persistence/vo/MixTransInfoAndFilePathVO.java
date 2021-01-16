package cn.kingnet.utp.service.persistence.vo;

import cn.kingnet.utp.service.persistence.entity.vo.OutsideTransOrderVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.nio.file.Path;

/**
 * @Description
 * @Author WJH
 * @Date 2020/12/28
 */
@Getter
@Setter
public class MixTransInfoAndFilePathVO implements Serializable {
    public MixTransInfoAndFilePathVO() {
    }

    public MixTransInfoAndFilePathVO(OutsideTransOrderVo vo, Path localPath, String clientTransId, String serverTransId) {
        this.vo = vo;
        this.localPath = localPath;
        this.clientTransId = clientTransId;
        this.serverTransId = serverTransId;
    }

    private OutsideTransOrderVo vo;
    private Path localPath;
    private String clientTransId;
    private String serverTransId;

    public static MixTransInfoAndFilePathVO of(OutsideTransOrderVo vo, Path localPath, String clientTransId, String serverTransId) {
        return new MixTransInfoAndFilePathVO(vo, localPath, clientTransId, serverTransId);
    }
}
