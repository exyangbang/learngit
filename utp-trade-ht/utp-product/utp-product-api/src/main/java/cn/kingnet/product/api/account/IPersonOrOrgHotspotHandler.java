package cn.kingnet.product.api.account;

import cn.kingnet.utp.trade.common.dto.account.PersonOrOrgHotspotReqDTO;
import cn.kingnet.utp.trade.common.dto.account.PersonOrOrgHotspotRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description : 内部建立个人/企业的客户热点信息
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/11/05 10:00
 */
@FeignClient(value = "${feign.name.account}")
@RequestMapping("/innerAccount/personOrOrgHotspot")
public interface IPersonOrOrgHotspotHandler {

	@PostMapping("/addPersonOrOrgHotspot")
	PersonOrOrgHotspotRespDTO addPersonOrOrgHotspot(@RequestBody PersonOrOrgHotspotReqDTO personOrOrgHotspotReqDTO);
}
