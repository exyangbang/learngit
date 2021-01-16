package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.Account;
import cn.kingnet.utp.service.persistence.entity.SubAccountMulTiSettleDetail;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountMultiSettleDetailBo;
import cn.kingnet.utp.service.persistence.entity.bo.UserAccountInfo;
import cn.kingnet.utp.service.persistence.service.CommonRedisService;
import cn.kingnet.utp.trade.common.bo.MerchantInfoBo;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSubAccountMultiSettleSplitReqDTO;
import cn.kingnet.utp.trade.common.dto.account.UploadSubAccountMultiSettleSplitRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 上送子账户多级分账文件
 * @Create : 2020-03-26
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.UPLOAD_SUBACCOUNT_MULTISETTLE_SPLIT,
        reqClass = UploadSubAccountMultiSettleSplitReqDTO.class,
        respClass = UploadSubAccountMultiSettleSplitRespDTO.class
)
@Slf4j
public class UploadSubAccountMultiSettleSplitService extends AbstractAccountTradeService<UploadSubAccountMultiSettleSplitReqDTO, UploadSubAccountMultiSettleSplitRespDTO> {

    public final static String DIR_NAME = "subAccount-multiSettleSplit";
    protected final static String FILE_BYTES = "FILE_BYTES";
    protected final static String MERCHANT_INFO_BO = "MERCHANT_INFO_BO";

    @Resource
    private ISubAccountMultiSettleDetailHandler subAccountMultiSettleDetailHandler;
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

    public UploadSubAccountMultiSettleSplitService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    private String buildUploadFileName(String industryCode, String subAccount, String settleDate, String batchNo) {
        return String.format("%s-%s-%s-%s.txt", industryCode, subAccount, settleDate, batchNo);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<UploadSubAccountMultiSettleSplitReqDTO, UploadSubAccountMultiSettleSplitRespDTO> tradeContext) {

        UploadSubAccountMultiSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();
        String industryCode = tradeContext.getAuthInfo().getAuthNo();
        String userAccount = reqDTO.getUserAccount();

        UploadSubAccountMultiSettleSplitRespDTO.UploadSubAccountMultiSettleSplitRespDTOBuilder builder = UploadSubAccountMultiSettleSplitRespDTO.builder();
        builder.settleDate(reqDTO.getSettleDate()).batchNo(reqDTO.getBatchNo()).success(Boolean.FALSE.toString());

        String fileName = buildUploadFileName(industryCode, userAccount, reqDTO.getSettleDate(), reqDTO.getBatchNo());
        SubAccountMultiSettleDetailBo multiSettleDetailBo;
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
                MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(subAccount.getAccount(),false);
                MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(merchantInfoBo.getAuthStatus());
                if (merAuthStatus != MerAuthStatus.NORMAL) {
                    throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("企业账户审核状态[%s],暂不能参与子账户多级分账", merAuthStatus == null ? null : merAuthStatus.getValue()));
                }
            }

            //解析文件域
            multiSettleDetailBo = buildMultiSettleDetailBo(industryCode, reqDTO, fileBytes, industryBrokerageAccount, maxBrokerageRate);

            //保存文件
            DataUtil.byte2File(fileBytes, utpConfigProperties.getUploadSettleSplitDir() + File.separator + DIR_NAME, fileName);
        } catch (Exception e) {
            logger.error("子账户[{}]批次号[{}]清算日期[{}]-->解析、保存子账户分账文件异常:", userAccount, reqDTO.getBatchNo(), reqDTO.getSettleDate(), e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("解析、保存子账户分账文件异常[%s]", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        try {
            //持久化log detail 以及 线程处理子账户分账业务
            subAccountMultiSettleDetailHandler.saveSubAccountMultiSettleDetail(multiSettleDetailBo);

            multiSettleDetailBo.getSubAccountMulTiSettleDetailList().forEach(detail -> {
                commonRedisService.addSubAccountMultiSettleDetailClientTransId(detail.getClientTransId(), detail.getBatchNo());
            });
            builder.success(Boolean.TRUE.toString());
        } catch (Exception e) {
            logger.error("子账户[{}]批次号[{}]清算日期[{}]清算类型[{}]-->子账户分账文件内容持久化操作异常:", industryCode, reqDTO.getBatchNo(), reqDTO.getSettleDate(), reqDTO.getType(), e);
            builder.success(Boolean.FALSE.toString());
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("子账户分账文件内容持久化操作异常[%s] ", StringUtil.truncate(e.getMessage(), 200)), e);
        }

        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<UploadSubAccountMultiSettleSplitReqDTO, UploadSubAccountMultiSettleSplitRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);

        UploadSubAccountMultiSettleSplitReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getReqDate(), true, "请求日期");
        ValidateUtils.isHHmmss(reqDTO.getReqTime(), true, "请求时间");
        ValidateUtils.isYyyyMMdd(reqDTO.getSettleDate(), true, "清算日期");
        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "子账户");
        ValidateUtils.abcValid(reqDTO.getUserAccount(), true, "子账户");
        ValidateUtils.maxLength(reqDTO.getBatchNo(), 30, true, "批次号");
        ValidateUtils.abcValid(reqDTO.getBatchNo(), true, "批次号");
        ValidateUtils.hasText(reqDTO.getContent(), "文件域");
        if (reqDTO.getType() == null || !reqDTO.getType().matches("1|2|3")) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "类型错误");
        }
        //校验查询平台基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

        //子账户是否已存在
        MerchantInfoBo merchantInfoBo = merchantAccountHandler.getMerchantInfoByAccountOrSettleAccount(reqDTO.getUserAccount(),false);
        if (merchantInfoBo == null || !tradeContext.getAuthInfo().getAuthNo().equals(merchantInfoBo.getIndustryCode())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("客户号[%s]下查无此子账户[%s]信息", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getUserAccount()));
        }
        if (!AccountStatus.OPEN_BIND.getCode().toString().equals(merchantInfoBo.getStatus())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "子账户状态非正常，暂无法分账");
        }

