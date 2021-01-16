package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IAccountEntryHandler;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.AccountEntryBatchBO;
import cn.kingnet.utp.service.persistence.service.AccountEntryService;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description : 入账信息处理服务
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/17 18:26
 */
@RestController
@RequestMapping("/spi/persistence/accountEntry")
@Slf4j
public class AccountEntryHandler extends DefaultFeginExceptionHandler implements IAccountEntryHandler {

    @Autowired
    private AccountEntryService accountEntryService;

    /**
     * 持久化入账上送明细信息
     *
     * @param accountEntryBatchBO
     */
    @Override
    @PostMapping("/saveAccountEntryBatchAndJobTask")
    @Transactional(rollbackFor = Exception.class)
    public void saveAccountEntryBatchAndJobTask(@RequestBody(required = false) AccountEntryBatchBO accountEntryBatchBO) {
        FileUploadLog fileUploadLog = accountEntryBatchBO.getFileUploadLog();
        List<AccountEntryDetail> accountEntryDetailList = accountEntryBatchBO.getAccountEntryDetailList();
        if (accountEntryBatchBO != null && fileUploadLog != null && accountEntryDetailList != null && accountEntryDetailList.size() > 0) {
            int count = MybatisDaoImpl.run().selectCount(FileUploadLogCondition.builder().andIndustryCodeEq(fileUploadLog.getIndustryCode()).andBatchIdEq(fileUploadLog.getBatchId()).build());
            if (count > 0) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("批次%s的入账记录已存在!", fileUploadLog.getBatchId()));
            }
            MybatisDaoImpl.run().insert(fileUploadLog);
            MybatisDaoImpl.run().insertBatch(accountEntryDetailList);
            if (fileUploadLog.getPeriod() == 0) {
                //创建任务
                final String taskId = JobTaskId.ACCOUNTENTRY_TASKID.getTaskId(fileUploadLog.getIndustryCode(), fileUploadLog.getBizDate(), fileUploadLog.getBatchId());
                final String taskArgs = new StringBuffer()
                        .append("   --industryCode=" + fileUploadLog.getIndustryCode()).append("\n")
                        .append("   --entryDate=" + fileUploadLog.getBizDate()).append("\n")
                        .append("   --batchId=" + fileUploadLog.getBatchId()).append("\n").toString();
                //1.电商平台创建入账文件数据处理任务 ||入虚账及明细，更新商户账户表信息
                this.createJobTask(taskId, JobTaskId.ACCOUNTENTRY_PROCESS_JOBID, JobTaskStatus.WAITING, taskArgs);
                //2.创建入账结果回调文件任务 || 查询数据处理结果并生成回调文件及推送
                this.createJobTask(taskId, JobTaskId.ACCOUNTENTRY_RETURN_JOBID, JobTaskStatus.PREP, taskArgs);
            }
        }
    }

    /**
     * 查询入账明细列表
     *
     * @param industryCode
     * @param entryDate
     * @param batchId
     * @return
     */
    @Override
    @PostMapping("/findAccountEntryDetailList")
    public List<AccountEntryDetail> findAccountEntryDetailList(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "entryDate", required = false) String entryDate, @RequestParam(value = "batchId", required = false) String batchId) {
        if (StringUtil.isBlank(industryCode) || StringUtil.isBlank(entryDate) || StringUtil.isBlank(batchId))
            return null;
        return MybatisDaoImpl.run().selectList(AccountEntryDetailCondition.builder().andIndustryCodeEq(industryCode).andBatchIdEq(batchId).andEntryDateEq(entryDate).build());
    }

    /**
     * 入账处理
     * @param accountEntryDetailId 入账明细ID
     * @return
     */
    @Override
    @PostMapping("/processAccountEntry")
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public AccountEntryDetail processAccountEntry(@RequestParam(value = "accountEntryDetailId", required = false) Long accountEntryDetailId) {
        AccountEntryDetail accountEntryDetail = MybatisDaoImpl.run().selectById(AccountEntryDetail.class,accountEntryDetailId);
        if(accountEntryDetail == null) return null;
        if(TransStatus.TRADE_SUCCESS.name().equals(accountEntryDetail.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(accountEntryDetail.getTransStatus())){
            return accountEntryDetail;
        }
        try{
            Account account = accountEntryService.processAccountEntry(accountEntryDetail);
            accountEntryDetail.setUserAccount(account.getAccount());
            accountEntryDetail.setHandleStatus(TrueOrFalseStatus.TRUE.value());
            accountEntryDetail.setTransStatus(TransStatus.TRADE_SUCCESS.name());
            accountEntryDetail.setTransDesc("入账成功!");
        }catch (Exception e){
            accountEntryDetail.setHandleStatus(TrueOrFalseStatus.TRUE.value());
            accountEntryDetail.setTransStatus(TransStatus.TRADE_FAILURE.name());
            String transDesc = "入账失败";
            if(e instanceof PersistenceException) transDesc = e.getMessage();
            accountEntryDetail.setTransDesc(StringUtil.substring(transDesc,0,50));
            log.error("平台{}-批次{}-入账日期{}-帐号{}-入账异常", accountEntryDetail.getIndustryCode(), accountEntryDetail.getBatchId(),accountEntryDetail.getEntryDate(),accountEntryDetail.getAccountNo(), e);
        }
        accountEntryDetail.setGmtModified(new Date());
        MybatisDaoImpl.run().updateById(accountEntryDetail);
        return accountEntryDetail;
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
