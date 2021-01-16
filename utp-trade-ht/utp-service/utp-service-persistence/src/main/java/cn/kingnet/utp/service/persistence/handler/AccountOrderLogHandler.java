package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IAccountOrderLogHandler;
import cn.kingnet.utp.service.persistence.entity.AccountOrderLog;
import cn.kingnet.utp.service.persistence.entity.vo.AccountOrderLogVo;
import cn.kingnet.utp.service.persistence.service.AccountOrderLogService;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/14
 */
@RestController
@RequestMapping("/spi/persistence/accountOrderLog")
@Slf4j
public class AccountOrderLogHandler extends DefaultFeginExceptionHandler implements IAccountOrderLogHandler {

    @Resource
    private AccountOrderLogService accountOrderLogService;

    @Override
    public List<AccountOrderLog> queryAccountOrderLog(String account, String orderId) {
        return accountOrderLogService.queryAccountOrderLog(account, orderId);
    }

    @Override
    public AccountOrderLog getAccountOrderLog(String serverTransId) {
        return accountOrderLogService.getAccountOrderLog(serverTransId);
    }

    @Override
    public void saveAccountOrderLog(@RequestBody AccountOrderLogVo accountOrderLogVo) {
        accountOrderLogService.saveAccountOrderLog(AccountOrderLog.of(accountOrderLogVo));
    }

    @Override
    public void updateAccountOrderLog(@RequestBody AccountOrderLogVo accountOrderLogVo) {
        accountOrderLogService.updateAccountOrderLog(AccountOrderLog.of(accountOrderLogVo));
    }
}
