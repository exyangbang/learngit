//package cn.kingnet.utp.scheduler.service;
//
//import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
//import cn.kingnet.utp.scheduler.data.entity.FileUploadLog;
//import cn.kingnet.utp.scheduler.data.entity.FileUploadLogCondition;
//import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
//import cn.kingnet.utp.trade.common.enums.ProductCode;
//import cn.kingnet.utp.trade.common.enums.TradeType;
//import cn.kingnet.utp.trade.common.enums.TransStatus;
//import cn.kingnet.utp.trade.common.exception.SchedulerException;
//import cn.kingnet.utp.trade.common.utils.LambdaLogger;
//import cn.kingnet.utp.trade.common.utils.StringUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @Description : 预付费卡入账文件T+N处理
// * @Author : linkaigui@scenetec.com
// * @Create : 2018/12/25 13:47
// */
//@Service
//@Slf4j
//public class UpLoadLogProcessService {
//
//    @Autowired
//    private BusinessTransactionService businessTransactionService;
//
//    public void processTaskTN(String bizDate) {
//        try {
//            LambdaLogger.debug(log, "T+n预付费卡入账文件记录，业务日期:{} 开始处理..", bizDate);
//            List<FileUploadLog> fileUploadLogList = MybatisDaoImpl.run().selectList(FileUploadLogCondition.builder().andProductCodeEq(ProductCode.PRECARD.name()).andTransStatusEq(TransStatus.PRE_CREATE.name()).andBizDateEq(bizDate).andPeriodGt(0).build());
//            final int[] count = {0};
//            if(!CollectionUtils.isEmpty(fileUploadLogList)){
//                fileUploadLogList.stream()
//                        .filter(item -> ProductCode.PRECARD.name().equals(item.getProductCode()))
//                        .filter(item -> StringUtil.isNotBlank(item.getIndustryCode()) && StringUtil.isNotBlank(item.getBizDate()) && StringUtil.isNotBlank(item.getBatchId()))
//                        .forEach(item ->{
//                            if(TradeType.UPLOAD_ACCOUNT_ENTRY.getCode().equals(item.getTradeType())){//入账
//                                businessTransactionService.saveAccountEntryJobTask(item);
//                                count[0] += 1;
//                            }else if(TradeType.UPLOAD_ACCOUNT_SETTLE.getCode().equals(item.getTradeType())) {//清算
//                                businessTransactionService.saveAccountSettleJobTask(item);
//                                count[0] += 1;
//                            }
//                        });
//            }
//            LambdaLogger.debug(log, "T+n预付费卡入账文件记录，业务日期:{},上送数{}, T+N任务数{} 处理完成...", bizDate, fileUploadLogList == null ? 0 : fileUploadLogList.size(), count[0]);
//        } catch (Exception e) {
//            throw new SchedulerException(HttpRespStatus.SERVER_ERROR,
//                    String.format("T+n预付费卡入账文件记录，业务日期:%s，处理异常", bizDate), e);
//        }
//    }
//}
