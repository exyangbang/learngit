package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.CommonDictionary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月08日
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/commonDictionary")
public interface ICommonDictionaryHandler {


    /**
     * 根据type获取字典集合
     * @param type
     * @return
     */
    @GetMapping("/getCommonDictionaryByType")
    List<CommonDictionary> getCommonDictionaryByType(@RequestParam(value = "type") String type);

}
