package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.product.account.service.inner.AuthBindEntRandomAmtPaymentService;
import cn.kingnet.product.account.service.inner.PictureService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.bo.BindBo;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.AuthBindEntReqDTO;
import cn.kingnet.utp.trade.common.dto.account.AuthBindEntRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Description: 企业证件认证鉴权绑卡
 * @Author sheqingquan@scenetec.com
 * @Create 2019/5/29 16:29
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.AUTH_BIND_ENT,
        reqClass = AuthBindEntReqDTO.class,
        respClass = AuthBindEntRespDTO.class
)
public class AuthBindEntService extends AbstractAccountTradeService<AuthBindEntReqDTO, AuthBindEntRespDTO> {

    protected static final String PAY_AMT_KEY = "PAY_AMT_KEY";

    protected static final String merchant_Account_info_key = "merchant_Account_info_key";

    @Resource
    protected ITransCurrentHandler transCurrentHandler;

    @Resource
    protected IChannelRelevantHandler channelRelevantHandler;

    @Resource
    protected IMerchantAccountHandler merchantAccountHandler;

    @Resource
    protected AuthBindEntRandomAmtPaymentService authBindEntRandomAmtPaymentService;

    @Resource
    protected IClearBankCodeHandler clearBankCodeHandler;

    @Resource
    protected PictureService pictureService;

