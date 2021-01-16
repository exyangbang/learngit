package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.ICollectAccountWithdrawHandler;
import cn.kingnet.utp.service.persistence.entity.CollectAccountWithdraw;
import cn.kingnet.utp.service.persistence.entity.CollectAccountWithdrawCondition;
import cn.kingnet.utp.service.persistence.entity.vo.CollectAccountWithdrawVo;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
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
@RequestMapping("/spi/persistence/collectAccountWithdraw")
@Slf4j
public class CollectAccountWithdrawHandler extends DefaultFeginExceptionHandler implements ICollectAccountWithdrawHandler {

    @Override
    @GetMapping("getById")
    public CollectAccountWithdraw getById(String id) {
        return MybatisDaoImpl.run().selectById(CollectAccountWithdraw.class, id);
    }

    @GetMapping("existsAccountAndClientIdOrServerId")
    @Override
    public boolean existsAccountAndClientIdOrServerId(String account, @RequestParam(value = "clientTransId", required = false) String clientTransId, @RequestParam(value = "serverId", required = false) String serverId) {
        CollectAccountWithdrawCondition condition = CollectAccountWithdrawCondition.builder().andAccountEq(account);
        if (StringUtil.isNotBlank(clientTransId)) {
            condition.andClientTransIdEq(clientTransId);
        }
        if (StringUtil.isNotBlank(serverId)) {
            condition.andServerTransIdEq(serverId);
        }
        int num = MybatisDaoImpl.run().selectCount(condition.build());
        return num > 0;
    }

    @GetMapping("getByIndustryCodeAndClientTransId")
    @Override
    public CollectAccountWithdraw getByIndustryCodeAndClientTransId(String industryCode, String clientTransId) {
        CollectAccountWithdrawCondition condition = CollectAccountWithdrawCondition.builder().andIndustryCodeEq(industryCode).andClientTransIdEq(clientTransId);
        List<CollectAccountWithdraw> list = MybatisDaoImpl.run().selectList(condition.build());
        CollectAccountWithdraw collectAccountWithdraw = null;
        if (!CollectionUtils.isEmpty(list)) {
            if (list.size() > 1) {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "归集账户提现客户端流水号存在多记录");
            }
            collectAccountWithdraw = list.get(0);
        }
        return collectAccountWithdraw;
    }

    @PostMapping("updateByIndustryCodeAndClientTransId")
    @Override
    public void updateByIndustryCodeAndClientTransId(@RequestBody CollectAccountWithdrawVo collectAccountWithdrawVo) {
        Assert.hasText(collectAccountWithdrawVo.getIndustryCode(), () -> "入参归集客户号不能为空");
        Assert.hasText(collectAccountWithdrawVo.getClientTransId(), () -> "入参归集提现客户端流水号不能为空");

        MybatisDaoImpl.run().update(CollectAccountWithdraw.of(collectAccountWithdrawVo),
                CollectAccountWithdrawCondition.builder().andIndustryCodeEq(collectAccountWithdrawVo.getIndustryCode()).andClientTransIdEq(collectAccountWithdrawVo.getClientTransId())
                        .and().andTransStatusNe(TransStatus.TRADE_SUCCESS.name()).orTransStatusIsNull().build());

    }

}
