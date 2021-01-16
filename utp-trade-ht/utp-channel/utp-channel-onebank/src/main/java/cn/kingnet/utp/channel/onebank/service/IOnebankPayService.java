package cn.kingnet.utp.channel.onebank.service;

import cn.kingnet.utp.trade.common.dto.sp.SpBaseRequest;
import cn.kingnet.utp.trade.common.dto.sp.SpBaseResponse;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.concurrent.CompletableFuture;

/**
 * @Description : 渠道交易接口
 * @Author : linkaigui
 * @Create : 2020/7/3 10:25
 */
public interface IOnebankPayService<REQ extends SpBaseRequest, RESP extends SpBaseResponse>{

    public CompletableFuture<?> doSyncWork(ServerRequest request);
}
