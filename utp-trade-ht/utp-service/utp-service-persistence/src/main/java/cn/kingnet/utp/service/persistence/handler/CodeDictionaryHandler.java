package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.ICodeDictionaryHandler;
import cn.kingnet.utp.service.persistence.entity.CodeDictionary;
import cn.kingnet.utp.service.persistence.entity.CodeDictionaryCondition;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description : 业务编码字典服务
 * @Author : sheqingquan@scenetec.com
 * @Create : 2019/2/22 11:31
 */
@RestController
@RequestMapping("/spi/persistence/codedictionaryhandler")
@Slf4j
public class CodeDictionaryHandler extends DefaultFeginExceptionHandler implements ICodeDictionaryHandler {

    /**
     * type->type:code type 1小时过期一次
     */
    private static Cache<String, Set<String>> typeCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.HOURS).build();

    @Override
    public boolean isExistCodeDictionary(@RequestParam("type") String type, @RequestParam("code") String code) {
        Assert.hasText(type, () -> "请求参数[type]不能为空");
        Assert.hasText(code, () -> "请求参数[code]不能为空");
        if (!existsTypeAndCodeInCache(type, code)) {
            return MybatisDaoImpl.run().selectCount(CodeDictionaryCondition.builder().andTypeEq(type).andCodeEq(code).build()) >= 1;
        }
        return true;
    }

    private boolean existsTypeAndCodeInCache(String type, String curCode) {
        if (!StringUtil.isBlank(type)) {
            try {
                Set<String> curCodeSet = typeCache.get(type, () -> {
                    List<CodeDictionary> list = MybatisDaoImpl.run().selectList(CodeDictionaryCondition.builder().andTypeEq(type).build());
                    Set<String> codeSet = null;
                    if (list != null) {
                        codeSet = list.stream().filter(o -> StringUtil.isNotBlank(o.getCode())).map(CodeDictionary::getCode).collect(Collectors.toSet());
                        if (codeSet != null && !codeSet.isEmpty()) {
                            typeCache.put(type, codeSet);
                        }
                    }
                    return codeSet;
                });
                return curCodeSet != null ? curCodeSet.contains(curCode) : false;
            } catch (ExecutionException e) {
                log.error("local Cache 加载查询异常：{}", e.getMessage(), e);
            }
        }
        return false;
    }
}
