package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.service.persistence.entity.vo.OutsideTransOrderVo;
import cn.kingnet.utp.service.persistence.vo.MixTransInfoAndFilePathVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 支付交易流水上送
 * @Author WJH
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/outsideTransOrder")
public interface IOutsideTransOrderHandler {

    /**
     * 是否存在代付客户&批次记录
     *
     * @param industryCode
     * @param batchId
     * @return
     */
    @GetMapping("isExistIndustryANdBatchId")
    boolean isExistIndustryANdBatchId(@RequestParam(value = "industryCode") String industryCode, @RequestParam(value = "batchId") String batchId);

    /**
     * 是否存在已成功上送的代付客户&支付订单号
     *
     * @param industryCode
     * @param transOrderId
     * @return
     */
    @GetMapping("isExistIndustryANdTransOrderId4Success")
    boolean isExistIndustryANdTransOrderId4Success(@RequestParam(value = "industryCode") String industryCode, @RequestParam(value = "transOrderId") String transOrderId);

    @PostMapping("saveOutsideTransOrderList")
    void saveOutsideTransOrderList(@RequestBody List<OutsideTransOrderVo> list);

    @PostMapping("saveOutsideTransOrder")
    void saveOutsideTransOrder(@RequestBody OutsideTransOrderVo outsideTransOrderVo,@RequestParam("isUpdate")boolean isUpdate);

    @PostMapping("validTransOrderIds")
    boolean validTransOrderIds(@RequestParam("industryCode") String industryCode, @RequestParam(value = "transOrderIds") String transOrderIds, @RequestParam(value = "splitAmount") long splitAmount, @RequestParam("isBrokerageAccount") Boolean isBrokerageAccount, @RequestParam(value = "maxBrokerageRate") Long maxBrokerageRate);

    @GetMapping("queryOutsideTransOrderList")
    List<OutsideTransOrder> queryOutsideTransOrderList(@RequestParam("industryCode") String industryCode, @RequestParam("batchNo") String batchNo);


    /**
     * 根据订单编号查询分账次数
     *
     * @param transOrderId
     * @return
     */
    @GetMapping("queryLinkedSplitNumByTransOrderId")
    Integer queryLinkedSplitNumByTransOrderId(@RequestParam("industryCode") String industryCode, @RequestParam("transOrderId") String transOrderId);

    /**
     * 查询报备成功的支付订单流水信息(单笔)
     *
     * @param industryCode
     * @param transOrderId
     */
    @GetMapping("selectByTransOrderIdAndSuccess")
    OutsideTransOrder selectByTransOrderIdAndSuccess(@RequestParam("industryCode") String industryCode, @RequestParam(value = "transOrderId") String transOrderId);

    /**
     * 查询报备成功的支付订单流水信息(多笔)
     *
     * @param industryCode
     * @param transOrderIds
     * @return
     */
    @PostMapping("selectByTransOrderIdsAndSuccess")
    List<OutsideTransOrder> selectByTransOrderIdsAndSuccess(@RequestParam("industryCode") String industryCode, @RequestParam(value = "transOrderIds") String transOrderIds);

    /**
     * 查询单笔支付流水PDF路径
     *
     * @param id
     * @return
     */
    @GetMapping("queryFilePathById")
    String queryFilePathById(@RequestParam(value = "id") long id);

    /**
     * 更新 外部订单记录分账状态及关联分账记录数
     *
     * @param industryCode
     * @param transOrderIds
     */
    @PostMapping("updateSplitStatusAndLinkedSplitNum")
    void updateSplitStatusAndLinkedSplitNum(@RequestParam("industryCode") String industryCode, @RequestParam("transOrderIds") String transOrderIds);

    @PostMapping("parseMixTransDetailTxtFileAsync")
    void parseMixTransDetailTxtFileAsync(@RequestBody MixTransInfoAndFilePathVO mixTransInfoAndFilePathVO);

}
