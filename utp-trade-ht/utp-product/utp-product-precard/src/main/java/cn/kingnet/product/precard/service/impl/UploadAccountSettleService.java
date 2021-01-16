package cn.kingnet.product.precard.service.impl;

import cn.kingnet.product.precard.configuration.ProductPreCardProperties;
import cn.kingnet.product.precard.service.AbstractPreCardTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.AccountSettleDetail;
import cn.kingnet.utp.service.persistence.entity.FileUploadLog;
import cn.kingnet.utp.service.persistence.entity.bo.AccountSettleBatchBO;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.precard.UploadAccountSettleReqDTO;
import cn.kingnet.utp.trade.common.dto.precard.UploadAccountSettleRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.DataUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.collect.Lists;
import org.springframework.cglib.beans.BeanMap;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description : 预付费卡清算文件上送
 * @Author : linkaigui@scenetec.com
 * @Create : 2018/12/19 9:23
 */
@TradeService(
        productCode = ProductCode.PRECARD,
        tradeType = TradeType.UPLOAD_ACCOUNT_SETTLE,
        reqClass = UploadAccountSettleReqDTO.class,
        respClass = UploadAccountSettleRespDTO.class
)
public class UploadAccountSettleService extends AbstractPreCardTradeService<UploadAccountSettleReqDTO, UploadAccountSettleRespDTO> {

    @Resource
    protected ITransCurrentHandler transCurrentHandler;

    @Resource
    protected ITransHistoryHandler transHistoryHandler;

    @Resource
    private IFileUploadLogHandler fileUploadLogHandler;

    @Resource
    private IAccountSettleHandler accountSettleHandler;

    private static final String FILE_PATH_NAME = "FILE_PATH_NAME";

    public UploadAccountSettleService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductPreCardProperties productPreCardProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productPreCardProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadAccountSettleReqDTO, UploadAccountSettleRespDTO> tradeContext) {
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        String filePath = tradeContext.getAttribute(FILE_PATH_NAME);
        if (StringUtil.isBlank(filePath)) throw new TradeException(HttpRespStatus.BAD_REQUEST, "文件内容不能为空或不存在");
        UploadAccountSettleReqDTO uploadAccountSettleReqDTO = tradeContext.getRequestDTO();

        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        long betweenDays = DateUtil.betweenDays(currentDate,uploadAccountSettleReqDTO.getSettleDate(), DateTimeFormatter.BASIC_ISO_DATE);

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            List<String> list = lines.filter(StringUtil::isNotBlank).collect(Collectors.toList());
            String firstLine = list.get(0);
            String[] fAy;
            if (StringUtil.isEmpty(firstLine) || (fAy = firstLine.split("\\|")).length < 4) {
                logger.error("{}入账文件首行格式有误.", filePath);
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "入账文件首行格式有误!");
            }
            //头行格式
            //        headMark	String	1	文件头标志位	固定值：H	Y　
            //        txType	String	50	业务类型	标志文件类型,settle	Y　
            //        applyDate	String	8	日期	格式：yyyyMMdd	Y　
            //        rowCount	String	10	总行数	数据行行数	Y
            String headMark = fAy[0].trim();
            String txType = fAy[1].trim();
            String applyDate = fAy[2].trim();
            String rowCount = fAy[3].trim();
            if (!UDPSettleSplitFeature.HEADMARK.equals(headMark)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "文件头标志位错误!");
            }
            if (!UDPSettleSplitFeature.TxType.SETTLE.getType().equals(txType)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "标志文件类型错误!");
            }
            ValidateUtils.isYyyyMMdd(applyDate, true, "文件头日期");
            ValidateUtils.isNum(rowCount, true, "总行数");
            if (!uploadAccountSettleReqDTO.getSettleDate().equals(applyDate)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "文件内清算日期与报文上送清算日期不一致!");
            }
            long count = list.size() - 1;
            long totalCount = Long.valueOf(rowCount);
            if (totalCount != count) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "清算文件总笔数与明细行数不相符!");
            }
            if (count < 1) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "清算文件无明细内容!");
            }
            Stream<String> deFirstLines = list.stream().skip(1);
            List<String> cardNoList = Lists.newArrayList();
            List<AccountSettleDetail> accountSettleDetailList = deFirstLines.map(lineStr -> {
                String[] data = lineStr.split("\\|",-1);
                if (data == null || data.length < 2 || data.length > 6) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, "清算文件数据行格式有误!");
                }
                data = Stream.of(data).map(ds -> (ds != null ? ds.trim() : "")).toArray(String[]::new);
                ValidateUtils.abcValid(data[0], true, String.format("文件内容,卡号%s", data[0]));
                ValidateUtils.maxLength(data[0], 32,true, String.format("文件内容,卡号%s", data[0]));
                if (cardNoList.contains(data[0])) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("文件内容,卡号%s 出现重复!", data[0]));
                } else {
                    cardNoList.add(data[0]);
                }
                ValidateUtils.isIntegerNegative(data[1], true, String.format("文件内容,%s的金额", data[0]));
                if (data[1].length() > 15) throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("文件内容,%s的金额超出范围!", data[0]));
                long payAmtLong;
                try {
                    payAmtLong = Long.parseLong(data[1]);
                } catch (Exception e) {
                    throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("文件内容,%s的金额格式不对!", data[0]));
                }
                if (payAmtLong <= 0) throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("文件内容,%s的金额须大于零的整数!", data[0]));

