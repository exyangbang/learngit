package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.MerchantBatchRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description : 批量流水记录处理接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 15:51
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/merchantBatchRecord")
public interface IMerchantBatchRecordHandler {

    /**
     * 保留流水
     *
     * @param merchantBatchRecord
     */
    @PostMapping("/saveMerchantBatchRecord")
    void saveMerchantBatchRecord(@RequestBody(required = false) MerchantBatchRecord merchantBatchRecord);

    /**
     * 根据 商户号+服务端流水号 更新流水
     *
     * @param merchantBatchRecord 更新对象
     * @param merNo               商户号
     * @param serverTransId       服务端流水号
     */
    @PostMapping("/updateByMernoAndServerTradeId")
    void updateByMernoAndServerTransId(@RequestBody(required = false) MerchantBatchRecord merchantBatchRecord,
                                       @RequestParam(value = "merNo", required = false) String merNo,
                                       @RequestParam(value = "serverTransId", required = false) String serverTransId);

    /**
     * 根据 商户号+客户端流水号 或者 商户号+服务端流水号查询 交易流水
     *
     * @param merNo
     * @param clientTransId
     * @param serverTransId
     * @return
     */
    @PostMapping("/queryByMernoAndClientTransIdOrServerTransId")
    MerchantBatchRecord queryByMernoAndClientTransIdOrServerTransId(@RequestParam(value = "merNo", required = false) String merNo,
                                                                    @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                    @RequestParam(value = "serverTransId", required = false) String serverTransId);

    /**
     * 根据 商户号+批次号 更新流水
     *
     * @param merchantBatchRecord 更新对象属性
     * @param merNo               商户条件
     * @param batchNo             批次号条件
     */
    @PostMapping("/updateByMerNoAndBatchNo")
    void updateByMerNoAndBatchNo(@RequestBody(required = false) MerchantBatchRecord merchantBatchRecord,
                                 @RequestParam(value = "merNo", required = false) String merNo,
                                 @RequestParam(value = "batchNo", required = false) String batchNo);


    /**
     * 根据 商户号+批次号查询 交易流水
     *
     * @param merNo
     * @param batchId
     * @return
     */
    @PostMapping("/queryByMernoAndBatchId")
    MerchantBatchRecord queryByMernoAndBatchId(@RequestParam(value = "merNo", required = false) String merNo,
                                               @RequestParam(value = "batchId", required = false) String batchId);

    /**
     *  查询交易时间大于min后未完成处理的流水记录
     * @param min
     * @return
     */
    @GetMapping("/queryUncompletedAndGtMin")
    List<MerchantBatchRecord> queryUncompletedAndGtMin(@RequestParam("min") int min);

    /**
     * 是否已存在 商户号+批次号
     * @param merNo
     * @param batchNo
     */
    @GetMapping("/isExistByMerNoAndBatchNo")
    boolean isExistByMerNoAndBatchNo(@RequestParam(value = "merNo", required = false) String merNo,
                                 @RequestParam(value = "batchNo", required = false) String batchNo);

}