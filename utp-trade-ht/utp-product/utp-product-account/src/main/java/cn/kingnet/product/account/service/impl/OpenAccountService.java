package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.product.account.service.inner.PictureService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.bo.OpenAccountBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.OpenAccountReqDTO;
import cn.kingnet.utp.trade.common.dto.account.OpenAccountRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOnlineCheckReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOrcIdentityReqDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 个人开户
 * @author zhongli
 * @date 2019-02-19
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.OPEN_ACCOUNT,
        reqClass = OpenAccountReqDTO.class,
        respClass = OpenAccountRespDTO.class
)
@Slf4j
public class OpenAccountService extends AbstractAccountTradeService<OpenAccountReqDTO, OpenAccountRespDTO> {


    private final static String CUR_INDUSTRY = "CUR_INDUSTRY";
    @Autowired
    IAccountHandler accountHandler;
    @Autowired
    IIndustryHandler industryHandler;
    @Autowired
    IBlackListHandler blackListHandler;
    @Autowired
    ICountryHandler countryHandler;
    @Autowired
    ICodeDictionaryHandler codeDictionaryHandler;
    @Resource
    private IAccountElectronicReceiptHandler accountElectronicReceiptHandler;
    @Resource
    private PictureService pictureService;
    @Resource
    private IPaymentService paymentService;

