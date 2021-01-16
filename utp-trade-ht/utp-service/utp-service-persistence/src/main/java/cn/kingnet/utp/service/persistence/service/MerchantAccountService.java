package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 商户账户服务
 * @Author sheqingquan@scenetec.com
 * @Create 2020/6/19 15:42
 */
@Service
public class MerchantAccountService {

    /**
     * 批量更新
     * @param updateList
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void batchUpdateMerchantAccount(List<MerchantAccountInfo> updateList) {
        MybatisDaoImpl.run().updateBatchById(updateList, 100);
    }
}