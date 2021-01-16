package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.AccountEntryDetail;
import cn.kingnet.utp.service.persistence.entity.bo.AccountEntryBatchBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description : 入账信息处理服务接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/16 19:30
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/accountEntry")
public interface IAccountEntryHandler {

    /**
     * 持久化入账上送信息
     * @param accountEntryBatchBO
     */
    @PostMapping("/saveAccountEntryBatchAndJobTask")
    void saveAccountEntryBatchAndJobTask(@RequestBody(required = false)AccountEntryBatchBO accountEntryBatchBO);

    /**
     * 查询入账信息列表
     * @param industryCode
     * @param entryDate
     * @param batchId
     * @return
     */
    @PostMapping("/findAccountEntryDetailList")
    List<AccountEntryDetail> findAccountEntryDetailList(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "entryDate", required = false) String entryDate,
            @RequestParam(value = "batchId", required = false) String batchId
    );

    /**
     * 入账处理
     * @param accountEntryDetailId 入账明细ID
     * @return
     */
    @PostMapping("/processAccountEntry")
    AccountEntryDetail processAccountEntry(@RequestParam(value = "accountEntryDetailId", required = false) Long accountEntryDetailId);
}