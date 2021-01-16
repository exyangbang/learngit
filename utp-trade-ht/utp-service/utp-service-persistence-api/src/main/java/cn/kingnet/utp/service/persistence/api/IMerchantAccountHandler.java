package cn.kingnet.utp.service.persistence.api;

import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description : 描述接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 9:24
 */
@FeignClient(value = "${feign.name.persis}")
@RequestMapping("/spi/persistence/merAccout")
public interface IMerchantAccountHandler {

    /**
     *  虚拟账户获取商户账户信息
     * @param userAccount
     * @return
     */
    @PostMapping("/getMerchantAccountByAccount")
    MerchantAccountInfo getMerchantAccountByAccount(@RequestParam(value = "userAccount", required = true) String userAccount);

   @PostMapping("/getMerchantAccountByAccountAndAcctNo")
   MerchantAccountInfo getMerchantAccountByAccountAndAcctNo(@RequestParam(value = "userAccount") String userAccount,@RequestParam(value = "acctNo",required = false) String acctNo);

    /**
     * 是否存在该虚账户userAccount的 正常绑卡信息 accountName
     * @param userAccount
     * @param accountName
     * @return
     */
    @PostMapping("/existsMerchantAccount")
    boolean existsMerchantAccount(@RequestParam(value = "userAccount") String userAccount,@RequestParam(value = "accountName",required = false) String accountName);

    /**
     *  虚账户对应的商户信息(兼容待结算子账户)
     * @param subAccount
     * @return
     */
    @PostMapping("/getMerchantInfoByAccountOrSettleAccount")
    MerchantInfoBo getMerchantInfoByAccountOrSettleAccount(@RequestParam(value = "subAccount", required = true) String subAccount,@RequestParam(value = "cacheAble") boolean cacheAble);

    @PostMapping("/getMerchantAccountsByAccountAndAcctNo")
    List<MerchantAccountInfo> getMerchantAccountsByAccountAndAcctNo(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "acctNo",required = false) String acctNo);

    /**
     * 更新绑卡信息
     * @param merchantAccountInfo
     */
    @PostMapping("/updateMerchantAccountInfo")
    void updateMerchantAccountInfo(@RequestBody MerchantAccountInfo merchantAccountInfo);

    /**
     * 查询客户号下绑定某张卡号的信息列表
     * @param industryCode
     * @param accountNo
     * @return
     */
    @PostMapping("/findMerAccountByIndustryCodeAndAcctNo")
    List<MerchantAccountInfo> findMerAccountByIndustryCodeAndAcctNo(@RequestParam(value = "industryCode") String industryCode,@RequestParam(value = "accountNo",required = false) String accountNo);


}
