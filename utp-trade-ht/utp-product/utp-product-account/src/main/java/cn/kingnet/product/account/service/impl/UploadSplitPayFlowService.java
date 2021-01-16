package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IOutsideTransOrderHandler;
import cn.kingnet.utp.service.persistence.api.ISplitInfoHandler;
import cn.kingnet.utp.service.persistence.api.IUploadSplitPayFlowHandler;
import cn.kingnet.utp.service.persistence.entity.TransHistory;
import cn.kingnet.utp.service.persistence.entity.vo.UploadSplitPayFlowVo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSplitPayFlowReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSplitPayFlowRespDTO;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.SettleMode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 上送分账-支付订单流水补登 服务
 * @Create : 2018-11-02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UPLOAD_SPLIT_PAY_FLOW,
        reqClass = UploadSplitPayFlowReqDTO.class,
        respClass = UploadSplitPayFlowRespDTO.class
)
@Deprecated
public class UploadSplitPayFlowService extends AbstractAccountTradeService<UploadSplitPayFlowReqDTO, UploadSplitPayFlowRespDTO> {


    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;
    @Resource
    private IUploadSplitPayFlowHandler uploadSplitPayFlowHandler;
    @Resource
    private ISplitInfoHandler splitInfoHandler;

    public final static String DIR_NAME = "split-pay";
    protected final static String FILE_BYTES = "FILE_BYTES";

    public UploadSplitPayFlowService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    private String buildUploadFileName(String industryCode, String batchNo) {
        return String.format("splitPay-%s-%s-%s.txt", industryCode, DateUtil.getCurrentDate(), batchNo);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadSplitPayFlowReqDTO, UploadSplitPayFlowRespDTO> tradeContext) {

        UploadSplitPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        UploadSplitPayFlowRespDTO.UploadSplitPayFlowRespDTOBuilder builder = UploadSplitPayFlowRespDTO.builder();
        builder.batchNo(reqDTO.getBatchNo()).success(Boolean.FALSE.toString());

        String fileName = buildUploadFileName(industryCode, reqDTO.getBatchNo());
        try {
            byte[] fileBytes = tradeContext.getAttribute(FILE_BYTES);
            BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
            String industryBorkerageAccount = basicConfigInfo.getIndustryBrokerageAccount();
            Long maxborkerageRate = basicConfigInfo.getMaxBrokerageRate();
            List<UploadSplitPayFlowVo> uploadSplitPayFlowVoList = buildUploadSplitPayFlowVoList(industryCode, reqDTO, fileBytes, industryBorkerageAccount, maxborkerageRate);
            if (CollectionUtils.isEmpty(uploadSplitPayFlowVoList)) {
                logger.error("分账-支付流水补登文件内容不能为空或不存在");
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "分账-支付流水补登文件内容不能为空或不存在");
            }
            //保存文件
            DataUtil.byte2File(fileBytes, utpConfigProperties.getUploadFileDir() + File.separator + DIR_NAME, fileName);
            uploadSplitPayFlowHandler.saveUploadSplitPayFlowList(uploadSplitPayFlowVoList);
            builder.success(Boolean.TRUE.toString());
        } catch (Exception e) {
            builder.success(Boolean.FALSE.toString());
            logger.error("代付客户号{}-批次号{}-->解析、保存分账-支付流水补登文件异常:", industryCode, reqDTO.getBatchNo(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("保存分账-支付流水补登文件异常[%s]", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadSplitPayFlowReqDTO, UploadSplitPayFlowRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        UploadSplitPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.hasText(reqDTO.getContent(), "文件域");
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        boolean isExist = outsideTransOrderHandler.isExistIndustryANdBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo());
        if (isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("代付客户(%s)-批次号(%s)支付流水已上送，不能重复上送..", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo()));
        }
        try {
            byte[] fileBytes = DataUtil.inflaterAndDecode64(reqDTO.getContent());
            tradeContext.setAttribute(FILE_BYTES, fileBytes);
        } catch (Exception e) {
            logger.error("分账-支付流水补登文件域解码解压缩异常:", e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "文件域解码解压缩异常:" + StringUtil.truncate(e.getMessage(), 200));
        }


    }

    @Override
    public void initTransFlow(TradeContext<UploadSplitPayFlowReqDTO, UploadSplitPayFlowRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadSplitPayFlowReqDTO, UploadSplitPayFlowRespDTO> tradeContext) {

    }

    private List<UploadSplitPayFlowVo> buildUploadSplitPayFlowVoList(String industryCode, UploadSplitPayFlowReqDTO reqDTO, byte[] fileBytes, String industryBrokerageAccount, Long maxBrokerageRate) {
        List<String> list = DataUtil.byte2List(fileBytes, "UTF-8");
        if (CollectionUtils.isEmpty(list)) {
            logger.error("代付客户号{}-批次号{}上送分账-支付流水补登文件不能为空.", industryCode, reqDTO.getBatchNo());
            return null;
        }
        String firstLine = list.get(0);
        Assert.hasText(firstLine, () -> "分账-支付流水补登文件首行不能为空");
        List<String> firstList = Splitter.on("|").trimResults().splitToList(firstLine);
        if (firstList.size() < 4) {
            logger.error("代付客户号{}-批次号{}上送分账-支付流水补登文件首行[{}]格式有误.", industryCode, reqDTO.getBatchNo(), firstLine);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "分账-支付流水补登文件首行格式有误");
        }
        String headMark = firstList.get(0);
        String txType = firstList.get(1);
        String settleDate = firstList.get(2);
        String rowCount = firstList.get(3);
        Assert.isTrue(UDPSettleSplitFeature.HEADMARK.equals(headMark), () -> "文件头标志位必须为H");
        Assert.isTrue(UDPSettleSplitFeature.TxType.SPLIT_PAY.getType().equals(txType), () -> "标志文件类型必须为" + UDPSettleSplitFeature.TxType.SPLIT_PAY.getType());
        Assert.isTrue(DateUtil.isYyyyMMdd(settleDate), () -> "清算日期格式必须为yyyyMMdd");
        ValidateUtils.isPositiveInteger(rowCount, 5, true, "总行数");

        long totalCount = Long.valueOf(rowCount);
        long dSumCount = CollectionUtils.isEmpty(list) ? 0L : list.size() - 1;
        Assert.isTrue(totalCount == dSumCount, () -> "分账-支付流水补登文件总笔数与明细行数不相符");
        Assert.isTrue(totalCount <= productAccountProperties.getMaxSplitSettleRows(), () -> "分账-支付流水补登文件总笔数超过最大限制"+productAccountProperties.getMaxSplitSettleRows()+"笔");

        List<String> clientTransIds = Lists.newArrayList();
        return Optional.ofNullable(list.stream().skip(1).map(l -> buildVo(industryCode, l, reqDTO, settleDate, clientTransIds, industryBrokerageAccount, maxBrokerageRate)).collect(Collectors.toList())).orElse(null);

    }


