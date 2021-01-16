package cn.kingnet.utp.service.persistence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**额度管理
 * @author zhongli
 * @date 2019-03-20 
 *
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/amount")
public interface IAmountHandler {

//    @PostMapping("/day/update")
//    void dailyChange(@RequestBody(required = false) DailyAmountBO dailyAmountBO);
//
//    /**
//     * 查询额度信息
//     * @param id
//     * @param date 时间格式 yyyyMMdd
//     * @return
//     */
//    @PostMapping("/day/find/bo")
//    DailyAmountBO findDailyAmount(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "date", required = false) String date);
//
//    /**
//     * 查询额度
//     * @param id
//     * @param date yyyyMMdd
//     * @param defaultAmont 当不存在缓存记录时，返回此值
//     * @return
//     */
//    @PostMapping("/day/get/amount")
//    long getDailyAmount(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "defaultAmont", required = false) Long defaultAmont);

}
