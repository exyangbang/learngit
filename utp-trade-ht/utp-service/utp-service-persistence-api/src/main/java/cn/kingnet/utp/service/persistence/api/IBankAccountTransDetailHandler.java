package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.BankAccountTransDetail;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description 银行内部户资金明细操作
 * @Author WJH
 * @Date 2019/03/14
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/bankAccountTransDetail")
public interface IBankAccountTransDetailHandler {

    @PostMapping("queryByOrderId")
    BankAccountTransDetail queryByOrderId(@RequestParam("userAccount") String userAccount, @RequestParam("orderId") String orderId);

    @PostMapping("queryByCoreNo")
    BankAccountTransDetail queryByCoreNo(@RequestParam("userAccount") String userAccount, @RequestParam("coreNo") String coreNo);

    @PostMapping("updateByOrderId")
    void updateOrderStatusByOrderId(@RequestParam("userAccount") String userAccount, @RequestParam("orderId") String orderId, @RequestParam("orderStatus") String orderStatus);

    @PostMapping("queryByFundAccount")
    List<BankAccountTransDetail> queryByFundAccount(@RequestParam("fundAccount") String fundAccount, @RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate);

    /**
     * 持久化 平台账户明细流水及账户资金操作明细
     */
    @PostMapping("/syncBankAccountTransDetail")
    void syncBankAccountTransDetail(@RequestParam(value = "fundAccountNo", required = false) String fundAccountNo, @RequestBody(required = false) List<BankAccountTransDetail> list);

    /**
     *  平台账户 上账
     * @param industryCode
     */
    @PostMapping("syncBankAccDetail2LocalIndustry")
    ServerResponseDTO syncBankAccDetail2LocalIndustry(@RequestParam("industryCode") String industryCode);
}
