package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.SplitInfoUploadLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 清算分账上送日志业务
 * @Author WJH
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/splitInfoUploadLog")
public interface ISplitInfoUploadLogHandler {


    /**
     * 持久化 清算分账文件
     *
     * @param splitInfoUploadLog
     */
    @PostMapping("/saveSplitInfoUploadLog")
    void saveSplitInfoUploadLog(@RequestBody(required = false) SplitInfoUploadLog splitInfoUploadLog);



    /**
     * 更新 清算分账上送纪录状态
     *
     * @param splitInfoUploadLog
     */
    @PutMapping("/updateSplitInfoUploadLogStatus")
    void updateSplitInfoUploadLogStatus(@RequestBody(required = false) SplitInfoUploadLog splitInfoUploadLog);


    /**
     * 异常回退
     * 1.清算分账上送纪录状态变更为失败
     * 2.删除关联的清算任务及关联的分账信息
     *
     * @param splitInfoUploadLog
     */
    @PostMapping("/rollbackSplitInfoUploadLog")
    void rollbackSplitInfoUploadLog(@RequestBody(required = false) SplitInfoUploadLog splitInfoUploadLog);


    /**
     * 清算分账信息：是否存在
     *
     * @param providerCode
     * @param settleDate
     * @param batchId
     * @param transStatus
     * @return
     */
    @GetMapping("/isExistSplitInfoUploadLog")
    boolean isExistSplitInfoUploadLog(
            @RequestParam(value = "providerCode", required = false) String providerCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchId", required = false) String batchId,
            @RequestParam(value = "transStatus", required = false) String transStatus
    );


    /**
     * @param providerCode 文件提供方
     * @param settleDate   清算日期
     * @param batchId      批次ID
     * @return
     */
    @GetMapping("querySplitInfoByBatchId")
    SplitInfoUploadLog querySplitInfoByBatchId(@RequestParam(value = "providerCode", required = false) String providerCode,
                                               @RequestParam(value = "settleDate", required = false) String settleDate,
                                               @RequestParam(value = "batchId", required = false) String batchId
    );

    /**
     * 实时 创建清算分账文件处理任务
     *
     * @param providerCode
     * @param settleDate
     * @param batchId
     */
    @PostMapping("/createJobTask4SplitInfo")
    void createJobTask4SplitInfo(@RequestParam(value = "providerCode", required = false) String providerCode,
                                 @RequestParam(value = "settleDate", required = false) String settleDate,
                                 @RequestParam(value = "batchId", required = false) String batchId);


}
