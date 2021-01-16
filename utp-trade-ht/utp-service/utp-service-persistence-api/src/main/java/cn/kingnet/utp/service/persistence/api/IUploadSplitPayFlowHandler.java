package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.TransHistory;
import cn.kingnet.utp.service.persistence.entity.UploadSplitPayFlow;
import cn.kingnet.utp.service.persistence.entity.vo.UploadSplitPayFlowVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 分账-支付流水关联补登文件上送
 * @Author WJH
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/uploadSplitPayFlow")
public interface IUploadSplitPayFlowHandler {

    /**
     * 是否存在代付客户&批次记录
     *
     * @param industryCode
     * @param batchId
     * @return
     */
    @GetMapping("isExistIndustryAndBatchId")
    boolean isExistIndustryAndBatchId(@RequestParam(value = "industryCode") String industryCode, @RequestParam(value = "batchId") String batchId);

    /**
     * 是否存在已成功上送的代付客户&客户端流水号
     *
     * @param industryCode
     * @param clientTransId
     * @return
     */
    @GetMapping("isExistIndustryAndClientTransId4Success")
    boolean isExistIndustryAndClientTransId4Success(@RequestParam(value = "industryCode") String industryCode, @RequestParam(value = "clientTransId") String clientTransId);

    @PostMapping("saveUploadSplitPayFlowList")
    void saveUploadSplitPayFlowList(@RequestBody List<UploadSplitPayFlowVo> list);

    /**
     * 根据客户号端流水号查询返回当前或历史交易流水
     *
     * @param industryCode
     * @param clientTransId
     * @return
     */
    @GetMapping("getTransCurrentOrHistoryByClientTransId")
    TransHistory getTransCurrentOrHistoryByClientTransId(@RequestParam(value = "industryCode") String industryCode, @RequestParam(value = "clientTransId") String clientTransId);

    @GetMapping("queryUploadSplitPayFlowList")
    List<UploadSplitPayFlow> queryUploadSplitPayFlowList(@RequestParam("industryCode") String industryCode, @RequestParam("batchNo") String batchNo);

}
