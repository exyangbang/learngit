package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfoCondition;
import cn.kingnet.utp.service.persistence.mapper.MerchantAccountInfoMapper;
import cn.kingnet.utp.service.persistence.service.MerchantInfoService;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.enums.BindCardStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/10/18 9:29
 */
@RestController
@RequestMapping("/spi/persistence/merAccout")
public class MerchantAccountHandler extends DefaultFeginExceptionHandler implements IMerchantAccountHandler {
    @Resource
    private MerchantInfoService merchantInfoService;

    /**
     * 虚拟账户获取商户账户信息 todo 待改造
     *
     * @param userAccount
     * @return
     */
    @PostMapping("/getMerchantAccountByAccount")
    @Override
    public MerchantAccountInfo getMerchantAccountByAccount(@RequestParam(value = "userAccount", required = true) String userAccount) {
        if (StringUtil.isNotBlank(userAccount)) {
            return MybatisDaoImpl.run().selectOne(MerchantAccountInfo.builder().account(userAccount).build());
        }
        return null;
    }

    @Override
    @PostMapping("/getMerchantAccountByAccountAndAcctNo")
    public MerchantAccountInfo getMerchantAccountByAccountAndAcctNo(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "acctNo", required = false) String acctNo) {
        MerchantAccountInfo merchantAccountInfo = null;
        MerchantAccountInfoCondition condition = MerchantAccountInfoCondition.builder().andAccountEq(userAccount);
        if (StringUtil.isNotBlank(acctNo)) {
            merchantAccountInfo = MybatisDaoImpl.run().selectOne(condition.andAccountNoEq(acctNo).build());
        } else {
            List<MerchantAccountInfo> list = MybatisDaoImpl.run().selectList(condition.build());
            if (!CollectionUtils.isEmpty(list)) {
                merchantAccountInfo = list.stream().filter(o -> BindCardStatus.NORMAL.getStatus().equals(o.getBindStatus())).findFirst().orElse(null);
                if (merchantAccountInfo == null) {
                    merchantAccountInfo = list.get(0);
                }
            }
        }
        return merchantAccountInfo;
    }

    @PostMapping("/existsMerchantAccount")
    @Override
    public boolean existsMerchantAccount(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "accountName", required = false) String accountName) {
        MerchantAccountInfoCondition condition = MerchantAccountInfoCondition.builder()
                .andAccountEq(userAccount).andAccountNameEq(accountName).andBindStatusEq(BindCardStatus.NORMAL.getStatus());
        return MybatisDaoImpl.run().selectCount(condition.build()) > 0;
    }

    /**
     * 虚账户对应的商户信息(兼容待结算子账户) || 仅能使用，禁止持久化库表
     *
     * @param subAccount
     * @return
     */
    @PostMapping("/getMerchantInfoByAccountOrSettleAccount")
    @Override
    public MerchantInfoBo getMerchantInfoByAccountOrSettleAccount(@RequestParam(value = "subAccount", required = true) String subAccount, @RequestParam(value = "cacheAble") boolean cacheAble) {
        return merchantInfoService.getMerchantInfoBo(subAccount, cacheAble);
    }


    @Override
    @PostMapping("/getMerchantAccountsByAccountAndAcctNo")
    public List<MerchantAccountInfo> getMerchantAccountsByAccountAndAcctNo(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "acctNo", required = false) String acctNo) {
        List<MerchantAccountInfo> merchantAccountInfos = null;
        MerchantAccountInfoCondition condition = MerchantAccountInfoCondition.builder().andAccountEq(userAccount);
        if (StringUtil.isNotBlank(acctNo)) {
            merchantAccountInfos = MybatisDaoImpl.run().selectList(condition.andAccountNoEq(acctNo).build());
        } else {
            merchantAccountInfos = MybatisDaoImpl.run().selectList(condition.build());
        }
        return merchantAccountInfos;
    }

    @Override
    @PostMapping("/updateMerchantAccountInfo")
    @Transactional(rollbackFor = Exception.class)
    public void updateMerchantAccountInfo(@RequestBody MerchantAccountInfo merchantAccountInfo) {
        ValidateUtils.notNull(merchantAccountInfo, "参数不能为空");
        ValidateUtils.hasText(merchantAccountInfo.getAccount(), "虚拟账户");
        ValidateUtils.hasText(merchantAccountInfo.getAccountNo(), "账号");
        MybatisDaoImpl.run().update(merchantAccountInfo, MerchantAccountInfoCondition.builder().andAccountEq(merchantAccountInfo.getAccount()).andAccountNoEq(merchantAccountInfo.getAccountNo()).build());
    }

    /**
     * 查询客户号下绑定某张卡号的信息列表
     *
     * @param industryCode
     * @param accountNo
     * @return
     */
    @Override
    @PostMapping("/findMerAccountByIndustryCodeAndAcctNo")
    public List<MerchantAccountInfo> findMerAccountByIndustryCodeAndAcctNo(@RequestParam(value = "industryCode") String industryCode, @RequestParam(value = "accountNo", required = false) String accountNo) {
        ValidateUtils.hasText(industryCode, "客户号");
        ValidateUtils.hasText(accountNo, "银行卡号");
        Map<String, Object> params = new HashMap<>(4);
        params.put("industryCode", industryCode);
        params.put("accountNo", accountNo);
        return MybatisDaoImpl.of(MerchantAccountInfoMapper.class).selectListBySql("findMerAccountByIndustryCodeAndAcctNo", params);
    }

}
