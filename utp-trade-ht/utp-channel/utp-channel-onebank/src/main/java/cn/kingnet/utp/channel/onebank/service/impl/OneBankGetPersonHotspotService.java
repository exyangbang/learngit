package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankGetPersonHotspotReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankGetPersonHotspotRespDTO;
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
 * @Description : 查询个人客户热点信息
 * @Author : WJH
 */
@Component("getPersonHotspot")
@ServiceContext(bodyClass = OneBankGetPersonHotspotReqDTO.class)
@Slf4j
public class OneBankGetPersonHotspotService extends AbstractEcifOnebankPaymentService<OneBankGetPersonHotspotReqDTO,OneBankGetPersonHotspotRespDTO> {

    private static final String PROPERTIES_KEY = "getPersonHotspot";
    private static final String API_NAME = UnionPaySubTypeEnum.GET_PERSON_HOTSPOT.getDesc();

    public OneBankGetPersonHotspotService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    public Object buildContent(FetureContext<OneBankGetPersonHotspotReqDTO, OneBankGetPersonHotspotRespDTO> fetureContext) {

        OneBankGetPersonHotspotReqDTO reqDTO = fetureContext.getSpReq();

        QueryHeader queryHeader = QueryHeader.builder().IdTpCd(reqDTO.getIdType()).IdNum(reqDTO.getIdCode()).build();
        AppHeader appHeader = AppHeader.builder().queryHeader(queryHeader).build();
        EcifBody ecifBody = EcifBody.builder().appHeader(appHeader).appBody(null).build();

        return JSONObject.toJSON(ecifBody);
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankGetPersonHotspotReqDTO, OneBankGetPersonHotspotRespDTO> fetureContext, byte[] respBody) {
        OneBankGetPersonHotspotRespDTO respDTO = JSON.parseObject(respBody,OneBankGetPersonHotspotRespDTO.class);
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
