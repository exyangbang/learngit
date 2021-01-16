package cn.kingnet.utp.reconciliation.batch.onebank.task;

import cn.kingnet.framework.starter.base.sql.BaseEntity;
import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.reconciliation.exception.ReconciliationProcessorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhongli
 * @date 2018/9/13
 */
@Component
@Slf4j
public class ReconciliationWriter<TransCurrent> implements ItemWriter<BaseEntity> {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(List<? extends BaseEntity> items) throws Exception {
        try {
            log.debug("对账处理更新：==> {}", items.toString());
            if (!CollectionUtils.isEmpty(items)) {
                MybatisDaoImpl.run().updateBatchById(items, 100);
            }
        } catch (Exception e) {
            throw new ReconciliationProcessorException("更新对账流水异常：".concat(e.getMessage()), e);
        }

    }

}
