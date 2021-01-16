package cn.kingnet.product.account.service.impl;

import cn.kingnet.product.account.configuration.ProductAccountProperties;
import cn.kingnet.product.account.service.AbstractAccountTradeService;
import cn.kingnet.utp.product.common.annotation.TradeService;
import cn.kingnet.utp.product.common.config.UtpConfigProperties;
import cn.kingnet.utp.product.common.model.TradeContext;
import cn.kingnet.utp.product.common.service.IAuthConfigInfoService;
import cn.kingnet.utp.service.persistence.api.IBasicConfigHandler;
import cn.kingnet.utp.service.persistence.entity.AccountDetail;
import cn.kingnet.utp.trade.common.dto.ChannelResponseDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryAccountDetailReqDTO;
import cn.kingnet.utp.trade.common.dto.account.QueryAccountDetailRespDTO;
import cn.kingnet.utp.trade.common.enums.AccountOperType;
import cn.kingnet.utp.trade.common.enums.HttpRespStatus;
import cn.kingnet.utp.trade.common.enums.ProductCode;
import cn.kingnet.utp.trade.common.enums.TradeType;
import cn.kingnet.utp.trade.common.exception.ProductException;
import cn.kingnet.utp.trade.common.exception.TradeException;
import cn.kingnet.utp.trade.common.model.BasicConfigInfo;
import cn.kingnet.utp.trade.common.utils.ChannelResponseUtil;
import cn.kingnet.utp.trade.common.utils.DateUtil;
import cn.kingnet.utp.trade.common.utils.StringUtil;
import cn.kingnet.utp.trade.common.validator.ValidateUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import feign.RetryableException;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description 用户账户资金明细查询
 * @Author WJH
 * @Date 2018年11月23日
 */
@TradeService(
        productCode = ProductCode.ACCOUNT,
        tradeType = TradeType.QUERY_ACCOUNT_DETAIL,
        reqClass = QueryAccountDetailReqDTO.class,
        respClass = QueryAccountDetailRespDTO.class
)
public class QueryAccountDetailService extends AbstractAccountTradeService<QueryAccountDetailReqDTO, QueryAccountDetailRespDTO> {

    public QueryAccountDetailService(IAuthConfigInfoService authConfigInfoService, UtpConfigProperties utpConfigProperties, IBasicConfigHandler basicConfigHandler, ProductAccountProperties productAccountProperties) {
        super(authConfigInfoService, utpConfigProperties, basicConfigHandler, productAccountProperties);
    }

    @Override
    protected void verifyReqParam(TradeContext<QueryAccountDetailReqDTO, QueryAccountDetailRespDTO> tradeContext) {
        super.verifyReqParam(tradeContext);
        QueryAccountDetailReqDTO reqDTO = tradeContext.getRequestDTO();
        ValidateUtils.isYyyyMMdd(reqDTO.getStartDate(), false, "开始日期");
        ValidateUtils.isYyyyMMdd(reqDTO.getEndDate(), false, "终止日期");

        if (StringUtil.isNotEmpty(reqDTO.getStartDate()) && StringUtil.isNotEmpty(reqDTO.getEndDate())) {
            long days = DateUtil.betweenDays(reqDTO.getStartDate(), reqDTO.getEndDate(), DateTimeFormatter.BASIC_ISO_DATE);
            if (days < 0) {
                throw new ProductException(HttpRespStatus.BAD_REQUEST, "开始日期不能大于终止日期");
            }
        }

        ValidateUtils.maxLength(reqDTO.getUserAccount(), 19, true, "用户账户");
        ValidateUtils.isNum(reqDTO.getUserAccount(), true, "用户账户");


        if (StringUtil.isNotEmpty(reqDTO.getOperateType())) {
            AccountOperType operType = AccountOperType.getEnum(reqDTO.getOperateType());
            if (operType == null) {
                throw new TradeException(HttpRespStatus.BAD_REQUEST, "操作类型有误");
            }
        }

        //校验查询平台商户基本信息是否存在
        this.setBasicConfigInfo(tradeContext, reqDTO.getUserAccount());
        BasicConfigInfo basicConfigInfo = this.getBasicConfigInfo(tradeContext);

        //校验用户账户归属资金账户与当前资金账户是否一致
        if(!basicConfigInfo.getFundAccount().equals(basicConfigInfo.getUserFundAccount())){
            throw new ProductException(HttpRespStatus.FORBIDDEN, "用户账户归属资金账户与当前资金账户不一致!");
        }

    }

    @Override
    public ChannelResponseDTO reqChannel(TradeContext<QueryAccountDetailReqDTO, QueryAccountDetailRespDTO> tradeContext) {

        QueryAccountDetailReqDTO reqDTO = tradeContext.getRequestDTO();
        QueryAccountDetailRespDTO.QueryAccountDetailRespDTOBuilder respDTOBuilder = QueryAccountDetailRespDTO.builder();
        respDTOBuilder.userAccount(reqDTO.getUserAccount());
        try {
            List<AccountDetail> accountDetailList = this.accountHandler.queryAccountDetail(reqDTO.getUserAccount(), reqDTO.getOperateType(), reqDTO.getStartDate(), reqDTO.getEndDate(), reqDTO.getPeerAccNo());
            List<Map<String, Object>> items =
                    Optional.ofNullable(accountDetailList).map(l -> l.stream().map(o -> this.buildItem(o)).collect(Collectors.toList()))
                            .orElse(Lists.newArrayList());
            respDTOBuilder.items(JSON.toJSONString(items));
        } catch (RetryableException re) {
            throw new TradeException(HttpRespStatus.NOT_FOUND, "服务器明细查询接口异常!", re);
        }
        return ChannelResponseUtil.success(respDTOBuilder.build(), null, null);
    }

    @Override
    public void initTransFlow(TradeContext<QueryAccountDetailReqDTO, QueryAccountDetailRespDTO> tradeContext) {

    }

    @Override
    public void updateTransFlow(TradeContext<QueryAccountDetailReqDTO, QueryAccountDetailRespDTO> tradeContext) {

    }

    /**
     * @param accountDetail
     * @return
     */
    private Map<String, Object> buildItem(AccountDetail accountDetail) {
        Map<String,Object> map = new HashMap<>(16);
        map.put("account",accountDetail.getAccount());
        map.put("operateType",accountDetail.getOperateType());
        map.put("operateSubType",accountDetail.getOperateSubType());
        map.put("amount",accountDetail.getAmount());
        map.put("beforeBalance",accountDetail.getBeforeBalance());
        map.put("afterBalance",accountDetail.getAfterBalance());
        map.put("recordTime",DateUtil.formateDate(accountDetail.getRecordTime(), DateUtil.FORMAT_DATETIME));
        map.put("seqNo",accountDetail.getSeqNo());
        map.put("remark",accountDetail.getRemark());
        map.put("peerAccNo",accountDetail.getPeerAccNo());
        map.put("serverTransId",accountDetail.getServerTransId());
        map.put("orderId",accountDetail.getOutsideOrderId());
        map.put("peerAccName",accountDetail.getPeerAccName());
        return map;
    }

}
