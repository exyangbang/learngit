package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.ICountryHandler;
import cn.kingnet.utp.service.persistence.entity.CountryCondition;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 国籍代码类Handler
 * @author admin
 */
@RestController
@RequestMapping("/spi/persistence/country")
public class CountryHandler extends DefaultFeginExceptionHandler implements ICountryHandler {

    @PostMapping("findBy/threeBitLetters")
    @Override
    public boolean isExistByThreeBitLetters(@RequestParam(value = "country", required = false) String country) {
        Assert.hasText(country, () -> "三位字母不能为空");
        return MybatisDaoImpl.run().selectCount(CountryCondition.builder().andThreeBitLettersEq(country).build()) >= 1;
    }
}