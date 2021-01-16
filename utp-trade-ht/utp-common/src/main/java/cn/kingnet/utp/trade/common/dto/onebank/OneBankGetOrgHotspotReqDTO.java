package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : GetPersonHotspot	查询企业客户热点信息	2013010002	01
 * @Author : WJH
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankGetOrgHotspotReqDTO extends SpBaseRequest implements Serializable {

    /**
     * 交易流水号
     */
    private String clientTradeId;

    /**
     * 请求日期
     */
    private String reqDate;

    /**
     * 请求时间
     */
    private String reqTime;
    /**
     * 证件类型 101 身份证，102 护照  103 军官证 201=企业营业执照》》 218=社会统一信用号
     */
    private String idType="218";
    /**
     * 企业营业执照即社会统一信用号
     */
    private String busLicCode;


}