    public OpenAccountService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<OpenAccountReqDTO, OpenAccountRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        OpenAccountReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getUserNo(), 32, true, "接入方用户号");
        ValidateUtils.maxLength(reqDTO.getName(), 60, true, "姓名");
        ValidateUtils.maxLength(reqDTO.getIdType(), 3, true, "证件类型");
        IdType idType = IdType.getEnum(reqDTO.getIdType());
        ValidateUtils.notNull(idType, "证件类型不支持");
        ValidateUtils.maxLength(reqDTO.getIdCode(), 32, true, "证件号");

        ValidateUtils.maxLength(reqDTO.getNickName(), 20, false, "用户昵称");

        //以0开头的手机号则视为固话
        ValidateUtils.hasText(reqDTO.getMobile(), "手机号码");
        if (reqDTO.getMobile().startsWith("0")) {
            ValidateUtils.phoneValid(reqDTO.getMobile(), true, "手机号码");
        } else {
            ValidateUtils.mobileValid(reqDTO.getMobile(), true, "手机号码");
        }

        ValidateUtils.emailValid(reqDTO.getEmail(), false, "邮箱地址");


        // ValidateUtils.maxLength(reqDTO.getPersonPicA(), 65532, true, "个人证件正面图片");
        // ValidateUtils.maxLength(reqDTO.getPersonPicB(), 65532, true, "个人证件反面图片");
        ValidateUtils.hasText(reqDTO.getPersonPicA(), "个人证件正面图片");
        ValidateUtils.hasText(reqDTO.getPersonPicB(), "个人证件反面图片");
        //ValidateUtils.checkSex(reqDTO.getSex(), true, "性别");
        ValidateUtils.maxLength(reqDTO.getCountry(), 50, true, "国籍、地区编码");
        ValidateUtils.maxLength(reqDTO.getProsession(), 100, true, "职业");
        ValidateUtils.maxLength(reqDTO.getAddress(), 256, true, "住所/工作地址");
        ValidateUtils.minChineseNum(reqDTO.getAddress(),10,true,"住所/工作地址");
        ValidateUtils.maxLength(reqDTO.getIdIndate(), 10, true, "证件有效期");
        ValidateUtils.isYyyy_MM_dd(reqDTO.getIdIndate(), true, "证件有效期");
        if (IdType.SFZ == idType) {
            ValidateUtils.idCardValid(reqDTO.getIdCode(), true, "证件号码");
            ValidateUtils.validIdIndate(reqDTO.getIdIndate(),reqDTO.getIdCode(),true,"身份证有效期");
        }

        boolean existByThreeBitLetters = countryHandler.isExistByThreeBitLetters(reqDTO.getCountry());
        if (!existByThreeBitLetters) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "国籍、地区编码[" + reqDTO.getCountry() + "]参数有误");
        }
        boolean isExistCodeDictionary = codeDictionaryHandler.isExistCodeDictionary("0003", reqDTO.getProsession());
        if (!isExistCodeDictionary) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "职业[" + reqDTO.getProsession() + "]参数有误");
        }
        //查找代付客户号信息，为了查找资金账户号
        Industry industry = accountHandler.findIndustry(tradeContext.getAuthInfo().getAuthNo());
        if (industry == null) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "未找到代付客户信息");
        } else if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "代付客户未启用");
        }
        tradeContext.setAttribute(CUR_INDUSTRY, industry);
        VirtualAccountType virtualAccountType = VirtualAccountType.resolve(reqDTO.getNature());
        if (virtualAccountType == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "账户性质[" + reqDTO.getNature() + "]参数有误");
        }
        if (VirtualAccountType.PERSON != virtualAccountType && VirtualAccountType.BROKERAGE != virtualAccountType) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "账户性质参数必须为3|7");
        }
        if (VirtualAccountType.BROKERAGE == virtualAccountType) {
            //个人开户去除了开通佣金账户功能
            throw new ProductException(HttpRespStatus.FORBIDDEN, "个人无法开通佣金账户类型");

            // if (!reqDTO.getName().equals(industry.getLegalPerson()) || !reqDTO.getIdCode().equals(industry.getIdCode())) {
            //     throw new ProductException(HttpRespStatus.BAD_REQUEST, "佣金账户姓名及身份证号必须与客户号法人及身份证号设值一致");
            // }
        } else {
            if (reqDTO.getName().equals(industry.getLegalPerson()) && reqDTO.getIdCode().equals(industry.getIdCode())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "个人账户姓名及身份证号不能为客户号法人及身份证号设值一致");
            }
        }
        boolean inBlack = blackListHandler.findIsBlackByNameAndIdCode(reqDTO.getName(), reqDTO.getIdCode());
        if (inBlack) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "当前个人信息位于黑名单中，开户失败，请联系管理员");
        }

        //渠道ORC身份识别接口，不匹配拒绝开户
        OneBankOrcIdentityReqDTO oneBankOrcIdentityReqDTO = new OneBankOrcIdentityReqDTO();
        oneBankOrcIdentityReqDTO.setClientTradeId(tradeContext.getServerTransId());
        oneBankOrcIdentityReqDTO.setName(reqDTO.getName());
        oneBankOrcIdentityReqDTO.setIdcard(reqDTO.getIdCode());
        oneBankOrcIdentityReqDTO.setIdcardImage(reqDTO.getPersonPicA());
        ChannelResponseDTO orcIdentityRespDTO;
        try {
            orcIdentityRespDTO = paymentService.orcIdentity(oneBankOrcIdentityReqDTO);
        } catch (Exception e) {
            log.error("ORC身份识别异常==>{}", e.getMessage(), e);
            throw new ProductException(HttpRespStatus.FORBIDDEN, "ORC身份识别异常");
        }
        if (!HttpRespStatus.OK.valueStr().equals(orcIdentityRespDTO.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "ORC身份识别失败:" + orcIdentityRespDTO.getMessage());
        }

        //渠道联网核查接口，不匹配拒绝开户
        OneBankOnlineCheckReqDTO oneBankOnlineCheckReqDTO = new OneBankOnlineCheckReqDTO();
        oneBankOnlineCheckReqDTO.setClientTradeId(tradeContext.getServerTransId());
        oneBankOnlineCheckReqDTO.setPersonId(reqDTO.getIdCode());
        oneBankOnlineCheckReqDTO.setPersonName(reqDTO.getName());
        oneBankOnlineCheckReqDTO.setBusinessPlace(reqDTO.getCountry());
        oneBankOnlineCheckReqDTO.setBusinessType("05");
        ChannelResponseDTO onlineCheckRespDTO;
        try {
            onlineCheckRespDTO = paymentService.onlineCheck(oneBankOnlineCheckReqDTO);
        } catch (Exception e) {
            log.error("联网核查异常==>{}", e.getMessage(), e);
            throw new ProductException(HttpRespStatus.FORBIDDEN, "联网核查异常");
        }
        if (!HttpRespStatus.OK.valueStr().equals(onlineCheckRespDTO.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "联网核查失败:" + onlineCheckRespDTO.getMessage());
        }

        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        boolean isOverOpenMax = industryHandler.validSubAccountOpenMax(industry.getCode(), reqDTO.getIdCode(), basicConfigInfo.getSubAccountOpenMax(), reqDTO.getNature(),UserType.ONE.getType());
        if (isOverOpenMax) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("已超出二级账户最大开立数量%s", basicConfigInfo.getSubAccountOpenMax()));
        }
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext tradeContext) {
        Industry industry = (Industry) tradeContext.getAttribute(CUR_INDUSTRY);
        //查询资金账户号
        String fundAccount = industry.getFundAccount();
        OpenAccountReqDTO reqDTO = (OpenAccountReqDTO) tradeContext.getRequestDTO();
        VirtualAccountType userType = VirtualAccountType.resolve(reqDTO.getNature());
        Account account = accountHandler.findAccount(fundAccount, reqDTO.getUserNo());
        if (account != null && !VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())) {
            logger.warn("流水号:{} >> 账户已开户，无需重复开户！", tradeContext.getServerTransId());
            return ChannelResponseUtil.success(this.buildSuccessResponse(tradeContext, account.getAccount()), null, null);
        }
        //若佣金账户则 industryCode+ （个人开户去除了开通佣金账户功能）
        // if (userType == VirtualAccountType.BROKERAGE) {
        //     Account brokerageAccount = industryHandler.getIndustryBrokerageAccount(industry.getCode());
        //     if (brokerageAccount != null && !VirtualAccountStatus.CANCEL.getType().equals(brokerageAccount.getStatus())) {
        //         logger.warn("流水号:{} >> 平台佣金账户已开户，无需重复开户！", tradeContext.getServerTransId());
        //         //校验是否和上送的userNo一样
        //         if (brokerageAccount.getObjCode().equals(reqDTO.getUserNo())) {
        //             return ChannelResponseUtil.success(buildSuccessResponse(tradeContext, brokerageAccount.getAccount()), null, null);
        //         } else {
        //             return ChannelResponseUtil.fail(buildFailResponse(tradeContext, "平台佣金账户已开户，无需重复开户"), HttpRespStatus.BAD_REQUEST, "平台佣金账户已开户，无需重复开户");
        //         }
        //     }
        // }

        FundAccount fundAccountEntity = accountHandler.findFundAccount(fundAccount);
        //查找资金账户编号，用来生成虚拟账户号
        String no = fundAccountEntity.getAccountNum();
        //生成虚拟账号
        String userAccount = accountHandler.createAccountNo(no);

        Account openAcount = new Account();
        openAcount.setObjCode(reqDTO.getUserNo());
        openAcount.setObjType(userType.getType());
        openAcount.setObjName(reqDTO.getName());
        openAcount.setAccount(userAccount);
        openAcount.setFundAccount(fundAccount);
        MerchantInfo merchantInfo = MerchantInfo.builder()
                .gmtCreate(new Date())
                .account(userAccount)
                .merNo(openAcount.getObjCode())
                .merName(openAcount.getObjName())
                .realName(reqDTO.getName())
                .idType(reqDTO.getIdType())
                .idCode(reqDTO.getIdCode())
                .industryCode(tradeContext.getAuthInfo().getAuthNo())
                .industryName(industry.getName())
                .status(AccountStatus.OPEN_UNBIND.getCode().toString())
                .userType(UserType.ONE.getType())
                .authStatus(MerAuthStatus.NORMAL.getCode())
                .sex(StringUtil.getSexByIdCode(reqDTO.getIdCode()))
                .country(reqDTO.getCountry())
                .prosession(reqDTO.getProsession())
                .businessAddress(reqDTO.getAddress())
                .idIndate(reqDTO.getIdIndate())
                .personPic(pictureService.base64ContentToFile(reqDTO.getPersonPicA(), industry.getCode(), userAccount, FileType.JPG))
                .personReversePic(pictureService.base64ContentToFile(reqDTO.getPersonPicB(), industry.getCode(), userAccount, FileType.JPG))
                .telephone(reqDTO.getMobile())
                .nature(userType.getType())
                .build();
        OpenAccountBo bo = new OpenAccountBo();
        bo.setAccount(openAcount);
        bo.setMerchantInfo(merchantInfo);
        accountHandler.openAccount(bo);

		try{
			accountElectronicReceiptHandler.createJobTask(merchantInfo.getAccount(),merchantInfo.getNature());
		}catch (Exception e){
			logger.error("流水号:{} >> 账户:{} >> 个人开户成功,创建开户电子回单任务异常:{}",tradeContext.getServerTransId(),merchantInfo.getAccount(),e.getMessage(),e);
		}

        return ChannelResponseUtil.success(buildSuccessResponse(tradeContext, userAccount), null, null);
    }

    /**
     * 虚拟账号编号规则：资金账户编号（4位）+ 序列号（8位）+ 2位随机数
     * </p>
     * @param tradeContext 交易上下文
     */
    @Override
    public void initTransFlow(TradeContext tradeContext) {

    }

    private OpenAccountRespDTO buildSuccessResponse(TradeContext tradeContext, String userAccount) {
        OpenAccountRespDTO respDTO = OpenAccountRespDTO.builder().userAccount(userAccount).build();
        respDTO.setClientTradeId(tradeContext.getClientTradeId());
        respDTO.setServerTradeId(tradeContext.getServerTransId());
        respDTO.setStatus(HttpRespStatus.OK.valueStr());
        respDTO.setMessage(HttpRespStatus.OK.getReasonPhrase());
        respDTO.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tradeContext.setResponseDTO(respDTO);
        return respDTO;
    }

    private OpenAccountRespDTO buildFailResponse(TradeContext tradeContext, String message) {
        OpenAccountRespDTO respDTO = OpenAccountRespDTO.builder().build();
        respDTO.setClientTradeId(tradeContext.getClientTradeId());
        respDTO.setServerTradeId(tradeContext.getServerTransId());
        respDTO.setStatus(HttpRespStatus.BAD_REQUEST.valueStr());
        respDTO.setMessage(message);
        respDTO.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tradeContext.setResponseDTO(respDTO);
        return respDTO;
    }

    @Override
    public void updateTransFlow(TradeContext tradeContext) {

    }

}
