package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.bo.BankClientAccountBO;
import cn.kingnet.utp.service.persistence.entity.bo.PersonOrgInfoBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description : 个人/企业的客户热点信息关联服务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/11/05 10:00
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/personOrOrgHotspotHandler")
public interface IPersonOrOrgHotspotHandler {

    /**
     * 获取建立个人/企业客户热点信息
     *
     * @return
     */
    @PostMapping("/getPersonOrOrgInfo")
    PersonOrgInfoBo getPersonOrOrgInfo(@RequestParam(value = "id") String id,
                                       @RequestParam(value = "account") String account,
                                       @RequestParam(value = "type") String type,
                                       @RequestParam(value = "code") String code,
                                       @RequestParam(value = "name") String name,
                                       @RequestParam(value = "fundAccount") String fundAccount);

    /**
     * 保存虚账户关联的银行客户号并关联状态为：开户已上报
     *
     * @param account
     * @param bankClientNo
     * @param isSelfChannel
     */
    @PostMapping("/saveBankClientNo")
    void saveBankClientNo(@RequestParam(value = "account") String account,
                          @RequestParam(value = "bankClientNo") String bankClientNo,
                          @RequestParam(value = "isSelfChannel") boolean isSelfChannel);

    /**
     * 更新虚账户关联银行客户号状态： bankclientStatus枚举
     *
     * @param account
     * @param bankClientNo
     * @param bankClientStatus
     */
    @PostMapping("/updateBankClientStatus")
    void updateBankClientStatus(@RequestParam(value = "account") String account,
                                @RequestParam(value = "bankClientNo") String bankClientNo,
                                @RequestParam(value = "bankClientStatus") int bankClientStatus);

    /**
     * 获取个人|企业 code已开户的信息
     *
     * @param personOrgInfoBo
     * @return
     */
    @PostMapping("/selectBankClientAccount")
    List<BankClientAccountBO> selectBankClientAccount(@RequestBody PersonOrgInfoBo personOrgInfoBo);
}
