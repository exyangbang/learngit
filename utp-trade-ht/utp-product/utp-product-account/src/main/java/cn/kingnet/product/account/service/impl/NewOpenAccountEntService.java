package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.product.account.service.inner.PictureService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.OpenAccountBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.NewOpenAccountEntReqDTO;
import cn.kingnet.utp.trade.common.dto.account.NewOpenAccountEntRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;

/**
 * 4.1.15.企业开户（京东定制化）
 * 1. 功能描述：
 * 企业申请开通虚拟账户，簿记平台根据接入方用户号，作为唯一标志，开通对应的唯一虚拟账户。(备注：如果接入方在开户请求时未收到应答报文，可再次上送开户请求，簿记平台若之前已开户成功，会直接返回对应的用户账户)
 * 企业在申请开通虚拟账户时，上传对应的图片材料,由运营人员进行审核，审核通过之后，可进行企业鉴权绑卡。 审核失败，可以调用开户接口重新上传图片材料。审核结果通过4.1.7.  企业/个体工商户证件资料审核结果回调通知 接口进行异步回调。
 * 2.请求URL: /v2/account/new_open_account_ent
 *
 * @author WJH
 * @date 2020-09-02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.NEW_OPEN_ACCOUNT_ENT,
        reqClass = NewOpenAccountEntReqDTO.class,
        respClass = NewOpenAccountEntRespDTO.class
)
public class NewOpenAccountEntService extends AbstractAccountTradeService<NewOpenAccountEntReqDTO, NewOpenAccountEntRespDTO> {

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
    @Resource
    protected PictureService pictureService;

    public NewOpenAccountEntService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<NewOpenAccountEntReqDTO, NewOpenAccountEntRespDTO> tradeContext) {
        NewOpenAccountEntReqDTO reqDTO = tradeContext.getRequestDTO();
        Industry industry = tradeContext.getAttribute(CUR_INDUSTRY);
        VirtualAccountType virtualAccountType = VirtualAccountType.resolve(reqDTO.getNature());
        //查询资金账户号
        String fundAccount = industry.getFundAccount();

        // industryCode+merNo 查询merchantInfo是否已开户及审核状态
        // 未开户则走开户流程  已开户且已审核通过直接返回相关状态成功 待审核则直接覆盖上送资料 已驳回则覆盖上送资料且状态置为待审核
        Account account = accountHandler.findAccount(fundAccount, reqDTO.getUserNo());
        MerchantInfo merchantInfo = null;
        if (account != null) {
            merchantInfo = industryHandler.getMerchantInfoByUserAccount(tradeContext.getIndustryCode(), account.getAccount());
            if (merchantInfo == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "已开户但查无此虚账户关联的基础信息");
            }
        }

        //条件判断图片上送：db存在则允许为空，若不为空则覆盖，db不存在则不允许为空
        validMerchantInfoPics(merchantInfo, reqDTO);


        //若佣金账户则 校验已开户佣金户必须和上送的userNo一致
        if (virtualAccountType == VirtualAccountType.BROKERAGE) {
            MerchantInfo brokerageMerchantInfo = industryHandler.getIndustryBrokerageMerchantInfo(industry.getCode());
            if (brokerageMerchantInfo != null) {
                logger.warn("流水号:{} >> 平台佣金账户已开户，无需重复开户!", tradeContext.getServerTransId());
                //校验是否和上送的userNo一样
                if (brokerageMerchantInfo.getMerNo().equals(reqDTO.getUserNo())) {
                    NewOpenAccountEntRespDTO respDTO = buildNewOpenAccountEntResp(tradeContext, fundAccount, virtualAccountType, brokerageMerchantInfo);
                    return ChannelResponseUtil.success(respDTO, null, null);
                }
            } else {
                return ChannelResponseUtil.build(new NewOpenAccountEntRespDTO(), null, null, HttpRespStatus.BAD_REQUEST, "平台佣金账户已开户，无需重复开户。userNo不一致");
            }
        }

        if (merchantInfo != null && account != null && !StringUtil.equals(merchantInfo.getAccount(), account.getAccount())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "已存在接入方用户号基础信息与账户信息不一致");
        }

        NewOpenAccountEntRespDTO respDTO = buildNewOpenAccountEntResp(tradeContext, fundAccount, virtualAccountType, merchantInfo);

//  todo 开户电子回单，暂时不启用

//        try{
//            accountElectronicReceiptHandler.createJobTask(merchantInfo.getAccount(),merchantInfo.getNature());
//        }catch (Exception e){
//            logger.error("流水号:{} >> 账户:{} >> 企业开户成功,创建开户电子回单任务异常:{}",tradeContext.getServerTransId(),merchantInfo.getAccount(),e.getMessage(),e);
//        }

        return ChannelResponseUtil.success(respDTO, null, null);
    }

    private void validMerchantInfoPics(MerchantInfo merchantInfo, NewOpenAccountEntReqDTO reqDTO) {
        if (merchantInfo != null) {
            if (StringUtil.isBlank(merchantInfo.getBusLicPic()) && StringUtil.isBlank(reqDTO.getBusinessLicensePic())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "营业执照图片不能为空");
            }
//            if (StringUtil.isBlank(merchantInfo.getLicensePic()) && StringUtil.isBlank(reqDTO.getLicensePic())) {
//                throw new ProductException(HttpRespStatus.BAD_REQUEST, "开户许可证图片不能为空");
//            }
            if (StringUtil.isBlank(merchantInfo.getPersonPic()) && StringUtil.isBlank(reqDTO.getPersonPicA())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "法人证件正面照图片不能为空");
            }
            if (StringUtil.isBlank(merchantInfo.getPersonReversePic()) && StringUtil.isBlank(reqDTO.getPersonPicB())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "法人证件反面照图片不能为空");
            }
        } else {
            if (StringUtil.isBlank(reqDTO.getBusinessLicensePic())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "营业执照图片不能为空");
            }
//            if (StringUtil.isBlank(reqDTO.getLicensePic())) {
//                throw new ProductException(HttpRespStatus.BAD_REQUEST, "开户许可证图片不能为空");
//            }
            if (StringUtil.isBlank(reqDTO.getPersonPicA())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "法人证件正面照图片不能为空");
            }
            if (StringUtil.isBlank(reqDTO.getPersonPicB())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "法人证件反面照图片不能为空");
            }
        }
    }

    private NewOpenAccountEntRespDTO buildNewOpenAccountEntResp(TradeContext<NewOpenAccountEntReqDTO, NewOpenAccountEntRespDTO> tradeContext, String fundAccount, VirtualAccountType virtualAccountType, MerchantInfo merchantInfo) {
        NewOpenAccountEntReqDTO reqDTO = tradeContext.getRequestDTO();
        NewOpenAccountEntRespDTO.NewOpenAccountEntRespDTOBuilder respDTOBuilder = NewOpenAccountEntRespDTO.builder();
        Industry industry = tradeContext.getAttribute(CUR_INDUSTRY);
        String industryCode = industry.getCode();
        String userAccount;
        if (merchantInfo != null) {
            userAccount = merchantInfo.getAccount();
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(merchantInfo.getAuthStatus());
            if (merAuthStatus == MerAuthStatus.NORMAL) {
                return respDTOBuilder.userAccount(merchantInfo.getAccount()).accountStatus(merchantInfo.getStatus()).authStatus(merchantInfo.getAuthStatus().toString()).build();
            }
        } else {
            //虚拟账号编号规则：资金账户编号（4位）+ 序列号（8位）+ 2位随机数
            FundAccount fundAccountEntity = accountHandler.findFundAccount(fundAccount);
            //查找资金账户编号，用来生成虚拟账户号
            String no = fundAccountEntity.getAccountNum();
            //生成虚拟账号
            userAccount = accountHandler.createAccountNo(no);
        }

        OpenAccountBo openAccountBo = new OpenAccountBo();
        Account tmpAccount = new Account();
        tmpAccount.setAccount(userAccount);
        tmpAccount.setObjCode(reqDTO.getUserNo());
        tmpAccount.setObjType(virtualAccountType.getType());
        tmpAccount.setObjName(reqDTO.getEnterpriseName());
        tmpAccount.setFundAccount(fundAccount);

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setBusinessIndate(reqDTO.getIdIndate());
        accountInfo.setLegalIndate(reqDTO.getPersonIdIndate());
        accountInfo.setAccount(userAccount);
        accountInfo.setObjType(virtualAccountType.getType());
        accountInfo.setUserType(UserType.MER.getType());

        MerchantInfo.MerchantInfoBuilder merchantInfoBuilder = MerchantInfo.builder()
                .merNo(tmpAccount.getObjCode()).merName(tmpAccount.getObjName()).account(userAccount)
                .regAddress(reqDTO.getRegAddress())
                .businessAddress(reqDTO.getRegAddress())
                .busLicCode(reqDTO.getBusinessLicenseCode())
                .legalName(reqDTO.getPersonName())
                .idCode(reqDTO.getPersonIdCode())
                .idType(reqDTO.getPersonIdType())
                .entName(reqDTO.getEnterpriseName())
                .industryCode(tradeContext.getIndustryCode())
                .industryName(industry.getName())
                .status(AccountStatus.OPEN_UNBIND.getCode().toString())
                .userType(UserType.MER.getType())
                .authStatus(MerAuthStatus.PENDING_REVIEW.getCode()) //京东定制化 开户后直接进入审核状态，审核通过后才可以绑卡鉴权
                .country(reqDTO.getCountry())
                .prosession(reqDTO.getOccupation())
                .telephone(reqDTO.getMobile())
                .nature(virtualAccountType.getType())
                .authCallBack(reqDTO.getCallbackUrl());

        //图片特殊处理
        if (StringUtil.isNotBlank(reqDTO.getPersonPicA())) {
            merchantInfoBuilder.personPic(this.base64ContentToFileURI(reqDTO.getPersonPicA(), industryCode, userAccount));
        }
        if (StringUtil.isNotBlank(reqDTO.getPersonPicB())) {
            merchantInfoBuilder.personReversePic(this.base64ContentToFileURI(reqDTO.getPersonPicB(), industryCode, userAccount));
        }
        if (StringUtil.isNotBlank(reqDTO.getBusinessLicensePic())) {
            merchantInfoBuilder.busLicPic(this.base64ContentToFileURI(reqDTO.getBusinessLicensePic(), industryCode, userAccount));
        }
        if (StringUtil.isNotBlank(reqDTO.getLicensePic())) {
            merchantInfoBuilder.licensePic(this.base64ContentToFileURI(reqDTO.getLicensePic(), industryCode, userAccount));
        }

        Date curDate = Date.from(Instant.now());
        tmpAccount.setGmtModified(curDate);
        accountInfo.setGmtModified(curDate);
        merchantInfoBuilder.gmtModified(curDate);
        if (merchantInfo != null) {
            //更新
            openAccountBo.setUpdateFlag(true);
            merchantInfoBuilder.id(merchantInfo.getId());
        } else {//创建账户
            openAccountBo.setUpdateFlag(false);
            tmpAccount.setGmtCreate(curDate);
            accountInfo.setGmtCreate(curDate);
            merchantInfoBuilder.gmtCreate(curDate);
        }
        MerchantInfo tmpMerchantInfo = merchantInfoBuilder.build();

        openAccountBo.setAccount(tmpAccount);
        openAccountBo.setMerchantInfo(tmpMerchantInfo);
        openAccountBo.setAccountInfo(accountInfo);

        accountHandler.openAccount(openAccountBo);

        return respDTOBuilder.userAccount(tmpMerchantInfo.getAccount()).accountStatus(tmpMerchantInfo.getStatus()).authStatus(tmpMerchantInfo.getAuthStatus().toString()).build();
    }

    private String base64ContentToFileURI(String base64ContentPic, String industryCode, String account) {
        return pictureService.base64ContentToFile(base64ContentPic, industryCode, account, FileType.JPG);
    }

    @Override
    protected void verifyReqParam(TradeContext<NewOpenAccountEntReqDTO, NewOpenAccountEntRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        NewOpenAccountEntReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getUserNo(), 32, true, "接入方用户号");
        ValidateUtils.maxLength(reqDTO.getPersonName(), 100, true, "法人姓名");
        ValidateUtils.validBicCode(reqDTO.getBusinessLicenseCode());
        ValidateUtils.maxLength(reqDTO.getRegAddress(), 200, true, "企业注册地址");
        ValidateUtils.minChineseNum(reqDTO.getRegAddress(), 10, true, "企业注册地址");
        ValidateUtils.minMaxLength(reqDTO.getEnterpriseName(), 8, 100, true, "企业名称");
        ValidateUtils.maxLength(reqDTO.getPersonIdType(), 3, true, "证件类型");
        IdType idType = IdType.getEnum(reqDTO.getPersonIdType());
        ValidateUtils.notNull(idType, "证件类型不支持");
        ValidateUtils.maxLength(reqDTO.getPersonIdCode(), 32, true, "证件号");

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

        ValidateUtils.isHttpUrl(reqDTO.getCallbackUrl(), true, "回调地址");
        ValidateUtils.maxLength(reqDTO.getCallbackUrl(), 200, true, "回调地址");

        ValidateUtils.isYyyy_MM_dd(reqDTO.getIdIndate(), true, "营业执照有效期");
        ValidateUtils.isYyyy_MM_dd(reqDTO.getPersonIdIndate(), true, "法人证件有效期");
        if (IdType.SFZ.getCode().equals(reqDTO.getPersonIdType())) {
            ValidateUtils.idCardValid(reqDTO.getPersonIdCode(), true, "法人证件号码");
            ValidateUtils.validIdIndate(reqDTO.getPersonIdIndate(), reqDTO.getPersonIdCode(), true, "法人身份证有效期");
        }


        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        Integer openAccountMode = basicConfigInfo.getOpenAccountMode();
        if (openAccountMode == null || OpenAccountMode.OPEN.getCode().intValue() != openAccountMode) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "该平台暂不支持该开户模式");
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

        boolean isOverOpenMax = industryHandler.validSubAccountOpenMax(industry.getCode(), reqDTO.getBusinessLicenseCode(), basicConfigInfo.getSubAccountOpenMax(), reqDTO.getNature(), UserType.MER.getType());
        if (isOverOpenMax) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("已超出二级账户最大开立数量%s", basicConfigInfo.getSubAccountOpenMax()));
        }
        tradeContext.setAttribute(CUR_INDUSTRY, industry);
    }


    @Override
    public void initTransFlow(TradeContext<NewOpenAccountEntReqDTO, NewOpenAccountEntRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<NewOpenAccountEntReqDTO, NewOpenAccountEntRespDTO> tradeContext) {

    }
}
