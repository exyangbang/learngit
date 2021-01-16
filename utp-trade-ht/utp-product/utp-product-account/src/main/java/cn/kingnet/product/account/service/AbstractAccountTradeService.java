package cn.kingnet.product.account.service;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.AbstractTradeService;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;
import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.TransferUser2IndustryReqDTO;
import cn.kingnet.utp.trade.common.dto.account.TransferUser2UserReqDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.IndustryBusinessType;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.VirtualAccountStatus;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Description : 账户代付抽象类
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/2 15:05
 */
@Slf4j
public abstract class AbstractAccountTradeService<REQ extends BaseRequestDTO, RESP extends BaseResponseDTO> extends AbstractTradeService<REQ, RESP> {

    protected final IBasicConfigHandler basicConfigHandler;

    protected final ProductAccountProperties productAccountProperties;

    @Resource
    protected IAccountHandler accountHandler;

    /**
     * 分账接口限制
     **/
    private final static String[] SPLIT_INTERGACE = new String[]{
            TradeType.UPLOAD_SETTLE_SPLIT.getCode(), TradeType.UPLOAD_SPLIT_PAY_FLOW.getCode(),
            TradeType.UPLOAD_INDUSTRY_PAY_FLOW.getCode(), TradeType.WITHDRAW.getCode(),
            TradeType.OPEN_ACCOUNT.getCode(), TradeType.OPEN_ACCOUNT_ENT.getCode(),
            TradeType.OPEN_ACCOUNT_SELFEMPLOYED.getCode(), TradeType.OPEN_ACCOUNT_SETTLEMENT.getCode(),
            TradeType.UPLOAD_SUBACCOUNT_PAY_FLOW.getCode(), TradeType.UPLOAD_SUBACCOUNT_SETTLE_SPLIT.getCode(),
            TradeType.QUERY_SUBACCOUNT_PAY_FLOW_RESULT.getCode(), TradeType.QUERY_SUBACCOUNT_SETTLE_SPLIT.getCode()
    };
    /**
     * 代付接口限制
     **/
    private final static String[] PAYMENT_INTERGACE = new String[]{TradeType.SGL_PAYMENT.getCode()};
    /**
     * 账户冻结校验相关接口限制
     **/
    private final static String[] ACCOUNT_FREE_INTERFACE = new String[]{
            TradeType.WITHDRAW.getCode(),
            TradeType.INNER_WITHDRAW.getCode(),
            TradeType.UPLOAD_SETTLE_SPLIT.getCode(),
            TradeType.TRANSFER.getCode(),
            TradeType.SGL_PAYMENT.getCode(),
            TradeType.REFUND_ORDERID.getCode(),
            TradeType.TRANSFER_USER2USER.getCode(),
            TradeType.TRANSFER_USER2INDUSTRY.getCode(),
            TradeType.ACC_PAYMENT.getCode()
    };

