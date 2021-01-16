package cn.kingnet.utp.service.persistence.handler;

import cn.kingnet.framework.starter.mybatis.dao.MybatisDaoImpl;
import cn.kingnet.utp.product.common.dto.manage.RefreshRedisDTO;
import cn.kingnet.utp.service.persistence.api.IRedisCacheHandler;
import cn.kingnet.utp.service.persistence.entity.IndustryAmtLimit;
import cn.kingnet.utp.service.persistence.entity.SubaccountsAmtLimit;
import cn.kingnet.utp.service.persistence.entity.bo.IndustryAmountLimitBO;
import cn.kingnet.utp.service.persistence.entity.bo.SubAccountAmountLimitBO;
import cn.kingnet.utp.service.persistence.service.ChannelAmountLimitService;
import cn.kingnet.utp.service.persistence.service.IndustryAmountLimitService;
import cn.kingnet.utp.service.persistence.service.MsgNoticeService;
import cn.kingnet.utp.service.persistence.service.SubAccountAmountLimitService;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.exception.DefaultFeginExceptionHandler;
import cn.kingnet.utp.trade.common.exception.PersistenceException;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/spi/persistence/refreshRedisCache")
public class RedisCacheHandler extends DefaultFeginExceptionHandler implements IRedisCacheHandler {

    @Autowired
    private ChannelAmountLimitService channelAmountLimitService;
    @Autowired
    private IndustryAmountLimitService industryAmountLimitService;
    @Autowired
    private SubAccountAmountLimitService subAccountAmountLimitService;

    /**操作类型*/
    private final static String INSERT_OPERATE = "1";
    private final static String UPDATE_OPERATE = "2";
    private final static String DELETE_OPERATE = "3";

    /**业务类型：01=渠道总额度 02=客户号总限额及单笔限额 03=客户号下子账户单日|单笔限额*/
    private final static String BIZ_CHANNEL = "01";
    private final static String BIZ_INDUSTRY = "02";
    private final static String BIZ_SUB_ACCOUNT = "03";

    @Resource
    private MsgNoticeService msgNoticeService;

