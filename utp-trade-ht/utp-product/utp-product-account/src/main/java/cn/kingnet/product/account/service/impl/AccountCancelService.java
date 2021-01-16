package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.AccountCancelReqDTO;
import cn.kingnet.utp.trade.common.dto.account.AccountCancelRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.VirtualAccountStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**销户
 * @author zhongli
 * @date 2019-03-04
 *
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.CANCEL,
        reqClass = AccountCancelReqDTO.class,
        respClass = AccountCancelRespDTO.class
)
public class AccountCancelService extends AbstractAccountTradeService<AccountCancelReqDTO, AccountCancelRespDTO> {

	public AccountCancelService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
		super(authConfigInfoService, utpConfigProperties,basicConfigHandler,productAccountProperties);
	}

    /**
     *                       ------------------------
     *                       | 查询虚拟账号余额是否为0 |
     *                       ------------------------
     *                           /                  ＼
     *                     ------------------      -------------------------------
     *                     | 为0则进行销户操作 |     | 不为0，无法进行销户，返回拒绝操作|
     *                     ------------------      -------------------------------
     *                          |
     *                     --------------------------------
     *                     | 更改t_account虚账户VirtualAccountStatus=Cancel及merchant_info accountStatus=cancel相应账户状态
     *                        以及t_account账户关联的银行客户号关联状态为 bankClientStatus=canceled_unreported
     *                     --------------------------------
     * @return
     */
    @Override
    public ChannelResponseDTO reqChannel(TradeContext<AccountCancelReqDTO, AccountCancelRespDTO> tradeContext) {
        String userAccount = tradeContext.getRequestDTO().getUserAccount();
        //判断余额是不是为0
        Account account = this.accountHandler.queryAccountByUserAccount(userAccount);

        if (account == null) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号未开户");
        }
        if(VirtualAccountStatus.CANCEL.getType().equals(account.getStatus())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账号已销户，不需要重复销户");
        }
        if (account.getBalance() != null && account.getBalance() > 0) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "账户还有余额，无法销户");
        }

        this.accountHandler.cancelAccount(userAccount);

        AccountCancelRespDTO respDTO = new AccountCancelRespDTO();
        respDTO.setClientTradeId(tradeContext.getClientTradeId());
        respDTO.setServerTradeId(tradeContext.getServerTransId());
        respDTO.setStatus(HttpRespStatus.OK.valueStr());
        respDTO.setMessage(HttpRespStatus.OK.getReasonPhrase());
        respDTO.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tradeContext.setResponseDTO(respDTO);

        return ChannelResponseUtil.success(respDTO,null,null);
    }

    @Override
    protected void verifyReqParam(TradeContext<AccountCancelReqDTO, AccountCancelRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        AccountCancelReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "用户账户");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");

        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(reqDTO.getUserAccount());
        if(merchantInfo == null){
            throw new ProductException(HttpRespStatus.FORBIDDEN, String.format("查无此账户[%s]", reqDTO.getUserAccount()));
        }

        //校验用户账户归属客户号与当前客户号是否一致
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        if (industryCode == null || !industryCode.equals(merchantInfo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属客户号与当前客户号不一致!");
        }
    }

    @Override
    public void initTransFlow(TradeContext<AccountCancelReqDTO, AccountCancelRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<AccountCancelReqDTO, AccountCancelRespDTO> tradeContext) {

    }

}
