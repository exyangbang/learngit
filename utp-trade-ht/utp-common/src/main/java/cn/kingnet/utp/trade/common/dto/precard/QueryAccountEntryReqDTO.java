package cn.kingnet.utp.trade.common.dto.precard;

import cn.kingnet.utp.trade.common.dto.BaseRequestDTO;

/**
 * @Description : 预付费卡入账结果查询
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/18 14:27
 */
public class QueryAccountEntryReqDTO extends BaseRequestDTO {

    /**
     * 入账日期 yyyyMMdd
     */
    private String entryDate;

    /**
     * 批次号
     */
    private String batchNo;

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
}
