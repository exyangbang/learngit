package cn.kingnet.utp.scheduler.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.scheduler.data.entity.Industry;
import cn.kingnet.utp.scheduler.data.entity.IndustryCondition;
import cn.kingnet.utp.scheduler.data.entity.IndustrySyncLog;
import cn.kingnet.utp.scheduler.data.entity.IndustrySyncLogCondition;
import cn.kingnet.utp.scheduler.data.mapper.IndustryMapper;
import cn.kingnet.utp.scheduler.exception.SyncIndustryAccountException;
import cn.kingnet.utp.service.persistence.api.*;
import cn.kingnet.utp.service.persistence.entity.BankAccountTransDetail;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.dto.onebank.*;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.support.ServerIdGenerate;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.IdGenerate;
import cn.kingnet.utp.trade.common.utils.MathUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.entity.Column;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Description 同步行业（平台）交易明细
 * @Author WJH
 * @Date 2018年10月23日
 */
@Service
@Slf4j
public class SyncIndustryAccountService {


    @Resource
    private IPaymentService iPaymentService;

    @Resource
    private IAccountHandler iAccountHandler;

    @Resource
    private IIndustryHandler iIndustryHandler;

    @Resource
    private IFundAccountHandler fundAccountHandler;

    @Resource
    private ServerIdGenerate serverIdGenerate;

    @Resource
    private IChannelIncomeFlowHandler channelIncomeFlowHandler;
    @Resource
    private IBankAccountTransDetailHandler bankAccountTransDetailHandler;

    private final ExecutorService executorService;

    public SyncIndustryAccountService() {
        this.executorService = new ThreadPoolExecutor(5, 80,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("SyncIndustryAccountService-%d").build(), new ThreadPoolExecutor.DiscardPolicy());

    }

