package cn.kingnet.utp.trade.common.dto.onebank;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.enums.FundAccType;

import java.io.Serializable;

/**
 * @Description : 对账文件下载
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/23 11:19
 */
public class OneBankStatementDownLoadReqDTO extends SpBaseRequest implements Serializable {

    /**对账文件日期*/
    private String settleDate;

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }
}
