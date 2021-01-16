package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.service.persistence.api.IChannelRelevantHandler;
import cn.kingnet.utp.service.persistence.entity.bo.ChannelInfoBO;
import cn.kingnet.utp.service.persistence.mapper.ChannelIndustryMapper;
import cn.kingnet.utp.service.persistence.service.ChannelAmountLimitService;
import cn.kingnet.utp.trade.common.enums.AccountType;
import cn.kingnet.utp.trade.common.enums.ChannelKey;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.utils.MathUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description : 渠道信息及路由获取服务
 * @Author : linkaigui
 * @Create : 2019/2/25 17:49
 */
@RestController
@RequestMapping("/spi/persistence/channelRelevant")
@Slf4j
public class ChannelRelevantHandler extends DefaultFeginExceptionHandler implements IChannelRelevantHandler {

    @Autowired
    private ChannelAmountLimitService channelAmountLimitService;

    /**
     * 仅获取渠道信息|不校验其剩余额度及其他规则，用于不发完渠道侧的相关内部交易
     *
     * @param industryCode
     * @param productNo
     * @return
     */
    @PostMapping("/findChannelInfoBO")
    @Override
    public ChannelInfoBO findChannelInfoBO(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "productNo", required = false) String productNo, @RequestParam(value = "channelKey", required = false) String channelKey) {
        List<ChannelInfoBO> list = findChannelInfoBOList(industryCode, productNo);
        if (CollectionUtils.isEmpty(list)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户号未配置渠道");
        }
        Optional<ChannelInfoBO> optionalChannelInfoBO = list.stream()
                .filter(bo -> StringUtil.isNotBlank(channelKey) ? channelKey.equals(bo.getChannelKey()) : true)
                .sorted(Comparator.comparing(ChannelInfoBO::getRoofPlacement)).findFirst();
        return optionalChannelInfoBO.orElseThrow(() -> new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号%s未配置指定渠道%s", industryCode, channelKey)));
    }


    private List<ChannelInfoBO> findChannelInfoBOList(@RequestParam(value = "industryCode", required = false) String industryCode, @RequestParam(value = "productNo", required = false) String productNo) {
        if (StringUtil.isEmpty(industryCode)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "客户号 不能为空");
        }
        if (StringUtil.isEmpty(productNo)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "产品编号 不能为空");
        }
        Map<String, Object> parameterMap = new HashMap<>(4);
        parameterMap.put("industryCode", industryCode);
        parameterMap.put("productNo", productNo);
        List<ChannelInfoBO> list = MybatisDaoImpl.of(ChannelIndustryMapper.class).selectListBySql("findChannelInfoBO", parameterMap);
        if (CollectionUtils.isEmpty(list)) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("客户号%s 未配置相关产品渠道", industryCode));
        }
        return list.stream().sorted(Comparator.comparing(ChannelInfoBO::getRoofPlacement)).collect(Collectors.toList());
    }

    @PostMapping("/selectChannelInfoBo")
    @Override
    public ChannelInfoBO selectChannelInfoBo(String industryCode, String productNo, String payeeAccType, long payAmt, String tradeDateTime) {
        List<ChannelInfoBO> channelInfoBOList = findChannelInfoBOList(industryCode, productNo);
        if (CollectionUtils.isEmpty(channelInfoBOList)) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, "未配置渠道!");
        }
        AccountType payeeAccTypeObj = AccountType.getAccountTypeByCode(payeeAccType);
        if (payeeAccTypeObj == null) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("收款方账户类型[%s]有误", payeeAccType));
        }
        if (payAmt <= 0) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("交易金额[%s]必须大于0", payAmt));
        }
        if (StringUtil.isEmpty(tradeDateTime) || tradeDateTime.length() != 14) {
            throw new TradeException(HttpRespStatus.BAD_REQUEST, String.format("交易时间[%s]必须为yyyyMMddHHmmss格式", tradeDateTime));
        }
        String transDate = tradeDateTime.substring(0, 8);
        ChannelInfoBO realChannelInfoBO = null;
        //对公账户只能选择非银联渠道
        if (AccountType.PUBLIC.getCode().equals(payeeAccType)) {
            List<ChannelInfoBO> publicChannelInfoBOList = channelInfoBOList.stream().filter(o -> isIncludeSIBByAmount(o.getChannelKey(), payAmt))
                    .filter(o -> !isCUCChannelKey(o.getChannelKey())).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(publicChannelInfoBOList)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "对公账户,未匹到合适的非银联代付渠道");
            }
            realChannelInfoBO = getRealChannelInfoBO(payAmt, transDate, publicChannelInfoBOList, new StringBuilder("对公账户,"));
            //对公账户 如有配置特殊收费配置，平台手续费优先使用对公手续费配置
            if(realChannelInfoBO != null && realChannelInfoBO.getPublicFeeTemplateId() != null && realChannelInfoBO.getPublicFeeTemplateId() != 0){
                realChannelInfoBO.setIndFeeTemplateId(realChannelInfoBO.getPublicFeeTemplateId());
            }
        }
        //对私账户全渠道都支持即按配置优先级选取
        else if (AccountType.PRIVATE.getCode().equals(payeeAccType)) {
            List<ChannelInfoBO> privateChannelInfoBOList = channelInfoBOList.stream().filter(o -> isIncludeSIBByAmount(o.getChannelKey(), payAmt)).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(privateChannelInfoBOList)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "对私账户,未匹到合适的渠道");
            }
            realChannelInfoBO = getRealChannelInfoBO(payAmt, transDate, privateChannelInfoBOList, new StringBuilder("对私账户,"));
            //对私账户 如有配置特殊收费配置，平台手续费优先使用对私手续费配置
            if(realChannelInfoBO != null && realChannelInfoBO.getPrivateFeeTemplateId() != null && realChannelInfoBO.getPrivateFeeTemplateId() != 0){
                realChannelInfoBO.setIndFeeTemplateId(realChannelInfoBO.getPrivateFeeTemplateId());
            }
        }
        //单位结算卡账户仅支持走银联渠道 + 超网
        else if (AccountType.BILLING_CARD.getCode().equals(payeeAccType)) {
            List<ChannelInfoBO> billingCardChannelInfoBOList = channelInfoBOList.stream().filter(o -> isIncludeSIBByAmount(o.getChannelKey(), payAmt))
                    .filter(o -> ChannelKey.HT_SIB.getKey().equals(o.getChannelKey()) || isCUCChannelKey(o.getChannelKey())).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(billingCardChannelInfoBOList)) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "单位结算卡,未匹到合适的银联/超网渠道");
            }
            realChannelInfoBO = getRealChannelInfoBO(payAmt, transDate, billingCardChannelInfoBOList, new StringBuilder("单位结算卡,"));
        }
        return realChannelInfoBO;
    }

    /**
     *  可用渠道的额度校验
     */
    private ChannelInfoBO getRealChannelInfoBO(long payAmt, String transDate, List<ChannelInfoBO> usableChannelInfoBOList, StringBuilder sb) {
        ChannelInfoBO realChannelInfoBO = null;
        for (ChannelInfoBO bo : usableChannelInfoBOList) {
            long availableAmount = channelAmountLimitService.getChannelDailyAvailableAmount(bo.getChannelCode(), transDate, bo.getChannelLimitAmount());
            if (payAmt > availableAmount) {
                sb.append(String.format("剩余可用[%s]渠道额度[%s元]不足. ", bo.getChannelName(), MathUtil.formatAmt(availableAmount)));
            } else {
                realChannelInfoBO = bo;
                break;
            }
        }
        if (realChannelInfoBO == null) {
            throw new PersistenceException(HttpRespStatus.NOT_FOUND, sb.toString());
        }
        return realChannelInfoBO;
    }

    private boolean isCUCChannelKey(String channelKey) {
        if (ChannelKey.HT_CUC.getKey().equals(channelKey) || ChannelKey.HT_POST_CUC.getKey().equals(channelKey)) {
            return true;
        }
        return false;
    }

    /**
     * 超网通道仅支持小于5w元的交易
     *
     * @param channelKey 渠道key
     * @param payAmt     >=50000.00不得走超网通道
     * @return
     */
    private boolean isIncludeSIBByAmount(String channelKey, long payAmt) {
        boolean isInclude = true;
        if (ChannelKey.HT_SIB.getKey().equals(channelKey) && payAmt >= 5000000) {
            isInclude = false;
        }
        return isInclude;
    }


}