    /**
     * @param line 行定义数据 ,用|分割
     *             清算日期	 	M	格式为yyyyMMdd
     *             客户端流水号		M	客户端流水唯一
     *             用户账号	 	M	 开户时创建返回
     *             金额	 	M	单位:分   无小数点
     *             结算方式		M	0=代付结算 1=记账结算
     *             账期		M	账期为0，实时结算
     *             账期为n，则t+n结算
     *             备注信息	 	    O	 
     *             交易订单号列表	 	M	多个用逗号隔开
     *             扩展字段2	 	O	 
     *             扩展字段3	 	O	 
     * @return
     */
    private UploadSplitPayFlowVo buildVo(String industryCode, String line, UploadSplitPayFlowReqDTO reqDTO, String settleDate, List<String> clientTransIds, String industryBrokerageAccount, Long maxBrokerageRate) {
        Assert.hasText(line, () -> "数据行记录不能为空");
        List<String> lineList = Splitter.on("|").trimResults().splitToList(line);
        String[] data = lineList.toArray(new String[10]);

        String preName, uploadStatus, uploadDesc;
        Date curDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
        UploadSplitPayFlowVo.UploadSplitPayFlowVoBuilder builder = UploadSplitPayFlowVo.builder().id(IdGenerate.getId())
                .industryCode(industryCode).batchId(reqDTO.getBatchNo()).gmtCreate(curDate).gmtModified(curDate);
        try {
            if (lineList.size() < 10) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "分账-支付流水补登文件数据行格式有误[列数不足10列]");
            }
            preName = String.format("客户端流水号[%s]数据行:", data[1]);

            ValidateUtils.isYyyyMMdd(data[0], true, preName + "清算日期");
            Assert.isTrue(settleDate.equals(data[0]), () -> "分账-支付流水补登文件内清算日期与首行清算日期不一致");

