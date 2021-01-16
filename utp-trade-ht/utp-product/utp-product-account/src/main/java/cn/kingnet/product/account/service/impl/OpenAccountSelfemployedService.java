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
import cn.kingnet.utp.trade.common.dto.account.OpenAccountSelfemployedReqDTO;
import cn.kingnet.utp.trade.common.dto.account.OpenAccountSelfemployedRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOnlineCheckReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankOrcIdentityReqDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description : 个体工商户开户
 * @Author : linkaigui
 * @Create : 2020/2/11 9:50
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.OPEN_ACCOUNT_SELFEMPLOYED,
        reqClass = OpenAccountSelfemployedReqDTO.class,
        respClass = OpenAccountSelfemployedRespDTO.class
)
@Slf4j
public class OpenAccountSelfemployedService extends AbstractAccountTradeService<OpenAccountSelfemployedReqDTO, OpenAccountSelfemployedRespDTO> {

    private final static String CUR_INDUSTRY = "CUR_INDUSTRY";

    @Resource
    IBlackListHandler blackListHandler;
    @Resource
    ICountryHandler countryHandler;
    @Resource
    ICodeDictionaryHandler codeDictionaryHandler;
    @Resource
    private IAccountElectronicReceiptHandler accountElectronicReceiptHandler;
    @Resource
    protected PictureService pictureService;
    @Resource
    IIndustryHandler industryHandler;
    @Resource
    private IPaymentService paymentService;

