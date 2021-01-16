package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IChannelIncomeFlowHandler;
import cn.kingnet.utp.service.persistence.api.IMerchantAccountHandler;
import cn.kingnet.utp.service.persistence.api.IUploadSubAccountIncomeFlowHandler;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountIncomeFlow;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSubAccountPayFlowReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSubAccountPayFlowRespDTO;
import cn.kingnet.utp.trade.common.enums.FileBatchStatus;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 子账户入金流水报备 服务
 * @Create : 2020.02.12
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UPLOAD_SUBACCOUNT_PAY_FLOW,
        reqClass = UploadSubAccountPayFlowReqDTO.class,
        respClass = UploadSubAccountPayFlowRespDTO.class

)
@Slf4j
public class UploadSubAccountPayFlowService extends AbstractAccountTradeService<UploadSubAccountPayFlowReqDTO, UploadSubAccountPayFlowRespDTO> {

    @Resource
    private IChannelIncomeFlowHandler channelIncomeFlowHandler;
    @Resource
    private IUploadSubAccountIncomeFlowHandler uploadSubAccountIncomeFlowHandler;
    @Resource
    private IMerchantAccountHandler merchantAccountHandler;
    @Resource
    private CommonRedisService commonRedisService;
    protected final static String FILE_BYTES = "FILE_BYTES";

