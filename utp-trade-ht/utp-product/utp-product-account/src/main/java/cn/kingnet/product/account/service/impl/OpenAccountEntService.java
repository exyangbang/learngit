package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
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
import cn.kingnet.utp.trade.common.dto.account.OpenAccountEntReqDTO;
import cn.kingnet.utp.trade.common.dto.account.OpenAccountRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 企业开户
 * @author zhongli
 * @date 2019-02-19
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.OPEN_ACCOUNT_ENT,
        reqClass = OpenAccountEntReqDTO.class,
        respClass = OpenAccountRespDTO.class
)
public class OpenAccountEntService extends AbstractAccountTradeService<OpenAccountEntReqDTO, OpenAccountRespDTO> {

    private final static String CUR_INDUSTRY = "CUR_INDUSTRY";

    @Resource
    IBlackListHandler blackListHandler;

    @Resource
    ICountryHandler countryHandler;

    @Resource
    ICodeDictionaryHandler codeDictionaryHandler;

    @Resource
    IIndustryHandler industryHandler;

    @Resource
    private IAccountElectronicReceiptHandler accountElectronicReceiptHandler;

    public OpenAccountEntService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<OpenAccountEntReqDTO, OpenAccountRespDTO> tradeContext) {
        OpenAccountEntReqDTO reqDTO = tradeContext.getRequestDTO();
        Industry industry = tradeContext.getAttribute(CUR_INDUSTRY);
        VirtualAccountType virtualAccountType = VirtualAccountType.resolve(reqDTO.getNature());
        //查询资金账户号
        String fundAccount = industry.getFundAccount();
        Account account = accountHandler.findAccount(fundAccount, reqDTO.getUserNo());
        if (account != null && !fundAccount.equals(account.getFundAccount())) {
            throw new ProductException(HttpRespStatus.SERVER_ERROR, "接入方用户号已开户!");
        }
        if (account != null && !account.getObjType().equals(virtualAccountType.getType())) {
            throw new ProductException(HttpRespStatus.SERVER_ERROR, "接入方用户号已开户!");
        }

        if (account != null && !VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())) {
            logger.warn("流水号:{} >> 账户已开户，无需重复开户!", tradeContext.getServerTransId());
            return ChannelResponseUtil.success(this.buildResponse(tradeContext, account.getAccount()), null, null);
        }
        //若佣金账户则 industryCode+
        if (virtualAccountType == VirtualAccountType.BROKERAGE) {
            MerchantInfo brokerageMerchantInfo = industryHandler.getIndustryBrokerageMerchantInfo(industry.getCode());
            if (brokerageMerchantInfo != null) {
                logger.warn("流水号:{} >> 平台佣金账户已开户，无需重复开户!", tradeContext.getServerTransId());
                //校验是否和上送的userNo一样
                if (brokerageMerchantInfo.getMerNo().equals(reqDTO.getUserNo())) {
                    return ChannelResponseUtil.success(this.buildResponse(tradeContext, brokerageMerchantInfo.getAccount()), null, null);
                } else {
                    return ChannelResponseUtil.build(this.buildResponse(tradeContext, null), null, null, HttpRespStatus.BAD_REQUEST, "平台佣金账户已开户，无需重复开户。userNo不一致");
                }
            }
        }

        //虚拟账号编号规则：资金账户编号（4位）+ 序列号（8位）+ 2位随机数
        FundAccount fundAccountEntity = accountHandler.findFundAccount(fundAccount);
        //查找资金账户编号，用来生成虚拟账户号
        String no = fundAccountEntity.getAccountNum();
        //生成虚拟账号
        String userAccount = accountHandler.createAccountNo(no);
        Account openAcount = new Account();
        openAcount.setObjCode(reqDTO.getUserNo());
        openAcount.setObjType(virtualAccountType.getType());
        openAcount.setObjName(reqDTO.getEnterpriseName());
        openAcount.setAccount(userAccount);
        openAcount.setFundAccount(fundAccount);
        MerchantInfo merchantInfo = MerchantInfo.builder().gmtCreate(new Date())
                .account(userAccount).merNo(openAcount.getObjCode()).merName(openAcount.getObjName())
                .regAddress(reqDTO.getRegAddress())
                .businessAddress(reqDTO.getRegAddress())
                .busLicCode(reqDTO.getBusinessLicenseCode())
                .legalName(reqDTO.getPersonName())
                .idCode(reqDTO.getPersonIdCode())
                .idType(reqDTO.getPersonIdType())
                .entName(reqDTO.getEnterpriseName())
                .industryCode(tradeContext.getAuthInfo().getAuthNo())
                .industryName(industry.getName())
                .status(AccountStatus.OPEN_UNBIND.getCode().toString())
                .userType(UserType.MER.getType())
                .authStatus(MerAuthStatus.PENDING_AUTH.getCode())
                .country(reqDTO.getCountry())
                .prosession(reqDTO.getOccupation())
                .telephone(reqDTO.getMobile())
                .nature(virtualAccountType.getType())
                .build();
        OpenAccountBo bo = new OpenAccountBo();
        bo.setAccount(openAcount);
        bo.setMerchantInfo(merchantInfo);
        accountHandler.openAccount(bo);
