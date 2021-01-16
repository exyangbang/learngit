package cn.kingnet.product.api.account;

import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountIncomeNoticeReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountIncomeNoticeRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description : 华通内部账户入金通知
 * @Author : linkaigui
 * @Create : 2019/3/16 18:39
 */
@FeignClient(value = "${feign.name.account}")
@RequestMapping("/innerAccount/accountIncomeNotice")
public interface IAccountIncomeNoticeHandler {

    /**
     * 华通内部账户入金通知
     * @param oneBankAccountIncomeNoticeReqDTO
     * @return
     */
    @PostMapping("/accountIncomeNotice")
    OneBankAccountIncomeNoticeRespDTO accountIncomeNotice(@RequestBody(required = false) OneBankAccountIncomeNoticeReqDTO oneBankAccountIncomeNoticeReqDTO);
}
