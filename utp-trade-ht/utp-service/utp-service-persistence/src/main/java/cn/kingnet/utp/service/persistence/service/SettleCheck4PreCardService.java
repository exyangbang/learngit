package cn.kingnet.utp.service.persistence.service;


import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import cn.kingnet.utp.trade.common.enums.AccountOperType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 预付费卡清分交易的差错处理
 */
@Service
@Slf4j
public class SettleCheck4PreCardService extends SettleCheckBaseAbstractService {

    public SettleCheck4PreCardService(InnerAccountService innerAccountService) {
        super(innerAccountService);
    }

    /**
     * 解冻金额
     * @param settleCheckInfo
     * @param remark
     */
    @Override
    protected void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {
        List<AccountSettleDetail> accountSettleDetailList = this.findAccountSettleDetailList(settleCheckInfo);
        accountSettleDetailList.stream()
                .filter(accountSettleDetail -> TrueOrFalseStatus.TRUE.value().equals(accountSettleDetail.getProvisionFlag()))
                .filter(accountSettleDetail -> StringUtil.isNotBlank(accountSettleDetail.getUserAccount()))
                .forEach(accountSettleDetail -> {
                    if (!innerAccountService.isExistAccountDetail(accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), settleCheckInfo.getServerTransId(), AccountOperType.UNFREEZEN_BLANCE)) {
                        innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT, accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), accountSettleDetail.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),accountSettleDetail.getPayeeName(),null);
                    }
                });

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(), AccountOperType.UNFREEZEN_BLANCE)) {
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "预付费卡清算手续费解冻", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
            }
        }
    }

    @Override
    protected void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark) {
        List<AccountSettleDetail> accountSettleDetailList = this.findAccountSettleDetailList(settleCheckInfo);
        accountSettleDetailList.stream()
                .filter(accountSettleDetail -> TrueOrFalseStatus.TRUE.value().equals(accountSettleDetail.getProvisionFlag()))
                .filter(accountSettleDetail -> StringUtil.isNotBlank(accountSettleDetail.getUserAccount()))
                .forEach(accountSettleDetail -> {
                    if (!innerAccountService.isExistAccountDetail(accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), settleCheckInfo.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                        innerAccountService.plusBalance(AccountOperSubType.PAYMENT, accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), accountSettleDetail.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),accountSettleDetail.getPayeeName(),null);
                    }
                });

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.REFUND, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "预付费卡清算手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.REFUND, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "预付费卡清算手续费退款", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }
    }

    @Override
    protected void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {
        List<AccountSettleDetail> accountSettleDetailList = this.findAccountSettleDetailList(settleCheckInfo);
        accountSettleDetailList.stream()
                .filter(accountSettleDetail -> TrueOrFalseStatus.TRUE.value().equals(accountSettleDetail.getProvisionFlag()))
                .filter(accountSettleDetail -> StringUtil.isNotBlank(accountSettleDetail.getUserAccount()))
                .forEach(accountSettleDetail -> {
                    if (!innerAccountService.isExistAccountDetail(accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), settleCheckInfo.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                        innerAccountService.minusBalance(AccountOperSubType.PAYMENT, accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), accountSettleDetail.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),accountSettleDetail.getPayeeName(),null);
                    }
                });

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "预付费卡清算手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "预付费卡清算手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }
    }

    @Override
    protected void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark) {
        List<AccountSettleDetail> accountSettleDetailList = this.findAccountSettleDetailList(settleCheckInfo);
        accountSettleDetailList.stream()
                .filter(accountSettleDetail -> TrueOrFalseStatus.TRUE.value().equals(accountSettleDetail.getProvisionFlag()))
                .filter(accountSettleDetail -> StringUtil.isNotBlank(accountSettleDetail.getUserAccount()))
                .forEach(accountSettleDetail -> {
                    if (!innerAccountService.isExistAccountDetail(accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), settleCheckInfo.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                        innerAccountService.minusAvailBalance(AccountOperSubType.PAYMENT, accountSettleDetail.getUserAccount(), accountSettleDetail.getAmount(), accountSettleDetail.getPayeeAcctNo(), remark, settleCheckInfo.getServerTransId(),accountSettleDetail.getPayeeName(),null);
                    }
                });

        //手续费处理
        if(settleCheckInfo.getMerFee() != null && settleCheckInfo.getMerFee() > 0){
            if (isMerRealTimeAndBuckle(settleCheckInfo)) {
                if (!innerAccountService.isExistAccountDetail(settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(), AccountOperType.MINUS_BLANCE)) {
                    innerAccountService.minusAvailBalance(AccountOperSubType.FEE, settleCheckInfo.getFeeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getIncomeAccount(), "预付费卡清算手续费支出", settleCheckInfo.getServerTransId(), settleCheckInfo.getIncomeAccountName(), null);
                }
                if (!innerAccountService.isExistAccountDetail(settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getServerTransId(), AccountOperType.PLUS_BLANCE)) {
                    innerAccountService.plusBalance(AccountOperSubType.FEE, settleCheckInfo.getIncomeAccount(), settleCheckInfo.getMerFee(), settleCheckInfo.getFeeAccount(), "预付费卡清算手续费收益", settleCheckInfo.getServerTransId(), settleCheckInfo.getFeeAccountName(), null);
                }
            }
        }
    }

    private List<AccountSettleDetail> findAccountSettleDetailList(SettleCheckInfo settleCheckInfo){
        if(StringUtil.isBlank(settleCheckInfo.getIndustryCode())){
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, "代付客户号为空!");
        }

        if(StringUtil.isBlank(settleCheckInfo.getServerTransId())){
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, "服务端流水号为空!");
        }
        FileUploadLog fileUploadLog = MybatisDaoImpl.run().selectOne(FileUploadLogCondition.builder().andIndustryCodeEq(settleCheckInfo.getIndustryCode()).andServerTransIdEq(settleCheckInfo.getServerTransId()).build());
        if(fileUploadLog == null || StringUtil.isBlank(fileUploadLog.getBatchId())) throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("预付费卡清算找不到流水号：%s 上送信息.",settleCheckInfo.getServerTransId()));
        List<AccountSettleDetail> accountSettleDetailList = MybatisDaoImpl.run().selectList(AccountSettleDetailCondition.builder().andIndustryCodeEq(fileUploadLog.getIndustryCode()).andBatchIdEq(fileUploadLog.getBatchId()).build());
        if(CollectionUtils.isEmpty(accountSettleDetailList)) throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("预付费卡清算找不到流水号：%s 明细信息.",settleCheckInfo.getServerTransId()));
        return accountSettleDetailList;
    }

}
