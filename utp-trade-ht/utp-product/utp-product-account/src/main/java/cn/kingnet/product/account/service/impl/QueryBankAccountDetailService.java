package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.channel.api.onebank.IPaymentService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBankAccountTransDetailHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.api.IIndustryHandler;
import cn.kingnet.utp.service.persistence.entity.BankAccountTransDetail;
import cn.kingnet.utp.service.persistence.entity.FundAccount;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryBankAccountDetailReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryBankAccountDetailRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountTransDetailQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankAccountTransDetailQueryRespDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountTransDetailQueryReqDTO;
import cn.kingnet.utp.trade.common.dto.onebank.OneBankInnerAccountTransDetailQueryRespDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.ChannelException;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.*;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : WJH
 * @Description : 查询同步银行资金流水明细
 * @Create : 2018-10-09
 */
@Deprecated
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_BANK_ACCOUNT_DETAIL,
        reqClass = QueryBankAccountDetailReqDTO.class,
        respClass = QueryBankAccountDetailRespDTO.class
)
@Slf4j
public class QueryBankAccountDetailService extends AbstractAccountTradeService<QueryBankAccountDetailReqDTO, QueryBankAccountDetailRespDTO> {

    @Resource
    private IBankAccountTransDetailHandler iBankAccountTransDetailHandler;
    @Resource
    private IIndustryHandler iIndustryHandler;
    @Resource
    private IPaymentService iPaymentService;

