package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankGetOrgHotspotReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankGetOrgHotspotRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.AppHeader;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.EcifBody;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.QueryHeader;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 查询企业客户热点信息
 * @Author : WJH
 */
@Component("getOrgHotspot")
@ServiceContext(bodyClass = OneBankGetOrgHotspotReqDTO.class)
@Slf4j
public class OneBankGetOrgHotspotService extends AbstractEcifOnebankPaymentService<OneBankGetOrgHotspotReqDTO,OneBankGetOrgHotspotRespDTO> {

    private static final String PROPERTIES_KEY = "getOrgHotspot";
    private static final String API_NAME = UnionPaySubTypeEnum.GET_ORG_HOTSPOT.getDesc();

    public OneBankGetOrgHotspotService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }


    @Override
    public Map<String, Object> buildContent(FetureContext<OneBankGetOrgHotspotReqDTO,OneBankGetOrgHotspotRespDTO> fetureContext) {
        OneBankGetOrgHotspotReqDTO reqDTO = fetureContext.getSpReq();

        QueryHeader queryHeader = QueryHeader.builder().IdTpCd(reqDTO.getIdType()).IdNum(reqDTO.getBusLicCode()).build();
        AppHeader appHeader = AppHeader.builder().queryHeader(queryHeader).build();
        EcifBody ecifBody = EcifBody.builder().appHeader(appHeader).appBody(null).build();

        return (JSONObject) JSONObject.toJSON(ecifBody);
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankGetOrgHotspotReqDTO,OneBankGetOrgHotspotRespDTO> fetureContext, byte[] respBody) {
        OneBankGetOrgHotspotRespDTO respDTO = JSON.parseObject(respBody, OneBankGetOrgHotspotRespDTO.class);
        if (respDTO != null && respDTO.getAppBody() != null) {
            return new HashMap<String, Object>(2) {{
                put("data", respDTO.getAppBody().getHsClient());
            }};
        }
        return null;
    }

    @Override
    public String key() {
        return PROPERTIES_KEY;
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }

}
