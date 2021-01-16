package cn.kingnet.utp.scheduler.handler;

import cn.kingnet.utp.product.common.dto.BaseInnerManageRespDTO;
import cn.kingnet.utp.scheduler.data.dto.FeeIncomeAccountCollectionRespDTO;
import cn.kingnet.utp.scheduler.service.FeeIncomeAccountCollectionService;
import cn.kingnet.utp.scheduler.service.FeeIncomeAccountMonthStatService;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/21
 */
@RestController
@RequestMapping("/spi/scheduler/feeIncomeAccount")
@Slf4j
public class FeeIncomeAccountHandler {

    @Autowired
    private FeeIncomeAccountCollectionService feeIncomeAccountCollectionService;
    @Autowired
    private FeeIncomeAccountMonthStatService feeIncomeAccountMonthStatService;

    @PostMapping("feeIncomeAccountMonthStat/{statMonth}")
    public BaseInnerManageRespDTO feeIncomeAccountMonthStat(@PathVariable("statMonth") String statMonth, @RequestParam(name = "account", required = false) String account) {
        BaseInnerManageRespDTO baseInnerManageRespDTO;
        try {
            feeIncomeAccountMonthStatService.feeIncomeAccountMonthStat(statMonth, account);
            baseInnerManageRespDTO = new BaseInnerManageRespDTO(HttpRespStatus.OK.valueStr(), "执行完成");
        } catch (Exception e) {
            baseInnerManageRespDTO = new BaseInnerManageRespDTO(HttpRespStatus.SERVER_ERROR.valueStr(), e.getMessage());
        }
        return baseInnerManageRespDTO;
    }

    @PostMapping("feeIncomeAccountCollection")
    public BaseInnerManageRespDTO feeIncomeAccountMonthCollection(@RequestParam("feeStatId") long feeStatId) {
        BaseInnerManageRespDTO baseInnerManageRespDTO;
        try {
            FeeIncomeAccountCollectionRespDTO respDTO = feeIncomeAccountCollectionService.doService(feeStatId);
            if (respDTO != null && HttpRespStatus.resolve(respDTO.getStatus()).is2xxSuccessful()) {
                baseInnerManageRespDTO = new BaseInnerManageRespDTO(HttpRespStatus.OK.valueStr(), "归集划转申请已受理", respDTO);
            } else {
                baseInnerManageRespDTO = new BaseInnerManageRespDTO(HttpRespStatus.FORBIDDEN.valueStr(), "归集划转申请失败", respDTO);
            }
        } catch (Exception e) {
            baseInnerManageRespDTO = new BaseInnerManageRespDTO(HttpRespStatus.SERVER_ERROR.valueStr(), e.getMessage());
        }
        return baseInnerManageRespDTO;
    }
}
