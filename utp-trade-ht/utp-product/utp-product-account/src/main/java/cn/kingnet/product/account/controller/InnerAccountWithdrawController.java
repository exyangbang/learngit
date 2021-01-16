package cn.kingnet.product.account.controller;

import cn.kingnet.product.account.service.inner.InnerQueryWithdrawService;
import cn.kingnet.product.account.service.inner.InnerWithdrawService;
import cn.kingnet.product.account.service.inner.manage.QueryTransStatusService;
import cn.kingnet.product.api.account.InnerAccountWithdrawHandler;
import cn.kingnet.utp.product.common.dto.manage.QueryTransStatusReqDTO;
import cn.kingnet.utp.trade.common.dto.account.InnerQueryWithdrawReqDTO;
import cn.kingnet.utp.trade.common.dto.account.InnerWithdrawReqDTO;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description 内部调用提现
 */
@RestController
@RequestMapping("/innerAccount/withdraw")
@Slf4j
public class InnerAccountWithdrawController extends DefaultFeginExceptionHandler implements InnerAccountWithdrawHandler {

    @Resource
    private InnerWithdrawService innerWithdrawService;
    @Resource
    private InnerQueryWithdrawService innerQueryWithdrawService;
    @Resource
    private QueryTransStatusService queryTransStatusService;
    private ExecutorService executorService;

    public InnerAccountWithdrawController() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("InnerAccountWithdraw-%s").build();
        this.executorService = new ThreadPoolExecutor(4, 100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(500), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
    }

    @Override
    @PostMapping("/autoWithdrawForSplit")
    public void autoWithdrawForSplit(@RequestBody(required = false) List<InnerWithdrawReqDTO> innerWithdrawReq) {
        if (innerWithdrawReq != null && !innerWithdrawReq.isEmpty()) {
            CompletableFuture<?>[] list = innerWithdrawReq.stream().map(req ->
                    CompletableFuture.supplyAsync(() -> innerWithdrawService.doService(req), executorService)
                            .whenComplete((r, e) -> {
                                if (e != null) {
                                    log.error("分账系统自动提现异常 >> 请求参数:{} 异常：{}", JSON.toJSONString(req), e.getMessage(), e);
                                }
                            })
            ).toArray(CompletableFuture[]::new);
            CompletableFuture.allOf(list).whenComplete((r, e) -> {
                log.info("分账系统自动提现完成.共提现记录数[{}]", list == null ? 0 : list.length);
            });
        }
    }

    @Override
    @PostMapping("/processUnSuccessResultForSplit")
    public void processUnSuccessResultForSplit(@RequestBody(required = false) List<InnerQueryWithdrawReqDTO> innerQueryWithdrawReq) {
        if (innerQueryWithdrawReq != null && !innerQueryWithdrawReq.isEmpty()) {
            CompletableFuture<?>[] list =
                    innerQueryWithdrawReq.stream().map(req -> CompletableFuture.supplyAsync(() -> innerQueryWithdrawService.doService(req), executorService)
                            .whenComplete((r, e) -> {
                                if (e != null) {
                                    log.error("分账系统自动提现结果查询异常 >> 请求参数：{} 异常：{}", JSON.toJSONString(req), e.getMessage(), e);
                                }
                            })
                    ).toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(list).whenComplete((r, e) -> {
                log.info("分账系统自动提现结果查询完成.共查询记录数[{}]", list == null ? 0 : list.length);
            });
        }

    }

    @Override
    @PostMapping("/queryTransStatus")
    public void queryTransStatus(String industryCode, String clientTradeId, String origServerTradeId) {
        QueryTransStatusReqDTO reqDTO = new QueryTransStatusReqDTO();
        reqDTO.setIndustryCode(industryCode);
        reqDTO.setClientTradeId(clientTradeId);
        reqDTO.setOrigServerTradeId(origServerTradeId);
        queryTransStatusService.doService(reqDTO);
    }


}
