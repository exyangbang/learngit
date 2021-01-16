package cn.kingnet.utp.service.persistence.service;


import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.SettleCheckInfo;
import cn.kingnet.utp.service.persistence.entity.TransCurrentCondition;
import cn.kingnet.utp.service.persistence.mapper.TransCurrentMapper;
import cn.kingnet.utp.service.persistence.mapper.TransHistoryMapper;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * 差错处理
 */
@Slf4j
public abstract class SettleCheckBaseAbstractService {

    protected InnerAccountService innerAccountService;

    public SettleCheckBaseAbstractService(InnerAccountService innerAccountService) {
        this.innerAccountService = innerAccountService;
    }

    protected boolean isSuccess(TransStatus transStatus) {
        return TransStatus.TRADE_SUCCESS == transStatus;
    }

    protected boolean isMerFeeZero(SettleCheckInfo settleCheckInfo) {
        return settleCheckInfo==null||settleCheckInfo.getMerFee()==null || settleCheckInfo.getMerFee().longValue()<=0;
    }


    /**
     * 差错处理及处理状态更新
     *
     * @param id                  差错表Id
     * @param errorType           差错类型
     * @param transStatus         交易类型
     * @param transStatus         校正后交易状态
     * @param remark              备注说明
     * @param serverTransId       服务端交易流水号
     * @param needUpdateTransflow 是否更新交易流水表
     * @return
     */
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void adjustAccount4SettleCheck(long id, ReconciliationErrorType errorType,
                                          TradeType tradeType, TransStatus transStatus, String remark, String serverTransId, boolean needUpdateTransflow) {

//        if (ReconciliationErrorType.A == errorType) {
//            LambdaLogger.error(log, "差错记录id{}-服务端流水号：{} >> 差错类型为：{}即平台状态成功-渠道状态成功，无需校正状态", id, serverTransId, errorType.value());
//            return;
//        }
//        if (ReconciliationErrorType.B == errorType) {
//            LambdaLogger.error(log, "差错记录id{}-服务端流水号：{} >> 差错类型为：{}即渠道成功，本地无流水，暂无法处理", id, serverTransId, errorType.value());
//            return;
//        }
//        if (ReconciliationErrorType.G == errorType) {
//            LambdaLogger.error(log, "差错记录id{}-服务端流水号：{} >> 差错类型为：{}即渠道流水，本地流水信息不匹配，暂无法处理", id, serverTransId, errorType.value());
//            return;
//        }
        SettleCheckInfo settleCheckInfo = MybatisDaoImpl.run().selectById(SettleCheckInfo.class, id);
        if (settleCheckInfo == null || !tradeType.getCode().equals(settleCheckInfo.getTradeType())) {
            LambdaLogger.error(log, "差错记录id{}-服务端流水号：{} >> 查无此交易类型[{}]的差错流水记录，暂无法处理", id, serverTransId,tradeType.getCode());
            return;
        }

        //FIXME 测试反馈 全部以外部入参为准|更新差错表以及历史流水表
        boolean isNext = true;
        boolean isMoveToHistory = false;
        try {
            switch (errorType) {
                case C: {
                    log.info("差错记录id{}-服务端流水号：{} >> 平台状态失败-渠道状态成功，校正状态为:{}", id, serverTransId, transStatus.name());
                    switch (transStatus) {
                        case TRADE_SUCCESS: {
                            failure2SuccessStatus(settleCheckInfo, remark);
                            isNext = true;
                        }
                        break;
                        case TRADE_FAILURE: {
                            LambdaLogger.info(log, "差错记录id{}-服务端流水号：{} >> 虚账户操作,平台状态失败-渠道状态成功，校正状态为：交易失败。无效操作，拒绝变更资金操作", id, serverTransId);
                        }
                        break;
                        default: {
                        }
                    }
                }
                break;
                case D: {
                    log.info("差错记录id{}-服务端流水号：{} >> 平台状态处理中-渠道状态成功，校正状态为:{}", id, serverTransId, transStatus.name());
                    switch (transStatus) {
                        case TRADE_SUCCESS: {
                            processIng2SuccessStatus(settleCheckInfo, remark);
                            isNext = true;
                        }
                        break;
                        case TRADE_FAILURE: {
                            LambdaLogger.info(log, "差错记录id{}-服务端流水号：{} >> 虚账户操作,平台状态处理中-渠道状态成功，校正状态为：交易失败。无效操作，拒绝变更资金操作",
                                    id, serverTransId);
                        }
                        break;
                        default: {
                        }
                    }
                }
                break;
                case E: {
                    log.info("差错记录id{}-服务端流水号：{} >> 平台状态成功-渠道未匹配记录，校正状态为:{}", id, serverTransId, transStatus.name());
                    switch (transStatus) {
                        case TRADE_SUCCESS: {
                            LambdaLogger.info(log, "差错记录id{}-服务端流水号：{} >> 虚账户操作,平台状态成功-渠道未匹配记录，校正状态为：交易成功。复核正常操作，无需变更资金操作",
                                    id, serverTransId);
                            isMoveToHistory = true;
                        }
                        break;
                        case TRADE_FAILURE: {
                            success2FailureStatus(settleCheckInfo, remark);
                            isNext = true;
                            isMoveToHistory = true;
                        }
                        break;
                        default: {
                        }
                    }
                }
                break;
                case F: {
                    LambdaLogger.info(log, "差错记录id{}-服务端流水号：{} >> 平台状态处理中-渠道未匹配记录，校正状态为:{}", id, serverTransId, transStatus.name());
                    switch (transStatus) {
                        case TRADE_SUCCESS: {
                            processIng2SuccessStatus(settleCheckInfo,remark);
                           /* LambdaLogger.info(log, "差错记录id{}-服务端流水号：{} >> 虚账户操作,平台状态处理中-渠道未匹配记录，校正状态为：交易成功。无效操作，拒绝变更资金操作",
                                    id, serverTransId);*/
                            isMoveToHistory = true;
                        }
                        break;
                        case TRADE_FAILURE: {
                            processIng2FailureStatus(settleCheckInfo, remark);
                            isNext = true;
                            isMoveToHistory = true;
                        }
                        break;
                        default: {
                        }
                    }
                }
                break;
                case G: {
                    LambdaLogger.error(log, "差错记录id{}-服务端流水号：{} >> 虚账户操作：交易信息不匹配，暂无法处理", id, serverTransId);
                }
                break;
                default: {
                    LambdaLogger.error(log, "差错记录id{}-服务端流水号：{} >> 虚账户操作：未知差错类型[%s],暂拒绝处理.", id, serverTransId, errorType.name());
                }
            }
//            if (isNext) {
                //更新差错流水处理状态
                settleCheckInfo.setStatus(TrueOrFalseStatus.TRUE.value());
                settleCheckInfo.setRemark(remark);
                settleCheckInfo.setAuditStatus(AuditStatus.APPROVED.getStatus());
                settleCheckInfo.setAccountHandleFlag(TrueOrFalseStatus.TRUE.value());
                settleCheckInfo.setGmtModified(new Date());
                MybatisDaoImpl.run().updateById(settleCheckInfo);

                if (needUpdateTransflow) {
                    //更新关联交易流水状态,当前交易流水
                    String hql = String.format("trans_status='%s' , description = CONCAT_WS(',',description,'%s') , gmt_modified='%s'", transStatus.name(), remark, DateUtil.getCurrentDate(DateUtil.FORMAT_DATETIME));
                    MybatisDaoImpl.run().updateForSet(hql, TransCurrentCondition.builder().andServerTransIdEq(serverTransId).build());
                }
//            }
            if(isMoveToHistory){
                //e,f类型，移至历史流水表
                moveToHistory(id, errorType, serverTransId);
            }
        } catch (Exception e) {
            LambdaLogger.error(log, "服务端流水号{},差错处理异常:{}", serverTransId,e.getMessage(),e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, String.format("服务端流水号%s差错处理异常[%s]", serverTransId,e.getMessage()));
        }

    }

