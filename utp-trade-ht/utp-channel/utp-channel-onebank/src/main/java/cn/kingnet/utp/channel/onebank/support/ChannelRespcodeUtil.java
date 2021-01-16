package cn.kingnet.utp.channel.onebank.support;

import cn.kingnet.utp.service.persistence.api.IChannelRespcodeHandler;
import cn.kingnet.utp.service.persistence.entity.ChannelRespcode;
import cn.kingnet.utp.trade.common.enums.OneBankRespCode;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author WJH
 * @Date 2019/06/17
 */
@Slf4j
@Component
public class ChannelRespcodeUtil {

    private IChannelRespcodeHandler channelRespcodeHandler;
    private static final Map<String, ChannelRespcode> SUCCESS_MAP = new HashMap<>();
    private static final Map<String, ChannelRespcode> FAILURE_MAP = new HashMap<>();
    private static final Map<String, ChannelRespcode> PROCESSING_MAP = new HashMap<>();

    public ChannelRespcodeUtil(IChannelRespcodeHandler channelRespcodeHandler) {
        this.channelRespcodeHandler = channelRespcodeHandler;
    }

    private ChannelRespcode queryByTransStatusAndRespcode(String transStatus, String respcode) {
        ChannelRespcode channelRespcode = null;
        if (StringUtil.isNotBlank(transStatus) && StringUtil.isNotBlank(respcode)) {
            channelRespcode = channelRespcodeHandler.queryByTransStatusAndRespcode(transStatus, respcode);
        }
        return channelRespcode;
    }

    /**
     *  渠道响应码是否明确失败 不确定或无响应码视为非明确失败
     * @param respCode
     * @return
     */
    public boolean isFailureRespcode(String respCode) {
        ChannelRespcode channelRespcode;
        if (StringUtil.isBlank(respCode)) {
            return false;
        }
        //目前提供错误码枚举检验
        if (OneBankRespCode.isFailureRespcode(respCode)) {
            return true;
        }
        // 库表标注交易失败的响应码 校验
        channelRespcode = FAILURE_MAP.get(respCode);
        if (channelRespcode == null) {
            try {
                channelRespcode = queryByTransStatusAndRespcode(TransStatus.TRADE_FAILURE.name(), respCode);
                FAILURE_MAP.put(respCode, channelRespcode);
            } catch (Exception e) {
                log.error("查询交易状态[{}]-渠道响应码[{}]对照关系记录异常：{}", TransStatus.TRADE_FAILURE.name(), respCode, e.getMessage());
                return false;
            }
        }
        if (channelRespcode != null) {
            return true;
        }
        return false;
    }

}
