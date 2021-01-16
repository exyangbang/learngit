package cn.kingnet.product.api.account;

import cn.kingnet.utp.trade.common.dto.onebank.OneBankVirtualAccountQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankVirtualAccountQueryRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description : 电子账户所属实体机构户查询
 * @Author : linkaigui
 * @Create : 2019/3/14 18:46
 */
@FeignClient(value = "${feign.name.account}")
@RequestMapping("/innerAccount/virtualAccountQuery")
public interface IOneBankVirtualAccountQueryHandler {

    /**
     * 电子账户所属实体机构户查询
     * @param oneBankVirtualAccountQueryReqDTO
     * @return
     */
    @PostMapping("/virtualAccountQuery")
    OneBankVirtualAccountQueryRespDTO virtualAccountQuery(@RequestBody(required = false) OneBankVirtualAccountQueryReqDTO oneBankVirtualAccountQueryReqDTO);
}
