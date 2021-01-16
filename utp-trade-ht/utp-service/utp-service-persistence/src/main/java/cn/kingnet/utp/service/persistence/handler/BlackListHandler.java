package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.IBlackListHandler;
import cn.kingnet.utp.service.persistence.entity.BlackList;
import cn.kingnet.utp.service.persistence.entity.BlackListCondition;
import cn.kingnet.utp.service.persistence.mapper.BlackListMapper;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/spi/persistence/blackList")
public class BlackListHandler implements IBlackListHandler {

    @Resource
    private RedisTemplate<String, List<BlackList>> redisTemplate;

    @Override
    public boolean findIsBlackByNameAndIdCode(String name, String idCode) {
        PlusEntityWrapper<BlackList> build = BlackListCondition.builder()
                .andNameEq(name)
                .andIdCodeEq(idCode).build();
        return MybatisDaoImpl.run().selectCount(build) >= 1;
    }

    @Override
    public boolean findIsBlackByEntNameAndBusLicCode(String entName, String busLicCode) {
        PlusEntityWrapper<BlackList> build = BlackListCondition.builder()
                .andEntNameEq(entName)
                .andBusLicCodeEq(busLicCode).build();
        return MybatisDaoImpl.run().selectCount(build) >= 1;
    }

    @Override
    public List<BlackList> selectAllBlackList() {
        String key = RedisKey.COMMON.fmtKey("blackList");
        if (redisTemplate.hasKey(key)) {
            return redisTemplate.boundValueOps(key).get();
        } else {
            List<BlackList> blackLists = MybatisDaoImpl.of(BlackListMapper.class).selectListBySql("selectAllBlackList");
            if (!CollectionUtils.isEmpty(blackLists)) {
                redisTemplate.boundValueOps(key).set(blackLists, 10, TimeUnit.MINUTES);
            }
            return blackLists;
        }
    }
}
