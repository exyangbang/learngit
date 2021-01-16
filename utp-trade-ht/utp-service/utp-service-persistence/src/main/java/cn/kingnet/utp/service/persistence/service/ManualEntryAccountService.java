package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Description : 手工入账服务
 * @Author : linkaigui
 * @Create : 2019/3/22 15:24
 */
@Service
@Slf4j
public class ManualEntryAccountService {

    @Resource
    private InnerAccountService innerAccountService;

    @Resource
    private MsgNoticeService msgNoticeService;
    @Resource
    private IndustryService industryService;
    @Resource
    private MerchantInfoService merchantInfoService;
    /**
     * 手工入账
     * @param transId
     * @param account
     * @param userModified
     * @return
     */
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public boolean manualEntryAccount(Long transId, String account, String userModified){
        log.info("交易明细Id:{}.虚拟账户:{}..手工入账处理开始 .", transId,account);
        BankAccountTransDetail bankAccountTransDetail = MybatisDaoImpl.run().selectById(BankAccountTransDetail.class,transId);

        Account tempAccount = MybatisDaoImpl.run().selectOne(AccountCondition.builder().andAccountEq(account).build());
        if(tempAccount == null || StringUtil.isBlank(tempAccount.getAccount())) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"虚拟账户有误!");
        }

        if(bankAccountTransDetail == null || bankAccountTransDetail.getId() == null || StringUtil.isBlank(bankAccountTransDetail.getSysReferenceNo())){
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"找不到银行账户交易明细!");
        }

        if(!TrueOrFalseStatus.FALSE.value().equals(bankAccountTransDetail.getOperStatus())){
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"该笔明细已入账,请勿重复入账!");
        }

        String industryCode = "";
        if(VirtualAccountType.MERCHANT.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.PERSON.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.SELFEMPLOYED.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.SETTLEACCOUNT.getType().equals(tempAccount.getObjType())
        ){
            if(StringUtil.isBlank(bankAccountTransDetail.getIndustryCode())){
                MerchantInfoBo merchantInfoBo = merchantInfoService.getMerchantInfoBo(tempAccount.getAccount(),true);
                if(merchantInfoBo == null || StringUtil.isBlank(merchantInfoBo.getIndustryCode())){
                    throw new TradeException(HttpRespStatus.BAD_REQUEST,"找不到对应的代付客户号!");
                }
                industryCode = merchantInfoBo.getIndustryCode();
            }else {
                industryCode = bankAccountTransDetail.getIndustryCode();
            }
        }else {
            industryCode = tempAccount.getObjCode();
        }

        if(StringUtil.isBlank(industryCode)) throw new TradeException(HttpRespStatus.BAD_REQUEST,"找不到对应的代付客户号!");
        Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(industryCode).build());
        if(industry == null || !industryCode.equals(industry.getCode())) throw new TradeException(HttpRespStatus.BAD_REQUEST,"找不到对应的代付客户号!");

        List<ChannelIncomeFlow> channelIncomeFlowList = MybatisDaoImpl.run().selectList(ChannelIncomeFlowCondition.builder().andCoreNoEq(bankAccountTransDetail.getSysReferenceNo()).build());
        if(!CollectionUtils.isEmpty(channelIncomeFlowList)){
            ChannelIncomeFlow channelIncomeFlow = channelIncomeFlowList.stream().findFirst().get();
            if(!account.equals(channelIncomeFlow.getAccNo())) throw new TradeException(HttpRespStatus.BAD_REQUEST,"虚拟帐号与入金通知不一致!");
            bankAccountTransDetail.setSourceFlag("1");
            bankAccountTransDetail.setOrderStatus(AccountOrderStatus.INITTIALIZE.getCode());
            bankAccountTransDetail.setOtherBankNo(channelIncomeFlow.getClearBankno());
        }

        //账户入金
        innerAccountService.plusBalance(AccountOperSubType.MANUAL_INCOME, account, bankAccountTransDetail.getTxnAmount(), bankAccountTransDetail.getOtherCustAccountNo(), "手工入账", bankAccountTransDetail.getSysReferenceNo(), bankAccountTransDetail.getOtherCustName(), bankAccountTransDetail.getOtherRid());
        LambdaLogger.info(log, "手工入账：虚账户{}打款入金,交易日期时间{} {}-来款账号{}-来款名称{}-来款金额{}-备注{}",
                account, bankAccountTransDetail.getTxnDate(), bankAccountTransDetail.getTxnTime(), bankAccountTransDetail.getOtherCustAccountNo(), bankAccountTransDetail.getOtherCustName(), bankAccountTransDetail.getTxnAmount(), bankAccountTransDetail.getRemarkDetail());

        bankAccountTransDetail.setAccount(account);
        bankAccountTransDetail.setOperStatus(TrueOrFalseStatus.TRUE.value());

        //更新交易明细信息
        bankAccountTransDetail.setIndustryCode(industryCode);
        bankAccountTransDetail.setGmtModified(new Date());
        bankAccountTransDetail.setUserModified(userModified);
        MybatisDaoImpl.run().updateById(bankAccountTransDetail);
        //更新入金通知流水
        AtomicReference<String> peerBankNo = new AtomicReference<>();
        if(!CollectionUtils.isEmpty(channelIncomeFlowList)){
            List<ChannelIncomeFlow> thizList = channelIncomeFlowList.stream()
                    .map(o -> {
                        o.setHandleFlag(TrueOrFalseStatus.TRUE.value());
                        if("01".equals(o.getBizFlag()) || "04".equals(o.getBizFlag())){
                            peerBankNo.set(o.getClearBankno());
                        }
                        return o;
                    }).collect(Collectors.toList());

            if (!org.springframework.util.CollectionUtils.isEmpty(thizList)) {
                MybatisDaoImpl.run().updateBatchById(thizList, 100);
            }
        }

        //入金通知
        Map<String, Object> map = new HashMap<>(32);
        map.put("operateType", AccountOperType.PLUS_BLANCE.getCode());
        map.put("operateSubType", AccountOperSubType.MANUAL_INCOME.getCode());
        map.put("amount", bankAccountTransDetail.getTxnAmount());
        map.put("recordTime", DateUtil.formateDate(bankAccountTransDetail.getGmtModified(), "yyyy-MM-dd HH:mm:ss"));
        map.put("seqNo", bankAccountTransDetail.getDetailSerialNumber());
        map.put("remark", bankAccountTransDetail.getSummaryDescription());
        map.put("peerAccNo", bankAccountTransDetail.getOtherCustAccountNo());
        map.put("peerAccName", bankAccountTransDetail.getOtherCustName());
        map.put("peerBankName", bankAccountTransDetail.getOtherBankName());
        map.put("serverTransId", bankAccountTransDetail.getSysReferenceNo());
        map.put("peerBankNo", peerBankNo.get());

        Map<String, Object> content = new HashMap(8);
        if(VirtualAccountType.MERCHANT.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.PERSON.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.SELFEMPLOYED.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.SETTLEACCOUNT.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.FEEOUTCOME.getType().equals(tempAccount.getObjType())
                || VirtualAccountType.AUTHOUTCOME.getType().equals(tempAccount.getObjType())
        ){
            content.put("noticeType", NoticeType.SECONDARY_ACC_INCOME.getType());
            map.put("orderId", bankAccountTransDetail.getOtherRid());
        }else {
            content.put("noticeType", NoticeType.INDUSTRY_ACC_INCOME.getType());
        }
        content.put("items", map);
        content.put("industryCode",industry.getCode());
        msgNoticeService.saveNoticeCallbackMessage(industry.getInnerNoticeUrl(), industry.getCode(), bankAccountTransDetail.getSysReferenceNo(), content);
        log.info("交易明细Id:{}.虚拟账户:{}.. 手工入账处理结束 .", transId,account);
        return true;
    }
}
