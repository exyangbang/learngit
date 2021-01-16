package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description : 退汇管理处理
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 22:40
 */
@Service
@Slf4j
public class TransReexchangeService {

    @Autowired
    private InnerAccountService innerAccountService;

    @Autowired
    private MsgNoticeService msgNoticeService;
    @Resource
    private IndustryService industryService;

    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public boolean adjustAccountByReexchange(Long id, String userModified){
        log.info("退汇流水Id:{}...退汇账户处理开始 .", id);
        TransReexchange transReexchange = MybatisDaoImpl.run().selectById(TransReexchange.class,id);

        if(transReexchange == null || transReexchange.getId() == null){
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"退汇信息错误!");
        }

        if(TrueOrFalseStatus.TRUE.value().equals(transReexchange.getSolveStatus())){
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"退汇已处理!");
        }

        if(StringUtil.isBlank(transReexchange.getServerTransId())){
            throw new TradeException(HttpRespStatus.BAD_REQUEST,"服务端流水号为空!");
        }

        PlusEntityWrapper<TransReexchange> wrap = TransReexchangeCondition.builder().andIdEq(id).andSolveStatusEq(TrueOrFalseStatus.FALSE.value()).build();
        String updateSql = String.format("solve_status = '%s',user_modified = '%s',gmt_modified = '%s'",TrueOrFalseStatus.TRUE.value(),userModified, DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        int resCount = MybatisDaoImpl.run().updateForSet(updateSql,wrap);
        if(resCount > 0){
            TransHistory transHistory = MybatisDaoImpl.run().selectOne(TransHistoryCondition.builder().andServerTransIdEq(transReexchange.getServerTransId()).build());
            if(transHistory == null || StringUtil.isBlank(transHistory.getServerTransId())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST,"服务端流水号不存在!");
            }
            if(!TransStatus.TRADE_SUCCESS.name().equals(transHistory.getTransStatus())) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "交易状态为"+transHistory.getTransStatus()+",不能做退汇!");
            }

            PlusEntityWrapper<TransHistory> transHistoryWrapper = TransHistoryCondition.builder().andIdEq(transHistory.getId()).andTransStatusEq(TransStatus.TRADE_SUCCESS.name()).build();
            String transHistoryUpdateSql = String.format("trans_status = '%s',user_modified = '%s',gmt_modified = '%s'",TransStatus.TRADE_FAILURE.name(),userModified, DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
            int transHistoryResCount = MybatisDaoImpl.run().updateForSet(transHistoryUpdateSql,transHistoryWrapper);
            if(transHistoryResCount <= 0) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST,"交易流水状态不确定!");
            }

            //账户处理
            if(TradeType.WITHDRAW.getCode().equals(transHistory.getTradeType())){
                //提现
                this.adjustAccount4Withdraw(transHistory);
            }else if(TradeType.TRANSFER.getCode().equals(transHistory.getTradeType())){
                //转账
                this.adjustAccount4Transfer(transHistory);
            }else if(TradeType.SGL_PAYMENT.getCode().equals(transHistory.getTradeType())){
                //单笔实时代付
                this.adjustAccount4SignalPayment(transHistory);
            }else if(TradeType.REFUND_ORDERID.getCode().equals(transHistory.getTradeType())){
                //订单退款
                this.adjustAccount4RefundOrderid(transHistory);
            }else if(TradeType.UPLOAD_ACCOUNT_SETTLE.getCode().equals(transHistory.getTradeType())){
                //预付费卡清算
                this.adjustAccount4PreCard(transHistory);
            }else if(TradeType.RANDOM_AMT_PAYMENT_AUTH.getCode().equals(transHistory.getTradeType())){
                //随机金额打款
                this.adjustAccount4RandomAmtPaymentAuth(transHistory);
            }else {
                throw new TradeException(HttpRespStatus.BAD_REQUEST,"交易类型未明确!");
            }

            // 退汇成功时调用
            noticeIndustryClient(transReexchange);

            log.info("退汇流水Id:{}...流水号：{} ==> 交易类型{} 退汇账户处理", id,transHistory.getServerTransId(), transHistory.getTradeType());
        }
        log.info("退汇流水Id:{}... 退汇账户处理结束 .", id);
        return true;
    }

    /**
     *
     * @param settleDate
     * @return
     */
    public List<TransReexchange> queryBySettleDate(String industryCode, String settleDate){
        PlusEntityWrapper<TransReexchange> wrapper = TransReexchangeCondition.builder().andIndustryCodeEq(industryCode).andChannelSettleDateEq(settleDate).build();
        return MybatisDaoImpl.run().selectList(wrapper);
    }

    /**
     * 提现退汇账户处理
     * @param transHistory
     */
    private void adjustAccount4Withdraw(TransHistory transHistory){

        if (!innerAccountService.isExistAccountDetail(transHistory.getPayeeAccount(), transHistory.getRealAmount(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
            innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayeeAccount(), transHistory.getRealAmount(), transHistory.getPayeeAcctNo(), "退汇入金", transHistory.getServerTransId(),transHistory.getPayeeName(),null);
        }

        //手续费处理
        if(transHistory.getMerFee() != null && transHistory.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(transHistory)) {
                if (!innerAccountService.isExistAccountDetail(transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getIncomeAccount(), "退汇手续费退款", transHistory.getServerTransId(), transHistory.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getFeeAccount(), "退汇手续费退款", transHistory.getServerTransId(), transHistory.getFeeAccountName(), null);
                }
            } else if (isMerRealTimeAndInner(transHistory)) {
                if (!innerAccountService.isExistAccountDetail(transHistory.getPayeeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayeeAccount(), transHistory.getMerFee(), transHistory.getIncomeAccount(), "退汇手续费退款", transHistory.getServerTransId(), transHistory.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getPayeeAcctNo(), "退汇手续费退款", transHistory.getServerTransId(), transHistory.getPayeeName(), null);
                }
            }
        }
    }

    /**
     * 转账
     * @param transHistory
     */
    private void adjustAccount4Transfer(TransHistory transHistory){

        if (!innerAccountService.isExistAccountDetail(transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
            innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getPayeeAccount(), "退汇入金", transHistory.getServerTransId(),transHistory.getPayeeName(),null);
        }
        if (!innerAccountService.isExistAccountDetail(transHistory.getPayeeAccount(), transHistory.getRealAmount(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
            innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getPayeeAccount(), transHistory.getRealAmount(), transHistory.getPayerAccount(), "转账退汇", transHistory.getServerTransId(),transHistory.getPayerName(),null);
        }

        if(transHistory.getMerFee() != null && transHistory.getMerFee() > 0){
            if (isMerRealTimeAndInner(transHistory)) {
                if (!innerAccountService.isExistAccountDetail(transHistory.getPayerAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayerAccount(), transHistory.getMerFee(), transHistory.getIncomeAccount(), "转账退汇手续费退款", transHistory.getServerTransId(), transHistory.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getPayerAccount(), "转账退汇手续费退款", transHistory.getServerTransId(), transHistory.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(transHistory)) {
                if (!innerAccountService.isExistAccountDetail(transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getIncomeAccount(), "转账退汇手续费退款", transHistory.getServerTransId(), transHistory.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getFeeAccount(), "转账退汇手续费退款", transHistory.getServerTransId(), transHistory.getFeeAccountName(), null);
                }
            }
        }
    }

    /**
     * 实时代付
     * @param transHistory
     */
    private void adjustAccount4SignalPayment(TransHistory transHistory){
        if (!innerAccountService.isExistAccountDetail(transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
            innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getPayeeAcctNo(), "实时代付退汇", transHistory.getServerTransId(), transHistory.getPayeeName(), null);
        }
        if(transHistory.getMerFee() != null && transHistory.getMerFee() > 0){
            if (isMerRealTimeAndInner(transHistory)) {
                if (!innerAccountService.isExistAccountDetail(transHistory.getPayerAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayerAccount(), transHistory.getMerFee(), transHistory.getIncomeAccount(), "实时代付手续费退汇", transHistory.getServerTransId(), transHistory.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getPayerAccount(), "实时代付手续费退汇", transHistory.getServerTransId(), transHistory.getPayerName(), null);
                }
            } else if (isMerRealTimeAndBuckle(transHistory)) {
                if (!innerAccountService.isExistAccountDetail(transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getIncomeAccount(), "实时代付手续费退汇", transHistory.getServerTransId(), transHistory.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getFeeAccount(), "实时代付手续费退汇", transHistory.getServerTransId(), transHistory.getFeeAccountName(), null);
                }
            }
        }
    }

    /**
     * 订单退款
     * @param transHistory
     */
    private void adjustAccount4RefundOrderid(TransHistory transHistory){
        if (!innerAccountService.isExistAccountDetail(transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
            innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getPayeeAcctNo(), "退汇入金", transHistory.getServerTransId(), transHistory.getPayeeName(), transHistory.getOrderId());
        }
    }

    /**
     * 预付费卡
     * @param transHistory
     */
    private void adjustAccount4PreCard(TransHistory transHistory){
        if(StringUtil.isBlank(transHistory.getIndustryCode())){
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, "代付客户号为空!");
        }

        if(StringUtil.isBlank(transHistory.getServerTransId())){
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, "服务端流水号为空!");
        }
        FileUploadLog fileUploadLog = MybatisDaoImpl.run().selectOne(FileUploadLogCondition.builder().andIndustryCodeEq(transHistory.getIndustryCode()).andServerTransIdEq(transHistory.getServerTransId()).build());
        if(fileUploadLog == null || StringUtil.isBlank(fileUploadLog.getBatchId())) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("预付费卡清算找不到流水号：%s 上送信息.",transHistory.getServerTransId()));
        }
        List<AccountSettleDetail> accountSettleDetailList = MybatisDaoImpl.run().selectList(AccountSettleDetailCondition.builder().andIndustryCodeEq(fileUploadLog.getIndustryCode()).andBatchIdEq(fileUploadLog.getBatchId()).build());
        if(CollectionUtils.isEmpty(accountSettleDetailList)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("预付费卡清算找不到流水号：%s 明细信息.",transHistory.getServerTransId()));
        }

        accountSettleDetailList.stream()
                .filter(accountSettleDetail -> TrueOrFalseStatus.TRUE.value().equals(accountSettleDetail.getProvisionFlag()))
                .filter(accountSettleDetail -> StringUtil.isNotBlank(accountSettleDetail.getUserAccount()))
                .forEach(accountSettleDetail -> {
                    if (!innerAccountService.isExistAccountDetail(accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                        innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), accountSettleDetail.getPayeeAcctNo(), "退汇入金", transHistory.getServerTransId(),accountSettleDetail.getPayeeName(),null);
                    }
                });

        //手续费处理
        if(transHistory.getMerFee() != null && transHistory.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(transHistory)) {
                if (!innerAccountService.isExistAccountDetail(transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getFeeAccount(), transHistory.getMerFee(), transHistory.getIncomeAccount(), "退汇手续费退款", transHistory.getServerTransId(), transHistory.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REMITTANCE, transHistory.getIncomeAccount(), transHistory.getMerFee(), transHistory.getFeeAccount(), "退汇手续费退款", transHistory.getServerTransId(), transHistory.getFeeAccountName(), null);
                }
            }
        }
    }

    /**
     * 随机金额打款
     * @param transHistory
     */
    private void adjustAccount4RandomAmtPaymentAuth(TransHistory transHistory){
        if (!innerAccountService.isExistAccountDetail(transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
            innerAccountService.plusBalance(AccountOperSubType.REMITTANCE, transHistory.getPayerAccount(), transHistory.getRealAmount(), transHistory.getPayeeAcctNo(), "退汇入金", transHistory.getServerTransId(), transHistory.getPayeeName(), transHistory.getOrderId());
        }
    }

    /**
     * 用户实时内扣
     *
     * @param transHistory
     * @return
     */
    private boolean isMerRealTimeAndInner(TransHistory transHistory) {
        return SettleType.REAL_TIME.getType().equals(transHistory.getMerSettleType())
                && ChargeMode.INNER.getMode().equals(transHistory.getMerChargeMode());
    }

    /**
     * 用户实时外扣
     *
     * @param transHistory
     * @return
     */
    private boolean isMerRealTimeAndBuckle(TransHistory transHistory) {
        return SettleType.REAL_TIME.getType().equals(transHistory.getMerSettleType())
                && ChargeMode.BUCKLE.getMode().equals(transHistory.getMerChargeMode());
    }

    /**
     * 退汇流水通知：退汇成功后通知代付客户平台
     * @param transReexchange
     */
    private void noticeIndustryClient(TransReexchange transReexchange){
        Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(transReexchange.getIndustryCode()).build());
        if(industry != null && !StringUtil.isBlank(industry.getInnerNoticeUrl())){
            Map<String,Object> map = new HashMap<>(16);
            map.put("industryCode",transReexchange.getIndustryCode());
            map.put("industryName",industry.getName());
            map.put("clientTransId",transReexchange.getClientTransId());
            map.put("serverTransId",transReexchange.getServerTransId());
            map.put("transDate",transReexchange.getTransDate());
            map.put("settleDate",transReexchange.getChannelSettleDate());
            map.put("payeeAccName",transReexchange.getPayeeName());
            map.put("payeeAccNo",transReexchange.getPayeeAcctNo());
            map.put("payAmt",transReexchange.getTransAmount());
            map.put("solveStatus",transReexchange.getSolveStatus());
            map.put("operUser",transReexchange.getUserCreate());
            map.put("operTime",DateUtil.formateDate(transReexchange.getGmtModified(),"yyyy-MM-dd HH:mm:ss"));

            Map<String,Object> content = new HashMap<>(8);
            content.put("noticeType",NoticeType.REEXCHANGE_FLOW.getType());
            content.put("industryCode",industry.getCode());
            content.put("items",map);
            msgNoticeService.saveNoticeCallbackMessage(industry.getInnerNoticeUrl(),transReexchange.getIndustryCode(),transReexchange.getServerTransId(),content);

        }
    }

}
