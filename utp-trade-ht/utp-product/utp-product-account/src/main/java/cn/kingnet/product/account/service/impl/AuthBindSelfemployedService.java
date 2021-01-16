package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.product.account.service.inner.PictureService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ICardBinHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.BindBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.AuthBindSelfemployedReqDTO;
import cn.kingnet.utp.trade.common.dto.account.AuthBindSelfemployedRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankBindReq;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description : 个体工商户鉴权绑定账户
 * @Author : linkaigui
 * @Create : 2020/2/11 9:54
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.AUTH_BIND_SELFEMPLOYED,
        reqClass = AuthBindSelfemployedReqDTO.class,
        respClass = AuthBindSelfemployedRespDTO.class
)
@Slf4j
public class AuthBindSelfemployedService extends AbstractAccountTradeService<AuthBindSelfemployedReqDTO, AuthBindSelfemployedRespDTO> {

    @Resource
    private ICardBinHandler cardBinHandler;
    @Resource
    private IPaymentService paymentService;
    @Resource
    private IAccountHandler accountHandler;
    @Resource
    private IMerchantAccountHandler merchantAccountHandler;
    @Resource
    protected PictureService pictureService;

    private final static String CUR_INDUSTRY = "CUR_INDUSTRY";

    private final static String CARD_BIN_INFO_KEY = "CARD_BIN_INFO_KEY";

