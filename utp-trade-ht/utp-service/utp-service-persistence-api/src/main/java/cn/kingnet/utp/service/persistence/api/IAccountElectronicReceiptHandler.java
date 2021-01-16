package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.AccountElectronicReceipt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description : 开户电子回单
 * @Author : linkaigui
 * @Create : 2020/3/13 15:39
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/accountElectronicReceipt")
public interface IAccountElectronicReceiptHandler {

    /**
     * 获取电子回单信息
     * @param receiptNo 电子回单号
     * @return
     */
    @PostMapping("/getByReceiptNo")
    AccountElectronicReceipt getByReceiptNo(@RequestParam(value = "receiptNo",required = false)String receiptNo);

    /**
     * 获取电子回单信息
     * @param account 虚拟帐号
     * @return
     */
    @PostMapping("/getByAccount")
    AccountElectronicReceipt getByAccount(@RequestParam(value = "account",required = false)String account);

    /**
     * 创建生成开户电子回单任务
     * @param account 虚拟账户
     * @param nature 账户性质
     */
    @PostMapping("/createJobTask")
    void createJobTask(@RequestParam(value = "account", required = false) String account,
                       @RequestParam(value = "nature", required = false) String nature);

    /**
     * 查询电子回单PDF路径
     * @param id
     * @return
     */
    @PostMapping("/queryFilePathById")
    String queryFilePathById(@RequestParam(value = "id") long id);
}
