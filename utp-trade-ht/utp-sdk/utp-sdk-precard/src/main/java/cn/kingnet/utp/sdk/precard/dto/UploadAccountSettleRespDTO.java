package cn.kingnet.utp.sdk.precard.dto;

import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;

/**
 * @Description : 预付费卡清算文件上送
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 13:30
 */
public class UploadAccountSettleRespDTO extends BaseResponseDTO {

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 清算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success = Boolean.FALSE.toString();

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
