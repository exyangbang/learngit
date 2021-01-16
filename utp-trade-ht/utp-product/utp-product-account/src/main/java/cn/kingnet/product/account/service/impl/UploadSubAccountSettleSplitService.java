package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.UploadSubAccountSettleSplitDetail;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountSettleSplitInfoBo;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSubAccountSettleSplitReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSubAccountSettleSplitRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.ConcurrentHashMultiset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 子账户平台清分文件上送
 * @Create : 2020-02-16
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UPLOAD_SUBACCOUNT_SETTLE_SPLIT,
        reqClass = UploadSubAccountSettleSplitReqDTO.class,
        respClass = UploadSubAccountSettleSplitRespDTO.class
)
@Slf4j
public class UploadSubAccountSettleSplitService extends AbstractAccountTradeService<UploadSubAccountSettleSplitReqDTO, UploadSubAccountSettleSplitRespDTO> {

    public final static String DIR_NAME = "subAccount-settleSplit";
    protected final static String FILE_BYTES = "FILE_BYTES";

    @Resource
    private ISubAccountSettleSplitHandler subAccountSettleSplitHandler;
    @Resource
    private IAccountHandler accountHandler;
    @Resource
    private IOutsideTransOrderHandler outsideTransOrderHandler;
    @Resource
    private IIndustryAmtLimitHandler iIndustryAmtLimitHandler;
    @Resource
    private IMerchantAccountHandler merchantAccountHandler;

    @Resource
    private CommonRedisService commonRedisService;

    public UploadSubAccountSettleSplitService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    private String buildUploadFileName(String industryCode, String subAccount, String settleDate, String batchNo) {
        return String.format("%s-%s-%s-%s.txt", industryCode, subAccount, settleDate, batchNo);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadSubAccountSettleSplitReqDTO, UploadSubAccountSettleSplitRespDTO> tradeContext) {

        UploadSubAccountSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        String userAccount = reqDTO.getUserAccount();

        UploadSubAccountSettleSplitRespDTO.UploadSubAccountSettleSplitRespDTOBuilder builder = UploadSubAccountSettleSplitRespDTO.builder();
        builder.userAccount(userAccount).settleDate(reqDTO.getSettleDate()).batchNo(reqDTO.getBatchNo()).success(Boolean.FALSE.toString());

        String fileName = buildUploadFileName(industryCode, userAccount, reqDTO.getSettleDate(), reqDTO.getBatchNo());
        SubAccountSettleSplitInfoBo settleSplitInfoBo;

        try {
            byte[] fileBytes = tradeContext.getAttribute(FILE_BYTES);
            BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
            String industryBrokerageAccount = basicConfigInfo.getIndustryBrokerageAccount();
            Long maxBrokerageRate = basicConfigInfo.getMaxBrokerageRate();

            Account subAccount = accountHandler.queryAccountByUserAccount(userAccount);
            if (subAccount == null || !CommonConstants.STATUS_NORMAL.equals(subAccount.getStatus())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("查无此子账户[%s]关联账户信息或者账户状态不可用", userAccount));
            }

            //企业用户只有审核通过才可能出入金
            if (VirtualAccountType.MERCHANT.getType().equals(subAccount.getObjType())) {
                MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(userAccount,false);
                MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(merchantInfoBo.getAuthStatus());
                if (merAuthStatus != MerAuthStatus.NORMAL) {
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("企业账户审核状态[%s],暂不能参与分账", merAuthStatus == null ? null : merAuthStatus.getValue()));
                }
            }

            //上送文件域解析校验
            settleSplitInfoBo = buildSettleSplitInfoBo(industryCode, subAccount.getFundAccount(), reqDTO, fileBytes, industryBrokerageAccount, maxBrokerageRate);

