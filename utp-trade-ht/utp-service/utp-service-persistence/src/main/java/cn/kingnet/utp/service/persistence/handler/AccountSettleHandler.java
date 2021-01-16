package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IAccountSettleHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.AccountSettleBatchBO;
import cn.kingnet.utp.service.persistence.service.AccountSettleService;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description : 清算信息处理服务
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 16:09
 */
@RestController
@RequestMapping("/spi/persistence/accountSettle")
@Slf4j
public class AccountSettleHandler extends DefaultFeginExceptionHandler implements IAccountSettleHandler {

    @Resource
    private AccountSettleService accountSettleService;

    /**
     * 持久化清算上送信息
     * @param accountSettleBatchBO
     */
    @Override
    @PostMapping("/saveAccountSettleBatchAndJobTask")
    @Transactional(rollbackFor = Exception.class)
    public void saveAccountSettleBatchAndJobTask(@RequestBody(required = false) AccountSettleBatchBO accountSettleBatchBO) {
        FileUploadLog fileUploadLog = accountSettleBatchBO.getFileUploadLog();
        List<AccountSettleDetail> accountSettleDetailList = accountSettleBatchBO.getAccountSettleDetailList();
        if (accountSettleBatchBO != null && fileUploadLog != null && accountSettleDetailList != null && accountSettleDetailList.size() > 0) {
            int count = MybatisDaoImpl.run().selectCount(FileUploadLogCondition.builder().andIndustryCodeEq(fileUploadLog.getIndustryCode()).andBatchIdEq(fileUploadLog.getBatchId()).build());
            if (count > 0) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("批次%s的入账记录已存在!", fileUploadLog.getBatchId()));
            }
            MybatisDaoImpl.run().insert(fileUploadLog);
            MybatisDaoImpl.run().insertBatch(accountSettleDetailList);
            if(fileUploadLog.getPeriod() == 0){
                //创建任务
                final String taskId = JobTaskId.ACCOUNTSETTLE_TASKID.getTaskId(fileUploadLog.getIndustryCode(),fileUploadLog.getBizDate(),fileUploadLog.getBatchId());
                final String taskArgs = new StringBuffer()
                        .append("   --industryCode=" + fileUploadLog.getIndustryCode()).append("\n")
                        .append("   --settleDate=" + fileUploadLog.getBizDate()).append("\n")
                        .append("   --batchId=" + fileUploadLog.getBatchId()).append("\n").toString();
                //1.电商平台创建清算文件数据处理任务
                this.createJobTask(taskId, JobTaskId.ACCOUNTSETTLE_PROCESS_JOBID, JobTaskStatus.WAITING,taskArgs);
                //2.创建清算结果回调文件任务 || 查询数据处理结果并生成回调文件及推送
                this.createJobTask(taskId,JobTaskId.ACCOUNTSETTLE_RETURN_JOBID,JobTaskStatus.PREP,taskArgs);
            }
        }
    }

    /**
     * 查询清算信息列表
     * @param industryCode
     * @param settleDate
     * @param batchId
     * @return
     */
    @Override
    @PostMapping("/findAccountSettleDetailList")
    public List<AccountSettleDetail> findAccountSettleDetailList(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "settleDate", required = false) String settleDate, @RequestParam(value = "batchId", required = false) String batchId) {
        if(StringUtil.isBlank(industryCode) || StringUtil.isBlank(settleDate) || StringUtil.isBlank(batchId)) return null;
        return MybatisDaoImpl.run().selectList(AccountSettleDetailCondition.builder().andIndustryCodeEq(industryCode).andBatchIdEq(batchId).andSettleDateEq(settleDate).build());
    }

    /**
     * 清算处理冻结金额
     * @param accountSettleDetailId 清算明细ID
     * @return
     */
    @Override
    @PostMapping("/freezeDetailAccout")
    @Transactional(rollbackFor = Exception.class)
    public AccountSettleDetail freezeDetailAccout(@RequestParam(value = "accountSettleDetailId", required = false) Long accountSettleDetailId,@RequestParam(value = "serverTransId", required = false) String serverTransId) {
        AccountSettleDetail accountSettleDetail = MybatisDaoImpl.run().selectById(AccountSettleDetail.class,accountSettleDetailId);
        if(accountSettleDetail == null) return null;
        if (TransStatus.TRADE_SUCCESS.name().equals(accountSettleDetail.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(accountSettleDetail.getTransStatus()) || TransStatus.PROCESSING.name().equals(accountSettleDetail.getTransStatus())) {
            return accountSettleDetail;
        }
        try{
            Account account = accountSettleService.freezeBalanceUserAccount(accountSettleDetail,serverTransId);
            accountSettleDetail.setUserAccount(account.getAccount());
            accountSettleDetail.setHandleStatus(TrueOrFalseStatus.TRUE.value());
            accountSettleDetail.setProvisionFlag(TrueOrFalseStatus.TRUE.value());
            accountSettleDetail.setTransStatus(TransStatus.PROCESSING.name());
            accountSettleDetail.setTransDesc("清算文件已处理,等待提现!");
        }catch (Exception e){
            accountSettleDetail.setHandleStatus(TrueOrFalseStatus.TRUE.value());
            accountSettleDetail.setProvisionFlag(TrueOrFalseStatus.FALSE.value());
            accountSettleDetail.setTransStatus(TransStatus.TRADE_FAILURE.name());
            String transDesc = "清算失败";
            if(e instanceof PersistenceException) transDesc = e.getMessage();
            accountSettleDetail.setTransDesc(StringUtil.substring(transDesc,0,50));
            log.error("平台{}-批次{}-清算日期{}-帐号{}-清算异常", accountSettleDetail.getIndustryCode(), accountSettleDetail.getBatchId(),accountSettleDetail.getSettleDate(),accountSettleDetail.getAccountNo(), e);
        }
        accountSettleDetail.setGmtModified(new Date());
        MybatisDaoImpl.run().updateById(accountSettleDetail);
        return accountSettleDetail;
    }

    /**
     * 预付费卡清算恢复冻结金额
     * @param accountSettleDetailId 清算明细ID
     * @param serverTransId
     * @param transStatus
     * @param transDesc
     * @return
     */
    @Override
    @PostMapping("/unfreezeDetailAccout")
    @Transactional(rollbackFor = Exception.class)
    public AccountSettleDetail unfreezeDetailAccout(@RequestParam(value = "accountSettleDetailId", required = false) Long accountSettleDetailId,
                                                    @RequestParam(value = "serverTransId", required = false) String serverTransId,
                                                    @RequestParam(value = "transStatus", required = false) String transStatus,
                                                    @RequestParam(value = "transDesc", required = false) String transDesc) {
        AccountSettleDetail accountSettleDetail = MybatisDaoImpl.run().selectById(AccountSettleDetail.class,accountSettleDetailId);
        if(accountSettleDetail == null) return null;
        accountSettleService.unfreezeUserAccount(accountSettleDetail.getUserAccount(),accountSettleDetail.getAmount(),accountSettleDetail.getPayeeAcctNo(),accountSettleDetail.getPayeeName(),"预付费卡清算恢复冻结金额",serverTransId);
        accountSettleDetail.setTransStatus(transStatus);
        accountSettleDetail.setTransDesc(StringUtil.substring(transDesc,0,50));
        accountSettleDetail.setGmtModified(new Date());
        MybatisDaoImpl.run().updateById(accountSettleDetail);
        return accountSettleDetail;
    }

    /**
     * 预付费卡清算对账处理
     * @param industryCode
     * @param serverTransId
     * @param targetTransStatus
     * @param transDesc
     * @return
     */
    @PostMapping("/reconciliationProcess")
    @Transactional(rollbackFor = Exception.class)
    public boolean reconciliationProcess(@RequestParam(value = "industryCode", required = false) String industryCode,
                                  @RequestParam(value = "serverTransId", required = false) String serverTransId,
                                  @RequestParam(value = "targetTransStatus", required = false) String targetTransStatus,
                                  @RequestParam(value = "transDesc", required = false) String transDesc){
        if (StringUtil.isBlank(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "企业编号(平台编号)不能为空");
        }

        if (StringUtil.isBlank(serverTransId)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "产品编号不能为空");
        }

        if (StringUtil.isBlank(targetTransStatus)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "交易状态不能为空");
        }

        FileUploadLog fileUploadLog = MybatisDaoImpl.run().selectOne(FileUploadLogCondition.builder().andIndustryCodeEq(industryCode).andServerTransIdEq(serverTransId).build());
        if(fileUploadLog == null || StringUtil.isBlank(fileUploadLog.getBatchId())) throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("预付费卡清算找不到流水号：%s 上送信息.",serverTransId));
        List<AccountSettleDetail> accountSettleDetailList = MybatisDaoImpl.run().selectList(AccountSettleDetailCondition.builder().andIndustryCodeEq(fileUploadLog.getIndustryCode()).andBatchIdEq(fileUploadLog.getBatchId()).build());
        if(CollectionUtils.isEmpty(accountSettleDetailList)) throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("预付费卡清算找不到流水号：%s 明细信息.",serverTransId));

        List<AccountSettleDetail> resultList = accountSettleDetailList.stream()
                .filter(accountSettleDetail -> TrueOrFalseStatus.TRUE.value().equals(accountSettleDetail.getProvisionFlag()))
                .filter(accountSettleDetail -> !targetTransStatus.equals(accountSettleDetail.getTransStatus()))
                .map(accountSettleDetail -> {
                    accountSettleDetail.setTransStatus(targetTransStatus);
                    if(StringUtil.isNotBlank(transDesc)) accountSettleDetail.setTransDesc(StringUtil.substring(transDesc,0,50));
                    accountSettleDetail.setGmtModified(new Date());
                    return accountSettleDetail;
                }).collect(Collectors.toList());

        if (resultList.size() > 0) MybatisDaoImpl.run().updateBatchById(resultList);

        if(!targetTransStatus.equals(fileUploadLog.getTransStatus())){
            fileUploadLog.setTransStatus(targetTransStatus);
            if(StringUtil.isNotBlank(transDesc)) fileUploadLog.setTransDesc(StringUtil.substring(transDesc,0,50));
            fileUploadLog.setGmtModified(new Date());
            MybatisDaoImpl.run().updateById(fileUploadLog);
        }
        return true;
    }

    /**
     * 创建任务
     *
     * @param taskId
     * @param jobTaskId
     * @param jobTaskStatus
     * @param taskArgs
     */
    private void createJobTask(String taskId, JobTaskId jobTaskId, JobTaskStatus jobTaskStatus, String taskArgs) {
        int count = MybatisDaoImpl.run().selectCount(JobTaskCondition.builder()
                .andTaskIdEq(taskId).andJobIdEq(jobTaskId.getId()).build());
        if (count > 0) {
            return;
        }
        JobTask jobTask = JobTask.builder().jobDate(DateUtil.getCurrentDate())
                .jobId(jobTaskId.getId())
                .jobtaskState(jobTaskStatus.name())
                .taskId(taskId)
                .jobPriority(1)
                .jobName(jobTaskId.getName())
                .retryTimes(0)
                .id(IdGenerate.getId())
                .taskArgs(taskArgs)
                .gmtCreate(new Date())
                .gmtModified(new Date())
                .build();
        MybatisDaoImpl.run().insert(jobTask);
    }
}