//        tradeContext.setAttribute(MERCHANT_INFO_BO, merchantInfoBo);

        //客户号+清算日期+批次号是否已存在 fixme 待优化缓存
        boolean isExist = subAccountMultiSettleDetailHandler.existsSubAccountMultiSettleDetail(tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo());
        if (isExist) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("平台[%s]下清算日期[%s]的批次号[%s] 已存在.", tradeContext.getAuthInfo().getAuthNo(), reqDTO.getSettleDate(), reqDTO.getBatchNo()));
        }

        try {
            byte[] fileBytes = DataUtil.inflaterAndDecode64(reqDTO.getContent());
            tradeContext.setAttribute(FILE_BYTES, fileBytes);
        } catch (Exception e) {
            logger.error("文件域解码解压缩异常:", e);
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "文件域解码解压缩异常:" + StringUtil.truncate(e.getMessage(), 200));
        }


    }

    @Override
    public void initTransFlow(TradeContext<UploadSubAccountMultiSettleSplitReqDTO, UploadSubAccountMultiSettleSplitRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<UploadSubAccountMultiSettleSplitReqDTO, UploadSubAccountMultiSettleSplitRespDTO> tradeContext) {

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
    private SubAccountMultiSettleDetailBo buildMultiSettleDetailBo(String industryCode, UploadSubAccountMultiSettleSplitReqDTO reqDTO, byte[] fileBytes,
                                                                   String industryBrokerageAccount,
                                                                   Long maxBrokerageRate) {
        List<String> list = DataUtil.byte2List(fileBytes, "UTF-8");
        if (CollectionUtils.isEmpty(list)) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("子账户[%s]批次号[%s]分账文件不能为空", reqDTO.getUserAccount(), reqDTO.getBatchNo()));
        }
        SubAccountMultiSettleDetailBo.SubAccountMultiSettleDetailBoBuilder builder = SubAccountMultiSettleDetailBo.builder();
        builder.industryCode(industryCode).userAccount(reqDTO.getUserAccount()).settleDate(reqDTO.getSettleDate()).batchNo(reqDTO.getBatchNo())
                .reqDate(reqDTO.getReqDate()).reqTime(reqDTO.getReqTime()).type(reqDTO.getType())
        .maxSplitSettleRows(productAccountProperties.getMaxSplitSettleRows());

        SubAccountMultiSettleDetailBo bo = builder.build();
        //解析文件域
        bo.parseContent(list);

        List<SubAccountMulTiSettleDetail> details = bo.getSubAccountMulTiSettleDetailList();

        //校验外部支付订单流水被关联最大次数
        validLinkedSplitList(industryCode, details);

        //校验客户端流水是否已存在及账期
        validClientTransIdAndPeriod(industryCode, bo);

        //获取平台客户下子账户信息
        Map<String, UserAccountInfo> subAccountMap = queryUserAccountByIndustryCode(industryCode);

        //逐条记录解析校验
