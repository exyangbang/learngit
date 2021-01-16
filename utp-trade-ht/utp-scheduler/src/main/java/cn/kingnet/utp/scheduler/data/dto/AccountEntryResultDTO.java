package cn.kingnet.utp.scheduler.data.dto;

import java.io.Serializable;

/**
 * @Description : 入账结果DTO
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/6 3:33
 */
public class AccountEntryResultDTO implements Serializable {

    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 入账日期
     */
    private String entryDate;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 入账结果文件域 回执文件byte[]经过 defalter压缩后再Base64编码字符串
     */
    private String content;

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
