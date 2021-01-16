package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IFeeIncomeAccountMonthStatHandler;
import cn.kingnet.utp.service.persistence.entity.FeeIncomeAccountMonthStat;
import cn.kingnet.utp.service.persistence.entity.FeeIncomeAccountMonthStatCondition;
import cn.kingnet.utp.service.persistence.entity.vo.FeeIncomeAccountMonthStatVo;
import cn.kingnet.utp.trade.common.enums.CollectionStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/08/14
 */
@RestController
@RequestMapping("/spi/persistence/feeIncomeAccountMonthStat")
@Slf4j
public class FeeIncomeAccountMonthStatHandler extends DefaultFeginExceptionHandler implements IFeeIncomeAccountMonthStatHandler {

    @Override
    @GetMapping("getById")
    public FeeIncomeAccountMonthStat getById(Long id) {
        return MybatisDaoImpl.run().selectById(FeeIncomeAccountMonthStat.class, id);
    }

    @GetMapping("getAccountAndServerTransId")
    @Override
    public FeeIncomeAccountMonthStat getAccountAndServerTransId(String account, String serverTransId) {
        FeeIncomeAccountMonthStatCondition condition = FeeIncomeAccountMonthStatCondition.builder().andAccountEq(account).andServerTransIdEq(serverTransId);
        List<FeeIncomeAccountMonthStat> list = MybatisDaoImpl.run().selectList(condition.build());
        FeeIncomeAccountMonthStat feeIncomeAccountMonthStat = null;
        if (!CollectionUtils.isEmpty(list)) {
            if (list.size() > 1) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "收益账户归集统计服务端流水号存在多记录");
            }
            feeIncomeAccountMonthStat = list.get(0);
        }
        return feeIncomeAccountMonthStat;
    }

    @PostMapping("updateByAccountAndServerTransId")
    @Override
    public void updateByAccountAndServerTransId(@RequestBody FeeIncomeAccountMonthStatVo feeIncomeAccountMonthStatVo) {
        Assert.hasText(feeIncomeAccountMonthStatVo.getAccount(), () -> "入参收益账户不能为空");
        Assert.hasText(feeIncomeAccountMonthStatVo.getServerTransId(), () -> "入参收益账户归集划转服务端流水号不能为空");

        MybatisDaoImpl.run().update(FeeIncomeAccountMonthStat.of(feeIncomeAccountMonthStatVo),
                FeeIncomeAccountMonthStatCondition.builder().andAccountEq(feeIncomeAccountMonthStatVo.getAccount()).andServerTransIdEq(feeIncomeAccountMonthStatVo.getServerTransId())
                        .and().andCollectionStatusNe(CollectionStatus.COLLECTED.getStatus()).orCollectionStatusIsNull()
                        .and().andTransStatusNe(TransStatus.TRADE_SUCCESS.name()).orTransStatusIsNull().build());

    }

}
