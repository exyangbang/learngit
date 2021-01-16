package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.ITransReexchangeHandler;
import cn.kingnet.utp.service.persistence.entity.TransReexchange;
import cn.kingnet.utp.service.persistence.service.TransReexchangeService;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.TradeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description : 退汇管理处理
 * @Author : linkaigui@scenetec.com
 * @Create : 2019/1/25 22:45
 */
@RestController
@RequestMapping("/spi/persistence/transReexchangeHandler")
@Slf4j
public class TransReexchangeHandler extends DefaultFeginExceptionHandler implements ITransReexchangeHandler {

    @Autowired
    private TransReexchangeService transReexchangeService;

    /**
     * 退汇账户处理
     * @param id 退汇流水ID
     * @param userModified 操作员
     * @return
     */
    @Override
    @PostMapping("/adjustAccount")
    public ServerResponseDTO adjustAccount(@RequestParam(value = "id",required = false)Long id, @RequestParam(value = "userModified",required = false)String userModified) {
        try{
            if(id == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "退汇流水ID不能为空!");
            }
            transReexchangeService.adjustAccountByReexchange(id,userModified);
            return new ServerResponseDTO(HttpRespStatus.OK.valueStr(),"处理成功");
        }catch (Exception e){
            log.error("退汇流水Id:{}...退汇处理异常{}", id,e.getMessage(),e);
            String message = "退汇账户处理异常!";
            if(e instanceof TradeException){
                message = e.getMessage();
            }
            return new ServerResponseDTO(HttpRespStatus.SERVER_ERROR.valueStr(),message);
        }
    }

    @Override
    public List<TransReexchange> queryBySettleDate(String industryCode, String settleDate) {
        return transReexchangeService.queryBySettleDate(industryCode,settleDate);
    }
}
