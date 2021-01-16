package cn.kingnet.utp.scheduler.pdf;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.scheduler.data.entity.AccountElectronicReceipt;
import cn.kingnet.utp.scheduler.data.entity.AccountElectronicReceiptCondition;
import cn.kingnet.utp.scheduler.data.entity.MerchantInfo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSealAutoPdfReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankSynthesizeTemplateWithPdfIdReqDTO;
import cn.kingnet.utp.trade.common.enums.ElectronicTemplateKey;
import cn.kingnet.utp.trade.common.enums.FileType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.RedisKey;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description : 银行开户电子回单生成
 * @Author : linkaigui
 * @Create : 2020/7/8 15:50
 */
@Service
@Slf4j
public class OneBankAccountEleReceiptPdf {

    private final RedisAtomicLong redisAtomicLong;

    private final IPaymentService paymentService;

    @Value("${cn.kingnet.utp.pdf.file-dir}")
    private String fileDir;

    public OneBankAccountEleReceiptPdf(RedisConnectionFactory connectionFactory, IPaymentService paymentService) {
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
    public void buildPdf(MerchantInfo merchantInfo,AccountElectronicReceipt accountElectronicReceipt) throws Exception{
        //获取创建日期
        String createDate = DateUtil.getStringFromDate(merchantInfo.getGmtCreate(),DateUtil.FORMAT_TRADEDATE);
        //电子回单号
        String receiptNo;
        if(accountElectronicReceipt != null && StringUtil.isNotBlank(accountElectronicReceipt.getReceiptNo())){
            receiptNo = accountElectronicReceipt.getReceiptNo();
        }else {
            receiptNo = this.getNO(createDate);
        }
        //模版填充的数据
        Map<String,Object> fieldMap = new HashMap<>(4);
        fieldMap.put("receiptNo",receiptNo);
        fieldMap.put("memberName",merchantInfo.getMerName());
        fieldMap.put("memberID",merchantInfo.getAccount());
        fieldMap.put("activeDate",createDate);

        //合成业务数据到模板生成单据，返回保存在临时表中的pdfId
        OneBankSynthesizeTemplateWithPdfIdReqDTO oneBankSynthesizeTemplateWithPdfIdReqDTO = new OneBankSynthesizeTemplateWithPdfIdReqDTO();
        oneBankSynthesizeTemplateWithPdfIdReqDTO.setFieldMap(fieldMap);
        oneBankSynthesizeTemplateWithPdfIdReqDTO.setElectronicTemplateKey(ElectronicTemplateKey.KLHD);
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
        oneBankSealAutoPdfReqDTO.setElectronicTemplateKey(ElectronicTemplateKey.KLHD);
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

        if(Objects.isNull(sealedPdfData)){
            throw new TradeException(HttpRespStatus.INTERNAL_SERVER_ERROR,"自动化签章银行返回sealedPdfData为空!");
        }

        //电子回单文件保存到本地，返回保存路径
        String pdfPath = savePdfFile(sealedPdfData, merchantInfo.getIndustryCode(), merchantInfo.getMerNo(),receiptNo);
        String md5Hex = DigestUtils.md5Hex(sealedPdfData);

        if(accountElectronicReceipt != null){
            accountElectronicReceipt.setReceiptNo(receiptNo);
            accountElectronicReceipt.setMd5Hex(md5Hex);
            accountElectronicReceipt.setAccount(merchantInfo.getAccount());
            accountElectronicReceipt.setFilePath(pdfPath);
            accountElectronicReceipt.setGmtModified(new Date());
            if(accountElectronicReceipt.getFileContent() != null){
                accountElectronicReceipt.setFileContent(null);
                MybatisDaoImpl.run().updateForSet("file_content = null", AccountElectronicReceiptCondition.builder().andIdEq(accountElectronicReceipt.getId()).build());
            }
            MybatisDaoImpl.run().updateById(accountElectronicReceipt);
        }else {
            AccountElectronicReceipt electronicReceipt = AccountElectronicReceipt.builder()
                    .receiptNo(receiptNo)
                    .md5Hex(md5Hex)
                    .account(merchantInfo.getAccount())
                    .filePath(pdfPath)
                    .gmtCreate(new Date())
                    .gmtModified(new Date())
                    .build();
            MybatisDaoImpl.run().insert(electronicReceipt);
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
        basePath.append("/").append("klhd");
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
        //生成 KLHD+ 回单号 + 当天日期 的文件名
        basePath.append("/")
                .append(ElectronicTemplateKey.KLHD.getCode()).append(receiptNo).append("_").append(DateUtil.getCurrentDate())
                .append(".").append(FileType.PDF.getType());
        //生成 随机16位UUID + 当天日期 的文件名
//        String fileName = IdGenerate.getUUID16().concat("_").concat(DateUtil.getCurrentDate()).concat(".").concat(FileType.PDF.getType());
//        String targetPath = basePath.append("/").append(fileName).toString();
        return DataUtil.base64ContentToFile(bytes, basePath.toString());
    }
}
