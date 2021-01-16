package cn.kingnet.utp.service.persistence.entity.bo;

import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 华通清算分账文件信息
 * @Author WJH
 * @Date 2018年10月18日
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HTSettleSplitInfoBo implements Serializable {

    /**
     * 代付客户号
     */
    private String industryCode;

    /**
     * 批次ID/批次号
     */
    private String batchId;

    /**
     * 清算日期 yyyyMMdd
     */
    private String settleDate;

    /**
     * 总笔数：
     */
    private long totalCount;
    /**
     * 同批次 账期必须全0或非全0  0:T0  1：Tn
     */
    private int period;

    private List<SplitInfo> splitInfoList;


}
