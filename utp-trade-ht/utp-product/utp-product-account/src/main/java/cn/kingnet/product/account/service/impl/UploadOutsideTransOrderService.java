package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.product.account.service.inner.PictureService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.ICodeDictionaryHandler;
import cn.kingnet.utp.service.persistence.api.IOutsideTransOrderHandler;
import cn.kingnet.utp.service.persistence.entity.OutsideTransOrder;
import cn.kingnet.utp.service.persistence.entity.vo.OutsideTransOrderVo;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadOutsideTransOrderReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadOutsideTransOrderRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 上送外部支付订单流水 服务
 * @Create : 2018-11-02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UPLOAD_INDUSTRY_PAY_FLOW,
        reqClass = UploadOutsideTransOrderReqDTO.class,
        respClass = UploadOutsideTransOrderRespDTO.class

)
public class UploadOutsideTransOrderService extends AbstractAccountTradeService<UploadOutsideTransOrderReqDTO, UploadOutsideTransOrderRespDTO> {

    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;
    @Resource
    private ICodeDictionaryHandler codeDictionaryHandler;
    @Resource
    private CommonRedisService commonRedisService;
    public final static String DIR_NAME = "trans-order";
    protected final static String FILE_BYTES = "FILE_BYTES";
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private PictureService pictureService;

