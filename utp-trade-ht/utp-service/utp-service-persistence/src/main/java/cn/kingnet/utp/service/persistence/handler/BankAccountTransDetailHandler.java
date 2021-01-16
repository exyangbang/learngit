package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IBankAccountTransDetailHandler;
import cn.kingnet.utp.service.persistence.entity.BankAccountTransDetail;
import cn.kingnet.utp.service.persistence.service.BankAccountTransDetailService;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/14
 */
@RestController
@RequestMapping("/spi/persistence/bankAccountTransDetail")
public class BankAccountTransDetailHandler extends DefaultFeginExceptionHandler implements IBankAccountTransDetailHandler {
    @Resource
    private BankAccountTransDetailService bankAccountTransDetailService;

    @Override
    public BankAccountTransDetail queryByOrderId(String userAccount, String orderId) {
        return bankAccountTransDetailService.queryByOrderId(userAccount, orderId);
    }

    @Override
    public BankAccountTransDetail queryByCoreNo(String userAccount, String coreNo) {
        return bankAccountTransDetailService.queryByCoreNo(userAccount, coreNo);
    }


    @Override
    public void updateOrderStatusByOrderId(String userAccount, String orderId, String orderStatus) {
        bankAccountTransDetailService.updateOrderStatusByOrderId(userAccount, orderId, orderStatus);
    }

    @Override
    public List<BankAccountTransDetail> queryByFundAccount(String fundAccount, String startDate, String endDate) {
        return bankAccountTransDetailService.queryByFundAccount(fundAccount, startDate, endDate);
    }

    @Override
    public void syncBankAccountTransDetail(@RequestParam(value = "fundAccountNo") String fundAccountNo, @RequestBody(required = false) List<BankAccountTransDetail> list) {
        bankAccountTransDetailService.syncBankAccountTransDetail(fundAccountNo, list);
    }

    @Override
    public ServerResponseDTO syncBankAccDetail2LocalIndustry(String industryCode) {
        ServerResponseDTO serverResponseDTO;
        try {
            serverResponseDTO = bankAccountTransDetailService.syncBankAccDetail2LocalIndustry(industryCode);
        } catch (Exception e) {
            serverResponseDTO = new ServerResponseDTO(HttpRespStatus.SERVER_ERROR.toString(), e.getMessage());
        }
        return serverResponseDTO;
    }

}
