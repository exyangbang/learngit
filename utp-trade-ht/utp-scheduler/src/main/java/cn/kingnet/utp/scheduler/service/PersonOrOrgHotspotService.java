package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.product.api.account.IPersonOrOrgHotspotHandler;
import cn.kingnet.utp.scheduler.data.entity.Account;
import cn.kingnet.utp.scheduler.data.mapper.AccountMapper;
import cn.kingnet.utp.trade.common.dto.account.PersonOrOrgHotspotReqDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.SchedulerException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 个人/企业的客户热点信息关联服务
 * @Author sheqingquan@scenetec.com
 * @Create 2019/11/6 13:56
 */
@Service
@Slf4j
public class PersonOrOrgHotspotService {

    @Resource
    private IPersonOrOrgHotspotHandler personOrOrgHotspotHandler;

    public void addPersonOrOrgHotspot() {
        LambdaLogger.info(log, "个人/企业的客户热点信息关联任务 开始执行...");
        long startTime = System.currentTimeMillis();
        try {
            //查询虚拟账户表，类型为1平台 2企业 3个人 7佣金账户 8个体工商户
			// 且虚账户状态&(平台|商户)信息状态为正常 同时(平台|商户)审核状态为：审核通过|已认证 才能上报ecif
            List<Account> accountList = MybatisDaoImpl.of(AccountMapper.class).selectListBySql("getAccountInfo");
            if (!CollectionUtils.isEmpty(accountList)) {
                //虚账户状态必须为正常的 才能上报
                accountList.forEach(account -> {
                            PersonOrOrgHotspotReqDTO personOrOrgHotspotReqDTO = PersonOrOrgHotspotReqDTO.builder()
                                    .id(String.valueOf(account.getId()))
                                    .account(account.getAccount())
                                    .type(account.getObjType())
                                    .code(account.getObjCode())
                                    .name(account.getObjName())
                                    .fundAccount(account.getFundAccount())
                                    .build();
                            try {
                                personOrOrgHotspotHandler.addPersonOrOrgHotspot(personOrOrgHotspotReqDTO);
                            } catch (TradeException e) {
                                log.error("虚拟账户号{},客户热点信息关联失败：{}", account.getAccount(), e.getMessage());
                            }
                        });
            }
            LambdaLogger.info(log, "个人/企业的客户热点信息关联任务 执行完成,用时{}ms", System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            log.error("个人/企业的客户热点信息关联任务 异常终止执行，异常：[{}]", e.getMessage(), e);
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, String.format("个人/企业的客户热点信息关联任务 异常终止执行，异常：[%s]", e.getMessage()));
        }
    }
}