    @Override
    public void refreshRedisCache(@RequestBody(required = false) RefreshRedisDTO refreshRedisDTO) {
        if (refreshRedisDTO == null) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "请求参数 refreshRedisDTO 不能为空");
        }
        if (StringUtil.isBlank(refreshRedisDTO.getTime()) || refreshRedisDTO.getTime().length() != 14) {
            throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "请求参数time格式有误");
        }
        String type = refreshRedisDTO.getType();
        String operateType = refreshRedisDTO.getOperateType();
        String time = refreshRedisDTO.getTime();
        String date = time.substring(0, 8);
        switch (type) {
            case BIZ_CHANNEL: {
                RefreshRedisDTO.ChannelLimitAmountVO vo = refreshRedisDTO.getChannelLimitAmountVO();
                Assert.notNull(vo, () -> "请求参数 ChannelLimitAmountVO 不能为空");
                Assert.hasText(vo.getChannelCode(), () -> "请求参数 渠道编码 不能为空");
                Assert.notNull(vo.getLimitTotalAmount(), () -> "请求参数 渠道单日限额 不能为空");

                if (DELETE_OPERATE.equals(operateType)) {
                    channelAmountLimitService.deleteLimitAmount(vo.getChannelCode(), date);
                } else {
                    channelAmountLimitService.refreshLimitAmount(vo.getChannelCode(), date, vo.getLimitTotalAmount());
                }
            }
            break;
            case BIZ_INDUSTRY: {
                RefreshRedisDTO.IndustryLimitAmountVO vo = refreshRedisDTO.getIndustryLimitAmountVO();
                Assert.notNull(vo, () -> "请求参数 IndustryLimitAmountVO 不能为空");
                Assert.hasText(vo.getIndustryCode(), () -> "请求参数 客户号 不能为空");
                Assert.notNull(vo.getIndustryLimitId(), () -> "请求参数 industryLimitId 不能为空");

                if (DELETE_OPERATE.equals(operateType)) {
                    industryAmountLimitService.deleteLimitAmount(vo.getIndustryCode(), date);
                    subAccountAmountLimitService.deleteLimitAmountByIndustry(vo.getIndustryCode(), date);
                } else {
                    IndustryAmtLimit industryAmtLimit = MybatisDaoImpl.run().selectById(IndustryAmtLimit.class, vo.getIndustryLimitId());
                    if (industryAmtLimit == null || !vo.getIndustryCode().equals(industryAmtLimit.getIndustryCode())) {
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此客户号[%s]限额记录", vo.getIndustryCode()));
                    }

                    IndustryAmountLimitBO industryAmountLimitBO = new IndustryAmountLimitBO();
                    industryAmountLimitBO.setIndustryCode(vo.getIndustryCode());
                    industryAmountLimitBO.setDate(date);

                    industryAmountLimitBO.setDailyLimitTotalAmount(industryAmtLimit.getIndustryDateAmt());
                    industryAmountLimitBO.setPublicLimitEachAmount(industryAmtLimit.getPublicIndividualAmt());
                    industryAmountLimitBO.setPrivateLimitEachAmount(industryAmtLimit.getPrivateIndividualAmt());
                    industryAmountLimitBO.setBillingCardLimitEachAmount(industryAmtLimit.getUnitIndividualAmt());

                    industryAmountLimitBO.setSameCashMaxAmt(industryAmtLimit.getSameCashMaxAmt());
                    industryAmountLimitBO.setMinuteMaxCashTranAmt(industryAmtLimit.getMinuteMaxCashTranAmt());

                    industryAmountLimitBO.setCommPrivateSubAccountDailyLimitTotalAmount(industryAmtLimit.getSubaccountsDateAmt());
                    industryAmountLimitBO.setCommPublicSubAccountDailyLimitTotalAmount(industryAmtLimit.getPublicSubaccountsDateAmt());

                    industryAmountLimitBO.setIndustryBalancePayDailyLimitTotalAmount(industryAmtLimit.getIndustryBalanceDateAmt());
                    industryAmountLimitBO.setPrivateSubAccountBalancePayDailyLimitTotalAmount(industryAmtLimit.getPrivateSubaccountsBalanceDateAmt());
                    industryAmountLimitBO.setPublicSubAccountBalancePayDailyLimitTotalAmount(industryAmtLimit.getPublicSubaccountsBalanceDateAmt());

                    industryAmountLimitService.refreshLimitAmount(industryAmountLimitBO);
                    // 同步刷新 以客户号公共值账户设值为准的记录
                    subAccountAmountLimitService.refreshLimitAmountByIndustry(industryAmountLimitBO);
                }
            }
            break;
            case BIZ_SUB_ACCOUNT: {
                RefreshRedisDTO.SubAccountLimitAmountVO vo = refreshRedisDTO.getSubAccountLimitAmountVO();
                Assert.notNull(vo, () -> "请求参数 SubAccountLimitAmountVO 不能为空");
                Assert.hasText(vo.getIndustryCode(), () -> "请求参数 industryCode 不能为空");
                Assert.hasText(vo.getSubAccount(), () -> "请求参数 subAccount 不能为空");
                Assert.notNull(vo.getSubAccountLimitId(), () -> "请求参数 subAccountLimitId 主键不能为空");
                if (DELETE_OPERATE.equals(operateType)) {
                    subAccountAmountLimitService.deleteLimitAmount(vo.getSubAccount(), date, vo.getIndustryCode());
                } else {
                    SubaccountsAmtLimit subaccountsAmtLimit = MybatisDaoImpl.run().selectById(SubaccountsAmtLimit.class, vo.getSubAccountLimitId());
                    if (subaccountsAmtLimit == null || !vo.getIndustryCode().equals(subaccountsAmtLimit.getIndustryCode()) || !vo.getSubAccount().equals(subaccountsAmtLimit.getSubAccount())) {
                        throw new PersistenceException(HttpRespStatus.BAD_REQUEST, String.format("查无此客户号[%s]下子账户[%s]限额记录", vo.getIndustryCode(), vo.getSubAccount()));
                    }
                    SubAccountAmountLimitBO subAccountAmountLimitBO = new SubAccountAmountLimitBO();
                    subAccountAmountLimitBO.setIndustryCode(vo.getIndustryCode());
                    subAccountAmountLimitBO.setSubAccount(vo.getSubAccount());
                    subAccountAmountLimitBO.setDate(date);
                    subAccountAmountLimitBO.setDailyLimitTotalAmount(subaccountsAmtLimit.getSubaccountsDateAmt());
                    subAccountAmountLimitBO.setLimitEachAmount(subaccountsAmtLimit.getSubaccountsIndividualAmt());
                    subAccountAmountLimitBO.setIndustryCommEffect(false);

                    subAccountAmountLimitService.refreshLimitAmount(subAccountAmountLimitBO);
                }
            }
            break;
            default: {
                throw new PersistenceException(HttpRespStatus.BAD_REQUEST, "请求参数type[".concat(type).concat("]暂不支持"));
            }
        }

    }

    @PostMapping("/saveNoticeCallbackMessage")
    @Override
    public void saveNoticeCallbackMessage(
            @RequestParam(value = "callbackUrl", required = false) String callbackUrl,
            @RequestParam(value = "industryCode", required = false) String industryCode,
            @RequestParam(value = "serverTransId", required = false) String serverTransId,
            @RequestBody(required = false) Map<String, Object> content) {
        Assert.hasText(callbackUrl, () -> "参数[callbackUrl]不能为空");
        Assert.hasText(industryCode, () -> "参数[industryCode]不能为空");
        Assert.notEmpty(content, () -> "参数[content]不能为空");

        msgNoticeService.saveNoticeCallbackMessage(callbackUrl, industryCode, serverTransId, content);

    }

}
