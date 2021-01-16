package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.CardBinInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 卡bin处理
 * @Author WJH
 * @Date 2018年11月08日
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/cardBin")
public interface ICardBinHandler {


    /**
     * 银行卡号关联的 人行清算行行号
     * @param cardNo 银行卡号
     * @return
     */
    @GetMapping("/getClearBankNo")
    String getClearBankNo(@RequestParam(value = "cardNo") String cardNo);


    /**
     * 银行卡号关联的 卡bin信息
     * @param cardNo 银行卡号
     * @return
     */
    @GetMapping("/getCardBinInfo")
    CardBinInfo getCardBinInfo(@RequestParam(value = "cardNo") String cardNo);

}
