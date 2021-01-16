package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IFundAccountHandler;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.service.persistence.service.FundAccountService;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/25
 */
@RestController
@RequestMapping("/spi/persistence/fundAccount")
public class FundAccountHandler extends DefaultFeginExceptionHandler implements IFundAccountHandler {

    @Resource
    private FundAccountService fundAccountService;

    @PostMapping("/queryFundAccountList")
    @Override
    public List<FundAccount> queryFundAccountList() {
        return fundAccountService.queryFundAccountList();
    }

    @PostMapping("/querySpecialFundAccountList")
    @Override
    public List<FundAccount> querySpecialFundAccountList() {
        return fundAccountService.querySpecialFundAccountList();
    }

    @PostMapping("/getByFundAccountNo")
    @Override
    public FundAccount getByFundAccountNo(@RequestParam("fundAccountNo") String fundAccountNo) {
        return fundAccountService.getByFundAccountNo(fundAccountNo);
    }
}