    public AuthBindEntService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<AuthBindEntReqDTO, AuthBindEntRespDTO> tradeContext) {
        AuthBindEntReqDTO authBindEntReqDTO = tradeContext.getRequestDTO();
        MerchantInfo merchantInfo = tradeContext.getAttribute(AuthBindEntRandomAmtPaymentService.MERCHANT_INFO_KEY);
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        MerchantAccountInfo tempMerchantAccountInfo = tradeContext.getAttribute(merchant_Account_info_key);
        AccountType payeeAccType = tradeContext.getAttribute(AuthBindEntRandomAmtPaymentService.PAYEE_ACC_TYPE);
        //商户信息
        MerchantInfo updateMerchantInfo = MerchantInfo.builder()
                .authCallBack(authBindEntReqDTO.getCallbackUrl())
                .account(merchantInfo.getAccount())
                .realName(authBindEntReqDTO.getAcctName())
                .gmtModified(new Date())
                .build();

        //图片特殊处理
        if (StringUtil.isBlank(merchantInfo.getPersonPic())) {
            updateMerchantInfo.setPersonPic(pictureService.base64ContentToFile(authBindEntReqDTO.getPersonPicA(), merchantInfo.getIndustryCode(), merchantInfo.getAccount(), FileType.JPG));
        }
        if (StringUtil.isBlank(merchantInfo.getPersonReversePic())) {
            updateMerchantInfo.setPersonReversePic(pictureService.base64ContentToFile(authBindEntReqDTO.getPersonPicB(), merchantInfo.getIndustryCode(), merchantInfo.getAccount(), FileType.JPG));
        }
        if (StringUtil.isBlank(merchantInfo.getBusLicPic())) {
            updateMerchantInfo.setBusLicPic(pictureService.base64ContentToFile(authBindEntReqDTO.getBusinessLicensePic(), merchantInfo.getIndustryCode(), merchantInfo.getAccount(), FileType.JPG));
            updateMerchantInfo.setLicensePic(pictureService.base64ContentToFile(authBindEntReqDTO.getLicensePic(), merchantInfo.getIndustryCode(), merchantInfo.getAccount(), FileType.JPG));
        }

        if (MerAuthStatus.PENDING_AUTH.getCode().equals(merchantInfo.getAuthStatus())) {
            updateMerchantInfo.setAuthStatus(MerAuthStatus.PENDING_REVIEW.getCode());
        }

        //商户绑卡信息
        Date nowDate = new Date();
        MerchantAccountInfo merchantAccountInfo = MerchantAccountInfo.builder()
                .account(merchantInfo.getAccount())
                .merNo(merchantInfo.getMerNo())
                .accountNo(authBindEntReqDTO.getAcctNo())
                .accountType(payeeAccType.getCode())
                .accountName(authBindEntReqDTO.getAcctName())
                .bankCode(authBindEntReqDTO.getOpBankCode())
                .bankName(authBindEntReqDTO.getOpBankName())
                .receiveBankCode(authBindEntReqDTO.getClBankCode())
                .authCount(0)
                .reqBindDate(nowDate)
                .build();

        //需要小额打款验证的
        if (TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getNeedPublicAuthAmt())) {
            long payAmt = tradeContext.getAttribute(PAY_AMT_KEY);
            merchantAccountInfo.setAuthAmt(payAmt);
            merchantAccountInfo.setBindStatus(BindCardStatus.PROCESSING.getStatus());
            merchantAccountInfo.setChannelRespCode(OneBankRespCode.PCC00000.name());
            merchantAccountInfo.setChannelRespMsg("打款处理中");
        } else {//不需要小额打款验证的
            updateMerchantInfo.setStatus(AccountStatus.OPEN_BIND.getCode().toString());
            merchantAccountInfo.setAuthAmt(0L);
            merchantAccountInfo.setBindStatus(BindCardStatus.NORMAL.getStatus());
            merchantAccountInfo.setChannelRespCode(OneBankRespCode.PCC00000.name());
            merchantAccountInfo.setChannelRespMsg("绑卡成功!");
        }

        if (tempMerchantAccountInfo != null && StringUtil.isNotBlank(tempMerchantAccountInfo.getAccount())) {
            merchantAccountInfo.setGmtModified(nowDate);
        } else {
            merchantAccountInfo.setGmtCreate(nowDate);
            merchantAccountInfo.setGmtModified(nowDate);
        }

        BindBo bindBo = new BindBo();
        bindBo.setMerchantInfo(updateMerchantInfo);
        bindBo.setMerchantAccountInfo(merchantAccountInfo);

        //保存绑卡信息
        accountHandler.bindMerchantAndMerAcc(bindBo);

        if (TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getNeedPublicAuthAmt())) {
            //需要小额打款验证处理
            ChannelResponseDTO channelResponseDTO = null;
            try {
                channelResponseDTO = authBindEntRandomAmtPaymentService.randomAmtPayment(tradeContext, merchantAccountInfo, basicConfigInfo);
            } catch (Exception e) {
                channelResponseDTO = authBindEntRandomAmtPaymentService.exceptionHandler(tradeContext, e);
                logger.error("流水号:{} >> 打款验证调用渠道异常:{}", tradeContext.getServerTransId(), e.getMessage(), e);
            }
            try {
                if (channelResponseDTO != null) {
                    HttpRespStatus httpRespStatus = HttpRespStatus.valueOf(Integer.valueOf(channelResponseDTO.getStatus()));
                    if (!(httpRespStatus.is2xxSuccessful() || httpRespStatus.is3xxRedirection())) {
                        MerchantAccountInfo updateMerchantAccountInfo = MerchantAccountInfo.builder()
                                .account(merchantInfo.getAccount())
                                .accountNo(authBindEntReqDTO.getAcctNo())
                                .bindStatus(BindCardStatus.FAILURE.getStatus())
                                .channelRespCode(channelResponseDTO.getChannelRespCode())
                                .channelRespMsg(channelResponseDTO.getMessage())
                                .gmtModified(new Date())
                                .build();
                        merchantAccountHandler.updateMerchantAccountInfo(updateMerchantAccountInfo);
                    }
                }
            } catch (Exception e) {
                logger.error("流水号:{} >> 企业鉴权绑卡渠道返回[httpRespStatus={}],更新账户状态异常:{}", tradeContext.getServerTransId(), channelResponseDTO.getStatus(), e.getMessage(), e);
            }
            return channelResponseDTO;
        } else {
            AuthBindEntRespDTO authBindEntRespDTO = new AuthBindEntRespDTO();
            authBindEntRespDTO.setClientTradeId(tradeContext.getClientTradeId());
            authBindEntRespDTO.setServerTradeId(tradeContext.getServerTransId());
            return ChannelResponseUtil.success(authBindEntRespDTO, null, null);
        }
    }

    @Override
    protected void verifyReqParam(TradeContext<AuthBindEntReqDTO, AuthBindEntRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        AuthBindEntReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");

        ValidateUtils.abcValid(reqDTO.getAcctNo(), true, "帐号");
        ValidateUtils.maxLength(reqDTO.getAcctNo(), 32, true, "账号");

        ValidateUtils.maxLength(reqDTO.getAcctName(), 100, true, "账户名称");

        ValidateUtils.abcValid(reqDTO.getOpBankCode(), true, "开户行号");
        ValidateUtils.maxLength(reqDTO.getOpBankCode(), 32, true, "开户行号");

        ValidateUtils.maxLength(reqDTO.getOpBankName(), 100, true, "开户行名称");

        ValidateUtils.abcValid(reqDTO.getClBankCode(), false, "清算行号");
        ValidateUtils.maxLength(reqDTO.getClBankCode(), 32, false, "清算行号");

        ValidateUtils.isHttpUrl(reqDTO.getCallbackUrl(), true, "回调地址");
        ValidateUtils.maxLength(reqDTO.getCallbackUrl(), 200, true, "回调地址");

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

        Integer openAccountMode = basicConfigInfo.getOpenAccountMode();
        if(openAccountMode==null || OpenAccountMode.BIND.getCode().intValue()!=openAccountMode){
            throw new ProductException(HttpRespStatus.FORBIDDEN,"该平台暂不支持该鉴权绑卡模式");
        }

        //清算行号
        String clBankCode = clearBankCodeHandler.getClearBankCode(reqDTO.getOpBankCode());
        if (StringUtil.isBlank(reqDTO.getClBankCode())) {
            if (StringUtil.isBlank(clBankCode)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "系统查无匹配的开户行!");
            } else {
                tradeContext.getRequestDTO().setClBankCode(clBankCode);
            }
        } else {
            if (StringUtil.isNotBlank(clBankCode) && !reqDTO.getClBankCode().equals(clBankCode)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("开户行%s,对应的清算行号为%s!", reqDTO.getOpBankCode(), clBankCode));
            }
        }

        //获取用户信息
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccountAll(reqDTO.getUserAccount());
        if (merchantInfo == null || StringUtils.isBlank(merchantInfo.getAccount())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未开户!");
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        if (!UserType.MER.getType().equals(merchantInfo.getUserType())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不允许此操作");
        }

        if (StringUtil.isBlank(merchantInfo.getPersonPic())) {
            ValidateUtils.hasText(reqDTO.getPersonPicA(), "法人证件正面图片照");
        }
        if (StringUtil.isBlank(merchantInfo.getPersonReversePic())) {
            ValidateUtils.hasText(reqDTO.getPersonPicB(), "法人证件反面照图片");
        }
        if (StringUtil.isBlank(merchantInfo.getBusLicPic())) {
            ValidateUtils.hasText(reqDTO.getBusinessLicensePic(), "营业执照图片");
        }

        AccountStatus accountStatus = AccountStatus.getEnum(Integer.valueOf(merchantInfo.getStatus()));

        if (!(accountStatus == AccountStatus.OPEN_UNBIND || accountStatus == AccountStatus.OPEN_BIND)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "账号" + accountStatus.getValue() + "，不能绑卡操作");
        }



        if (VirtualAccountType.BROKERAGE.getType().equals(merchantInfo.getNature())) {
            //验证 佣金账户绑卡的 账号及账户名称 要与 客户号设置一致
            if (!reqDTO.getAcctName().equals(basicConfigInfo.getEntName()) || !reqDTO.getAcctNo().equals(basicConfigInfo.getIndustryAccountNo())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "佣金账户的账号及账户名称必须与客户号的账号及企业名称一致!");
            }
        } else {
            //20200831 去除限制规则：企业账户的账号及账户名称不能与客户号的账号及企业名称一致；开户中改规则限制已经去除了。
            if (!StringUtil.contains(reqDTO.getAcctName(), merchantInfo.getMerName())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "账户名称不符合!");
            }
        }

        //获取用户绑卡列表
        List<MerchantAccountInfo> acctList = merchantAccountHandler.getMerchantAccountsByAccountAndAcctNo(reqDTO.getUserAccount(), null);
        //不支持绑多张卡
        if (!TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getAbleBindMultiCard())) {
            if (!CollectionUtils.isEmpty(acctList)) {
                long normalSize = acctList.stream().filter(acctInfo -> {
                    if (BindCardStatus.NORMAL.getStatus().equals(acctInfo.getBindStatus())) {
                        return true;
                    } else if (BindCardStatus.PROCESSING.getStatus().equals(acctInfo.getBindStatus())) {
                        return true;
                    } else if (BindCardStatus.WAITING_AUTH.getStatus().equals(acctInfo.getBindStatus())) {
                        return true;
                    } else if (BindCardStatus.FROZEN.getStatus().equals(acctInfo.getBindStatus())) {
                        return true;
                    } else if (BindCardStatus.AUTH_FAILURE.getStatus().equals(acctInfo.getBindStatus())) {
                        return true;
                    }
                    return false;
                }).count();
                if (normalSize > 0) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "不支持绑定多张卡!");
                }
            }
        }

        if (!CollectionUtils.isEmpty(acctList)) {
            MerchantAccountInfo merchantAccountInfo = acctList.stream().filter(acctInfo -> reqDTO.getAcctNo().equals(acctInfo.getAccountNo())).findFirst().orElse(null);
            if (merchantAccountInfo != null) {
                if (BindCardStatus.NORMAL.getStatus().equals(merchantAccountInfo.getBindStatus())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "账号已绑卡，不能重复绑定!");
                } else if (BindCardStatus.PROCESSING.getStatus().equals(merchantAccountInfo.getBindStatus())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "打款处理中，不能重复绑定!");
                } else if (BindCardStatus.WAITING_AUTH.getStatus().equals(merchantAccountInfo.getBindStatus())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "打款成功，待验证，不能重复绑定!");
                } else if (BindCardStatus.FROZEN.getStatus().equals(merchantAccountInfo.getBindStatus())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "该卡冻结，暂不能绑定!");
                } else if (BindCardStatus.AUTH_FAILURE.getStatus().equals(merchantAccountInfo.getBindStatus())) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "验证失败，暂不能绑定!");
                }
            }
            tradeContext.setAttribute(merchant_Account_info_key, merchantAccountInfo);
        }

        AccountType payeeAccType = AccountType.PUBLIC;
        //需要对公打款验证时
        if (TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getNeedPublicAuthAmt())) {
            //校验平台账户是否冻结
            if (null != basicConfigInfo.getAccountStatus() && basicConfigInfo.getAccountStatus().equals(VirtualAccountStatus.FREEZE.getType())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN.value(), "代付客户冻结状态下无法进行出金操作");
            }

            if (StringUtil.isBlank(basicConfigInfo.getAuthPaymentAccount())) {
                throw new TradeException(HttpRespStatus.FORBIDDEN, "代付客户未配置小额打款支出账户!");
            }

            //交易客户端流水不能重复：当天交易流水检验
            boolean existClientId = transCurrentHandler.existIndustryAndClientTransIdOrServerTransId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getClientTradeId(), null);
            if (existClientId) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
            }

            //资金账户类型
            FundAccType payerFundAccType = FundAccType.resolve(basicConfigInfo.getFundAccType());
            if (null == payerFundAccType) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("付款方归属资金账户类型[%s]错误", basicConfigInfo.getFundAccType()));
            }

            //获取渠道配置信息||实时代付仅支持 银联代付
            String trandeDateTime = tradeContext.getTransDate().concat(tradeContext.getTransTime());
            //随机金额
            Random random = new Random();
            long payAmt = random.nextInt(50) + 1;

            //获取渠道配置
            ChannelInfoBO channelInfoBO = channelRelevantHandler.selectChannelInfoBo(basicConfigInfo.getIndustryCode(), basicConfigInfo.getProductNo(), payeeAccType.getCode(), payAmt, trandeDateTime);

            tradeContext.setAttribute(AuthBindEntRandomAmtPaymentService.PAYER_FUNDACC_TYPE, payerFundAccType);
            tradeContext.setAttribute(PAY_AMT_KEY, payAmt);
            tradeContext.setAttribute(AuthBindEntRandomAmtPaymentService.CHANNEL_INFO_BO_KEY, channelInfoBO);
        }
        tradeContext.setAttribute(AuthBindEntRandomAmtPaymentService.PAYEE_ACC_TYPE, payeeAccType);
        tradeContext.setAttribute(AuthBindEntRandomAmtPaymentService.MERCHANT_INFO_KEY, merchantInfo);
    }

    @Override
    public void initTransFlow(TradeContext<AuthBindEntReqDTO, AuthBindEntRespDTO> tradeContext) {
    }

    @Override
    public void updateTransFlow(TradeContext<AuthBindEntReqDTO, AuthBindEntRespDTO> tradeContext) {

    }
}
