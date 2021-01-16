package cn.kingnet.utp.trade.common.dto.account;

import java.io.Serializable;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月13日
 */
public class SplitInfoResultDTO implements Serializable {

    /**
     * 客户号
     */
    private String industryCode;
    /**
     * 清算日期
     */
    private String settleDate;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 批次状态 FileBatchStatus
     */
    private String batchStatus;
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

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }
}
