package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.TransCurrent;
import cn.kingnet.utp.service.persistence.entity.TransOrderRelation;
import cn.kingnet.utp.service.persistence.entity.vo.TransBatchRecordVo;
import cn.kingnet.utp.service.persistence.entity.vo.TransParamFailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description : 交易流水数据处理接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/9/6 15:51
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/transCurrent")
public interface ITransCurrentHandler {

    /**
     * 保存流水
     *
     * @param transCurrentList
     */
    @PostMapping("/saveTransCurrent")
    void saveTransCurrent(@RequestBody(required = false) List<TransCurrent> transCurrentList);

    /**
     * 保存流水关联支付订单信息
     *
     * @param transOrderRelationList
     */
    @PostMapping("/saveTransOrderRelation")
    void saveTransOrderRelation(@RequestBody(required = false) List<TransOrderRelation> transOrderRelationList);

    /**
     * 根据 代付客户号+服务端流水号 更新流水
     *
     * @param transCurrent  更新对象
     * @param industryCode  代付客户号
     * @param serverTransId 服务端流水号
     */
    @PostMapping("/updateByIndustryCodeAndServerTradeId")
    void updateByIndustryCodeAndServerTransId(@RequestBody(required = false) TransCurrent transCurrent,
                                              @RequestParam(value = "industryCode", required = false) String industryCode,
                                              @RequestParam(value = "serverTransId", required = false) String serverTransId);

    /**
     * id更新当前或历史表记录
     * @param transCurrent
     * @param historyStatus
     */
    @PostMapping("/updateCurrentOrHistoryById")
    void updateCurrentOrHistoryById(@RequestBody(required = false) TransCurrent transCurrent, @RequestParam(value = "historyStatus") boolean historyStatus);

    /**
     * 根据 行业代码+客户端流水号 或者 行业代码+服务端流水号查询 交易流水
     *
     * @param industryCode
     * @param clientTransId
     * @param serverTransId
     * @return
     */
    @PostMapping("/queryByIndustryAndClientTransIdOrServerTransId")
    List<TransCurrent> queryByIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                                      @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                                      @RequestParam(value = "serverTransId", required = false) String serverTransId);

    @PostMapping("/getByIndustryAndClientTransIdOrServerTransId")
    TransCurrent getByIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                              @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                              @RequestParam(value = "serverTransId", required = false) String serverTransId);


    /**
     * 批量保存流水及批次信息
     *
     * @param transBatchRecordVo
     */
    @PostMapping("saveTransCurrentAndBatchInfo")
    void saveTransCurrentAndBatchInfo(@RequestBody(required = false) TransBatchRecordVo transBatchRecordVo);

    /**
     * 批量更新流水及批次信息
     *
     * @param transBatchRecordVo
     */
    @PutMapping("updateTransCurrentAndBatchInfo")
    void updateTransCurrentAndBatchInfo(TransBatchRecordVo transBatchRecordVo);

    /**
     * 根据服务端流水号查询单笔交易流水 返回一条
     *
     * @param serverTransId
     * @return
     */
    @PostMapping("queryByServerTrandsId")
    TransCurrent queryByServerTrandsId(@RequestParam(value = "serverTransId") String serverTransId);

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

    @GetMapping("/existIndustryAndClientTransIdOrServerTransId")
    boolean existIndustryAndClientTransIdOrServerTransId(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                         @RequestParam(value = "clientTransId", required = false) String clientTransId,
                                                         @RequestParam(value = "serverTransId", required = false) String serverTransId);

    @GetMapping("/existIndustryAndSuccessOrderId")
    boolean existIndustryAndSuccessOrderId(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "orderId", required = false) String orderId);


    @PostMapping("/setSplitPaymentRedfund")
    boolean setSplitPaymentRedfund(@RequestParam(value = "origClientTradeId", required = false) String origClientTradeId);

    @PostMapping("/deleteSplitPaymentRedfund")
    boolean deleteSplitPaymentRedfund(@RequestParam(value = "origClientTradeId", required = false) String origClientTradeId);

    @PostMapping("/saveTransParamFail")
    void saveTransParamFail(@RequestBody TransParamFailVo transParamFailVo);
}
