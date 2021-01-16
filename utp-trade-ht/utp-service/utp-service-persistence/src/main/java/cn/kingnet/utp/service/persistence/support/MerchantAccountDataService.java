/*
package cn.kingnet.utp.service.persistence.support;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.ClearBankCode;
import cn.kingnet.utp.service.persistence.entity.ClearBankCodeCondition;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfo;
import cn.kingnet.utp.service.persistence.entity.MerchantAccountInfoCondition;
import cn.kingnet.utp.service.persistence.service.MerchantAccountService;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

*/
/**
 * @Description: 商户账户数据转换：已转换完成无需再执行
 * @Author sheqingquan@scenetec.com
 * @Create 2020/6/19 10:45
 *//*

@Slf4j
@Component
@Order(value = 11)
@Deprecated
public class MerchantAccountDataService implements ApplicationRunner {

    private RedisTemplate redisTemplate;
    private final String key = RedisKey.fmtKey(RedisKey.COMMON, "merchantAccountData", "firstTime");

    @Resource
    private MerchantAccountService merchantAccountService;

    public MerchantAccountDataService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (redisTemplate.hasKey(key)) {
            handle(false);
        } else {
            BoundValueOperations bOpts = redisTemplate.boundValueOps(key);
            try {
                log.info("开始 首次进行商户账户数据处理...");
                bOpts.set(true);
                handle(true);
                log.info("结束 首次进行商户账户数据处理...");
            } catch (Exception e) {
                bOpts.getOperations().delete(key);
                log.error("商户账户数据处理异常==>{}", e.getMessage(), e);
            }
        }
    }

    */
/**
     * 可提供外部触发 重新加载
     * @param firstTime
     *//*

    private void handle(boolean firstTime) {
        if (firstTime) {
            handleMerchantAccountData();
        } else {
            log.info("非首次启动，不进行商户账户数据处理...");
        }
    }

    */
/**
     * 商户账户数据转换
     *//*

    private void handleMerchantAccountData() {
        try {
            //每次查询1000条
            int count = MybatisDaoImpl.run().selectCount(MerchantAccountInfoCondition.builder().build());
            Page page = new Page(1, 1000);
            page.setTotal(count);
            for (int cur = page.getCurrent(); cur <= page.getPages(); cur++) {
                List<MerchantAccountInfo> list = MybatisDaoImpl.run().selectPage(MerchantAccountInfoCondition.builder().build(), cur, page.getSize());
                if (!CollectionUtils.isEmpty(list)) {
                    //开户行非数字或为空，则根据清算行找到开户行,并更新,找不到则user_modified字段更新为 bankCodeError 及更新时间
                    List<MerchantAccountInfo> updateList = list.stream()
                            .filter(merchantAccountInfo -> {
                                //过滤出 开户行非数字或为空 的数据
                                if (StringUtil.isBlank(merchantAccountInfo.getBankCode())) {
                                    return true;
                                }
                                if (!isNum(merchantAccountInfo.getBankCode())) {
                                    return true;
                                }
                                return false;
                            }).map(merchantAccountInfo -> {
                                //清算行为空，认为数据转换失败
                                if (StringUtil.isBlank(merchantAccountInfo.getReceiveBankCode())) {
                                    return buildFail(merchantAccountInfo);
                                }
                                ClearBankCode clearBankCode = MybatisDaoImpl.run().selectOne(ClearBankCodeCondition.builder().andClBankCodeEq(merchantAccountInfo.getReceiveBankCode()).build());
                                if (null == clearBankCode) {
                                    //根据清算行未找到开户行
                                    return buildFail(merchantAccountInfo);
                                } else {
                                    //更新开户行
                                    merchantAccountInfo.setBankCode(clearBankCode.getOpBankCode());
                                }
                                return merchantAccountInfo;
                            }).collect(Collectors.toList());

                    if (!CollectionUtils.isEmpty(updateList)) {
                        log.info("批量商户账户数据转换，需要更新{}条", updateList.size());
                        merchantAccountService.batchUpdateMerchantAccount(updateList);
                    }
                }
            }
        } catch (Exception e) {
            log.error("商户账户数据转换异常:{}", e.getMessage(), e);
            throw new RuntimeException("商户账户数据转换异常", e);
        }
    }

    */
/**
     * 构建数据更新失败对象
     * @param merchantAccountInfo
     * @return
     *//*

    private MerchantAccountInfo buildFail(MerchantAccountInfo merchantAccountInfo) {
        merchantAccountInfo.setUserModified("bankCodeError");
        merchantAccountInfo.setGmtModified(new Date());
        return merchantAccountInfo;
    }

    */
/**
     * 验证是否为数字
     * @param value
     *//*

    public boolean isNum(String value) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
*/