    public AuthBindSelfemployedService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<AuthBindSelfemployedReqDTO, AuthBindSelfemployedRespDTO> tradeContext) {
        AuthBindSelfemployedReqDTO reqDTO = tradeContext.getRequestDTO();
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccountAll(reqDTO.getUserAccount());
        if (merchantInfo == null || StringUtils.isBlank(merchantInfo.getAccount())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未开户");
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        if (!VirtualAccountType.SELFEMPLOYED.getType().equals(merchantInfo.getNature())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不允许此操作");
        }

        AccountStatus accountStatus = AccountStatus.getEnum(Integer.valueOf(merchantInfo.getStatus()));
        Industry industry = tradeContext.getAttribute(CUR_INDUSTRY);

        MerchantAccountInfo merAcc = merchantAccountHandler.getMerchantAccountByAccountAndAcctNo(reqDTO.getUserAccount(), reqDTO.getAcctNo());
        //账号只有解绑的状态下 才可以去更新状态 重新绑卡
        if (null != merAcc && !BindCardStatus.UN_BIND.getStatus().equals(merAcc.getBindStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "该账号状态不支持绑定操作");
        }

        //不支持绑定多张卡
        if ("0".equals(industry.getAbleBindMultiCard())) {
            if (accountStatus != AccountStatus.OPEN_UNBIND) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "账号" + accountStatus.getValue() + "，不能绑定");
            }
            // 解决个体户解绑后不能再绑的bug(其实是业务调整变更)。 解绑后不需要变更账户审核状态，绑卡时也不需要校验账户审核状态
            //20201009:删除绑卡时校验账户审核状态
        } else {
            //判断是否为第一次上送
            if (StringUtil.isBlank(merchantInfo.getBusLicPic())) {
                if (!(accountStatus == AccountStatus.OPEN_BIND || accountStatus == AccountStatus.OPEN_UNBIND)) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "账号" + accountStatus.getValue() + "，不能绑定");
                }
                // 解决个体户解绑后不能再绑的bug(其实是业务调整变更)。 解绑后不需要变更账户审核状态，绑卡时也不需要校验账户审核状态
                //20201009:删除绑卡时校验账户审核状态
            }
        }

        Account merAccount = accountHandler.queryAccountByUserAccount(merchantInfo.getAccount());

        CardBinInfo cardBinInfo = tradeContext.getAttribute(CARD_BIN_INFO_KEY);
        //请求渠道
        OneBankBindReq.OneBankAccountVerificationReq oneBankAccountVerificationReq = new OneBankBindReq.OneBankAccountVerificationReq();
        oneBankAccountVerificationReq.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        oneBankAccountVerificationReq.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        if (AuthenticationMode.THREE.getMode().equals(industry.getAuthenticationMode())) {
            oneBankAccountVerificationReq.setVerifyType("3");
        } else {
            oneBankAccountVerificationReq.setVerifyType("4");
            oneBankAccountVerificationReq.setPhone(reqDTO.getMobile());
        }
        oneBankAccountVerificationReq.setVerifyAcctType("0");
        oneBankAccountVerificationReq.setAcctNo(reqDTO.getAcctNo());
        oneBankAccountVerificationReq.setAcctName(merchantInfo.getRealName());
        oneBankAccountVerificationReq.setIdCode(merchantInfo.getIdCode());
        oneBankAccountVerificationReq.setIdType(merchantInfo.getIdType());
        oneBankAccountVerificationReq.setForceOuterValidate("0");
        oneBankAccountVerificationReq.setCardType("D");
        oneBankAccountVerificationReq.setCcy("CNY");
        oneBankAccountVerificationReq.setLwhbh(cardBinInfo.getClearbankno());
        oneBankAccountVerificationReq.setAcctType("01");
        //资金账户
        oneBankAccountVerificationReq.setCustomerNo(merAccount.getFundAccount());
        oneBankAccountVerificationReq.setPersonCode("8888");
        OneBankBindReq oneBankBindReq = new OneBankBindReq();
        oneBankBindReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankBindReq.setAcctNo(reqDTO.getAcctNo());
        oneBankBindReq.setAcctType("3");
        oneBankBindReq.setOneBankAccountVerificationReq(oneBankAccountVerificationReq);
        oneBankBindReq.setTradeDate(oneBankAccountVerificationReq.getReqDate());
        oneBankBindReq.setTradeTime(oneBankAccountVerificationReq.getReqTime());
        oneBankBindReq.setFundAccType(FundAccType.INNER_ACC);
        ChannelResponseDTO channelResponseDTO = paymentService.bind(oneBankBindReq);

        if (HttpRespStatus.OK.valueStr().equals(channelResponseDTO.getStatus())) {
            MerchantInfo updateMerchantInfo = MerchantInfo.builder().account(merchantInfo.getAccount())
                    .busLicCode(reqDTO.getBusinessLicenseNo())
                    .authCallBack(reqDTO.getCallbackUrl())
                    .status(AccountStatus.OPEN_BIND.getCode().toString())
                    .gmtModified(new Date())
                    .build();

            //判断是否为第一次上送
            if (StringUtil.isBlank(merchantInfo.getBusLicPic())) {
                updateMerchantInfo.setAuthStatus(MerAuthStatus.PENDING_REVIEW.getCode());
            }

            if (StringUtil.isNoneBlank(reqDTO.getBusinessLicensePic())) {
                updateMerchantInfo.setBusLicPic(pictureService.base64ContentToFile(reqDTO.getBusinessLicensePic(), merchantInfo.getIndustryCode(), merchantInfo.getAccount(), FileType.JPG));
            }

            MerchantAccountInfo merchantAccountInfo = null;
            if (merAcc == null) {
                merchantAccountInfo = MerchantAccountInfo.builder()
                        .account(merchantInfo.getAccount())
                        .merNo(merAccount.getObjCode())
                        .accountNo(reqDTO.getAcctNo())
                        .accountType(AccountType.PRIVATE.getCode())
                        .accountName(merchantInfo.getRealName())
                        .bankCode(cardBinInfo.getBankcode())
                        .bankName(cardBinInfo.getBankname())
                        .receiveBankCode(cardBinInfo.getClearbankno())
                        .bindStatus(BindCardStatus.NORMAL.getStatus())
                        .gmtCreate(new Date())
                        .reqBindDate(new Date())
                        .build();

            } else {
                // 卡号存在且为解绑状态，则更新，小额打款金额=0，绑卡状态-正常，验证次数=0，绑卡时间-当前，冻结时间-清除
                merchantAccountInfo = merAcc;
                merchantAccountInfo.setAuthAmt(0L);
                merchantAccountInfo.setBindStatus(BindCardStatus.NORMAL.getStatus());
                merchantAccountInfo.setAuthCount(0);
                merchantAccountInfo.setReqBindDate(new Date());
                merchantAccountInfo.setGmtModified(new Date());
            }

            BindBo bindBo = new BindBo();
            bindBo.setMerchantAccountInfo(merchantAccountInfo);
            bindBo.setMerchantInfo(updateMerchantInfo);
            accountHandler.bindMerchantAndMerAcc(bindBo);
        }
        return channelResponseDTO;
    }

    @Override
    protected void verifyReqParam(TradeContext<AuthBindSelfemployedReqDTO, AuthBindSelfemployedRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        AuthBindSelfemployedReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getAcctNo(), 32, true, "账号");
        ValidateUtils.abcValid(reqDTO.getAcctNo(), true, "帐号");
        ValidateUtils.abcValid(reqDTO.getVerifyType(), false, "验证类型");
        ValidateUtils.maxLength(reqDTO.getVerifyType(), 1, false, "验证类型");
        ValidateUtils.maxLength(reqDTO.getRemark(), 100, false, "备注/附言");
        ValidateUtils.validBicCode(reqDTO.getBusinessLicenseNo());

        ValidateUtils.isHttpUrl(reqDTO.getCallbackUrl(), true, "回调地址");
        ValidateUtils.maxLength(reqDTO.getCallbackUrl(), 200, true, "回调地址");

        CardBinInfo cardBinInfo = cardBinHandler.getCardBinInfo(reqDTO.getAcctNo());
        if (cardBinInfo == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]的卡BIN信息", reqDTO.getAcctNo()));
        }
        if (StringUtils.isBlank(cardBinInfo.getClearbankno())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的清算行号", reqDTO.getAcctNo()));
        }
        if (StringUtils.isBlank(cardBinInfo.getBankcode())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行号", reqDTO.getAcctNo()));
        }
        if (StringUtils.isBlank(cardBinInfo.getBankname())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行名", reqDTO.getAcctNo()));
        }
        tradeContext.setAttribute(CARD_BIN_INFO_KEY, cardBinInfo);

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
        if (AuthenticationMode.THREE.getMode().equals(industry.getAuthenticationMode())) {
            //不需要验证手机号码
            ValidateUtils.maxLength(reqDTO.getMobile(), 19, false, "手机号码");
        } else {
            ValidateUtils.mobileValid(reqDTO.getMobile(), true, "手机号码");
        }

        //支持绑定多张卡
        if ("1".equals(industry.getAbleBindMultiCard())) {
            //第一次上送需要校验图片
            MerchantInfo merchantInfo = accountHandler.findMerchantByAccountAll(reqDTO.getUserAccount());
            if (merchantInfo == null) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未开户");
            }
            if (StringUtil.isBlank(merchantInfo.getBusLicPic())) {
                ValidateUtils.hasText(reqDTO.getBusinessLicensePic(), "营业执照图片");
            }
        } else {
            ValidateUtils.hasText(reqDTO.getBusinessLicensePic(), "营业执照图片");
        }
        tradeContext.setAttribute(CUR_INDUSTRY, industry);
    }

    @Override
    public void initTransFlow(TradeContext<AuthBindSelfemployedReqDTO, AuthBindSelfemployedRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<AuthBindSelfemployedReqDTO, AuthBindSelfemployedRespDTO> tradeContext) {

    }
}
