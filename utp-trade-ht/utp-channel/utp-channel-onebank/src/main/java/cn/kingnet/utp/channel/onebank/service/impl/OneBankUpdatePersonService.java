package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankUpdatePersonReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankUpdatePersonRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.*;
import cn.kingnet.utp.trade.common.enums.HTAddressType;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 更新个人客户信息
 * @Author : WJH
 */
@Component("updatePerson")
@ServiceContext(bodyClass = OneBankUpdatePersonReqDTO.class)
@Slf4j
public class OneBankUpdatePersonService extends AbstractEcifOnebankPaymentService<OneBankUpdatePersonReqDTO, OneBankUpdatePersonRespDTO> {

    private static final String PROPERTIES_KEY = "updatePerson";
    private static final String API_NAME = UnionPaySubTypeEnum.UPDATE_PERSON.getDesc();

    public OneBankUpdatePersonService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    public Map<String, Object> buildContent(FetureContext<OneBankUpdatePersonReqDTO, OneBankUpdatePersonRespDTO> fetureContext) {
        OneBankUpdatePersonReqDTO reqDTO = fetureContext.getSpReq();
        Assert.hasText(reqDTO.getClientId(), () -> "参数[clientId]不能为空");
        QueryHeader queryHeader = QueryHeader.builder().ClientId(reqDTO.getClientId()).IdTpCd(reqDTO.getIdType()).IdNum(reqDTO.getIdCode()).build();
        AppHeader appHeader = AppHeader.builder().queryHeader(queryHeader).build();

        //ecif客户信息：证件类型及证件号 手机号码不允许修改
        Xperson.XpersonBuilder builder = Xperson.builder();

        if (StringUtil.isNoneEmpty(reqDTO.getIdType(), reqDTO.getIdCode(), reqDTO.getIdIndate())) {
            Identifier identifier = new Identifier(reqDTO.getIdType(), reqDTO.getIdCode(), reqDTO.getIdIndate());
            builder.identifier(new Identifier[]{identifier});
        }

        if (StringUtil.isNotEmpty(reqDTO.getAddress())) {
            Address address = new Address(reqDTO.getAddress(), HTAddressType.CONTACT.getCode(),null,null,null);
            builder.address(new Address[]{address});
        }

        if (StringUtil.isNotEmpty(reqDTO.getTelephone())) {
            ContactMethod contactMethod = instanceContactMethodByTelphone(reqDTO.getTelephone());
            builder.contactMethod(new ContactMethod[]{contactMethod});
        }

        Xperson xperson = builder.clientName(reqDTO.getRealName()).countryTpCd(reqDTO.getCountryTpCd()).residentTpCd(reqDTO.getCdResidentTp())
                .genderTpCd(toGenderTpCd(reqDTO.getGenderTpCd())).occupationTpCd(reqDTO.getOccupationTpCd())
                .birthDt(reqDTO.getBirthDt())
                .createTms(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).build();


        Map<String, Object> appBody = new HashMap<String, Object>(4) {{
            put("Xperson", xperson);
        }};

        EcifBody ecifBody = EcifBody.builder().appHeader(appHeader).appBody(appBody).build();

        return (JSONObject) JSONObject.toJSON(ecifBody);
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankUpdatePersonReqDTO, OneBankUpdatePersonRespDTO> fetureContext, byte[] respBody) {
        OneBankUpdatePersonRespDTO respDTO = JSON.parseObject(respBody, OneBankUpdatePersonRespDTO.class);
        if (respDTO != null && respDTO.getAppBody() != null) {
            Xperson xperson = respDTO.getAppBody().getXperson();
            return new HashMap<String, Object>(2) {{
                put("data", xperson);
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
