package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.MerchantReconcileRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 对账记录服务接口
 * @Author : linkaigui
 * @Create : 2019/3/27 11:19
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/reconcileRecord")
public interface IMerchantReconcileRecordHandler {

    /**
     * 查询对账记录
     * @param settleDate 对账日期
     * @return
     */
    @PostMapping("/queryReconcileRecordByDate")
    MerchantReconcileRecord queryReconcileRecordByDate(@RequestParam(value = "settleDate", required = false) String settleDate);
}
