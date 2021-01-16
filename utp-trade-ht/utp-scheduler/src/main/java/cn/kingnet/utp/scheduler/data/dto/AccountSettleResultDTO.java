package cn.kingnet.utp.scheduler.data.dto;

import java.io.Serializable;

/**
 * @Description : 清算结果DTO
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/7 11:44
 */
public class AccountSettleResultDTO implements Serializable {

    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 清算日期
     */
    private String settleDate;
    /**清算总金额*/
    private String settleAmount;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 清算结果文件域 回执文件byte[]经过 defalter压缩后再Base64编码字符串
     */
    private String content;

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(String settleAmount) {
        this.settleAmount = settleAmount;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