    public AbstractAccountTradeService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties);
        this.basicConfigHandler = basicConfigHandler;
        this.productAccountProperties = productAccountProperties;
    }

    @Override
    protected String generateServerTransId() {
        return IdGenerate.generateServerTransId(this.productAccountProperties.getDfa(), this.productAccountProperties.getSystemId());
    }

    @Override
    protected void verifyReqParam(TradeContext<REQ, RESP> tradeContext) {
        super.verifyReqParam(tradeContext);
        //每个接口强制校验industry信息,防止部分业务接口不调用setBasicConfigInfo遗漏校验
        setBasicConfigInfo(tradeContext, null);
    }

    /**
     * 查询&校验&设置基础配置信息
     *
     * @param tradeContext 交易上下文
     */
    public void setBasicConfigInfo(TradeContext<REQ, RESP> tradeContext, String userAccount) {
        BasicConfigInfo basicConfigInfo ;
        try {
            basicConfigInfo = getBasicConfigInfo(tradeContext);
            //若basicConfigInfo未设置或者具体业务需要获取校验userAccount时 需要重新查询
            if (basicConfigInfo == null || StringUtil.isNotBlank(userAccount)) {
                basicConfigInfo = basicConfigHandler.getBasicConfigInfoByIndustry(tradeContext.getAuthInfo().getAuthNo(), userAccount, tradeContext.getTradeService().productCode().name());
            }
        } catch (RetryableException re) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "找不到获取基础信息接口!");
        }
        if (basicConfigInfo == null) {
            throw new TradeException(HttpRespStatus.FORBIDDEN, "找不到客户号信息,拒绝请求!");
        }
        ValidateUtils.hasText(basicConfigInfo.getIndustryCode(), "平台代码");
        ValidateUtils.hasText(basicConfigInfo.getCustAccountNo(), "平台客户账户");
        ValidateUtils.hasText(basicConfigInfo.getCustAccountName(), "平台客户账户名称");
        ValidateUtils.hasText(basicConfigInfo.getFundAccount(), "资金账号");
        ValidateUtils.hasText(basicConfigInfo.getIndustryAccount(), "平台虚拟账号");
        ValidateUtils.hasText(basicConfigInfo.getBusinessType(), "平台开通业务");

        // 校验平台开通业务&接口权限
        validBusinessType(tradeContext,basicConfigInfo);

        // 验证部分出金相关接口的平台客户&用户账户是否冻结
        validIndustryAndUserAccountFreezeStatus(tradeContext,basicConfigInfo,userAccount);

        //设置当前上下文基础配置信息
        tradeContext.setAttribute(CommonConstants.BASIC_CONFIG_INFO_KEY, basicConfigInfo);
    }

    /**
     * 验证部分出金相关接口的平台客户&用户账户是否冻结
     */
    private void validIndustryAndUserAccountFreezeStatus(TradeContext<REQ,RESP> tradeContext,BasicConfigInfo basicConfigInfo,String userAccount) {
        if (Arrays.asList(ACCOUNT_FREE_INTERFACE).contains(tradeContext.getTradeService().tradeType().getCode())) {
            //校验平台账户是否冻结
            if (null != basicConfigInfo.getAccountStatus() && basicConfigInfo.getAccountStatus().equals(VirtualAccountStatus.FREEZE.getType())) {
                throw new ProductException(HttpRespStatus.FORBIDDEN.value(), "代付客户冻结状态下无法进行出金操作");
            }
            //校验个人，企业账户是否冻结
            if (isAccountFreeTradeService(tradeContext.getRequestDTO(), userAccount, basicConfigInfo)) {
                throw new ProductException(HttpRespStatus.FORBIDDEN.value(), "账户冻结状态下无法进行出金操作");
            }
        }
    }

    /**
     * 校验平台开通业务&接口权限
     */
    private void validBusinessType(TradeContext<REQ,RESP> tradeContext,BasicConfigInfo basicConfigInfo){
        IndustryBusinessType businessType = IndustryBusinessType.resolve(basicConfigInfo.getBusinessType());
        if (businessType == IndustryBusinessType.SPLIT && Arrays.asList(PAYMENT_INTERGACE).contains(tradeContext.getTradeService().tradeType().getCode())) {
            throw new ProductException(HttpRespStatus.NOT_ACCEPTABLE, "该平台仅能支持分账业务");
        } else if (businessType == IndustryBusinessType.PAYMENT && Arrays.asList(SPLIT_INTERGACE).contains(tradeContext.getTradeService().tradeType().getCode())) {
            throw new ProductException(HttpRespStatus.NOT_ACCEPTABLE, "该平台仅能支持代付业务");
        }
    }

    public BasicConfigInfo getBasicConfigInfo(TradeContext<REQ, RESP> tradeContext) {
        return tradeContext.getAttribute(CommonConstants.BASIC_CONFIG_INFO_KEY);
    }

    protected boolean isMerFeeZero(Long merFee) {
        return merFee == null || merFee.longValue() <= 0;
    }

    /**
     * 校验平台虚拟账户,用户虚拟账户,账户冻结状态下无法进行出金操作
     * 默认 false
     *
     * @return
     */
    public boolean isAccountFreeTradeService(REQ requestDTO, String userAccount, BasicConfigInfo basicConfigInfo) {
        if (StringUtil.isBlank(userAccount)) {
            userAccount = basicConfigInfo.getIndustryAccount();
        }
        //转账(用户-用户)
        if (requestDTO instanceof TransferUser2UserReqDTO) {
            TransferUser2UserReqDTO transferUser2UserReqDTO = (TransferUser2UserReqDTO) requestDTO;
            userAccount = transferUser2UserReqDTO.getPayerUserAccount();
        }
        //转账(用户-代付客户平台)
        if (requestDTO instanceof TransferUser2IndustryReqDTO) {
            TransferUser2IndustryReqDTO transferUser2UserReqDTO = (TransferUser2IndustryReqDTO) requestDTO;
            userAccount = transferUser2UserReqDTO.getPayerUserAccount();
        }
        //查询账户状态
        Account account = accountHandler.findAccountByNo(userAccount);
        if (null == account) {
            throw new ProductException(HttpRespStatus.FORBIDDEN.value(), "查无此虚拟账户:".concat(userAccount));
        }
        //冻结状态，则抛异常
        if (VirtualAccountStatus.FREEZE.getType().equals(account.getStatus())) {
            return true;
        }
        return false;
    }
}
