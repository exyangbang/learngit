package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.BlackList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 黑名单列表管理
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/blackList")
public interface IBlackListHandler {

    /**
     * 查询黑名单
     * @param name 姓名
     * @param idCode 证件号
     * @return
     */
    @GetMapping("findBlackListByNameAndIdCode")
    boolean findIsBlackByNameAndIdCode(@RequestParam("name") String name, @RequestParam("idCode") String idCode);

    /**
     * 查询黑名单
     * @param entName 企业名称
     * @param busLicCode 营业执照号
     * @return
     */
    @GetMapping("findBlackListByEntNameAndBusLicCode")
    boolean findIsBlackByEntNameAndBusLicCode(@RequestParam("entName") String entName, @RequestParam("busLicCode") String busLicCode);

    /**
     *  企业的字段被重命名为个人字段，外部校验个人即可
     * @return
     */
    @GetMapping("selectAllBlackList")
    List<BlackList> selectAllBlackList();


}
