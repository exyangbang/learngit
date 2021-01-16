package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.*;
import cn.kingnet.utp.service.persistence.mapper.ChannelIncomeFlowMapper;
import cn.kingnet.utp.service.persistence.vo.ChannelIncomeFlow4AccountVo;
import cn.kingnet.utp.trade.common.dto.ServerResponseDTO;
import cn.kingnet.utp.trade.common.enums.*;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2019/03/17
 */
@Service
@Slf4j
public class BankAccountTransDetailService {

    @Resource
    private MsgNoticeService msgNoticeService;
    @Resource
    private IndustryService industryService;
    @Resource
    private FundAccountService fundAccountService;
    @Resource
    private InnerAccountService innerAccountService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static String genRedisCoreNoHashKey(String fundAccount, String coreNo) {
        return RedisKey.fmtKey(RedisKey.CORE_NO, fundAccount, String.valueOf(Math.abs(coreNo.hashCode()) % 1000));
    }

    public void setRedisCoreNoHashField(String fundAccount, String coreNo, String otherRid) {
        if (StringUtil.isBlank(fundAccount)) {
            return;
        }
        if (StringUtil.isNotBlank(coreNo)) {
            redisTemplate.boundHashOps(genRedisCoreNoHashKey(fundAccount, coreNo)).putIfAbsent(coreNo, otherRid);
        }
    }

    public void delRedisCoreNoHashField(String fundAccount, String coreNo) {
        if (StringUtil.isBlank(fundAccount)) {
            return;
        }
        if (StringUtil.isNotBlank(coreNo)) {
            redisTemplate.boundHashOps(genRedisCoreNoHashKey(fundAccount, coreNo)).delete(coreNo);
        }
    }

    private boolean existsRedisCoreNoHashField(String fundAccount, String coreNo) {
        return redisTemplate.boundHashOps(genRedisCoreNoHashKey(fundAccount, coreNo)).hasKey(coreNo);
    }

    public boolean existsFundAccountAndCoreNo(String fundAccount, String coreNo) {
        boolean exists = existsRedisCoreNoHashField(fundAccount, coreNo);
        if (!exists) {
            //FIXME 是否有必要校验下db
            exists = MybatisDaoImpl.run().selectCount(BankAccountTransDetailCondition.builder().andCustAccountNoEq(fundAccount).andSysReferenceNoEq(coreNo).build()) > 0;
        }
        return exists;
    }

    public BankAccountTransDetail queryByOrderId(String userAccount, String orderId) {
        return MybatisDaoImpl.run().selectOne(BankAccountTransDetailCondition.builder()
                .andSourceFlagEq("1").andAccountEq(userAccount).andOtherRidEq(orderId).build());
    }

    public BankAccountTransDetail queryByCoreNo(String userAccount, String coreNo) {
        return MybatisDaoImpl.run().selectOne(BankAccountTransDetailCondition.builder()
                .andSourceFlagEq("1").andAccountEq(userAccount).andSysReferenceNoEq(coreNo).build());
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateOrderStatusByOrderId(String userAccount, String orderId, String orderStatus) {
        MybatisDaoImpl.run().update(
                BankAccountTransDetail.builder().orderStatus(orderStatus).gmtModified(new Date()).build(),
                BankAccountTransDetailCondition.builder().andSourceFlagEq("1").andAccountEq(userAccount).andOtherRidEq(orderId).build());

    }

    public List<BankAccountTransDetail> queryByFundAccount(String fundAccount, String startDate, String endDate) {
        BankAccountTransDetailCondition condition = BankAccountTransDetailCondition.builder();
        condition.andCustAccountNoEq(fundAccount);
        if (!StringUtils.isEmpty(startDate) && StringUtils.isEmpty(endDate)) {
            condition.andTxnDateBetween(startDate, LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        } else if (StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate)) {
            condition.andTxnDateBetween("20181201", endDate);
        } else if (!StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate)) {
            condition.andTxnDateBetween(startDate, endDate);
        }
        return MybatisDaoImpl.run().selectList(condition.build());

    }

