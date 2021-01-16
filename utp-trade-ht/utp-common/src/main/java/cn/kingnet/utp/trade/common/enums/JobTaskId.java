package cn.kingnet.utp.trade.common.enums;

/**
 * @Description : jobId taskId_prefix
 */
public enum JobTaskId {

    SETTLESPLIT_TASKID("SETTLESPLIT", "平台清分任务Id前缀"),
    SETTLESPLIT_PROCESS_JOBID_EB("SETTLESPLIT-PROCESS-EB", "平台清分T+0处理"),
    SETTLESPLIT_RETURN_JOBID_EB("SETTLESPLIT-RETURN-EB", "平台清分结果回调"),
    SETTLESPLIT_PROCESS_JOBID_TN("SETTLESPLIT-PROCESS-TN", "平台清分T+n处理"),

    ACCOUNTENTRY_TASKID("ACCOUNTENTRY", "预付费卡入账任务Id前缀"),
    ACCOUNTENTRY_PROCESS_JOBID("ACCOUNTENTRY-PROCESS", "预付费卡入账处理"),
    ACCOUNTENTRY_RETURN_JOBID("ACCOUNTENTRY-RETURN", "预付费卡入账回调处理"),

    ACCOUNTSETTLE_TASKID("ACCOUNTSETTLE", "预付费卡清算任务Id前缀"),
    ACCOUNTSETTLE_PROCESS_JOBID("ACCOUNTSETTLE-PROCESS", "预付费卡清算处理"),
    ACCOUNTSETTLE_RETURN_JOBID("ACCOUNTSETTLE-RETURN", "预付费卡清算回调处理"),

    ACCOUNT_ELE_RECEIPT_PDF_TASKID("ACCTELERECEIPTPDF", "开户电子回单Id前缀"),
    ACCOUNT_ELE_RECEIPT_PDF_PROCESS_JOBID("ACCTELERECEIPTPDF-PROCESS", "开户电子回单处理"),;


    private String id;

    private String name;

    JobTaskId(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaskId(String industryCode, String settleDate, String batchId){
        return String.format("%s-%s-%s-%s", this.getId(), industryCode, settleDate, batchId);
    }
}
