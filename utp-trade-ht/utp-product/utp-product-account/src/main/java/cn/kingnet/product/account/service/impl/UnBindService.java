package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IIndustryHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UnBindReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UnBindRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 解绑
 * @author zhongli
 * @date 2019-02-19
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UNBIND,
        reqClass = UnBindReqDTO.class,
        respClass = UnBindRespDTO.class
)
public class UnBindService extends AbstractAccountTradeService<UnBindReqDTO, UnBindRespDTO> {


    @Autowired
    private IAccountHandler accountHandler;
    @Autowired
    private IIndustryHandler industryHandler;
    @Autowired
    private IMerchantAccountHandler merchantAccountHandler;

    public UnBindService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties,basicConfigHandler,productAccountProperties);
    }
    /**
     * 校验资金账户对应的商户是否存在，不存在创建虚拟账户
     * <p>
     * -----------        -----------------------------------
     * | 解绑账户 | ==>  | 将表t_merchant_info 字段status改成2 |
     * ------------        ----------------------------------
     * </p>
     * @param tradeContext 交易上下文
     */
    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UnBindReqDTO, UnBindRespDTO> tradeContext) {
        UnBindReqDTO reqDTO = tradeContext.getRequestDTO();
        String userAccount = reqDTO.getUserAccount();
        String acctNo = reqDTO.getAcctNo();
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(userAccount);
        if(merchantInfo == null){
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("查无此账户[%s]", userAccount));
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }

        if (!(UserType.ONE.getType().equals(merchantInfo.getUserType()) || UserType.MER.getType().equals(merchantInfo.getUserType()))) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "该账户不允许此操作");
        }
        if (!AccountStatus.OPEN_BIND.getCode().toString().equals(merchantInfo.getStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未绑卡，不能解绑");
        }

        //支持绑定多张卡，账号不能为空
        Industry industry = industryHandler.getIndustryByCode(tradeContext.getAuthInfo().getAuthNo());
        if ("1".equals(industry.getAbleBindMultiCard())) {
            ValidateUtils.maxLength(reqDTO.getAcctNo(), 32, true, "账号");
        }

        //支持绑定多张卡，查询商户账户状态，只有0-正常状态的才可以解绑
        MerchantAccountInfo merchantAccountInfo = merchantAccountHandler.getMerchantAccountByAccountAndAcctNo(userAccount, acctNo);
        if (null == merchantAccountInfo) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "该卡号和商户账户信息不匹配");
        }
        if (!BindCardStatus.NORMAL.getStatus().equals(merchantAccountInfo.getBindStatus())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "该账号状态不支持解绑操作");
        }

        accountHandler.unBind(userAccount, acctNo);

        UnBindRespDTO resq = new UnBindRespDTO();
        resq.setClientTradeId(tradeContext.getClientTradeId());
        resq.setServerTradeId(tradeContext.getServerTransId());
        resq.setStatus(HttpRespStatus.OK.valueStr());
        resq.setMessage(HttpRespStatus.OK.getReasonPhrase());
        resq.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tradeContext.setResponseDTO(resq);

        return ChannelResponseUtil.success(resq,null,null);
    }


    @Override
    public void initTransFlow(TradeContext<UnBindReqDTO, UnBindRespDTO> tradeContext) {

    }


    @Override
    public void updateTransFlow(TradeContext tradeContext) {

    }

    @Override
    protected void verifyReqParam(TradeContext<UnBindReqDTO, UnBindRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        UnBindReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
    }

}