//        bo.getSubAccountMulTiSettleDetailList().stream().forEach(detail -> {
//            this.buildMultiSettleDetail(reqDTO.getSettleDate(), detail, industryBrokerageAccount, maxBrokerageRate, subAccountMap);
//        });

        details = buildMultiSettleDetail4Multi(reqDTO.getSettleDate(), details, industryBrokerageAccount, maxBrokerageRate, subAccountMap);

        bo.setSubAccountMulTiSettleDetailList(details);
        bo.setSubAccountMap(subAccountMap);

        return bo;
    }

    private List<SubAccountMulTiSettleDetail> buildMultiSettleDetail4Multi(String settleDate, List<SubAccountMulTiSettleDetail> details, String industryBrokerageAccount, Long maxBrokerageRate, Map<String, UserAccountInfo> subAccountMap) {
        List<SubAccountMulTiSettleDetail> reList;
        AtomicBoolean isBlack = new AtomicBoolean(false);
        ExecutorService executorService = Executors.newFixedThreadPool(details.size() / 20+1);

        CompletableFuture<SubAccountMulTiSettleDetail>[] cfs =
                details.stream().map(o -> CompletableFuture.supplyAsync(() -> {
                    SubAccountMulTiSettleDetail detail = null;
                    if (!isBlack.get()) {
                        try {
                            detail = this.buildMultiSettleDetail(settleDate, o, industryBrokerageAccount, maxBrokerageRate, subAccountMap);
                        } catch (Exception e) {
                            isBlack.set(true);
                            throw new RuntimeException(e);
                        }
                    }
                    return detail;
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
    private void validClientTransIdAndPeriod(String industryCode, SubAccountMultiSettleDetailBo bo) {
        List<SubAccountMulTiSettleDetail> list = bo.getSubAccountMulTiSettleDetailList();

        if (!CollectionUtils.isEmpty(list)) {
            Multiset<String> clientTransIdMultiset = ConcurrentHashMultiset.create();
            ConcurrentHashMap<String, Integer> periodSet = new ConcurrentHashMap<>(8);

            list.stream().forEach(o -> {
                clientTransIdMultiset.add(o.getClientTransId());
                periodSet.putIfAbsent(String.valueOf(o.getPeriod()), o.getPeriod());
            });

            String t0Flag = "0";
            if (periodSet.size() > 1 && periodSet.containsKey(t0Flag)) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "同批次内账期必须全部为0或非0");
            }
            bo.setPeriod(periodSet.containsKey(t0Flag) ? "0" : "n");

            if (!CollectionUtils.isEmpty(clientTransIdMultiset)) {
                clientTransIdMultiset.elementSet().parallelStream().forEach(clientTransId -> {
                    long curCount = clientTransIdMultiset.count(clientTransId);
                    if (curCount > 1 || commonRedisService.isExistSubAccountMultiSettleDetailClientTransId(clientTransId)) {
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
    private void validLinkedSplitList(String industryCode, List<SubAccountMulTiSettleDetail> list) {
        if (!CollectionUtils.isEmpty(list)) {
            Multiset<String> multiset = ConcurrentHashMultiset.create();
            list.parallelStream().forEach(o -> {
                Set<String> transOrderSet = Splitter.on(",").trimResults().splitToList(o.getTransOrderIds())
                        .parallelStream().filter(StringUtil::isNoneBlank).collect(Collectors.toSet());
                if (!CollectionUtils.isEmpty(transOrderSet)) {
                    multiset.addAll(transOrderSet);
                }
            });

            if (!CollectionUtils.isEmpty(multiset)) {
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

    /**
     * 平台客户下所有子账户支付关联信息
     */
    private Map<String, UserAccountInfo> queryUserAccountByIndustryCode(String industryCode) {
        List<UserAccountInfo> list = accountHandler.queryUserAccountByIndustryCode(industryCode);
        if (!CollectionUtils.isEmpty(list)) {
            return list.stream().collect(Collectors.toMap(UserAccountInfo::getAccount, Function.identity(), (t1, t2) -> t2));
        }
        throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("该客户号[%s]下未开通任何子账户", industryCode));
    }

    private SubAccountMulTiSettleDetail buildMultiSettleDetail(String settleDate, SubAccountMulTiSettleDetail detail, String industryBrokerageAccount, Long maxBrokerageRate, Map<String, UserAccountInfo> subAccountMap) {

        String transStatus = TransStatus.PRE_CREATE.name(), transDesc = "分账数据已受理";
        try {
            String preName = String.format("记录[%s]行中", detail.getSeqNo());
            ValidateUtils.isYyyyMMdd(detail.getSettleDate(), true, preName + "清算日期");
            Assert.isTrue(settleDate.equals(detail.getSettleDate()), () -> "分账文件内清算日期与报文上送清算日期不一致");
            ValidateUtils.abcValid(detail.getClientTransId(), 32, true, preName + "客户端流水号");
            ValidateUtils.abcValid(detail.getPayerSubAccount(), 19, true, preName + "分账转出子账户");
            ValidateUtils.abcValid(detail.getPayeeSubAccount(), 19, true, preName + "分账转入子账户");
            ValidateUtils.isPositiveInteger(detail.getAmount().toString(), 15, true, preName + "金额");
            Assert.isTrue(SettleMode.CHARGE.getCode().equals(detail.getSettleMode()), () -> preName + "结算方式必须为记账结算");
            Assert.isTrue(detail.getPeriod().intValue() == 0, () -> preName + "暂仅支持账期为0");
            ValidateUtils.maxLength(detail.getRemark(), 1024, false, preName + "备注");
            ValidateUtils.maxLength(detail.getTransOrderIds(), 20000, true, preName + "交易订单号列表");
            ValidateUtils.maxLength(detail.getExtend2(), 200, false, preName + "扩展字段2");
            ValidateUtils.maxLength(detail.getExtend3(), 200, false, preName + "扩展字段3");

            //校验各type类型下userAccount、payerSubAccount、payeeSubAccount关系 及余额
            validPayerAndPayeeSubAccount(detail, subAccountMap);

            //校验支付订单[transOrderIds]是否存在及金额大于分账金额
            boolean isBrokerageAccount = detail.getPayeeSubAccount().equals(industryBrokerageAccount);
            outsideTransOrderHandler.validTransOrderIds(detail.getIndustryCode(), detail.getTransOrderIds(), detail.getAmount(), isBrokerageAccount, maxBrokerageRate);

            Date curDate = new Date();
            detail.setGmtCreate(curDate);
            detail.setGmtModified(curDate);
            detail.setSplitDate(buildSplitDate(detail.getSettleDate(), detail.getPeriod()));
            detail.setStatus(SplitStatus.SPLIT_UNDO.getStatus());
            detail.setTransStatus(transStatus);
            detail.setTransDesc(transDesc);
            detail.setTransDate(DateUtil.getCurrentDate());
            detail.setTransTime(DateUtil.getCurrentTime());
        } catch (Exception e) {
            log.error("分账数据行信息有误.[客户端流水号{}]", detail.getClientTransId(), e);
            transStatus = TransStatus.TRADE_FAILURE.name();
            transDesc = StringUtil.truncate(e.getMessage(), 100);
            //调整为最初的：整批次要么成功要么失败处理
            throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("分账数据行信息有误.%s [客户端流水号%s]", transDesc, detail.getClientTransId()));
        }
        return detail;
    }

    private void validPayerAndPayeeSubAccount(SubAccountMulTiSettleDetail detail, Map<String, UserAccountInfo> subAccountMap) {
        UserAccountInfo userAccount = subAccountMap.get(detail.getUserAccount());
        Assert.notNull(userAccount, () -> String.format("客户号[%s]下查无此出金子账户[%s]", detail.getIndustryCode(), detail.getUserAccount()));
        UserAccountInfo payerAccount = subAccountMap.get(detail.getPayerSubAccount());
        Assert.notNull(payerAccount, () -> String.format("客户号[%s]下查无此分账转出子账户[%s]", detail.getIndustryCode(), detail.getPayerSubAccount()));
        UserAccountInfo payeeAccount = subAccountMap.get(detail.getPayeeSubAccount());
        Assert.notNull(payeeAccount, () -> String.format("客户号[%s]下查无此分账转出子账户[%s]", detail.getIndustryCode(), detail.getPayeeSubAccount()));

        Assert.isTrue(TrueOrFalseStatus.TRUE.value().equals(userAccount.getStatus()), () -> "出金子账户状态不可用");
        Assert.isTrue(TrueOrFalseStatus.TRUE.value().equals(payerAccount.getStatus()), () -> "分账转出子账户状态不可用");

        Assert.isTrue(AccountStatus.OPEN_BIND.getCode().toString().equals(payerAccount.getMerchantStatus()), () -> "分账转出用户必须已开户已绑卡");
        if (AccountStatus.NO_OPEN.getCode().toString().equals(payeeAccount.getMerchantStatus()) || AccountStatus.CANCEL.getCode().toString().equals(payeeAccount.getMerchantStatus())) {
            throw new ProductException(HttpRespStatus.BAD_REQUEST, "分账转入用户未开户或已销户");
        }

        //payer企业用户只有审核通过才可能出入金
        if (VirtualAccountType.MERCHANT.getType().equals(payerAccount.getObjType())) {
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(payerAccount.getMerchantAuthStatus());
            if (merAuthStatus != MerAuthStatus.NORMAL) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("分账转出的企业账户审核状态[%s],暂不能参与子账户分账", merAuthStatus == null ? null : merAuthStatus.getValue()));
            }
        }
        //payee企业用户只有审核通过才可能出入金
        if (VirtualAccountType.MERCHANT.getType().equals(payeeAccount.getObjType())) {
            MerAuthStatus merAuthStatus = MerAuthStatus.getEnum(payeeAccount.getMerchantAuthStatus());
            if (merAuthStatus != MerAuthStatus.NORMAL) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, String.format("分账转入的企业账户审核状态[%s],暂不能参与子账户分账", merAuthStatus == null ? null : merAuthStatus.getValue()));
            }
        }

        if (1 == detail.getSeqNo().intValue()) {
            Assert.isTrue(detail.getUserAccount().equals(detail.getPayerSubAccount()), "首行分账转出子账户与出金子账户必须为同一个待结算账户");
        }

        String type = detail.getType();
        switch (type) {
            case "1": {
                //结算类型
                if (1 == detail.getSeqNo().intValue()) {
                    //校验出金子账户第一条必须是待结算账户
                    Assert.isTrue(VirtualAccountType.SETTLEACCOUNT.getType().equals(userAccount.getObjType()), "出金子账户必须为待结算账户");
                }
                //所有记录，待结算账户做为转出账户时，转入账户只能是关联的同名结算账户
                if (VirtualAccountType.SETTLEACCOUNT.getType().equals(payerAccount.getObjType())) {
                    Assert.isTrue(payeeAccount.getAccount().equals(payerAccount.getOrigAccount()), "转出账户为待结算账户，则转入账户只能是其关联的同名结算账户");
                }

                //转出账户只能为普通账户+待结算账户 ，转入账户只能普通账户+佣金账户
                Assert.isTrue(payerAccount.getObjType().matches("2|3|8|9"), "转出账户只能为结算账户或待结算账户");
                Assert.isTrue(payeeAccount.getObjType().matches("2|3|8|9|7"), "转入账户只能为结算账户或佣金账户或待结算账户");
            }
            break;
            case "2": {
                //退款类型
                //校验所有出金子账户不能是待结算账户
                Assert.isTrue(!VirtualAccountType.SETTLEACCOUNT.getType().equals(payerAccount.getObjType()), "退款类型，转出子账户不能为待结算账户");

                //TODO 校验金额最大的那笔分账资金只能转入到平台配置的退款户（下一个版本实现）
                //TODO 校验退款与正常交易比例不能超过风控设定值（下一个版本实现）
            }
            break;
            case "3": {
                //撤销类型
                //校验所有出金子账户必须是待结算账户。
                Assert.isTrue(VirtualAccountType.SETTLEACCOUNT.getType().equals(payerAccount.getObjType()), "撤销类型，转出子账户只能为待结算账户");
//                Assert.isTrue(payerAccount.getAccount().equals(userAccount.getAccount()), "撤销类型，转出子账户必须和出金子账户为同一待结算账户");
                //TODO 校验待结算账户转入的账户必须是平台配置的退款户（下一个版本实现）
                //TODO 校验撤销与正常交易比例不能超过风控设定值（下一个版本实现）
            }
            break;
            default: {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "类型[" + type + "]有误");
            }
        }


    }

    private String buildSplitDate(String settleDate, int period) {
        String splitDate = settleDate;
        try {
            splitDate = DateUtil.plusDate(settleDate, DateTimeFormatter.BASIC_ISO_DATE, period);
        } catch (Exception e) {
            log.error("推算分账日期异常:", settleDate, period, e);
        }
        return splitDate;
    }


}
