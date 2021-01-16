package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAddPersonReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAddPersonRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.*;
import cn.kingnet.utp.trade.common.enums.HTAddressType;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
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
 * @Description : 建立个人客户信息
 * @Author : WJH
 */
@Component("addPerson")
@ServiceContext(bodyClass = OneBankAddPersonReqDTO.class)
@Slf4j
public class OneBankAddPersonService extends AbstractEcifOnebankPaymentService<OneBankAddPersonReqDTO,OneBankAddPersonRespDTO> {

    private static final String PROPERTIES_KEY = "addPerson";
    private static final String API_NAME = UnionPaySubTypeEnum.ADD_PERSON.getDesc();

    public OneBankAddPersonService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    public Map<String, Object> buildContent(FetureContext<OneBankAddPersonReqDTO,OneBankAddPersonRespDTO>  fetureContext) {
        OneBankAddPersonReqDTO reqDTO = fetureContext.getSpReq();

        Assert.hasText(reqDTO.getIdType(),()->"请求参数[idType]证件类型不能为空");
        Assert.hasText(reqDTO.getIdCode(),()->"请求参数[idCode]证件号码不能为空");
        Assert.hasText(reqDTO.getIdIndate(),()->"请求参数[idIndate]证件有效期不能为空");
        Assert.hasText(reqDTO.getAddress(),()->"请求参数[address]详细地址不能为空");
        Assert.hasText(reqDTO.getTelephone(),()->"请求参数[telephone]联系手机号码不能为空");
        Assert.hasText(reqDTO.getCountryTpCd(),()->"请求参数[countryTpCd]国籍代码不能为空");
        Assert.hasText(reqDTO.getRealName(),()->"请求参数[realName]姓名不能为空");
        Assert.hasText(reqDTO.getGenderTpCd(),()->"请求参数[genderTpCd]性别不能为空");
        Assert.hasText(reqDTO.getOccupationTpCd(),()->"请求参数[occupationTpCd]职业不能为空");
        Assert.hasText(reqDTO.getCdResidentTp(),()->"请求参数[cdResidentTp]居民类型不能为空");

        QueryHeader queryHeader = QueryHeader.builder().IdTpCd(reqDTO.getIdType()).IdNum(reqDTO.getIdCode()).build();
        AppHeader appHeader = AppHeader.builder().queryHeader(queryHeader).build();

        Identifier identifier = new Identifier(reqDTO.getIdType(), reqDTO.getIdCode(), reqDTO.getIdIndate());
        Address address = new Address(reqDTO.getAddress(), HTAddressType.CONTACT.getCode(),null,null,null);
        ContactMethod contactMethod = instanceContactMethodByTelphone(reqDTO.getTelephone());

        Xperson xperson = Xperson.builder().clientName(reqDTO.getRealName()).countryTpCd(reqDTO.getCountryTpCd())
                .identifier(null).contactMethod(new ContactMethod[]{contactMethod}).address(new Address[]{address})
                .birthDt(reqDTO.getBirthDt()).genderTpCd(toGenderTpCd(reqDTO.getGenderTpCd())).occupationTpCd(reqDTO.getOccupationTpCd())
                .residentTpCd(reqDTO.getCdResidentTp()).createTms(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).build();

        Map<String, Object> appBody = new HashMap<String, Object>(4) {{
            put("Xperson", xperson);
            put("Identifier", identifier);
        }};

        EcifBody ecifBody = EcifBody.builder().appHeader(appHeader).appBody(appBody).build();

        return (JSONObject) JSONObject.toJSON(ecifBody);
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankAddPersonReqDTO,OneBankAddPersonRespDTO>  fetureContext, byte[] respBody) {
        OneBankAddPersonRespDTO respDTO = JSON.parseObject(respBody, OneBankAddPersonRespDTO.class);
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
