package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.UtpDMBUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankBindReq;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.FundAccType;
import cn.kingnet.utp.trade.common.enums.UnionPaySubTypeEnum;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.support.ServiceContext;
import cn.onebank.dmb.client.util.DmbUtil;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.SysHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * 鉴权绑定--账户验证（华通）
 *
 * @author zhongli
 */
@Component("bind")
@ServiceContext(bodyClass = OneBankBindReq.class)
@Slf4j
public class OneBankBindService extends BaseOnebankPayService<OneBankBindReq, SpBaseResponse> {

    private static final String ACCOUNT_VERIFICATION_KEY = "accountVerification";
    private static final String ACCOUNT_VERIFICATION_PUBLIC_KEY = "accountPublicVerification";

    private static final String API_NAME = UnionPaySubTypeEnum.BIND.getDesc();

    public OneBankBindService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @Override
    public SysHeader buildSysHeader(FetureContext<OneBankBindReq, SpBaseResponse> fetureContext) {
        OneBankBindReq requestDTO = fetureContext.getSpReq();
        SysHeader sysHeader = new SysHeader();
        /**目标dfa值 ：由华通提供*/
        sysHeader.setTargetDfa(UtpDMBUtil.getTargetDfaByFundAccType(requestDTO.getFundAccType()));
        /**平台dfa值：由华通提供**/
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        OnebankChannelProperties.Transfer transfer = getTransfer(requestDTO);
        /**服务代码，由华通提供*/
        sysHeader.setServiceId(transfer.getServiceId());
        /**服务场景，默认01，由华通提供*/
        sysHeader.setSceneId(transfer.getSceneId());
        /**全局业务流水号*/
        sysHeader.setBizSeqNo(requestDTO.getClientTradeId());
        /**服务调用流水号*/
        sysHeader.setConsumerSeqNo(requestDTO.getClientTradeId());
        /**交易发生日期*/
        sysHeader.setTransactionDateTime(new StringBuilder(requestDTO.getTradeDate()).append(":").append(requestDTO.getTradeTime()).toString());
        /**账号*/
        sysHeader.setAcctNo(requestDTO.getAcctNo());
        /**账号类型*/
        sysHeader.setAcctType(requestDTO.getAcctType());
        return sysHeader;
    }

    @Override
    public AppHeader buildAppHeader(FetureContext fetureContext) {
        AppHeader appHeader = new AppHeader();
        return appHeader;
    }

    @Override
    public Object buildContent(FetureContext<OneBankBindReq, SpBaseResponse> fetureContext) {
        OneBankBindReq requestDTO = fetureContext.getSpReq();
        OneBankBindReq.OneBankAccountVerificationReq accountVerificationReq = requestDTO.getOneBankAccountVerificationReq();
        accountVerificationReq.setVersion(this.onebankChannelProperties.getTransfer(ACCOUNT_VERIFICATION_KEY).getVersion());
        accountVerificationReq.setChlCode(this.onebankChannelProperties.getChannelId());
        accountVerificationReq.setSrcChlCode(accountVerificationReq.getChlCode());
        accountVerificationReq.setProductCode(this.onebankChannelProperties.getTransfer(ACCOUNT_VERIFICATION_KEY).getProductcode());
        accountVerificationReq.setPayRouteType("2");
        accountVerificationReq.setInputUser(this.onebankChannelProperties.getTxnTellerId());
        //授权柜员
        accountVerificationReq.setGrantUser(null);
        return accountVerificationReq;
    }

    public OnebankChannelProperties.Transfer getTransfer(OneBankBindReq req) {
        if (req != null && FundAccType.GENERAL_ACC == req.getFundAccType()) {
            return this.onebankChannelProperties.getTransfer(ACCOUNT_VERIFICATION_PUBLIC_KEY);
        }
        return this.onebankChannelProperties.getTransfer(ACCOUNT_VERIFICATION_KEY);
    }

    @Override
    protected String apiName() {
        return API_NAME;
    }
}
