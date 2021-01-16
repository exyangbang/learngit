package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.TransHistory;
import cn.kingnet.utp.service.persistence.entity.vo.TransCurrentVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 历史交易流水处理接口
 * @Author WJH
 * @Date 2018年09月09日
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/transHistory")
public interface ITransHistoryHandler {

    /**
     * 保存历史流水信息
     *
     * @param transHistoryList
     */
    @PostMapping("/saveTransCurrent")
    void saveTransHistory(@RequestBody(required = false) List<TransHistory> transHistoryList);

    /**
     * 根据 行业代码+客户端流水号 或者 行业代码+服务端流水号查询 交易流水
     *
     * @param industryCode
     * @param clientTransId
     * @param serverTransId
     * @return
     */
    @PostMapping("/queryByIndustryAndClientTransIdOrServerTransId")
    List<TransHistory> queryByIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                      @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                      @RequestParam(value = "serverTransId", required = false) String serverTransId);

    /**
     * 获取对账记录
     *
     * @param industryCode 平台代码
     * @param settleDate   对账日期
     * @return
     */
    @PostMapping("/querySettleDataByIndustryCodeAndDate")
    public List<TransHistory> querySettleDataByIndustryCodeAndDate(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                   @RequestParam(value = "settleDate", required = false) String settleDate);

    /**
     * 行业代码 + 客户端流水号 或者 行业代码 + 批次号 是否存在
     *
     * @param industryCode
     * @param clientTransId
     * @param batchId
     * @return
     */
    @PostMapping("/isExistByIndustryCodeAndClientTransIdOrBatchId")
    boolean isExistByIndustryCodeAndClientTransIdOrBatchId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                           @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                           @RequestParam(value = "batchId", required = false) String batchId);

    /**
     * 查询下载平台对账单数据
     *
     * @param industryCode
     * @param reconcileDate
     * @return
     */
    @GetMapping("/downloadReconcileData")
    List<TransCurrentVo> downloadReconcileData(@RequestParam(value = "industryCode") String industryCode,
                                               @RequestParam(value = "reconcileDate") String reconcileDate);

    @PostMapping("/downloadIndustryD1SpecailReconFile")
    byte[] downloadIndustryD1SpecailReconFile(@RequestParam("industryCode") String industryCode, @RequestParam("txDate") String txDate);

    @PostMapping("/downloadIndustrySubAccountDailyBalanceFile")
    byte[] downloadIndustrySubAccountDailyBalanceFile(@RequestParam("industryCode") String industryCode, @RequestParam("txDate") String txDate);

}
