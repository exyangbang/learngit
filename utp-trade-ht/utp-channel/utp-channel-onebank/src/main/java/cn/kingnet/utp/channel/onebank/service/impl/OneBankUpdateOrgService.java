package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankUpdateOrgReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankUpdateOrgRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.ecif.*;
import cn.kingnet.utp.trade.common.enums.HTAddressType;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 更新企业客户信息
 * @Author : WJH
 */
@Component("updateOrg")
@ServiceContext(bodyClass = OneBankUpdateOrgReqDTO.class)
@Slf4j
public class OneBankUpdateOrgService extends AbstractEcifOnebankPaymentService<OneBankUpdateOrgReqDTO, OneBankUpdateOrgRespDTO> {

    private static final String PROPERTIES_KEY = "updateOrg";
    private static final String API_NAME = UnionPaySubTypeEnum.UPDATE_ORG.getDesc();

    public OneBankUpdateOrgService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }


    @Override
    public Map<String, Object> buildContent(FetureContext<OneBankUpdateOrgReqDTO, OneBankUpdateOrgRespDTO> fetureContext) {
        OneBankUpdateOrgReqDTO reqDTO = fetureContext.getSpReq();

        if (StringUtil.isNotEmpty(reqDTO.getBusLicCode())) {
            ValidateUtils.validBicCode(reqDTO.getBusLicCode());
        }

        Assert.hasText(reqDTO.getClientId(), () -> "参数[clientId]不能为空");
        QueryHeader queryHeader = QueryHeader.builder().ClientId(reqDTO.getClientId()).IdTpCd(reqDTO.getIdType()).IdNum(reqDTO.getBusLicCode()).build();
        AppHeader appHeader = AppHeader.builder().queryHeader(queryHeader).build();

        Xorg.XorgBuilder xorgBuilder = Xorg.builder().clientId(reqDTO.getClientId());
        if (StringUtil.isNotBlank(reqDTO.getIdIndate()) && StringUtil.isNotBlank(reqDTO.getBusinessStartdate())) {
            Identifier identifier = new Identifier(reqDTO.getIdType(), reqDTO.getBusLicCode(), reqDTO.getBusinessStartdate(), reqDTO.getIdIndate());
            xorgBuilder.identifier(new Identifier[]{identifier});
        }
        //因联系地址改为必输，注册地址和联系地址必须均存在。
        List<Address> addressList = new ArrayList<>();
        if (StringUtil.isNotBlank(reqDTO.getAddress())) {
            Address regAddress = new Address(reqDTO.getAddress(), HTAddressType.REGISTER.getCode(), reqDTO.getRegProvince(), reqDTO.getRegCity(), reqDTO.getRegArea());
            addressList.add(regAddress);
        }
        if (StringUtil.isNotBlank(reqDTO.getContactAddress())) {
            Address contactAddress = new Address(reqDTO.getContactAddress(), HTAddressType.CONTACT.getCode(), reqDTO.getContactProvince(), reqDTO.getContactCity(), reqDTO.getContactArea());
            addressList.add(contactAddress);
        }
        if (addressList != null && addressList.size() > 0) {
            xorgBuilder.address(addressList.toArray(new Address[addressList.size()]));
        }

        if (StringUtil.isNotBlank(reqDTO.getRegisterAmt())) {
            RegisterCapital registerCapital = new RegisterCapital(reqDTO.getRegisterAmt());
            xorgBuilder.registerCapital(new RegisterCapital[]{registerCapital});
        }
        List<RelatedPerson> relatedPersonList = new ArrayList(8);
        if (!StringUtil.isAnyBlank(reqDTO.getLegalIdCode(), reqDTO.getLegalIdType(), reqDTO.getLegalIdindate(), reqDTO.getLegalStartdate(), reqDTO.getLegalName())) {
            RelatedPerson legal = RelatedPerson.builder().relTpCd("1213")
                    .idTpCd(reqDTO.getLegalIdType()).idNum(reqDTO.getLegalIdCode())
                    .chineseName(reqDTO.getLegalName()).startDt(reqDTO.getLegalStartdate()).expiryDt(reqDTO.getLegalIdindate())
                    .build();
            relatedPersonList.add(legal);
        }
        if(!StringUtil.isAnyBlank(reqDTO.getActualMasterIdCode(), reqDTO.getActualMasterIdType(), reqDTO.getActualMasterName(), reqDTO.getActualMasterIdStartDate(), reqDTO.getActualMasterIdindate()))
        {
            RelatedPerson actualMaster = RelatedPerson.builder().relTpCd("1223")
                    .idTpCd(reqDTO.getActualMasterIdType()).idNum(reqDTO.getActualMasterIdCode())
                    .chineseName(reqDTO.getActualMasterName()).startDt(reqDTO.getActualMasterIdStartDate()).expiryDt(reqDTO.getActualMasterIdindate())
                    .build();
            relatedPersonList.add(actualMaster);
        }
        if (!StringUtil.isAnyBlank(reqDTO.getAuthProxyIdType(), reqDTO.getAuthProxyIdCode(), reqDTO.getAuthProxyName(), reqDTO.getAuthProxyIdStartDate(), reqDTO.getAuthProxyIdindate())) {
            RelatedPerson authProxy = RelatedPerson.builder().relTpCd("2234")
                    .idTpCd(reqDTO.getAuthProxyIdType()).idNum(reqDTO.getAuthProxyIdCode())
                    .chineseName(reqDTO.getAuthProxyName()).startDt(reqDTO.getAuthProxyIdStartDate()).expiryDt(reqDTO.getAuthProxyIdindate())
                    .build();
            relatedPersonList.add(authProxy);
        }
        //受益人1,2,3,4 代码值2251/2252/2253/2254
        if (!StringUtil.isAnyBlank(reqDTO.getOwnerOneName(), reqDTO.getOwnerOneCerfileType(), reqDTO.getOwnerOneCerfileNo(), reqDTO.getOwnerOneStartdate(), reqDTO.getOwnerOneIndate())) {
            RelatedPerson ownerOne = RelatedPerson.builder().relTpCd("2251")
                    .idTpCd(reqDTO.getOwnerOneCerfileType()).idNum(reqDTO.getOwnerOneCerfileNo())
                    .chineseName(reqDTO.getOwnerOneName()).startDt(reqDTO.getOwnerOneStartdate()).expiryDt(reqDTO.getOwnerOneIndate())
                    .build();
            relatedPersonList.add(ownerOne);
        }
        if (!StringUtil.isAnyBlank(reqDTO.getOwnerTwoName(), reqDTO.getOwnerTwoCerfileType(), reqDTO.getOwnerTwoCerfileNo(), reqDTO.getOwnerTwoStartdate(), reqDTO.getOwnerTwoIndate())) {
            RelatedPerson ownerTwo = RelatedPerson.builder().relTpCd("2252")
                    .idTpCd(reqDTO.getOwnerTwoCerfileType()).idNum(reqDTO.getOwnerTwoCerfileNo())
                    .chineseName(reqDTO.getOwnerTwoName()).startDt(reqDTO.getOwnerTwoStartdate()).expiryDt(reqDTO.getOwnerTwoIndate())
                    .build();
            relatedPersonList.add(ownerTwo);
        }
        if (!StringUtil.isAnyBlank(reqDTO.getOwnerThreeName(), reqDTO.getOwnerThreeCerfileType(), reqDTO.getOwnerThreeCerfileNo(), reqDTO.getOwnerThreeStartdate(), reqDTO.getOwnerThreeIndate())) {
            RelatedPerson ownerThree = RelatedPerson.builder().relTpCd("2253")
                    .idTpCd(reqDTO.getOwnerThreeCerfileType()).idNum(reqDTO.getOwnerThreeCerfileNo())
                    .chineseName(reqDTO.getOwnerThreeName()).startDt(reqDTO.getOwnerThreeStartdate()).expiryDt(reqDTO.getOwnerThreeIndate())
                    .build();
            relatedPersonList.add(ownerThree);
        }
        if (!StringUtil.isAnyBlank(reqDTO.getOwnerFourName(), reqDTO.getOwnerFourCerfileType(), reqDTO.getOwnerFourCerfileNo(), reqDTO.getOwnerFourStartdate(), reqDTO.getOwnerFourIndate())) {
            RelatedPerson ownerFour = RelatedPerson.builder().relTpCd("2254")
                    .idTpCd(reqDTO.getOwnerFourCerfileType()).idNum(reqDTO.getOwnerFourCerfileNo())
                    .chineseName(reqDTO.getOwnerFourName()).startDt(reqDTO.getOwnerFourStartdate()).expiryDt(reqDTO.getOwnerFourIndate())
                    .build();
            relatedPersonList.add(ownerFour);
        }
        if (!CollectionUtils.isEmpty(relatedPersonList)) {
            xorgBuilder.relatedPerson(relatedPersonList.toArray(new RelatedPerson[0]));
        }

        //        utp本地限制3000字符但传入ecif经营范围限制500字符
        String businessScopeLimit = reqDTO.getBusinessScope() != null ? StringUtil.truncate(reqDTO.getBusinessScope(), 500) : null;

        Xorg xorg = xorgBuilder.clientName(reqDTO.getEntName()).rgstCountryTpCd(reqDTO.getCountryTpCd())
                .industryTpCd(reqDTO.getIndustryTpCd()).businessScope(businessScopeLimit)
                .residentTpCd(reqDTO.getResidentTpCd()).customerManager(reqDTO.getCustomerManager())
                .orgTpCd(reqDTO.getOrgTpCd()).spdbScaleTpCd(reqDTO.getSpdbScaleTpCd())
                .economicTpCd(reqDTO.getEconomicTpCd())
                .listedTpCd(reqDTO.getListedTpCd())
                .createTms(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).build();

        Map<String, Object> appBody = new HashMap<String, Object>(4) {{
            put("Xorg", xorg);
        }};

        EcifBody ecifBody = EcifBody.builder().appHeader(appHeader).appBody(appBody).build();

        return (JSONObject) JSONObject.toJSON(ecifBody);
    }


    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankUpdateOrgReqDTO, OneBankUpdateOrgRespDTO> fetureContext, byte[] respBody) {
        OneBankUpdateOrgRespDTO respDTO = JSON.parseObject(respBody, OneBankUpdateOrgRespDTO.class);
        if (respDTO != null && respDTO.getAppBody() != null) {
            Xorg xorg = respDTO.getAppBody().getXorg();
            return new HashMap<String, Object>(2) {{
                put("data", xorg);
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
