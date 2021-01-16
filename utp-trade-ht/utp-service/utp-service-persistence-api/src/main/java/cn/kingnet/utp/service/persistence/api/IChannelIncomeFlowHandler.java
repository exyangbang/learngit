package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.ChannelIncomeFlow;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 账户入金通知流水接口
 * @Author : linkaigui
 * @Create : 2019/3/17 17:29
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/channelIncomeFlow")
public interface IChannelIncomeFlowHandler {

    /**
     * 查询账户入金通知流水信息
     *
     * @param coreNo
     * @return
     */
    @PostMapping("/findChannelIncomeFlowByCoreNo")
    ChannelIncomeFlow findChannelIncomeFlowByCoreNo(@RequestParam(value = "coreNo") String coreNo);

    /**
     * 保存账户入金通知流水
     *
     * @param channelIncomeFlow
     * @return
     */
    @PostMapping("/saveChannelIncomeFlow")
    int saveChannelIncomeFlow(@RequestBody(required = false) ChannelIncomeFlow channelIncomeFlow);

    @PostMapping("/isExistChannelIncomeFlowByCoreNo")
    boolean isExistChannelIncomeFlowByCoreNo(@RequestParam(value = "accNo") String accNo, @RequestParam(value = "coreNo") String coreNo);

    @PostMapping("/isExistChannelIncomeFlowByRid")
    boolean isExistChannelIncomeFlowByRid(@RequestParam(value = "accNo") String accNo, @RequestParam(value = "rid") String rid);

    @PostMapping("/syncBankAccDetail2LocalFunctionAccount")
    void syncBankAccDetail2LocalFunctionAccount();

    @PostMapping("/syncBankAccDetail2LocalSubAccount")
    void syncBankAccDetail2LocalSubAccount(@RequestParam(value = "industryCode") String industryCode);
}
