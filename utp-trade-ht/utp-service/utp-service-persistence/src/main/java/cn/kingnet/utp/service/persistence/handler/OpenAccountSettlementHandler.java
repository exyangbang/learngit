package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IOpenAccountSettlementHandler;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.AccountCondition;
import cn.kingnet.utp.service.persistence.entity.MerchantInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantInfoCondition;
import cn.kingnet.utp.service.persistence.service.MerchantInfoService;
import cn.kingnet.utp.service.persistence.support.VirtualAccountNoGenerate;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.VirtualAccountType;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author sheqingquan@scenetec.com
 * @description: TODO
 * @create 2020/2/12 10:57
 */
@RestController
@RequestMapping("/spi/persistence/openAccountSettlement")
public class OpenAccountSettlementHandler implements IOpenAccountSettlementHandler {

    @Resource
    VirtualAccountNoGenerate virtualAccountNoGenerate;
    @Resource
    private MerchantInfoService merchantInfoService;
    @GetMapping("/findSettleAccount")
    @Override
    public String findSettleAccount(String userAccount) {
        //查询对应的商户信息
        MerchantInfo merchantInfo = merchantInfoService.selectOne(MerchantInfoCondition.builder().andAccountEq(userAccount).build());
        if (null == merchantInfo) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "商户信息异常");
        }
        return merchantInfo.getSettleAccount();
    }

    @GetMapping("/createSettleAccount")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String createSettleAccount(String userAccount) {
        if (StringUtil.isBlank(userAccount)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户号不能为空");
        }
        //查询原先虚账户和商户信息
        Account account = MybatisDaoImpl.run().selectOne(AccountCondition.builder().andAccountEq(userAccount).build());
        if (null == account) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "虚账户信息异常");
        }
        MerchantInfo merchantInfo = merchantInfoService.selectOne(MerchantInfoCondition.builder().andAccountEq(userAccount).build());
        if (null == merchantInfo) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "商户信息异常");
        }
        //生成新的虚账户号
        String accountNo = account.getAccount();
        String userSettleAccount = virtualAccountNoGenerate.createAccountNo();
        account.setId(null);
        account.setAccount(userSettleAccount);
        account.setGmtCreate(new Date());
        account.setGmtModified(new Date());
        account.setBalance(0L);
        account.setFrozenAmount(0L);
        account.setAvailAmount(0L);
        //类型为待结算账户
        account.setObjType(VirtualAccountType.SETTLEACCOUNT.getType());
        //创建待结算账户
        MybatisDaoImpl.run().insert(account);
        //更新商户关联信息
        merchantInfo.setSettleAccount(userSettleAccount);
        MybatisDaoImpl.run().update(merchantInfo, MerchantInfoCondition.builder().andAccountEq(accountNo).build());
        return userSettleAccount;
    }
}
