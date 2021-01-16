package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.UploadSubAccountIncomeFlow;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 子账户入金流水报备
 * @Author WJH
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/uploadSubAccountIncomeFlow")
public interface IUploadSubAccountIncomeFlowHandler {

    /**
     * 是否存在入金流水号
     *
     * @param incomeFlowId
     * @return
     */
    @GetMapping("isExistIncomeFlowId")
    boolean isExistIncomeFlowId(@RequestParam(value = "subAccount")String subAccount,@RequestParam(value = "incomeFlowId") String incomeFlowId);

    /**
     * 是否存在批次
     * @param batchNo
     * @return
     */
    @GetMapping("isExistBatchNo")
    boolean isExistBatchNo(@RequestParam(value = "batchNo") String batchNo);

    /**
     * 保存 入金流水报备信息
     *
     * @param uploadSubAccountIncomeFlowList
     */
    @PostMapping("save")
    void save(@RequestBody List<UploadSubAccountIncomeFlow> uploadSubAccountIncomeFlowList);

    @PostMapping("queryByIndustryAndBatchNo")
    List<UploadSubAccountIncomeFlow> queryByIndustryAndBatchNo(@RequestParam(value="industryCode") String industryCode, @RequestParam(value = "batchNo") String batchNo);
}