    /***平台原状态处理中 转 失败状态*/
    protected abstract void processIng2FailureStatus(SettleCheckInfo settleCheckInfo, String remark);

    /***平台原状态成功 转 失败状态*/
    protected abstract void success2FailureStatus(SettleCheckInfo settleCheckInfo, String remark);

    /***平台原状态处理中 转 成功状态*/
    protected abstract void processIng2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark);

    /***平台原状态失败 转 成功状态*/
    protected abstract void failure2SuccessStatus(SettleCheckInfo settleCheckInfo, String remark);


    /**
     * 用户实时内扣
     *
     * @param settleCheckInfo
     * @return
     */
    protected boolean isMerRealTimeAndInner(SettleCheckInfo settleCheckInfo) {
        return SettleType.REAL_TIME.getType().equals(settleCheckInfo.getMerSettleType())
                && ChargeMode.INNER.getMode().equals(settleCheckInfo.getMerChargeMode());
    }

    /**
     * 用户实时外扣
     *
     * @param settleCheckInfo
     * @return
     */
    protected boolean isMerRealTimeAndBuckle(SettleCheckInfo settleCheckInfo) {
        return SettleType.REAL_TIME.getType().equals(settleCheckInfo.getMerSettleType())
                && ChargeMode.BUCKLE.getMode().equals(settleCheckInfo.getMerChargeMode());
    }

    /**
     * 根据差错表e,f的情况，
     * 查询当前流水表数据并移至历史流水表
     */
    @Transactional(rollbackFor = Exception.class)
    public void moveToHistory(long id, ReconciliationErrorType errorType, String serverTransId) {
        try {
            //e,f 类型需要移至历史流水表
            if (errorType.equals(ReconciliationErrorType.E) || errorType.equals(ReconciliationErrorType.F)) {
                Map<String, Object> map = Maps.newHashMap();
                map.put("serverTransId", serverTransId);
                //迁移到历史流水表
                MybatisDaoImpl.of(TransHistoryMapper.class).insertBySql("moveFromCurrentDate", map);
                MybatisDaoImpl.of(TransCurrentMapper.class).deleteBySql("deleteFromCurrentDate", map);
                log.info("差错记录id{}-服务端流水号{}-差错类型{} >> 迁移至历史流水表成功", id, serverTransId, errorType);
            }
        }catch (Exception e) {
            log.info("服务端流水号{},差错处理异常:{}", serverTransId, e.getMessage(), e);
            throw new PersistenceException(HttpRespStatus.SERVER_ERROR, String.format("服务端流水号%s差错处理-移至历史流水表异常[%s]", serverTransId, e.getMessage()));
        }
    }
}
