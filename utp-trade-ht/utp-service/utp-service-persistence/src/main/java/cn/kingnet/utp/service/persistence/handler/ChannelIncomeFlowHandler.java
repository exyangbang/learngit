package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IChannelIncomeFlowHandler;
import cn.kingnet.utp.service.persistence.entity.ChannelIncomeFlow;
import cn.kingnet.utp.service.persistence.entity.ChannelIncomeFlowCondition;
import cn.kingnet.utp.service.persistence.mapper.ChannelIncomeFlowMapper;
import cn.kingnet.utp.service.persistence.service.ChannelIncomeFlowService;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description : 账户入金通知流水
 * @Author : linkaigui
 * @Create : 2019/3/17 17:32
 */
@RestController
@RequestMapping("/spi/persistence/channelIncomeFlow")
public class ChannelIncomeFlowHandler extends DefaultFeginExceptionHandler implements IChannelIncomeFlowHandler {

    @Resource
    private ChannelIncomeFlowMapper channelIncomeFlowMapper;

    @Resource
    private ChannelIncomeFlowService channelIncomeFlowService;
    /**
     * 查询账户入金通知流水信息
     *
     * @param coreNo
     * @return
     */
    @PostMapping("/findChannelIncomeFlowByCoreNo")
    @Override
    public ChannelIncomeFlow findChannelIncomeFlowByCoreNo(@RequestParam(value = "coreNo") String coreNo) {
        return MybatisDaoImpl.run().selectOne(ChannelIncomeFlowCondition.builder().andCoreNoEq(coreNo).build());
    }

    /**
     * 保存账户入金通知流水
     *
     * @param channelIncomeFlow
     * @return
     */
    @PostMapping("/saveChannelIncomeFlow")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveChannelIncomeFlow(@RequestBody(required = false) ChannelIncomeFlow channelIncomeFlow) {
        return channelIncomeFlowMapper.insert(channelIncomeFlow);
    }

    @PostMapping("/isExistChannelIncomeFlowByCoreNo")
    @Override
    public boolean isExistChannelIncomeFlowByCoreNo(@RequestParam(value = "accNo") String accNo, @RequestParam(value = "coreNo") String coreNo) {
        int count = MybatisDaoImpl.run().selectCount(ChannelIncomeFlowCondition.builder().andAccNoEq(accNo).andCoreNoEq(coreNo).build());
        return count > 0;
    }

    @Override
    @PostMapping("/isExistChannelIncomeFlowByRid")
    public boolean isExistChannelIncomeFlowByRid(@RequestParam(value = "accNo") String accNo, @RequestParam(value = "rid") String rid) {
        int count = MybatisDaoImpl.run().selectCount(ChannelIncomeFlowCondition.builder().andAccNoEq(accNo).andRidEq(rid).build());
        return count > 0;
    }

    @PostMapping("/syncBankAccDetail2LocalFunctionAccount")
    @Override
    public void syncBankAccDetail2LocalFunctionAccount() {
        channelIncomeFlowService.syncBankAccDetail2LocalFunctionAccount();
    }
    @PostMapping("/syncBankAccDetail2LocalSubAccount")
    @Override
    public void syncBankAccDetail2LocalSubAccount(@RequestParam(value = "industryCode") String industryCode){
        channelIncomeFlowService.syncBankAccDetail2LocalSubAccount(industryCode);
    }

}
