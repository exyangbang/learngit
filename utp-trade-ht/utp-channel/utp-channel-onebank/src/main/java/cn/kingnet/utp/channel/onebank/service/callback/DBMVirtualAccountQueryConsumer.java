package cn.kingnet.utp.channel.onebank.service.callback;

import cn.kingnet.product.api.account.IOneBankVirtualAccountQueryHandler;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankReqHead;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankRspHead;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankVirtualAccountQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankVirtualAccountQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.OneBankVirtualAccountQueryRespCode;
import cn.kingnet.utp.trade.common.support.BeanApplicationContext;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.onebank.dmb.client.container.service.IService;
import cn.onebank.dmb.common.message.AppHeader;
import cn.onebank.dmb.common.message.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description : 电子账户所属实体机构户查询
 * @Author : linkaigui
 * @Create : 2019/3/14 16:05
 */
@Slf4j
public class DBMVirtualAccountQueryConsumer implements IService {

    private final IOneBankVirtualAccountQueryHandler oneBankVirtualAccountQueryHandler;

    public DBMVirtualAccountQueryConsumer() {
        this.oneBankVirtualAccountQueryHandler = BeanApplicationContext.getBean(IOneBankVirtualAccountQueryHandler.class);
    }

    @Override
    public Message execute(Message message) throws Exception {
        LambdaLogger.info(log, "电子账户所属实体机构户查询接收报文: {}", JSON.toJSONString(message));
        Message reutrnMsg = new Message();
        reutrnMsg.setSysHead(message == null ? null : message.getSysHead());
        reutrnMsg.setAppHead(new AppHeader());
        //判断是否业务成功
        if (message == null || message.getBody() == null) {
            OneBankVirtualAccountQueryRespDTO.OneBankVirtualAccountQueryRespDTOBuilder respDTOBuilder = OneBankVirtualAccountQueryRespDTO.builder()
                    .rspHead(OneBankRspHead.builder().bzflag(OneBankVirtualAccountQueryRespCode.R14.getHeadRspCode()).errmsg(OneBankVirtualAccountQueryRespCode.R14.getDesc()).build())
                    .rspBody(OneBankVirtualAccountQueryRespDTO.RspBody.builder().rspCode(OneBankVirtualAccountQueryRespCode.R14.getRspCode()).build());
            reutrnMsg.setBody(JSONObject.toJSONBytes(respDTOBuilder.build()));
            LambdaLogger.error(log, "电子账户所属实体机构户查询 body is null");
            return reutrnMsg;
        }

        //成功则取包处理
        String rspString = new String(message.getBody());
        LambdaLogger.info(log, "电子账户所属实体机构户查询接收报文BODY: {}", rspString);
        OneBankRspHead.OneBankRspHeadBuilder oneBankRspHeadBuilder = OneBankRspHead.builder();
        try {
            OneBankVirtualAccountQueryReqDTO oneBankVirtualAccountQueryReqDTO = JSON.parseObject(rspString, OneBankVirtualAccountQueryReqDTO.class);
            if(oneBankVirtualAccountQueryReqDTO.getReqHead() != null){
                OneBankReqHead reqHead = oneBankVirtualAccountQueryReqDTO.getReqHead();
                oneBankRspHeadBuilder.reqchid(reqHead.getReqchid()).reqtime(reqHead.getReqtime()).reqno(reqHead.getReqno());
            }
            if(oneBankVirtualAccountQueryReqDTO.getReqBody() == null){
                OneBankVirtualAccountQueryRespDTO.OneBankVirtualAccountQueryRespDTOBuilder respDTOBuilder = OneBankVirtualAccountQueryRespDTO.builder()
                        .rspHead(oneBankRspHeadBuilder.bzflag(OneBankVirtualAccountQueryRespCode.R14.getHeadRspCode()).errmsg(OneBankVirtualAccountQueryRespCode.R14.getDesc()).build())
                        .rspBody(OneBankVirtualAccountQueryRespDTO.RspBody.builder().rspCode(OneBankVirtualAccountQueryRespCode.R14.getRspCode()).build());
                reutrnMsg.setBody(JSONObject.toJSONBytes(respDTOBuilder.build()));
            }else {
                OneBankVirtualAccountQueryRespDTO oneBankVirtualAccountQueryRespDTO = oneBankVirtualAccountQueryHandler.virtualAccountQuery(oneBankVirtualAccountQueryReqDTO);
                reutrnMsg.setBody(JSONObject.toJSONBytes(oneBankVirtualAccountQueryRespDTO));
                LambdaLogger.info(log, "电子账户所属实体机构户查询响应报文: {}", JSON.toJSONString(oneBankVirtualAccountQueryRespDTO));
            }
        } catch (Exception e) {
            log.error("电子账户所属实体机构户查询异常：{}", e.getMessage(), e);
            OneBankVirtualAccountQueryRespDTO.OneBankVirtualAccountQueryRespDTOBuilder respDTOBuilder = OneBankVirtualAccountQueryRespDTO.builder()
                    .rspHead(oneBankRspHeadBuilder.bzflag(OneBankVirtualAccountQueryRespCode.R99.getHeadRspCode()).errmsg("业务处理失败.").build())
                    .rspBody(OneBankVirtualAccountQueryRespDTO.RspBody.builder().rspCode(OneBankVirtualAccountQueryRespCode.R99.getRspCode()).build());
            reutrnMsg.setBody(JSONObject.toJSONBytes(respDTOBuilder.build()));
        }
        return reutrnMsg;
    }
}
