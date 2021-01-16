package cn.kingnet.product.account.service.inner.manage;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.dto.manage.AccountInfoDTO;
import cn.kingnet.utp.product.common.dto.manage.BankClientAccountInfoDTO;
import cn.kingnet.utp.product.common.tools.SHA1;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IPersonOrOrgHotspotHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.bo.BankClientAccountBO;
import cn.kingnet.utp.service.persistence.entity.bo.PersonOrgInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.*;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.IdType;
import cn.kingnet.utp.trade.common.enums.UserType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description : 个人/企业的客户热点信息关联服务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/11/05 10:00
 */
@Service
@Slf4j
public class PersonOrOrgHotspotService {

    private ProductAccountProperties productAccountProperties;
    private IPersonOrOrgHotspotHandler personOrOrgInfoHandler;
    private IPaymentService paymentService;

    @Resource
    private IAccountHandler accountHandler;

    public PersonOrOrgHotspotService(ProductAccountProperties productAccountProperties, IPersonOrOrgHotspotHandler personOrOrgInfoHandler, IPaymentService paymentService) {
        this.productAccountProperties = productAccountProperties;
        this.personOrOrgInfoHandler = personOrOrgInfoHandler;
        this.paymentService = paymentService;
    }

    public ServerResponseDTO addPersonOrOrgHotspot(AccountInfoDTO accountInfoDTO, int operation) {
        if (accountInfoDTO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数[accountInfoDTO]不能为空");
        }
        if (StringUtil.isBlank(accountInfoDTO.getId())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数[id]不能为空");
        }
        if (StringUtil.isBlank(accountInfoDTO.getAccount())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数[account]不能为空");
        }
        if (StringUtil.isBlank(accountInfoDTO.getType())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数[type]不能为空");
        }
        if (StringUtil.isBlank(accountInfoDTO.getCode())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数[code]不能为空");
        }
        if (StringUtil.isBlank(accountInfoDTO.getName())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数[name]不能为空");
        }
        if (StringUtil.isBlank(accountInfoDTO.getFundAccount())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "请求参数[fundAccount]不能为空");
        }

        //operation 1后管接口调用，需要验签  2属于系统内部定时任务调用，不需要验签
        if (operation == 1) {
            if (!SHA1.genWithAmple(accountInfoDTO.toSHA1()).equals(accountInfoDTO.getSign())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
            }
        }

        ServerResponseDTO serverResponseDTO;
        try {
            //获取个人、企业相关信息
            PersonOrgInfoBo personOrgInfoBo = personOrOrgInfoHandler.getPersonOrOrgInfo(accountInfoDTO.getId(), accountInfoDTO.getAccount(),
                    accountInfoDTO.getType(), accountInfoDTO.getCode(), accountInfoDTO.getName(), accountInfoDTO.getFundAccount());

            if (personOrgInfoBo == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "获取个人、企业相关信息异常");
            }

