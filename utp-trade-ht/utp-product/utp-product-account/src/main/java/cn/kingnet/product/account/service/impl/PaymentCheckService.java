package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.api.IPaymentCheckHandler;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.bo.BindBo;
import cn.kingnet.utp.service.persistence.entity.bo.PaymentCheckBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.PaymentCheckReqDTO;
import cn.kingnet.utp.trade.common.dto.account.PaymentCheckRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description 对公小额打款验证
 * @Author caixh
 * @Date 2020/3/23.
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.PAYMENT_CHECK,
        reqClass = PaymentCheckReqDTO.class,
        respClass = PaymentCheckRespDTO.class
)
@Slf4j
public class PaymentCheckService extends AbstractAccountTradeService<PaymentCheckReqDTO, PaymentCheckRespDTO> {

    @Resource
    private IMerchantAccountHandler merchantAccountHandler;
    @Resource
    private IPaymentCheckHandler paymentCheckHandler;

    public PaymentCheckService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    /**
     * 请求渠道
     * @param tradeContext 交易上下文
     * @return 渠道响应DTO
     */
    @Override
    public ChannelResponseDTO reqChannel(TradeContext<PaymentCheckReqDTO, PaymentCheckRespDTO> tradeContext) {
        PaymentCheckReqDTO reqDTO = tradeContext.getRequestDTO();
        MerchantAccountInfo merchantAccountInfo = merchantAccountHandler.getMerchantAccountByAccountAndAcctNo(reqDTO.getUserAccount(), reqDTO.getAcctNo());
        if (null == merchantAccountInfo) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "商户账户信息不匹配");
        }

        PaymentCheckRespDTO respDTO = new PaymentCheckRespDTO();
        respDTO.setBindStatus(merchantAccountInfo.getBindStatus());

        //状态校验
        BindCardStatus merchantAccountStatus = BindCardStatus.getBindCardStatus(merchantAccountInfo.getBindStatus());
        if (null == merchantAccountStatus) {
            return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, "未知的绑卡状态[" + merchantAccountInfo.getBindStatus() + "]，交易失败");
        }

        //3-打款成功，待验证 和 4-验证失败 和 5-冻结 才进行校验，其它状态一律返回失败
        if (!(BindCardStatus.WAITING_AUTH.equals(merchantAccountStatus) || BindCardStatus.AUTH_FAILURE.equals(merchantAccountStatus))) {
            switch (merchantAccountStatus) {
                case FAILURE:
                    respDTO.setErrCode(merchantAccountInfo.getChannelRespCode());
                    respDTO.setErrMsg(merchantAccountInfo.getChannelRespMsg());
                    return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, "打款失败，交易失败");
                case NORMAL:
                    return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, "已经验证通过，无需重复验证");
                case FROZEN:
                    return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, "验证次数>=" + this.productAccountProperties.getMaxCardAuthCount() + "次，验证失败");
                case PROCESSING:
                    return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, "打款处理中，交易失败");
                case UN_BIND:
                    return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, "处于解绑状态，交易失败");
                default: {
                    return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, "未知的绑卡状态，交易失败");
                }
            }
        }

        BindBo bo = new BindBo();
        if (Integer.parseInt(reqDTO.getAuthAmt()) == merchantAccountInfo.getAuthAmt().intValue()) {
            //校验成功
            //更新商户账户状态，检查商户状态
            BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

            MerchantAccountInfo updateMerchantAccountInfo = MerchantAccountInfo.builder()
                    .account(reqDTO.getUserAccount())
                    .accountNo(reqDTO.getAcctNo())
                    .bindStatus(BindCardStatus.NORMAL.getStatus())
                    .gmtModified(new Date()).build();
            bo.setMerchantAccountInfo(updateMerchantAccountInfo);
            if (AccountStatus.OPEN_UNBIND.getCode() == Integer.parseInt(basicConfigInfo.getUserAccountStatus())) {
                //商户未绑卡 须更新状态
                MerchantInfo updateMerchantInfo = MerchantInfo.builder()
                        .account(reqDTO.getUserAccount())
                        .status(AccountStatus.OPEN_BIND.getCode().toString())
                        .gmtModified(new Date()).build();
                bo.setMerchantInfo(updateMerchantInfo);
            }
        } else {
            //校验失败
            String errMsg = "金额不匹配，验证失败";
            int authCount = merchantAccountInfo.getAuthCount() + 1;
            MerchantAccountInfo.MerchantAccountInfoBuilder builder = MerchantAccountInfo.builder()
                    .account(reqDTO.getUserAccount())
                    .accountNo(reqDTO.getAcctNo())
                    .authCount(authCount)
                    .bindStatus(BindCardStatus.AUTH_FAILURE.getStatus())
                    .gmtModified(new Date());

            if (authCount >= this.productAccountProperties.getMaxCardAuthCount()) {
                //校验失败次数
                builder.bindStatus(BindCardStatus.FROZEN.getStatus()).freezeDate(new Date());
                errMsg = String.format("验证次数>=%s次，验证失败", this.productAccountProperties.getMaxCardAuthCount());
            }
            bo.setMerchantAccountInfo(builder.build());
            accountHandler.authMerchantAccount(bo);
            if (bo.getMerchantAccountInfo().getBindStatus().equals(BindCardStatus.FROZEN.getStatus())) {
                //绑卡验证失败超过3次后，状态变更为冻结，发送通知
                sendNotify(tradeContext.getIndustryCode(), tradeContext.getServerTransId(), reqDTO, respDTO, BindCardStatus.FROZEN.getStatus());
            }
            respDTO.setBindStatus(bo.getMerchantAccountInfo().getBindStatus());
            return ChannelResponseUtil.fail(respDTO, HttpRespStatus.FORBIDDEN, errMsg);
        }
        accountHandler.authMerchantAccount(bo);
        //打款成功，待验证发送通知
        if (bo.getMerchantAccountInfo().getBindStatus().equals(BindCardStatus.WAITING_AUTH.getStatus())) {
            sendNotify(tradeContext.getIndustryCode(), tradeContext.getServerTransId(), reqDTO, respDTO, BindCardStatus.WAITING_AUTH.getStatus());
        }
        respDTO.setBindStatus(bo.getMerchantAccountInfo().getBindStatus());
        return ChannelResponseUtil.success(respDTO, null, null);
    }

    /**
     * 验证请求参数
     * @param tradeContext 交易上下文
     */
    @Override
    protected void verifyReqParam(TradeContext<PaymentCheckReqDTO, PaymentCheckRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        PaymentCheckReqDTO reqDTO = tradeContext.getRequestDTO();

        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");

        ValidateUtils.hasText(reqDTO.getAcctNo(), "账号不能为空");
        ValidateUtils.isPositiveInteger(reqDTO.getAuthAmt(), 15, true, "鉴权金额");

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, reqDTO.getUserAccount());

        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        if (!TrueOrFalseStatus.TRUE.value().equals(basicConfigInfo.getNeedPublicAuthAmt())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "代付客户未启用小额打款验证");
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(basicConfigInfo.getUserIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }
    }

    /**
     * 小额打款验证绑卡状态变化通知
     * @param industryCode
     * @param serverTransId
     * @param reqDTO
     * @param respDTO
     */
    public void sendNotify(String industryCode, String serverTransId, PaymentCheckReqDTO reqDTO, PaymentCheckRespDTO respDTO, String bindStatus) {
        PaymentCheckBo paymentCheckBo = new PaymentCheckBo();
        paymentCheckBo.setIndustryCode(industryCode);
        paymentCheckBo.setServerTransId(serverTransId);
        paymentCheckBo.setUserAccount(reqDTO.getUserAccount());
        paymentCheckBo.setAcctNo(reqDTO.getAcctNo());
        paymentCheckBo.setBindStatus(bindStatus);
        paymentCheckBo.setErrCode(respDTO.getErrCode());
        paymentCheckBo.setErrMsg(respDTO.getErrMsg());
        LambdaLogger.debug(log, log -> log.debug("小额打款验证绑卡状态变化通知，请求参数==>{}", JSON.toJSONString(paymentCheckBo)));
        ServerResponseDTO responseDTO = paymentCheckHandler.notify(paymentCheckBo);
        if (!responseDTO.getStatus().equals(HttpRespStatus.OK.valueStr())) {
            log.error("服务端流水号{}，卡号{}，小额打款验证绑卡状态变化通知异常==>{}", serverTransId, reqDTO.getAcctNo(), responseDTO.getMessage());
            throw new ProductException(HttpRespStatus.SERVER_ERROR, "小额打款验证绑卡状态变化通知异常");
        }
    }

    /**
     * 初始化流水
     * @param tradeContext 交易上下文
     */
    @Override
    public void initTransFlow(TradeContext<PaymentCheckReqDTO, PaymentCheckRespDTO> tradeContext) {

    }

    /**
     * 更新流水
     * @param tradeContext 交易上下文
     */
    @Override
    public void updateTransFlow(TradeContext<PaymentCheckReqDTO, PaymentCheckRespDTO> tradeContext) {

    }
}
