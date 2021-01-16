package cn.kingnet.product.api.account;

import cn.kingnet.utp.trade.common.dto.account.InnerQueryWithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.InnerWithdrawReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 内部系统调用
 */
@FeignClient(value = "${feign.name.account}")
@RequestMapping("/innerAccount/withdraw")
public interface InnerAccountWithdrawHandler {

    @PostMapping("/autoWithdrawForSplit")
    void autoWithdrawForSplit(@RequestBody(required = false) List<InnerWithdrawReqDTO> innerWithdrawReq);

    @PostMapping("/processUnSuccessResultForSplit")
    void processUnSuccessResultForSplit(@RequestBody(required = false) List<InnerQueryWithdrawReqDTO> innerQueryWithdrawReq);

    @PostMapping("/queryTransStatus")
    void queryTransStatus(@RequestParam("industryCode") String industryCode, @RequestParam("clientTradeId") String clientTradeId, @RequestParam("origServerTradeId") String origServerTradeId);


}