//                ValidateUtils.notSpecialStr(data[2], false, String.format("文件内容,%s的备注信息", data[0]));
                ValidateUtils.notSpecialStr(data[3], false, String.format("文件内容,%s的扩展字段1", data[0]));
                ValidateUtils.notSpecialStr(data[4], false, String.format("文件内容,%s的扩展字段2", data[0]));
                ValidateUtils.notSpecialStr(data[5], false, String.format("文件内容,%s的扩展字段3", data[0]));
                return AccountSettleDetail.builder()
                        .id(IdGenerate.getId())
                        .settleDate(uploadAccountSettleReqDTO.getSettleDate())
                        .batchId(uploadAccountSettleReqDTO.getBatchNo())
                        .industryCode(tradeContext.getAuthInfo().getAuthNo())
                        .payerAccount(basicConfigInfo.getIndustryAccount())
                        .merNo(data[0])
                        .amount(payAmtLong)
                        .period(Integer.valueOf(String.valueOf(betweenDays)))
                        .accountNo(data[0])
                        .payeeAcctNo(uploadAccountSettleReqDTO.getPayeeAcctNo())
                        .payeeName(uploadAccountSettleReqDTO.getPayeeName())
                        .payeeOpbk(uploadAccountSettleReqDTO.getPayeeOpbk())
                        .showPayerAcctNo(uploadAccountSettleReqDTO.getShowPayerAcctNo())
                        .showPayerName(uploadAccountSettleReqDTO.getShowPayerName())
                        .remark(data[2])
                        .extend1(data[3])
                        .extend2(data[4])
                        .extend3(data[5])
                        .handleStatus(TrueOrFalseStatus.FALSE.value())
                        .provisionFlag(TrueOrFalseStatus.FALSE.value())
                        .transStatus(TransStatus.PRE_CREATE.name())
                        .transDesc("清算信息上送成功，等待处理任务")
                        .gmtCreate(new Date())
                        .gmtModified(new Date())
                        .build();
            }).collect(Collectors.toList());

            Long totalAmount = accountSettleDetailList.stream().mapToLong(AccountSettleDetail::getAmount).sum();

            FileUploadLog fileUploadLog = FileUploadLog.builder()
                    .id(IdGenerate.getId())
                    .productCode(ProductCode.PRECARD.name())
                    .tradeType(TradeType.UPLOAD_ACCOUNT_SETTLE.name())
                    .industryCode(tradeContext.getAuthInfo().getAuthNo())
                    .payerAccount(basicConfigInfo.getIndustryAccount())
                    .bizDate(uploadAccountSettleReqDTO.getSettleDate())
                    .period(Integer.valueOf(String.valueOf(betweenDays)))
                    .batchId(uploadAccountSettleReqDTO.getBatchNo())
                    .totalCount(totalCount)
                    .totalAmount(totalAmount)
                    .realCount(0L)
                    .realAmount(0L)
                    .transStatus(TransStatus.PRE_CREATE.name())
                    .transDesc("清算信息上送成功，等待处理任务")
                    .callbackUrl(uploadAccountSettleReqDTO.getCallbackUrl())
                    .transDate(uploadAccountSettleReqDTO.getReqDate())
                    .transTime(uploadAccountSettleReqDTO.getReqTime())
                    .callbackTimes(0)
                    .serverTransId(tradeContext.getServerTransId())
                    .clientTransId(uploadAccountSettleReqDTO.getClientTradeId())
                    .gmtCreate(new Date())
                    .gmtModified(new Date())
                    .build();

            accountSettleHandler.saveAccountSettleBatchAndJobTask(AccountSettleBatchBO.builder().fileUploadLog(fileUploadLog).accountSettleDetailList(accountSettleDetailList).build());
            //返回信息
            UploadAccountSettleRespDTO respDTO = new UploadAccountSettleRespDTO();
            respDTO.setBatchNo(uploadAccountSettleReqDTO.getBatchNo());
            respDTO.setSettleDate(uploadAccountSettleReqDTO.getSettleDate());
            respDTO.setSuccess(Boolean.TRUE.toString());
            respDTO.setClientTradeId(uploadAccountSettleReqDTO.getClientTradeId());
            respDTO.setServerTradeId(tradeContext.getServerTransId());
            respDTO.setStatus(HttpRespStatus.OK.valueStr());
            respDTO.setMessage(HttpRespStatus.OK.getReasonPhrase());
            return ChannelResponseDTO.builder()
                    .status(HttpRespStatus.OK.valueStr())
                    .message(HttpRespStatus.OK.getReasonPhrase())
                    .serverTransId(tradeContext.getServerTransId())
                    .spRespMsg(BeanMap.create(respDTO))
                    .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .build();
        } catch (IOException ioe) {
            logger.error("文件域内容读取异常:", ioe.getMessage(), ioe);
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "文件域内容读取异常" + ioe.getMessage());
        }
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadAccountSettleReqDTO, UploadAccountSettleRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        UploadAccountSettleReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_TRADEDATE);
        if (!currentDate.equals(reqDTO.getReqDate()))
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "请求日期必须为当前日期!");
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        if (!currentDate.equals(reqDTO.getSettleDate())){
            long betweenDays = DateUtil.betweenDays(currentDate,reqDTO.getSettleDate(), DateTimeFormatter.BASIC_ISO_DATE);
            if(betweenDays < 0){
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "清算日期须大于等于当前日期!");
            }
        }
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");

        ValidateUtils.abcValid(reqDTO.getPayeeAcctNo(), true, "清算收款账号");
        ValidateUtils.maxLength(reqDTO.getPayeeAcctNo(), 32, true, "清算收款账号");

        ValidateUtils.notSpecialStr(reqDTO.getPayeeName(), true, "清算收款户名");
        ValidateUtils.maxLength(reqDTO.getPayeeName(), 64, true, "清算收款户名");

        ValidateUtils.abcValid(reqDTO.getPayeeOpbk(), true, "清算行行号");
        ValidateUtils.maxLength(reqDTO.getPayeeOpbk(), 20, true, "清算行行号");

        ValidateUtils.isHttpUrl(reqDTO.getCallbackUrl(), true, "回调地址");

        ValidateUtils.abcValid(reqDTO.getShowPayerAcctNo(), false, "显示付款账号");
        ValidateUtils.maxLength(reqDTO.getShowPayerAcctNo(), 32, false, "显示付款账号");

        ValidateUtils.notSpecialStr(reqDTO.getShowPayerName(), false, "显示付款户名");
        ValidateUtils.maxLength(reqDTO.getShowPayerName(), 60, false, "显示付款户名");

        ValidateUtils.hasText(reqDTO.getContent(), "文件域");

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        //交易客户端流水不能重复：当天交易流水检验
        boolean flag = transCurrentHandler.isExistByIndustryCodeAndClientTransIdOrBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getClientTradeId(), null);
        //是否已存在商户+客户端流水
        if (flag) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }
        //历史交易流水 校验
        boolean flag1 = transHistoryHandler.isExistByIndustryCodeAndClientTransIdOrBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getClientTradeId(), null);
        if (flag1) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水已存在!");
        }

        int isExistFlag = fileUploadLogHandler.countFileUploadLogByClientTransId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getClientTradeId(), null);
        if (isExistFlag > 0) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "客户端流水重复!");
        }

        int isExistFlag1 = fileUploadLogHandler.countFileUploadLogByBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo(), null);
        if (isExistFlag1 > 0) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("批次号%s 重复!", reqDTO.getBatchNo()));
        }

        byte[] fileBytes;
        try {
            fileBytes = DataUtil.inflaterAndDecode64(reqDTO.getContent());
        } catch (Exception e) {
            logger.error("文件域解码解压缩异常:", e);
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "文件域解码解压缩异常" + e.getMessage());
        }

        try {
            String fileName = String.format("%s%s%s.txt", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo());
            StringBuilder filePath = new StringBuilder(utpConfigProperties.getUploadFileDir())
                    .append(utpConfigProperties.getUploadFileDir().endsWith(File.separator) ? "" : File.separator)
                    .append("settleFiles").append(File.separator)
                    .append(reqDTO.getReqDate());
            DataUtil.byte2File(fileBytes, filePath.toString(), fileName);
            tradeContext.setAttribute(FILE_PATH_NAME, filePath.toString() + File.separator + fileName);
        } catch (Exception e) {
            logger.error("保存文件异常:", e);
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "文件域内容异常" + e.getMessage());
        }
    }

    @Override
    public void initTransFlow(TradeContext<UploadAccountSettleReqDTO, UploadAccountSettleRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadAccountSettleReqDTO, UploadAccountSettleRespDTO> tradeContext) {

    }
}