    /**
     * 二级账户入金通知 回调
     *
     * @param thizBankList
     */
    @Async
    public void noticeIndustry4SecondaryAcc(Industry industry, List<BankAccountTransDetail> thizBankList) {

        if (!CollectionUtils.isEmpty(thizBankList)) {
            thizBankList.forEach(o -> {
                Map<String, Object> map = new HashMap<>(16);
                map.put("account", o.getAccount());
                map.put("operateType", AccountOperType.PLUS_BLANCE.getCode());
                map.put("operateSubType", AccountOperSubType.ORDER_INCOME.getCode());
                map.put("amount", o.getTxnAmount());
                map.put("recordTime", DateUtil.formateDate(o.getGmtModified(), "yyyy-MM-dd HH:mm:ss"));
                map.put("seqNo", o.getDetailSerialNumber());
                map.put("remark", o.getSummaryDescription());
                map.put("peerAccNo", o.getOtherCustAccountNo());
                map.put("peerAccName", o.getOtherCustName());
                map.put("peerBankNo", o.getOtherBankNo());
                map.put("peerBankName", o.getOtherBankName());
                map.put("serverTransId", o.getSysReferenceNo());
                //业务规定确认：该字段为客户端直接或间接上送华通的业务流水号
                map.put("orderId", o.getOtherRid());

                Map<String, Object> content = new HashMap(8);
                content.put("noticeType", NoticeType.SECONDARY_ACC_INCOME.getType());
                content.put("industryCode", industry.getCode());
                content.put("items", map);

                msgNoticeService.saveNoticeCallbackMessage(industry.getInnerNoticeUrl(), o.getIndustryCode(), o.getSysReferenceNo(), content);
            });
        }
    }

    /**
     * 平台账户入金通知回调
     *
     * @param thizBankList
     */
    @Async
    public void noticeIndustry4IndustryAcc(Industry industry, List<BankAccountTransDetail> thizBankList) {
        if (!CollectionUtils.isEmpty(thizBankList)) {

            thizBankList.forEach(o -> {
                Map<String, Object> map = new HashMap<>(16);
                map.put("operateType", AccountOperType.PLUS_BLANCE.getCode());
                map.put("operateSubType", AccountOperSubType.INCOME.getCode());
                map.put("amount", o.getTxnAmount());
                map.put("recordTime", DateUtil.formateDate(o.getGmtModified(), "yyyy-MM-dd HH:mm:ss"));
                map.put("seqNo", o.getDetailSerialNumber());
                map.put("remark", o.getSummaryDescription());
                map.put("peerAccNo", o.getOtherCustAccountNo());
                map.put("peerAccName", o.getOtherCustName());
                map.put("peerBankNo", o.getOtherBankNo());
                map.put("peerBankName", o.getOtherBankName());
                map.put("serverTransId", o.getSysReferenceNo());

                Map<String, Object> content = new HashMap(8);
                content.put("noticeType", NoticeType.INDUSTRY_ACC_INCOME.getType());
                content.put("industryCode", industry.getCode());
                content.put("items", map);

                msgNoticeService.saveNoticeCallbackMessage(industry.getInnerNoticeUrl(), o.getIndustryCode(), o.getSysReferenceNo(), content);
            });

        }
    }


    /**
     * 过滤掉内部账户已同步记录
     * 客户账号|内部账户 + 明细序号 唯一定位一笔交易
     *
     * @param list
     * @return
     */
    public List<BankAccountTransDetail> filteExistBankAccountTransDetail(String fundAccountNo, List<BankAccountTransDetail> list) {
        List<BankAccountTransDetail> noExistList = list.stream().filter(l -> fundAccountNo.equals(l.getCustAccountNo()) && !existsFundAccountAndCoreNo(l.getCustAccountNo(), l.getSysReferenceNo())).collect(Collectors.toList());
        //该记录是否为未处理过的订单入金通知
        List<ChannelIncomeFlow> dbflowList = MybatisDaoImpl.run().selectList(ChannelIncomeFlowCondition.builder().andHandleFlagEq(TrueOrFalseStatus.FALSE.value()).build());
        if (!CollectionUtils.isEmpty(noExistList) && !CollectionUtils.isEmpty(dbflowList)) {
            Map<String, ChannelIncomeFlow> noHandledFlowMap = dbflowList.stream().filter(o -> StringUtil.isNotBlank(o.getCoreNo())).collect(Collectors.toMap(ChannelIncomeFlow::getCoreNo, Function.identity()));
            noExistList = noExistList.stream().map(l -> markBankAccountTransDetailOfChannelIncomeFlow(l, noHandledFlowMap)).collect(Collectors.toList());
        }
        return noExistList;
    }

    /**
     * 同步记录是否为 功能账户|二级子账户的入金通知记录
     *
     * @param bankAccountTransDetai
     * @param noHandledFlowMap
     * @return
     */
    private BankAccountTransDetail markBankAccountTransDetailOfChannelIncomeFlow(BankAccountTransDetail bankAccountTransDetai, Map<String, ChannelIncomeFlow> noHandledFlowMap) {
        ChannelIncomeFlow channelIncomeFlow = noHandledFlowMap.get(bankAccountTransDetai.getSysReferenceNo());
        if (channelIncomeFlow != null) {
            bankAccountTransDetai.setAccount(channelIncomeFlow.getAccNo());
            bankAccountTransDetai.setSourceFlag("1");
            bankAccountTransDetai.setOrderStatus(AccountOrderStatus.INITTIALIZE.getCode());
        }
        return bankAccountTransDetai;
    }

