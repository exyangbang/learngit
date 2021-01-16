package cn.kingnet.utp.trade.common.dto.precard;

import cn.kingnet.utp.trade.common.dto.BaseResponseDTO;

/**
 * @Description : 预付费卡入账结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/18 14:28
 */
public class QueryAccountEntryRespDTO extends BaseResponseDTO {

    /**
     * 入账日期 yyyyMMdd
     */
    private String entryDate;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success = Boolean.FALSE.toString();

    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
