package cn.kingnet.utp.service.persistence.entity.vo;

import cn.kingnet.utp.service.persistence.entity.MerchantBatchRecord;
import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.TransHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TransBatchRecordVo implements java.io.Serializable {

    /**
     * 当前流水记录集
     */
    private List<TransCurrent> currentList;

    /**
     * 历史流水记录集
     */
    private List<TransHistory> historyList;

    /**
     * 批量流水记录
     */
    private MerchantBatchRecord batchRecord;
}