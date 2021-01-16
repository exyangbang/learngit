package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.service.persistence.entity.FundAccountCondition;
import cn.kingnet.utp.service.persistence.mapper.FundAccountMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/25
 */
@Service
public class FundAccountService {

    public List<FundAccount> queryFundAccountList() {
        return MybatisDaoImpl.run().selectAllList(FundAccount.class);
    }

    public List<FundAccount> querySpecialFundAccountList() {
        return MybatisDaoImpl.of(FundAccountMapper.class).selectListBySql("querySpecialFundAccountList");
    }

    public FundAccount getByFundAccountNo(String fundAccountNo) {
        return MybatisDaoImpl.run().selectOne(FundAccountCondition.builder().andBankAccountNoEq(fundAccountNo).build());
    }
}
