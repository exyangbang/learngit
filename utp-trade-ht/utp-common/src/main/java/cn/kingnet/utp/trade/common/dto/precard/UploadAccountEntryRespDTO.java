package cn.kingnet.utp.trade.common.dto.precard;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;

/**
 * @Description : 预付费卡入账文件上送
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/16 13:11
 */
public class UploadAccountEntryRespDTO extends BaseResponseDTO {

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 入账日期 yyyyMMdd
     */
    private String entryDate;

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

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
