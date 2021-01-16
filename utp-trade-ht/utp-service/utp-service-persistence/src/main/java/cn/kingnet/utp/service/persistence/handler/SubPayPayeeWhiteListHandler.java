package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.ISubPayPayeeWhiteListHandler;
import cn.kingnet.utp.service.persistence.mapper.SubPayPayeeWhiteListMapper;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import com.google.common.collect.Maps;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description : 收款人白名单
 * @Author : linkaigui
 * @Create : 2020/5/15 10:06
 */
@RestController
@RequestMapping("/spi/persistence/payeeWhite")
public class SubPayPayeeWhiteListHandler extends DefaultFeginExceptionHandler implements ISubPayPayeeWhiteListHandler {

    @GetMapping("/selectCountByIndustryAndPayee")
    @Override
    public Integer selectCountByIndustryAndPayee(@RequestParam(value = "industryId", required = false) Long industryId,
                                         @RequestParam(value = "payeeAccount", required = false) String payeeAccount,
                                         @RequestParam(value = "payeeName", required = false) String payeeName) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("industryId", industryId);
        params.put("payeeAccount", payeeAccount);
        params.put("payeeName", payeeName);
        List<Integer> list = MybatisDaoImpl.of(SubPayPayeeWhiteListMapper.class).selectListBySql("selectCountByIndustryAndPayee", params);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return 0;
    }
}
