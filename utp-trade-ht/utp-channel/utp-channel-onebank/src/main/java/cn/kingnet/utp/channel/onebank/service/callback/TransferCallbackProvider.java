package cn.kingnet.utp.channel.onebank.service.callback;

import cn.kingnet.product.api.account.IOneBankCallbackHandler;
import cn.kingnet.utp.channel.onebank.support.UtpRedisTemplate;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferCallbackReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankTransferCallbackRespDTO;
import cn.kingnet.utp.trade.common.enums.OneBankRespCode;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.onebank.dmb.client.container.service.IService;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

/**
 * @Description : 转账回调接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 10:06
 */
@Slf4j
public class TransferCallbackProvider implements IService {

    private final IOneBankCallbackHandler oneBankCallbackHandler;

    private UtpRedisTemplate utpRedisTemplate;

    public TransferCallbackProvider() {
        this.oneBankCallbackHandler = BeanApplicationContext.getBean(IOneBankCallbackHandler.class);
        this.utpRedisTemplate = BeanApplicationContext.getBean(UtpRedisTemplate.class);
    }

    @Override
    public Message execute(Message message) throws Exception {
        LambdaLogger.info(log, "华通异步回调接收报文: {}", JSON.toJSONString(message));

        Message reutrnMsg = new Message();
        reutrnMsg.setSysHead(message == null ? null : message.getSysHead());
        reutrnMsg.setAppHead(new AppHeader());
        //判断是否业务成功
        if (message == null || message.getBody() == null) {
            reutrnMsg.setBody(JSONArray.toJSONBytes(OneBankTransferCallbackRespDTO.builder().respCode(OneBankRespCode.PCC000001.name()).respMsg("Message Or message.getBody() is Null").build()));
            LambdaLogger.error(log, "华通异步回调接收报文 body is null");
            return reutrnMsg;
        }
        //成功则取包处理
        String rspString = new String(message.getBody());
        LambdaLogger.info(log, "华通异步回调接收报文BODY: {}", rspString);
        pubCallbackResp(rspString);
        try {
            OneBankTransferCallbackReqDTO oneBankTransferCallbackReqDTO = JSON.parseObject(rspString, OneBankTransferCallbackReqDTO.class);
            if (oneBankTransferCallbackReqDTO == null) {
                reutrnMsg.setBody(JSONArray.toJSONBytes(OneBankTransferCallbackRespDTO.builder().respCode(OneBankRespCode.PCC000001.name()).respMsg("message.getBody() Incorrect content").build()));
                log.error("华通交易异步通知异常：{} body={}", "message.getBody() incorrect content.", rspString);
            } else {
                OneBankTransferCallbackRespDTO rsp = oneBankCallbackHandler.transferCallback(oneBankTransferCallbackReqDTO);
                reutrnMsg.setBody(JSONArray.toJSONBytes(rsp));
            }
        } catch (Exception e) {
            log.error("华通交易异步通知异常：{}", e.getMessage(), e);
            reutrnMsg.setBody(JSONArray.toJSONBytes(OneBankTransferCallbackRespDTO.builder().respCode(OneBankRespCode.PCC000002.name()).respMsg("业务处理不成功").build()));
        }
        return reutrnMsg;
    }

    @Async
    public void pubCallbackResp(String callbackResp) {
        try {
            utpRedisTemplate.get().convertAndSend(RedisKey.TOPIC_HT_CALLBACK_RESP.name(), callbackResp);
        } catch (Exception e) {
            LambdaLogger.error(log, "发布华通回调内容异常：" + e.getMessage(), e);
        }
    }

}
