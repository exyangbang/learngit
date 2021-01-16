package cn.kingnet.product.precard.service.impl;

import cn.kingnet.product.precard.configuration.ProductPreCardProperties;
import cn.kingnet.product.precard.service.AbstractPreCardTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IAccountHandler;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.AccountDetail;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryIndustryAccountDetailReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryIndustryAccountDetailRespDTO;
import cn.kingnet.utp.trade.common.enums.AccountOperType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import feign.RetryableException;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description : 平台账户资金明细查询
 * @Author : linkaigui
 * @Create : 2019/2/28 17:10
 */
@TradeService(
        productCode = ProductCode.PRECARD,
        tradeType = TradeType.QUERY_INDUSTRY_ACCOUNT_DETAIL,
        reqClass = QueryIndustryAccountDetailReqDTO.class,
        respClass = QueryIndustryAccountDetailRespDTO.class
)
public class QueryIndustryAccountDetailService extends AbstractPreCardTradeService<QueryIndustryAccountDetailReqDTO, QueryIndustryAccountDetailRespDTO> {

    @Resource
    private IAccountHandler iAccountHandler;

    public QueryIndustryAccountDetailService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductPreCardProperties productPreCardProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productPreCardProperties);
    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryIndustryAccountDetailReqDTO, QueryIndustryAccountDetailRespDTO> tradeContext) {

        BasicConfigInfo basicConfigInfo = getBasicConfigInfo(tradeContext);
        QueryIndustryAccountDetailReqDTO reqDTO = tradeContext.getRequestDTO();
        QueryIndustryAccountDetailRespDTO.QueryIndustryAccountDetailRespDTOBuilder builder = QueryIndustryAccountDetailRespDTO.builder();
        builder.industryCode(basicConfigInfo.getIndustryCode());
        try {
            List<AccountDetail> accountDetailList = iAccountHandler.queryAccountDetail(basicConfigInfo.getIndustryAccount(), reqDTO.getOperateType(), reqDTO.getStartDate(), reqDTO.getEndDate(),reqDTO.getPeerAccNo());
            List<Map<String, Object>> items =
                    Optional.ofNullable(accountDetailList).map(l -> l.stream().map(o -> this.buildItem(o)).collect(Collectors.toList()))
                            .orElse(Lists.newArrayList());
            builder.items(JSON.toJSONString(items));
        } catch (RetryableException re) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "服务器明细查询接口异常!");
        }
        return ChannelResponseUtil.success(builder.build(), null, null);

    }


    @Override
    protected void verifyReqParam(TradeContext<QueryIndustryAccountDetailReqDTO, QueryIndustryAccountDetailRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryIndustryAccountDetailReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getStartDate(), false, "开始日期");
        ValidateUtils.isYyyyMMdd(reqDTO.getEndDate(), false, "终止日期");

        if (StringUtil.isNotEmpty(reqDTO.getStartDate()) && StringUtil.isNotEmpty(reqDTO.getEndDate())) {
            long days = DateUtil.betweenDays(reqDTO.getStartDate(), reqDTO.getEndDate(), DateTimeFormatter.BASIC_ISO_DATE);
            if (days < 0) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "开始日期不能大于终止日期");
            }
        }

        ValidateUtils.maxLength(reqDTO.getPeerAccNo(), 30, false, "对方账号");
        ValidateUtils.isNum(reqDTO.getPeerAccNo(), false, "对方账号");

        if (StringUtil.isNotEmpty(reqDTO.getOperateType())) {
            AccountOperType operType = AccountOperType.getEnum(reqDTO.getOperateType());
            if (operType == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "操作类型有误");
            }
        }

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, null);

    }

    /**
     * @param accountDetail
     * @return
     */
    private Map<String, Object> buildItem(AccountDetail accountDetail) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(accountDetail);
        jsonObject.remove("id");
        jsonObject.put("recordTime", DateUtil.formateDate(accountDetail.getRecordTime(), DateUtil.FORMAT_DATETIME));
        return jsonObject;
    }

    @Override
    public void initTransFlow(TradeContext<QueryIndustryAccountDetailReqDTO, QueryIndustryAccountDetailRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryIndustryAccountDetailReqDTO, QueryIndustryAccountDetailRespDTO> tradeContext) {

    }
}
