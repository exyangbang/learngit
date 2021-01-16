package cn.kingnet.utp.scheduler.task.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.scheduler.data.entity.OutsideTransOrder;
import cn.kingnet.utp.scheduler.data.mapper.OutsideTransOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2021/01/05
 */
@Service
@Slf4j
public class OutsideTransFLowService {

    @Transactional(rollbackFor = Exception.class)
    public void backupOutsideTransFlow(OutsideTransOrder mix) {
        try {
            Map<String, String> param = new HashMap<>();
            param.put("mixTransOrderId", mix.getTransOrderId());
            param.put("industryCode", mix.getIndustryCode());
            MybatisDaoImpl.of(OutsideTransOrderMapper.class).insertBySql("moveToOutsideFlowBak", param);
            MybatisDaoImpl.of(OutsideTransOrderMapper.class).deleteBySql("deleteByBatchId", param);
            OutsideTransOrder mixUpdate = OutsideTransOrder.builder().id(mix.getId()).gmtModified(Date.from(Instant.now()))
                    .fileConvertFlag(1).fileConvertDesc("融合支付流水批次明细已移除到备份表").build();
            MybatisDaoImpl.run().updateById(mixUpdate);
        } catch (Exception e) {
            log.error("融合支付流水明细移动|删除及融合支付流水信息更新异常:{}", e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
