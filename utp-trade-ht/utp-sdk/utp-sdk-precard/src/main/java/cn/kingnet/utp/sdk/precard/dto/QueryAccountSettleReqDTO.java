package cn.kingnet.utp.sdk.precard.dto;


import cn.kingnet.utp.sdk.core.dto.BaseRequestDTO;

/**
 * @Description : 预付费卡清算结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 14:11
 */
public class QueryAccountSettleReqDTO extends BaseRequestDTO {

    /**
     * 清算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * 批次号
     */
    private String batchNo;

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
}
