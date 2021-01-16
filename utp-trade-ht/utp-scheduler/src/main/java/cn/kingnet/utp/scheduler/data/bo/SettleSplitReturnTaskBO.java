package cn.kingnet.utp.scheduler.data.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description 清分文件 回盘任务参数
 * @Author WJH
 * @Date 2019/10/17
 */
@Getter
@Setter
public class SettleSplitReturnTaskBO implements Serializable {
    /**
     * 文件提供方编号|代付客户号 industryCode
     */
    private String providerCode;
    /**
     * 清算日期
     */
    private String settleDate;
    /**
     * 批次号
     */
    private String batchId;

}