    public OpenAccountSelfemployedService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<OpenAccountSelfemployedReqDTO, OpenAccountSelfemployedRespDTO> tradeContext) {
        Industry industry = tradeContext.getAttribute(CUR_INDUSTRY);
        //查询资金账户号
        String fundAccount = industry.getFundAccount();
        OpenAccountSelfemployedReqDTO reqDTO = tradeContext.getRequestDTO();
        VirtualAccountType virtualAccountType = VirtualAccountType.resolve(reqDTO.getNature());
        Account account = accountHandler.findAccount(fundAccount, reqDTO.getUserNo());
        if (account != null && !fundAccount.equals(account.getFundAccount())) {
            throw new ProductException(HttpRespStatus.SERVER_ERROR, "接入方用户号已开户!");
        }
        if (account != null && !account.getObjType().equals(virtualAccountType.getType())) {
            throw new ProductException(HttpRespStatus.SERVER_ERROR, "接入方用户号已开户!");
        }
        OpenAccountSelfemployedRespDTO openAccountSelfemployedRespDTO = new OpenAccountSelfemployedRespDTO();
        openAccountSelfemployedRespDTO.setClientTradeId(reqDTO.getClientTradeId());
        openAccountSelfemployedRespDTO.setServerTradeId(tradeContext.getServerTransId());
        if (account != null && !VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())) {
            logger.warn("流水号:{} >> 账户已开户，无需重复开户！", tradeContext.getServerTransId());
            openAccountSelfemployedRespDTO.setUserAccount(account.getAccount());
            return ChannelResponseUtil.success(openAccountSelfemployedRespDTO, null, null);
        }
        FundAccount fundAccountEntity = accountHandler.findFundAccount(fundAccount);
        //查找资金账户编号，用来生成虚拟账户号
        String no = fundAccountEntity.getAccountNum();
        //生成虚拟账号
        String userAccount = accountHandler.createAccountNo(no);
        Account openAcount = new Account();
        openAcount.setObjCode(reqDTO.getUserNo());
        openAcount.setObjType(virtualAccountType.getType());
        openAcount.setObjName(reqDTO.getName());
        openAcount.setAccount(userAccount);
        openAcount.setFundAccount(fundAccount);
        MerchantInfo merchantInfo = MerchantInfo.builder()
                .gmtCreate(new Date())
                .account(userAccount)
                .merNo(reqDTO.getUserNo())
                .merName(reqDTO.getName())
                .realName(reqDTO.getName())
                .idType(reqDTO.getIdType())
                .idCode(reqDTO.getIdCode())
                .industryCode(tradeContext.getAuthInfo().getAuthNo())
                .industryName(industry.getName())
                .status(AccountStatus.OPEN_UNBIND.getCode().toString())
                .userType(UserType.ONE.getType())
                .authStatus(MerAuthStatus.PENDING_AUTH.getCode())
                .sex(StringUtil.getSexByIdCode(reqDTO.getIdCode()))
                .country(reqDTO.getCountry())
                .prosession(reqDTO.getProsession())
                .businessAddress(reqDTO.getAddress())
                .idIndate(reqDTO.getIdIndate())
                .personPic(pictureService.base64ContentToFile(reqDTO.getPersonPicA(), industry.getCode(), userAccount, FileType.JPG))
                .personReversePic(pictureService.base64ContentToFile(reqDTO.getPersonPicB(), industry.getCode(), userAccount, FileType.JPG))
                .telephone(reqDTO.getMobile())
                .nature(virtualAccountType.getType())
                .build();
        OpenAccountBo bo = new OpenAccountBo();
        bo.setAccount(openAcount);
        bo.setMerchantInfo(merchantInfo);
        accountHandler.openAccount(bo);

        try{
            accountElectronicReceiptHandler.createJobTask(merchantInfo.getAccount(),merchantInfo.getNature());
        }catch (Exception e){
            logger.error("流水号:{} >> 账户:{} >> 个体工商户开户成功,创建开户电子回单任务异常:{}",tradeContext.getServerTransId(),merchantInfo.getAccount(),e.getMessage(),e);
        }

        openAccountSelfemployedRespDTO.setUserAccount(userAccount);
        return ChannelResponseUtil.success(openAccountSelfemployedRespDTO, null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<OpenAccountSelfemployedReqDTO, OpenAccountSelfemployedRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        OpenAccountSelfemployedReqDTO reqDTO = tradeContext.getRequestDTO();
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

        VirtualAccountType virtualAccountType = VirtualAccountType.resolve(reqDTO.getNature());
        if (virtualAccountType == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "账户性质[" + reqDTO.getNature() + "]参数有误");
        }
        if (VirtualAccountType.SELFEMPLOYED != virtualAccountType) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "账户性质参数必须为8");
        }

        //查找代付客户号信息，为了查找资金账户号
        Industry industry = accountHandler.findIndustry(tradeContext.getAuthInfo().getAuthNo());
        if (industry == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "找不到客户号信息,拒绝请求!");
        }
        ValidateUtils.hasText(industry.getCode(), "平台代码");
        ValidateUtils.hasText(industry.getFundAccount(), "资金账号");
        ValidateUtils.hasText(industry.getAccount(), "平台虚拟账号");
        if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "代付客户未启用");
        }

        tradeContext.setAttribute(CUR_INDUSTRY, industry);

        boolean existByThreeBitLetters = countryHandler.isExistByThreeBitLetters(reqDTO.getCountry());
        if (!existByThreeBitLetters) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "国籍、地区编码[" + reqDTO.getCountry() + "]参数有误");
        }
        boolean isExistCodeDictionary = codeDictionaryHandler.isExistCodeDictionary("0003", reqDTO.getProsession());
        if (!isExistCodeDictionary) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "职业[" + reqDTO.getProsession() + "]参数有误");
        }

        if (reqDTO.getName().equals(industry.getLegalPerson()) && reqDTO.getIdCode().equals(industry.getIdCode())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "个人账户姓名及身份证号不能为客户号法人及身份证号设值一致");
        }

        boolean inBlack = blackListHandler.findIsBlackByNameAndIdCode(reqDTO.getName(), reqDTO.getIdCode());
        if (inBlack) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "当前个体工商信息位于黑名单中，开户失败，请联系管理员");
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
    public void initTransFlow(TradeContext<OpenAccountSelfemployedReqDTO, OpenAccountSelfemployedRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<OpenAccountSelfemployedReqDTO, OpenAccountSelfemployedRespDTO> tradeContext) {

    }
}
