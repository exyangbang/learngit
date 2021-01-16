package cn.kingnet.utp.scheduler.service;

import cn.kingnet.utp.service.persistence.api.IRedisCacheHandler;
import cn.kingnet.utp.service.persistence.api.ISplitInfoHandler;
import cn.kingnet.utp.service.persistence.api.ISplitInfoUploadLogHandler;
import cn.kingnet.utp.service.persistence.entity.SplitInfo;
import cn.kingnet.utp.service.persistence.entity.SplitInfoUploadLog;
import cn.kingnet.utp.trade.common.dto.account.SplitInfoResultDTO;
import cn.kingnet.utp.trade.common.enums.FileBatchStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.TransStatus;
import cn.kingnet.utp.trade.common.exception.SchedulerException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 清算分账服务
 * @Author WJH
 * @Date 2018年10月23日
 */
@Service
@Slf4j
public class IndustrySettleSplitService {

    static final String SEPARATOR = "|";

    @Resource
    private ISplitInfoHandler iSplitInfoHandler;

    @Resource
    private UDPSettleSplitFeature udpSettleSplitFeature;
    @Resource
    private ISplitInfoUploadLogHandler iSplitInfoUploadLogHandler;
    @Resource
    private IRedisCacheHandler redisCacheHandler;

    /**
     * 平台T0 清算分账：1.虚拟账户入账 2.分账记录更新
     * 事务下沉处理
     */
    public void processSplitInfo4T0(String industryCode, String settleDate, String batchId) {
        List<SplitInfo> list = null;
        try {
            SplitInfoUploadLog splitInfoUploadLog = iSplitInfoUploadLogHandler.querySplitInfoByBatchId(industryCode, settleDate, batchId);
            if (splitInfoUploadLog == null) {
                LambdaLogger.error(log, "查无此清算分账记录,代付客户{}-清算日期{}-批次号{}", industryCode, settleDate, batchId);
                return;
            }
            if (TransStatus.TRADE_SUCCESS.name().equals(splitInfoUploadLog.getTransStatus()) || TransStatus.TRADE_FAILURE.name().equals(splitInfoUploadLog.getTransStatus())) {
                LambdaLogger.info(log, String.format("清算分账记录,代付客户%s-清算日期%s-批次号%s 明确状态[%s]不再分账处理", industryCode, settleDate, batchId, splitInfoUploadLog.getTransStatus()));
                return;
            }
            if (StringUtil.isBlank(splitInfoUploadLog.getTransStatus())) {
                String warnMsg = String.format("清算分账记录,代付客户%s-清算日期%s-批次号%s 批次交易状态为[null]，待下次任务轮询处理", industryCode, settleDate, batchId, splitInfoUploadLog.getTransStatus());
                LambdaLogger.warn(log, warnMsg);
                throw new SchedulerException(HttpRespStatus.BAD_REQUEST, warnMsg);
            }
            //仅已初始化的批次状态记录执行清分作业
            if (TransStatus.PRE_CREATE.name().equals(splitInfoUploadLog.getTransStatus())) {
                LambdaLogger.info(log, "清算分账记录,代付客户{}-清算日期{}-批次号{}，开始处理..", industryCode, settleDate, batchId);
                boolean batchStatus = iSplitInfoHandler.batchProcessSplitInfo4T0(industryCode, settleDate, batchId);
                LambdaLogger.info(log, "清算分账记录,代付客户{}-清算日期{}-批次号{}，批处理状态：{}", industryCode, settleDate, batchId, batchStatus ? "成功" : "失败");
            } else {
                LambdaLogger.warn(log, String.format("清算分账记录,代付客户%s-清算日期%s-批次号%s 批次交易状态[%s]，暂不能进行分账处理", industryCode, settleDate, batchId, splitInfoUploadLog.getTransStatus()));
            }
        } catch (Exception e) {
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, String.format("清算分账记录%s-%s-%s，虚账入账异常[%s]", industryCode, settleDate, batchId, e.getMessage()), e);
        }
    }


    /**
     * 清算分账结果 回盘
     *
     * @param settleDate
     */
    public void returnSplitInfoResult(String industryCode, String settleDate, String batchId) {

        SplitInfoUploadLog splitInfoUploadLog = iSplitInfoUploadLogHandler.querySplitInfoByBatchId(industryCode, settleDate, batchId);
        if (splitInfoUploadLog == null) {
            LambdaLogger.error(log, "回盘:查无此清算分账记录{}-{}-{}", industryCode, settleDate, batchId);
            return;
        }
        if (TransStatus.TRADE_SUCCESS.name().equals(splitInfoUploadLog.getTransStatus())) {
            iSplitInfoUploadLogHandler.updateSplitInfoUploadLogStatus(SplitInfoUploadLog.builder().providerCode(industryCode).settleDate(settleDate).batchId(batchId).transStatus(TransStatus.TRADE_SUCCESS.name())
                    .remark("清算分账处理成功，并回调完成").build());
            callBackSettleSplitResult(industryCode, settleDate, batchId, splitInfoUploadLog.getCallbackUrl());
            return;
        } else if (TransStatus.TRADE_FAILURE.name().equals(splitInfoUploadLog.getTransStatus())) {
            iSplitInfoUploadLogHandler.updateSplitInfoUploadLogStatus(SplitInfoUploadLog.builder().providerCode(industryCode).settleDate(settleDate).batchId(batchId).transStatus(TransStatus.TRADE_FAILURE.name())
                    .remark("清算分账处理失败，并回调完成").build());
            callBackSettleSplitResult(industryCode, settleDate, batchId, splitInfoUploadLog.getCallbackUrl());
            return;
        } else {
            LambdaLogger.error(log, "回盘:清算分账记录,代付客户{}-清算日期{}-批次号{} 业务未处理完，暂不能出清算分账回盘文件", industryCode, settleDate, batchId);
            throw new SchedulerException(HttpRespStatus.BAD_REQUEST, String.format("批次状态为[%s],分账业务未处理完.备注说明：%s", splitInfoUploadLog.getTransStatus(), splitInfoUploadLog.getRemark()));
        }
       /*
        //1.该批次下已入虚账，未提现分账记录
        List<SplitInfo> unSuccessList = iSplitInfoHandler.querySplitInfoUnSuccess(industryCode, settleDate, batchId, 3);

        //2.入虚账完成且提现转账未完成的，重新发起查询
        if (!CollectionUtils.isEmpty(unSuccessList)) {
            LambdaLogger.warn(log, "回盘:清算分账记录,代付客户{}-清算日期{}-批次号{} 业务未处理完，暂不能出清算分账回盘文件", industryCode, settleDate, batchId);
        } else {
            iSplitInfoUploadLogHandler.updateSplitInfoUploadLogStatus(SplitInfoUploadLog.builder().providerCode(industryCode).settleDate(settleDate).batchId(batchId).transStatus(TransStatus.TRADE_SUCCESS.name())
                    .remark("清算分账处理完成，并回调完成").build());
            callBackSettleSplitResult(industryCode, settleDate, batchId, splitInfoUploadLog.getCallbackUrl());
        }
*/

    }

    @Async
    public void callBackSettleSplitResult(String industryCode, String settleDate, String batchId, String callbackUrl) {
        List<SplitInfo> splitInfoList = iSplitInfoHandler.querySplitInfoByBatchId(industryCode, settleDate, batchId);
        // 按规范生成文件并推送到文件提供方
        int totalCount = CollectionUtils.isEmpty(splitInfoList) ? 0 : splitInfoList.size();
        //H|settle_result|20180101|222
        StringBuffer stringBuffer = new StringBuffer()
                .append(UDPSettleSplitFeature.HEADMARK).append(SEPARATOR)
                .append(UDPSettleSplitFeature.TxType.SETTLE_RESULT.getType()).append(SEPARATOR)
                .append(DateUtil.getCurrentDate()).append(SEPARATOR).append(totalCount);
        if (totalCount > 0) {
            AtomicInteger succNum = new AtomicInteger();
            //清算日期|客户端流水号|用户账户|金额|结算方式|账期|备注|扩展1|扩展2|扩展3|交易状态|结果说明|对账日期
            splitInfoList.forEach(item -> {
                stringBuffer.append("\n")
                        .append(StringUtil.objTrimToEmpty(item.getSettleDate())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getClientTransId())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getUserAccount())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getAmount())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getSettleMode())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getPeriod())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getRemark())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getExtend1())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getServerTransId())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getExtend3())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getTransStatus())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getTransDesc())).append(SEPARATOR)
                        .append(StringUtil.objTrimToEmpty(item.getReconcileDate()));

                if (TransStatus.TRADE_SUCCESS.name().equals(item.getTransStatus())) {
                    succNum.incrementAndGet();
                }
            });
            try {
                String fileName = UDPSettleSplitFeature.buildResultFileName(industryCode, settleDate, batchId);
                byte[] settleResultFile = stringBuffer.toString().getBytes("utf-8");
                DataUtil.byte2File(settleResultFile, udpSettleSplitFeature.getSettleSplitDir(), fileName);

                String batchStatus = succNum.get() == 0 ? FileBatchStatus.FAILURE.getStatus() : (succNum.get() == totalCount ? FileBatchStatus.SUCCESS.getStatus() : FileBatchStatus.PART_SUCCESS.getStatus());

                SplitInfoResultDTO resultDTO = new SplitInfoResultDTO();
                resultDTO.setIndustryCode(industryCode);
                resultDTO.setSettleDate(settleDate);
                resultDTO.setBatchNo(batchId);
                resultDTO.setBatchStatus(batchStatus);
                resultDTO.setContent(DataUtil.deflaterAndEncode64(settleResultFile));
                redisCacheHandler.saveNoticeCallbackMessage(callbackUrl, industryCode, batchId, BeanMap.create(resultDTO));

            } catch (Exception e) {
                log.error("回调:代付客户{}-清算日期{}-批次号{} 清算分账回盘文件回调异常:[{}]", industryCode, settleDate, batchId, e.getMessage(), e);
                throw new SchedulerException(HttpRespStatus.SERVER_ERROR, String.format("回调:代付客户%s-清算日期%s-批次号%s 清算分账回盘文件回调异常[%s]", industryCode, settleDate, batchId, e.getMessage()), e);
            }
        }
    }


    /**
     * T+n模式 清算分账：1.虚拟账户入账 2.分账记录更新 3.代付模式自动发起代付，记账模式无需发起代付
     * 事务下沉处理
     *
     * @param splitDate
     */
    public void processSplitInfo4TN(String splitDate) {
        List<SplitInfo> list;
        try {
            LambdaLogger.info(log, "T+n清算分账记录，分账日期:{} 开始处理..", splitDate);
            list = iSplitInfoHandler.processSplitInfo4TN(splitDate);
            LambdaLogger.info(log, "T+n清算分账记录,分账日期:{} 处理完成. 虚账入账成功数{}", new Object[]{splitDate, list != null ? list.size() : 0});
        } catch (Exception e) {
            throw new SchedulerException(HttpRespStatus.SERVER_ERROR, String.format("T+n清算分账记录,分账日期:%s，处理异常[%s]", splitDate, e.getMessage()), e);
        }
    }


}