            long curBalance = subAccount.getAvailAmount() == null ? 0L : subAccount.getAvailAmount();
            if (curBalance < settleSplitInfoBo.getSubAccountSettleSplitDetailList().stream().mapToLong(o -> o.getAmount()).sum()) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "子账户账户余额不足,请充值后再试.");
            }

            //保存文件
            DataUtil.byte2File(fileBytes, utpConfigProperties.getUploadSettleSplitDir() + File.separator + DIR_NAME, fileName);

        } catch (Exception e) {
            logger.error("子账户[{}]批次号[{}]清算日期[{}]-->解析、保存子账户分账文件异常:", userAccount, reqDTO.getBatchNo(), reqDTO.getSettleDate(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("校验失败[%s]", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        try {
            //持久化log detail 以及 线程处理子账户分账业务
            subAccountSettleSplitHandler.saveSubAccountSettleSplit(settleSplitInfoBo);
            settleSplitInfoBo.getSubAccountSettleSplitDetailList().forEach(detail -> {
                commonRedisService.addSubAccountSettleSplitClientTransId(detail.getClientTransId(), detail.getBatchNo());
            });
            builder.success(Boolean.TRUE.toString());
        } catch (Exception e) {
            logger.error("子账户[{}]批次号[{}]清算日期[{}]-->子账户分账文件内容持久化操作异常:", industryCode, reqDTO.getBatchNo(), reqDTO.getSettleDate(), e);
            builder.success(Boolean.FALSE.toString());
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("子账户分账文件处理异常[%s] ", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadSubAccountSettleSplitReqDTO, UploadSubAccountSettleSplitRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        UploadSubAccountSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "子账户");
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "子账户");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.hasText(reqDTO.getContent(), "文件域");
        ValidateUtils.isHttpUrl(reqDTO.getCallbackUrl(), true, "回调地址");

        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);
        //子账户是否已存在
        MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(reqDTO.getUserAccount(),true);
        if (merchantInfoBo == null || !tradeContext.getAuthInfo().getAuthNo().equals(merchantInfoBo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]下查无此子账户[%s]信息", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getUserAccount()));
        }
        //子账户+批次号是否已存在
        boolean isExist = subAccountSettleSplitHandler.isExistSubAccountSettleSplitLog(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getUserAccount(), reqDTO.getBatchNo());
        if (isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("平台[%s]下子账户[%s]的批次号[%s] 已存在.", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getUserAccount(), reqDTO.getBatchNo()));
        }

        try {
            byte[] fileBytes = DataUtil.inflaterAndDecode64(reqDTO.getContent());
            tradeContext.setAttribute(FILE_BYTES, fileBytes);
        } catch (Exception e) {
            logger.error("子账户批量分账文件域解码解压缩异常:", e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "文件域解码解压缩异常:" + StringUtil.truncate(e.getMessage(), 200));
        }


    }

    @Override
    public void initTransFlow(TradeContext<UploadSubAccountSettleSplitReqDTO, UploadSubAccountSettleSplitRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadSubAccountSettleSplitReqDTO, UploadSubAccountSettleSplitRespDTO> tradeContext) {

    }


    /**
     * 子账户分账文件转业务对象
     *
     * @param industryCode             代付客户号
     * @param reqDTO                   业务清算日期
     * @param fileBytes                文件域内容
     * @param industryBrokerageAccount 佣金账户
     * @param maxBrokerageRate         最大佣金比例
     * @return
     */
    public SubAccountSettleSplitInfoBo buildSettleSplitInfoBo(String industryCode, String payerFundAccount, UploadSubAccountSettleSplitReqDTO reqDTO, byte[] fileBytes,
                                                              String industryBrokerageAccount,
                                                              Long maxBrokerageRate) {
        List<String> list = DataUtil.byte2List(fileBytes, "UTF-8");
        if (CollectionUtils.isEmpty(list)) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("子账户[%s]批次号[%s]清分文件不能为空", reqDTO.getUserAccount(), reqDTO.getBatchNo()));
        }

        SubAccountSettleSplitInfoBo.SubAccountSettleSplitInfoBoBuilder builder = SubAccountSettleSplitInfoBo.builder();
        builder.industryCode(industryCode).userAccount(reqDTO.getUserAccount()).settleDate(reqDTO.getSettleDate()).batchNo(reqDTO.getBatchNo())
                .reqDate(reqDTO.getReqDate()).reqTime(reqDTO.getReqTime()).callbackUrl(reqDTO.getCallbackUrl())
        .maxSplitSettleRows(productAccountProperties.getMaxSplitSettleRows());
        SubAccountSettleSplitInfoBo bo = builder.build();

        //解析文件头及文件内容
        bo.parseContent(list);

        List<UploadSubAccountSettleSplitDetail> details = bo.getSubAccountSettleSplitDetailList();

        //校验客户端流水号及账期是否全0或全非0
        validClientTransIdAndPeriod(industryCode, bo);

        //校验外部支付订单流水被关联最大次数
        validLinkedSplitList(industryCode, details);

