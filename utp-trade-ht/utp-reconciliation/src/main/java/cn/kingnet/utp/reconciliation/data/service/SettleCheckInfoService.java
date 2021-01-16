package cn.kingnet.utp.reconciliation.data.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.reconciliation.data.entity.SettleCheckInfoCondition;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description : 描述
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/23 20:27
 */
@Component
public class SettleCheckInfoService {

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public int updateAccountHandleFlag(Long id,String accountHandleFlag){
        int count = 0;
        if(id != null && StringUtil.isNotBlank(accountHandleFlag)){
            String updateSql = String.format("account_handle_flag = '%s',gmt_modified = '%s'",accountHandleFlag, DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
            count = MybatisDaoImpl.run().updateForSet(updateSql, SettleCheckInfoCondition.builder().andIdEq(id).build());
        }
        return count;
    }
}