            ValidateUtils.abcValid(data[1], true, preName + "客户端流水号");
            ValidateUtils.maxLength(data[1], 32, true, preName + "客户端流水号");
            Assert.isTrue(!clientTransIds.contains(data[1]), () -> String.format("客户端流水号[%s]已存在", data[1]));
            clientTransIds.add(data[1]);

            ValidateUtils.maxLength(data[2], 19, true, preName + "用户账户");
            ValidateUtils.isNum(data[2], true, preName + "用户账户");

            ValidateUtils.isPositiveInteger(data[3], 15, true, preName + "金额");

            ValidateUtils.isNum(data[4], true, preName + "结算方式");
            SettleMode settleMode = SettleMode.getSettleMode(data[4]);
            if (settleMode == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format(preName + "结算方式[%s]有误", data[4]));
            }
            if (SettleMode.CHARGE == settleMode) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format(preName + "补登信息不能为记账结算方式", data[4]));
            }

            ValidateUtils.isNum(data[5], true, preName + "账期");
            int period = Integer.valueOf(data[5]);
            if (period < 0 || period > 999999) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "账期必须不小于零或不大于999999");
            }

            //原客户端流水记录是否存在
            TransHistory transHistory = uploadSplitPayFlowHandler.getTransCurrentOrHistoryByClientTransId(industryCode, data[1]);
            if (transHistory == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "查无此原分账客户端流水号[" + data[1] + "]");
            }
            //回填原交易流水相关信息
            builder.transDate(transHistory.getTransDate()).serverTransId(transHistory.getServerTransId())
                    .transStatus(transHistory.getTransStatus()).queryTimes(0).transDesc(transHistory.getRespMessage())
                    .reconcileDate(transHistory.getReconcileDate());
            //校验支付订单[transOrderIds]是否存在及金额大于分账金额

            boolean isExistSplitInfoSuccess = splitInfoHandler.isExistsSplitInfo4Success(industryCode, data[1]);
            if (isExistSplitInfoSuccess) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "客户端流水号[" + data[1] + "]已存在成功分账记录，无法分账信息补登");
            }
            boolean isIndustryBrokerageAccount = data[2].equals(industryBrokerageAccount);
            outsideTransOrderHandler.validTransOrderIds(industryCode, data[7], Long.valueOf(data[3]), isIndustryBrokerageAccount, maxBrokerageRate);

            uploadStatus = "SUCCESS";
            uploadDesc = "上送成功";
        } catch (Exception e) {
            uploadStatus = "FAILURE";
            uploadDesc = "上送失败:" + StringUtil.truncate(e.getMessage(), 150);
            logger.error("上送分账-支付订单流水补登异常", e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "数据行信息有误.[" + uploadDesc + "]");
        }
        return builder.settleDate(StringUtil.truncate(data[0], 8))
                .clientTransId(StringUtil.truncate(data[1], 32))
                .userAccount(StringUtil.truncate(data[2], 19))
                .amount(parseAmount(data[3], 0L))
                .settleMode(StringUtil.truncate(data[4], 1))
                .period(parsePeriod(data[5], 0))
                .remark(StringUtil.truncate(data[6], 1024))
                .extend1(StringUtil.truncate(data[7], 1024)).extend2(StringUtil.truncate(data[8], 200))
                .extend3(StringUtil.truncate(data[9], 200))
                .splitDate(buildSplitDate(data[0], data[5]))
                .uploadStatus(uploadStatus)
                .uploadDesc(uploadDesc)
                .build();

    }


    private Long parseAmount(String amount, long defaultVal) {
        Long reVal = defaultVal;
        try {
            reVal = Long.valueOf(amount);
        } catch (NumberFormatException e) {
            logger.error("金额[{}]格式化异常:", amount, e);
        }
        return reVal;
    }

    private Integer parsePeriod(String period, int defaultVal) {
        Integer reVal = defaultVal;
        try {
            reVal = Integer.valueOf(period);
        } catch (NumberFormatException e) {
            logger.error("账期[{}]格式化异常:", period, e);
        }
        return reVal;
    }

    private String buildSplitDate(String settleDate, String period) {
        String splitDate = settleDate;
        try {
            splitDate = DateUtil.plusDate(settleDate, DateTimeFormatter.BASIC_ISO_DATE, Integer.parseInt(period));
        } catch (Exception e) {
            logger.error("清算日期[{}]+账期[{}]推算清算日期异常:", settleDate, period, e);
        }
        return splitDate;
    }
}
