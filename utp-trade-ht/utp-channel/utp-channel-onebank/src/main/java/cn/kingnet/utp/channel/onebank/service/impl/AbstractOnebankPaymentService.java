package cn.kingnet.utp.channel.onebank.service.impl;

import cn.kingnet.utp.channel.onebank.configuration.OnebankChannelProperties;
import cn.kingnet.utp.channel.onebank.service.BaseOnebankPayService;
import cn.kingnet.utp.channel.onebank.support.UtpDMBUtil;
import cn.kingnet.utp.channel.onebank.support.UtpDbmTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReq;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferReqContent;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import cn.kingnet.utp.trade.common.enums.ChannelKey;
import cn.kingnet.utp.trade.common.support.FetureContext;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.onebank.dmb.client.util.DmbUtil;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.SysHeader;
import com.alibaba.fastjson.JSON;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;

/**
 * @author zhongli
 * @date 2018/10/18
 */
public abstract class AbstractOnebankPaymentService<REQ extends SpBaseRequest, RESP extends SpBaseResponse> extends BaseOnebankPayService<REQ, RESP> {


    public AbstractOnebankPaymentService(UtpDbmTemplate utpDbmTemplate, OnebankChannelProperties onebankChannelProperties, ExecutorService executorService) {
        super(utpDbmTemplate, onebankChannelProperties, executorService);
    }

    @PostConstruct
    public void init() {
        initCheck();
    }


    protected void initCheck() {
        OnebankChannelProperties.Transfer transfer = getTransfer(key());
        Assert.hasText(transfer.getServiceId(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".service_id"));
        Assert.hasText(transfer.getSceneId(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".scene_id"));
        Assert.hasText(transfer.getCallBackServiceId(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".call_back_service_id"));
        Assert.hasText(transfer.getCallBackSceneId(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".call_back_scene_id"));
        Assert.hasText(transfer.getProductcode(), () -> "未配置 cn.kingnet.utp.channel.onebank.transfer_map.".concat(key()).concat(".product_code"));
    }


    @Override
    public SysHeader buildSysHeader(FetureContext<REQ, RESP> fetureContext) {
        OneBankTransferReq req = JSON.parseObject(JSON.toJSONString(fetureContext.getSpReq()), OneBankTransferReq.class);
        OnebankChannelProperties.Transfer transfer = getTransfer(req);
        SysHeader sysHeader = new SysHeader();
        /**服务代码，由华通提供*/
        sysHeader.setServiceId(transfer.getServiceId());
        /**服务场景，默认01，由华通提供*/
        sysHeader.setSceneId(transfer.getSceneId());
        /**目标dfa值 ：由华通提供*/
        sysHeader.setTargetDfa(UtpDMBUtil.getTargetDfaByFundAccType(req.getFundAccType()));
        /**平台dfa值：由华通提供**/
        sysHeader.setDfa(DmbUtil.getConsumerDFA());
        /**全局业务流水号*/
        sysHeader.setBizSeqNo(req.getClientTradeId());
        /**服务调用流水号*/
        sysHeader.setConsumerSeqNo(req.getClientTradeId());
        /**交易发生日期*/
        sysHeader.setTransactionDateTime(new StringBuilder(req.getTradeDate()).append(":").append(req.getTradeTime()).toString());
        /**账号*/
        sysHeader.setAcctNo(req.getAcctNo());
        /**账号类型*/
        sysHeader.setAcctType(req.getAcctType());

        return sysHeader;
    }

    @Override
    public AppHeader buildAppHeader(FetureContext<REQ, RESP> fetureContext) {
        AppHeader appHead = new AppHeader();
        return appHead;
    }


    @Override
    public OneBankTransferReqContent buildContent(FetureContext<REQ, RESP> fetureContext) {
        OneBankTransferReq req = JSON.parseObject(JSON.toJSONString(fetureContext.getSpReq()), OneBankTransferReq.class);
        OneBankTransferReqContent content = req.getContent();
        //remark 备注|附言最大长度100
        content.setRemark(StringUtil.truncate(content.getRemark(),100));

        OnebankChannelProperties.Transfer transfer = getTransfer(req);
        /**产品代码 有新旧之分*/
        content.setProductCode(selectProductNoByChannelKey(req, transfer));
        /**柜员*/
        content.setInputUser(onebankChannelProperties.getTxnTellerId());
        /**渠道编码*/
        content.setChlCode(onebankChannelProperties.getChannelId());
        content.setSrcChlCode(onebankChannelProperties.getChannelId());
        /**机构号*/
        content.setOrgId(onebankChannelProperties.getTxnBranchCode());
        content.setBizCharactCode(transfer.getCallBackServiceId());
        content.setTransScenario(transfer.getCallBackSceneId());
        /**可疑账号确认标识*/
        content.setDoubtfulAcctEnter("0");

        /**兼容智能路由：不再限制，统一都填写8888**/
        content.setPersonCode(CommonConstants.DEFAULT_HT_PERSON_CODE);
        return content;
    }

    private String selectProductNoByChannelKey(OneBankTransferReq oneBankTransferReq, OnebankChannelProperties.Transfer transfer) {
        String productNo;
        //当且仅当 银联代付(事后划账)渠道时选择 新产品编码交易
        if (ChannelKey.HT_POST_CUC.getKey().equals(oneBankTransferReq.getChannelKey())) {
            productNo = transfer.getNewProductcode();
        } else {
            productNo = transfer.getProductcode();
        }
        return productNo;
    }

    public abstract String key();

    public OnebankChannelProperties.Transfer getTransfer(OneBankTransferReq req) {
        String key = key();
        return this.getTransfer(key);
    }

    public OnebankChannelProperties.Transfer getTransfer(String key) {
        Assert.hasText(key, () -> this.getClass().getName().concat(" is not defined method key(), the method return null."));
        return onebankChannelProperties.getTransfer(key);
    }

    @Override
    protected abstract String apiName();
}
