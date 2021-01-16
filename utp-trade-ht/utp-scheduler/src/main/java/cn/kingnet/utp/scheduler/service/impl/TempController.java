package cn.kingnet.utp.scheduler.service.impl;

import cn.kingnet.utp.scheduler.service.SyncIndustryAccountService;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/28
 */
@RestController
@RequestMapping("/temp")
public class TempController {

    @Resource
    SyncIndustryAccountService syncIndustryAccountService;

    @RequestMapping("/sync/fundAcc/{fundAccNo}/{startDate}/{endDate}")
    public Object fundAccTransDetail(@PathVariable("fundAccNo") String fundAccNo, @PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate,
                                     @RequestParam(value = "startTime",required = false) String startTime,
                                     @RequestParam(value = "endTime",required = false) String endTime
                                     ){
        FundAccount fundAccount = syncIndustryAccountService.getByFundAccountNo(fundAccNo);
        syncIndustryAccountService.syncBankAccountTransDetail(fundAccount,startDate,startTime,endDate,endTime);

        syncIndustryAccountService.syncFundAccountBalance(fundAccount);
        return fundAccount;
    }
    @RequestMapping("/sync/industry/{industryCode}")
    public Object industry2TransDetail(@PathVariable("industryCode") String industryCode){
        syncIndustryAccountService.syncBankAccDetail2LocalIndustry(industryCode);
        return new HashMap<>();
    }
}