    /**
     * 查询该客户号下的子账户待入账的订单入金记录
     * 每次至多取1k条处理
     *
     * @param industryCode
     * @return
     */
    public List<ChannelIncomeFlow4AccountVo> selectChannelIncomeFlow4SubAccount(String industryCode) {
        Map<String, String> paramsMap = Maps.newHashMap();
        paramsMap.put("industryCode", industryCode);
        List<ChannelIncomeFlow4AccountVo> channelIncomeFlow4SubAccountVoList = MybatisDaoImpl.of(ChannelIncomeFlowMapper.class).selectListBySql("selectChannelIncomeFlow4SubAccount", paramsMap);
        return channelIncomeFlow4SubAccountVoList;
    }

    /**
     * 查询当前 所有功能账户入金
     * 每次至多取1k条处理
     *
     * @return
     */
    public List<ChannelIncomeFlow4AccountVo> selectChannelIncomeFlow4FunctionAccount() {
        List<ChannelIncomeFlow4AccountVo> channelIncomeFlow4AccountVoList = MybatisDaoImpl.of(ChannelIncomeFlowMapper.class).selectPageBySql("selectChannelIncomeFlow4FunctionAccount", 1, 1000);
        return channelIncomeFlow4AccountVoList;
    }

    @Transactional(rollbackFor = Exception.class)
    public void syncBankAccountTransDetail(String fundAccountNo, List<BankAccountTransDetail> list) {
        //同步华通内部资金明细
        if (!CollectionUtils.isEmpty(list)) {
            List<BankAccountTransDetail> noExistList = this.filteExistBankAccountTransDetail(fundAccountNo, list);
            if (!CollectionUtils.isEmpty(noExistList)) {
                MybatisDaoImpl.run().insertBatch(noExistList, 100);
                noExistList.stream().forEach(o -> {
                    this.setRedisCoreNoHashField(o.getCustAccountNo(), o.getSysReferenceNo(), o.getOtherRid());
                });
                log.info("资金账号:{},共同步账户明细记录数:{},真实同步平台虚账记录数：{}", fundAccountNo, list.size(), noExistList.size());
            }
        }

    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public ServerResponseDTO syncBankAccDetail2LocalIndustry(String industryCode) {
        Assert.hasText(industryCode, "参数industryCode不能为空");

        //未入账操作前可抛异常，不影响可逐笔入账
        String enableThrowExceptionMsg;

        //该代付客户号归属资金账户下的所有非订单入金的未记账的记录
        Industry industry = industryService.selectOne(IndustryCondition.builder().andCodeEq(industryCode).build());
        if (industry == null || StringUtil.isEmpty(industry.getFundAccount())) {
            enableThrowExceptionMsg = String.format("平台上账失败：平台客户[%s]信息不存在或者未关联资金账户", industryCode);
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, enableThrowExceptionMsg);
        }

        FundAccount fundAccount = fundAccountService.getByFundAccountNo(industry.getFundAccount());
        if (fundAccount == null) {
            enableThrowExceptionMsg = String.format("平台上账失败：平台客户[%s]关联资金账户[%s]不存在", industryCode, industry.getFundAccount());
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, enableThrowExceptionMsg);
        }

        List<BankAccountTransDetail> unHandledBankTransOfIndustryList = MybatisDaoImpl.run().selectList(BankAccountTransDetailCondition.builder()
                .andCustAccountNoEq(industry.getFundAccount()).andOperStatusEq("0").andSourceFlagEq("0").build());
        if (CollectionUtils.isEmpty(unHandledBankTransOfIndustryList)) {
            return new ServerResponseDTO(HttpRespStatus.OK.valueStr(), "查无待同步上账银行流水记录");
        }
        LambdaLogger.debug(log, "[{}]平台客户关联的资金账号[{}]存在[{}]笔资金明细待同步上账", industryCode, industry.getFundAccount(), unHandledBankTransOfIndustryList.size());

