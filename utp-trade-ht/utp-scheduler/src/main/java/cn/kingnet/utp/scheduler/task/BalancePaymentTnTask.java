package cn.kingnet.utp.scheduler.task;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.framework.starter.mybatis.mapper.PlusEntityWrapper;
import cn.kingnet.utp.scheduler.data.entity.TransCurrent;
import cn.kingnet.utp.scheduler.data.entity.TransCurrentCondition;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.trade.common.bo.InnerAccountTransferBo;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.utils.CommonConstants;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description Tn余额支付处理
 * @Author WJH
 * @Date 2020年03月14日
 */
@Slf4j
@Component
public class BalancePaymentTnTask {
    private final ExecutorService executorService;
    private final IAccountHandler accountHandler;

    public BalancePaymentTnTask(IAccountHandler accountHandler) {
        this.accountHandler = accountHandler;
        this.executorService = new ThreadPoolExecutor(4, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("BalancePaymentTnTask-%d").build(), new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * Tn余额支付处理 8点 一定要早于对账
     */
    @Scheduled(cron = "${cn.kingnet.utp.schedule.ht-properties.corn.balancePaymentTnSettleDaily}")
    public void balancePaymentTnSettleDaily() {
        LambdaLogger.info(log, "余额支付Tn结算任务 开始执行...");
        long sTime = System.currentTimeMillis();
        String curDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        List<TransCurrent> transCurrentList;
        try {
            PlusEntityWrapper<TransCurrent> condition = TransCurrentCondition.builder()
                    .andTradeTypeEq(TradeType.BALANCE_PAYMENT.toString()).andPaymentSettleStatusEq(CommonConstants.PAYMENT_SETTLE_STATUS_UNDO)
                    .andTransStatusEq(TransStatus.TRADE_SUCCESS.name()).andRefundStatusEq(CommonConstants.REFUND_STATUS_UNDO).andPaymentPeriodGt(0).andTransDateLt(curDate).build();
            Integer count = MybatisDaoImpl.run().selectCount(condition);
            if (count == null || count.intValue() == 0) {
                LambdaLogger.info(log, logger -> logger.info("查无{}前余额支付Tn待结算交易记录", curDate));
                return;
            }
            transCurrentList = new ArrayList<>(count);
            Page page = new Page(1, 500);
            page.setTotal(count);
            long pages = page.getPages();
            for (int i = 1; i <= pages; i++) {
                List<TransCurrent> details = MybatisDaoImpl.run().selectPage(condition, i, page.getSize());
                if (details != null && !details.isEmpty()) {
                    transCurrentList.addAll(details);
                }
            }
        } catch (Exception e) {
            log.error("余额支付Tn结算终止执行，获取交易信息异常[{}]", e.getMessage(), e);
            return;
        }
        try {
            CompletableFuture<?>[] completableFutures =
                    transCurrentList.stream()
                            .map(this::buildInnerAccountTransferBo)
                            .map(this::runTnSettleProcessSync)
                            .map(future -> future.thenAcceptAsync(r -> {
                                LambdaLogger.info(log, "余额支付Tn结算完成,共耗时:{}毫秒. 服务端流水号[{}] >> 订单号[{}],金额[{}]分,收款账户[{}:{}] ", (System.currentTimeMillis() - sTime), r.getServerTransId(), r.getOutsideOrderId(), r.getAmount(), r.getPayeeAccount(), r.getPayeeAccountName());
                            }))
                            .toArray(size -> new CompletableFuture[size]);

            CompletableFuture.allOf(completableFutures).join();
            LambdaLogger.info(log, "共{} 笔余额支付Tn结算完成，共耗时:{}毫秒", transCurrentList.size(), (System.currentTimeMillis() - sTime));
        } catch (Exception e) {
            log.error("余额支付Tn结算异常:{}", e.getMessage(), e);
        }

    }


    private InnerAccountTransferBo buildInnerAccountTransferBo(TransCurrent transCurrent) {
        InnerAccountTransferBo.InnerAccountTransferBoBuilder builder = InnerAccountTransferBo.builder();
        builder.transId(transCurrent.getId()).industryCode(transCurrent.getIndustryCode())
                .payerAccount(transCurrent.getPayerAccount()).payerAccountName(transCurrent.getPayerName())
                .payeeAccount(transCurrent.getPayeeAccount()).payeeAccountName(transCurrent.getPayeeName())
                .period(transCurrent.getPaymentPeriod()).amount(transCurrent.getRealAmount())
                .serverTransId(transCurrent.getServerTransId()).outsideOrderId(transCurrent.getOrderId())
                .remark(transCurrent.getSummaryDescription());
        return builder.build();
    }


    private CompletableFuture<InnerAccountTransferBo> runTnSettleProcessSync(InnerAccountTransferBo bo) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                this.accountHandler.balancePaymentTnSettle(bo);
            } catch (Exception e) {
                LambdaLogger.error(log, "余额支付Tn结算异常：服务端流水号[{}] >> 订单号[{}],金额[{}]分,收款账户[{}:{}] ", bo.getServerTransId(), bo.getOutsideOrderId(), bo.getAmount(), bo.getPayeeAccount(), bo.getPayeeAccountName());
            }
            return bo;
        }, executorService);
    }


}