    public UploadOutsideTransOrderService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    private String buildUploadFileName(String industryCode, String batchNo) {
        return String.format("transOrder-%s-%s-%s.txt", industryCode, DateUtil.getCurrentDate(), batchNo);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadOutsideTransOrderReqDTO, UploadOutsideTransOrderRespDTO> tradeContext) {

        UploadOutsideTransOrderReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        UploadOutsideTransOrderRespDTO.UploadOutsideTransOrderRespDTOBuilder builder = UploadOutsideTransOrderRespDTO.builder();
        builder.batchNo(reqDTO.getBatchNo()).success(Boolean.FALSE.toString()).batchStatus(FileBatchStatus.FAILURE.getStatus());

        String fileName = buildUploadFileName(industryCode, reqDTO.getBatchNo());
        try {
//            if(!lock(industryCode,reqDTO.getBatchNo())){
//                throw new ProductException(HttpRespStatus.FORBIDDEN,"平台客户已有支付流水处理中，请稍后再试.");
//            }
            byte[] fileBytes = tradeContext.getAttribute(FILE_BYTES);

            //是否支持支付流水初始化标识
            boolean ableTransOrderInit = this.getBasicConfigInfo(tradeContext).getAbleTransOrderInit() == 1 ? true : false;
            List<OutsideTransOrderVo> outsideTransOrderVoList = buildUploadOutsideTransOrderVoList(industryCode, reqDTO, fileBytes, ableTransOrderInit);
            if (CollectionUtils.isEmpty(outsideTransOrderVoList)) {
                logger.error("支付流水文件内容不能为空或不存在");
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "支付流水文件内容不能为空或不存在");
            }

            //保存文件
            DataUtil.byte2File(fileBytes, utpConfigProperties.getUploadFileDir() + File.separator + DIR_NAME, fileName);
            outsideTransOrderHandler.saveOutsideTransOrderList(outsideTransOrderVoList);

            addSuccessOrderValueByRedis(industryCode, outsideTransOrderVoList);

            builder.success(Boolean.TRUE.toString()).batchStatus(FileBatchStatus.SUCCESS.getStatus());
//            unlock(industryCode,reqDTO.getBatchNo());
        } catch (Exception e) {
//            unlock(industryCode,reqDTO.getBatchNo());
            builder.success(Boolean.FALSE.toString()).batchStatus(FileBatchStatus.FAILURE.getStatus());
            logger.error("代付客户号{}-批次号{}-->解析、保存支付流水文件异常:", industryCode, reqDTO.getBatchNo(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("保存支付流水文件异常[%s]", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    @Async
    public void addSuccessOrderValueByRedis(String industryCode, List<OutsideTransOrderVo> outsideTransOrderVoList) {
        if (outsideTransOrderVoList != null) {
            outsideTransOrderVoList.parallelStream().filter(l -> "SUCCESS".equals(l.getUploadStatus()))
                    .map(vo -> OutsideTransOrder.of(vo))
                    .forEach(obj -> {
                        //transOrder 视为全局唯一
                        commonRedisService.addOutSideTransOrderByRedis(industryCode, obj.getTransOrderId(), obj);
                    });
        }
    }

    private String fmtCurKey(String industryCode, String batchNo) {
        return RedisKey.fmtKey(RedisKey.COMMON, "outSideTransOrder", industryCode, batchNo);
    }

    private boolean lock(String industryCode, String batchNo) {
        String curKey = fmtCurKey(industryCode, batchNo);
        if (redisTemplate.hasKey(curKey)) {
            return false;
        } else {
            redisTemplate.boundValueOps(curKey).set(true, 5, TimeUnit.SECONDS);
            return true;
        }
    }

    private void unlock(String industryCode, String batchNo) {
        redisTemplate.delete(fmtCurKey(industryCode, batchNo));
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadOutsideTransOrderReqDTO, UploadOutsideTransOrderRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        UploadOutsideTransOrderReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.hasText(reqDTO.getContent(), "文件域");
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        boolean isExist = outsideTransOrderHandler.isExistIndustryANdBatchId(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo());
        if (isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("代付客户(%s)-批次号(%s)支付流水已上送，不能重复上送..", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getBatchNo()));
        }
        try {
            byte[] fileBytes = DataUtil.inflaterAndDecode64(reqDTO.getContent());
            tradeContext.setAttribute(FILE_BYTES, fileBytes);
        } catch (Exception e) {
            logger.error("支付流水文件域解码解压缩异常:", e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "文件域解码解压缩异常:" + StringUtil.truncate(e.getMessage(), 200));
        }


    }

    @Override
    public void initTransFlow(TradeContext<UploadOutsideTransOrderReqDTO, UploadOutsideTransOrderRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadOutsideTransOrderReqDTO, UploadOutsideTransOrderRespDTO> tradeContext) {

    }

    private List<OutsideTransOrderVo> buildUploadOutsideTransOrderVoList(String industryCode, UploadOutsideTransOrderReqDTO reqDTO, byte[] fileBytes, boolean ableTransOrderInit) {
        List<String> list = DataUtil.byte2List(fileBytes, "UTF-8");
        if (CollectionUtils.isEmpty(list)) {
            logger.error("代付客户号{}-批次号{}上送支付流水文件不能为空.", industryCode, reqDTO.getBatchNo());
            return null;
        }
        String firstLine = list.get(0);
        Assert.hasText(firstLine, () -> "支付流水文件首行内容不能为空");
        List<String> firstList = Splitter.on("|").trimResults().splitToList(firstLine);
        if (firstList.size() < 4) {
            logger.error("代付客户号{}-批次号{}上送支付流水文件首行[{}]格式有误[列数不足4列].", industryCode, reqDTO.getBatchNo(), firstLine);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "支付流水文件首行格式有误");
        }
        String headMark = firstList.get(0);
        String txType = firstList.get(1);
        String tradeDate = firstList.get(2);
        String rowCount = firstList.get(3);

        Assert.isTrue(UDPSettleSplitFeature.HEADMARK.equals(headMark), () -> "文件头标志位必须为H");
        Assert.isTrue(UDPSettleSplitFeature.TxType.PAY_FLOW.getType().equals(txType), () -> "标志文件类型必须为" + UDPSettleSplitFeature.TxType.PAY_FLOW.getType());
        Assert.isTrue(DateUtil.isYyyyMMdd(tradeDate), () -> "交易日期格式必须为yyyyMMdd");
        ValidateUtils.isPositiveInteger(rowCount, 5, true, "总行数");

        long totalCount = Long.valueOf(rowCount);
        long dSumCount = CollectionUtils.isEmpty(list) ? 0L : list.size() - 1;
        Assert.isTrue(totalCount == dSumCount, () -> "支付流水文件总笔数与明细行数不相符");
        Assert.isTrue(totalCount > 0 && totalCount <= 1000, "支付流水文件总笔数范围必须在[1,1000]");
        List<String> orderIds = Lists.newArrayList();

//        return Optional.ofNullable(list.stream().skip(1).map(l -> buildVo(industryCode, l, reqDTO, tradeDate, orderIds, ableTransOrderInit)).collect(Collectors.toList())).orElse(null);

        List<OutsideTransOrderVo> listVO ;
        listVO = buildVo4Multi(list, industryCode, reqDTO, tradeDate, ableTransOrderInit);

        return listVO;
    }

    private List<OutsideTransOrderVo> buildVo4Multi(List<String> list, String industryCode, UploadOutsideTransOrderReqDTO reqDTO, String tradeDate, boolean ableTransOrderInit) {
        List<OutsideTransOrderVo> reList = null;
        AtomicBoolean isBlack = new AtomicBoolean(false);
        ExecutorService executorService = Executors.newFixedThreadPool(list.size() / 20+1);

        ConcurrentLinkedQueue orderQueues = new ConcurrentLinkedQueue();

        CompletableFuture<OutsideTransOrderVo>[] cfs =
                list.stream().skip(1).map(s -> CompletableFuture.supplyAsync(() -> {
                    if (isBlack.get()) {
                        return null;
                    }
                    try {
                        return buildVo(industryCode, s, reqDTO, tradeDate, orderQueues, ableTransOrderInit);
                    } catch (Exception e) {
                        isBlack.set(true);
                        throw e;
                    }
                }, executorService)).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(cfs).join();
        executorService.shutdown();

        reList = Arrays.stream(cfs).map(CompletableFuture::join).collect(Collectors.toList());

        return reList;
    }


    /**
     * @param line 行定义数据 ,用|分割
     *             交易日期	8	M	格式为yyyyMMdd 0
     *             交易时间	6	M	HHmmss 1
     *             支付订单号	32	M	唯一性校验 2
     *             交易商户号	15	M	交易商户号 3
     *             交易金额	15	M	单位:分   无小数点 4
     *             支付方式	20	M	0支付宝 1微信 2银联  3无正向支付流水  9其他支付方式 5
     *             卖方名称	100	M 6
     *             买方名称	100	O 7
     *             商品信息(描述)	512	M	支付方式为3时，该字段传对应的分账协议编号 8
     *             备注说明	1024	O	支付方式为3时，该字段传对应的分账协议内容 9
     *             ================ 2.1.2版本新增 ================
     *             商户手机号码	20	O	 10
     *             支付机构编码	10	M	详见支付机构编码表  11
     *             交易渠道支付订单号	50	M	指收单机构生成订单号  12
     *             付款方/买方Id	50	M 13
     *             付款方手机号码	20	O 14
     *             优惠金额	15	O	单位:分   无小数点 15
     *             物流信息	200	O 16
     * @return
     */
    private OutsideTransOrderVo buildVo(String industryCode, String line, UploadOutsideTransOrderReqDTO reqDTO, String tradeDate, Collection<String> orderIds, boolean ableTransOrderInit) {
        Assert.hasText(line, () -> "数据行记录不能为空");
        List<String> lineList = Splitter.on("|").trimResults().splitToList(line);
        Assert.isTrue(lineList.size() >= 17, () -> "支付流水文件数据行格式有误[列数不足17列]");
        String[] data = lineList.toArray(new String[17]);
        String preName, uploadStatus, uploadDesc;
        String remark = null;
        try {
            preName = String.format("支付订单号[%s]数据行:", data[2]);

            ValidateUtils.isYyyyMMdd(data[0], true, preName + "交易日期");
            Assert.isTrue(tradeDate.equals(data[0]), () -> "支付流水文件内交易日期与首行交易日期不一致");

            ValidateUtils.isHHmmss(data[1], true, preName + "交易时间");

            ValidateUtils.abcValid(data[2], true, preName + "支付订单号");
            ValidateUtils.maxLength(data[2], 32, true, preName + "支付订单号");
            Assert.isTrue(!orderIds.contains(data[2]), () -> String.format("支付流水号[%s]已存在", data[2]));
            orderIds.add(data[2]);

            //2.1.2 交易商户号 修改为必须条件
            ValidateUtils.maxLength(data[3], 32, true, preName + "交易商户号");
            ValidateUtils.isPositiveInteger(data[4], 15, true, preName + "金额");

            ValidateUtils.maxLength(data[5], 2, true, preName + "支付方式");
            PayMode payMode = PayMode.getPayMode(data[5]);
            Assert.notNull(payMode, () -> String.format(preName + "支付方式[%s]有误", data[5]));
            if (!ableTransOrderInit && payMode == PayMode.CUSTOMER_INIT) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "该平台客户不支持[客户初始化]支付方式");
            }

            ValidateUtils.maxLength(data[6], 100, true, preName + "交易商户/卖方名称");
            //2.1.2 付款方/买方名称 修改为必须条件
            ValidateUtils.maxLength(data[7], 100, true, preName + "付款方/买方名称");

            ValidateUtils.maxLength(data[8], 512, true, preName + "商品信息描述");
            // ====== 以下为新增 =======
            ValidateUtils.isNum(data[10], false, preName + "商户手机号码");
            ValidateUtils.maxLength(data[10], 20, false, preName + "商户手机号码");

            ValidateUtils.maxLength(data[11], 14, true, preName + "支付机构编码");
            ValidateUtils.maxLength(data[12], 50, true, preName + "交易渠道支付订单号");
            ValidateUtils.maxLength(data[13], 50, true, preName + "付款方/买方Id");
            ValidateUtils.maxLength(data[14], 20, false, preName + "付款方手机号码");
            ValidateUtils.isIntegerNegative(data[15], 15, false, preName + "优惠金额");
            ValidateUtils.maxLength(data[16], 200, false, preName + "物流信息");


            boolean isExistOrderId = outsideTransOrderHandler.isExistIndustryANdTransOrderId4Success(industryCode, data[2]);
            if (isExistOrderId) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format(preName + "支付订单号已存在", data[2]));
            }

