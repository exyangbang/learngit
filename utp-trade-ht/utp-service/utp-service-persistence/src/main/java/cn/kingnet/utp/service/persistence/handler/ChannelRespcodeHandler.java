package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.service.persistence.api.IChannelRespcodeHandler;
import cn.kingnet.utp.service.persistence.entity.ChannelRespcode;
import cn.kingnet.utp.service.persistence.entity.ChannelRespcodeCondition;
import cn.kingnet.utp.trade.common.enums.TrueOrFalseStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author WJH
 * @Date 2019/06/17
 */
@RestController
@RequestMapping("/spi/persistence/channelRespcode")
public class ChannelRespcodeHandler extends DefaultFeginExceptionHandler implements IChannelRespcodeHandler {

    @Override
    public List<ChannelRespcode> queryByTransStatus(String transStatus) {
        PlusEntityWrapper<ChannelRespcode> plusEntityWrapper = ChannelRespcodeCondition.builder()
                .andTransStatusEq(transStatus).andStatusEq(TrueOrFalseStatus.TRUE.value()).build();
        return MybatisDaoImpl.run().selectList(plusEntityWrapper);
    }

    @Override
    public ChannelRespcode queryByTransStatusAndRespcode(String transStatus, String respcode) {
        PlusEntityWrapper<ChannelRespcode> plusEntityWrapper = ChannelRespcodeCondition.builder()
                .andTransStatusEq(transStatus).andChannelRespcodeEq(respcode).andStatusEq(TrueOrFalseStatus.TRUE.value()).build();
        return MybatisDaoImpl.run().selectOne(plusEntityWrapper);
    }

}
