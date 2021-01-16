package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.ISplitInfoHandler;
import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import cn.kingnet.utp.service.persistence.entity.SplitInfoCondition;
import cn.kingnet.utp.service.persistence.entity.bo.HTSettleSplitInfoBo;
import cn.kingnet.utp.service.persistence.service.InnerAccountService;
import cn.kingnet.utp.service.persistence.service.JobTaskService;
import cn.kingnet.utp.service.persistence.service.OutsideTransOrderService;
import cn.kingnet.utp.service.persistence.service.ProcessSplitInfoService;
import cn.kingnet.utp.trade.common.bo.IndustryPayInfo;
import cn.kingnet.utp.trade.common.bo.UserPayInfo;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.SplitStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2018年10月30日
 */
@RestController
@RequestMapping("/spi/persistence/splitInfo")
@Slf4j
public class SplitInfoHandler extends DefaultFeginExceptionHandler implements ISplitInfoHandler {

    @Resource
    private ProcessSplitInfoService processSplitInfoService;
    @Resource
    private InnerAccountService innerAccountService;
    @Resource
    private JobTaskService jobTaskService;
    @Resource
    private OutsideTransOrderService outsideTransOrderService;

    @Override
    @PostMapping("/saveSplitInfoBatch")
    @Transactional(rollbackFor = Exception.class)
    public void saveSplitInfoBatch(@RequestBody(required = false) HTSettleSplitInfoBo htSettleSplitInfoBo) {
        if (htSettleSplitInfoBo != null && !CollectionUtils.isEmpty(htSettleSplitInfoBo.getSplitInfoList())) {
            String industryCode = htSettleSplitInfoBo.getIndustryCode();
            String settleDate = htSettleSplitInfoBo.getSettleDate();
            String batchId = htSettleSplitInfoBo.getBatchId();
            List<SplitInfo> splitInfoList = htSettleSplitInfoBo.getSplitInfoList();
            if (!existsSplitInfoBySettleDate(industryCode, settleDate, batchId)) {
                MybatisDaoImpl.run().insertBatch(splitInfoList, 100);

                //更新关联支付订单流水状态|仅更新清算成功的
                List<SplitInfo> succSplitInfoList = splitInfoList.stream().filter(o -> !TransStatus.TRADE_FAILURE.name().equals(o.getTransStatus())).collect(Collectors.toList());
                updateByTransOrderIdsAndSuccess(succSplitInfoList);
                //创建处理分账定时任务
                jobTaskService.createJobTask4SplitInfo(htSettleSplitInfoBo.getIndustryCode(), htSettleSplitInfoBo.getSettleDate(), htSettleSplitInfoBo.getBatchId());

            } else {
                log.error("注意：代付客户号{}-清算日期{}-批次Id{}的清算分账记录已存在，不重新落库保存", htSettleSplitInfoBo.getIndustryCode(), settleDate, htSettleSplitInfoBo.getBatchId());
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("代付客户号%s-清算日期%s-批次Id%s的清算分账记录已存在", htSettleSplitInfoBo.getIndustryCode(), settleDate, htSettleSplitInfoBo.getBatchId()));
            }
        }

    }

    /**
     * 异步更新 分账关联的 支付订单次数
     * @param succSplitInfoList
     */
    private void updateByTransOrderIdsAndSuccess(List<SplitInfo> succSplitInfoList) {
        if (!CollectionUtils.isEmpty(succSplitInfoList)) {
            CompletableFuture.runAsync(()->{
                succSplitInfoList.forEach(o -> {
                    outsideTransOrderService.updateSplitStatusAndLinkedSplitNum(o.getIndustryCode(),o.getExtend1());
//                    Map<String, String> params = new HashMap<>(4);
//                    params.put("transOrderIds", o.getExtend1());
//                    MybatisDaoImpl.of(OutsideTransOrderMapper.class).updateBySql("updateByTransOrderIdsAndSuccess", params);
                });
            });
        }
    }

    /**
     * @param industryCode 代付客户号
     * @param settleDate   清算日期
     * @param batchId      批次Id
     * @return
     */
    public boolean existsSplitInfoBySettleDate(String industryCode, String settleDate, String batchId) {
        int count = MybatisDaoImpl.run().selectCount(SplitInfoCondition.builder().andIndustryCodeEq(industryCode).andSettleDateEq(settleDate).andBatchIdEq(batchId).build());
        return count > 0;
    }

    /**
     * @param providerCode 文件提供方|代付客户号
     * @param splitDate    清算分账日期
     * @return
     */
    @GetMapping("querySplitInfo")
    @Override
    public List<SplitInfo> querySplitInfo(@RequestParam(value = "providerCode", required = false) String providerCode,
                                          @RequestParam(value = "splitDate", required = false) String splitDate) {
        return MybatisDaoImpl.run().selectList(SplitInfoCondition.builder().andProviderCodeEq(providerCode).andSplitDateEq(splitDate).build());
    }

    /**
     * T+0 清算分账信息：处理入账
     *
     * @param settleDate yyyyMMdd
     * @return
     */
    @PostMapping("/batchProcessSplitInfo4T0")
    @Override
    public boolean batchProcessSplitInfo4T0(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchId", required = false) String batchId

    ) {
        return processSplitInfoService.batchProcessSplitInfo4T0(industryCode, settleDate, batchId);
    }

    /**
     * T+n 清算分账信息：处理入账
     *
     * @param splitDate yyyyMMdd
     * @return
     */
    @Override
    @PostMapping("/processSplitInfo4TN")
    public List<SplitInfo> processSplitInfo4TN(@RequestParam(value = "splitDate", required = false) String splitDate) {
        return processSplitInfoService.processSplitInfo4TN(splitDate);
    }

    /**
     * 清算分账信息：是否存在
     *
     * @param providerCode 文件提供方
     * @param settleDate   清算日期
     * @param batchId      批次Id
     * @return
     */
    @GetMapping("/isExistSplitInfo")
    @Override
    public boolean isExistSplitInfo(
            @RequestParam(value = "providerCode", required = false) String providerCode,
            @RequestParam(value = "settleDate", required = false) String settleDate,
            @RequestParam(value = "batchId", required = false) String batchId
    ) {
        return MybatisDaoImpl.run().selectCount(SplitInfoCondition.builder()
                .andProviderCodeEq(providerCode).andSettleDateEq(settleDate).andBatchIdEq(batchId)
                .build()) > 0;
    }

    /**
     * @param providerCode 文件提供方
     * @param settleDate   清算日期
     * @param batchId      批次Id
     * @return
     */
    @GetMapping("querySplitInfoByBatchId")
    @Override
    public List<SplitInfo> querySplitInfoByBatchId(@RequestParam(value = "providerCode", required = false) String providerCode,
                                                   @RequestParam(value = "settleDate", required = false) String settleDate,
                                                   @RequestParam(value = "batchId", required = false) String batchId) {
        return MybatisDaoImpl.run().selectList(SplitInfoCondition.builder()
                .andProviderCodeEq(providerCode).andSettleDateEq(settleDate).andBatchIdEq(batchId)
                .build());
    }


    /**
     * 是否入虚账且账期为0自动提现结果不明确的 分账记录
     *
     * @param industryCode 代付客户号
     * @param settleDate   清算日期
     * @param batchId      批次ID
     * @param queryTimes   大于该查询次数不再重跑查询
     * @return
     */
    @GetMapping("querySplitInfoUnSuccess")
    @Override
    public List<SplitInfo> querySplitInfoUnSuccess(@RequestParam(value = "industryCode", required = false) String industryCode,
                                                   @RequestParam(value = "settleDate", required = false) String settleDate,
                                                   @RequestParam(value = "batchId", required = false) String batchId,
                                                   @RequestParam(value = "queryTimes", required = false) int queryTimes
    ) {
        SplitInfoCondition condition = SplitInfoCondition.builder()
                .andStatusEq(SplitStatus.SPLIT_OK.getStatus()).andPeriodEq(0)
                .and().andTransStatusNe(TransStatus.TRADE_SUCCESS.name()).orTransStatusIsNull()
                .and().andTransStatusNe(TransStatus.TRADE_FAILURE.name()).orTransStatusIsNull()
                .and()
                .andIndustryCodeEq(industryCode).andSettleDateEq(settleDate).andBatchIdEq(batchId)
                .andQueryTimesLe(queryTimes);

        return MybatisDaoImpl.run().selectList(condition.build());

    }

    /**
     * 更新清算分账 提现状态等信息
     *
     * @param splitInfo
     */
    @PostMapping("updateTransStatusById")
    @Override
    public void updateTransStatusById(@RequestBody(required = false) SplitInfo splitInfo) {
        if (splitInfo != null) {
            MybatisDaoImpl.run().updateById(splitInfo);
        }
    }

    /**
     * 查询后更新清算分账 提现状态、描述及查询次数
     *
     * @param splitInfoId   分账主键Id
     * @param transStatus   交易状态
     * @param transDesc     描述
     * @param reconcileDate 查询返回清算对账日
     */
    @Override
    @PostMapping("updateTransStatusAndTimesById")
    public void updateTransStatusAndTimesById(
            @RequestParam(value = "splitInfoId") String splitInfoId, @RequestParam(value = "transStatus") String transStatus,
            @RequestParam(value = "transDesc", required = false) String transDesc, @RequestParam(value = "reconcileDate", required = false) String reconcileDate
    ) {
        String setSql;
        if (StringUtil.isNotEmpty(reconcileDate)) {
            setSql = String.format(" trans_status='%s' , trans_desc='%s',query_times=query_times+1 ,gmt_modified = '%s',reconcile_date = '%s' ", transStatus, transDesc,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), reconcileDate);
        } else {
            setSql = String.format(" trans_status='%s' , trans_desc='%s',query_times=query_times+1 ,gmt_modified = '%s' ", transStatus, transDesc, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        MybatisDaoImpl.run().updateForSet(setSql, SplitInfoCondition.builder().andIdEq(splitInfoId).build());
    }

    @GetMapping("getSplitInfoById")
    @Override
    public SplitInfo getSplitInfoById(@RequestParam(value = "splitInfoId") String splitInfoId) {
        return MybatisDaoImpl.run().selectById(SplitInfo.class, splitInfoId);
    }


    /**
     * 查询用户账户 清算分账流水
     *
     * @param userAccount 用户账户
     * @param startDate   起始日期 yyyyMMdd
     * @param endDate     终止日期 yyyyMMdd
     * @return
     */
    @GetMapping("/queryAccountDetail4Income")
    @Override
    public List<SplitInfo> queryAccountDetail4Income(@RequestParam(value = "userAccount") String userAccount,
                                                     @RequestParam(value = "startDate", required = false) String startDate,
                                                     @RequestParam(value = "endDate", required = false) String endDate) {

        SplitInfoCondition condition = SplitInfoCondition.builder();
        //提现 = 代付出金 或者 余额出金
        condition.andUserAccountEq(userAccount);

        if (StringUtil.isNotEmpty(startDate) && StringUtil.isNotEmpty(endDate)) {
            condition.andSettleDateBetween(startDate, endDate);
        } else if (StringUtil.isNotEmpty(startDate) && StringUtil.isEmpty(endDate)) {
            condition.andSettleDateGe(startDate);
        } else if (StringUtil.isNotEmpty(endDate) && StringUtil.isEmpty(startDate)) {
            condition.andSettleDateLe(endDate);
        }
        condition.orderDesc(" settle_date ");

        return MybatisDaoImpl.run().selectList(condition.build());
    }

    @GetMapping("/isExistsSplitInfo4Success")
    @Override
    public Boolean isExistsSplitInfo4Success(String industryCode, String clientTransId) {
        int count = MybatisDaoImpl.run().selectCount(SplitInfoCondition.builder().andIndustryCodeEq(industryCode).andClientTransIdEq(clientTransId).andStatusEq(SplitStatus.SPLIT_OK.getStatus()).build());
        return count > 0;

    }

    @GetMapping("/getIndustryPayInfo")
    @Override
    public IndustryPayInfo getIndustryPayInfo(@RequestParam("industryCode") String industryCode) {
        IndustryPayInfo industryPayInfo = innerAccountService.getIndustryPayInfo(industryCode);
        if (industryCode == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "查无此客户号[" + industryCode + "]关联的支付信息");
        }
        return industryPayInfo;
    }

    @GetMapping("/getUserPayInfo")
    @Override
    public UserPayInfo getUserPayInfo(@RequestParam("userAccount") String userAccount) {
        UserPayInfo userPayInfo = innerAccountService.getUserPayInfo(userAccount,true);
        if (userPayInfo == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "查无此用户账户[" + userAccount + "]关联的支付信息");
        }
        return userPayInfo;
    }

    @PostMapping("/processSingleSplitPayment")
    @Override
    public void processSingleSplitPayment(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "userAccount", required = false) String userAccount,
            @RequestParam(value = "payAmt", required = false) long payAmt,
            @RequestParam(value = "serverTransId", required = false) String serverTransId,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "clientTransId", required = false) String clientTransId
    ) {
        Assert.hasText(industryCode, () -> "参数[industryCode]不能为空");
        Assert.hasText(userAccount, () -> "参数[userAccount]不能为空");
        Assert.isTrue(payAmt > 0, () -> "参数[payAmt]必须大于0");
        Assert.hasText(serverTransId, () -> "参数[serverTransId]不能为空");
        Assert.hasText(clientTransId, () -> "参数[clientTransId]不能为空");
        processSplitInfoService.processSingleSplitPayment(industryCode, userAccount, payAmt, serverTransId, remark, clientTransId);
    }

    @PostMapping("/processSingleSplitPaymentRefund")
    @Override
    public void processSingleSplitPaymentRefund(
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "payerAccount", required = false) String payerAccount,
            @RequestParam(value = "payeeAccount", required = false) String payeeAccount,
            @RequestParam(value = "payAmt", required = false) long payAmt,
            @RequestParam(value = "serverTransId", required = false) String serverTransId,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "clientTransId", required = false) String clientTransId,
            @RequestParam(value = "origTransId", required = false) Long origTransId,
            @RequestParam(value = "historyStatus", required = false) String historyStatus) {

        Assert.hasText(industryCode, () -> "参数[industryCode]不能为空");
        Assert.hasText(payerAccount, () -> "参数[payerAccount]不能为空");
        Assert.hasText(payeeAccount, () -> "参数[payeeAccount]不能为空");
        Assert.isTrue(payAmt > 0, () -> "参数[payAmt]必须大于0");
        Assert.hasText(serverTransId, () -> "参数[serverTransId]不能为空");
        Assert.hasText(clientTransId, () -> "参数[clientTransId]不能为空");
        Assert.notNull(origTransId, () -> "参数[origTransId]不能为空");
        processSplitInfoService.processSingleSplitPaymentRefund(industryCode, payerAccount, payeeAccount, payAmt, serverTransId, remark, clientTransId, origTransId, historyStatus);
    }

    @PostMapping("/saveSplitInfo")
    @Override
    public void saveSplitInfo(@RequestBody SplitInfo splitInfo) {
        MybatisDaoImpl.run().insert(splitInfo);
    }
}
