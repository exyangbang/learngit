package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IClearBankCodeHandler;
import cn.kingnet.utp.service.persistence.entity.ClearBankCode;
import cn.kingnet.utp.service.persistence.entity.ClearBankCodeCondition;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 清算行表
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/10 11:01
 */
@RestController
@RequestMapping("/spi/persistence/clearBankCodeHandler")
public class ClearBankCodeHandler implements IClearBankCodeHandler {

    @PostMapping("/getClearBankCode")
    @Override
    public String getClearBankCode(@RequestParam(value = "openBankCode") String openBankCode) {
        Assert.hasText(openBankCode, "参数[openBankCode]不能为空");
        ClearBankCode clearBankCode = MybatisDaoImpl.run().selectOne(ClearBankCodeCondition.builder().andOpBankCodeEq(openBankCode).build());
        if (null != clearBankCode) {
            return clearBankCode.getClBankCode();
        }
        return null;
    }
}