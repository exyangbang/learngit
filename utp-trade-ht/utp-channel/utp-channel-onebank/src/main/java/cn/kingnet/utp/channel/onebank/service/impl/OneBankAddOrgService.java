package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAddOrgReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAddOrgRespDTO;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description : 建立企业客户信息
 * @Author : WJH
 */
@Component("addOrg")
@ServiceContext(bodyClass = OneBankAddOrgReqDTO.class)
@Slf4j
public class OneBankAddOrgService extends AbstractEcifOnebankPaymentService<OneBankAddOrgReqDTO, OneBankAddOrgRespDTO> {

    private static final String PROPERTIES_KEY = "addOrg";
    private static final String API_NAME = UnionPaySubTypeEnum.ADD_ORG.getDesc();

    public OneBankAddOrgService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }


    @Override
    public Map<String, Object> buildContent(FetureContext<OneBankAddOrgReqDTO, OneBankAddOrgRespDTO> fetureContext) {
        OneBankAddOrgReqDTO reqDTO = fetureContext.getSpReq();

        Assert.hasText(reqDTO.getIdType(), () -> "请求参数[idType:企业证件类型]不能为空");
        Assert.hasText(reqDTO.getEnt_name(), () -> "请求参数[ent_name:企业名称]不能为空");
        Assert.hasText(reqDTO.getBusLicCode(), () -> "请求参数[busLicCode:营业执照号]不能为空");
        Assert.hasText(reqDTO.getTelephone(), () -> "请求参数[telephone:联系人电话]不能为空");
        Assert.hasText(reqDTO.getLegalMobile(), () -> "请求参数[legalMobile:法人联系电话]不能为空");
        Assert.hasText(reqDTO.getAddress(), () -> "请求参数[address:注册地址]不能为空");

        Assert.hasText(reqDTO.getIdIndate(), () -> "请求参数[idIndate:营业执照有效期]不能为空");
        Assert.hasText(reqDTO.getRegisterAmt(), () -> "请求参数[registerAmt:注册资金]不能为空");
        Assert.hasText(reqDTO.getBusinessScope(), () -> "请求参数[businessScope:营业范围]不能为空");
        Assert.hasText(reqDTO.getLegalIdType(), () -> "请求参数[legalIdType:法人证件类型]不能为空");
        Assert.hasText(reqDTO.getCountryTpCd(), () -> "请求参数[countryTpCd:国籍]不能为空");

        Assert.hasText(reqDTO.getLegalIdCode(), () -> "请求参数[legalIdCode:法人证件号]不能为空");
        Assert.hasText(reqDTO.getLegalName(), () -> "请求参数[legalName:法人姓名]不能为空");
        Assert.hasText(reqDTO.getLegalIdindate(), () -> "请求参数[legalIdindate:法人证件有效期]不能为空");
        Assert.hasText(reqDTO.getLegalMobile(), () -> "请求参数[legalMobile:法人手机号码]不能为空");
        Assert.hasText(reqDTO.getIndustryTpCd(), () -> "请求参数[industryTpCd:行业类型]不能为空");

        Assert.hasText(reqDTO.getCustomerManager(), () -> "请求参数[customerManager:所属客户经理]不能为空");
        Assert.hasText(reqDTO.getOrgTpCd(), () -> "请求参数[orgTpCd:企业类型]不能为空");
        Assert.hasText(reqDTO.getSpdbScaleTpCd(), () -> "请求参数[spdbScaleTpCd:企业规模(行内)]不能为空");
        Assert.hasText(reqDTO.getEconomicTpCd(), () -> "请求参数[economicTpCd:企业经营性质]不能为空");
        Assert.hasText(reqDTO.getResidentTpCd(), () -> "请求参数[residentTpCd:居民类型]不能为空");

        ValidateUtils.validBicCode(reqDTO.getBusLicCode());

        QueryHeader queryHeader = QueryHeader.builder().IdTpCd(reqDTO.getIdType()).IdNum(reqDTO.getBusLicCode()).build();
        AppHeader appHeader = AppHeader.builder().queryHeader(queryHeader).build();

        //企业证件类型、营业执照、营业执照有效期
        Identifier identifier = new Identifier(reqDTO.getIdType(), reqDTO.getBusLicCode(), reqDTO.getBusinessStartdate(), reqDTO.getIdIndate());
        List<Address> addressList = new ArrayList<>();
        //注册地址：详细地址 必填项故无需判断
        Address regAddress = new Address(reqDTO.getAddress(), HTAddressType.REGISTER.getCode(), reqDTO.getRegProvince(), reqDTO.getRegCity(), reqDTO.getRegArea());
        addressList.add(regAddress);
        if (StringUtil.isNotBlank(reqDTO.getContactAddress())) {
            //注册地址：联系地址
            Address contactAddress = new Address(reqDTO.getContactAddress(), HTAddressType.CONTACT.getCode(), reqDTO.getContactProvince(), reqDTO.getContactCity(), reqDTO.getContactArea());
            addressList.add(contactAddress);
        }
        Address[] addresses = null;
        if (addressList != null && addressList.size() > 0) {
            addresses = addressList.toArray(new Address[addressList.size()]);
        }

        //客户联系信息：手机号码
        ContactMethod contactMethod = instanceContactMethodByTelphone(reqDTO.getTelephone());

        //客户关联人信息的法人信息：法人姓名、法人证件类型、法人身份证号码、法人身份证有效期、法人联系电话
        List<RelatedPerson> relatedPersonList = new ArrayList(8);
        RelatedPerson legal = RelatedPerson.builder().relTpCd("1213")
                .idTpCd(reqDTO.getLegalIdType()).idNum(reqDTO.getLegalIdCode())
                .chineseName(reqDTO.getLegalName()).startDt(reqDTO.getLegalStartdate()).expiryDt(reqDTO.getLegalIdindate()).mobile(reqDTO.getLegalMobile())
                .build();
        relatedPersonList.add(legal);

        if (!StringUtil.isAnyBlank(reqDTO.getActualMasterIdCode(), reqDTO.getActualMasterIdType(), reqDTO.getActualMasterName(), reqDTO.getActualMasterIdStartDate(), reqDTO.getActualMasterIdindate())) {
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

        //注册资本
        RegisterCapital[] registerCapitals = null;
        if (StringUtil.isNotBlank(reqDTO.getRegisterAmt())) {
            RegisterCapital registerCapital = new RegisterCapital(reqDTO.getRegisterAmt());
            registerCapitals = new RegisterCapital[]{registerCapital};
        }

//        企业名称、营业执照号码、手机号码、注册地址、注册资本、经营范围、法人姓名、法人证件类型、法人身份证号码、
//        法人身份证有效期、客户经理、企业类型、企业规模、企业经济性质、居民类型、国籍、行业、营业执照有效期
//        utp本地限制3000字符但传入ecif经营范围限制500字符
        String businessScopeLimit = reqDTO.getBusinessScope() != null ? StringUtil.truncate(reqDTO.getBusinessScope(), 500) : null;

        Xorg xorg = Xorg.builder().clientName(reqDTO.getEnt_name()).rgstCountryTpCd(reqDTO.getCountryTpCd())
                .industryTpCd(reqDTO.getIndustryTpCd()).businessScope(businessScopeLimit)
                .identifier(null).contactMethod(new ContactMethod[]{contactMethod}).address(addresses)
                .relatedPerson(relatedPersonList.toArray(new RelatedPerson[0])).registerCapital(registerCapitals)
                .customerManager(reqDTO.getCustomerManager()).orgTpCd(reqDTO.getOrgTpCd())
                .spdbScaleTpCd(reqDTO.getSpdbScaleTpCd()).economicTpCd(reqDTO.getEconomicTpCd())
                .listedTpCd(reqDTO.getListedTpCd()).residentTpCd(reqDTO.getResidentTpCd())
                .createTms(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).build();

        Map<String, Object> appBody = new HashMap<String, Object>(4) {{
            put("Xorg", xorg);
            put("Identifier", identifier);
        }};

        EcifBody ecifBody = EcifBody.builder().appHeader(appHeader).appBody(appBody).build();

        return (JSONObject) JSONObject.toJSON(ecifBody);
    }

    @Override
    protected Map<String, Object> parseRespBody(FetureContext<OneBankAddOrgReqDTO, OneBankAddOrgRespDTO> fetureContext, byte[] respBody) {
        OneBankAddOrgRespDTO respDTO = JSON.parseObject(respBody, OneBankAddOrgRespDTO.class);
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
