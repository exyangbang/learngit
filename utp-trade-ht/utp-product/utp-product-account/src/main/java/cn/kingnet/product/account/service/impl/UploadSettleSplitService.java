package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.service.persistence.entity.bo.HTSettleSplitInfoBo;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSettleSplitReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSettleSplitRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.model.UDPSettleSplitFeature;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 代付客户平台清分文件上送
 * @Create : 2018-11-02
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UPLOAD_SETTLE_SPLIT,
        reqClass = UploadSettleSplitReqDTO.class,
        respClass = UploadSettleSplitRespDTO.class
)
@Slf4j
public class UploadSettleSplitService extends AbstractAccountTradeService<UploadSettleSplitReqDTO, UploadSettleSplitRespDTO> {

    protected final static String FILEBYTES_KEY = "FILEBYTES_KEY";

    @Resource
    private ISplitInfoUploadLogHandler iSplitInfoUploadLogHandler;
    @Resource
    private IAccountHandler accountHandler;
    @Resource
    private IChannelRelevantHandler channelRelevantHandler;
    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;
    @Resource
    private ISplitInfoHandler splitInfoHandler;
    @Resource
    private IIndustryAmtLimitHandler iIndustryAmtLimitHandler;
    @Resource
    private IMerchantAccountHandler merchantAccountHandler;
    @Resource
    private IBlackListHandler blackListHandler;