    /**
     * 同步银行资金账户余额
     *
     * @param fundAccount
     */
    public void syncFundAccountBalance(FundAccount fundAccount) {
        Long fundAccountBalance = queryBankAccountBalance(fundAccount);
        try {
            if (fundAccountBalance != null) {
                iIndustryHandler.syncFundAccountBalance(fundAccount.getBankAccountNo(), fundAccountBalance);
            }
        } catch (Exception e) {
            log.error("资金账户{}[{}] 资金账户余额同步异常:{}", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), e.getMessage(), e);
        }
    }

    private Long queryBankAccountBalance(FundAccount fundAccount) {
        Long fundAccountBalance = null;
        if (fundAccount != null) {
            if (FundAccType.INNER_ACC.getType().equals(fundAccount.getAccountType())) {
                OneBankInnerAccountBalanceQueryReqDTO reqDTO = new OneBankInnerAccountBalanceQueryReqDTO();
                reqDTO.setSubAccount(fundAccount.getBankAccountNo());
                reqDTO.setStartingRow("0");
                reqDTO.setFirstInquiryFlg("1");
                reqDTO.setPerReturnRows("100");

                reqDTO.setReqDate(DateUtil.getCurrentDate());
                reqDTO.setReqTime(DateUtil.getCurrentTime());
                reqDTO.setClientTradeId(serverIdGenerate.generateServerTransId());
                ChannelResponseDTO responseDTO = iPaymentService.innerAccountBalanceQuery(reqDTO);
                if (responseDTO != null) {
                    log.info("内部户余额查询 >> 资金账户{}[{}] 响应报文：{}", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), JSON.toJSONString(responseDTO));
                }
                //查询成功
                if (responseDTO != null && HttpRespStatus.OK.valueStr().equals(responseDTO.getStatus())) {
                    JSONObject reJson = new JSONObject(responseDTO.getSpRespMsg());
                    String data = reJson.getString("data");
                    if (StringUtil.isNotEmpty(data)) {
                        List<OneBankInnerAccountBalanceQueryRespDTO> respDTOList = JSON.parseArray(data, OneBankInnerAccountBalanceQueryRespDTO.class);
                        if (respDTOList != null) {
                            Double accountBalance = respDTOList.get(0).getAccountBalance();
                            if (accountBalance != null) {
                                fundAccountBalance = MathUtil.multiply(BigDecimal.valueOf(accountBalance), BigDecimal.valueOf(100d)).longValue();
                            }
                        }
                    }
                }
            } else if (FundAccType.GENERAL_ACC.getType().equals(fundAccount.getAccountType())) {
                OneBankAccountBalanceQueryReqDTO reqDTO = new OneBankAccountBalanceQueryReqDTO();
                reqDTO.setCustAcctRangeFlg("1");
                reqDTO.setCustAccountNo(fundAccount.getBankAccountNo());
                reqDTO.setStartingRow("0");
                reqDTO.setFirstInquiryFlg("1");
                reqDTO.setPerReturnRows("100");

                reqDTO.setReqDate(DateUtil.getCurrentDate());
                reqDTO.setReqTime(DateUtil.getCurrentTime());
                reqDTO.setClientTradeId(serverIdGenerate.generateServerTransId());
                ChannelResponseDTO responseDTO = iPaymentService.accountBalanceQuery(reqDTO);
                if (responseDTO != null) {
                    log.info("一般户余额查询 >> 资金账户{}[{}] 响应报文：{}", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), JSON.toJSONString(responseDTO));
                }
                //查询成功
                if (responseDTO != null && HttpRespStatus.OK.valueStr().equals(responseDTO.getStatus())) {
                    JSONObject reJson = new JSONObject(responseDTO.getSpRespMsg());
                    String data = reJson.getString("data");
                    if (StringUtil.isNotEmpty(data)) {
                        List<OneBankAccountBalanceQueryRespDTO> respDTOList = JSON.parseArray(data, OneBankAccountBalanceQueryRespDTO.class);
                        if (respDTOList != null) {
                            Double accountBalance = respDTOList.get(0).getAvailableBalance();
                            if (accountBalance != null) {
                                fundAccountBalance = MathUtil.multiply(BigDecimal.valueOf(accountBalance), BigDecimal.valueOf(100d)).longValue();
                            }
                        }
                    }
                } else {
                    log.error("余额查询 >> 资金账户{}[{}] 账户类型[{}]暂不支持", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), fundAccount.getAccountType());
                }
            }
        }
        return fundAccountBalance;
    }


    /**
     * 同步资金账户下资金明细记录
     *
     * @param fundAccount
     * @param startDate
     * @param endDate
     */
    public void syncBankAccountTransDetail(FundAccount fundAccount, String startDate, String startTime, String endDate, String endTime) {
        List<BankAccountTransDetail> list = null;
        if (fundAccount != null) {
            if (FundAccType.INNER_ACC.getType().equals(fundAccount.getAccountType())) {
                if (!TrueOrFalseStatus.TRUE.value().equals(fundAccount.getShareFlag())) {
                    list = obtainInnerBankAccountTransDetail(fundAccount.getBankAccountNo(), startDate, endDate);
                } else {
                    // 共享资金账户由包含其他系统入金记录，可能很多 故必须按照日期 时间 +来款账号逐个同步
                    syncShareInnerBankAccountTransDetail(fundAccount.getBankAccountNo(), startDate, startTime, endDate, endTime);
                }
            } else if (FundAccType.GENERAL_ACC.getType().equals(fundAccount.getAccountType())) {
                list = obtainBankAccountTransDetail(fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), startDate, endDate);
            } else {
                log.error("资金账户{}[{}] 账户类型[{}]暂不支持", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), fundAccount.getAccountType());
                return;
            }

            try {
                log.info("资金账户{}[{}] 同步资金明细记录数[{}] ", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), list == null ? 0 : list.size());
                if (!CollectionUtils.isEmpty(list)) {
                    bankAccountTransDetailHandler.syncBankAccountTransDetail(fundAccount.getBankAccountNo(), list);
                }
                saveOrUpdateIndustrySyncLog(0, fundAccount.getBankAccountNo(), endDate, endTime);
            } catch (Exception e) {
                throw new SyncIndustryAccountException("持久化资金账户明细异常：" + e.getMessage(), e, HttpRespStatus.SERVER_ERROR.value());
            }
        }
    }


    /**
     * 获取 内部户资金账户 交易资金明细
     *
     * @return
     */
    private List<BankAccountTransDetail> obtainInnerBankAccountTransDetail(String fundAccountNo, String startDate, String endDate) {
        List<BankAccountTransDetail> detailList;
        Assert.hasText(fundAccountNo, "资金账户不能为空");
        try {
            OneBankInnerAccountTransDetailQueryReqDTO dto = new OneBankInnerAccountTransDetailQueryReqDTO();
            //账户类型
            dto.setAcctType("3");
            dto.setAcctNo(fundAccountNo);
            dto.setCustAccountNo(fundAccountNo);
            //首次标识
            dto.setFirstInquiryFlg("1");
            //默认每页100
            dto.setPerReturnRows("100");
            dto.setStartingDate(startDate);
            dto.setTerminationDate(endDate);
            dto.setDrcrFlag(HTDrcrFlag.CREDIT.getFlag());
            //起始行号
            dto.setStartingRow("0");
            dto.setReqDate(DateUtil.getCurrentDate());
            dto.setReqTime(DateUtil.getCurrentTime());
            dto.setClientTradeId(serverIdGenerate.generateServerTransId());

            List<OneBankInnerAccountTransDetailQueryRespDTO> reList = innerAccountTransDetailQuery(dto, Lists.newArrayList(), true, null);

            Date curDate = new Date();
            detailList = Optional.ofNullable(reList).map(list -> list.stream()
                    .filter(o -> HTDrcrFlag.CREDIT.getFlag().equals(o.getDrcrFlag()) && HTReverseFlag.NORMAL.getFlag().equals(o.getReverseFlag()))
                    .map(o -> {
                        BankAccountTransDetail detail = new BankAccountTransDetail();
                        detail.setId(IdGenerate.getId());
                        detail.setOperStatus("0");
                        detail.setCustAccountNo(o.getCustAccountNo());
                        detail.setCustAccountName(o.getAccountName());
                        detail.setOtherCustAccountNo(o.getOtherAccount());
                        detail.setOtherCustName(o.getOtherCustName());
                        detail.setOtherBankName(o.getOtherBankName());
                        detail.setOtherRemark(o.getOtherRemark());
                        detail.setRemarkDetail(o.getRemarkDetail());
                        detail.setTxnDate(o.getTxnDate());
                        detail.setTxnTime(o.getTxnTime());
                        detail.setTxnAmount(MathUtil.multiply(BigDecimal.valueOf(o.getTxnAmount()), BigDecimal.valueOf(100d)).longValue());
                        detail.setAccountBalance(MathUtil.multiply(BigDecimal.valueOf(o.getAccountBalance()), BigDecimal.valueOf(100d)).longValue());
                        detail.setReversedFlag(o.getReverseFlag());
                        detail.setDrcrFlag(o.getDrcrFlag());
                        detail.setSysReferenceNo(o.getSysReferenceno());
                        detail.setOrgSysReferenceNo(o.getOrgSysReferenceno());
                        detail.setSummaryDescription(o.getSummaryDescription());
                        detail.setGmtCreate(curDate);
                        detail.setGmtModified(curDate);
                        detail.setDetailSerialNumber(o.getDetailSerialNumber());
                        detail.setBizReferenceNo(o.getBizReferenceno());
                        return detail;
                    }).collect(Collectors.toList())
            ).orElse(null);
        } catch (Exception e) {
            throw new SyncIndustryAccountException("同步资金账户明细处理异常：" + e.getMessage(), e, HttpRespStatus.SERVER_ERROR.value());
        }
        return detailList;
    }

    void syncShareInnerBankAccountTransDetail(String fundAccountNo, String startDate, String startTime, String endDate, String endTime) {
        List<String> payerAccList = MybatisDaoImpl.of(IndustryMapper.class).selectListBySql("selectPayerAccListByFundAccount", new HashMap<String, String>() {{
            put("fundAccount", fundAccountNo);
        }});
        if (!CollectionUtils.isEmpty(payerAccList)) {
            payerAccList.stream().forEach(payerAccNo -> {
                CompletableFuture.runAsync(() -> {
                    obtainShareInnerBankAccountTransDetail(fundAccountNo, payerAccNo, startDate, startTime, endDate, endTime);
                }, executorService);
            });
        }
    }

    private void obtainShareInnerBankAccountTransDetail(String fundAccountNo, String payerAccNo, String startDate, String startTime, String endDate, String endTime) {
        List<BankAccountTransDetail> detailList;
        Assert.hasText(fundAccountNo, "资金账户不能为空");
        try {
            OneBankInnerAccountTransDetailQueryReqDTO dto = new OneBankInnerAccountTransDetailQueryReqDTO();
            //账户类型
            dto.setAcctType("3");
            dto.setAcctNo(fundAccountNo);
            dto.setCustAccountNo(fundAccountNo);
            //首次标识
            dto.setFirstInquiryFlg("1");
            //默认每页50
            dto.setPerReturnRows("100");
            dto.setStartingDate(startDate);
            dto.setStartingTime(startTime);
            dto.setTerminationDate(endDate);
            dto.setTerminationTime(endTime);
            dto.setRivalAcct(payerAccNo);
            dto.setDrcrFlag(HTDrcrFlag.CREDIT.getFlag());
            //起始行号
            dto.setStartingRow("0");
            dto.setReqDate(DateUtil.getCurrentDate());
            dto.setReqTime(DateUtil.getCurrentTime());
            dto.setClientTradeId(serverIdGenerate.generateServerTransId());

            List<OneBankInnerAccountTransDetailQueryRespDTO> reList = innerAccountTransDetailQuery(dto, Lists.newArrayList(), true, null);

            Date curDate = new Date();
            detailList = Optional.ofNullable(reList).map(list -> list.stream()
                    .filter(o -> HTDrcrFlag.CREDIT.getFlag().equals(o.getDrcrFlag()))
                    .filter(o -> HTReverseFlag.NORMAL.getFlag().equals(o.getReverseFlag()))
                    .map(o -> {
                        BankAccountTransDetail detail = new BankAccountTransDetail();
                        detail.setId(IdGenerate.getId());
                        detail.setOperStatus("0");
                        detail.setCustAccountNo(o.getCustAccountNo());
                        detail.setCustAccountName(o.getAccountName());
                        detail.setOtherCustAccountNo(o.getOtherAccount());
                        detail.setOtherCustName(o.getOtherCustName());
                        detail.setOtherBankName(o.getOtherBankName());
                        detail.setOtherRemark(o.getOtherRemark());
                        detail.setRemarkDetail(o.getRemarkDetail());
                        detail.setTxnDate(o.getTxnDate());
                        detail.setTxnTime(o.getTxnTime());
                        detail.setTxnAmount(MathUtil.multiply(BigDecimal.valueOf(o.getTxnAmount()), BigDecimal.valueOf(100d)).longValue());
                        detail.setAccountBalance(MathUtil.multiply(BigDecimal.valueOf(o.getAccountBalance()), BigDecimal.valueOf(100d)).longValue());
                        detail.setReversedFlag(o.getReverseFlag());
                        detail.setDrcrFlag(o.getDrcrFlag());
                        detail.setSysReferenceNo(o.getSysReferenceno());
                        detail.setOrgSysReferenceNo(o.getOrgSysReferenceno());
                        detail.setSummaryDescription(o.getSummaryDescription());
                        detail.setGmtCreate(curDate);
                        detail.setGmtModified(curDate);
                        detail.setDetailSerialNumber(o.getDetailSerialNumber());
                        detail.setBizReferenceNo(o.getBizReferenceno());
                        return detail;
                    }).collect(Collectors.toList())
            ).orElse(null);

            try {
                log.info("资金账户{} 来款账户{} {}{}-{}{} 同步资金明细记录数[{}] ", fundAccountNo, payerAccNo, startDate, startTime, endDate, endTime, detailList == null ? 0 : detailList.size());
                if (!CollectionUtils.isEmpty(detailList)) {
                    bankAccountTransDetailHandler.syncBankAccountTransDetail(fundAccountNo, detailList);
                }
            } catch (Exception e) {
                log.error("持久化同步共享资金账户{} 来款账户{} {}{}-{}{} 处理异常：{} ", fundAccountNo, payerAccNo, startDate, startTime, endDate, endTime, e.getMessage(), e);
            }
        } catch (Exception e) {
            log.error("同步共享资金账户{} 来款账户{} {}{}-{}{} 处理异常：{} ", fundAccountNo, payerAccNo, startDate, startTime, endDate, endTime, e.getMessage(), e);
        }
    }

    /**
     * 获取 一般户：资金账户交易资金入账明细
     *
     * @return
     */
    private List<BankAccountTransDetail> obtainBankAccountTransDetail(String fundAccountNo, String fundAccountName, String startDate, String endDate) {
        List<BankAccountTransDetail> detailList;
        Assert.hasText(fundAccountNo, "资金账户不能为空");
        try {
            OneBankAccountTransDetailQueryReqDTO dto = new OneBankAccountTransDetailQueryReqDTO();
            //账户类型
            dto.setAcctType("3");
            dto.setAcctNo(fundAccountNo);
            dto.setCustAccountNo(fundAccountNo);
            //首次标识
            dto.setFirstInquiryFlg("1");
            //默认每页50
            dto.setPerReturnRows("100");
            dto.setStartingDate(startDate);
            dto.setEndDate(endDate);
            dto.setDrcrFlag(HTDrcrFlag.CREDIT.getFlag());
            //起始行号
            dto.setStartingRow("0");
            dto.setReqDate(DateUtil.getCurrentDate());
            dto.setReqTime(DateUtil.getCurrentTime());
            dto.setClientTradeId(serverIdGenerate.generateServerTransId());

            List<OneBankAccountTransDetailQueryRespDTO> reList = accountTransDetailQuery(dto, Lists.newArrayList());

            Date curDate = new Date();
            detailList = Optional.ofNullable(reList).map(list -> list.stream()
                    .filter(o -> HTDrcrFlag.CREDIT.getFlag().equals(o.getDrcrFlag()))
                    .filter(o -> HTReverseFlag.NORMAL.getFlag().equals(o.getReversedFlag()))
                    .map(o -> {
                        BankAccountTransDetail detail = new BankAccountTransDetail();
                        detail.setId(IdGenerate.getId());
                        detail.setOperStatus("0");
                        detail.setCustAccountNo(o.getCustAccountNo());
                        detail.setCustAccountName(fundAccountName);
                        detail.setOtherCustAccountNo(o.getOtherCustAccountNo());
                        detail.setOtherCustName(o.getOtherCustName());
                        detail.setOtherBankName(o.getOtherBankName());
                        detail.setOtherRemark(o.getRemark());
                        detail.setRemarkDetail(o.getRemarkDetail());
                        detail.setTxnDate(o.getTxnDate());
                        detail.setTxnTime(null);
                        detail.setTxnAmount(MathUtil.multiply(BigDecimal.valueOf(o.getTxnAmount()), BigDecimal.valueOf(100d)).longValue());
                        detail.setAccountBalance(MathUtil.multiply(BigDecimal.valueOf(o.getAccountBalance()), BigDecimal.valueOf(100d)).longValue());
                        detail.setReversedFlag(o.getReversedFlag());
                        detail.setDrcrFlag(o.getDrcrFlag());
                        detail.setSysReferenceNo(o.getSysReferenceno());
                        detail.setOrgSysReferenceNo(o.getOrgSysReferenceno());
                        detail.setSummaryDescription(o.getSummaryDescription());
                        detail.setGmtCreate(curDate);
                        detail.setGmtModified(curDate);
                        detail.setCardNumber(o.getCardNumber());
                        detail.setDetailSerialNumber(o.getDetailSerialNumber());
                        detail.setNatureDate(o.getNatureDate());
                        detail.setBizReferenceNo(o.getBizReferenceno());
                        return detail;
                    }).collect(Collectors.toList())
            ).orElse(null);
        } catch (Exception e) {
            throw new SyncIndustryAccountException("同步资金账户明细处理异常：" + e.getMessage(), e, HttpRespStatus.SERVER_ERROR.value());
        }
        return detailList;
    }

    /**
     * 递归查询合并
     * 注意：不同平台下客户号可以设置相同；即平台账户需要再根据响应结果中过滤非本平台的来款账户
     *
     * @param dto
     * @param dataList
     * @return
     */
    private List<OneBankInnerAccountTransDetailQueryRespDTO> innerAccountTransDetailQuery(OneBankInnerAccountTransDetailQueryReqDTO dto, List<OneBankInnerAccountTransDetailQueryRespDTO> dataList, boolean isFirstPage, Long totalRecords) {
        //首次查询
        ChannelResponseDTO responseDTO = iPaymentService.innerAccountTransDetailQuery(dto);
        //查询成功
        if (responseDTO != null && HttpRespStatus.OK.valueStr().equals(responseDTO.getStatus())) {
            JSONObject reJson = new JSONObject(responseDTO.getSpRespMsg());
            //仅首页查询返回才返回有效总记录数
            if (isFirstPage) {
                totalRecords = reJson.getLongValue("totalRecords");
            }
            //是否有后续数据 0-无 1-有 FIXME 核心查询有bug：第2页总是返回0,hasMore无效，核心建议通过总行数来控制
//            boolean hasMore = "1".equals(reJson.getString("hasMore")) ? true : false;

            String data = reJson.getString("data");
            if (StringUtil.isNotEmpty(data)) {
                dataList.addAll(JSON.parseArray(data, OneBankInnerAccountTransDetailQueryRespDTO.class));
                long nextStartRow = Long.valueOf(dto.getStartingRow()) + Long.valueOf(dto.getPerReturnRows());
                boolean hasNextPage = nextStartRow < totalRecords;
                if (hasNextPage) {
                    dto.setStartingRow(String.valueOf(nextStartRow));
                    dto.setReqDate(DateUtil.getCurrentDate());
                    dto.setReqTime(DateUtil.getCurrentTime());
                    dto.setClientTradeId(serverIdGenerate.generateServerTransId());
                    dto.setFirstInquiryFlg("0");
                    innerAccountTransDetailQuery(dto, dataList, false, totalRecords);
                }
            }
        } else {
            throw new SyncIndustryAccountException(String.format("渠道响应异常%s", responseDTO.getMessage()), HttpRespStatus.BAD_GATEWAY.value());
        }
        return dataList;
    }

    /**
     * 递归查询合并
     * 注意：不同平台下客户号可以设置相同；即平台账户需要再根据响应结果中过滤非本平台的来款账户
     *
     * @param dto
     * @param dataList
     * @return
     */
    private List<OneBankAccountTransDetailQueryRespDTO> accountTransDetailQuery(OneBankAccountTransDetailQueryReqDTO dto, List<OneBankAccountTransDetailQueryRespDTO> dataList) {
        //首次查询
        ChannelResponseDTO responseDTO = iPaymentService.accountTransDetailQuery(dto);
        //查询成功
        if (responseDTO != null && HttpRespStatus.OK.valueStr().equals(responseDTO.getStatus())) {
            JSONObject reJson = new JSONObject(responseDTO.getSpRespMsg());
            //查询返回总记录数
            long totalRecords = reJson.getLongValue("totalRecords");
            //是否有后续数据 0-无 1-有
            boolean hasMore = "1".equals(reJson.getString("hasMore")) ? true : false;
            String data = reJson.getString("data");
            if (StringUtil.isNotEmpty(data)) {
                dataList.addAll(JSON.parseArray(data, OneBankAccountTransDetailQueryRespDTO.class));
                if (hasMore) {
                    long nextStartRow = Long.valueOf(dto.getStartingRow()) + Long.valueOf(dto.getPerReturnRows());
                    dto.setStartingRow(String.valueOf(nextStartRow));
                    dto.setReqDate(DateUtil.getCurrentDate());
                    dto.setReqTime(DateUtil.getCurrentTime());
                    dto.setClientTradeId(serverIdGenerate.generateServerTransId());
                    dto.setFirstInquiryFlg("0");
                    accountTransDetailQuery(dto, dataList);
                }
            }
        } else {
            throw new SyncIndustryAccountException(String.format("渠道响应异常:%s", responseDTO.getMessage()), HttpRespStatus.BAD_GATEWAY.value());
        }
        return dataList;
    }


    /**
     * 排除掉 pic图片字段
     *
     * @return
     */
    private Column[] selectIndustryColumn() {
        List<Column> columnList = SqlHelper.table(Industry.class).getFieldList().stream().map(i -> Column.create().column(i.getColumn()))
                .filter(col -> !col.getColumn().toLowerCase().endsWith("_pic"))
                .collect(Collectors.toList());
        columnList.add(Column.create().column("ID"));
        return columnList.toArray(new Column[0]);
    }

    public List<Industry> getNeedAccountSyncIndustryList() {
        Wrapper<Industry> wrapper = IndustryCondition.builder().orIndustryTypeEq(VirtualAccountType.INDUSTRY.getType())
                .orIndustryTypeEq(VirtualAccountType.COLLECTION.getType()).build().setSqlSelect(selectIndustryColumn());
        return MybatisDaoImpl.run().selectList(wrapper);
    }

    public List<Industry> getNeedSpecialAccountSyncIndustryList() {
        return MybatisDaoImpl.of(IndustryMapper.class).selectListBySql("getNeedSpecialAccountSyncIndustryList");
    }


    public List<IndustrySyncLog> getIndustrySyncLog() {
        return MybatisDaoImpl.run().selectList(IndustrySyncLogCondition.builder().andIndustryCodeIsNotNull().build());
    }

    public List<IndustrySyncLog> getFundAccountSyncLog() {
        return MybatisDaoImpl.run().selectList(IndustrySyncLogCondition.builder().andFundAccountNoIsNotNull().build());
    }

    /**
     * @param type 0:资金账号 1：代付客户号
     * @param code 资金账号/代付客户号
     */
    @Transactional(rollbackFor = Exception.class)
    void saveOrUpdateIndustrySyncLog(int type, String code, String endDate, String endTime) {
        IndustrySyncLog.IndustrySyncLogBuilder builder = IndustrySyncLog.builder();
        int count;
        Date date = new Date();
        if (type == 0) {
            count = MybatisDaoImpl.run().selectCount(IndustrySyncLogCondition.builder().andFundAccountNoEq(code).build());
            if (count > 0) {
                builder.fundAccountNo(code).gmtModified(date).lastDate(endDate).lastTime(endTime);
                MybatisDaoImpl.run().update(builder.build(), IndustrySyncLogCondition.builder().andFundAccountNoEq(code).build());
            } else {
                builder.fundAccountNo(code).gmtCreate(date).gmtModified(date).lastDate(endDate).lastTime(endTime);
                MybatisDaoImpl.run().insert(builder.build());
            }
        } else if (type == 1) {
            count = MybatisDaoImpl.run().selectCount(IndustrySyncLogCondition.builder().andIndustryCodeEq(code).build());
            if (count > 0) {
                builder.industryCode(code).gmtModified(date).lastDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
                MybatisDaoImpl.run().update(builder.build(), IndustrySyncLogCondition.builder().andIndustryCodeEq(code).build());
            } else {
                builder.industryCode(code).gmtCreate(date).gmtModified(date).lastDate(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
                MybatisDaoImpl.run().insert(builder.build());
            }
        }
    }


    public List<FundAccount> queryFundAccountList() {
        return fundAccountHandler.queryFundAccountList();
    }

    public List<FundAccount> querySpecialFundAccountList() {
        return fundAccountHandler.querySpecialFundAccountList();
    }

    public FundAccount getByFundAccountNo(String fundAccountNo) {
        return fundAccountHandler.getByFundAccountNo(fundAccountNo);
    }


    /**
     * 根据订单通知&银行明细 处理 功能上账
     */
    public void syncBankAccDetail2LocalFunctionAccount() {
        try {
            channelIncomeFlowHandler.syncBankAccDetail2LocalFunctionAccount();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 根据订单通知&银行明细 处理 平台下子账户上账
     */
    public void syncBankAccDetail2LocalSubAccount(String industryCode) {
        try {
            channelIncomeFlowHandler.syncBankAccDetail2LocalSubAccount(industryCode);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 根据银行明细 处理 平台上账
     */
    public ServerResponseDTO syncBankAccDetail2LocalIndustry(String industryCode) {
        Assert.hasText(industryCode, "参数industryCode不能为空");
        ServerResponseDTO responseDTO = null;
        try {
            responseDTO = bankAccountTransDetailHandler.syncBankAccDetail2LocalIndustry(industryCode);
            if (responseDTO != null && HttpRespStatus.OK.valueStr().equals(responseDTO.getStatus())) {
                saveOrUpdateIndustrySyncLog(1, industryCode, null, null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return responseDTO;
    }
}
