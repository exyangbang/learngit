package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
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
import cn.kingnet.utp.trade.common.dto.account.BindReqDTO;
import cn.kingnet.utp.trade.common.dto.account.BindRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankBindReq;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 鉴权绑卡
 * @author zhongli
 * @date 2019-02-21
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.BIND,
        reqClass = BindReqDTO.class,
        respClass = BindRespDTO.class,
        createTransFlow = true,
        successTransStatus = TransStatus.TRADE_SUCCESS
)
public class BindService extends AbstractAccountTradeService<BindReqDTO, BindRespDTO> {


    @Resource
    private IAccountHandler accountHandler;
    @Resource
    private IPaymentService paymentService;
    @Resource
    private ICardBinHandler cardBinHandler;
    @Resource
    private IMerchantAccountHandler merchantAccountHandler;

    private final static String CUR_INDUSTRY = "CUR_INDUSTRY";
    private final static String MER_ACCOUNT = "MER_ACCOUNT";

    public BindService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties,basicConfigHandler,productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<BindReqDTO, BindRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        BindReqDTO req = tradeContext.getRequestDTO();
        ValidateUtils.maxLength(req.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.abcValid(req.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(req.getAcctNo(), 32, true, "账号");
        ValidateUtils.abcValid(req.getAcctNo(), true, "账号");
        ValidateUtils.abcValid(req.getVerifyType(), false, "验证类型");
        ValidateUtils.maxLength(req.getVerifyType(), 1, false, "验证类型");
        ValidateUtils.maxLength(req.getRemark(), 100, false, "备注/附言");

        CardBinInfo cardBinInfo = cardBinHandler.getCardBinInfo(req.getAcctNo());
        if (cardBinInfo == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]的卡BIN信息", req.getAcctNo()));
        }
        if (StringUtils.isBlank(cardBinInfo.getClearbankno())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的清算行号", req.getAcctNo()));
        }
        if (StringUtils.isBlank(cardBinInfo.getBankcode())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行号", req.getAcctNo()));
        }
        if (StringUtils.isBlank(cardBinInfo.getBankname())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("平台未找到acctNo[%s]卡BIN的开户行名", req.getAcctNo()));
        }
        req.setClBankCode(cardBinInfo.getClearbankno());
        req.setOpBankCode(cardBinInfo.getBankcode());
        req.setOpBankName(cardBinInfo.getBankname());

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
            ValidateUtils.maxLength(req.getMobile(), 19, false, "手机号码");
        } else {
            ValidateUtils.mobileValid(req.getMobile(), true, "手机号码");
        }

        //查询是否已经绑卡且正常使用
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccountAll(req.getUserAccount());

        if (merchantInfo == null || StringUtils.isBlank(merchantInfo.getAccount())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未开户!");
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        if (!UserType.ONE.getType().equals(merchantInfo.getUserType())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不允许此操作");
        }
        //不支持绑定多张卡
        if ("0".equals(industry.getAbleBindMultiCard())) {
            if (AccountStatus.OPEN_BIND.getCode().toString().equals(merchantInfo.getStatus())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "账号已绑卡，不能重复绑定");
            }
        }

        if (AccountStatus.CANCEL.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号已销户，不能绑定");
        }
        if (AccountStatus.FREEZE.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号已冻结，不能绑定");
        }
        if (!MerAuthStatus.NORMAL.getCode().equals(merchantInfo.getAuthStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "该账户未认证，不能绑定");
        }

        MerchantAccountInfo merchantAccountInfo = merchantAccountHandler.getMerchantAccountByAccountAndAcctNo(req.getUserAccount(), req.getAcctNo());
        //账号只有解绑的状态下 才可以去更新状态 重新绑卡
        if (null != merchantAccountInfo) {
            if (!BindCardStatus.UN_BIND.getStatus().equals(merchantAccountInfo.getBindStatus())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN, "该账号状态不支持绑定操作");
            }
            tradeContext.setAttribute(MER_ACCOUNT, merchantAccountInfo);
        }

        tradeContext.setAttribute("merchantinfo", merchantInfo);
        tradeContext.setAttribute(CUR_INDUSTRY, industry);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<BindReqDTO, BindRespDTO> tradeContext) {
        BindReqDTO req = tradeContext.getRequestDTO();
        Industry industry = tradeContext.getAttribute(CUR_INDUSTRY);
        OneBankBindReq.OneBankAccountVerificationReq oneBankReq = new OneBankBindReq.OneBankAccountVerificationReq();
        BeanUtils.copyProperties(req, oneBankReq);
        MerchantInfo merchantInfo = tradeContext.getAttribute("merchantinfo");
        Account account = tradeContext.getAttribute("user_account");
        oneBankReq.setAcctName(merchantInfo.getRealName());
        oneBankReq.setIdCode(merchantInfo.getIdCode());
        oneBankReq.setIdType(merchantInfo.getIdType());
        oneBankReq.setReqDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        oneBankReq.setReqTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")));
        oneBankReq.setVerifyAcctType("0");
        oneBankReq.setForceOuterValidate("0");
        if (AuthenticationMode.THREE.getMode().equals(industry.getAuthenticationMode())) {
            oneBankReq.setVerifyType("3");
        } else {
            oneBankReq.setVerifyType("4");
            oneBankReq.setPhone(req.getMobile());
        }
        oneBankReq.setCardType("D");
        oneBankReq.setCcy("CNY");
        oneBankReq.setLwhbh(req.getClBankCode());
        oneBankReq.setAcctType("01");
        //资金账户
        oneBankReq.setCustomerNo(account.getFundAccount());
        oneBankReq.setPersonCode("8888");

        OneBankBindReq oneBankBindReq = new OneBankBindReq();
        oneBankBindReq.setClientTradeId(tradeContext.getServerTransId());
        oneBankBindReq.setAcctNo(req.getAcctNo());
        oneBankBindReq.setAcctType("3");
        oneBankBindReq.setOneBankAccountVerificationReq(oneBankReq);
        oneBankBindReq.setTradeDate(oneBankReq.getReqDate());
        oneBankBindReq.setTradeTime(oneBankReq.getReqTime());
        oneBankBindReq.setFundAccType(FundAccType.INNER_ACC);
        ChannelResponseDTO resp = paymentService.bind(oneBankBindReq);
        return resp;
    }

    /**
     * -------------------------
     * |  查询虚拟账户是否已经绑卡 |
     * -------------------------
     * /                ＼
     * /                  ＼
     * -------------------------     ---------------
     * | 已经绑卡且正常使用，抛异常 |   | 未绑卡或已解绑 |
     * --------------------------    ———————————————
     * |
     * ------------------------------
     * |  调用渠道绑卡（华通账户验证接口）|
     * ------------------------------
     * @param tradeContext 交易上下文
     */

    @Override
    public void initTransFlow(TradeContext<BindReqDTO, BindRespDTO> tradeContext) {
        String userAccount = tradeContext.getRequestDTO().getUserAccount();
        // FundAccount fundAccount = industryHandler.getFundAccountByIndustryCode(tradeContext.getAuthInfo().getAuthNo());
        // FundAccType fundAccType = FundAccType.resolve(fundAccount.getAccountType());
        // if (fundAccType == null) {
        //     throw new ProductException(HttpRespStatus.BAD_REQUEST, "资金账户类型不能为空");
        // }
        //  默认就调对私||目前仅有RDFA有四要素认证
        // tradeContext.setAttribute("fundAccType", FundAccType.INNER_ACC);
        Account account = accountHandler.queryAccountByUserAccount(userAccount);
        tradeContext.setAttribute("user_account", account);
    }

    /**
     * ------------------------------
     * |  调用渠道绑卡（华通账户验证接口）|
     * ------------------------------
     * /         ＼
     * /           ＼
     * -----------       ----------------------------------------------
     * |   不通过   |     | 通过，如果已有绑卡信息，更新信息；新绑卡的创建信息 |
     * -----------       ----------------------------------------------
     * |
     * ----------------------------------------------
     * | 操作表t_merchant_info和t_merchant_account_info |
     * ----------------------------------------------
     * @param tradeContext 交易上下文
     */
    @Override
    public void updateTransFlow(TradeContext<BindReqDTO, BindRespDTO> tradeContext) {
        if (HttpRespStatus.OK.valueStr().equals(tradeContext.getResponseDTO().getStatus())) {
            BindReqDTO req = tradeContext.getRequestDTO();
            //虚拟账户
            String userAccount = req.getUserAccount();
            Account account = tradeContext.getAttribute("user_account");
            MerchantInfo merchantInfo = tradeContext.getAttribute("merchantinfo");

            MerchantAccountInfo merchantAccountInfo = tradeContext.getAttribute(MER_ACCOUNT);
            if (null != merchantAccountInfo) {
                // 卡号存在且为解绑状态，则更新，小额打款金额=0，绑卡状态-正常，验证次数=0，绑卡时间-当前，冻结时间-清除
                merchantAccountInfo.setAuthAmt(0L);
                merchantAccountInfo.setBindStatus(BindCardStatus.NORMAL.getStatus());
                merchantAccountInfo.setAuthCount(0);
                merchantAccountInfo.setReqBindDate(new Date());
                merchantAccountInfo.setGmtModified(new Date());
            } else {
                merchantAccountInfo = MerchantAccountInfo.builder()
                        .account(userAccount)
                        .merNo(account.getObjCode())
                        .accountNo(req.getAcctNo())
                        .accountType(AccountType.PRIVATE.getCode())
                        .accountName(merchantInfo.getRealName())
                        .bankCode(req.getOpBankCode())
                        .bankName(req.getOpBankName())
                        .receiveBankCode(req.getClBankCode())
                        .bindStatus(BindCardStatus.NORMAL.getStatus())
                        .gmtCreate(new Date())
                        .reqBindDate(new Date())
                        .build();
            }

            BindBo bindBo = new BindBo();
            bindBo.setMerchantAccountInfo(merchantAccountInfo);
            bindBo.setMerchantInfo(MerchantInfo.builder().status(AccountStatus.OPEN_BIND.getCode().toString()).build());
            accountHandler.bindMerchantAndMerAcc(bindBo);
        }
    }

}