    public UploadSettleSplitService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    private String buildUploadFileName(String providerCode, String settleDate, String batchNo) {
        return String.format("%s%s%s.txt", providerCode, settleDate, batchNo);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadSettleSplitReqDTO, UploadSettleSplitRespDTO> tradeContext) {

        UploadSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        UploadSettleSplitRespDTO.UploadSettleSplitRespDTOBuilder builder = UploadSettleSplitRespDTO.builder();
        builder.settleDate(reqDTO.getSettleDate()).batchNo(reqDTO.getBatchNo()).success(Boolean.FALSE.toString());

        String fileName = buildUploadFileName(industryCode, reqDTO.getSettleDate(), reqDTO.getBatchNo());
        HTSettleSplitInfoBo htSettleSplitInfoBo;
        try {
            byte[] fileBytes = tradeContext.getAttribute(FILEBYTES_KEY);
            BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
            String industryBrokerageAccount = basicConfigInfo.getIndustryBrokerageAccount();
            Long maxBrokerageRate = basicConfigInfo.getMaxBrokerageRate();
            htSettleSplitInfoBo = buildSettleSplitInfoBo(industryCode, reqDTO.getSettleDate(), reqDTO.getBatchNo(), fileBytes, industryBrokerageAccount, maxBrokerageRate);
            if (htSettleSplitInfoBo == null || CollectionUtils.isEmpty(htSettleSplitInfoBo.getSplitInfoList())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "清算分账文件内容不能为空或不存在");
            }

            Account industryAccount = accountHandler.queryAccountByUserAccount(getBasicConfigInfo(tradeContext).getIndustryAccount());
            if (industryAccount == null || !CommonConstants.STATUS_NORMAL.equals(industryAccount.getStatus())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查无此代付客户号[%s]关联账户信息或者账户状态不可用", htSettleSplitInfoBo.getIndustryCode()));
            }
            long curBalance = industryAccount.getAvailAmount() == null ? 0L : industryAccount.getAvailAmount();
            if (curBalance < htSettleSplitInfoBo.getSplitInfoList().stream().mapToLong(o -> o.getAmount()).sum()) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "代付账户余额不足,请充值后再试.");
            }

            //保存文件
            DataUtil.byte2File(fileBytes, utpConfigProperties.getUploadSettleSplitDir(), fileName);

        } catch (Exception e) {
            logger.error("代付客户号{}-清算日期{}-批次号{}-->解析、保存清算分账文件异常:", industryCode, reqDTO.getSettleDate(), reqDTO.getBatchNo(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("平台清分文件校验失败[%s]", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        SplitInfoUploadLog splitInfoUploadLog = null;
        try {
            //初始批次状态为空
            splitInfoUploadLog = buildSplitInfoUploadLog(reqDTO, htSettleSplitInfoBo);
            iSplitInfoUploadLogHandler.saveSplitInfoUploadLog(splitInfoUploadLog);

            splitInfoHandler.saveSplitInfoBatch(htSettleSplitInfoBo);

            //批次状态为订单初始化
            splitInfoUploadLog.setRemark("清算分账信息落库成功，并成功初始化信息处理任务");
            splitInfoUploadLog.setTransStatus(TransStatus.PRE_CREATE.name());
            iSplitInfoUploadLogHandler.updateSplitInfoUploadLogStatus(splitInfoUploadLog);

            builder.success(Boolean.TRUE.toString());
        } catch (Exception e) {
            logger.error("代付客户号{}-清算日期{}-批次号{}-->清算分账文件内容持久化操作异常:", industryCode, reqDTO.getSettleDate(), reqDTO.getBatchNo(), e);
            splitInfoUploadLog.setRemark("清算分账信息落库异常："+StringUtil.truncate(e.getMessage(),200));
            splitInfoUploadLog.setTransStatus(TransStatus.TRADE_FAILURE.name());
            iSplitInfoUploadLogHandler.rollbackSplitInfoUploadLog(splitInfoUploadLog);
            builder.success(Boolean.FALSE.toString());
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("清算分账文件内容持久化操作异常[%s] ", StringUtil.truncate(e.getMessage(), 200)), e);
        }


        return ChannelResponseUtil.success(builder.build(), null, null);
    }


    private SplitInfoUploadLog buildSplitInfoUploadLog(UploadSettleSplitReqDTO reqDTO, HTSettleSplitInfoBo htSettleSplitInfoBo) {
        return SplitInfoUploadLog.builder().id(IdGenerate.getId())
                .providerCode(htSettleSplitInfoBo.getIndustryCode())
                .settleDate(reqDTO.getSettleDate()).batchId(reqDTO.getBatchNo())
                .callbackUrl(reqDTO.getCallbackUrl()).callbackTimes(0).count(htSettleSplitInfoBo.getTotalCount())
                .transDate(reqDTO.getReqDate()).transTime(reqDTO.getReqTime()).transStatus(null)
                .gmtCreate(new Date()).gmtModified(new Date()).build();
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadSettleSplitReqDTO, UploadSettleSplitRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        UploadSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.hasText(reqDTO.getContent(), "文件域");
        ValidateUtils.isHttpUrl(reqDTO.getCallbackUrl(), true, "回调地址");
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        ChannelInfoBO channelInfoBO = channelRelevantHandler.findChannelInfoBO(tradeContext.getAuthInfo().getAuthNo(), basicConfigInfo.getProductNo(), null);
        if (channelInfoBO == null) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "代付客户号关联渠道未配置");
        }

        boolean isExist = iSplitInfoUploadLogHandler.isExistSplitInfoUploadLog(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo(), null);
        if (isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("平台%s-清算日期%s-批次%s 已存在.", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo()));
        }

        try {
            byte[] fileBytes = DataUtil.inflaterAndDecode64(reqDTO.getContent());
            tradeContext.setAttribute(FILEBYTES_KEY, fileBytes);
        } catch (Exception e) {
            logger.error("文件域解码解压缩异常:", e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "文件域解码解压缩异常:" + StringUtil.truncate(e.getMessage(), 200));
        }


    }

    @Override
    public void initTransFlow(TradeContext<UploadSettleSplitReqDTO, UploadSettleSplitRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadSettleSplitReqDTO, UploadSettleSplitRespDTO> tradeContext) {

    }


    /**
     * 清算分账文件转业务对象
     *
     * @param industryCode 代付客户号
     * @param settleDate   业务清算日期
     * @param batchId      批次号
     * @param fileBytes    文件域内容
     * @return
     */
    public HTSettleSplitInfoBo buildSettleSplitInfoBo(String industryCode, String settleDate, String batchId,
                                                      byte[] fileBytes,
                                                      String industryBrokerageAccount,
                                                      Long maxBrokerageRate) {
        List<String> list = DataUtil.byte2List(fileBytes, "UTF-8");
        if (CollectionUtils.isEmpty(list)) {
            log.error("代付客户号{}-清算日期{}-批次号{}上送清分文件为空.", industryCode, settleDate, batchId);
            return null;
        }
        String firstLine = list.get(0);
        Assert.hasText(firstLine, () -> "清分文件首行不能为空");
        List<String> firstList = Splitter.on("|").trimResults().splitToList(firstLine);
        if (firstList.size() < 4) {
            log.error("代付客户号{}-清算日期{}-批次号{}上送清分文件首行[{}]格式有误.", industryCode, settleDate, batchId, firstLine);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "清分文件首行格式有误");
        }
        String headMark = firstList.get(0);
        String txType = firstList.get(1);
        String applyDate = firstList.get(2);
        String rowCount = firstList.get(3);
        Assert.isTrue(UDPSettleSplitFeature.HEADMARK.equals(headMark), () -> "文件头标志位必须为H");
        Assert.isTrue(UDPSettleSplitFeature.TxType.SETTLE.getType().equals(txType), () -> "标志文件类型必须为settle");
        Assert.isTrue(DateUtil.isYyyyMMdd(applyDate), () -> "日期格式必须为yyyyMMdd");
        Assert.isTrue(settleDate.equals(applyDate), () -> "清分文件首行清算日期与报文上送清算日期不一致");

        ValidateUtils.isPositiveInteger(rowCount, 5, true, "总行数");

        long totalCount = Long.valueOf(rowCount);
        //校验总笔数是否一致
        long dSumCount = CollectionUtils.isEmpty(list) ? 0L : list.size() - 1;
        Assert.isTrue(totalCount == dSumCount, () -> "清分文件总笔数与明细行数不相符");
        Assert.isTrue(totalCount <= productAccountProperties.getMaxSplitSettleRows(), () -> "清分文件总笔数超过最大限制"+productAccountProperties.getMaxSplitSettleRows()+"笔");
        Assert.isTrue(totalCount > 0, () -> "清分文件清分记录不能为空");

        HTSettleSplitInfoBo.HTSettleSplitInfoBoBuilder builder = HTSettleSplitInfoBo.builder();
        builder.industryCode(industryCode).settleDate(applyDate).batchId(batchId).totalCount(totalCount);

        List<String> dataList = list.subList(1, list.size());
        Set<Integer> periodSet = new HashSet<>();
        //参数格式校验
        List<SplitInfo> splitInfoList = buildSplitInfoList(industryCode, settleDate, batchId, dataList, periodSet);

        //同批次内不能混有T0 Tn数据
        builder.period(periodSet.contains(0) ? 0 : 1);
        builder.splitInfoList(splitInfoList);

        HTSettleSplitInfoBo htSettleSplitInfoBo = builder.build();
        //业务参数校验
        validSplitInfoList(htSettleSplitInfoBo, industryBrokerageAccount, maxBrokerageRate);
        return htSettleSplitInfoBo;
    }

    private List<SplitInfo> buildSplitInfoList(String industryCode, String settleDate, String batchId, List<String> dataList, Set<Integer> periodSet) {
        List<String> clientTransIds = new ArrayList<>(dataList.size());
        List<SplitInfo> splitInfoList = new ArrayList<>(dataList.size());
        dataList.stream().filter(StringUtil::isNotBlank).forEach(line -> {
            splitInfoList.add(buildSplitInfo(industryCode, settleDate, batchId, line, clientTransIds, periodSet));
        });
        return splitInfoList;
    }

    /**
     * 业务参数校验
     */
    private void validSplitInfoList(HTSettleSplitInfoBo splitInfoBo, String industryBrokerageAccount, long maxBrokerageRate) {
        List<BlackList> allBlackList = blackListHandler.selectAllBlackList();
        String industryCode = splitInfoBo.getIndustryCode();
        List<SplitInfo> splitInfoList = splitInfoBo.getSplitInfoList();

        if (splitInfoBo != null && !CollectionUtils.isEmpty(splitInfoList)) {

//            splitInfoBo.getSplitInfoList().forEach(splitInfo -> {
//                validSplitInfo(industryCode, splitInfo, industryBrokerageAccount, maxBrokerageRate, allBlackList);
//            });

            ExecutorService executorService = Executors.newFixedThreadPool(splitInfoList.size() / 20 + 1);
            AtomicBoolean isBlack = new AtomicBoolean(false);

            CompletableFuture<SplitInfo>[] cfs =
            splitInfoList.stream().map(cur -> CompletableFuture.supplyAsync(() -> {
                SplitInfo splitInfo = null;
                if (!isBlack.get()) {
                    try {
                        splitInfo = validSplitInfo(industryCode, cur, industryBrokerageAccount, maxBrokerageRate, allBlackList);
                    } catch (Exception e) {
                        isBlack.set(true);
                        throw e;
                    }
                }
                return splitInfo;
            }, executorService)).toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(cfs).join();
            executorService.shutdown();

            Arrays.stream(cfs).map(CompletableFuture::join).collect(Collectors.toList());

            validLinkedSplitList(industryCode, splitInfoList);
        }
    }

    //支付流水关联记录数校验
    private void validLinkedSplitList(String industryCode, List<SplitInfo> list) {
        if (!CollectionUtils.isEmpty(list)) {
            Multiset<String> multiset = HashMultiset.create();
            list.stream().forEach(o -> {
                Set<String> curSet = this.validLinkedSplitNum(o);
                if (!CollectionUtils.isEmpty(curSet)) {
                    multiset.addAll(curSet);
                }
            });

            if (!CollectionUtils.isEmpty(multiset)) {
                Integer maxLinkSplitIdNumDb = iIndustryAmtLimitHandler.findSameOrderMaxSplitNum(industryCode);
                int maxLinkSplitIdNum = maxLinkSplitIdNumDb == null || maxLinkSplitIdNumDb <= 0 ? 5 : maxLinkSplitIdNumDb.intValue();
                multiset.elementSet().stream().forEach(orderId -> {
                    long curLinkedSplitNum = multiset.count(orderId);
                    if (curLinkedSplitNum > maxLinkSplitIdNum) {
                        log.error("支付流水[{}}]当前关联分账记录数[{}],已超出最大可关联分账记录数[{}}]", orderId, curLinkedSplitNum, maxLinkSplitIdNum);
                        throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("支付流水[%s]已超出最大可关联分账记录数[%s]", orderId, maxLinkSplitIdNum));
                    }
                    int dbLinkedSplitIdNum = outsideTransOrderHandler.queryLinkedSplitNumByTransOrderId(industryCode,orderId);
                    if ((curLinkedSplitNum + dbLinkedSplitIdNum) > maxLinkSplitIdNum) {
                        log.error("支付流水[{}}]当前关联分账记录数[{}],已超出最大可关联分账记录数[{}}]", orderId, curLinkedSplitNum, curLinkedSplitNum);
                        throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("支付流水[%s]已超出最大可关联分账记录数[%s]", orderId, maxLinkSplitIdNum));
                    }
                });
            }
        }
    }

    private Set<String> validLinkedSplitNum(SplitInfo splitInfo) {
        String outsideTransOrderIds = splitInfo.getExtend1();
        if (splitInfo != null && StringUtil.isNotBlank(outsideTransOrderIds)) {
            List<String> outTransOrderList = Splitter.on(",").trimResults().splitToList(outsideTransOrderIds);
            if (CollectionUtils.isEmpty(outTransOrderList)) {
                log.error("分账记录的支付流水列表格式错误. {}", splitInfo.getExtend1());
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "分账记录的支付流水列表格式错误");
            }
            Set<String> outTransOrderIdMap = outTransOrderList.stream().filter(StringUtil::isNoneBlank).collect(Collectors.toSet());
            return outTransOrderIdMap;
        }
        return null;
    }


    /**
     * @param line 行定义数据 ,用|分割
     *             1	清算日期		M	格式为yyyyMMdd
     *             2	客户端流水号		M 必须 0 个人 1 商户
     *             3	用户账号		M 必须
     *             4	金额		M	单位:分   无小数点
     *             5	结算方式		M	0-代付结算 1-记账结算
     *             6	账期		M	数字， 例如： 1 表示账期为 T+1
     *             7	备注信息		O
     *             8	扩展字段1 ==》 支付订单列表 逗号隔开
     *             9	扩展字段2		O
     *             10	扩展字段3		O
     * @return
     */
    private SplitInfo buildSplitInfo(String industryCode, String settleDate, String batchId, String line, List<String> clientTransIds, Set<Integer> periodSet) {
        if (StringUtil.isBlank(line)) {
            return null;
        }
        List<String> lineList = Splitter.on("|").trimResults().splitToList(line);
        String[] data = lineList.toArray(new String[10]);
        String transStatus = TransStatus.PRE_CREATE.name(), transDesc = "清分数据已受理";

        try {
            Assert.isTrue(lineList.size() >= 10, () -> "分账文件数据行格式有误[列数不足10列]");

            String preName = String.format("记录[%s]行中", data[1]);
            ValidateUtils.isYyyyMMdd(data[0], true, preName + "清算日期");
            Assert.isTrue(settleDate.equals(data[0]), () -> "清分文件内清算日期与报文上送清算日期不一致");
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
            } else if (settleMode == SettleMode.PAYMENT) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format(preName + "暂不支持[%s]%s", data[4], settleMode.getName()));
            }

            ValidateUtils.isNum(data[5], true, preName + "账期");
            int period = Integer.valueOf(data[5]);
            if (period < 0 || period > 999999) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "账期必须不小于零或不大于999999");
            }
            periodSet.add(period);
            if (periodSet.size() > 1 && periodSet.contains(0)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "同批次内账期必须全部为0或非0");
            }
            ValidateUtils.maxLength(data[7], 20000,true,preName + "交易订单号列表");

        } catch (Exception e) {
            log.error("清分数据行信息有误.[{}]", line, e);
            transStatus = TransStatus.TRADE_FAILURE.name();
            transDesc = StringUtil.truncate(e.getMessage(), 100);
            //调整为最初的：整批次要么成功要么失败处理
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("清分数据行信息有误.%s", transDesc));
        }
        return SplitInfo.builder().id(IdGenerate.getId())
                .industryCode(industryCode)
                .providerCode(industryCode)
                .batchId(StringUtil.truncate(batchId, 32))
                .settleDate(StringUtil.truncate(data[0], 8))
                .clientTransId(StringUtil.truncate(data[1], 32))
                .userAccount(StringUtil.truncate(data[2], 19))
                .amount(parseAmount(data[3], 0L))
                .settleMode(StringUtil.truncate(data[4], 1))
                .period(parsePeriod(data[5], 0))
                .remark(StringUtil.truncate(data[6], 1024))
                .extend1(data[7]).extend2(StringUtil.truncate(data[8], 200)).extend3(StringUtil.truncate(data[9], 200))
                .gmtCreate(new Date()).gmtModified(new Date())
                .splitDate(buildSplitDate(data[0], data[5]))
                .status(SplitStatus.SPLIT_UNDO.getStatus())
                .transStatus(transStatus)
                .transDesc(transDesc)
                .transDate(DateUtil.getCurrentDate())
                .build();
    }


    private SplitInfo validSplitInfo(String industryCode, SplitInfo splitInfo, String industryBrokerageAccount, Long maxBrokerageRate, List<BlackList> allBlackList) {
        try {
            String userAccount = splitInfo.getUserAccount();
            Account account = accountHandler.queryAccountByUserAccount(userAccount);
            if (account == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "查无此虚拟账户");
            }

            //企业用户只有审核通过才可能出入金
            if (VirtualAccountType.MERCHANT.getType().equals(account.getObjType())) {
                MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(userAccount,false);
                MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(merchantInfoBo.getAuthStatus());
                if (merAuthStatus != MerAuthStatus.NORMAL) {
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("企业账户审核状态[%s],暂不能参与平台分账", merAuthStatus == null ? null : merAuthStatus.getValue()));
                }
            }

            //二级账户是否进入黑名单
            if (isBlackUserAccount(industryCode, userAccount, allBlackList)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("该账户[%s]的已被列入黑名单，暂不能分账", userAccount));
            }

            //客户端流水是否已存在
            boolean isExistsSplitInfo = splitInfoHandler.isExistsSplitInfo4Success(industryCode, splitInfo.getClientTransId());
            if (isExistsSplitInfo) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "客户端流水号[" + splitInfo.getClientTransId() + "]已存在成功分账记录");
            }

            //校验支付订单[transOrderIds]是否存在及金额大于分账金额
            boolean isBrokerageAccount = userAccount.equals(industryBrokerageAccount);
            String outsideTransOrderIds = splitInfo.getExtend1();
            outsideTransOrderHandler.validTransOrderIds(industryCode, outsideTransOrderIds, splitInfo.getAmount(), isBrokerageAccount, maxBrokerageRate);
        } catch (Exception e) {
            log.error("清分数据行信息有误.[客户端流水:{}]", splitInfo.getClientTransId(), e);
            //调整为最初的：整批次要么成功要么失败处理
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("清分数据行信息有误.%s", e.getMessage()));
        }
        return splitInfo;
    }

    /**
     * 黑名单校验及客户号一致性
     *
     * @param industryCode
     * @param userAccount
     * @param allBlackList
     * @return
     */
    private boolean isBlackUserAccount(String industryCode, String userAccount, List<BlackList> allBlackList) {
        MerchantInfo merchantInfo = accountHandler.findMerchantByAccount(userAccount);
        if (merchantInfo != null) {
            if (!StringUtil.equals(industryCode, merchantInfo.getIndustryCode())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("该分账用户归属代付客户[%s]与上送代付客户号不一致", merchantInfo.getIndustryCode()));
            }
        } else {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查无此子账户[%s]的基本信息", userAccount));
        }
        String userType = merchantInfo.getUserType();
        String code, name;
        if (userType.equals(UserType.MER.getType())) {
            code = merchantInfo.getBusLicCode();
            name = merchantInfo.getEntName();
        } else {
            code = merchantInfo.getIdCode();
            name = merchantInfo.getMerName();
        }
        if (!CollectionUtils.isEmpty(allBlackList)) {
            return allBlackList.parallelStream().filter(o -> o.getIdCode().equals(code) && o.getName().equals(name)).count() > 0;
        }
        return false;
    }


    private Long parseAmount(String amount, long defaultVal) {
        Long reVal = defaultVal;
        try {
            reVal = Long.valueOf(amount);
        } catch (NumberFormatException e) {
            log.error("金额[{}]格式化异常:", amount, e);
        }
        return reVal;
    }

    private Integer parsePeriod(String period, int defaultVal) {
        Integer reVal = defaultVal;
        try {
            reVal = Integer.valueOf(period);
        } catch (NumberFormatException e) {
            log.error("账期[{}]格式化异常:", period, e);
        }
        return reVal;
    }

    private String buildSplitDate(String settleDate, String period) {
        String splitDate = settleDate;
        try {
            splitDate = DateUtil.plusDate(settleDate, DateTimeFormatter.BASIC_ISO_DATE, Integer.parseInt(period));
        } catch (Exception e) {
            log.error("清算日期[{}]+账期[{}]推算清算日期异常:", settleDate, period, e);
        }
        return splitDate;
    }


}