            if (StringUtil.isBlank(personOrgInfoBo.getAddress())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "详细地址不能为空");
            }

            //查询(本地|银行)是否已建立关联
            BankClientAccountBO bankClientAccountBO = getPersonOrgHotspotByBank(personOrgInfoBo);
            if (bankClientAccountBO != null && StringUtil.isNotBlank(bankClientAccountBO.getBankClientNo())) {
                //银行客户号 更新到虚拟账户表
                boolean isSelfChannelFlag = bankClientAccountBO.getBankClientChnFlag().intValue() == 0;
                personOrOrgInfoHandler.saveBankClientNo(accountInfoDTO.getAccount(), bankClientAccountBO.getBankClientNo(), isSelfChannelFlag);
            } else {
                //需要请求渠道进行建立关联
                addPersonOrgInfo(personOrgInfoBo, accountInfoDTO.getAccount());
            }
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.OK.toString(), "信息关联成功");
        } catch (Exception e) {
            log.error("信息关联异常：{}", e.getMessage(), e);
            throw new ProductException(HttpRespStatus.SERVER_ERROR, String.format("信息关联失败:%s", e.getMessage()));
        }
        return serverResponseDTO;
    }

    /**
     * 请求渠道获取银行客户号
     *
     * @param personOrgInfoBo
     * @return
     */
    private BankClientAccountBO getPersonOrgHotspotByBank(PersonOrgInfoBo personOrgInfoBo) {
        BankClientAccountBO bo = getPersonOrgHotspotByLocal(personOrgInfoBo);
        if (StringUtil.isNotBlank(bo.getBankClientNo())) {
            return bo;
        }
        String clientTradeId = String.valueOf(IdGenerate.getId());
        String reqDate = DateUtil.getToday();
        String reqTime = DateUtil.getCurrentTime();
        ChannelResponseDTO channelResponseDTO = null;

        //调用渠道查询个人、企业客户热点信息是否关联
        if (personOrgInfoBo.getType().equals(UserType.ONE.getType())) {
            OneBankGetPersonHotspotReqDTO oneBankGetPersonHotspotReqDTO = OneBankGetPersonHotspotReqDTO.builder()
                    .clientTradeId(clientTradeId)
                    .reqDate(reqDate)
                    .reqTime(reqTime)
                    .idCode(personOrgInfoBo.getCode())
                    .idType(personOrgInfoBo.getIdType())
                    .build();
            LambdaLogger.info(log, l -> l.info("[查询个人客户热点信息]-请求报文：{}", JSON.toJSONString(oneBankGetPersonHotspotReqDTO)));
            channelResponseDTO = paymentService.getPersonHotspot(oneBankGetPersonHotspotReqDTO);
        } else {
            OneBankGetOrgHotspotReqDTO oneBankGetOrgHotspotReqDTO = OneBankGetOrgHotspotReqDTO.builder()
                    .clientTradeId(clientTradeId)
                    .reqDate(reqDate)
                    .reqTime(reqTime)
                    .busLicCode(personOrgInfoBo.getCode())
                    .build();
            LambdaLogger.info(log, l -> l.info("[查询企业客户热点信息]-请求报文：{}", JSON.toJSONString(oneBankGetOrgHotspotReqDTO)));
            channelResponseDTO = paymentService.getOrgHotspot(oneBankGetOrgHotspotReqDTO);
        }
        String bankClientNo = getClientId(channelResponseDTO, 1);
        // 非自有的其他渠道
        bo.setBankClientChnFlag(1);
        bo.setBankClientNo(bankClientNo);
        return bo;
    }

    private BankClientAccountBO getPersonOrgHotspotByLocal(PersonOrgInfoBo personOrgInfoBo) {
        BankClientAccountBO bankClientAccountBO = new BankClientAccountBO();
        List<BankClientAccountBO> list = personOrOrgInfoHandler.selectBankClientAccount(personOrgInfoBo);
        if (!CollectionUtils.isEmpty(list)) {
            bankClientAccountBO = list.stream().filter(bo -> StringUtil.isNotBlank(bo.getBankClientNo())).findFirst().orElse(bankClientAccountBO);
        }
        return bankClientAccountBO;
    }

    /**
     * 请求渠道建立个人、企业信息关联
     *
     * @param personOrgInfoBo
     * @param account
     */
    private void addPersonOrgInfo(PersonOrgInfoBo personOrgInfoBo, String account) {
        String clientTradeId = String.valueOf(IdGenerate.getId());
        String reqDate = DateUtil.getToday();
        String reqTime = DateUtil.getCurrentTime();
        String bankClientNo = null;
        ChannelResponseDTO channelResponseDTO = null;

        if (personOrgInfoBo.getType().equals(UserType.ONE.getType())) {
            Assert.isTrue("M".equals(personOrgInfoBo.getGenderTpCd()) || "F".equals(personOrgInfoBo.getGenderTpCd()), "个人用户 性别不能为空");
            Assert.isTrue(IdType.getEnum(personOrgInfoBo.getIdType()) != null, () -> String.format("个人证件类型[%s]有误.", personOrgInfoBo.getIdType()));

            OneBankAddPersonReqDTO oneBankAddPersonReqDTO = OneBankAddPersonReqDTO.builder()
                    .clientTradeId(clientTradeId)
                    .reqDate(reqDate)
                    .reqTime(reqTime)
                    .idType(personOrgInfoBo.getIdType())
                    .idCode(personOrgInfoBo.getCode())
                    .idIndate(personOrgInfoBo.getIdIndate())
                    .realName(personOrgInfoBo.getRealName())
                    .telephone(personOrgInfoBo.getTelephone())
                    .birthDt(personOrgInfoBo.getBirthDt())
                    .countryTpCd(personOrgInfoBo.getCountryTpCd())
                    .genderTpCd(personOrgInfoBo.getGenderTpCd())
                    .occupationTpCd(personOrgInfoBo.getOccupationTpCd())
                    .address(personOrgInfoBo.getAddress())
                    .cdResidentTp(personOrgInfoBo.getResidentType())
                    .build();
            LambdaLogger.info(log, l -> l.info("[建立个人客户热点信息]-请求报文：{}", JSON.toJSONString(oneBankAddPersonReqDTO)));
            channelResponseDTO = paymentService.addPerson(oneBankAddPersonReqDTO);
        } else {
            /**
             * 企业名称、营业执照号码、手机号码、注册地址、注册资本、经营范围、法人姓名、法人证件类型、法人身份证号码、
             * 法人身份证有效期、客户经理、企业类型、企业规模、企业经济性质、居民类型、国籍、行业、营业执照有效期
             * 联系地址，营业执照生效日期，法人证件生效日期，实际控制人证件生效日期，授权代理人证件生效日期
             * 四个受益所有人相关信息,省市区码值
             */
            OneBankAddOrgReqDTO oneBankAddOrgReqDTO = OneBankAddOrgReqDTO.builder()
                    .clientTradeId(clientTradeId)
                    .reqDate(reqDate)
                    .reqTime(reqTime)
                    .idType(IdType.ID218.getCode())
                    .ent_name(personOrgInfoBo.getRealName())
                    .busLicCode(personOrgInfoBo.getCode())
                    .telephone(personOrgInfoBo.getTelephone())
                    .address(personOrgInfoBo.getAddress())
                    .registerAmt(personOrgInfoBo.getRegisterAmt())
                    .businessScope(personOrgInfoBo.getBusinessScope())
                    .legalIdType(personOrgInfoBo.getLegalIdType())
                    .legalIdCode(personOrgInfoBo.getLegalIdCode())
                    .legalName(personOrgInfoBo.getLegalName())
                    .legalIdindate(personOrgInfoBo.getLegalIdindate())
                    .legalMobile(personOrgInfoBo.getTelephone())
                    .idIndate(personOrgInfoBo.getIdIndate())
                    .countryTpCd(personOrgInfoBo.getCountryTpCd())
                    .industryTpCd(personOrgInfoBo.getIndustryTpCd())
                    .customerManager(personOrgInfoBo.getCustomerManager())
                    .orgTpCd(personOrgInfoBo.getOrgTpCd())
                    .spdbScaleTpCd(personOrgInfoBo.getSpdbScaleTpCd())
                    .economicTpCd(personOrgInfoBo.getEconomicTpCd())
                    .residentTpCd(personOrgInfoBo.getResidentType())
                    .listedTpCd(personOrgInfoBo.getListedTpCd())

                    .contactAddress(personOrgInfoBo.getContactAddress())
                    .businessStartdate(personOrgInfoBo.getBusinessStartdate())
                    .legalStartdate(personOrgInfoBo.getLegalStartdate())
                    .actualMasterIdStartDate(personOrgInfoBo.getActualMasterIdStartDate())
                    .authProxyIdStartDate(personOrgInfoBo.getAuthProxyIdStartDate())
                    .ownerOneName(personOrgInfoBo.getOwnerOneName())
                    .ownerOneCerfileType(personOrgInfoBo.getOwnerOneCerfileType())
                    .ownerOneCerfileNo(personOrgInfoBo.getOwnerOneCerfileNo())
                    .ownerOneStartdate(personOrgInfoBo.getOwnerOneStartdate())
                    .ownerOneIndate(personOrgInfoBo.getOwnerOneIndate())
                    .ownerTwoName(personOrgInfoBo.getOwnerTwoName())
                    .ownerTwoCerfileType(personOrgInfoBo.getOwnerTwoCerfileType())
                    .ownerTwoCerfileNo(personOrgInfoBo.getOwnerTwoCerfileNo())
                    .ownerTwoStartdate(personOrgInfoBo.getOwnerTwoStartdate())
                    .ownerTwoIndate(personOrgInfoBo.getOwnerTwoIndate())
                    .ownerThreeName(personOrgInfoBo.getOwnerThreeName())
                    .ownerThreeCerfileType(personOrgInfoBo.getOwnerThreeCerfileType())
                    .ownerThreeCerfileNo(personOrgInfoBo.getOwnerThreeCerfileNo())
                    .ownerThreeStartdate(personOrgInfoBo.getOwnerThreeStartdate())
                    .ownerThreeIndate(personOrgInfoBo.getOwnerThreeIndate())
                    .ownerFourName(personOrgInfoBo.getOwnerFourName())
                    .ownerFourCerfileType(personOrgInfoBo.getOwnerFourCerfileType())
                    .ownerFourCerfileNo(personOrgInfoBo.getOwnerFourCerfileNo())
                    .ownerFourStartdate(personOrgInfoBo.getOwnerFourStartdate())
                    .ownerFourIndate(personOrgInfoBo.getOwnerFourIndate())
                    .contactProvince(personOrgInfoBo.getContactProvince())
                    .contactCity(personOrgInfoBo.getContactCity())
                    .contactArea(personOrgInfoBo.getContactArea())
                    .regProvince(personOrgInfoBo.getRegProvince())
                    .regCity(personOrgInfoBo.getRegCity())
                    .regArea(personOrgInfoBo.getRegArea())
                    .build();

            LambdaLogger.info(log, l -> l.info("[建立企业客户热点信息]-请求报文：{}", JSON.toJSONString(oneBankAddOrgReqDTO)));
            channelResponseDTO = paymentService.addOrg(oneBankAddOrgReqDTO);
        }

        bankClientNo = getClientId(channelResponseDTO, 2);

        //返回的自有渠道创建的银行客户号保存到虚拟账户表
        if (StringUtil.isNotEmpty(bankClientNo)) {
            //通过银行查询返回的 银行客户号都视为 非自有渠道创建
            personOrOrgInfoHandler.saveBankClientNo(account, bankClientNo, true);
        }
    }

    /**
     * 获取渠道返回的银行客户号
     *
     * @param channelResponseDTO
     * @param type               1请求渠道获取银行客户号  2请求渠道建立个人、企业信息关联
     * @return
     */
    private String getClientId(ChannelResponseDTO channelResponseDTO, int type) {
        if (channelResponseDTO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "渠道返回参数[channelResponseDTO]为空");
        }

        //请求成功
        if (channelResponseDTO.getStatus().equals(HttpRespStatus.OK.valueStr())) {
            LambdaLogger.info(log, l -> l.info(String.format("[%s]-渠道返回报文：{}", type == 1 ? "请求获取银行客户号" : "请求建立个人、企业信息关联"), JSON.toJSONString(channelResponseDTO)));
            Map<String, Object> spRespMsg = channelResponseDTO.getSpRespMsg();
            if (spRespMsg == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "渠道返回参数[spRespMsg]为空");
            }

            if (spRespMsg.get("data") != null) {
                Map<String, Object> dataMap = (Map<String, Object>) spRespMsg.get("data");
                if (dataMap.get("clientId") != null) {
                    return String.valueOf(dataMap.get("clientId"));
                }
            }
        } else {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, channelResponseDTO.getMessage());
        }
        return null;
    }

    public ServerResponseDTO updatePersonOrOrgHotspot(BankClientAccountInfoDTO bankClientAccountInfoDTO, int operation) {
        Assert.notNull(bankClientAccountInfoDTO, () -> "请求参数[bankClientAccountInfoDTO]不能为空");
        Assert.hasText(bankClientAccountInfoDTO.getClientTransId(), () -> "请求参数[clientTransId]不能为空");
        Assert.hasText(bankClientAccountInfoDTO.getAccountId(), () -> "请求参数[accountId]不能为空");
        Assert.hasText(bankClientAccountInfoDTO.getAccount(), () -> "请求参数[account]不能为空");
        Assert.hasText(bankClientAccountInfoDTO.getUserType(), () -> "请求参数[userType]不能为空");
        Assert.hasText(bankClientAccountInfoDTO.getBankClientNo(), () -> "请求参数[bankClientNo]不能为空");
        Assert.hasText(bankClientAccountInfoDTO.getReqDate(), () -> "请求参数[reqDate]不能为空");
        Assert.hasText(bankClientAccountInfoDTO.getReqTime(), () -> "请求参数[reqTime]不能为空");
        switch (bankClientAccountInfoDTO.getUserType()) {
            case "0": {
                Assert.notNull(bankClientAccountInfoDTO.getPersonAccount(), () -> "请求参数[personAccount]不能为空");
                break;
            }
            case "1": {
                Assert.notNull(bankClientAccountInfoDTO.getOrganizationAccount(), () -> "请求参数[OrganizationAccount]不能为空");
                break;
            }
            default: {
                throw new RuntimeException("请求参数[userType]不合法");
            }
        }

        //operation 1后管接口调用，需要验签  2属于系统内部定时任务调用，不需要验签
        if (operation == 1) {
            if (!SHA1.genWithAmple(bankClientAccountInfoDTO.toSHA1()).equals(bankClientAccountInfoDTO.getSign())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "签名信息校验失败");
            }
        }

        ServerResponseDTO serverResponseDTO;
        try {
            //库表参数校验
            Account account = accountHandler.getAccount(bankClientAccountInfoDTO.getAccountId());
            Assert.notNull(account, () -> "查无此AccountId账户信息");
            Assert.isTrue(account.getBankClientStatus() != 0, () -> "该账户为开户未上报，请先上报后再试");
            Assert.isTrue(bankClientAccountInfoDTO.getAccount().equals(account.getAccount()), () -> "请求参数account与库表不匹配");
            Assert.isTrue(bankClientAccountInfoDTO.getBankClientNo().equals(account.getBankClientNo()), () -> "请求参数bankClientNo与库表不匹配");
            Assert.isTrue(account.getBankClientChnFlag() == 0, () -> "非自有渠道开户的银行客户号信息不能同步到ecif");
            serverResponseDTO = syncUpdateLocalAccount2Ecif(bankClientAccountInfoDTO);
        } catch (Exception e) {
            log.error("信息关联异常：{}", e.getMessage(), e);
            throw new ProductException(HttpRespStatus.SERVER_ERROR, String.format("信息关联失败:%s", e.getMessage()));
        }
        return serverResponseDTO;
    }

    private ServerResponseDTO syncUpdateLocalAccount2Ecif(BankClientAccountInfoDTO reqDTO) {
        ServerResponseDTO serverResponseDTO;
        try {
            ChannelResponseDTO channelResponseDTO;
            //FIXME ecif信息修改依赖后管上送，若后续不足则需要接口新增字段后管上送
            //个人同步
            if ("0".equals(reqDTO.getUserType())) {
                BankClientAccountInfoDTO.PersonAccount personAccount = reqDTO.getPersonAccount();
                OneBankUpdatePersonReqDTO onebankReqDTO = new OneBankUpdatePersonReqDTO();
                BeanUtils.copyProperties(personAccount, onebankReqDTO);

                onebankReqDTO.setClientId(reqDTO.getBankClientNo());
                onebankReqDTO.setClientTradeId(reqDTO.getClientTransId());
                onebankReqDTO.setReqDate(reqDTO.getReqDate());
                onebankReqDTO.setReqTime(reqDTO.getReqTime());
                channelResponseDTO = paymentService.updatePerson(onebankReqDTO);
            } else {
                //企业同步
                BankClientAccountInfoDTO.OrganizationAccount orgAccount = reqDTO.getOrganizationAccount();
                OneBankUpdateOrgReqDTO onebankReqDTO = new OneBankUpdateOrgReqDTO();
                BeanUtils.copyProperties(orgAccount, onebankReqDTO);

                //企业只能用社会统一信用代码
                onebankReqDTO.setIdType(IdType.ID218.getCode());
                onebankReqDTO.setClientId(reqDTO.getBankClientNo());
                onebankReqDTO.setClientTradeId(reqDTO.getClientTransId());
                onebankReqDTO.setReqDate(reqDTO.getReqDate());
                onebankReqDTO.setReqTime(reqDTO.getReqTime());
                //FIXME 原后管OwnershipTpCd存储的值是EconomicTpCd,这期版本字段暂转换使用，后期配合后管修正
                onebankReqDTO.setEconomicTpCd(orgAccount.getOwnershipTpCd());

                channelResponseDTO = paymentService.updateOrg(onebankReqDTO);
            }
            if (channelResponseDTO == null) {
                serverResponseDTO = new ServerResponseDTO(HttpRespStatus.SERVER_ERROR.valueStr(), "渠道响应内容为空");
            } else {
                serverResponseDTO = new ServerResponseDTO(channelResponseDTO.getStatus(), channelResponseDTO.getMessage(), channelResponseDTO.getSpRespMsg());
            }
        } catch (Exception e) {
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.SERVER_ERROR.valueStr(), "同步上报Ecif异常:" + e.getMessage());
        }
        return serverResponseDTO;
    }

}
