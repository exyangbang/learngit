package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import cn.kingnet.utp.service.persistence.entity.bo.HTSettleSplitInfoBo;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 清算分账处理
 * @Author WJH
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/splitInfo")
public interface ISplitInfoHandler {


    /**
     * 持久化 清算分账文件
     *
     * @param htSettleSplitInfoBo
     */
    @PostMapping("/saveSplitInfoBatch")
    void saveSplitInfoBatch(@RequestBody(required = false) HTSettleSplitInfoBo htSettleSplitInfoBo);

    /**
     * @param providerCode 文件提供方
     * @param splitDate    清算分账日期
     * @return
     */
    @GetMapping("querySplitInfo")
    List<SplitInfo> querySplitInfo(@RequestParam(value = "providerCode", required = false) String providerCode,
                                   @RequestParam(value = "splitDate", required = false) String splitDate);


    /**
     * 清算分账信息：处理入账
     *
     * @param industryCode
     * @param settleDate
     * @param batchId
     * @return
     */
    @PostMapping("/batchProcessSplitInfo4T0")
    boolean batchProcessSplitInfo4T0(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchId", required = false) String batchId
    );

    /**
     * T+n 清算分账信息：处理入账
     *
     * @param splitDate
     * @return
     */
    @PostMapping("/processSplitInfo4TN")
    List<SplitInfo> processSplitInfo4TN(@RequestParam(value = "splitDate", required = false) String splitDate);

    /**
     * 清算分账信息：是否存在
     *
     * @param providerCode
     * @param settleDate
     * @param batchId
     * @return
     */
    @GetMapping("/isExistSplitInfo")
    boolean isExistSplitInfo(
            @RequestParam(value = "providerCode", required = false) String providerCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchId", required = false) String batchId
    );


    /**
     * @param providerCode 文件提供方
     * @param settleDate   清算日期
     * @param batchId      批次ID
     * @return
     */
    @GetMapping("querySplitInfoByBatchId")
    List<SplitInfo> querySplitInfoByBatchId(@RequestParam(value = "providerCode", required = false) String providerCode,
                                            @RequestParam(value = "settleDate", required = false) String settleDate,
                                            @RequestParam(value = "batchId", required = false) String batchId
    );


    /**
     * 是否入虚账且账期为0自动提现结果不明确的 分账记录
     *
     * @param industryCode 代付客户号
     * @param settleDate   清算日期
     * @param batchId      批次ID
     * @param queryTimes   大于该查询次数不再重跑查询
     * @return
     */
    @GetMapping("querySplitInfoUnSuccess")
    List<SplitInfo> querySplitInfoUnSuccess(@RequestParam(value = "industryCode", required = false) String industryCode,
                                            @RequestParam(value = "settleDate", required = false) String settleDate,
                                            @RequestParam(value = "batchId", required = false) String batchId,
                                            @RequestParam(value = "queryTimes", required = false) int queryTimes
    );

    /**
     * 更新清算分账 提现状态等信息
     *
     * @param splitInfo
     */
    @PostMapping("updateTransStatusById")
    void updateTransStatusById(@RequestBody(required = false) SplitInfo splitInfo);

    /**
     * 查询后更新清算分账 提现状态、描述及查询次数
     *
     * @param splitInfoId   分账主键Id
     * @param transStatus   交易状态
     * @param transDesc     描述
     * @param reconcileDate 华通返回清算对账日
     */
    @PostMapping("updateTransStatusAndTimesById")
    void updateTransStatusAndTimesById(@RequestParam(value = "splitInfoId") String splitInfoId,
                                       @RequestParam(value = "transStatus") String transStatus,
                                       @RequestParam(value = "transDesc", required = false) String transDesc,
                                       @RequestParam(value = "reconcileDate", required = false) String reconcileDate
    );

    @GetMapping("getSplitInfoById")
    SplitInfo getSplitInfoById(@RequestParam(value = "splitInfoId") String splitInfoId);

    /**
     * 查询用户账户 清算分账流水
     *
     * @param userAccount 虚账户
     * @param startDate   起始日期 yyyyMMdd
     * @param endDate     终止日期 yyyyMMdd
     * @return
     */
    @GetMapping("/queryAccountDetail4Income")
    List<SplitInfo> queryAccountDetail4Income(@RequestParam(value = "userAccount") String userAccount,
                                              @RequestParam(value = "startDate", required = false) String startDate,
                                              @RequestParam(value = "endDate", required = false) String endDate);

    /**
     * 是否已存在成功分账记录[status=1]
     *
     * @param industryCode
     * @param clientTransId
     * @return
     */
    @GetMapping("/isExistsSplitInfo4Success")
    Boolean isExistsSplitInfo4Success(@RequestParam("industryCode") String industryCode, @RequestParam("clientTransId") String clientTransId);

    @GetMapping("/getIndustryPayInfo")
    IndustryPayInfo getIndustryPayInfo(@RequestParam("industryCode") String industryCode);

    @GetMapping("getUserPayInfo")
    UserPayInfo getUserPayInfo(@RequestParam("userAccount") String userAccount);

    @PostMapping("/processSingleSplitPayment")
    void processSingleSplitPayment(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "userAccount", required = false) String userAccount,
            @RequestParam(value = "payAmt", required = false) long payAmt,
            @RequestParam(value = "serverTransId", required = false) String serverTransId,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "clientTransId", required = false) String clientTransId
    );

    @PostMapping("/processSingleSplitPaymentRefund")
    void processSingleSplitPaymentRefund(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "payerAccount", required = false) String payerAccount,
            @RequestParam(value = "payeeAccount", required = false) String payeeAccount,
            @RequestParam(value = "payAmt", required = false) long payAmt,
            @RequestParam(value = "serverTransId", required = false) String serverTransId,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "clientTransId", required = false) String clientTransId,
            @RequestParam(value = "origTransId", required = false) Long origTransId,
            @RequestParam(value = "historyStatus", required = false) String historyStatus
    );

    @PostMapping("/saveSplitInfo")
    void saveSplitInfo(@RequestBody SplitInfo splitInfo);
}