        List<IndustryAccountInfo> list = MybatisDaoImpl.run().selectList(IndustryAccountInfoCondition.builder().andIndustryCodeEq(industry.getCode()).build());
        List<String> payerAccNoList, whiteAccNameList;
        boolean isFundCollectionType;
        if (!FundUseType.COLLECTION.getType().equals(fundAccount.getUseType())) {
            List<WhiteList> whiteListList = MybatisDaoImpl.run().selectList(WhiteListCondition.builder().andIndustryCodeEq(industry.getCode()).build());
            //代付客户号下配置的来款账户
            payerAccNoList = Optional.ofNullable(list).orElseGet(ArrayList::new).stream().map(IndustryAccountInfo::getAccountNo).collect(Collectors.toList());
            //白名单中配置的来款账户名称
            whiteAccNameList = Optional.ofNullable(whiteListList).orElseGet(ArrayList::new).stream().map(WhiteList::getAccountName).collect(Collectors.toList());
            isFundCollectionType = false;
        } else {
            payerAccNoList = new ArrayList<>(2);
            whiteAccNameList = new ArrayList<>(2);
            isFundCollectionType = true;
        }

        //根据来款账户过滤归属该代付客户号的银行入金明细【关联来款账号匹配或者白名单中来款账户名称批次】并做虚账户打款入金操作
        //20201009 新增
        // 1. “根据来款账户上账”标志是按原有逻辑根据来款账户或者来款白名单匹配上账。
        //2. “无限制的来款上账” 有入金就给平台上账
        Integer industryIncomeType = industry.getIndustryIncomeType();
        boolean isNoLimited = industryIncomeType != null && industryIncomeType.intValue() == 1 ? true : false;

        //若无限制的来款上账 则校验配置规则是否正确
        if (isNoLimited) {
            //后管配置限制：无限制的来款上账时，二级账户是否对外接款选项只能选“否”。
            if (!"0".equals(industry.getWhetherExternal())) {
                enableThrowExceptionMsg = String.format("平台[%s]入金类型为[无限制的来款上账],则二级账户是否对外接款选项只能选[否],当前配置值为[%s]，故该平台客户暂不能上处理，请联系管理员核查", industryCode, industry.getWhetherExternal());
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, enableThrowExceptionMsg);
            }
            //无限制的来款上账时，需要校验一个资金账户下仅一个客户号，否则不能选择无限制的来款上账
            Integer industryNumOfFundAccount = MybatisDaoImpl.run().selectCount(IndustryCondition.builder().andFundAccountEq(industry.getFundAccount()).andIndustryTypeEq(VirtualAccountType.INDUSTRY.getType()).build());
            if (industryNumOfFundAccount.intValue() > 1) {
                enableThrowExceptionMsg = String.format("平台[%s]入金类型为[无限制的来款上账],则该平台所属的资金账户下仅能配置一个客户号,当前平台资金账户已被[%s]个其他平台关联，故该平台客户暂不能上处理，请联系管理员核查", industryCode, industryNumOfFundAccount - 1);
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, enableThrowExceptionMsg);
            }
        }

        AtomicLong succ = new AtomicLong();
        AtomicLong fail = new AtomicLong();
        List<BankAccountTransDetail> thizIndustryBankList = unHandledBankTransOfIndustryList.stream()
                .filter(o -> isNoLimited || isFundCollectionType || payerAccNoList.contains(o.getOtherCustAccountNo()) || whiteAccNameList.contains(o.getOtherCustName()))
                .map(o -> {
                    try {
                        innerAccountService.plusBalance(AccountOperSubType.INCOME, industry.getAccount(), o.getTxnAmount(), o.getOtherCustAccountNo(), o.getRemarkDetail(), o.getSysReferenceNo(), o.getOtherCustName(), o.getBizReferenceNo());
                        LambdaLogger.info(log, "平台账户上账成功：平台客户[{}]关联资金账户[{}]打款入金,该笔订单[coreNo:{},bizNo:{}]", industry.getCode(), industry.getFundAccount(), o.getSysReferenceNo(), o.getBizReferenceNo());
                        o.setOperStatus("1");
                        o.setIndustryCode(industry.getCode());
                        o.setGmtModified(new Date());
                        succ.incrementAndGet();
                    } catch (Exception e) {
                        LambdaLogger.error(log, "平台账户上账失败：平台客户[{}]关联资金账户[{}]打款入金,该笔订单[coreNo:{},bizNo:{}]", industry.getCode(), industry.getFundAccount(), o.getSysReferenceNo(), o.getBizReferenceNo(), e.getMessage(), e);
                        fail.incrementAndGet();
                    }
                    return o;
                }).filter(o -> "1".equals(o.getOperStatus())).collect(Collectors.toList());

        //更新记账状态
        if (!CollectionUtils.isEmpty(thizIndustryBankList)) {
            MybatisDaoImpl.run().updateBatchById(thizIndustryBankList, 100);
            //平台账户入金通知
            this.noticeIndustry4IndustryAcc(industry, thizIndustryBankList);
        }
        return new ServerResponseDTO(HttpRespStatus.OK.valueStr(), String.format("成功数[%s],失败数[%s]", succ.get(), fail.get()));
    }


}
