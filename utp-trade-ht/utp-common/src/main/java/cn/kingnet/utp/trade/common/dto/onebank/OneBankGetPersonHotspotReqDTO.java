package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.*;

import java.io.Serializable;

/**
 * @Description : GetPersonHotspot	查询个人客户热点信息	2013010001	01
 * @Author : WJH
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OneBankGetPersonHotspotReqDTO extends SpBaseRequest implements Serializable {

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
     * 个人/法人证件类型 101 身份证，102 护照  103 军官证
     */
    private String idType = "101";
    /**
     * 个人/法人证件号
     */
    private String idCode;


}
