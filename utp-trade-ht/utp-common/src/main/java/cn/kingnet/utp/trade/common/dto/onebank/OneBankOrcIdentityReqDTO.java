package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : orc身份识别
 * @Author : WJH
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class OneBankOrcIdentityReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 客户端流水号 M
     */
    private String clientTradeId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号码 M
     */
    private String idcard;
    /**
     * 身份证照片base64 M
     */
    private String idcardImage;
}