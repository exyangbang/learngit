package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.AccountEntryDetail;
import cn.kingnet.utp.service.persistence.entity.ElectronicReceipt;
import cn.kingnet.utp.service.persistence.entity.bo.AccountEntryBatchBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description : 电子回单查找接口
 * @Author : caohong
 * @Date : 2019-03-19
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/electronic/receipt")
public interface IElectronicReceiptHandler {
    
    /**
     * @Description: 通过交易流水ID查找电子回单信息
     * @Params: [serverTransId]
     * @return: cn.kingnet.utp.service.persistence.entity.ElectronicReceipt
     * @Date: 2019-03-21
     */
    @PostMapping("/found/by/serverTransId")
    ElectronicReceipt foundByServerTransId(@RequestParam(value = "origTradeId") String serverTransId);

    /**
     * @Description: 通过交易流水ID和电子回单号查找电子回单信息
     * @Params: [serverTransId, receiptNo]
     * @return: cn.kingnet.utp.service.persistence.entity.ElectronicReceipt
     * @Date: 2019-03-21
     */
    @PostMapping("/found/by/serverTransIdAndReceiptNo")
    ElectronicReceipt foundByServerTransIdAndReceiptNo(@RequestParam(value = "origTradeId") String serverTransId ,@RequestParam(value = "receiptNo") String receiptNo);

    /**
     * 查询电子回单PDF路径
     * @param id
     * @return
     */
    @PostMapping("/queryFilePathById")
    String queryFilePathById(@RequestParam(value = "id") long id);
}