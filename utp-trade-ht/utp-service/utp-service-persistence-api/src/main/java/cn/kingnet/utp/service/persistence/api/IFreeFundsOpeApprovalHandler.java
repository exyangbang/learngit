package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.bo.FreeFundsOpeApprovalBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 资金冻结解冻记录服务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/2/22 11:31
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/freezebalance")
public interface IFreeFundsOpeApprovalHandler {

	@PostMapping("save/freeFundsOpeApproval")
	void saveFreeFundsOpeApproval(@RequestBody FreeFundsOpeApprovalBo freeFundsOpeApprovalBo);

}