//todo 开户电子回单，暂时不启用
//        try{
//            accountElectronicReceiptHandler.createJobTask(merchantInfo.getAccount(),merchantInfo.getNature());
//        }catch (Exception e){
//            logger.error("流水号:{} >> 账户:{} >> 企业开户成功,创建开户电子回单任务异常:{}",tradeContext.getServerTransId(),merchantInfo.getAccount(),e.getMessage(),e);
//        }

        return ChannelResponseUtil.success(this.buildResponse(tradeContext, userAccount), null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<OpenAccountEntReqDTO, OpenAccountRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        OpenAccountEntReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getUserNo(), 32, true, "接入方用户号");
        ValidateUtils.maxLength(reqDTO.getPersonName(), 100, true, "法人姓名");
        ValidateUtils.validBicCode(reqDTO.getBusinessLicenseCode());
        ValidateUtils.maxLength(reqDTO.getRegAddress(), 200, true, "企业注册地址");
        ValidateUtils.minChineseNum(reqDTO.getRegAddress(),10,true,"企业注册地址");
        ValidateUtils.minMaxLength(reqDTO.getEnterpriseName(), 8, 100, true, "企业名称");
        ValidateUtils.maxLength(reqDTO.getPersonIdType(), 3, true, "证件类型");
        IdType idType = IdType.getEnum(reqDTO.getPersonIdType());
        ValidateUtils.notNull(idType, "证件类型不支持");
        ValidateUtils.maxLength(reqDTO.getPersonIdCode(), 32, true, "证件号");
        if (IdType.SFZ.getCode().equals(reqDTO.getPersonIdType())) {
            ValidateUtils.idCardValid(reqDTO.getPersonIdCode(), true, "法人证件号码");
        }
        ValidateUtils.maxLength(reqDTO.getNickName(), 20, false, "用户昵称");

        //以0开头的手机号则视为固话
        ValidateUtils.hasText(reqDTO.getMobile(), "手机号码");
        if (reqDTO.getMobile().startsWith("0")) {
            ValidateUtils.phoneValid(reqDTO.getMobile(), true, "手机号码");
        } else {
            ValidateUtils.mobileValid(reqDTO.getMobile(), true, "手机号码");
        }

        ValidateUtils.emailValid(reqDTO.getEmail(), false, "邮箱地址");
        ValidateUtils.maxLength(reqDTO.getCountry(), 50, true, "国籍、地区编码");
        ValidateUtils.maxLength(reqDTO.getOccupation(), 100, true, "行业");

        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        Integer openAccountMode = basicConfigInfo.getOpenAccountMode();
        if(openAccountMode==null || OpenAccountMode.BIND.getCode().intValue()!=openAccountMode){
            throw new ProductException(HttpRespStatus.FORBIDDEN,"该平台暂不支持该开户模式");
        }

        boolean existByThreeBitLetters = countryHandler.isExistByThreeBitLetters(reqDTO.getCountry());
        if (!existByThreeBitLetters) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "国籍、地区编码[" + reqDTO.getCountry() + "]参数有误");
        }
        boolean isExistCodeDictionary = codeDictionaryHandler.isExistCodeDictionary("0002", reqDTO.getOccupation());
        if (!isExistCodeDictionary) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "行业[" + reqDTO.getOccupation() + "]参数有误");
        }

        //查找代付客户号信息，为了查找资金账户号
        Industry industry = accountHandler.findIndustry(tradeContext.getAuthInfo().getAuthNo());
        if (industry == null) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "未找到代付客户信息");
        } else if (!TrueOrFalseStatus.TRUE.value().equals(industry.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "代付客户未启用");
        }

        VirtualAccountType virtualAccountType = VirtualAccountType.resolve(reqDTO.getNature());
        if (virtualAccountType == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "账户性质[" + reqDTO.getNature() + "]参数有误");
        }
        if (VirtualAccountType.MERCHANT != virtualAccountType && VirtualAccountType.BROKERAGE != virtualAccountType) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "账户性质参数必须为2|7");
        }
        if (VirtualAccountType.BROKERAGE == virtualAccountType) {
            if (!reqDTO.getEnterpriseName().equals(industry.getEntName())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "佣金账户的企业名称必须与客户号的企业名称设值一致");
            }
        }
        // else {
        //     if (reqDTO.getEnterpriseName().equals(industry.getEntName())) {
        //         throw new ProductException(HttpRespStatus.BAD_REQUEST, "企业账户的企业名称不能与客户号的企业名称设值一致");
        //     }
        // }
        boolean inBlack = blackListHandler.findIsBlackByEntNameAndBusLicCode(reqDTO.getEnterpriseName(), reqDTO.getBusinessLicenseCode());
        if (inBlack) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "当前企业信息位于黑名单中，开户失败，请联系管理员");
        }


        boolean isOverOpenMax = industryHandler.validSubAccountOpenMax(industry.getCode(), reqDTO.getBusinessLicenseCode(), basicConfigInfo.getSubAccountOpenMax(), reqDTO.getNature(),UserType.MER.getType());
        if (isOverOpenMax) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("已超出二级账户最大开立数量%s", basicConfigInfo.getSubAccountOpenMax()));
        }
        tradeContext.setAttribute(CUR_INDUSTRY, industry);
    }

    private OpenAccountRespDTO buildResponse(TradeContext tradeContext, String userAccount) {
        OpenAccountRespDTO openAccountRespDTO = OpenAccountRespDTO.builder().build();
        if (StringUtil.isNoneBlank(userAccount)) {
            openAccountRespDTO.setUserAccount(userAccount);
        }
        openAccountRespDTO.setClientTradeId(tradeContext.getClientTradeId());
        openAccountRespDTO.setServerTradeId(tradeContext.getServerTransId());
        return openAccountRespDTO;
    }

    @Override
    public void initTransFlow(TradeContext<OpenAccountEntReqDTO, OpenAccountRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<OpenAccountEntReqDTO, OpenAccountRespDTO> tradeContext) {

    }
}
