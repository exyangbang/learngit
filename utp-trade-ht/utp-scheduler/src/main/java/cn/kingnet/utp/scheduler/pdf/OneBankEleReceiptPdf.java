package cn.kingnet.utp.scheduler.pdf;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.scheduler.data.entity.*;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSealAutoPdfReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSynthesizeTemplateWithPdfIdReqDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description : 银行客户电子回单生成
 * @Author : linkaigui
 * @Create : 2020/7/8 15:50
 */
@Service
@Slf4j
public class OneBankEleReceiptPdf {

    private final RedisAtomicLong redisAtomicLong;

    private final IPaymentService paymentService;

    @Value("${cn.kingnet.utp.pdf.file-dir}")
    private String fileDir;

    public OneBankEleReceiptPdf(RedisConnectionFactory connectionFactory, IPaymentService paymentService) {
        this.paymentService = paymentService;
        RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Long.class));
        redisTemplate.setExposeConnection(true);
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.afterPropertiesSet();
        this.redisAtomicLong = new RedisAtomicLong(RedisKey.ELE_RECEIPT_NO_SEGMENT_KEY.name(), redisTemplate);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void buildTransHistory(TransHistory transHistory, ElectronicReceipts electronicReceipt) throws Exception {
        TradeType tradeType = TradeType.resolve(transHistory.getTradeType());
        //电子回单号
        String receiptNo;
        if(electronicReceipt != null && StringUtil.isNotBlank(electronicReceipt.getOrderNo())){
            receiptNo = electronicReceipt.getOrderNo();
        }else {
            receiptNo = this.getNO(transHistory.getTransDate());
        }
        //模版填充的数据
        Map<String,Object> fieldMap = new HashMap<>(16);
        //记账时间
        LocalDate accountingDate = LocalDate.parse(StringUtil.isNotEmpty(transHistory.getReconcileDate()) ? transHistory.getReconcileDate() : transHistory.getTransDate(), DateTimeFormatter.BASIC_ISO_DATE);
        fieldMap.put("accountingDate",accountingDate);
        //流水号
        fieldMap.put("serialNo",transHistory.getClientTransId());
        //回单号
        fieldMap.put("receiptNo",receiptNo);
        //收款人户名
        fieldMap.put("namePayee",StringUtils.isNotBlank(transHistory.getShowPayeeAccountName()) ? transHistory.getShowPayeeAccountName() : "");
        //收款人账号
        fieldMap.put("accountPayee",StringUtils.isNotBlank(transHistory.getShowPayeeAccountNo()) ? transHistory.getShowPayeeAccountNo() : "");
        //收款人开户银行
        fieldMap.put("depositBankPayee",transHistory.getPayeeOpbkName() == null ? "" : transHistory.getPayeeOpbkName());
        //付款人户名
        fieldMap.put("namePayer",StringUtils.isNotBlank(transHistory.getShowPayerAccountName()) ? transHistory.getShowPayerAccountName() : "");
        //付款人账号
        fieldMap.put("accountPayer",StringUtils.isNotBlank(transHistory.getShowPayerAccountNo()) ? transHistory.getShowPayerAccountNo() : "");
        //付款人开户银行
        fieldMap.put("depositBankPayer",transHistory.getPayerOpbkName() == null ? "" : transHistory.getPayerOpbkName());
        //交易金额
        String amount = BigDecimal.valueOf(transHistory.getTransAmount()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        fieldMap.put("tradingAmount",String.format("人民币（大写）%s ￥%s元", RMBConvert.convert(amount), amount));
        //交易类型
        fieldMap.put("tradingType",this.getShowTradeType(tradeType));
        //交易附言
        fieldMap.put("tradingPostscript",transHistory.getSummaryDescription() == null ? "" : transHistory.getSummaryDescription());
        //备注
        fieldMap.put("remark","");
        //打印时间
        LocalDate date = LocalDate.parse(transHistory.getTransDate(), DateTimeFormatter.BASIC_ISO_DATE);
        LocalTime time = LocalTime.parse(transHistory.getTransTime(), DateTimeFormatter.ofPattern("HHmmss"));
        String dateTime = date.format(DateTimeFormatter.ISO_LOCAL_DATE).concat(" ").concat(time.format(DateTimeFormatter.ofPattern("HH.mm.ss")));
        fieldMap.put("date",dateTime);

        ElectronicTemplateKey etk = ElectronicTemplateKey.KHDZHD;
        if("1".equals(transHistory.getMerSettleType())&&"1".equals(transHistory.getMerChargeMode())){
            //实时内扣
            etk = ElectronicTemplateKey.KHDZHD002;
            //手续费金额
            String merFee = BigDecimal.valueOf(transHistory.getMerFee()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            fieldMap.put("handlingFee",String.format("人民币（大写）%s ￥%s元", RMBConvert.convert(merFee), merFee));
        }

        //请求银行获取签章后的PDF
        byte[] sealedPdfData = this.sendSealedPdfData(fieldMap, etk);
        if(Objects.isNull(sealedPdfData)){
            throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,"自动化签章银行返回sealedPdfData为空!");
        }

        //电子回单文件保存到本地，返回保存路径
        String pdfPath = savePdfFile(sealedPdfData, transHistory.getIndustryCode(), transHistory.getMerNo(),receiptNo);
        String md5Hex = DigestUtils.md5Hex(sealedPdfData);

        if(electronicReceipt != null){
            electronicReceipt.setServerTransId(transHistory.getServerTransId());
            electronicReceipt.setOrderNo(receiptNo);
            electronicReceipt.setTradeType(transHistory.getTradeType());
            electronicReceipt.setMd5Hex(md5Hex);
            electronicReceipt.setIndustryCode(transHistory.getIndustryCode());
            electronicReceipt.setClientTransId(transHistory.getClientTransId());
            electronicReceipt.setFilePath(pdfPath);
            electronicReceipt.setGmtModified(new Date());
            if(electronicReceipt.getFileContent() != null){
                electronicReceipt.setFileContent(null);
                MybatisDaoImpl.run().updateForSet("file_content = null", ElectronicReceiptsCondition.builder().andIdEq(electronicReceipt.getId()).build());
            }
            MybatisDaoImpl.run().updateById(electronicReceipt);
        }else {
            ElectronicReceipts electronicReceiptTemp = ElectronicReceipts.builder()
                    .serverTransId(transHistory.getServerTransId())
                    .orderNo(receiptNo)
                    .tradeType(transHistory.getTradeType())
                    .md5Hex(md5Hex)
                    .industryCode(transHistory.getIndustryCode())
                    .clientTransId(transHistory.getClientTransId())
                    .filePath(pdfPath)
                    .gmtCreate(new Date())
                    .gmtModified(new Date())
                    .build();
            MybatisDaoImpl.run().insert(electronicReceiptTemp);
        }
        if ("9090".equals(transHistory.getUserType())) {
            MybatisDaoImpl.run().updateById(ChannelIncomeFlow.builder().id(transHistory.getId()).elcMakeFlag(ElcMakeFlag.MAKE.getFlag()).build());
        } else {
            MybatisDaoImpl.run().updateById(TransHistory.builder().id(transHistory.getId()).elcMakeFlag(ElcMakeFlag.MAKE.getFlag()).build());
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public void buildTransCurrent(TransCurrent transCurrent, ElectronicReceipts electronicReceipt) throws Exception {
        TradeType tradeType = TradeType.resolve(transCurrent.getTradeType());
        //电子回单号
        String receiptNo;
        if(electronicReceipt != null && StringUtil.isNotBlank(electronicReceipt.getOrderNo())){
            receiptNo = electronicReceipt.getOrderNo();
        }else {
            receiptNo = this.getNO(transCurrent.getTransDate());
        }
        //模版填充的数据
        Map<String,Object> fieldMap = new HashMap<>(16);
        //记账时间
        LocalDate accountingDate = LocalDate.parse(StringUtil.isNotEmpty(transCurrent.getReconcileDate()) ? transCurrent.getReconcileDate() : transCurrent.getTransDate(), DateTimeFormatter.BASIC_ISO_DATE);
        fieldMap.put("accountingDate",accountingDate);
        //流水号
        fieldMap.put("serialNo",transCurrent.getClientTransId());
        //回单号
        fieldMap.put("receiptNo",receiptNo);
        //收款人户名
        fieldMap.put("namePayee",StringUtils.isNotBlank(transCurrent.getShowPayeeAccountName()) ? transCurrent.getShowPayeeAccountName() : "");
        //收款人账号
        fieldMap.put("accountPayee",StringUtils.isNotBlank(transCurrent.getShowPayeeAccountNo()) ? transCurrent.getShowPayeeAccountNo() : "");
        //收款人开户银行
        fieldMap.put("depositBankPayee",transCurrent.getPayeeOpbkName() == null ? "" : transCurrent.getPayeeOpbkName());
        //付款人户名
        fieldMap.put("namePayer",StringUtils.isNotBlank(transCurrent.getShowPayerAccountName()) ? transCurrent.getShowPayerAccountName() : "");
        //付款人账号
        fieldMap.put("accountPayer",StringUtils.isNotBlank(transCurrent.getShowPayerAccountNo()) ? transCurrent.getShowPayerAccountNo() : "");
        //付款人开户银行
        fieldMap.put("depositBankPayer",transCurrent.getPayerOpbkName() == null ? "" : transCurrent.getPayerOpbkName());
        //交易金额
        String amount = BigDecimal.valueOf(transCurrent.getTransAmount()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        fieldMap.put("tradingAmount",String.format("人民币（大写）%s ￥%s元", RMBConvert.convert(amount), amount));
        //交易类型
        fieldMap.put("tradingType",this.getShowTradeType(tradeType));
        //交易附言
        fieldMap.put("tradingPostscript",transCurrent.getSummaryDescription() == null ? "" : transCurrent.getSummaryDescription());
        //备注
        fieldMap.put("remark","");
        //打印时间
        LocalDate date = LocalDate.parse(transCurrent.getTransDate(), DateTimeFormatter.BASIC_ISO_DATE);
        LocalTime time = LocalTime.parse(transCurrent.getTransTime(), DateTimeFormatter.ofPattern("HHmmss"));
        String dateTime = date.format(DateTimeFormatter.ISO_LOCAL_DATE).concat(" ").concat(time.format(DateTimeFormatter.ofPattern("HH.mm.ss")));
        fieldMap.put("date",dateTime);

        ElectronicTemplateKey etk = ElectronicTemplateKey.KHDZHD;
        if("1".equals(transCurrent.getMerSettleType())&&"1".equals(transCurrent.getMerChargeMode())){
            //实时内扣
            etk = ElectronicTemplateKey.KHDZHD002;
            //手续费金额
            String merFee = BigDecimal.valueOf(transCurrent.getMerFee()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            fieldMap.put("handlingFee",String.format("人民币（大写）%s ￥%s元", RMBConvert.convert(merFee), merFee));
        }

        //请求银行获取签章后的PDF
        byte[] sealedPdfData = this.sendSealedPdfData(fieldMap, etk);
        if(Objects.isNull(sealedPdfData)){
            throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,"自动化签章银行返回sealedPdfData为空!");
        }

        //电子回单文件保存到本地，返回保存路径
        String pdfPath = savePdfFile(sealedPdfData, transCurrent.getIndustryCode(), transCurrent.getMerNo(),receiptNo);
        String md5Hex = DigestUtils.md5Hex(sealedPdfData);

        if(electronicReceipt != null){
            electronicReceipt.setServerTransId(transCurrent.getServerTransId());
            electronicReceipt.setOrderNo(receiptNo);
            electronicReceipt.setTradeType(transCurrent.getTradeType());
            electronicReceipt.setMd5Hex(md5Hex);
            electronicReceipt.setIndustryCode(transCurrent.getIndustryCode());
            electronicReceipt.setClientTransId(transCurrent.getClientTransId());
            electronicReceipt.setFilePath(pdfPath);
            electronicReceipt.setGmtModified(new Date());
            if(electronicReceipt.getFileContent() != null){
                electronicReceipt.setFileContent(null);
                MybatisDaoImpl.run().updateForSet("file_content = null", ElectronicReceiptsCondition.builder().andIdEq(electronicReceipt.getId()).build());
            }
            MybatisDaoImpl.run().updateById(electronicReceipt);
        }else {
            ElectronicReceipts electronicReceiptTemp = ElectronicReceipts.builder()
                    .serverTransId(transCurrent.getServerTransId())
                    .orderNo(receiptNo)
                    .tradeType(transCurrent.getTradeType())
                    .md5Hex(md5Hex)
                    .industryCode(transCurrent.getIndustryCode())
                    .clientTransId(transCurrent.getClientTransId())
                    .filePath(pdfPath)
                    .gmtCreate(new Date())
                    .gmtModified(new Date())
                    .build();
            MybatisDaoImpl.run().insert(electronicReceiptTemp);
        }
        if ("9090".equals(transCurrent.getUserType())) {
            MybatisDaoImpl.run().updateById(ChannelIncomeFlow.builder().id(transCurrent.getId()).elcMakeFlag(ElcMakeFlag.MAKE.getFlag()).build());
        } else {
            MybatisDaoImpl.run().updateById(TransCurrent.builder().id(transCurrent.getId()).elcMakeFlag(ElcMakeFlag.MAKE.getFlag()).build());
        }
    }

    private byte[] sendSealedPdfData(Map<String,Object> fieldMap, ElectronicTemplateKey etk){
        //合成业务数据到模板生成单据，返回保存在临时表中的pdfId
        OneBankSynthesizeTemplateWithPdfIdReqDTO oneBankSynthesizeTemplateWithPdfIdReqDTO = new OneBankSynthesizeTemplateWithPdfIdReqDTO();
        oneBankSynthesizeTemplateWithPdfIdReqDTO.setFieldMap(fieldMap);
        oneBankSynthesizeTemplateWithPdfIdReqDTO.setElectronicTemplateKey(etk);
        String reqId = IdGenerate.generateServerTransId("","");
        oneBankSynthesizeTemplateWithPdfIdReqDTO.setClientTradeId(reqId);
        oneBankSynthesizeTemplateWithPdfIdReqDTO.setSavedPdfId(reqId);
        ChannelResponseDTO channelResponseDTO = paymentService.synthesizeTemplateWithPdfId(oneBankSynthesizeTemplateWithPdfIdReqDTO);
        String pdfId = null;
        if(channelResponseDTO != null && HttpRespStatus.OK.valueStr().equals(channelResponseDTO.getStatus())){
            if(Objects.isNull(channelResponseDTO.getSpRespMsg())){
                throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,"合成模版银行返回数据为空!");
            }
            pdfId = (String) channelResponseDTO.getSpRespMsg().getOrDefault("savedPdfId","");
        }

        if(StringUtil.isBlank(pdfId)){
            throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,"合成模版银行返回savedPdfId为空!");
        }

        //PDF自动化签章接口返回PDF文件
        OneBankSealAutoPdfReqDTO oneBankSealAutoPdfReqDTO = new OneBankSealAutoPdfReqDTO();
        oneBankSealAutoPdfReqDTO.setElectronicTemplateKey(etk);
        oneBankSealAutoPdfReqDTO.setPdf(pdfId);
        String reqAutoId = IdGenerate.generateServerTransId("","");
        oneBankSealAutoPdfReqDTO.setClientTradeId(reqAutoId);
        oneBankSealAutoPdfReqDTO.setSavedPdfId(reqAutoId);
        ChannelResponseDTO channelResponseDTO1 = paymentService.sealAutoPdf(oneBankSealAutoPdfReqDTO);

        byte[] sealedPdfData = null;
        if(channelResponseDTO1 != null && HttpRespStatus.OK.valueStr().equals(channelResponseDTO1.getStatus())){
            if(Objects.isNull(channelResponseDTO1.getSpRespMsg())){
                throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,"自动化签章银行返回数据为空!");
            }
            String sealedPdfDataTemp = (String) channelResponseDTO1.getSpRespMsg().getOrDefault("sealedPdfData","");
            if(StringUtil.isBlank(sealedPdfDataTemp)){
                throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,"自动化签章银行返回sealedPdfData为空!");
            }
            sealedPdfData = DataUtil.inflaterAndDecode64(sealedPdfDataTemp);
        }
        return sealedPdfData;
    }

    private String getShowTradeType(TradeType tradeType){
        switch (tradeType) {
            case WITHDRAW:
                return "提现";
            case SGL_PAYMENT:
                return "代付";
            case REFUND_ORDERID:
                return "订单退款";
            case SPLIT_PAYMENT:
                return "平台分账";
            case SUBACCOUNT_SPLIT_PAYMENT:
                return "子账户分账";
            case SPLIT_PAYMENT_REFUND:
                return "平台分账退款";
            case SUBACCOUNT_SPLIT_PAYMENT_REFUND:
                return "子账户分账退款";
            case BALANCE_PAYMENT:
                return "余额支付";
            case BALANCE_PAYMENT_REFUND:
                return "余额支付退款";
            case CHANNEL_INCOME_RECEIPT:
                return "入款";
            case ACC_PAYMENT:
                return "付款";
            default:
                return "";
        }
    }

    String getNO(String pref) {
        long sec = this.redisAtomicLong.incrementAndGet();
        String seqNoStr = String.format("%08d", sec);
        return pref.concat(seqNoStr);
    }

    /**
     * 保存PDF文件到本地
     * @param bytes        pdf内容
     * @param industryCode 代付客户号
     * @param merNo        商户号
     * @return
     */
    private String savePdfFile(byte[] bytes, String industryCode, String merNo,String receiptNo) {
        if (fileDir.contains("\\")) {
            fileDir = fileDir.replaceAll("\\\\", "/").replaceAll("//", "/");
        }
        //文件保存目录：基本路径 + 客户号/ or 客户号/商户号/
        StringBuffer basePath = new StringBuffer(fileDir);
        basePath.append("/").append("khdzhd");
        if(StringUtil.isNotBlank(industryCode)){
            basePath.append("/").append(industryCode);
        }
        if (StringUtil.isNotBlank(merNo)) {
            basePath.append("/").append(merNo);
        }
        //判断文件夹是否存在，不存在则创建
        File file = new File(basePath.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        //生成 KHDZHD+ 回单号 + 当天日期 的文件名
        basePath.append("/")
                .append(ElectronicTemplateKey.KHDZHD.getCode()).append(receiptNo).append("_").append(DateUtil.getCurrentDate())
                .append(".").append(FileType.PDF.getType());
        return DataUtil.base64ContentToFile(bytes, basePath.toString());
    }
}
