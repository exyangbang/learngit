package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.ICardBinHandler;
import cn.kingnet.utp.service.persistence.entity.CardBinInfo;
import cn.kingnet.utp.service.persistence.service.CardBinService;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月08日
 */
@RestController
@RequestMapping("/spi/persistence/cardBin")
public class CardBinHandler extends DefaultFeginExceptionHandler implements ICardBinHandler {

    @Resource
    private CardBinService cardBinService;

    @GetMapping("/getClearBankNo")
    @Override
    public String getClearBankNo(@RequestParam(value = "cardNo") String cardNo) {
        return cardBinService.getClearBankNo(cardNo);
    }

    @GetMapping("/getCardBinInfo")
    @Override
    public CardBinInfo getCardBinInfo(@RequestParam(value = "cardNo") String cardNo) {
        return cardBinService.getCardBinInfo(cardNo);
    }
}
