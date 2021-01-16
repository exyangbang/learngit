package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.ICommonDictionaryHandler;
import cn.kingnet.utp.service.persistence.entity.CommonDictionary;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2018年11月08日
 */
@RestController
@RequestMapping("/spi/persistence/commonDictionary")
public class CommonDictionaryHandler extends DefaultFeginExceptionHandler implements ICommonDictionaryHandler {

    @GetMapping("/getCommonDictionaryByType")
    @Override
    public List<CommonDictionary> getCommonDictionaryByType(String type) {
        return MybatisDaoImpl.run().selectList(CommonDictionary.builder().type(type).build());
    }
}
