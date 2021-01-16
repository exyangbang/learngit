package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.utp.service.persistence.api.IPaymentCheckHandler;
import cn.kingnet.utp.service.persistence.entity.Industry;
import cn.kingnet.utp.service.persistence.entity.IndustryCondition;
import cn.kingnet.utp.service.persistence.entity.bo.PaymentCheckBo;
import cn.kingnet.utp.service.persistence.service.IndustryService;
import cn.kingnet.utp.service.persistence.service.MsgNoticeService;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.NoticeType;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 对公小额打款验证
 * @Author sheqingquan@scenetec.com
 * @Create 2020/4/10 14:35
 */
@Slf4j
@RestController
@RequestMapping("/spi/persistence/paymentCheckHandler")
public class PaymentCheckHandler extends DefaultFeginExceptionHandler implements IPaymentCheckHandler {

    @Autowired
    private MsgNoticeService msgNoticeService;
    @Resource
    private IndustryService industryService;

    @PostMapping("/notify")
    @Override
    public ServerResponseDTO notify(@RequestBody PaymentCheckBo paymentCheckBo) {
        try {
            if (null == paymentCheckBo) {
                return new ServerResponseDTO(HttpRespStatus.SERVER_ERROR.valueStr(), "请求通知信息异常");
            }
            sendNotify(paymentCheckBo);
            return new ServerResponseDTO(HttpRespStatus.OK.valueStr(), "处理成功");
        } catch (Exception e) {
            log.error("服务端流水号{}，卡号{}，小额打款验证绑卡状态变化通知异常==>{}", paymentCheckBo.getServerTransId(), paymentCheckBo.getAcctNo(), e.getMessage(), e);
            return new ServerResponseDTO(HttpRespStatus.SERVER_ERROR.valueStr(), e.getMessage());
        }
    }

    /**
     * 小额打款验证绑卡状态变化通知
     * @param paymentCheckBo
     */
    private void sendNotify(PaymentCheckBo paymentCheckBo) {
        Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(paymentCheckBo.getIndustryCode()).build());
        if (industry != null && !StringUtil.isBlank(industry.getInnerNoticeUrl())) {
            Map<String, Object> map = new HashMap<>(16);
            map.put("userAccount", paymentCheckBo.getUserAccount());
            map.put("acctNo", paymentCheckBo.getAcctNo());
            map.put("bindStatus", paymentCheckBo.getBindStatus());
            map.put("errCode", paymentCheckBo.getErrCode());
            map.put("errMsg", paymentCheckBo.getErrMsg());

            Map<String, Object> content = new HashMap<>(8);
            content.put("noticeType", NoticeType.AUTH_BIND_STATUS_CHANGE.getType());
            content.put("industryCode", industry.getCode());
            content.put("items", map);
            msgNoticeService.saveNoticeCallbackMessage(industry.getInnerNoticeUrl(), paymentCheckBo.getIndustryCode(), paymentCheckBo.getServerTransId(), content);
        }
    }
}