package cn.kingnet.utp.service.persistence.service;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.entity.BankAccountTransDetail;
import cn.kingnet.utp.service.persistence.entity.ChannelIncomeFlow;
import cn.kingnet.utp.service.persistence.vo.ChannelIncomeFlow4AccountVo;
import cn.kingnet.utp.trade.common.enums.AccountOperSubType;
import cn.kingnet.utp.trade.common.enums.AccountOperType;
import cn.kingnet.utp.trade.common.enums.NoticeType;
import cn.kingnet.utp.trade.common.enums.VirtualAccountType;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.LambdaLogger;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WJH
 * @Date 2020/04/23
 */
@Service
@Slf4j
public class ChannelIncomeFlowService {
    @Resource
    private InnerAccountService innerAccountService;
    @Resource
    private BankAccountTransDetailService bankAccountTransDetailService;
    @Resource
    private IndustryService industryService;
    @Resource
    private MsgNoticeService msgNoticeService;

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void syncBankAccDetail2LocalFunctionAccount() {
        List<ChannelIncomeFlow4AccountVo> voList = bankAccountTransDetailService.selectChannelIncomeFlow4FunctionAccount();
        if (!CollectionUtils.isEmpty(voList)) {
            Map<String, Multimap<String, String>> cache = new HashMap<>(voList.size());
            Set<String> processedCoreNoSet = new HashSet<>(voList.size());
            List<ChannelIncomeFlow4AccountVo> handledVoList =
                    voList.stream().map(vo -> {
                        if (processedCoreNoSet.contains(vo.getCoreNo())) {
                            LambdaLogger.error(log, "功能账户上账：功能账户{}订单入金,该笔订单[coreNo:{},rid:{}]已上账,不能重复上账", vo.getAccNo(), vo.getCoreNo(), vo.getRid());
                            return vo;
                        }
                        //客户号关联 功能账户 配置的 来款账户集合
                        Multimap<String, String> funcAccountRemitterMultiMap;
                        if (cache.containsKey(vo.getIndustryCode())) {
                            funcAccountRemitterMultiMap = cache.get(vo.getIndustryCode());
                        } else {
                            funcAccountRemitterMultiMap = industryService.selectFunctionAccountRemitterMap(vo.getIndustryCode());
                        }
                        if (VirtualAccountType.isFunctionAccount(vo.getNature())) {
                            //若银行资金同步的来款账户 有配置在 功能账户的 来款账户中，则上账操作，否则不上上账
                            if (funcAccountRemitterMultiMap.get(vo.getAccNo()).contains(vo.getOtherCustAccountNo())) {
                                try {
                                    innerAccountService.plusBalance(AccountOperSubType.ORDER_INCOME, vo.getAccNo(), vo.getAmt(), vo.getOtherCustAccountNo(), vo.getRemarkDetail(), vo.getCoreNo(), vo.getOtherCustName(), vo.getRid());
                                    LambdaLogger.info(log, "功能账户上账：功能账户{}订单入金,该笔订单[coreNo:{},rid:{}]", vo.getAccNo(), vo.getCoreNo(), vo.getRid());
                                    vo.setOperStatus("1");
                                    vo.setGmtModified(new Date());
                                    //防止 查询结果重复处理
                                    processedCoreNoSet.add(vo.getCoreNo());
                                } catch (Exception e) {
                                    LambdaLogger.info(log, "功能账户上账：功能账户{}订单入金,该笔订单[coreNo:{},rid:{}]", vo.getAccNo(), vo.getCoreNo(), vo.getRid(), e.getMessage(), e);
                                }
                            } else {
                                LambdaLogger.warn(log, "功能账户[{}]未配置该来款账号[{}]，该笔订单[coreNo:{},rid:{}]暂不能上账", vo.getAccNo(), vo.getOtherCustAccountNo(), vo.getCoreNo(), vo.getRid());
                            }
                        } else {
                            LambdaLogger.error(log, "错误：功能账户上账任务中检索到非功能账户[{}]，该笔订单[coreNo:{},rid:{}]暂不能上账", vo.getAccNo(), vo.getCoreNo(), vo.getRid());
                        }
                        return vo;
                    }).filter(vo -> "1".equals(vo.getOperStatus())).collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(handledVoList)) {
                List<ChannelIncomeFlow> channelIncomeFlows = new ArrayList<>(handledVoList.size());
                List<BankAccountTransDetail> bankAccountTransDetails = new ArrayList<>(handledVoList.size());
                handledVoList.forEach(vo -> {
                    channelIncomeFlows.add(ChannelIncomeFlow.builder().id(vo.getId()).gmtModified(vo.getGmtModified()).handleFlag("1").build());
                    bankAccountTransDetails.add(BankAccountTransDetail.builder().id(vo.getBankTransDetailId()).gmtModified(vo.getGmtModified()).operStatus("1")
                            .industryCode(vo.getIndustryCode()).account(vo.getAccNo()).sourceFlag("1").otherBankNo(vo.getClearBankno()).otherRid(vo.getRid()).build());
                });
                //持久化
                MybatisDaoImpl.run().updateBatchById(channelIncomeFlows, 100);
                MybatisDaoImpl.run().updateBatchById(bankAccountTransDetails, 100);
                //信息通知:功能账户
                noticeIndustry4SubAccount(handledVoList);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void syncBankAccDetail2LocalSubAccount(String industryCode) {
        Assert.hasText(industryCode, "参数 industryCode 不能为空");
        List<ChannelIncomeFlow4AccountVo> voList = bankAccountTransDetailService.selectChannelIncomeFlow4SubAccount(industryCode);
        if (!CollectionUtils.isEmpty(voList)) {
            Set<String> processedCoreNoSet = new HashSet<>(voList.size());
            List<ChannelIncomeFlow4AccountVo> handledVoList =
                    voList.stream().map(vo -> {
                        if (processedCoreNoSet.contains(vo.getCoreNo())) {
                            LambdaLogger.error(log, "子账户上账：子账户{}订单入金,该笔订单[coreNo:{},rid:{}]已上账,不能重复上账", vo.getAccNo(), vo.getCoreNo(), vo.getRid());
                            return vo;
                        }
                        if (VirtualAccountType.isSubAccount(vo.getNature())) {
                            try {
                                //子账户上账 不受限制 来款账户及白名单限制
                                innerAccountService.plusBalance(AccountOperSubType.ORDER_INCOME, vo.getAccNo(), vo.getAmt(), vo.getOtherCustAccountNo(), vo.getRemarkDetail(), vo.getCoreNo(), vo.getOtherCustName(), vo.getRid());
                                vo.setOperStatus("1");
                                vo.setGmtModified(new Date());
                                //防止 查询结果重复处理
                                processedCoreNoSet.add(vo.getCoreNo());
                                LambdaLogger.info(log, "子账户上账：子账户{}订单入金,该笔订单[coreNo:{},rid:{}] 上账成功", vo.getAccNo(), vo.getCoreNo(), vo.getRid());
                            } catch (Exception e) {
                                LambdaLogger.error(log, "子账户上账：子账户{}订单入金,该笔订单[coreNo:{},rid:{}] 上账失败:[{}]", vo.getAccNo(), vo.getCoreNo(), vo.getRid(), e.getMessage(), e);
                            }
                        } else {
                            LambdaLogger.error(log, "错误：子账户上账任务中检索到非子账户[{}]，该笔订单[coreNo:{},rid:{}]暂不能上账", vo.getAccNo(), vo.getCoreNo(), vo.getRid());
                        }
                        return vo;
                    }).filter(vo -> "1".equals(vo.getOperStatus())).collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(handledVoList)) {
                List<ChannelIncomeFlow> channelIncomeFlows = new ArrayList<>(handledVoList.size());
                List<BankAccountTransDetail> bankAccountTransDetails = new ArrayList<>(handledVoList.size());
                handledVoList.forEach(vo -> {
                    channelIncomeFlows.add(ChannelIncomeFlow.builder().id(vo.getId()).gmtModified(vo.getGmtModified()).handleFlag("1").build());
                    bankAccountTransDetails.add(BankAccountTransDetail.builder().id(vo.getBankTransDetailId()).gmtModified(vo.getGmtModified()).operStatus("1")
                            .industryCode(vo.getIndustryCode()).account(vo.getAccNo()).sourceFlag("1").otherBankNo(vo.getClearBankno()).otherRid(vo.getRid()).build());
                });
                //持久化
                MybatisDaoImpl.run().updateBatchById(channelIncomeFlows, 100);
                MybatisDaoImpl.run().updateBatchById(bankAccountTransDetails, 100);
                //信息通知:子账户
                noticeIndustry4SubAccount(handledVoList);
            }
        }
    }


    @Async
    public void noticeIndustry4SubAccount(List<ChannelIncomeFlow4AccountVo> handledVoList) {

        if (!CollectionUtils.isEmpty(handledVoList)) {
            handledVoList.forEach(o -> {
                Map<String, Object> map = new HashMap<>(16);
                map.put("account", o.getAccNo());
                map.put("operateType", AccountOperType.PLUS_BLANCE.getCode());
                map.put("operateSubType", AccountOperSubType.ORDER_INCOME.getCode());
                map.put("amount", o.getAmt());
                map.put("recordTime", DateUtil.formateDate(o.getGmtModified(), "yyyy-MM-dd HH:mm:ss"));
                map.put("seqNo", o.getDetailSerialNumber());
                map.put("remark", o.getRemarkDetail());
                map.put("peerAccNo", o.getOtherCustAccountNo());
                map.put("peerAccName", o.getOtherCustName());
                map.put("peerBankNo", o.getClearBankno());
                map.put("peerBankName", o.getBankName());
                map.put("serverTransId", o.getCoreNo());
                //业务规定确认：该字段为客户端直接或间接上送华通的业务流水号
                map.put("orderId", o.getRid());

                Map<String, Object> content = new HashMap(8);
                content.put("noticeType", NoticeType.SECONDARY_ACC_INCOME.getType());
                content.put("industryCode", o.getIndustryCode());
                content.put("items", map);

                msgNoticeService.saveNoticeCallbackMessage(o.getInnerNoticeUrl(), o.getIndustryCode(), o.getCoreNo(), content);
            });
        }
    }
}
