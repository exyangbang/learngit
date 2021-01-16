package cn.kingnet.utp.channel.onebank.service.callback;

import cn.kingnet.product.api.account.IAccountIncomeNoticeHandler;
import cn.kingnet.utp.trade.common.dto.onebank.*;
import cn.kingnet.utp.trade.common.enums.OneBankAccountIncomeNoticeRespCode;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.onebank.dmb.client.container.service.IService;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 华通内部账户入金通知接口
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/11/5 10:06
 */
@Slf4j
public class DBMAccountIncomeNoticeConsumer implements IService {

    private final IAccountIncomeNoticeHandler accountIncomeNoticeHandler;

    public DBMAccountIncomeNoticeConsumer() {
        this.accountIncomeNoticeHandler = BeanApplicationContext.getBean(IAccountIncomeNoticeHandler.class);;
    }

    @Override
    public Message execute(Message message) throws Exception {
        LambdaLogger.info(log, "华通内部账户入金通知接收报文: {}", JSON.toJSONString(message));
        Message reutrnMsg = new Message();
        reutrnMsg.setSysHead(message == null ? null : message.getSysHead());
        reutrnMsg.setAppHead(new AppHeader());
        //判断是否业务成功
        if (message == null || message.getBody() == null) {
            OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder = OneBankAccountIncomeNoticeRespDTO.builder()
                    .rspHead(OneBankRspHead.builder().bzflag(OneBankAccountIncomeNoticeRespCode.ER1031024.getHeadRspCode()).errmsg("无请求参数 message body").build())
                    .rspBody(OneBankAccountIncomeNoticeRespDTO.RspBody.builder().build());
            reutrnMsg.setBody(JSONObject.toJSONBytes(respDTOBuilder.build()));
            LambdaLogger.error(log, "华通内部账户入金通知报文 body is null");
            return reutrnMsg;
        }
        //成功则取包处理
        String rspString = new String(message.getBody());
        LambdaLogger.info(log, "华通内部账户入金通知接收报文BODY: {}", rspString);
        OneBankRspHead.OneBankRspHeadBuilder oneBankRspHeadBuilder = OneBankRspHead.builder();
        try {
            OneBankAccountIncomeNoticeReqDTO oneBankAccountIncomeNoticeReqDTO = JSON.parseObject(rspString, OneBankAccountIncomeNoticeReqDTO.class);

            //reqHead处理
            OneBankReqHead reqHead = oneBankAccountIncomeNoticeReqDTO.getReqHead();
            if(reqHead == null){
                OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder = OneBankAccountIncomeNoticeRespDTO.builder()
                        .rspHead(oneBankRspHeadBuilder.bzflag(OneBankAccountIncomeNoticeRespCode.ER1031024.getHeadRspCode()).errmsg("参数[reqHead]错误").build())
                        .rspBody(OneBankAccountIncomeNoticeRespDTO.RspBody.builder().build());
                reutrnMsg.setBody(JSONObject.toJSONBytes(respDTOBuilder.build()));
                return reutrnMsg;
            }

            //处理响应头部rspHead
            oneBankRspHeadBuilder.reqchid(reqHead.getReqchid()).reqtime(reqHead.getReqtime()).reqno(reqHead.getReqno());

            //reqBody处理
            OneBankAccountIncomeNoticeReqDTO.ReqBody reqBody = oneBankAccountIncomeNoticeReqDTO.getReqBody();
            if(reqBody == null){
                OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder = OneBankAccountIncomeNoticeRespDTO.builder()
                        .rspHead(oneBankRspHeadBuilder.bzflag(OneBankAccountIncomeNoticeRespCode.ER1031024.getHeadRspCode()).errmsg(OneBankAccountIncomeNoticeRespCode.ER1031024.getDesc()).build())
                        .rspBody(OneBankAccountIncomeNoticeRespDTO.RspBody.builder().build());
                reutrnMsg.setBody(JSONObject.toJSONBytes(respDTOBuilder.build()));
                return reutrnMsg;
            }

            //调用入金通知服务
            OneBankAccountIncomeNoticeRespDTO oneBankAccountIncomeNoticeRespDTO = accountIncomeNoticeHandler.accountIncomeNotice(oneBankAccountIncomeNoticeReqDTO);
            reutrnMsg.setBody(JSONObject.toJSONBytes(oneBankAccountIncomeNoticeRespDTO));
            LambdaLogger.info(log, "华通内部账户入金通知响应报文: {}", JSON.toJSONString(oneBankAccountIncomeNoticeRespDTO));
        } catch (Exception e) {
            log.error("华通内部账户入金通知异常：{}", e.getMessage(), e);
            OneBankAccountIncomeNoticeRespDTO.OneBankAccountIncomeNoticeRespDTOBuilder respDTOBuilder = OneBankAccountIncomeNoticeRespDTO.builder()
                    .rspHead(OneBankRspHead.builder().bzflag(OneBankAccountIncomeNoticeRespCode.ER1031025.getHeadRspCode()).errmsg("入账有误").build())
                    .rspBody(OneBankAccountIncomeNoticeRespDTO.RspBody.builder().build());
            reutrnMsg.setBody(JSONObject.toJSONBytes(respDTOBuilder.build()));
        }
        return reutrnMsg;
    }
}
