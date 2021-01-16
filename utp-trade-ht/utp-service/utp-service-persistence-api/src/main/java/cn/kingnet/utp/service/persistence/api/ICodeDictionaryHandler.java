package cn.kingnet.utp.service.persistence.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 业务编码字典服务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/2/22 11:31
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/codedictionaryhandler")
public interface ICodeDictionaryHandler {

	@PostMapping("find/codeDictionary")
	boolean isExistCodeDictionary(@RequestParam("type") String type, @RequestParam("code") String code);
}
