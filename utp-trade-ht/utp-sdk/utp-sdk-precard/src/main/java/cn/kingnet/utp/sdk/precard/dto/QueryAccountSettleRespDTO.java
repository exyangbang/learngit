package cn.kingnet.utp.sdk.precard.dto;


import cn.kingnet.utp.sdk.core.dto.BaseResponseDTO;

/**
 * @Description : 预付费卡清算结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 14:12
 */
public class QueryAccountSettleRespDTO extends BaseResponseDTO {

    /**
     * 清算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 清算总金额
     */
    private String settleAmount;

    /**
     * boolean 入账成功标志	成功-true 失败-false
     */
    private String success = Boolean.FALSE.toString();

    /**
     * 实时文件流内容，base64字符串 必填
     */
    private String content;

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(String settleAmount) {
        this.settleAmount = settleAmount;
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