            //校验支付机构编号是否在业务编码字典中:fixme 待优化缓存
            boolean isExistCodeDictionary = codeDictionaryHandler.isExistCodeDictionary("0001", StringUtil.truncate(data[11], 20));
            if (!isExistCodeDictionary) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "支付机构编号不存在");
            }
            uploadStatus = "SUCCESS";
            uploadDesc = "上送成功";

            if (PayMode.NOPAYFLOW.getType().equals(payMode.getType())) {
                //支付方式为3时，字段 remark 为分账协议内容
                remark = pictureService.base64ContentToFile(data[9], industryCode, data[2], FileType.PDF);
            } else {
                remark = data[9];
            }
        } catch (Exception e) {
            uploadStatus = "FAILURE";
            uploadDesc = "上送失败:" + StringUtil.truncate(e.getMessage(), 150);
            logger.error("支付流水文件数据行信息有误.[{}]", line, e);
            //调整整批次处理
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("数据行信息有误:[%s]", e.getMessage()));
        }
        Date curDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
        return OutsideTransOrderVo.builder().id(IdGenerate.getId())
                .industryCode(industryCode).batchId(StringUtil.truncate(reqDTO.getBatchNo(), 32))
                .reqDate(StringUtil.truncate(reqDTO.getReqDate(), 8)).reqTime(StringUtil.truncate(reqDTO.getReqTime(), 6))
                .transDate(StringUtil.truncate(data[0], 8)).transTime(StringUtil.truncate(data[1], 6))
                .transOrderId(StringUtil.truncate(data[2], 32)).merNo(StringUtil.truncate(data[3], 32))
                .transAmount(parseAmount(data[4], 0)).payMode(StringUtil.truncate(data[5], 2))
                .sellerName(StringUtil.truncate(data[6], 100)).buyerName(StringUtil.truncate(data[7], 100))
                .goodsInfo(StringUtil.truncate(data[8], 512))
                .remark(remark)
                .gmtCreate(curDate).gmtModified(curDate)
                .uploadStatus(uploadStatus).uploadDesc(uploadDesc)
                ///=======以下为新增========
                .merPhone(StringUtil.truncate(data[10], 20))
                .txnChannel(StringUtil.truncate(data[11], 20))
                .txnChannelTradeNo(StringUtil.truncate(data[12], 20))
                .buyerId(StringUtil.truncate(data[13], 50))
                .buyerPhone(StringUtil.truncate(data[14], 20))
                .discountAmount(parseAmount(data[15], 0))
                .logistics(StringUtil.truncate(data[16], 200))
                .merName(StringUtil.truncate(data[6], 100))
                .build();
    }

    private Long parseAmount(String amount, long defaultVal) {
        Long reVal = defaultVal;
        try {
            if (StringUtil.isNotEmpty(amount)) {
                reVal = Long.valueOf(amount);
            }
        } catch (NumberFormatException e) {
            logger.error("金额[{}]格式化异常:", amount, e);
        }
        return reVal;
    }
}