//        details.stream().forEach(detail -> {
//            this.buildSettleSplitDetial(reqDTO.getSettleDate(),payerFundAccount, detail, industryBrokerageAccount, maxBrokerageRate);
//        });

        details = buildSettleSplitDetail4Multi(reqDTO.getSettleDate(), payerFundAccount, details, industryBrokerageAccount, maxBrokerageRate);

        bo.setSubAccountSettleSplitDetailList(details);

        return bo;
    }

    /**
     * 多线程逐行解析校验
     */
    private List<UploadSubAccountSettleSplitDetail> buildSettleSplitDetail4Multi(String settleDate, String payerFundAccount, List<UploadSubAccountSettleSplitDetail> details, String industryBrokerageAccount, Long maxBrokerageRate) {
        List<UploadSubAccountSettleSplitDetail> reList ;

        ExecutorService executorService = Executors.newFixedThreadPool(details.size() / 20 + 1);
        AtomicBoolean isBlack = new AtomicBoolean(false);

        CompletableFuture<UploadSubAccountSettleSplitDetail>[] cfs =
                details.stream().map(detail -> CompletableFuture.supplyAsync(() -> {
                    UploadSubAccountSettleSplitDetail curDetail = null;
                    if (!isBlack.get()) {
                        try {
                            curDetail = this.buildSettleSplitDetial(settleDate, payerFundAccount, detail, industryBrokerageAccount, maxBrokerageRate);
                        } catch (Exception e) {
                            isBlack.set(true);
                            throw e;
                        }
                    }
                    return curDetail;
                }, executorService)).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(cfs).join();
        executorService.shutdown();

        reList = Arrays.stream(cfs).map(CompletableFuture::join).collect(Collectors.toList());

        return reList;
    }


    /**
     * 验证客户端流水
     *
     * @param bo
     */
    private void validClientTransIdAndPeriod(String industryCode, SubAccountSettleSplitInfoBo bo) {
        List<UploadSubAccountSettleSplitDetail> list = bo.getSubAccountSettleSplitDetailList();

        if (!CollectionUtils.isEmpty(list)) {
            ConcurrentHashMultiset<String> clientTransIdMultiset = ConcurrentHashMultiset.create();
            ConcurrentHashMap<String, Integer> periodSet = new ConcurrentHashMap(8);

            list.parallelStream().forEach(o -> {
                clientTransIdMultiset.add(o.getClientTransId());
                periodSet.putIfAbsent(String.valueOf(o.getPeriod()), o.getPeriod());
            });

            //设置整批次T0|Tn 标识
            String t0Flag = "0";
            if (periodSet.size() > 1 && periodSet.containsKey(t0Flag)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "同批次内账期必须全部为0或非0");
            }
            bo.setPeriod(periodSet.containsKey(t0Flag) ? "0" : "n");

            //校验客户端流水是否已存在
            if (!CollectionUtils.isEmpty(clientTransIdMultiset)) {
                clientTransIdMultiset.elementSet().parallelStream().forEach(clientTransId -> {
                    long curCount = clientTransIdMultiset.count(clientTransId);
                    if (curCount > 1 || commonRedisService.isExistSubAccountSettleSplitClientTransId(clientTransId)) {
                        throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("客户端流水[%s]文件内重复或数据库已存在", clientTransId));
                    }
                });
            }
        }
    }

    /**
     * 验证支付流水关联被分账记录数
     *
     * @param industryCode
     * @param list
     */
    private void validLinkedSplitList(String industryCode, List<UploadSubAccountSettleSplitDetail> list) {
        if (!CollectionUtils.isEmpty(list)) {
            ConcurrentHashMultiset<String> multiset = ConcurrentHashMultiset.create();
            list.stream().forEach(o -> {
                Set<String> transOrderSet = Splitter.on(",").trimResults().splitToList(o.getTransOrderIds())
                        .parallelStream().filter(StringUtil::isNoneBlank).collect(Collectors.toSet());
                if (!CollectionUtils.isEmpty(transOrderSet)) {
                    multiset.addAll(transOrderSet);
                }
            });

            if (!CollectionUtils.isEmpty(multiset)) {
                //fixme 待优化与后管联动更新缓存
                Integer maxLinkSplitIdNumDb = iIndustryAmtLimitHandler.findSameOrderMaxSplitNum(industryCode);
                int maxLinkSplitIdNum = maxLinkSplitIdNumDb == null || maxLinkSplitIdNumDb <= 0 ? 5 : maxLinkSplitIdNumDb.intValue();
                multiset.elementSet().stream().forEach(orderId -> {
                    long curLinkedSplitNum = multiset.count(orderId);
                    if (curLinkedSplitNum > maxLinkSplitIdNum) {
                        log.error("支付流水[{}]当前关联分账记录数[{}],已超出最大可关联分账记录数[{}]", orderId, curLinkedSplitNum, maxLinkSplitIdNum);
                        throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("支付流水[%s]已超出最大可关联分账记录数[%s]", orderId, maxLinkSplitIdNum));
                    }

                    int dbLinkedSplitIdNum = outsideTransOrderHandler.queryLinkedSplitNumByTransOrderId(industryCode, orderId);
                    if ((curLinkedSplitNum + dbLinkedSplitIdNum) > maxLinkSplitIdNum) {
                        log.error("支付流水[{}]当前关联分账记录数[{}],已超出最大可关联分账记录数[{}]", orderId, curLinkedSplitNum, curLinkedSplitNum);
                        throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("支付流水[%s]已超出最大可关联分账记录数[%s]", orderId, maxLinkSplitIdNum));
                    }
                });
            }
        }
    }


    private UploadSubAccountSettleSplitDetail buildSettleSplitDetial(String settleDate, String payerFundAccount, UploadSubAccountSettleSplitDetail detail,
                                                                     String industryBrokerageAccount,
                                                                     Long maxBrokerageRate) {

        String transStatus = TransStatus.PRE_CREATE.name(), transDesc = "清分数据已受理";
        try {
            String preName = String.format("记录[%s]行中", detail.getSeqNo());
            ValidateUtils.isYyyyMMdd(detail.getSettleDate(), true, preName + "清算日期");
            if (!settleDate.equals(detail.getSettleDate())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "清分文件内清算日期与报文上送清算日期不一致.");
            }
            ValidateUtils.abcValid(detail.getClientTransId(), true, preName + "客户端流水号");
            ValidateUtils.maxLength(detail.getClientTransId(), 32, true, preName + "客户端流水号");

            ValidateUtils.maxLength(detail.getSubAccount(), 19, true, preName + "入金子账户");
            ValidateUtils.abcValid(detail.getSubAccount(), true, preName + "入金子账户");
            Account account = accountHandler.queryAccountByUserAccount(detail.getSubAccount());
            if (account == null) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "查无此入金子账户[" + detail.getSubAccount() + "]");
            }

            //企业用户只有审核通过才可能出入金
            if (VirtualAccountType.MERCHANT.getType().equals(account.getObjType())) {
                MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(account.getAccount(),false);
                MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(merchantInfoBo.getAuthStatus());
                if (merAuthStatus != MerAuthStatus.NORMAL) {
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("企业账户审核状态[%s],暂不能参与子账户分账", merAuthStatus == null ? null : merAuthStatus.getValue()));
                }
            }

            if (payerFundAccount == null || !payerFundAccount.equals(account.getFundAccount())) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "出金子账户与入金子账户的实体账户号不一致");
            }
            VirtualAccountType virtualAccountType = VirtualAccountType.resolve(account.getObjType());
            if (virtualAccountType == null || !(
                    virtualAccountType == VirtualAccountType.MERCHANT ||
                            virtualAccountType == VirtualAccountType.PERSON ||
                            virtualAccountType == VirtualAccountType.BROKERAGE ||
                            virtualAccountType == VirtualAccountType.SELFEMPLOYED ||
                            virtualAccountType == VirtualAccountType.SETTLEACCOUNT)
            ) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "该入金子账户类型[" + account.getObjType() + "]不允许此操作");
            }

            ValidateUtils.maxLength(String.valueOf(detail.getAmount()), 15, true, preName + "金额");
            if (detail.getAmount() <= 0) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "金额必须大于零");
            }

            ValidateUtils.isNum(detail.getSettleMode(), true, preName + "结算方式");
            SettleMode settleMode = SettleMode.getSettleMode(detail.getSettleMode());
            if (settleMode == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format(preName + "结算方式[%s]有误", detail.getSettleMode()));
            } else if (settleMode == SettleMode.PAYMENT) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format(preName + "暂不支持[%s]%s", detail.getSettleMode(), settleMode.getName()));
            }

            if (detail.getPeriod() < 0 || detail.getPeriod() > 999999) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "账期必须不小于零或不大于999999");
            }
            ValidateUtils.maxLength(detail.getTransOrderIds(), 20000, true, preName + "交易订单号列表");

            //校验支付订单[transOrderIds]是否存在及金额大于分账金额
            boolean isBrokerageAccount = detail.getSubAccount().equals(industryBrokerageAccount);
            outsideTransOrderHandler.validTransOrderIds(detail.getIndustryCode(), detail.getTransOrderIds(), detail.getAmount(), isBrokerageAccount, maxBrokerageRate);

            Date curDate = new Date();
            detail.setGmtCreate(curDate);
            detail.setGmtModified(curDate);
            detail.setSplitDate(buildSplitDate(detail.getSettleDate(), detail.getPeriod()));
            detail.setStatus(SplitStatus.SPLIT_UNDO.getStatus());
            detail.setTransStatus(transStatus);
            detail.setTransDesc(transDesc);
            detail.setTransDate(DateUtil.getCurrentDate());
        } catch (Exception e) {
            log.error("清分数据行信息有误.[客户端流水号{}]", detail.getClientTransId(), e);
            transStatus = TransStatus.TRADE_FAILURE.name();
            transDesc = StringUtil.truncate(e.getMessage(), 100);
            //调整为最初的：整批次要么成功要么失败处理
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("清分数据行信息有误.%s [客户端流水号%s]", transDesc, detail.getClientTransId()));
        }
        return detail;
    }

    private String buildSplitDate(String settleDate, int period) {
        String splitDate = settleDate;
        try {
            splitDate = DateUtil.plusDate(settleDate, DateTimeFormatter.BASIC_ISO_DATE, period);
        } catch (Exception e) {
            log.error("清算日期[{}]+账期[{}]推算清算日期异常:", settleDate, period, e);
        }
        return splitDate;
    }


}
