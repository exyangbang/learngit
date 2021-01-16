package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description : 预付卡清算服务
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/7 17:10
 */
@Service
@Slf4j
public class AccountSettleService {

    @Resource
    private InnerAccountService innerAccountService;
    @Resource
    private IndustryService industryService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED,isolation = Isolation.READ_COMMITTED)
    public Account freezeBalanceUserAccount(AccountSettleDetail accountSettleDetail,String serverTransId){
        //获取商户虚拟账户
        Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(accountSettleDetail.getIndustryCode()).build());
        Account account = MybatisDaoImpl.run().selectOne(AccountCondition.builder().andFundAccountEq(industry.getFundAccount()).andObjTypeEq(VirtualAccountType.MERCHANT.getType()).andObjCodeEq(accountSettleDetail.getMerNo()).build());
        if(account == null || StringUtil.isBlank(account.getAccount())) throw new PersistenceException(HttpRespStatus.NOT_ACCEPTABLE, "找不到账户信息");
        accountSettleDetail.setUserAccount(account.getAccount());
        //冻结商户 账户金额
        innerAccountService.freezeBalance(AccountOperSubType.PAYMENT, account.getAccount(),accountSettleDetail.getAmount(), accountSettleDetail.getPayeeAcctNo(), "预付费卡清算冻结金额", serverTransId,accountSettleDetail.getPayeeName(),null);
        return account;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED,isolation = Isolation.READ_COMMITTED)
    public void unfreezeUserAccount(String accountNo, long amount, String payeeAccNo, String payeeName,String remark, String serverTransId) {
        innerAccountService.unfreezeBalance(AccountOperSubType.PAYMENT,accountNo, amount, payeeAccNo, remark, serverTransId,payeeName,null);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED,isolation = Isolation.READ_COMMITTED)
    public void minusUserAccount(String accountNo, long amount, String payeeAccNo, String payeeName,String remark, String serverTransId) {
        innerAccountService.minusBalance(AccountOperSubType.PAYMENT,accountNo, amount, payeeAccNo, remark, serverTransId,payeeName,null);
    }

    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void callbackSuccess(TransCurrent transCurrent, TransStatus transStatus){
        FileUploadLog fileUploadLog = MybatisDaoImpl.run().selectOne(FileUploadLogCondition.builder()
                .andIndustryCodeEq(transCurrent.getIndustryCode())
                .andBatchIdEq(transCurrent.getServerBatchNo())
                .andServerTransIdEq(transCurrent.getServerTransId())
                .build());
        final String transDesc = StringUtil.isNotBlank(transCurrent.getChannelRespMsg()) ? transCurrent.getChannelRespMsg() : "清算成功";
        if (!(TransStatus.TRADE_SUCCESS.name().equals(fileUploadLog.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(fileUploadLog.getTransStatus()))) {
            List<AccountSettleDetail> accountSettleDetailList = MybatisDaoImpl.run().selectList(AccountSettleDetailCondition.builder().andIndustryCodeEq(fileUploadLog.getIndustryCode()).andBatchIdEq(fileUploadLog.getBatchId()).andSettleDateEq(fileUploadLog.getBizDate()).build());
            Optional.ofNullable(accountSettleDetailList).ifPresent(accountSettleDetails -> {
                List<AccountSettleDetail> list = accountSettleDetails.stream().map(detail ->{
                    if(TransStatus.TRADE_SUCCESS.name().equals(detail.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(detail.getTransStatus())){
                        return detail;
                    }
                    this.minusUserAccount(detail.getUserAccount(),detail.getAmount(),detail.getPayeeAcctNo(),detail.getPayeeName(),"预付费卡清算代付出金",transCurrent.getServerTransId());
                    detail.setTransStatus(transStatus.name());
                    detail.setTransDesc(StringUtil.substring(transDesc,0,50));
                    detail.setGmtModified(new Date());
                    return detail;
                }).collect(Collectors.toList());
                //手续费处理
                if(SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(transCurrent.getMerChargeMode()) && transCurrent.getMerFee() != null && transCurrent.getMerFee() > 0){
                    //手续费支出账户出金
                    innerAccountService.minusBalance(AccountOperSubType.FEE,transCurrent.getFeeAccount(),transCurrent.getMerFee(),transCurrent.getIncomeAccount(),"预付费卡清算成功，手续费出金",transCurrent.getServerTransId(),transCurrent.getIncomeAccountName(),null);
                    //手续费收益账户入金
                    innerAccountService.plusBalance(AccountOperSubType.FEE, transCurrent.getIncomeAccount(), transCurrent.getMerFee(),transCurrent.getFeeAccount(),"预付费卡清算成功，手续费入金",transCurrent.getServerTransId(),transCurrent.getFeeAccountName(),null);
                }
                fileUploadLog.setTransStatus(transStatus.name());
                fileUploadLog.setTransDesc(StringUtil.substring(transDesc,0,50));
                fileUploadLog.setGmtModified(new Date());
                MybatisDaoImpl.run().updateById(fileUploadLog);
                MybatisDaoImpl.run().updateBatchById(list);
                String updateSql = String.format("jobtask_state = '%s',catch_exception = null ", JobTaskStatus.WAITING.name());
                String taskId = JobTaskId.ACCOUNTSETTLE_TASKID.getTaskId(fileUploadLog.getIndustryCode(),fileUploadLog.getBizDate(),fileUploadLog.getBatchId());
                MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder().andJobIdEq(JobTaskId.ACCOUNTSETTLE_RETURN_JOBID.getId()).andTaskIdEq(taskId).and().andJobtaskStateNe(JobTaskStatus.RUNNING.name()).orJobtaskStateIsNull().build());
            });
        }
    }

    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void callbackFailure(TransCurrent transCurrent,TransStatus transStatus){
        FileUploadLog fileUploadLog = MybatisDaoImpl.run().selectOne(FileUploadLogCondition.builder()
                .andIndustryCodeEq(transCurrent.getIndustryCode())
                .andBatchIdEq(transCurrent.getServerBatchNo())
                .andServerTransIdEq(transCurrent.getServerTransId())
                .build());
        final String transDesc = StringUtil.isNotBlank(transCurrent.getChannelRespMsg()) ? transCurrent.getChannelRespMsg() : "清算失败";
        if (!(TransStatus.TRADE_SUCCESS.name().equals(fileUploadLog.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(fileUploadLog.getTransStatus()))) {
            List<AccountSettleDetail> accountSettleDetailList = MybatisDaoImpl.run().selectList(AccountSettleDetailCondition.builder().andIndustryCodeEq(fileUploadLog.getIndustryCode()).andBatchIdEq(fileUploadLog.getBatchId()).andSettleDateEq(fileUploadLog.getBizDate()).build());
            Optional.ofNullable(accountSettleDetailList).ifPresent(accountSettleDetails -> {
                List<AccountSettleDetail> list = accountSettleDetails.stream().map(detail ->{
                    if(TransStatus.TRADE_SUCCESS.name().equals(detail.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(detail.getTransStatus())){
                        return detail;
                    }
                    this.unfreezeUserAccount(detail.getUserAccount(),detail.getAmount(),detail.getPayeeAcctNo(),detail.getPayeeName(),"预付费卡清算恢复冻结金额",transCurrent.getServerTransId());
                    detail.setTransStatus(transStatus.name());
                    detail.setTransDesc(StringUtil.substring(transDesc,0,50));
                    detail.setGmtModified(new Date());
                    return detail;
                }).collect(Collectors.toList());
                if(SettleType.REAL_TIME.getType().equals(transCurrent.getMerSettleType()) && ChargeMode.BUCKLE.getMode().equals(transCurrent.getMerChargeMode()) && transCurrent.getMerFee() != null && transCurrent.getMerFee() > 0){
                    innerAccountService.unfreezeBalance(AccountOperSubType.FEE,transCurrent.getFeeAccount(),transCurrent.getMerFee(), transCurrent.getIncomeAccount(), "预付费卡清算失败，恢复冻结手续费",transCurrent.getServerTransId(),transCurrent.getIncomeAccountName(),null);
                }
                fileUploadLog.setTransStatus(transStatus.name());
                fileUploadLog.setTransDesc(StringUtil.substring(transDesc,0,50));
                fileUploadLog.setGmtModified(new Date());
                MybatisDaoImpl.run().updateById(fileUploadLog);
                MybatisDaoImpl.run().updateBatchById(list);
                String updateSql = String.format("jobtask_state = '%s',catch_exception = null ", JobTaskStatus.WAITING.name());
                String taskId = JobTaskId.ACCOUNTSETTLE_TASKID.getTaskId(fileUploadLog.getIndustryCode(),fileUploadLog.getBizDate(),fileUploadLog.getBatchId());
                MybatisDaoImpl.run().updateForSet(updateSql, JobTaskCondition.builder().andJobIdEq(JobTaskId.ACCOUNTSETTLE_RETURN_JOBID.getId()).andTaskIdEq(taskId).and().andJobtaskStateNe(JobTaskStatus.RUNNING.name()).orJobtaskStateIsNull().build());
            });
        }
    }
}