    public UploadSubAccountPayFlowService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }


    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadSubAccountPayFlowReqDTO, UploadSubAccountPayFlowRespDTO> tradeContext) {
        UploadSubAccountPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        UploadSubAccountPayFlowRespDTO.UploadSubAccountPayFlowRespDTOBuilder builder = UploadSubAccountPayFlowRespDTO.builder();
        builder.batchNo(reqDTO.getBatchNo()).success(Boolean.FALSE.toString()).batchStatus(FileBatchStatus.FAILURE.getStatus());
        UploadSubAccountPayFlowRespDTO respDTO = null;
        byte[] fileBytes = tradeContext.getAttribute(FILE_BYTES);
        try {
            //校验入库
            saveUploadOutsideTransOrderList(industryCode, reqDTO, fileBytes);

            builder.batchStatus(FileBatchStatus.SUCCESS.getStatus());
            builder.success(Boolean.TRUE.toString());
            respDTO = builder.build();
        } catch (Exception e) {
            boolean saveSuccess = uploadSubAccountIncomeFlowHandler.isExistBatchNo(reqDTO.getBatchNo());
            builder.batchStatus(saveSuccess ? FileBatchStatus.SUCCESS.getStatus() : FileBatchStatus.FAILURE.getStatus());
            builder.success(saveSuccess ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
            respDTO = builder.build();
            if (!saveSuccess) {
                logger.error("代付客户号{}-批次号{}-->解析、保存子账户入金流水报备文件异常:", industryCode, reqDTO.getBatchNo(), e);
                return ChannelResponseUtil.exception(respDTO, HttpRespStatus.BAD_REQUEST, "入金流水报备失败", StringUtil.truncate(e.getMessage(), 200));
            }
        }
        return ChannelResponseUtil.success(respDTO, null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadSubAccountPayFlowReqDTO, UploadSubAccountPayFlowRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        UploadSubAccountPayFlowReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.hasText(reqDTO.getContent(), "入金流水文件域");
        if (uploadSubAccountIncomeFlowHandler.isExistBatchNo(reqDTO.getBatchNo())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "批次号已存在");
        }
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        try {
            byte[] fileBytes = DataUtil.inflaterAndDecode64(reqDTO.getContent());
            tradeContext.setAttribute(FILE_BYTES, fileBytes);
        } catch (Exception e) {
            logger.error("子账户入金文件域解码解压缩异常:", e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "子账户入金文件域解码解压缩异常:" + StringUtil.truncate(e.getMessage(), 200));
        }


    }

    @Override
    public void initTransFlow(TradeContext<UploadSubAccountPayFlowReqDTO, UploadSubAccountPayFlowRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadSubAccountPayFlowReqDTO, UploadSubAccountPayFlowRespDTO> tradeContext) {

    }

    private void saveUploadOutsideTransOrderList(String industryCode, UploadSubAccountPayFlowReqDTO reqDTO, byte[] fileBytes) {
        List<String> list = DataUtil.byte2List(fileBytes, "UTF-8");
        if (CollectionUtils.isEmpty(list)) {
            logger.error("客户号[{}}]下批次号[{}]子账户入金流水报备文件不能为空.", industryCode, reqDTO.getBatchNo());
            return;
        }
        String firstLine = list.get(0);
        Assert.hasText(firstLine, () -> "首行内容不能为空");
        List<String> firstList = Splitter.on("|").trimResults().splitToList(firstLine);
        if (firstList.size() < 4) {
            logger.error("客户号[{}}]下批次号[{}]子账户入金流水报备文件首行[{}]格式有误.", industryCode, reqDTO.getBatchNo(), firstLine);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "子账户入金流水报备文件首行格式有误");
        }

        String headMark = firstList.get(0);
        String txType = firstList.get(1);
        String tradeDate = firstList.get(2);
        String rowCount = firstList.get(3);
        Assert.isTrue(UDPSettleSplitFeature.HEADMARK.equals(headMark), () -> "文件头标志位必须为H");
        Assert.isTrue(UDPSettleSplitFeature.TxType.SUBACCOUNT_PAY_FLOW.getType().equals(txType), () -> "\"标志文件类型必须为\" + UDPSettleSplitFeature.TxType.SUBACCOUNT_PAY_FLOW.getType()");
        Assert.isTrue(DateUtil.isYyyyMMdd(tradeDate), () -> "交易日期格式必须为yyyyMMdd");

        ValidateUtils.isPositiveInteger(rowCount, 5, true, "总行数");

        long totalCount = Long.valueOf(rowCount);
        long dSumCount = CollectionUtils.isEmpty(list) ? 0L : list.size() - 1;
        Assert.isTrue(totalCount == dSumCount, () -> "子账户入金流水报备文件总笔数与明细行数不相符");
        Assert.isTrue(totalCount <= 1000, () -> "子账户入金流水报备文件总笔数超过最大限制1000笔");

        // 校验本文件内及缓存内支付流水不能重复关联多笔入金流水
        Multiset<String> curOrderMultiSet = validLinkedIncomeList(industryCode, list.subList(1, list.size()));

        //文件域逐行解析验证
//        List<String> incomeFlowIds = Lists.newArrayList();
//        List<UploadSubAccountIncomeFlow> uploadSubAccountIncomeFlowList = Optional.ofNullable(list.stream().skip(1).map(l -> buildVo(industryCode, l, reqDTO, tradeDate, incomeFlowIds)).collect(Collectors.toList())).orElse(null);
        List<UploadSubAccountIncomeFlow> uploadSubAccountIncomeFlowList = buildVo4Multi(list, industryCode, reqDTO, tradeDate);

        if (CollectionUtils.isEmpty(uploadSubAccountIncomeFlowList)) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "子账户入金流水报备文件内容不能为空或不存在");
        }

        // 校验支付流水是否存在
        curOrderMultiSet.elementSet().parallelStream().forEach(orderId -> {
            if (!commonRedisService.isExistOutSideTransOrderIdByRedis(industryCode, orderId)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("关联的支付流水[%s]不存在", orderId));
            }
        });

        uploadSubAccountIncomeFlowHandler.save(uploadSubAccountIncomeFlowList);

        //redis 缓存
        curOrderMultiSet.elementSet().parallelStream().forEach(orderId -> {
            commonRedisService.addTransOrderIdLinkedIncomeByRedis(industryCode, orderId);
        });

    }

    private List<UploadSubAccountIncomeFlow> buildVo4Multi(List<String> list, String industryCode, UploadSubAccountPayFlowReqDTO reqDTO, String tradeDate) {
        List<UploadSubAccountIncomeFlow> reList = null;
        ConcurrentLinkedQueue orderIdQueues = new ConcurrentLinkedQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(list.size() / 20 + 1);
        AtomicBoolean isBlack = new AtomicBoolean(false);

        CompletableFuture<UploadSubAccountIncomeFlow>[] cfs =
                list.stream().skip(1).map(line -> CompletableFuture.supplyAsync(() -> {
                    if (isBlack.get()) {
                        return null;
                    }
                    try {
                        return this.buildVo(industryCode, line, reqDTO, tradeDate, orderIdQueues);
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
     *             序号	6	M	文件数据行号
     *             子账户账号	19	M	接口开户获取
     *             入金流水号	32	M	唯一性校验[bankDetail.bizReferenceNo = channelIncome.rid]
     *             交易金额	15	M	单位:分   无小数点
     *             关联的支付流水列表	1024	M	支持多条，用逗号隔开
     *             备注说明	200	O
     * @return
     */
    private UploadSubAccountIncomeFlow buildVo(String industryCode, String line, UploadSubAccountPayFlowReqDTO reqDTO, String tradeDate, Collection<String> incomeFlowIds) {

        if (StringUtil.isBlank(line)) {
            return null;
        }
        List<String> lineList = Splitter.on("|").trimResults().splitToList(line);
        String[] data = lineList.toArray(new String[6]);

        String preName;
        try {
            if (lineList.size() < 6) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "子账户入金流水报备文件数据行列数有误[列数小于6列]");
            }
            preName = String.format("数据行[%s]:", data[0]);
            ValidateUtils.isNum(data[0], true, preName);

            ValidateUtils.abcValid(data[1], true, preName + "子账户账号");
            ValidateUtils.maxLength(data[1], 19, true, preName + "子账户账号");
            MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(data[1],true);
            if (merchantInfoBo == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, preName + String.format(" 查无此子账户[%s]关联商户信息", data[1]));
            }
            if (!industryCode.equals(merchantInfoBo.getIndustryCode())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, preName + String.format(" 子账户[%s]非法,不属于该客户号下子账户", data[1]));
            }
            ValidateUtils.abcValid(data[2], true, preName + "入金流水号");
            ValidateUtils.maxLength(data[2], 50, true, preName + "入金流水号");
            if (incomeFlowIds.contains(data[2])) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("本批次下入金流水号[%s]已存在", data[2]));
            } else {
                //是否存在subAccount的入金流水报备记录
                boolean isExist = uploadSubAccountIncomeFlowHandler.isExistIncomeFlowId(data[1], data[2]);
                if (isExist) {
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("入金流水号[%s]已存在", data[2]));
                }
                //是否存在subAccount的渠道订单入金流水通知记录
                if (!channelIncomeFlowHandler.isExistChannelIncomeFlowByRid(data[1], data[2])) {
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("渠道入金记录查无此子账户[%s]入金流水[%s]", data[1], data[2]));
                }
            }
            incomeFlowIds.add(data[2]);

            ValidateUtils.maxLength(data[3], 15, true, preName + "金额");
            ValidateUtils.isNum(data[3], true, preName + "金额");
            if (Long.valueOf(data[3]) <= 0) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "金额必须大于零");
            }
            ValidateUtils.maxLength(data[4], 2048, true, preName + "关联的支付流水列表");
        } catch (Exception e) {
            logger.error("子账户入金流水报备文件数据行信息有误.[{}]", line, e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("子账户入金流水报备文件数据行信息有误.[%s]", e.getMessage()));
        }
        Date curDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
        return UploadSubAccountIncomeFlow.builder().id(IdGenerate.getId())
                .industryCode(industryCode)
                .batchNo(reqDTO.getBatchNo())
                .seqNo(Integer.valueOf(data[0])).subAccount(data[1]).incomeFlowId(data[2])
                .incomeAmount(parseAmount(data[3], 0)).payFlowIds(data[4]).remark(data[5])
                .gmtCreate(curDate).gmtModified(curDate)
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


    private Multiset<String> validLinkedIncomeList(String industryCode, List<String> incomeFlowList) {
        if (!CollectionUtils.isEmpty(incomeFlowList)) {
            ConcurrentHashMultiset<String> multiset = ConcurrentHashMultiset.create();
            incomeFlowList.stream().forEach(o -> {
                Set<String> curSet = this.parseTransOrderIdsSet(o);
                if (!CollectionUtils.isEmpty(curSet)) {
                    multiset.addAll(curSet);
                }
            });

            multiset.elementSet().parallelStream().forEach(orderId -> {
                if (commonRedisService.isExistTransOrderIdLinkedIncomeByRedis(industryCode, orderId)) {
                    log.error("该支付流水[{}]已存在关联入金流水记录", orderId);
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("该支付流水[%s}]已存在关联入金流水记录", orderId));
                }
                long curLinkedSplitNum = multiset.count(orderId);
                if (curLinkedSplitNum > 1) {
                    log.error("支付流水不能重复关联多笔入金流水,支付流水[{}]当前关联入金记录数[{}],", orderId, curLinkedSplitNum);
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("支付流水不能重复关联多笔入金流水,支付流水[%s]当前关联入金记录数[%s]", orderId, curLinkedSplitNum));
                }
            });
            return multiset;
        }
        return null;
    }

    /**
     * 支付流水关联集合
     *
     * @param row
     * @return
     */
    private Set<String> parseTransOrderIdsSet(String row) {
        if (StringUtil.isNotBlank(row)) {
            List<String> rowList = Splitter.on("|").trimResults().splitToList(row);
            if (CollectionUtils.isEmpty(rowList) || rowList.size() < 6) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "入金流水记录行格式错误");
            }
            List<String> outTransOrderList = Splitter.on(",").trimResults().splitToList(rowList.get(4));
            if (CollectionUtils.isEmpty(outTransOrderList)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "入金流水记录行的支付流水列表格式错误");
            }
            Set<String> outTransOrderIdMap = outTransOrderList.parallelStream().filter(StringUtil::isNoneBlank).collect(Collectors.toSet());
            return outTransOrderIdMap;
        }
        return null;
    }

}
