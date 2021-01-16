package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.AccountSettleDetail;
import cn.kingnet.utp.service.persistence.entity.bo.AccountSettleBatchBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description : 清算信息处理服务接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 16:06
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/accountSettle")
public interface IAccountSettleHandler {

    /**
     * 持久化清算上送信息
     *
     * @param accountSettleBatchBO
     */
    @PostMapping("/saveAccountSettleBatchAndJobTask")
    void saveAccountSettleBatchAndJobTask(@RequestBody(required = false) AccountSettleBatchBO accountSettleBatchBO);

    /**
     * 查询清算信息列表
     *
     * @param industryCode
     * @param settleDate
     * @param batchId
     * @return
     */
    @PostMapping("/findAccountSettleDetailList")
    List<AccountSettleDetail> findAccountSettleDetailList(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchId", required = false) String batchId
    );

    /**
     * 清算处理冻结金额
     * @param accountSettleDetailId
     * @param serverTransId
     * @return
     */
    @PostMapping("/freezeDetailAccout")
    AccountSettleDetail freezeDetailAccout(@RequestParam(value = "accountSettleDetailId", required = false) Long accountSettleDetailId, @RequestParam(value = "serverTransId", required = false) String serverTransId);

    /**
     * 预付费卡清算恢复冻结金额
     * @param accountSettleDetailId
     * @param serverTransId
     * @param transStatus
     * @param transDesc
     * @return
     */
    @PostMapping("/unfreezeDetailAccout")
    AccountSettleDetail unfreezeDetailAccout(@RequestParam(value = "accountSettleDetailId", required = false) Long accountSettleDetailId,
                                             @RequestParam(value = "serverTransId", required = false) String serverTransId,
                                             @RequestParam(value = "transStatus", required = false) String transStatus,
                                             @RequestParam(value = "transDesc", required = false) String transDesc);

    /**
     * 预付费卡清算对账处理
     * @param industryCode
     * @param serverTransId
     * @param targetTransStatus
     * @param transDesc
     * @return
     */
    @PostMapping("/reconciliationProcess")
    boolean reconciliationProcess(@RequestParam(value = "industryCode", required = false) String industryCode,
                                             @RequestParam(value = "serverTransId", required = false) String serverTransId,
                                             @RequestParam(value = "targetTransStatus", required = false) String targetTransStatus,
                                             @RequestParam(value = "transDesc", required = false) String transDesc);
}
