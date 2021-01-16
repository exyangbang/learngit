package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IManualEntryAccountHandler;
import cn.kingnet.utp.service.persistence.service.ManualEntryAccountService;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.vo.ManualEntryAccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description : 手工入账服务
 * @Author : linkaigui
 * @Create : 2019/3/22 11:18
 */
@RestController
@RequestMapping("/spi/persistence/manualEntryAccountHandler")
@Slf4j
public class ManualEntryAccountHandler extends DefaultFeginExceptionHandler implements IManualEntryAccountHandler {

    @Resource
    private ManualEntryAccountService manualEntryAccountService;

    /**
     * 手工入账处理
     * @param manualEntryAccountVO
     * @return
     */
    @PostMapping("/manualAccount")
    @Override
    public ServerResponseDTO manualAccount(@RequestBody(required = false) ManualEntryAccountVO manualEntryAccountVO) {
        try{
            if(manualEntryAccountVO == null) throw new TradeException(HttpRespStatus.BAD_REQUEST, "参数错误!");
            if(manualEntryAccountVO.getTransId() == null || manualEntryAccountVO.getTransId() == 0) throw new TradeException(HttpRespStatus.BAD_REQUEST, "交易明细ID不能为空!");
            if(StringUtil.isBlank(manualEntryAccountVO.getAccount())) throw new TradeException(HttpRespStatus.BAD_REQUEST, "虚拟帐号不能为空!");
            manualEntryAccountService.manualEntryAccount(manualEntryAccountVO.getTransId(),manualEntryAccountVO.getAccount(),manualEntryAccountVO.getUserModified());
            return new ServerResponseDTO(HttpRespStatus.OK.valueStr(),"手工入账处理成功");
        }catch (Exception e){
            log.error("手工入账Id:{}...手工入账处理异常{}", manualEntryAccountVO != null ? manualEntryAccountVO.getTransId() : "",e.getMessage(),e);
            String message = "手工入账处理异常!";
            if(e instanceof TradeException){
                message = e.getMessage();
            }
            return new ServerResponseDTO(HttpRespStatus.SERVER_ERROR.valueStr(),message);
        }
    }
}
