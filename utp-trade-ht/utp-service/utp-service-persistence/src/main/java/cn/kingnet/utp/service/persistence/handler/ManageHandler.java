package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.IManageHandler;
import cn.kingnet.utp.service.persistence.entity.FreezingFundsOpeApproval;
import cn.kingnet.utp.service.persistence.entity.FreezingFundsOpeApprovalCondition;
import cn.kingnet.utp.service.persistence.entity.vo.FreezingFundsOpeApprovalVo;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author WJH
 * @Date 2019/10/16
 */
@RestController
@RequestMapping("/spi/persistence/manage")
public class ManageHandler extends DefaultFeginExceptionHandler implements IManageHandler {

    @PostMapping("selectFreezingFundsOpeApproval")
    @Override
    public FreezingFundsOpeApproval selectFreezingFundsOpeApproval(@RequestBody FreezingFundsOpeApprovalVo vo) {
        PlusEntityWrapper<FreezingFundsOpeApproval> plusEntityWrapper =
                FreezingFundsOpeApprovalCondition.builder().andAccountEq(vo.getAccount()).andClinetTransIdEq(vo.getClinetTransId()).build();
        FreezingFundsOpeApproval freezingFundsOpeApproval =
                MybatisDaoImpl.run().selectOne(plusEntityWrapper);
        return freezingFundsOpeApproval;
    }

}