    public QueryBankAccountDetailService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryBankAccountDetailReqDTO, QueryBankAccountDetailRespDTO> tradeContext) {
        QueryBankAccountDetailReqDTO reqDTO = tradeContext.getRequestDTO();
        QueryBankAccountDetailRespDTO.QueryBankAccountDetailRespDTOBuilder builder = QueryBankAccountDetailRespDTO.builder();
        builder.startDate(reqDTO.getStartDate()).endDate(reqDTO.getEndDate()).industryCode(tradeContext.getAuthInfo().getAuthNo());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);
        try {
            List<BankAccountTransDetail> list;
            if ("0".equals(reqDTO.getFilteFlag())) {
                list = iBankAccountTransDetailHandler.queryByFundAccount(basicConfigInfo.getFundAccount(), reqDTO.getStartDate(), reqDTO.getEndDate());
            } else {
                FundAccount fundAccount = iIndustryHandler.getFundAccountByIndustryCode(tradeContext.getAuthInfo().getAuthNo());
                list = queryRealtimeBankAccountTransDetail(fundAccount, reqDTO.getStartDate(), reqDTO.getEndDate());
            }
            builder.detailJson(JSON.toJSONString(list));
        } catch (Exception e) {
            ChannelResponseUtil.exception(builder.build(), null, null, new ChannelException(HttpRespStatus.SERVER_ERROR, e.getMessage()));
        }
        return ChannelResponseUtil.success(builder.build(), null, null);
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryBankAccountDetailReqDTO, QueryBankAccountDetailRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryBankAccountDetailReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getStartDate(), false, "开始日期");
        ValidateUtils.isYyyyMMdd(reqDTO.getEndDate(), false, "终止日期");

        if (StringUtil.isNotEmpty(reqDTO.getStartDate()) && StringUtil.isNotEmpty(reqDTO.getEndDate())) {
            long days = DateUtil.betweenDays(reqDTO.getStartDate(), reqDTO.getEndDate(), DateTimeFormatter.BASIC_ISO_DATE);
            if (days < 0) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "开始日期不能大于终止日期");
            }
        }
        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

    }

    @Override
    public void initTransFlow(TradeContext<QueryBankAccountDetailReqDTO, QueryBankAccountDetailRespDTO> tradeContext) {
    }

    @Override
    public void updateTransFlow(TradeContext<QueryBankAccountDetailReqDTO, QueryBankAccountDetailRespDTO> tradeContext) {
    }

    /**
     * 实时查询资金账户下资金明细记录
     *
     * @param fundAccount
     * @param startDate
     * @param endDate
     */
    public List<BankAccountTransDetail> queryRealtimeBankAccountTransDetail(FundAccount fundAccount, String startDate, String endDate) {

        List<BankAccountTransDetail> list = null;
        if (fundAccount != null) {
            if (FundAccType.INNER_ACC.getType().equals(fundAccount.getAccountType())) {
                list = obtainInnerBankAccountTransDetail(fundAccount.getBankAccountNo(), startDate, endDate);
            } else if (FundAccType.GENERAL_ACC.getType().equals(fundAccount.getAccountType())) {
                list = obtainBankAccountTransDetail(fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), startDate, endDate);
            } else {
                log.error("资金账户{}[{}] 账户类型[{}]暂不支持", fundAccount.getBankAccountNo(), fundAccount.getBankAccountName(), fundAccount.getAccountType());
            }
        }
        return list;
    }

    /**
     * 获取 一般户的资金账户 交易资金明细
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
            //默认每页50
            dto.setPerReturnRows("100");
            dto.setStartingDate(startDate);
            dto.setTerminationDate(endDate);
            dto.setDrcrFlag(HTDrcrFlag.CREDIT.getFlag());
            //起始行号
            dto.setStartingRow("0");
            dto.setReqDate(DateUtil.getCurrentDate());
            dto.setReqTime(DateUtil.getCurrentTime());
            dto.setClientTradeId(generateServerTransId());

            List<OneBankInnerAccountTransDetailQueryRespDTO> reList = innerAccountTransDetailQuery(dto, Lists.newArrayList());

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
                        return detail;
                    }).collect(Collectors.toList())
            ).orElse(null);

        } catch (Exception e) {
            log.error("同步资金账户(内部户){}-日期{}至{}明细处理异常：{}", fundAccountNo, startDate, endDate, e.getMessage(), e);
            throw new ProductException(HttpRespStatus.BAD_GATEWAY, String.format("渠道响应异常:%s", e.getMessage()), e);
        }
        return detailList;
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
            dto.setClientTradeId(generateServerTransId());

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
                        return detail;
                    }).collect(Collectors.toList())
            ).orElse(null);
        } catch (Exception e) {
            log.error("同步资金账户(一般户){}-日期{}至{}明细处理异常:{}", fundAccountNo, startDate, endDate, e.getMessage(), e);
            throw new ProductException(HttpRespStatus.BAD_GATEWAY, String.format("渠道响应异常:%s", e.getMessage()), e);
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
    private List<OneBankInnerAccountTransDetailQueryRespDTO> innerAccountTransDetailQuery(OneBankInnerAccountTransDetailQueryReqDTO dto, List<OneBankInnerAccountTransDetailQueryRespDTO> dataList) {
        //首次查询
        ChannelResponseDTO responseDTO = iPaymentService.innerAccountTransDetailQuery(dto);
        //查询成功
        if (responseDTO != null && HttpRespStatus.OK.valueStr().equals(responseDTO.getStatus())) {
            JSONObject reJson = new JSONObject(responseDTO.getSpRespMsg());
            //查询返回总记录数
            long totalRecords = reJson.getLongValue("totalRecords");
            //是否有后续数据 0-无 1-有
            boolean hasMore = "1".equals(reJson.getString("hasMore")) ? true : false;
            String data = reJson.getString("data");
            if (StringUtil.isNotEmpty(data)) {
                dataList.addAll(JSON.parseArray(data, OneBankInnerAccountTransDetailQueryRespDTO.class));
                if (hasMore && totalRecords > 0) {
                    long nextStartRow = Long.valueOf(dto.getStartingRow()) + Long.valueOf(dto.getPerReturnRows());
                    dto.setStartingRow(String.valueOf(nextStartRow));
                    dto.setReqDate(DateUtil.getCurrentDate());
                    dto.setReqTime(DateUtil.getCurrentTime());
                    dto.setClientTradeId(generateServerTransId());
                    innerAccountTransDetailQuery(dto, dataList);
                }
            }
        } else {
            throw new ProductException(HttpRespStatus.BAD_GATEWAY.value(), String.format("渠道响应异常:%s", responseDTO.getMessage()));
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
                if (hasMore && totalRecords > 0) {
                    long nextStartRow = Long.valueOf(dto.getStartingRow()) + Long.valueOf(dto.getPerReturnRows());
                    dto.setStartingRow(String.valueOf(nextStartRow));
                    dto.setReqDate(DateUtil.getCurrentDate());
                    dto.setReqTime(DateUtil.getCurrentTime());
                    dto.setClientTradeId(generateServerTransId());
                    accountTransDetailQuery(dto, dataList);
                }
            }
        } else {
            throw new ProductException(HttpRespStatus.BAD_GATEWAY.value(), String.format("渠道响应异常:%s", responseDTO.getMessage()));
        }
        return dataList;
    }


}
